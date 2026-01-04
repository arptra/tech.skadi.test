# SimpleBleProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.simpleble`\n
*Источник:* `starrynet/strategy/protocol/simpleble/SimpleBleProtocol.java`\n
*Тип:* Class

## Назначение
Класс SimpleBleProtocol управляет логикой, связанной с SimpleBleProtocol.

## Поля
- `String TAG`

## Методы
- `public void createOrRemoveBond(boolean z, BluetoothDevice bluetoothDevice)`
- `public int connect(StDevice stDevice, int i)`
- `public void createBond(StDevice stDevice)`
- `public int disconnect(StDevice stDevice, int i)`
- `public IMessageChannel getMessageChannel(StDevice stDevice)`
- `public int getProfile()`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public void onRecv(StConnectDevice stConnectDevice, byte bArr, int i, IStarryNetChannel iStarryNetChannel)`
- `public void removeBond(StDevice stDevice)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public SimpleBleProtocol()`
