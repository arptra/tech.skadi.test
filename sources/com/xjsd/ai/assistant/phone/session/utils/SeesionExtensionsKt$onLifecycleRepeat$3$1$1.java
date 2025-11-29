package com.xjsd.ai.assistant.phone.session.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.xjsd.ai.assistant.log.ILog;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SeesionExtensionsKt$onLifecycleRepeat$3$1$1 implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f8603a;
    public final /* synthetic */ Lifecycle b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ CoroutineScope d;
    public final /* synthetic */ Lifecycle.Event e;
    public final /* synthetic */ Mutex f;
    public final /* synthetic */ Function2 g;
    public final /* synthetic */ CancellableContinuation h;

    @SourceDebugExtension({"SMAP\nSeesionExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeesionExtensions.kt\ncom/xjsd/ai/assistant/phone/session/utils/SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,135:1\n120#2,10:136\n*S KotlinDebug\n*F\n+ 1 SeesionExtensions.kt\ncom/xjsd/ai/assistant/phone/session/utils/SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1\n*L\n50#1:136,10\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1", f = "SeesionExtensions.kt", i = {0, 1}, l = {141, 51}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    /* renamed from: com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(mutex, function2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Throwable th;
            Mutex mutex;
            Mutex mutex2;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex2 = mutex;
                function2 = function2;
                this.L$0 = mutex2;
                this.L$1 = function2;
                this.label = 1;
                if (mutex2.c((Object) null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                function2 = (Function2) this.L$1;
                ResultKt.throwOnFailure(obj);
                mutex2 = (Mutex) this.L$0;
            } else if (i == 2) {
                mutex = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex.d((Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1$1$1 seesionExtensionsKt$onLifecycleRepeat$3$1$1$1$1$1 = new SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1$1$1(function2, (Continuation<? super SeesionExtensionsKt$onLifecycleRepeat$3$1$1$1$1$1>) null);
                this.L$0 = mutex2;
                this.L$1 = null;
                this.label = 2;
                if (CoroutineScopeKt.f(seesionExtensionsKt$onLifecycleRepeat$3$1$1$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                Unit unit2 = Unit.INSTANCE;
                mutex.d((Object) null);
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                Mutex mutex3 = mutex2;
                th = th3;
                mutex = mutex3;
                mutex.d((Object) null);
                throw th;
            }
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SeesionExtensionsKt$onLifecycleRepeat$3$1$1(Lifecycle.Event event, Lifecycle lifecycle, Ref.ObjectRef objectRef, CoroutineScope coroutineScope, Lifecycle.Event event2, Mutex mutex, Function2 function2, CancellableContinuation cancellableContinuation) {
        this.f8603a = event;
        this.b = lifecycle;
        this.c = objectRef;
        this.d = coroutineScope;
        this.e = event2;
        this.f = mutex;
        this.g = function2;
        this.h = cancellableContinuation;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == this.f8603a) {
            Lifecycle lifecycle = this.b;
            ILog.a("LifecycleRepeat", "restart work, lifecycle instance: " + lifecycle);
            Ref.ObjectRef objectRef = this.c;
            CoroutineScope coroutineScope = this.d;
            final Mutex mutex = this.f;
            final Function2 function2 = this.g;
            objectRef.element = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        if (event == this.e) {
            Lifecycle lifecycle2 = this.b;
            ILog.a("LifecycleRepeat", "cancel work, lifecycle instance: " + lifecycle2);
            Job job = (Job) this.c.element;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            this.c.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            CancellableContinuation cancellableContinuation = this.h;
            try {
                Result.Companion companion = Result.Companion;
                Unit unit = Unit.INSTANCE;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(unit));
                obj = Result.m20constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r8 = Result.m23exceptionOrNullimpl(obj);
            if (r8 != null) {
                ILog.h("LifecycleRepeat", "捕获异常", r8);
            }
        }
    }
}
