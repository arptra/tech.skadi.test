# StarryNetEncryptData

*Пакет:* `com.upuphone.starrynet.strategy.encrypt`\n
*Источник:* `starrynet/strategy/encrypt/StarryNetEncryptData.java`\n
*Тип:* Class

## Назначение
Класс StarryNetEncryptData управляет логикой, связанной с StarryNetEncryptData.

## Поля
- `String M_IV_PARAM_V2`
- `LruCache mKeyPairMap`
- `KeyPair mKeyPairV2`

## Методы
- `public static StarryNetEncryptData getInstance()`
- `public String getIvParamV2()`
- `public KeyPair getKeyPair(String str)`
- `public KeyPair getKeyPairV2()`
- `public void saveKeyPair(String str, KeyPair keyPair)`
- `public void setKeyPairV2(KeyPair keyPair)`
- `private StarryNetEncryptData()`
