package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/entity/StandbyWidgetOrderInfo;", "", "action", "", "value", "Lcom/upuphone/xr/sapp/entity/StandbyWidgetOrderSubInfo;", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/StandbyWidgetOrderSubInfo;)V", "getAction", "()Ljava/lang/String;", "getValue", "()Lcom/upuphone/xr/sapp/entity/StandbyWidgetOrderSubInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class StandbyWidgetOrderInfo {
    @NotNull
    private final String action;
    @NotNull
    private final StandbyWidgetOrderSubInfo value;

    public StandbyWidgetOrderInfo(@NotNull String str, @NotNull StandbyWidgetOrderSubInfo standbyWidgetOrderSubInfo) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(standbyWidgetOrderSubInfo, AccountConstantKt.RESPONSE_VALUE);
        this.action = str;
        this.value = standbyWidgetOrderSubInfo;
    }

    public static /* synthetic */ StandbyWidgetOrderInfo copy$default(StandbyWidgetOrderInfo standbyWidgetOrderInfo, String str, StandbyWidgetOrderSubInfo standbyWidgetOrderSubInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = standbyWidgetOrderInfo.action;
        }
        if ((i & 2) != 0) {
            standbyWidgetOrderSubInfo = standbyWidgetOrderInfo.value;
        }
        return standbyWidgetOrderInfo.copy(str, standbyWidgetOrderSubInfo);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final StandbyWidgetOrderSubInfo component2() {
        return this.value;
    }

    @NotNull
    public final StandbyWidgetOrderInfo copy(@NotNull String str, @NotNull StandbyWidgetOrderSubInfo standbyWidgetOrderSubInfo) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(standbyWidgetOrderSubInfo, AccountConstantKt.RESPONSE_VALUE);
        return new StandbyWidgetOrderInfo(str, standbyWidgetOrderSubInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StandbyWidgetOrderInfo)) {
            return false;
        }
        StandbyWidgetOrderInfo standbyWidgetOrderInfo = (StandbyWidgetOrderInfo) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) standbyWidgetOrderInfo.action) && Intrinsics.areEqual((Object) this.value, (Object) standbyWidgetOrderInfo.value);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final StandbyWidgetOrderSubInfo getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.action;
        StandbyWidgetOrderSubInfo standbyWidgetOrderSubInfo = this.value;
        return "StandbyWidgetOrderInfo(action=" + str + ", value=" + standbyWidgetOrderSubInfo + ")";
    }
}
