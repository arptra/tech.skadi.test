package com.upuphone.xr.interconnect.api;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.starrynetsdk.ability.audio.PhoneAbility;
import com.upuphone.starrynetsdk.ability.audio.PhoneListener;
import com.upuphone.xr.interconnect.common.IDialerListener;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import com.upuphone.xr.interconnect.util.ExceptionLogUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;

public class StarryNetDialerManagerImpl implements StarryNetDialerManager, StarryNetAbilityManager.OnStarryAbilityStateListener {
    private static final String TAG = "StarryNetDialerManagerImpl";
    private boolean hasRegisterPhoneListener = false;
    /* access modifiers changed from: private */
    public List<IDialerListener> mDialerListeners = new DeDuplicateCopyOnWriteArrayList();
    private final PhoneListener mPhoneListener = new PhoneListener() {
        public void onAddressBookSyncState(int i) {
            if (StarryNetDialerManagerImpl.this.mDialerListeners.size() > 0) {
                ILog.d(StarryNetDialerManagerImpl.TAG, "onAddressBookSyncState state--" + i);
                for (IDialerListener onSyncPhoneBookStateChanged : StarryNetDialerManagerImpl.this.mDialerListeners) {
                    try {
                        onSyncPhoneBookStateChanged.onSyncPhoneBookStateChanged(i);
                    } catch (RemoteException e) {
                        ExceptionLogUtil.print(StarryNetDialerManagerImpl.TAG, e, "IDialerListener", "onSyncPhoneBookStateChanged");
                    }
                }
            }
        }

        public void onPhoneStateChanged(String str, int i) {
            if (StarryNetDialerManagerImpl.this.mDialerListeners.size() > 0) {
                ILog.d(StarryNetDialerManagerImpl.TAG, "onPhoneStateChanged phoneNum--" + str + ",state--" + i);
                for (IDialerListener onDialerStateChanged : StarryNetDialerManagerImpl.this.mDialerListeners) {
                    try {
                        onDialerStateChanged.onDialerStateChanged(str, i);
                    } catch (RemoteException e) {
                        ExceptionLogUtil.print(StarryNetDialerManagerImpl.TAG, e, "IDialerListener", "onDialerStateChanged");
                    }
                }
            }
        }
    };

    public StarryNetDialerManagerImpl() {
        StarryNetAbilityManager.getInstance().registerOnStarryAbilityStateListener(this);
    }

    private PhoneAbility getPhoneAbility() {
        return StarryNetAbilityManager.getInstance().getPhoneAbility();
    }

    private void registerPhoneListener() {
        if (!this.mDialerListeners.isEmpty() && !this.hasRegisterPhoneListener) {
            int registerPhoneListener = getPhoneAbility().registerPhoneListener(this.mPhoneListener);
            ILog.d(TAG, "registerPhoneListener返回code--" + registerPhoneListener);
            this.hasRegisterPhoneListener = registerPhoneListener == 0;
        }
    }

    public boolean dial(@NonNull int i, @Nullable String str) {
        PhoneAbility phoneAbility = getPhoneAbility();
        if (phoneAbility != null) {
            int dail = phoneAbility.dail(i, str);
            ILog.d(TAG, "dial params action--" + i + "，phoneNumber--" + str + "，返回code--" + dail);
            return dail == 0;
        }
        ILog.d(TAG, "dial params action--" + i + "，phoneNumber--" + str + "，请求失败--PhoneAbility为空");
        return false;
    }

    public void onStateChanged(boolean z) {
        if (z) {
            registerPhoneListener();
        } else {
            this.hasRegisterPhoneListener = false;
        }
    }

    public void registerDialerListener(IDialerListener iDialerListener) {
        if (iDialerListener != null) {
            this.mDialerListeners.add(iDialerListener);
            registerPhoneListener();
        }
    }

    public boolean syncPhoneBook() {
        PhoneAbility phoneAbility = getPhoneAbility();
        if (phoneAbility != null) {
            int syncAddressBook = phoneAbility.syncAddressBook();
            ILog.d(TAG, "syncPhoneBook返回code--" + syncAddressBook);
            return syncAddressBook == 0;
        }
        ILog.d(TAG, "syncPhoneBook请求失败--PhoneAbility为空");
        return false;
    }

    public void unregisterDialerListener(IDialerListener iDialerListener) {
        if (iDialerListener != null) {
            this.mDialerListeners.remove(iDialerListener);
            PhoneAbility phoneAbility = getPhoneAbility();
            if (this.mDialerListeners.isEmpty() && phoneAbility != null) {
                int unregisterPhoneListener = phoneAbility.unregisterPhoneListener(this.mPhoneListener);
                ILog.d(TAG, "unregisterPhoneListener返回code--" + unregisterPhoneListener);
                if (unregisterPhoneListener == 0) {
                    this.hasRegisterPhoneListener = false;
                }
            }
        }
    }
}
