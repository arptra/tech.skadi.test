package sdk.meizu.account.factor.authentication.sdk.repository;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService;
import sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario;
import sdk.meizu.account.factor.authentication.sdk.data.GeetestData;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JL\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J@\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018JF\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001fJD\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository;", "", "apiService", "Lsdk/meizu/account/factor/authentication/sdk/api/FactorAuthenticationService;", "(Lsdk/meizu/account/factor/authentication/sdk/api/FactorAuthenticationService;)V", "confirm", "Lkotlin/Result;", "Lsdk/meizu/account/factor/authentication/sdk/data/ConfirmValue;", "token", "", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "mode", "Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "validate", "account", "confirm-hUnOzRk", "(Ljava/lang/String;Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmAnswer", "", "answerList", "", "Lsdk/meizu/account/factor/authentication/sdk/data/AnswerType;", "confirmAnswer-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSupportValidateType", "Lsdk/meizu/account/factor/authentication/sdk/data/ResponseValidateData;", "processName", "data", "Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;", "getSupportValidateType-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVCode", "getVCode-yxL6bBk", "(Ljava/lang/String;Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;Ljava/lang/String;Lsdk/meizu/account/factor/authentication/sdk/data/GeetestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFactorAuthenticationRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FactorAuthenticationRepository.kt\nsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,185:1\n1864#2,3:186\n*S KotlinDebug\n*F\n+ 1 FactorAuthenticationRepository.kt\nsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository\n*L\n166#1:186,3\n*E\n"})
public final class FactorAuthenticationRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FactorAuthenticationRepository";
    @NotNull
    private final FactorAuthenticationService apiService;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/repository/FactorAuthenticationRepository$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModeScenario.values().length];
            try {
                iArr[ModeScenario.LOGIN_ACCOUNT_VALIDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public FactorAuthenticationRepository(@NotNull FactorAuthenticationService factorAuthenticationService) {
        Intrinsics.checkNotNullParameter(factorAuthenticationService, "apiService");
        this.apiService = factorAuthenticationService;
    }

    /* renamed from: getSupportValidateType-yxL6bBk$default  reason: not valid java name */
    public static /* synthetic */ Object m11getSupportValidateTypeyxL6bBk$default(FactorAuthenticationRepository factorAuthenticationRepository, String str, String str2, String str3, GeetestData geetestData, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            geetestData = null;
        }
        return factorAuthenticationRepository.m14getSupportValidateTypeyxL6bBk(str, str2, str3, geetestData, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ff A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0135 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: confirm-hUnOzRk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m12confirmhUnOzRk(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r10, @org.jetbrains.annotations.Nullable sdk.meizu.account.factor.authentication.sdk.constant.Mode r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue>> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirm$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirm$1 r0 = (sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirm$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirm$1 r0 = new sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirm$1
            r0.<init>(r8, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            java.lang.String r4 = ""
            r5 = 1
            java.lang.String r6 = "FactorAuthenticationRepository"
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0031 }
            goto L_0x00d1
        L_0x0031:
            r8 = move-exception
            goto L_0x0161
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0031 }
            goto L_0x00c3
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r14.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "confirm. type: "
            r14.append(r2)     // Catch:{ all -> 0x0031 }
            r14.append(r10)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = ", mode: "
            r14.append(r2)     // Catch:{ all -> 0x0031 }
            r14.append(r11)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = ", validate: "
            r14.append(r2)     // Catch:{ all -> 0x0031 }
            r14.append(r12)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = ", token: "
            r14.append(r2)     // Catch:{ all -> 0x0031 }
            r14.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0031 }
            android.util.Log.d(r6, r14)     // Catch:{ all -> 0x0031 }
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService$Companion r14 = sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService.Companion     // Catch:{ all -> 0x0031 }
            sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r2 = sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt.getParamModeScenario()     // Catch:{ all -> 0x0031 }
            java.lang.String r14 = r14.getConfirm(r2)     // Catch:{ all -> 0x0031 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0031 }
            r2.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = "access_token"
            r2.put(r7, r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "validate_code_type"
            java.lang.String r10 = r10.getValidateType()     // Catch:{ all -> 0x0031 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "validate_mode"
            if (r11 == 0) goto L_0x0097
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0031 }
            if (r10 != 0) goto L_0x0098
        L_0x0097:
            r10 = r4
        L_0x0098:
            r2.put(r9, r10)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "validate_value"
            r2.put(r9, r12)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "bind_account"
            r2.put(r9, r13)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "vcode"
            r2.put(r9, r12)     // Catch:{ all -> 0x0031 }
            sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r9 = sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt.getParamModeScenario()     // Catch:{ all -> 0x0031 }
            int[] r10 = sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x0031 }
            int r9 = r9.ordinal()     // Catch:{ all -> 0x0031 }
            r9 = r10[r9]     // Catch:{ all -> 0x0031 }
            if (r9 != r5) goto L_0x00c6
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService r8 = r8.apiService     // Catch:{ all -> 0x0031 }
            r0.label = r5     // Catch:{ all -> 0x0031 }
            java.lang.Object r14 = r8.execute(r14, r2, r0)     // Catch:{ all -> 0x0031 }
            if (r14 != r1) goto L_0x00c3
            return r1
        L_0x00c3:
            sdk.meizu.account.factor.authentication.sdk.data.ResponseModel r14 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseModel) r14     // Catch:{ all -> 0x0031 }
            goto L_0x00d3
        L_0x00c6:
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService r8 = r8.apiService     // Catch:{ all -> 0x0031 }
            r0.label = r3     // Catch:{ all -> 0x0031 }
            java.lang.Object r14 = r8.confirm(r14, r2, r0)     // Catch:{ all -> 0x0031 }
            if (r14 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            sdk.meizu.account.factor.authentication.sdk.data.ResponseModel r14 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseModel) r14     // Catch:{ all -> 0x0031 }
        L_0x00d3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r8.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "confirm. responseModel: "
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            r8.append(r14)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = ", val: "
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.Object r9 = r14.getValue()     // Catch:{ all -> 0x0031 }
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0031 }
            android.util.Log.d(r6, r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r14.getCode()     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "200"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x0135
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r8.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "confirm. value: "
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.Object r9 = r14.getValue()     // Catch:{ all -> 0x0031 }
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0031 }
            android.util.Log.d(r6, r8)     // Catch:{ all -> 0x0031 }
            java.lang.Object r8 = r14.getValue()     // Catch:{ all -> 0x0031 }
            boolean r8 = r8 instanceof java.lang.Boolean     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x0125
            sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue r8 = new sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue     // Catch:{ all -> 0x0031 }
            r8.<init>(r4, r4)     // Catch:{ all -> 0x0031 }
            goto L_0x0130
        L_0x0125:
            java.lang.Object r8 = r14.getValue()     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "null cannot be cast to non-null type sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)     // Catch:{ all -> 0x0031 }
            sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue r8 = (sdk.meizu.account.factor.authentication.sdk.data.ConfirmValue) r8     // Catch:{ all -> 0x0031 }
        L_0x0130:
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0188
        L_0x0135:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r8.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = "confirm. fail: "
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = r14.getMessage()     // Catch:{ all -> 0x0031 }
            r8.append(r9)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0031 }
            android.util.Log.d(r6, r8)     // Catch:{ all -> 0x0031 }
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0031 }
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0031 }
            java.lang.String r9 = r14.getMessage()     // Catch:{ all -> 0x0031 }
            r8.<init>(r9)     // Catch:{ all -> 0x0031 }
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x0031 }
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0188
        L_0x0161:
            java.lang.String r9 = "confirm. throw. "
            android.util.Log.d(r6, r9, r8)
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            boolean r10 = r8 instanceof retrofit2.HttpException
            if (r10 == 0) goto L_0x0179
            retrofit2.HttpException r8 = (retrofit2.HttpException) r8
            int r8 = r8.code()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto L_0x017d
        L_0x0179:
            java.lang.String r8 = r8.getMessage()
        L_0x017d:
            r9.<init>(r8)
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)
        L_0x0188:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository.m12confirmhUnOzRk(java.lang.String, sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType, sdk.meizu.account.factor.authentication.sdk.constant.Mode, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ee A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0100 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: confirmAnswer-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m13confirmAnswerBWLJW6A(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.util.List<sdk.meizu.account.factor.authentication.sdk.data.AnswerType> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.Boolean>> r11) {
        /*
            r7 = this;
            r0 = 1
            boolean r1 = r11 instanceof sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirmAnswer$1
            if (r1 == 0) goto L_0x0014
            r1 = r11
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirmAnswer$1 r1 = (sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirmAnswer$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0014
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x0019
        L_0x0014:
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirmAnswer$1 r1 = new sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$confirmAnswer$1
            r1.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            java.lang.String r4 = "FactorAuthenticationRepository"
            if (r3 == 0) goto L_0x0037
            if (r3 != r0) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x002c }
            goto L_0x00c0
        L_0x002c:
            r7 = move-exception
            goto L_0x0114
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r11.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = "confirmAnswer. answerList: "
            r11.append(r3)     // Catch:{ all -> 0x002c }
            r11.append(r10)     // Catch:{ all -> 0x002c }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r4, r11)     // Catch:{ all -> 0x002c }
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService$Companion r11 = sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService.Companion     // Catch:{ all -> 0x002c }
            sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r3 = sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt.getParamModeScenario()     // Catch:{ all -> 0x002c }
            java.lang.String r11 = r11.getConfirmAnswer(r3)     // Catch:{ all -> 0x002c }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x002c }
            r3.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "access_token"
            r3.put(r5, r8)     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "bind_account"
            r3.put(r8, r9)     // Catch:{ all -> 0x002c }
            java.util.Iterator r8 = r10.iterator()     // Catch:{ all -> 0x002c }
            r9 = 0
        L_0x006c:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x002c }
            if (r10 == 0) goto L_0x00b5
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x002c }
            int r5 = r9 + 1
            if (r9 >= 0) goto L_0x007d
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ all -> 0x002c }
        L_0x007d:
            sdk.meizu.account.factor.authentication.sdk.data.AnswerType r10 = (sdk.meizu.account.factor.authentication.sdk.data.AnswerType) r10     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r9.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r6 = "question"
            r9.append(r6)     // Catch:{ all -> 0x002c }
            r9.append(r5)     // Catch:{ all -> 0x002c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x002c }
            int r6 = r10.getQuestion()     // Catch:{ all -> 0x002c }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x002c }
            r3.put(r9, r6)     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r9.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r6 = "answer"
            r9.append(r6)     // Catch:{ all -> 0x002c }
            r9.append(r5)     // Catch:{ all -> 0x002c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x002c }
            java.lang.String r10 = r10.getSecret()     // Catch:{ all -> 0x002c }
            r3.put(r9, r10)     // Catch:{ all -> 0x002c }
            r9 = r5
            goto L_0x006c
        L_0x00b5:
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService r7 = r7.apiService     // Catch:{ all -> 0x002c }
            r1.label = r0     // Catch:{ all -> 0x002c }
            java.lang.Object r11 = r7.execute(r11, r3, r1)     // Catch:{ all -> 0x002c }
            if (r11 != r2) goto L_0x00c0
            return r2
        L_0x00c0:
            sdk.meizu.account.factor.authentication.sdk.data.ResponseModel r11 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseModel) r11     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r7.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "confirmAnswer. responseModel: "
            r7.append(r8)     // Catch:{ all -> 0x002c }
            r7.append(r11)     // Catch:{ all -> 0x002c }
            java.lang.String r8 = ", val: "
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.Object r8 = r11.getValue()     // Catch:{ all -> 0x002c }
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r4, r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r11.getCode()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "200"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x0100
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = r11.getValue()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = kotlin.Result.m20constructorimpl(r7)     // Catch:{ all -> 0x002c }
            goto L_0x0136
        L_0x0100:
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            java.lang.RuntimeException r7 = new java.lang.RuntimeException     // Catch:{ all -> 0x002c }
            java.lang.String r8 = r11.getMessage()     // Catch:{ all -> 0x002c }
            r7.<init>(r8)     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = kotlin.Result.m20constructorimpl(r7)     // Catch:{ all -> 0x002c }
            goto L_0x0136
        L_0x0114:
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            boolean r9 = r7 instanceof retrofit2.HttpException
            if (r9 == 0) goto L_0x0127
            retrofit2.HttpException r7 = (retrofit2.HttpException) r7
            int r7 = r7.code()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            goto L_0x012b
        L_0x0127:
            java.lang.String r7 = r7.getMessage()
        L_0x012b:
            r8.<init>(r7)
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r7 = kotlin.Result.m20constructorimpl(r7)
        L_0x0136:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository.m13confirmAnswerBWLJW6A(java.lang.String, java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b4 A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00de A[Catch:{ all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getSupportValidateType-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m14getSupportValidateTypeyxL6bBk(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable sdk.meizu.account.factor.authentication.sdk.data.GeetestData r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData>> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getSupportValidateType$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getSupportValidateType$1 r0 = (sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getSupportValidateType$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getSupportValidateType$1 r0 = new sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getSupportValidateType$1
            r0.<init>(r6, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "FactorAuthenticationRepository"
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x002b }
            goto L_0x0086
        L_0x002b:
            r6 = move-exception
            goto L_0x00f7
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r11)
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService$Companion r11 = sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService.Companion     // Catch:{ all -> 0x002b }
            sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r2 = sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt.getParamModeScenario()     // Catch:{ all -> 0x002b }
            java.lang.String r11 = r11.getSupportValidateType(r2)     // Catch:{ all -> 0x002b }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "access_token"
            r2.put(r5, r7)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "bind_account"
            r2.put(r7, r8)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "validate_process_name"
            r2.put(r7, r9)     // Catch:{ all -> 0x002b }
            if (r10 == 0) goto L_0x007b
            java.lang.String r7 = "geetest_version"
            java.lang.String r8 = "3"
            r2.put(r7, r8)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "geetest_challenge"
            java.lang.String r8 = r10.getChallenge()     // Catch:{ all -> 0x002b }
            r2.put(r7, r8)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "geetest_validate"
            java.lang.String r8 = r10.getValidate()     // Catch:{ all -> 0x002b }
            r2.put(r7, r8)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "geetest_seccode"
            java.lang.String r8 = r10.getSeccode()     // Catch:{ all -> 0x002b }
            r2.put(r7, r8)     // Catch:{ all -> 0x002b }
        L_0x007b:
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService r6 = r6.apiService     // Catch:{ all -> 0x002b }
            r0.label = r3     // Catch:{ all -> 0x002b }
            java.lang.Object r11 = r6.getSupportValidateType(r11, r2, r0)     // Catch:{ all -> 0x002b }
            if (r11 != r1) goto L_0x0086
            return r1
        L_0x0086:
            sdk.meizu.account.factor.authentication.sdk.data.ResponseModel r11 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseModel) r11     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r6.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "getSupportValidateType. type: "
            r6.append(r7)     // Catch:{ all -> 0x002b }
            r6.append(r11)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = ", val: "
            r6.append(r7)     // Catch:{ all -> 0x002b }
            java.lang.Object r7 = r11.getValue()     // Catch:{ all -> 0x002b }
            r6.append(r7)     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r4, r6)     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r11.getCode()     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "200"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x002b }
            if (r6 == 0) goto L_0x00de
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r6.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "getSupportValidateType. value: "
            r6.append(r7)     // Catch:{ all -> 0x002b }
            java.lang.Object r7 = r11.getValue()     // Catch:{ all -> 0x002b }
            r6.append(r7)     // Catch:{ all -> 0x002b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r4, r6)     // Catch:{ all -> 0x002b }
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            java.lang.Object r6 = r11.getValue()     // Catch:{ all -> 0x002b }
            java.lang.String r7 = "null cannot be cast to non-null type sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)     // Catch:{ all -> 0x002b }
            sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData r6 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData) r6     // Catch:{ all -> 0x002b }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x002b }
            goto L_0x011e
        L_0x00de:
            java.lang.String r6 = "getSupportValidateType. fail. "
            android.util.Log.d(r4, r6)     // Catch:{ all -> 0x002b }
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x002b }
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ all -> 0x002b }
            java.lang.String r7 = r11.getMessage()     // Catch:{ all -> 0x002b }
            r6.<init>(r7)     // Catch:{ all -> 0x002b }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)     // Catch:{ all -> 0x002b }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x002b }
            goto L_0x011e
        L_0x00f7:
            java.lang.String r7 = "getSupportValidateType. throw. "
            android.util.Log.d(r4, r7, r6)
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            boolean r8 = r6 instanceof retrofit2.HttpException
            if (r8 == 0) goto L_0x010f
            retrofit2.HttpException r6 = (retrofit2.HttpException) r6
            int r6 = r6.code()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            goto L_0x0113
        L_0x010f:
            java.lang.String r6 = r6.getMessage()
        L_0x0113:
            r7.<init>(r6)
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
        L_0x011e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository.m14getSupportValidateTypeyxL6bBk(java.lang.String, java.lang.String, java.lang.String, sdk.meizu.account.factor.authentication.sdk.data.GeetestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0103 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getVCode-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m15getVCodeyxL6bBk(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.Nullable sdk.meizu.account.factor.authentication.sdk.data.GeetestData r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.Boolean>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getVCode$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getVCode$1 r0 = (sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getVCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getVCode$1 r0 = new sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository$getVCode$1
            r0.<init>(r7, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "FactorAuthenticationRepository"
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x002c }
            goto L_0x00ab
        L_0x002c:
            r7 = move-exception
            goto L_0x012f
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService$Companion r12 = sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService.Companion     // Catch:{ all -> 0x002c }
            sdk.meizu.account.factor.authentication.sdk.constant.ModeScenario r2 = sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt.getParamModeScenario()     // Catch:{ all -> 0x002c }
            java.lang.String r12 = r12.getVCode(r2)     // Catch:{ all -> 0x002c }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x002c }
            r2.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "access_token"
            java.lang.String r6 = sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt.getParamToken()     // Catch:{ all -> 0x002c }
            r2.put(r5, r6)     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "validate_code_type"
            java.lang.String r6 = r9.getValidateType()     // Catch:{ all -> 0x002c }
            r2.put(r5, r6)     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "bind_account"
            r2.put(r5, r10)     // Catch:{ all -> 0x002c }
            if (r11 == 0) goto L_0x0084
            java.lang.String r10 = "geetest_version"
            java.lang.String r5 = "3"
            r2.put(r10, r5)     // Catch:{ all -> 0x002c }
            java.lang.String r10 = "geetest_challenge"
            java.lang.String r5 = r11.getChallenge()     // Catch:{ all -> 0x002c }
            r2.put(r10, r5)     // Catch:{ all -> 0x002c }
            java.lang.String r10 = "geetest_validate"
            java.lang.String r5 = r11.getValidate()     // Catch:{ all -> 0x002c }
            r2.put(r10, r5)     // Catch:{ all -> 0x002c }
            java.lang.String r10 = "geetest_seccode"
            java.lang.String r11 = r11.getSeccode()     // Catch:{ all -> 0x002c }
            r2.put(r10, r11)     // Catch:{ all -> 0x002c }
        L_0x0084:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r10.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r11 = "getVCode. type: "
            r10.append(r11)     // Catch:{ all -> 0x002c }
            r10.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r9 = ", token: "
            r10.append(r9)     // Catch:{ all -> 0x002c }
            r10.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r4, r8)     // Catch:{ all -> 0x002c }
            sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService r7 = r7.apiService     // Catch:{ all -> 0x002c }
            r0.label = r3     // Catch:{ all -> 0x002c }
            java.lang.Object r12 = r7.execute(r12, r2, r0)     // Catch:{ all -> 0x002c }
            if (r12 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            sdk.meizu.account.factor.authentication.sdk.data.ResponseModel r12 = (sdk.meizu.account.factor.authentication.sdk.data.ResponseModel) r12     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r7.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "getVCode. vCodeData: "
            r7.append(r8)     // Catch:{ all -> 0x002c }
            r7.append(r12)     // Catch:{ all -> 0x002c }
            java.lang.String r8 = ", val: "
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.Object r8 = r12.getValue()     // Catch:{ all -> 0x002c }
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r4, r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r12.getCode()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "200"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x002c }
            if (r7 == 0) goto L_0x0103
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r7.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "getVCode. value: "
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.Object r8 = r12.getValue()     // Catch:{ all -> 0x002c }
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r4, r7)     // Catch:{ all -> 0x002c }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = r12.getValue()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = kotlin.Result.m20constructorimpl(r7)     // Catch:{ all -> 0x002c }
            goto L_0x0156
        L_0x0103:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r7.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r8 = "getVCode. fail: "
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r8 = r12.getMessage()     // Catch:{ all -> 0x002c }
            r7.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r4, r7)     // Catch:{ all -> 0x002c }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            java.lang.RuntimeException r7 = new java.lang.RuntimeException     // Catch:{ all -> 0x002c }
            java.lang.String r8 = r12.getMessage()     // Catch:{ all -> 0x002c }
            r7.<init>(r8)     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch:{ all -> 0x002c }
            java.lang.Object r7 = kotlin.Result.m20constructorimpl(r7)     // Catch:{ all -> 0x002c }
            goto L_0x0156
        L_0x012f:
            java.lang.String r8 = "getVCode. throw. "
            android.util.Log.d(r4, r8, r7)
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            boolean r9 = r7 instanceof retrofit2.HttpException
            if (r9 == 0) goto L_0x0147
            retrofit2.HttpException r7 = (retrofit2.HttpException) r7
            int r7 = r7.code()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            goto L_0x014b
        L_0x0147:
            java.lang.String r7 = r7.getMessage()
        L_0x014b:
            r8.<init>(r7)
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r7 = kotlin.Result.m20constructorimpl(r7)
        L_0x0156:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository.m15getVCodeyxL6bBk(java.lang.String, sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType, java.lang.String, sdk.meizu.account.factor.authentication.sdk.data.GeetestData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
