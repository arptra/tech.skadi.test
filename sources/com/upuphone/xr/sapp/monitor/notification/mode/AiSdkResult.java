package com.upuphone.xr.sapp.monitor.notification.mode;

import android.service.notification.StatusBarNotification;
import androidx.annotation.Keep;
import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.sdk.ResultType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J5\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "", "type", "Lcom/upuphone/sdk/ResultType;", "model", "Lcom/upuphone/sdk/ArSmartReminderModel;", "sbn", "Landroid/service/notification/StatusBarNotification;", "canReply", "", "(Lcom/upuphone/sdk/ResultType;Lcom/upuphone/sdk/ArSmartReminderModel;Landroid/service/notification/StatusBarNotification;Z)V", "getCanReply", "()Z", "setCanReply", "(Z)V", "getModel", "()Lcom/upuphone/sdk/ArSmartReminderModel;", "setModel", "(Lcom/upuphone/sdk/ArSmartReminderModel;)V", "getSbn", "()Landroid/service/notification/StatusBarNotification;", "setSbn", "(Landroid/service/notification/StatusBarNotification;)V", "getType", "()Lcom/upuphone/sdk/ResultType;", "setType", "(Lcom/upuphone/sdk/ResultType;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AiSdkResult {
    private boolean canReply;
    @Nullable
    private ArSmartReminderModel model;
    @NotNull
    private StatusBarNotification sbn;
    @Nullable
    private ResultType type;

    public AiSdkResult(@Nullable ResultType resultType, @Nullable ArSmartReminderModel arSmartReminderModel, @NotNull StatusBarNotification statusBarNotification, boolean z) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        this.type = resultType;
        this.model = arSmartReminderModel;
        this.sbn = statusBarNotification;
        this.canReply = z;
    }

    public static /* synthetic */ AiSdkResult copy$default(AiSdkResult aiSdkResult, ResultType resultType, ArSmartReminderModel arSmartReminderModel, StatusBarNotification statusBarNotification, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            resultType = aiSdkResult.type;
        }
        if ((i & 2) != 0) {
            arSmartReminderModel = aiSdkResult.model;
        }
        if ((i & 4) != 0) {
            statusBarNotification = aiSdkResult.sbn;
        }
        if ((i & 8) != 0) {
            z = aiSdkResult.canReply;
        }
        return aiSdkResult.copy(resultType, arSmartReminderModel, statusBarNotification, z);
    }

    @Nullable
    public final ResultType component1() {
        return this.type;
    }

    @Nullable
    public final ArSmartReminderModel component2() {
        return this.model;
    }

    @NotNull
    public final StatusBarNotification component3() {
        return this.sbn;
    }

    public final boolean component4() {
        return this.canReply;
    }

    @NotNull
    public final AiSdkResult copy(@Nullable ResultType resultType, @Nullable ArSmartReminderModel arSmartReminderModel, @NotNull StatusBarNotification statusBarNotification, boolean z) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        return new AiSdkResult(resultType, arSmartReminderModel, statusBarNotification, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiSdkResult)) {
            return false;
        }
        AiSdkResult aiSdkResult = (AiSdkResult) obj;
        return this.type == aiSdkResult.type && Intrinsics.areEqual((Object) this.model, (Object) aiSdkResult.model) && Intrinsics.areEqual((Object) this.sbn, (Object) aiSdkResult.sbn) && this.canReply == aiSdkResult.canReply;
    }

    public final boolean getCanReply() {
        return this.canReply;
    }

    @Nullable
    public final ArSmartReminderModel getModel() {
        return this.model;
    }

    @NotNull
    public final StatusBarNotification getSbn() {
        return this.sbn;
    }

    @Nullable
    public final ResultType getType() {
        return this.type;
    }

    public int hashCode() {
        ResultType resultType = this.type;
        int i = 0;
        int hashCode = (resultType == null ? 0 : resultType.hashCode()) * 31;
        ArSmartReminderModel arSmartReminderModel = this.model;
        if (arSmartReminderModel != null) {
            i = arSmartReminderModel.hashCode();
        }
        return ((((hashCode + i) * 31) + this.sbn.hashCode()) * 31) + Boolean.hashCode(this.canReply);
    }

    public final void setCanReply(boolean z) {
        this.canReply = z;
    }

    public final void setModel(@Nullable ArSmartReminderModel arSmartReminderModel) {
        this.model = arSmartReminderModel;
    }

    public final void setSbn(@NotNull StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "<set-?>");
        this.sbn = statusBarNotification;
    }

    public final void setType(@Nullable ResultType resultType) {
        this.type = resultType;
    }

    @NotNull
    public String toString() {
        ResultType resultType = this.type;
        ArSmartReminderModel arSmartReminderModel = this.model;
        StatusBarNotification statusBarNotification = this.sbn;
        boolean z = this.canReply;
        return "AiSdkResult(type=" + resultType + ", model=" + arSmartReminderModel + ", sbn=" + statusBarNotification + ", canReply=" + z + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AiSdkResult(ResultType resultType, ArSmartReminderModel arSmartReminderModel, StatusBarNotification statusBarNotification, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resultType, arSmartReminderModel, statusBarNotification, (i & 8) != 0 ? false : z);
    }
}
