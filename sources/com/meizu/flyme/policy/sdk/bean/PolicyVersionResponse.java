package com.meizu.flyme.policy.sdk.bean;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyVersionResponse;", "", "code", "", "data", "Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "msg", "", "(ILcom/meizu/flyme/policy/sdk/bean/PolicyData;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyVersionResponse {
    private final int code;
    @NotNull
    private final PolicyData data;
    @NotNull
    private final String msg;

    public PolicyVersionResponse(int i, @NotNull PolicyData policyData, @NotNull String str) {
        Intrinsics.checkNotNullParameter(policyData, "data");
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.code = i;
        this.data = policyData;
        this.msg = str;
    }

    public static /* synthetic */ PolicyVersionResponse copy$default(PolicyVersionResponse policyVersionResponse, int i, PolicyData policyData, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = policyVersionResponse.code;
        }
        if ((i2 & 2) != 0) {
            policyData = policyVersionResponse.data;
        }
        if ((i2 & 4) != 0) {
            str = policyVersionResponse.msg;
        }
        return policyVersionResponse.copy(i, policyData, str);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final PolicyData component2() {
        return this.data;
    }

    @NotNull
    public final String component3() {
        return this.msg;
    }

    @NotNull
    public final PolicyVersionResponse copy(int i, @NotNull PolicyData policyData, @NotNull String str) {
        Intrinsics.checkNotNullParameter(policyData, "data");
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        return new PolicyVersionResponse(i, policyData, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyVersionResponse)) {
            return false;
        }
        PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) obj;
        return this.code == policyVersionResponse.code && Intrinsics.areEqual((Object) this.data, (Object) policyVersionResponse.data) && Intrinsics.areEqual((Object) this.msg, (Object) policyVersionResponse.msg);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final PolicyData getData() {
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
        return "PolicyVersionResponse(code=" + this.code + ", data=" + this.data + ", msg=" + this.msg + ')';
    }
}
