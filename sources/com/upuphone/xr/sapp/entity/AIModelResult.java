package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AIModelResult;", "", "requestResult", "", "state", "", "visible", "(ZIZ)V", "getRequestResult", "()Z", "setRequestResult", "(Z)V", "getState", "()I", "setState", "(I)V", "getVisible$annotations", "()V", "getVisible", "setVisible", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AIModelResult {
    private boolean requestResult;
    private int state;
    private boolean visible;

    public AIModelResult() {
        this(false, 0, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AIModelResult copy$default(AIModelResult aIModelResult, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = aIModelResult.requestResult;
        }
        if ((i2 & 2) != 0) {
            i = aIModelResult.state;
        }
        if ((i2 & 4) != 0) {
            z2 = aIModelResult.visible;
        }
        return aIModelResult.copy(z, i, z2);
    }

    @Deprecated(message = "该属性已废弃，默认所有版本都支持大模型功能")
    public static /* synthetic */ void getVisible$annotations() {
    }

    public final boolean component1() {
        return this.requestResult;
    }

    public final int component2() {
        return this.state;
    }

    public final boolean component3() {
        return this.visible;
    }

    @NotNull
    public final AIModelResult copy(boolean z, int i, boolean z2) {
        return new AIModelResult(z, i, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIModelResult)) {
            return false;
        }
        AIModelResult aIModelResult = (AIModelResult) obj;
        return this.requestResult == aIModelResult.requestResult && this.state == aIModelResult.state && this.visible == aIModelResult.visible;
    }

    public final boolean getRequestResult() {
        return this.requestResult;
    }

    public final int getState() {
        return this.state;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.requestResult) * 31) + Integer.hashCode(this.state)) * 31) + Boolean.hashCode(this.visible);
    }

    public final void setRequestResult(boolean z) {
        this.requestResult = z;
    }

    public final void setState(int i) {
        this.state = i;
    }

    public final void setVisible(boolean z) {
        this.visible = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.requestResult;
        int i = this.state;
        boolean z2 = this.visible;
        return "AIModelResult(requestResult=" + z + ", state=" + i + ", visible=" + z2 + ")";
    }

    public AIModelResult(boolean z, int i, boolean z2) {
        this.requestResult = z;
        this.state = i;
        this.visible = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AIModelResult(boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? Integer.parseInt("0") : i, (i2 & 4) != 0 ? true : z2);
    }
}
