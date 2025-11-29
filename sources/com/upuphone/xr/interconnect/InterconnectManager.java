package com.upuphone.xr.interconnect;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.honey.account.r7.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.relay.BypassAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayBean;
import com.upuphone.starrynetsdk.ability.relay.RemoteListener;
import com.upuphone.starrynetsdk.api.Util;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.PhoneNaviAbility;
import com.upuphone.xr.interconnect.api.PhoneNaviAbilityImpl;
import com.upuphone.xr.interconnect.api.PhoneSappAbility;
import com.upuphone.xr.interconnect.api.PhoneSappAbilityImpl;
import com.upuphone.xr.interconnect.api.PhoneTransAbility;
import com.upuphone.xr.interconnect.api.PhoneTransAbilityImpl;
import com.upuphone.xr.interconnect.api.StarryNetAppManager;
import com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoManagerImpl;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.api.StarryNetDialerManager;
import com.upuphone.xr.interconnect.api.StarryNetDialerManagerImpl;
import com.upuphone.xr.interconnect.api.StarryNetFileTransfer;
import com.upuphone.xr.interconnect.api.StarryNetFileTransferImpl;
import com.upuphone.xr.interconnect.api.StarryNetGroupMessenger;
import com.upuphone.xr.interconnect.api.StarryNetGroupMessengerImpl;
import com.upuphone.xr.interconnect.api.StarryNetMessenger;
import com.upuphone.xr.interconnect.api.StarryNetMessengerImpl;
import com.upuphone.xr.interconnect.api.StarryNetWifiManager;
import com.upuphone.xr.interconnect.api.StarryNetWifiManagerImpl;
import com.upuphone.xr.interconnect.api.VolumeChange;
import com.upuphone.xr.interconnect.api.VolumeChangeImpl;
import com.upuphone.xr.interconnect.api.glass.StarryNetDlna;
import com.upuphone.xr.interconnect.api.phone.PhoneAccountAbility;
import com.upuphone.xr.interconnect.api.phone.PhoneAccountAbilityImpl;
import com.upuphone.xr.interconnect.bluetooth.BluetoothEventMonitor;
import com.upuphone.xr.interconnect.business.databinder.DataBinderManager;
import com.upuphone.xr.interconnect.delegate.TimeSyncDelegate;
import com.upuphone.xr.interconnect.entity.ConnectMessageOuterClass;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.inner.InnerOperatorManagerCreator;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.main.StarryNetAbilityInstallListener;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.main.dispatcher.MainDispatcher;
import com.upuphone.xr.interconnect.main.handler.MainMessageHandler;
import com.upuphone.xr.interconnect.main.handler.TimeSyncRequestMessageHandler;
import com.upuphone.xr.interconnect.main.handler.TimeSyncResponseMessageHandler;
import com.upuphone.xr.interconnect.resource.ResourceManager;
import com.upuphone.xr.interconnect.task.TaskManager;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import kotlinx.coroutines.Dispatchers;

public final class InterconnectManager {
    public static final String SP_NAME = "sapp";
    private static final String TAG = "InterconnectManager";
    private volatile boolean hasInit;
    private Boolean isFinishInnerMessageReceiver;
    private boolean isStarrySdkInstalled;
    private Context mContext;
    /* access modifiers changed from: private */
    public DataBinderManager mDataBinderManager;
    private MainDispatcher mMainDispatcher;
    private List<OnStarrySdkStateChangeListener> mOnStarrySdkStateChangeListeners;
    private String mPeerPackageName;
    private PhoneNaviAbility mPhoneNaviAbility;
    private PhoneSappAbility mPhoneSappAbility;
    private PhoneTransAbility mPhoneTransAbility;
    private ResourceManager mResourceManager;
    private StarryNetAppManagerImpl mStarryNetAppManager;
    /* access modifiers changed from: private */
    public StarryNetDeviceInfoManagerImpl mStarryNetDeviceInfoManager;
    private StarryNetDeviceManager mStarryNetDeviceManager;
    private StarryNetDialerManager mStarryNetDialerManager;
    private StarryNetDlna mStarryNetDlna;
    private StarryNetFileTransferImpl mStarryNetFileTransfer;
    private StarryNetGroupMessenger mStarryNetGroupMessenger;
    private StarryNetMessenger mStarryNetMessenger;
    private StarryNetWifiManagerImpl mStarryNetWifiManager;
    private TaskManager mTaskManager;
    private VolumeChangeImpl mVolumeChange;
    private Handler mainHandler;
    private PhoneAccountAbility phoneAccountAbility;
    private int platform;

    public static final class InterconnectManagerHolder {
        /* access modifiers changed from: private */
        public static final InterconnectManager INSTANCE = new InterconnectManager();

        private InterconnectManagerHolder() {
        }
    }

