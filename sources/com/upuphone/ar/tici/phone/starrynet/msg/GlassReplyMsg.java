package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/GlassReplyMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/msg/IMsgId;", "msgId", "", "(Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassReplyMsg extends BaseJsonMsg implements IMsgId {
    @SerializedName("msgId")
    @NotNull
    private final String msgId;

    public GlassReplyMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        this.msgId = str;
    }

    public static /* synthetic */ GlassReplyMsg copy$default(GlassReplyMsg glassReplyMsg, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = glassReplyMsg.msgId;
        }
        return glassReplyMsg.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.msgId;
    }

    @NotNull
    public final GlassReplyMsg copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        return new GlassReplyMsg(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlassReplyMsg) && Intrinsics.areEqual((Object) this.msgId, (Object) ((GlassReplyMsg) obj).msgId);
    }

    @NotNull
    public String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        return this.msgId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.msgId;
        return "GlassReplyMsg(msgId=" + str + ")";
    }
}
