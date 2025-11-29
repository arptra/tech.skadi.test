package com.upuphone.ar.translation.phone.fragment;

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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1", f = "TransRecordFragment.kt", i = {1}, l = {348, 367}, m = "invokeSuspend", n = {"noteBeanList"}, s = {"L$0"})
public final class TransRecordFragment$onLoadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    Object L$0;
    int label;
    final /* synthetic */ TransRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransRecordFragment$onLoadMoreData$1(TransRecordFragment transRecordFragment, int i, int i2, Continuation<? super TransRecordFragment$onLoadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = transRecordFragment;
        this.$pageIndex = i;
        this.$pageSize = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TransRecordFragment$onLoadMoreData$1(this.this$0, this.$pageIndex, this.$pageSize, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0137  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            java.lang.String r2 = "mRecycleHelper"
            r3 = 2
            java.lang.String r4 = "mRecordAdapter"
            java.lang.String r5 = "TransRecordFragment"
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x002a
            if (r1 == r6) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            java.lang.Object r0 = r10.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00f3
        L_0x001e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007a
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "onLoadMoreData inner"
            com.upuphone.ar.translation.ext.LogExt.j(r11, r5)
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r11 = r10.this$0
            com.upuphone.ar.translation.utils.RecycleHelper r11 = r11.c
            if (r11 != 0) goto L_0x003e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r11 = r7
        L_0x003e:
            boolean r11 = r11.c()
            if (r11 == 0) goto L_0x0066
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r10 = r10.this$0
            java.lang.String r10 = r10.b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "onLoadMoreData "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = " 无更多数据需要加载"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r10, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0066:
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1$noteBeanList$1 r1 = new com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1$noteBeanList$1
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r8 = r10.this$0
            r1.<init>(r8, r7)
            r10.label = r6
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r1, r10)
            if (r11 != r0) goto L_0x007a
            return r0
        L_0x007a:
            java.util.List r11 = (java.util.List) r11
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r1 = r10.this$0
            com.upuphone.ar.translation.phone.adapter.NoteListAdapter r1 = r1.d
            if (r1 != 0) goto L_0x0088
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r7
        L_0x0088:
            boolean r1 = r1.x0()
            if (r1 == 0) goto L_0x00c5
            boolean r1 = r11.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x00c5
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r1 = r10.this$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordShareViewModel r1 = r1.f
            java.lang.String r8 = "mRecordShareVm"
            if (r1 != 0) goto L_0x00a3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r1 = r7
        L_0x00a3:
            androidx.lifecycle.LiveData r1 = r1.h()
            java.lang.Object r1 = r1.getValue()
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            if (r1 == 0) goto L_0x00c5
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r1 = r10.this$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordShareViewModel r1 = r1.f
            if (r1 != 0) goto L_0x00c1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r1 = r7
        L_0x00c1:
            r8 = 0
            r1.m(r8)
        L_0x00c5:
            boolean r1 = r11.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x00db
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r1 = r10.this$0
            com.upuphone.ar.translation.phone.adapter.NoteListAdapter r1 = r1.d
            if (r1 != 0) goto L_0x00d8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r7
        L_0x00d8:
            r1.r(r11)
        L_0x00db:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1$dbRecordCount$1 r8 = new com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1$dbRecordCount$1
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r9 = r10.this$0
            r8.<init>(r9, r7)
            r10.L$0 = r11
            r10.label = r3
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.g(r1, r8, r10)
            if (r1 != r0) goto L_0x00f1
            return r0
        L_0x00f1:
            r0 = r11
            r11 = r1
        L_0x00f3:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r1 = r10.this$0
            com.upuphone.ar.translation.phone.adapter.NoteListAdapter r1 = r1.d
            if (r1 != 0) goto L_0x0105
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r7
        L_0x0105:
            int r1 = r1.getItemCount()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = "onLoadMoreData itemCount="
            r3.append(r8)
            r3.append(r1)
            java.lang.String r1 = ", dbRecordCount="
            r3.append(r1)
            r3.append(r11)
            java.lang.String r1 = r3.toString()
            com.upuphone.ar.translation.ext.LogExt.g(r1, r5)
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r1 = r10.this$0
            com.upuphone.ar.translation.phone.adapter.NoteListAdapter r1 = r1.d
            if (r1 != 0) goto L_0x0131
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r7
        L_0x0131:
            int r1 = r1.getItemCount()
            if (r1 < r11) goto L_0x0166
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r11 = r10.this$0
            java.lang.String r11 = r11.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "onLoadMoreData 已经加载出全部 "
            r1.append(r3)
            r1.append(r11)
            java.lang.String r11 = " 记录"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r11, r5)
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r11 = r10.this$0
            com.upuphone.ar.translation.utils.RecycleHelper r11 = r11.c
            if (r11 != 0) goto L_0x0162
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0163
        L_0x0162:
            r7 = r11
        L_0x0163:
            r7.i(r6)
        L_0x0166:
            com.upuphone.ar.translation.phone.fragment.TransRecordFragment r11 = r10.this$0
            int r1 = r10.$pageIndex
            int r10 = r10.$pageSize
            r11.showData(r0, r1, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.fragment.TransRecordFragment$onLoadMoreData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransRecordFragment$onLoadMoreData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
