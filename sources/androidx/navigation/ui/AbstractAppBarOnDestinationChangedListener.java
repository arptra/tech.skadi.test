package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.upuphone.starrynet.payload.PayloadConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b!\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H$¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR$\u0010#\u001a\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010 0 \u0018\u00010\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "title", "", "c", "(Ljava/lang/CharSequence;)V", "Landroid/graphics/drawable/Drawable;", "icon", "", "contentDescription", "b", "(Landroid/graphics/drawable/Drawable;I)V", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "x", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "", "showAsDrawerIndicator", "a", "(Z)V", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "Ljava/util/Set;", "topLevelDestinations", "Ljava/lang/ref/WeakReference;", "Landroidx/customview/widget/Openable;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "openableLayoutWeakReference", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "d", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "arrowDrawable", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "animator", "navigation-ui_release"}, k = 1, mv = {1, 6, 0})
@RestrictTo
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1503a;
    public final Set b;
    public final WeakReference c;
    public DrawerArrowDrawable d;
    public ValueAnimator e;

    public final void a(boolean z) {
        DrawerArrowDrawable drawerArrowDrawable = this.d;
        Pair pair = drawerArrowDrawable == null ? null : TuplesKt.to(drawerArrowDrawable, Boolean.TRUE);
        if (pair == null) {
            DrawerArrowDrawable drawerArrowDrawable2 = new DrawerArrowDrawable(this.f1503a);
            this.d = drawerArrowDrawable2;
            pair = TuplesKt.to(drawerArrowDrawable2, Boolean.FALSE);
        }
        DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) pair.component1();
        boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
        b(drawerArrowDrawable3, z ? R.string.nav_app_bar_open_drawer_description : R.string.nav_app_bar_navigate_up_description);
        float f = z ? 0.0f : 1.0f;
        if (booleanValue) {
            float a2 = drawerArrowDrawable3.a();
            ValueAnimator valueAnimator = this.e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawerArrowDrawable3, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, new float[]{a2, f});
            this.e = ofFloat;
            if (ofFloat != null) {
                ofFloat.start();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
        }
        drawerArrowDrawable3.setProgress(f);
    }

    public abstract void b(Drawable drawable, int i);

    public abstract void c(CharSequence charSequence);

    public void x(NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
        if (!(navDestination instanceof FloatingWindow)) {
            WeakReference weakReference = this.c;
            Openable openable = weakReference == null ? null : (Openable) weakReference.get();
            if (this.c == null || openable != null) {
                CharSequence l = navDestination.l();
                boolean z = true;
                if (l != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(l);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle == null || !bundle.containsKey(group)) {
                            throw new IllegalArgumentException("Could not find \"" + group + "\" in " + bundle + " to fill label \"" + l + '\"');
                        }
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(String.valueOf(bundle.get(group)));
                    }
                    matcher.appendTail(stringBuffer);
                    c(stringBuffer);
                }
                boolean b2 = NavigationUI.b(navDestination, this.b);
                if (openable != null || !b2) {
                    if (openable == null || !b2) {
                        z = false;
                    }
                    a(z);
                    return;
                }
                b((Drawable) null, 0);
                return;
            }
            navController.f0(this);
        }
    }
}
