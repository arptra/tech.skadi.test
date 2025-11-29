package com.xjmz.myvu.permissions;

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
@DebugMetadata(c = "com.xjmz.myvu.permissions.PermissionAndStateHelper$checkView$1", f = "PermissionAndStateHelper.kt", i = {}, l = {139, 142}, m = "invokeSuspend", n = {}, s = {})
public final class PermissionAndStateHelper$checkView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PermissionAndStateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionAndStateHelper$checkView$1(PermissionAndStateHelper permissionAndStateHelper, Continuation<? super PermissionAndStateHelper$checkView$1> continuation) {
        super(2, continuation);
        this.this$0 = permissionAndStateHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PermissionAndStateHelper$checkView$1(this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        r11 = com.upuphone.star.core.log.ULog.f6446a;
        r11.c("PermissionAndStateHelper", "checkPermissionAndState, error: " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r3) goto L_0x000e
            if (r1 != r2) goto L_0x0017
        L_0x000e:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            goto L_0x0093
        L_0x0013:
            r10 = move-exception
            goto L_0x007a
        L_0x0015:
            r10 = move-exception
            goto L_0x007b
        L_0x0017:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r11)
            com.upuphone.xr.sapp.utils.PhoneTypeUtils r11 = com.upuphone.xr.sapp.utils.PhoneTypeUtils.f7912a     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            boolean r11 = r11.d()     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            if (r11 == 0) goto L_0x006f
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r11 = com.upuphone.xr.sapp.utils.DataStoreUtils.e     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            com.upuphone.xr.sapp.utils.DataStoreUtils r4 = r11.a()     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            java.lang.String r5 = "notification_permission_huawei"
            r1 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            r8 = 4
            r9 = 0
            r7 = 0
            java.lang.Object r1 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            if (r1 != 0) goto L_0x0093
            com.upuphone.xr.sapp.utils.DataStoreUtils r11 = r11.a()     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            java.lang.String r1 = "notification_permission_huawei"
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            r11.o(r1, r2)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            com.xjmz.myvu.permissions.PermissionAndStateHelper r11 = r10.this$0     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            androidx.fragment.app.FragmentActivity r11 = r11.q()     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            java.lang.String r1 = "android.permission.POST_NOTIFICATIONS"
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            r2 = 100
            r11.requestPermissions(r1, r2)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            r10.label = r3     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            r1 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r1, r10)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x006f:
            com.xjmz.myvu.permissions.PermissionAndStateHelper r11 = r10.this$0     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            r10.label = r2     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            java.lang.Object r10 = r11.y(r10)     // Catch:{ Exception -> 0x0015, all -> 0x0013 }
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x007a:
            throw r10
        L_0x007b:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "PermissionAndStateHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkPermissionAndState, error: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r11.c(r0, r10)
        L_0x0093:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper$checkView$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PermissionAndStateHelper$checkView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
