package androidx.window.layout;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowMetrics;", "b", "(Landroid/app/Activity;)Landroidx/window/layout/WindowMetrics;", "a", "Companion", "window_release"}, k = 1, mv = {1, 6, 0})
public interface WindowMetricsCalculator {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f2044a = Companion.f2045a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator$Companion;", "", "<init>", "()V", "Landroidx/window/layout/WindowMetricsCalculator;", "a", "()Landroidx/window/layout/WindowMetricsCalculator;", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "decorator", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f2045a = new Companion();
        public static Function1 b = WindowMetricsCalculator$Companion$decorator$1.INSTANCE;

        public final WindowMetricsCalculator a() {
            return (WindowMetricsCalculator) b.invoke(WindowMetricsCalculatorCompat.b);
        }
    }

    static WindowMetricsCalculator a() {
        return f2044a.a();
    }

    WindowMetrics b(Activity activity);
}
