# DiscoveryActionObserver

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/DiscoveryActionObserver.java`\n
*Тип:* Class

## Назначение
Класс DiscoveryActionObserver управляет логикой, связанной с DiscoveryActionObserver.

## Поля
- `String ACTION_BT_OPP_DATA_CHANGED`
- `int DIRECTION_BLUETOOTH_COMPLETED`
- `int DIRECTION_BLUETOOTH_INCOMING`
- `int DIRECTION_BLUETOOTH_OUTGOING`
- `int DIRECTION_BLUETOOTH_UNKOWN`
- `String EXTRA_BT_OPP_TRANSFER_DIRECTION`
- `String TAG`
- `List mStateChangeCallback`

## Методы
- `public static DiscoveryActionObserver getInstance()`
- `public void init(Context context)`
- `public void regDiscoveryActionCallback(DiscoveryStateChangeCallback discoveryStateChangeCallback)`
- `public void unregDiscoveryActionCallback(DiscoveryStateChangeCallback discoveryStateChangeCallback)`
