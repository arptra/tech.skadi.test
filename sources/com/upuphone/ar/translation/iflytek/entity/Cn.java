package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/Cn;", "", "st", "Lcom/upuphone/ar/translation/iflytek/entity/St;", "(Lcom/upuphone/ar/translation/iflytek/entity/St;)V", "getSt", "()Lcom/upuphone/ar/translation/iflytek/entity/St;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Cn {
    @SerializedName("st")
    @NotNull
    private final St st;

    public Cn() {
        this((St) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Cn copy$default(Cn cn, St st2, int i, Object obj) {
        if ((i & 1) != 0) {
            st2 = cn.st;
        }
        return cn.copy(st2);
    }

    @NotNull
    public final St component1() {
        return this.st;
    }

    @NotNull
    public final Cn copy(@NotNull St st2) {
        Intrinsics.checkNotNullParameter(st2, "st");
        return new Cn(st2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cn) && Intrinsics.areEqual((Object) this.st, (Object) ((Cn) obj).st);
    }

    @NotNull
    public final St getSt() {
        return this.st;
    }

    public int hashCode() {
        return this.st.hashCode();
    }

    @NotNull
    public String toString() {
        St st2 = this.st;
        return "Cn(st=" + st2 + ")";
    }

    public Cn(@NotNull St st2) {
        Intrinsics.checkNotNullParameter(st2, "st");
        this.st = st2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cn(St st2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new St((String) null, (String) null, (List) null, (String) null, 15, (DefaultConstructorMarker) null) : st2);
    }
}
