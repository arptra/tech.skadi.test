# ChannelManager

*Пакет:* `com.upuphone.starrynet.core.ble.channel`\n
*Источник:* `starrynet/core/ble/channel/ChannelManager.java`\n
*Тип:* Class

## Назначение
Класс ChannelManager управляет логикой, связанной с ChannelManager.

## Поля
- `int ATT_HEADER`
- `int DEFAULT_MTU_SIZE`
- `int DMTU_OFFSET`
- `int MAX_MTU_SIZE`
- `int MAX_PACKAGE_NUM`
- `IBleChannelReader mBleReader`
- `ConcurrentMap mChannels`
- `Map writerMap`

## Методы
- `public synchronized SendChannel getChannel(ChannelTag channelTag)`
- `abstract public int getDMTU(String str)`
- `public IBleChannelWriter getWriterByMac(ChannelTag channelTag)`
- `abstract public boolean isClient()`
- `public void log(String str, Object objArr)`
- `public void onBleConnected(String str)`
- `public void onBleDisconnected(String str)`
- `abstract public void receiveData(ChannelTag channelTag, byte bArr, int i)`
- `public synchronized IBleChannelWriter registerChannelReader(ChannelTag channelTag, IBleChannelReader iBleChannelReader)`
- `public synchronized SendChannel removeChannel(ChannelTag channelTag)`
- `public void resetChannelState(String str)`
- `public synchronized void unregisterChannelReader(ChannelTag channelTag, IBleChannelReader iBleChannelReader)`
- `abstract public boolean useCrc32Verify()`
- `abstract public void writeBatchBleData(ChannelTag channelTag, List list, ChannelCallback channelCallback)`
- `abstract public void writeBle(ChannelTag channelTag, byte bArr, ChannelCallback channelCallback, boolean z)`
