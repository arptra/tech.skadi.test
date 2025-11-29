package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "", "()V", "AirTransferring", "DownloadFail", "DownloadSuccess", "Downloading", "GlassUpdateFail", "GlassUpdateIdle", "GlassUpdateInfoState", "GlassUpdateSuccess", "InstallFail", "Installing", "StarTransferring", "TransferFail", "UpdateDialogGlassCanceled", "UpdateDisconnected", "VerifyFail", "VerifySuccess", "Verifying", "WaitingUpdateDialogResult", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateFail;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateIdle;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateSuccess;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public abstract class GlassUpdateState {

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$AirTransferring;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "uid", "", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AirTransferring extends GlassUpdateInfoState {
        @NotNull
        private final String uid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AirTransferring(@NotNull GlassUpdateInfo glassUpdateInfo, @NotNull String str) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            this.uid = str;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$DownloadFail;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "uid", "", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "percent", "", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;F)V", "getPercent", "()F", "getUid", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DownloadFail extends GlassUpdateInfoState {
        private final float percent;
        @NotNull
        private final String uid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DownloadFail(@NotNull String str, @NotNull GlassUpdateInfo glassUpdateInfo, float f) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            this.uid = str;
            this.percent = f;
        }

        public final float getPercent() {
            return this.percent;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$DownloadSuccess;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DownloadSuccess extends GlassUpdateInfoState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DownloadSuccess(@NotNull GlassUpdateInfo glassUpdateInfo) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$Downloading;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "percent", "", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;F)V", "getPercent", "()F", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Downloading extends GlassUpdateInfoState {
        private final float percent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Downloading(@NotNull GlassUpdateInfo glassUpdateInfo, float f) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            this.percent = f;
        }

        public final float getPercent() {
            return this.percent;
        }

        @NotNull
        public String toString() {
            float f = this.percent;
            return "Downloading(percent=" + f + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateFail;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "uid", "", "version", "digest", "errorMsg", "errorCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getErrorCode", "getErrorMsg", "getUid", "getVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GlassUpdateFail extends GlassUpdateState {
        @Nullable
        private final String digest;
        @Nullable
        private final String errorCode;
        @Nullable
        private final String errorMsg;
        @Nullable
        private final String uid;
        @Nullable
        private final String version;

        public GlassUpdateFail(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            super((DefaultConstructorMarker) null);
            this.uid = str;
            this.version = str2;
            this.digest = str3;
            this.errorMsg = str4;
            this.errorCode = str5;
        }

        @Nullable
        public final String getDigest() {
            return this.digest;
        }

        @Nullable
        public final String getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @Nullable
        public final String getUid() {
            return this.uid;
        }

        @Nullable
        public final String getVersion() {
            return this.version;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateIdle;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GlassUpdateIdle extends GlassUpdateState {
        @NotNull
        public static final GlassUpdateIdle INSTANCE = new GlassUpdateIdle();

        private GlassUpdateIdle() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "getGlassUpdateInfo", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class GlassUpdateInfoState extends GlassUpdateState {
        @NotNull
        private final GlassUpdateInfo glassUpdateInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GlassUpdateInfoState(@NotNull GlassUpdateInfo glassUpdateInfo2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(glassUpdateInfo2, "glassUpdateInfo");
            this.glassUpdateInfo = glassUpdateInfo2;
        }

        @NotNull
        public final GlassUpdateInfo getGlassUpdateInfo() {
            return this.glassUpdateInfo;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateSuccess;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "uid", "", "version", "digest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getUid", "getVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GlassUpdateSuccess extends GlassUpdateState {
        @Nullable
        private final String digest;
        @Nullable
        private final String uid;
        @Nullable
        private final String version;

        public GlassUpdateSuccess(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            super((DefaultConstructorMarker) null);
            this.uid = str;
            this.version = str2;
            this.digest = str3;
        }

        @Nullable
        public final String getDigest() {
            return this.digest;
        }

        @Nullable
        public final String getUid() {
            return this.uid;
        }

        @Nullable
        public final String getVersion() {
            return this.version;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$InstallFail;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "uid", "", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "errorCode", "", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;I)V", "getErrorCode", "()I", "getUid", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InstallFail extends GlassUpdateInfoState {
        private final int errorCode;
        @NotNull
        private final String uid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InstallFail(@NotNull String str, @NotNull GlassUpdateInfo glassUpdateInfo, @GlassUpdateErrorCode int i) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            this.uid = str;
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$Installing;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "uid", "", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Installing extends GlassUpdateInfoState {
        @NotNull
        private final String uid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Installing(@NotNull GlassUpdateInfo glassUpdateInfo, @NotNull String str) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            this.uid = str;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$StarTransferring;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "uid", "", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StarTransferring extends GlassUpdateInfoState {
        @NotNull
        private final String uid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StarTransferring(@NotNull GlassUpdateInfo glassUpdateInfo, @NotNull String str) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            this.uid = str;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$TransferFail;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "uid", "", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "errorCode", "", "extraErrorMsg", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;ILjava/lang/String;)V", "getErrorCode", "()I", "getExtraErrorMsg", "()Ljava/lang/String;", "getUid", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TransferFail extends GlassUpdateInfoState {
        private final int errorCode;
        @Nullable
        private final String extraErrorMsg;
        @NotNull
        private final String uid;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TransferFail(String str, GlassUpdateInfo glassUpdateInfo, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, glassUpdateInfo, i, (i2 & 8) != 0 ? null : str2);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        public final String getExtraErrorMsg() {
            return this.extraErrorMsg;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransferFail(@NotNull String str, @NotNull GlassUpdateInfo glassUpdateInfo, @GlassUpdateErrorCode int i, @Nullable String str2) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            this.uid = str;
            this.errorCode = i;
            this.extraErrorMsg = str2;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$UpdateDialogGlassCanceled;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UpdateDialogGlassCanceled extends GlassUpdateInfoState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateDialogGlassCanceled(@NotNull GlassUpdateInfo glassUpdateInfo) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$UpdateDisconnected;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UpdateDisconnected extends GlassUpdateInfoState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateDisconnected(@NotNull GlassUpdateInfo glassUpdateInfo) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$VerifyFail;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "uid", "", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "getUid", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VerifyFail extends GlassUpdateInfoState {
        @NotNull
        private final String uid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerifyFail(@NotNull String str, @NotNull GlassUpdateInfo glassUpdateInfo) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(str, Oauth2AccessToken.KEY_UID);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            this.uid = str;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$VerifySuccess;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "installRequired", "", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Z)V", "getInstallRequired", "()Z", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VerifySuccess extends GlassUpdateInfoState {
        private final boolean installRequired;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerifySuccess(@NotNull GlassUpdateInfo glassUpdateInfo, boolean z) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            this.installRequired = z;
        }

        public final boolean getInstallRequired() {
            return this.installRequired;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$Verifying;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Verifying extends GlassUpdateInfoState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Verifying(@NotNull GlassUpdateInfo glassUpdateInfo) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateState$WaitingUpdateDialogResult;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState$GlassUpdateInfoState;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "downloadFile", "Ljava/io/File;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/io/File;)V", "getDownloadFile", "()Ljava/io/File;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WaitingUpdateDialogResult extends GlassUpdateInfoState {
        @NotNull
        private final File downloadFile;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WaitingUpdateDialogResult(@NotNull GlassUpdateInfo glassUpdateInfo, @NotNull File file) {
            super(glassUpdateInfo);
            Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
            Intrinsics.checkNotNullParameter(file, "downloadFile");
            this.downloadFile = file;
        }

        @NotNull
        public final File getDownloadFile() {
            return this.downloadFile;
        }
    }

    public /* synthetic */ GlassUpdateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GlassUpdateState() {
    }
}
