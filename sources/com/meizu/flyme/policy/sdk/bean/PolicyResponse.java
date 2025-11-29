package com.meizu.flyme.policy.sdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyResponse;", "", "data", "Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "newest", "", "(Lcom/meizu/flyme/policy/sdk/bean/PolicyData;Z)V", "getData", "()Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "getNewest", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyResponse {
    @NotNull
    private final PolicyData data;
    private final boolean newest;

    public PolicyResponse(@NotNull PolicyData policyData, boolean z) {
        Intrinsics.checkNotNullParameter(policyData, "data");
        this.data = policyData;
        this.newest = z;
    }

    public static /* synthetic */ PolicyResponse copy$default(PolicyResponse policyResponse, PolicyData policyData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            policyData = policyResponse.data;
        }
        if ((i & 2) != 0) {
            z = policyResponse.newest;
        }
        return policyResponse.copy(policyData, z);
    }

    @NotNull
    public final PolicyData component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.newest;
    }

    @NotNull
    public final PolicyResponse copy(@NotNull PolicyData policyData, boolean z) {
        Intrinsics.checkNotNullParameter(policyData, "data");
        return new PolicyResponse(policyData, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyResponse)) {
            return false;
        }
        PolicyResponse policyResponse = (PolicyResponse) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) policyResponse.data) && this.newest == policyResponse.newest;
    }

    @NotNull
    public final PolicyData getData() {
        return this.data;
    }

    public final boolean getNewest() {
        return this.newest;
    }

    public int hashCode() {
        int hashCode = this.data.hashCode() * 31;
        boolean z = this.newest;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "PolicyResponse(data=" + this.data + ", newest=" + this.newest + ')';
    }
}
