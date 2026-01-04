# IStarryNetDiscoverer

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/IStarryNetDiscoverer.java`\n
*Тип:* Interface

## Назначение
Класс IStarryNetDiscoverer управляет логикой, связанной с IStarryNetDiscoverer.

## Поля
- Нет объявленных полей.

## Методы
- `int disableFastConnect()`
- `int enableFastConnect()`
- `int enableFastConnectWithTimeOut(long j)`
- `boolean getReconnectEnable()`
- `boolean isAdvEnable()`
- `boolean isCarActiveDisconnect(String str)`
- `boolean isCarActiveDisconnectPad()`
- `int requestConnect(byte bArr, long j)`
- `int reset()`
- `int setAdvertiseEnableMode(int i)`
- `void setCarActiveDisconnect(String str)`
- `int setDeviceConnectable(boolean z, int i, String str)`
- `int setFastConnectProcess(int i)`
- `int setReconnectEnable(boolean z)`
- `int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `int startMultiDeviceFound()`
- `void startUp(short s)`
- `void stopBleScan()`
- `int stopDiscovery(String str)`
- `int stopMultiDeviceFound(boolean z)`
- `void stopNotifyAdv()`
- `int upDataAdvParams(byte bArr)`
