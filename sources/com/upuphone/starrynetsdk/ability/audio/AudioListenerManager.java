package com.upuphone.starrynetsdk.ability.audio;

import androidx.annotation.NonNull;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.core.api.sys.ApiSystemProxy;
import com.upuphone.runasone.core.api.sys.SysCallData;
import com.upuphone.runasone.core.api.sys.SystemCallBack;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ListenerManager;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AudioListenerManager extends ListenerManager {
    private static final String TAG = "AudioListenerManager";
    private final ApiSystemProxy api;
    private final List<AudioListener> audioListeners;
    private volatile boolean isCallbackRegistered;
    private final List<PhoneListener> phoneListeners;
    private final AudioCallback systemCallback;

    public static final class AudioCallback implements SystemCallBack {
        private final List<AudioListener> audioListeners;
        private final List<PhoneListener> phoneListeners;

        public void callBackData(@NonNull SysCallData sysCallData) {
            switch (sysCallData.getAction()) {
                case 8:
                    StarryDevice device = sysCallData.getDevice();
                    for (AudioListener onDeviceChanged : this.audioListeners) {
                        onDeviceChanged.onDeviceChanged(device);
                    }
                    return;
                case 9:
                    String phoneNum = sysCallData.getPhoneNum();
                    int intValue = sysCallData.getCallState().intValue();
                    for (PhoneListener onPhoneStateChanged : this.phoneListeners) {
                        onPhoneStateChanged.onPhoneStateChanged(phoneNum, intValue);
                    }
                    return;
                case 10:
                    int intValue2 = sysCallData.getPhoneBookState().intValue();
                    for (PhoneListener onAddressBookSyncState : this.phoneListeners) {
                        onAddressBookSyncState.onAddressBookSyncState(intValue2);
                    }
                    return;
                default:
                    return;
            }
        }

        private AudioCallback(List<AudioListener> list, List<PhoneListener> list2) {
            this.audioListeners = list;
            this.phoneListeners = list2;
        }
    }

    public static class Holder {
        /* access modifiers changed from: private */
        public static final AudioListenerManager INSTANCE = new AudioListenerManager();

        private Holder() {
        }
    }

    private void doRegisterSystemCallback(boolean z) {
        SNSLog.d(TAG, "doRegisterSystemCallback from restore: " + z);
        if (this.isCallbackRegistered) {
            SNSLog.e(TAG, "SystemCallback already registered , unnecessary doRegisterSystemCallback");
        } else if (this.audioListeners.isEmpty() && this.phoneListeners.isEmpty()) {
            SNSLog.e(TAG, "Listeners isEmpty , unnecessary doRegisterSystemCallback");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterSystemCallback failed.");
        } else {
            try {
                this.api.registerCallBack(this.systemCallback);
                this.isCallbackRegistered = true;
            } catch (RuntimeException e) {
                SNSLog.e(TAG, "doRegisterSystemCallback failed.", e);
            }
        }
    }

    private void doUnregisterSystemCallback() {
        SNSLog.d(TAG, "doUnregisterSystemCallback");
        if (!this.audioListeners.isEmpty() || !this.phoneListeners.isEmpty()) {
            SNSLog.e(TAG, "Listeners not empty , unnecessary doUnregisterSystemCallback");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doUnregisterSystemCallback failed.");
        } else {
            try {
                this.api.unRegisterCallBack(this.systemCallback);
                this.isCallbackRegistered = false;
            } catch (RuntimeException e) {
                SNSLog.e(TAG, "doUnregisterSystemCallback failed.", e);
            }
        }
    }

    public static AudioListenerManager getInstance() {
        return Holder.INSTANCE;
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
        doRegisterSystemCallback(true);
    }

    public void onUninstalled() {
        super.onUninstalled();
        this.isCallbackRegistered = false;
    }

    public void registerAudioListener(AudioListener audioListener) {
        this.audioListeners.add(audioListener);
        doRegisterSystemCallback(false);
    }

    public void registerPhoneListener(PhoneListener phoneListener) {
        this.phoneListeners.add(phoneListener);
        doRegisterSystemCallback(false);
    }

    public void unregisterAudioListener(AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
        doUnregisterSystemCallback();
    }

    public void unregisterPhoneListener(PhoneListener phoneListener) {
        this.phoneListeners.remove(phoneListener);
        doUnregisterSystemCallback();
    }

    private AudioListenerManager() {
        this.api = new ApiSystemProxy();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.audioListeners = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.phoneListeners = copyOnWriteArrayList2;
        this.systemCallback = new AudioCallback(copyOnWriteArrayList, copyOnWriteArrayList2);
        Camp.getInstance().addSentry(this);
    }
}
