# FastPairManager

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/FastPairManager.java`\n
*Тип:* Class

## Назначение
Класс FastPairManager управляет логикой, связанной с FastPairManager.

## Поля
- `String TAG`
- `DiscoveryConnectConfig mDiscoveryConnectConfig`
- `FastPairApp mFastPairApp`
- `IFastPairCallback mFastPairCallback`
- `FastPairJudgment mFastPairJudgment`
- `FastPairStar mFastPairStar`
- `int mProcessType`

## Методы
- `private int checkRspType(StDiscoveryDevice stDiscoveryDevice)`
- `private boolean isConnectable(StDiscoveryDevice stDiscoveryDevice)`
- `private boolean refuseReconnectAdv(StDiscoveryDevice stDiscoveryDevice)`
- `public void clearBeacon()`
- `public int fastPairStatus(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean handleActiveAdv(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean handleNotify(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean isPairing(StDevice stDevice)`
- `public void onApCreated(WiFiApInfo wiFiApInfo)`
- `public void onApRemoved()`
- `public void onBleConnectFail(StDevice stDevice, int i)`
- `public void onBleConnected(StDevice stDevice)`
- `public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onBrConnectFail(StDevice stDevice, int i)`
- `public void onBrEdrConnected(StDevice stDevice)`
- `public void onConnectFail(StDevice stDevice, int i, int i2)`
- `public void onConnected(StConnectDevice stConnectDevice, int i)`
- `public void onDisconnected(StConnectDevice stConnectDevice, int i)`
- `public boolean onDiscovery(StDiscoveryDevice stDiscoveryDevice)`
- `public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public void onP2pGoCreated(GoInfo goInfo)`
- `public void onP2pGoRemoved()`
- `public void setDeviceConnectable(boolean z, int i, String str)`
- `public void setFastConnectProcess(int i)`
- `public void starPair(StDiscoveryDevice stDiscoveryDevice, int i, int i2)`
- `public boolean startAppFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startRequestConnect(StDiscoveryDevice stDiscoveryDevice)`
- `public FastPairManager(Context context, IFastPairCallback iFastPairCallback)`
