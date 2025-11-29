package com.upuphone.ar.tici.phone.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.honey.account.s4.e;
import com.honey.account.s4.f;
import com.upuphone.ar.tici.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \t2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0005J+\u0010\u0011\u001a\u00020\u00102\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010%\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/StoragePermission;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "j", "()Z", "e", "", "l", "i", "Lkotlin/Function0;", "yesBlock", "noBlock", "Landroid/app/AlertDialog;", "f", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroid/app/AlertDialog;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "", "", "b", "[Ljava/lang/String;", "PERMISSIONS_STORAGE", "c", "Landroid/app/AlertDialog;", "dialog", "value", "d", "Z", "getHavePermission", "k", "(Z)V", "havePermission", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class StoragePermission {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Activity f6000a;
    public final String[] b = {"android.permission.READ_EXTERNAL_STORAGE"};
    public AlertDialog c;
    public boolean d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/StoragePermission$Companion;", "", "()V", "REQUEST_EXTERNAL_STORAGE_CODE", "", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public StoragePermission(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f6000a = activity;
    }

    public static final void g(Function0 function0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(function0, "$noBlock");
        function0.invoke();
    }

    public static final void h(Function0 function0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(function0, "$yesBlock");
        function0.invoke();
    }

    public final boolean e() {
        k(Build.VERSION.SDK_INT >= 30 ? Environment.isExternalStorageManager() : ContextCompat.checkSelfPermission(this.f6000a, "android.permission.READ_EXTERNAL_STORAGE") == 0);
        return this.d;
    }

    public final AlertDialog f(Function0 function0, Function0 function02) {
        AlertDialog create = new AlertDialog.Builder(this.f6000a).setTitle(R.string.request_permission_title).setMessage(R.string.request_permission_content).setNegativeButton(R.string.request_permission_deny, new e(function02)).setPositiveButton(R.string.request_permission_agree, new f(function0)).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    public final void i(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
    }

    public final boolean j() {
        CommonExtKt.e("checkStoragePermission: ", "StoragePermission");
        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                this.f6000a.startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
                k(false);
            } else {
                k(true);
                CommonExtKt.e("Android 11以上，有权限", "StoragePermission");
            }
        } else if (ContextCompat.checkSelfPermission(this.f6000a, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            if (!ActivityCompat.i(this.f6000a, "android.permission.READ_EXTERNAL_STORAGE")) {
                l(this.f6000a);
            } else {
                ActivityCompat.e(this.f6000a, this.b, 1);
            }
            k(false);
        } else {
            k(true);
            CommonExtKt.e("Android 6.0以上，11以下，当前已有权限", "StoragePermission");
        }
        return this.d;
    }

    public final void k(boolean z) {
        this.d = z;
        CommonExtKt.e("文件权限: " + z, "StoragePermission");
    }

    public final void l(Activity activity) {
        AlertDialog alertDialog = this.c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog f = f(new StoragePermission$showPermissionDeniedDialog$1(this, activity), new StoragePermission$showPermissionDeniedDialog$2(this));
        this.c = f;
        if (f != null) {
            f.show();
        }
    }
}
