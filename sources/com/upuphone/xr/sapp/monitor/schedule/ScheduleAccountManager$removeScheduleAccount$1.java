package com.upuphone.xr.sapp.monitor.schedule;

import com.google.gson.Gson;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nScheduleAccountManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleAccountManager.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleAccountManager$removeScheduleAccount$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n766#2:134\n857#2,2:135\n*S KotlinDebug\n*F\n+ 1 ScheduleAccountManager.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleAccountManager$removeScheduleAccount$1\n*L\n121#1:134\n121#1:135,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager$removeScheduleAccount$1", f = "ScheduleAccountManager.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
public final class ScheduleAccountManager$removeScheduleAccount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleAccountManager$removeScheduleAccount$1(String str, Continuation<? super ScheduleAccountManager$removeScheduleAccount$1> continuation) {
        super(2, continuation);
        this.$id = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ScheduleAccountManager$removeScheduleAccount$1(this.$id, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List a2 = ScheduleAccountManager.b;
            String str = this.$id;
            ArrayList arrayList = new ArrayList();
            for (Object next : a2) {
                if (Intrinsics.areEqual((Object) ((LocalScheduleModel) next).c(), (Object) str)) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                ScheduleAccountManager.b.removeAll(arrayList);
                DataStoreUtils.e.a().p("schedule_account_cache_key", new Gson().toJson((Object) ScheduleAccountManager.b), true);
                MutableSharedFlow b = ScheduleAccountManager.c;
                List a3 = ScheduleAccountManager.b;
                this.label = 1;
                if (b.emit(a3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
        return ((ScheduleAccountManager$removeScheduleAccount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
