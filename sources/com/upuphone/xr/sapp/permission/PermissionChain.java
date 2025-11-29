package com.upuphone.xr.sapp.permission;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u000289B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0015\u001a\u00020\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019j\u0002`\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017H@¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010\u0013J\u001f\u0010(\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0014H\u0002¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\r018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u00102R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000205048\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u00106¨\u0006:"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionChain;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "", "", "permissions", "", "skipIfRejectTwice", "Lcom/upuphone/xr/sapp/permission/PermissionListener;", "listener", "Lcom/upuphone/xr/sapp/permission/PermissionChain$PermissionTask;", "j", "([Ljava/lang/String;ZLcom/upuphone/xr/sapp/permission/PermissionListener;)Lcom/upuphone/xr/sapp/permission/PermissionChain$PermissionTask;", "permissionTask", "", "c", "(Lcom/upuphone/xr/sapp/permission/PermissionChain$PermissionTask;)V", "Lcom/upuphone/xr/sapp/permission/PermissionResult;", "l", "([Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "Lcom/upuphone/xr/sapp/permission/ActivityResultCallback;", "callback", "i", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "k", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "()V", "Lcom/upuphone/xr/sapp/permission/PermissionFragment;", "e", "()Lcom/upuphone/xr/sapp/permission/PermissionFragment;", "g", "result", "h", "(Lcom/upuphone/xr/sapp/permission/PermissionChain$PermissionTask;Lcom/upuphone/xr/sapp/permission/PermissionResult;)V", "a", "Landroidx/fragment/app/FragmentActivity;", "f", "()Landroidx/fragment/app/FragmentActivity;", "b", "Lcom/upuphone/xr/sapp/permission/PermissionFragment;", "permissionFragment", "Ljava/util/Queue;", "Ljava/util/Queue;", "permissionQueue", "", "", "Ljava/util/Map;", "permissionRequestTime", "Companion", "PermissionTask", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionChain.kt\ncom/upuphone/xr/sapp/permission/PermissionChain\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,252:1\n314#2,11:253\n314#2,11:276\n11065#3:264\n11400#3,3:265\n13309#3,2:274\n1726#4,3:268\n1726#4,3:271\n*S KotlinDebug\n*F\n+ 1 PermissionChain.kt\ncom/upuphone/xr/sapp/permission/PermissionChain\n*L\n86#1:253,11\n232#1:276,11\n112#1:264\n112#1:265,3\n165#1:274,2\n120#1:268,3\n133#1:271,3\n*E\n"})
public final class PermissionChain {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final FragmentActivity f7813a;
    public PermissionFragment b;
    public final Queue c = new LinkedBlockingQueue();
    public final Map d = new LinkedHashMap();

    @SourceDebugExtension({"SMAP\nPermissionChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionChain.kt\ncom/upuphone/xr/sapp/permission/PermissionChain$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,252:1\n11065#2:253\n11400#2,3:254\n*S KotlinDebug\n*F\n+ 1 PermissionChain.kt\ncom/upuphone/xr/sapp/permission/PermissionChain$Companion\n*L\n34#1:253\n34#1:254,3\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionChain$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "", "permissions", "Lcom/upuphone/xr/sapp/permission/PermissionResult;", "a", "(Landroid/content/Context;[Ljava/lang/String;)Lcom/upuphone/xr/sapp/permission/PermissionResult;", "FRAGMENT_TAG", "Ljava/lang/String;", "", "MIN_PERMISSION_TIME", "J", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PermissionResult a(Context context, String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(strArr, "permissions");
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                PermissionHelper permissionHelper = PermissionHelper.f7819a;
                arrayList.add(new PermissionDetail(str, permissionHelper.l(context, str), permissionHelper.h(str)));
            }
            return new PermissionResult(strArr, arrayList, false);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionChain$PermissionTask;", "", "", "", "permissions", "", "skipIfRejectTwice", "Lcom/upuphone/xr/sapp/permission/PermissionListener;", "listener", "<init>", "([Ljava/lang/String;ZLcom/upuphone/xr/sapp/permission/PermissionListener;)V", "a", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "Z", "c", "()Z", "Lcom/upuphone/xr/sapp/permission/PermissionListener;", "()Lcom/upuphone/xr/sapp/permission/PermissionListener;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class PermissionTask {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f7814a;
        public final boolean b;
        public final PermissionListener c;

        public PermissionTask(String[] strArr, boolean z, PermissionListener permissionListener) {
            Intrinsics.checkNotNullParameter(strArr, "permissions");
            Intrinsics.checkNotNullParameter(permissionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.f7814a = strArr;
            this.b = z;
            this.c = permissionListener;
        }

        public final PermissionListener a() {
            return this.c;
        }

        public final String[] b() {
            return this.f7814a;
        }

        public final boolean c() {
            return this.b;
        }
    }

    public PermissionChain(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.f7813a = fragmentActivity;
    }

    public final void c(PermissionTask permissionTask) {
        Intrinsics.checkNotNullParameter(permissionTask, "permissionTask");
        this.c.remove(permissionTask);
    }

    public final void d() {
        PermissionTask permissionTask = (PermissionTask) this.c.peek();
        if (permissionTask == null) {
            ULog.f6446a.c("PermissionChain", "checkPermission, permissionQueue is empty");
            return;
        }
        String[] b2 = permissionTask.b();
        ArrayList<PermissionDetail> arrayList = new ArrayList<>(b2.length);
        for (String str : b2) {
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            arrayList.add(new PermissionDetail(str, permissionHelper.l(this.f7813a, str), permissionHelper.h(str)));
        }
        if (!arrayList.isEmpty()) {
            for (PermissionDetail a2 : arrayList) {
                if (!a2.a()) {
                    if (!permissionTask.c()) {
                        g(permissionTask);
                    } else {
                        if (!arrayList.isEmpty()) {
                            for (PermissionDetail b3 : arrayList) {
                                if (b3.b() < 2) {
                                }
                            }
                        }
                        h(permissionTask, new PermissionResult(b2, arrayList, false));
                        return;
                    }
                    g(permissionTask);
                    return;
                }
            }
        }
        h(permissionTask, new PermissionResult(b2, arrayList, false));
    }

    public final PermissionFragment e() {
        PermissionFragment permissionFragment = this.b;
        if (permissionFragment != null) {
            return permissionFragment;
        }
        Fragment p0 = this.f7813a.getSupportFragmentManager().p0("PermissionFragment@PermissionChain");
        if (p0 != null) {
            return (PermissionFragment) p0;
        }
        PermissionFragment permissionFragment2 = new PermissionFragment();
        this.b = permissionFragment2;
        this.f7813a.getSupportFragmentManager().s().e(permissionFragment2, "PermissionFragment@PermissionChain").k();
        return permissionFragment2;
    }

    public final FragmentActivity f() {
        return this.f7813a;
    }

    public final void g(PermissionTask permissionTask) {
        this.d.clear();
        for (String put : permissionTask.b()) {
            this.d.put(put, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        e().u0(permissionTask.b(), new PermissionChain$handlePermissionRequest$2(this, permissionTask));
    }

    public final void h(PermissionTask permissionTask, PermissionResult permissionResult) {
        permissionTask.a().a(permissionResult);
        this.c.remove(permissionTask);
        d();
    }

    public final void i(Intent intent, Function1 function1) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "callback");
        e().n0(intent, function1);
    }

    public final PermissionTask j(String[] strArr, boolean z, PermissionListener permissionListener) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(permissionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        PermissionTask permissionTask = new PermissionTask(strArr, z, permissionListener);
        boolean isEmpty = this.c.isEmpty();
        this.c.offer(permissionTask);
        if (isEmpty) {
            d();
        }
        return permissionTask;
    }

    public final Object k(Intent intent, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        i(intent, new PermissionChain$waitForActivityResult$2$callback$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final Object l(String[] strArr, boolean z, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        cancellableContinuationImpl.E(new PermissionChain$waitForPermissionResult$2$1(this, j(strArr, z, new PermissionChain$waitForPermissionResult$2$listener$1(cancellableContinuationImpl))));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }
}
