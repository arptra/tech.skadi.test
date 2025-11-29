package com.here.services.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.here.odnp.util.Log;
import com.here.posclient.UpdateOptions;
import com.here.services.common.PositioningError;
import com.here.services.location.LocationListener;
import com.here.services.location.OptionsChangedEvent;
import com.here.services.location.internal.IPositioning;

public class ListenerProxy implements IPositioning.IPositionListener {
    private static final String TAG = "ListenerProxy";
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final LocationListener mListener;

    public ListenerProxy(LocationListener locationListener) {
        this(locationListener, (Looper) null);
    }

    public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) {
        final OptionsChangedEvent optionsChangedEvent = new OptionsChangedEvent(updateOptions, updateOptions2);
        if (optionsChangedEvent.hasChanged()) {
            Log.v(TAG, "onOptionsChanged: options changed", new Object[0]);
            this.mHandler.post(new Runnable() {
                public void run() {
                    ListenerProxy.this.mListener.onOptionsChanged(optionsChangedEvent);
                }
            });
            return;
        }
        Log.v(TAG, "onOptionsChanged: options restored", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                ListenerProxy.this.mListener.onOptionsRestored();
            }
        });
    }

    public void onPositionInfoChanged(final PositioningError positioningError) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ListenerProxy.this.mListener.onLocationInfoChanged(positioningError);
            }
        });
    }

    public void onPositionResolvingFailed(final PositioningError positioningError) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ListenerProxy.this.mListener.onLocationRequestFailed(positioningError);
            }
        });
    }

    public void onPositionUpdate(final Location location) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ListenerProxy.this.mListener.onLocationChanged(location);
            }
        });
    }

    public void onSessionClosed() {
    }

    public ListenerProxy(LocationListener locationListener, Looper looper) {
        Log.v(TAG, TAG, new Object[0]);
        if (looper != null) {
            this.mHandler = new Handler(looper);
        } else {
            this.mHandler = new Handler();
        }
        this.mListener = locationListener;
    }
}
