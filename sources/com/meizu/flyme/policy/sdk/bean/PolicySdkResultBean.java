package com.meizu.flyme.policy.sdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u00103\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000e¨\u00069"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicySdkResultBean;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "contentTypes", "", "getContentTypes", "()Ljava/lang/String;", "setContentTypes", "(Ljava/lang/String;)V", "policyData", "Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "getPolicyData", "()Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "setPolicyData", "(Lcom/meizu/flyme/policy/sdk/bean/PolicyData;)V", "policyHistoryListResponse", "Lcom/meizu/flyme/policy/sdk/bean/PolicyHistoryListResponse;", "getPolicyHistoryListResponse", "()Lcom/meizu/flyme/policy/sdk/bean/PolicyHistoryListResponse;", "setPolicyHistoryListResponse", "(Lcom/meizu/flyme/policy/sdk/bean/PolicyHistoryListResponse;)V", "policyNewest", "", "getPolicyNewest", "()Z", "setPolicyNewest", "(Z)V", "policyNewestPath", "getPolicyNewestPath", "setPolicyNewestPath", "policyNewestVersion", "", "getPolicyNewestVersion", "()J", "setPolicyNewestVersion", "(J)V", "policyRecordRequest", "Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;", "getPolicyRecordRequest", "()Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;", "setPolicyRecordRequest", "(Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;)V", "policyRegrantFlag", "getPolicyRegrantFlag", "setPolicyRegrantFlag", "policyUrl", "getPolicyUrl", "setPolicyUrl", "versionDesc", "getVersionDesc", "setVersionDesc", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySdkResultBean {
    private int code;
    @NotNull
    private String contentTypes = "";
    @Nullable
    private PolicyData policyData;
    @Nullable
    private PolicyHistoryListResponse policyHistoryListResponse;
    private boolean policyNewest;
    @NotNull
    private String policyNewestPath = "";
    private long policyNewestVersion;
    @Nullable
    private PolicyRecordRequest policyRecordRequest;
    private boolean policyRegrantFlag;
    @NotNull
    private String policyUrl = "";
    @NotNull
    private String versionDesc = "";

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getContentTypes() {
        return this.contentTypes;
    }

    @Nullable
    public final PolicyData getPolicyData() {
        return this.policyData;
    }

    @Nullable
    public final PolicyHistoryListResponse getPolicyHistoryListResponse() {
        return this.policyHistoryListResponse;
    }

    public final boolean getPolicyNewest() {
        return this.policyNewest;
    }

    @NotNull
    public final String getPolicyNewestPath() {
        return this.policyNewestPath;
    }

    public final long getPolicyNewestVersion() {
        return this.policyNewestVersion;
    }

    @Nullable
    public final PolicyRecordRequest getPolicyRecordRequest() {
        return this.policyRecordRequest;
    }

    public final boolean getPolicyRegrantFlag() {
        return this.policyRegrantFlag;
    }

    @NotNull
    public final String getPolicyUrl() {
        return this.policyUrl;
    }

    @NotNull
    public final String getVersionDesc() {
        return this.versionDesc;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setContentTypes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentTypes = str;
    }

    public final void setPolicyData(@Nullable PolicyData policyData2) {
        this.policyData = policyData2;
    }

    public final void setPolicyHistoryListResponse(@Nullable PolicyHistoryListResponse policyHistoryListResponse2) {
        this.policyHistoryListResponse = policyHistoryListResponse2;
    }

    public final void setPolicyNewest(boolean z) {
        this.policyNewest = z;
    }

    public final void setPolicyNewestPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.policyNewestPath = str;
    }

    public final void setPolicyNewestVersion(long j) {
        this.policyNewestVersion = j;
    }

    public final void setPolicyRecordRequest(@Nullable PolicyRecordRequest policyRecordRequest2) {
        this.policyRecordRequest = policyRecordRequest2;
    }

    public final void setPolicyRegrantFlag(boolean z) {
        this.policyRegrantFlag = z;
    }

    public final void setPolicyUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.policyUrl = str;
    }

    public final void setVersionDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.versionDesc = str;
    }
}
