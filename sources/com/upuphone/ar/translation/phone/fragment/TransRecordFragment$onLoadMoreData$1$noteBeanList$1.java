package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.adapter.NoteListAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordListViewModel;
import com.upuphone.ar.translation.utils.RecycleHelper;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1$noteBeanList$1", f = "TransRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TransRecordFragment$onLoadMoreData$1$noteBeanList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<NoteBean>>, Object> {
    int label;
    final /* synthetic */ TransRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransRecordFragment$onLoadMoreData$1$noteBeanList$1(TransRecordFragment transRecordFragment, Continuation<? super TransRecordFragment$onLoadMoreData$1$noteBeanList$1> continuation) {
        super(2, continuation);
        this.this$0 = transRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TransRecordFragment$onLoadMoreData$1$noteBeanList$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TranslatorRecordListViewModel o0 = this.this$0.z0();
            String u0 = this.this$0.b;
            RecycleHelper v0 = this.this$0.c;
            NoteListAdapter noteListAdapter = null;
            if (v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecycleHelper");
                v0 = null;
            }
            int d = v0.d();
            NoteListAdapter n0 = this.this$0.d;
            if (n0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            } else {
                noteListAdapter = n0;
            }
            return o0.g(u0, d, noteListAdapter.getItemCount());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<NoteBean>> continuation) {
        return ((TransRecordFragment$onLoadMoreData$1$noteBeanList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
