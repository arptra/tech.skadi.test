# AirProJudgement

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.judgment`\n
*Источник:* `starrynet/strategy/discovery/fastpair/judgment/AirProJudgement.java`\n
*Тип:* Class

## Назначение
Класс AirProJudgement управляет логикой, связанной с AirProJudgement.

## Поля
- `int RSSI_FAST_PAIR_MIN`
- `int RSSI_UN_BOND_MIN`
- `String TAG`

## Методы
- `public void dealDelayJudgment(StDiscoveryDevice stDiscoveryDevice, int i, int i2)`
- `public void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice)`
- `public int getRssiFastPairMin()`
- `public int getRssiUnBondMin()`
- `public boolean needOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public AirProJudgement(FastPairJudgment fastPairJudgment, String str)`
