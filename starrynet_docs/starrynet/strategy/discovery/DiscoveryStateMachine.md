# DiscoveryStateMachine

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/DiscoveryStateMachine.java`\n
*Тип:* Class

## Назначение
Класс DiscoveryStateMachine управляет логикой, связанной с DiscoveryStateMachine.

## Поля
- `int GATT_SERVER_STATE_OFF`
- `int GATT_SERVER_STATE_ON`
- `String KEY_CONNECT_ID`
- `int MSG_ACTIVE_ADV_TIMEOUT`
- `int MSG_ADD_BEACON_ID`
- `int MSG_ADV_ENABLE_MODE_CHANGE`
- `int MSG_ADV_STATE_CHANGE`
- `int MSG_ADV_STR_MODE_CHANGE`
- `int MSG_BOND_STATE_CHANGE_SERVER`
- `int MSG_BT_OFF`
- `int MSG_BT_ON`
- `int MSG_CONNECT_ADV_TIMEOUT`
- `int MSG_GATT_SERVER_STATE_CHANGE`
- `int MSG_NOTIFY_ADV_TIMEOUT`
- `int MSG_PASSIVE_ADV_TIMEOUT`
- `int MSG_RECONNECT_ADV_TIMEOUT`
- `int MSG_RESTART_SCAN`
- `int MSG_RESTART_STARRY_ADV`
- `int MSG_RETRY_START_ADV`
- `int MSG_SCREEN_OFF`
- `int MSG_SCREEN_ON`
- `int MSG_START_ADV`
- `int MSG_START_SCAN`
- `int MSG_START_SCAN_LOW_POWER`
- `int MSG_STOP_ADV`
- `int MSG_STOP_SCAN`
- `int MSG_UUP_SHARE_ADV_TIMEOUT`
- `int MSG_UUP_SHARE_RSP_ADV_TIMEOUT`
- `String TAG`
- `int TIMES_RETRY_ADV`
- `int TIME_INTERVAL_ADV_LONG`
- `int TIME_INTERVAL_ADV_SHORT`
- `int TIME_RESTART_ADV_DELAY`
- `int TIME_RETRY_ADV_DELAY`
- `boolean isAdvModeEnable`
- `boolean isGattServerReady`
- `boolean isStrModeEnter`
- `ActiveState mActiveState`
- `int mAdvRetryTimes`
- `int mAdvState`
- `AdvertiserManager mAdvertiserManager`
- `int mBeaconId`
- `boolean mIsLowPowerScanning`
- `boolean mIsScanning`
- `boolean mLimitScanFreq`
- `byte mNeedReconnectId`
- `boolean mNeedRepeatActiveAdv`
- `boolean mNeedRepeatPassiveAdv`
- `boolean mNeedRepeatReconnectAdv`
- `boolean mNeedScan`
- `boolean mNeedUupShareAdv`
- `long mPassiveAdvTime`
- `ScanManager mScanManager`
- `ScreenOffState mScreenOffState`
- `StandbyState mStandbyState`
- `int recordScanMode`

## Методы
- `public void checkAndStartAdv()`
- `public void cleanRetryAdv()`
- `private void dealNeedReconnectAdv()`
- `public void deleteAdvDemand(int i)`
- `public boolean isAdvEnable()`
- `public static DiscoveryStateMachine make(Context context, Looper looper, AdvertiserManager advertiserManager)`
- `public void recordAdvDemand(int i, byte bArr)`
- `public void removeAllDeferredMessages()`
- `public void startHighScan()`
- `public void startLowScan()`
- `public void addBeaconId()`
- `public void cleanup()`
- `public void doQuit()`
- `public int getAdvDemand(int i)`
- `public synchronized int getAdvState()`
- `public void resetScanRecord()`
- `public void retryStartAdv(int i, byte bArr)`
- `public synchronized void setAdvState(int i)`
- `public void setLimitScanFreqFlag(boolean z)`
- `public void startAdv(int i, byte bArr)`
- `public void stopHighScan()`
- `public void stopLowScan()`
- `public DiscoveryStateMachine(Context context, Looper looper, AdvertiserManager advertiserManager)`
