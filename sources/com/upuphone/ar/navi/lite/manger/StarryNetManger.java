package com.upuphone.ar.navi.lite.manger;

import android.content.Context;
import android.text.TextUtils;
import com.upuphone.ar.navi.lite.model.IConnection;
import com.upuphone.ar.navi.lite.model.IConnectionManager;
import com.upuphone.ar.navi.lite.model.INetDevice;
import com.upuphone.ar.navi.lite.model.INetDeviceManager;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.protocol.NotifyUtils;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.outer.SuperServiceStateListener;
import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.Arrays;
import java.util.List;

public class StarryNetManger implements SuperServiceStateListener {
    private static final Boolean IS_AAR = Boolean.TRUE;
    /* access modifiers changed from: private */
    public static final String TAG = ("NAVI-" + StarryNetManger.class.getSimpleName());
    private static StarryNetManger instance = null;
    private DeviceConnectionListener deviceConnectionListener = new DeviceConnectionListener() {
        public void onDeviceConnected(StarryNetDevice starryNetDevice) {
            String d = StarryNetManger.TAG;
            CLog.b(d, "########## onDeviceConnected." + starryNetDevice);
            if (StarryNetManger.this.isXrDevice(starryNetDevice)) {
                List b = IConnectionManager.c().b();
                for (int i = 0; i < b.size(); i++) {
                    ((IConnection) b.get(i)).A(true);
                }
                if (StarryNetManger.this.mContext != null && NaviUtil.e0(StarryNetManger.this.mContext.getApplicationContext())) {
                    StarryNetManger.this.dealDeviceConnectedAction();
                }
            }
        }

        public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
            CLog.b(StarryNetManger.TAG, "&&&&&&&&&& onDeviceDisconnected." + starryNetDevice);
            if (StarryNetManger.this.isXrDevice(starryNetDevice)) {
                NaviUtil.V0();
                List b = IConnectionManager.c().b();
                for (int i = 0; i < b.size(); i++) {
                    ((IConnection) b.get(i)).A(false);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext = null;
    private MessageReceiver messageReceiver = new MessageReceiver() {
        public void onMessageReceive(StarryNetMessage starryNetMessage) {
            String d = StarryNetManger.TAG;
            CLog.b(d, "onMessageReceive getReceiverPkg=" + starryNetMessage.getReceiverPkg() + " getMessage=" + starryNetMessage.getMessage());
            List c = INetDeviceManager.b().c();
            String d2 = StarryNetManger.TAG;
            CLog.b(d2, "onMessageReceive netDeviceList.size()=" + c.size());
            for (int i = 0; i < c.size(); i++) {
                ((INetDevice) c.get(i)).onMessageReceive(starryNetMessage);
            }
            StarryNetManger.this.handleReconnectionNaviMessage(starryNetMessage.getMessage());
        }
    };
    private OperatorManager operatorManager = null;
    private StarryNetMessageOperator starryNetMessageOperator;

    private void cancelResumeNavi() {
        NaviUtil.q1(false);
        if (NaviUtil.u0()) {
            NaviControlManager.k().P();
        }
    }

    public static StarryNetMessage createNetMessage(String str) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg(AssistantConstants.PKG_NAME_NAV);
        starryNetMessage.setMessage(str);
        return starryNetMessage;
    }

    /* access modifiers changed from: private */
    public void dealDeviceConnectedAction() {
        Context context = this.mContext;
        if (context == null) {
            CLog.b(TAG, "dealDeviceConnectedAction mContext is null.");
            return;
        }
        int f = CSharedPreferences.f(context.getApplicationContext(), "navi_latest_launch_mode", 0);
        long g = CSharedPreferences.g(this.mContext.getApplicationContext(), "navi_disconnect_time", 0);
        long currentTimeMillis = System.currentTimeMillis() - g;
        String str = TAG;
        CLog.b(str, "dealDeviceConnectedAction detaTime:" + currentTimeMillis + " disconnectTime=" + g + " latestLaunchMode=" + f);
        if (g == 0) {
            CLog.b(str, "dealDeviceConnectedAction disconnect time is invalid.");
        } else if (currentTimeMillis < 600000) {
            NotifyUtils.g(f);
            NaviUtil.A1(this.mContext.getApplicationContext());
        } else {
            NaviUtil.m();
            NotifyUtils.g(f);
            NaviUtil.w1(this.mContext.getApplicationContext(), "reconnection_navi", NaviUtil.B(this.mContext.getApplicationContext()).getName());
            NaviUtil.p1(true);
        }
    }

    public static StarryNetManger getInstance() {
        if (instance == null) {
            instance = new StarryNetManger();
        }
        return instance;
    }

    private StarryNetDevice getStarryNetDevice() {
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 == null || operatorManager2.getDeviceOperator() == null) {
            return null;
        }
        return this.operatorManager.getDeviceOperator().getConnectedDevice();
    }

    /* access modifiers changed from: private */
    public void handleReconnectionNaviMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(CmdAction.CMD_DIALOG_CONFIRM) && str.contains("reconnection_navi")) {
                CLog.b(TAG, "handleReconnectionNaviMessage: NOTIFICATION_RSP_CONFIRM");
                int f = CSharedPreferences.f(this.mContext.getApplicationContext(), "navi_latest_launch_mode", 0);
                NaviUtil.p1(false);
                NotifyUtils.g(f);
                NaviUtil.A1(this.mContext.getApplicationContext());
            } else if (str.contains(CmdAction.CMD_DIALOG_CANCEL) && str.contains("reconnection_navi")) {
                CLog.b(TAG, "handleReconnectionNaviMessage: NOTIFICATION_RSP_CANCEL");
                NaviUtil.p1(false);
                NotifyUtils.g(0);
                cancelResumeNavi();
                NaviUtil.U0(this.mContext.getApplicationContext());
            }
        }
    }

    public OperatorManager getOperatorManager() {
        return this.operatorManager;
    }

    public void init(Context context) {
        CLog.b(TAG, "init is Enter.");
        this.mContext = context;
        unRegister();
        if (IS_AAR.booleanValue()) {
            OperatorManager init = SuperAppServiceManager.getInstance().init("com.upuphone.ar.navi.lite");
            this.operatorManager = init;
            if (!(init == null || init.getMessageOperator() == null)) {
                this.operatorManager.getMessageOperator().registerMessageReceiver(this.messageReceiver);
            }
        } else {
            this.operatorManager = SuperAppServiceManager.getInstance().init(context.getApplicationContext(), this, 0);
        }
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 != null) {
            this.starryNetMessageOperator = operatorManager2.getMessageOperator();
            this.operatorManager.getDeviceOperator().registerDeviceConnectionListener(this.deviceConnectionListener);
        }
    }

    public boolean isAirDevice() {
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 == null || operatorManager2.getDeviceOperator() == null || this.operatorManager.getDeviceOperator().getConnectedDevice() == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.operatorManager.getDeviceOperator().getConnectedDevice().getModelId())) {
            return this.operatorManager.getDeviceInfoOperator().isAir();
        }
        CLog.b(TAG, "isAirDevice modelId isEmpty!");
        return false;
    }

    public boolean isAirPro() {
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 == null) {
            return false;
        }
        return operatorManager2.getDeviceInfoOperator().isAirPro();
    }

    public boolean isDeviceConnected() {
        if (!IS_AAR.booleanValue()) {
            return true;
        }
        return isXrDevice(getStarryNetDevice());
    }

    public boolean isXrDevice(StarryNetDevice starryNetDevice) {
        return starryNetDevice != null && starryNetDevice.getTerminalType() == 2;
    }

    public void onServiceConnected() {
        String str = TAG;
        CLog.b(str, "onServiceConnected ");
        StarryNetMessageOperator starryNetMessageOperator2 = this.starryNetMessageOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.registerMessageReceiver(this.messageReceiver);
        } else {
            CLog.b(str, "onServiceConnected starryNetDeviceMessageOperator is null.");
        }
    }

    public void onServiceDied() {
        CLog.b(TAG, "onServiceDied ");
    }

    public void requestPermission() {
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 == null) {
            CLog.b(TAG, "requestPermission permission operatorManager is null!");
        } else {
            operatorManager2.getSappAbilityOperator().requestPermission(Arrays.asList(NaviUtil.b), new IPermissonResult.Stub() {
                public void permissonResult(PermissionResult permissionResult) {
                    for (int i = 0; i < permissionResult.getDeniedPermissionList().size(); i++) {
                        String d = StarryNetManger.TAG;
                        CLog.b(d, "requestPermission permission[" + i + "]=" + permissionResult.getDeniedPermissionList().get(i));
                    }
                }
            });
        }
    }

    public void sendMessage(String str, SendMessageListener sendMessageListener) {
        StarryNetMessageOperator starryNetMessageOperator2 = this.starryNetMessageOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.sendMessage(createNetMessage(str), sendMessageListener);
        } else {
            CLog.b(TAG, "sendMessage @@@ starryNetDeviceMessageOperator is null.");
        }
    }

    public void unRegister() {
        String str = TAG;
        CLog.b(str, "unRegister ");
        StarryNetMessageOperator starryNetMessageOperator2 = this.starryNetMessageOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.unregisterMessageReceiver(this.messageReceiver);
            this.starryNetMessageOperator = null;
        } else {
            CLog.b(str, "unRegister starryNetDeviceMessageOperator is null.");
        }
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 != null) {
            operatorManager2.getDeviceOperator().unregisterDeviceConnectionListener(this.deviceConnectionListener);
            this.operatorManager = null;
            return;
        }
        CLog.b(str, "unRegister operatorManager is null.");
    }

    public static StarryNetMessage createNetMessage(String str, String str2) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg(str2);
        starryNetMessage.setMessage(str);
        return starryNetMessage;
    }

    public void sendMessage(String str, String str2, SendMessageListener sendMessageListener) {
        StarryNetMessageOperator starryNetMessageOperator2 = this.starryNetMessageOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.sendMessage(createNetMessage(str, str2), sendMessageListener);
        } else {
            CLog.b(TAG, "sendMessage ### starryNetDeviceMessageOperator is null.");
        }
    }

    public static StarryNetMessage createNetMessage(String str, String str2, byte[] bArr) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg(str2);
        starryNetMessage.setMessage(str);
        starryNetMessage.setData(bArr);
        return starryNetMessage;
    }

    public void sendMessage(String str, String str2, byte[] bArr, SendMessageListener sendMessageListener) {
        StarryNetMessageOperator starryNetMessageOperator2 = this.starryNetMessageOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.sendMessage(createNetMessage(str, str2, bArr), sendMessageListener);
        } else {
            CLog.b(TAG, "sendMessage &&&&&& starryNetDeviceMessageOperator is null.");
        }
    }

    public void sendMessage(String str, byte[] bArr, SendMessageListener sendMessageListener) {
        StarryNetMessageOperator starryNetMessageOperator2 = this.starryNetMessageOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.sendMessage(createNetMessage(str, bArr), sendMessageListener);
        } else {
            CLog.b(TAG, "sendMessage @@@@@@@@ starryNetDeviceMessageOperator is null.");
        }
    }

    public static StarryNetMessage createNetMessage(String str, byte[] bArr) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg(AssistantConstants.PKG_NAME_NAV);
        starryNetMessage.setMessage(str);
        starryNetMessage.setData(bArr);
        return starryNetMessage;
    }
}
