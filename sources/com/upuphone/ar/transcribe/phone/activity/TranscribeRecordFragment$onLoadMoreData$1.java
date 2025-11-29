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

@SourceDebugExtension({"SMAP\nTranscribeRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$onLoadMoreData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,488:1\n1620#2,3:489\n*S KotlinDebug\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$onLoadMoreData$1\n*L\n277#1:489,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$onLoadMoreData$1", f = "TranscribeRecordFragment.kt", i = {1}, l = {271, 282}, m = "invokeSuspend", n = {"noteBeanList"}, s = {"L$0"})
public final class TranscribeRecordFragment$onLoadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    Object L$0;
    int label;
    final /* synthetic */ TranscribeRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeRecordFragment$onLoadMoreData$1(TranscribeRecordFragment transcribeRecordFragment, int i, int i2, Continuation<? super TranscribeRecordFragment$onLoadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeRecordFragment;
        this.$pageIndex = i;
        this.$pageSize = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeRecordFragment$onLoadMoreData$1(this.this$0, this.$pageIndex, this.$pageSize, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010f  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            java.lang.String r2 = "recycleHelper"
            r3 = 2
            java.lang.String r4 = "TransRecordFragment"
            java.lang.String r5 = "recordAdapter"
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x002a
            if (r1 == r6) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            java.lang.Object r0 = r12.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00cb
        L_0x001e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005b
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r13 = r12.this$0
            com.upuphone.ar.transcribe.utils.RecycleHelper r13 = r13.recycleHelper
            if (r13 != 0) goto L_0x0039
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r13 = r7
        L_0x0039:
            boolean r13 = r13.c()
            if (r13 == 0) goto L_0x0047
            java.lang.String r12 = "onLoadMoreData 转写 无更多数据需要加载"
            com.upuphone.ar.transcribe.ext.LogExt.g(r12, r4)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0047:
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$onLoadMoreData$1$noteBeanList$1 r1 = new com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$onLoadMoreData$1$noteBeanList$1
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r8 = r12.this$0
            r1.<init>(r8, r7)
            r12.label = r6
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.g(r13, r1, r12)
            if (r13 != r0) goto L_0x005b
            return r0
        L_0x005b:
            java.util.List r13 = (java.util.List) r13
            boolean r1 = r13.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x00b3
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r1 = r12.this$0
            com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter r1 = r1.recordAdapter
            if (r1 != 0) goto L_0x0070
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r7
        L_0x0070:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r9 = r12.this$0
            java.util.Iterator r10 = r13.iterator()
        L_0x007b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x008f
            java.lang.Object r11 = r10.next()
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r11 = (com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean) r11
            com.upuphone.ar.transcribe.phone.bean.ListItemBean r11 = r9.toItemBean(r11)
            r8.add(r11)
            goto L_0x007b
        L_0x008f:
            r1.r(r8)
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r1 = r12.this$0
            com.upuphone.ar.transcribe.phone.vm.TranscribeEditViewModel r1 = r1.editViewModel
            if (r1 != 0) goto L_0x00a0
            java.lang.String r1 = "editViewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r7
        L_0x00a0:
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r8 = r12.this$0
            com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter r8 = r8.recordAdapter
            if (r8 != 0) goto L_0x00ac
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r8 = r7
        L_0x00ac:
            int r8 = r8.getItemCount()
            r1.x(r8)
        L_0x00b3:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$onLoadMoreData$1$dbRecordCount$1 r8 = new com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$onLoadMoreData$1$dbRecordCount$1
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r9 = r12.this$0
            r8.<init>(r9, r7)
            r12.L$0 = r13
            r12.label = r3
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.g(r1, r8, r12)
            if (r1 != r0) goto L_0x00c9
            return r0
        L_0x00c9:
            r0 = r13
            r13 = r1
        L_0x00cb:
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r1 = r12.this$0
            com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter r1 = r1.recordAdapter
            if (r1 != 0) goto L_0x00dd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r7
        L_0x00dd:
            int r1 = r1.getItemCount()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = "onLoadMoreData itemCount="
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = ", dbRecordCount="
            r3.append(r1)
            r3.append(r13)
            java.lang.String r1 = r3.toString()
            com.upuphone.ar.transcribe.ext.LogExt.d(r1, r4)
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r1 = r12.this$0
            com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter r1 = r1.recordAdapter
            if (r1 != 0) goto L_0x0109
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r7
        L_0x0109:
            int r1 = r1.getItemCount()
            if (r1 < r13) goto L_0x0124
            java.lang.String r13 = "onLoadMoreData 已经加载出全部 转写记录"
            com.upuphone.ar.transcribe.ext.LogExt.g(r13, r4)
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r13 = r12.this$0
            com.upuphone.ar.transcribe.utils.RecycleHelper r13 = r13.recycleHelper
            if (r13 != 0) goto L_0x0120
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0121
        L_0x0120:
            r7 = r13
        L_0x0121:
            r7.i(r6)
        L_0x0124:
            com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment r13 = r12.this$0
            int r1 = r12.$pageIndex
            int r12 = r12.$pageSize
            r13.showData(r0, r1, r12)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment$onLoadMoreData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeRecordFragment$onLoadMoreData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
