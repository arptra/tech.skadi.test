package com.upuphone.star.fota.phone;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "Landroid/os/Parcelable;", "code", "", "msg", "", "data", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(ILjava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "getCode", "()I", "getData", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "isSuccess", "", "()Z", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class GlassCheckUpdateResult implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GlassCheckUpdateResult> CREATOR = new Creator();
    private final int code;
    @Nullable
    private final GlassUpdateInfo data;
    @Nullable
    private final String msg;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GlassCheckUpdateResult> {
        /* renamed from: a */
        public final GlassCheckUpdateResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GlassCheckUpdateResult(parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : GlassUpdateInfo.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final GlassCheckUpdateResult[] newArray(int i) {
            return new GlassCheckUpdateResult[i];
        }
    }

    @JvmOverloads
    public GlassCheckUpdateResult(int i, @Nullable String str) {
        this(i, str, (GlassUpdateInfo) null, 4, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GlassCheckUpdateResult copy$default(GlassCheckUpdateResult glassCheckUpdateResult, int i, String str, GlassUpdateInfo glassUpdateInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = glassCheckUpdateResult.code;
        }
        if ((i2 & 2) != 0) {
            str = glassCheckUpdateResult.msg;
        }
        if ((i2 & 4) != 0) {
            glassUpdateInfo = glassCheckUpdateResult.data;
        }
        return glassCheckUpdateResult.copy(i, str, glassUpdateInfo);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @Nullable
    public final GlassUpdateInfo component3() {
        return this.data;
    }

    @NotNull
    public final GlassCheckUpdateResult copy(int i, @Nullable String str, @Nullable GlassUpdateInfo glassUpdateInfo) {
        return new GlassCheckUpdateResult(i, str, glassUpdateInfo);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassCheckUpdateResult)) {
            return false;
        }
        GlassCheckUpdateResult glassCheckUpdateResult = (GlassCheckUpdateResult) obj;
        return this.code == glassCheckUpdateResult.code && Intrinsics.areEqual((Object) this.msg, (Object) glassCheckUpdateResult.msg) && Intrinsics.areEqual((Object) this.data, (Object) glassCheckUpdateResult.data);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final GlassUpdateInfo getData() {
        return this.data;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        GlassUpdateInfo glassUpdateInfo = this.data;
        if (glassUpdateInfo != null) {
            i = glassUpdateInfo.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.msg;
        GlassUpdateInfo glassUpdateInfo = this.data;
        return "GlassCheckUpdateResult(code=" + i + ", msg=" + str + ", data=" + glassUpdateInfo + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        GlassUpdateInfo glassUpdateInfo = this.data;
        if (glassUpdateInfo == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        glassUpdateInfo.writeToParcel(parcel, i);
    }

    @JvmOverloads
    public GlassCheckUpdateResult(int i, @Nullable String str, @Nullable GlassUpdateInfo glassUpdateInfo) {
        this.code = i;
        this.msg = str;
        this.data = glassUpdateInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassCheckUpdateResult(int i, String str, GlassUpdateInfo glassUpdateInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : glassUpdateInfo);
    }
}
