package com.upuphone.ar.translation.iflytek.entity;

import com.geetest.sdk.w;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\b\u0010!\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/Cw;", "", "rl", "", "sc", "", "w", "wb", "wc", "we", "wp", "(Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;)V", "getRl", "()Ljava/lang/String;", "getSc", "()I", "getW", "getWb", "getWc", "getWe", "getWp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Cw {
    @SerializedName("rl")
    @NotNull
    private final String rl;
    @SerializedName("sc")
    private final int sc;
    @SerializedName("w")
    @NotNull
    private final String w;
    @SerializedName("wb")
    private final int wb;
    @SerializedName("wc")
    private final int wc;
    @SerializedName("we")
    private final int we;
    @SerializedName("wp")
    @NotNull
    private final String wp;

    public Cw() {
        this((String) null, 0, (String) null, 0, 0, 0, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Cw copy$default(Cw cw, String str, int i, String str2, int i2, int i3, int i4, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = cw.rl;
        }
        if ((i5 & 2) != 0) {
            i = cw.sc;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            str2 = cw.w;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            i2 = cw.wb;
        }
        int i7 = i2;
        if ((i5 & 16) != 0) {
            i3 = cw.wc;
        }
        int i8 = i3;
        if ((i5 & 32) != 0) {
            i4 = cw.we;
        }
        int i9 = i4;
        if ((i5 & 64) != 0) {
            str3 = cw.wp;
        }
        return cw.copy(str, i6, str4, i7, i8, i9, str3);
    }

    @NotNull
    public final String component1() {
        return this.rl;
    }

    public final int component2() {
        return this.sc;
    }

    @NotNull
    public final String component3() {
        return this.w;
    }

    public final int component4() {
        return this.wb;
    }

    public final int component5() {
        return this.wc;
    }

    public final int component6() {
        return this.we;
    }

    @NotNull
    public final String component7() {
        return this.wp;
    }

    @NotNull
    public final Cw copy(@NotNull String str, int i, @NotNull String str2, int i2, int i3, int i4, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "rl");
        Intrinsics.checkNotNullParameter(str2, w.f);
        Intrinsics.checkNotNullParameter(str3, "wp");
        return new Cw(str, i, str2, i2, i3, i4, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cw)) {
            return false;
        }
        Cw cw = (Cw) obj;
        return Intrinsics.areEqual((Object) this.rl, (Object) cw.rl) && this.sc == cw.sc && Intrinsics.areEqual((Object) this.w, (Object) cw.w) && this.wb == cw.wb && this.wc == cw.wc && this.we == cw.we && Intrinsics.areEqual((Object) this.wp, (Object) cw.wp);
    }

    @NotNull
    public final String getRl() {
        return this.rl;
    }

    public final int getSc() {
        return this.sc;
    }

    @NotNull
    public final String getW() {
        return this.w;
    }

    public final int getWb() {
        return this.wb;
    }

    public final int getWc() {
        return this.wc;
    }

    public final int getWe() {
        return this.we;
    }

    @NotNull
    public final String getWp() {
        return this.wp;
    }

    public int hashCode() {
        return (((((((((((this.rl.hashCode() * 31) + Integer.hashCode(this.sc)) * 31) + this.w.hashCode()) * 31) + Integer.hashCode(this.wb)) * 31) + Integer.hashCode(this.wc)) * 31) + Integer.hashCode(this.we)) * 31) + this.wp.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.rl;
        int i = this.sc;
        String str2 = this.w;
        int i2 = this.wb;
        int i3 = this.wc;
        int i4 = this.we;
        String str3 = this.wp;
        return "Cw(rl='" + str + "', sc=" + i + ", w='" + str2 + "', wb=" + i2 + ", wc=" + i3 + ", we=" + i4 + ", wp='" + str3 + "')";
    }

    public Cw(@NotNull String str, int i, @NotNull String str2, int i2, int i3, int i4, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "rl");
        Intrinsics.checkNotNullParameter(str2, w.f);
        Intrinsics.checkNotNullParameter(str3, "wp");
        this.rl = str;
        this.sc = i;
        this.w = str2;
        this.wb = i2;
        this.wc = i3;
        this.we = i4;
        this.wp = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cw(String str, int i, String str2, int i2, int i3, int i4, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? 0 : i4, (i5 & 64) != 0 ? "" : str3);
    }
}
