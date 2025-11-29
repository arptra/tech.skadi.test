package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.RecordTabBean;
import com.upuphone.ar.translation.phone.helper.TranslatorDbHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$deleteRecordForDb$1", f = "TranslatorMainViewModel.kt", i = {}, l = {343, 351}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorMainViewModel$deleteRecordForDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ List<RecordTabBean> $recordTabs;
    int label;
    final /* synthetic */ TranslatorMainViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$deleteRecordForDb$1$1", f = "TranslatorMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$deleteRecordForDb$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(noteBean, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String accountId = noteBean.getAccountId();
                String recognizeId = noteBean.getRecognizeId();
                TranslatorDbHelper translatorDbHelper = TranslatorDbHelper.f6307a;
                IntelExtnSummary b = translatorDbHelper.a().b(accountId, recognizeId);
                LogExt.j("deleteRecordForDb summary=" + b, "TranslatorMainViewModel");
                if (b != null) {
                    translatorDbHelper.a().d(b);
                }
                List c = translatorDbHelper.b().c(accountId, recognizeId);
                int size = c.size();
                LogExt.j("deleteRecordForDb todoList=" + size, "TranslatorMainViewModel");
                if (!c.isEmpty()) {
                    translatorDbHelper.b().d(c);
                }
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
    public TranslatorMainViewModel$deleteRecordForDb$1(TranslatorMainViewModel translatorMainViewModel, NoteBean noteBean, List<RecordTabBean> list, Continuation<? super TranslatorMainViewModel$deleteRecordForDb$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorMainViewModel;
        this.$noteBean = noteBean;
        this.$recordTabs = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorMainViewModel$deleteRecordForDb$1(this.this$0, this.$noteBean, this.$recordTabs, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            TranslatorMainViewModel$deleteRecordForDb$1$deleteId$1 translatorMainViewModel$deleteRecordForDb$1$deleteId$1 = new TranslatorMainViewModel$deleteRecordForDb$1$deleteId$1(this.$noteBean, (Continuation<? super TranslatorMainViewModel$deleteRecordForDb$1$deleteId$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, translatorMainViewModel$deleteRecordForDb$1$deleteId$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int intValue = ((Number) obj).intValue();
        LogExt.j("deleteRecordForDb id=" + intValue, "TranslatorMainViewModel");
        this.this$0.j(this.$noteBean, this.$recordTabs);
        CoroutineDispatcher b2 = Dispatchers.b();
        final NoteBean noteBean = this.$noteBean;
        AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.label = 2;
        if (BuildersKt.g(b2, r1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorMainViewModel$deleteRecordForDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
