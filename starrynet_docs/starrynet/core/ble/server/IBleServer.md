# IBleServer

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/IBleServer.java`\n
*Тип:* Interface

## Назначение
Класс IBleServer управляет логикой, связанной с IBleServer.

## Поля
- Нет объявленных полей.

## Методы
- `void addServices(IGattCharacterService iGattCharacterService)`
- `void clearGattServerResponseListener(GattServerResponseListener gattServerResponseListener)`
- `void disconnect()`
- `boolean isCharacterNotify(String str, UUID uuid)`
- `boolean isConnected(String str)`
- `boolean isServerOpened()`
- `void openServer()`
- `void registerGattServerResponseListener(GattServerResponseListener gattServerResponseListener)`
- `boolean sendNotification(String str, UUID uuid, byte bArr)`
