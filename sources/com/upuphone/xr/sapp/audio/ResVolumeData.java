package com.upuphone.xr.sapp.audio;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/audio/ResVolumeData;", "", "action", "", "value", "time", "", "streamType", "", "(Ljava/lang/String;Ljava/lang/String;JI)V", "getAction", "()Ljava/lang/String;", "getStreamType", "()I", "setStreamType", "(I)V", "getTime", "()J", "setTime", "(J)V", "getValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ResVolumeData {
    @NotNull
    private final String action;
    private int streamType;
    private long time;
    @NotNull
    private final String value;

    public ResVolumeData(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        this.action = str;
        this.value = str2;
        this.time = j;
        this.streamType = i;
    }

    public static /* synthetic */ ResVolumeData copy$default(ResVolumeData resVolumeData, String str, String str2, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resVolumeData.action;
        }
        if ((i2 & 2) != 0) {
            str2 = resVolumeData.value;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            j = resVolumeData.time;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            i = resVolumeData.streamType;
        }
        return resVolumeData.copy(str, str3, j2, i);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    public final long component3() {
        return this.time;
    }

    public final int component4() {
        return this.streamType;
    }

    @NotNull
    public final ResVolumeData copy(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        return new ResVolumeData(str, str2, j, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResVolumeData)) {
            return false;
        }
        ResVolumeData resVolumeData = (ResVolumeData) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) resVolumeData.action) && Intrinsics.areEqual((Object) this.value, (Object) resVolumeData.value) && this.time == resVolumeData.time && this.streamType == resVolumeData.streamType;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    public final int getStreamType() {
        return this.streamType;
    }

    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((this.action.hashCode() * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + Integer.hashCode(this.streamType);
    }

    public final void setStreamType(int i) {
        this.streamType = i;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    @NotNull
    public String toString() {
        String str = this.action;
        String str2 = this.value;
        long j = this.time;
        int i = this.streamType;
        return "ResVolumeData(action=" + str + ", value=" + str2 + ", time=" + j + ", streamType=" + i + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResVolumeData(String str, String str2, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : j, (i2 & 8) != 0 ? 3 : i);
    }
}
