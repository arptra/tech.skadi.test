package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import com.upuphone.star.core.log.ULog;
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
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$showRenameDialog$4$1", f = "TranscribeRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeRecordFragment$showRenameDialog$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ListItemBean $bean;
    final /* synthetic */ String $value;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TranscribeRecordFragment this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$showRenameDialog$4$1$1", f = "TranscribeRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$showRenameDialog$4$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(listItemBean, str, transcribeRecordFragment, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                listItemBean.setTitle(str);
                NoteListAdapter access$getRecordAdapter$p = transcribeRecordFragment.recordAdapter;
                if (access$getRecordAdapter$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                    access$getRecordAdapter$p = null;
                }
                access$getRecordAdapter$p.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeRecordFragment$showRenameDialog$4$1(ListItemBean listItemBean, String str, TranscribeRecordFragment transcribeRecordFragment, Continuation<? super TranscribeRecordFragment$showRenameDialog$4$1> continuation) {
        super(2, continuation);
        this.$bean = listItemBean;
        this.$value = str;
        this.this$0 = transcribeRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TranscribeRecordFragment$showRenameDialog$4$1 transcribeRecordFragment$showRenameDialog$4$1 = new TranscribeRecordFragment$showRenameDialog$4$1(this.$bean, this.$value, this.this$0, continuation);
        transcribeRecordFragment$showRenameDialog$4$1.L$0 = obj;
        return transcribeRecordFragment$showRenameDialog$4$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (TranscribeDBHelper.f6108a.E(this.$bean.getId(), this.$value) > 0) {
                MainCoroutineDispatcher c = Dispatchers.c();
                final ListItemBean listItemBean = this.$bean;
                final String str = this.$value;
                final TranscribeRecordFragment transcribeRecordFragment = this.this$0;
                Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, c, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            } else {
                ULog.f6446a.c("TransRecordFragment", "update title error");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeRecordFragment$showRenameDialog$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
