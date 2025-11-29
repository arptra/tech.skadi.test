package com.meizu.flyme.policy.sdk.util;

import android.util.Log;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/PolicySdkLogUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySdkLogUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "PolicySDK";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/PolicySdkLogUtils$Companion;", "", "()V", "TAG", "", "d", "", "method", "msg", "e", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final void d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "method");
            Log.d(PolicySdkLogUtils.TAG, Intrinsics.stringPlus(str, "() "));
        }

        public final void e(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "method");
            Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            Log.e(PolicySdkLogUtils.TAG, str + "() " + str2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void d(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "method");
            Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            Log.d(PolicySdkLogUtils.TAG, str + "() " + str2);
        }
    }
}
