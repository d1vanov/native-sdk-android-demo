package ru.dgis.sdk.app.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.util.IOUtils
import java9.util.concurrent.CompletableFuture
import ru.dgis.sdk.DGis
import ru.dgis.sdk.map.Map
import ru.dgis.sdk.map.Style
import ru.dgis.sdk.map.StyleBuilder
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.lang.RuntimeException


class MapStyleViewModel: ViewModel() {
    private val closeables = mutableListOf<AutoCloseable>()
    private var loadingFuture = CompletableFuture<Void>()
    private var stylePath = ""
    private val styleData = MutableLiveData<Style>()
    private var map: Map? = null

    var isStyleSelected: Boolean = false
        private set

    val style: LiveData<Style>
        get() = styleData

    fun loadStyle(styleStream: InputStream) {
        isStyleSelected = true

        loadingFuture = CompletableFuture
            .supplyAsync {
                val destinationFile = File.createTempFile("style-", ".2gis")
                styleStream.use { inStream ->
                    FileOutputStream(destinationFile).use { outStream ->
                        IOUtils.copyStream(inStream, outStream)
                    }
                }
                destinationFile.absolutePath
            }
            .thenCompose { stylePath ->
                this.stylePath = stylePath

                val future = CompletableFuture<Style>()
                val sdkContext = checkNotNull(DGis.context())

                StyleBuilder(sdkContext)
                    .loadStyleFromFile(stylePath)
                    .onComplete({ style ->
                        future.complete(style)
                    }, future::completeExceptionally)

                future
            }
            .thenAccept(styleData::postValue)
    }

    fun onMapReady(map: Map) {
        this.map = map
        closeables.add(map)
    }

    override fun onCleared() {
        super.onCleared()
        loadingFuture.cancel(true)

        closeables.forEach(AutoCloseable::close)
        closeables.clear()

        if (stylePath.isNotEmpty()) {
            CompletableFuture.runAsync {
                File(stylePath).delete()
            }
        }
    }
}
