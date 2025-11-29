package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/St;", "", "bg", "", "ed", "rt", "", "Lcom/upuphone/ar/translation/iflytek/entity/Rt;", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getBg", "()Ljava/lang/String;", "getEd", "getRt", "()Ljava/util/List;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class St {
    @SerializedName("bg")
    @NotNull
    private final String bg;
    @SerializedName("ed")
    @NotNull
    private final String ed;
    @SerializedName("rt")
    @NotNull
    private final List<Rt> rt;
    @SerializedName("type")
    @NotNull
    private final String type;

    public St() {
        this((String) null, (String) null, (List) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ St copy$default(St st, String str, String str2, List<Rt> list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = st.bg;
        }
        if ((i & 2) != 0) {
            str2 = st.ed;
        }
        if ((i & 4) != 0) {
            list = st.rt;
        }
        if ((i & 8) != 0) {
            str3 = st.type;
        }
        return st.copy(str, str2, list, str3);
    }

    @NotNull
    public final String component1() {
        return this.bg;
    }

    @NotNull
    public final String component2() {
        return this.ed;
    }

    @NotNull
    public final List<Rt> component3() {
        return this.rt;
    }

    @NotNull
    public final String component4() {
        return this.type;
    }

    @NotNull
    public final St copy(@NotNull String str, @NotNull String str2, @NotNull List<Rt> list, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "bg");
        Intrinsics.checkNotNullParameter(str2, "ed");
        Intrinsics.checkNotNullParameter(list, "rt");
        Intrinsics.checkNotNullParameter(str3, "type");
        return new St(str, str2, list, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof St)) {
            return false;
        }
        St st = (St) obj;
        return Intrinsics.areEqual((Object) this.bg, (Object) st.bg) && Intrinsics.areEqual((Object) this.ed, (Object) st.ed) && Intrinsics.areEqual((Object) this.rt, (Object) st.rt) && Intrinsics.areEqual((Object) this.type, (Object) st.type);
    }

    @NotNull
    public final String getBg() {
        return this.bg;
    }

    @NotNull
    public final String getEd() {
        return this.ed;
    }

    @NotNull
    public final List<Rt> getRt() {
        return this.rt;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.bg.hashCode() * 31) + this.ed.hashCode()) * 31) + this.rt.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.bg;
        String str2 = this.ed;
        List<Rt> list = this.rt;
        String str3 = this.type;
        return "St(bg='" + str + "', ed='" + str2 + "', rt=" + list + ", type='" + str3 + "')";
    }

    public St(@NotNull String str, @NotNull String str2, @NotNull List<Rt> list, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "bg");
        Intrinsics.checkNotNullParameter(str2, "ed");
        Intrinsics.checkNotNullParameter(list, "rt");
        Intrinsics.checkNotNullParameter(str3, "type");
        this.bg = str;
        this.ed = str2;
        this.rt = list;
        this.type = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ St(String str, String str2, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? "1" : str3);
    }
}
