# MyVU Server (BLE Peripheral)

Телефон поднимает GATT Server (Peripheral), рекламирует сервис FEE0 и ждёт, пока очки выступят в роли Central и подключатся сами. Код полностью на стандартных Android API без сторонних BLE SDK.

## Как собрать
1. Android Studio Jellyfish или новее.
2. Открыть папку `myvu_server_app` как проект Gradle.
3. compileSdk/targetSdk = 35, minSdk = 26. Kotlin 1.9.24, AGP 8.5.2.
4. В репозитории нет `gradle/wrapper/gradle-wrapper.jar` (бинарник удалён). При первой синхронизации Android Studio скачает его сама; если собираете из CLI — один раз выполните `gradle -p myvu_server_app wrapper --gradle-version 8.7`, чтобы восстановить jar и дальше пользоваться `./gradlew`.
5. Синхронизировать Gradle, собрать `app`.

### Сборка и запуск на Google Pixel 9 Pro (Android 16)
1. Включите Developer options на устройстве и разрешите USB debugging.
2. Подключите Pixel 9 Pro по USB, убедитесь, что оно отображается как ADB‑устройство (`adb devices`).
3. В Android Studio выберите подключённый Pixel 9 Pro как target device.
4. Соберите и установите `app` (Build > Make Project, затем Run). Gradle соберёт APK с targetSdk 35, совместимый с Android 16.
5. После установки выдайте запрошенные BLE‑разрешения, затем включите advertising и сервер из главного экрана.

## Как установить
- Подпишите debug- или release-APK обычным способом и установите на Pixel 9 Pro (Android 16). Проект не требует правки кода после клонирования.

## Разрешения и подготовка
- Android 12+: выдайте `BLUETOOTH_CONNECT`, `BLUETOOTH_ADVERTISE`, `BLUETOOTH_SCAN` во время первого запуска.
- Android 10/11: система может потребовать `ACCESS_FINE_LOCATION` для BLE операций.
- Включите Bluetooth. На главном экране есть кнопка перехода в настройки, статус отображается в разделе Diagnostics.
- Убедитесь, что режим энергосбережения не душит приложение: переведите сервис в исключения Battery Optimization при необходимости.

## Как запустить сервер
1. Убедитесь, что права выданы (строка "Permissions OK").
2. UUID по умолчанию совпадают со StarryNet: сервис `0000FEE0-0000-1000-8000-00805F9B34FB`, характеристика `0000FEE1-0000-1000-8000-00805F9B34FB`. При желании отредактируйте поля UI и нажмите **Start Server**.
3. Переключите **Advertise ON/OFF** в состояние ON. В логах появится `Advertising STARTED with service ...`.
4. Подключите очки (они сами найдут рекламу FEE0 и инициируют GATT подключение).

## Что считать успехом
- В Logcat/окне логов видны события:
  - `CONNECTED <address> name=<name> bond=<state>`
  - `XR_VALID_CONNECTED: CCC enabled from <address>` после записи дескриптора 0x2902 с `ENABLE_NOTIFICATION_VALUE`.
  - Входящие WRITE: `WRITE from <address> len=<N> ... payload=<HEX>`
- В Diagnostics поле `Notify enabled` должно быть `true`.
- Кнопка **Send Notify** отправляет payload (в hex) в характеристику FEE1 и в логах видно `Notification sent status=0`.

## Архитектура
- `BleGattServerController` — управляет GATT Server, Advertising, хранит `DeviceSession`, логирует каждый callback. Все BLE операции исполняются в HandlerThread, чтобы избежать гонок с UI.
- `BleServerService` — foreground service, держит controller живым, публикует диагностику в UI каждые 2 секунды.
- `PacketLogger` — единый логгер (TAG `MYVU_SERVER`), выводит в Logcat, хранит буфер для UI и экспорта в файл.
- `ProtocolHooks` — заглушка под будущий протокол; сейчас только конвертирует входящие байты в hex-строки для логов.
- `DeviceSession` — хранит адрес, MTU, флаг notifyEnabled, метку последней активности.
- UI (`MainActivity`) — управление сервером/рекламой, поле hex для notify, диагностика, экспорт логов.

## Типичные проблемы
- **Нет advertising permission**: переключатель не включается, строка `Missing: ...` подсказывает недостающие права.
- **Bluetooth выключен**: статус `Bluetooth: OFF` и реклама не стартует; включите в настройках.
- **Аппарат не поддерживает Peripheral**: лог `No advertiser available`; проверьте устройство.
- **Очки не делают CCC write**: без записи дескриптора 0x2902 сервер считает, что notify запрещён и не отправляет уведомления.

## Ожидаемые логи
Пример последовательности в окне логов/Logcat:
```
12:00:00.123 | Advertising STARTED with service 0000f...fee0
12:00:05.456 | CONNECTED AA:BB:CC:DD:EE:FF name=XRGlasses bond=10
12:00:05.789 | XR_VALID_CONNECTED: CCC enabled from AA:BB:CC:DD:EE:FF
12:00:06.010 | WRITE from AA:BB:CC:DD:EE:FF len=3 offset=0 prepared=false payload=01 02 03
12:00:07.000 | Sending notify to AA:BB:CC:DD:EE:FF (2 bytes)
12:00:07.001 | notifyCharacteristicChanged result=0
12:00:07.010 | Notification sent status=0 to AA:BB:CC:DD:EE:FF
```
