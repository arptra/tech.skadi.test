# StarJudgment

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.judgment`\n
*Источник:* `starrynet/strategy/discovery/fastpair/judgment/StarJudgment.java`\n
*Тип:* Class

## Назначение
Класс StarJudgment управляет логикой, связанной с StarJudgment.

## Поля
- `int DELAY_TIME`
- `int RSSI_FAST_PAIR_MIN`
- `int RSSI_FAST_PAIR_MIN_3004`
- `int RSSI_UN_BOND_MIN`
- `int RSSI_UN_BOND_MIN_3004`
- `String TAG`
- `List mDeviceBondCache`
- `Map mDeviceCache`
- `List mDevicePairCache`

## Методы
- `private synchronized void sendDelayMessage(StDiscoveryDevice stDiscoveryDevice)`
- `public void dealDelayJudgment(com r1, int r2, int r3)`
- `public void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice)`
- `public int getRssiFastPairMin()`
- `public int getRssiUnBondMin()`
- `public boolean needOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public StarJudgment(FastPairJudgment fastPairJudgment, String str)`
