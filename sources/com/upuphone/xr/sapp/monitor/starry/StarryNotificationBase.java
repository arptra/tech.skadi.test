package com.upuphone.xr.sapp.monitor.starry;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/starry/StarryNotificationBase;", "T", "", "notificationAction", "", "data", "(Ljava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getNotificationAction", "()Ljava/lang/String;", "setNotificationAction", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/upuphone/xr/sapp/monitor/starry/StarryNotificationBase;", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class StarryNotificationBase<T> {
    @Nullable
    private T data;
    @NotNull
    private String notificationAction;

    public StarryNotificationBase() {
        this((String) null, (Object) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StarryNotificationBase copy$default(StarryNotificationBase starryNotificationBase, String str, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            str = starryNotificationBase.notificationAction;
        }
        if ((i & 2) != 0) {
            t = starryNotificationBase.data;
        }
        return starryNotificationBase.copy(str, t);
    }

    @NotNull
    public final String component1() {
        return this.notificationAction;
    }

    @Nullable
    public final T component2() {
        return this.data;
    }

    @NotNull
    public final StarryNotificationBase<T> copy(@NotNull String str, @Nullable T t) {
        Intrinsics.checkNotNullParameter(str, "notificationAction");
        return new StarryNotificationBase<>(str, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StarryNotificationBase)) {
            return false;
        }
        StarryNotificationBase starryNotificationBase = (StarryNotificationBase) obj;
        return Intrinsics.areEqual((Object) this.notificationAction, (Object) starryNotificationBase.notificationAction) && Intrinsics.areEqual((Object) this.data, (Object) starryNotificationBase.data);
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @NotNull
    public final String getNotificationAction() {
        return this.notificationAction;
    }

    public int hashCode() {
        int hashCode = this.notificationAction.hashCode() * 31;
        T t = this.data;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public final void setData(@Nullable T t) {
        this.data = t;
    }

    public final void setNotificationAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notificationAction = str;
    }

    @NotNull
    public String toString() {
        String str = this.notificationAction;
        T t = this.data;
        return "StarryNotificationBase(notificationAction=" + str + ", data=" + t + ")";
    }

    public StarryNotificationBase(@NotNull String str, @Nullable T t) {
        Intrinsics.checkNotNullParameter(str, "notificationAction");
        this.notificationAction = str;
        this.data = t;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StarryNotificationBase(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "SHOW_NOTIFICATION" : str, (i & 2) != 0 ? null : obj);
    }
}
