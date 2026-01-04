# PadStarryNetDiscoverer

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/PadStarryNetDiscoverer.java`\n
*Тип:* Class

## Назначение
Класс PadStarryNetDiscoverer управляет логикой, связанной с PadStarryNetDiscoverer.

## Поля
- `String TAG`
- `FastPairManager mFastPairManager`

## Методы
- `public void callbackForTimeOut()`
- `public int disableFastConnect()`
- `public void initAdvertiseManager()`
- `public void onBleConnected(String str, boolean z)`
- `public void onBleDisconnected(String str)`
- `public void onBluetoothNameChange(String str)`
- `public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onDeviceConnectRequest(StDevice stDevice, byte bArr)`
- `public void onDiscovered(StDiscoveryDevice stDiscoveryDevice)`
- `public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public void startUp(short s)`
- `public PadStarryNetDiscoverer()`
