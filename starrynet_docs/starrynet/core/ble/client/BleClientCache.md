# BleClientCache

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BleClientCache.java`\n
*Тип:* Class

## Назначение
Класс BleClientCache управляет логикой, связанной с BleClientCache.

## Поля
- `String KEY_CHARACTER_CATEGORY`
- `String KEY_IS_CLIENT_REQUEST`
- `String KEY_MTU`
- `Map objectMap`

## Методы
- `private boolean getBoolean(String str, boolean z)`
- `public static BleClientCache getInstance()`
- `private int getInt(String str, int i)`
- `private void putBoolean(String str, boolean z)`
- `public void clearCharacterCategory(String str)`
- `public void clearMtu(String str)`
- `public int getCharacterCategory(String str)`
- `public int getMtuSize(String str)`
- `public boolean isClientConnected(String str)`
- `public boolean isClientReady(String str)`
- `public boolean isClientRequest(String str)`
- `public boolean isExternalDevice(String str)`
- `public void markExternalDevice(String str, boolean z)`
- `public void putClientConnected(String str, boolean z)`
- `public void putReadyClient(String str, boolean z)`
- `public void updateDiscoveryServiceInfo(String str, UUID uuid)`
- `public void updateIsClientRequest(String str, boolean z)`
- `public void updateMtu(String str, int i)`
- `private BleClientCache()`
