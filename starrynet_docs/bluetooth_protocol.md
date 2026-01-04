# StarryNet Bluetooth протокол (сводка)

Этот файл описывает, как классы StarryNet координируют обнаружение устройств, установку BLE‑каналов, обмен пакетами и шифрованное спаривание. Используя шаги ниже, можно воспроизвести последовательность подключения.

## 1. Обнаружение и первичный отклик
- `AbsStarryNetDiscoverer` управляет жизненным циклом поиска: регистрирует слушателей событий, поднимает state machine и при включении Bluetooth стартует нужные рекламные пакеты/сканирование. На таймаутах включает быстрый отклик и пассивную рекламу для ожидающих устройств.【F:sources/com/upuphone/starrynet/strategy/discovery/AbsStarryNetDiscoverer.java†L21-L197】
- Рекламные данные строятся менеджерами `AdvertiserManager`/`AdvPackManager`, а ответы на найденные объявления зависят от версии/типа устройства (логика `checkAndResponseDeviceFoundAdv`).【F:sources/com/upuphone/starrynet/strategy/discovery/AbsStarryNetDiscoverer.java†L140-L196】

## 2. Настройка соединения BLE
- Все сервисы/характеристики BLE заданы в `BluetoothConstants` (служба `STARRY_NET_SERVICE_UUID`, каналы для внутренних/внешних сообщений, мульти‑write UUID и т.д.). Эти UUID используются как для клиентских запросов, так и для серверных уведомлений.【F:sources/com/upuphone/starrynet/core/ble/BluetoothConstants.java†L9-L44】
- `BleConnectManager` выступает единым фасадом клиента: создаёт/кэширует `BleConnectMaster` по MAC‑адресу, ограничивает количество активных мастеров, инициирует connect/disconnect, MTU запросы, чтение/запись характеристик и подписки на уведомления/indicate.【F:sources/com/upuphone/starrynet/core/ble/client/BleConnectManager.java†L25-L171】
- После установления GATT‑сессии `ChannelManager` регистрирует два канала (внутренний и внешний) для каждой удалённой MAC, готовя читателей/писателей и очищая состояние при разрыве. MTU/фрагментация пакетов учитывается через константы ATT_HEADER/DEFAULT_MTU_SIZE/DMTU_OFFSET.【F:sources/com/upuphone/starrynet/core/ble/channel/ChannelManager.java†L11-L125】

## 3. Транспортный слой пакетов
- Конкретная отправка/приём идёт через `SendChannel`/`ReceiveChannel`: `SendChannel` буферизует пакеты, отслеживает CTR‑пакеты/таймауты и уведомляет зарегистрированных `IBleChannelReader`. Внутри используется `Packet` и его специализированные варианты (ACK/CTR/Data/FastAck и пр.) для подтверждений и сборки фрагментов.【F:sources/com/upuphone/starrynet/core/ble/channel/SendChannel.java†L19-L95】【F:sources/com/upuphone/starrynet/core/ble/channel/SendChannel.java†L105-L152】
- `ChannelManager` предоставляет `IBleChannelWriter` обёртку, через которую верхний уровень пишет данные (с опкодом или без) — отправка выполняется в `SendChannel.send(...)`, а доставки подтверждаются через `ChannelCallback`/`IChannelPacketReadResult`.

## 4. Шифрование и обмен ключами
- Шифрованные сообщения собираются в `StarryNetEncryptHelper`: для каждого шага генерируется protobuf `LinkProtocol` с командой (`AUTH_MESSAGE`, `BOND_MSG_CHANGE`, `CONNECT_AP`, запросы на отключение клиента и т.д.). Данные шифруются через `EncryptionUtil` и используют идентификатор устройства/ключи из `StarryNetData`/`StConnectDevice` для формирования полезной нагрузки.【F:sources/com/upuphone/starrynet/strategy/encrypt/StarryNetEncryptHelper.java†L25-L197】
- Помощники `StarryNetDecryptHelper`/`StarryNetEncryptHelperV2` (см. индивидуальные файлы в `starrynet_docs/strategy/encrypt`) обеспечивают обратное преобразование и поддержку версий шифрования.

## 5. Спаривание и выбор протокола
- `StarryNetPairManager`/`StarryNetPairProcess` (см. индивидуальные файлы) организуют обмен сообщениями спаривания через `IPairChannel`, используя готовые BLE‑каналы и события (`StarryNetPairEventBus`). Клиентские/серверные реализации (`BleClientPair`, `BleServerPair`, `RingSecurityPair`) определяют последовательность для роли устройства.
- `ProtocolManager` и семейство классов `StarryNetProtocol`/`CarStarryNetProtocol`/`PhoneStarryNetProtocol` согласовывают версии (`ProtocolVersions`/`ProtocolVersionsCache`) и запускают соответствующие каналы (BLE, P2P, AP), переключаясь на нужный тип транспорта после успешного обмена ключами.

## 6. Базовая последовательность подключения
1. **Обнаружение**: устройство публикует рекламу StarryNet, сканер через `AbsStarryNetDiscoverer` выявляет подходящих пиров и инициирует ответный ADV/scan.【F:sources/com/upuphone/starrynet/strategy/discovery/AbsStarryNetDiscoverer.java†L39-L196】
2. **Установка GATT**: `BleConnectManager` создаёт мастер по MAC, выполняет connect и (при необходимости) запрос MTU/подписку на notify для UUID из `BluetoothConstants`.【F:sources/com/upuphone/starrynet/core/ble/client/BleConnectManager.java†L87-L171】【F:sources/com/upuphone/starrynet/core/ble/BluetoothConstants.java†L9-L44】
3. **Инициализация каналов**: `ChannelManager` регистрирует внутренний/внешний `SendChannel`, привязывает читателей и начинает принимать пакеты с учётом MTU/CRC настроек.【F:sources/com/upuphone/starrynet/core/ble/channel/ChannelManager.java†L51-L124】
4. **Обмен пакетами**: данные упаковываются в `Packet`/`DataPacket`, управление — в CTR/ACK. Очередь `SendChannel` гарантирует последовательность/повтор, таймауты CTR восстанавливают поток при сбоях.【F:sources/com/upuphone/starrynet/core/ble/channel/SendChannel.java†L23-L152】
5. **Шифрованное спаривание**: стороны обмениваются protobuf‑сообщениями через `StarryNetEncryptHelper` (команды AUTH/BOND/CONNECT_*). После подтверждения статуса и обмена ключами `StarryNetPairManager` переключает состояние пары на готовность и сохраняет ключи для последующих сеансов.【F:sources/com/upuphone/starrynet/strategy/encrypt/StarryNetEncryptHelper.java†L64-L197】
6. **Выбор и запуск протокола**: `ProtocolManager` активирует нужный профиль (Phone/Pad/Car/XR) через `StarryNetProtocol`, который подписывается на события каналов и, при необходимости, переводит связь на P2P/AP после BLE‑неготиации и ключевого обмена.

Используя эту схему и детальные описания отдельных классов в подпапке `starrynet_docs`, можно воспроизвести полный процесс BLE‑подключения StarryNet: от рекламы до зашифрованного обмена данными.
