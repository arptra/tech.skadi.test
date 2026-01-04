# BleReceiveMsgManager

*Пакет:* `com.upuphone.starrynet.core.ble.manager`\n
*Источник:* `starrynet/core/ble/manager/BleReceiveMsgManager.java`\n
*Тип:* Class

## Назначение
Класс BleReceiveMsgManager управляет логикой, связанной с BleReceiveMsgManager.

## Поля
- `int MSG_RECEIVE_DATA`
- `int MSG_STICKY_DATA_DONE`
- `Map dispatcherMap`
- `Handler mDispatchHandler`
- `Handler mReceiveHandler`

## Методы
- `public static BleReceiveMsgManager getInstance()`
- `public boolean handleMessage(Message message)`
- `public BleDataDispatcher makeInstance(String str)`
- `public void notifyStickyDataDone(String str)`
- `public void receiveBleData(BleReceiveData bleReceiveData)`
- `public void registerBleDataReceiver(String str, IBleDataReceiver iBleDataReceiver)`
- `public void resetDispatcher(String str)`
- `public void unregisterBleDataReceiver(String str, IBleDataReceiver iBleDataReceiver)`
- `public void notifyStickyDataDone(boolean z, String str, int i, byte bArr)`
- `private BleReceiveMsgManager()`
