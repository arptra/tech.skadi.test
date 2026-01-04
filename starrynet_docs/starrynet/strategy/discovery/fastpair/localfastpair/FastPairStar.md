# FastPairStar

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/localfastpair/FastPairStar.java`\n
*Тип:* Class

## Назначение
Класс FastPairStar управляет логикой, связанной с FastPairStar.

## Поля
- `String KEY_INTERNATIONAL_PRIVACY_OUT_DATE`
- `int STATE_FIND`
- `String TAG`
- `int TIMEOUT_WAIT_ACTIVITY_STARTED`
- `boolean isPairing`
- `String mCacheId`
- `Object mFastPairWindow`
- `Boolean mInternationalPrivacyOutDate`
- `LocalSharePreference mLocalSharePreference`

## Методы
- `private void showFastPairWindow(StDevice stDevice)`
- `public void dealBondFailMessage(Message message)`
- `public void dealBondOkMessage(Message message)`
- `public void dealClickConnectMessage(Message message)`
- `public void dealConnectTimeoutMessage(Message message)`
- `public void dealDismissWindowMessage(Message message)`
- `public void dealShowWindowMessage(Message message)`
- `public void dismissWindows()`
- `public boolean getPairing()`
- `public boolean isPairingDevice(StDevice stDevice)`
- `public boolean isPopOrConnect(StDiscoveryDevice stDiscoveryDevice, int i, int i2)`
- `public void onBleConnected(StDevice stDevice)`
- `public void onBluetoothConnected(StDevice stDevice)`
- `public void onBrEdrConnected(StDevice stDevice)`
- `public void onEvent(Object obj)`
- `public void setPairing(boolean z)`
- `public FastPairStar(Context context)`
