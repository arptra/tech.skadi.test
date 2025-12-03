# com.upuphone: обзор пакетов и алгоритм подключения к очкам

## Аудио (`com.upuphone.oggopus`)
- `OggOpus` — Kotlin-обёртка над нативной библиотекой `oggopus`: билдер задаёт режим/частоту/каналы, `init` создаёт нативный прокси, `decode`/`decodeAsync` возвращают PCM/OPUS, `release` освобождает ресурс; слушатель `OnDataListener` получает асинхронные пакеты. 【F:sources/com/upuphone/oggopus/OggOpus.java†L12-L116】

## SDK уведомлений (`com.upuphone.sdk`)
- `NotificationSDK` формирует `ArSmartReminderModel`, доставляя результат через `ICallback` с кодами `ResultType`; `Regular` держит белый список пакетов. 【F:sources/com/upuphone/sdk/NotificationSDK.java†L5-L36】【F:sources/com/upuphone/sdk/ArSmartReminderModel.java†L5-L35】【F:sources/com/upuphone/sdk/Regular.java†L5-L22】

## Общие утилиты и потоки (`com.upuphone.starrycommon`)
- Исполнители: `CacheExecutor` поднимает ленивый `ThreadPoolExecutor`; `ThreadExecutorKit` отдаёт общий пул; `SingleHandlerThread` и `UILoop` упрощают работу с `HandlerThread`; сетевые заглушки `Packet`/`PacketBus` описывают обмен пакетами. 【F:sources/com/upuphone/starrycommon/threads/CacheExecutor.java†L1-L25】【F:sources/com/upuphone/starrycommon/threads/ThreadExecutorKit.java†L1-L8】【F:sources/com/upuphone/starrycommon/threads/SingleHandlerThread.java†L1-L4】【F:sources/com/upuphone/starrycommon/network/Packet.java†L1-L9】【F:sources/com/upuphone/starrycommon/network/PacketBus.java†L1-L3】
- Графика и видео: `EglBase`/`EglBase14`/`EglBase10` создают EGL-контексты; `WindowSurface`/`PbufferSurface` инкапсулируют поверхности; `UupFfmpegUtils`, `MediaUtils`, счётчики FPS/битрейта и утилиты времени облегчают работу с медиа. 【F:sources/com/upuphone/starrycommon/egl/EglBase.java†L1-L80】【F:sources/com/upuphone/starrycommon/eglbehaviour/WindowSurface.java†L1-L36】【F:sources/com/upuphone/starrycommon/utils/UupFfmpegUtils.java†L1-L44】【F:sources/com/upuphone/starrycommon/utils/UupFpsCounter.java†L1-L40】
- Разное: генераторы последовательностей (`SequenceGenerator`), сохранение файлов, утилиты разрешений и IP-адресов, логирование в файл (`Log2File`). 【F:sources/com/upuphone/starrycommon/utils/SequenceGenerator.java†L1-L44】【F:sources/com/upuphone/starrycommon/utils/PermissionUtils.java†L1-L47】【F:sources/com/upuphone/starrycommon/utils/IPAddressUtil.java†L1-L61】【F:sources/com/upuphone/starrycommon/utils/Log2File.java†L1-L47】

## Сбор событий (`com.upuphone.datatrack`)
- `XJDataTrack` инициализирует SDK: регистрирует колбэки жизненного цикла, готовит отчёты, запускает `XJDataDispatch` и отправляет события с метаданными устройства/пакета. 【F:sources/com/upuphone/datatrack/sdk/XJDataTrack.java†L1-L173】
- Отчётчики (`DataTrackReporter`, `InstantReporter`) строят сообщения и отправляют их через `XJHttpManager` сразу после генерации. 【F:sources/com/upuphone/datatrack/sdk/reporter/DataTrackReporter.java†L1-L9】【F:sources/com/upuphone/datatrack/sdk/reporter/InstantReporter.java†L1-L32】

## BLE и Run-As-One (`com.upuphone.runasone`)
- `QosLevel` перечисляет уровни QoS для ProtoBuf-сообщений. 【F:sources/com/upuphone/runasone/QosLevel.java†L1-L63】
- `ble.BleRequest` агрегирует типы запросов (MTU, notify, read/write) с ID, UUID и колбэками для BLE-пайплайна. 【F:sources/com/upuphone/runasone/ble/BleRequest.java†L1-L40】

## Библиотеки Star (сетевые/лог/обновления)
- Логирование (`com.upuphone.star.core.log`): интерфейсы `Printer`, `FormatPrinter`, `FilePrinter` и стратегии бэкапа/очистки файлов реализуют гибкую систему логов. 【F:sources/com/upuphone/star/core/log/Printer.java†L1-L15】【F:sources/com/upuphone/star/core/log/file/FilePrinter.java†L1-L53】【F:sources/com/upuphone/star/core/log/file/backup/FileSizeBackupStrategy.java†L1-L27】
- HTTP (`com.upuphone.star.httplib`): `HttpInstance` оборачивает запросы, `HttpResult` и `ResponseParser` описывают ответ, `SignUtils` и `JsonUtils` помогают с подписью и JSON. 【F:sources/com/upuphone/star/httplib/HttpInstance.java†L1-L126】【F:sources/com/upuphone/star/httplib/HttpResult.java†L1-L45】【F:sources/com/upuphone/star/httplib/SignUtils.java†L1-L44】
- Загрузки (`com.upuphone.star.download.manager`): `DownloadManager` управляет задачами, БД (`DownloadDb`, `DownloadDao`) хранит статусы, исключения сигнализируют об отсутствии сети/Wi‑Fi. 【F:sources/com/upuphone/star/download/manager/DownloadManager.java†L1-L92】【F:sources/com/upuphone/star/download/manager/db/DownloadDb.java†L1-L41】
- Обновления очков (`com.upuphone.star.fota.phone`): `GlassUpdateApiManager` вызывает проверку и загрузку обновлений через HTTP, используя `CheckGlassUpdateParam`/`GlassUpdateResultParam`; `GlassUpdateException` описывает ошибки. 【F:sources/com/upuphone/star/fota/phone/GlassUpdateApiManager.java†L1-L86】【F:sources/com/upuphone/star/fota/phone/CheckGlassUpdateParam.java†L1-L26】【F:sources/com/upuphone/star/fota/phone/GlassUpdateException.java†L1-L20】

