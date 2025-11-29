package com.upuphone.xr.sapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.alibaba.fastjson.asm.Opcodes;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.x8.y;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.GenericWindowView;
import com.upuphone.xr.sapp.view.popup.ConnectTipWindowView;
import com.upuphone.xr.sapp.view.popup.ConnectViewTipWindowView;
import com.upuphone.xr.sapp.view.popup.GenericWindowViewContainer;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 /2\u00020\u0001:\u0002^_BK\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001a¢\u0006\u0004\b)\u0010\u001eJ\u0015\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0003¢\u0006\u0004\b+\u0010$J\u0015\u0010,\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b,\u0010\"J\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u0010.J\u0019\u00100\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b0\u0010\u0017J\u0017\u00101\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u0010$J\u000f\u00102\u001a\u00020\u001aH\u0002¢\u0006\u0004\b2\u0010\u001eJ\u000f\u00103\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u0010\u001eJ)\u00107\u001a\u0002062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\b7\u00108R&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010D\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010P\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010LRB\u0010X\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010Qj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u0001`R8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010ZR\u0016\u0010\\\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010LR\u0016\u0010]\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010L¨\u0006`"}, d2 = {"Lcom/upuphone/xr/sapp/view/SuperGenericWindowView;", "Landroid/widget/FrameLayout;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "windowTypes", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "actionCallback", "", "touchOutsideDismiss", "backKeyDismiss", "Landroid/os/Bundle;", "bundle", "Landroid/content/Context;", "context", "<init>", "(Ljava/util/ArrayList;Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;ZZLandroid/os/Bundle;Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/view/KeyEvent;", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "Landroid/view/View;", "child", "", "onViewRemoved", "(Landroid/view/View;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "windowType", "l", "(I)Z", "s", "(I)V", "", "data", "v", "(ILjava/lang/Object;)V", "r", "height", "setSoftKeyHeight", "q", "o", "()Z", "p", "k", "t", "n", "u", "Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "callback", "Lcom/upuphone/xr/sapp/view/popup/GenericWindowViewContainer;", "m", "(Landroid/content/Context;ILcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;)Lcom/upuphone/xr/sapp/view/popup/GenericWindowViewContainer;", "a", "Ljava/util/ArrayList;", "b", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "c", "Z", "d", "e", "mDismissAni", "f", "Lcom/upuphone/xr/sapp/view/popup/GenericWindowViewContainer;", "mGenericWindowView", "Landroid/graphics/Rect;", "g", "Landroid/graphics/Rect;", "mClickRect", "h", "Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "i", "I", "mScreenHeight", "j", "mScreenWidth", "showPos", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getMExtraList", "()Ljava/util/HashMap;", "setMExtraList", "(Ljava/util/HashMap;)V", "mExtraList", "Landroid/os/Handler;", "Landroid/os/Handler;", "delayHandler", "mSoftKeyHeight", "mSoftKeyAdapterHeight", "Companion", "IActionCallback", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"ViewConstructor"})
public final class SuperGenericWindowView extends FrameLayout {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);
    public static int q = StaticMethodUtilsKt.h(0.0f);

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f7988a;
    public IActionCallback b;
    public final boolean c;
    public final boolean d;
    public boolean e;
    public GenericWindowViewContainer f;
    public Rect g;
    public GenericWindowView.IClickCallback h;
    public int i;
    public int j;
    public int k = 80;
    public HashMap l;
    public final Handler m;
    public int n;
    public int o;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$Companion;", "", "<init>", "()V", "", "NAVIGATION_HEIGHT", "I", "getNAVIGATION_HEIGHT", "()I", "a", "(I)V", "", "GRAVITY", "Ljava/lang/String;", "TAG", "", "TOP_NOTIFICATION_DISMISS_TIME", "J", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i) {
            SuperGenericWindowView.q = i;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "", "", "windowType", "actionType", "", "a", "(II)V", "data", "c", "(ILjava/lang/Object;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface IActionCallback {
        void a(int i, int i2);

        void c(int i, Object obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperGenericWindowView(ArrayList arrayList, IActionCallback iActionCallback, boolean z, boolean z2, Bundle bundle, Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(arrayList, "windowTypes");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7988a = arrayList;
        this.b = iActionCallback;
        this.c = z;
        this.d = z2;
        Handler handler = new Handler(Looper.getMainLooper());
        this.m = handler;
        this.g = new Rect();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.j = displayMetrics.widthPixels;
        this.i = displayMetrics.heightPixels;
        if (!o()) {
            setBackgroundColor(context.getColor(R.color.custom_dialog_bg));
        } else if (!p()) {
            handler.postDelayed(new y(this), 3000);
        }
        this.h = new GenericWindowView.IClickCallback(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SuperGenericWindowView f7989a;

            {
                this.f7989a = r1;
            }

            public void a(int i, int i2) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("SuperPermissionView", "buttonCallback windowType = " + i + ",action = " + i2);
                IActionCallback c = this.f7989a.b;
                if (c != null) {
                    c.a(i, i2);
                }
                this.f7989a.f7988a.remove(Integer.valueOf(i));
                if (this.f7989a.f7988a.isEmpty()) {
                    this.f7989a.r();
                    return;
                }
                SuperGenericWindowView superGenericWindowView = this.f7989a;
                superGenericWindowView.removeView(superGenericWindowView.f);
            }

            public void b(int i, Object obj) {
                IActionCallback c = this.f7989a.b;
                if (c != null) {
                    c.c(i, obj);
                }
                if (this.f7989a.q(i)) {
                    if (i != 132) {
                        this.f7989a.f7988a.remove(Integer.valueOf(i));
                    }
                    if (this.f7989a.f7988a.isEmpty()) {
                        this.f7989a.r();
                        return;
                    }
                    SuperGenericWindowView superGenericWindowView = this.f7989a;
                    superGenericWindowView.removeView(superGenericWindowView.f);
                }
            }
        };
        Object obj = this.f7988a.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        this.f = m(context, ((Number) obj).intValue(), this.h);
        if (bundle != null) {
            this.k = bundle.getInt("gravity", 80);
        }
    }

    public static final void b(SuperGenericWindowView superGenericWindowView) {
        Intrinsics.checkNotNullParameter(superGenericWindowView, "this$0");
        superGenericWindowView.r();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ULog.Delegate delegate = ULog.f6446a;
        Integer valueOf = keyEvent != null ? Integer.valueOf(keyEvent.getKeyCode()) : null;
        delegate.a("SuperPermissionView", "dispatchKeyEvent::keyCode is: " + valueOf);
        if (k(keyEvent) || o()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.d) {
            return true;
        }
        r();
        return true;
    }

    @Nullable
    public final HashMap<Integer, Object> getMExtraList() {
        return this.l;
    }

    public final boolean k(KeyEvent keyEvent) {
        return (keyEvent != null && keyEvent.getKeyCode() == 67) || (keyEvent != null && keyEvent.getKeyCode() == 66) || ((keyEvent != null && keyEvent.getKeyCode() == 7) || ((keyEvent != null && keyEvent.getKeyCode() == 8) || ((keyEvent != null && keyEvent.getKeyCode() == 9) || ((keyEvent != null && keyEvent.getKeyCode() == 10) || ((keyEvent != null && keyEvent.getKeyCode() == 11) || ((keyEvent != null && keyEvent.getKeyCode() == 12) || ((keyEvent != null && keyEvent.getKeyCode() == 13) || ((keyEvent != null && keyEvent.getKeyCode() == 14) || ((keyEvent != null && keyEvent.getKeyCode() == 15) || (keyEvent != null && keyEvent.getKeyCode() == 16))))))))));
    }

    public final boolean l(int i2) {
        return this.f7988a.contains(Integer.valueOf(i2));
    }

    public final GenericWindowViewContainer m(Context context, int i2, GenericWindowView.IClickCallback iClickCallback) {
        return i2 != 2001 ? i2 != 2002 ? new GenericWindowView(i2, context, iClickCallback) : new ConnectTipWindowView(i2, context, iClickCallback) : new ConnectViewTipWindowView(i2, context, iClickCallback);
    }

    public final void n() {
        try {
            Object systemService = getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public final boolean o() {
        try {
            if (this.f7988a.size() <= 0) {
                return false;
            }
            Integer num = (Integer) this.f7988a.get(0);
            if (num == null) {
                return false;
            }
            return num.intValue() == 141;
        } catch (Exception unused) {
            return false;
        }
    }

    public void onAttachedToWindow() {
        GenericWindowViewContainer genericWindowViewContainer;
        super.onAttachedToWindow();
        HashMap hashMap = this.l;
        if (!(hashMap == null || (genericWindowViewContainer = this.f) == null)) {
            Object obj = this.f7988a.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            genericWindowViewContainer.setMExtra(MapsKt.getValue(hashMap, obj));
        }
        Object obj2 = this.f7988a.get(0);
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        t(((Number) obj2).intValue());
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MainApplication.k.m(false);
        GenericWindowViewContainer genericWindowViewContainer = this.f;
        if (genericWindowViewContainer != null) {
            genericWindowViewContainer.a();
        }
        this.f = null;
        this.h = null;
        this.b = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (o()) {
            return super.onTouchEvent(motionEvent);
        }
        Rect rect = this.g;
        if (rect != null && motionEvent != null && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && this.c) {
            r();
        }
        return true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((!this.f7988a.isEmpty()) && view != null && (view instanceof GenericWindowView)) {
            GenericWindowView genericWindowView = (GenericWindowView) view;
            Object obj = this.f7988a.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            genericWindowView.setWindowType(((Number) obj).intValue());
            HashMap hashMap = this.l;
            if (hashMap != null) {
                Object obj2 = this.f7988a.get(0);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                genericWindowView.setMExtra(MapsKt.getValue(hashMap, obj2));
            }
            Object obj3 = this.f7988a.get(0);
            Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
            t(((Number) obj3).intValue());
        }
    }

    public final boolean p() {
        try {
            if (this.f7988a.size() <= 0) {
                return false;
            }
            Integer num = (Integer) this.f7988a.get(0);
            if (num == null) {
                return false;
            }
            return num.intValue() == 161;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean q(int i2) {
        if (i2 == 158 || i2 == 202) {
            return false;
        }
        switch (i2) {
            case 191:
            case 192:
            case Opcodes.INSTANCEOF:
            case 194:
            case 195:
            case 196:
            case 197:
            case Opcodes.IFNULL:
                return false;
            default:
                return true;
        }
    }

    public final void r() {
        this.m.removeCallbacksAndMessages((Object) null);
        if (!this.e) {
            try {
                GenericWindowManger.c.a().l(this);
                n();
                GenericWindowViewContainer genericWindowViewContainer = this.f;
                if (genericWindowViewContainer != null) {
                    this.e = true;
                    StaticMethodUtilsKt.c(genericWindowViewContainer, new SuperGenericWindowView$removeAll$1$1(this, genericWindowViewContainer));
                }
            } catch (Exception e2) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e2.getMessage();
                delegate.a("SuperPermissionView", "removeAll error : " + message);
            }
        }
    }

    public final void s(int i2) {
        GenericWindowViewContainer genericWindowViewContainer = this.f;
        if (genericWindowViewContainer != null && genericWindowViewContainer.getWindowType() == i2) {
            this.f7988a.remove(Integer.valueOf(i2));
            if (this.f7988a.isEmpty()) {
                r();
            } else {
                removeView(this.f);
            }
        }
    }

    public final void setMExtraList(@Nullable HashMap<Integer, Object> hashMap) {
        this.l = hashMap;
    }

    public final void setSoftKeyHeight(int i2) {
        if (this.n != i2) {
            this.n = i2;
            GenericWindowViewContainer genericWindowViewContainer = this.f;
            if (genericWindowViewContainer != null && genericWindowViewContainer.getWindowType() == 114) {
                u();
            }
        }
    }

    public final void t(int i2) {
        GenericWindowViewContainer genericWindowViewContainer = this.f;
        if (genericWindowViewContainer != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (i2 != 114) {
                if (i2 != 123) {
                    if (i2 == 141) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = StaticMethodUtilsKt.h(46.0f);
                    } else if (i2 != 150) {
                        if (i2 != 161) {
                            if (i2 != 203) {
                                if (!(i2 == 116 || i2 == 117)) {
                                    switch (i2) {
                                        case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                                        case 132:
                                        case 133:
                                            break;
                                        default:
                                            switch (i2) {
                                                case Opcodes.IF_ACMPEQ:
                                                case Opcodes.IF_ACMPNE:
                                                case Opcodes.GOTO:
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case Opcodes.NEW:
                                                            break;
                                                        case Opcodes.NEWARRAY:
                                                        case 189:
                                                            break;
                                                        default:
                                                            layoutParams.gravity = this.k;
                                                            layoutParams.bottomMargin = StaticMethodUtilsKt.h(18.0f) + q;
                                                            break;
                                                    }
                                            }
                                    }
                                }
                                layoutParams.gravity = 17;
                            }
                            layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            layoutParams.gravity = this.k;
                            layoutParams.bottomMargin = StaticMethodUtilsKt.h(18.0f) + q;
                        } else {
                            layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = StaticMethodUtilsKt.h(96.0f);
                        }
                    }
                }
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
            } else {
                layoutParams.gravity = this.k;
                layoutParams.bottomMargin = this.o + q;
            }
            layoutParams.setMarginStart(StaticMethodUtilsKt.h(16.0f));
            layoutParams.setMarginEnd(StaticMethodUtilsKt.h(16.0f));
            addView(genericWindowViewContainer, layoutParams);
            genericWindowViewContainer.getViewTreeObserver().addOnGlobalLayoutListener(new SuperGenericWindowView$showPermission$1$1(this, genericWindowViewContainer));
        }
    }

    public final void u() {
        int i2 = this.i - (this.n * 2);
        GenericWindowViewContainer genericWindowViewContainer = this.f;
        Intrinsics.checkNotNull(genericWindowViewContainer);
        if (i2 < genericWindowViewContainer.getHeight()) {
            int i3 = this.i - (this.n * 2);
            GenericWindowViewContainer genericWindowViewContainer2 = this.f;
            Intrinsics.checkNotNull(genericWindowViewContainer2);
            this.o = (i3 - genericWindowViewContainer2.getHeight()) / 2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = Math.abs(this.o);
            layoutParams.setMarginStart(getResources().getDimensionPixelSize(R.dimen.card_default_margin));
            layoutParams.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.card_default_margin));
            layoutParams.gravity = this.k;
            GenericWindowViewContainer genericWindowViewContainer3 = this.f;
            Intrinsics.checkNotNull(genericWindowViewContainer3);
            genericWindowViewContainer3.setLayoutParams(layoutParams);
        }
    }

    public final void v(int i2, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        GenericWindowViewContainer genericWindowViewContainer = this.f;
        if (genericWindowViewContainer != null && genericWindowViewContainer.getWindowType() == i2) {
            genericWindowViewContainer.b(i2, obj);
        }
    }
}
