package dagger.hilt.android;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u0007J)\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0007¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\f\u001a\u00020\rH\b¢\u0006\u0002\u0010\u000eJ)\u0010\u000b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0007¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\b¢\u0006\u0002\u0010\u0013J)\u0010\u0010\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0007¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\b¢\u0006\u0002\u0010\u0018J)\u0010\u0015\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldagger/hilt/android/EntryPointAccessors;", "", "()V", "fromActivity", "T", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Ljava/lang/Object;", "entryPoint", "Ljava/lang/Class;", "(Landroid/app/Activity;Ljava/lang/Class;)Ljava/lang/Object;", "fromApplication", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;", "fromFragment", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Object;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;)Ljava/lang/Object;", "fromView", "view", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Object;", "(Landroid/view/View;Ljava/lang/Class;)Ljava/lang/Object;", "java_dagger_hilt_android-entry_point_accessors_internal_kt"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EntryPointAccessors {
    @NotNull
    public static final EntryPointAccessors INSTANCE = new EntryPointAccessors();

    private EntryPointAccessors() {
    }

    @JvmStatic
    public static final <T> T fromActivity(@NotNull Activity activity, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cls, "entryPoint");
        return EntryPoints.get(activity, cls);
    }

    @JvmStatic
    public static final <T> T fromApplication(@NotNull Context context, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "entryPoint");
        return EntryPoints.get(Contexts.getApplication(context.getApplicationContext()), cls);
    }

    @JvmStatic
    public static final <T> T fromFragment(@NotNull Fragment fragment, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cls, "entryPoint");
        return EntryPoints.get(fragment, cls);
    }

    @JvmStatic
    public static final <T> T fromView(@NotNull View view, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(cls, "entryPoint");
        return EntryPoints.get(view, cls);
    }

    public final /* synthetic */ <T> T fromActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fromActivity(activity, Object.class);
    }

    public final /* synthetic */ <T> T fromApplication(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fromApplication(context, Object.class);
    }

    public final /* synthetic */ <T> T fromFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fromFragment(fragment, Object.class);
    }

    public final /* synthetic */ <T> T fromView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return fromView(view, Object.class);
    }
}
