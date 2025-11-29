package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 ¨\u0006\""}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowMetrics;", "c", "(Landroid/app/Activity;)Landroidx/window/layout/WindowMetrics;", "b", "Landroid/graphics/Rect;", "e", "(Landroid/app/Activity;)Landroid/graphics/Rect;", "d", "Landroid/view/Display;", "display", "Landroid/graphics/Point;", "h", "(Landroid/view/Display;)Landroid/graphics/Point;", "bounds", "", "i", "(Landroid/app/Activity;Landroid/graphics/Rect;)V", "Landroid/content/Context;", "context", "", "g", "(Landroid/content/Context;)I", "Landroid/view/DisplayCutout;", "f", "(Landroid/view/Display;)Landroid/view/DisplayCutout;", "", "Ljava/lang/String;", "TAG", "window_release"}, k = 1, mv = {1, 6, 0})
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat b = new WindowMetricsCalculatorCompat();
    public static final String c;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        c = simpleName;
    }

    public WindowMetrics b(Activity activity) {
        Rect rect;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 30) {
            rect = ActivityCompatHelperApi30.f2017a.b(activity);
        } else {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "display");
            Point h = h(defaultDisplay);
            rect = new Rect(0, 0, h.x, h.y);
        }
        return new WindowMetrics(rect);
    }

    public WindowMetrics c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new WindowMetrics(Build.VERSION.SDK_INT >= 30 ? ActivityCompatHelperApi30.f2017a.a(activity) : e(activity));
    }

    public final Rect d(Activity activity) {
        DisplayCutout f;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.f2016a.a(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", (Class[]) null).invoke(obj, (Object[]) null);
                if (invoke != null) {
                    rect.set((Rect) invoke);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", (Class[]) null).invoke(obj, (Object[]) null);
                if (invoke2 != null) {
                    rect.set((Rect) invoke2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            }
        } catch (NoSuchFieldException e) {
            Log.w(c, e);
            i(activity, rect);
        } catch (NoSuchMethodException e2) {
            Log.w(c, e2);
            i(activity, rect);
        } catch (IllegalAccessException e3) {
            Log.w(c, e3);
            i(activity, rect);
        } catch (InvocationTargetException e4) {
            Log.w(c, e4);
            i(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.f2018a;
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "currentDisplay");
        displayCompatHelperApi17.a(defaultDisplay, point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.f2016a;
        if (!activityCompatHelperApi24.a(activity)) {
            int g = g(activity);
            int i = rect.bottom;
            if (i + g == point.y) {
                rect.bottom = i + g;
            } else {
                int i2 = rect.right;
                if (i2 + g == point.x) {
                    rect.right = i2 + g;
                } else if (rect.left == g) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.a(activity) && (f = f(defaultDisplay)) != null) {
            int i3 = rect.left;
            DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.f2019a;
            if (i3 == displayCompatHelperApi28.b(f)) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCompatHelperApi28.c(f)) {
                rect.right += displayCompatHelperApi28.c(f);
            }
            if (rect.top == displayCompatHelperApi28.d(f)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCompatHelperApi28.a(f)) {
                rect.bottom += displayCompatHelperApi28.a(f);
            }
        }
        return rect;
    }

    public final Rect e(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", (Class[]) null).invoke(obj, (Object[]) null);
            if (invoke != null) {
                return new Rect((Rect) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (NoSuchFieldException e) {
            Log.w(c, e);
            return d(activity);
        } catch (NoSuchMethodException e2) {
            Log.w(c, e2);
            return d(activity);
        } catch (IllegalAccessException e3) {
            Log.w(c, e3);
            return d(activity);
        } catch (InvocationTargetException e4) {
            Log.w(c, e4);
            return d(activity);
        }
    }

    public final DisplayCutout f(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor((Class[]) null);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance((Object[]) null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{newInstance.getClass()});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, new Object[]{newInstance});
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
            return null;
        } catch (ClassNotFoundException e) {
            Log.w(c, e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.w(c, e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Log.w(c, e3);
            return null;
        } catch (IllegalAccessException e4) {
            Log.w(c, e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w(c, e5);
            return null;
        } catch (InstantiationException e6) {
            Log.w(c, e6);
            return null;
        }
    }

    public final int g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final Point h(Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        Point point = new Point();
        DisplayCompatHelperApi17.f2018a.a(display, point);
        return point;
    }

    public final void i(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
