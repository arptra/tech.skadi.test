# IChannel

*Пакет:* `com.upuphone.starrynet.core.ble.channel`\n
*Источник:* `starrynet/core/ble/channel/IChannel.java`\n
*Тип:* Interface

## Назначение
Класс IChannel управляет логикой, связанной с IChannel.

## Поля
- `int SENSE_BLE_DISCONNECT`
- `int SENSE_NORMAL`

## Методы
- `void onRead(byte bArr)`
- `void onReadPacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult)`
- `void onRecv(byte bArr, int i)`
- `void reset(int i)`
- `void send(int i, byte bArr, int i2, ChannelCallback channelCallback)`
- `void send(byte bArr, int i, ChannelCallback channelCallback)`
- `void write(byte bArr, ChannelCallback channelCallback, boolean z)`
- `void writeBatchData(List list, ChannelCallback channelCallback)`
