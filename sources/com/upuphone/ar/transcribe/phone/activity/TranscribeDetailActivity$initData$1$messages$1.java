package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1$messages$1", f = "TranscribeDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeDetailActivity$initData$1$messages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MessageEntity>>, Object> {
    final /* synthetic */ long $recordId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeDetailActivity$initData$1$messages$1(long j, Continuation<? super TranscribeDetailActivity$initData$1$messages$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeDetailActivity$initData$1$messages$1(this.$recordId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return TranscribeDBHelper.f6108a.i(this.$recordId);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<MessageEntity>> continuation) {
        return ((TranscribeDetailActivity$initData$1$messages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
