# CarStarryNetDiscoverer

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/CarStarryNetDiscoverer.java`\n
*Тип:* Class

## Назначение
Класс CarStarryNetDiscoverer управляет логикой, связанной с CarStarryNetDiscoverer.

## Поля
- `String TAG`
- `boolean isAdvEnable`
- `boolean isMultiDeviceFound`
- `boolean isReconnectEnable`
- `boolean isSupportCarWithPad`
- `CarBaseManager mCarManager`
- `long mConnectTimeoutMillis`
- `byte mRequestConnectId`
- `boolean mRequestRecord`
- `List mSetActiveDisconnect`
- `List mSetRemoveBond`

## Методы
- `private boolean checkCanStartReconnectAdv()`
- `private void checkStartActiveAdv(boolean z)`
- `private boolean hasDevicePairing()`
- `private void removeBondIncompatibleDevice()`
- `private void sendMsg(StDevice stDevice, int i, byte bArr)`
- `private void setRemoveBond(String str)`
- `public void callbackForTimeOut()`
- `public int disableFastConnect()`
- `public int enableFastConnect()`
- `public boolean getReconnectEnable()`
- `public void initAdvEnableMode()`
- `public void initAdvertiseManager()`
- `public void initCarManager()`
- `public boolean isAdvEnable()`
- `public boolean isCarActiveDisconnect(String str)`
- `public boolean isCarActiveDisconnectPad()`
- `public boolean isStrPowerMode()`
- `public void onBleConnected(String str, boolean z)`
- `public void onBleDisconnected(String str)`
- `public void onBluetoothNameChange(String str)`
- `public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onDeviceConnectRequest(StDevice stDevice, byte bArr)`
- `public void onDiscovered(StDiscoveryDevice stDiscoveryDevice)`
- `public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public void onP2pGoDisconnected(StConnectDevice stConnectDevice)`
- `public void onStrModeChanged(boolean z)`
- `public int requestConnect(byte bArr, long j)`
- `public int setAdvertiseEnableMode(int i)`
- `public void setCarActiveDisconnect(String str)`
- `public int setReconnectEnable(boolean z)`
- `public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public int startMultiDeviceFound()`
- `public int startPassiveAdv(boolean z)`
- `public int stopDiscovery(String str)`
- `public int stopMultiDeviceFound(boolean z)`
- `public boolean supportCarWithPad()`
- `public CarStarryNetDiscoverer()`
