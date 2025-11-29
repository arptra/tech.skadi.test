package com.upuphone.ar.transcribe.phone.activity;

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

@SourceDebugExtension({"SMAP\nTranscribeDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeDetailActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity$initData$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,683:1\n262#2,2:684\n262#2,2:686\n262#2,2:688\n262#2,2:690\n262#2,2:692\n262#2,2:694\n262#2,2:696\n262#2,2:700\n262#2,2:702\n1855#3,2:698\n1864#3,3:704\n*S KotlinDebug\n*F\n+ 1 TranscribeDetailActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity$initData$1\n*L\n237#1:684,2\n258#1:686,2\n259#1:688,2\n264#1:690,2\n265#1:692,2\n275#1:694,2\n276#1:696,2\n284#1:700,2\n285#1:702,2\n278#1:698,2\n287#1:704,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1", f = "TranscribeDetailActivity.kt", i = {}, l = {227, 270}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeDetailActivity$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    final /* synthetic */ long $searchId;
    Object L$0;
    int label;
    final /* synthetic */ TranscribeDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeDetailActivity$initData$1(long j, TranscribeDetailActivity transcribeDetailActivity, long j2, Continuation<? super TranscribeDetailActivity$initData$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = transcribeDetailActivity;
        this.$searchId = j2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeDetailActivity$initData$1(this.$recordId, this.this$0, this.$searchId, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02e5  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            java.lang.String r4 = "nsvText"
            java.lang.String r5 = "nsvList"
            r6 = 8
            r7 = 0
            r8 = 1
            java.lang.String r9 = "TranscribeDetailActivity"
            java.lang.String r10 = "mBinding"
            r11 = 0
            if (r2 == 0) goto L_0x0035
            if (r2 == r8) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            kotlin.ResultKt.throwOnFailure(r23)
            r2 = r23
            goto L_0x025b
        L_0x0023:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002b:
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r2 = (com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity) r2
            kotlin.ResultKt.throwOnFailure(r23)
            r12 = r23
            goto L_0x0068
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r23)
            long r12 = r0.$recordId
            r14 = -1
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x0049
            java.lang.String r0 = "无效的翻译记录id"
            com.upuphone.ar.transcribe.ext.LogExt.g(r0, r9)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0049:
            com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper r2 = com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper.f6108a
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            r2.n(r12)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r2 = r0.this$0
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1$1 r13 = new com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1$1
            long r14 = r0.$recordId
            r13.<init>(r14, r11)
            r0.L$0 = r2
            r0.label = r8
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.g(r12, r13, r0)
            if (r12 != r1) goto L_0x0068
            return r1
        L_0x0068:
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r12 = (com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean) r12
            r2.mTranscribeBean = r12
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r2 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r2 = r2.mTranscribeBean
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "NoteBean="
            r12.append(r13)
            r12.append(r2)
            java.lang.String r2 = r12.toString()
            com.upuphone.ar.transcribe.ext.LogExt.g(r2, r9)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r2 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r2 = r2.mTranscribeBean
            if (r2 == 0) goto L_0x0094
            java.lang.String r2 = r2.getTransResult()
            goto L_0x0095
        L_0x0094:
            r2 = r11
        L_0x0095:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "srcContent="
            r12.append(r13)
            r12.append(r2)
            java.lang.String r13 = " \n"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.upuphone.ar.transcribe.ext.LogExt.g(r12, r9)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            java.util.List r12 = r12.mNoteDetailBeans
            r12.clear()
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x00c3:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r12 = r12.m
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r13 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r13 = r13.mTranscribeBean
            if (r13 == 0) goto L_0x00d3
            java.lang.String r13 = r13.getSuperTitle()
            if (r13 != 0) goto L_0x00e0
        L_0x00d3:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r13 = r0.this$0
            int r14 = com.upuphone.ar.transcribe.R.string.transcribe_app_name
            java.lang.String r13 = r13.getString(r14)
            java.lang.String r14 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
        L_0x00e0:
            r12.setText(r13)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r12 = r12.mTranscribeBean
            if (r12 == 0) goto L_0x00f0
            java.lang.String r12 = r12.getFullLocation()
            goto L_0x00f1
        L_0x00f0:
            r12 = r11
        L_0x00f1:
            if (r12 == 0) goto L_0x011a
            int r12 = r12.length()
            if (r12 != 0) goto L_0x00fa
            goto L_0x011a
        L_0x00fa:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0106
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x0106:
            android.widget.TextView r12 = r12.j
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r13 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r13 = r13.mTranscribeBean
            if (r13 == 0) goto L_0x0115
            java.lang.String r13 = r13.getFullLocation()
            goto L_0x0116
        L_0x0115:
            r13 = r11
        L_0x0116:
            r12.setText(r13)
            goto L_0x0130
        L_0x011a:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0126
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x0126:
            androidx.constraintlayout.widget.Group r12 = r12.e
            java.lang.String r13 = "locationGroup"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r12.setVisibility(r6)
        L_0x0130:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x013c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x013c:
            android.widget.TextView r12 = r12.l
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r13 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r14 = r13.mTranscribeBean
            if (r14 == 0) goto L_0x014b
            long r14 = r14.getRecordTime()
            goto L_0x014d
        L_0x014b:
            r14 = 0
        L_0x014d:
            java.lang.String r13 = com.upuphone.ar.transcribe.utils.DateUtils.l(r13, r14)
            r12.setText(r13)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r12 = r12.mTranscribeBean
            if (r12 == 0) goto L_0x0161
            java.lang.String r12 = r12.getRecognizeId()
            goto L_0x0162
        L_0x0161:
            r12 = r11
        L_0x0162:
            if (r12 == 0) goto L_0x019b
            boolean r12 = kotlin.text.StringsKt.isBlank(r12)
            if (r12 == 0) goto L_0x016b
            goto L_0x019b
        L_0x016b:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            boolean r12 = r12.isSupportAi()
            if (r12 != 0) goto L_0x0187
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x017f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x017f:
            com.upuphone.ar.transcribe.phone.view.TransTitleBar r12 = r12.i
            int r13 = com.upuphone.ar.transcribe.R.drawable.ai_menu_icon_disable
            r12.setIconMenu2(r13)
            goto L_0x01ac
        L_0x0187:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x0193
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x0193:
            com.upuphone.ar.transcribe.phone.view.TransTitleBar r12 = r12.i
            int r13 = com.upuphone.ar.transcribe.R.drawable.ai_menu_icon
            r12.setIconMenu2(r13)
            goto L_0x01ac
        L_0x019b:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r12 = r12.mBinding
            if (r12 != 0) goto L_0x01a7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r12 = r11
        L_0x01a7:
            com.upuphone.ar.transcribe.phone.view.TransTitleBar r12 = r12.i
            r12.setIconMenu2Visible(r7)
        L_0x01ac:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r13 = r12.mTranscribeBean
            if (r13 == 0) goto L_0x01b9
            int r13 = r13.getType()
            goto L_0x01ba
        L_0x01b9:
            r13 = r8
        L_0x01ba:
            r12.transType = r13
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r12 = r0.this$0
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r12 = r12.mTranscribeBean
            if (r12 == 0) goto L_0x0245
            java.lang.String r12 = r12.getTransResult()
            if (r12 == 0) goto L_0x0245
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x0245
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            int r1 = r1.transType
            if (r1 != r8) goto L_0x020f
            java.lang.String r1 = "普通转写类型"
            com.upuphone.ar.transcribe.ext.LogExt.g(r1, r9)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x01eb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = r11
        L_0x01eb:
            androidx.core.widget.NestedScrollView r1 = r1.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r1.setVisibility(r6)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x01ff
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L_0x0200
        L_0x01ff:
            r11 = r1
        L_0x0200:
            androidx.core.widget.NestedScrollView r1 = r11.g
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r1.setVisibility(r7)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r0.this$0
            r0.analysisAirData(r2)
            goto L_0x03f3
        L_0x020f:
            java.lang.String r1 = "电话转写类型"
            com.upuphone.ar.transcribe.ext.LogExt.g(r1, r9)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0221
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = r11
        L_0x0221:
            androidx.core.widget.NestedScrollView r1 = r1.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r1.setVisibility(r7)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0235
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L_0x0236
        L_0x0235:
            r11 = r1
        L_0x0236:
            androidx.core.widget.NestedScrollView r1 = r11.g
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r1.setVisibility(r6)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r0.this$0
            r0.analysisData(r2)
            goto L_0x03f3
        L_0x0245:
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1$messages$1 r12 = new com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1$messages$1
            long r13 = r0.$recordId
            r12.<init>(r13, r11)
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.g(r2, r12, r0)
            if (r2 != r1) goto L_0x025b
            return r1
        L_0x025b:
            java.util.List r2 = (java.util.List) r2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "message: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.transcribe.ext.LogExt.g(r1, r9)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            int r1 = r1.transType
            if (r1 != r8) goto L_0x02e5
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0285
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = r11
        L_0x0285:
            androidx.core.widget.NestedScrollView r1 = r1.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r1.setVisibility(r6)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0299
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = r11
        L_0x0299:
            androidx.core.widget.NestedScrollView r1 = r1.g
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r1.setVisibility(r7)
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            r1.<init>()
            java.util.Iterator r3 = r2.iterator()
        L_0x02aa:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02c2
            java.lang.Object r4 = r3.next()
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r4 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r4
            java.lang.String r4 = r4.getMessage()
            java.lang.String r4 = com.upuphone.ar.transcribe.ext.StringExtKt.a(r4)
            r1.append(r4)
            goto L_0x02aa
        L_0x02c2:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r3 = r0.this$0
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r2 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r2
            r3.updatingMessage = r2
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x02d9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L_0x02da
        L_0x02d9:
            r11 = r0
        L_0x02da:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r0 = r11.k
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            goto L_0x03f3
        L_0x02e5:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x02f1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = r11
        L_0x02f1:
            androidx.core.widget.NestedScrollView r1 = r1.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r1.setVisibility(r7)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r1 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = r1.mBinding
            if (r1 != 0) goto L_0x0305
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r1 = r11
        L_0x0305:
            androidx.core.widget.NestedScrollView r1 = r1.g
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r1.setVisibility(r6)
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            r3 = -1
            r1.element = r3
            long r4 = r0.$searchId
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r6 = r0.this$0
            java.util.Iterator r8 = r2.iterator()
        L_0x031d:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x038a
            java.lang.Object r12 = r8.next()
            int r13 = r7 + 1
            if (r7 >= 0) goto L_0x032e
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x032e:
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r12 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r12
            com.upuphone.ar.transcribe.phone.bean.NoteDetailBean r15 = new com.upuphone.ar.transcribe.phone.bean.NoteDetailBean
            r19 = 15
            r20 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r21 = 0
            r14 = r15
            r11 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r21
            r14.<init>(r15, r16, r17, r18, r19, r20)
            java.lang.Long r14 = r12.getId()
            r11.setId(r14)
            long r14 = r12.getTimestamp()
            java.lang.String r14 = com.upuphone.ar.transcribe.utils.DateUtils.c(r14)
            r11.setTimestamp(r14)
            java.lang.String r14 = r12.getMessage()
            java.lang.String r14 = com.upuphone.ar.transcribe.ext.StringExtKt.a(r14)
            r11.setContent(r14)
            int r14 = r12.getOwner()
            r11.setOwnerType(r14)
            java.lang.Long r12 = r12.getId()
            if (r12 != 0) goto L_0x0376
            goto L_0x0380
        L_0x0376:
            long r14 = r12.longValue()
            int r12 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r12 != 0) goto L_0x0380
            r1.element = r7
        L_0x0380:
            java.util.List r7 = r6.mNoteDetailBeans
            r7.add(r11)
            r7 = r13
            r11 = 0
            goto L_0x031d
        L_0x038a:
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r4 = r0.this$0
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r2 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r2
            r4.updatingMessage = r2
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r2 = r0.this$0
            java.util.List r2 = r2.mNoteDetailBeans
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "data: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.upuphone.ar.transcribe.ext.LogExt.d(r2, r9)
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r2 = r0.this$0
            com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter r2 = r2.mAdapter
            if (r2 == 0) goto L_0x03ba
            r2.notifyDataSetChanged()
        L_0x03ba:
            int r2 = r1.element
            long r4 = r0.$searchId
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "scroll position: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = ", searchId: "
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = r6.toString()
            com.upuphone.ar.transcribe.ext.LogExt.d(r2, r9)
            int r2 = r1.element
            if (r2 == r3) goto L_0x03f3
            com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity r0 = r0.this$0
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r0 = r0.mBinding
            if (r0 != 0) goto L_0x03eb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r11 = 0
            goto L_0x03ec
        L_0x03eb:
            r11 = r0
        L_0x03ec:
            androidx.recyclerview.widget.RecyclerView r0 = r11.h
            int r1 = r1.element
            r0.scrollToPosition(r1)
        L_0x03f3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeDetailActivity$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
