package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.data.OpenTiciResult;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.utils.ConstantsKt;
import com.upuphone.ar.tici.phone.utils.TiciDataTrack;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$handTiciResult$1", f = "TiciAppViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$handTiciResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenTiciResult $result;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$handTiciResult$1(TiciAppViewModel ticiAppViewModel, OpenTiciResult openTiciResult, Continuation<? super TiciAppViewModel$handTiciResult$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiAppViewModel;
        this.$result = openTiciResult;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$handTiciResult$1(this.this$0, this.$result, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.H0((TiciEntity) null);
            int i = 0;
            if (this.$result.b() == OpenTiciFrom.ResetToDefaultTici) {
                this.this$0.n.setValue(Boxing.boxBoolean(false));
            }
            if (this.$result.a() != ConstantsKt.g()) {
                int a2 = this.$result.a();
                if (a2 != ConstantsKt.e()) {
                    i = a2 == ConstantsKt.c() ? 1 : a2 == ConstantsKt.h() ? 2 : a2 == ConstantsKt.b() ? 4 : 3;
                }
                TiciDataTrack.f6001a.c("app_prompt_fail", MapsKt.mapOf(TuplesKt.to("reason", Boxing.boxInt(i))));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$handTiciResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
