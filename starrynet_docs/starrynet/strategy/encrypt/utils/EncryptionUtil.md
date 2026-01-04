# EncryptionUtil

*Пакет:* `com.upuphone.starrynet.strategy.encrypt.utils`\n
*Источник:* `starrynet/strategy/encrypt/utils/EncryptionUtil.java`\n
*Тип:* Class

## Назначение
Класс EncryptionUtil управляет логикой, связанной с EncryptionUtil.

## Поля
- `String KEY_ALGORITHM`
- `String KEY_ASYMMETRIC`
- `String KEY_SYMMETRIC_V1`
- `String KEY_SYMMETRIC_V2`
- `String KEY_SYMMETRIC_V3`
- `String TAG`

## Методы
- `public static byte decrypt(byte bArr, byte bArr2, byte bArr3)`
- `public static byte decryptCTR(byte bArr, byte bArr2, byte bArr3)`
- `public static byte encrypt(byte bArr, byte bArr2, byte bArr3)`
- `public static byte encryptCTR(byte bArr, byte bArr2, byte bArr3)`
- `public static KeyPair generateECKeyPairByPublicKey(byte bArr)`
- `public static String generateIV()`
- `public static KeyPair generatorECKeyPair()`
- `public static byte getSecretKey(byte bArr, byte bArr2)`
- `public static String getSymmetric(int i)`
- `public static byte decrypt(byte bArr, byte bArr2, byte bArr3, int i)`
- `public static byte encrypt(byte bArr, byte bArr2, byte bArr3, int i)`
- `private EncryptionUtil()`
