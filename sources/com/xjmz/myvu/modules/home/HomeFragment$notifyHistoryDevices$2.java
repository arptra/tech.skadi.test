package com.xjmz.myvu.modules.home;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import java.util.List;
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
@DebugMetadata(c = "com.xjmz.myvu.modules.home.HomeFragment$notifyHistoryDevices$2", f = "HomeFragment.kt", i = {0, 0, 1}, l = {333, 337}, m = "invokeSuspend", n = {"$this$launch", "it", "$this$launch"}, s = {"L$0", "I$2", "L$0"})
public final class HomeFragment$notifyHistoryDevices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AndroidConnectApi.DeviceInfo> $devices;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$notifyHistoryDevices$2(HomeFragment homeFragment, List<AndroidConnectApi.DeviceInfo> list, Continuation<? super HomeFragment$notifyHistoryDevices$2> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
        this.$devices = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        HomeFragment$notifyHistoryDevices$2 homeFragment$notifyHistoryDevices$2 = new HomeFragment$notifyHistoryDevices$2(this.this$0, this.$devices, continuation);
        homeFragment$notifyHistoryDevices$2.L$0 = obj;
        return homeFragment$notifyHistoryDevices$2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d5  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            java.lang.String r2 = "HomeFragment"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r4) goto L_0x002d
            if (r1 != r3) goto L_0x0025
            int r1 = r14.I$1
            int r5 = r14.I$0
            java.lang.Object r6 = r14.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r14.L$1
            com.xjmz.myvu.modules.home.HomeFragment r7 = (com.xjmz.myvu.modules.home.HomeFragment) r7
            java.lang.Object r8 = r14.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d0
        L_0x0025:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x002d:
            int r1 = r14.I$2
            int r5 = r14.I$1
            int r6 = r14.I$0
            java.lang.Object r7 = r14.L$2
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r14.L$1
            com.xjmz.myvu.modules.home.HomeFragment r8 = (com.xjmz.myvu.modules.home.HomeFragment) r8
            java.lang.Object r9 = r14.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0090
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            int r1 = com.xjmz.myvu.modules.home.HomeFragment.q
            com.xjmz.myvu.modules.home.HomeFragment r5 = r14.this$0
            java.util.List<com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo> r6 = r14.$devices
            r7 = 0
            r13 = r5
            r5 = r1
            r1 = r7
            r7 = r6
            r6 = r13
        L_0x0058:
            if (r1 >= r5) goto L_0x00e9
            boolean r8 = kotlinx.coroutines.CoroutineScopeKt.h(r15)
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "notifyHistoryDevices() star isActive:"
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            r9.g(r2, r10)
            if (r8 == 0) goto L_0x00e6
            r14.L$0 = r15
            r14.L$1 = r6
            r14.L$2 = r7
            r14.I$0 = r5
            r14.I$1 = r1
            r14.I$2 = r1
            r14.label = r4
            java.lang.Object r8 = r6.i1(r7, r14)
            if (r8 != r0) goto L_0x008b
            return r0
        L_0x008b:
            r9 = r15
            r15 = r8
            r8 = r6
            r6 = r5
            r5 = r1
        L_0x0090:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "notifyHistoryDevices() sendHistory"
            r11.append(r12)
            r11.append(r15)
            java.lang.String r12 = " "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r1 = r11.toString()
            r10.g(r2, r1)
            if (r15 != 0) goto L_0x00d5
            r14.L$0 = r9
            r14.L$1 = r8
            r14.L$2 = r7
            r14.I$0 = r6
            r14.I$1 = r5
            r14.label = r3
            r10 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r10, r14)
            if (r15 != r0) goto L_0x00cb
            return r0
        L_0x00cb:
            r1 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
        L_0x00d0:
            r15 = r8
            r13 = r7
            r7 = r6
            r6 = r13
            goto L_0x00e6
        L_0x00d5:
            kotlinx.coroutines.Job r15 = r8.i
            r1 = 0
            if (r15 == 0) goto L_0x00df
            kotlinx.coroutines.Job.DefaultImpls.a(r15, r1, r4, r1)
        L_0x00df:
            r8.i = r1
            r1 = r5
            r5 = r6
            r6 = r8
            r15 = r9
        L_0x00e6:
            int r1 = r1 + r4
            goto L_0x0058
        L_0x00e9:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.modules.home.HomeFragment$notifyHistoryDevices$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HomeFragment$notifyHistoryDevices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
