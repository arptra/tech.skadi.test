package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.SpeechTranscribeFragment$handleVariousMsg$1", f = "SpeechTranscribeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpeechTranscribeFragment$handleVariousMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OperateMessage<Object> $operateMessage;
    int label;
    final /* synthetic */ SpeechTranscribeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechTranscribeFragment$handleVariousMsg$1(OperateMessage<Object> operateMessage, SpeechTranscribeFragment speechTranscribeFragment, Continuation<? super SpeechTranscribeFragment$handleVariousMsg$1> continuation) {
        super(2, continuation);
        this.$operateMessage = operateMessage;
        this.this$0 = speechTranscribeFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SpeechTranscribeFragment$handleVariousMsg$1(this.$operateMessage, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int type = this.$operateMessage.getType();
            String e = InterconnectMsgCodExtKt.e(type);
            LogExt.j("handleVariousMsg Type" + e, "SpeechTranscribeFragment");
            if (type == 7) {
                this.this$0.g1();
            } else if (type == 11) {
                LogExt.j("眼镜翻译启动完成", "SpeechTranscribeFragment");
            } else if (type == 66) {
                this.this$0.toToast(R.string.tl_record_save_to_translator);
            } else if (type == 102) {
                this.this$0.g1();
            } else if (type == 1002) {
                this.this$0.R0();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SpeechTranscribeFragment$handleVariousMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
