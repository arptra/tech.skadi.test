package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding;
import com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$reSaveData$2$1", f = "TranscribeDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeDetailActivity$reSaveData$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageEntity $it;
    int label;
    final /* synthetic */ TranscribeDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeDetailActivity$reSaveData$2$1(TranscribeDetailActivity transcribeDetailActivity, MessageEntity messageEntity, Continuation<? super TranscribeDetailActivity$reSaveData$2$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeDetailActivity;
        this.$it = messageEntity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeDetailActivity$reSaveData$2$1(this.this$0, this.$it, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TranscribeBean access$getMTranscribeBean$p = this.this$0.mTranscribeBean;
            if (access$getMTranscribeBean$p != null) {
                TranscribeDetailActivity transcribeDetailActivity = this.this$0;
                MessageEntity messageEntity = this.$it;
                ActivityTranscribeDetailBinding access$getMBinding$p = transcribeDetailActivity.mBinding;
                if (access$getMBinding$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    access$getMBinding$p = null;
                }
                access$getMTranscribeBean$p.setSuperTitle(String.valueOf(access$getMBinding$p.m.getText()));
                NoteDetailAdapter access$getMAdapter$p = transcribeDetailActivity.mAdapter;
                if (access$getMAdapter$p == null || access$getMAdapter$p.E0() != 0) {
                    NoteDetailAdapter access$getMAdapter$p2 = transcribeDetailActivity.mAdapter;
                    if (access$getMAdapter$p2 != null && access$getMAdapter$p2.E0() == 1) {
                        access$getMTranscribeBean$p.setTitle2(messageEntity.getMessage());
                    }
                } else {
                    access$getMTranscribeBean$p.setTitle(messageEntity.getMessage());
                }
                TranscribeDBHelper.f6108a.B(access$getMTranscribeBean$p, messageEntity);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeDetailActivity$reSaveData$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
