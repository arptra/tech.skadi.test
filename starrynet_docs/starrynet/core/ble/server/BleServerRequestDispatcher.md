# BleServerRequestDispatcher

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/BleServerRequestDispatcher.java`\n
*Тип:* Class

## Назначение
Класс BleServerRequestDispatcher управляет логикой, связанной с BleServerRequestDispatcher.

## Поля
- `int MAX_REQUEST_COUNT`
- `int MSG_SCHEDULE_NEXT`
- `int REQUEST_INTERVAL`
- `int SEND_DELAY`
- `String TAG`
- `List mBleHighLevelWorkList`
- `boolean mBleSupport`
- `List mBleWorkList`
- `BleServerRequest mCurrentRequest`
- `Handler mHandler`
- `long mLastRequestTime`
- `IBleServer mServer`
- `long requestIndex`

## Методы
- `public static long access$004(BleServerRequestDispatcher bleServerRequestDispatcher)`
- `private void addHighLevelNewRequest(BleServerRequest bleServerRequest)`
- `private void addNewRequest(BleServerRequest bleServerRequest)`
- `private boolean isHighLevelRequest(UUID uuid)`
- `private void scheduleNextRequest(long j)`
- `public void addServices(IGattCharacterService iGattCharacterService)`
- `public void checkRuntime()`
- `public void disconnect(String str)`
- `public boolean handleMessage(Message message)`
- `public boolean isCharacterNotify(String str, UUID uuid)`
- `public void onRequestCompleted(BleServerRequest bleServerRequest)`
- `public void openServer(OpenServerResponse openServerResponse)`
- `public void sendBatchNotification(String str, UUID uuid, List list, BleNotificationResponse bleNotificationResponse)`
- `public void sendNotification(String str, UUID uuid, byte bArr, BleNotificationResponse bleNotificationResponse)`
- `public void sendNotificationAtOnce(String str, UUID uuid, byte bArr, BleNotificationResponse bleNotificationResponse)`
- `private void scheduleNextRequest()`
- `public BleServerRequestDispatcher(GattServerConfig gattServerConfig)`
