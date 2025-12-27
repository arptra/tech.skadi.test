# MyVU Server (BLE Peripheral)

Телефон поднимает BLE GATT Server и рекламирует сервис StarryNet с UUID 0x0BD1, чтобы очки выступали BLE Central и сами подключались. Поведение повторяет декомпилированный `com.upuphone.starrynet.core.ble.server`: валидность XR‑соединения определяется включением notify на 0x2001/0x2002.

## Как собрать
1. Android Studio Jellyfish или новее.
2. Открыть папку `myvu_server_app` как Gradle‑проект.
3. compileSdk/targetSdk = 35, minSdk = 26. Kotlin 1.9.24, AGP 8.5.2.
4. В репозитории нет `gradle/wrapper/gradle-wrapper.jar` (бинарник удалён). При первой синхронизации Android Studio скачает его сама; если собираете из CLI — один раз выполните `gradle -p myvu_server_app wrapper --gradle-version 8.7`, чтобы восстановить jar и дальше пользоваться `./gradlew`.
5. Синхронизировать Gradle и собрать модуль `app`.

### Сборка и запуск на Google Pixel 9 Pro (Android 16)
1. Включите Developer options и USB debugging.
2. Подключите Pixel 9 Pro по USB и проверьте `adb devices`.
3. В Android Studio выберите устройство как target и запустите Run. TargetSdk 35 работает на Android 16 без доп. настроек.
4. После установки выдайте запрошенные BLE‑разрешения, включите Bluetooth и перейдите в приложение.

## Разрешения и подготовка
- Android 12+: нужны `BLUETOOTH_CONNECT`, `BLUETOOTH_ADVERTISE`, `BLUETOOTH_SCAN` (запрашиваются рантайм).
- Android 10/11: может потребоваться `ACCESS_FINE_LOCATION` для BLE операций системы.
- Включите Bluetooth (кнопка «Open Bluetooth settings» помогает быстро попасть в настройки).
- Foreground service удерживает процесс живым; при агрессивном энергосбережении добавьте приложение в исключения.

## Как запустить сервер
1. Убедитесь, что строка статуса показывает «Permissions OK» и Bluetooth включён.
2. Поле Service UUID по умолчанию — `00000BD1-0000-1000-8000-00805F9B34FB` (StarryNet). Поле «Notify characteristic» задаёт предпочитаемый канал уведомлений (по умолчанию 0x2002).
3. Нажмите **Start GATT** (поднимет GATT Server с профилем StarryNet) и **Start Adv** (реклама сервиса 0x0BD1; опционально включите manufacturer data 0x0BD1).
4. Очки найдут advertising и подключатся как Central. После включения CCCD на 0x2001 или 0x2002 в логах появится `VALID_XR_CONNECTED`.
5. Кнопка **Send Notify** отправляет hex‑payload в выбранный notify‑UUID (если уведомления включены на устройстве). **Export logs** сохранит файл в `Documents` и откроет стандартный share-sheet.

## Проверка через nRF Connect
1. На втором телефоне откройте nRF Connect → Scan → найдите рекламу, где в Service UUID присутствует `0x0BD1` (и при включённой галочке — Manufacturer Data id 0x0BD1).
2. Подключитесь, найдите сервис `00000bd1-0000-1000-8000-00805f9b34fb` и характеристики ниже.
3. Включите Notify на `0x2001` или `0x2002`. В приложении появится лог `VALID_XR_CONNECTED` и статус valid=true в Diagnostics.
4. Отправьте Write без ответа в `0x2000` или `0x2023` — сервер сэмулирует ответ notify (AA55 + len + payload) на 0x2002 (или 0x2001, если только он включён). В логах будет видно входящий WRITE и исходящий notify.

