# AbsStarryNetDiscoverer

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/AbsStarryNetDiscoverer.java`\n
*Тип:* Class

## Назначение
Класс AbsStarryNetDiscoverer управляет логикой, связанной с AbsStarryNetDiscoverer.

## Поля
- `int MSG_REQUEST_CONNECT_TIMEOUT`
- `int MSG_XR_ADV_TIMEOUT`
- `int RSSI_ICCOA_PAIR_MIN`
- `String TAG`
- `AdvertiserManager mAdvertiseManager`
- `Context mContext`
- `DiscoverHanddler mDiscoverHandler`
- `CopyOnWriteArraySet mListBleChannel`
- `List mListDiscovery`
- `SysActionManager mStateChangeSimpleCallback`
- `DiscoveryStateMachine mStateMachine`
- `HandlerThread mStateMachineThread`

## Методы
- `public void callbackForTimeOut()`
- `public void checkAndResponseDeviceFoundAdv(com r4)`
- `public int disableFastConnect()`
- `public int enableFastConnect()`
- `public int enableFastConnectWithTimeOut(long j)`
- `public boolean getReconnectEnable()`
- `abstract public void initAdvertiseManager()`
- `public boolean isAdvEnable()`
- `public boolean isCarActiveDisconnect(String str)`
- `public boolean isCarActiveDisconnectPad()`
- `public boolean isStarryAdvertising()`
- `public void onAdvStatus(int i, int i2)`
- `public void onBatchDiscovered(List list)`
- `public void onBleConnected(String str, boolean z)`
- `public void onBleDisconnected(String str)`
- `public void onBluetoothDisabled()`
- `public void onBluetoothEnabled()`
- `public void onBluetoothNameChange(String str)`
- `public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onConnectFail(StDevice stDevice, int i, int i2)`
- `public void onDiscovered(StDiscoveryDevice stDiscoveryDevice)`
- `public void onDiscoveredFail(int i)`
- `public void onEvent(Object obj)`
- `public void onLost(StDiscoveryDevice stDiscoveryDevice)`
- `public void onP2pGoConnected(StConnectDevice stConnectDevice)`
- `public void onP2pGoDisconnected(StConnectDevice stConnectDevice)`
- `public void onScreenOff()`
- `public void onScreenOn()`
- `public void onUupShareDisabled()`
- `public void onUupShareEnabled()`
- `public int requestConnect(byte bArr, long j)`
- `public int reset()`
- `public void restartStarryAdv()`
- `public int setAdvertiseEnableMode(int i)`
- `public void setCarActiveDisconnect(String str)`
- `public int setDeviceConnectable(boolean z, int i, String str)`
- `public int setFastConnectProcess(int i)`
- `public int setReconnectEnable(boolean z)`
- `public int startActiveAdv(boolean z)`
- `public int startConnectAdv(byte bArr)`
- `public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public int startMultiDeviceFound()`
- `public int startNotifyAdv(byte bArr)`
- `public int startPassiveAdv(boolean z)`
- `public int startReConnectAdv(byte bArr)`
- `public int startScan(DiscoveryFilter discoveryFilter, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public void startUp(short s)`
- `public void startUupShareAdv()`
- `public void startUupShareRspAdv()`
- `public int stopActiveAdv()`
- `public void stopBleScan()`
- `public void stopConnectAdv()`
- `public int stopDiscovery(String str)`
- `public int stopMultiDeviceFound(boolean z)`
- `public void stopNotifyAdv()`
- `public void stopPassiveAdv()`
- `public void stopReConnectAdv()`
- `public int stopScan(String str)`
- `public void stopStarryAdv()`
- `public void stopUupShareAdv()`
- `public void stopUupShareRspAdv()`
- `public int upDataAdvParams(byte bArr)`
- `public AbsStarryNetDiscoverer()`
