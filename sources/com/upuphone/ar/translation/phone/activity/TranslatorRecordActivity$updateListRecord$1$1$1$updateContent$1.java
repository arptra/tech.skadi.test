package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter;
import kotlin.Metadata;
import kotlin.Pair;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1", f = "TranslatorRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
    final /* synthetic */ NoteDetailAdapter $adapter;
    final /* synthetic */ String $tempDstContent;
    final /* synthetic */ String $tempSrcContent;
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1(TranslatorRecordActivity translatorRecordActivity, String str, String str2, NoteDetailAdapter noteDetailAdapter, Continuation<? super TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
        this.$tempSrcContent = str;
        this.$tempDstContent = str2;
        this.$adapter = noteDetailAdapter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1(this.this$0, this.$tempSrcContent, this.$tempDstContent, this.$adapter, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getMTranslatorRecordVm().G(this.$tempSrcContent, this.$tempDstContent, this.$adapter.getData());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<String, String>> continuation) {
        return ((TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
