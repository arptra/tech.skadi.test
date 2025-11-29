package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import com.honey.account.h0.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 #2\u00020\u0001:\u0003$%&B\u0013\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0005R&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/WindowBackend;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "windowExtension", "<init>", "(Landroidx/window/layout/ExtensionInterfaceCompat;)V", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "", "a", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "b", "(Landroidx/core/util/Consumer;)V", "", "i", "(Landroid/app/Activity;)Z", "f", "(Landroid/app/Activity;)V", "Landroidx/window/layout/ExtensionInterfaceCompat;", "g", "()Landroidx/window/layout/ExtensionInterfaceCompat;", "setWindowExtension", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "h", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getWindowLayoutChangeCallbacks$annotations", "()V", "windowLayoutChangeCallbacks", "c", "Companion", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper", "window_release"}, k = 1, mv = {1, 6, 0})
public final class SidecarWindowBackend implements WindowBackend {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static volatile SidecarWindowBackend d;
    public static final ReentrantLock e = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    public ExtensionInterfaceCompat f2037a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/window/layout/SidecarWindowBackend;", "a", "(Landroid/content/Context;)Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "b", "(Landroid/content/Context;)Landroidx/window/layout/ExtensionInterfaceCompat;", "Landroidx/window/core/Version;", "sidecarVersion", "", "c", "(Landroidx/window/core/Version;)Z", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "globalInstance", "Landroidx/window/layout/SidecarWindowBackend;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SidecarWindowBackend a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (SidecarWindowBackend.d == null) {
                ReentrantLock d = SidecarWindowBackend.e;
                d.lock();
                try {
                    if (SidecarWindowBackend.d == null) {
                        SidecarWindowBackend.d = new SidecarWindowBackend(SidecarWindowBackend.c.b(context));
                    }
                    Unit unit = Unit.INSTANCE;
                    d.unlock();
                } catch (Throwable th) {
                    d.unlock();
                    throw th;
                }
            }
            SidecarWindowBackend c = SidecarWindowBackend.d;
            Intrinsics.checkNotNull(c);
            return c;
        }

        public final ExtensionInterfaceCompat b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (!c(SidecarCompat.f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (!sidecarCompat.l()) {
                    return null;
                }
                return sidecarCompat;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(Version version) {
            return version != null && version.compareTo(Version.f.a()) >= 0;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "<init>", "(Landroidx/window/layout/SidecarWindowBackend;)V", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "newLayout", "", "a", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    @VisibleForTesting
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SidecarWindowBackend f2038a;

        public ExtensionListenerImpl(SidecarWindowBackend sidecarWindowBackend) {
            Intrinsics.checkNotNullParameter(sidecarWindowBackend, "this$0");
            this.f2038a = sidecarWindowBackend;
        }

        public void a(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "newLayout");
            Iterator it = this.f2038a.h().iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = (WindowLayoutChangeCallbackWrapper) it.next();
                if (Intrinsics.areEqual((Object) windowLayoutChangeCallbackWrapper.d(), (Object) activity)) {
                    windowLayoutChangeCallbackWrapper.b(windowLayoutInfo);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u000e¨\u0006\u001d"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "newLayoutInfo", "", "b", "(Landroidx/window/layout/WindowLayoutInfo;)V", "a", "Landroid/app/Activity;", "d", "()Landroid/app/Activity;", "Ljava/util/concurrent/Executor;", "c", "Landroidx/core/util/Consumer;", "e", "()Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "f", "()Landroidx/window/layout/WindowLayoutInfo;", "setLastInfo", "lastInfo", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class WindowLayoutChangeCallbackWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f2039a;
        public final Executor b;
        public final Consumer c;
        public WindowLayoutInfo d;

        public WindowLayoutChangeCallbackWrapper(Activity activity, Executor executor, Consumer consumer) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(consumer, "callback");
            this.f2039a = activity;
            this.b = executor;
            this.c = consumer;
        }

        public static final void c(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(windowLayoutChangeCallbackWrapper, "this$0");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "$newLayoutInfo");
            windowLayoutChangeCallbackWrapper.c.accept(windowLayoutInfo);
        }

        public final void b(WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "newLayoutInfo");
            this.d = windowLayoutInfo;
            this.b.execute(new d(this, windowLayoutInfo));
        }

        public final Activity d() {
            return this.f2039a;
        }

        public final Consumer e() {
            return this.c;
        }

        public final WindowLayoutInfo f() {
            return this.d;
        }
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.f2037a = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.f2037a;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.a(new ExtensionListenerImpl(this));
        }
    }

    public void a(Activity activity, Executor executor, Consumer consumer) {
        WindowLayoutInfo windowLayoutInfo;
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "callback");
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat g = g();
            if (g == null) {
                consumer.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
                return;
            }
            boolean i = i(activity);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, consumer);
            h().add(windowLayoutChangeCallbackWrapper);
            if (!i) {
                g.b(activity);
            } else {
                Iterator it = h().iterator();
                while (true) {
                    windowLayoutInfo = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) activity, (Object) ((WindowLayoutChangeCallbackWrapper) obj).d())) {
                        break;
                    }
                }
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) obj;
                if (windowLayoutChangeCallbackWrapper2 != null) {
                    windowLayoutInfo = windowLayoutChangeCallbackWrapper2.f();
                }
                if (windowLayoutInfo != null) {
                    windowLayoutChangeCallbackWrapper.b(windowLayoutInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "callback");
        synchronized (e) {
            try {
                if (g() != null) {
                    ArrayList<WindowLayoutChangeCallbackWrapper> arrayList = new ArrayList<>();
                    Iterator it = h().iterator();
                    while (it.hasNext()) {
                        WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = (WindowLayoutChangeCallbackWrapper) it.next();
                        if (windowLayoutChangeCallbackWrapper.e() == consumer) {
                            Intrinsics.checkNotNullExpressionValue(windowLayoutChangeCallbackWrapper, "callbackWrapper");
                            arrayList.add(windowLayoutChangeCallbackWrapper);
                        }
                    }
                    h().removeAll(arrayList);
                    for (WindowLayoutChangeCallbackWrapper d2 : arrayList) {
                        f(d2.d());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
            }
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.b;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            for (WindowLayoutChangeCallbackWrapper d2 : copyOnWriteArrayList) {
                if (Intrinsics.areEqual((Object) d2.d(), (Object) activity)) {
                    return;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat = this.f2037a;
        if (extensionInterfaceCompat != null) {
            extensionInterfaceCompat.c(activity);
        }
    }

    public final ExtensionInterfaceCompat g() {
        return this.f2037a;
    }

    public final CopyOnWriteArrayList h() {
        return this.b;
    }

    public final boolean i(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (WindowLayoutChangeCallbackWrapper d2 : copyOnWriteArrayList) {
            if (Intrinsics.areEqual((Object) d2.d(), (Object) activity)) {
                return true;
            }
        }
        return false;
    }
}
