package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/RemoteGlassUpdateState;", "", "code", "", "msg", "", "stateCode", "uid", "version", "digest", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getDigest", "()Ljava/lang/String;", "isSuccess", "", "()Z", "isUpdating", "getMsg", "getStateCode", "getUid", "getVersion", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class RemoteGlassUpdateState {
    public static final int CODE_INSTALLING = 105;
    public static final int CODE_INSTALL_COMPLETE = 107;
    public static final int CODE_TRANSFERRING = 101;
    public static final int CODE_TRANSFER_FAIL = 102;
    public static final int CODE_TRANSFER_SUCCESS = 109;
    public static final int CODE_UPDATE_FAIL = 106;
    public static final int CODE_UPDATE_IDLE = 100;
    public static final int CODE_UPDATE_SUCCESS = 108;
    public static final int CODE_VERIFYING = 103;
    public static final int CODE_VERIFY_FAIL = 104;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int code;
    @Nullable
    private final String digest;
    @Nullable
    private final String msg;
    private final int stateCode;
    @Nullable
    private final String uid;
    @Nullable
    private final String version;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/entity/RemoteGlassUpdateState$Companion;", "", "()V", "CODE_INSTALLING", "", "CODE_INSTALL_COMPLETE", "CODE_TRANSFERRING", "CODE_TRANSFER_FAIL", "CODE_TRANSFER_SUCCESS", "CODE_UPDATE_FAIL", "CODE_UPDATE_IDLE", "CODE_UPDATE_SUCCESS", "CODE_VERIFYING", "CODE_VERIFY_FAIL", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteGlassUpdateState(int i, @Nullable String str, int i2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.code = i;
        this.msg = str;
        this.stateCode = i2;
        this.uid = str2;
        this.version = str3;
        this.digest = str4;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public final int getStateCode() {
        return this.stateCode;
    }

    @Nullable
    public final String getUid() {
        return this.uid;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }

    public final boolean isUpdating() {
        int i = this.stateCode;
        return i == 101 || i == 103 || i == 105;
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.msg;
        int i2 = this.stateCode;
        String str2 = this.uid;
        String str3 = this.version;
        String str4 = this.digest;
        return "RemoteGlassUpdateState(code=" + i + ", msg=" + str + ", stateCode=" + i2 + ", uid=" + str2 + ", version=" + str3 + ", digest=" + str4 + ")";
    }
}
