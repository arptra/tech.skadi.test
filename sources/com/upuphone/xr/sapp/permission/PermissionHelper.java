package com.upuphone.xr.sapp.permission;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.OSHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.vu.utils.ArSpaceUtil;
import com.xjmz.myvu.ext.ConnectExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J!\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b&\u0010\u001cJ\u001d\u0010'\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b)\u0010*J#\u0010+\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b+\u0010*J%\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b-\u0010.J%\u0010/\u001a\u0004\u0018\u00010,2\u0006\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b/\u0010.JY\u00106\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u0002002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\b\u00101\u001a\u0004\u0018\u00010,2\b\u00102\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00103\u001a\u0004\u0018\u00010,2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e04H\u0007¢\u0006\u0004\b6\u00107JF\u00108\u001a\u00020\t2\u0006\u0010\u0005\u001a\u0002002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\b\u00101\u001a\u0004\u0018\u00010,2\b\u00102\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00103\u001a\u0004\u0018\u00010,H@¢\u0006\u0004\b8\u00109J.\u0010;\u001a\u00020\t2\u0006\u0010\u0005\u001a\u0002002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010:\u001a\u00020\tH@¢\u0006\u0004\b;\u0010<J?\u0010=\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u0002002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010:\u001a\u00020\t2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e04¢\u0006\u0004\b=\u0010>J\u0018\u0010?\u001a\u00020\t2\u0006\u0010\u0005\u001a\u000200H@¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020\t2\u0006\u0010\u0005\u001a\u000200H@¢\u0006\u0004\bA\u0010@J\u0018\u0010B\u001a\u00020\t2\u0006\u0010\u0005\u001a\u000200H@¢\u0006\u0004\bB\u0010@J\u0018\u0010C\u001a\u00020\t2\u0006\u0010\u0005\u001a\u000200H@¢\u0006\u0004\bC\u0010@J\"\u0010E\u001a\u00020\t2\u0006\u0010\u0005\u001a\u0002002\b\b\u0002\u0010D\u001a\u00020\tH@¢\u0006\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionHelper;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "", "permissions", "", "v", "(Landroid/app/Activity;Ljava/util/List;)Z", "Landroid/content/Context;", "context", "m", "(Landroid/content/Context;Ljava/util/List;)Z", "", "n", "(Landroid/content/Context;[Ljava/lang/String;)Z", "permission", "l", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "h", "(Ljava/lang/String;)I", "i", "(Ljava/util/List;)Ljava/util/List;", "j", "([Ljava/lang/String;)Ljava/util/List;", "count", "", "t", "(Ljava/lang/String;I)V", "value", "s", "(Ljava/lang/String;Z)V", "f", "(Ljava/lang/String;)Z", "g", "u", "(Landroid/app/Activity;Ljava/lang/String;)Z", "a", "(Landroid/app/Activity;[Ljava/lang/String;)Z", "b", "Lcom/upuphone/xr/sapp/entity/PermissionNote;", "e", "(Landroid/content/Context;[Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/PermissionNote;", "k", "Landroidx/fragment/app/FragmentActivity;", "permissionNote", "rejectWindowType", "rejectPermissionNote", "Lkotlin/Function1;", "callback", "q", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/PermissionNote;Ljava/lang/Integer;Lcom/upuphone/xr/sapp/entity/PermissionNote;Lkotlin/jvm/functions/Function1;)V", "o", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/PermissionNote;Ljava/lang/Integer;Lcom/upuphone/xr/sapp/entity/PermissionNote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showRejectDialog", "p", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "y", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "z", "x", "w", "needBluetoothPermission", "c", "(Landroidx/fragment/app/FragmentActivity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionHelper.kt\ncom/upuphone/xr/sapp/permission/PermissionHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,717:1\n1855#2,2:718\n1549#2:720\n1620#2,3:721\n1855#2,2:728\n1726#2,3:730\n1747#2,3:733\n11065#3:724\n11400#3,3:725\n12474#3,2:736\n12474#3,2:738\n12474#3,2:740\n12474#3,2:742\n12474#3,2:744\n12474#3,2:746\n12474#3,2:748\n12474#3,2:750\n12474#3,2:752\n12474#3,2:754\n12474#3,2:756\n12474#3,2:758\n12474#3,2:760\n12474#3,2:762\n12474#3,2:764\n12474#3,2:766\n12474#3,2:768\n12474#3,2:770\n12474#3,2:772\n12474#3,2:774\n12474#3,2:776\n12474#3,2:778\n12474#3,2:780\n12474#3,2:782\n12474#3,2:784\n12474#3,2:786\n12474#3,2:788\n12474#3,2:790\n12474#3,2:792\n*S KotlinDebug\n*F\n+ 1 PermissionHelper.kt\ncom/upuphone/xr/sapp/permission/PermissionHelper\n*L\n59#1:718,2\n92#1:720\n92#1:721,3\n152#1:728,2\n174#1:730,3\n190#1:733,3\n141#1:724\n141#1:725,3\n206#1:736,2\n218#1:738,2\n225#1:740,2\n232#1:742,2\n239#1:744,2\n246#1:746,2\n263#1:748,2\n275#1:750,2\n290#1:752,2\n307#1:754,2\n314#1:756,2\n321#1:758,2\n328#1:760,2\n335#1:762,2\n342#1:764,2\n349#1:766,2\n366#1:768,2\n383#1:770,2\n390#1:772,2\n404#1:774,2\n408#1:776,2\n412#1:778,2\n416#1:780,2\n420#1:782,2\n424#1:784,2\n428#1:786,2\n432#1:788,2\n436#1:790,2\n496#1:792,2\n*E\n"})
public final class PermissionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final PermissionHelper f7819a = new PermissionHelper();

    public static /* synthetic */ Object d(PermissionHelper permissionHelper, FragmentActivity fragmentActivity, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return permissionHelper.c(fragmentActivity, z, continuation);
    }

    public final boolean a(Activity activity, String[] strArr) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        if (n(activity, strArr)) {
            return false;
        }
        List<Number> j = j(strArr);
        if (!(j instanceof Collection) || !j.isEmpty()) {
            for (Number intValue : j) {
                if (intValue.intValue() != 0) {
                    if (v(activity, ArraysKt.toList((T[]) strArr))) {
                        return true;
                    }
                    if (AppUtils.f7842a.j()) {
                        return false;
                    }
                    List<Boolean> g = g(strArr);
                    if ((g instanceof Collection) && g.isEmpty()) {
                        return false;
                    }
                    for (Boolean booleanValue : g) {
                        if (!booleanValue.booleanValue()) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(Activity activity, String[] strArr) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() && a(activity, strArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: androidx.fragment.app.FragmentActivity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(androidx.fragment.app.FragmentActivity r13, boolean r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.upuphone.xr.sapp.permission.PermissionHelper$checkLocationAndBluetooth$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.xr.sapp.permission.PermissionHelper$checkLocationAndBluetooth$1 r0 = (com.upuphone.xr.sapp.permission.PermissionHelper$checkLocationAndBluetooth$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.permission.PermissionHelper$checkLocationAndBluetooth$1 r0 = new com.upuphone.xr.sapp.permission.PermissionHelper$checkLocationAndBluetooth$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x006b
            if (r2 == r6) goto L_0x005c
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0109
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            boolean r12 = r0.Z$0
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r14 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r14 = (com.upuphone.xr.sapp.permission.PermissionHelper) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00e4
        L_0x004b:
            boolean r12 = r0.Z$0
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r14 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r14 = (com.upuphone.xr.sapp.permission.PermissionHelper) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r14
            r14 = r12
            r12 = r11
            goto L_0x00c5
        L_0x005c:
            boolean r14 = r0.Z$0
            java.lang.Object r12 = r0.L$1
            r13 = r12
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r12 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r12 = (com.upuphone.xr.sapp.permission.PermissionHelper) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00a9
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Boolean r2 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.Boolean r8 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "checkLocationAndBluetooth, THIRD_PLATFORM: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r2 = ", COUNTRY_INTL: "
            r9.append(r2)
            r9.append(r8)
            java.lang.String r2 = r9.toString()
            java.lang.String r8 = "PermissionHelper"
            r15.a(r8, r2)
            com.upuphone.xr.sapp.utils.OSHelper r15 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r15 = r15.b()
            if (r15 == 0) goto L_0x00d2
            r0.L$0 = r12
            r0.L$1 = r13
            r0.Z$0 = r14
            r0.label = r6
            java.lang.Object r15 = r12.y(r13, r0)
            if (r15 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x00b6
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x00b6:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.Z$0 = r14
            r0.label = r5
            java.lang.Object r15 = r12.z(r13, r0)
            if (r15 != r1) goto L_0x00c5
            return r1
        L_0x00c5:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x00d2
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x00d2:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.Z$0 = r14
            r0.label = r4
            java.lang.Object r15 = r12.x(r13, r0)
            if (r15 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r11 = r14
            r14 = r12
            r12 = r11
        L_0x00e4:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x00f1
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x00f1:
            if (r12 != 0) goto L_0x00fb
            com.upuphone.xr.sapp.utils.OSHelper r12 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r12 = r12.a()
            if (r12 == 0) goto L_0x0116
        L_0x00fb:
            r12 = 0
            r0.L$0 = r12
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r15 = r14.w(r13, r0)
            if (r15 != r1) goto L_0x0109
            return r1
        L_0x0109:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r12 = r15.booleanValue()
            if (r12 != 0) goto L_0x0116
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x0116:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.c(androidx.fragment.app.FragmentActivity, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PermissionNote e(Context context, String[] strArr) {
        String str;
        String modelId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        for (String contains : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.A(), contains)) {
                String string = OSHelper.f7904a.d() ? context.getString(R.string.flyme_internal_app_permission_location_text_android_r) : context.getString(R.string.flyme_internal_app_permission_location_text);
                Intrinsics.checkNotNull(string);
                String string2 = context.getString(R.string.location_title);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return new PermissionNote(string2, string);
            }
        }
        for (String contains2 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.z(), contains2)) {
                String string3 = context.getString(R.string.bt_title);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                String string4 = context.getString(R.string.flyme_internal_app_permission_nearby_devices_text);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return new PermissionNote(string3, string4);
            }
        }
        for (String contains3 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.q(), contains3)) {
                String string5 = context.getString(R.string.call_title);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                String string6 = context.getString(R.string.flyme_internal_app_permission_phone_text);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return new PermissionNote(string5, string6);
            }
        }
        for (String contains4 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.m(), contains4)) {
                String string7 = context.getString(R.string.calllog_title);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                String string8 = context.getString(R.string.flyme_internal_app_permission_read_call_log_text);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return new PermissionNote(string7, string8);
            }
        }
        for (String contains5 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.n(), contains5)) {
                String string9 = context.getString(R.string.address_title);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                String string10 = context.getString(R.string.flyme_internal_app_permission_contacts_text);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return new PermissionNote(string9, string10);
            }
        }
        for (String contains6 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.r(), contains6)) {
                Boolean bool = BuildConfig.b;
                Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
                if (bool.booleanValue()) {
                    StarryNetDevice a2 = ConnectExtKt.a();
                    str = (a2 == null || (modelId = a2.getModelId()) == null || !ModelIdExtKt.b(modelId)) ? context.getString(R.string.flyme_internal_app_permission_calendar_text) : context.getString(R.string.third_app_permission_calendar_text_air);
                } else {
                    str = context.getString(R.string.flyme_internal_app_permission_calendar_text);
                }
                Intrinsics.checkNotNull(str);
                String string11 = context.getString(R.string.permission_read_calendar);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return new PermissionNote(string11, str);
            }
        }
        for (String contains7 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.l(), contains7)) {
                String string12 = OSHelper.f7904a.e() ? context.getString(R.string.flyme_internal_app_permission_storage_text) : context.getString(R.string.flyme_internal_app_permission_media_visual_text);
                Intrinsics.checkNotNull(string12);
                String string13 = context.getString(R.string.permission_read_write_note_title);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return new PermissionNote(string13, string12);
            }
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            if (!ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.y(), strArr[i])) {
                i++;
            } else if (ArSpaceUtil.f8089a.i()) {
                String string14 = context.getString(R.string.permission_record_audio_title);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                String string15 = context.getString(R.string.flyme_internal_app_permission_microphone_vivo_text);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                return new PermissionNote(string14, string15);
            } else {
                String string16 = context.getString(R.string.permission_record_audio_title);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                String string17 = context.getString(R.string.flyme_internal_app_permission_microphone_text);
                Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                return new PermissionNote(string16, string17);
            }
        }
        for (String contains8 : strArr) {
            if (ArraysKt.contains((T[]) PermissionAndStateCheckUtils.f7907a.u(), contains8)) {
                String string18 = context.getString(R.string.permission_camera_title);
                Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                String string19 = context.getString(R.string.flyme_internal_app_permission_camera_text);
                Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
                return new PermissionNote(string18, string19);
            }
        }
        return null;
    }

    public final boolean f(String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        DataStoreUtils a2 = DataStoreUtils.e.a();
        return ((Boolean) DataStoreUtils.i(a2, str + "_permission_rationale_history", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final List g(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permission");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String f : strArr) {
            arrayList.add(Boolean.valueOf(f7819a.f(f)));
        }
        return arrayList;
    }

    public final int h(String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        DataStoreUtils a2 = DataStoreUtils.e.a();
        return ((Number) DataStoreUtils.i(a2, str + "_reject_count", 0, (Context) null, 4, (Object) null)).intValue();
    }

    public final List i(List list) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataStoreUtils a2 = DataStoreUtils.e.a();
            arrayList.add(Integer.valueOf(((Number) DataStoreUtils.i(a2, ((String) it.next()) + "_reject_count", 0, (Context) null, 4, (Object) null)).intValue()));
        }
        return arrayList;
    }

    public final List j(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        return i(ArraysKt.toList((T[]) strArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012e, code lost:
        r5 = r5.getModelId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.upuphone.xr.sapp.entity.PermissionNote k(android.content.Context r6, java.lang.String[] r7) {
        /*
            r5 = this;
            java.lang.String r5 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            java.lang.String r5 = "permissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            int r5 = r7.length
            r0 = 0
            r1 = r0
        L_0x000d:
            java.lang.String r2 = "getString(...)"
            if (r1 >= r5) goto L_0x003a
            r3 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r4 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r4 = r4.A()
            boolean r3 = kotlin.collections.ArraysKt.contains((T[]) r4, r3)
            if (r3 == 0) goto L_0x0037
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r7 = com.upuphone.xr.sapp.R.string.permission_reminder_title_location
            java.lang.String r7 = r6.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r0 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r6 = r6.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r5.<init>(r7, r6)
            return r5
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x003a:
            int r5 = r7.length
            r1 = r0
        L_0x003c:
            if (r1 >= r5) goto L_0x0067
            r3 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r4 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r4 = r4.t()
            boolean r3 = kotlin.collections.ArraysKt.contains((T[]) r4, r3)
            if (r3 == 0) goto L_0x0064
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r7 = com.upuphone.xr.sapp.R.string.permission_reminder_title_location
            java.lang.String r7 = r6.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r0 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r6 = r6.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r5.<init>(r7, r6)
            return r5
        L_0x0064:
            int r1 = r1 + 1
            goto L_0x003c
        L_0x0067:
            int r5 = r7.length
            r1 = r0
        L_0x0069:
            if (r1 >= r5) goto L_0x008e
            r3 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r4 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r4 = r4.z()
            boolean r3 = kotlin.collections.ArraysKt.contains((T[]) r4, r3)
            if (r3 == 0) goto L_0x008b
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r6 = com.upuphone.xr.sapp.R.string.permission_reminder_title_bluetooth
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_nearby_devices_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            r5.<init>(r6, r7)
            return r5
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0069
        L_0x008e:
            int r5 = r7.length
            r1 = r0
        L_0x0090:
            if (r1 >= r5) goto L_0x00b5
            r3 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r4 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r4 = r4.q()
            boolean r3 = kotlin.collections.ArraysKt.contains((T[]) r4, r3)
            if (r3 == 0) goto L_0x00b2
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r6 = com.upuphone.xr.sapp.R.string.permission_dial_read_phone_state_title
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_phone_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            r5.<init>(r6, r7)
            return r5
        L_0x00b2:
            int r1 = r1 + 1
            goto L_0x0090
        L_0x00b5:
            int r5 = r7.length
            r1 = r0
        L_0x00b7:
            if (r1 >= r5) goto L_0x00e2
            r3 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r4 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r4 = r4.m()
            boolean r3 = kotlin.collections.ArraysKt.contains((T[]) r4, r3)
            if (r3 == 0) goto L_0x00df
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r7 = com.upuphone.xr.sapp.R.string.calllog_permission_tittle
            java.lang.String r7 = r6.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r0 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_read_call_log_text
            java.lang.String r6 = r6.getString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r5.<init>(r7, r6)
            return r5
        L_0x00df:
            int r1 = r1 + 1
            goto L_0x00b7
        L_0x00e2:
            int r5 = r7.length
            r1 = r0
        L_0x00e4:
            if (r1 >= r5) goto L_0x0109
            r2 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r3 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r3 = r3.n()
            boolean r2 = kotlin.collections.ArraysKt.contains((T[]) r3, r2)
            if (r2 == 0) goto L_0x0106
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r6 = com.upuphone.xr.sapp.R.string.permission_reminder_title_contact
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_contacts_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            r5.<init>(r6, r7)
            return r5
        L_0x0106:
            int r1 = r1 + 1
            goto L_0x00e4
        L_0x0109:
            int r5 = r7.length
            r1 = r0
        L_0x010b:
            if (r1 >= r5) goto L_0x0161
            r2 = r7[r1]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r3 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r3 = r3.r()
            boolean r2 = kotlin.collections.ArraysKt.contains((T[]) r3, r2)
            if (r2 == 0) goto L_0x015e
            java.lang.Boolean r5 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r7 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0149
            com.upuphone.xr.interconnect.entity.StarryNetDevice r5 = com.xjmz.myvu.ext.ConnectExtKt.a()
            if (r5 == 0) goto L_0x0142
            java.lang.String r5 = r5.getModelId()
            if (r5 == 0) goto L_0x0142
            boolean r5 = com.upuphone.xr.sapp.utils.ModelIdExtKt.b(r5)
            r7 = 1
            if (r5 != r7) goto L_0x0142
            int r5 = com.upuphone.xr.sapp.R.string.third_app_permission_calendar_text_air
            java.lang.String r5 = r6.getString(r5)
            goto L_0x014f
        L_0x0142:
            int r5 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_calendar_text
            java.lang.String r5 = r6.getString(r5)
            goto L_0x014f
        L_0x0149:
            int r5 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_calendar_text
            java.lang.String r5 = r6.getString(r5)
        L_0x014f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.upuphone.xr.sapp.entity.PermissionNote r6 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r7 = com.upuphone.xr.sapp.R.string.permission_read_calendar
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            r6.<init>(r7, r5)
            return r6
        L_0x015e:
            int r1 = r1 + 1
            goto L_0x010b
        L_0x0161:
            int r5 = r7.length
            r6 = r0
        L_0x0163:
            if (r6 >= r5) goto L_0x01a7
            r1 = r7[r6]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r2 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r2.l()
            boolean r1 = kotlin.collections.ArraysKt.contains((T[]) r2, r1)
            if (r1 == 0) goto L_0x01a4
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            java.lang.Boolean r6 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.String r7 = "COUNTRY_INTL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0185
            int r6 = com.upuphone.xr.sapp.R.string.permission_read_write_title_oversea
            goto L_0x0187
        L_0x0185:
            int r6 = com.upuphone.xr.sapp.R.string.permission_read_write_title
        L_0x0187:
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            com.upuphone.xr.sapp.utils.OSHelper r7 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r7 = r7.e()
            if (r7 == 0) goto L_0x019a
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_storage_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            goto L_0x01a0
        L_0x019a:
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_media_visual_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
        L_0x01a0:
            r5.<init>(r6, r7)
            return r5
        L_0x01a4:
            int r6 = r6 + 1
            goto L_0x0163
        L_0x01a7:
            int r5 = r7.length
            r6 = r0
        L_0x01a9:
            if (r6 >= r5) goto L_0x01ce
            r1 = r7[r6]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r2 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r2.y()
            boolean r1 = kotlin.collections.ArraysKt.contains((T[]) r2, r1)
            if (r1 == 0) goto L_0x01cb
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r6 = com.upuphone.xr.sapp.R.string.permission_record_audio_dialog_title
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_microphone_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            r5.<init>(r6, r7)
            return r5
        L_0x01cb:
            int r6 = r6 + 1
            goto L_0x01a9
        L_0x01ce:
            int r5 = r7.length
        L_0x01cf:
            if (r0 >= r5) goto L_0x01f4
            r6 = r7[r0]
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r1 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r1 = r1.u()
            boolean r6 = kotlin.collections.ArraysKt.contains((T[]) r1, r6)
            if (r6 == 0) goto L_0x01f1
            com.upuphone.xr.sapp.entity.PermissionNote r5 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r6 = com.upuphone.xr.sapp.R.string.permission_camera_dialog_title
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            int r7 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_camera_text
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            r5.<init>(r6, r7)
            return r5
        L_0x01f1:
            int r0 = r0 + 1
            goto L_0x01cf
        L_0x01f4:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.k(android.content.Context, java.lang.String[]):com.upuphone.xr.sapp.entity.PermissionNote");
    }

    public final boolean l(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "permission");
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public final boolean m(Context context, List list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "permissions");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!f7819a.l(context, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean n(Context context, String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        return m(context, ArraysKt.toList((T[]) strArr));
    }

    public final Object o(FragmentActivity fragmentActivity, String[] strArr, PermissionNote permissionNote, Integer num, PermissionNote permissionNote2, Continuation continuation) {
        return p(fragmentActivity, strArr, num != null, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(androidx.fragment.app.FragmentActivity r20, java.lang.String[] r21, boolean r22, kotlin.coroutines.Continuation r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            boolean r4 = r3 instanceof com.upuphone.xr.sapp.permission.PermissionHelper$requestPermission$3
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.upuphone.xr.sapp.permission.PermissionHelper$requestPermission$3 r4 = (com.upuphone.xr.sapp.permission.PermissionHelper$requestPermission$3) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            com.upuphone.xr.sapp.permission.PermissionHelper$requestPermission$3 r4 = new com.upuphone.xr.sapp.permission.PermissionHelper$requestPermission$3
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r4.label
            r14 = 4
            r12 = 3
            r6 = 2
            r15 = 1
            r16 = 0
            java.lang.String r11 = "PermissionHelper"
            if (r5 == 0) goto L_0x0094
            if (r5 == r15) goto L_0x007b
            if (r5 == r6) goto L_0x0066
            if (r5 == r12) goto L_0x0054
            if (r5 != r14) goto L_0x004c
            java.lang.Object r0 = r4.L$2
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.Object r1 = r4.L$1
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            java.lang.Object r2 = r4.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = (com.upuphone.xr.sapp.permission.PermissionHelper) r2
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r11
            goto L_0x01f0
        L_0x004c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0054:
            java.lang.Object r0 = r4.L$2
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.Object r1 = r4.L$1
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            java.lang.Object r2 = r4.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = (com.upuphone.xr.sapp.permission.PermissionHelper) r2
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r11
            goto L_0x01b7
        L_0x0066:
            boolean r0 = r4.Z$0
            java.lang.Object r1 = r4.L$2
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.Object r2 = r4.L$1
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
            java.lang.Object r5 = r4.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r5 = (com.upuphone.xr.sapp.permission.PermissionHelper) r5
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r11
            r11 = r5
            goto L_0x0148
        L_0x007b:
            boolean r0 = r4.Z$0
            java.lang.Object r1 = r4.L$2
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.lang.Object r2 = r4.L$1
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
            java.lang.Object r5 = r4.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r5 = (com.upuphone.xr.sapp.permission.PermissionHelper) r5
            kotlin.ResultKt.throwOnFailure(r3)
            r8 = r0
            r0 = r5
            r18 = r2
            r2 = r1
            r1 = r18
            goto L_0x00ca
        L_0x0094:
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.Boolean r3 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.String r5 = "COUNTRY_INTL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00f6
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r3 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r3 = r3.A()
            int r5 = r3.length
            r7 = r16
        L_0x00ad:
            if (r7 >= r5) goto L_0x00f6
            r8 = r3[r7]
            boolean r8 = kotlin.collections.ArraysKt.contains((T[]) r2, r8)
            if (r8 == 0) goto L_0x00f1
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r2
            r8 = r22
            r4.Z$0 = r8
            r4.label = r15
            java.lang.Object r3 = com.upuphone.xr.sapp.utils.DialogExtKt.a(r1, r4)
            if (r3 != r13) goto L_0x00ca
            return r13
        L_0x00ca:
            com.upuphone.xr.sapp.utils.DialogResult r3 = (com.upuphone.xr.sapp.utils.DialogResult) r3
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "requestPermission, location buttonAction: "
            r7.append(r9)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r5.a(r11, r7)
            com.upuphone.xr.sapp.utils.DialogAction r3 = r3.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r5 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r3 == r5) goto L_0x00ef
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r16)
            return r0
        L_0x00ef:
            r3 = r8
            goto L_0x00f9
        L_0x00f1:
            r8 = r22
            int r7 = r7 + 1
            goto L_0x00ad
        L_0x00f6:
            r8 = r22
            goto L_0x00ef
        L_0x00f9:
            com.upuphone.xr.sapp.entity.PermissionNote r7 = r0.e(r1, r2)
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r8 = java.util.Arrays.toString(r2)
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "requestPermission, permissions: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = ", permissionNote: "
            r9.append(r8)
            r9.append(r7)
            java.lang.String r8 = r9.toString()
            r5.a(r11, r8)
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r2
            r4.Z$0 = r3
            r4.label = r6
            r8 = 0
            r10 = 4
            r17 = 0
            r5 = r1
            r6 = r2
            r9 = r4
            r14 = r11
            r11 = r17
            java.lang.Object r5 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r5, r6, r7, r8, r9, r10, r11)
            if (r5 != r13) goto L_0x0140
            return r13
        L_0x0140:
            r11 = r0
            r0 = r3
            r3 = r5
            r18 = r2
            r2 = r1
            r1 = r18
        L_0x0148:
            com.upuphone.xr.sapp.permission.PermissionResult r3 = (com.upuphone.xr.sapp.permission.PermissionResult) r3
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestPermission, permissionResult: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            r5.a(r14, r6)
            boolean r3 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r3)
            if (r3 == 0) goto L_0x016b
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r0
        L_0x016b:
            if (r0 != 0) goto L_0x0177
            java.lang.String r0 = "requestPermission, showRejectDialog=false, return"
            r5.a(r14, r0)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r16)
            return r0
        L_0x0177:
            com.upuphone.xr.sapp.entity.PermissionNote r7 = r11.k(r2, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "requestPermission, rejectPermissionNote: "
            r0.append(r3)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r5.a(r14, r0)
            if (r7 != 0) goto L_0x0196
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r16)
            return r0
        L_0x0196:
            r4.L$0 = r11
            r4.L$1 = r2
            r4.L$2 = r1
            r4.label = r12
            r6 = 2008(0x7d8, float:2.814E-42)
            r8 = 0
            r9 = 0
            r0 = 12
            r12 = 0
            r5 = r2
            r10 = r4
            r3 = r11
            r11 = r0
            java.lang.Object r0 = com.upuphone.xr.sapp.utils.GenericWindowExtKt.b(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r0 != r13) goto L_0x01b0
            return r13
        L_0x01b0:
            r18 = r3
            r3 = r0
            r0 = r1
            r1 = r2
            r2 = r18
        L_0x01b7:
            com.upuphone.xr.sapp.utils.GenericWindowResult$ButtonAction r3 = (com.upuphone.xr.sapp.utils.GenericWindowResult.ButtonAction) r3
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestPermission, dialogResult: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            r5.a(r14, r6)
            int r3 = r3.getActionType()
            r5 = 1101(0x44d, float:1.543E-42)
            if (r3 == r5) goto L_0x01dc
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r16)
            return r0
        L_0x01dc:
            android.content.Intent r3 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.s()
            r4.L$0 = r2
            r4.L$1 = r1
            r4.L$2 = r0
            r5 = 4
            r4.label = r5
            java.lang.Object r3 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r1, r3, r4)
            if (r3 != r13) goto L_0x01f0
            return r13
        L_0x01f0:
            boolean r0 = r2.n(r1, r0)
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "requestPermission, isGranted: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.a(r14, r2)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.p(androidx.fragment.app.FragmentActivity, java.lang.String[], boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void q(FragmentActivity fragmentActivity, String[] strArr, PermissionNote permissionNote, Integer num, PermissionNote permissionNote2, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new PermissionHelper$requestPermission$1(fragmentActivity, strArr, permissionNote, num, permissionNote2, function1, (Continuation<? super PermissionHelper$requestPermission$1>) null), 3, (Object) null);
    }

    public final void r(FragmentActivity fragmentActivity, String[] strArr, boolean z, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new PermissionHelper$requestPermission$5(fragmentActivity, strArr, z, function1, (Continuation<? super PermissionHelper$requestPermission$5>) null), 3, (Object) null);
    }

    public final void s(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "permission");
        DataStoreUtils a2 = DataStoreUtils.e.a();
        a2.o(str + "_permission_rationale_history", Boolean.valueOf(z));
    }

    public final void t(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "permission");
        DataStoreUtils a2 = DataStoreUtils.e.a();
        a2.o(str + "_reject_count", Integer.valueOf(i));
    }

    public final boolean u(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "permission");
        return ActivityCompat.i(activity, str);
    }

    public final boolean v(Activity activity, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (f7819a.u(activity, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w(androidx.fragment.app.FragmentActivity r13, kotlin.coroutines.Continuation r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothPermission$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothPermission$1 r0 = (com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothPermission$1 r0 = new com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothPermission$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "PermissionHelper"
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x006c
            if (r2 == r7) goto L_0x0058
            if (r2 == r6) goto L_0x0047
            if (r2 != r5) goto L_0x003f
            java.lang.Object r12 = r0.L$2
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r0 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r0 = (com.upuphone.xr.sapp.permission.PermissionHelper) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0119
        L_0x003f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0047:
            java.lang.Object r12 = r0.L$2
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = (com.upuphone.xr.sapp.permission.PermissionHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00f6
        L_0x0058:
            java.lang.Object r12 = r0.L$2
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = (com.upuphone.xr.sapp.permission.PermissionHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r11 = r14
            r14 = r12
            r12 = r2
            r2 = r11
            goto L_0x00bf
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r14 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r14 = r14.z()
            boolean r2 = r12.n(r13, r14)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "waitForBluetoothPermission, hasBtPermission: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.a(r4, r9)
            if (r2 == 0) goto L_0x0097
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x0097:
            com.upuphone.xr.sapp.entity.PermissionNote r2 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r8 = com.upuphone.xr.sapp.R.string.bt_title
            java.lang.String r8 = r13.getString(r8)
            java.lang.String r9 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r10 = com.upuphone.xr.sapp.R.string.bt_content
            java.lang.String r10 = r13.getString(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            r2.<init>(r8, r10)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r7
            java.lang.Object r2 = com.upuphone.xr.sapp.permission.PermissionExtKt.a(r13, r14, r2, r3, r0)
            if (r2 != r1) goto L_0x00bf
            return r1
        L_0x00bf:
            com.upuphone.xr.sapp.permission.PermissionResult r2 = (com.upuphone.xr.sapp.permission.PermissionResult) r2
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "waitForBluetoothPermission, permissionResult: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.a(r4, r9)
            boolean r2 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r2)
            if (r2 == 0) goto L_0x00e3
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x00e3:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r6
            java.lang.Object r2 = com.upuphone.xr.sapp.utils.DialogExtKt.b(r13, r0)
            if (r2 != r1) goto L_0x00f2
            return r1
        L_0x00f2:
            r11 = r2
            r2 = r12
            r12 = r14
            r14 = r11
        L_0x00f6:
            com.upuphone.xr.sapp.utils.DialogResult r14 = (com.upuphone.xr.sapp.utils.DialogResult) r14
            com.upuphone.xr.sapp.utils.DialogAction r14 = r14.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r4 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r14 == r4) goto L_0x0105
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r12
        L_0x0105:
            android.content.Intent r14 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.s()
            r0.L$0 = r2
            r0.L$1 = r13
            r0.L$2 = r12
            r0.label = r5
            java.lang.Object r14 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r13, r14, r0)
            if (r14 != r1) goto L_0x0118
            return r1
        L_0x0118:
            r0 = r2
        L_0x0119:
            boolean r12 = r0.n(r13, r12)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.w(androidx.fragment.app.FragmentActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(androidx.fragment.app.FragmentActivity r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothState$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothState$1 r0 = (com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothState$1 r0 = new com.upuphone.xr.sapp.permission.PermissionHelper$waitForBluetoothState$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            java.lang.String r2 = "PermissionHelper"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r4) goto L_0x003b
            if (r1 != r3) goto L_0x0033
            java.lang.Object r8 = r0.L$0
            androidx.fragment.app.FragmentActivity r8 = (androidx.fragment.app.FragmentActivity) r8
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00ae
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            java.lang.Object r8 = r0.L$0
            androidx.fragment.app.FragmentActivity r8 = (androidx.fragment.app.FragmentActivity) r8
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0075
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r7 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r7 = r7.b(r8)
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "waitForBluetoothState, btState: "
            r5.append(r6)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r1.a(r2, r5)
            if (r7 == 0) goto L_0x006a
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L_0x006a:
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = com.upuphone.xr.sapp.utils.DialogExtKt.d(r8, r0)
            if (r7 != r9) goto L_0x0075
            return r9
        L_0x0075:
            com.upuphone.xr.sapp.utils.DialogResult r7 = (com.upuphone.xr.sapp.utils.DialogResult) r7
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "waitForBluetoothState, dialogResult: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r1.a(r2, r4)
            com.upuphone.xr.sapp.utils.DialogAction r7 = r7.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r1 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r7 == r1) goto L_0x009c
            r7 = 0
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        L_0x009c:
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r1 = "android.settings.BLUETOOTH_SETTINGS"
            r7.<init>(r1)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r8, r7, r0)
            if (r7 != r9) goto L_0x00ae
            return r9
        L_0x00ae:
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r7 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r7 = r7.b(r8)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.x(androidx.fragment.app.FragmentActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(androidx.fragment.app.FragmentActivity r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.permission.PermissionHelper$waitForLocationState$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForLocationState$1 r0 = (com.upuphone.xr.sapp.permission.PermissionHelper$waitForLocationState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForLocationState$1 r0 = new com.upuphone.xr.sapp.permission.PermissionHelper$waitForLocationState$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            java.lang.String r2 = "PermissionHelper"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r4) goto L_0x003b
            if (r1 != r3) goto L_0x0033
            java.lang.Object r8 = r0.L$0
            androidx.fragment.app.FragmentActivity r8 = (androidx.fragment.app.FragmentActivity) r8
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00ae
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            java.lang.Object r8 = r0.L$0
            androidx.fragment.app.FragmentActivity r8 = (androidx.fragment.app.FragmentActivity) r8
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0075
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r7 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r7 = r7.f(r8)
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "waitForLocationState, locationState: "
            r5.append(r6)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r1.a(r2, r5)
            if (r7 == 0) goto L_0x006a
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L_0x006a:
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = com.upuphone.xr.sapp.utils.DialogExtKt.e(r8, r0)
            if (r7 != r9) goto L_0x0075
            return r9
        L_0x0075:
            com.upuphone.xr.sapp.utils.DialogResult r7 = (com.upuphone.xr.sapp.utils.DialogResult) r7
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "waitForLocationState, dialogResult: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r1.a(r2, r4)
            com.upuphone.xr.sapp.utils.DialogAction r7 = r7.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r1 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r7 == r1) goto L_0x009c
            r7 = 0
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        L_0x009c:
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r1 = "android.settings.LOCATION_SOURCE_SETTINGS"
            r7.<init>(r1)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r8, r7, r0)
            if (r7 != r9) goto L_0x00ae
            return r9
        L_0x00ae:
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r7 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r7 = r7.f(r8)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.y(androidx.fragment.app.FragmentActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(androidx.fragment.app.FragmentActivity r13, kotlin.coroutines.Continuation r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.upuphone.xr.sapp.permission.PermissionHelper$waitForNecessaryLocationPermission$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForNecessaryLocationPermission$1 r0 = (com.upuphone.xr.sapp.permission.PermissionHelper$waitForNecessaryLocationPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.permission.PermissionHelper$waitForNecessaryLocationPermission$1 r0 = new com.upuphone.xr.sapp.permission.PermissionHelper$waitForNecessaryLocationPermission$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            java.lang.String r6 = "PermissionHelper"
            r7 = 1
            if (r2 == 0) goto L_0x006d
            if (r2 == r7) goto L_0x0058
            if (r2 == r5) goto L_0x0047
            if (r2 != r4) goto L_0x003f
            java.lang.Object r12 = r0.L$2
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r0 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r0 = (com.upuphone.xr.sapp.permission.PermissionHelper) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x015f
        L_0x003f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0047:
            java.lang.Object r12 = r0.L$2
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = (com.upuphone.xr.sapp.permission.PermissionHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0125
        L_0x0058:
            java.lang.Object r12 = r0.L$2
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.Object r13 = r0.L$1
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = (com.upuphone.xr.sapp.permission.PermissionHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r11 = r14
            r14 = r12
            r12 = r2
            r2 = r11
            goto L_0x00ee
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r14 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r14 = r14.A()
            boolean r2 = r12.n(r13, r14)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "waitForLocationPermission, hasLocationPermission: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.a(r6, r9)
            if (r2 == 0) goto L_0x0098
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x0098:
            java.lang.String r2 = java.util.Arrays.toString(r14)
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "waitForLocationPermission, permissions: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            r8.a(r6, r2)
            com.upuphone.xr.sapp.utils.OSHelper r2 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r2 = r2.d()
            if (r2 == 0) goto L_0x00c6
            int r2 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text_android_r
            java.lang.String r2 = r13.getString(r2)
            goto L_0x00cc
        L_0x00c6:
            int r2 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r2 = r13.getString(r2)
        L_0x00cc:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.upuphone.xr.sapp.entity.PermissionNote r8 = new com.upuphone.xr.sapp.entity.PermissionNote
            int r9 = com.upuphone.xr.sapp.R.string.location_title
            java.lang.String r9 = r13.getString(r9)
            java.lang.String r10 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r8.<init>(r9, r2)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r7
            java.lang.Object r2 = com.upuphone.xr.sapp.permission.PermissionExtKt.a(r13, r14, r8, r3, r0)
            if (r2 != r1) goto L_0x00ee
            return r1
        L_0x00ee:
            com.upuphone.xr.sapp.permission.PermissionResult r2 = (com.upuphone.xr.sapp.permission.PermissionResult) r2
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "waitForLocationPermission, permissionResult: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.a(r6, r9)
            boolean r2 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r2)
            if (r2 == 0) goto L_0x0112
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x0112:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.label = r5
            java.lang.Object r2 = com.upuphone.xr.sapp.utils.DialogExtKt.f(r13, r0)
            if (r2 != r1) goto L_0x0121
            return r1
        L_0x0121:
            r11 = r2
            r2 = r12
            r12 = r14
            r14 = r11
        L_0x0125:
            com.upuphone.xr.sapp.utils.DialogResult r14 = (com.upuphone.xr.sapp.utils.DialogResult) r14
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "waitForLocationPermission, dialogResult: "
            r7.append(r8)
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            r5.a(r6, r7)
            com.upuphone.xr.sapp.utils.DialogAction r14 = r14.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r5 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r14 == r5) goto L_0x014b
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r12
        L_0x014b:
            android.content.Intent r14 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.s()
            r0.L$0 = r2
            r0.L$1 = r13
            r0.L$2 = r12
            r0.label = r4
            java.lang.Object r14 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r13, r14, r0)
            if (r14 != r1) goto L_0x015e
            return r1
        L_0x015e:
            r0 = r2
        L_0x015f:
            boolean r12 = r0.n(r13, r12)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.permission.PermissionHelper.z(androidx.fragment.app.FragmentActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
