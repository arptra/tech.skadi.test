package com.meizu.flyme.policy.sdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyNewestPathResultBean;", "", "()V", "isExists", "", "()Z", "setExists", "(Z)V", "newestPolicyName", "", "getNewestPolicyName", "()Ljava/lang/String;", "setNewestPolicyName", "(Ljava/lang/String;)V", "newestPolicyPath", "getNewestPolicyPath", "setNewestPolicyPath", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyNewestPathResultBean {
    private boolean isExists;
    @NotNull
    private String newestPolicyName = "";
    @NotNull
    private String newestPolicyPath = "";

    @NotNull
    public final String getNewestPolicyName() {
        return this.newestPolicyName;
    }

    @NotNull
    public final String getNewestPolicyPath() {
        return this.newestPolicyPath;
    }

    public final boolean isExists() {
        return this.isExists;
    }

    public final void setExists(boolean z) {
        this.isExists = z;
    }

    public final void setNewestPolicyName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newestPolicyName = str;
    }

    public final void setNewestPolicyPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newestPolicyPath = str;
    }
}
