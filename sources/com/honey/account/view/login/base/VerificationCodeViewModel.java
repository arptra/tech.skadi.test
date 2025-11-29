package com.honey.account.view.login.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.honey.account.common.ResultUiState;
import com.honey.account.data.GeetestData;
import com.honey.account.view.login.data.VCodeMethod;
import com.honey.account.view.login.data.VCodeMode;
import com.honey.account.view.login.repository.LoginRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVerificationCodeViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerificationCodeViewModel.kt\ncom/honey/account/view/login/base/VerificationCodeViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,183:1\n731#2,9:184\n731#2,9:195\n37#3,2:193\n37#3,2:204\n*S KotlinDebug\n*F\n+ 1 VerificationCodeViewModel.kt\ncom/honey/account/view/login/base/VerificationCodeViewModel\n*L\n108#1:184,9\n110#1:195,9\n108#1:193,2\n110#1:204,2\n*E\n"})
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ \u0010 \u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006("}, d2 = {"Lcom/honey/account/view/login/base/VerificationCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/honey/account/view/login/repository/LoginRepository;", "(Lcom/honey/account/view/login/repository/LoginRepository;)V", "_smsCodeUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/honey/account/common/ResultUiState;", "", "_vCodeTimeDownFlow", "", "smsCodeUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getSmsCodeUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setSmsCodeUiState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "vCodeTimeDownFlow", "getVCodeTimeDownFlow", "setVCodeTimeDownFlow", "downFlow", "", "formatAccount", "", "account", "formatEmail", "changeEmail", "formatPhone", "changePhone", "getVCode", "data", "Lcom/honey/account/data/GeetestData;", "plusStart", "frontLen", "endLen", "vCodeMethod", "Lcom/honey/account/view/login/data/VCodeMethod;", "vCodeMode", "Lcom/honey/account/view/login/data/VCodeMode;", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@HiltViewModel
public class VerificationCodeViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "VerificationCodeViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<ResultUiState<Boolean>> _smsCodeUiState;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<Integer> _vCodeTimeDownFlow;
    /* access modifiers changed from: private */
    @NotNull
    public final LoginRepository loginRepository;
    @NotNull
    private StateFlow<? extends ResultUiState<Boolean>> smsCodeUiState;
    @NotNull
    private StateFlow<Integer> vCodeTimeDownFlow;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/honey/account/view/login/base/VerificationCodeViewModel$Companion;", "", "()V", "TAG", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public VerificationCodeViewModel(@NotNull LoginRepository loginRepository2) {
        Intrinsics.checkNotNullParameter(loginRepository2, "loginRepository");
        this.loginRepository = loginRepository2;
        MutableStateFlow<Integer> a2 = StateFlowKt.a(100);
        this._vCodeTimeDownFlow = a2;
        this.vCodeTimeDownFlow = FlowKt.c(a2);
        MutableStateFlow<ResultUiState<Boolean>> a3 = StateFlowKt.a(ResultUiState.Default.INSTANCE);
        this._smsCodeUiState = a3;
        this.smsCodeUiState = FlowKt.c(a3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String formatEmail(java.lang.String r7) {
        /*
            r6 = this;
            kotlin.text.Regex r6 = new kotlin.text.Regex
            java.lang.String r0 = "@"
            r6.<init>((java.lang.String) r0)
            r1 = 0
            java.util.List r6 = r6.split(r7, r1)
            boolean r2 = r6.isEmpty()
            r3 = 1
            if (r2 != 0) goto L_0x0038
            int r2 = r6.size()
            java.util.ListIterator r2 = r6.listIterator(r2)
        L_0x001b:
            boolean r4 = r2.hasPrevious()
            if (r4 == 0) goto L_0x0038
            java.lang.Object r4 = r2.previous()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x002e
            goto L_0x001b
        L_0x002e:
            int r2 = r2.nextIndex()
            int r2 = r2 + r3
            java.util.List r6 = kotlin.collections.CollectionsKt.take(r6, r2)
            goto L_0x003c
        L_0x0038:
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L_0x003c:
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.Object[] r6 = r6.toArray(r2)
            java.lang.String[] r6 = (java.lang.String[]) r6
            r6 = r6[r1]
            kotlin.text.Regex r2 = new kotlin.text.Regex
            r2.<init>((java.lang.String) r0)
            java.util.List r7 = r2.split(r7, r1)
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x007a
            int r0 = r7.size()
            java.util.ListIterator r0 = r7.listIterator(r0)
        L_0x005d:
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L_0x007a
            java.lang.Object r2 = r0.previous()
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0070
            goto L_0x005d
        L_0x0070:
            int r0 = r0.nextIndex()
            int r0 = r0 + r3
            java.util.List r7 = kotlin.collections.CollectionsKt.take(r7, r0)
            goto L_0x007e
        L_0x007a:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x007e:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r7 = r7.toArray(r0)
            java.lang.String[] r7 = (java.lang.String[]) r7
            r7 = r7[r3]
            int r0 = r6.length()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            java.lang.String r4 = ""
            r2.<init>(r4)
            char r4 = r6.charAt(r1)
            r2.append(r4)
            r4 = 4
            if (r0 < r4) goto L_0x00b0
            java.lang.String r1 = "****"
            r2.append(r1)
            int r1 = r0 + -3
        L_0x00a4:
            if (r1 >= r0) goto L_0x00c8
            char r3 = r6.charAt(r1)
            r2.append(r3)
            int r1 = r1 + 1
            goto L_0x00a4
        L_0x00b0:
            int r4 = 8 - r0
        L_0x00b2:
            if (r1 >= r4) goto L_0x00bc
            java.lang.String r5 = "*"
            r2.append(r5)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00bc:
            if (r3 >= r0) goto L_0x00c8
            char r1 = r6.charAt(r3)
            r2.append(r1)
            int r3 = r3 + 1
            goto L_0x00bc
        L_0x00c8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r0 = 64
            r6.append(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.login.base.VerificationCodeViewModel.formatEmail(java.lang.String):java.lang.String");
    }

    private final String formatPhone(String str) {
        if (StringsKt.isBlank(str)) {
            return "";
        }
        switch (str.length()) {
            case 6:
                return plusStart(str, 1, 1);
            case 7:
                return plusStart(str, 1, 2);
            case 8:
                return plusStart(str, 2, 2);
            case 9:
                return plusStart(str, 3, 2);
            case 10:
                return plusStart(str, 2, 4);
            case 11:
                return plusStart(str, 3, 4);
            default:
                return str.length() < 6 ? plusStart(str, 0, 1) : plusStart(str, 4, 4);
        }
    }

    private final String plusStart(String str, int i, int i2) {
        String str2 = "";
        for (int i3 = 0; i3 < (str.length() - i) - i2; i3++) {
            str2 = str2 + '*';
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        sb.append(str2);
        String substring2 = str.substring(str.length() - i2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        sb.append(substring2);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final VCodeMethod vCodeMethod(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null) ? VCodeMethod.LOGIN_EMAIL : VCodeMethod.LOGIN_PHONE;
    }

    /* access modifiers changed from: private */
    public final VCodeMode vCodeMode(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null) ? VCodeMode.EMAIL_CODE_VALIDATE : VCodeMode.PHONE_CODE_VALIDATE;
    }

    public final void downFlow() {
        this._vCodeTimeDownFlow.setValue(60);
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VerificationCodeViewModel$downFlow$1(this, (Continuation<? super VerificationCodeViewModel$downFlow$1>) null), 3, (Object) null);
    }

    @NotNull
    public final String formatAccount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "account");
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null) ? formatEmail(str) : formatPhone(str);
    }

    @NotNull
    public final StateFlow<ResultUiState<Boolean>> getSmsCodeUiState() {
        return this.smsCodeUiState;
    }

    public final void getVCode(@NotNull String str, @Nullable GeetestData geetestData) {
        Intrinsics.checkNotNullParameter(str, "account");
        downFlow();
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VerificationCodeViewModel$getVCode$1(this, str, geetestData, (Continuation<? super VerificationCodeViewModel$getVCode$1>) null), 3, (Object) null);
    }

    @NotNull
    public final StateFlow<Integer> getVCodeTimeDownFlow() {
        return this.vCodeTimeDownFlow;
    }

    public final void setSmsCodeUiState(@NotNull StateFlow<? extends ResultUiState<Boolean>> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.smsCodeUiState = stateFlow;
    }

    public final void setVCodeTimeDownFlow(@NotNull StateFlow<Integer> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.vCodeTimeDownFlow = stateFlow;
    }
}
