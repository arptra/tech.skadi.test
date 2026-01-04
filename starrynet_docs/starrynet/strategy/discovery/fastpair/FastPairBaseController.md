# FastPairBaseController

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/FastPairBaseController.java`\n
*Тип:* Class

## Назначение
Класс FastPairBaseController управляет логикой, связанной с FastPairBaseController.

## Поля
- `int RSSI_RECONNECT_MIN`
- `String TAG`
- `Context mContext`
- `StarryDeviceManager mDeviceManager`
- `StarryDeviceManager mDiscoveryDeviceManager`
- `FastPairHandler mHandler`
- `HandlerThread mHandlerThread`

## Методы
- `public boolean checkFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `abstract public void connectStDevice(StDevice stDevice)`
- `abstract public void dealAutoConnectTimeoutMessage(Message message)`
- `abstract public void dealBondFailMessage(Message message)`
- `abstract public void dealBondOkMessage(Message message)`
- `abstract public void dealClassicBondMessage(Message message)`
- `abstract public void dealClickCancelMessage(Message message)`
- `abstract public void dealClickConnectMessage(Message message)`
- `abstract public void dealConnectTimeoutMessage(Message message)`
- `abstract public void dealDismissWindowMessage(Message message)`
- `abstract public void dealDispatchToAppMessage(Message message)`
- `abstract public void dealRemoveBondMessage(Message message)`
- `abstract public void dealShowWindowMessage(Message message)`
- `abstract public boolean getPairing()`
- `public boolean isPopOrConnect(StDiscoveryDevice stDiscoveryDevice, int i)`
- `public void onBluetoothDisabled()`
- `abstract public void setPairing(boolean z)`
- `public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice)`
- `public FastPairBaseController(Context context)`
