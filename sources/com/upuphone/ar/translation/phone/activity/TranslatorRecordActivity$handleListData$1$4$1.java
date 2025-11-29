package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$4$1", f = "TranslatorRecordActivity.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordActivity$handleListData$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<NoteDetailBean>>, Object> {
    final /* synthetic */ String $dst;
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ String $src;
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$handleListData$1$4$1(TranslatorRecordActivity translatorRecordActivity, NoteBean noteBean, String str, String str2, Continuation<? super TranslatorRecordActivity$handleListData$1$4$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
        this.$noteBean = noteBean;
        this.$src = str;
        this.$dst = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$handleListData$1$4$1(this.this$0, this.$noteBean, this.$src, this.$dst, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TranslatorRecordViewModel access$getMTranslatorRecordVm = this.this$0.getMTranslatorRecordVm();
            NoteBean noteBean = this.$noteBean;
            String str = this.$src;
            String str2 = this.$dst;
            this.label = 1;
            obj = access$getMTranslatorRecordVm.v(noteBean, str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<NoteDetailBean>> continuation) {
        return ((TranslatorRecordActivity$handleListData$1$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
