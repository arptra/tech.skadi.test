package com.meizu.flyme.policy.sdk.bean;

import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyHistoryListResponse;", "", "code", "", "data", "", "Lcom/meizu/flyme/policy/sdk/bean/PolicyResponse;", "msg", "", "(ILjava/util/List;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyHistoryListResponse {
    private final int code;
    @NotNull
    private final List<PolicyResponse> data;
    @NotNull
    private final String msg;

    public PolicyHistoryListResponse(int i, @NotNull List<PolicyResponse> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.code = i;
        this.data = list;
        this.msg = str;
    }

    public static /* synthetic */ PolicyHistoryListResponse copy$default(PolicyHistoryListResponse policyHistoryListResponse, int i, List<PolicyResponse> list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = policyHistoryListResponse.code;
        }
        if ((i2 & 2) != 0) {
            list = policyHistoryListResponse.data;
        }
        if ((i2 & 4) != 0) {
            str = policyHistoryListResponse.msg;
        }
        return policyHistoryListResponse.copy(i, list, str);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final List<PolicyResponse> component2() {
        return this.data;
    }

    @NotNull
    public final String component3() {
        return this.msg;
    }

    @NotNull
    public final PolicyHistoryListResponse copy(int i, @NotNull List<PolicyResponse> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        return new PolicyHistoryListResponse(i, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyHistoryListResponse)) {
            return false;
        }
        PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) obj;
        return this.code == policyHistoryListResponse.code && Intrinsics.areEqual((Object) this.data, (Object) policyHistoryListResponse.data) && Intrinsics.areEqual((Object) this.msg, (Object) policyHistoryListResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final List<PolicyResponse> getData() {
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "PolicyHistoryListResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
