# XRStarryNetDiscoverer

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/XRStarryNetDiscoverer.java`\n
*Тип:* Class

## Назначение
Класс XRStarryNetDiscoverer управляет логикой, связанной с XRStarryNetDiscoverer.

## Поля
- `String TAG`
- `long advTimeoutMills`

## Методы
- `public void callbackForTimeOut()`
- `public int disableFastConnect()`
- `public int enableFastConnect()`
- `public int enableFastConnectWithTimeOut(long j)`
- `public int enableFastConnectXr()`
- `public void initAdvertiseManager()`
- `public void onBluetoothNameChange(String str)`
- `public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onConnectFail(StDevice stDevice, int i, int i2)`
- `public boolean onDiscovery(StDiscoveryDevice stDiscoveryDevice)`
- `public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public int stopDiscovery(String str)`
- `public int upDataAdvParams(byte bArr)`
- `public XRStarryNetDiscoverer()`
