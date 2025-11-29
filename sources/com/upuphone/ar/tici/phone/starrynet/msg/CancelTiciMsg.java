package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/CancelTiciMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "msgId", "", "(Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CancelTiciMsg extends BaseJsonMsg {
    @SerializedName("msgId")
    @NotNull
    private final String msgId;

    public CancelTiciMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        this.msgId = str;
    }

    public static /* synthetic */ CancelTiciMsg copy$default(CancelTiciMsg cancelTiciMsg, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelTiciMsg.msgId;
        }
        return cancelTiciMsg.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.msgId;
    }

    @NotNull
    public final CancelTiciMsg copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        return new CancelTiciMsg(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CancelTiciMsg) && Intrinsics.areEqual((Object) this.msgId, (Object) ((CancelTiciMsg) obj).msgId);
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        return this.msgId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.msgId;
        return "CancelTiciMsg(msgId=" + str + ")";
    }
}
