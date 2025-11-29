package com.upuphone.xr.sapp.monitor.schedule.lark;

import com.upuphone.xr.sapp.monitor.schedule.ScheduleProvider;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/lark/LarkScheduleProvider;", "Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleProvider;", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "account", "<init>", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;)V", "", "c", "()V", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "d", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLarkScheduleProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LarkScheduleProvider.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkScheduleProvider\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,102:1\n48#2,4:103\n*S KotlinDebug\n*F\n+ 1 LarkScheduleProvider.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkScheduleProvider\n*L\n31#1:103,4\n*E\n"})
public final class LarkScheduleProvider extends ScheduleProvider {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public CoroutineScope c = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/lark/LarkScheduleProvider$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LarkScheduleProvider(LocalScheduleModel localScheduleModel) {
        super(localScheduleModel);
        Intrinsics.checkNotNullParameter(localScheduleModel, "account");
    }

    public void c() {
        Job unused = BuildersKt__Builders_commonKt.d(this.c, new LarkScheduleProvider$query$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this), (CoroutineStart) null, new LarkScheduleProvider$query$2(this, (Continuation<? super LarkScheduleProvider$query$2>) null), 2, (Object) null);
    }
}
