package com.upuphone.ar.fastrecord.phone.starrynet.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/RecordInterConnectMessage;", "", "msgCmd", "", "fastRecordData", "", "(ILjava/lang/String;)V", "getFastRecordData", "()Ljava/lang/String;", "setFastRecordData", "(Ljava/lang/String;)V", "getMsgCmd", "()I", "setMsgCmd", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordInterConnectMessage {
    @SerializedName("fastRecordData")
    @Nullable
    private String fastRecordData;
    @SerializedName("msgCmd")
    private int msgCmd;

    public RecordInterConnectMessage(int i, @Nullable String str) {
        this.msgCmd = i;
        this.fastRecordData = str;
    }

    public static /* synthetic */ RecordInterConnectMessage copy$default(RecordInterConnectMessage recordInterConnectMessage, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recordInterConnectMessage.msgCmd;
        }
        if ((i2 & 2) != 0) {
            str = recordInterConnectMessage.fastRecordData;
        }
        return recordInterConnectMessage.copy(i, str);
    }

    public final int component1() {
        return this.msgCmd;
    }

    @Nullable
    public final String component2() {
        return this.fastRecordData;
    }

    @NotNull
    public final RecordInterConnectMessage copy(int i, @Nullable String str) {
        return new RecordInterConnectMessage(i, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordInterConnectMessage)) {
            return false;
        }
        RecordInterConnectMessage recordInterConnectMessage = (RecordInterConnectMessage) obj;
        return this.msgCmd == recordInterConnectMessage.msgCmd && Intrinsics.areEqual((Object) this.fastRecordData, (Object) recordInterConnectMessage.fastRecordData);
    }

    @Nullable
    public final String getFastRecordData() {
        return this.fastRecordData;
    }

    public final int getMsgCmd() {
        return this.msgCmd;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.msgCmd) * 31;
        String str = this.fastRecordData;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setFastRecordData(@Nullable String str) {
        this.fastRecordData = str;
    }

    public final void setMsgCmd(int i) {
        this.msgCmd = i;
    }

    @NotNull
    public String toString() {
        int i = this.msgCmd;
        String str = this.fastRecordData;
        return "RecordInterConnectMessage(msgCmd=" + i + ", fastRecordData=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordInterConnectMessage(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }
}
