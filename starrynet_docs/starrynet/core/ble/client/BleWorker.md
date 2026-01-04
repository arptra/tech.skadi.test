# BleWorker

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BleWorker.java`\n
*Тип:* Class

## Назначение
Класс BleWorker управляет логикой, связанной с BleWorker.

## Поля
- `int BALANCE_SPEED_TRANS_MODE`
- `int BLE_EVENT_QUIET`
- `int HIGH_SPEED_TRANS_MODE`
- `int LOW_SPEED_TRANS_MODE`
- `int MSG_DISCONNECT_TIMEOUT`
- `int MSG_GATT_RESPONSE`
- `String TAG`
- `boolean isSupportLe2M`
- `BluetoothDevice mBluetoothDevice`
- `BluetoothGatt mBluetoothGatt`
- `IBluetoothGattResponse mBluetoothGattResponse`
- `BleConnectConfig mConConfig`
- `int mConnectStatus`
- `Map mDeviceProfile`
- `GattResponseListener mGattResponseListener`
- `long mLastBleEventTime`
- `int mLatencyMode`
- `Object mLock`
- `RuntimeChecker mRuntimeChecker`
- `SystemActionObserver mSystemActionChangedCallback`
- `Handler mWorkerHandler`

## Методы
- `private void broadcastCharacterChanged(UUID uuid, UUID uuid2, byte bArr)`
- `public void broadcastConnectStatus(int i, int i2)`
- `private BluetoothGattCharacteristic cloneCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `public static android copy(android r2)`
- `private String getAddress()`
- `private android getCharacter(java r2, java r3)`
- `public void invokeSetLeConnectionPriority(int i)`
- `private boolean isCharacteristicNoRspWritable(BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `private boolean isCharacteristicNotifyable(BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `private boolean isCharacteristicReadable(BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `private boolean isCharacteristicWritable(BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `private boolean isSupportHighSpeed()`
- `public void lambda$releaseAfterDisconnected$0(int i)`
- `private void openHighSpeedModeIfNeed()`
- `private void refreshServiceProfile(Consumer consumer, UUID uuid)`
- `public void releaseAfterDisconnected(int i)`
- `private void requestPhy(int i, int i2, int i3)`
- `public void setConnectStatus(int i)`
- `private void updateBleEventTime()`
- `private boolean useDetailLog()`
- `public void checkRuntime()`
- `public void clearGattResponseListener(GattResponseListener gattResponseListener)`
- `public void closeGatt()`
- `public void destroy()`
- `public boolean discoverService()`
- `public int getCurrentStatus()`
- `public boolean handleMessage(Message message)`
- `public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse bleResponse)`
- `public void log(String str, Object objArr)`
- `public void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte bArr)`
- `public void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte bArr)`
- `public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte bArr)`
- `public void onConnectionStateChange(int i, int i2)`
- `public void onConnectionUpdate(int i, int i2)`
- `public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `public void onMtuChanged(int i, int i2)`
- `public void onPhyRead(int i, int i2, int i3)`
- `public void onPhyUpdate(int i, int i2, int i3)`
- `public void onServiceChanged(BluetoothGatt bluetoothGatt)`
- `public void onServicesDiscovered(int i)`
- `public boolean openGatt(BleConnectConfig bleConnectConfig)`
- `public boolean readCharacteristic(UUID uuid, UUID uuid2)`
- `public boolean refreshDeviceCache()`
- `public void registerGattResponseListener(GattResponseListener gattResponseListener)`
- `public boolean requestMtu(int i)`
- `public boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z)`
- `public void waitFor(int i)`
- `public void wf(String str, Object objArr)`
- `public boolean writeCharacteristic(UUID uuid, UUID uuid2, byte bArr)`
- `public boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte bArr)`
- `public BleWorker(String str, RuntimeChecker runtimeChecker)`
