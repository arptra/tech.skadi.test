# MyvuRingBleProtocol

*Пакет:* `com.upuphone.starrynet.strategy.protocol.simpleble`\n
*Источник:* `starrynet/strategy/protocol/simpleble/MyvuRingBleProtocol.java`\n
*Тип:* Class

## Назначение
Класс MyvuRingBleProtocol управляет логикой, связанной с MyvuRingBleProtocol.

## Поля
- `byte OPCODE_INTERNAL_CREATE_BOND`
- `byte OPCODE_INTERNAL_GET_FW_VER`
- `byte OPCODE_INTERNAL_GET_SN`
- `byte OPCODE_INTERNAL_INTERNAL_INFO_ALL_GOT`
- `byte OPCODE_RING_OPEN_ENCRYPTION`
- `byte OPCODE_RING_SHUTDOWN_ENCRYPTION`
- `byte PAIR_STATE_AUTH_FAIL`
- `byte PAIR_STATE_AUTH_SUCCESS`
- `byte STARRY_RING_INTERNAL_CMD`
- `byte STARRY_RING_INTERNAL_MESSAGE`
- `String TAG`
- `byte mProtocolOpcodeMap`
- `byte mProtocolOpcodeMapAlternative`
- `byte mProtocolPlainOpCodeMap`
- `boolean mEnableEncryptionMode`
- `boolean mInternalCmdDone`

## Методы
- `private boolean checkIfInternalProtocolMessage(byte b)`
- `private boolean checkIfInternalRingCmd(byte b)`
- `private boolean checkIfPlainOpCode(byte b)`
- `private void dealInternalRingCmd(byte b, StConnectDevice stConnectDevice)`
- `public static String getHexString(byte b)`
- `public int connect(StDevice stDevice, int i)`
- `public int disconnect(StDevice stDevice, int i)`
- `public StConnectDevice getConnectDevice(String str)`
- `public IMessageChannel getMessageChannel(StDevice stDevice)`
- `public int getProfile()`
- `public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2)`
- `public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel)`
- `public void onPairStatusChange(StDevice stDevice, int i, int i2)`
- `public void onPrivateCmdExchange(StDevice stDevice, int i, int i2)`
- `public void onRecv(StConnectDevice stConnectDevice, byte bArr, int i, IStarryNetChannel iStarryNetChannel)`
- `public void removeBond(StDevice stDevice)`
- `public void securityMessageSender(StDevice stDevice, byte bArr)`
- `public int sendMsg(StDevice stDevice, byte bArr)`
- `public MyvuRingBleProtocol()`
