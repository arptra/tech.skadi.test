# BleClientChannel

*Пакет:* `com.upuphone.starrynet.strategy.channel.ble`\n
*Источник:* `starrynet/strategy/channel/ble/BleClientChannel.java`\n
*Тип:* Class

## Назначение
Класс BleClientChannel управляет логикой, связанной с BleClientChannel.

## Поля
- `String TAG`
- `List prepareConnectMacList`

## Методы
- `private static BleConnectConfig getBleConnectConfig(StDevice stDevice, String str)`
- `public void lambda$connectBle$0(StDevice stDevice, int i, Bundle bundle)`
- `public void lambda$requestMtu$1(String str, int i, Integer num)`
- `private void onBleConnected(String str)`
- `private void onBleDisconnected(String str, int i)`
- `private void onConnectResult(StDevice stDevice, int i, String str)`
- `private void openNotify(String str, UUID uuid)`
- `private void openNotify4Message(String str)`
- `private void requestMtu(String str)`
- `private void trackDisconnect(StConnectDevice stConnectDevice, int i)`
- `public int connect(StDevice stDevice)`
- `public synchronized void connectBle(StDevice stDevice)`
- `public int disconnect(StDevice stDevice)`
- `public int getProfile()`
- `public boolean isConnected(String str)`
- `public void onBleClientConnectChangeEvent(ClientConnectChangeEvent clientConnectChangeEvent)`
- `public void onEvent(Object obj)`
- `public void onRead(ChannelTag channelTag, byte bArr, int i)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public void setCallback(IChannelCallback iChannelCallback)`
- `public int sendMsg(StDevice stDevice, byte bArr, int i)`
- `public int sendMsg(StDevice stDevice, byte bArr, int i, IMessageCallback iMessageCallback)`
- `public int sendMsg(StDevice stDevice, byte bArr, IMessageCallback iMessageCallback)`
- `public int sendMsg(StDevice stDevice, boolean z, byte bArr, int i, IMessageCallback iMessageCallback)`
- `public BleClientChannel()`
