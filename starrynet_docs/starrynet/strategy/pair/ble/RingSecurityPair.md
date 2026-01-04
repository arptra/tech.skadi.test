# RingSecurityPair

*Пакет:* `com.upuphone.starrynet.strategy.pair.ble`\n
*Источник:* `starrynet/strategy/pair/ble/RingSecurityPair.java`\n
*Тип:* Class

## Назначение
Класс RingSecurityPair управляет логикой, связанной с RingSecurityPair.

## Поля
- `byte GATT_HEADER_SIZE`
- `String KEY_ALGORITHM`
- `String KEY_ASYMMETRIC`
- `String KEY_DEVICEINFO`
- `String KEY_ENCSWITCHINFO`
- `String KEY_HASH`
- `String KEY_IV`
- `String KEY_MACADDR`
- `String KEY_MODELID`
- `String KEY_PUBKEY`
- `String KEY_RANDOM`
- `byte OPCODE_PHONE_START_REMOVE_BOND`
- `byte OPCODE_RING_ENCRYPTED_DATA`
- `byte OPCODE_RING_ENCRYPTION_MODE`
- `byte OPCODE_RING_GET_FW_VER`
- `byte OPCODE_RING_GET_SN`
- `byte OPCODE_RING_PAIR`
- `byte OPCODE_RING_PAIR_SWITCH_INFO`
- `byte OPCODE_RING_PAIR_SWITCH_KEY`
- `byte RING_MSG_HEADER_SIZE`
- `byte SN_TLV_TAG_DEV_INFO`
- `byte SN_TLV_TAG_ENC_SWITCH_INFO`
- `byte SN_TLV_TAG_HASH`
- `byte SN_TLV_TAG_IV`
- `byte SN_TLV_TAG_MACADDR`
- `byte SN_TLV_TAG_MODELID`
- `byte SN_TLV_TAG_PUB_KEY`
- `byte SN_TLV_TAG_RANDOM`
- `String TAG`
- `byte gRandom`
- `byte padding`
- `byte staticKey`
- `byte mBytesRecv`
- `IMYVURingStatusCallback mPairStatusCallback`

## Методы
- `private static byte concatenate(byte bArr, byte bArr2)`
- `private static void crcValue(byte bArr)`
- `public static String debugByteArray(byte bArr)`
- `public static RingSecurityPair getInstance()`
- `private static byte getSecretKey(byte bArr, byte bArr2)`
- `private void handleServerKeyMsg(StDevice stDevice, byte bArr)`
- `private void handleServerSwitchInfoMsg(StDevice stDevice, byte bArr)`
- `public static String printByteArray(byte bArr)`
- `private void recombineFragment(int i, int i2, byte bArr)`
- `private void sendRemoteSwitchInfo(StDevice stDevice, byte bArr, byte bArr2)`
- `private void sendRingPairMsg(StDevice stDevice, byte b, byte bArr)`
- `public byte ClientDataDecrypt(byte bArr, StConnectDevice stConnectDevice)`
- `public byte ClientDataEncrypt(byte bArr, String str)`
- `public void clientCreateBond(StDevice stDevice)`
- `public void getFwVer(StConnectDevice stConnectDevice)`
- `public void getSN(StConnectDevice stConnectDevice)`
- `public void handleRingInternalMessage(StDevice stDevice, byte bArr)`
- `public void onResponse(StDevice stDevice, byte bArr, int i)`
- `public void registerPairStatusCallback(IMYVURingStatusCallback iMYVURingStatusCallback)`
- `public void sendRemoveBondCmd(StConnectDevice stConnectDevice)`
- `public void setEncryptionMode(StConnectDevice stConnectDevice, boolean z)`
- `private RingSecurityPair()`
