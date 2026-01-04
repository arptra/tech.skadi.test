# BluetoothUtils

*Пакет:* `com.upuphone.starrynet.core.ble.utils`\n
*Источник:* `starrynet/core/ble/utils/BluetoothUtils.java`\n
*Тип:* Class

## Назначение
Класс BluetoothUtils управляет логикой, связанной с BluetoothUtils.

## Поля
- `String TAG`
- `BluetoothAdapter mBluetoothAdapter`
- `BluetoothManager mBluetoothManager`

## Методы
- `public static BluetoothAdapter getBluetoothAdapter()`
- `public static BluetoothManager getBluetoothManager()`
- `public static BluetoothDevice getRemoteDevice(String str)`
- `public static boolean isBleDeviceConnected(BluetoothDevice bluetoothDevice)`
- `public static boolean isBleDeviceDisconnected(String str)`
- `public static boolean isBleSupported()`
- `public static boolean isBluetoothEnabled()`
- `public static boolean refreshGattCache(BluetoothGatt bluetoothGatt)`
- `public static void registerBleStateReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter)`
- `private static void registerGlobalReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter)`
- `public static void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter)`
- `public static void registerReceiverCompatApi34(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter)`
- `public static void sendBroadcast(Intent intent)`
- `private static void sendGlobalBroadcast(Intent intent)`
- `public static void setBluetoothDeviceAliasName(String str, String str2)`
- `public static void sendBroadcast(String str)`
- `public static boolean isBleDeviceConnected(String str)`
