# FastPairJudgment

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.judgment`\n
*Источник:* `starrynet/strategy/discovery/fastpair/judgment/FastPairJudgment.java`\n
*Тип:* Class

## Назначение
Класс FastPairJudgment управляет логикой, связанной с FastPairJudgment.

## Поля
- `int JUDGMENT_STATUS_DEFAULT`
- `int JUDGMENT_STATUS_NO_JUDGMENT`
- `int JUDGMENT_STATUS_PAIRING`
- `int MSG_DELAY_JUDGMENT`
- `int MSG_FAST_PAIR_JUDGMENT`
- `String TAG`
- `IJudgmentCallback mCallback`
- `Handler mHandler`
- `BaseJudgment mJudgment`
- `Map mJudgmentMap`
- `Map mPairRecords`

## Методы
- `private void dealDelayJudgment(StDiscoveryDevice stDiscoveryDevice, int i, int i2)`
- `private void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice)`
- `public void dealMsg(Message message)`
- `private BaseJudgment getJudgment(String str)`
- `public void addPairRecord(StDiscoveryDevice stDiscoveryDevice)`
- `public void clearPairRecord()`
- `public int getFastPairStatus(StDiscoveryDevice stDiscoveryDevice)`
- `public Handler getHandler()`
- `public int getPairRecord(String str)`
- `public boolean handleNotify(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean isJudged(StDiscoveryDevice stDiscoveryDevice)`
- `public void removePairRecord(String str)`
- `public void sendResult(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public boolean startAppFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public boolean startRequestConnect(StDiscoveryDevice stDiscoveryDevice)`
- `public FastPairJudgment(IJudgmentCallback iJudgmentCallback)`
