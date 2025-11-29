package com.here.odnp.posclient.pos;

import android.location.Location;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.posclient.pos.IPositioningSession;
import com.here.odnp.util.Log;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.common.PositioningError;

public class PositioningSession extends CloseableSession implements IPositioningSession {
    private static final String TAG = "odnp.posclient.PositioningSession";
    private final IPositioningSession.ILocationListener mListener;
    private boolean mStarted;

    /* renamed from: com.here.odnp.posclient.pos.PositioningSession$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$com$here$posclient$Status = iArr;
            try {
                iArr[Status.Ok.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public PositioningSession(PosClientManager posClientManager, IPositioningSession.ILocationListener iLocationListener) {
        super(posClientManager);
        if (iLocationListener != null) {
            this.mListener = iLocationListener;
            return;
        }
        throw new IllegalArgumentException("listener is null");
    }

    public int availableFeatures() {
        return this.mPosClientManager.availableFeatures();
    }

    public void clearData(int i) {
        Log.v(TAG, "clearData: data items: %d", Integer.valueOf(i));
        this.mPosClientManager.clearData(i);
    }

    public int enabledFeatures() {
        return this.mPosClientManager.enabledFeatures();
    }

    public Location getLastPosition() {
        return this.mPosClientManager.onGetLastLocation();
    }

    public UpdateOptions getUpdateOptions() {
        return new UpdateOptions(this.mPosClientManager.onGetUpdateOptions());
    }

    public boolean injectActivity(GeneralActivityResult generalActivityResult) {
        return this.mStarted && this.mPosClientManager.onInjectActivity(generalActivityResult);
    }

    public boolean injectLocation(Location location) {
        return this.mStarted && this.mPosClientManager.onInjectLocation(location);
    }

    public boolean isOfflineModeSet() {
        return this.mPosClientManager.isOfflineModeSet();
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void locationCalculationFailed(PositioningError positioningError) {
        if (this.mStarted) {
            this.mListener.onLocationResolvingFailed(positioningError);
        }
    }

    public void locationChanged(Location location) {
        if (this.mStarted) {
            this.mListener.onLocationChanged(location);
        }
    }

    public void locationInfoChanged(PositioningError positioningError) {
        if (this.mStarted) {
            this.mListener.onLocationInfoChanged(positioningError);
        }
    }

    public void onClose() {
        if (!this.mPosClientManager.removePositioner(this)) {
            Log.w(TAG, "Positioner.onClose: positioner not in positioner set.", new Object[0]);
        }
        this.mListener.onClosed();
    }

    public void onNetworkLocationDisabled(boolean z) {
        this.mPosClientManager.onNetworkLocationDisabled(z);
    }

    public void onNetworkLocationEnabled() {
        this.mPosClientManager.onNetworkLocationEnabled();
    }

    public void onOpen() {
        this.mPosClientManager.addPositioner(this);
    }

    public void positioningConsentRevoked() {
        this.mPosClientManager.positioningConsentRevoked();
    }

    public void requestLastPosition() {
        this.mPosClientManager.onRequestLastPosition();
    }

    public void requestPosition() {
        this.mPosClientManager.onRequestPosition();
    }

    public boolean requestSingleUpdate(UpdateOptions updateOptions) {
        Log.v(TAG, "requestSingleUpdate", new Object[0]);
        return AnonymousClass1.$SwitchMap$com$here$posclient$Status[this.mPosClientManager.onRequestSingleUpdate(updateOptions, this.mListener).ordinal()] == 1;
    }

    public void resetMeasurements() {
        this.mPosClientManager.onResetMeasurements();
    }

    public void setOfflineMode(boolean z) {
        this.mPosClientManager.setOfflineMode(z);
    }

    public int setUpdateOptions(UpdateOptions updateOptions) {
        return this.mPosClientManager.onSetUpdateOptions(new UpdateOptions(updateOptions), (IPositioningSession.StatusListener) null);
    }

    public boolean startInjectionUpdates() {
        if (!this.mStarted) {
            if (AnonymousClass1.$SwitchMap$com$here$posclient$Status[this.mPosClientManager.onStartInjectionUpdates().ordinal()] == 1) {
                this.mStarted = true;
            }
        }
        return this.mStarted;
    }

    public boolean startPositionUpdates() {
        if (!this.mStarted) {
            if (AnonymousClass1.$SwitchMap$com$here$posclient$Status[this.mPosClientManager.onStartPositionUpdates().ordinal()] == 1) {
                this.mStarted = true;
            }
        }
        return this.mStarted;
    }

    public void stopPositionUpdates() {
        if (this.mStarted) {
            this.mStarted = false;
            this.mPosClientManager.onStopPositionUpdates();
        }
    }

    public void toggleFeature(PositioningFeature positioningFeature, boolean z) {
        this.mPosClientManager.toggleFeature(positioningFeature, z);
    }

    public int setUpdateOptions(UpdateOptions updateOptions, IPositioningSession.StatusListener statusListener) {
        return this.mPosClientManager.onSetUpdateOptions(new UpdateOptions(updateOptions), statusListener);
    }
}
