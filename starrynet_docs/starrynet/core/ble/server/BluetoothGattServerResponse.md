# BluetoothGattServerResponse

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/BluetoothGattServerResponse.java`\n
*Тип:* Class

## Назначение
Класс BluetoothGattServerResponse управляет логикой, связанной с BluetoothGattServerResponse.

## Поля
- `IBleGattServerResponse mResponse`

## Методы
- `public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte bArr)`
- `public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2)`
- `public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte bArr)`
- `public void onMtuChanged(BluetoothDevice bluetoothDevice, int i)`
- `public void onNotificationSent(BluetoothDevice bluetoothDevice, int i)`
- `public void onPhyRead(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `public void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `public void onServiceAdded(int i, BluetoothGattService bluetoothGattService)`
- `public BluetoothGattServerResponse(IBleGattServerResponse iBleGattServerResponse)`
