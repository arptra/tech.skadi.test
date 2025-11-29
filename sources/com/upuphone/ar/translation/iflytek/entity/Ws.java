package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/Ws;", "", "cw", "", "Lcom/upuphone/ar/translation/iflytek/entity/Cw;", "wb", "", "we", "(Ljava/util/List;II)V", "getCw", "()Ljava/util/List;", "getWb", "()I", "getWe", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Ws {
    @SerializedName("cw")
    @NotNull
    private final List<Cw> cw;
    @SerializedName("wb")
    private final int wb;
    @SerializedName("we")
    private final int we;

    public Ws() {
        this((List) null, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Ws copy$default(Ws ws, List<Cw> list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = ws.cw;
        }
        if ((i3 & 2) != 0) {
            i = ws.wb;
        }
        if ((i3 & 4) != 0) {
            i2 = ws.we;
        }
        return ws.copy(list, i, i2);
    }

    @NotNull
    public final List<Cw> component1() {
        return this.cw;
    }

    public final int component2() {
        return this.wb;
    }

    public final int component3() {
        return this.we;
    }

    @NotNull
    public final Ws copy(@NotNull List<Cw> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "cw");
        return new Ws(list, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ws)) {
            return false;
        }
        Ws ws = (Ws) obj;
        return Intrinsics.areEqual((Object) this.cw, (Object) ws.cw) && this.wb == ws.wb && this.we == ws.we;
    }

    @NotNull
    public final List<Cw> getCw() {
        return this.cw;
    }

    public final int getWb() {
        return this.wb;
    }

    public final int getWe() {
        return this.we;
    }

    public int hashCode() {
        return (((this.cw.hashCode() * 31) + Integer.hashCode(this.wb)) * 31) + Integer.hashCode(this.we);
    }

    @NotNull
    public String toString() {
        List<Cw> list = this.cw;
        int i = this.wb;
        int i2 = this.we;
        return "W(cw=" + list + ", wb=" + i + ", we=" + i2 + ")";
    }

    public Ws(@NotNull List<Cw> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "cw");
        this.cw = list;
        this.wb = i;
        this.we = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ws(List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}
