package com.xjmz.myvu.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.honey.account.o9.a;
import com.honey.account.o9.b;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.xr.account.XJAuthenticator;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.utils.AccountExt;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.xjmz.myvu.MYVUActivity;
import flyme.support.v7.app.AlertDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H@¢\u0006\u0004\b\t\u0010\nJ,\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H@¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0004H@¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H@¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001bJ\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0003J,\u0010\"\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H@¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J\u0012\u0010*\u001a\u0004\u0018\u00010)H@¢\u0006\u0004\b*\u0010\u0019J/\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u0010\u0003R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010=\u001a\u0002088FX\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8FX\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8FX\u0002¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/xjmz/myvu/account/AccountManager;", "", "<init>", "()V", "", "forceMzTokenInvalidate", "Lkotlin/Function1;", "", "callback", "u", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/Fragment;", "fragment", "i", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "resultCode", "q", "(I)V", "forceInvalidate", "Lcom/xjmz/myvu/account/MzTokenResult;", "l", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjmz/myvu/account/GetUserInfoResult;", "m", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "()Z", "Landroidx/fragment/app/FragmentActivity;", "rootActivity", "y", "(Landroidx/fragment/app/FragmentActivity;)V", "r", "x", "p", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "userInfo", "mzToken", "v", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/xjmz/myvu/account/UserInfoData;", "n", "Landroid/content/Context;", "app", "g", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "B", "(Landroid/content/Context;)V", "code", "s", "(Ljava/lang/Integer;)Z", "f", "b", "Z", "inLoginProcess", "Lcom/google/gson/Gson;", "c", "Lkotlin/Lazy;", "j", "()Lcom/google/gson/Gson;", "gson", "Lcom/upuphone/star/httplib/HttpInstance;", "d", "k", "()Lcom/upuphone/star/httplib/HttpInstance;", "http", "Lcom/upuphone/xr/account/XJAuthenticator;", "e", "o", "()Lcom/upuphone/xr/account/XJAuthenticator;", "xjAuthenticator", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAccountManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountManager.kt\ncom/xjmz/myvu/account/AccountManager\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,491:1\n314#2,11:492\n208#3:503\n*S KotlinDebug\n*F\n+ 1 AccountManager.kt\ncom/xjmz/myvu/account/AccountManager\n*L\n309#1:492,11\n383#1:503\n*E\n"})
public final class AccountManager {

