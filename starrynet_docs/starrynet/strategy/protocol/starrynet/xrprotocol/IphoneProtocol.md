# IphoneProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol`\n
*Источник:* `starrynet/strategy/protocol/starrynet/xrprotocol/IphoneProtocol.java`\n
*Тип:* Class

## Назначение
Класс IphoneProtocol управляет логикой, связанной с IphoneProtocol.

## Поля
- `int MSG_IOS_CONNECT_TIMEOUT`
- `String TAG`
- `Handler mHandler`
- `Set mIOSBondCancelOrTimeOutSet`
- `XRStarryNetProtocol mXrProtocol`

## Методы
- `private void dealBluetoothConnect(StConnectDevice stConnectDevice)`
- `private BluetoothDevice findConnectIOSDevice(BrEdrChannel brEdrChannel, StarryLinkEncrypt iOSConnectBt)`
- `private void handleConnectBrEdrFromClient(StarryNetDecryptHelper starryNetDecryptHelper)`
- `private void handleIosConnectBt(StConnectDevice stConnectDevice, StarryLinkEncrypt iOSConnectBt)`
- `private void syncIosBrEdrMac(StConnectDevice stConnectDevice, BluetoothDevice bluetoothDevice, BrEdrChannel brEdrChannel)`
- `private boolean triggerBondCancelOrTimeout(StConnectDevice stConnectDevice)`
- `public void cancelIosBtTimeout()`
- `public boolean dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper)`
- `public int getTargetTerminalType()`
- `public void notifyBtStateToIos(StConnectDevice stConnectDevice)`
- `public void onBleServerConnected(StConnectDevice stConnectDevice)`
- `public boolean onBleServerDisconnected(StConnectDevice stConnectDevice)`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public IphoneProtocol(XRStarryNetProtocol xRStarryNetProtocol)`
