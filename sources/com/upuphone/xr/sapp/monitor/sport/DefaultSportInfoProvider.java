package com.upuphone.xr.sapp.monitor.sport;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.XiaoMiFeatureParser;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/DefaultSportInfoProvider;", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfoProvider;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "c", "()V", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "e", "()Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "b", "Landroid/content/Context;", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "mSportInfo", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DefaultSportInfoProvider extends SportInfoProvider {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final Context b;
    public final SportInfo c = new SportInfo(0, 0.0d, 0, 0, 8, (DefaultConstructorMarker) null);
    public final CoroutineScope d = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/DefaultSportInfoProvider$Companion;", "", "()V", "TAG", "", "XIAOMI_STEPS", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public DefaultSportInfoProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
    }

    public void c() {
        Job unused = BuildersKt__Builders_commonKt.d(this.d, (CoroutineContext) null, (CoroutineStart) null, new DefaultSportInfoProvider$update$1(this, (Continuation<? super DefaultSportInfoProvider$update$1>) null), 3, (Object) null);
    }

    public final SportInfo e() {
        ULog.Delegate delegate = ULog.f6446a;
        String name = Thread.currentThread().getName();
        delegate.a("DefaultSportInfoProvider", "sendThirdStepMessage=Thread Name =" + name);
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        if (phoneTypeUtils.c()) {
            if (HuaWeiFeatureParser.b().g()) {
                this.c.setStepCount(HuaWeiFeatureParser.b().d(this.b));
                this.c.setErrorCode(0);
            } else {
                this.c.setErrorCode(3);
            }
        } else if (phoneTypeUtils.e()) {
            boolean b2 = XiaoMiFeatureParser.e().b("support_steps_provider", false);
            delegate.a("DefaultSportInfoProvider", "XiaoMiFeatureParser XIAOMI_STEPS = " + b2);
            if (b2) {
                int f = XiaoMiFeatureParser.e().f(GlobalExtKt.f());
                if (f != -1) {
                    delegate.a("DefaultSportInfoProvider", "XiaoMiFeatureParser xiaoMiSteps = " + f);
                    this.c.setStepCount(f);
                    this.c.setErrorCode(0);
                } else {
                    delegate.a("DefaultSportInfoProvider", "XiaoMiFeatureParser error = 4");
                    this.c.setErrorCode(4);
                }
            } else {
                delegate.a("DefaultSportInfoProvider", "XiaoMiFeatureParser error = 3");
                this.c.setErrorCode(3);
            }
        } else {
            delegate.a("DefaultSportInfoProvider", "XiaoMiFeatureParser error  other phone");
            this.c.setErrorCode(3);
        }
        return this.c;
    }
}
