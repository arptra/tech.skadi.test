package sdk.meizu.account.factor.authentication.sdk;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010 *\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0#2\"\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0&\u0012\u0006\u0012\u0004\u0018\u00010'0%ø\u0001\u0000¢\u0006\u0002\u0010(\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0012\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0004\b\u0014\u0010\u0005\"\u001a\u0010\u0015\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0003\"\u0004\b\u0017\u0010\u0005\"\u001a\u0010\u0018\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0004\b\u001a\u0010\u0005\"\u001a\u0010\u001b\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0003\"\u0004\b\u001d\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"paramAccount", "", "getParamAccount", "()Ljava/lang/String;", "setParamAccount", "(Ljava/lang/String;)V", "paramMode", "Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "getParamMode", "()Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "setParamMode", "(Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;)V", "paramModeScenario", "Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;", "getParamModeScenario", "()Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;", "setParamModeScenario", "(Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;)V", "paramPackageName", "getParamPackageName", "setParamPackageName", "paramProcessName", "getParamProcessName", "setParamProcessName", "paramServiceName", "getParamServiceName", "setParamServiceName", "paramToken", "getParamToken", "setParamToken", "collectLifecycleFlow", "", "T", "Landroidx/activity/ComponentActivity;", "flow", "Lkotlinx/coroutines/flow/Flow;", "collect", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/ComponentActivity;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationActivityKt {
    @NotNull
    private static String paramAccount = "*";
    @Nullable
    private static Mode paramMode = null;
    public static ModeScenario paramModeScenario = null;
    @NotNull
    private static String paramPackageName = "";
    @NotNull
    private static String paramProcessName = "";
    @NotNull
    private static String paramServiceName = "";
    public static String paramToken;

    public static final <T> void collectLifecycleFlow(@NotNull ComponentActivity componentActivity, @NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(function2, "collect");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(componentActivity), (CoroutineContext) null, (CoroutineStart) null, new FactorAuthenticationActivityKt$collectLifecycleFlow$1(componentActivity, flow, function2, (Continuation<? super FactorAuthenticationActivityKt$collectLifecycleFlow$1>) null), 3, (Object) null);
    }

    @NotNull
    public static final String getParamAccount() {
        return paramAccount;
    }

    @Nullable
    public static final Mode getParamMode() {
        return paramMode;
    }

    @NotNull
    public static final ModeScenario getParamModeScenario() {
        ModeScenario modeScenario = paramModeScenario;
        if (modeScenario != null) {
            return modeScenario;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paramModeScenario");
        return null;
    }

    @NotNull
    public static final String getParamPackageName() {
        return paramPackageName;
    }

    @NotNull
    public static final String getParamProcessName() {
        return paramProcessName;
    }

    @NotNull
    public static final String getParamServiceName() {
        return paramServiceName;
    }

    @NotNull
    public static final String getParamToken() {
        String str = paramToken;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paramToken");
        return null;
    }

    public static final void setParamAccount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        paramAccount = str;
    }

    public static final void setParamMode(@Nullable Mode mode) {
        paramMode = mode;
    }

    public static final void setParamModeScenario(@NotNull ModeScenario modeScenario) {
        Intrinsics.checkNotNullParameter(modeScenario, "<set-?>");
        paramModeScenario = modeScenario;
    }

    public static final void setParamPackageName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        paramPackageName = str;
    }

    public static final void setParamProcessName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        paramProcessName = str;
    }

    public static final void setParamServiceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        paramServiceName = str;
    }

    public static final void setParamToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        paramToken = str;
    }
}
