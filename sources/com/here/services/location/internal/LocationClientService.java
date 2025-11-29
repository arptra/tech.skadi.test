package com.here.services.location.internal;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.pos.IPositioningSession;
import com.here.odnp.util.Log;
import com.here.odnp.util.MasterThread;
import com.here.odnp.util.SafeHandler;
import com.here.odnp.util.SyncHandlerTask;
import com.here.posclient.PositioningFeature;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.common.PositioningError;
import com.here.services.internal.IBoundService;
import com.here.services.location.internal.IPositioningClient;
import com.here.services.location.internal.PositionListener;

public class LocationClientService extends IPositioningClient.Stub implements IBoundService {
    private static final String TAG = "services.location.internal.LocationClientService";
    private final SafeHandler mHandler = new SafeHandler(MasterThread.getInstance().getLooper());
    private final IPositioningSession.ILocationListener mLocationListener;
    /* access modifiers changed from: private */
    public final ISdkPosClientManager mPosClientManager;
    /* access modifiers changed from: private */
    public PositionListener mPositionListener;

    public LocationClientService(IPosClientManager iPosClientManager, Intent intent) {
        AnonymousClass1 r3 = new IPositioningSession.ILocationListener() {
            public void onClosed() {
                Log.v(LocationClientService.TAG, "onClosed", new Object[0]);
            }

            public void onLocationChanged(Location location) {
                Log.v(LocationClientService.TAG, "onLocationChanged: location: %s", location);
                try {
                    synchronized (LocationClientService.this) {
                        if (LocationClientService.this.mPositionListener == null) {
                            Log.w(LocationClientService.TAG, "onLocationChanged: PositionListener is null -> ignored.", new Object[0]);
                        } else {
                            LocationClientService.this.mPositionListener.onPositionUpdate(location);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }

            public void onLocationInfoChanged(PositioningError positioningError) {
                Log.v(LocationClientService.TAG, "onLocationInfoChanged: %s", positioningError);
                try {
                    synchronized (LocationClientService.this) {
                        if (LocationClientService.this.mPositionListener == null) {
                            Log.w(LocationClientService.TAG, "onLocationInfoChanged: PositionListener is null -> ignored.", new Object[0]);
                        } else {
                            LocationClientService.this.mPositionListener.onPositionInfoChanged(positioningError);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }

            public void onLocationResolvingFailed(PositioningError positioningError) {
                Log.v(LocationClientService.TAG, "onLocationResolvingFailed: %s", positioningError);
                try {
                    synchronized (LocationClientService.this) {
                        if (LocationClientService.this.mPositionListener == null) {
                            Log.w(LocationClientService.TAG, "onLocationResolvingFailed: PositionListener is null -> ignored.", new Object[0]);
                        } else {
                            LocationClientService.this.mPositionListener.onPositionResolvingFailed(positioningError);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }

            public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) {
                Log.v(LocationClientService.TAG, "onOptionsChanged", new Object[0]);
                try {
                    synchronized (LocationClientService.this) {
                        if (LocationClientService.this.mPositionListener == null) {
                            Log.w(LocationClientService.TAG, "onOptionsChanged: PositionListener is null -> ignored.", new Object[0]);
                        } else {
                            LocationClientService.this.mPositionListener.onOptionsChanged(updateOptions, updateOptions2);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        };
        this.mLocationListener = r3;
        if (iPosClientManager != null) {
            this.mPosClientManager = ServicesPosClientManager.create(iPosClientManager, r3);
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    public int availableFeatures() throws RemoteException {
        ISdkPosClientManager iSdkPosClientManager = this.mPosClientManager;
        return iSdkPosClientManager != null ? iSdkPosClientManager.availableFeatures() : (int) PositioningFeature.None.value;
    }

    public void clearPositioningData() throws RemoteException {
        ISdkPosClientManager iSdkPosClientManager = this.mPosClientManager;
        if (iSdkPosClientManager != null) {
            iSdkPosClientManager.positioningConsentRevoked();
        }
    }

    public int enabledFeatures() throws RemoteException {
        ISdkPosClientManager iSdkPosClientManager = this.mPosClientManager;
        return iSdkPosClientManager != null ? iSdkPosClientManager.enabledFeatures() : (int) PositioningFeature.None.value;
    }

    public Location getLastPosition() throws RemoteException {
        ISdkPosClientManager iSdkPosClientManager = this.mPosClientManager;
        if (iSdkPosClientManager != null) {
            return iSdkPosClientManager.getLastPosition();
        }
        return null;
    }

    public boolean injectActivity(final GeneralActivityResult generalActivityResult) throws RemoteException {
        return this.mHandler.post(new Runnable() {
            public void run() {
                Log.v(LocationClientService.TAG, "injectActivity", new Object[0]);
                LocationClientService.this.mPosClientManager.injectActivity(generalActivityResult);
            }
        });
    }

    public boolean injectLocation(final Location location) throws RemoteException {
        return this.mHandler.post(new Runnable() {
            public void run() {
                Log.v(LocationClientService.TAG, "injectLocation", new Object[0]);
                LocationClientService.this.mPosClientManager.injectLocation(location);
            }
        });
    }

    public boolean requestSingleUpdate(Bundle bundle, final PositionListener positionListener) throws RemoteException {
        final UpdateOptions fromBundle = UpdateOptions.fromBundle(bundle);
        AnonymousClass2 r0 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                Log.v(LocationClientService.TAG, "requestSingleUpdate: %s", fromBundle);
                final PositionListener asInterface = PositionListener.Stub.asInterface(positionListener.asBinder());
                return Boolean.valueOf(LocationClientService.this.mPosClientManager.requestSingleUpdate(fromBundle, new IPositioningSession.ILocationListener() {
                    public void onClosed() {
                    }

                    public void onLocationChanged(Location location) {
                        try {
                            asInterface.onPositionUpdate(location);
                        } catch (RemoteException unused) {
                        }
                    }

                    public void onLocationInfoChanged(PositioningError positioningError) {
                        try {
                            asInterface.onPositionInfoChanged(positioningError);
                        } catch (RemoteException unused) {
                        }
                    }

                    public void onLocationResolvingFailed(PositioningError positioningError) {
                        try {
                            asInterface.onPositionResolvingFailed(positioningError);
                        } catch (RemoteException unused) {
                        }
                    }

                    public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) {
                        try {
                            asInterface.onOptionsChanged(updateOptions, updateOptions2);
                        } catch (RemoteException unused) {
                        }
                    }
                }));
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Boolean) r0.getResult()).booleanValue();
        }
        return false;
    }

    public boolean startInjectionUpdates(final PositionListener positionListener) throws RemoteException {
        AnonymousClass4 r0 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                Log.v(LocationClientService.TAG, "startInjectionUpdates", new Object[0]);
                IBinder asBinder = positionListener.asBinder();
                try {
                    asBinder.linkToDeath(new IBinder.DeathRecipient() {
                        public void binderDied() {
                            synchronized (LocationClientService.this) {
                                Log.v(LocationClientService.TAG, "binderDied: setting PositionListener null.", new Object[0]);
                                PositionListener unused = LocationClientService.this.mPositionListener = null;
                            }
                        }
                    }, 0);
                    synchronized (LocationClientService.this) {
                        PositionListener unused = LocationClientService.this.mPositionListener = PositionListener.Stub.asInterface(asBinder);
                    }
                    return Boolean.valueOf(LocationClientService.this.mPosClientManager.startInjectionUpdates());
                } catch (RemoteException unused2) {
                    return Boolean.FALSE;
                }
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Boolean) r0.getResult()).booleanValue();
        }
        return false;
    }

    public boolean startPositionUpdates(Bundle bundle, final PositionListener positionListener) throws RemoteException {
        final UpdateOptions fromBundle = UpdateOptions.fromBundle(bundle);
        AnonymousClass3 r0 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                Log.v(LocationClientService.TAG, "startPositionUpdates: %s", fromBundle);
                IBinder asBinder = positionListener.asBinder();
                try {
                    asBinder.linkToDeath(new IBinder.DeathRecipient() {
                        public void binderDied() {
                            synchronized (LocationClientService.this) {
                                Log.v(LocationClientService.TAG, "binderDied: setting PositionListener null.", new Object[0]);
                                PositionListener unused = LocationClientService.this.mPositionListener = null;
                            }
                        }
                    }, 0);
                    synchronized (LocationClientService.this) {
                        PositionListener unused = LocationClientService.this.mPositionListener = PositionListener.Stub.asInterface(asBinder);
                    }
                    return Boolean.valueOf(LocationClientService.this.mPosClientManager.startLocationUpdates(fromBundle));
                } catch (RemoteException unused2) {
                    return Boolean.FALSE;
                }
            }
        };
        if (this.mHandler.post(r0)) {
            return ((Boolean) r0.getResult()).booleanValue();
        }
        return false;
    }

    public void stopPositionUpdates(PositionListener positionListener) throws RemoteException {
        this.mHandler.post(new Runnable() {
            public void run() {
                Log.v(LocationClientService.TAG, "stopPositionUpdates", new Object[0]);
                synchronized (LocationClientService.this) {
                    PositionListener unused = LocationClientService.this.mPositionListener = null;
                }
                LocationClientService.this.mPosClientManager.stopLocationUpdates();
            }
        });
    }

    public void toggleFeature(String str, boolean z) throws RemoteException {
        ISdkPosClientManager iSdkPosClientManager = this.mPosClientManager;
        if (iSdkPosClientManager != null) {
            iSdkPosClientManager.toggleFeature(str, z);
        }
    }

    public void unBind() {
        try {
            stopPositionUpdates((PositionListener) null);
        } catch (RemoteException unused) {
        }
    }
}
