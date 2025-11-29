package com.honey.account.view.web.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/honey/account/view/web/data/WebResult;", "T", "", "isOk", "", "value", "msg", "", "(ZLjava/lang/Object;Ljava/lang/String;)V", "()Z", "setOk", "(Z)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(ZLjava/lang/Object;Ljava/lang/String;)Lcom/honey/account/view/web/data/WebResult;", "equals", "other", "hashCode", "", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebResult<T> {
    private boolean isOk;
    @Nullable
    private String msg;
    @Nullable
    private T value;

    public WebResult(boolean z, @Nullable T t, @Nullable String str) {
        this.isOk = z;
        this.value = t;
        this.msg = str;
    }

    public static /* synthetic */ WebResult copy$default(WebResult webResult, boolean z, T t, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webResult.isOk;
        }
        if ((i & 2) != 0) {
            t = webResult.value;
        }
        if ((i & 4) != 0) {
            str = webResult.msg;
        }
        return webResult.copy(z, t, str);
    }

    public final boolean component1() {
        return this.isOk;
    }

    @Nullable
    public final T component2() {
        return this.value;
    }

    @Nullable
    public final String component3() {
        return this.msg;
    }

    @NotNull
    public final WebResult<T> copy(boolean z, @Nullable T t, @Nullable String str) {
        return new WebResult<>(z, t, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebResult)) {
            return false;
        }
        WebResult webResult = (WebResult) obj;
        return this.isOk == webResult.isOk && Intrinsics.areEqual((Object) this.value, (Object) webResult.value) && Intrinsics.areEqual((Object) this.msg, (Object) webResult.msg);
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        boolean z = this.isOk;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        T t = this.value;
        int i2 = 0;
        int hashCode = (i + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final boolean isOk() {
        return this.isOk;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setOk(boolean z) {
        this.isOk = z;
    }

    public final void setValue(@Nullable T t) {
        this.value = t;
    }

    @NotNull
    public String toString() {
        return "WebResult(isOk=" + this.isOk + ", value=" + this.value + ", msg=" + this.msg + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebResult(boolean z, Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str);
    }
}
