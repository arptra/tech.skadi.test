package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTranscribeRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$updateRecord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,488:1\n350#2,7:489\n*S KotlinDebug\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$updateRecord$1\n*L\n408#1:489,7\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$updateRecord$1", f = "TranscribeRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeRecordFragment$updateRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TranscribeBean $transcribeBean;
    int label;
    final /* synthetic */ TranscribeRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeRecordFragment$updateRecord$1(TranscribeRecordFragment transcribeRecordFragment, TranscribeBean transcribeBean, Continuation<? super TranscribeRecordFragment$updateRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeRecordFragment;
        this.$transcribeBean = transcribeBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeRecordFragment$updateRecord$1(this.this$0, this.$transcribeBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NoteListAdapter access$getRecordAdapter$p = this.this$0.recordAdapter;
            NoteListAdapter noteListAdapter = null;
            if (access$getRecordAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                access$getRecordAdapter$p = null;
            }
            List data = access$getRecordAdapter$p.getData();
            TranscribeBean transcribeBean = this.$transcribeBean;
            Iterator it = data.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                ListItemBean listItemBean = (ListItemBean) it.next();
                Long id = transcribeBean.getId();
                long id2 = listItemBean.getId();
                if (id != null && id.longValue() == id2) {
                    listItemBean.setTitle(transcribeBean.getSuperTitle());
                    listItemBean.setContent(transcribeBean.getTitle());
                    listItemBean.setContent2(transcribeBean.getTitle2());
                    break;
                }
                i++;
            }
            NoteListAdapter access$getRecordAdapter$p2 = this.this$0.recordAdapter;
            if (access$getRecordAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            } else {
                noteListAdapter = access$getRecordAdapter$p2;
            }
            noteListAdapter.notifyItemChanged(i);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeRecordFragment$updateRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
