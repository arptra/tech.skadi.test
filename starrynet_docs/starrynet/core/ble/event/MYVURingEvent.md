# MYVURingEvent

*Пакет:* `com.upuphone.starrynet.core.ble.event`\n
*Источник:* `starrynet/core/ble/event/MYVURingEvent.java`\n
*Тип:* Class

## Назначение
Класс MYVURingEvent управляет логикой, связанной с MYVURingEvent.

## Поля
- `int STATE_ACL_CONNECTED`
- `int STATE_ACL_DISCONNECTED`
- `int STATE_BONDED`
- `int STATE_BONDING`
- `int STATE_BT_STATE_CHANGE_OFF`
- `int STATE_BT_STATE_CHANGE_ON`
- `int STATE_HID_HOST_CONNECTED`
- `int STATE_HID_HOST_DISCONNECTED`
- `int STATE_RING_OFFLINE_REMOVE_BOND`
- `int STATE_UNBOND`
- `String bleMac`
- `BluetoothDevice device`
- `int state`

## Методы
- `public String getBleMac()`
- `public BluetoothDevice getDevice()`
- `public int getState()`
- `public MYVURingEvent(String str, int i)`
- `public MYVURingEvent(String str, int i, BluetoothDevice bluetoothDevice)`
