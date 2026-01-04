# BleConnectRequest

*Пакет:* `com.upuphone.starrynet.core.ble.client.request`\n
*Источник:* `starrynet/core/ble/client/request/BleConnectRequest.java`\n
*Тип:* Class

## Назначение
Класс BleConnectRequest управляет логикой, связанной с BleConnectRequest.

## Поля
- `int CONNECT_TIMEOUT`
- `int DISCOVER_SERVICE_TIMEOUT`
- `int MSG_CONNECT`
- `int MSG_CONNECT_TIMEOUT`
- `int MSG_DISCOVER_SERVICE`
- `int MSG_DISCOVER_SERVICE_TIMEOUT`
- `int MSG_RETRY_DISCOVER_SERVICE`
- `int RETRY_TIMES`
- `int mConnectCount`
- `BleConnectConfig mConnectionConfig`
- `int mServiceDiscoverCount`

## Методы
- `private boolean doDiscoverService()`
- `private boolean doOpenNewGatt(BleConnectConfig bleConnectConfig)`
- `private void onConnectSuccess()`
- `private void onServiceDiscoverFailed()`
- `private void processConnect()`
- `private void processConnectTimeout()`
- `private void processDiscoverService()`
- `private void processDiscoverServiceTimeout()`
- `private boolean retryConnectIfNeeded()`
- `private void retryConnectLater()`
- `private void retryDiscoverServiceIfNeeded()`
- `private void retryDiscoverServiceLater()`
- `public boolean handleMessage(Message message)`
- `public boolean onConnectStatusChanged(boolean z)`
- `public void onServicesDiscovered(int i)`
- `public void processRequest()`
- `public BleConnectRequest(BleConnectConfig bleConnectConfig, BleResponser bleResponser)`
