package com.meizu.flyme.policy.sdk.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/meizu/flyme/policy/sdk/config/PolicySdkErrorCode;", "", "()V", "FAILED", "", "NETWORK_ERROR", "NOT_NETWORK", "PARAMETER_ERROR", "PARAMETER_LOCAL_FILE_NAME_ERROR", "SUCCESS", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySdkErrorCode {
    public static final int FAILED = -1;
    @NotNull
    public static final PolicySdkErrorCode INSTANCE = new PolicySdkErrorCode();
    public static final int NETWORK_ERROR = -10004;
    public static final int NOT_NETWORK = -10003;
    public static final int PARAMETER_ERROR = -10001;
    public static final int PARAMETER_LOCAL_FILE_NAME_ERROR = -10002;
    public static final int SUCCESS = 0;

    private PolicySdkErrorCode() {
    }
}
