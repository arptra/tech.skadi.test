package com.here.services.crowdsource.internal;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.hd.IHdCrowdsourceSession;
import com.here.odnp.util.Log;
import com.here.posclient.crowdsource.hd.ActivityEvent;
import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;
import com.here.services.crowdsource.hd.internal.IHdWifiCollectionActivityListener;
import com.here.services.crowdsource.hd.internal.IHdWifiCollectionController;
import com.here.services.internal.IBoundService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CrowdsourceClientService extends IHdWifiCollectionController.Stub implements IBoundService {
    private static final String TAG = "services.crowdsource.internal.CrowdsourceClientService";
    private final Map<IBinder, IActivityEventDispatcher> mDispatchers = new ConcurrentHashMap();
    private final IHdCrowdsourceSession mSession;

    public CrowdsourceClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.i(TAG, "CrowdsourceClientService", new Object[0]);
        if (iPosClientManager != null) {
            this.mSession = iPosClientManager.createHdCrowdsourceSession();
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    public boolean registerActivityEvents(final IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) {
        if (this.mDispatchers.containsKey(iHdWifiCollectionActivityListener)) {
            return true;
        }
        AnonymousClass1 r0 = new IActivityEventDispatcher() {
            public void onDailyQuotaReached() {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.DailyQuotaReached);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onDailyQuotaReached: error", e);
                }
            }

            public void onDataUploadStarted() {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.DataUploadStarted);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onDataUploadStarted: error", e);
                }
            }

            public void onDataUploadStopped(long j) {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.DataUploadStopped);
                    builder.setUploadSize(j);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onDataUploadStopped: error", e);
                }
            }

            public void onSensorUseStarted() {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.SensorUseStarted);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onSensorUseStarted: error", e);
                }
            }

            public void onSensorUseStopped() {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.SensorUseStopped);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onSensorUseStopped: error", e);
                }
            }

            public void onWifiScanStarted(long j) {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.WifiScanStarted);
                    builder.setWifiScanInterval(j);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onWifiScanStarted: error", e);
                }
            }

            public void onWifiScanStopped() {
                try {
                    ActivityEvent.Builder builder = new ActivityEvent.Builder();
                    builder.setType(ActivityEvent.Type.WifiScanStopped);
                    iHdWifiCollectionActivityListener.onActivityEvent(builder.build());
                } catch (RemoteException e) {
                    Log.e(CrowdsourceClientService.TAG, "onWifiScanStopped: error", e);
                }
            }
        };
        boolean startActivityEventListening = this.mSession.startActivityEventListening(r0);
        if (startActivityEventListening) {
            this.mDispatchers.put(iHdWifiCollectionActivityListener.asBinder(), r0);
        }
        return startActivityEventListening;
    }

    public boolean sendEvent(String str) {
        ControlEvent valueOf = ControlEvent.valueOf(str);
        if (valueOf != null) {
            return this.mSession.sendEvent(valueOf);
        }
        Log.e(TAG, "sendEvent: unknown event %s", str);
        return false;
    }

    public boolean setWifiIntervals(int i, int i2) {
        return this.mSession.setWifiIntervals(i, i2);
    }

    public void unBind() {
    }

    public void unregisterActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) {
        IActivityEventDispatcher remove = this.mDispatchers.remove(iHdWifiCollectionActivityListener.asBinder());
        if (remove != null) {
            this.mSession.stopActivityEventListening(remove);
        }
    }
}
