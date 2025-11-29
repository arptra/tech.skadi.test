package com.upuphone.datatrack.base.db;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.upuphone.datatrack.base.db.DataTrackDbHelper$deleteOverLimitCount$1", f = "DataTrackDbHelper.kt", i = {}, l = {86, 92, 94}, m = "invokeSuspend", n = {}, s = {})
public final class DataTrackDbHelper$deleteOverLimitCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxCount;
    final /* synthetic */ String $packageName;
    int label;
    final /* synthetic */ DataTrackDbHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackDbHelper$deleteOverLimitCount$1(DataTrackDbHelper dataTrackDbHelper, String str, int i, Continuation<? super DataTrackDbHelper$deleteOverLimitCount$1> continuation) {
        super(2, continuation);
        this.this$0 = dataTrackDbHelper;
        this.$packageName = str;
        this.$maxCount = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackDbHelper$deleteOverLimitCount$1(this.this$0, this.$packageName, this.$maxCount, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009c A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            java.lang.String r2 = "DataTrackDbHelper"
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r5) goto L_0x0024
            if (r1 == r4) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x009d
        L_0x0018:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0078
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003c
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r8)
            com.upuphone.datatrack.base.db.DataTrackDbHelper r8 = r7.this$0
            com.upuphone.datatrack.base.db.AppTrackDao r8 = r8.f()
            java.lang.String r1 = r7.$packageName
            r7.label = r5
            java.lang.Object r8 = r8.e(r1, r7)
            if (r8 != r0) goto L_0x003c
            return r0
        L_0x003c:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            int r1 = r7.$maxCount
            if (r8 <= r1) goto L_0x009d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "deleteOverLimitCount, rowCount: "
            r1.append(r5)
            r1.append(r8)
            java.lang.String r5 = ", maxCount: "
            r1.append(r5)
            int r5 = r7.$maxCount
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.upuphone.datatrack.base.utils.LogUtil.e(r2, r1)
            com.upuphone.datatrack.base.db.DataTrackDbHelper r1 = r7.this$0
            com.upuphone.datatrack.base.db.AppTrackDao r1 = r1.f()
            java.lang.String r5 = r7.$packageName
            int r6 = r7.$maxCount
            int r8 = r8 - r6
            r7.label = r4
            java.lang.Object r8 = r1.a(r5, r8, r7)
            if (r8 != r0) goto L_0x0078
            return r0
        L_0x0078:
            java.util.List r8 = (java.util.List) r8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "deleteOverLimitCount, deletedIds: "
            r1.append(r4)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.upuphone.datatrack.base.utils.LogUtil.e(r2, r1)
            com.upuphone.datatrack.base.db.DataTrackDbHelper r1 = r7.this$0
            com.upuphone.datatrack.base.db.AppTrackDao r1 = r1.f()
            r7.label = r3
            java.lang.Object r7 = r1.f(r8, r7)
            if (r7 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.datatrack.base.db.DataTrackDbHelper$deleteOverLimitCount$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataTrackDbHelper$deleteOverLimitCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
