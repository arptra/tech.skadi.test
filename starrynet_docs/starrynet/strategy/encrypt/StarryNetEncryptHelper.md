# StarryNetEncryptHelper

*Пакет:* `com.upuphone.starrynet.strategy.encrypt`\n
*Источник:* `starrynet/strategy/encrypt/StarryNetEncryptHelper.java`\n
*Тип:* Class

## Назначение
Класс StarryNetEncryptHelper управляет логикой, связанной с StarryNetEncryptHelper.

## Поля
- `String TAG`

## Методы
- `public static byte bleServerRequestClientDisconnectConnection()`
- `private static StarryLinkEncrypt genLinkProtocol(StarryLinkEncrypt command)`
- `public static byte generate3rdBrEdrMac(byte bArr)`
- `public static byte generateActiveDisconnectP2p()`
- `public static byte generateAdapterNameChange(byte bArr)`
- `public static byte generateApConnected(byte bArr, byte bArr2, int i)`
- `public static byte generateApDisconnected(byte bArr, byte bArr2, int i)`
- `public static byte generateAuthMessage(byte bArr)`
- `public static byte generateAuthStatus()`
- `public static byte generateBleStateChangeData(int i, StConnectDevice stConnectDevice)`
- `public static byte generateBondMessage(byte bArr)`
- `public static byte generateBtConnectStateData(boolean z, StConnectDevice stConnectDevice)`
- `public static byte generateBtStateChangeData(int i, StConnectDevice stConnectDevice)`
- `public static byte generateCancelAuth()`
- `public static byte generateClearData()`
- `public static byte generateConnectAp(byte bArr, byte bArr2, int i)`
- `public static byte generateConnectGc(byte bArr, String str, boolean z, int i)`
- `public static byte generateConnectGo(byte bArr, String str, GoInfo goInfo, int i)`
- `public static byte generateCreateAp()`
- `public static byte generateDeviceInfo(StConnectDevice stConnectDevice)`
- `public static byte generateDeviceInfoSwitchData(StConnectDevice stConnectDevice)`
- `public static byte generateDeviceUnBondedData()`
- `public static byte generateDisconnectAp(byte bArr, byte bArr2, int i)`
- `public static byte generateDisconnectBle()`
- `public static byte generateDisconnectP2p()`
- `public static byte generateGcIpAddress(byte bArr)`
- `public static byte generateKeySwitchData(byte bArr, StConnectDevice stConnectDevice)`
- `public static byte generateNotifyWifiDisable()`
- `public static byte generateRemoteStarryNetStack(byte bArr)`
- `public static byte generateSppServerRequestConnectMessage()`
- `public static byte generateSppServerUUIDSyncMessage(byte bArr)`
- `public static byte getMasterEnsure()`
- `public static byte getMasterInfo(byte bArr, String str, int i)`
- `public static byte getMasterInfoViaWrite(byte bArr, String str, int i)`
- `public static byte getMasterKey(String str, String str2)`
- `public static byte getMasterKeyViaWrite(String str, String str2)`
- `private static StarryLinkEncrypt genLinkProtocol(StarryLinkEncrypt command, byte bArr)`
- `private StarryNetEncryptHelper()`
