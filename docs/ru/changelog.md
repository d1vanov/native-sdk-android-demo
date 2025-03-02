# Release notes

## v0.14.0
**Release Date:** 05.05.2021
- Исправлена ошибка при добавлении маркера - по умолчанию, он направлен вверх экрана независимо от поворота карты.
- *Ломающее изменение*. Изначальный поворот маркера (`MarkerOptions.iconMapDirection`) и поворот существующего маркера (`Marker.iconMapDirection`) теперь optional.

## v0.13.0
**Release Date:** 30.04.2021
- Исправлено промаргивание карты черным цветом при ее создании
- Возможность задать поворот маркера `MarkerOptions.iconMapDirection`, `Marker.iconMapDirection` 
- В копирайте на карте по умолчанию не отображается версия SDK, чтобы включить нужно задать `MapView.showApiVersionInCopyrightView = true`
- Информация о положении камер в навигаторе - `Camera.geoPoint, Camera.bearing`
- Возможность задать `positionPoint` в функциях `calcPosition` и `zoomOutToFit`
- Функции для создания объектов заменены на конструкторы `createMapObjectManager` -> `MapObjectManager`, `Geometry.createPoint` -> `PointGeometry` и т.д.


## v0.12.1
**Release Date:** 23.04.2021
- исправлен учет масштаба карты
- минимальный масштаб (`CameraZoomRestrictions.minZoom`) теперь по умолчанию - 2
- убрано вытеснение маркеров друг другом
- исправление в обработке статистики


## v0.12
**Release Date:** 22.04.2021
- возможность использования SVG изображений для маркеров - `imageFromAsset(context, "some.svg"), imageFromSvg(context, svgData)`
- исправлены падения при оптимизации кода с помощью ProGuard
- исправлен учет видимости полилинии `PolylineOptions.visible, Polyline.isVisible`
- добавили сбор анонимной статистики использования, по умолчанию включено (параметр `dataCollectStatus` в `DGis.initialize`), отключать рекомендуется только в случае явного выбора пользователем(например, отказ GDPR)
- на изображении карты(`MapView.takeSnapshot`) отображается копирайт
- возможность задать собственную траекторию перемещения камеры - `Camera.move(moveController)`
- свойство `padding` перемещено из `Map` в `Camera`
- возможность задать поведение камеры при изменении `padding` - `Camera.setPadding(padding, positionPointChangeBehaviour)`
- при поиске(`SearchManager`) учитывается местоположение пользователя
- свойство `GeometryMapObject.originalGeometry` переименовано в `geometry`
- удалено свойство `GeometryMapObject.shift` вместо него нужно использовать установку `geometry`
- Исправлены типы параметров `registerPlatformLocationSource`, `registerPlatformMagneticSource` - `LocationSource`, `MagneticHeadingSource` вместо `Any`
- ускорено получение результата срабатывания `Future` и `Channel`
- удалены устаревшие методы `Future` и `Channel`


## v0.11
**Release Date:** 14.04.2021
- возможность задать произвольную тему карты - `MapOptions.lightTheme`, `MapOptions.darkTheme`, `Map.setTheme(light, dark)`, `Map.setTheme(name)`
- управление и получение информации о http-кэше - `HttpCacheManager`
- дополнительные конструкторы data-типов - `GeoPoint(lat: Double, lon: Double)`, `Color(r, g, b, a)` и др.
- информация о полосах движения маршрута - `RouteInfo.laneSigns`
- возможность вращать/масштабировать карту относительно ее центра(а не центра жеста) - `RotationSettings.rotateAboutMapPositionPoint`, `ScalingSettings.scalingAboutMapPositionPoint`
- возможность задать скорость движения в симуляции навигации - `SimulationSettings.speed`
- убрана тонкая черная граница у объектов карты, когда она не задана
- исправлено падение при удалении карты на эмуляторах
- исправлено падение при задании `LocationSource`
- *Ломающиее изменение:* `TextStyle.fontSize`, `TextStyle.strokeWidth` имеют тип `LogicalPixel`, а не `Float`
- *Ломающиее изменение:* вместо `navigation.Model.laneSign` теперь `navigation.Model.laneSignIndex`, 
  а `LaneSign` можно получить по этому индексу из `RouteInfo.laneSigns`


