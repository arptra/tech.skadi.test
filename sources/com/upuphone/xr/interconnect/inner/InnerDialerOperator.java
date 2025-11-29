package com.upuphone.xr.interconnect.inner;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDialerOperator;
import com.upuphone.xr.interconnect.common.IDialerListener;
import com.upuphone.xr.interconnect.listener.DialerListener;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import java.util.List;

public class InnerDialerOperator implements StarryNetDialerOperator {
    private static final String TAG = "InnerDialerOperator";
    private List<DialerListener> mDialerListeners = new DeDuplicateCopyOnWriteArrayList();
    private String pkgName;

    public InnerDialerOperator(String str) {
        this.pkgName = str;
    }

    public void dial(@NonNull int i, @Nullable String str) {
        if (!InterconnectManager.getInstance().getStarryNetDialerManager().dial(i, str) && this.mDialerListeners.size() > 0) {
            for (IDialerListener onDialerStateChanged : this.mDialerListeners) {
                try {
                    onDialerStateChanged.onDialerStateChanged(str, -1);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public void registerDialerListener(DialerListener dialerListener) {
        if (dialerListener != null) {
            this.mDialerListeners.add(dialerListener);
            InterconnectManager.getInstance().getStarryNetDialerManager().registerDialerListener(dialerListener);
        }
    }

    public void syncPhoneBook() {
        if (!InterconnectManager.getInstance().getStarryNetDialerManager().syncPhoneBook() && this.mDialerListeners.size() > 0) {
            for (IDialerListener onSyncPhoneBookStateChanged : this.mDialerListeners) {
                try {
                    onSyncPhoneBookStateChanged.onSyncPhoneBookStateChanged(2);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public void unregisterDialerListener(DialerListener dialerListener) {
        if (dialerListener != null) {
            this.mDialerListeners.remove(dialerListener);
            InterconnectManager.getInstance().getStarryNetDialerManager().unregisterDialerListener(dialerListener);
        }
    }
}