    public interface OnStarrySdkStateChangeListener {
        void onStateChanged(boolean z);
    }

    public static InterconnectManager getInstance() {
        return InterconnectManagerHolder.INSTANCE;
    }

    private void initConnectManager(@NonNull Context context, @SuperAppServiceManager.Platform int i) {
        boolean isEnable = new BypassAbility().isEnable();
        ILog.i(TAG, "initConnectManager hasInit: " + this.hasInit + ", enable: " + isEnable);
        if (!this.hasInit || !isEnable) {
            this.hasInit = true;
            this.platform = i;
            Application application = context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
            StarryNetAbilityInstallListener.INSTANCE.install(application);
            this.mContext = application;
            this.mainHandler = new Handler(Looper.getMainLooper());
            this.mPeerPackageName = Util.getAppUniteCode(context);
            this.mStarryNetAppManager.init(this.mContext);
            this.mStarryNetAppManager.startScan();
            this.mStarryNetDeviceManager.init();
            registerInnerMessageReceiver();
            if (!isGlassPlatform()) {
                new TimeSyncDelegate(this.mContext);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$toast$0(String str) {
        Toast.makeText(this.mContext, str, 0).show();
    }

    private void printSdkInfo() {
        ILog.i(TAG, "╔══════════════════════════════初始化互联服务SDK══════════════════════════════╗");
        ILog.i(TAG, "║SDK版本：AR-3.2.0.0");
        ILog.i(TAG, "║互联互通SDK版本（内置）：2.8.44");
        ILog.i(TAG, "║互联互通SDK版本（国内三方）：2.8.44");
        ILog.i(TAG, "║互联互通SDK版本（海外）：2.8.44");
        ILog.i(TAG, "║是否是适配三方手机版本：false");
        ILog.i(TAG, "║是否是适配海外手机版本：true");
        ILog.i(TAG, "║构建版本信息：branch=STARV_MP7_INTL_20250423，hash=32026939b，构建时间=20250423_2049");
        ILog.i(TAG, "╚══════════════════════════════════════════════════════════════════════════╝");
    }

    private void registerDeviceConnectedListener() {
        this.mStarryNetDeviceManager.setMainDeviceConnectListener(new DeviceConnectionListener() {
            public void onDeviceConnected(StarryNetDevice starryNetDevice) throws RemoteException {
                if (starryNetDevice.getTerminalType() == 2) {
                    InterconnectManager.this.mDataBinderManager.onRemoteServiceStarted(starryNetDevice.getDeviceId());
                }
            }

            public void onDeviceDisconnected(StarryNetDevice starryNetDevice) throws RemoteException {
                InterconnectManager.this.mStarryNetDeviceInfoManager.clear();
                InterconnectManager.this.mDataBinderManager.onRemoteServiceDied(starryNetDevice.getDeviceId());
            }
        });
    }

    private void registerInnerMessageReceiver() {
        if (this.isFinishInnerMessageReceiver.booleanValue()) {
            ULog.m(TAG, "registerInnerMessageReceiver isFinishInnerMessageReceiver finish return");
            return;
        }
        ULog.m(TAG, "registerInnerMessageReceiver start set isFinishInnerMessageReceiver true");
        this.isFinishInnerMessageReceiver = Boolean.TRUE;
        OperatorManager init = SuperAppServiceManager.getInstance().init("com.upuphone.xr.interconnect");
        if (init == null) {
            init = SuperAppServiceManager.getInstance().init("com.upuphone.xr.interconnect");
        }
        MainMessageHandler mainMessageHandler = new MainMessageHandler();
        mainMessageHandler.addHandler(this.mStarryNetFileTransfer.getFileTransportMessageHandler());
        mainMessageHandler.addHandler(new TimeSyncRequestMessageHandler());
        mainMessageHandler.addHandler(new TimeSyncResponseMessageHandler());
        mainMessageHandler.addHandler(this.mStarryNetDeviceInfoManager.getRequestUpdateHandler());
        mainMessageHandler.addHandler(this.mStarryNetDeviceInfoManager.getResponseHandler());
        mainMessageHandler.addHandler(this.mStarryNetWifiManager.getConnectWifiResponseHandler());
        mainMessageHandler.addHandler(this.mStarryNetWifiManager.getConnectWifiRequestHandler());
        mainMessageHandler.addHandler(this.mStarryNetWifiManager.getRequestWifiInfoHandler());
        mainMessageHandler.addHandler(this.mStarryNetWifiManager.getWifiInfoResponseHandler());
        mainMessageHandler.addHandler(this.mStarryNetAppManager.getLaunchStarryNetAppRequestHandler());
        mainMessageHandler.addHandler(this.mStarryNetAppManager.getLaunchStarryNetAppResponseHandler());
        mainMessageHandler.addHandler(this.mDataBinderManager);
        mainMessageHandler.addHandler(this.mDataBinderManager.getRequestHandler());
        mainMessageHandler.addHandler(this.mTaskManager.getExecutionHandler());
        mainMessageHandler.addHandler(this.mTaskManager.getRunningTaskActionHandler());
        mainMessageHandler.addHandler(this.mResourceManager);
        if (init == null || init.getMessageOperator() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("om.getMessageOperator() is null,om != null = ");
            sb.append(init != null);
            ILog.i(TAG, sb.toString());
            return;
        }
        ILog.i(TAG, "registerMessageReceiver(mainMessageHandler)");
        init.getMessageOperator().registerMessageReceiver(mainMessageHandler);
    }

    public void checkStarryNetStatus(String str, final RemoteListener remoteListener) {
        RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
        if (relayAbility != null) {
            ILog.i(TAG, "mRelayAbility != null send version msg");
            RelayBean relayBean = new RelayBean();
            relayBean.setTargetDeviceId(str);
            relayBean.setTargetUniteCode(getInstance().getPackageName());
            ConnectMessageOuterClass.ConnectMessage.Builder newBuilder = ConnectMessageOuterClass.ConnectMessage.newBuilder();
            int deviceMsgVersion = this.mStarryNetMessenger.getDeviceMsgVersion(str);
            ILog.i(TAG, "checkStarryNetStatus version = " + deviceMsgVersion);
            newBuilder.setVersion(deviceMsgVersion);
            relayBean.setData(((ConnectMessageOuterClass.ConnectMessage) newBuilder.build()).toByteArray());
            relayAbility.relay(relayBean, new RemoteListener() {
                public void onFailure(String str, int i) {
                    ILog.i(InterconnectManager.TAG, "sendMessageStatusCheckMsg relay onFailure  uniteCode = $uniteCode,code = $code");
                    remoteListener.onFailure(str, i);
                }

                public void onSuccess(String str) {
                    ILog.i(InterconnectManager.TAG, "sendMessageStatusCheckMsg relay onSuccess ");
                    remoteListener.onSuccess(str);
                }
            });
        }
    }

    public BluetoothEventMonitor getBluetoothEventMonitor() {
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public DataBinderManager getDataBinderManager() {
        return this.mDataBinderManager;
    }

    public MainDispatcher getMainDispatcher() {
        return this.mMainDispatcher;
    }

    public SharedPreferences getMainSp() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(SP_NAME, 0);
    }

    public String getPackageName() {
        Context context = this.mContext;
        return context == null ? "" : context.getPackageName();
    }

    public String getPeerPackageName() {
        return this.mPeerPackageName;
    }

    public PhoneAccountAbility getPhoneAccountAbility() {
        return this.phoneAccountAbility;
    }

    public PhoneNaviAbility getPhoneNaviAbility() {
        return this.mPhoneNaviAbility;
    }

    public PhoneSappAbility getPhoneSappAbility() {
        return this.mPhoneSappAbility;
    }

    public PhoneTransAbility getPhoneTransAbility() {
        return this.mPhoneTransAbility;
    }

    public ResourceManager getResourceManager() {
        return this.mResourceManager;
    }

    public StarryNetAppManager getStarryNetAppManager() {
        return this.mStarryNetAppManager;
    }

    public StarryNetDeviceInfoManager getStarryNetDeviceInfoManager() {
        return this.mStarryNetDeviceInfoManager;
    }

    public StarryNetDeviceManager getStarryNetDeviceManager() {
        return this.mStarryNetDeviceManager;
    }

    public StarryNetDialerManager getStarryNetDialerManager() {
        return this.mStarryNetDialerManager;
    }

    public StarryNetDlna getStarryNetDlna() {
        return this.mStarryNetDlna;
    }

    public StarryNetFileTransfer getStarryNetFileTransfer() {
        return this.mStarryNetFileTransfer;
    }

    public StarryNetMessenger getStarryNetMessenger() {
        return this.mStarryNetMessenger;
    }

    public StarryNetGroupMessenger getStarryNetSdkGroupMessenger() {
        return this.mStarryNetGroupMessenger;
    }

    public StarryNetWifiManager getStarryNetWifiManager() {
        return this.mStarryNetWifiManager;
    }

    public TaskManager getTaskManager() {
        return this.mTaskManager;
    }

    public VolumeChange getVolumeChange() {
        return this.mVolumeChange;
    }

    public void init(@NonNull Context context, @SuperAppServiceManager.Platform int i) {
        boolean isEnable = new BypassAbility().isEnable();
        ULog.f(TAG, "hasInit = " + isFinishInit() + ",isStarryNetFinishInit = " + isStarryNetFinishInit() + ", enable = " + isEnable);
        if (!isFinishInit() || !isEnable) {
            ULog.f(TAG, "isFinishInit is false");
            initConnectManager(context, i);
        } else if (!isStarryNetFinishInit()) {
            ULog.f(TAG, "isStarryNetFinishInit is false");
            StarryNetAbilityInstallListener.INSTANCE.install(context.getApplicationContext());
        } else {
            ULog.f(TAG, "isStarryNetFinishInit is true ,isFinishInit is true");
        }
    }

    public boolean isFinishInit() {
        return this.hasInit;
    }

    public boolean isGlassPlatform() {
        return this.platform == 1;
    }

    public boolean isStarryNetFinishInit() {
        return StarryNetAbilityInstallListener.INSTANCE.isFinishInit();
    }

    public void notifyStarrySdkStateChanged(boolean z) {
        this.isStarrySdkInstalled = z;
        if (!this.mOnStarrySdkStateChangeListeners.isEmpty()) {
            for (OnStarrySdkStateChangeListener onStateChanged : this.mOnStarrySdkStateChangeListeners) {
                onStateChanged.onStateChanged(z);
            }
        }
    }

    public boolean persistentData(String str, Object obj) {
        SharedPreferences mainSp;
        if (this.mContext == null || (mainSp = getMainSp()) == null) {
            return false;
        }
        SharedPreferences.Editor edit = mainSp.edit();
        if (obj instanceof Integer) {
            return edit.putInt(str, ((Integer) obj).intValue()).commit();
        }
        if (obj instanceof String) {
            return edit.putString(str, (String) obj).commit();
        }
        if (obj instanceof Boolean) {
            return edit.putBoolean(str, ((Boolean) obj).booleanValue()).commit();
        }
        if (obj instanceof Float) {
            return edit.putFloat(str, ((Float) obj).floatValue()).commit();
        }
        if (obj instanceof Long) {
            return edit.putLong(str, ((Long) obj).longValue()).commit();
        }
        return false;
    }

    public void post2MainThread(Runnable runnable) {
        Handler handler = this.mainHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void registerOnStarrySdkStateChangeListener(OnStarrySdkStateChangeListener onStarrySdkStateChangeListener) {
        this.mOnStarrySdkStateChangeListeners.add(onStarrySdkStateChangeListener);
        if (this.isStarrySdkInstalled) {
            onStarrySdkStateChangeListener.onStateChanged(true);
        }
    }

    public void toast(String str) {
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            this.mainHandler.post(new a(this, str));
        }
    }

    public void unregisterOnStarrySdkStateChangeListener(OnStarrySdkStateChangeListener onStarrySdkStateChangeListener) {
        this.mOnStarrySdkStateChangeListeners.remove(onStarrySdkStateChangeListener);
    }

    private InterconnectManager() {
        this.hasInit = false;
        this.mPeerPackageName = null;
        this.isStarrySdkInstalled = false;
        this.mOnStarrySdkStateChangeListeners = new DeDuplicateCopyOnWriteArrayList();
        printSdkInfo();
        this.isFinishInnerMessageReceiver = Boolean.FALSE;
        StarryNetDeviceManagerImpl starryNetDeviceManagerImpl = new StarryNetDeviceManagerImpl();
        this.mStarryNetDeviceManager = starryNetDeviceManagerImpl;
        this.mStarryNetMessenger = new StarryNetMessengerImpl(starryNetDeviceManagerImpl.connectManager.getPeerDeviceStatusManager());
        this.mStarryNetFileTransfer = new StarryNetFileTransferImpl();
        this.mStarryNetGroupMessenger = new StarryNetGroupMessengerImpl();
        this.mStarryNetDlna = null;
        this.mVolumeChange = new VolumeChangeImpl();
        this.mPhoneSappAbility = new PhoneSappAbilityImpl();
        this.mStarryNetAppManager = new StarryNetAppManagerImpl();
        this.mPhoneNaviAbility = new PhoneNaviAbilityImpl();
        this.mStarryNetDeviceInfoManager = new StarryNetDeviceInfoManagerImpl();
        this.mStarryNetWifiManager = new StarryNetWifiManagerImpl();
        this.mStarryNetDialerManager = new StarryNetDialerManagerImpl();
        this.phoneAccountAbility = new PhoneAccountAbilityImpl();
        this.mMainDispatcher = new MainDispatcher();
        DataBinderManager dataBinderManager = new DataBinderManager();
        this.mDataBinderManager = dataBinderManager;
        this.mTaskManager = new TaskManager(dataBinderManager);
        this.mResourceManager = new ResourceManager(Dispatchers.a(), this.mDataBinderManager, this.mTaskManager);
        this.mPhoneTransAbility = new PhoneTransAbilityImpl();
        registerDeviceConnectedListener();
        SuperAppServiceManager.getInstance().inject(new InnerOperatorManagerCreator());
    }
}
