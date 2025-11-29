package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ boolean $isContentTag;
    final /* synthetic */ boolean $isPersonTag;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1(boolean z, boolean z2, FastRecordTagViewModel fastRecordTagViewModel, Function0<Unit> function0, Continuation<? super FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1> continuation) {
        super(2, continuation);
        this.$isContentTag = z;
        this.$isPersonTag = z2;
        this.this$0 = fastRecordTagViewModel;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1(this.$isContentTag, this.$isPersonTag, this.this$0, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.$isContentTag;
            boolean z2 = this.$isPersonTag;
            LogExt.logE("saveAllHistoryData,isContentTag = " + z + ",isPersonTag = " + z2, "FastRecordTagViewModel");
            if (this.$isContentTag) {
                this.this$0.saveAllChangedNormalTagToHistory(true);
            }
            if (this.$isPersonTag) {
                this.this$0.saveAllNormalPersonToHistory(true);
            }
            this.$callBack.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
