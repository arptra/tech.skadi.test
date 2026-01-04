# MdnsStateMachine

*Пакет:* `com.upuphone.starrynet.strategy.discovery.mdns`\n
*Источник:* `starrynet/strategy/discovery/mdns/MdnsStateMachine.java`\n
*Тип:* Class

## Назначение
Класс MdnsStateMachine управляет логикой, связанной с MdnsStateMachine.

## Поля
- `int MSG_RESTART_AVD`
- `int MSG_RESTART_SCAN`
- `int MSG_START_AVD`
- `int MSG_START_SCAN`
- `int MSG_STOP_AVD`
- `int MSG_STOP_SCAN`
- `String TAG`
- `State activeState`
- `Context mContext`
- `MdnsAdvertising mMdnsAdvertising`
- `MdnsDiscoveryImpl mMdnsDiscovery`

## Методы
- `public static MdnsStateMachine make(Context context, Looper looper)`
- `public void startAdvertising()`
- `public void startDiscovery()`
- `private MdnsStateMachine(Context context, Looper looper)`
