package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ProtocolModel;", "", "protoId", "", "protoTitle", "", "protoContent", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getProtoContent", "()Ljava/lang/String;", "getProtoId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getProtoTitle", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/ProtocolModel;", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ProtocolModel {
    @Nullable
    private final String protoContent;
    @Nullable
    private final Long protoId;
    @Nullable
    private final String protoTitle;

    public ProtocolModel(@Nullable Long l, @Nullable String str, @Nullable String str2) {
        this.protoId = l;
        this.protoTitle = str;
        this.protoContent = str2;
    }

    public static /* synthetic */ ProtocolModel copy$default(ProtocolModel protocolModel, Long l, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = protocolModel.protoId;
        }
        if ((i & 2) != 0) {
            str = protocolModel.protoTitle;
        }
        if ((i & 4) != 0) {
            str2 = protocolModel.protoContent;
        }
        return protocolModel.copy(l, str, str2);
    }

    @Nullable
    public final Long component1() {
        return this.protoId;
    }

    @Nullable
    public final String component2() {
        return this.protoTitle;
    }

    @Nullable
    public final String component3() {
        return this.protoContent;
    }

    @NotNull
    public final ProtocolModel copy(@Nullable Long l, @Nullable String str, @Nullable String str2) {
        return new ProtocolModel(l, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolModel)) {
            return false;
        }
        ProtocolModel protocolModel = (ProtocolModel) obj;
        return Intrinsics.areEqual((Object) this.protoId, (Object) protocolModel.protoId) && Intrinsics.areEqual((Object) this.protoTitle, (Object) protocolModel.protoTitle) && Intrinsics.areEqual((Object) this.protoContent, (Object) protocolModel.protoContent);
    }

    @Nullable
    public final String getProtoContent() {
        return this.protoContent;
    }

    @Nullable
    public final Long getProtoId() {
        return this.protoId;
    }

    @Nullable
    public final String getProtoTitle() {
        return this.protoTitle;
    }

    public int hashCode() {
        Long l = this.protoId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.protoTitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.protoContent;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        Long l = this.protoId;
        String str = this.protoTitle;
        String str2 = this.protoContent;
        return "ProtocolModel(protoId=" + l + ", protoTitle=" + str + ", protoContent=" + str2 + ")";
    }
}
