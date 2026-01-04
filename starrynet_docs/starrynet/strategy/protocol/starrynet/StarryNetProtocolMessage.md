# StarryNetProtocolMessage

*Пакет:* `com.upuphone.starrynet.strategy.protocol.starrynet`\n
*Источник:* `starrynet/strategy/protocol/starrynet/StarryNetProtocolMessage.java`\n
*Тип:* Class

## Назначение
Класс StarryNetProtocolMessage управляет логикой, связанной с StarryNetProtocolMessage.

## Поля
- `int CREATE_BOND_WAIT_RETRY_TIMES`
- `int DELAY_CREATE_BOND_WAIT`
- `int DELAY_TIMEOUT_AUTH`
- `int DELAY_XR_TIMEOUT_AUTH`
- `int MSG_ON_AUTH`
- `int MSG_ON_AUTH_TIMEOUT`
- `int MSG_ON_CREATE_BOND_WAIT`
- `int MSG_STARR_NET`
- `String TAG`
- `IProtocolCallback mCallback`
- `Context mContext`
- `int mCreateBondWaitRetry`
- `Handler mHandler`

## Методы
- `private void dealConnectApMsg(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealConnectGoMsg(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealConnectedApMsg(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealCreateApMsg(StConnectDevice stConnectDevice)`
- `private void dealDisconnectApMsg(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealDisconnectedApMsg(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealGcConnectMsg(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealGcDisconnectMsg(StConnectDevice stConnectDevice)`
- `private void dealOnAuthMsg(Message message)`
- `private void dealOnAuthTimeout(Message message)`
- `private boolean dealStarryNetStackCmd(StConnectDevice stConnectDevice, byte bArr)`
- `private void dealSyncThirdMac(StConnectDevice stConnectDevice, byte bArr)`
- `public void dealWithMessage(Message message)`
- `abstract public int connect(StDevice stDevice, int i)`
- `public void dealGcIpMsg(StConnectDevice stConnectDevice, byte bArr)`
- `public void dealPeerNameChange(StConnectDevice stConnectDevice, byte bArr)`
- `public void dealPeerWifiDisable(StConnectDevice stConnectDevice)`
- `public void dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper)`
- `abstract public int disconnect(StDevice stDevice, int i)`
- `public boolean filterFastPairFlag(StConnectDevice stConnectDevice)`
- `public String getP2pMacAddress()`
- `abstract public IStarryNetChannel getReadyChannel(String str)`
- `public boolean isP2PGoRole()`
- `public void onConnected(StConnectDevice stConnectDevice, int i)`
- `public void onDisconnected(StConnectDevice stConnectDevice, int i)`
- `public boolean onHandleMessage(Message message)`
- `public void startSppServerListen(StConnectDevice stConnectDevice)`
- `public void stopSppChannel(StConnectDevice stConnectDevice, int i)`
- `public void sysP2pMacAddress(StConnectDevice stConnectDevice, String str)`
