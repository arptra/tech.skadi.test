package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.db.TiciDBHelper;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtil;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$resetAllData$1", f = "TiciAppViewModel.kt", i = {0}, l = {503}, m = "invokeSuspend", n = {"userId"}, s = {"L$0"})
public final class TiciAppViewModel$resetAllData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$resetAllData$1(TiciAppViewModel ticiAppViewModel, Continuation<? super TiciAppViewModel$resetAllData$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiAppViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$resetAllData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String g = TiciApp.b.g();
            if (g == null) {
                g = "0";
            }
            CommonExtKt.e("resetAllData, start, userId: " + g, "TiciAppViewModel");
            TiciDBHelper ticiDBHelper = TiciDBHelper.f5925a;
            this.L$0 = g;
            this.label = 1;
            if (ticiDBHelper.a(g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = g;
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SpUtil.Companion companion = SpUtil.b;
        SpUtil b = companion.b(str);
        TiciApp ticiApp = TiciApp.b;
        b.b(ticiApp.a());
        companion.a().b(ticiApp.a());
        this.this$0.I0((TiciEntity) null);
        this.this$0.H0((TiciEntity) null);
        this.this$0.F0(false);
        this.this$0.G0(false);
        CommonExtKt.e("resetAllData, succeed", "TiciAppViewModel");
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$resetAllData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
