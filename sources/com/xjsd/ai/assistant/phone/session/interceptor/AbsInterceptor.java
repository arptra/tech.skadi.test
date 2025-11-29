package com.xjsd.ai.assistant.phone.session.interceptor;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.honey.account.la.a;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\bJ:\u0010\u0013\u001a\u00020\u0012*\u00020\f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0013\u0010\u0014JL\u0010\u0018\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u00028\u00000\u00162-\u0010\u0011\u001a)\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\f8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010%¨\u0006'"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/AbsInterceptor;", "", "Lcom/xjsd/ai/assistant/phone/session/Session;", "session", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;)V", "", "f", "()V", "h", "i", "g", "Landroidx/lifecycle/Lifecycle;", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/Job;", "j", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)V", "a", "Lcom/xjsd/ai/assistant/phone/session/Session;", "d", "()Lcom/xjsd/ai/assistant/phone/session/Session;", "Landroidx/lifecycle/Lifecycle;", "c", "()Landroidx/lifecycle/Lifecycle;", "setLifecycle", "(Landroidx/lifecycle/Lifecycle;)V", "lifecycle", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleObserver", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class AbsInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public final Session f8577a;
    public Lifecycle b;
    public final LifecycleEventObserver c;

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
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.AbsInterceptor.WhenMappings.<clinit>():void");
        }
    }

    public AbsInterceptor(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.f8577a = session;
        this.b = session.getLifecycle();
        a aVar = new a(this);
        this.c = aVar;
        this.b.a(aVar);
    }

    public static final void e(AbsInterceptor absInterceptor, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(absInterceptor, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            ILog.a(absInterceptor.getClass().getSimpleName(), "on create");
            absInterceptor.f();
        } else if (i == 2) {
            ILog.a(absInterceptor.getClass().getSimpleName(), "on resume");
            absInterceptor.h();
        } else if (i == 3) {
            ILog.a(absInterceptor.getClass().getSimpleName(), "on stop");
            absInterceptor.i();
        } else if (i == 4) {
            ILog.a(absInterceptor.getClass().getSimpleName(), "on destroy");
            absInterceptor.g();
        }
    }

    public final void b(Flow flow, Function3 function3) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(function3, "block");
        Job unused = BuildersKt__Builders_commonKt.d(SeesionExtensionsKt.a(this.f8577a), (CoroutineContext) null, (CoroutineStart) null, new AbsInterceptor$collectWhenResume$1(this, flow, function3, (Continuation<? super AbsInterceptor$collectWhenResume$1>) null), 3, (Object) null);
    }

    public final Lifecycle c() {
        return this.b;
    }

    public final Session d() {
        return this.f8577a;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public final Job j(Lifecycle lifecycle, Function2 function2) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        return BuildersKt__Builders_commonKt.d(SeesionExtensionsKt.a(this.f8577a), (CoroutineContext) null, (CoroutineStart) null, new AbsInterceptor$runWhenResume$1(lifecycle, function2, (Continuation<? super AbsInterceptor$runWhenResume$1>) null), 3, (Object) null);
    }
}
