# ReceiveChannel

*Пакет:* `com.upuphone.starrynet.core.ble.channel`\n
*Источник:* `starrynet/core/ble/channel/ReceiveChannel.java`\n
*Тип:* Class

## Назначение
Класс ReceiveChannel управляет логикой, связанной с ReceiveChannel.

## Поля
- `ReceiveMessageListener mReceiveMsgListener`
- `Channel mSendChannel`

## Методы
- `public int getDMTU()`
- `public int getMaxPackageNum()`
- `public void onRecv(byte bArr, int i)`
- `public boolean useCrc32Verify()`
- `public void write(byte bArr, ChannelCallback channelCallback, boolean z)`
- `public void writeBatchData(List list, ChannelCallback channelCallback)`
- `public ReceiveChannel(Channel channel, ReceiveMessageListener receiveMessageListener)`
