# BleAppJudgment

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/appfastpair/BleAppJudgment.java`\n
*Тип:* Class

## Назначение
Класс BleAppJudgment управляет логикой, связанной с BleAppJudgment.

## Поля
- `int RSSI_FAST_PAIR_MIN`
- `String TAG`
- `StDiscoveryDevice mDevice`
- `StarryDeviceManager mDeviceManager`

## Методы
- `private void changeToUnBondSate(StConnectDevice stConnectDevice)`
- `public int dealReceiveDefaultOrOtherMac(StConnectDevice stConnectDevice)`
- `public int dealReceivePeerMac(StConnectDevice stConnectDevice)`
- `public int isBlePop()`
- `public int padBlePop(com r7)`
- `public int resetBondState(StConnectDevice stConnectDevice)`
- `public BleAppJudgment(StDiscoveryDevice stDiscoveryDevice)`
