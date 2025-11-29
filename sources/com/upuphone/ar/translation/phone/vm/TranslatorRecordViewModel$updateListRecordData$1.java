package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteBeanExtKt;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$updateListRecordData$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordViewModel$updateListRecordData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRecordUpdated;
    final /* synthetic */ boolean $isTitleUpdated;
    final /* synthetic */ NoteBean $noteBean;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$updateListRecordData$1$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$updateListRecordData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(noteBean, z, z2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TranslatorLitePalHelper.f6309a.m(noteBean, z, z2);
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
    public TranslatorRecordViewModel$updateListRecordData$1(NoteBean noteBean, boolean z, boolean z2, Continuation<? super TranslatorRecordViewModel$updateListRecordData$1> continuation) {
        super(2, continuation);
        this.$noteBean = noteBean;
        this.$isTitleUpdated = z;
        this.$isRecordUpdated = z2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$updateListRecordData$1(this.$noteBean, this.$isTitleUpdated, this.$isRecordUpdated, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            final NoteBean noteBean = this.$noteBean;
            final boolean z = this.$isTitleUpdated;
            final boolean z2 = this.$isRecordUpdated;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(b, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NoteBean noteBean2 = (NoteBean) AnyExtKt.a(this.$noteBean, NoteBean.class);
        String assembleContent = NoteBeanExtKt.assembleContent(noteBean2);
        if (StringsKt.isBlank(assembleContent)) {
            assembleContent = noteBean2.getContent();
        }
        noteBean2.setContent(assembleContent);
        noteBean2.setSrcContent("");
        noteBean2.setDstContent("");
        Unit unit = Unit.INSTANCE;
        TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1005, noteBean2));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordViewModel$updateListRecordData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
