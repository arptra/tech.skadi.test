# RingConnectStateEvent

*Пакет:* `com.upuphone.starrynet.core.ble.event`\n
*Источник:* `starrynet/core/ble/event/RingConnectStateEvent.java`\n
*Тип:* Class

## Назначение
Класс RingConnectStateEvent управляет логикой, связанной с RingConnectStateEvent.

## Поля
- `int STATE_ACL_CONNECTED`
- `int STATE_ACL_DISCONNECTED`
- `int STATE_BLE_CONNECTED`
- `int STATE_BONDED`
- `int STATE_BT_OFF`
- `int STATE_HID_HOST_CONNECTED`
- `int STATE_RING_ACL_CONNECTED`
- `int STATE_RING_ACL_DISCONNECTED`
- `int STATE_RING_BONDED`
- `int STATE_RING_UNBONDED`
- `String bleMac`
- `BluetoothDevice device`
- `int state`

## Методы
- `public String getBleMac()`
- `public BluetoothDevice getDevice()`
- `public int getState()`
- `public RingConnectStateEvent(String str, int i)`
- `public RingConnectStateEvent(String str, int i, BluetoothDevice bluetoothDevice)`
