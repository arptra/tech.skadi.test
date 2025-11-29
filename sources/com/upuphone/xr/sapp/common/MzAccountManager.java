package com.upuphone.xr.sapp.common;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.assistant.VoiceAssistantDelegate;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.OSHelper;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjmz.myvu.account.AccountManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001f\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/common/MzAccountManager;", "", "<init>", "()V", "", "info", "mzToken", "", "g", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "e", "()Ljava/lang/String;", "", "f", "()Z", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "a", "Landroidx/lifecycle/MutableLiveData;", "_accountInfoData", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "d", "()Landroidx/lifecycle/LiveData;", "accountInfoData", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMzAccountManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MzAccountManager.kt\ncom/upuphone/xr/sapp/common/MzAccountManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
public final class MzAccountManager {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final MzAccountManager d = new MzAccountManager();

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData f6660a;
    public final LiveData b;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.common.MzAccountManager$1", f = "MzAccountManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.common.MzAccountManager$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MzAccountManager this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.f6660a.postValue(MzAccountManager.c.a());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00148\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/common/MzAccountManager$Companion;", "", "<init>", "()V", "", "login", "", "e", "(Z)V", "d", "c", "()Z", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "a", "()Lcom/upuphone/xr/sapp/entity/AccountInfo;", "Lcom/upuphone/xr/sapp/common/MzAccountManager;", "instance", "Lcom/upuphone/xr/sapp/common/MzAccountManager;", "b", "()Lcom/upuphone/xr/sapp/common/MzAccountManager;", "", "ACCOUNT_LOGIN", "Ljava/lang/String;", "MZ_ACCOUNT", "MZ_AUTH_GRANT_ACTION", "", "REQUEST_CODE_ACCOUNT_AUTH", "I", "REQUEST_CODE_ACCOUNT_LOGIN", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccountInfo a() {
            String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "mz_account", "", (Context) null, 4, (Object) null);
            try {
                return (AccountInfo) new Gson().fromJson(str, AccountInfo.class);
            } catch (JsonSyntaxException unused) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("MzAccountManager", "parse account error  ... " + str);
                return null;
            }
        }

        public final MzAccountManager b() {
            return MzAccountManager.d;
        }

        public final boolean c() {
            return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "account_login_state", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        }

        public final void d() {
            String str;
            boolean c = c();
            AccountInfo a2 = a();
            if (a2 == null || (str = a2.getMzUid()) == null) {
                str = "";
            }
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("MzAccountManager", "login = " + c + ",mzUid = " + str);
            SuperMessageManger.m.a().b0(c, str);
        }

        public final void e(boolean z) {
            DataStoreUtils.e.a().o("account_login_state", Boolean.valueOf(z));
            SuperMessageManger.m.a().X(z);
        }

        public Companion() {
        }
    }

    public MzAccountManager() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f6660a = mutableLiveData;
        this.b = mutableLiveData;
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        ULog.f6446a.a("MzAccountManager", "init-> ");
    }

    public static /* synthetic */ void h(MzAccountManager mzAccountManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        mzAccountManager.g(str, str2);
    }

    public final void c() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o("account_login_state", Boolean.FALSE);
        companion.a().o("mz_account", "");
        this.f6660a.postValue(null);
    }

    public final LiveData d() {
        return this.b;
    }

    public final String e() {
        AccountInfo accountInfo = (AccountInfo) this.f6660a.getValue();
        if (accountInfo != null) {
            return accountInfo.getMzUid();
        }
        return null;
    }

    public final boolean f() {
        ULog.f6446a.g("MzAccountManager", "loginOut() called");
        if (OSHelper.f7904a.g()) {
            AccountManager.f8217a.o().logout();
            return true;
        }
        AccountManager.f8217a.o().logout();
        h(this, (String) null, (String) null, 3, (Object) null);
        return true;
    }

    public final void g(String str, String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "info");
        Intrinsics.checkNotNullParameter(str2, "mzToken");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m20constructorimpl((AccountInfo) JsonUtils.f7893a.a(str, AccountInfo.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        String str3 = null;
        if (Result.m26isFailureimpl(obj)) {
            obj = null;
        }
        AccountInfo accountInfo = (AccountInfo) obj;
        if (accountInfo != null) {
            accountInfo.setMzToken(str2);
        }
        if (accountInfo != null) {
            str3 = new Gson().toJson((Object) accountInfo);
        }
        if (str3 == null) {
            str3 = str;
        }
        DataStoreUtils.e.a().o("mz_account", str3);
        VoiceAssistantDelegate.f6640a.e(str);
        FastRecordManager.Companion.getInstance().syncAccountInfo(str);
        NaviManager.getInstance(MainApplication.k.f()).setAccountInfo(str);
        this.f6660a.postValue(accountInfo);
    }
}
