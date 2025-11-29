package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import com.upuphone.starrynet.api.StConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;", "", "msgType", "", "discernResult", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getDiscernResult", "()Ljava/util/Map;", "setDiscernResult", "(Ljava/util/Map;)V", "getMsgType", "()Ljava/lang/String;", "setMsgType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DiscernResultModel {
    @NotNull
    private Map<String, String> discernResult;
    @NotNull
    private String msgType;

    public DiscernResultModel(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, StConstant.STARRY_MESSAGE_KEY_MSG_TYPE);
        Intrinsics.checkNotNullParameter(map, "discernResult");
        this.msgType = str;
        this.discernResult = map;
    }

    public static /* synthetic */ DiscernResultModel copy$default(DiscernResultModel discernResultModel, String str, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = discernResultModel.msgType;
        }
        if ((i & 2) != 0) {
            map = discernResultModel.discernResult;
        }
        return discernResultModel.copy(str, map);
    }

    @NotNull
    public final String component1() {
        return this.msgType;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.discernResult;
    }

    @NotNull
    public final DiscernResultModel copy(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, StConstant.STARRY_MESSAGE_KEY_MSG_TYPE);
        Intrinsics.checkNotNullParameter(map, "discernResult");
        return new DiscernResultModel(str, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiscernResultModel)) {
            return false;
        }
        DiscernResultModel discernResultModel = (DiscernResultModel) obj;
        return Intrinsics.areEqual((Object) this.msgType, (Object) discernResultModel.msgType) && Intrinsics.areEqual((Object) this.discernResult, (Object) discernResultModel.discernResult);
    }

    @NotNull
    public final Map<String, String> getDiscernResult() {
        return this.discernResult;
    }

    @NotNull
    public final String getMsgType() {
        return this.msgType;
    }

    public int hashCode() {
        return (this.msgType.hashCode() * 31) + this.discernResult.hashCode();
    }

    public final void setDiscernResult(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.discernResult = map;
    }

    public final void setMsgType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msgType = str;
    }

    @NotNull
    public String toString() {
        String str = this.msgType;
        Map<String, String> map = this.discernResult;
        return "DiscernResultModel(msgType=" + str + ", discernResult=" + map + ")";
    }
}
