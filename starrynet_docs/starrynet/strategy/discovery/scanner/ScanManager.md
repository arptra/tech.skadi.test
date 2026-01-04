# ScanManager

*Пакет:* `com.upuphone.starrynet.strategy.discovery.scanner`\n
*Источник:* `starrynet/strategy/discovery/scanner/ScanManager.java`\n
*Тип:* Class

## Назначение
Класс ScanManager управляет логикой, связанной с ScanManager.

## Поля
- `String ENHANCED_SERVICE_CARLINK_SWITCHER`
- `String ENHANCED_SERVICE_FLYME_LINK_SWITCHER`
- `int ENHANCED_SERVICE_OPEN`
- `String MYVU_RING_OTA_NAME`
- `String TAG`
- `List lstRingScanFilter`
- `List lstScanFilter`
- `BluetoothAdapter mAdapter`
- `boolean mCarLinkOpened`
- `Context mContext`
- `boolean mFlymeLinkOpened`
- `ScanCallback mHighFreqRingScanCallback`
- `ScanCallback mHighFreqScanCallback`
- `ScanSettings mHighFreqScanSettings`
- `boolean mIsMzPhone`
- `ScanCallback mLowPowerScanCallback`
- `ScanSettings mLowPowerScanSettings`
- `StarryNetData mParser`
- `int mRestartScanCount`
- `BluetoothLeScanner mScanner`

## Методы
- `public static int access$608(ScanManager scanManager)`
- `public void decodeUupShareScanData(StDevice stDevice, Map map)`
- `private boolean isBluetoothEnabled()`
- `public boolean isCarLinkOpened()`
- `public boolean isFlymeLinkOpened()`
- `private void startListenEnhanceServiceChange()`
- `public void onBluetoothDisabled()`
- `public void onBluetoothEnabled()`
- `public void onUupShareDisabled()`
- `public void onUupShareEnabled()`
- `public boolean startHighFreqScan()`
- `public boolean startLowPowerBackgroundScan()`
- `public void stopHighFreqScan()`
- `public void stopLowPowerBackgroundScan()`
- `public boolean startHighFreqScan(boolean z)`
- `public ScanManager(Context context)`
