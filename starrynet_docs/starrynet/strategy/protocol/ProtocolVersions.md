# ProtocolVersions

*Пакет:* `com.upuphone.starrynet.strategy.protocol`\n
*Источник:* `starrynet/strategy/protocol/ProtocolVersions.java`\n
*Тип:* Class

## Назначение
Класс ProtocolVersions управляет логикой, связанной с ProtocolVersions.

## Поля
- `String PROTOCOL_KEY_BLE_VERSION`
- `String PROTOCOL_KEY_CATEGORY_ID`
- `String PROTOCOL_KEY_CONNECTION_VERSION`
- `String PROTOCOL_KEY_ENCRYPT_TYPE`
- `String PROTOCOL_KEY_IDENTIFIER`
- `String PROTOCOL_KEY_MAX_MTU_SIZE`
- `String TAG`
- `int bleVersion`
- `String categoryID`
- `int connectVersion`
- `int encryptType`
- `int maxMtuSize`
- `String selfIdentifier`

## Методы
- `public static byte buildBytesFromVersions(ProtocolVersions protocolVersions)`
- `public static ProtocolVersions buildOwnVersions()`
- `public static ProtocolVersions buildResponseVersions(ProtocolVersions protocolVersions)`
- `public static ProtocolVersions parseJson(String str)`
- `public int getBleVersion()`
- `public String getCategoryID()`
- `public int getConnectVersion()`
- `public int getEncryptType()`
- `public int getMaxMtuSize()`
- `public String getSelfIdentifier()`
- `public void setBleVersion(int i)`
- `public void setCategoryID(String str)`
- `public void setConnectVersion(int i)`
- `public void setEncryptType(int i)`
- `public void setMaxMtuSize(int i)`
- `public void setSelfIdentifier(String str)`
- `public ProtocolVersions(String str)`
