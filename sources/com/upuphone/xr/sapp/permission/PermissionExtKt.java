package com.upuphone.xr.sapp.permission;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.entity.PermissionNote;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\f\u0010\r\u001a6\u0010\u0010\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "", "", "permissions", "", "skipIfRejectTwice", "Lcom/upuphone/xr/sapp/permission/PermissionResult;", "d", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "intent", "Landroidx/activity/result/ActivityResult;", "c", "(Landroidx/fragment/app/FragmentActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/PermissionNote;", "permissionNote", "a", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/PermissionNote;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class PermissionExtKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(androidx.fragment.app.FragmentActivity r9, java.lang.String[] r10, com.upuphone.xr.sapp.entity.PermissionNote r11, boolean r12, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof com.upuphone.xr.sapp.permission.PermissionExtKt$requestPermissionWithTips$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.upuphone.xr.sapp.permission.PermissionExtKt$requestPermissionWithTips$1 r0 = (com.upuphone.xr.sapp.permission.PermissionExtKt$requestPermissionWithTips$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.permission.PermissionExtKt$requestPermissionWithTips$1 r0 = new com.upuphone.xr.sapp.permission.PermissionExtKt$requestPermissionWithTips$1
            r0.<init>(r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 161(0xa1, float:2.26E-43)
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x002c }
            goto L_0x00a7
        L_0x002c:
            r9 = move-exception
            goto L_0x00ad
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r13)
            int r13 = r10.length
            java.lang.String r2 = "PermissionExt"
            if (r13 == 0) goto L_0x00b1
            com.upuphone.xr.sapp.permission.PermissionChain$Companion r13 = com.upuphone.xr.sapp.permission.PermissionChain.e
            com.upuphone.xr.sapp.permission.PermissionResult r13 = r13.a(r9, r10)
            boolean r5 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r13)
            if (r5 == 0) goto L_0x004c
            return r13
        L_0x004c:
            com.upuphone.xr.sapp.permission.PermissionHelper r13 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            boolean r13 = r13.b(r9, r10)
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r6 = java.util.Arrays.toString(r10)
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "requestPermissionWithTips, permissions: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = ", canShowPermissionTips: "
            r7.append(r6)
            r7.append(r13)
            java.lang.String r6 = r7.toString()
            r5.a(r2, r6)
            if (r13 == 0) goto L_0x0099
            if (r11 == 0) goto L_0x0099
            java.lang.String r13 = r11.getTitle()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestPermissionWithTips, shownPermissionTip: "
            r6.append(r7)
            r6.append(r13)
            java.lang.String r13 = r6.toString()
            r5.a(r2, r13)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.T(r9, r11)
        L_0x0099:
            java.lang.String r11 = "requestPermissionWithTips, requestPermission"
            r5.a(r2, r11)
            r0.label = r4     // Catch:{ all -> 0x002c }
            java.lang.Object r13 = d(r9, r10, r12, r0)     // Catch:{ all -> 0x002c }
            if (r13 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            com.upuphone.xr.sapp.permission.PermissionResult r13 = (com.upuphone.xr.sapp.permission.PermissionResult) r13     // Catch:{ all -> 0x002c }
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.d(r3)
            return r13
        L_0x00ad:
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.d(r3)
            throw r9
        L_0x00b1:
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r10 = "requestPermissionWithTips, permissions is empty"
            r9.c(r2, r10)
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "permissions is empty"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionExtKt.a(androidx.fragment.app.FragmentActivity, java.lang.String[], com.upuphone.xr.sapp.entity.PermissionNote, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b(FragmentActivity fragmentActivity, String[] strArr, PermissionNote permissionNote, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(fragmentActivity, strArr, permissionNote, z, continuation);
    }

    public static final Object c(FragmentActivity fragmentActivity, Intent intent, Continuation continuation) {
        return new PermissionChain(fragmentActivity).k(intent, continuation);
    }

    public static final Object d(FragmentActivity fragmentActivity, String[] strArr, boolean z, Continuation continuation) {
        return new PermissionChain(fragmentActivity).l(strArr, z, continuation);
    }

    public static /* synthetic */ Object e(FragmentActivity fragmentActivity, String[] strArr, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return d(fragmentActivity, strArr, z, continuation);
    }
}
