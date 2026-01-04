# BleDataDispatcher

*Пакет:* `com.upuphone.starrynet.core.ble.manager`\n
*Источник:* `starrynet/core/ble/manager/BleDataDispatcher.java`\n
*Тип:* Class

## Назначение
Класс BleDataDispatcher управляет логикой, связанной с BleDataDispatcher.

## Поля
- `boolean DETAIL_LOG`
- `int MSG_ADD_DATA`
- `int MSG_DEAL_WITH_DATA`
- `int MSG_WAIT_TIMEOUT`
- `String TAG`
- `int WAIT_DONE_INTERVAL`
- `String mBleMac`
- `Handler mDispatchHandler`
- `ConcurrentLinkedQueue mQueue`
- `Handler mReceiveHandler`
- `List mReceivers`
- `boolean mWaitStickyDataDone`

## Методы
- `private void dispatchData()`
- `public void lambda$stickyDoneWithData$0(boolean z, int i, byte bArr)`
- `private void log(String str, Object objArr)`
- `private void notifyDealWithData()`
- `public void addReceiver(IBleDataReceiver iBleDataReceiver)`
- `public boolean handleMessage(Message message)`
- `public void receiveBleData(BleReceiveData bleReceiveData)`
- `public boolean removeReceiver(IBleDataReceiver iBleDataReceiver)`
- `public void reset()`
- `public void stickyDataDone()`
- `public void stickyDoneWithData(boolean z, int i, byte bArr)`
- `public BleDataDispatcher(String str, Looper looper, Looper looper2)`
