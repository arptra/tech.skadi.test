# FastPairStarActivity

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/localfastpair/FastPairStarActivity.java`\n
*Тип:* Class

## Назначение
Класс FastPairStarActivity управляет логикой, связанной с FastPairStarActivity.

## Поля
- `String DEVICE_ID_AIR`
- `String DEVICE_ID_AIR_PRO`
- `String DEVICE_ID_STAR`
- `String PREFIX_FAST_PAIR`
- `String SUFFIX_CONNECT`
- `String SUFFIX_CONNECT_OK`
- `String TAG`
- `boolean isAppInstalled`
- `Button mBtnNegative`
- `Button mBtnPositive`
- `CheckBox mCbxPrivacy`
- `ConstraintLayout mClNegative`
- `int mConnectState`
- `String mConnectedResId`
- `String mConnectingResId`
- `Context mContext`
- `String mDeviceId`
- `String mDeviceName`
- `PAGImageView mImageView`
- `LinearLayout mLayoutPrivacy`
- `ViewGroup mLayoutWindows`
- `String mLocalPP`
- `String mLocalUP`
- `TextView mTvDeviceName`
- `TextView mTvNegative`
- `TextView mTvTitle`

## Методы
- `private void checkSuperAppInstalled()`
- `private void init()`
- `private void initPolicySDK(Context context)`
- `private void initServicePrivacy()`
- `public void onClickGetPolicyData(String str, String str2, String str3)`
- `private void playPagAnimation(String str, boolean z)`
- `private void postOperateEvent(int i)`
- `private void setVirtualNavigationBarColor()`
- `public void startPolicyActivity(String str, String str2)`
- `public void onClick(View view)`
- `public void onConfigurationChanged(Configuration configuration)`
- `public void onCreate(Bundle bundle)`
- `public void onDestroy()`
- `public void onEvent(Object obj)`
- `public void onStatusChange(int i, int i2)`
- `public void onStop()`
- `public void prepareResource()`
