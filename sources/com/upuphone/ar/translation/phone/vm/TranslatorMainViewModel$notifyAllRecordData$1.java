package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.RecordTabBean;
import java.util.List;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$notifyAllRecordData$1", f = "TranslatorMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorMainViewModel$notifyAllRecordData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecordTabBean> $recordTabs;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainViewModel$notifyAllRecordData$1(List<RecordTabBean> list, Continuation<? super TranslatorMainViewModel$notifyAllRecordData$1> continuation) {
        super(2, continuation);
        this.$recordTabs = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorMainViewModel$notifyAllRecordData$1(this.$recordTabs, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            for (RecordTabBean component3 : this.$recordTabs) {
                component3.component3().E0();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorMainViewModel$notifyAllRecordData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
