# RingReconnBackgroundScanManager

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/RingReconnBackgroundScanManager.java`\n
*Тип:* Class

## Назначение
Класс RingReconnBackgroundScanManager управляет логикой, связанной с RingReconnBackgroundScanManager.

## Поля
- `int DISCONNECT_TYPE_ACTIVE`
- `int DISCONNECT_TYPE_PASSIVE`
- `int OP_BACKGROUND_SCAN_STATUS_CHANGE_START`
- `int OP_BACKGROUND_SCAN_STATUS_CHANGE_STOP`
- `int OP_BACKGROUND_SCAN_STATUS_CHECK`
- `int OP_SCREEN_STATE_CHANGE_OFF`
- `int OP_SCREEN_STATE_CHANGE_ON`
- `int OP_SCREEN_STATE_CHECK`
- `int SCAN_TIMEOUT`
- `String TAG`
- `StConnectDevice mBondedRing`
- `StarryDeviceManager mDeviceManager`
- `boolean mIsBackgroundScanning`
- `boolean mIsDisconnectByUser`
- `boolean mIsScreenOn`
- `List mLstScanFilter`
- `ScanFilter mRingEmptyFilter`
- `BackgroundScanCallback mRingScanCallback`
- `ScanSettings mRingScanSettingsBalanced`
- `Timer mScanTimer`
- `BluetoothLeScanner mScanner`
- `boolean ringACLConnected`

## Методы
- `private void disconnectInd(int i)`
- `public static RingReconnBackgroundScanManager getInstance()`
- `private void initScanner()`
- `public void onScreenStateChange(boolean z)`
- `private synchronized boolean opBackgroundScanStatus(int i)`
- `private synchronized boolean opScreenState(int i)`
- `private void startBackgroundScan()`
- `private synchronized void startTimer()`
- `public void stopBackgroundScan()`
- `private synchronized void stopTimer()`
- `public void bondedInd(String str)`
- `public synchronized void connectInd(String str)`
- `public void disconnectLinkLoss()`
- `public void onBluetoothStateChange(boolean z)`
- `public void onEvent(Object obj)`
- `public void unbindInd()`
- `private RingReconnBackgroundScanManager()`
