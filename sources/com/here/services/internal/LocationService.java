package com.here.services.internal;

import android.content.Intent;
import android.os.IBinder;
import com.here.odnp.util.AssetCopyTask;
import com.here.odnp.util.Log;
import com.here.odnp.util.MasterThread;
import com.here.odnp.util.OdnpAssetManager;

public final class LocationService extends ServiceBase implements OdnpAssetManager.AsyncCopyListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final OdnpAssetManager.Asset[] ASSETS = {new OdnpAssetManager.Asset("config/publog.pem", false, true)};
    private static final String TAG = "services.internal.LocationService";
    private LocationServiceController mController;
    private final AssetCopyTask mCopyTask = new AssetCopyTask(this, this);
    private MasterThread mMasterThread;

    static {
        try {
            Class.forName("android.os.AsyncTask");
        } catch (ClassNotFoundException unused) {
        }
    }

    public void asyncCopyFinished(boolean z) {
        if (!z) {
            Log.w(TAG, "asyncCopyFinished: Failed to copy assets to working directory!", new Object[0]);
        }
    }

    public synchronized void onAllBindingsClosed() {
        Log.v(TAG, "onAllBindingsClosed: All bound services have been closed -> stopping service", new Object[0]);
        this.mController = null;
        stopSelf();
    }

    public synchronized IBinder onBind(Intent intent) {
        LocationServiceController locationServiceController = this.mController;
        if (locationServiceController != null) {
            return locationServiceController.onServiceBind(intent);
        } else if (!isLocationServiceControllerAction(intent)) {
            Log.e(TAG, "onBind: controller is null -> ignored", new Object[0]);
            return null;
        } else {
            Log.v(TAG, "onBind: creating new controller", new Object[0]);
            LocationServiceController openController = new LocationServiceController(this).openController(this.mCopyTask, intent.getExtras());
            this.mController = openController;
            if (openController == null) {
                Log.e(TAG, "onBind: openController failed -> service not usable", new Object[0]);
            }
            return this.mController;
        }
    }

    public void onCreate() {
        Log.v(TAG, "onCreate", new Object[0]);
        super.onCreate();
        this.mCopyTask.start(ASSETS);
        MasterThread instance = MasterThread.getInstance();
        this.mMasterThread = instance;
        instance.start();
    }

    public void onDestroy() {
        Log.v(TAG, "onDestroy", new Object[0]);
        synchronized (this) {
            try {
                LocationServiceController locationServiceController = this.mController;
                if (locationServiceController != null) {
                    locationServiceController.unBind();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mMasterThread.stop();
        this.mMasterThread = null;
        super.onDestroy();
    }

    public void onLowMemory() {
        Log.i(TAG, "onLowMemory", new Object[0]);
    }

    public synchronized boolean onUnbind(Intent intent) {
        if (this.mController == null) {
            return false;
        }
        if (isLocationServiceControllerAction(intent)) {
            Log.v(TAG, "onUnbind: controller unbind", new Object[0]);
            this.mController.unBind();
            return true;
        }
        return this.mController.onServiceUnbind(intent);
    }
}
