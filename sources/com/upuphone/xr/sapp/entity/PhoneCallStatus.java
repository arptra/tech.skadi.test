package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/entity/PhoneCallStatus;", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "action", "", "callId", "callStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAction", "()Ljava/lang/String;", "getCallId", "getCallStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class PhoneCallStatus implements IPhoneCallStatus {
    @NotNull
    private final String action;
    @NotNull
    private final String callId;
    private final int callStatus;

    public PhoneCallStatus(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "callId");
        this.action = str;
        this.callId = str2;
        this.callStatus = i;
    }

    public static /* synthetic */ PhoneCallStatus copy$default(PhoneCallStatus phoneCallStatus, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = phoneCallStatus.action;
        }
        if ((i2 & 2) != 0) {
            str2 = phoneCallStatus.callId;
        }
        if ((i2 & 4) != 0) {
            i = phoneCallStatus.callStatus;
        }
        return phoneCallStatus.copy(str, str2, i);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final String component2() {
        return this.callId;
    }

    public final int component3() {
        return this.callStatus;
    }

    @NotNull
    public final PhoneCallStatus copy(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "callId");
        return new PhoneCallStatus(str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneCallStatus)) {
            return false;
        }
        PhoneCallStatus phoneCallStatus = (PhoneCallStatus) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) phoneCallStatus.action) && Intrinsics.areEqual((Object) this.callId, (Object) phoneCallStatus.callId) && this.callStatus == phoneCallStatus.callStatus;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public String getCallId() {
        return this.callId;
    }

    public int getCallStatus() {
        return this.callStatus;
    }

    public int hashCode() {
        return (((this.action.hashCode() * 31) + this.callId.hashCode()) * 31) + Integer.hashCode(this.callStatus);
    }

    @NotNull
    public String toString() {
        String str = this.action;
        String callId2 = getCallId();
        int callStatus2 = getCallStatus();
        return "PhoneCallStatus(action='" + str + "', callId='" + callId2 + "', callStatus=" + callStatus2 + ")";
    }
}
