package com.upuphone.xr.interconnect;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.common.ICommonAggregate;
import com.upuphone.xr.interconnect.remote.CommonAggregateImpl;
import com.upuphone.xr.interconnect.util.log.ILog;

public class CommonAggregateService extends Service {
    private static final String TAG = "CommonAggregateService";
    private ICommonAggregate mCommonAggregate;

    @Nullable
    public IBinder onBind(Intent intent) {
        ILog.i(TAG, "onBind");
        return this.mCommonAggregate.asBinder();
    }

    public void onCreate() {
        super.onCreate();
        ILog.i(TAG, "onCreate");
        this.mCommonAggregate = new CommonAggregateImpl();
    }

    public void onDestroy() {
        ILog.i(TAG, "onDestroy");
        InterconnectManager.getInstance().getMainDispatcher().clear();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        ILog.i(TAG, "onRebind");
    }
}
