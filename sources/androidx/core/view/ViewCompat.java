package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import com.honey.account.q.r;
import com.honey.account.q.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {

    /* renamed from: a  reason: collision with root package name */
    public static WeakHashMap f886a;
    public static final int[] b = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final OnReceiveContentViewBehavior c = new r();
    public static final AccessibilityPaneVisibilityManager d = new AccessibilityPaneVisibilityManager();

    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakHashMap f887a = new WeakHashMap();

        public void a(View view) {
            this.f887a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                b(view);
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void c(View view) {
            this.f887a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
        }

        public final void d(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class AccessibilityViewProperty<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f888a;
        public final Class b;
        public final int c;
        public final int d;

        public AccessibilityViewProperty(int i, Class cls, int i2) {
            this(i, cls, 0, i2);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        public abstract Object c(View view);

        public abstract void d(View view, Object obj);

        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f888a);
            if (this.b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                ViewCompat.i(view);
                view.setTag(this.f888a, obj);
                ViewCompat.c0(view, this.d);
            }
        }

        public boolean g(Object obj, Object obj2) {
            return !obj2.equals(obj);
        }

        public AccessibilityViewProperty(int i, Class cls, int i2, int i3) {
            this.f888a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }
    }

    @RequiresApi
    public static class Api20Impl {
        @DoNotInline
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @DoNotInline
        public static WindowInsetsCompat b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets w = windowInsetsCompat.w();
            if (w != null) {
                return WindowInsetsCompat.y(view.computeSystemWindowInsets(w, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @DoNotInline
        public static boolean c(@NonNull View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        @DoNotInline
        public static boolean d(@NonNull View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        @DoNotInline
        public static boolean e(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        @DoNotInline
        public static boolean f(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        @DoNotInline
        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @DoNotInline
        public static float i(View view) {
            return view.getElevation();
        }

        @DoNotInline
        @Nullable
        public static WindowInsetsCompat j(@NonNull View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.a(view);
        }

        @DoNotInline
        public static String k(View view) {
            return view.getTransitionName();
        }

        @DoNotInline
        public static float l(View view) {
            return view.getTranslationZ();
        }

        @DoNotInline
        public static float m(@NonNull View view) {
            return view.getZ();
        }

        @DoNotInline
        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        @DoNotInline
        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        @DoNotInline
        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        @DoNotInline
        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @DoNotInline
        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @DoNotInline
        public static void s(View view, float f) {
            view.setElevation(f);
        }

        @DoNotInline
        public static void t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        @DoNotInline
        public static void u(@NonNull final View view, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {

                    /* renamed from: a  reason: collision with root package name */
                    public WindowInsetsCompat f889a = null;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        WindowInsetsCompat y = WindowInsetsCompat.y(windowInsets, view);
                        int i = Build.VERSION.SDK_INT;
                        if (i < 30) {
                            Api21Impl.a(windowInsets, view);
                            if (y.equals(this.f889a)) {
                                return onApplyWindowInsetsListener.onApplyWindowInsets(view, y).w();
                            }
                        }
                        this.f889a = y;
                        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, y);
                        if (i >= 30) {
                            return onApplyWindowInsets.w();
                        }
                        ViewCompat.q0(view);
                        return onApplyWindowInsets.w();
                    }
                });
            }
        }

        @DoNotInline
        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        @DoNotInline
        public static void w(View view, float f) {
            view.setTranslationZ(f);
        }

        @DoNotInline
        public static void x(@NonNull View view, float f) {
            view.setZ(f);
        }

        @DoNotInline
        public static boolean y(View view, int i) {
            return view.startNestedScroll(i);
        }

        @DoNotInline
        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @Nullable
        public static WindowInsetsCompat a(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat x = WindowInsetsCompat.x(rootWindowInsets);
            x.u(x);
            x.d(view.getRootView());
            return x;
        }

        @DoNotInline
        public static int b(@NonNull View view) {
            return view.getScrollIndicators();
        }

        @DoNotInline
        public static void c(@NonNull View view, int i) {
            view.setScrollIndicators(i);
        }

        @DoNotInline
        public static void d(@NonNull View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static void a(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        @DoNotInline
        public static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        public static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        public static void d(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        @DoNotInline
        public static boolean e(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        @DoNotInline
        public static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static void a(@NonNull View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        @DoNotInline
        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        @DoNotInline
        public static int c(View view) {
            return view.getImportantForAutofill();
        }

        @DoNotInline
        public static int d(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        @DoNotInline
        public static boolean e(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        @DoNotInline
        public static boolean f(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        @DoNotInline
        public static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        @DoNotInline
        public static boolean h(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        @DoNotInline
        public static View i(@NonNull View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        @DoNotInline
        public static boolean j(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        @DoNotInline
        public static void k(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @DoNotInline
        public static void l(@NonNull View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        @DoNotInline
        public static void m(View view, int i) {
            view.setImportantForAutofill(i);
        }

        @DoNotInline
        public static void n(@NonNull View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        @DoNotInline
        public static void o(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        @DoNotInline
        public static void p(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static void a(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            s sVar = new s(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, sVar);
            view.addOnUnhandledKeyEventListener(sVar);
        }

        @DoNotInline
        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @DoNotInline
        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @DoNotInline
        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @DoNotInline
        public static void e(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        @DoNotInline
        public static <T> T f(View view, int i) {
            return view.requireViewById(i);
        }

        @DoNotInline
        public static void g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        @DoNotInline
        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @DoNotInline
        public static void i(View view, AutofillIdCompat autofillIdCompat) {
            view.setAutofillId(autofillIdCompat == null ? null : autofillIdCompat.a());
        }

        @DoNotInline
        public static void j(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @DoNotInline
        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        @DoNotInline
        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @DoNotInline
        public static void d(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        @DoNotInline
        public static void e(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
            view.setContentCaptureSession(contentCaptureSessionCompat == null ? null : contentCaptureSessionCompat.a());
        }

        @DoNotInline
        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        @DoNotInline
        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        @Nullable
        public static WindowInsetsControllerCompat c(@NonNull View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.g(windowInsetsController);
            }
            return null;
        }

        @DoNotInline
        public static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        @DoNotInline
        public static void e(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        @DoNotInline
        public static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @RequiresApi
    public static final class Api31Impl {
        @DoNotInline
        @Nullable
        public static String[] a(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        @DoNotInline
        @Nullable
        public static ContentInfoCompat b(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
            ContentInfo h = contentInfoCompat.h();
            ContentInfo performReceiveContent = view.performReceiveContent(h);
            if (performReceiveContent == null) {
                return null;
            }
            return performReceiveContent == h ? contentInfoCompat : ContentInfoCompat.i(performReceiveContent);
        }

        @DoNotInline
        public static void c(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    @RequiresApi
    public static final class OnReceiveContentListenerAdapter implements OnReceiveContentListener {

        /* renamed from: a  reason: collision with root package name */
        public final OnReceiveContentListener f890a;

        public OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener) {
            this.f890a = onReceiveContentListener;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat i = ContentInfoCompat.i(contentInfo);
            ContentInfoCompat a2 = this.f890a.a(view, i);
            if (a2 == null) {
                return null;
            }
            return a2 == i ? contentInfo : a2.h();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    public static class UnhandledKeyEventManager {

        /* renamed from: a  reason: collision with root package name */
        public static final ArrayList f891a = new ArrayList();
    }

    public static int A(View view) {
        return view.getMeasuredState();
    }

    public static void A0(View view, ColorStateList colorStateList) {
        Api21Impl.q(view, colorStateList);
    }

    public static int B(View view) {
        return view.getMinimumHeight();
    }

    public static void B0(View view, PorterDuff.Mode mode) {
        Api21Impl.r(view, mode);
    }

    public static int C(View view) {
        return view.getMinimumWidth();
    }

    public static void C0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static String[] D(View view) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void D0(View view, float f) {
        Api21Impl.s(view, f);
    }

    public static int E(View view) {
        return view.getPaddingEnd();
    }

    public static void E0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static int F(View view) {
        return view.getPaddingStart();
    }

    public static void F0(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static ViewParent G(View view) {
        return view.getParentForAccessibility();
    }

    public static void G0(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static WindowInsetsCompat H(View view) {
        return Api23Impl.a(view);
    }

    public static void H0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static CharSequence I(View view) {
        return (CharSequence) d1().e(view);
    }

    public static void I0(View view, int i) {
        Api26Impl.m(view, i);
    }

    public static String J(View view) {
        return Api21Impl.k(view);
    }

    public static void J0(View view, int i) {
        view.setLabelFor(i);
    }

    public static float K(View view) {
        return view.getTranslationX();
    }

    public static void K0(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static float L(View view) {
        return view.getTranslationY();
    }

    public static void L0(View view, int i) {
        view.setLayoutDirection(i);
    }

    public static float M(View view) {
        return Api21Impl.l(view);
    }

    public static void M0(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.u(view, onApplyWindowInsetsListener);
    }

    public static WindowInsetsControllerCompat N(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void N0(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static int O(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void O0(View view, float f) {
        view.setPivotX(f);
    }

    public static float P(View view) {
        return Api21Impl.m(view);
    }

    public static void P0(View view, PointerIconCompat pointerIconCompat) {
        Api24Impl.d(view, (PointerIcon) (pointerIconCompat != null ? pointerIconCompat.a() : null));
    }

    public static boolean Q(View view) {
        return l(view) != null;
    }

    public static void Q0(View view, float f) {
        view.setRotation(f);
    }

    public static boolean R(View view) {
        return view.hasOnClickListeners();
    }

    public static void R0(View view, float f) {
        view.setRotationX(f);
    }

    public static boolean S(View view) {
        return view.hasOverlappingRendering();
    }

    public static void S0(View view, float f) {
        view.setRotationY(f);
    }

    public static boolean T(View view) {
        return view.hasTransientState();
    }

    public static void T0(View view, float f) {
        view.setScaleX(f);
    }

    public static boolean U(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static void U0(View view, float f) {
        view.setScaleY(f);
    }

    public static boolean V(View view) {
        return view.isAttachedToWindow();
    }

    public static void V0(View view, int i, int i2) {
        Api23Impl.d(view, i, i2);
    }

    public static boolean W(View view) {
        return view.isLaidOut();
    }

    public static void W0(View view, CharSequence charSequence) {
        d1().f(view, charSequence);
    }

    public static boolean X(View view) {
        return Api21Impl.p(view);
    }

    public static void X0(View view, String str) {
        Api21Impl.v(view, str);
    }

    public static boolean Y(View view) {
        return view.isPaddingRelative();
    }

    public static void Y0(View view, float f) {
        view.setTranslationX(f);
    }

    public static boolean Z(View view) {
        Boolean bool = (Boolean) t0().e(view);
        return bool != null && bool.booleanValue();
    }

    public static void Z0(View view, float f) {
        view.setTranslationY(f);
    }

    public static void a0(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void a1(View view, float f) {
        Api21Impl.w(view, f);
    }

    public static AccessibilityViewProperty b() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28) {
            /* renamed from: h */
            public Boolean c(View view) {
                return Boolean.valueOf(Api28Impl.c(view));
            }

            /* renamed from: i */
            public void d(View view, Boolean bool) {
                Api28Impl.g(view, bool.booleanValue());
            }

            /* renamed from: j */
            public boolean g(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static /* synthetic */ ContentInfoCompat b0(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    public static void b1(View view, WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.d(view, callback);
    }

    public static int c(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int p = p(view, charSequence);
        if (p != -1) {
            d(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(p, charSequence, accessibilityViewCommand));
        }
        return p;
    }

    public static void c0(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = m(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            int i2 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i2 = 2048;
                }
                obtain.setEventType(i2);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(m(view));
                    H0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(m(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    public static void c1(View view, float f) {
        Api21Impl.x(view, f);
    }

    public static void d(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        i(view);
        o0(accessibilityActionCompat.b(), view);
        n(view).add(accessibilityActionCompat);
        c0(view, 0);
    }

    public static void d0(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public static AccessibilityViewProperty d1() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_state_description, CharSequence.class, 64, 30) {
            /* renamed from: h */
            public CharSequence c(View view) {
                return Api30Impl.b(view);
            }

            /* renamed from: i */
            public void d(View view, CharSequence charSequence) {
                Api30Impl.f(view, charSequence);
            }

            /* renamed from: j */
            public boolean g(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static ViewPropertyAnimatorCompat e(View view) {
        if (f886a == null) {
            f886a = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) f886a.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        f886a.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static void e0(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public static void e1(View view) {
        Api21Impl.z(view);
    }

    public static WindowInsetsCompat f(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Api21Impl.b(view, windowInsetsCompat, rect);
    }

    public static WindowInsetsCompat f0(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets w = windowInsetsCompat.w();
        if (w != null) {
            WindowInsets b2 = Api20Impl.b(view, w);
            if (!b2.equals(w)) {
                return WindowInsetsCompat.y(b2, view);
            }
        }
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat g(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets w = windowInsetsCompat.w();
        if (w != null) {
            WindowInsets a2 = Api20Impl.a(view, w);
            if (!a2.equals(w)) {
                return WindowInsetsCompat.y(a2, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void g0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.O0());
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        return false;
    }

    public static AccessibilityViewProperty h0() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            /* renamed from: h */
            public CharSequence c(View view) {
                return Api28Impl.b(view);
            }

            /* renamed from: i */
            public void d(View view, CharSequence charSequence) {
                Api28Impl.h(view, charSequence);
            }

            /* renamed from: j */
            public boolean g(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static void i(View view) {
        AccessibilityDelegateCompat k = k(view);
        if (k == null) {
            k = new AccessibilityDelegateCompat();
        }
        u0(view, k);
    }

    public static boolean i0(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static int j() {
        return View.generateViewId();
    }

    public static ContentInfoCompat j0(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        if (onReceiveContentListener == null) {
            return v(view).onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat a2 = onReceiveContentListener.a(view, contentInfoCompat);
        if (a2 == null) {
            return null;
        }
        return v(view).onReceiveContent(a2);
    }

    public static AccessibilityDelegateCompat k(View view) {
        View.AccessibilityDelegate l = l(view);
        if (l == null) {
            return null;
        }
        return l instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) l).f861a : new AccessibilityDelegateCompat(l);
    }

    public static void k0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static View.AccessibilityDelegate l(View view) {
        return Api29Impl.a(view);
    }

    public static void l0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static CharSequence m(View view) {
        return (CharSequence) h0().e(view);
    }

    public static void m0(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static List n(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void n0(View view, int i) {
        o0(i, view);
        c0(view, 0);
    }

    public static float o(View view) {
        return view.getAlpha();
    }

    public static void o0(int i, View view) {
        List n = n(view);
        for (int i2 = 0; i2 < n.size(); i2++) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) n.get(i2)).b() == i) {
                n.remove(i2);
                return;
            }
        }
    }

    public static int p(View view, CharSequence charSequence) {
        List n = n(view);
        for (int i = 0; i < n.size(); i++) {
            if (TextUtils.equals(charSequence, ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) n.get(i)).c())) {
                return ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) n.get(i)).b();
            }
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[] iArr = b;
            if (i3 >= iArr.length || i2 != -1) {
                return i2;
            }
            int i4 = iArr[i3];
            boolean z = true;
            for (int i5 = 0; i5 < n.size(); i5++) {
                z &= ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) n.get(i5)).b() != i4;
            }
            if (z) {
                i2 = i4;
            }
            i3++;
        }
        return i2;
    }

    public static void p0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            n0(view, accessibilityActionCompat.b());
        } else {
            d(view, accessibilityActionCompat.a(charSequence, accessibilityViewCommand));
        }
    }

    public static ColorStateList q(View view) {
        return Api21Impl.g(view);
    }

    public static void q0(View view) {
        Api20Impl.c(view);
    }

    public static PorterDuff.Mode r(View view) {
        return Api21Impl.h(view);
    }

    public static int r0(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static Rect s(View view) {
        return view.getClipBounds();
    }

    public static void s0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        Api29Impl.d(view, context, iArr, attributeSet, typedArray, i, i2);
    }

    public static Display t(View view) {
        return view.getDisplay();
    }

    public static AccessibilityViewProperty t0() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28) {
            /* renamed from: h */
            public Boolean c(View view) {
                return Boolean.valueOf(Api28Impl.d(view));
            }

            /* renamed from: i */
            public void d(View view, Boolean bool) {
                Api28Impl.j(view, bool.booleanValue());
            }

            /* renamed from: j */
            public boolean g(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static float u(View view) {
        return Api21Impl.i(view);
    }

    public static void u0(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (l(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        H0(view);
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    public static OnReceiveContentViewBehavior v(View view) {
        return view instanceof OnReceiveContentViewBehavior ? (OnReceiveContentViewBehavior) view : c;
    }

    public static void v0(View view, boolean z) {
        b().f(view, Boolean.valueOf(z));
    }

    public static boolean w(View view) {
        return view.getFitsSystemWindows();
    }

    public static void w0(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static int x(View view) {
        return view.getImportantForAccessibility();
    }

    public static void x0(View view, CharSequence charSequence) {
        h0().f(view, charSequence);
        if (charSequence != null) {
            d.a(view);
        } else {
            d.c(view);
        }
    }

    public static int y(View view) {
        return Api26Impl.c(view);
    }

    public static void y0(View view, float f) {
        view.setAlpha(f);
    }

    public static int z(View view) {
        return view.getLayoutDirection();
    }

    public static void z0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
