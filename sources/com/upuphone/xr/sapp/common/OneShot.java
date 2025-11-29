package com.upuphone.xr.sapp.common;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\tJ \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\r\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/common/OneShot;", "T", "", "data", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isConsumed", "", "component1", "()Ljava/lang/Object;", "copy", "(Ljava/lang/Object;)Lcom/upuphone/xr/sapp/common/OneShot;", "equals", "other", "get", "hashCode", "", "peek", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OneShot<T> {
    @Nullable
    private final T data;
    private volatile boolean isConsumed;

    public OneShot(@Nullable T t) {
        this.data = t;
    }

    private final T component1() {
        return this.data;
    }

    public static /* synthetic */ OneShot copy$default(OneShot oneShot, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            t = oneShot.data;
        }
        return oneShot.copy(t);
    }

    @NotNull
    public final OneShot<T> copy(@Nullable T t) {
        return new OneShot<>(t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OneShot) && Intrinsics.areEqual((Object) this.data, (Object) ((OneShot) obj).data);
    }

    @Nullable
    public final T get() {
        if (this.isConsumed) {
            return null;
        }
        this.isConsumed = true;
        return this.data;
    }

    public int hashCode() {
        T t = this.data;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    @Nullable
    public final T peek() {
        return this.data;
    }

    @NotNull
    public String toString() {
        T t = this.data;
        return "OneShot(data=" + t + ")";
    }
}
