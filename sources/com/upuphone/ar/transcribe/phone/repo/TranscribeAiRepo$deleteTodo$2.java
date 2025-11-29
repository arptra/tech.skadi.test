package com.upuphone.ar.transcribe.phone.repo;

import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo$deleteTodo$2", f = "TranscribeAiRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeAiRepo$deleteTodo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long[]>, Object> {
    final /* synthetic */ AiTodoEntity $bean;
    int label;
    final /* synthetic */ TranscribeAiRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAiRepo$deleteTodo$2(AiTodoEntity aiTodoEntity, TranscribeAiRepo transcribeAiRepo, Continuation<? super TranscribeAiRepo$deleteTodo$2> continuation) {
        super(2, continuation);
        this.$bean = aiTodoEntity;
        this.this$0 = transcribeAiRepo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeAiRepo$deleteTodo$2(this.$bean, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$bean.setDeleted(Boxing.boxInt(1));
            AiTodoEntity aiTodoEntity = this.$bean;
            String src = aiTodoEntity.getSrc();
            if (src == null) {
                src = this.$bean.getContent();
            }
            aiTodoEntity.setContent(src);
            this.$bean.setReported(Boxing.boxInt(0));
            return this.this$0.l().e(CollectionsKt.listOf(this.$bean));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Long[]> continuation) {
        return ((TranscribeAiRepo$deleteTodo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
