package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/DisplayCompatHelperApi17;", "", "<init>", "()V", "Landroid/view/Display;", "display", "Landroid/graphics/Point;", "point", "", "a", "(Landroid/view/Display;Landroid/graphics/Point;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class DisplayCompatHelperApi17 {

    /* renamed from: a  reason: collision with root package name */
    public static final DisplayCompatHelperApi17 f2018a = new DisplayCompatHelperApi17();

    public final void a(Display display, Point point) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(point, "point");
        display.getRealSize(point);
    }
}
