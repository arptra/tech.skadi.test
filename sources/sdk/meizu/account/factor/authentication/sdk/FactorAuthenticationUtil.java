package sdk.meizu.account.factor.authentication.sdk;

import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.runasone.api.ApiConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.constant.Mode;
import sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario;
import sdk.meizu.account.factor.authentication.sdk.module.BuildConfigProvider;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J@\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationUtil;", "", "()V", "CODE_ERROR_CANCEL", "", "CODE_ERROR_MODE_NULL", "CODE_ERROR_TOKEN_NULL", "CODE_INVALID_TOKEN", "CODE_INVALID_TOKEN_STATUS", "FACTOR_ACTION", "buildConfigProvider", "Lsdk/meizu/account/factor/authentication/sdk/module/BuildConfigProvider;", "getBuildConfigProvider", "()Lsdk/meizu/account/factor/authentication/sdk/module/BuildConfigProvider;", "setBuildConfigProvider", "(Lsdk/meizu/account/factor/authentication/sdk/module/BuildConfigProvider;)V", "factorValidate", "", "data", "Landroid/content/Intent;", "listener", "Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationUtil$FactorValidateListener;", "getSimpleValidateMode", "token", "packageName", "serviceName", "getStrictValidateMode", "getValidateMode", "modeScenario", "Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;", "processName", "mode", "Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "FactorValidateListener", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FactorAuthenticationUtil {
    @NotNull
    public static final String CODE_ERROR_CANCEL = "103";
    @NotNull
    public static final String CODE_ERROR_MODE_NULL = "102";
    @NotNull
    public static final String CODE_ERROR_TOKEN_NULL = "101";
    @NotNull
    public static final String CODE_INVALID_TOKEN = "198001";
    @NotNull
    public static final String CODE_INVALID_TOKEN_STATUS = "401";
    @NotNull
    private static final String FACTOR_ACTION = "com.meizu.account.factor.authentication";
    @NotNull
    public static final FactorAuthenticationUtil INSTANCE = new FactorAuthenticationUtil();
    @Nullable
    private static BuildConfigProvider buildConfigProvider;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationUtil$FactorValidateListener;", "", "failure", "", "code", "", "validateSuccess", "validateCode", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface FactorValidateListener {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void validateSuccess$default(FactorValidateListener factorValidateListener, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    factorValidateListener.validateSuccess(str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateSuccess");
            }
        }

        void failure(@NotNull String str);

        void validateSuccess(@Nullable String str);
    }

    private FactorAuthenticationUtil() {
    }

    public static /* synthetic */ Intent getValidateMode$default(FactorAuthenticationUtil factorAuthenticationUtil, ModeScenario modeScenario, String str, String str2, String str3, String str4, Mode mode, int i, Object obj) {
        String str5 = "";
        String str6 = (i & 2) != 0 ? str5 : str;
        String str7 = (i & 4) != 0 ? str5 : str2;
        String str8 = (i & 8) != 0 ? str5 : str3;
        if ((i & 16) == 0) {
            str5 = str4;
        }
        return factorAuthenticationUtil.getValidateMode(modeScenario, str6, str7, str8, str5, (i & 32) != 0 ? Mode.SIMPLE : mode);
    }

    public final void factorValidate(@Nullable Intent intent, @NotNull FactorValidateListener factorValidateListener) {
        Intrinsics.checkNotNullParameter(factorValidateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("message");
            if (stringExtra == null || stringExtra.length() <= 0) {
                boolean booleanExtra = intent.getBooleanExtra(ConstantKt.FACTOR_RESULT_STATE, false);
                String stringExtra2 = intent.getStringExtra("validate_code");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                Intrinsics.checkNotNull(stringExtra2);
                if (booleanExtra) {
                    factorValidateListener.validateSuccess(stringExtra2);
                    return;
                }
                return;
            }
            factorValidateListener.failure(stringExtra);
            return;
        }
        new FactorAuthenticationUtil$factorValidate$1$2(factorValidateListener);
    }

    @Nullable
    public final BuildConfigProvider getBuildConfigProvider() {
        return buildConfigProvider;
    }

    @NotNull
    public final Intent getSimpleValidateMode(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, ConstantKt.FACTOR_PARAMS_SERVICE_NAME);
        return getValidateMode$default(this, ModeScenario.LOGGED_ACCOUNT_THREE, str, str2, str3, (String) null, Mode.SIMPLE, 16, (Object) null);
    }

    @NotNull
    public final Intent getStrictValidateMode(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, ConstantKt.FACTOR_PARAMS_SERVICE_NAME);
        return getValidateMode$default(this, ModeScenario.LOGGED_ACCOUNT_THREE, str, str2, str3, (String) null, Mode.STRICT, 16, (Object) null);
    }

    @NotNull
    public final Intent getValidateMode(@NotNull ModeScenario modeScenario, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Mode mode) {
        Intrinsics.checkNotNullParameter(modeScenario, ConstantKt.FACTOR_PARAMS_MODE_SCENARIO);
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, ConstantKt.FACTOR_PARAMS_SERVICE_NAME);
        Intrinsics.checkNotNullParameter(str4, ConstantKt.FACTOR_PARAMS_PROCESS_NAME);
        Intrinsics.checkNotNullParameter(mode, RtspHeaders.Values.MODE);
        Intent intent = new Intent();
        intent.setAction(FACTOR_ACTION);
        intent.putExtra(ConstantKt.FACTOR_PARAMS_TOKEN, str);
        intent.putExtra(ConstantKt.FACTOR_PARAMS_MODE, mode.name());
        intent.putExtra(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str2);
        intent.putExtra(ConstantKt.FACTOR_PARAMS_SERVICE_NAME, str3);
        intent.putExtra(ConstantKt.FACTOR_PARAMS_PROCESS_NAME, str4);
        intent.putExtra(ConstantKt.FACTOR_PARAMS_MODE_SCENARIO, Integer.parseInt(modeScenario.toString()));
        return intent;
    }

    public final void setBuildConfigProvider(@Nullable BuildConfigProvider buildConfigProvider2) {
        buildConfigProvider = buildConfigProvider2;
    }
}
