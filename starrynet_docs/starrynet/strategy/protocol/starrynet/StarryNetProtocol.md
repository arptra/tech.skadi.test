# StarryNetProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.starrynet`\n
*Источник:* `starrynet/strategy/protocol/starrynet/StarryNetProtocol.java`\n
*Тип:* Class

## Назначение
Класс StarryNetProtocol управляет логикой, связанной с StarryNetProtocol.

## Поля
- `int PROTOCOL_CONNECT_VERSION_CURRENT`
- `int PROTOCOL_ENCRYPT_TYPE_SUPPORT`
- `String TAG`
- `boolean isP2PGoRole`
- `int mDefaultPort`
- `IPublisher mP2pMsgHandler`
- `boolean mP2pMutualAp`
- `StarryNetPairManager mPair`
- `boolean mPublisherRegister`
- `Map mReadyChannelMap`

## Методы
- `private void dealJsonData(byte bArr, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `public void dealP2pActiveDisconnect(StConnectDevice stConnectDevice)`
- `public void dealP2pDisconnect(StConnectDevice stConnectDevice)`
- `private int getConnectProfile(int i)`
- `private StConnectDevice getStConnectDevice(StConnectDevice stConnectDevice, byte bArr)`
- `private boolean notifyApMutual()`
- `private void processRemoteStarryNetStackAction(StConnectDevice stConnectDevice, byte bArr)`
- `private boolean starryNetStackActionLoad(android r5, com r6)`
- `private boolean starryNetStackActionUnload(Bundle bundle, StConnectDevice stConnectDevice)`
- `private void trackOfflineRemoveBondResult(StDevice stDevice)`
- `public int cancelAuth(StDevice stDevice)`
- `public int connect(StDevice stDevice, int i)`
- `public void connectP2p(StConnectDevice stConnectDevice)`
- `public int createBond(StDevice stDevice)`
- `public void dealGcIpMsg(StConnectDevice stConnectDevice, byte bArr)`
- `public boolean deviceP2pMutualAp()`
- `public void disableWifiAp()`
- `public int disconnect(StDevice stDevice, int i)`
- `public void disconnectP2p(StDevice stDevice)`
- `public IMessageChannel getMessageChannel(StDevice stDevice)`
- `public String getP2pMacAddress()`
- `public int getProfile()`
- `public int getProtocolConnectVersion()`
- `public IStarryNetChannel getReadyChannel(String str)`
- `public void init()`
- `public boolean isP2PGoRole()`
- `public boolean isWifiApOpen()`
- `public boolean needDeviceSwitch(StDevice stDevice)`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public boolean onDealVersionData(ProtocolVersions protocolVersions, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public void onReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel)`
- `public void onRecv(StConnectDevice stConnectDevice, byte bArr, int i, IStarryNetChannel iStarryNetChannel)`
- `public void readMsg(StDevice stDevice, int i, byte bArr, IPairMsgCallback iPairMsgCallback)`
- `public void regRemoveDeviceBroadcast(Context context)`
- `public IPublisher registerPublisher(IPublisher iPublisher)`
- `public int removeBond(StDevice stDevice)`
- `public int requestAuth(StDevice stDevice, byte bArr)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public boolean sendP2pMsg(StConnectDevice stConnectDevice, byte bArr)`
- `public int sendStarryNetMsg(StDevice stDevice, byte bArr)`
- `public void setDefaultPort(int i)`
- `public void setProtocolCallback(IProtocolCallback iProtocolCallback)`
- `public boolean starryNetStackActionCmd(int i, Bundle bundle, StConnectDevice stConnectDevice)`
- `public void starryNetStackSyncCaps(StConnectDevice stConnectDevice, int i)`
- `public void startSppServerListen(StConnectDevice stConnectDevice)`
- `public void stopSppChannel(StConnectDevice stConnectDevice, int i)`
- `public void sysP2pMacAddress(StConnectDevice stConnectDevice, String str)`
- `public void updateBondStateChanged(StDevice stDevice, int i)`
- `public void disconnect(StDevice stDevice)`
- `public void sendMsg(StDevice stDevice, int i, byte bArr, IPairMsgCallback iPairMsgCallback)`
- `public int sendStarryNetMsg(StDevice stDevice, byte bArr, IMessageCallback iMessageCallback)`
- `public StarryNetProtocol()`
