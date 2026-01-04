# BleServerRequest

*Пакет:* `com.upuphone.starrynet.core.ble.server.request`\n
*Источник:* `starrynet/core/ble/server/request/BleServerRequest.java`\n
*Тип:* Class

## Назначение
Класс BleServerRequest управляет логикой, связанной с BleServerRequest.

## Поля
- `int MSG_REQUEST_TIMEOUT`
- `String mBleMac`
- `BleServerRequestDispatcher mDispatcher`
- `Bundle mExtra`
- `boolean mFinished`
- `Handler mHandler`
- `long mRequestId`
- `boolean mRequestTimeout`
- `BleServerResponser mResponse`
- `RuntimeChecker mRuntimeChecker`
- `IBleServer mServer`

## Методы
- `private void log(String str, Object objArr)`
- `public void addServices(IGattCharacterService iGattCharacterService)`
- `public void cancel()`
- `public void checkRuntime()`
- `public void clearGattServerResponseListener(GattServerResponseListener gattServerResponseListener)`
- `public void disconnect()`
- `public long getRequestID()`
- `public long getTimeoutInMillis()`
- `public boolean handleMessage(Message message)`
- `public boolean isCharacterNotify(String str, UUID uuid)`
- `public boolean isConnected(String str)`
- `public boolean isServerOpened()`
- `public void onConnectStatusChanged(String str, boolean z)`
- `public void onRequestCompleted(int i)`
- `public void onResponse(int i)`
- `public void openServer()`
- `final public void process(BleServerRequestDispatcher bleServerRequestDispatcher)`
- `abstract public void processRequest()`
- `public void registerGattServerResponseListener(GattServerResponseListener gattServerResponseListener)`
- `public boolean sendNotification(String str, UUID uuid, byte bArr)`
- `public void setBleServer(IBleServer iBleServer)`
- `public void setRequestID(long j)`
- `public void setRuntimeChecker(RuntimeChecker runtimeChecker)`
- `public void startRequestTiming()`
- `public void stopRequestTiming()`
- `public BleServerRequest(String str, BleServerResponser bleServerResponser)`
