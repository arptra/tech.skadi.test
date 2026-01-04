# FastPairLocal

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/localfastpair/FastPairLocal.java`\n
*Тип:* Class

## Назначение
Класс FastPairLocal управляет логикой, связанной с FastPairLocal.

## Поля
- `String ACTION_PAIRING_CANCEL`
- `int CONNECT_TIMEOUT`
- `String SETTING_KEY_FAST_PAIR`
- `String SETTING_VALUE_NULL`
- `int STATE_CONNECTING`
- `int STATE_CONNECT_FAILED`
- `int STATE_CONNECT_SUCCESS`
- `String TAG`
- `StDevice mFastPairConnectDevice`
- `StDevice mFastPairShowDevice`

## Методы
- `private void trackConnection(StDevice stDevice)`
- `private void trackOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice)`
- `public void connectStDevice(StDevice stDevice)`
- `public void dealAutoConnectTimeoutMessage(Message message)`
- `public void dealClassicBondMessage(Message message)`
- `public void dealClickCancelMessage(Message message)`
- `public void dealDispatchToAppMessage(Message message)`
- `public void dealRemoveBondMessage(Message message)`
- `public void onBleConnected(StDevice stDevice)`
- `public void onBluetoothDisabled()`
- `public void onBrEdrConnected(StDevice stDevice)`
- `public void resetDeviceConnectState()`
- `public void updateForBondOk(byte bArr)`
- `public void updateForConnectTimeout(StDiscoveryDevice stDiscoveryDevice)`
- `public FastPairLocal(Context context)`
