package com.meizu.flyme.policy.sdk.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;", "", "()V", "baseInfoList", "", "Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordBaseInfo;", "getBaseInfoList", "()Ljava/util/List;", "setBaseInfoList", "(Ljava/util/List;)V", "businessId", "", "getBusinessId", "()Ljava/lang/String;", "setBusinessId", "(Ljava/lang/String;)V", "operation", "getOperation", "setOperation", "type", "getType", "setType", "useId", "getUseId", "setUseId", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyRecordRequest {
    @NotNull
    private List<PolicyRecordBaseInfo> baseInfoList = new ArrayList();
    @NotNull
    private String businessId = "";
    @NotNull
    private String operation = "";
    @NotNull
    private String type = "";
    @NotNull
    private String useId = "";

    @NotNull
    public final List<PolicyRecordBaseInfo> getBaseInfoList() {
        return this.baseInfoList;
    }

    @NotNull
    public final String getBusinessId() {
        return this.businessId;
    }

    @NotNull
    public final String getOperation() {
        return this.operation;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUseId() {
        return this.useId;
    }

    public final void setBaseInfoList(@NotNull List<PolicyRecordBaseInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.baseInfoList = list;
    }

    public final void setBusinessId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessId = str;
    }

    public final void setOperation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.operation = str;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final void setUseId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.useId = str;
    }
}
