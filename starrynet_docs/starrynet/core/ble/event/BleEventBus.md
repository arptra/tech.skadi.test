# BleEventBus

*Пакет:* `com.upuphone.starrynet.core.ble.event`\n
*Источник:* `starrynet/core/ble/event/BleEventBus.java`\n
*Тип:* Class

## Назначение
Класс BleEventBus управляет логикой, связанной с BleEventBus.

## Поля
- `String TAG`
- `Map mReceivers`

## Методы
- `public static BleEventBus get()`
- `public static ArrayList lambda$register$0(Class cls)`
- `public void post(Object obj)`
- `public void register(Class cls, EventReceiver eventReceiver)`
- `public void unregister(Class cls, EventReceiver eventReceiver)`
- `private BleEventBus()`
