package com.upuphone.ar.translation.phone.bean;

import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\b\u0010#\u001a\u00020\u0005H\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "", "transType", "", "remoteSrc", "", "remoteDst", "proximalSrc", "proximalDst", "isFirstTemp", "", "recognizeId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "()Z", "setFirstTemp", "(Z)V", "getProximalDst", "()Ljava/lang/String;", "getProximalSrc", "getRecognizeId", "getRemoteDst", "getRemoteSrc", "getTransType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TempStorageTransResult {
    private boolean isFirstTemp;
    @NotNull
    private final String proximalDst;
    @NotNull
    private final String proximalSrc;
    @NotNull
    private final String recognizeId;
    @NotNull
    private final String remoteDst;
    @NotNull
    private final String remoteSrc;
    private final int transType;

    public TempStorageTransResult(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "remoteSrc");
        Intrinsics.checkNotNullParameter(str2, "remoteDst");
        Intrinsics.checkNotNullParameter(str3, "proximalSrc");
        Intrinsics.checkNotNullParameter(str4, "proximalDst");
        Intrinsics.checkNotNullParameter(str5, "recognizeId");
        this.transType = i;
        this.remoteSrc = str;
        this.remoteDst = str2;
        this.proximalSrc = str3;
        this.proximalDst = str4;
        this.isFirstTemp = z;
        this.recognizeId = str5;
    }

    public static /* synthetic */ TempStorageTransResult copy$default(TempStorageTransResult tempStorageTransResult, int i, String str, String str2, String str3, String str4, boolean z, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tempStorageTransResult.transType;
        }
        if ((i2 & 2) != 0) {
            str = tempStorageTransResult.remoteSrc;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = tempStorageTransResult.remoteDst;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = tempStorageTransResult.proximalSrc;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = tempStorageTransResult.proximalDst;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            z = tempStorageTransResult.isFirstTemp;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            str5 = tempStorageTransResult.recognizeId;
        }
        return tempStorageTransResult.copy(i, str6, str7, str8, str9, z2, str5);
    }

    public final int component1() {
        return this.transType;
    }

    @NotNull
    public final String component2() {
        return this.remoteSrc;
    }

    @NotNull
    public final String component3() {
        return this.remoteDst;
    }

    @NotNull
    public final String component4() {
        return this.proximalSrc;
    }

    @NotNull
    public final String component5() {
        return this.proximalDst;
    }

    public final boolean component6() {
        return this.isFirstTemp;
    }

    @NotNull
    public final String component7() {
        return this.recognizeId;
    }

    @NotNull
    public final TempStorageTransResult copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "remoteSrc");
        Intrinsics.checkNotNullParameter(str2, "remoteDst");
        Intrinsics.checkNotNullParameter(str3, "proximalSrc");
        Intrinsics.checkNotNullParameter(str4, "proximalDst");
        Intrinsics.checkNotNullParameter(str5, "recognizeId");
        return new TempStorageTransResult(i, str, str2, str3, str4, z, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TempStorageTransResult)) {
            return false;
        }
        TempStorageTransResult tempStorageTransResult = (TempStorageTransResult) obj;
        return this.transType == tempStorageTransResult.transType && Intrinsics.areEqual((Object) this.remoteSrc, (Object) tempStorageTransResult.remoteSrc) && Intrinsics.areEqual((Object) this.remoteDst, (Object) tempStorageTransResult.remoteDst) && Intrinsics.areEqual((Object) this.proximalSrc, (Object) tempStorageTransResult.proximalSrc) && Intrinsics.areEqual((Object) this.proximalDst, (Object) tempStorageTransResult.proximalDst) && this.isFirstTemp == tempStorageTransResult.isFirstTemp && Intrinsics.areEqual((Object) this.recognizeId, (Object) tempStorageTransResult.recognizeId);
    }

    @NotNull
    public final String getProximalDst() {
        return this.proximalDst;
    }

    @NotNull
    public final String getProximalSrc() {
        return this.proximalSrc;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    @NotNull
    public final String getRemoteDst() {
        return this.remoteDst;
    }

    @NotNull
    public final String getRemoteSrc() {
        return this.remoteSrc;
    }

    public final int getTransType() {
        return this.transType;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.transType) * 31) + this.remoteSrc.hashCode()) * 31) + this.remoteDst.hashCode()) * 31) + this.proximalSrc.hashCode()) * 31) + this.proximalDst.hashCode()) * 31) + Boolean.hashCode(this.isFirstTemp)) * 31) + this.recognizeId.hashCode();
    }

    public final boolean isFirstTemp() {
        return this.isFirstTemp;
    }

    public final void setFirstTemp(boolean z) {
        this.isFirstTemp = z;
    }

    @NotNull
    public String toString() {
        String k = InterconnectMsgCodExtKt.k(this.transType);
        boolean z = this.isFirstTemp;
        String str = this.remoteSrc;
        String str2 = this.remoteDst;
        String str3 = this.proximalSrc;
        String str4 = this.proximalDst;
        String mixSpecialData = AsrExtKt.mixSpecialData(this.recognizeId);
        return "[transType=" + k + ", isFirstTemp=" + z + "]==>(remoteSrc='" + str + "', remoteDst='" + str2 + "')\n(proximalSrc='" + str3 + "', proximalDst='" + str4 + "', recognizeId='" + mixSpecialData + "')";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TempStorageTransResult(int i, String str, String str2, String str3, String str4, boolean z, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, str3, str4, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? "" : str5);
    }
}
