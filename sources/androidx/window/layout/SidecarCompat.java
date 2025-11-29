package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.upuphone.runasone.api.ApiConstant;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 -2\u00020\u0001:\u0005./012B\u001d\b\u0007\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010$R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010&R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020(0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010&R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00063"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "Landroidx/window/sidecar/SidecarInterface;", "sidecar", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "<init>", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "extensionCallback", "", "a", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "h", "(Landroid/app/Activity;)Landroidx/window/layout/WindowLayoutInfo;", "b", "(Landroid/app/Activity;)V", "Landroid/os/IBinder;", "windowToken", "i", "(Landroid/os/IBinder;Landroid/app/Activity;)V", "c", "", "l", "()Z", "j", "k", "Landroidx/window/sidecar/SidecarInterface;", "g", "()Landroidx/window/sidecar/SidecarInterface;", "Landroidx/window/layout/SidecarAdapter;", "", "Ljava/util/Map;", "windowListenerRegisteredContexts", "Landroid/content/ComponentCallbacks;", "d", "componentCallbackMap", "e", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "f", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0})
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final SidecarInterface f2031a;
    public final SidecarAdapter b;
    public final Map c;
    public final Map d;
    public ExtensionInterfaceCompat.ExtensionCallbackInterface e;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/window/sidecar/SidecarInterface;", "b", "(Landroid/content/Context;)Landroidx/window/sidecar/SidecarInterface;", "Landroid/app/Activity;", "activity", "Landroid/os/IBinder;", "a", "(Landroid/app/Activity;)Landroid/os/IBinder;", "Landroidx/window/core/Version;", "c", "()Landroidx/window/core/Version;", "sidecarVersion", "", "TAG", "Ljava/lang/String;", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (!TextUtils.isEmpty(apiVersion)) {
                    return Version.f.b(apiVersion);
                }
                return null;
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "<init>", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "newLayout", "", "a", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "activityWindowLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* renamed from: a  reason: collision with root package name */
        public final ExtensionInterfaceCompat.ExtensionCallbackInterface f2032a;
        public final ReentrantLock b = new ReentrantLock();
        public final WeakHashMap c = new WeakHashMap();

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            Intrinsics.checkNotNullParameter(extensionCallbackInterface, "callbackInterface");
            this.f2032a = extensionCallbackInterface;
        }

        public void a(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "newLayout");
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                if (!Intrinsics.areEqual((Object) windowLayoutInfo, (Object) (WindowLayoutInfo) this.c.get(activity))) {
                    WindowLayoutInfo windowLayoutInfo2 = (WindowLayoutInfo) this.c.put(activity, windowLayoutInfo);
                    reentrantLock.unlock();
                    this.f2032a.a(activity, windowLayoutInfo);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "callbackInterface", "<init>", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "a", "Landroidx/window/layout/SidecarAdapter;", "b", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "d", "Landroidx/window/sidecar/SidecarDeviceState;", "lastDeviceState", "Ljava/util/WeakHashMap;", "e", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a  reason: collision with root package name */
        public final SidecarAdapter f2033a;
        public final SidecarInterface.SidecarCallback b;
        public final ReentrantLock c = new ReentrantLock();
        public SidecarDeviceState d;
        public final WeakHashMap e = new WeakHashMap();

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
            Intrinsics.checkNotNullParameter(sidecarAdapter, "sidecarAdapter");
            Intrinsics.checkNotNullParameter(sidecarCallback, "callbackInterface");
            this.f2033a = sidecarAdapter;
            this.b = sidecarCallback;
        }

        public void onDeviceStateChanged(@NotNull SidecarDeviceState sidecarDeviceState) {
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                if (!this.f2033a.a(this.d, sidecarDeviceState)) {
                    this.d = sidecarDeviceState;
                    this.b.onDeviceStateChanged(sidecarDeviceState);
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(@NotNull IBinder iBinder, @NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            Intrinsics.checkNotNullParameter(iBinder, ApiConstant.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "newLayout");
            synchronized (this.c) {
                if (!this.f2033a.d((SidecarWindowLayoutInfo) this.e.get(iBinder), sidecarWindowLayoutInfo)) {
                    SidecarWindowLayoutInfo sidecarWindowLayoutInfo2 = (SidecarWindowLayoutInfo) this.e.put(iBinder, sidecarWindowLayoutInfo);
                    this.b.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00040\u00040\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/window/layout/SidecarCompat;", "sidecarCompat", "Landroid/app/Activity;", "activity", "<init>", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "a", "Landroidx/window/layout/SidecarCompat;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "b", "Ljava/lang/ref/WeakReference;", "activityWeakReference", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final SidecarCompat f2034a;
        public final WeakReference b;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "sidecarCompat");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f2034a = sidecarCompat;
            this.b = new WeakReference(activity);
        }

        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.b.get();
            IBinder a2 = SidecarCompat.f.a(activity);
            if (activity != null && a2 != null) {
                this.f2034a.i(a2, activity);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SidecarCompat f2035a;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "this$0");
            this.f2035a = sidecarCompat;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(@NotNull SidecarDeviceState sidecarDeviceState) {
            SidecarInterface g;
            Intrinsics.checkNotNullParameter(sidecarDeviceState, "newDeviceState");
            Collection<Activity> values = this.f2035a.c.values();
            SidecarCompat sidecarCompat = this.f2035a;
            for (Activity activity : values) {
                IBinder a2 = SidecarCompat.f.a(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (!(a2 == null || (g = sidecarCompat.g()) == null)) {
                    sidecarWindowLayoutInfo = g.getWindowLayoutInfo(a2);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface d = sidecarCompat.e;
                if (d != null) {
                    d.a(activity, sidecarCompat.b.e(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(@NotNull IBinder iBinder, @NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            Intrinsics.checkNotNullParameter(iBinder, "windowToken");
            Intrinsics.checkNotNullParameter(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = (Activity) this.f2035a.c.get(iBinder);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter e = this.f2035a.b;
            SidecarInterface g = this.f2035a.g();
            SidecarDeviceState deviceState = g == null ? null : g.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo e2 = e.e(sidecarWindowLayoutInfo, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface d = this.f2035a.e;
            if (d != null) {
                d.a(activity, e2);
            }
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        Intrinsics.checkNotNullParameter(sidecarAdapter, "sidecarAdapter");
        this.f2031a = sidecarInterface;
        this.b = sidecarAdapter;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public void a(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        Intrinsics.checkNotNullParameter(extensionCallbackInterface, "extensionCallback");
        this.e = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.f2031a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.b, new TranslatingCallback(this)));
        }
    }

    public void b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder a2 = f.a(activity);
        if (a2 != null) {
            i(a2, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
    }

    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder a2 = f.a(activity);
        if (a2 != null) {
            SidecarInterface sidecarInterface2 = this.f2031a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(a2);
            }
            k(activity);
            boolean z = this.c.size() == 1;
            this.c.remove(a2);
            if (z && (sidecarInterface = this.f2031a) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    public final SidecarInterface g() {
        return this.f2031a;
    }

    public final WindowLayoutInfo h(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder a2 = f.a(activity);
        if (a2 == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }
        SidecarInterface sidecarInterface = this.f2031a;
        SidecarDeviceState sidecarDeviceState = null;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(a2);
        SidecarAdapter sidecarAdapter = this.b;
        SidecarInterface sidecarInterface2 = this.f2031a;
        if (sidecarInterface2 != null) {
            sidecarDeviceState = sidecarInterface2.getDeviceState();
        }
        if (sidecarDeviceState == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void i(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(iBinder, "windowToken");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f2031a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.c.size() == 1 && (sidecarInterface = this.f2031a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.e;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.a(activity, h(activity));
        }
        j(activity);
    }

    public final void j(Activity activity) {
        if (this.d.get(activity) == null) {
            SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, activity);
            this.d.put(activity, sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
            activity.registerComponentCallbacks(sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
        }
    }

    public final void k(Activity activity) {
        activity.unregisterComponentCallbacks((ComponentCallbacks) this.d.get(activity));
        this.d.remove(activity);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0106 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ae A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0131 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0142 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015a A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0166 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0172 A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x017e A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[Catch:{ NoSuchFieldError -> 0x00b7, all -> 0x018a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l() {
        /*
            r7 = this;
            androidx.window.sidecar.SidecarInterface r0 = r7.f2031a     // Catch:{ all -> 0x018a }
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = r1
            goto L_0x001a
        L_0x0007:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            java.lang.String r2 = "setSidecarCallback"
            java.lang.Class<androidx.window.sidecar.SidecarInterface$SidecarCallback> r3 = androidx.window.sidecar.SidecarInterface.SidecarCallback.class
            java.lang.Class[] r3 = new java.lang.Class[]{r3}     // Catch:{ all -> 0x018a }
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch:{ all -> 0x018a }
        L_0x001a:
            if (r0 != 0) goto L_0x001e
            r0 = r1
            goto L_0x0022
        L_0x001e:
            java.lang.Class r0 = r0.getReturnType()     // Catch:{ all -> 0x018a }
        L_0x0022:
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ all -> 0x018a }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ all -> 0x018a }
            if (r3 == 0) goto L_0x017e
            androidx.window.sidecar.SidecarInterface r0 = r7.f2031a     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x002f
            goto L_0x0032
        L_0x002f:
            r0.getDeviceState()     // Catch:{ all -> 0x018a }
        L_0x0032:
            androidx.window.sidecar.SidecarInterface r0 = r7.f2031a     // Catch:{ all -> 0x018a }
            r3 = 1
            if (r0 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r0.onDeviceStateListenersChanged(r3)     // Catch:{ all -> 0x018a }
        L_0x003b:
            androidx.window.sidecar.SidecarInterface r0 = r7.f2031a     // Catch:{ all -> 0x018a }
            java.lang.Class<android.os.IBinder> r4 = android.os.IBinder.class
            if (r0 != 0) goto L_0x0043
        L_0x0041:
            r0 = r1
            goto L_0x0054
        L_0x0043:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x004a
            goto L_0x0041
        L_0x004a:
            java.lang.String r5 = "getWindowLayoutInfo"
            java.lang.Class[] r6 = new java.lang.Class[]{r4}     // Catch:{ all -> 0x018a }
            java.lang.reflect.Method r0 = r0.getMethod(r5, r6)     // Catch:{ all -> 0x018a }
        L_0x0054:
            if (r0 != 0) goto L_0x0058
            r0 = r1
            goto L_0x005c
        L_0x0058:
            java.lang.Class r0 = r0.getReturnType()     // Catch:{ all -> 0x018a }
        L_0x005c:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r5 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)     // Catch:{ all -> 0x018a }
            if (r5 == 0) goto L_0x0172
            androidx.window.sidecar.SidecarInterface r0 = r7.f2031a     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x006a
        L_0x0068:
            r0 = r1
            goto L_0x007b
        L_0x006a:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x018a }
            if (r0 != 0) goto L_0x0071
            goto L_0x0068
        L_0x0071:
            java.lang.String r5 = "onWindowLayoutChangeListenerAdded"
            java.lang.Class[] r6 = new java.lang.Class[]{r4}     // Catch:{ all -> 0x018a }
            java.lang.reflect.Method r0 = r0.getMethod(r5, r6)     // Catch:{ all -> 0x018a }
        L_0x007b:
            if (r0 != 0) goto L_0x007f
            r0 = r1
            goto L_0x0083
        L_0x007f:
            java.lang.Class r0 = r0.getReturnType()     // Catch:{ all -> 0x018a }
        L_0x0083:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ all -> 0x018a }
            if (r5 == 0) goto L_0x0166
            androidx.window.sidecar.SidecarInterface r7 = r7.f2031a     // Catch:{ all -> 0x018a }
            if (r7 != 0) goto L_0x008f
        L_0x008d:
            r7 = r1
            goto L_0x00a0
        L_0x008f:
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x018a }
            if (r7 != 0) goto L_0x0096
            goto L_0x008d
        L_0x0096:
            java.lang.String r0 = "onWindowLayoutChangeListenerRemoved"
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch:{ all -> 0x018a }
            java.lang.reflect.Method r7 = r7.getMethod(r0, r4)     // Catch:{ all -> 0x018a }
        L_0x00a0:
            if (r7 != 0) goto L_0x00a4
            r7 = r1
            goto L_0x00a8
        L_0x00a4:
            java.lang.Class r7 = r7.getReturnType()     // Catch:{ all -> 0x018a }
        L_0x00a8:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r2)     // Catch:{ all -> 0x018a }
            if (r0 == 0) goto L_0x015a
            androidx.window.sidecar.SidecarDeviceState r7 = new androidx.window.sidecar.SidecarDeviceState     // Catch:{ all -> 0x018a }
            r7.<init>()     // Catch:{ all -> 0x018a }
            r0 = 3
            r7.posture = r0     // Catch:{ NoSuchFieldError -> 0x00b7 }
            goto L_0x00e6
        L_0x00b7:
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r2 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r4 = "setPosture"
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x018a }
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch:{ all -> 0x018a }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x018a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x018a }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x018a }
            r2.invoke(r7, r4)     // Catch:{ all -> 0x018a }
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r2 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r4 = "getPosture"
            java.lang.reflect.Method r2 = r2.getMethod(r4, r1)     // Catch:{ all -> 0x018a }
            java.lang.Object r7 = r2.invoke(r7, r1)     // Catch:{ all -> 0x018a }
            if (r7 == 0) goto L_0x0152
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x018a }
            int r7 = r7.intValue()     // Catch:{ all -> 0x018a }
            if (r7 != r0) goto L_0x014a
        L_0x00e6:
            androidx.window.sidecar.SidecarDisplayFeature r7 = new androidx.window.sidecar.SidecarDisplayFeature     // Catch:{ all -> 0x018a }
            r7.<init>()     // Catch:{ all -> 0x018a }
            android.graphics.Rect r0 = r7.getRect()     // Catch:{ all -> 0x018a }
            java.lang.String r2 = "displayFeature.rect"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x018a }
            r7.setRect(r0)     // Catch:{ all -> 0x018a }
            r7.getType()     // Catch:{ all -> 0x018a }
            r7.setType(r3)     // Catch:{ all -> 0x018a }
            androidx.window.sidecar.SidecarWindowLayoutInfo r0 = new androidx.window.sidecar.SidecarWindowLayoutInfo     // Catch:{ all -> 0x018a }
            r0.<init>()     // Catch:{ all -> 0x018a }
            java.util.List r7 = r0.displayFeatures     // Catch:{ NoSuchFieldError -> 0x0106 }
            goto L_0x018b
        L_0x0106:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x018a }
            r2.<init>()     // Catch:{ all -> 0x018a }
            r2.add(r7)     // Catch:{ all -> 0x018a }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r7 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r4 = "setDisplayFeatures"
            java.lang.Class<java.util.List> r5 = java.util.List.class
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch:{ all -> 0x018a }
            java.lang.reflect.Method r7 = r7.getMethod(r4, r5)     // Catch:{ all -> 0x018a }
            java.lang.Object[] r4 = new java.lang.Object[]{r2}     // Catch:{ all -> 0x018a }
            r7.invoke(r0, r4)     // Catch:{ all -> 0x018a }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r7 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r4 = "getDisplayFeatures"
            java.lang.reflect.Method r7 = r7.getMethod(r4, r1)     // Catch:{ all -> 0x018a }
            java.lang.Object r7 = r7.invoke(r0, r1)     // Catch:{ all -> 0x018a }
            if (r7 == 0) goto L_0x0142
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x018a }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)     // Catch:{ all -> 0x018a }
            if (r7 == 0) goto L_0x013a
            goto L_0x018b
        L_0x013a:
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x018a }
            java.lang.String r0 = "Invalid display feature getter/setter"
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x0142:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ all -> 0x018a }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x014a:
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x018a }
            java.lang.String r0 = "Invalid device posture getter/setter"
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x0152:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ all -> 0x018a }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Int"
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x015a:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018a }
            java.lang.String r1 = "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r7)     // Catch:{ all -> 0x018a }
            r0.<init>(r7)     // Catch:{ all -> 0x018a }
            throw r0     // Catch:{ all -> 0x018a }
        L_0x0166:
            java.lang.NoSuchMethodException r7 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018a }
            java.lang.String r1 = "Illegal return type for 'onWindowLayoutChangeListenerAdded': "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)     // Catch:{ all -> 0x018a }
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x0172:
            java.lang.NoSuchMethodException r7 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018a }
            java.lang.String r1 = "Illegal return type for 'getWindowLayoutInfo': "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)     // Catch:{ all -> 0x018a }
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x017e:
            java.lang.NoSuchMethodException r7 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018a }
            java.lang.String r1 = "Illegal return type for 'setSidecarCallback': "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)     // Catch:{ all -> 0x018a }
            r7.<init>(r0)     // Catch:{ all -> 0x018a }
            throw r7     // Catch:{ all -> 0x018a }
        L_0x018a:
            r3 = 0
        L_0x018b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.l():boolean");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f.b(context), new SidecarAdapter((SpecificationComputer.VerificationMode) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
