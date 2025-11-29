package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import androidx.window.layout.ExtensionInterfaceCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"androidx/window/layout/SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1", "Landroid/content/ComponentCallbacks;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 implements ComponentCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SidecarCompat f2036a;
    public final /* synthetic */ Activity b;

    public SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(SidecarCompat sidecarCompat, Activity activity) {
        this.f2036a = sidecarCompat;
        this.b = activity;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        ExtensionInterfaceCompat.ExtensionCallbackInterface d = this.f2036a.e;
        if (d != null) {
            Activity activity = this.b;
            d.a(activity, this.f2036a.h(activity));
        }
    }

    public void onLowMemory() {
    }
}
