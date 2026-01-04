# BluetoothGattResponse

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BluetoothGattResponse.java`\n
*Тип:* Class

## Назначение
Класс BluetoothGattResponse управляет логикой, связанной с BluetoothGattResponse.

## Поля
- `IBluetoothGattResponse response`

## Методы
- `public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i)`
- `public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i)`
- `public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2)`
- `public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4)`
- `public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i)`
- `public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2)`
- `public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3)`
- `public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3)`
- `public void onServiceChanged(BluetoothGatt bluetoothGatt)`
- `public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i)`
- `public BluetoothGattResponse(IBluetoothGattResponse iBluetoothGattResponse)`
