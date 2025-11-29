package com.upuphone.ar.tici.phone;

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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciMainActivity$runDataMigrationAndLoadContent$1", f = "TiciMainActivity.kt", i = {0, 1, 1, 2}, l = {741, 750, 751}, m = "invokeSuspend", n = {"userId", "userId", "loadingDialog", "loadingDialog"}, s = {"L$0", "L$0", "L$1", "L$0"})
public final class TiciMainActivity$runDataMigrationAndLoadContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$runDataMigrationAndLoadContent$1(TiciMainActivity ticiMainActivity, Continuation<? super TiciMainActivity$runDataMigrationAndLoadContent$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiMainActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciMainActivity$runDataMigrationAndLoadContent$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a6  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "TiciMainActivity"
            if (r1 == 0) goto L_0x003a
            if (r1 == r4) goto L_0x0032
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r0 = r9.L$0
            com.meizu.common.app.LoadingDialog r0 = (com.meizu.common.app.LoadingDialog) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a7
        L_0x001d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0025:
            java.lang.Object r1 = r9.L$1
            com.meizu.common.app.LoadingDialog r1 = (com.meizu.common.app.LoadingDialog) r1
            java.lang.Object r3 = r9.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r1
            goto L_0x0097
        L_0x0032:
            java.lang.Object r1 = r9.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006f
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r1 = r10.g()
            if (r1 == 0) goto L_0x00b3
            int r7 = r1.length()
            if (r7 != 0) goto L_0x004c
            goto L_0x00b3
        L_0x004c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "runDataMigrationAndLoadContent, fillTiciEntityWithUserId, userId: "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r7, r6)
            com.upuphone.ar.tici.phone.db.TiciDao r10 = r10.w()
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r10.h(r1, r9)
            if (r10 != r0) goto L_0x006f
            return r0
        L_0x006f:
            boolean r10 = com.upuphone.ar.tici.phone.utils.SpUtilKt.m()
            if (r10 != 0) goto L_0x00b8
            java.lang.String r10 = "runDataMigrationAndLoadContent, start"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r10, r6)
            com.upuphone.ar.tici.phone.TiciMainActivity r10 = r9.this$0
            int r7 = com.upuphone.ar.tici.R.string.tici_loading
            java.lang.String r7 = r10.getString(r7)
            r8 = 0
            com.meizu.common.app.LoadingDialog r10 = com.meizu.common.app.LoadingDialog.show(r10, r5, r7, r8)
            com.upuphone.ar.tici.phone.utils.TiciHelper r7 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            r9.L$0 = r1
            r9.L$1 = r10
            r9.label = r3
            java.lang.Object r3 = r7.l(r9)
            if (r3 != r0) goto L_0x0096
            return r0
        L_0x0096:
            r3 = r1
        L_0x0097:
            com.upuphone.ar.tici.phone.utils.TiciHelper r1 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            r9.L$0 = r10
            r9.L$1 = r5
            r9.label = r2
            java.lang.Object r1 = r1.m(r3, r9)
            if (r1 != r0) goto L_0x00a6
            return r0
        L_0x00a6:
            r0 = r10
        L_0x00a7:
            com.upuphone.ar.tici.phone.utils.SpUtilKt.p(r4)
            r0.dismiss()
            java.lang.String r10 = "runDataMigrationAndLoadContent, end"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r10, r6)
            goto L_0x00b8
        L_0x00b3:
            java.lang.String r10 = "runDataMigrationAndLoadContent, userId is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r10, r6, r5, r3, r5)
        L_0x00b8:
            com.upuphone.ar.tici.phone.TiciMainActivity r9 = r9.this$0
            r9.B1()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciMainActivity$runDataMigrationAndLoadContent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciMainActivity$runDataMigrationAndLoadContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
