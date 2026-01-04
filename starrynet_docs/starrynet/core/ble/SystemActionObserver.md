# SystemActionObserver

*Пакет:* `com.upuphone.starrynet.core.ble`\n
*Источник:* `starrynet/core/ble/SystemActionObserver.java`\n
*Тип:* Class

## Назначение
Класс SystemActionObserver управляет логикой, связанной с SystemActionObserver.

## Поля
- `String TAG`
- `boolean isBluetoothOn`
- `boolean isScreenOn`
- `BluetoothAdapter mAdapter`
- `Handler mHandler`
- `List mStateChangeCallback`

## Методы
- `public static SystemActionObserver getInstance()`
- `public void onBluetoothStateChange(Intent intent)`
- `public void enableBluetooth()`
- `public SystemActionObserver init(Context context)`
- `public boolean isBtOn()`
- `public boolean isScreenOn()`
- `public void registerSystemActionCallback(SystemActionChangedCallback systemActionChangedCallback)`
- `public void unregisterSystemActionCallback(SystemActionChangedCallback systemActionChangedCallback)`
- `private SystemActionObserver()`
