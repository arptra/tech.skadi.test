# BleServerCache

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/BleServerCache.java`\n
*Тип:* Class

## Назначение
Класс BleServerCache управляет логикой, связанной с BleServerCache.

## Поля
- `String DEFAULT_OPEN_SERVER_DONE_KEY`
- `String DEFAULT_PHYSICS_CONNECT_STATUS_KEY`
- `String KEY_CHARACTER_CATEGORY`
- `String KEY_MTU`
- `String LOGIC_SERVER_CONNECT_4_IOS_KEY`
- `Map cache`

## Методы
- `public static BleServerCache getInstance()`
- `private int getInt(String str, int i)`
- `public void clearCharacterCategory(String str)`
- `public void clearMtu(String str)`
- `public void clearServerLogicConnected4IOS(String str)`
- `public int getCharacterCategory(String str)`
- `public synchronized int getMtu(String str)`
- `public int isServerLogicConnected4IOS(String str)`
- `public boolean isServerPhysicsConnected(String str)`
- `public boolean openServerDone()`
- `public synchronized void putActualMtu(String str, int i)`
- `public synchronized void putExpectedMtu(String str, int i)`
- `public void updateOpenNotifyUUID(String str, UUID uuid)`
- `public void updateOpenServerDone(boolean z)`
- `public void updatePhysicsConnectStatus(String str, boolean z)`
- `public void updateServerLogicConnected4IOS(String str, boolean z)`
- `private BleServerCache()`
