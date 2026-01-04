# IccoaProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.iccoa`\n
*Источник:* `starrynet/strategy/protocol/iccoa/IccoaProtocol.java`\n
*Тип:* Class

## Назначение
Класс IccoaProtocol управляет логикой, связанной с IccoaProtocol.

## Поля
- `int COMMUNICATION_TIMEOUT`
- `int DEFAULT_BAND`
- `int FIVE_G_BAND`
- `String KEY_STARRY_AP_SUPPORT`
- `String SUPPORT_STARRY_AP`
- `String TAG`
- `IProtocolCallback mCallback`
- `CommunicationTimeoutHandler mCommunicationTimeoutHandler`
- `Context mContext`
- `IccoaChannel mIccoaChannel`
- `boolean mIsBleAuthCompleted`
- `StConnectDevice mStConnectDevice`
- `HashMap mWaitConnectWifiDevices`
- `WifiManager mWifiManager`

## Методы
- `private int checkWifiBandInfo()`
- `private void connectWifi(StConnectDevice stConnectDevice, int i)`
- `private Map dealJsonDataFromCar(byte bArr)`
- `private int disconnectUsb(StDevice stDevice)`
- `private boolean isSupportStarryAp()`
- `public void lambda$onWiFiEnabled$0(Integer num)`
- `private byte sendPhoneJsonData2Car(int i, String str)`
- `private void startTimer(int i, int i2, StDevice stDevice)`
- `private void stopTimer(int i)`
- `public int connect(StDevice stDevice, int i)`
- `public int disconnect(StDevice stDevice, int i)`
- `public IMessageChannel getMessageChannel(StDevice stDevice)`
- `public int getProfile()`
- `public boolean isBleAuthCompleted()`
- `public void onBatchDiscovered(List list)`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onConnectFail(int i)`
- `public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public void onDisConnected(String str)`
- `public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public void onDiscovered(StDiscoveryDevice stDiscoveryDevice)`
- `public void onDiscoveredFail(int i)`
- `public void onLost(StDiscoveryDevice stDiscoveryDevice)`
- `public void onRecv(StConnectDevice stConnectDevice, byte bArr, int i, IStarryNetChannel iStarryNetChannel)`
- `public void onWiFiEnabled()`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public void setProtocolCallback(IProtocolCallback iProtocolCallback)`
- `public void onRecv(StDevice stDevice, byte bArr, int i)`
- `public void onConnected(String str)`
- `public IccoaProtocol(Context context)`
