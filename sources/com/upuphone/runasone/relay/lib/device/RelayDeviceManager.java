package com.upuphone.runasone.relay.lib.device;

import com.honey.account.h6.a;
import com.honey.account.h6.b;
import com.honey.account.h6.c;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.manager.RelayBean;
import com.upuphone.runasone.relay.lib.track.RelayTrackManager;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.runasone.relay.lib.utils.UtilUse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RelayDeviceManager {
    private static RelayDeviceManager instance = new RelayDeviceManager();
    private final String TAG = RelayDeviceManager.class.getSimpleName();
    private final ConcurrentHashMap<String, RelayCallback> listenerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AbilityBean> mDeviceMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Set<String>> remoteListenerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, SendRelayMessageCallBack> sendListenerMap = new ConcurrentHashMap<>();

    private RelayDeviceManager() {
    }

    public static RelayDeviceManager getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$callRelayCallbackOnRemove$1(StarryTag starryTag, int i, RelayCallback relayCallback) {
        callIRelayBack(starryTag, relayCallback, i, (StarryParam) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getRelayListener$0(String str, List list, String str2) {
        RelayCallback relayListener = getRelayListener(str, str2);
        if (relayListener != null) {
            list.add(relayListener);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onDeviceListChanged$2(String str, RelayCallback relayCallback) {
        relayCallback.onDeviceListChanged(str, getAbilityDeviceList(str));
    }

    public void addAppUniteCodeList(String str, Collection<String> collection, Map<String, Integer> map, boolean z) {
        AbilityBean abilityBean = this.mDeviceMap.get(str);
        if (abilityBean != null && collection != null && collection.size() > 0) {
            if (map != null && map.size() > 0) {
                Map<String, Integer> metaMap = abilityBean.getMetaMap();
                Map<Integer, String> codeMap = abilityBean.getCodeMap();
                for (Map.Entry next : map.entrySet()) {
                    String str2 = this.TAG;
                    LogUtil.dPrimary(str2, "映射值   " + ((String) next.getKey()) + "" + next.getValue());
                    metaMap.put((String) next.getKey(), (Integer) next.getValue());
                    codeMap.put((Integer) next.getValue(), (String) next.getKey());
                }
            }
            if (!z || abilityBean.getKeyList() == null) {
                abilityBean.setKeyList(new ArrayList());
            }
            abilityBean.getKeyList().addAll(collection);
            for (String onDeviceListChanged : collection) {
                onDeviceListChanged(onDeviceListChanged);
            }
        }
    }

    public synchronized void addRelayListener(String str, String str2, RelayCallback relayCallback) {
        try {
            Set set = this.remoteListenerMap.get(str2);
            if (set == null) {
                set = Collections.synchronizedSet(new HashSet());
                this.remoteListenerMap.put(str2, set);
            }
            set.add(str);
            this.listenerMap.put(str, relayCallback);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void addSendMessageListener(String str, SendRelayMessageCallBack sendRelayMessageCallBack) {
        this.sendListenerMap.put(str, sendRelayMessageCallBack);
        String str2 = this.TAG;
        LogUtil.dPrimary(str2, "-----sendListenerMap.size= " + this.sendListenerMap.size() + "    mDeviceMap.size=" + this.mDeviceMap.size() + "    listenerMap.size=" + this.listenerMap.size() + "    remoteListenerMap.size=" + this.remoteListenerMap.size());
    }

    public void callIRelayBack(StarryTag starryTag, RelayCallback relayCallback, int i, StarryParam starryParam) {
        if (relayCallback == null) {
            return;
        }
        if (i > 0) {
            String str = this.TAG;
            LogUtil.dPrimary(str, "------REMOTE_FAILED:" + i + "   starryTag= " + starryTag.toString());
            relayCallback.onRemoteError(starryTag, i, RelayErrorCode.getErrorText(i), starryParam);
        } else if (i == 0) {
            String str2 = this.TAG;
            LogUtil.dPrimary(str2, "------REMOTE_STOP:   starryTag= " + starryTag.toString());
            relayCallback.onRemoteStop(starryTag, starryParam);
        } else {
            String str3 = this.TAG;
            LogUtil.dPrimary(str3, "------REMOTE_START:   starryTag= " + starryTag.toString());
            relayCallback.onRemoteStart(starryTag, starryParam);
        }
    }

    public void callRelayCallbackOnRemove(StarryTag starryTag, int i) {
        List<RelayCallback> relayListener = getRelayListener(starryTag.getReceiveAppUniteCode());
        if (relayListener != null) {
            relayListener.forEach(new b(this, starryTag, i));
        }
    }

    public void callRemoteListener(String str, int i, boolean z, StarryParam starryParam) {
        if (z) {
            MessageManager.getInstance().timeOut.sendRemoveRemote(false, str, starryParam != null ? starryParam.getListenerId() : 0);
        }
        if (str != null && str.contains("%")) {
            StarryTag starryTag = UtilUse.getStarryTag(str);
            if (starryTag.getSendAppUniteCode() == null || starryTag.getSendAppUniteCode().length() <= 0) {
                callRelayCallbackOnRemove(starryTag, i);
            } else {
                callIRelayBack(starryTag, getRelayListener(starryTag.getReceiveAppUniteCode(), starryTag.getSendAppUniteCode()), i, starryParam);
            }
        }
    }

    public void callSendMessageListener(String str, int i, boolean z) {
        if (z) {
            MessageManager.getInstance().timeOut.sendRemoveMessage(false, str);
        }
        RelayTrackManager sIntance = RelayTrackManager.getSIntance();
        sIntance.trackSendCallback(str, i + "");
        SendRelayMessageCallBack sendMessageListener = getInstance().getSendMessageListener(str, Boolean.TRUE);
        if (sendMessageListener == null) {
            String str2 = this.TAG;
            LogUtil.dPrimary(str2, "------消息回调，没有回调方法   uniqueKey=" + str);
        } else if (i > 0) {
            String str3 = this.TAG;
            LogUtil.dPrimary(str3, "------MSG_FAILED:" + i + "   uniqueKey=" + str);
            sendMessageListener.onError(i, RelayErrorCode.getErrorText(i));
        } else {
            String str4 = this.TAG;
            LogUtil.dPrimary(str4, "------MSG_SUCCESS   uniqueKey=" + str);
            sendMessageListener.onSuccess();
        }
    }

    public List<StarryDevice> getAbilityDeviceList(String str) {
        ArrayList arrayList = new ArrayList();
        for (AbilityBean next : this.mDeviceMap.values()) {
            if (next.getKeyList() != null && next.getKeyList().contains(str) && !next.isRemoved()) {
                arrayList.add(next.getDevice());
            }
        }
        return arrayList;
    }

    public Map<String, StarryDevice> getAbilityDeviceMap(String str) {
        HashMap hashMap = new HashMap();
        for (AbilityBean next : this.mDeviceMap.values()) {
            if (next.getKeyList() != null && next.getKeyList().contains(str) && !next.isRemoved()) {
                hashMap.put(next.getDevice().getId(), next.getDevice());
            }
        }
        return hashMap;
    }

    public AbilityBean getDeviceById(String str) {
        return this.mDeviceMap.get(str);
    }

    public List<StarryDevice> getDeviceList() {
        ArrayList arrayList = new ArrayList();
        for (AbilityBean device : this.mDeviceMap.values()) {
            arrayList.add(device.getDevice());
        }
        return arrayList;
    }

    public int getReceiveMappingCode(AbilityBean abilityBean, String str) {
        Integer num;
        if (abilityBean == null || (num = abilityBean.getMetaMap().get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public RelayCallback getRelayListener(String str, String str2) {
        Set set = this.remoteListenerMap.get(str);
        if (set == null || !set.contains(str2)) {
            return null;
        }
        return this.listenerMap.get(str2);
    }

    public String getSendMappingAuc(AbilityBean abilityBean, int i) {
        String str;
        if (abilityBean == null || (str = abilityBean.getCodeMap().get(Integer.valueOf(i))) == null) {
            return null;
        }
        return str;
    }

    public SendRelayMessageCallBack getSendMessageListener(String str, Boolean bool) {
        return bool.booleanValue() ? this.sendListenerMap.remove(str) : this.sendListenerMap.get(str);
    }

    public void onDeviceListChanged(String str) {
        List<RelayCallback> relayListener = getRelayListener(str);
        if (relayListener != null) {
            relayListener.forEach(new a(this, str));
        }
    }

    public void putDevice(StarryDevice starryDevice, IAbilitySlot.SlotObserver slotObserver, RelayBean relayBean) {
        ConcurrentHashMap<String, Integer> metaMap;
        AbilityBean abilityBean = new AbilityBean();
        abilityBean.setDevice(starryDevice);
        abilityBean.setObserver(slotObserver);
        this.mDeviceMap.put(starryDevice.getId(), abilityBean);
        if (relayBean != null && (metaMap = relayBean.getMetaMap()) != null) {
            addAppUniteCodeList(starryDevice.getId(), metaMap.keySet(), metaMap, false);
        }
    }

    public void removeAppUniteCodeList(String str, List<String> list, boolean z) {
        Integer remove;
        AbilityBean abilityBean = this.mDeviceMap.get(str);
        if (abilityBean != null && abilityBean.getKeyList() != null && list != null && list.size() > 0) {
            for (String next : list) {
                if (z) {
                    abilityBean.setRemoved(true);
                    callRelayCallbackOnRemove(new StarryTag(str, "", next), RelayErrorCode.DEVICE_DISCONNECT);
                    onDeviceListChanged(next);
                } else if (abilityBean.getKeyList().remove(next)) {
                    if (!(abilityBean.getCodeMap() == null || (remove = abilityBean.getMetaMap().remove(next)) == null)) {
                        abilityBean.getCodeMap().remove(remove);
                    }
                    callRelayCallbackOnRemove(new StarryTag(str, "", next), RelayErrorCode.APP_UNINSTALL);
                    onDeviceListChanged(next);
                }
            }
        }
    }

    public void removeDevice(String str) {
        AbilityBean abilityBean = this.mDeviceMap.get(str);
        if (abilityBean != null) {
            removeAppUniteCodeList(str, abilityBean.getKeyList(), true);
            this.mDeviceMap.remove(str);
        }
    }

    public synchronized void removeRelayListener(String str, String str2) {
        if (str2 != null) {
            try {
                Set set = this.remoteListenerMap.get(str2);
                if (set != null) {
                    set.remove(str);
                    if (set.size() == 0) {
                        this.remoteListenerMap.remove(str2);
                    }
                }
                for (Set<String> contains : this.remoteListenerMap.values()) {
                    if (contains.contains(str)) {
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.listenerMap.remove(str);
    }

    public List<RelayCallback> getRelayListener(String str) {
        Set set = this.remoteListenerMap.get(str);
        if (set == null || set.size() <= 0) {
            return null;
        }
        List<RelayCallback> synchronizedList = Collections.synchronizedList(new ArrayList());
        set.forEach(new c(this, str, synchronizedList));
        if (synchronizedList.size() > 0) {
            return synchronizedList;
        }
        return null;
    }
}
