package com.upuphone.ar.tici.phone.utils;

import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0013\u0010\u0012R$\u0010\u0017\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/EventBus;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "event", "", "f", "(Ljava/lang/Object;)V", "h", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "g", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/Object;)V", "T", "Ljava/lang/Class;", "eventType", "e", "(Ljava/lang/Class;)Ljava/lang/Object;", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "stickyEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "d", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_eventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "eventFlow", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nEventBus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventBus.kt\ncom/upuphone/ar/tici/phone/utils/EventBus\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,90:1\n83#1,7:103\n36#2:91\n21#2:92\n23#2:96\n36#2:97\n21#2:98\n23#2:102\n21#2:110\n23#2:114\n50#3:93\n55#3:95\n50#3:99\n55#3:101\n50#3:111\n55#3:113\n106#4:94\n106#4:100\n106#4:112\n*S KotlinDebug\n*F\n+ 1 EventBus.kt\ncom/upuphone/ar/tici/phone/utils/EventBus\n*L\n69#1:103,7\n64#1:91\n64#1:92\n64#1:96\n68#1:97\n68#1:98\n68#1:102\n79#1:110\n79#1:114\n64#1:93\n64#1:95\n68#1:99\n68#1:101\n79#1:111\n79#1:113\n64#1:94\n68#1:100\n79#1:112\n*E\n"})
public final class EventBus implements CoroutineScope {
    public static final EventBus b = new EventBus();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final MutableSharedFlow d;
    public static final SharedFlow e;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f5982a = CoroutineScopeKt.b();

    static {
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        d = b2;
        e = FlowKt.b(b2);
    }

    public final Object e(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "eventType");
        return cls.cast(c.get(cls));
    }

    public final void f(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new EventBus$post$1(obj, (Continuation<? super EventBus$post$1>) null), 3, (Object) null);
    }

    public final void g(LifecycleOwner lifecycleOwner, Object obj) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(obj, "event");
        h(obj);
        lifecycleOwner.getLifecycle().a(new EventBus$postSticky$2());
    }

    public CoroutineContext getCoroutineContext() {
        return this.f5982a.getCoroutineContext();
    }

    public final void h(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new EventBus$postSticky$1(obj, (Continuation<? super EventBus$postSticky$1>) null), 3, (Object) null);
    }

    public final Object j(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "eventType");
        return cls.cast(c.remove(cls));
    }
}
