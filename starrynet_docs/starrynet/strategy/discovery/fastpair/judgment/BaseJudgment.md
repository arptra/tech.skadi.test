# BaseJudgment

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.judgment`\n
*Источник:* `starrynet/strategy/discovery/fastpair/judgment/BaseJudgment.java`\n
*Тип:* Class

## Назначение
Класс BaseJudgment управляет логикой, связанной с BaseJudgment.

## Поля
- `int DEVICE_STATUS_BOND`
- `int DEVICE_STATUS_BOND_OTHER`
- `int DEVICE_STATUS_CONNECTED`
- `int DEVICE_STATUS_UN_BOND`
- `String TAG`
- `FastPairJudgment mJudgment`
- `String mModelId`

## Методы
- `public void addPairRecord(StDiscoveryDevice stDiscoveryDevice)`
- `public void dealDelayJudgment(StDiscoveryDevice stDiscoveryDevice, int i, int i2)`
- `public void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice)`
- `public int getDeviceBondInfoResult(StDiscoveryDevice stDiscoveryDevice)`
- `public int getFastPairStatus(StDiscoveryDevice stDiscoveryDevice)`
- `public Handler getHandler()`
- `public int getPairRecord(String str)`
- `public boolean isJudged(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean needOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice)`
- `public void removePairRecord(String str)`
- `public void sendResult(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public BaseJudgment(FastPairJudgment fastPairJudgment, String str)`
