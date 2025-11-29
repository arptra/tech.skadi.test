package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.NoteBean;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordShareViewModel$notifyMultiDeleteItems$1", f = "TranslatorRecordShareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordShareViewModel$notifyMultiDeleteItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<NoteBean> $list;
    int label;
    final /* synthetic */ TranslatorRecordShareViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordShareViewModel$notifyMultiDeleteItems$1(TranslatorRecordShareViewModel translatorRecordShareViewModel, List<NoteBean> list, Continuation<? super TranslatorRecordShareViewModel$notifyMultiDeleteItems$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordShareViewModel;
        this.$list = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordShareViewModel$notifyMultiDeleteItems$1(this.this$0, this.$list, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.e.setValue(this.$list);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordShareViewModel$notifyMultiDeleteItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
