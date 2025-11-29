package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.vm.TranscribeEditViewModel;
import com.upuphone.ar.transcribe.utils.RecycleHelper;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$deleteRecord$1", f = "TranscribeRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeRecordFragment$deleteRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TranscribeBean $transcribeBean;
    int label;
    final /* synthetic */ TranscribeRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeRecordFragment$deleteRecord$1(TranscribeRecordFragment transcribeRecordFragment, TranscribeBean transcribeBean, Continuation<? super TranscribeRecordFragment$deleteRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeRecordFragment;
        this.$transcribeBean = transcribeBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeRecordFragment$deleteRecord$1(this.this$0, this.$transcribeBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NoteListAdapter access$getRecordAdapter$p = this.this$0.recordAdapter;
            RecycleHelper recycleHelper = null;
            if (access$getRecordAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                access$getRecordAdapter$p = null;
            }
            access$getRecordAdapter$p.h0(this.this$0.toItemBean(this.$transcribeBean));
            TranscribeEditViewModel access$getEditViewModel$p = this.this$0.editViewModel;
            if (access$getEditViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editViewModel");
                access$getEditViewModel$p = null;
            }
            NoteListAdapter access$getRecordAdapter$p2 = this.this$0.recordAdapter;
            if (access$getRecordAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                access$getRecordAdapter$p2 = null;
            }
            access$getEditViewModel$p.x(access$getRecordAdapter$p2.getItemCount());
            NoteListAdapter access$getRecordAdapter$p3 = this.this$0.recordAdapter;
            if (access$getRecordAdapter$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                access$getRecordAdapter$p3 = null;
            }
            if (access$getRecordAdapter$p3.getItemCount() == 0) {
                RecycleHelper access$getRecycleHelper$p = this.this$0.recycleHelper;
                if (access$getRecycleHelper$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recycleHelper");
                } else {
                    recycleHelper = access$getRecycleHelper$p;
                }
                LogExt.g("deleteRecord loadMore=" + recycleHelper.b(), "TransRecordFragment");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeRecordFragment$deleteRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
