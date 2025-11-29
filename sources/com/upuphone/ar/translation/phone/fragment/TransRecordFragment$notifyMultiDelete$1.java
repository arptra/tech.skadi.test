package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.adapter.NoteListAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordShareViewModel;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.TransRecordFragment$notifyMultiDelete$1", f = "TransRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TransRecordFragment$notifyMultiDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TransRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransRecordFragment$notifyMultiDelete$1(TransRecordFragment transRecordFragment, Continuation<? super TransRecordFragment$notifyMultiDelete$1> continuation) {
        super(2, continuation);
        this.this$0 = transRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TransRecordFragment$notifyMultiDelete$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            NoteListAdapter n0 = this.this$0.d;
            TranslatorRecordShareViewModel translatorRecordShareViewModel = null;
            if (n0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                n0 = null;
            }
            List<NoteBean> data = n0.getData();
            for (NoteBean noteBean : data) {
                if (noteBean.isDeleted()) {
                    arrayList.add(noteBean);
                }
            }
            TranslatorRecordShareViewModel s0 = this.this$0.f;
            if (s0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordShareVm");
                s0 = null;
            }
            s0.m(arrayList.size() == data.size());
            TranslatorRecordShareViewModel s02 = this.this$0.f;
            if (s02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordShareVm");
            } else {
                translatorRecordShareViewModel = s02;
            }
            translatorRecordShareViewModel.p(arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransRecordFragment$notifyMultiDelete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
