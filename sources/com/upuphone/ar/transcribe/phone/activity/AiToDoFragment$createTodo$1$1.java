package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.AiToDoFragment$createTodo$1$1", f = "AiToDoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiToDoFragment$createTodo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TranscribeBean $it;
    int label;
    final /* synthetic */ AiToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiToDoFragment$createTodo$1$1(TranscribeBean transcribeBean, AiToDoFragment aiToDoFragment, Continuation<? super AiToDoFragment$createTodo$1$1> continuation) {
        super(2, continuation);
        this.$it = transcribeBean;
        this.this$0 = aiToDoFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiToDoFragment$createTodo$1$1(this.$it, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String recognizeId;
        List data;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String account = this.$it.getAccount();
            if (account == null || StringsKt.isBlank(account) || (recognizeId = this.$it.getRecognizeId()) == null || StringsKt.isBlank(recognizeId)) {
                this.this$0.toToast(R.string.tl_generate_to_do_empty);
            } else {
                AiTodoAdapter access$getAdapter$p = this.this$0.adapter;
                if (!(access$getAdapter$p == null || (data = access$getAdapter$p.getData()) == null)) {
                    data.clear();
                }
                this.this$0.showLoading();
                this.this$0.getTodoViewModel().v(this.$it);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AiToDoFragment$createTodo$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
