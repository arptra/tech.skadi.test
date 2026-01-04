# StarryNetDecryptHelper

*Пакет:* `com.upuphone.starrynet.strategy.encrypt`\n
*Источник:* `starrynet/strategy/encrypt/StarryNetDecryptHelper.java`\n
*Тип:* Class

## Назначение
Класс StarryNetDecryptHelper управляет логикой, связанной с StarryNetDecryptHelper.

## Поля
- `String TAG`
- `StarryLinkEncrypt mCommand`
- `ByteString mData`
- `byte mIdentifier`

## Методы
- `public static byte decryptInfo(byte bArr, byte bArr2, int i)`
- `public static StarryNetDecryptHelper parse(byte bArr)`
- `public StarryLinkEncrypt getApInfo(byte bArr, int i)`
- `public StarryLinkEncrypt getCommand()`
- `public byte getData()`
- `public StarryLinkEncrypt getGcInfo(byte bArr, int i)`
- `public StarryLinkEncrypt getGoInfo(byte bArr, int i)`
- `public StarryLinkEncrypt getIOSConnectBt()`
- `public byte getIdentifier()`
- `public StarryLinkEncrypt getReadInfo(byte bArr, int i)`
- `public StarryLinkEncrypt getReadKey()`
- `public StarryLinkEncrypt getStaInfo(byte bArr, int i)`
- `public StarryLinkEncrypt getWriteInfo(byte bArr, int i)`
- `public StarryLinkEncrypt getWriteKey()`
- `public byte getData(byte bArr, int i)`
- `private StarryNetDecryptHelper(ByteString byteString, StarryLinkEncrypt command, ByteString byteString2)`
