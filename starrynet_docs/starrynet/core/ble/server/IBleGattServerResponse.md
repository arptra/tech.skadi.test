# IBleGattServerResponse

*Пакет:* `com.upuphone.starrynet.core.ble.server`\n
*Источник:* `starrynet/core/ble/server/IBleGattServerResponse.java`\n
*Тип:* Interface

## Назначение
Класс IBleGattServerResponse управляет логикой, связанной с IBleGattServerResponse.

## Поля
- Нет объявленных полей.

## Методы
- `void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic)`
- `void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte bArr)`
- `void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2)`
- `void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte bArr)`
- `void onMtuChanged(BluetoothDevice bluetoothDevice, int i)`
- `void onNotificationSent(BluetoothDevice bluetoothDevice, int i)`
- `void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `void onReadPhy(BluetoothDevice bluetoothDevice, int i, int i2, int i3)`
- `void onServiceAdded(int i, BluetoothGattService bluetoothGattService)`
