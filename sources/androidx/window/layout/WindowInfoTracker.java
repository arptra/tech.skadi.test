package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/window/layout/WindowInfoTracker;", "", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "b", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "a", "Companion", "window_release"}, k = 1, mv = {1, 6, 0})
public interface WindowInfoTracker {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f2040a = Companion.f2041a;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/window/layout/WindowInfoTracker$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/window/layout/WindowInfoTracker;", "a", "(Landroid/content/Context;)Landroidx/window/layout/WindowInfoTracker;", "Landroidx/window/layout/WindowBackend;", "b", "(Landroid/content/Context;)Landroidx/window/layout/WindowBackend;", "", "Z", "DEBUG", "", "c", "Ljava/lang/String;", "TAG", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "d", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "decorator", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f2041a = new Companion();
        public static final boolean b = false;
        public static final String c = Reflection.getOrCreateKotlinClass(WindowInfoTracker.class).getSimpleName();
        public static WindowInfoTrackerDecorator d = EmptyDecorator.f2020a;

        public final WindowInfoTracker a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return d.a(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.b, b(context)));
        }

        public final WindowBackend b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ExtensionWindowLayoutInfoBackend extensionWindowLayoutInfoBackend = null;
            try {
                WindowLayoutComponent m = SafeWindowLayoutComponentProvider.f2029a.m();
                if (m != null) {
                    extensionWindowLayoutInfoBackend = new ExtensionWindowLayoutInfoBackend(m);
                }
            } catch (Throwable unused) {
                if (b) {
                    Log.d(c, "Failed to load WindowExtensions");
                }
            }
            return extensionWindowLayoutInfoBackend == null ? SidecarWindowBackend.c.a(context) : extensionWindowLayoutInfoBackend;
        }
    }

    static WindowInfoTracker a(Context context) {
        return f2040a.a(context);
    }

    Flow b(Activity activity);
}
