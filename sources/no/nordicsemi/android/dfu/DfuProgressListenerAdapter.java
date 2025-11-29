package no.nordicsemi.android.dfu;

import androidx.annotation.NonNull;

public class DfuProgressListenerAdapter implements DfuProgressListener {
    public void onDeviceConnected(@NonNull String str) {
    }

    public void onDeviceConnecting(@NonNull String str) {
    }

    public void onDeviceDisconnected(@NonNull String str) {
    }

    public void onDeviceDisconnecting(String str) {
    }

    public void onDfuAborted(@NonNull String str) {
    }

    public void onDfuCompleted(@NonNull String str) {
    }

    public void onDfuProcessStarted(@NonNull String str) {
    }

    public void onDfuProcessStarting(@NonNull String str) {
    }

    public void onEnablingDfuMode(@NonNull String str) {
    }

    public void onError(@NonNull String str, int i, int i2, String str2) {
    }

    public void onFirmwareValidating(@NonNull String str) {
    }

    public void onProgressChanged(@NonNull String str, int i, float f, float f2, int i2, int i3) {
    }
}
