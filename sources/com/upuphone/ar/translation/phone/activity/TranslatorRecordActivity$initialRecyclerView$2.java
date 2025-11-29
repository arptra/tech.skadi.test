package com.upuphone.ar.translation.phone.activity;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
import com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "isEdited", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorRecordActivity$initialRecyclerView$2 extends Lambda implements Function2<Integer, Boolean, Unit> {
    final /* synthetic */ TranslatorRecordActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$initialRecyclerView$2$2", f = "TranslatorRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$initialRecyclerView$2$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(translatorRecordActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TranslatorRecordActivity translatorRecordActivity = translatorRecordActivity;
                ItemDetailListHeadBinding access$getMListHeadBinding$p = translatorRecordActivity.mListHeadBinding;
                if (access$getMListHeadBinding$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
                    access$getMListHeadBinding$p = null;
                }
                translatorRecordActivity.updateEditStatus(2, access$getMListHeadBinding$p.b.q(), translatorRecordActivity.isListRecordEdited(), translatorRecordActivity.isListTitleUpdated() || (translatorRecordActivity.isListRecordUpdated() && !translatorRecordActivity.isListTitleBlank()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$initialRecyclerView$2(TranslatorRecordActivity translatorRecordActivity) {
        super(2);
        this.this$0 = translatorRecordActivity;
    }

    public final void invoke(int i, boolean z) {
        NoteDetailAdapter access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p != null) {
            NoteDetailBean noteDetailBean = (NoteDetailBean) access$getMAdapter$p.getData().get(i);
            List data = access$getMAdapter$p.getData();
            noteDetailBean.setEditStatus(z ? 1 : 0);
            Unit unit = Unit.INSTANCE;
            data.set(i, noteDetailBean);
        }
        LifecycleCoroutineScope a2 = LifecycleOwnerKt.a(this.this$0);
        CoroutineDispatcher b = Dispatchers.b();
        final TranslatorRecordActivity translatorRecordActivity = this.this$0;
        Job unused = BuildersKt__Builders_commonKt.d(a2, b, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 2, (Object) null);
        if (!z) {
            this.this$0.refreshListDeleteStatus(i);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }
}
