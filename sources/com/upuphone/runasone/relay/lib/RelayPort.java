package com.upuphone.runasone.relay.lib;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import com.honey.account.f6.a;
import com.honey.account.f6.b;
import com.upuphone.runasone.RelayApi;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.ApiRelayMsgAdapter;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.api.ApiRelayMsgImp;
import com.upuphone.runasone.relay.lib.device.MessageManager;
import com.upuphone.runasone.relay.lib.device.RelayDeviceManager;
import com.upuphone.runasone.relay.lib.manager.AppConfigManager;
import com.upuphone.runasone.relay.lib.manager.RelayBean;
import com.upuphone.runasone.relay.lib.track.RelayTrackManager;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class RelayPort implements IAbilitySlot {
    private static final String TAG = "RelayPort";
    private static RelayPort instance = new RelayPort();
    public static final boolean isSupportMapping = false;
    ApiRelayMsgAdapter adapter;
    private BiConsumer<Integer, Map<String, Integer>> appChangeCall = new a();
    private final Set<String> binderSet = Collections.synchronizedSet(new LinkedHashSet());
    private Set<String> mappingMatch = new HashSet();

    private RelayPort() {
        AppConfigManager.getInstance().addAppChangeCall(this.appChangeCall);
    }

    public static RelayPort getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$appStateChanged$1(int i, String str, StarryDevice starryDevice) {
        if (i == 1) {
            MessageManager.getInstance().sendRemoteSuccess(new StarryTag(starryDevice.getId(), str, ""));
        } else if (i == 0) {
            MessageManager.getInstance().sendRemoteFailed(new StarryTag(starryDevice.getId(), str, ""), RelayErrorCode.BINDER_UN_CONNECT);
            RelayDeviceManager.getInstance().removeRelayListener(str, (String) null);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Integer num, Map map) {
        if (1 == num.intValue()) {
            MessageManager.getInstance().UpdateAbility(map, RelayApi.AppUniteCodeType.ADD);
        } else if (2 == num.intValue()) {
            MessageManager.getInstance().UpdateAbility(map, RelayApi.AppUniteCodeType.DEL);
        }
    }

    public void appStateChanged(int i, String str, String str2, int i2) {
        if (i2 == 1) {
            this.binderSet.add(str2);
            String str3 = TAG;
            LogUtil.dPrimary(str3, "binder STATE_CONNECT " + str2);
        } else if (i2 == 0) {
            this.binderSet.remove(str2);
            String str4 = TAG;
            LogUtil.dPrimary(str4, "binder STATE_DISCONNECT " + str2);
        }
        RelayDeviceManager.getInstance().getDeviceList().forEach(new b(i2, str2));
    }

    public void attach(StarryDevice starryDevice, IAbilitySlot.SlotObserver slotObserver, ComponentProperty componentProperty) {
        RelayBean relayBean;
        if (componentProperty == null || componentProperty.getAgreementType() != 1 || !componentProperty.isSupportTlv()) {
            String str = TAG;
            LogUtil.dPrimary(str, str + "attach " + starryDevice.getId() + " ");
            if (componentProperty != null) {
                LogUtil.dPrimary(str, "remoteJson " + componentProperty.getCommitInfo() + " " + componentProperty.getVersion() + componentProperty.getJson());
            }
            if (componentProperty == null || componentProperty.getJson() == null) {
                relayBean = null;
            } else {
                relayBean = (RelayBean) new Gson().fromJson(componentProperty.getJson(), RelayBean.class);
                RelayTrackManager.getSIntance().trackAttach(starryDevice.getId(), relayBean.getMetaInfo());
                relayBean.isSupportMapping();
            }
            RelayDeviceManager.getInstance().putDevice(starryDevice, slotObserver, relayBean);
        }
    }

    public void detach(StarryDevice starryDevice) {
        String str = TAG;
        LogUtil.dPrimary(str, "detach " + starryDevice.getId());
        RelayDeviceManager.getInstance().removeDevice(starryDevice.getId());
    }

    public void input(StarryDevice starryDevice, AbilityMessage abilityMessage) {
        String str = TAG;
        LogUtil.dPrimary(str, "input before unpack  deviceId=" + starryDevice.getId());
        try {
            MessageManager.getInstance().input(starryDevice, RelayApi.Message.parseFrom(abilityMessage.getBypass()));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public boolean isBinderExit(String str) {
        if (BuildConfig.IS_THIRD.booleanValue()) {
            return true;
        }
        return this.binderSet.contains(str);
    }

    public boolean isSupportMapping(String str) {
        return this.mappingMatch.contains(str);
    }

    public void removeRelayListener(String str, String str2) {
        String str3 = TAG;
        LogUtil.dPrimary(str3, "------removeRelayListener------" + str + "  receiveUniteCode=" + str2);
        if (str2 == null || str2.length() == 0) {
            str2 = str;
        }
        RelayDeviceManager.getInstance().removeRelayListener(str, str2);
    }

    public void setRelayListener(String str, String str2, RelayCallback relayCallback) {
        String str3 = TAG;
        LogUtil.dPrimary(str3, "------addRelayListener------" + str + "  receiveUniteCode=" + str2);
        if (relayCallback == null) {
            LogUtil.w("--RelayListener回调接口设置为null");
            return;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = str;
        }
        RelayDeviceManager.getInstance().addRelayListener(str, str2, relayCallback);
    }

    public void setSupportMapping(String str) {
        this.mappingMatch.add(str);
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        if (this.adapter == null) {
            this.adapter = new ApiRelayMsgAdapter(new ApiRelayMsgImp());
        }
        this.adapter.adapt(bundle, bundle2);
    }
}
