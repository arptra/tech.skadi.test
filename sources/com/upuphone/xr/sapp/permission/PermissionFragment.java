package com.upuphone.xr.sapp.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.honey.account.q8.a;
import com.honey.account.q8.b;
import com.honey.account.q8.c;
import com.honey.account.q8.d;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u0011\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\"\u0010\u0010\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\fj\u0002`\u000f¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\fj\u0002`\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R6\u0010\u0010\u001a\"\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0004\u0018\u0001`\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R*\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0004\u0018\u0001`\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "", "permissions", "Lkotlin/Function1;", "", "", "Lcom/upuphone/xr/sapp/permission/PermissionCallback;", "permissionCallback", "u0", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Intent;", "intent", "Landroidx/activity/result/ActivityResult;", "Lcom/upuphone/xr/sapp/permission/ActivityResultCallback;", "callback", "n0", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "s0", "([Ljava/lang/String;)V", "m0", "(Landroid/content/Intent;)V", "Landroidx/activity/result/ActivityResultLauncher;", "a", "Landroidx/activity/result/ActivityResultLauncher;", "permissionLauncher", "b", "activityResultLauncher", "c", "Lkotlin/jvm/functions/Function1;", "d", "activityResultCallback", "", "Ljava/lang/Runnable;", "e", "Ljava/util/List;", "pendingActions", "f", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionFragment.kt\ncom/upuphone/xr/sapp/permission/PermissionFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,95:1\n1855#2,2:96\n37#3,2:98\n*S KotlinDebug\n*F\n+ 1 PermissionFragment.kt\ncom/upuphone/xr/sapp/permission/PermissionFragment\n*L\n45#1:96,2\n55#1:98,2\n*E\n"})
public final class PermissionFragment extends Fragment {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public ActivityResultLauncher f7818a;
    public ActivityResultLauncher b;
    public Function1 c;
    public Function1 d;
    public final List e = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/permission/PermissionFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void k0(PermissionFragment permissionFragment, Map map) {
        Intrinsics.checkNotNullParameter(permissionFragment, "this$0");
        Intrinsics.checkNotNullParameter(map, "it");
        Function1 function1 = permissionFragment.c;
        permissionFragment.c = null;
        if (function1 != null) {
            function1.invoke(map);
        }
    }

    public static final void l0(PermissionFragment permissionFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(permissionFragment, "this$0");
        Intrinsics.checkNotNullParameter(activityResult, "it");
        Function1 function1 = permissionFragment.d;
        permissionFragment.d = null;
        if (function1 != null) {
            function1.invoke(activityResult);
        }
    }

    public static final void o0(PermissionFragment permissionFragment, Intent intent) {
        Intrinsics.checkNotNullParameter(permissionFragment, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        permissionFragment.m0(intent);
    }

    public static final void v0(PermissionFragment permissionFragment, String[] strArr) {
        Intrinsics.checkNotNullParameter(permissionFragment, "this$0");
        Intrinsics.checkNotNullParameter(strArr, "$permissions");
        permissionFragment.s0(strArr);
    }

    public final void m0(Intent intent) {
        ActivityResultLauncher activityResultLauncher = this.b;
        if (activityResultLauncher != null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("PermissionFragment", "requestActivityResult: " + intent);
            activityResultLauncher.a(intent);
        }
    }

    public final void n0(Intent intent, Function1 function1) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.d = function1;
        if (this.b != null) {
            m0(intent);
        } else {
            this.e.add(new d(this, intent));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7818a = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new a(this));
        this.b = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
        for (Runnable run : this.e) {
            run.run();
        }
        this.e.clear();
    }

    public final void s0(String[] strArr) {
        ActivityResultLauncher activityResultLauncher = this.f7818a;
        if (activityResultLauncher != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String arrays = Arrays.toString(strArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
            delegate.a("PermissionFragment", "requestPermissions: " + arrays);
            activityResultLauncher.a(strArr);
        }
    }

    public final void u0(String[] strArr, Function1 function1) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function1, "permissionCallback");
        this.c = function1;
        if (this.f7818a != null) {
            s0(strArr);
        } else {
            this.e.add(new c(this, strArr));
        }
    }
}
