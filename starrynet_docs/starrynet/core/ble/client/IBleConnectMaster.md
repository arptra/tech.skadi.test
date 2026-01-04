# IBleConnectMaster

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/IBleConnectMaster.java`\n
*Тип:* Interface

## Назначение
Класс IBleConnectMaster управляет логикой, связанной с IBleConnectMaster.

## Поля
- Нет объявленных полей.

## Методы
- `void cancelConnecting()`
- `void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse)`
- `void destroy()`
- `void disconnect()`
- `void isCharacterExist(UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `void notify(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse)`
- `void read(UUID uuid, UUID uuid2, BleReadResponse bleReadResponse)`
- `void requestMtu(int i, BleRequestMtuResponse bleRequestMtuResponse)`
- `void write(UUID uuid, UUID uuid2, byte bArr, BleWriteResponse bleWriteResponse)`
- `void writeBatchNoRsp(UUID uuid, UUID uuid2, List list, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `void writeNoRsp(UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `void writeNoRspAtOnce(UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
