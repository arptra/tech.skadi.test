# UupShareProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.uupshare`\n
*Источник:* `starrynet/strategy/protocol/uupshare/UupShareProtocol.java`\n
*Тип:* Class

## Назначение
Класс UupShareProtocol управляет логикой, связанной с UupShareProtocol.

## Поля
- `ParcelUuid BASE_UUID`
- `String M_IV_PARAM_V_2`
- `String TAG`
- `ParcelUuid UUP_SHARE_ADV_SERVICE_UUID`
- `ParcelUuid UUP_SHARE_CONNECT_SERVICE_UUID`
- `ParcelUuid UUP_SHARE_READ_UUID`
- `ParcelUuid UUP_SHARE_SERVICE_DATA_UUID`
- `ParcelUuid UUP_SHARE_SERVICE_RESPONSE_DATA_UUID`
- `ParcelUuid UUP_SHARE_WRITE_UUID`
- `Context mContext`
- `StConnectDevice mDevice`
- `BluetoothGattServer mGattServer`
- `Gson mGson`
- `KeyPair mKeyPairA`

## Методы
- `private byte getMasterKey()`
- `private void handleDeviceInfo(StConnectDevice stConnectDevice, byte bArr)`
- `private void initUupService()`
- `public void lambda$readDeviceInfo$0(StConnectDevice stConnectDevice, int i, byte bArr)`
- `public void lambda$sendP2PInfo2PeerDevice$1(StConnectDevice stConnectDevice, int i, byte bArr)`
- `private void onAuthResult(StConnectDevice stConnectDevice, int i, String str)`
- `private void onBleSlaveConnected(UupShareInfo uupShareInfo, String str)`
- `private MasterKey parseMasterKey(byte bArr)`
- `private void readDeviceInfo(StConnectDevice stConnectDevice)`
- `private void sendP2PInfo2PeerDevice(StConnectDevice stConnectDevice, String str)`
- `public int connect(StDevice stDevice, int i)`
- `public void connectP2p(String str, String str2, int i, int i2, byte bArr)`
- `public int disconnect(StDevice stDevice, int i)`
- `public GoInfo getGoInfo()`
- `public IMessageChannel getMessageChannel(StDevice stDevice)`
- `public int getProfile()`
- `public void init()`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte bArr)`
- `public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public void onRecv(StConnectDevice stConnectDevice, byte bArr, int i, IStarryNetChannel iStarryNetChannel)`
- `public UupShareInfo parseSlaveKey(byte bArr)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public void connect(StDevice stDevice)`
- `public void disconnect()`
- `private String getMasterKey(MasterKey masterKey)`
- `public UupShareProtocol()`
