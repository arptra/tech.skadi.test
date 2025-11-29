package com.upuphone.ar.transcribe.interconnect.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\b\u0010&\u001a\u00020\u0005H\u0016R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001e\u0010\n\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015¨\u0006'"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/entity/StartTrans;", "", "transType", "", "src", "", "dst", "phoneInitFinish", "", "callState", "wechatReply", "isNewSession", "(ILjava/lang/String;Ljava/lang/String;ZIZZ)V", "getCallState", "()I", "setCallState", "(I)V", "getDst", "()Ljava/lang/String;", "()Z", "setNewSession", "(Z)V", "getPhoneInitFinish", "getSrc", "getTransType", "getWechatReply", "setWechatReply", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StartTrans {
    @SerializedName("callState")
    private int callState;
    @SerializedName("dst")
    @NotNull
    private final String dst;
    private boolean isNewSession;
    @SerializedName("phoneInitFinish")
    private final boolean phoneInitFinish;
    @SerializedName("src")
    @NotNull
    private final String src;
    @SerializedName("transType")
    private final int transType;
    @SerializedName("wechatReply")
    private boolean wechatReply;

    public StartTrans(int i, @NotNull String str, @NotNull String str2, boolean z, int i2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        this.transType = i;
        this.src = str;
        this.dst = str2;
        this.phoneInitFinish = z;
        this.callState = i2;
        this.wechatReply = z2;
        this.isNewSession = z3;
    }

    public static /* synthetic */ StartTrans copy$default(StartTrans startTrans, int i, String str, String str2, boolean z, int i2, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = startTrans.transType;
        }
        if ((i3 & 2) != 0) {
            str = startTrans.src;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = startTrans.dst;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            z = startTrans.phoneInitFinish;
        }
        boolean z4 = z;
        if ((i3 & 16) != 0) {
            i2 = startTrans.callState;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            z2 = startTrans.wechatReply;
        }
        boolean z5 = z2;
        if ((i3 & 64) != 0) {
            z3 = startTrans.isNewSession;
        }
        return startTrans.copy(i, str3, str4, z4, i4, z5, z3);
    }

    public final int component1() {
        return this.transType;
    }

    @NotNull
    public final String component2() {
        return this.src;
    }

    @NotNull
    public final String component3() {
        return this.dst;
    }

    public final boolean component4() {
        return this.phoneInitFinish;
    }

    public final int component5() {
        return this.callState;
    }

    public final boolean component6() {
        return this.wechatReply;
    }

    public final boolean component7() {
        return this.isNewSession;
    }

    @NotNull
    public final StartTrans copy(int i, @NotNull String str, @NotNull String str2, boolean z, int i2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return new StartTrans(i, str, str2, z, i2, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartTrans)) {
            return false;
        }
        StartTrans startTrans = (StartTrans) obj;
        return this.transType == startTrans.transType && Intrinsics.areEqual((Object) this.src, (Object) startTrans.src) && Intrinsics.areEqual((Object) this.dst, (Object) startTrans.dst) && this.phoneInitFinish == startTrans.phoneInitFinish && this.callState == startTrans.callState && this.wechatReply == startTrans.wechatReply && this.isNewSession == startTrans.isNewSession;
    }

    public final int getCallState() {
        return this.callState;
    }

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    public final boolean getPhoneInitFinish() {
        return this.phoneInitFinish;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final int getTransType() {
        return this.transType;
    }

    public final boolean getWechatReply() {
        return this.wechatReply;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.transType) * 31) + this.src.hashCode()) * 31) + this.dst.hashCode()) * 31) + Boolean.hashCode(this.phoneInitFinish)) * 31) + Integer.hashCode(this.callState)) * 31) + Boolean.hashCode(this.wechatReply)) * 31) + Boolean.hashCode(this.isNewSession);
    }

    public final boolean isNewSession() {
        return this.isNewSession;
    }

    public final void setCallState(int i) {
        this.callState = i;
    }

    public final void setNewSession(boolean z) {
        this.isNewSession = z;
    }

    public final void setWechatReply(boolean z) {
        this.wechatReply = z;
    }

    @NotNull
    public String toString() {
        int i = this.transType;
        String str = this.src;
        String str2 = this.dst;
        boolean z = this.phoneInitFinish;
        int i2 = this.callState;
        boolean z2 = this.wechatReply;
        return "StartTrans(transType=" + i + ", src='" + str + "', dst='" + str2 + "', phoneInitFinish=" + z + ", callState=" + i2 + ", wechatReply=" + z2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StartTrans(int i, String str, String str2, boolean z, int i2, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? true : z3);
    }
}
