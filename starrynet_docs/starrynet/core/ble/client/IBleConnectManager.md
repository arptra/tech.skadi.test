# IBleConnectManager

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/IBleConnectManager.java`\n
*Тип:* Interface

## Назначение
Класс IBleConnectManager управляет логикой, связанной с IBleConnectManager.

## Поля
- Нет объявленных полей.

## Методы
- `void cancelConnecting(String str)`
- `void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse)`
- `void connect(String str, BleConnectResponse bleConnectResponse)`
- `void disconnect(String str)`
- `void disconnectAllDevices()`
- `void isCharacterExist(String str, UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `void notify(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse)`
- `void read(String str, UUID uuid, UUID uuid2, BleReadResponse bleReadResponse)`
- `void requestMtu(String str, int i, BleRequestMtuResponse bleRequestMtuResponse)`
- `void write(String str, UUID uuid, UUID uuid2, byte bArr, BleWriteResponse bleWriteResponse)`
- `void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List list, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `void writeNoRsp(String str, UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `void writeNoRspAtOnce(String str, UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
