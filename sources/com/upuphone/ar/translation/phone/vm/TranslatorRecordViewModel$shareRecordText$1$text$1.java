package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$shareRecordText$1$text$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordViewModel$shareRecordText$1$text$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ List<NoteDetailBean> $noteBeanList;
    final /* synthetic */ String $textRecord;
    int label;
    final /* synthetic */ TranslatorRecordViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$shareRecordText$1$text$1(NoteBean noteBean, TranslatorRecordViewModel translatorRecordViewModel, List<NoteDetailBean> list, String str, Continuation<? super TranslatorRecordViewModel$shareRecordText$1$text$1> continuation) {
        super(2, continuation);
        this.$noteBean = noteBean;
        this.this$0 = translatorRecordViewModel;
        this.$noteBeanList = list;
        this.$textRecord = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$shareRecordText$1$text$1(this.$noteBean, this.this$0, this.$noteBeanList, this.$textRecord, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int xrType = this.$noteBean.getXrType();
            return xrType != 0 ? xrType != 1 ? "" : this.$noteBean.getTransType() == 3 ? this.this$0.D(this.$noteBean, this.$noteBeanList) : this.this$0.E(this.$noteBean, this.$textRecord) : this.this$0.D(this.$noteBean, this.$noteBeanList);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((TranslatorRecordViewModel$shareRecordText$1$text$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
