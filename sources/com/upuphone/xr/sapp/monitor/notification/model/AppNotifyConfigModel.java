package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;", "", "packageName", "", "disableState", "", "showAllNotify", "needTts", "(Ljava/lang/String;ZZZ)V", "getDisableState", "()Z", "setDisableState", "(Z)V", "getNeedTts", "setNeedTts", "getPackageName", "()Ljava/lang/String;", "getShowAllNotify", "setShowAllNotify", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AppNotifyConfigModel {
    private boolean disableState;
    private boolean needTts;
    @NotNull
    private final String packageName;
    private boolean showAllNotify;

    public AppNotifyConfigModel(@NotNull String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        this.packageName = str;
        this.disableState = z;
        this.showAllNotify = z2;
        this.needTts = z3;
    }

    public final boolean getDisableState() {
        return this.disableState;
    }

    public final boolean getNeedTts() {
        return this.needTts;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getShowAllNotify() {
        return this.showAllNotify;
    }

    public final void setDisableState(boolean z) {
        this.disableState = z;
    }

    public final void setNeedTts(boolean z) {
        this.needTts = z;
    }

    public final void setShowAllNotify(boolean z) {
        this.showAllNotify = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppNotifyConfigModel(String str, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3);
    }
}
