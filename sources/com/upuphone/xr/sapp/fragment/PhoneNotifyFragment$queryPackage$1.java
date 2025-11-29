package com.upuphone.xr.sapp.fragment;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1", f = "PhoneNotifyFragment.kt", i = {0, 1}, l = {357, 361, 363}, m = "invokeSuspend", n = {"starTime", "dataList"}, s = {"J$0", "L$0"})
public final class PhoneNotifyFragment$queryPackage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $animTime;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PhoneNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNotifyFragment$queryPackage$1(int i, PhoneNotifyFragment phoneNotifyFragment, Continuation<? super PhoneNotifyFragment$queryPackage$1> continuation) {
        super(2, continuation);
        this.$animTime = i;
        this.this$0 = phoneNotifyFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PhoneNotifyFragment$queryPackage$1 phoneNotifyFragment$queryPackage$1 = new PhoneNotifyFragment$queryPackage$1(this.$animTime, this.this$0, continuation);
        phoneNotifyFragment$queryPackage$1.L$0 = obj;
        return phoneNotifyFragment$queryPackage$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b8 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x002e
            if (r1 == r4) goto L_0x0028
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b9
        L_0x0017:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x001f:
            java.lang.Object r1 = r14.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00a3
        L_0x0028:
            long r6 = r14.J$0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0055
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r6 = r15
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            long r12 = java.lang.System.currentTimeMillis()
            com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1$async$1 r9 = new com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1$async$1
            com.upuphone.xr.sapp.fragment.PhoneNotifyFragment r15 = r14.this$0
            r9.<init>(r15, r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r15 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r6, r7, r8, r9, r10, r11)
            r14.J$0 = r12
            r14.label = r4
            java.lang.Object r15 = r15.c(r14)
            if (r15 != r0) goto L_0x0054
            return r0
        L_0x0054:
            r6 = r12
        L_0x0055:
            r1 = r15
            java.util.List r1 = (java.util.List) r1
            long r8 = java.lang.System.currentTimeMillis()
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            long r10 = r8 - r6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r12 = "-----starTime:"
            r4.append(r12)
            r4.append(r6)
            java.lang.String r6 = "   endTime:"
            r4.append(r6)
            r4.append(r8)
            java.lang.String r6 = "--"
            r4.append(r6)
            r4.append(r10)
            java.lang.String r6 = "-"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = "PhoneNotifyFragment"
            r15.g(r6, r4)
            int r15 = r14.$animTime
            long r6 = (long) r15
            int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00a3
            long r6 = (long) r15
            long r6 = r6 - r10
            r15 = 10
            long r8 = (long) r15
            long r6 = r6 + r8
            r14.L$0 = r1
            r14.label = r3
            java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r6, r14)
            if (r15 != r0) goto L_0x00a3
            return r0
        L_0x00a3:
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1$1 r3 = new com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1$1
            com.upuphone.xr.sapp.fragment.PhoneNotifyFragment r4 = r14.this$0
            r3.<init>(r4, r1, r5)
            r14.L$0 = r5
            r14.label = r2
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r15, r3, r14)
            if (r14 != r0) goto L_0x00b9
            return r0
        L_0x00b9:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PhoneNotifyFragment$queryPackage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
