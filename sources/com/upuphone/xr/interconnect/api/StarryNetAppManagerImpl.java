package com.upuphone.xr.interconnect.api;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.honey.account.s7.a;
import com.honey.account.s7.b;
import com.honey.account.s7.c;
import com.honey.account.s7.d;
import com.honey.account.s7.e;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayBean;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.business.app.LaunchAgent;
import com.upuphone.xr.interconnect.business.app.LaunchRequestHandler;
import com.upuphone.xr.interconnect.business.app.LaunchResponseHandler;
import com.upuphone.xr.interconnect.common.IAppDockMenuClickListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.LaunchAppParam;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.entity.StarryNetAppDockMenu;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.pm.OpenRemoteStarryNetAppCode;
import com.upuphone.xr.interconnect.pm.StarryNetAppUtil;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StarryNetAppManagerImpl implements StarryNetAppManager, LaunchAgent {
    private static final String TAG = "StarryNetAppManagerImpl";
    private volatile boolean hasInit = false;
    private Map<String, List<IAppDockMenuClickListener>> mAppDockMenuClickListenerListMap = new ConcurrentHashMap();
    private Context mContext;
    private Handler mHandler;
    private LaunchRequestHandler mLaunchStarryNetAppRequestHandler;
    private final LaunchResponseHandler mLaunchStarryNetAppResponseHandler;
    private String mLocalAppIconPath;
    private String mLocalAppMenuIconPath;
    private String mLocalIconPath;
    private List<StarryNetApp> mLocalStarryNetAppList = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public Map<String, OpenRemoteStarryNetAppCallback> mOpenRemoteStarryNetAppCallbackMap;
    private List<StarryNetApp> mRemoteStarryNetAppList = new CopyOnWriteArrayList();
    private List<StarryNetAppChangeListener> mStarryNetAppChangeListenerList = new DeDuplicateArrayList();
    private HandlerThread mWorkThread;

    public final class LaunchStarryNetAppListener extends SendMessageListener {
        private OpenRemoteStarryNetAppCallback mCallback;
        private String requestId;

        public void onFail(String str, int i) throws RemoteException {
            StarryNetAppManagerImpl.this.invokeOpenRemoteStarryNetAppCallback(this.mCallback, OpenRemoteStarryNetAppCode.CODE_SEND_MESSAGE_FAIL);
        }

        public void onSuccess(String str) throws RemoteException {
            if (this.mCallback != null) {
                StarryNetAppManagerImpl.this.mOpenRemoteStarryNetAppCallbackMap.put(this.requestId, this.mCallback);
            }
        }

        private LaunchStarryNetAppListener(String str, OpenRemoteStarryNetAppCallback openRemoteStarryNetAppCallback) {
            this.requestId = str;
            this.mCallback = openRemoteStarryNetAppCallback;
        }
    }

    public StarryNetAppManagerImpl() {
        HashMap hashMap = new HashMap();
        this.mOpenRemoteStarryNetAppCallbackMap = hashMap;
        this.mLaunchStarryNetAppResponseHandler = new LaunchResponseHandler(hashMap);
    }

    private <T> List<T> getCopiedData(List<T> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        return arrayList;
    }

    private List<StarryNetApp> getMergedStarryNetAppList() {
        List<StarryNetApp> copiedData = getCopiedData(this.mLocalStarryNetAppList);
        copiedData.addAll(this.mRemoteStarryNetAppList);
        return copiedData;
    }

    /* access modifiers changed from: private */
    public void invokeOpenRemoteStarryNetAppCallback(OpenRemoteStarryNetAppCallback openRemoteStarryNetAppCallback, int i) {
        if (openRemoteStarryNetAppCallback != null) {
            if (i == 200) {
                openRemoteStarryNetAppCallback.onSuccess();
            } else {
                openRemoteStarryNetAppCallback.onFail(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dynamicUpdateStarryNetApp$2(StarryNetApp starryNetApp) {
        List<StarryNetApp> queryLocalStarryNetApp = queryLocalStarryNetApp(starryNetApp.getPackageName());
        if (queryLocalStarryNetApp != null && queryLocalStarryNetApp.size() > 0) {
            for (StarryNetApp remove : queryLocalStarryNetApp) {
                this.mLocalStarryNetAppList.remove(remove);
            }
        }
        this.mLocalStarryNetAppList.add(starryNetApp);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPeerAppInstalled$3() {
        for (StarryNetAppChangeListener onPeerAppInstalled : this.mStarryNetAppChangeListenerList) {
            onPeerAppInstalled.onPeerAppInstalled();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPeerAppRemoved$4() {
        for (StarryNetAppChangeListener onPeerAppRemoved : this.mStarryNetAppChangeListenerList) {
            onPeerAppRemoved.onPeerAppRemoved();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openRemoteStarryNetApp$1(StarryNetMessenger starryNetMessenger, StarryNetMessage starryNetMessage, String str, OpenRemoteStarryNetAppCallback openRemoteStarryNetAppCallback) {
        starryNetMessenger.sendMessage(starryNetMessage, new LaunchStarryNetAppListener(str, openRemoteStarryNetAppCallback));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startScan$0() {
        long currentTimeMillis = System.currentTimeMillis();
        List<StarryNetApp> queryStarryNetApp = StarryNetAppUtil.queryStarryNetApp(this.mContext);
        if (queryStarryNetApp != null && queryStarryNetApp.size() > 0) {
            ILog.w(TAG, "starryNetAppList add size  = " + queryStarryNetApp.size());
            this.mLocalStarryNetAppList.addAll(queryStarryNetApp);
        }
        ILog.d(TAG, "扫描互联应用耗时--" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    private void startWorkThread() {
        HandlerThread handlerThread = new HandlerThread("StarryNetAppManager");
        this.mWorkThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mWorkThread.getLooper());
    }

    public void dynamicUpdateStarryNetApp(StarryNetApp starryNetApp) {
        this.mHandler.post(new e(this, starryNetApp));
    }

    public MessageHandler getLaunchStarryNetAppRequestHandler() {
        if (this.mLaunchStarryNetAppRequestHandler == null) {
            this.mLaunchStarryNetAppRequestHandler = new LaunchRequestHandler(this.mContext, TAG, this, this.mLocalStarryNetAppList);
        }
        return this.mLaunchStarryNetAppRequestHandler;
    }

    public MessageHandler getLaunchStarryNetAppResponseHandler() {
        return this.mLaunchStarryNetAppResponseHandler;
    }

    public void init(@NonNull Context context) {
        if (!this.hasInit) {
            this.hasInit = true;
            this.mContext = context;
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("icons");
            sb.append(str);
            String sb2 = sb.toString();
            this.mLocalIconPath = sb2 + ImagesContract.LOCAL + str;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.mLocalIconPath);
            sb3.append(DDAuthConstant.AUTH_LOGIN_TYPE_APP);
            this.mLocalAppIconPath = sb3.toString();
            this.mLocalAppMenuIconPath = this.mLocalIconPath + "menu";
            startWorkThread();
        }
    }

    public void launchActivity(@NonNull Intent intent) {
        this.mContext.startActivity(intent);
    }

    public void launchService(@NonNull Intent intent) {
        this.mContext.startService(intent);
    }

    public void notifyPeerAppInstalled() {
        ILog.d(TAG, "Notifying peer app installed.");
        InterconnectManager.getInstance().post2MainThread(new b(this));
    }

    public void notifyPeerAppRemoved() {
        ILog.d(TAG, "Notifying peer app removed.");
        InterconnectManager.getInstance().post2MainThread(new c(this));
    }

    public void onLocalStarryNetAppDockMenuClick(String str, String str2) {
        List<IAppDockMenuClickListener> list = this.mAppDockMenuClickListenerListMap.get(StarryNetAppUtil.paresStarryNetAppPackage(str));
        if (list == null || list.isEmpty()) {
            list = this.mAppDockMenuClickListenerListMap.get(StarryNetAppUtil.parseStarryNetAppId(str));
        }
        if (list == null || list.isEmpty()) {
            ILog.d(TAG, "未找到对应的按钮监听器");
            return;
        }
        for (IAppDockMenuClickListener onDockMenuClick : list) {
            try {
                onDockMenuClick.onDockMenuClick(str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void openRemoteStarryNetApp(String str, String str2, OpenRemoteStarryNetAppCallback openRemoteStarryNetAppCallback) {
        StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
        if (connectedDevice == null) {
            invokeOpenRemoteStarryNetAppCallback(openRemoteStarryNetAppCallback, OpenRemoteStarryNetAppCode.CODE_NO_DEVICE);
            return;
        }
        StarryNetMessenger starryNetMessenger = InterconnectManager.getInstance().getStarryNetMessenger();
        if (!starryNetMessenger.canSendMessage(connectedDevice.getId())) {
            RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
            if (relayAbility == null) {
                invokeOpenRemoteStarryNetAppCallback(openRemoteStarryNetAppCallback, OpenRemoteStarryNetAppCode.CODE_STARRY_SDK_NOT_AVAILABLE);
                return;
            }
            RelayBean relayBean = new RelayBean();
            relayBean.setTargetDeviceId(connectedDevice.getId()).setTargetUniteCode(InterconnectManager.getInstance().getPeerPackageName()).setHost("com.upuphone.bridge").setData(new byte[0]);
            if (relayAbility.startRemote(relayBean) != 0) {
                invokeOpenRemoteStarryNetAppCallback(openRemoteStarryNetAppCallback, OpenRemoteStarryNetAppCode.CODE_PULL_MAIN_APP_FAIL);
                return;
            }
        }
        String uuid = UUID.randomUUID().toString();
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(11, new LaunchAppParam(str, str2, uuid)).toString());
        Handler handler = new Handler(Looper.getMainLooper());
        if (starryNetMessenger.canSendMessage(connectedDevice.getId())) {
            starryNetMessenger.sendMessage(createInnerMessage, new LaunchStarryNetAppListener(uuid, openRemoteStarryNetAppCallback));
        } else {
            handler.postDelayed(new d(this, starryNetMessenger, createInnerMessage, uuid, openRemoteStarryNetAppCallback), AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    public List<StarryNetApp> queryLocalStarryNetApp(String str) {
        DeDuplicateArrayList deDuplicateArrayList = new DeDuplicateArrayList();
        for (StarryNetApp next : this.mLocalStarryNetAppList) {
            if (next.getPackageName().equals(str)) {
                deDuplicateArrayList.add(next);
            }
        }
        return deDuplicateArrayList;
    }

    public List<StarryNetAppDockMenu> queryLocalStarryNetAppDockMenuList(String str) {
        for (StarryNetApp next : this.mLocalStarryNetAppList) {
            if (next.getId().equals(str)) {
                return next.getDockMenuList();
            }
        }
        return null;
    }

    public List<StarryNetApp> queryLocalStarryNetAppList() {
        return getCopiedData(this.mLocalStarryNetAppList);
    }

    public List<StarryNetApp> queryRemoteStarryNetAppList() {
        return getCopiedData(this.mRemoteStarryNetAppList);
    }

    public void registerMenuClickListener(String str, IAppDockMenuClickListener iAppDockMenuClickListener) {
        if (iAppDockMenuClickListener != null) {
            List list = this.mAppDockMenuClickListenerListMap.get(str);
            if (list == null) {
                list = new DeDuplicateArrayList();
                this.mAppDockMenuClickListenerListMap.put(str, list);
            }
            list.add(iAppDockMenuClickListener);
        }
    }

    public void registerStarryNetAppChangeListener(StarryNetAppChangeListener starryNetAppChangeListener) {
        if (starryNetAppChangeListener != null) {
            this.mStarryNetAppChangeListenerList.add(starryNetAppChangeListener);
            starryNetAppChangeListener.onRemoteStarryNetAppListChange(getMergedStarryNetAppList());
            ((StarryNetDeviceManagerImpl) InterconnectManager.getInstance().getStarryNetDeviceManager()).connectManager.getPeerAppStatusManager().warmUpListener(starryNetAppChangeListener);
        }
    }

    public void startScan() {
        this.mHandler.post(new a(this));
    }

    public void unregisterMenuClickListener(String str, IAppDockMenuClickListener iAppDockMenuClickListener) {
        List list;
        if (iAppDockMenuClickListener != null && (list = this.mAppDockMenuClickListenerListMap.get(str)) != null) {
            list.remove(iAppDockMenuClickListener);
        }
    }

    public void unregisterStarryNetAppChangeListener(StarryNetAppChangeListener starryNetAppChangeListener) {
        this.mStarryNetAppChangeListenerList.remove(starryNetAppChangeListener);
    }
}
