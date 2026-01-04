# BleConnectManager

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BleConnectManager.java`\n
*Тип:* Class

## Назначение
Класс BleConnectManager управляет логикой, связанной с BleConnectManager.

## Поля
- `int ALIVE_TIMEOUT`
- `int MAX_CLIENT_SIZE`
- `String TAG`
- `IBleConnectManager sInstance`
- `HashMap mAliveMap`
- `HashMap mBleConnectWorkerMap`
- `Handler mHandler`

## Методы
- `private void checkIfNeedDestroyMaster()`
- `private IBleConnectMaster getBleConnectMaster(String str)`
- `public static IBleConnectManager getInstance()`
- `public void cancelConnecting(String str)`
- `public void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse)`
- `public void disconnect(String str)`
- `public void disconnectAllDevices()`
- `public boolean handleMessage(Message message)`
- `public void isCharacterExist(String str, UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `public void notify(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `public void read(String str, UUID uuid, UUID uuid2, BleReadResponse bleReadResponse)`
- `public void requestMtu(String str, int i, BleRequestMtuResponse bleRequestMtuResponse)`
- `public void write(String str, UUID uuid, UUID uuid2, byte bArr, BleWriteResponse bleWriteResponse)`
- `public void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List list, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `public void writeNoRsp(String str, UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `public void writeNoRspAtOnce(String str, UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `public void connect(String str, BleConnectResponse bleConnectResponse)`
- `private BleConnectManager()`
