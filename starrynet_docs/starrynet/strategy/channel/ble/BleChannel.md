# BleChannel

*Пакет:* `com.upuphone.starrynet.strategy.channel.ble`\n
*Источник:* `starrynet/strategy/channel/ble/BleChannel.java`\n
*Тип:* Class

## Назначение
Класс BleChannel управляет логикой, связанной с BleChannel.

## Поля
- `String TAG`
- `IChannelCallback mCallback`
- `List mConnectedCache`

## Методы
- `public boolean isConnected(String str)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public void setCallback(IChannelCallback iChannelCallback)`
- `public int sendMsg(StDevice stDevice, byte bArr, int i)`
- `public int sendMsg(StDevice stDevice, byte bArr, IMessageCallback iMessageCallback)`
- `public int sendMsg(StDevice stDevice, byte bArr, int i, IMessageCallback iMessageCallback)`
