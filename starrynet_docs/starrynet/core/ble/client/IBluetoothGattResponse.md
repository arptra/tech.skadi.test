# IBluetoothGattResponse

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/IBluetoothGattResponse.java`\n
*Тип:* Interface

## Назначение
Класс IBluetoothGattResponse управляет логикой, связанной с IBluetoothGattResponse.

## Поля
- Нет объявленных полей.

## Методы
- `void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte bArr)`
- `void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte bArr)`
- `void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte bArr)`
- `void onConnectionStateChange(int i, int i2)`
- `void onConnectionUpdate(int i, int i2)`
- `void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i)`
- `void onMtuChanged(int i, int i2)`
- `void onPhyRead(int i, int i2, int i3)`
- `void onPhyUpdate(int i, int i2, int i3)`
- `void onServiceChanged(BluetoothGatt bluetoothGatt)`
- `void onServicesDiscovered(int i)`
