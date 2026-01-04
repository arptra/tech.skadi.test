# BleChannelPair

*Пакет:* `com.upuphone.starrynet.strategy.pair.ble`\n
*Источник:* `starrynet/strategy/pair/ble/BleChannelPair.java`\n
*Тип:* Class

## Назначение
Класс BleChannelPair управляет логикой, связанной с BleChannelPair.

## Поля
- `String TAG`
- `IPairChannel mChannel`
- `PairMsgHandler mPairMsgHandler`
- `StarryNetPairProcess mPairProcess`
- `IPairStatusCallback mPairStatusCallback`

## Методы
- `private void handleBondMsgFromClient(StarryNetDecryptHelper starryNetDecryptHelper)`
- `private void handleBondMsgFromServer(StarryNetDecryptHelper starryNetDecryptHelper)`
- `private void handleClientInfoMsg(StarryNetDecryptHelper starryNetDecryptHelper, String str)`
- `private void handleClientKeyMsg(StarryNetDecryptHelper starryNetDecryptHelper)`
- `private void handleClientUnPair(StarryNetDecryptHelper starryNetDecryptHelper, String str)`
- `public void handleMsgFromClient(StarryNetDecryptHelper starryNetDecryptHelper, String str)`
- `public void handleMsgFromServer(StarryNetDecryptHelper starryNetDecryptHelper, StDevice stDevice)`
- `private void handleServerInfoMsg(StarryNetDecryptHelper starryNetDecryptHelper, String str)`
- `private void handleServerKeyMsg(StarryNetDecryptHelper starryNetDecryptHelper, StDevice stDevice)`
- `public void onAuthResult(StDevice stDevice, int i, int i2)`
- `public void processPairFailMsg(int i, int i2, StDevice stDevice)`
- `private void startTimer(int i, int i2, StDevice stDevice)`
- `public void stopTimer(int i)`
- `public void trackRemoveBondResult(StDevice stDevice, boolean z)`
- `public void trackSwitchInfoResult(StDevice stDevice, int i, int i2)`
- `public void trackSwitchKeyResult(StDevice stDevice, int i, int i2)`
- `private void updateKey(StDevice stDevice, int i, byte bArr)`
- `public void clientCreateBond(StDevice stDevice, byte bArr)`
- `public void clientRemoveBond(StConnectDevice stConnectDevice)`
- `public void createBond(StDevice stDevice, byte bArr)`
- `public void onResponse(StDevice stDevice, byte bArr, int i)`
- `public void removeBond(StConnectDevice stConnectDevice, byte bArr)`
- `public void serverCreateBond(StDevice stDevice, byte bArr)`
- `public void serverRemoveBond(StConnectDevice stConnectDevice)`
- `public BleChannelPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback)`