    /* renamed from: a  reason: collision with root package name */
    public static final AccountManager f8217a = new AccountManager();
    public static boolean b;
    public static final Lazy c = LazyKt.lazy(AccountManager$gson$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(AccountManager$http$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(AccountManager$xjAuthenticator$2.INSTANCE);

    public static final void A(DialogInterface dialogInterface, int i) {
    }

    public static /* synthetic */ void h(AccountManager accountManager, Context context, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        accountManager.g(context, function1);
    }

    public static /* synthetic */ void w(AccountManager accountManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        accountManager.v(str, str2);
    }

    public static final void z(FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$rootActivity");
        f8217a.B(fragmentActivity);
    }

    public final void B(Context context) {
        Intent skipPasswordPageIntent = o().skipPasswordPageIntent();
        skipPasswordPageIntent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(skipPasswordPageIntent);
    }

    public final void f() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean c2 = MzAccountManager.c.c();
        delegate.g("AccountManager", "checkHadSetPassword-> 开始检测是否设置过密码 isAccountLogin()：" + c2);
        AccountExt.f7838a.d(AccountManager$checkHasSetPassword$1.INSTANCE);
    }

    public final void g(Context context, Function1 function1) {
        o().isSetPassword(new AccountManager$checkPasswordSeted$1(context, function1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(androidx.fragment.app.Fragment r13, kotlin.jvm.functions.Function1 r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.xjmz.myvu.account.AccountManager$doLogin$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.xjmz.myvu.account.AccountManager$doLogin$1 r0 = (com.xjmz.myvu.account.AccountManager$doLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.account.AccountManager$doLogin$1 r0 = new com.xjmz.myvu.account.AccountManager$doLogin$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            java.lang.String r6 = "AccountManager"
            if (r2 == 0) goto L_0x004e
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.account.AccountManager r12 = (com.xjmz.myvu.account.AccountManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0149
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            java.lang.Object r12 = r0.L$2
            r14 = r12
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            java.lang.Object r12 = r0.L$1
            r13 = r12
            androidx.fragment.app.Fragment r13 = (androidx.fragment.app.Fragment) r13
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.account.AccountManager r12 = (com.xjmz.myvu.account.AccountManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00a2
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            com.upuphone.xr.sapp.config.NetConfig$Companion r2 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r7 = r2.p()
            java.lang.String r8 = r2.f()
            java.lang.String r9 = r2.g()
            java.lang.String r2 = r2.d()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "doLogin-> url: "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r7 = ", appkey: "
            r10.append(r7)
            r10.append(r8)
            java.lang.String r7 = ", secret: "
            r10.append(r7)
            r10.append(r9)
            java.lang.String r7 = ", appid: "
            r10.append(r7)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            r15.g(r6, r2)
            b = r5
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r5
            java.lang.Object r15 = r12.l(r5, r0)
            if (r15 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            com.xjmz.myvu.account.MzTokenResult r15 = (com.xjmz.myvu.account.MzTokenResult) r15
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "doLogin-> mzToken: "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r2.g(r6, r7)
            int r7 = r15.c()
            if (r7 == 0) goto L_0x00fd
            if (r7 == r5) goto L_0x00e6
            if (r7 == r4) goto L_0x00c6
            goto L_0x0149
        L_0x00c6:
            com.xjmz.myvu.account.MzTokenResult$OriginError r12 = r15.b()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "doLogin() 获取mztoken失败. "
            r13.append(r15)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r2.g(r6, r12)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r14.invoke(r12)
            goto L_0x0149
        L_0x00e6:
            java.lang.String r13 = "doLogin() 有mztoken, 直接获取"
            r2.g(r6, r13)
            r0.L$0 = r12
            r13 = 0
            r0.L$1 = r13
            r0.L$2 = r13
            r0.label = r4
            r13 = 200(0xc8, float:2.8E-43)
            java.lang.Object r12 = r12.p(r13, r14, r0)
            if (r12 != r1) goto L_0x0149
            return r1
        L_0x00fd:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "doLogin() 没有mztoken, 跳转到mz登陆. fragment: "
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r2.g(r6, r12)
            android.content.Intent r12 = r15.a()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "doLogin() intent: "
            r14.append(r0)
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r2.g(r6, r12)
            android.content.Intent r12 = r15.a()
            if (r12 == 0) goto L_0x0147
            java.lang.String r14 = "com.meizu.account.action.auth_grant"
            java.lang.String r15 = r12.getAction()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 == 0) goto L_0x0141
            r14 = 10001(0x2711, float:1.4014E-41)
            r13.startActivityForResult(r12, r14)
            goto L_0x0149
        L_0x0141:
            r14 = 10000(0x2710, float:1.4013E-41)
            r13.startActivityForResult(r12, r14)
            goto L_0x0149
        L_0x0147:
            com.xjmz.myvu.account.AccountManager$doLogin$3 r12 = com.xjmz.myvu.account.AccountManager$doLogin$3.INSTANCE
        L_0x0149:
            b = r3
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.AccountManager.i(androidx.fragment.app.Fragment, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Gson j() {
        return (Gson) c.getValue();
    }

    public final HttpInstance k() {
        return (HttpInstance) d.getValue();
    }

    public final Object l(boolean z, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        f8217a.o().getMzAuthToken(Boxing.boxBoolean(z), new AccountManager$getMzToken$2$1(cancellableContinuationImpl, z));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(kotlin.coroutines.Continuation r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.xjmz.myvu.account.AccountManager$getUserInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.xjmz.myvu.account.AccountManager$getUserInfo$1 r0 = (com.xjmz.myvu.account.AccountManager$getUserInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.account.AccountManager$getUserInfo$1 r0 = new com.xjmz.myvu.account.AccountManager$getUserInfo$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r13 = r0.L$0
            com.xjmz.myvu.account.AccountManager r13 = (com.xjmz.myvu.account.AccountManager) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r14)
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r14 = r13.n(r0)
            if (r14 != r1) goto L_0x0043
            return r1
        L_0x0043:
            com.xjmz.myvu.account.UserInfoData r14 = (com.xjmz.myvu.account.UserInfoData) r14
            if (r14 == 0) goto L_0x005a
            com.xjmz.myvu.account.GetUserInfoResult r6 = new com.xjmz.myvu.account.GetUserInfoResult
            com.google.gson.Gson r13 = r13.j()
            java.lang.String r2 = r13.toJson((java.lang.Object) r14)
            r4 = 4
            r5 = 0
            r1 = 1
            r3 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x006d
        L_0x005a:
            com.xjmz.myvu.account.GetUserInfoResult r6 = new com.xjmz.myvu.account.GetUserInfoResult
            com.xjmz.myvu.account.GetUserInfoResult$ResultError r10 = new com.xjmz.myvu.account.GetUserInfoResult$ResultError
            r13 = -2
            java.lang.String r14 = "数据异常"
            r10.<init>(r13, r14)
            r11 = 2
            r12 = 0
            r8 = 2
            r9 = 0
            r7 = r6
            r7.<init>(r8, r9, r10, r11, r12)
        L_0x006d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.AccountManager.m(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c1 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c6 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00db A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dc A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(kotlin.coroutines.Continuation r18) {
        /*
            r17 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.xjmz.myvu.account.AccountManager$getUserProfile$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.xjmz.myvu.account.AccountManager$getUserProfile$1 r1 = (com.xjmz.myvu.account.AccountManager$getUserProfile$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.xjmz.myvu.account.AccountManager$getUserProfile$1 r1 = new com.xjmz.myvu.account.AccountManager$getUserProfile$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            java.lang.String r6 = "AccountManager"
            r7 = 0
            if (r4 == 0) goto L_0x003d
            if (r4 != r5) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0091
        L_0x0032:
            r0 = move-exception
            goto L_0x0119
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r0)
            com.upuphone.xr.sapp.config.NetConfig$Companion r0 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r4 = "sMyvuAuth"
            java.lang.String r0 = r0.v(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = "/"
            r4.append(r0)
            java.lang.String r0 = "api/v2/oauth/user/profile"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder
            r4.<init>()
            okhttp3.Request$Builder r0 = r4.url((java.lang.String) r0)
            okhttp3.Request$Builder r0 = r0.get()
            okhttp3.Request r0 = r0.build()
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0032 }
            java.lang.String r8 = "getUserProfile"
            r4.g(r6, r8)     // Catch:{ Exception -> 0x0032 }
            com.upuphone.star.httplib.HttpInstance r2 = r17.k()     // Catch:{ Exception -> 0x0032 }
            com.xjmz.myvu.account.AccountManager$getUserProfile$$inlined$request$1 r4 = new com.xjmz.myvu.account.AccountManager$getUserProfile$$inlined$request$1     // Catch:{ Exception -> 0x0032 }
            r4.<init>()     // Catch:{ Exception -> 0x0032 }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r8 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)     // Catch:{ Exception -> 0x0032 }
            r1.label = r5     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r0 = r2.h(r0, r4, r1)     // Catch:{ Exception -> 0x0032 }
            if (r0 != r3) goto L_0x0091
            return r3
        L_0x0091:
            com.upuphone.star.httplib.HttpResult r0 = (com.upuphone.star.httplib.HttpResult) r0     // Catch:{ Exception -> 0x0032 }
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r2 = r0.b()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r3 = com.xjsd.xr.sapp.asr.utils.GsonHelper.toJson(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r4.<init>()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r5 = "getUserProfile-> "
            r4.append(r5)     // Catch:{ Exception -> 0x0032 }
            r4.append(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = " response:"
            r4.append(r2)     // Catch:{ Exception -> 0x0032 }
            r4.append(r3)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0032 }
            r1.g(r6, r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r1 = r0.b()     // Catch:{ Exception -> 0x0032 }
            com.xjmz.myvu.account.GetUserProfileResponse r1 = (com.xjmz.myvu.account.GetUserProfileResponse) r1     // Catch:{ Exception -> 0x0032 }
            if (r1 == 0) goto L_0x00c6
            com.xjmz.myvu.account.UserProfileData r1 = r1.getData()     // Catch:{ Exception -> 0x0032 }
            goto L_0x00c7
        L_0x00c6:
            r1 = r7
        L_0x00c7:
            boolean r2 = r0.e()     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x0118
            java.lang.Object r0 = r0.b()     // Catch:{ Exception -> 0x0032 }
            com.xjmz.myvu.account.GetUserProfileResponse r0 = (com.xjmz.myvu.account.GetUserProfileResponse) r0     // Catch:{ Exception -> 0x0032 }
            if (r0 == 0) goto L_0x0118
            java.lang.Integer r0 = r0.getStatus()     // Catch:{ Exception -> 0x0032 }
            if (r0 != 0) goto L_0x00dc
            goto L_0x0118
        L_0x00dc:
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0032 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x0118
            if (r1 == 0) goto L_0x0118
            com.xjmz.myvu.account.UserInfoData r0 = new com.xjmz.myvu.account.UserInfoData     // Catch:{ Exception -> 0x0032 }
            java.lang.String r9 = r1.getUid()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r10 = r1.getSocialSuid()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r11 = r1.getNick()     // Catch:{ Exception -> 0x0032 }
            if (r11 == 0) goto L_0x0105
            java.lang.String r12 = "用户"
            java.lang.String r13 = "User"
            r15 = 4
            r16 = 0
            r14 = 0
            java.lang.String r2 = kotlin.text.StringsKt.replaceFirst$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)     // Catch:{ Exception -> 0x0032 }
            r11 = r2
            goto L_0x0106
        L_0x0105:
            r11 = r7
        L_0x0106:
            java.lang.String r12 = r1.getPhone()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r13 = r1.getLogo()     // Catch:{ Exception -> 0x0032 }
            r15 = 32
            r16 = 0
            r14 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0032 }
            return r0
        L_0x0118:
            return r7
        L_0x0119:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getUserInfo-> "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.g(r6, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.AccountManager.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final XJAuthenticator o() {
        return (XJAuthenticator) e.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c8, code lost:
        if (r1.booleanValue() != false) goto L_0x01ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(int r18, kotlin.jvm.functions.Function1 r19, kotlin.coroutines.Continuation r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.xjmz.myvu.account.AccountManager$handleMzLoginResult$2
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.xjmz.myvu.account.AccountManager$handleMzLoginResult$2 r3 = (com.xjmz.myvu.account.AccountManager$handleMzLoginResult$2) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.xjmz.myvu.account.AccountManager$handleMzLoginResult$2 r3 = new com.xjmz.myvu.account.AccountManager$handleMzLoginResult$2
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 0
            r8 = 2
            r9 = 1
            java.lang.String r10 = "AccountManager"
            if (r5 == 0) goto L_0x0070
            if (r5 == r9) goto L_0x0058
            if (r5 != r8) goto L_0x0050
            int r0 = r3.I$0
            java.lang.Object r1 = r3.L$3
            com.xjmz.myvu.account.MzTokenResult r1 = (com.xjmz.myvu.account.MzTokenResult) r1
            java.lang.Object r4 = r3.L$2
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r5 = r3.L$1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r3 = r3.L$0
            com.xjmz.myvu.account.AccountManager r3 = (com.xjmz.myvu.account.AccountManager) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r3
            r3 = r2
            r2 = r16
            goto L_0x010f
        L_0x0050:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0058:
            int r0 = r3.I$0
            java.lang.Object r1 = r3.L$2
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r5 = r3.L$1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r11 = r3.L$0
            com.xjmz.myvu.account.AccountManager r11 = (com.xjmz.myvu.account.AccountManager) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r11
            r11 = r16
            goto L_0x00b4
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r2)
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r11 = "dealAuthActivityResult, resultCode: "
            r5.append(r11)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r2.g(r10, r5)
            b = r9
            if (r1 == 0) goto L_0x008f
            r1 = r9
            goto L_0x0090
        L_0x008f:
            r1 = r7
        L_0x0090:
            kotlin.jvm.internal.Ref$BooleanRef r5 = new kotlin.jvm.internal.Ref$BooleanRef
            r5.<init>()
            if (r1 == 0) goto L_0x0187
            java.lang.String r11 = "handleMzLoginResult-> mz activity返回成功"
            r2.g(r10, r11)
            r3.L$0 = r0
            r11 = r19
            r3.L$1 = r11
            r3.L$2 = r5
            r3.I$0 = r1
            r3.label = r9
            java.lang.Object r2 = r0.l(r9, r3)
            if (r2 != r4) goto L_0x00af
            return r4
        L_0x00af:
            r16 = r11
            r11 = r5
            r5 = r16
        L_0x00b4:
            com.xjmz.myvu.account.MzTokenResult r2 = (com.xjmz.myvu.account.MzTokenResult) r2
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "handleMzLoginResult() 登陆完重新获取: mzToken: "
            r13.append(r14)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            r12.g(r10, r13)
            int r13 = r2.c()
            if (r13 != r9) goto L_0x016e
            java.lang.String r13 = r2.d()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "handleMzLoginResult() mzToken: "
            r14.append(r15)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r12.g(r10, r13)
            java.lang.String r13 = r2.d()
            if (r13 == 0) goto L_0x0168
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            if (r13 == 0) goto L_0x00f8
            goto L_0x0168
        L_0x00f8:
            r0.f()
            r3.L$0 = r0
            r3.L$1 = r5
            r3.L$2 = r11
            r3.L$3 = r2
            r3.I$0 = r1
            r3.label = r8
            java.lang.Object r3 = r0.m(r3)
            if (r3 != r4) goto L_0x010e
            return r4
        L_0x010e:
            r4 = r11
        L_0x010f:
            com.xjmz.myvu.account.GetUserInfoResult r3 = (com.xjmz.myvu.account.GetUserInfoResult) r3
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "handleMzLoginResult(): "
            r12.append(r13)
            r12.append(r3)
            java.lang.String r12 = r12.toString()
            r11.g(r10, r12)
            int r12 = r3.a()
            if (r12 == r9) goto L_0x0148
            if (r12 == r8) goto L_0x0130
            goto L_0x0190
        L_0x0130:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = "handleMzLoginResult-> 获取userinfo失败. "
            r2.append(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r11.g(r10, r2)
            r0.x()
            goto L_0x0190
        L_0x0148:
            java.lang.String r3 = r3.b()
            if (r3 == 0) goto L_0x015c
            com.xjmz.myvu.account.AccountManager r12 = f8217a
            java.lang.String r2 = r2.d()
            r12.v(r3, r2)
            r4.element = r9
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x015d
        L_0x015c:
            r2 = r6
        L_0x015d:
            if (r2 != 0) goto L_0x0190
            java.lang.String r2 = "handleMzLoginResult-> userjson为空"
            r11.g(r10, r2)
            r0.x()
            goto L_0x0190
        L_0x0168:
            java.lang.String r2 = "handleMzLoginResult-> 错误, mztoken为空"
            r12.g(r10, r2)
            goto L_0x0185
        L_0x016e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "handleMzLoginResult() 登陆完重新获取mztoken失败, "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r12.g(r10, r2)
            r0.x()
        L_0x0185:
            r4 = r11
            goto L_0x0190
        L_0x0187:
            r11 = r19
            java.lang.String r3 = "handleMzLoginResult-> mz activity返回失败"
            r2.g(r10, r3)
            r4 = r5
            r5 = r11
        L_0x0190:
            boolean r2 = r4.element
            if (r2 != 0) goto L_0x01d6
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            if (r1 == 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r9 = r7
        L_0x019a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "handleMzLoginResult-> mzActivityLoginSuccess: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = ", loginSuccess:"
            r11.append(r9)
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            r3.g(r10, r2)
            java.lang.String r2 = ""
            w(r0, r2, r6, r8, r6)
            if (r1 != 0) goto L_0x01ca
            java.lang.Boolean r1 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r2 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01d6
        L_0x01ca:
            java.lang.String r1 = "handleMzLoginResult-> 触发logout"
            r3.g(r10, r1)
            com.upuphone.xr.account.XJAuthenticator r0 = r0.o()
            r0.logout()
        L_0x01d6:
            b = r7
            boolean r0 = r4.element
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r5.invoke(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.AccountManager.p(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void q(int i) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new AccountManager$handleMzLoginResult$1(i, (Continuation<? super AccountManager$handleMzLoginResult$1>) null), 3, (Object) null);
    }

    public final boolean r() {
        return b;
    }

    public final boolean s(Integer num) {
        return (num != null && num.intValue() == 10011) || (num != null && num.intValue() == 10015) || (num != null && num.intValue() == 10014);
    }

    public final boolean t() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            Boolean bool2 = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool2, "THIRD_PLATFOM");
            if (!bool2.booleanValue()) {
                return false;
            }
        }
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "has_set_password", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        MzAccountManager.Companion companion = MzAccountManager.c;
        boolean c2 = companion.c();
        delegate.g("AccountManager", "needSetPassword-> 是否需要设置密码 hasSetPassWord：" + booleanValue + " isAccountLogin() = " + c2);
        return companion.c() && !booleanValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0148, code lost:
        if (r10 == null) goto L_0x014a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(boolean r18, kotlin.jvm.functions.Function1 r19, kotlin.coroutines.Continuation r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.xjmz.myvu.account.AccountManager$refreshLoginState$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.xjmz.myvu.account.AccountManager$refreshLoginState$1 r3 = (com.xjmz.myvu.account.AccountManager$refreshLoginState$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.xjmz.myvu.account.AccountManager$refreshLoginState$1 r3 = new com.xjmz.myvu.account.AccountManager$refreshLoginState$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            java.lang.String r6 = ""
            r8 = 2
            r9 = 1
            r10 = 0
            java.lang.String r11 = "AccountManager"
            if (r5 == 0) goto L_0x0061
            if (r5 == r9) goto L_0x004c
            if (r5 != r8) goto L_0x0044
            java.lang.Object r0 = r3.L$2
            com.xjmz.myvu.account.MzTokenResult r0 = (com.xjmz.myvu.account.MzTokenResult) r0
            java.lang.Object r1 = r3.L$1
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r3 = r3.L$0
            com.xjmz.myvu.account.AccountManager r3 = (com.xjmz.myvu.account.AccountManager) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0195
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$1
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r5 = r3.L$0
            com.xjmz.myvu.account.AccountManager r5 = (com.xjmz.myvu.account.AccountManager) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r5
            r5 = r2
            r2 = r16
            goto L_0x00d1
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r2)
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            com.upuphone.xr.sapp.config.NetConfig$Companion r5 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r12 = r5.p()
            java.lang.String r13 = r5.f()
            java.lang.String r14 = r5.g()
            java.lang.String r5 = r5.d()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r7 = "refreshLoginState-> url: "
            r15.append(r7)
            r15.append(r12)
            java.lang.String r7 = ", appkey: "
            r15.append(r7)
            r15.append(r13)
            java.lang.String r7 = ", secret: "
            r15.append(r7)
            r15.append(r14)
            java.lang.String r7 = ", appid: "
            r15.append(r7)
            r15.append(r5)
            java.lang.String r5 = r15.toString()
            r2.g(r11, r5)
            com.upuphone.xr.sapp.utils.NetworkUtils r5 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r5 = r5.g()
            if (r5 != 0) goto L_0x00b4
            java.lang.String r0 = "refreshLoginState-> 网路不可用, 不做处理"
            r2.g(r11, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b4:
            boolean r5 = b
            if (r5 == 0) goto L_0x00c0
            java.lang.String r0 = "refreshLoginState-> 正在登录中, 不要刷登录状态, 在登录结果中处理"
            r2.g(r11, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00c0:
            r3.L$0 = r0
            r2 = r19
            r3.L$1 = r2
            r3.Z$0 = r1
            r3.label = r9
            java.lang.Object r5 = r0.l(r1, r3)
            if (r5 != r4) goto L_0x00d1
            return r4
        L_0x00d1:
            com.xjmz.myvu.account.MzTokenResult r5 = (com.xjmz.myvu.account.MzTokenResult) r5
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "refreshLoginState-> "
            r12.append(r13)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            r7.g(r11, r12)
            int r12 = r5.c()
            if (r12 == 0) goto L_0x0218
            if (r12 == r9) goto L_0x014e
            if (r12 == r8) goto L_0x00f5
            goto L_0x022a
        L_0x00f5:
            com.xjmz.myvu.account.MzTokenResult$OriginError r1 = r5.b()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "refreshLoginState() 失败: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r7.g(r11, r1)
            com.xjmz.myvu.account.MzTokenResult$OriginError r1 = r5.b()
            if (r1 == 0) goto L_0x014a
            int r1 = r1.a()
            com.xjmz.myvu.account.AccountManager r3 = f8217a
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            boolean r1 = r3.s(r1)
            if (r1 == 0) goto L_0x0134
            java.lang.String r1 = "refreshLoginState-> mztoken失败忽略情况"
            r7.g(r11, r1)
            if (r2 == 0) goto L_0x0148
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            r2.invoke(r1)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0148
        L_0x0134:
            java.lang.String r1 = "refreshLoginState-> mztoken失败清理数据"
            r7.g(r11, r1)
            w(r3, r6, r10, r8, r10)
            if (r2 == 0) goto L_0x0148
            r1 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r2.invoke(r1)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x0148:
            if (r10 != 0) goto L_0x022a
        L_0x014a:
            com.xjmz.myvu.account.AccountManager$refreshLoginState$5 r1 = com.xjmz.myvu.account.AccountManager$refreshLoginState$5.INSTANCE
            goto L_0x022a
        L_0x014e:
            java.lang.String r12 = "refreshLoginState-> 登陆成功的, mz token有效"
            r7.g(r11, r12)
            com.upuphone.xr.sapp.common.MzAccountManager$Companion r12 = com.upuphone.xr.sapp.common.MzAccountManager.c
            com.upuphone.xr.sapp.entity.AccountInfo r12 = r12.a()
            if (r12 == 0) goto L_0x0171
            if (r1 != 0) goto L_0x0171
            java.lang.String r1 = "refreshLoginState-> 非首次进入，accountinfo存在, 不再重新获取"
            r7.g(r11, r1)
            if (r2 == 0) goto L_0x016b
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            r2.invoke(r1)
        L_0x016b:
            r0.f()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0171:
            java.lang.String r1 = r5.d()
            if (r1 == 0) goto L_0x0206
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x017f
            goto L_0x0206
        L_0x017f:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.L$2 = r5
            r3.label = r8
            java.lang.Object r1 = r0.m(r3)
            if (r1 != r4) goto L_0x018e
            return r4
        L_0x018e:
            r3 = r0
            r0 = r5
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x0195:
            com.xjmz.myvu.account.GetUserInfoResult r2 = (com.xjmz.myvu.account.GetUserInfoResult) r2
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "refreshLoginState-> userinfo: "
            r5.append(r7)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r4.g(r11, r5)
            int r5 = r2.a()
            if (r5 == r9) goto L_0x01d4
            if (r5 == r8) goto L_0x01b6
            goto L_0x0204
        L_0x01b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "refreshLoginState-> 获取userinfo失败, 忽略. userInfoResult: "
            r0.append(r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r4.g(r11, r0)
            if (r1 == 0) goto L_0x0204
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            r1.invoke(r0)
            goto L_0x0204
        L_0x01d4:
            java.lang.String r2 = r2.b()
            if (r2 == 0) goto L_0x01ef
            com.xjmz.myvu.account.AccountManager r5 = f8217a
            java.lang.String r0 = r0.d()
            r5.v(r2, r0)
            if (r1 == 0) goto L_0x01ef
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            r1.invoke(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x01f0
        L_0x01ef:
            r0 = r10
        L_0x01f0:
            if (r0 != 0) goto L_0x0204
            java.lang.String r0 = "refreshLoginState-> userjson为空"
            r4.g(r11, r0)
            if (r1 == 0) goto L_0x0201
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r1.invoke(r0)
        L_0x0201:
            w(r3, r6, r10, r8, r10)
        L_0x0204:
            r0 = r3
            goto L_0x022a
        L_0x0206:
            java.lang.String r0 = "refreshLoginState-> 失败, mztoken为空"
            r7.g(r11, r0)
            if (r2 == 0) goto L_0x0215
            r1 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r2.invoke(r0)
        L_0x0215:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0218:
            r1 = 0
            java.lang.String r3 = "refreshLoginState-> 需要重新登陆"
            r7.g(r11, r3)
            w(r0, r6, r10, r8, r10)
            if (r2 == 0) goto L_0x022a
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r2.invoke(r1)
        L_0x022a:
            r0.f()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.AccountManager.u(boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void v(String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("AccountManager", "saveAccountState() called with: userInfo = " + str);
        if (StringsKt.isBlank(str)) {
            delegate.g("AccountManager", "saveAccountState-> 清空数据");
            MzAccountManager.c.e(false);
        } else {
            delegate.g("AccountManager", "saveAccountState-> 登陆成功");
            MzAccountManager.c.e(true);
        }
        MzAccountManager.Companion companion = MzAccountManager.c;
        companion.b().g(str, str2);
        companion.d();
    }

    public final void x() {
        MYVUActivity r = MainApplication.k.f().r();
        if (r != null) {
            UToast.Companion companion = UToast.f6444a;
            Context f = GlobalExtKt.f();
            String string = r.getString(R.string.account_login_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.e(f, string, 1);
        }
    }

    public final void y(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
        new AlertDialog.Builder(fragmentActivity).setMessage((CharSequence) fragmentActivity.getString(R.string.myvu_set_password_tips)).setTitle((CharSequence) fragmentActivity.getString(R.string.myvu_set_password)).setPositiveButton((CharSequence) fragmentActivity.getString(R.string.go_to_set), (DialogInterface.OnClickListener) new a(fragmentActivity)).setNegativeButton((CharSequence) fragmentActivity.getString(R.string.cancel), (DialogInterface.OnClickListener) new b()).show();
    }
}
