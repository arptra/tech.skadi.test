# BleGattServer

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/BleGattServer.java`\n
*Тип:* Class

## Назначение
Класс BleGattServer управляет логикой, связанной с BleGattServer.

## Поля
- `int MSG_GATT_RESPONSE`
- `String TAG`
- `List mAddedServices`
- `GattServerConfig mConfig`
- `Context mContext`
- `GattServerResponseListener mGattResponseListener`
- `BluetoothGattServer mGattServer`
- `boolean mIsGattServerOpen`
- `Map mMac2OpenNotifyMap`
- `Map mNotificationCharacterMap`
- `Map mRemoteDevices`
- `RuntimeChecker mRuntimeChecker`
- `IBleGattServerResponse mServerCallback`
- `Set mValidConnectedDevice`
- `Handler mWorkerHandler`

## Методы
- `private String bluetoothGattService2String(BluetoothGattService bluetoothGattService)`
- `public void broadcastServerValidConnectStatusChanged(boolean z, String str)`
- `private BluetoothGattService buildGattService(IGattCharacterService iGattCharacterService)`
- `private void checkAndNotifyValidConnected(BleOpenNotifyEvent bleOpenNotifyEvent)`
- `private boolean checkServiceAdded(IGattCharacterService iGattCharacterService)`
- `private void error(String str, Object objArr)`
- `public void log(String str, Object objArr)`
- `private void notificationCallback(int i)`
- `private IGattCharacteristic queryCharacter(BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `private void requestPhy(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `public void addServices(IGattCharacterService iGattCharacterService)`
- `public void checkRuntime()`
- `public void clearGattServerResponseListener(GattServerResponseListener gattServerResponseListener)`
- `public void disconnect()`
- `public boolean handleMessage(Message message)`
- `public boolean isCharacterNotify(String str, UUID uuid)`
- `public boolean isConnected(String str)`
- `public boolean isServerOpened()`
- `public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte bArr)`
- `public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2)`
- `public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte bArr)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `public void onMtuChanged(BluetoothDevice bluetoothDevice, int i)`
- `public void onNotificationSent(BluetoothDevice bluetoothDevice, int i)`
- `public void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `public void onReadPhy(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `public void onServiceAdded(int i, BluetoothGattService bluetoothGattService)`
- `public void openServer()`
- `public void registerGattServerResponseListener(GattServerResponseListener gattServerResponseListener)`
- `public boolean sendNotification(String str, UUID uuid, byte bArr)`
- `public void updatePhysicsConnectedStatus(String str, boolean z)`
- `public void wf(String str, Object objArr)`
- `private void addServices()`
- `public BleGattServer(Context context, GattServerConfig gattServerConfig, RuntimeChecker runtimeChecker)`
