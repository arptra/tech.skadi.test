package com.meizu.flyme.policy.sdk.config;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/meizu/flyme/policy/sdk/config/PolicyRequestErrorCode;", "", "Companion", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface PolicyRequestErrorCode {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int SERVICE_ERROR = 500;
    public static final int SERVICE_PARAMETER_ERROR = 100001;
    public static final int SERVICE_POLICY_NON_EXIST = 210001;
    public static final int SERVICE_POLICY_VERSION_NON_EXIST = 210002;
    public static final int SERVICE_RECORD_APP_ID_ERROR = 110003;
    public static final int SERVICE_SUCCESS = 200;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/meizu/flyme/policy/sdk/config/PolicyRequestErrorCode$Companion;", "", "()V", "SERVICE_ERROR", "", "SERVICE_PARAMETER_ERROR", "SERVICE_POLICY_NON_EXIST", "SERVICE_POLICY_VERSION_NON_EXIST", "SERVICE_RECORD_APP_ID_ERROR", "SERVICE_SUCCESS", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SERVICE_ERROR = 500;
        public static final int SERVICE_PARAMETER_ERROR = 100001;
        public static final int SERVICE_POLICY_NON_EXIST = 210001;
        public static final int SERVICE_POLICY_VERSION_NON_EXIST = 210002;
        public static final int SERVICE_RECORD_APP_ID_ERROR = 110003;
        public static final int SERVICE_SUCCESS = 200;

        private Companion() {
        }
    }
}
