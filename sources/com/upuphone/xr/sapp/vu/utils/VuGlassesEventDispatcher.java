package com.upuphone.xr.sapp.vu.utils;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.xr.sapp.vu.arspace.OnKeyListener;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0007*\u0001,\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003/01B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001dJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\rJ\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\rR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130#8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010%R\u0014\u0010.\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010-¨\u00062"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher;", "", "<init>", "()V", "", "m", "", "brightness", "i", "(I)V", "keyCode", "action", "l", "(II)V", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnBrightnessChangeListener;", "listener", "d", "(Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnBrightnessChangeListener;)V", "n", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnWearStateChangeListener;", "h", "(Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnWearStateChangeListener;)V", "r", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnUpgradeStateChangeListener;", "g", "(Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnUpgradeStateChangeListener;)V", "q", "Lcom/upuphone/xr/sapp/vu/arspace/OnKeyListener;", "e", "(Lcom/upuphone/xr/sapp/vu/arspace/OnKeyListener;)V", "o", "f", "p", "j", "k", "Ljava/util/concurrent/CopyOnWriteArraySet;", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "brightnessListeners", "c", "wearStateListeners", "upgradeStateListeners", "glassesKeyListeners", "phoneKeyListeners", "com/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$glassesEventCallback$1", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$glassesEventCallback$1;", "glassesEventCallback", "OnBrightnessChangeListener", "OnUpgradeStateChangeListener", "OnWearStateChangeListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassesEventDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesEventDispatcher.kt\ncom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n1855#2,2:139\n1855#2,2:141\n1855#2,2:143\n*S KotlinDebug\n*F\n+ 1 VuGlassesEventDispatcher.kt\ncom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher\n*L\n66#1:139,2\n72#1:141,2\n78#1:143,2\n*E\n"})
public final class VuGlassesEventDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesEventDispatcher f8098a = new VuGlassesEventDispatcher();
    public static final CopyOnWriteArraySet b = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet e = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet f = new CopyOnWriteArraySet();
    public static final VuGlassesEventDispatcher$glassesEventCallback$1 g = new VuGlassesEventDispatcher$glassesEventCallback$1();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnBrightnessChangeListener;", "", "onBrightnessChange", "", "brightness", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnBrightnessChangeListener {
        void onBrightnessChange(int i);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnUpgradeStateChangeListener;", "", "", "curProgress", "totalProgress", "type", "status", "", "a", "(IIII)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnUpgradeStateChangeListener {
        void a(int i, int i2, int i3, int i4);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnWearStateChangeListener;", "", "", "isWear", "", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnWearStateChangeListener {
        void a(boolean z);
    }

    public final void d(OnBrightnessChangeListener onBrightnessChangeListener) {
        Intrinsics.checkNotNullParameter(onBrightnessChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        b.add(onBrightnessChangeListener);
    }

    public final void e(OnKeyListener onKeyListener) {
        Intrinsics.checkNotNullParameter(onKeyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        e.add(onKeyListener);
    }

    public final void f(OnKeyListener onKeyListener) {
        Intrinsics.checkNotNullParameter(onKeyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f.add(onKeyListener);
    }

    public final void g(OnUpgradeStateChangeListener onUpgradeStateChangeListener) {
        Intrinsics.checkNotNullParameter(onUpgradeStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        d.add(onUpgradeStateChangeListener);
    }

    public final void h(OnWearStateChangeListener onWearStateChangeListener) {
        Intrinsics.checkNotNullParameter(onWearStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.add(onWearStateChangeListener);
    }

    public final void i(int i) {
        for (OnBrightnessChangeListener onBrightnessChange : b) {
            onBrightnessChange.onBrightnessChange(i);
        }
    }

    public final void j(int i, int i2) {
        for (OnKeyListener onKeyEvent : e) {
            onKeyEvent.onKeyEvent(i, i2);
        }
    }

    public final void k(int i, int i2) {
        for (OnKeyListener onKeyEvent : f) {
            onKeyEvent.onKeyEvent(i, i2);
        }
    }

    public final void l(int i, int i2) {
        k(i, i2);
    }

    public final void m() {
        VuGlassesHidUtil.f8104a.u(g);
    }

    public final void n(OnBrightnessChangeListener onBrightnessChangeListener) {
        Intrinsics.checkNotNullParameter(onBrightnessChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        b.remove(onBrightnessChangeListener);
    }

    public final void o(OnKeyListener onKeyListener) {
        Intrinsics.checkNotNullParameter(onKeyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        e.remove(onKeyListener);
    }

    public final void p(OnKeyListener onKeyListener) {
        Intrinsics.checkNotNullParameter(onKeyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f.remove(onKeyListener);
    }

    public final void q(OnUpgradeStateChangeListener onUpgradeStateChangeListener) {
        Intrinsics.checkNotNullParameter(onUpgradeStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        d.remove(onUpgradeStateChangeListener);
    }

    public final void r(OnWearStateChangeListener onWearStateChangeListener) {
        Intrinsics.checkNotNullParameter(onWearStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.remove(onWearStateChangeListener);
    }
}
