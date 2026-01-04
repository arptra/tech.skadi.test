# BleBatchWriteRequest

*Пакет:* `com.upuphone.starrynet.core.ble.client.request`\n
*Источник:* `starrynet/core/ble/client/request/BleBatchWriteRequest.java`\n
*Тип:* Class

## Назначение
Класс BleBatchWriteRequest управляет логикой, связанной с BleBatchWriteRequest.

## Поля
- `int DELAY_TIME`
- `int MSG_SEND_NEXT_DATA`
- `String TAG`
- `List dataBytes`
- `int dataSize`
- `ITryInterruptRequestCallback interruptRequestCallback`
- `boolean isWaitingOnWrite`
- `int totalWriteNum`

## Методы
- `private boolean isHighLevelRequest(UUID uuid, UUID uuid2)`
- `private boolean startWrite()`
- `public boolean checkNeedInterrupt()`
- `public long getTimeoutInMillis()`
- `public boolean handleMessage(Message message)`
- `public BleBatchWriteRequest interrupt()`
- `public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte bArr)`
- `public void processRequest()`
- `public void triggerCompleted()`
- `public void tryInterruptRequest(ITryInterruptRequestCallback iTryInterruptRequestCallback)`
- `public BleBatchWriteRequest(UUID uuid, UUID uuid2, List list, BleResponser bleResponser)`
