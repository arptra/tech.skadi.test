# BleRequest

*Пакет:* `com.upuphone.starrynet.core.ble.client.request`\n
*Источник:* `starrynet/core/ble/client/request/BleRequest.java`\n
*Тип:* Class

## Назначение
Класс BleRequest управляет логикой, связанной с BleRequest.

## Поля
- `int MSG_REQUEST_TIMEOUT`
- `String mAddress`
- `byte mBytes`
- `UUID mCharacterUUID`
- `IBleRequestDispatcher mDispatcher`
- `Bundle mExtra`
- `boolean mFinished`
- `Handler mHandler`
- `long mRequestId`
- `boolean mRequestTimeout`
- `BleResponser mResponse`
- `Handler mResponseHandler`
- `int mResultCode`
- `RuntimeChecker mRuntimeChecker`
- `UUID mServiceUUID`
- `IBleWorker mWorker`

## Методы
- `public void lambda$onResponse$0(int i)`
- `public void cancel()`
- `public void checkRuntime()`
- `public void clearGattResponseListener(GattResponseListener gattResponseListener)`
- `public void closeGatt()`
- `public void destroy()`
- `public boolean discoverService()`
- `public String getAddress()`
- `public int getCurrentStatus()`
- `public Bundle getExtra()`
- `public int getIntExtra(String str, int i)`
- `public long getRequestID()`
- `public BleResponser getResponse()`
- `public int getResultCode()`
- `public String getStatusText()`
- `public long getTimeoutInMillis()`
- `public boolean handleMessage(Message message)`
- `public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `public void log(String str)`
- `public boolean onConnectStatusChanged(boolean z)`
- `public void onRequestCompleted(int i)`
- `public void onResponse(int i)`
- `public boolean openGatt(BleConnectConfig bleConnectConfig)`
- `final public void process(IBleRequestDispatcher iBleRequestDispatcher)`
- `abstract public void processRequest()`
- `public void putByteArray(String str, byte bArr)`
- `public void putIntExtra(String str, int i)`
- `public void putParcelable(String str, Parcelable parcelable)`
- `public boolean readCharacteristic(UUID uuid, UUID uuid2)`
- `public boolean refreshDeviceCache()`
- `public void registerGattResponseListener(GattResponseListener gattResponseListener)`
- `public boolean requestMtu(int i)`
- `public void setAddress(String str)`
- `public boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z)`
- `public void setRequestID(long j)`
- `public void setResponse(BleResponser bleResponser)`
- `public void setResultCode(int i)`
- `public void setRuntimeChecker(RuntimeChecker runtimeChecker)`
- `public void setWorker(IBleWorker iBleWorker)`
- `public void startRequestTiming()`
- `public void stopRequestTiming()`
- `public boolean writeCharacteristic(UUID uuid, UUID uuid2, byte bArr)`
- `public boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte bArr)`
- `public BleRequest(BleResponser bleResponser)`
