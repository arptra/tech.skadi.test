package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.constant.AccountConstantKt;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R&\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001e"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend;", "Landroidx/window/layout/WindowBackend;", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "component", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;)V", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "", "a", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "b", "(Landroidx/core/util/Consumer;)V", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "extensionWindowBackendLock", "", "Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "c", "Ljava/util/Map;", "activityToListeners", "d", "listenerToActivity", "MulticastConsumer", "window_release"}, k = 1, mv = {1, 6, 0})
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {

    /* renamed from: a  reason: collision with root package name */
    public final WindowLayoutComponent f2021a;
    public final ReentrantLock b = new ReentrantLock();
    public final Map c = new LinkedHashMap();
    public final Map d = new LinkedHashMap();

    @SuppressLint({"NewApi"})
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "Ljava/util/function/Consumer;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "value", "", "a", "(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "listener", "b", "(Landroidx/core/util/Consumer;)V", "d", "", "c", "()Z", "Landroid/app/Activity;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "multicastConsumerLock", "Landroidx/window/layout/WindowLayoutInfo;", "lastKnownValue", "", "Ljava/util/Set;", "registeredListeners", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class MulticastConsumer implements Consumer<WindowLayoutInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f2022a;
        public final ReentrantLock b = new ReentrantLock();
        public WindowLayoutInfo c;
        public final Set d = new LinkedHashSet();

        public MulticastConsumer(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f2022a = activity;
        }

        /* renamed from: a */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(windowLayoutInfo, AccountConstantKt.RESPONSE_VALUE);
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                this.c = ExtensionsWindowLayoutInfoAdapter.f2023a.b(this.f2022a, windowLayoutInfo);
                for (androidx.core.util.Consumer accept : this.d) {
                    accept.accept(this.c);
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final void b(androidx.core.util.Consumer consumer) {
            Intrinsics.checkNotNullParameter(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                WindowLayoutInfo windowLayoutInfo = this.c;
                if (windowLayoutInfo != null) {
                    consumer.accept(windowLayoutInfo);
                }
                this.d.add(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean c() {
            return this.d.isEmpty();
        }

        public final void d(androidx.core.util.Consumer consumer) {
            Intrinsics.checkNotNullParameter(consumer, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                this.d.remove(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public ExtensionWindowLayoutInfoBackend(WindowLayoutComponent windowLayoutComponent) {
        Intrinsics.checkNotNullParameter(windowLayoutComponent, "component");
        this.f2021a = windowLayoutComponent;
    }

    public void a(Activity activity, Executor executor, androidx.core.util.Consumer consumer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "callback");
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.c.get(activity);
            if (multicastConsumer == null) {
                unit = null;
            } else {
                multicastConsumer.b(consumer);
                this.d.put(consumer, activity);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(activity);
                this.c.put(activity, multicastConsumer2);
                this.d.put(consumer, activity);
                multicastConsumer2.b(consumer);
                this.f2021a.addWindowLayoutInfoListener(activity, multicastConsumer2);
            }
            Unit unit2 = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void b(androidx.core.util.Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "callback");
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Activity activity = (Activity) this.d.get(consumer);
            if (activity == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.c.get(activity);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.d(consumer);
            if (multicastConsumer.c()) {
                this.f2021a.removeWindowLayoutInfoListener(multicastConsumer);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
