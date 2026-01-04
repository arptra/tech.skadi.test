# StarryNetPairManager

*Пакет:* `com.upuphone.starrynet.strategy.pair`\n
*Источник:* `starrynet/strategy/pair/StarryNetPairManager.java`\n
*Тип:* Class

## Назначение
Класс StarryNetPairManager управляет логикой, связанной с StarryNetPairManager.

## Поля
- `String TAG`
- `IChannelModulePair gcChannelModulePair`
- `IChannelModulePair goChannelModulePair`
- `IPairStatusCallback mCallback`
- `boolean mIsPair`
- `boolean mIsUnPair`
- `IPairChannel mPairChannel`
- `Object mSyncIsPair`
- `Object mSyncIsUnPair`

## Методы
- `public void createBond(StDevice stDevice, int i)`
- `public void onEvent(String str, byte bArr, int i)`
- `public void removeBond(StConnectDevice stConnectDevice, int i)`
- `public StarryNetPairManager(IPairChannel iPairChannel)`
