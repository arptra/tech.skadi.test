package com.upuphone.starrynetsdk.ability.relay;

import android.util.ArraySet;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.ApiRelayMsgProxy;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class RelayListenerManager extends ListenerManager {
    private static final String TAG = "RelayListenerManager";
    private final Set<String> allSubscribeUniteCodes;
    private final ApiRelayMsgProxy api;
    private volatile boolean isInit;
    private final List<ListenerBean> listenerList;
    private final RelayCallback relayCallback;
    private String uniteCode;

    public static final class Callback implements RelayCallback {
        private List<ListenerBean> listenerList;

        private Set<RelayListener> getRelayList(String str, int i) {
            HashSet hashSet = new HashSet();
            if (i == 0) {
                this.listenerList.forEach(new b(str, hashSet));
            } else {
                this.listenerList.forEach(new c(i, str, hashSet));
            }
            return hashSet;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$getRelayList$1(String str, Set set, ListenerBean listenerBean) {
            List<String> list = listenerBean.getList();
            if (list != null) {
                for (String equals : list) {
                    if (str.equals(equals)) {
                        set.add(listenerBean.getListener());
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$getRelayList$2(int i, String str, Set set, ListenerBean listenerBean) {
            List<String> list;
            if ((i == listenerBean.getListenerId() || listenerBean.getListenerId() == 0) && (list = listenerBean.getList()) != null) {
                for (String equals : list) {
                    if (str.equals(equals)) {
                        set.add(listenerBean.getListener());
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDeviceListChanged$0(List list, String str, ListenerBean listenerBean) {
            RelayListener listener = listenerBean.getListener();
            listener.onRelayDeviceListChanged(list);
            listener.onRelayDeviceListChanged(str, list);
        }

        public void onDeviceListChanged(String str, List<StarryDevice> list) {
            SNSLog.d(RelayListenerManager.TAG, "onDeviceListChanged devList: " + list);
            this.listenerList.forEach(new a(list, str));
        }

        public void onReceiveMessage(StarryTag starryTag, ArrayData arrayData, StarryParam starryParam) {
            String sendAppUniteCode = starryTag.getSendAppUniteCode();
            Set<RelayListener> relayList = getRelayList(sendAppUniteCode, (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId());
            if (relayList.size() == 0) {
                SNSLog.e(RelayListenerManager.TAG, "onReceiveMessage: 未找到匹配的listenerId");
                return;
            }
            for (RelayListener onRelay : relayList) {
                onRelay.onRelay(starryTag.getDeviceId(), sendAppUniteCode, arrayData.getData());
            }
        }

        public void onRemoteError(StarryTag starryTag, int i, String str, StarryParam starryParam) {
            String sendAppUniteCode = starryTag.getSendAppUniteCode();
            SNSLog.d(RelayListenerManager.TAG, "onRemoteError from sendAppUniteCode: " + sendAppUniteCode + " >>> " + i);
            Set<RelayListener> relayList = getRelayList(sendAppUniteCode, (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId());
            if (relayList.size() == 0) {
                SNSLog.e(RelayListenerManager.TAG, "onReceiveMessage: 未找到匹配的listenerId");
                return;
            }
            for (RelayListener onRemoteError : relayList) {
                onRemoteError.onRemoteError(starryTag.getDeviceId(), sendAppUniteCode, i);
            }
        }

        public void onRemoteStart(StarryTag starryTag, StarryParam starryParam) {
            String sendAppUniteCode = starryTag.getSendAppUniteCode();
            SNSLog.d(RelayListenerManager.TAG, "onRemoteStart from sendAppUniteCode: " + sendAppUniteCode);
            Set<RelayListener> relayList = getRelayList(sendAppUniteCode, (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId());
            if (relayList.size() == 0) {
                SNSLog.e(RelayListenerManager.TAG, "onReceiveMessage: 未找到匹配的listenerId");
                return;
            }
            for (RelayListener onRemoteStarted : relayList) {
                onRemoteStarted.onRemoteStarted(starryTag.getDeviceId(), sendAppUniteCode);
            }
        }

        public void onRemoteStop(StarryTag starryTag, StarryParam starryParam) {
            String sendAppUniteCode = starryTag.getSendAppUniteCode();
            Set<RelayListener> relayList = getRelayList(sendAppUniteCode, (starryParam == null || starryParam.getListenerId() <= 0) ? 0 : starryParam.getListenerId());
            if (relayList.size() == 0) {
                SNSLog.e(RelayListenerManager.TAG, "onReceiveMessage: 未找到匹配的listenerId");
                return;
            }
            for (RelayListener onRemoteStopped : relayList) {
                onRemoteStopped.onRemoteStopped(starryTag.getDeviceId(), sendAppUniteCode);
            }
        }

        private Callback(List<ListenerBean> list) {
            this.listenerList = list;
        }
    }

    public static class Holder {
        /* access modifiers changed from: private */
        public static final RelayListenerManager INSTANCE = new RelayListenerManager();

        private Holder() {
        }
    }

    private void doRegisterRelayCallBack(boolean z, Collection<String> collection) {
        SNSLog.d(TAG, "doRegisterRelayCallBack form restore: " + z);
        if (collection.isEmpty()) {
            SNSLog.e(TAG, "subscribeUniteCodes is null or empty , unnecessary doRegisterRelayCallback");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterRelayCallback failed.");
        } else {
            for (String relayListener : collection) {
                try {
                    this.api.setRelayListener(this.uniteCode, relayListener, this.relayCallback);
                } catch (HubRemoteException | HubTargetException e) {
                    SNSLog.e(TAG, "doRegisterRelayCallback failed.", e);
                }
            }
        }
    }

    private void doUnregisterRelayCallBack(Collection<String> collection) {
        SNSLog.d(TAG, "doUnregisterRelayCallBack");
        if (collection.isEmpty()) {
            SNSLog.e(TAG, "RemoveUniteCodes is null or empty , unnecessary doUnregisterRelayCallBack");
        } else if (isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doUnregisterRelayCallBack failed.");
        } else {
            for (String removeRelayListener : collection) {
                try {
                    this.api.removeRelayListener(this.uniteCode, removeRelayListener);
                } catch (HubRemoteException | HubTargetException e) {
                    SNSLog.e(TAG, "doRegisterRelayCallback failed.", e);
                }
            }
        }
    }

    public static RelayListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(String str) {
        if (!this.isInit) {
            this.isInit = true;
            this.uniteCode = str;
            Camp.getInstance().addSentry(this);
        }
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
        doRegisterRelayCallBack(true, this.allSubscribeUniteCodes);
    }

    public void registerRelayListener(RelayListener relayListener, String... strArr) {
        registerRelayListener(relayListener, 0, strArr);
    }

    public synchronized void unregisterRelayListener(RelayListener relayListener) {
        SNSLog.d(TAG, String.format("registerRelayListener relayListener=%s", new Object[]{relayListener == null ? "null" : relayListener.toString()}));
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ListenerBean listenerBean = null;
        for (ListenerBean next : this.listenerList) {
            if (relayListener.equals(next.getListener())) {
                arrayList.add(next);
                listenerBean = next;
            }
            hashSet.addAll(next.getList());
        }
        this.listenerList.removeAll(arrayList);
        if (listenerBean != null) {
            List<String> list = listenerBean.getList();
            ArraySet arraySet = new ArraySet();
            if (list != null) {
                for (String next2 : list) {
                    if (!hashSet.contains(next2)) {
                        arraySet.add(next2);
                    }
                }
            }
            this.allSubscribeUniteCodes.removeAll(arraySet);
            doUnregisterRelayCallBack(arraySet);
        }
    }

    private RelayListenerManager() {
        this.api = new ApiRelayMsgProxy();
        List<ListenerBean> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.listenerList = synchronizedList;
        this.relayCallback = new Callback(synchronizedList);
        this.allSubscribeUniteCodes = Collections.synchronizedSet(new ArraySet());
    }

    public synchronized void registerRelayListener(RelayListener relayListener, int i, String... strArr) {
        ListenerBean listenerBean;
        SNSLog.d(TAG, String.format("registerRelayListener relayListener=%s", new Object[]{relayListener == null ? "null" : relayListener.toString()}));
        List asList = Arrays.asList(strArr);
        Iterator<ListenerBean> it = this.listenerList.iterator();
        while (true) {
            if (!it.hasNext()) {
                listenerBean = null;
                break;
            }
            listenerBean = it.next();
            if (listenerBean.getListener().equals(relayListener)) {
                break;
            }
        }
        if (listenerBean == null) {
            listenerBean = new ListenerBean();
            this.listenerList.add(listenerBean);
        }
        listenerBean.setListener(relayListener);
        listenerBean.setList(asList);
        listenerBean.setListenerId(i);
        this.allSubscribeUniteCodes.addAll(asList);
        doRegisterRelayCallBack(false, asList);
    }
}
