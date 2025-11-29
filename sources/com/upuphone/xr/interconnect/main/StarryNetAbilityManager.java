package com.upuphone.xr.interconnect.main;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.audio.PhoneAbility;
import com.upuphone.starrynetsdk.ability.relay.BypassAbility;
import com.upuphone.starrynetsdk.ability.relay.BypassListener;
import com.upuphone.starrynetsdk.ability.relay.IMultiBypassAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.starrynetsdk.device.discovery.DevicesDiscoverer;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class StarryNetAbilityManager {
    private Context enabledContext;
    private IMultiBypassAbility iMultiBypassAbility;
    private DevicesConnector mDevicesConnector;
    private DevicesDiscoverer mDevicesDiscoverer;
    private List<OnStarryAbilityStateListener> mOnStarryAbilityStateListeners;
    private PhoneAbility mPhoneAbility;
    private RelayAbility mRelayAbility;
    private ShareAbility mShareAbility;
    private BypassAbility mUserBypassAbility;
    private CopyOnWriteArrayList ringMsgListener;

    public static final class Holder {
        /* access modifiers changed from: private */
        public static StarryNetAbilityManager INSTANCE = new StarryNetAbilityManager();

        private Holder() {
        }
    }

    public interface OnStarryAbilityStateListener {
        void onStateChanged(boolean z);
    }

    public static StarryNetAbilityManager getInstance() {
        return Holder.INSTANCE;
    }

    private void notifyStarryAbilityStateChanged(boolean z) {
        if (!this.mOnStarryAbilityStateListeners.isEmpty()) {
            for (OnStarryAbilityStateListener onStateChanged : this.mOnStarryAbilityStateListeners) {
                onStateChanged.onStateChanged(z);
            }
        }
    }

    public void destroyStarryDlnaSdk() {
    }

    public BypassAbility getBypassAbility() {
        return this.mUserBypassAbility;
    }

    public DevicesConnector getDevicesConnector() {
        return this.mDevicesConnector;
    }

    public DevicesDiscoverer getDevicesDiscoverer() {
        return this.mDevicesDiscoverer;
    }

    public IMultiBypassAbility getMultiBypassAbility() {
        return this.iMultiBypassAbility;
    }

    public PhoneAbility getPhoneAbility() {
        return this.mPhoneAbility;
    }

    public RelayAbility getRelayAbility() {
        return this.mRelayAbility;
    }

    public ShareAbility getShareAbility() {
        return this.mShareAbility;
    }

    public void init(Context context) {
        this.enabledContext = context;
        this.mDevicesDiscoverer = new DevicesDiscoverer();
        this.mDevicesConnector = new DevicesConnector();
        this.mRelayAbility = new RelayAbility(context);
        this.mUserBypassAbility = new BypassAbility();
        this.iMultiBypassAbility = new IMultiBypassAbility(context);
        this.mShareAbility = new ShareAbility(context);
        this.mPhoneAbility = new PhoneAbility();
        notifyStarryAbilityStateChanged(true);
    }

    public void registerMultiBypassAbility(String str, String str2, BypassListener bypassListener, String str3) {
        ULog.f("StarryNetAbilityManager", "registerMultiBypassAbility serviceUuid = " + str);
        ULog.f("StarryNetAbilityManager", "registerMultiBypassAbility characterUuid = " + str2);
        IMultiBypassAbility iMultiBypassAbility2 = this.iMultiBypassAbility;
        if (iMultiBypassAbility2 == null) {
            ULog.f("StarryNetAbilityManager", "iMultiBypassAbility is null return");
        } else {
            iMultiBypassAbility2.registerBypassListener(str, str2, bypassListener, str3);
        }
    }

    public void registerOnStarryAbilityStateListener(OnStarryAbilityStateListener onStarryAbilityStateListener) {
        if (onStarryAbilityStateListener != null) {
            this.mOnStarryAbilityStateListeners.add(onStarryAbilityStateListener);
        }
    }

    public void reset() {
        this.enabledContext = null;
        this.mDevicesDiscoverer = null;
        this.mDevicesConnector = null;
        this.mRelayAbility = null;
        this.mUserBypassAbility = null;
        this.iMultiBypassAbility = null;
        this.mShareAbility = null;
        this.mPhoneAbility = null;
        notifyStarryAbilityStateChanged(false);
    }

    public void unRegisterMultiBypassAbility(String str, String str2, BypassListener bypassListener, String str3) {
        ULog.f("StarryNetAbilityManager", "unRegisterMultiBypassAbility serviceUuid = " + str);
        ULog.f("StarryNetAbilityManager", "unRegisterMultiBypassAbility characterUuid = " + str2);
        IMultiBypassAbility iMultiBypassAbility2 = this.iMultiBypassAbility;
        if (iMultiBypassAbility2 == null) {
            ULog.f("StarryNetAbilityManager", "iMultiBypassAbility is null return");
        } else {
            iMultiBypassAbility2.unregisterBypassListener(str, str2, bypassListener, str3);
        }
    }

    public void unregisterOnStarryAbilityStateListener(OnStarryAbilityStateListener onStarryAbilityStateListener) {
        if (onStarryAbilityStateListener != null) {
            this.mOnStarryAbilityStateListeners.remove(onStarryAbilityStateListener);
        }
    }

    private StarryNetAbilityManager() {
        this.enabledContext = null;
        this.ringMsgListener = new CopyOnWriteArrayList();
        this.mOnStarryAbilityStateListeners = new DeDuplicateCopyOnWriteArrayList();
    }
}
