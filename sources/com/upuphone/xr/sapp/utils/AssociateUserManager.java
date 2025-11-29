package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AssociateUserManager;", "", "<init>", "()V", "", "e", "f", "g", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "", "b", "I", "retry", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssociateUserManager {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final Lazy d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AssociateUserManager$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f7844a = CoroutineScopeKt.a(Dispatchers.b());
    public int b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AssociateUserManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/AssociateUserManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/utils/AssociateUserManager;", "instance", "", "ASSOCIATE_USER_LOGOUT", "Ljava/lang/String;", "", "MAX_RETRY", "I", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AssociateUserManager a() {
            return (AssociateUserManager) AssociateUserManager.d.getValue();
        }

        public Companion() {
        }
    }

    public AssociateUserManager() {
        ULog.f6446a.a("AssociateUserManager", "AssociateUserManager init");
        MzAccountManager.c.b().d().observeForever(new AssociateUserManager$sam$androidx_lifecycle_Observer$0(new Function1<AccountInfo, Unit>(this) {
            final /* synthetic */ AssociateUserManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AccountInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable AccountInfo accountInfo) {
                ULog.Delegate delegate = ULog.f6446a;
                String id = accountInfo != null ? accountInfo.getId() : null;
                delegate.a("AssociateUserManager", "user account change:" + id);
                this.this$0.g();
            }
        }));
    }

    public final void e() {
        MzAccountManager.Companion companion = MzAccountManager.c;
        AccountInfo a2 = companion.a();
        DataStoreUtils.Companion companion2 = DataStoreUtils.e;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(companion2.a(), "associate_user_logout", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AssociateUserManager", "checkCacheState " + booleanValue + " userId" + a2);
        if (a2 == null || booleanValue) {
            delegate.c("AssociateUserManager", "setStartDiscoveryState isHaveLogin true");
            StarryNetHelper starryNetHelper = StarryNetHelper.f7917a;
            StarryNetHelper.StartDiscoveryCondition e = starryNetHelper.e();
            e.c(true);
            starryNetHelper.i(e);
        } else {
            companion.b().f();
            companion2.a().o("associate_user_logout", Boolean.TRUE);
        }
        companion2.a().o("associate_user_logout", Boolean.TRUE);
    }

    public final void f() {
        Job unused = BuildersKt__Builders_commonKt.d(this.f7844a, (CoroutineContext) null, (CoroutineStart) null, new AssociateUserManager$syncAssociateUserData$1(this, (Continuation<? super AssociateUserManager$syncAssociateUserData$1>) null), 3, (Object) null);
    }

    public final void g() {
        SuperNotificationManager.f7749a.G();
        AppConfigHelper.d.a().f();
    }
}
