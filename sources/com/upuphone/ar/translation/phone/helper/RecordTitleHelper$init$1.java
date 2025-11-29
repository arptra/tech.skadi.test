package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.RecordTitleHelper$init$1", f = "RecordTitleHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecordTitleHelper$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecordTitleHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordTitleHelper$init$1(RecordTitleHelper recordTitleHelper, Continuation<? super RecordTitleHelper$init$1> continuation) {
        super(2, continuation);
        this.this$0 = recordTitleHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordTitleHelper$init$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RecordTitleHelper recordTitleHelper = this.this$0;
            TranslatorLitePalHelper translatorLitePalHelper = TranslatorLitePalHelper.f6309a;
            recordTitleHelper.b = translatorLitePalHelper.j(2);
            this.this$0.c = translatorLitePalHelper.j(3);
            int size = this.this$0.b.size();
            int size2 = this.this$0.c.size();
            LogExt.j("Init simulTitle size=" + size + ", dialogueTitle size=" + size2, "RecordTitleHelper");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordTitleHelper$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
