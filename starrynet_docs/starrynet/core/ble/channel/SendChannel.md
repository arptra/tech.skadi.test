# SendChannel

*Пакет:* `com.upuphone.starrynet.core.ble.channel`\n
*Источник:* `starrynet/core/ble/channel/SendChannel.java`\n
*Тип:* Class

## Назначение
Класс SendChannel управляет логикой, связанной с SendChannel.

## Поля
- `int ATT_HEADER`
- `int DEFAULT_MTU_SIZE`
- `int DMTU_OFFSET`
- `int HANDLE_CTR_TIMEOUT_INTERVAL`
- `int MAX_MTU_SIZE`
- `int MAX_PACKAGE_NUM`
- `int MSG_ADD_PACKET`
- `int MSG_HANDLE_CTR_TIMEOUT`
- `int MSG_HANDLE_PACKET`
- `ChannelManager channelManager`
- `AtomicBoolean isReceivingCTR`
- `Handler mHandler`
- `Handler mMsgCallback`
- `ReceiveChannel mReceiveChannel`
- `LinkedList mReceiveQueue`
- `List readers`
- `ChannelTag tag`
- `boolean useCrc32`
- `IBleChannelWriter writer`

## Методы
- `private void handleReceivePacket()`
- `public boolean lambda$new$0(Message message)`
- `public void addReader(IBleChannelReader iBleChannelReader)`
- `public void destroy()`
- `public int getDMTU()`
- `public int getMaxPackageNum()`
- `public void onRead(byte bArr)`
- `public void onRecv(byte bArr, int i)`
- `public void removeReader(IBleChannelReader iBleChannelReader)`
- `public void reset(int i)`
- `public boolean useCrc32Verify()`
- `public void write(byte bArr, ChannelCallback channelCallback, boolean z)`
- `public void writeBatchData(List list, ChannelCallback channelCallback)`
- `public SendChannel(ChannelTag channelTag, ChannelManager channelManager2, boolean z)`
