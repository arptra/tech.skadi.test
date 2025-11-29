package com.upuphone.xr.sapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.ActivityFeedbackBinding;
import com.upuphone.xr.sapp.entity.WindowFocusChangeListener;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/upuphone/xr/sapp/FeedbackActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "finish", "", "hasFocus", "onWindowFocusChanged", "(Z)V", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "arguments", "x", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Landroidx/appcompat/app/ActionBar;", "actionBar", "s0", "(Landroidx/appcompat/app/ActionBar;)V", "Lcom/upuphone/xr/sapp/databinding/ActivityFeedbackBinding;", "b", "Lcom/upuphone/xr/sapp/databinding/ActivityFeedbackBinding;", "binding", "c", "Landroidx/navigation/NavController;", "navController", "Lcom/upuphone/xr/sapp/entity/WindowFocusChangeListener;", "d", "Lcom/upuphone/xr/sapp/entity/WindowFocusChangeListener;", "windowFocusChangeListener", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFeedbackActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedbackActivity.kt\ncom/upuphone/xr/sapp/FeedbackActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n1#2:119\n*E\n"})
public final class FeedbackActivity extends BaseActivity implements NavController.OnDestinationChangedListener {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public ActivityFeedbackBinding b;
    public NavController c;
    public WindowFocusChangeListener d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/FeedbackActivity$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.next_close_enter, R.anim.next_close_exit);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityFeedbackBinding c2 = ActivityFeedbackBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.b = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        setContentView((View) c2.getRoot());
        setRequestedOrientation(1);
        fitNavigationBar(true);
        fitSystemWindow(true);
        fitStatusBar(true);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().o0(R.id.my_feedback_navi);
        if (navHostFragment != null) {
            NavController j0 = navHostFragment.j0();
            this.c = j0;
            if (j0 != null) {
                j0.p(this);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            s0(supportActionBar);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.d = null;
        NavController navController = this.c;
        if (navController != null) {
            navController.f0(this);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        WindowFocusChangeListener windowFocusChangeListener = this.d;
        if (windowFocusChangeListener != null) {
            windowFocusChangeListener.onWindowFocusChanged(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s0(androidx.appcompat.app.ActionBar r4) {
        /*
            r3 = this;
            java.lang.String r3 = "getDeclaredField(...)"
            java.lang.Class r0 = r4.getClass()     // Catch:{ Exception -> 0x001c }
            java.lang.String r1 = "setShowHideAnimationEnabled"
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x001c }
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch:{ Exception -> 0x001c }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x001c }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x001c }
            java.lang.Object[] r1 = new java.lang.Object[]{r1}     // Catch:{ Exception -> 0x001c }
            r0.invoke(r4, r1)     // Catch:{ Exception -> 0x001c }
            goto L_0x0063
        L_0x001c:
            java.lang.Class r0 = r4.getClass()     // Catch:{ Exception -> 0x0063 }
            java.lang.Class r0 = r0.getSuperclass()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r1 = "mActionBar"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ Exception -> 0x0063 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ Exception -> 0x0063 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r0 = "get(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ Exception -> 0x0063 }
            java.lang.Class r0 = r4.getClass()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r2 = "mShowHideAnimationEnabled"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0063 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ Exception -> 0x0063 }
            r0.setAccessible(r1)     // Catch:{ Exception -> 0x0063 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0063 }
            r0.set(r4, r2)     // Catch:{ Exception -> 0x0063 }
            java.lang.Class r0 = r4.getClass()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r2 = "mCurrentShowAnim"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0063 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ Exception -> 0x0063 }
            r0.setAccessible(r1)     // Catch:{ Exception -> 0x0063 }
            r3 = 0
            r0.set(r4, r3)     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.FeedbackActivity.s0(androidx.appcompat.app.ActionBar):void");
    }

    public void x(NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
        ULog.Delegate delegate = ULog.f6446a;
        CharSequence l = navDestination.l();
        delegate.a("FeedbackActivity", "registerNaviCallback::destination is: " + l + " and arguments is: " + bundle);
    }
}
