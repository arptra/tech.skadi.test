package androidx.core.splashscreen;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/core/splashscreen/ThemeUtils;", "", "()V", "Api31", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThemeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ThemeUtils f817a = new ThemeUtils();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\n\u0010\u0006\u001a\u00060\u0004R\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/core/splashscreen/ThemeUtils$Api31;", "", "<init>", "()V", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "theme", "Landroid/view/View;", "decor", "Landroid/util/TypedValue;", "tv", "", "b", "(Landroid/content/res/Resources$Theme;Landroid/view/View;Landroid/util/TypedValue;)V", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0})
    public static final class Api31 {

        /* renamed from: a  reason: collision with root package name */
        public static final Api31 f818a = new Api31();

        @JvmStatic
        @DoNotInline
        @JvmOverloads
        public static final void a(@NotNull Resources.Theme theme, @NotNull View view) {
            Intrinsics.checkNotNullParameter(theme, "theme");
            Intrinsics.checkNotNullParameter(view, "decor");
            c(theme, view, (TypedValue) null, 4, (Object) null);
        }

        @JvmStatic
        @DoNotInline
        @JvmOverloads
        public static final void b(@NotNull Resources.Theme theme, @NotNull View view, @NotNull TypedValue typedValue) {
            Intrinsics.checkNotNullParameter(theme, "theme");
            Intrinsics.checkNotNullParameter(view, "decor");
            Intrinsics.checkNotNullParameter(typedValue, "tv");
            int i = (!theme.resolveAttribute(16844000, typedValue, true) || typedValue.data == 0) ? 0 : 8;
            if (theme.resolveAttribute(16844140, typedValue, true) && typedValue.data != 0) {
                i |= 16;
            }
            WindowInsetsController a2 = view.getWindowInsetsController();
            Intrinsics.checkNotNull(a2);
            a2.setSystemBarsAppearance(i, 24);
        }

        public static /* synthetic */ void c(Resources.Theme theme, View view, TypedValue typedValue, int i, Object obj) {
            if ((i & 4) != 0) {
                typedValue = new TypedValue();
            }
            b(theme, view, typedValue);
        }
    }
}
