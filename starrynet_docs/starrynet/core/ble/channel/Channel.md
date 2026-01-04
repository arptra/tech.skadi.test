# Channel

*Пакет:* `com.upuphone.starrynet.core.ble.channel`\n
*Источник:* `starrynet/core/ble/channel/Channel.java`\n
*Тип:* Class

## Назначение
Класс Channel управляет логикой, связанной с Channel.

## Поля
- `long CMD_TIMEOUT`
- `boolean DEBUG`
- `int MSG_WRITE_CALLBACK`
- `String TAG`
- `long TIMEOUT`
- `String TIMER_EXCEPTION`
- `int WANTED_MAX_PACKAGE_NUM`
- `byte mBytesToWrite`
- `Handler mCallback`
- `IChannel mChannel`
- `ChannelCallback mChannelCallback`
- `IChannel mChannelImpl`
- `ChannelState mCurrentState`
- `List mCurrentSync`
- `int mFrameCount`
- `byte mMixHeaderData`
- `int mPackageType`
- `SparseArray mPacketRecv`
- `IChannelStateHandler mRecvACKHandler`
- `IChannelStateHandler mRecvCTRHandler`
- `IChannelStateHandler mRecvDataHandler`
- `IChannelStateHandler mRecvFastACKHandler`
- `IChannelStateHandler mRecvFastCTRHandler`
- `IChannelStateHandler mRecvFastDataHandler`
- `IChannelStateHandler mRecvMixCTRHandler`
- `IChannelStateHandler mRecvSINGLEACKHandler`
- `IChannelStateHandler mRecvSingleCTRHandler`
- `IChannelStateHandler mRecvSingleNoAckCTRHandler`
- `IChannelStateHandler mSyncPacketHandler`
- `Timer mTimeoutHandler`
- `Timer mTimer`
- `int mTotalBytes`
- `IChannelStateHandler mWaitStartACKHandler`
- `IChannelStateHandler mWaitStartFastACKHandler`
- `IChannelStateHandler mWaitStartMngACKHandler`
- `IChannelStateHandler mWaitStartSingleACKHandler`
- `Handler mWorkerHandler`
- `ChannelStateBlock stateMachine`

## Методы
- `public static int access$1412(Channel channel, int i)`
- `public void assertRuntime(boolean z)`
- `private boolean checkCRC32(byte bArr, byte bArr2)`
- `public void dispatchOnReceive(byte bArr)`
- `private int getFrameCount(int i)`
- `public byte getTotalRecvdBytes()`
- `private boolean isExceptionTimerOn()`
- `private boolean isTimerOn()`
- `public boolean lambda$new$2(Message message)`
- `public void lambda$performBatchWrite$1(List list, ChannelCallback channelCallback)`
- `public void lambda$performWrite$0(byte bArr, WriteCallback writeCallback, boolean z)`
- `private boolean needCRC32Verify()`
- `public boolean onDataPacketRecvd(DataPacket dataPacket)`
- `private boolean onPostState(ChannelEvent channelEvent, Object objArr)`
- `public void onSendCallback(int i)`
- `private void performBatchWrite(List list, ChannelCallback channelCallback)`
- `public void performOnRead(byte bArr)`
- `public void performSend(int i, byte bArr, int i2, ChannelCallback channelCallback)`
- `public void performWrite(Packet packet, ChannelCallback channelCallback)`
- `public void receivePacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult)`
- `private void resetOnException()`
- `public void sendDataPacket(List list, boolean z)`
- `private void sendFastDataPacket(List list)`
- `private void sendMixControlData(byte bArr, int i)`
- `private void sendStartFlowPacket(int i, int i2, byte bArr)`
- `private void sendStartMixFlowPacket(int i, byte bArr, byte bArr2)`
- `public void setCurrentState(ChannelState channelState)`
- `private void startExceptionTimer()`
- `public void startSendFastData()`
- `public void startSyncPacket()`
- `public void startTimer()`
- `public void stopTimer()`
- `private boolean syncLostPacket()`
- `abstract public int getDMTU()`
- `abstract public int getMaxPackageNum()`
- `public byte handleTotalReceiveBytes(ByteBuffer byteBuffer, int i)`
- `public void log(String str, Object objArr)`
- `public void logError(String str, Object objArr)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `public void onRead(byte bArr)`
- `public void onReadPacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult)`
- `public void reset(int i)`
- `public void resetChannelStatus()`
- `public void send(int i, byte bArr, int i2, ChannelCallback channelCallback)`
- `abstract public boolean useCrc32Verify()`
- `public void wf(String str, Object objArr)`
- `private void performWrite(Packet packet, ChannelCallback channelCallback, boolean z)`
- `public void startTimer(long j)`
- `final public void send(byte bArr, int i, ChannelCallback channelCallback)`
- `public void startTimer(long j, Timer timerCallback)`
- `public Channel()`
