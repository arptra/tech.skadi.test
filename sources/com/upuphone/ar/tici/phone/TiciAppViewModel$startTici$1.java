package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.db.TiciDao;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$startTici$1", f = "TiciAppViewModel.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$startTici$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenTiciFrom $from;
    final /* synthetic */ long $id;
    final /* synthetic */ boolean $restart;
    final /* synthetic */ boolean $restartIfReachLast;
    final /* synthetic */ Integer $targetIndex;
    final /* synthetic */ Integer $targetPage;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$startTici$1(long j, TiciAppViewModel ticiAppViewModel, OpenTiciFrom openTiciFrom, boolean z, boolean z2, Integer num, Integer num2, Continuation<? super TiciAppViewModel$startTici$1> continuation) {
        super(2, continuation);
        this.$id = j;
        this.this$0 = ticiAppViewModel;
        this.$from = openTiciFrom;
        this.$restart = z;
        this.$restartIfReachLast = z2;
        this.$targetPage = num;
        this.$targetIndex = num2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$startTici$1(this.$id, this.this$0, this.$from, this.$restart, this.$restartIfReachLast, this.$targetPage, this.$targetIndex, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TiciDao w = TiciApp.b.w();
            long j = this.$id;
            this.label = 1;
            obj = w.q(j, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TiciEntity ticiEntity = (TiciEntity) obj;
        if (ticiEntity == null) {
            long j2 = this.$id;
            CommonExtKt.d("startTici, can`t find ticiEntity for id: " + j2, "TiciAppViewModel", (Throwable) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        TiciAppViewModel.O0(this.this$0, ticiEntity, this.$from, this.$restart, this.$restartIfReachLast, this.$targetPage, this.$targetIndex, 0, 64, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$startTici$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
