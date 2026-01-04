# StPairEventBus

*Пакет:* `com.upuphone.starrynet.strategy.pair`\n
*Источник:* `starrynet/strategy/pair/StPairEventBus.java`\n
*Тип:* Class

## Назначение
Класс StPairEventBus управляет логикой, связанной с StPairEventBus.

## Поля
- `String TAG`
- `Map mReceivers`

## Методы
- `public static StPairEventBus get()`
- `public static ArrayList lambda$register$0(Class cls)`
- `public void post(Object obj)`
- `public void register(Class cls, EventReceiver eventReceiver)`
- `public void unregister(Class cls, EventReceiver eventReceiver)`
- `private StPairEventBus()`
