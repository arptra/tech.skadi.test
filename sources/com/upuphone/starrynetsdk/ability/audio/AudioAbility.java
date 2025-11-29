package com.upuphone.starrynetsdk.ability.audio;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/audio/AudioAbility;", "Lcom/upuphone/starrynetsdk/ability/audio/BaseAudioAbility;", "()V", "activeDevice", "Lcom/upuphone/runasone/device/StarryDevice;", "getActiveDevice", "()Lcom/upuphone/runasone/device/StarryDevice;", "getListBrDevice", "", "registerAudioListener", "", "listener", "Lcom/upuphone/starrynetsdk/ability/audio/AudioListener;", "transfer", "device", "unregisterAudioListener", "Companion", "core-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AudioAbility extends BaseAudioAbility {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "AudioAbility";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/audio/AudioAbility$Companion;", "", "()V", "TAG", "", "core-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Nullable
    public final StarryDevice getActiveDevice() {
        SNSLog.d(TAG, "getActiveDevice");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getActiveDevice failed.");
            return null;
        }
        try {
            return getApi().getAudioPlayDevice();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "getActiveDevice failed.", e);
            return null;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "getActiveDevice failed.", e2);
            return null;
        }
    }

    @Nullable
    public final List<StarryDevice> getListBrDevice() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,getListBrDevice failed.");
            return null;
        }
        try {
            return getApi().getListBrDevice();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "getListBrDevice failed.", e);
            return null;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "getListBrDevice failed.", e2);
            return null;
        }
    }

    public final int registerAudioListener(@NotNull AudioListener audioListener) {
        Intrinsics.checkNotNullParameter(audioListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SNSLog.d(TAG, "registerAudioListener");
        getListenerManager().registerAudioListener(audioListener);
        return 0;
    }

    public final int transfer(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        SNSLog.d(TAG, "transfer to " + starryDevice.getId());
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,transfer failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            getApi().switchAudioPlayDevice(starryDevice);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "transfer failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "transfer failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public final int unregisterAudioListener(@NotNull AudioListener audioListener) {
        Intrinsics.checkNotNullParameter(audioListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SNSLog.d(TAG, "unregisterAudioListener");
        getListenerManager().unregisterAudioListener(audioListener);
        return 0;
    }
}
