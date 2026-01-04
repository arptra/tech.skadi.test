# PhoneStarryNetProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.starrynet`\n
*Источник:* `starrynet/strategy/protocol/starrynet/PhoneStarryNetProtocol.java`\n
*Тип:* Class

## Назначение
Класс PhoneStarryNetProtocol управляет логикой, связанной с PhoneStarryNetProtocol.

## Поля
- `int DELAY_TIME_BOND_BR`
- `int MSG_WAIT_SWITCH_VERSIONS_TIMEOUT`
- `String TAG`
- `int WAIT_RESPONSE_INTERVAL`

## Методы
- `private void doReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `public void lambda$openNotify$1(UUID uuid, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel, int i, Void voidR)`
- `public static void lambda$sendClearBondData$0(IStarryNetChannel iStarryNetChannel, StConnectDevice stConnectDevice, int i)`
- `private void onMessageReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `private void openNotify(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `private void openNotify4Config(String str)`
- `private void sendClearBondData(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `public void dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper)`
- `public int getProtocolConnectVersion()`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public boolean onDealVersionData(ProtocolVersions protocolVersions, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `public boolean onHandleMessage(Message message)`
- `public void onReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `private void openNotify(String str, UUID uuid)`
