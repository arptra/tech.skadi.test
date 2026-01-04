# BatchNotificationRequest

*Пакет:* `com.upuphone.starrynet.core.ble.server.request`\n
*Источник:* `starrynet/core/ble/server/request/BatchNotificationRequest.java`\n
*Тип:* Class

## Назначение
Класс BatchNotificationRequest управляет логикой, связанной с BatchNotificationRequest.

## Поля
- `int DELAY`
- `String TAG`
- `List dataBytes`
- `int dataSize`
- `ITryInterruptRequestCallback interruptRequestCallback`
- `boolean isWaitingOnSent`
- `UUID mCharacterUUID`
- `int totalWriteNum`

## Методы
- `private boolean isHighLevelRequest(UUID uuid)`
- `private boolean sendNotification()`
- `public boolean checkNeedInterrupt()`
- `public long getTimeoutInMillis()`
- `public BatchNotificationRequest interrupt()`
- `public void onNotificationSent(int i)`
- `public void processRequest()`
- `public void triggerCompleted()`
- `public void tryInterruptRequest(ITryInterruptRequestCallback iTryInterruptRequestCallback)`
- `public BatchNotificationRequest(String str, UUID uuid, List list, BleServerResponser bleServerResponser)`