## StarryNet: обнаружение и подключение устройств
- `StarryNetData` держит контекст приложения, профиль собственного устройства (`StDevice`), подбирает коннекторы/сканеры для телефонов, XR‑устройств, авто и пр., и даёт вспомогательные методы для идентификаторов/терминалов. 【F:sources/com/upuphone/starrynet/strategy/StarryNetData.java†L13-L189】
- `XRStarryNetDiscoverer` — BLE‑стратегия для XR/очков: включает fast‑connect, запускает пассивную рекламу для переподключения, фильтрует найденные устройства по типу/статусу и управляет тайм‑аутами. 【F:sources/com/upuphone/starrynet/strategy/discovery/XRStarryNetDiscoverer.java†L22-L176】
- `UsbStarryNetDiscoverer` обнаруживает аксессуары ICCOA через USB (AOA), парсит префикс, наполняет `StDiscoveryDevice` VIN/PIN/Vendor‑данными и публикует в `StarryDeviceManager`. 【F:sources/com/upuphone/starrynet/strategy/discovery/UsbStarryNetDiscoverer.java†L15-L74】
- `StarryDeviceManager` хранит найденные (`StDiscoveryDevice`) и подключённые (`StConnectDevice`) устройства, поднимает протоколы, синхронизирует состояния и уведомляет слушателей. 【F:sources/com/upuphone/starrynet/strategy/data/StarryDeviceManager.java†L1-L100】

## Алгоритм подключения к умным очкам (BLE/StarryNet)
1. **Инициализация StarryNet**: в `Application` создать `StDevice` для телефона и передать его в `StarryNetData` (устанавливает тип терминала, BT MAC/Android ID, выбирает нужный коннектор/сканер). 【F:sources/com/upuphone/starrynet/strategy/StarryNetData.java†L13-L189】
2. **Запуск стратегии XR**: создать `XRStarryNetDiscoverer`, который сразу активирует fast‑connect и регистрируется в `StarryDeviceManager` как интерсептор. 【F:sources/com/upuphone/starrynet/strategy/discovery/XRStarryNetDiscoverer.java†L26-L35】
3. **Реклама для переподключения**: если есть связка с очками (BLE bond), `enableFastConnect` включает reconnect‑advertising с MAC очков; без связи `enableFastConnectXr` публикует пассивный ADV и ставит тайм‑аут. 【F:sources/com/upuphone/starrynet/strategy/discovery/XRStarryNetDiscoverer.java†L48-L98】
4. **Сканирование**: вызвать `startDiscovery` с `DiscoveryFilter` для типа устройства (XR/очков). Менеджер отправляет сообщение в `DiscoveryStateMachine`, начиная BLE‑скан. 【F:sources/com/upuphone/starrynet/strategy/discovery/XRStarryNetDiscoverer.java†L155-L172】
5. **Обработка найденных устройств**: `onDiscovery` помечает XR‑устройства статусами (новое/ожидает reconnect/не наше), используя идентификаторы из `StarryDeviceManager`. Нужные устройства передаются наружу через callback. 【F:sources/com/upuphone/starrynet/strategy/discovery/XRStarryNetDiscoverer.java†L124-L153】
6. **Запрос соединения**: по выбранному `StDiscoveryDevice` вызвать `requestConnect(identifier, timeout)` через реализацию `IStarryNetDiscoverer` (доступна из выбранной стратегии), чтобы инициировать BLE‑соединение и дальнейшие протоколы. 【F:sources/com/upuphone/starrynet/strategy/discovery/IStarryNetDiscoverer.java†L15-L26】
7. **Мониторинг статуса**: `StarryDeviceManager` обновляет состояние протоколов, хранит связки и уведомляет о подключении/отключении; при успешной связи можно активировать каналы передачи данных/управления очками. 【F:sources/com/upuphone/starrynet/strategy/data/StarryDeviceManager.java†L31-L62】【F:sources/com/upuphone/starrynet/strategy/data/StarryDeviceManager.java†L86-L100】

8. **USB-фолбэк (если очки поддерживают AOA)**: параллельно можно запустить `UsbStarryNetDiscoverer.startDiscovery()` — при подключении по USB он создаст `StDiscoveryDevice` и передаст его в общую шину устройств, откуда можно вызывать общий `requestConnect`. 【F:sources/com/upuphone/starrynet/strategy/discovery/UsbStarryNetDiscoverer.java†L21-L74】
