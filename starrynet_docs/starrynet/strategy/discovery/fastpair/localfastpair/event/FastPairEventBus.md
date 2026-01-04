# FastPairEventBus

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event`\n
*Источник:* `starrynet/strategy/discovery/fastpair/localfastpair/event/FastPairEventBus.java`\n
*Тип:* Class

## Назначение
Класс FastPairEventBus управляет логикой, связанной с FastPairEventBus.

## Поля
- `String TAG`
- `Map mReceivers`

## Методы
- `public static FastPairEventBus get()`
- `public static ArrayList lambda$register$0(Class cls)`
- `public void post(Object obj)`
- `public void register(Class cls, EventReceiver eventReceiver)`
- `public void unregister(Class cls, EventReceiver eventReceiver)`