## Таблица UUID / свойств
| Короткий UUID | Полный UUID | Свойства | Права | Назначение |
| --- | --- | --- | --- | --- |
| 0x0BD1 | 00000bd1-0000-1000-8000-00805f9b34fb | PRIMARY SERVICE | – | Сервис StarryNet |
| 0x2000 | 00002000-0000-1000-8000-00805f9b34fb | WRITE, WRITE_NO_RESPONSE | PERMISSION_WRITE | glasses → phone base write |
| 0x2001 | 00002001-0000-1000-8000-00805f9b34fb | NOTIFY (+CCCD) | PERMISSION_READ | XR_NOTIFY (включение notify делает соединение валидным) |
| 0x2002 | 00002002-0000-1000-8000-00805f9b34fb | NOTIFY (+CCCD) | PERMISSION_READ | XR_NOTIFY (валидность соединения) |
| 0x2020 | 00002020-0000-1000-8000-00805f9b34fb | NOTIFY (+CCCD) | PERMISSION_READ | Air internal (TODO уточнить точные флаги) |
| 0x2021 | 00002021-0000-1000-8000-00805f9b34fb | NOTIFY (+CCCD) | PERMISSION_READ | Air external (TODO) |
| 0x2022 | 00002022-0000-1000-8000-00805f9b34fb | NOTIFY (+CCCD) | PERMISSION_READ | Air urgent external (TODO) |
| 0x2023 | 00002023-0000-1000-8000-00805f9b34fb | WRITE, WRITE_NO_RESPONSE | PERMISSION_WRITE | glass write |

## Что считать успехом
- В логах видно `CONNECTED ...`, затем `VALID_XR_CONNECTED after CCC enable ...` после записи CCCD на 0x2001/0x2002.
- При входящем WRITE на 0x2000 или 0x2023 логируется hex‑payload и отправляется notify‑эхо (со статусом в `onNotificationSent`).
- В Diagnostics отображаются подключённые устройства, их MTU и valid=true, когда notify включён на XR‑каналах.

## Ожидаемые логи
```
12:00:00.123 | Advertising STARTED with service 00000bd1-0000-1000-8000-00805f9b34fb includeMfg=true
12:00:05.456 | CONNECTED AA:BB:CC:DD:EE:FF name=XRGlasses bond=10
12:00:05.789 | VALID_XR_CONNECTED after CCC enable on 00002002-0000-1000-8000-00805f9b34fb from AA:BB:CC:DD:EE:FF
12:00:06.010 | WRITE 00002000-0000-1000-8000-00805f9b34fb from AA:BB:CC:DD:EE:FF len=3 offset=0 prepared=false payload=01 02 03
12:00:06.011 | Notify(00002002-0000-1000-8000-00805f9b34fb) -> AA:BB:CC:DD:EE:FF status=0 bytes=AA 55 03 00 01 02 03
```

## Архитектура
- `StarryNetUuids`/`Uuid16` — константы UUID 0x0BD1 и характеристик 0x2000/0x2001/0x2002/0x2020/0x2021/0x2022/0x2023 + список XR_NOTIFY.
- `StarryNetGattProfile` — собирает GATT‑сервис с нужными свойствами и CCCD.
- `BleGattServerController` — управляет GATT Server и Advertising на HandlerThread, трекает CCCD по MAC, определяет valid XR подключение, роутит WRITE в notify‑эхо, логирует каждый callback.
- `DeviceSession` — хранит MTU, время жизни, включённые notify, флаг validConnected.
- `BleServerService` — foreground service, держит контроллер живым, публикует diagnostics (список сессий) в UI.
- `MainActivity` — UI: старт/стоп GATT и Advertising, выбор notify‑UUID, включение manufacturer data, отправка notify, просмотр логов и диагностики, экспорт.
- `PacketLogger` — логирует с TAG `MYVU_SERVER`, буфер последних 200 строк, экспорт в Documents.
- `ProtocolHooks` — утилиты для hex; место для будущей логики протокола/CRC.

## Типичные проблемы
- **Нет advertising permission**: статус «Missing: ...»; выдайте разрешения вручную.
- **Bluetooth выключен**: строка «Bluetooth: OFF (enable in settings)»; включите модуль BT.
- **Нет peripheral поддержки**: лог `No advertiser available` — устройство не умеет BLE Peripheral.
- **Notify не включён**: без CCCD на 0x2001/0x2002 соединение не считается валидным и уведомления не шлются.
