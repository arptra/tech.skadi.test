# IPairChannel

*Пакет:* `com.upuphone.starrynet.strategy.pair`\n
*Источник:* `starrynet/strategy/pair/IPairChannel.java`\n
*Тип:* Interface

## Назначение
Класс IPairChannel управляет логикой, связанной с IPairChannel.

## Поля
- Нет объявленных полей.

## Методы
- `void disconnect(StDevice stDevice)`
- `void disconnectP2p(StDevice stDevice)`
- `void readMsg(StDevice stDevice, int i, byte bArr, IPairMsgCallback iPairMsgCallback)`
- `void sendMsg(StDevice stDevice, int i, byte bArr, IPairMsgCallback iPairMsgCallback)`
- `boolean sendP2pMsg(StConnectDevice stConnectDevice, byte bArr)`
- `void updateBondStateChanged(StDevice stDevice, int i)`
