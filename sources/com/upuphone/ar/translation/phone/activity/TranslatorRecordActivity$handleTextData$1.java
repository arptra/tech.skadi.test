package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTranslatorRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity$handleTextData$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,934:1\n262#2,2:935\n262#2,2:937\n262#2,2:939\n262#2,2:941\n262#2,2:963\n262#2,2:985\n49#3:943\n65#3,16:944\n93#3,3:960\n49#3:965\n65#3,16:966\n93#3,3:982\n*S KotlinDebug\n*F\n+ 1 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity$handleTextData$1\n*L\n464#1:935,2\n465#1:937,2\n475#1:939,2\n482#1:941,2\n519#1:963,2\n547#1:985,2\n507#1:943\n507#1:944,16\n507#1:960,3\n540#1:965\n540#1:966,16\n540#1:982,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1", f = "TranslatorRecordActivity.kt", i = {0, 0}, l = {492, 523}, m = "invokeSuspend", n = {"src", "dst"}, s = {"L$0", "L$1"})
public final class TranslatorRecordActivity$handleTextData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$handleTextData$1(TranslatorRecordActivity translatorRecordActivity, NoteBean noteBean, Continuation<? super TranslatorRecordActivity$handleTextData$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$handleTextData$1(this.this$0, this.$noteBean, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x024f  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "loadingView"
            r4 = 2
            java.lang.String r5 = "etRecordTitle"
            r6 = 8
            r7 = 0
            r8 = 1
            java.lang.String r9 = "mBinding"
            r10 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r8) goto L_0x002d
            if (r2 != r4) goto L_0x0025
            java.lang.Object r1 = r0.L$0
            com.upuphone.ar.translation.phone.view.ClipboardEditText r1 = (com.upuphone.ar.translation.phone.view.ClipboardEditText) r1
            kotlin.ResultKt.throwOnFailure(r23)
            r4 = r23
            goto L_0x0209
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.lang.Object r2 = r0.L$2
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r23)
            r7 = r23
            r20 = r8
            r19 = r11
            goto L_0x018a
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r23)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            r2.mRecordType = r8
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x0058
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x0058:
            androidx.core.widget.NestedScrollView r2 = r2.g
            java.lang.String r11 = "nsvList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r11)
            r2.setVisibility(r6)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x006e:
            android.widget.ScrollView r2 = r2.f
            java.lang.String r11 = "nsvContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r11)
            r2.setVisibility(r7)
            com.upuphone.ar.translation.phone.bean.NoteBean r2 = r0.$noteBean
            java.lang.String r11 = r2.getSrcContent()
            com.upuphone.ar.translation.phone.bean.NoteBean r2 = r0.$noteBean
            java.lang.String r2 = r2.getDstContent()
            boolean r12 = com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro()
            if (r12 == 0) goto L_0x0103
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0096
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x0096:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.d
            r12.setEnableClickEdit(r8)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x00a7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x00a7:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.d
            com.upuphone.ar.translation.phone.view.EditTitleInputFilter r13 = new com.upuphone.ar.translation.phone.view.EditTitleInputFilter
            r13.<init>()
            com.upuphone.ar.translation.phone.view.EditTitleInputFilter[] r13 = new com.upuphone.ar.translation.phone.view.EditTitleInputFilter[]{r13}
            android.text.InputFilter[] r13 = (android.text.InputFilter[]) r13
            r12.setFilters(r13)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x00c3:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)
            r12.setVisibility(r7)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r13 = r12.getMTranslatorRecordVm()
            com.upuphone.ar.translation.phone.bean.NoteBean r14 = r0.$noteBean
            java.lang.String r13 = r13.B(r14)
            r12.mOriginalRecordTitle = r13
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x00e6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x00e6:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.d
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r13 = r0.this$0
            java.lang.String r13 = r13.mOriginalRecordTitle
            r12.setText(r13)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x00fd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x00fd:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.c
            r12.setEnableClickEdit(r8)
            goto L_0x015b
        L_0x0103:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x010f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x010f:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)
            r12.setVisibility(r6)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0123
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x0123:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.d
            r12.setEnableClickEdit(r7)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0134
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x0134:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.c
            r12.setEnableClickEdit(r7)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0145
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x0145:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.c
            r12.setAir(r8)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0156
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x0156:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r12 = r12.c
            r12.setFocusableInTouchMode(r8)
        L_0x015b:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0167
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r12 = r10
        L_0x0167:
            android.widget.TextView r12 = r12.j
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$1 r14 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$1
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r15 = r0.this$0
            com.upuphone.ar.translation.phone.bean.NoteBean r7 = r0.$noteBean
            r14.<init>(r15, r7, r10)
            r0.L$0 = r11
            r0.L$1 = r2
            r0.L$2 = r12
            r0.label = r8
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r13, r14, r0)
            if (r7 != r1) goto L_0x0185
            return r1
        L_0x0185:
            r20 = r2
            r19 = r11
            r2 = r12
        L_0x018a:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x019b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x019b:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r2 = r2.d
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$2 r7 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$2
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r8 = r0.this$0
            r7.<init>(r8)
            r2.i(r7)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x01b3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x01b3:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r2 = r2.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r5 = r0.this$0
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$invokeSuspend$$inlined$doOnTextChanged$1 r7 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$invokeSuspend$$inlined$doOnTextChanged$1
            r7.<init>(r5)
            r2.addTextChangedListener(r7)
            boolean r2 = kotlin.text.StringsKt.isBlank(r19)
            if (r2 != 0) goto L_0x025b
            boolean r2 = kotlin.text.StringsKt.isBlank(r20)
            if (r2 != 0) goto L_0x025b
            boolean r2 = com.upuphone.ar.translation.utils.JsonUtils.b(r20)
            if (r2 != 0) goto L_0x01d6
            goto L_0x025b
        L_0x01d6:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x01e2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x01e2:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r2 = r2.c
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$4 r7 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$4
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r8 = r0.this$0
            com.upuphone.ar.translation.phone.bean.NoteBean r11 = r0.$noteBean
            r21 = 0
            r16 = r7
            r17 = r8
            r18 = r11
            r16.<init>(r17, r18, r19, r20, r21)
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r5, r7, r0)
            if (r4 != r1) goto L_0x0208
            return r1
        L_0x0208:
            r1 = r2
        L_0x0209:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r1 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x021a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r1 = r10
        L_0x021a:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r1 = r1.c
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$5 r2 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$5
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r4 = r0.this$0
            r2.<init>(r4)
            r1.i(r2)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r1 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0232
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r1 = r10
        L_0x0232:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r1 = r1.c
            java.lang.String r2 = "etRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$invokeSuspend$$inlined$doOnTextChanged$2 r4 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1$invokeSuspend$$inlined$doOnTextChanged$2
            r4.<init>(r2)
            r1.addTextChangedListener(r4)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r0 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x024f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            goto L_0x0250
        L_0x024f:
            r10 = r0
        L_0x0250:
            com.upuphone.ar.translation.phone.view.TranslatorLoadingView r0 = r10.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r0.setVisibility(r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x025b:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r1 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0267
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r1 = r10
        L_0x0267:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r1 = r1.c
            r2 = 0
            r1.setEnableClickEdit(r2)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r0 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x0279
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            goto L_0x027a
        L_0x0279:
            r10 = r0
        L_0x027a:
            com.upuphone.ar.translation.phone.view.TranslatorLoadingView r0 = r10.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r0.setVisibility(r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleTextData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordActivity$handleTextData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
