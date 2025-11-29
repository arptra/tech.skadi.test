package com.upuphone.runasone.lifecycle.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.honey.account.d6.a;
import com.honey.account.d6.b;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.core.api.ApiConstant;
import com.upuphone.runasone.lifecycle.bean.LifecycleServiceConnection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class LifecycleManager {
    private static final String TAG = "LifecycleManager";
    private static final LifecycleManager sInstance = new LifecycleManager();
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mMainHandler;
    /* access modifiers changed from: private */
    public final Map<String, ServiceConnection> mRegisterApp = new ConcurrentHashMap();

    private void bindService(String str) {
        Log.d(TAG, "bindService: " + this.mRegisterApp);
        if (this.mContext != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, ApiConstant.LIFECYCLE_SERVICE));
            this.mContext.bindService(intent, makeServiceConnection(), 1);
            Log.d(TAG, "bindService: s");
            return;
        }
        Log.e(TAG, "bindService: Context is null");
    }

    public static LifecycleManager getInstance() {
        return sInstance;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAppRegistered$0(String str) {
        if (this.mRegisterApp.get(str) == null) {
            bindService(str);
        }
    }

    private ServiceConnection makeServiceConnection() {
        Log.d(TAG, "makeServiceConnection: " + this.mRegisterApp);
        return new LifecycleServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(LifecycleManager.TAG, this + ":onServiceConnected: " + LifecycleManager.this.mRegisterApp);
                LifecycleManager.this.mRegisterApp.put(componentName.getPackageName(), this);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                super.onServiceDisconnected(componentName);
                Log.d(LifecycleManager.TAG, this + ":onServiceDisconnected: " + componentName + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + LifecycleManager.this.mRegisterApp + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + getNeedReBind());
                if (getNeedReBind()) {
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    LifecycleManager.this.mContext.bindService(intent, this, 1);
                }
            }
        };
    }

    private void postMainRunnable(Runnable runnable) {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        this.mMainHandler.post(runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: unBindService */
    public void lambda$onAppUnregistered$1(String str) {
        Log.d(TAG, "unBindService: " + this.mRegisterApp);
        if (!(this.mContext == null || this.mRegisterApp.get(str) == null)) {
            Context context = this.mContext;
            ServiceConnection serviceConnection = this.mRegisterApp.get(str);
            Objects.requireNonNull(serviceConnection);
            context.unbindService(serviceConnection);
        }
        this.mRegisterApp.remove(str);
    }

    public void onAppDied(String str) {
        Log.d(TAG, "onAppDied: " + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.mRegisterApp);
    }

    public void onAppRegistered(String str) {
        Log.d(TAG, "onAppRegistered: " + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.mRegisterApp);
        postMainRunnable(new b(this, str));
    }

    public void onAppUnregistered(String str) {
        Log.d(TAG, "onAppUnregistered: " + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.mRegisterApp);
        postMainRunnable(new a(this, str));
    }

    public void setContext(Context context) {
        this.mContext = context;
    }
}
