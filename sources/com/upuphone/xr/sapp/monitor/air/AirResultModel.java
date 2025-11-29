package com.upuphone.xr.sapp.monitor.air;

import androidx.annotation.Keep;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/air/AirResultModel;", "", "functionName", "", "requestId", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "code", "", "msg", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getData", "()Ljava/util/HashMap;", "setData", "(Ljava/util/HashMap;)V", "getFunctionName", "()Ljava/lang/String;", "setFunctionName", "(Ljava/lang/String;)V", "getMsg", "setMsg", "getRequestId", "setRequestId", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirResultModel {
    private int code;
    @NotNull
    private HashMap<String, Object> data;
    @NotNull
    private String functionName;
    @NotNull
    private String msg;
    @NotNull
    private String requestId;

    public AirResultModel(@NotNull String str, @NotNull String str2, @NotNull HashMap<String, Object> hashMap, int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "functionName");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        Intrinsics.checkNotNullParameter(hashMap, "data");
        Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.functionName = str;
        this.requestId = str2;
        this.data = hashMap;
        this.code = i;
        this.msg = str3;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final HashMap<String, Object> getData() {
        return this.data;
    }

    @NotNull
    public final String getFunctionName() {
        return this.functionName;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setData(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.data = hashMap;
    }

    public final void setFunctionName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.functionName = str;
    }

    public final void setMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msg = str;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirResultModel(String str, String str2, HashMap hashMap, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, hashMap, (i2 & 8) != 0 ? 200 : i, (i2 & 16) != 0 ? "成功" : str3);
    }
}
