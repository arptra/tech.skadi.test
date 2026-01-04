# IBleConnectManager

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/IBleConnectManager.java`\n
*Тип:* Interface

## Назначение
Класс IBleConnectManager управляет логикой, связанной с IBleConnectManager.

## Поля
- Нет объявленных полей.

## Методы
- `void addServices(IGattCharacterService iGattCharacterService)`
- `void disconnect(String str)`
- `void init(GattServerConfig gattServerConfig)`
- `void isCharacterNotify(String str, UUID uuid, Consumer consumer)`
- `void openServer(OpenServerResponse openServerResponse)`
- `void sendBatchNotifications(String str, UUID uuid, List list, BleNotificationResponse bleNotificationResponse)`
- `void sendNotification(String str, UUID uuid, byte bArr, BleNotificationResponse bleNotificationResponse)`
- `void sendNotificationAtOnce(String str, UUID uuid, byte bArr, BleNotificationResponse bleNotificationResponse)`
