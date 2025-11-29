package sdk.meizu.account.factor.authentication.sdk.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario;
import sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseModel;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ7\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ=\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003\"\u0004\b\u0000\u0010\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/api/FactorAuthenticationService;", "", "confirm", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseModel;", "Lsdk/meizu/account/factor/authentication/sdk/data/ConfirmValue;", "url", "", "fields", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "T", "getSupportValidateType", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FactorAuthenticationService {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/api/FactorAuthenticationService$Companion;", "", "()V", "getConfirm", "", "modeScenario", "Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;", "getConfirmAnswer", "getSupportValidateType", "getVCode", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            static {
                /*
                    sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario[] r0 = sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r1 = sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario.LOGGED_ACCOUNT_THREE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r1 = sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario.LOGGED_ACCOUNT     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r1 = sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario.LOGGED_ANSWER     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r1 = sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario.LOGIN_ACCOUNT_VALIDATE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService.Companion.WhenMappings.<clinit>():void");
            }
        }

        private Companion() {
        }

        @NotNull
        public final String getConfirm(@NotNull ModeScenario modeScenario) {
            Intrinsics.checkNotNullParameter(modeScenario, ConstantKt.FACTOR_PARAMS_MODE_SCENARIO);
            int i = WhenMappings.$EnumSwitchMapping$0[modeScenario.ordinal()];
            return i != 1 ? i != 2 ? i != 4 ? "" : "system/userInfoManage/validate/validateCode" : "unirest/userInfoManage/validate" : "unirest/openapi/client/validate";
        }

        @NotNull
        public final String getConfirmAnswer(@NotNull ModeScenario modeScenario) {
            Intrinsics.checkNotNullParameter(modeScenario, ConstantKt.FACTOR_PARAMS_MODE_SCENARIO);
            int i = WhenMappings.$EnumSwitchMapping$0[modeScenario.ordinal()];
            return i != 3 ? i != 4 ? "" : "system/userInfoManage/validate/validateAnswer" : "unirest/userInfoManage/answer/verify";
        }

        @NotNull
        public final String getSupportValidateType(@NotNull ModeScenario modeScenario) {
            Intrinsics.checkNotNullParameter(modeScenario, ConstantKt.FACTOR_PARAMS_MODE_SCENARIO);
            int i = WhenMappings.$EnumSwitchMapping$0[modeScenario.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "system/userInfoManage/validate/checkAccount" : "unirest/userInfoManage/answer/list" : "unirest/userInfoManage/validate/supportValidateTypes" : "unirest/openapi/client/validate/supportValidateTypes";
        }

        @NotNull
        public final String getVCode(@NotNull ModeScenario modeScenario) {
            Intrinsics.checkNotNullParameter(modeScenario, ConstantKt.FACTOR_PARAMS_MODE_SCENARIO);
            int i = WhenMappings.$EnumSwitchMapping$0[modeScenario.ordinal()];
            return i != 1 ? i != 2 ? i != 4 ? "" : "system/userInfoManage/validate/sendVcode" : "unirest/userInfoManage/validate/sendVcode" : "unirest/openapi/client/validate/sendVcode";
        }
    }

    @FormUrlEncoded
    @Nullable
    @POST
    Object confirm(@NotNull @Url String str, @NotNull @FieldMap Map<String, String> map, @NotNull Continuation<? super ResponseModel<ConfirmValue>> continuation);

    @FormUrlEncoded
    @Nullable
    @POST
    <T> Object execute(@NotNull @Url String str, @NotNull @FieldMap Map<String, String> map, @NotNull Continuation<? super ResponseModel<T>> continuation);

    @FormUrlEncoded
    @Nullable
    @POST
    Object getSupportValidateType(@NotNull @Url String str, @NotNull @FieldMap Map<String, String> map, @NotNull Continuation<? super ResponseModel<ResponseValidateData>> continuation);
}
