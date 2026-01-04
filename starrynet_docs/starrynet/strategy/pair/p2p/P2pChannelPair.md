# P2pChannelPair

*Пакет:* `com.upuphone.starrynet.strategy.pair.p2p`\n
*Источник:* `starrynet/strategy/pair/p2p/P2pChannelPair.java`\n
*Тип:* Class

## Назначение
Класс P2pChannelPair управляет логикой, связанной с P2pChannelPair.

## Поля
- `String TAG`
- `IPairChannel mChannel`
- `PairP2pMsgHandler mP2pPairMsgHandler`
- `IPairStatusCallback mPairStatusCallback`

## Методы
- `private void handleGcUnBondMsg(StarryNetDecryptHelper starryNetDecryptHelper)`
- `private void handleGoUnBondMsg(StarryNetDecryptHelper starryNetDecryptHelper)`
- `public void handleMsgFromGc(StarryNetDecryptHelper starryNetDecryptHelper)`
- `public void handleMsgFromGo(StarryNetDecryptHelper starryNetDecryptHelper)`
- `private void startTimer(int i, int i2, StDevice stDevice)`
- `private void stopTimer(int i)`
- `public void trackRemoveBondResult(StDevice stDevice, boolean z)`
- `public void createBond(StDevice stDevice, byte bArr)`
- `public void removeBond(StConnectDevice stConnectDevice, byte bArr)`
- `public P2pChannelPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback)`
