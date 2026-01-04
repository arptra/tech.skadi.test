# BleRequestDispatcher

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BleRequestDispatcher.java`\n
*Тип:* Class

## Назначение
Класс BleRequestDispatcher управляет логикой, связанной с BleRequestDispatcher.

## Поля
- `byte HEART_BEAT_DATA`
- `int HEART_BEAT_INTERVAL`
- `int MAX_REQUEST_COUNT`
- `int MSG_SCHEDULE_NEXT`
- `int MSG_SEND_HEART_BEAT_DATA`
- `int REQUEST_INTERVAL`
- `String TAG`
- `String mAddress`
- `List mBleHighLevelWorkList`
- `boolean mBleSupport`
- `List mBleWorkList`
- `BleRequest mCurrentRequest`
- `Handler mHandler`
- `UUID mHeartBeatUUID`
- `long mLastRequestTime`
- `IBleWorker mWorker`
- `long requestIndex`

## Методы
- `public static long access$204(BleRequestDispatcher bleRequestDispatcher)`
- `private void addNewRequest(BleRequest bleRequest)`
- `private void doNextRequest()`
- `private boolean isHighLevelRequest(UUID uuid, UUID uuid2)`
- `public static BleRequestDispatcher newInstance(String str)`
- `private void scheduleNextRequest()`
- `public void addNewHighLevelRequest(BleRequest bleRequest)`
- `public void cancelConnecting()`
- `public void checkRuntime()`
- `public void connect(BleConnectConfig bleConnectConfig, BleResponser bleResponser)`
- `public void destroy()`
- `public void disconnect()`
- `public boolean handleMessage(Message message)`
- `public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `public void notify(UUID uuid, UUID uuid2, BleResponser bleResponser)`
- `public void onRequestCompleted(BleRequest bleRequest)`
- `public void read(UUID uuid, UUID uuid2, BleResponser bleResponser)`
- `public void requestMtu(int i, BleResponser bleResponser)`
- `public void write(UUID uuid, UUID uuid2, byte bArr, BleResponser bleResponser)`
- `public void writeBatchNoRsp(UUID uuid, UUID uuid2, List list, BleResponser bleResponser)`
- `public void writeNoRespAtOne(UUID uuid, UUID uuid2, byte bArr, BleResponser bleResponser)`
- `public void writeNoRsp(UUID uuid, UUID uuid2, byte bArr, BleResponser bleResponser)`
- `private BleRequestDispatcher(String str)`
