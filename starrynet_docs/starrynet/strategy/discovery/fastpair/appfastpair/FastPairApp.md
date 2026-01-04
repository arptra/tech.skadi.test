# FastPairApp

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/appfastpair/FastPairApp.java`\n
*Тип:* Class

## Назначение
Класс FastPairApp управляет логикой, связанной с FastPairApp.

## Поля
- `int CONNECT_TIMEOUT`
- `String TAG`
- `boolean isPairing`
- `IFastPairCallback mFastPairCallback`

## Методы
- `private void trackConnection(StDevice stDevice)`
- `private void updateForConnectTimeoutOrFail(StDiscoveryDevice stDiscoveryDevice)`
- `public void connectStDevice(StDevice stDevice)`
- `public void dealAutoConnectTimeoutMessage(Message message)`
- `public void dealBondFailMessage(Message message)`
- `public void dealBondOkMessage(Message message)`
- `public void dealClassicBondMessage(Message message)`
- `public void dealClickCancelMessage(Message message)`
- `public void dealClickConnectMessage(Message message)`
- `public void dealConnectTimeoutMessage(Message message)`
- `public void dealDismissWindowMessage(Message message)`
- `public void dealDispatchToAppMessage(Message message)`
- `public void dealRemoveBondMessage(Message message)`
- `public void dealShowWindowMessage(Message message)`
- `public boolean getPairing()`
- `public void setPairing(boolean z)`
- `public void updateForBondOk(byte bArr)`
- `public FastPairApp(Context context, IFastPairCallback iFastPairCallback)`
