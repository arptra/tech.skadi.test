# NotificationRequest

*Пакет:* `com.upuphone.starrynet.core.ble.server.request`\n
*Источник:* `starrynet/core/ble/server/request/NotificationRequest.java`\n
*Тип:* Class

## Назначение
Класс NotificationRequest управляет логикой, связанной с NotificationRequest.

## Поля
- `String mBleMac`
- `byte mBytes`
- `UUID mCharacterUUID`

## Методы
- `public long getTimeoutInMillis()`
- `public void onNotificationSent(int i)`
- `public void processRequest()`
- `public NotificationRequest(String str, UUID uuid, byte bArr, BleServerResponser bleServerResponser)`
