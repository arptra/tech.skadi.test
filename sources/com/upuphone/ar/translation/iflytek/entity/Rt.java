package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/Rt;", "", "ws", "", "Lcom/upuphone/ar/translation/iflytek/entity/Ws;", "(Ljava/util/List;)V", "getWs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Rt {
    @SerializedName("ws")
    @NotNull
    private final List<Ws> ws;

    public Rt() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Rt copy$default(Rt rt, List<Ws> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rt.ws;
        }
        return rt.copy(list);
    }

    @NotNull
    public final List<Ws> component1() {
        return this.ws;
    }

    @NotNull
    public final Rt copy(@NotNull List<Ws> list) {
        Intrinsics.checkNotNullParameter(list, "ws");
        return new Rt(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Rt) && Intrinsics.areEqual((Object) this.ws, (Object) ((Rt) obj).ws);
    }

    @NotNull
    public final List<Ws> getWs() {
        return this.ws;
    }

    public int hashCode() {
        return this.ws.hashCode();
    }

    @NotNull
    public String toString() {
        List<Ws> list = this.ws;
        return "Rt(ws=" + list + ")";
    }

    public Rt(@NotNull List<Ws> list) {
        Intrinsics.checkNotNullParameter(list, "ws");
        this.ws = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Rt(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
