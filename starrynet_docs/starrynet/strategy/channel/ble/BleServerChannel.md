# BleServerChannel

*Пакет:* `com.upuphone.starrynet.strategy.channel.ble`\n
*Источник:* `starrynet/strategy/channel/ble/BleServerChannel.java`\n
*Тип:* Class

## Назначение
Класс BleServerChannel управляет логикой, связанной с BleServerChannel.

## Поля
- `String TAG`
- `IBleDataReceiver mShortMessageReceiver`

## Методы
- `private void handleIOSNotificationEvent(boolean z, BleOpenNotifyEvent bleOpenNotifyEvent)`
- `private boolean isIOSCanDisableNotification(UUID uuid)`
- `private void onBleConnected(String str)`
- `private void onBleDisconnected(String str)`
- `private void onStarryNetData(BluetoothDevice bluetoothDevice, byte bArr, int i)`
- `private void onStarryNetMessage(byte bArr)`
- `private void receiveOpenNotifyEvent(BleOpenNotifyEvent bleOpenNotifyEvent)`
- `public int connect(StDevice stDevice)`
- `public int disconnect(StDevice stDevice)`
- `public int getProfile()`
- `public void init()`
- `public boolean isConnected(String str)`
- `public void onBleServerConnectChangeEvent(ServerConnectChangeEvent serverConnectChangeEvent)`
- `public void onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i)`
- `public void onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i, byte bArr)`
- `public void onEvent(Object obj)`
- `public void onRead(ChannelTag channelTag, byte bArr, int i)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public void setCallback(IChannelCallback iChannelCallback)`
- `public int sendMsg(StDevice stDevice, byte bArr, int i)`
- `public int sendMsg(StDevice stDevice, byte bArr, int i, IMessageCallback iMessageCallback)`
- `public int sendMsg(StDevice stDevice, byte bArr, IMessageCallback iMessageCallback)`
- `public int sendMsg(StDevice stDevice, boolean z, byte bArr, int i, IMessageCallback iMessageCallback)`
- `public BleServerChannel()`
