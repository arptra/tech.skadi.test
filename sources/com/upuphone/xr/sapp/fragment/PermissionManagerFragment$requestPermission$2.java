package com.upuphone.xr.sapp.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.entity.PermissionNote;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.PermissionManagerFragment$requestPermission$2", f = "PermissionManagerFragment.kt", i = {}, l = {889, 897}, m = "invokeSuspend", n = {}, s = {})
public final class PermissionManagerFragment$requestPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $jumpAction;
    final /* synthetic */ PermissionNote $permissionNote;
    final /* synthetic */ String[] $permissions;
    final /* synthetic */ PermissionNote $rejectPermissionNote;
    final /* synthetic */ int $rejectWindowType;
    final /* synthetic */ FragmentActivity $safeActivity;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionManagerFragment$requestPermission$2(String[] strArr, PermissionNote permissionNote, FragmentActivity fragmentActivity, int i, PermissionNote permissionNote2, Function0<Unit> function0, Continuation<? super PermissionManagerFragment$requestPermission$2> continuation) {
        super(2, continuation);
        this.$permissions = strArr;
        this.$permissionNote = permissionNote;
        this.$safeActivity = fragmentActivity;
        this.$rejectWindowType = i;
        this.$rejectPermissionNote = permissionNote2;
        this.$jumpAction = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PermissionManagerFragment$requestPermission$2(this.$permissions, this.$permissionNote, this.$safeActivity, this.$rejectWindowType, this.$rejectPermissionNote, this.$jumpAction, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            java.lang.String r4 = "PermissionManagerFragment"
            if (r1 == 0) goto L_0x0021
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0097
        L_0x0015:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0061
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String[] r1 = r13.$permissions
            com.upuphone.xr.sapp.entity.PermissionNote r5 = r13.$permissionNote
            if (r5 == 0) goto L_0x0031
            java.lang.String r5 = r5.getTitle()
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestPermission, permissions: "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r1 = ", permissionTitle: "
            r6.append(r1)
            r6.append(r5)
            java.lang.String r1 = r6.toString()
            r14.a(r4, r1)
            androidx.fragment.app.FragmentActivity r5 = r13.$safeActivity
            java.lang.String[] r6 = r13.$permissions
            com.upuphone.xr.sapp.entity.PermissionNote r7 = r13.$permissionNote
            r13.label = r3
            r8 = 0
            r10 = 4
            r11 = 0
            r9 = r13
            java.lang.Object r14 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r5, r6, r7, r8, r9, r10, r11)
            if (r14 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.upuphone.xr.sapp.permission.PermissionResult r14 = (com.upuphone.xr.sapp.permission.PermissionResult) r14
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "requestPermission, permissionResult: "
            r3.append(r5)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r1.a(r4, r3)
            boolean r14 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r14)
            if (r14 == 0) goto L_0x0082
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0082:
            androidx.fragment.app.FragmentActivity r5 = r13.$safeActivity
            int r6 = r13.$rejectWindowType
            com.upuphone.xr.sapp.entity.PermissionNote r7 = r13.$rejectPermissionNote
            r13.label = r2
            r8 = 0
            r9 = 0
            r11 = 12
            r12 = 0
            r10 = r13
            java.lang.Object r14 = com.upuphone.xr.sapp.utils.GenericWindowExtKt.b(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L_0x0097
            return r0
        L_0x0097:
            com.upuphone.xr.sapp.utils.GenericWindowResult$ButtonAction r14 = (com.upuphone.xr.sapp.utils.GenericWindowResult.ButtonAction) r14
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "requestPermission, dialogResult: "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.a(r4, r1)
            int r14 = r14.getActionType()
            r0 = 1101(0x44d, float:1.543E-42)
            if (r14 != r0) goto L_0x00bc
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r13.$jumpAction
            r13.invoke()
        L_0x00bc:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.PermissionManagerFragment$requestPermission$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PermissionManagerFragment$requestPermission$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
