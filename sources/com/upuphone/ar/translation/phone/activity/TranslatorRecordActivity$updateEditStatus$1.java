package com.upuphone.ar.translation.phone.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateEditStatus$1", f = "TranslatorRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordActivity$updateEditStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $editType;
    final /* synthetic */ boolean $isContentUpdated;
    final /* synthetic */ boolean $recordEnableEdit;
    final /* synthetic */ boolean $titleEnableEdit;
    int label;
    final /* synthetic */ TranslatorRecordActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordActivity$updateEditStatus$1(TranslatorRecordActivity translatorRecordActivity, int i, boolean z, boolean z2, boolean z3, Continuation<? super TranslatorRecordActivity$updateEditStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorRecordActivity;
        this.$editType = i;
        this.$titleEnableEdit = z;
        this.$recordEnableEdit = z2;
        this.$isContentUpdated = z3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordActivity$updateEditStatus$1(this.this$0, this.$editType, this.$titleEnableEdit, this.$recordEnableEdit, this.$isContentUpdated, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r9 = r9.getDstLanguage();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r8.label
            if (r0 != 0) goto L_0x01e9
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = r9.mNoteBean
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x0020
            java.lang.String r9 = r9.getDstLanguage()
            if (r9 == 0) goto L_0x0020
            boolean r9 = kotlin.text.StringsKt.isBlank(r9)
            r9 = r9 ^ r0
            goto L_0x0021
        L_0x0020:
            r9 = r1
        L_0x0021:
            int r2 = r8.$editType
            boolean r3 = r8.$titleEnableEdit
            boolean r4 = r8.$recordEnableEdit
            boolean r5 = r8.$isContentUpdated
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "updateEditStatus editType="
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = ", titleEnableEdit="
            r6.append(r2)
            r6.append(r3)
            java.lang.String r2 = ", recordEnableEdit="
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = ", isContentUpdated="
            r6.append(r2)
            r6.append(r5)
            java.lang.String r2 = r6.toString()
            java.lang.String r3 = "TranslatorRecordActivity"
            com.upuphone.ar.translation.ext.LogExt.j(r2, r3)
            int r2 = r8.$editType
            r3 = 0
            java.lang.String r4 = "mBinding"
            if (r2 == r0) goto L_0x0126
            r5 = 2
            if (r2 == r5) goto L_0x0064
            goto L_0x01e6
        L_0x0064:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x0070
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
        L_0x0070:
            com.upuphone.ar.translation.phone.view.TransTitleBar r2 = r2.i
            boolean r5 = r8.$isContentUpdated
            r2.setTextMenuEnabled(r5)
            boolean r2 = r8.$recordEnableEdit
            if (r2 == 0) goto L_0x00c2
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r9 = r9.mBinding
            if (r9 != 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r9 = r3
        L_0x0087:
            com.upuphone.ar.translation.phone.view.TransTitleBar r9 = r9.i
            r9.setTextMenuVisible(r0)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r9 = r9.mBinding
            if (r9 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r9 = r3
        L_0x0098:
            com.upuphone.ar.translation.phone.view.TransTitleBar r9 = r9.i
            r9.setIconMenuVisible(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r9 = r9.mBinding
            if (r9 != 0) goto L_0x00a9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r9 = r3
        L_0x00a9:
            com.upuphone.ar.translation.phone.view.TransTitleBar r9 = r9.i
            r9.setIconMenu1Visible(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r8 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r8 = r8.mBinding
            if (r8 != 0) goto L_0x00ba
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x00bb
        L_0x00ba:
            r3 = r8
        L_0x00bb:
            com.upuphone.ar.translation.phone.view.TransTitleBar r8 = r3.i
            r8.setIconMenu2Visible(r1)
            goto L_0x01e6
        L_0x00c2:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x00ce
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
        L_0x00ce:
            com.upuphone.ar.translation.phone.view.TransTitleBar r2 = r2.i
            boolean r5 = r8.$titleEnableEdit
            if (r5 != 0) goto L_0x00db
            boolean r5 = r8.$isContentUpdated
            if (r5 == 0) goto L_0x00d9
            goto L_0x00db
        L_0x00d9:
            r5 = r1
            goto L_0x00dc
        L_0x00db:
            r5 = r0
        L_0x00dc:
            r2.setTextMenuVisible(r5)
            boolean r2 = r8.$titleEnableEdit
            if (r2 != 0) goto L_0x00e9
            boolean r2 = r8.$isContentUpdated
            if (r2 != 0) goto L_0x00e9
            r2 = r0
            goto L_0x00ea
        L_0x00e9:
            r2 = r1
        L_0x00ea:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r5 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r5 = r5.mBinding
            if (r5 != 0) goto L_0x00f6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r5 = r3
        L_0x00f6:
            com.upuphone.ar.translation.phone.view.TransTitleBar r5 = r5.i
            r5.setIconMenuVisible(r2)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r5 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r5 = r5.mBinding
            if (r5 != 0) goto L_0x0107
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r5 = r3
        L_0x0107:
            com.upuphone.ar.translation.phone.view.TransTitleBar r5 = r5.i
            if (r2 == 0) goto L_0x010e
            if (r9 == 0) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r0 = r1
        L_0x010f:
            r5.setIconMenu1Visible(r0)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r8 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r8 = r8.mBinding
            if (r8 != 0) goto L_0x011e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x011f
        L_0x011e:
            r3 = r8
        L_0x011f:
            com.upuphone.ar.translation.phone.view.TransTitleBar r8 = r3.i
            r8.setIconMenu2Visible(r2)
            goto L_0x01e6
        L_0x0126:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x0132
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
        L_0x0132:
            com.upuphone.ar.translation.phone.view.TransTitleBar r2 = r2.i
            boolean r5 = r8.$isContentUpdated
            r2.setTextMenuEnabled(r5)
            boolean r2 = r8.$titleEnableEdit
            if (r2 == 0) goto L_0x0184
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r9 = r9.mBinding
            if (r9 != 0) goto L_0x0149
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r9 = r3
        L_0x0149:
            com.upuphone.ar.translation.phone.view.TransTitleBar r9 = r9.i
            r9.setTextMenuVisible(r0)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r9 = r9.mBinding
            if (r9 != 0) goto L_0x015a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r9 = r3
        L_0x015a:
            com.upuphone.ar.translation.phone.view.TransTitleBar r9 = r9.i
            r9.setIconMenuVisible(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r9 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r9 = r9.mBinding
            if (r9 != 0) goto L_0x016b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r9 = r3
        L_0x016b:
            com.upuphone.ar.translation.phone.view.TransTitleBar r9 = r9.i
            r9.setIconMenu1Visible(r1)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r8 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r8 = r8.mBinding
            if (r8 != 0) goto L_0x017c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x017d
        L_0x017c:
            r3 = r8
        L_0x017d:
            com.upuphone.ar.translation.phone.view.TransTitleBar r8 = r3.i
            r8.setIconMenu2Visible(r1)
            goto L_0x01e6
        L_0x0184:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r2 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r2 = r2.mBinding
            if (r2 != 0) goto L_0x0190
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
        L_0x0190:
            com.upuphone.ar.translation.phone.view.TransTitleBar r2 = r2.i
            boolean r5 = r8.$recordEnableEdit
            if (r5 != 0) goto L_0x019d
            boolean r5 = r8.$isContentUpdated
            if (r5 == 0) goto L_0x019b
            goto L_0x019d
        L_0x019b:
            r5 = r1
            goto L_0x019e
        L_0x019d:
            r5 = r0
        L_0x019e:
            r2.setTextMenuVisible(r5)
            boolean r2 = r8.$recordEnableEdit
            if (r2 != 0) goto L_0x01ab
            boolean r2 = r8.$isContentUpdated
            if (r2 != 0) goto L_0x01ab
            r2 = r0
            goto L_0x01ac
        L_0x01ab:
            r2 = r1
        L_0x01ac:
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r5 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r5 = r5.mBinding
            if (r5 != 0) goto L_0x01b8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r5 = r3
        L_0x01b8:
            com.upuphone.ar.translation.phone.view.TransTitleBar r5 = r5.i
            r5.setIconMenuVisible(r2)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r5 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r5 = r5.mBinding
            if (r5 != 0) goto L_0x01c9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r5 = r3
        L_0x01c9:
            com.upuphone.ar.translation.phone.view.TransTitleBar r5 = r5.i
            if (r2 == 0) goto L_0x01d0
            if (r9 == 0) goto L_0x01d0
            goto L_0x01d1
        L_0x01d0:
            r0 = r1
        L_0x01d1:
            r5.setIconMenu1Visible(r0)
            com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity r8 = r8.this$0
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r8 = r8.mBinding
            if (r8 != 0) goto L_0x01e0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x01e1
        L_0x01e0:
            r3 = r8
        L_0x01e1:
            com.upuphone.ar.translation.phone.view.TransTitleBar r8 = r3.i
            r8.setIconMenu2Visible(r2)
        L_0x01e6:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x01e9:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity$updateEditStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordActivity$updateEditStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
