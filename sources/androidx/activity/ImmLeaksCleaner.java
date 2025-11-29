package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.LifecycleEventObserver;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0004\u000e\u000f\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Landroidx/activity/ImmLeaksCleaner;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "activity", "b", "Cleaner", "Companion", "FailedInitialization", "ValidCleaner", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final Lazy c = LazyKt.lazy(ImmLeaksCleaner$Companion$cleaner$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final Activity f95a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/ImmLeaksCleaner$Cleaner;", "", "<init>", "()V", "Landroid/view/inputmethod/InputMethodManager;", "", "a", "(Landroid/view/inputmethod/InputMethodManager;)Z", "b", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "lock", "Landroid/view/View;", "c", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "servedView", "Landroidx/activity/ImmLeaksCleaner$FailedInitialization;", "Landroidx/activity/ImmLeaksCleaner$ValidCleaner;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class Cleaner {
        public /* synthetic */ Cleaner(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean a(InputMethodManager inputMethodManager);

        public abstract Object b(InputMethodManager inputMethodManager);

        public abstract View c(InputMethodManager inputMethodManager);

        public Cleaner() {
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/activity/ImmLeaksCleaner$Companion;", "", "<init>", "()V", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "cleaner$delegate", "Lkotlin/Lazy;", "a", "()Landroidx/activity/ImmLeaksCleaner$Cleaner;", "cleaner", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Cleaner a() {
            return (Cleaner) ImmLeaksCleaner.c.getValue();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f*\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/activity/ImmLeaksCleaner$FailedInitialization;", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "<init>", "()V", "Landroid/view/inputmethod/InputMethodManager;", "", "a", "(Landroid/view/inputmethod/InputMethodManager;)Z", "", "b", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "lock", "Landroid/view/View;", "c", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "servedView", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class FailedInitialization extends Cleaner {

        /* renamed from: a  reason: collision with root package name */
        public static final FailedInitialization f96a = new FailedInitialization();

        public FailedInitialization() {
            super((DefaultConstructorMarker) null);
        }

        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            return false;
        }

        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            return null;
        }

        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            return null;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0012*\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/activity/ImmLeaksCleaner$ValidCleaner;", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "Ljava/lang/reflect/Field;", "hField", "servedViewField", "nextServedViewField", "<init>", "(Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;)V", "Landroid/view/inputmethod/InputMethodManager;", "", "a", "(Landroid/view/inputmethod/InputMethodManager;)Z", "Ljava/lang/reflect/Field;", "b", "c", "", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "lock", "Landroid/view/View;", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "servedView", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class ValidCleaner extends Cleaner {

        /* renamed from: a  reason: collision with root package name */
        public final Field f97a;
        public final Field b;
        public final Field c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValidCleaner(Field field, Field field2, Field field3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(field, "hField");
            Intrinsics.checkNotNullParameter(field2, "servedViewField");
            Intrinsics.checkNotNullParameter(field3, "nextServedViewField");
            this.f97a = field;
            this.b = field2;
            this.c = field3;
        }

        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            try {
                this.c.set(inputMethodManager, (Object) null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            try {
                return this.f97a.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            try {
                return (View) this.b.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        r1.isActive();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(androidx.lifecycle.LifecycleOwner r2, androidx.lifecycle.Lifecycle.Event r3) {
        /*
            r1 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            androidx.lifecycle.Lifecycle$Event r2 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r3 == r2) goto L_0x000f
            return
        L_0x000f:
            android.app.Activity r1 = r1.f95a
            java.lang.String r2 = "input_method"
            java.lang.Object r1 = r1.getSystemService(r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.view.inputmethod.InputMethodManager r1 = (android.view.inputmethod.InputMethodManager) r1
            androidx.activity.ImmLeaksCleaner$Companion r2 = b
            androidx.activity.ImmLeaksCleaner$Cleaner r2 = r2.a()
            java.lang.Object r3 = r2.b(r1)
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            monitor-enter(r3)
            android.view.View r0 = r2.c(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0034
            monitor-exit(r3)
            return
        L_0x0034:
            boolean r0 = r0.isAttachedToWindow()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x003c
            monitor-exit(r3)
            return
        L_0x003c:
            boolean r2 = r2.a(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            if (r2 == 0) goto L_0x0046
            r1.isActive()
        L_0x0046:
            return
        L_0x0047:
            r1 = move-exception
            monitor-exit(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.onStateChanged(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }
}
