package com.upuphone.xr.sapp.monitor.notification;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager$saveReminderScenesControlState$1", f = "SuperNotificationManager.kt", i = {}, l = {543}, m = "invokeSuspend", n = {}, s = {})
public final class SuperNotificationManager$saveReminderScenesControlState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperNotificationManager$saveReminderScenesControlState$1(boolean z, Continuation<? super SuperNotificationManager$saveReminderScenesControlState$1> continuation) {
        super(2, continuation);
        this.$state = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperNotificationManager$saveReminderScenesControlState$1(this.$state, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0086  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x000f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            boolean r1 = r6.$state
            kotlinx.coroutines.flow.MutableStateFlow r3 = com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager.j
            java.lang.Object r3 = r3.getValue()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "saveReminderScenesControlState state:"
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = " old:"
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
            java.lang.String r3 = "SuperNotificationManager"
            r7.a(r3, r1)
            boolean r7 = r6.$state
            kotlinx.coroutines.flow.MutableStateFlow r1 = com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager.j
            java.lang.Object r1 = r1.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r7 == r1) goto L_0x007f
            kotlinx.coroutines.flow.MutableStateFlow r7 = com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager.j
            boolean r1 = r6.$state
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r6.label = r2
            java.lang.Object r7 = r7.emit(r1, r6)
            if (r7 != r0) goto L_0x0069
            return r0
        L_0x0069:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r7 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r7 = r7.a()
            boolean r0 = r6.$state
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            java.lang.String r1 = "reminder_scenes_control_state_key"
            r7.p(r1, r0, r2)
            com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager r7 = com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager.f7749a
            r7.P()
        L_0x007f:
            boolean r6 = r6.$state
            if (r6 == 0) goto L_0x0086
            java.lang.String r6 = "1"
            goto L_0x0088
        L_0x0086:
            java.lang.String r6 = "0"
        L_0x0088:
            java.lang.String r7 = "status"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r7, r6)
            kotlin.Pair[] r6 = new kotlin.Pair[]{r6}
            java.util.HashMap r6 = kotlin.collections.MapsKt.hashMapOf(r6)
            com.upuphone.xr.sapp.context.SdkContext r7 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.DataTrackContext r7 = r7.d()
            java.lang.String r0 = "app_smart_notifications"
            r7.reportEvent(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager$saveReminderScenesControlState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperNotificationManager$saveReminderScenesControlState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
