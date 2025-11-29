package com.meizu.flyme.policy.sdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyFileDataResultBean;", "", "()V", "area", "", "getArea", "()Ljava/lang/String;", "setArea", "(Ljava/lang/String;)V", "category", "getCategory", "setCategory", "policyUid", "getPolicyUid", "setPolicyUid", "version", "", "getVersion", "()J", "setVersion", "(J)V", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyFileDataResultBean {
    @NotNull
    private String area = "";
    @NotNull
    private String category = "";
    @NotNull
    private String policyUid = "";
    private long version;

    @NotNull
    public final String getArea() {
        return this.area;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getPolicyUid() {
        return this.policyUid;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setArea(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.area = str;
    }

    public final void setCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    public final void setPolicyUid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.policyUid = str;
    }

    public final void setVersion(long j) {
        this.version = j;
    }
}
