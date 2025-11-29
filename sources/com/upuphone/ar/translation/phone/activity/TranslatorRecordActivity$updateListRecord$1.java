package com.upuphone.ar.translation.phone.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1", f = "TranslatorRecordActivity.kt", i = {0, 0}, l = {701, 726}, m = "invokeSuspend", n = {"adapter", "$this$invokeSuspend_u24lambda_u243_u24lambda_u240"}, s = {"L$3", "L$5"})
public final class TranslatorRecordActivity$updateListRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isRecordUpdated;
    final /* synthetic */ Ref.BooleanRef $isTitleUpdated;
    final /* synthetic */ String $title;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$updateListRecord$1(TranslatorRecordActivity translatorRecordActivity, String str, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Continuation<? super TranslatorRecordActivity$updateListRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
        this.$title = str;
        this.$isTitleUpdated = booleanRef;
        this.$isRecordUpdated = booleanRef2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$updateListRecord$1(this.this$0, this.$title, this.$isTitleUpdated, this.$isRecordUpdated, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0162  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 1
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 2
            if (r3 == 0) goto L_0x004d
            if (r3 == r1) goto L_0x002a
            if (r3 != r4) goto L_0x0022
            java.lang.Object r1 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r0 = r0.L$0
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r0 = (com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity) r0
            kotlin.ResultKt.throwOnFailure(r18)
            r4 = 0
            goto L_0x012e
        L_0x0022:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002a:
            java.lang.Object r3 = r0.L$6
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r3 = (com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity) r3
            java.lang.Object r6 = r0.L$5
            com.upuphone.ar.translation.phone.bean.NoteBean r6 = (com.upuphone.ar.translation.phone.bean.NoteBean) r6
            java.lang.Object r7 = r0.L$4
            com.upuphone.ar.translation.phone.bean.NoteBean r7 = (com.upuphone.ar.translation.phone.bean.NoteBean) r7
            java.lang.Object r8 = r0.L$3
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r8 = (com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter) r8
            java.lang.Object r9 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r0.L$0
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r11 = (com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity) r11
            kotlin.ResultKt.throwOnFailure(r18)
            r4 = r18
            goto L_0x00b2
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r18)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r3 = r0.this$0
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r3 = r3.mAdapter
            if (r3 == 0) goto L_0x016d
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r12 = r0.this$0
            java.lang.String r6 = r0.$title
            kotlin.jvm.internal.Ref$BooleanRef r13 = r0.$isTitleUpdated
            kotlin.jvm.internal.Ref$BooleanRef r14 = r0.$isRecordUpdated
            com.upuphone.ar.translation.phone.bean.NoteBean r15 = r12.mNoteBean
            if (r15 == 0) goto L_0x00d0
            boolean r7 = r12.isListTitleUpdated()
            if (r7 == 0) goto L_0x0074
            r12.mOriginalRecordTitle = r6
            r15.setTitle(r6)
            r13.element = r1
        L_0x0074:
            boolean r6 = r12.isListRecordUpdated()
            if (r6 == 0) goto L_0x00ce
            java.lang.String r8 = r15.getSrcContent()
            java.lang.String r9 = r15.getDstContent()
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1 r10 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1$1$1$updateContent$1
            r16 = 0
            r6 = r10
            r7 = r12
            r4 = r10
            r10 = r3
            r5 = r11
            r11 = r16
            r6.<init>(r7, r8, r9, r10, r11)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.L$3 = r3
            r0.L$4 = r15
            r0.L$5 = r15
            r0.L$6 = r12
            r0.label = r1
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r5, r4, r0)
            if (r4 != r2) goto L_0x00ab
            return r2
        L_0x00ab:
            r8 = r3
            r3 = r12
            r11 = r3
            r10 = r13
            r9 = r14
            r6 = r15
            r7 = r6
        L_0x00b2:
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r5 = r4.getFirst()
            java.lang.String r5 = (java.lang.String) r5
            r6.setSrcContent(r5)
            java.lang.Object r4 = r4.getSecond()
            java.lang.String r4 = (java.lang.String) r4
            r6.setDstContent(r4)
            r9.element = r1
            r12 = r3
            r15 = r7
            r3 = r8
            r14 = r9
            r13 = r10
            goto L_0x00d2
        L_0x00ce:
            r11 = r12
            goto L_0x00d2
        L_0x00d0:
            r11 = r12
            r15 = 0
        L_0x00d2:
            r12.mNoteBean = r15
            java.util.List r4 = r3.getData()
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L_0x00df:
            if (r6 >= r4) goto L_0x0109
            java.util.List r7 = r3.getData()
            java.lang.Object r7 = r7.get(r6)
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r7 = (com.upuphone.ar.translation.phone.bean.NoteDetailBean) r7
            int r8 = r7.getNoteStatus()
            if (r1 > r8) goto L_0x00f5
            r9 = 3
            if (r8 >= r9) goto L_0x00f5
            goto L_0x00fc
        L_0x00f5:
            int r8 = r7.getEditStatus()
            if (r8 == r1) goto L_0x00fc
            goto L_0x0107
        L_0x00fc:
            r7.setEditStatus(r5)
            r7.setNoteStatus(r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            r3.j0(r6, r7)
        L_0x0107:
            int r6 = r6 + r1
            goto L_0x00df
        L_0x0109:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1$1$3 r3 = new com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1$1$3
            r4 = 0
            r3.<init>(r11, r4)
            r0.L$0 = r11
            r0.L$1 = r13
            r0.L$2 = r14
            r0.L$3 = r4
            r0.L$4 = r4
            r0.L$5 = r4
            r0.L$6 = r4
            r5 = 2
            r0.label = r5
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r1, r3, r0)
            if (r0 != r2) goto L_0x012b
            return r2
        L_0x012b:
            r0 = r11
            r2 = r13
            r1 = r14
        L_0x012e:
            com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding r3 = r0.mListHeadBinding
            if (r3 != 0) goto L_0x013b
            java.lang.String r3 = "mListHeadBinding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r5 = r4
            goto L_0x013c
        L_0x013b:
            r5 = r3
        L_0x013c:
            com.upuphone.ar.translation.phone.view.ClipboardEditText r3 = r5.b
            r3.j()
            com.upuphone.ar.translation.phone.bean.NoteBean r3 = r0.mNoteBean
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "updateListRecord mNoteBean="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "TranslatorRecordActivity"
            com.upuphone.ar.translation.ext.LogExt.j(r3, r4)
            com.upuphone.ar.translation.phone.bean.NoteBean r3 = r0.mNoteBean
            if (r3 == 0) goto L_0x016d
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r0 = r0.getMTranslatorRecordVm()
            boolean r2 = r2.element
            boolean r1 = r1.element
            r0.Y(r3, r2, r1)
        L_0x016d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateListRecord$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordActivity$updateListRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
