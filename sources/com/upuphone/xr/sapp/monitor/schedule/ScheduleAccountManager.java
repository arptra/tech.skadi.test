package com.upuphone.xr.sapp.monitor.schedule;

import android.content.Context;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel;
import com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\fH@¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleAccountManager;", "", "<init>", "()V", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "d", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "e", "()Ljava/util/List;", "local", "", "h", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;)V", "", "id", "g", "(Ljava/lang/String;)V", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "Ljava/util/List;", "cacheArray", "c", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_localScheduleAccount", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleAccountManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ScheduleAccountManager f7776a = new ScheduleAccountManager();
    public static List b = new ArrayList();
    public static final MutableSharedFlow c = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public static final CoroutineScope d;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager$1", f = "ScheduleAccountManager.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScheduleAccountManager scheduleAccountManager = ScheduleAccountManager.f7776a;
                this.label = 1;
                if (scheduleAccountManager.f(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.b());
        d = a2;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final MutableSharedFlow d() {
        return c;
    }

    public final List e() {
        String str = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "schedule_account_cache_key", "", true, (Context) null, 8, (Object) null);
        if (b.isEmpty() && str.length() > 0) {
            Object fromJson = new Gson().fromJson(str, new ScheduleAccountManager$getScheduleAccountCache$1());
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            b = (List) fromJson;
        }
        return b;
    }

    public final Object f(Continuation continuation) {
        String str = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "schedule_account_cache_key", "", true, (Context) null, 8, (Object) null);
        if (str.length() > 0) {
            List list = (List) new Gson().fromJson(str, new ScheduleAccountManager$initScheduleAccount$cache$1());
            List list2 = b;
            Intrinsics.checkNotNull(list);
            list2.addAll(list);
            Object emit = c.emit(b, continuation);
            return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
        }
        b.add(new LocalScheduleModel("system_calendar", "系统日历", "#FA5700", true, SubscribeType.calendar, (RemoteCalendarModel) null));
        return Unit.INSTANCE;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!Intrinsics.areEqual((Object) str, (Object) "system_calendar")) {
            Job unused = BuildersKt__Builders_commonKt.d(d, (CoroutineContext) null, (CoroutineStart) null, new ScheduleAccountManager$removeScheduleAccount$1(str, (Continuation<? super ScheduleAccountManager$removeScheduleAccount$1>) null), 3, (Object) null);
        }
    }

    public final void h(LocalScheduleModel localScheduleModel) {
        Intrinsics.checkNotNullParameter(localScheduleModel, ImagesContract.LOCAL);
        Job unused = BuildersKt__Builders_commonKt.d(d, (CoroutineContext) null, (CoroutineStart) null, new ScheduleAccountManager$saveScheduleAccount$1(localScheduleModel, (Continuation<? super ScheduleAccountManager$saveScheduleAccount$1>) null), 3, (Object) null);
    }
}
