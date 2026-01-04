# IProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol`\n
*Источник:* `starrynet/strategy/protocol/IProtocol.java`\n
*Тип:* Interface

## Назначение
Класс IProtocol управляет логикой, связанной с IProtocol.

## Поля
- Нет объявленных полей.

## Методы
- `int connect(StDevice stDevice, int i)`
- `int disconnect(StDevice stDevice, int i)`
- `IMessageChannel getMessageChannel(StDevice stDevice)`
- `int getProfile()`
- `void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `void onRecv(StConnectDevice stConnectDevice, byte bArr, int i, IStarryNetChannel iStarryNetChannel)`
- `int sendMsg(StDevice stDevice, byte bArr)`