## v0.10
**Release Date:** 07.04.2021
- добавили метод [takeSnapshot](/ru/android/native/maps/reference/ru.dgis.sdk.map.MapView#nav-lvl1--takeSnapshot) для получения последнего отрисованного кадра в картинку
- параметр [interactive](/ru/android/native/maps/reference/ru.dgis.sdk.map.Map#nav-lvl1--var%20interactive) для отключения возможности взаимодействия пользователя с картой
- добавили [renderMode](/ru/android/native/maps/reference/ru.dgis.sdk.map.MapOptions#nav-lvl1--var%20renderMode). Теперь можно отрисовывать карту в TextureView
- добавили [полилинию с градиентом](/ru/android/native/maps/reference/ru.dgis.sdk.map.PolylineOptions#nav-lvl1--val%20gradientPolylineOptions)
- *Ломающее изменение:* обновили класс [GeoRect](/ru/android/native/maps/reference/ru.dgis.sdk.coordinates.GeoRect)
- `removeSource` больше не бросает исключение. Даже если источник не был добавлен на карту


## v0.9
**Release Date:** 24.03.2021
- добавили возможность рисовать [пунктирную линию](/ru/android/native/maps/reference/ru.dgis.sdk.map.PolylineOptions#nav-lvl1--val%20dashed)
- [opacity](/ru/android/native/maps/reference/ru.dgis.sdk.map.Marker#nav-lvl1--var%20iconOpacity) для Marker
- функции конверторы для работы со Style Zoom([projectionZToStyleZ](/ru/android/native/maps/reference/ru.dgis.sdk.map.projectionZToStyleZ), [styleZToProjectionZ](/ru/android/native/maps/reference/ru.dgis.sdk.map.styleZToProjectionZ))
- для работы с атрибутами карты добавлен новый тип [AttributeValue](/ru/android/native/maps/reference/ru.dgis.sdk.map.AttributeValue)
- [showApiVersionInCopyrightView](/ru/android/native/maps/reference/ru.dgis.sdk.map.MapView#nav-lvl1--var%20showApiVersionInCopyrightView) для отображения версии SDK в copyright
- исправлено падение при вызове *getMapAsync* из не приатаченного View
- из [DgisMapObject](/ru/android/native/maps/reference/ru.dgis.sdk.map.DgisMapObject) больше нельзя получить Future на объект справочника. Для этого нужно использовать [SearchManager](/ru/android/native/maps/reference/ru.dgis.sdk.directory.SearchManager)


## v0.8
**Release Date:** 17.03.2021
- *Ломающее изменение:* мы изменили формат работы с подписками на изменения свойств. Раньше такие поля как `camera.position` имели тип `StatefulChannel`. Для того чтобы получать уведомления об изменениях данных в `Channel` нужно вызвать `camera.position.connect()`, а получить текущее значение можно через `camera.position.value`. Такой API вызывал вопросы, поэтому в новой версии `camera.position`(и другие свойства `StatefulChannel`) это просто getter/setter. А для подписки на изменение нужно использовать `camera.positionChannel`
- добавили кэш для тайлов на карте. По умолчанию кэш *включен*, и максимальный размер хранилища 300Мб. Его можно отключить или изменить его размер в настройках [HttpOptions](/ru/android/native/maps/reference/ru.dgis.sdk.context.HttpOptions)
- [Padding](/ru/android/native/maps/reference/ru.dgis.sdk.map.Map#nav-lvl1--var%20padding) на карте
- для объектов Polygon/Polyline добавилась возможность изменить текущую геометрию
- добавили источник для растровых тайлов(см. [createRasterTileDataSource](/ru/android/native/maps/reference/ru.dgis.sdk.map.createRasterTileDataSource))
- поддержали атрибут theme для стилей карты выгруженных из редактора
- методы для создания иконки маркера *imageFromAsset/imageFromCanvas/imageFromResource* переместили в пакет `ru.dgis.sdk.map`
- сконвертировали методы в property в случаях когда такая форма более логична(напр. [enabledGestures](/ru/android/native/maps/reference/ru.dgis.sdk.map.GestureManager#nav-lvl1--var%20enabledGestures))


## v0.7
**Release Date:** 04.03.2021
- высокоуровневый API для динамических объектов карты(см. [MapObjectManager](/ru/android/native/maps/reference/ru.dgis.sdk.map.MapObjectManager))
- методы [visibleArea](/ru/android/native/maps/reference/ru.dgis.sdk.map.Camera#nav-lvl1--visibleArea), [visibleRect](/ru/android/native/maps/reference/ru.dgis.sdk.map.Camera#nav-lvl1--visibleRect) для получения видимой области карты
- источник [TrafficSource](/ru/android/native/maps/reference/ru.dgis.sdk.map.TrafficSource) для отображения пробочных тайлов на карте
- [получение геометрии](/ru/android/native/maps/reference/ru.dgis.sdk.map.toMapGeometry) из TrafficRoute
- исправления в сигнатурах функций. Большинство методов теперь возвращает non-nullable значения


## v0.6.0
**Release Date:** 15.02.2021
- разделили SDK на 2 артефакта. **sdk-map** - версия для тех кому нужна только карта и справочник. **sdk-full** - более полная, содержит в себе навигатор. В *build.gradle* необходимо указать нужную версию(напр. `implementation 'ru.dgis.sdk:sdk-map:0.6.0'`)
- карта и контролы теперь доступны и в темной теме
- [добавили уровень логирования](/ru/android/native/maps/reference/ru.dgis.sdk.DGis#nav-lvl1--initialize). По умолчанию SDK пишет только Warning и более критичные сообщения
- методы для вычисления [позиции камеры](/ru/android/native/maps/reference/ru.dgis.sdk.map.calcPosition) и [Zoom Level](/ru/android/native/maps/reference/ru.dgis.sdk.map.zoomOutToFit) по заданной геометрии
- [источник для данных с кластеризацией](/ru/android/native/maps/reference/ru.dgis.sdk.map.GeometryMapObjectSourceBuilder#nav-lvl1--createSourceWithClustering)
- добавили возможность задать [координату с высотой для маркера](/ru/android/native/maps/reference/ru.dgis.sdk.map.MarkerBuilder#nav-lvl1--setPosition)
- для динамических объектов на карте, добавили возможность [определить пользовательские данные](/ru/android/native/maps/reference/ru.dgis.sdk.map.MarkerBuilder#nav-lvl1--setUserData)
- поддержали создание маркера с текстом, без иконки
- *Ломающее изменение:* иконку маркера необходимо указывать через [объект стилей](/ru/android/native/maps/reference/ru.dgis.sdk.map.MarkerBuilder#nav-lvl1--setStyle). Формирование стиля маркера с иконкой может занимать значительное время т.к. для этого может понадобится растеризация/сжатие изображения. Мы настоятельно рекомендуем делать это в фоновом потоке и переиспользовать MarkerStyle для однотипных маркеров.


## v0.5.0
**Release Date:** 04.02.2021
- исправлен баг с ключами API(проявлялось как 403 от сервера тайлов)
- звуковое оповещение о превышении скорости в навигаторе
- получение пробочного балла в [TrafficManager](/ru/android/native/maps/reference/ru.dgis.sdk.traffic.TrafficManager)
- landscape Ui в навигаторе


## v0.4.6
**Release Date:** 26.01.2021
- приглушение других звуков при проигрывании инструкций навигатора
- редизайн Ui навигатора 
- исправление ошибок


## v0.4.5
**Release Date:** 20.01.2021
- вернули *map.camera* 


## v0.4.4
**Release Date:** 19.01.2021
- *ViewportPoint* переименован в *ScreenPoint*, *ViewportSize* -> *ScreenSize*
- фикс слоя для маркеров
- добавлен [GestureManager](/ru/android/native/maps/reference/GestureManager)
- добавили возможность отменять [Future](/ru/android/native/maps/reference/Future#nav-lvl1--cancel)
- изменили работу с **Any** типами (см. [пример](/ru/android/native/maps/reference/SuggestHandler#nav-lvl1--match))


## v0.4.3
**Release Date:** 22.12.2020
- режим слежения за маркером местоположения
- поддержка offline данных в downloads директории
- воспроизведение голосовых инструкций с учетом скорости на маршруте
- [searchById](/ru/android/native/maps/reference/SearchManager#nav-lvl1--searchById) в модуле справочника
- добавили свойство [renderView](/ru/android/native/maps/reference/MapView#nav-lvl1--renderView) у объекта MapView


## v0.4.2
**Release Date:** 15.12.2020
- голосовые инструкции в навигаторе во время ведения по маршруту
- поддержали жест наклона карты


## v0.4.1
**Release Date:** 09.12.2020
- добавлен новый [DgisSource](/ru/android/native/maps/reference/DgisSource). Для работы c объектами 2GIS
- *Ломающее изменение:* DgisSourceCreator был удален. Вместо него стоит использовать статические методы [DgisSource](/ru/android/native/maps/reference/DgisSource)
- в [RouteParams](/ru/android/native/maps/reference/RouteParams) добавлена поддержка промежуточных точек


## v0.4.0
**Release Date:** 03.12.2020
- уменьшили размер библиотеки
- UI контролы карты и навигатора
- баблики с дополнительной информацией по найденному маршруту


## v0.3.3
**Release Date:** 24.11.2020
- [добавили возможность делать подпись к маркерам](/ru/android/native/maps/reference/MarkerBuilder#nav-lvl2--setText)
- [для объектов справочника доступны дополнительные атрибуты](/ru/android/native/maps/reference/DirectoryObject#nav-lvl2--attributes)
- *Ломающее изменение:* необходимо отказаться от методов tryCastTo* в пользу обычного приведения типов
- уменьшили размер зашитых в библиотеку данных


## v0.3.2
**Release Date:** 17.11.2020
- данные, необходимые для инициализации SDK, теперь зашиты в пакет. Больше нет необходимости в предустановленных данных
- отображение поисковой выдачи с генерализацией как в мобильном 2GIS
- работа с FollowManager. Позволяет следить за точкой на карте
- для карты Online Data Source выбирается по умолчанию
- научили наш 3d engine работать с SVG
- в стриме событий навигатора добавилась координата следующего маневра


## v0.3.1
**Release Date:** 09.11.2020
- поддержка drag для объектов карты
- в RouteEditor теперь можно выбирать маршрут по клику в него
- "съедание" маршрута при запуске навигатора
- исправления в расчете ETA


## v0.3.0
**Release Date:** 02.11.2020
- [добавлены методы отображения маркеров на карте](/ru/android/native/maps/examples#nav-lvl1--Добавление_маркера_на_карту)
- [оповещение о маневрах, камерах, улице, времени до конца маршрута и т. д.](/ru/android/native/maps/examples#nav-lvl1--События_по_маршруту_во_время_ведения)
- [получение информации об объектах по клику в карту](/ru/android/native/maps/examples#nav-lvl1--Получение_информации_по_клику_в_карту)


## v0.2.2
**Release Date:** 27.10.2020
- исправлен баг c *ClassLoader* при использовании *sharedUserId*
- в найденном маршруте можно получить расстояние в метрах через `route.length`
- добавлен обработчик для уменьшения потребления памяти
- в `MapView` добавлена работа с `TouchEventsObserver`


## v0.2.1
**Release Date:** 20.10.2020
- [отображение маркера текущего местоположения](/ru/android/native/maps/examples#nav-lvl1--Отображение_маркера_текущего_местоположения)
- добавили использование API key
- починили работу https
- изменен интерфейс NavigationManager


## v0.2.0
**Release Date:** 08.10.2020
- [поддержали добавление кастомного источника геопозиции](/ru/android/native/maps/examples#nav-lvl1--Создание_и_использование_собственного_источника_позиции)
- [работа с объектами из GeoJSON](/ru/android/native/maps/examples#nav-lvl1--%D0%94%D0%BE%D0%B1%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5_%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%D0%BE%D0%B2_%D0%B8%D0%B7_GeoJson)
- [поиск о отображение маршрута на карте](/ru/android/native/maps/examples#nav-lvl1--Построение_маршрута_и_его_отображение_на_карте)


## v0.1.2
**Release Date:** 22.09.2020
- добавление кастомных геометрий

подробнее: https://telegra.ph/NativeSDK-012-09-22


## v0.1.1
**Release Date:** 15.09.2020
- темная тема карты

подробнее: https://telegra.ph/NativeSDK-011-09-15


## v0.1.0
**Release Date:** 08.09.2020
- online карта
- изменения в API для инициализации SDK
- гибридный справочник(online + offline)

подробнее: https://telegra.ph/NativeSDK-010-09-08


## v0.0.1
**Release Date:** 21.08.2020
- online справочник

подробнее: https://telegra.ph/NativeSDK-001-08-20
