# BleConnectMaster

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BleConnectMaster.java`\n
*Тип:* Class

## Назначение
Класс BleConnectMaster управляет логикой, связанной с BleConnectMaster.

## Поля
- `int CHECK_ALIVE_CYCLE`
- `int CHECK_ALIVE_LIMIT`
- `int MSG_CHECK_ALIVE`
- `String mAddressMac`
- `BleRequestDispatcher mBleRequestDispatcher`
- `Handler mHandler`
- `Handler mMainHandler`
- `MessageHandlerThread mThread`
- `long mTimeStamp`

## Методы
- `private static void assertCalledInCoreBleThread()`
- `private void checkAlive()`
- `private void initDispatcherIfNeeded()`
- `public void lambda$prepareCheckAlive$1()`
- `public void lambda$stopMasterLooper$0()`
- `public static IBleConnectMaster newInstance(String str)`
- `private void prepareCheckAlive()`
- `private void startMasterLooper()`
- `private void stopMasterLooper()`
- `private void updateTimeStamp(long j)`
- `public void cancelConnecting()`
- `public void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse)`
- `public void destroy()`
- `public void disconnect()`
- `public Handler getHandler()`
- `public boolean handleMessage(Message message)`
- `public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `public void notify(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `public void read(UUID uuid, UUID uuid2, BleReadResponse bleReadResponse)`
- `public void requestMtu(int i, BleRequestMtuResponse bleRequestMtuResponse)`
- `public void write(UUID uuid, UUID uuid2, byte bArr, BleWriteResponse bleWriteResponse)`
- `public void writeBatchNoRsp(UUID uuid, UUID uuid2, List list, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `public void writeNoRsp(UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `public void writeNoRspAtOnce(UUID uuid, UUID uuid2, byte bArr, BleWriteNoRespResponse bleWriteNoRespResponse)`
- `private BleConnectMaster(String str)`
