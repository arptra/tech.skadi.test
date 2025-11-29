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

@SourceDebugExtension({"SMAP\nTranslatorRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity$handleListData$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,934:1\n262#2,2:935\n262#2,2:937\n262#2,2:939\n262#2,2:941\n262#2,2:963\n262#2,2:965\n49#3:943\n65#3,16:944\n93#3,3:960\n*S KotlinDebug\n*F\n+ 1 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity$handleListData$1\n*L\n389#1:935,2\n390#1:937,2\n401#1:939,2\n406#1:941,2\n435#1:963,2\n448#1:965,2\n425#1:943\n425#1:944,16\n425#1:960,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1", f = "TranslatorRecordActivity.kt", i = {0, 0, 1}, l = {410, 441}, m = "invokeSuspend", n = {"src", "dst", "adapter"}, s = {"L$0", "L$1", "L$0"})
public final class TranslatorRecordActivity$handleListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$handleListData$1(TranslatorRecordActivity translatorRecordActivity, NoteBean noteBean, Continuation<? super TranslatorRecordActivity$handleListData$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$handleListData$1(this.this$0, this.$noteBean, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d6  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "loadingView"
            r4 = 1
            java.lang.String r5 = "etRecordTitle"
            r6 = 2
            r7 = 8
            java.lang.String r8 = "mBinding"
            java.lang.String r9 = "mListHeadBinding"
            r10 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x0032
            if (r2 != r6) goto L_0x002a
            java.lang.Object r1 = r0.L$1
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r1 = (com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter) r1
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r2 = (com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter) r2
            kotlin.ResultKt.throwOnFailure(r23)
            r4 = r23
            goto L_0x01c2
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            java.lang.Object r2 = r0.L$2
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r23)
            r20 = r4
            r19 = r11
            r4 = r23
            goto L_0x0143
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r23)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            r2.mRecordType = r6
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x005d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r2 = r10
        L_0x005d:
            androidx.core.widget.NestedScrollView r2 = r2.g
            java.lang.String r11 = "nsvList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r11)
            r11 = 0
            r2.setVisibility(r11)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x0074
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r2 = r10
        L_0x0074:
            android.widget.ScrollView r2 = r2.f
            java.lang.String r12 = "nsvContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r12)
            r2.setVisibility(r7)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r2 = r2.mAdapter
            if (r2 == 0) goto L_0x008f
            java.util.List r2 = r2.getData()
            if (r2 == 0) goto L_0x008f
            r2.clear()
        L_0x008f:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            r2.initialRecyclerView()
            com.upuphone.ar.translation.phone.bean.NoteBean r2 = r0.$noteBean
            java.lang.String r2 = r2.getSrcContent()
            com.upuphone.ar.translation.phone.bean.NoteBean r12 = r0.$noteBean
            java.lang.String r12 = r12.getDstContent()
            com.upuphone.ar.translation.phone.bean.NoteBean r13 = r0.$noteBean
            int r13 = r13.getTransType()
            r14 = 3
            if (r13 != r14) goto L_0x0100
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r13 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r13 = r13.mListHeadBinding
            if (r13 != 0) goto L_0x00b5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r13 = r10
        L_0x00b5:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r13 = r13.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r5)
            r13.setVisibility(r11)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r11 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r11 = r11.mListHeadBinding
            if (r11 != 0) goto L_0x00c9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r11 = r10
        L_0x00c9:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r11 = r11.b
            com.upuphone.ar.translation.phone.view.EditTitleInputFilter r13 = new com.upuphone.ar.translation.phone.view.EditTitleInputFilter
            r13.<init>()
            com.upuphone.ar.translation.phone.view.EditTitleInputFilter[] r13 = new com.upuphone.ar.translation.phone.view.EditTitleInputFilter[]{r13}
            android.text.InputFilter[] r13 = (android.text.InputFilter[]) r13
            r11.setFilters(r13)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r11 = r0.this$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r13 = r11.getMTranslatorRecordVm()
            com.upuphone.ar.translation.phone.bean.NoteBean r14 = r0.$noteBean
            java.lang.String r13 = r13.B(r14)
            r11.mOriginalRecordTitle = r13
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r11 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r11 = r11.mListHeadBinding
            if (r11 != 0) goto L_0x00f4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r11 = r10
        L_0x00f4:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r11 = r11.b
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r13 = r0.this$0
            java.lang.String r13 = r13.mOriginalRecordTitle
            r11.setText(r13)
            goto L_0x0114
        L_0x0100:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r11 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r11 = r11.mListHeadBinding
            if (r11 != 0) goto L_0x010c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r11 = r10
        L_0x010c:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r11 = r11.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            r11.setVisibility(r7)
        L_0x0114:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r11 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r11 = r11.mListHeadBinding
            if (r11 != 0) goto L_0x0120
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r11 = r10
        L_0x0120:
            android.widget.TextView r11 = r11.c
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$1 r14 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$1
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r15 = r0.this$0
            com.upuphone.ar.translation.phone.bean.NoteBean r7 = r0.$noteBean
            r14.<init>(r15, r7, r10)
            r0.L$0 = r2
            r0.L$1 = r12
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r13, r14, r0)
            if (r4 != r1) goto L_0x013e
            return r1
        L_0x013e:
            r19 = r2
            r2 = r11
            r20 = r12
        L_0x0143:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r2 = r2.mListHeadBinding
            if (r2 != 0) goto L_0x0154
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x0154:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r2 = r2.b
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$2 r4 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$2
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r7 = r0.this$0
            r4.<init>(r7)
            r2.i(r4)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r2 = r2.mListHeadBinding
            if (r2 != 0) goto L_0x016c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r2 = r10
        L_0x016c:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r2 = r2.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r4 = r0.this$0
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$invokeSuspend$$inlined$doOnTextChanged$1 r5 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$invokeSuspend$$inlined$doOnTextChanged$1
            r5.<init>(r4)
            r2.addTextChangedListener(r5)
            boolean r2 = kotlin.text.StringsKt.isBlank(r19)
            if (r2 != 0) goto L_0x01e4
            boolean r2 = kotlin.text.StringsKt.isBlank(r20)
            if (r2 != 0) goto L_0x01e4
            boolean r2 = com.upuphone.ar.translation.utils.JsonUtils.b(r20)
            if (r2 != 0) goto L_0x018e
            goto L_0x01e4
        L_0x018e:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r0.this$0
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r2 = r2.mAdapter
            if (r2 == 0) goto L_0x01ca
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r4 = r0.this$0
            com.upuphone.ar.translation.phone.bean.NoteBean r5 = r0.$noteBean
            java.util.List r7 = r2.getData()
            r7.clear()
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$4$1 r9 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1$4$1
            r21 = 0
            r16 = r9
            r17 = r4
            r18 = r5
            r16.<init>(r17, r18, r19, r20, r21)
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r10
            r0.label = r6
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r7, r9, r0)
            if (r4 != r1) goto L_0x01c1
            return r1
        L_0x01c1:
            r1 = r2
        L_0x01c2:
            java.util.Collection r4 = (java.util.Collection) r4
            r1.r(r4)
            r2.notifyDataSetChanged()
        L_0x01ca:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r0 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x01d6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            goto L_0x01d7
        L_0x01d6:
            r10 = r0
        L_0x01d7:
            com.upuphone.ar.translation.phone.view.TranslatorLoadingView r0 = r10.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r1 = 8
            r0.setVisibility(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01e4:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r0 = r0.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x01f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            goto L_0x01f1
        L_0x01f0:
            r10 = r0
        L_0x01f1:
            com.upuphone.ar.translation.phone.view.TranslatorLoadingView r0 = r10.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r1 = 8
            r0.setVisibility(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$handleListData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordActivity$handleListData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
