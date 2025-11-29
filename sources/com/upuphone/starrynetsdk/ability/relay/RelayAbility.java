package com.upuphone.starrynetsdk.ability.relay;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.ApiRelayMsgProxy;
import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.util.RelayConst;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.api.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class RelayAbility extends Ability {
    private static final String TAG = "RelayAbility";
    private int MAX_MSG_NUM;
    private final int RELAY_TAG;
    private final ApiRelayMsgProxy api = new ApiRelayMsgProxy();
    private HandlerThread handlerThread;
    /* access modifiers changed from: private */
    public final AtomicInteger integer;
    private final LinkedList<HandlerData> list;
    private final RelayListenerManager listenerManager;
    private Handler mThreadHandler;
    private final Object obj;
    private final String uniteCode;

    public RelayAbility(Context context) {
        RelayListenerManager instance = RelayListenerManager.getInstance();
        this.listenerManager = instance;
        this.obj = new Object();
        this.list = new LinkedList<>();
        this.RELAY_TAG = 1;
        this.integer = new AtomicInteger(0);
        this.MAX_MSG_NUM = 20;
        String appUniteCode = Util.getAppUniteCode(context);
        this.uniteCode = appUniteCode;
        instance.init(appUniteCode);
        Camp.getInstance().addSentry(this);
    }

    private void initThread() {
        HandlerThread handlerThread2 = new HandlerThread(RelayConst.RELAY_COMP);
        this.handlerThread = handlerThread2;
        handlerThread2.start();
        this.mThreadHandler = new Handler(this.handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                HandlerData handlerData;
                if (message.what == 1 && (handlerData = (HandlerData) message.obj) != null) {
                    RelayAbility.this.relay(handlerData.getRelayBean(), handlerData.getListener());
                    RelayAbility.this.recycleData(handlerData);
                    RelayAbility.this.integer.decrementAndGet();
                }
            }
        };
    }

    private HandlerData obtain(RelayBean relayBean, RemoteListener remoteListener) {
        HandlerData poll;
        synchronized (this.obj) {
            poll = this.list.poll();
        }
        if (poll == null || poll.isUsing()) {
            HandlerData handlerData = new HandlerData(relayBean, remoteListener);
            handlerData.setUsing(true);
            return handlerData;
        }
        poll.setRelayBean(relayBean);
        poll.setListener(remoteListener);
        poll.setUsing(true);
        return poll;
    }

    /* access modifiers changed from: private */
    public void recycleData(HandlerData handlerData) {
        handlerData.setRelayBean((RelayBean) null);
        handlerData.setListener((RemoteListener) null);
        handlerData.setUsing(false);
        synchronized (this.obj) {
            try {
                if (this.list.size() < 10) {
                    this.list.addLast(handlerData);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int relay(RelayBean relayBean) {
        return relay(relayBean, (RemoteListener) null);
    }

    private int relayOnce(final StarryTag starryTag, byte[] bArr, int i, StarryParam starryParam, final RemoteListener remoteListener) {
        if (remoteListener != null) {
            try {
                this.api.sendMessageQos(starryTag, new ArrayData(bArr), i, starryParam, new SendRelayMessageCallBack() {
                    public void onError(int i, String str) {
                        remoteListener.onFailure(starryTag.getReceiveAppUniteCode(), i);
                    }

                    public void onSuccess() {
                        remoteListener.onSuccess(starryTag.getReceiveAppUniteCode());
                    }
                });
                return 0;
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "relay failed.", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "relay failed.", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        } else {
            this.api.sendMessageQos(starryTag, new ArrayData(bArr), i, starryParam, (SendRelayMessageCallBack) null);
            return 0;
        }
    }

    public List<StarryDevice> getRelayDeviceList() {
        SNSLog.d(TAG, "getRelayDeviceList");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getRelayDeviceList failed.");
            return null;
        }
        try {
            return this.api.getRelayDeviceList(this.uniteCode);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "startRemote failed.", e);
            return null;
        }
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
    }

    public int registerRelayListener(RelayListener relayListener, String... strArr) {
        return registerRelayListener(relayListener, 0, strArr);
    }

    public int relayAsync(RelayBean relayBean, RemoteListener remoteListener) {
        if (this.handlerThread == null || this.mThreadHandler == null) {
            synchronized (this) {
                try {
                    if (this.handlerThread != null) {
                        if (this.mThreadHandler == null) {
                        }
                    }
                    initThread();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        if (this.integer.get() > this.MAX_MSG_NUM) {
            SNSLog.e(TAG, "relay failed. 缓存数量超限");
            if (remoteListener != null) {
                remoteListener.onFailure(relayBean.getTargetUniteCode(), RelayErrorCode.MSG_OVER_POOL);
            }
            return 1;
        }
        this.integer.incrementAndGet();
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obtain(relayBean, remoteListener);
        this.mThreadHandler.sendMessage(obtain);
        return 0;
    }

    public void setMaxMsgPoll(int i) {
        if (i > 0) {
            this.MAX_MSG_NUM = i;
        }
    }

    public int startRemote(RelayBean relayBean) {
        StarryParam starryParam;
        SNSLog.d(TAG, "startRemote " + relayBean.getTargetUniteCode());
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,startRemote failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            StarryTag starryTag = new StarryTag(relayBean.getTargetDeviceId(), this.uniteCode, relayBean.getTargetUniteCode());
            if (relayBean.getListenerId() > 0) {
                starryParam = new StarryParam();
                starryParam.setListenerId(relayBean.getListenerId());
            } else {
                starryParam = null;
            }
            this.api.startRemote(starryTag, relayBean.getHost(), new ArrayData(relayBean.getData()), relayBean.getType(), starryParam);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startRemote failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startRemote failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int stopRemote(RelayBean relayBean) {
        StarryParam starryParam;
        SNSLog.d(TAG, "stopRemote " + relayBean.getTargetUniteCode());
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,stopRemote failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            StarryTag starryTag = new StarryTag(relayBean.getTargetDeviceId(), this.uniteCode, relayBean.getTargetUniteCode());
            if (relayBean.getListenerId() > 0) {
                starryParam = new StarryParam();
                starryParam.setListenerId(relayBean.getListenerId());
            } else {
                starryParam = null;
            }
            this.api.stopRemote(starryTag, starryParam);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startRemote failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startRemote failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int unregisterRelayListener(RelayListener relayListener) {
        SNSLog.d(TAG, "unregisterRelayListener");
        this.listenerManager.unregisterRelayListener(relayListener);
        return 0;
    }

    public int registerRelayListener(RelayListener relayListener, int i, String... strArr) {
        SNSLog.d(TAG, "registerRelayListener: " + Arrays.toString(strArr));
        if (i < 0 || i > 1000) {
            SNSLog.e(TAG, "registerRelayListener: id不在语序范围内");
            return 1;
        }
        if (strArr.length == 0) {
            strArr = new String[]{this.uniteCode};
        }
        this.listenerManager.registerRelayListener(relayListener, i, strArr);
        return 0;
    }

    public int relay(RelayBean relayBean, RemoteListener remoteListener) {
        StarryParam starryParam;
        List<String> targetUniteCodeList = relayBean.getTargetUniteCodeList();
        boolean z = true;
        if (targetUniteCodeList != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("relay to ");
            sb.append(targetUniteCodeList);
            sb.append(" with ask: ");
            if (remoteListener == null) {
                z = false;
            }
            sb.append(z);
            SNSLog.d(TAG, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("relay to ");
            sb2.append(relayBean.getTargetUniteCode());
            sb2.append(" with ask: ");
            if (remoteListener == null) {
                z = false;
            }
            sb2.append(z);
            SNSLog.d(TAG, sb2.toString());
        }
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,relay failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        if (relayBean.getListenerId() > 0) {
            starryParam = new StarryParam();
            starryParam.setListenerId(relayBean.getListenerId());
        } else {
            starryParam = null;
        }
        if (targetUniteCodeList != null) {
            for (String starryTag : targetUniteCodeList) {
                int relayOnce = relayOnce(new StarryTag(relayBean.getTargetDeviceId(), this.uniteCode, starryTag), relayBean.getData(), relayBean.getQos(), starryParam, remoteListener);
                if (relayOnce < 0) {
                    return relayOnce;
                }
            }
            return 0;
        }
        return relayOnce(new StarryTag(relayBean.getTargetDeviceId(), this.uniteCode, relayBean.getTargetUniteCode()), relayBean.getData(), relayBean.getQos(), starryParam, remoteListener);
    }

    public List<StarryDevice> getRelayDeviceList(String... strArr) {
        SNSLog.d(TAG, "getRelayDeviceList");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getRelayDeviceList failed.");
            return null;
        }
        try {
            HashSet hashSet = new HashSet();
            for (String relayDeviceList : strArr) {
                List<StarryDevice> relayDeviceList2 = this.api.getRelayDeviceList(relayDeviceList);
                if (relayDeviceList2 != null) {
                    hashSet.addAll(relayDeviceList2);
                }
            }
            SNSLog.e(TAG, "set.size = " + hashSet.size());
            return new ArrayList(hashSet);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "startRemote failed.", e);
            return null;
        }
    }
}
