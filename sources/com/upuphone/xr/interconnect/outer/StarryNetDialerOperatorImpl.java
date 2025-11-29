package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.api.StarryNetDialerOperator;
import com.upuphone.xr.interconnect.common.IDialerManager;
import com.upuphone.xr.interconnect.listener.DialerListener;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import java.util.List;

public class StarryNetDialerOperatorImpl implements StarryNetDialerOperator, SuperServiceStateListener {
    private static final String TAG = "StarryNetDialerOperatorImpl";
    private List<DialerListener> mDialerListeners = new DeDuplicateCopyOnWriteArrayList();
    private IDialerManager mDialerManager;
    private SuperServiceProvider mProvider;

    public void dial(@NonNull int i, @Nullable String str) {
        IDialerManager iDialerManager = this.mDialerManager;
        if (iDialerManager != null) {
            try {
                iDialerManager.dial(i, str);
            } catch (RemoteException unused) {
            }
        } else {
            Log.w(TAG, "mDialerManager为空，暂不能dial");
        }
    }

    public void onServiceConnected() {
        IDialerManager dialerManager = this.mProvider.getDialerManager();
        this.mDialerManager = dialerManager;
        if (dialerManager != null && this.mDialerListeners.size() > 0) {
            for (DialerListener registerDialerListener : this.mDialerListeners) {
                try {
                    this.mDialerManager.registerDialerListener(registerDialerListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onServiceDied() {
        this.mDialerManager = null;
    }

    public void registerDialerListener(DialerListener dialerListener) {
        if (dialerListener != null) {
            this.mDialerListeners.add(dialerListener);
            IDialerManager iDialerManager = this.mDialerManager;
            if (iDialerManager != null) {
                try {
                    iDialerManager.registerDialerListener(dialerListener);
                } catch (RemoteException unused) {
                }
            } else {
                Log.w(TAG, "mDialerManager为空，暂不能registerDialerListener");
            }
        }
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void syncPhoneBook() {
        IDialerManager iDialerManager = this.mDialerManager;
        if (iDialerManager != null) {
            try {
                iDialerManager.syncPhoneBook();
            } catch (RemoteException unused) {
            }
        } else {
            Log.w(TAG, "mDialerManager为空，暂不能syncPhoneBook");
        }
    }

    public void unregisterDialerListener(DialerListener dialerListener) {
        if (dialerListener != null) {
            this.mDialerListeners.remove(dialerListener);
            IDialerManager iDialerManager = this.mDialerManager;
            if (iDialerManager != null) {
                try {
                    iDialerManager.unregisterDialerListener(dialerListener);
                } catch (RemoteException unused) {
                }
            } else {
                Log.w(TAG, "mDialerManager为空，暂不能unregisterDialerListener");
            }
        }
    }
}
