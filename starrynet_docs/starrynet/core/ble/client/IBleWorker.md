# IBleWorker

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/IBleWorker.java`\n
*Тип:* Interface

## Назначение
Класс IBleWorker управляет логикой, связанной с IBleWorker.

## Поля
- Нет объявленных полей.

## Методы
- `void clearGattResponseListener(GattResponseListener gattResponseListener)`
- `void closeGatt()`
- `void destroy()`
- `boolean discoverService()`
- `int getCurrentStatus()`
- `void isCharacterExist(UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `boolean openGatt(BleConnectConfig bleConnectConfig)`
- `boolean readCharacteristic(UUID uuid, UUID uuid2)`
- `boolean refreshDeviceCache()`
- `void registerGattResponseListener(GattResponseListener gattResponseListener)`
- `boolean requestMtu(int i)`
- `boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z)`
- `boolean writeCharacteristic(UUID uuid, UUID uuid2, byte bArr)`
- `boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte bArr)`
