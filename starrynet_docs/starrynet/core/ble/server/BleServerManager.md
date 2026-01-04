# BleServerManager

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/BleServerManager.java`\n
*Тип:* Class

## Назначение
Класс BleServerManager управляет логикой, связанной с BleServerManager.

## Поля
- `String TAG`
- `IBleConnectManager sInstance`
- `BleServerRequestDispatcher mDispatcher`
- `Handler mHandler`
- `boolean mIsInit`

## Методы
- `public static IBleConnectManager getInstance()`
- `public void addServices(IGattCharacterService iGattCharacterService)`
- `public void disconnect(String str)`
- `public boolean handleMessage(Message message)`
- `public void init(GattServerConfig gattServerConfig)`
- `public void isCharacterNotify(String str, UUID uuid, Consumer consumer)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `public void openServer(OpenServerResponse openServerResponse)`
- `public void sendBatchNotifications(String str, UUID uuid, List list, BleNotificationResponse bleNotificationResponse)`
- `public void sendNotification(String str, UUID uuid, byte bArr, BleNotificationResponse bleNotificationResponse)`
- `public void sendNotificationAtOnce(String str, UUID uuid, byte bArr, BleNotificationResponse bleNotificationResponse)`
- `private BleServerManager()`
