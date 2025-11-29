package com.here.sdk.location;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.auth.AuthData;
import com.here.sdk.core.AuthenticationException;
import java.util.List;

interface PositioningClientListener {

    public interface OnAuthDataReceivedListener {
        void onAuthDataReceived(@NonNull AuthData authData);
    }

    public enum deviceSetting {
        UNDEFINED,
        NWLOCATION,
        AIRPLANEMODE,
        CELL,
        WIFI,
        GNSS,
        DATACONNECTION
    }

    AuthData getAuthenticationData() throws AuthenticationException;

    @Nullable
    LocationAccuracy getDesiredLocationAccuracy();

    @Nullable
    LocationOptions getDesiredLocationOptions();

    void onClientDisconnected();

    void onClientFailedToStart(@NonNull LocationEngineStatus locationEngineStatus);

    void onClientSuccessfullyStarted();

    void onFeaturesNotAvailable(@NonNull List<LocationFeature> list);

    void onLocationChanged(@NonNull Location location);

    void onLocationIssueChanged(@NonNull List<LocationIssueType> list);

    void onLocationRequestFailed();

    void onLocationServicesStateChanged(boolean z);

    void onOptionsChanged(deviceSetting devicesetting, boolean z);

    void setDesiredLocationAccuracy(@Nullable LocationAccuracy locationAccuracy);

    void setDesiredLocationOptions(@Nullable LocationOptions locationOptions);

    void updateAuthentication(OnAuthDataReceivedListener onAuthDataReceivedListener);
}
