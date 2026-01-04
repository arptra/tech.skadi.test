# AdvertiserManager

*Пакет:* `com.upuphone.starrynet.strategy.discovery.advertiser`\n
*Источник:* `starrynet/strategy/discovery/advertiser/AdvertiserManager.java`\n
*Тип:* Class

## Назначение
Класс AdvertiserManager управляет логикой, связанной с AdvertiserManager.

## Поля
- `int ADV_STATE_SUCCESS`
- `int ADV_TYPE_ACTIVE`
- `int ADV_TYPE_CONNECT`
- `int ADV_TYPE_NOTIFY`
- `int ADV_TYPE_PASSIVE`
- `int ADV_TYPE_RECONNECT`
- `int ADV_TYPE_UUP_SHARE`
- `int ADV_TYPE_UUP_SHARE_RSP`
- `String TAG`
- `AdvertiseCallback mActiveAdvCallback`
- `BluetoothAdapter mAdapter`
- `IAdvStartCallback mAdvStartCallback`
- `BluetoothLeAdvertiser mAdvertiser`
- `AdvertiseCallback mConnectAdvCallback`
- `AdvertiseSettings mConnectableAdvSettings`
- `AdvertiseSettings mConnectableRspAdvSettings`
- `AdvertiseCallback mNotifyAdvCallback`
- `AdvertiseCallback mPassiveAdvCallback`
- `AdvertiseCallback mReConnectAdvCallback`
- `AdvertiseSettings mUnConnectableAdvSettings`
- `AdvertiseCallback mUupShareAdvCallback`

## Методы
- `public synchronized AdvertiseCallback getActiveAdvCallback()`
- `public synchronized AdvertiseCallback getConnectAdvCallback()`
- `public synchronized AdvertiseSettings getConnectableAdvSettings(int i)`
- `public synchronized AdvertiseSettings getConnectableRspSettings(int i)`
- `public synchronized AdvertiseCallback getNotifyAdvCallback()`
- `public synchronized AdvertiseCallback getPassiveAdvCallback()`
- `public synchronized AdvertiseCallback getReConnectAdvCallback()`
- `public synchronized AdvertiseSettings getUnConnectableAdvSettings(int i)`
- `public AdvertiseCallback getUupShareAdvCallback()`
- `public AdvertiseCallback getUupShareRspAdvCallback()`
- `public void initAdvertiser()`
- `public void registerAdvStartCallback(IAdvStartCallback iAdvStartCallback)`
- `public synchronized void startActiveAdv(int i, int i2)`
- `public synchronized void startConnectAdv(int i, byte bArr, int i2)`
- `public synchronized void startNotifyAdv(int i, byte bArr, int i2)`
- `public synchronized void startPassiveAdv(int i, byte bArr, int i2)`
- `public synchronized void startReconnectAdv(int i, byte bArr, int i2)`
- `public void startUp(short s)`
- `public synchronized void startUupShareAdv(int i)`
- `public void startUupShareResponseAdv(int i)`
- `public synchronized void stopAdv(int r4)`
- `public void unRegisterAdvStartCallback()`
- `public AdvertiserManager()`
