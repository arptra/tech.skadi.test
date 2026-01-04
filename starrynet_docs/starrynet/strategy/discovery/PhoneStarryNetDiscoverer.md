# PhoneStarryNetDiscoverer

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/PhoneStarryNetDiscoverer.java`\n
*Тип:* Class

## Назначение
Класс PhoneStarryNetDiscoverer управляет логикой, связанной с PhoneStarryNetDiscoverer.

## Поля
- `String TAG`
- `DiscoveryActionObserver discoveryStateChangeCallback`
- `FastPairManager mFastPairManager`
- `UsbStarryNetDiscoverer mUsbStarryNetDiscoverer`

## Методы
- `public void callbackForTimeOut()`
- `public int disableFastConnect()`
- `public void initAdvertiseManager()`
- `public void onBleConnected(String str, boolean z)`
- `public void onBleDisconnected(String str)`
- `public void onBluetoothNameChange(String str)`
- `public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2)`
- `public void onConnectFail(StDevice stDevice, int i, int i2)`
- `public void onDeviceConnectRequest(StDevice stDevice, byte bArr)`
- `public void onDiscovered(StDiscoveryDevice stDiscoveryDevice)`
- `public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public int requestConnect(byte bArr, long j)`
- `public int setDeviceConnectable(boolean z, int i, String str)`
- `public int setFastConnectProcess(int i)`
- `public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public void startUp(short s)`
- `public void stopBleScan()`
- `public PhoneStarryNetDiscoverer()`
