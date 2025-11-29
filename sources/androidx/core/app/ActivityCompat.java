package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {

    /* renamed from: a  reason: collision with root package name */
    public static PermissionCompatDelegate f638a;

    /* renamed from: androidx.core.app.ActivityCompat$1  reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f639a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public void run() {
            int[] iArr = new int[this.f639a.length];
            PackageManager packageManager = this.b.getPackageManager();
            String packageName = this.b.getPackageName();
            int length = this.f639a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f639a[i], packageName);
            }
            ((OnRequestPermissionsResultCallback) this.b).onRequestPermissionsResult(this.c, this.f639a, iArr);
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        @DoNotInline
        public static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        @DoNotInline
        public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        public static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    @RequiresApi
    public static class Api22Impl {
        @DoNotInline
        public static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        @DoNotInline
        public static void b(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        @DoNotInline
        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static <T> T a(Activity activity, int i) {
            return activity.requireViewById(i);
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static Display a(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        @DoNotInline
        public static void b(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
            activity.setLocusContext(locusIdCompat == null ? null : locusIdCompat.b(), bundle);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static boolean a(@NonNull Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(activity.getApplication().getPackageManager(), new Object[]{str})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    @RequiresApi
    public static class Api32Impl {
        @DoNotInline
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean a(Activity activity, String[] strArr, int i);
    }

    @RestrictTo
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    @RequiresApi
    public static class SharedElementCallback21Impl extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        public final SharedElementCallback f640a;

        public SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f640a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f640a.b(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f640a.c(context, parcelable);
        }

        public void onMapSharedElements(List list, Map map) {
            this.f640a.d(list, map);
        }

        public void onRejectSharedElements(List list) {
            this.f640a.e(list);
        }

        public void onSharedElementEnd(List list, List list2, List list3) {
            this.f640a.f(list, list2, list3);
        }

        public void onSharedElementStart(List list, List list2, List list3) {
            this.f640a.g(list, list2, list3);
        }

        public void onSharedElementsArrived(List list, List list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f640a.h(list, list2, new a(onSharedElementsReadyListener));
        }
    }

    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void b(Activity activity) {
        Api21Impl.a(activity);
    }

    public static void c(Activity activity) {
        Api21Impl.b(activity);
    }

    public static void d(Activity activity) {
        activity.recreate();
    }

    public static void e(Activity activity, String[] strArr, int i) {
        PermissionCompatDelegate permissionCompatDelegate = f638a;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.a(activity, strArr, i)) {
            HashSet hashSet = new HashSet();
            int i2 = 0;
            while (i2 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i2));
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[(strArr.length - size)] : strArr;
            if (size > 0) {
                if (size != strArr.length) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < strArr.length; i4++) {
                        if (!hashSet.contains(Integer.valueOf(i4))) {
                            strArr2[i3] = strArr[i4];
                            i3++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            Api23Impl.b(activity, strArr, i);
        }
    }

    public static View f(Activity activity, int i) {
        return (View) Api28Impl.a(activity, i);
    }

    public static void g(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.c(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void h(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.d(activity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static boolean i(Activity activity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i >= 32 ? Api32Impl.a(activity, str) : i == 31 ? Api31Impl.b(activity, str) : Api23Impl.c(activity, str);
        }
        return false;
    }

    public static void j(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void k(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void l(Activity activity) {
        Api21Impl.e(activity);
    }
}
