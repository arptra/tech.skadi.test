package com.upuphone.ar.translation.phone.vm;

import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteDetailUpdateBean;
import com.upuphone.ar.translation.phone.bean.TransRecordIndex;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$parseListRecordSpans$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordViewModel$parseListRecordSpans$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<NoteDetailUpdateBean, Unit> $callback;
    final /* synthetic */ Editable $editable;
    final /* synthetic */ int $speaker;
    int label;
    final /* synthetic */ TranslatorRecordViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$parseListRecordSpans$1$2", f = "TranslatorRecordViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$parseListRecordSpans$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(function1, objectRef, objectRef2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<NoteDetailUpdateBean, Unit> function1 = function1;
                NoteDetailUpdateBean noteDetailUpdateBean = new NoteDetailUpdateBean();
                Ref.ObjectRef<String> objectRef = objectRef;
                Ref.ObjectRef<String> objectRef2 = objectRef2;
                noteDetailUpdateBean.setSrc((String) objectRef.element);
                noteDetailUpdateBean.setDst((String) objectRef2.element);
                function1.invoke(noteDetailUpdateBean);
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
    public TranslatorRecordViewModel$parseListRecordSpans$1(Editable editable, int i, TranslatorRecordViewModel translatorRecordViewModel, Function1<? super NoteDetailUpdateBean, Unit> function1, Continuation<? super TranslatorRecordViewModel$parseListRecordSpans$1> continuation) {
        super(2, continuation);
        this.$editable = editable;
        this.$speaker = i;
        this.this$0 = translatorRecordViewModel;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$parseListRecordSpans$1(this.$editable, this.$speaker, this.this$0, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        int i2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Editable editable = this.$editable;
            int i3 = 0;
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
            int color = this.$speaker == 0 ? this.this$0.s().getColor(R.color.color_record_detail_me_src) : this.this$0.s().getColor(R.color.color_record_detail_other_src);
            ArrayList<TransRecordIndex> arrayList = new ArrayList<>();
            Intrinsics.checkNotNull(foregroundColorSpanArr);
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                int spanStart = this.$editable.getSpanStart(foregroundColorSpan);
                int foregroundColor = foregroundColorSpan.getForegroundColor();
                TransRecordIndex transRecordIndex = new TransRecordIndex();
                transRecordIndex.setRecordType(foregroundColor == color ? 0 : 1);
                transRecordIndex.setStartIndex(spanStart);
                arrayList.add(transRecordIndex);
            }
            int length = this.$editable.length();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            for (TransRecordIndex transRecordIndex2 : arrayList) {
                int i4 = i3 + 1;
                if (i3 != CollectionsKt.getLastIndex(arrayList)) {
                    i2 = transRecordIndex2.getStartIndex();
                    i = ((TransRecordIndex) arrayList.get(i4)).getStartIndex();
                } else {
                    i2 = transRecordIndex2.getStartIndex();
                    i = length;
                }
                if (i2 + 1 <= i && i <= length) {
                    T obj2 = this.$editable.subSequence(i2, i).toString();
                    if (transRecordIndex2.getRecordType() == 0) {
                        objectRef.element = obj2;
                    } else {
                        objectRef2.element = obj2;
                    }
                }
                i3 = i4;
            }
            CoroutineScope a2 = ViewModelKt.a(this.this$0);
            MainCoroutineDispatcher c = Dispatchers.c();
            final Function1<NoteDetailUpdateBean, Unit> function1 = this.$callback;
            Job unused = BuildersKt__Builders_commonKt.d(a2, c, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordViewModel$parseListRecordSpans$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
