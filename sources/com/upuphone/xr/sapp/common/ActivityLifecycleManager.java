package com.upuphone.xr.sapp.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u00020\u0019\"\b\b\u0000\u0010\u0017*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u001f\u001a\u00020\b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J(\u0010!\u001a\u00020\b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u001dH\u0002¢\u0006\u0004\b!\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002XD¢\u0006\u0006\n\u0004\b\u001f\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010'R\"\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00180*8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u001f\u0010/\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00180-8F¢\u0006\u0006\u001a\u0004\b&\u0010.¨\u00060"}, d2 = {"Lcom/upuphone/xr/sapp/common/ActivityLifecycleManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Lcom/upuphone/xr/sapp/common/ApplicationVisibilityCallback;", "callback", "e", "(Lcom/upuphone/xr/sapp/common/ApplicationVisibilityCallback;)V", "T", "Ljava/lang/Class;", "", "d", "(Ljava/lang/Class;)Z", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "action", "b", "(Lkotlin/jvm/functions/Function1;)V", "a", "", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "activityLifecycleCallbacks", "applicationVisibilityCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "visibleActivityList", "", "()Ljava/util/List;", "visibleActivities", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nActivityLifecycleManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityLifecycleManager.kt\ncom/upuphone/xr/sapp/common/ActivityLifecycleManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1855#2,2:113\n1855#2,2:115\n*S KotlinDebug\n*F\n+ 1 ActivityLifecycleManager.kt\ncom/upuphone/xr/sapp/common/ActivityLifecycleManager\n*L\n89#1:113,2\n103#1:115,2\n*E\n"})
public final class ActivityLifecycleManager implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public static final ActivityLifecycleManager f6654a = new ActivityLifecycleManager();
    public static final String b = "ActivityLifecycleManager";
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static final CopyOnWriteArrayList e = new CopyOnWriteArrayList();

    public final void a(Function1 function1) {
        for (ApplicationVisibilityCallback applicationVisibilityCallback : d) {
            Intrinsics.checkNotNull(applicationVisibilityCallback);
            function1.invoke(applicationVisibilityCallback);
        }
    }

    public final void b(Function1 function1) {
        for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : c) {
            Intrinsics.checkNotNull(activityLifecycleCallbacks);
            function1.invoke(activityLifecycleCallbacks);
        }
    }

    public final List c() {
        return e;
    }

    public final boolean d(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "activity");
        return c().contains(cls);
    }

    public final void e(ApplicationVisibilityCallback applicationVisibilityCallback) {
        Intrinsics.checkNotNullParameter(applicationVisibilityCallback, "callback");
        d.add(applicationVisibilityCallback);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        b(new ActivityLifecycleManager$onActivityCreated$1(activity, bundle));
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        b(new ActivityLifecycleManager$onActivityDestroyed$1(activity));
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        b(new ActivityLifecycleManager$onActivityPaused$1(activity));
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        b(new ActivityLifecycleManager$onActivityResumed$1(activity));
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
        b(new ActivityLifecycleManager$onActivitySaveInstanceState$1(activity, bundle));
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CopyOnWriteArrayList copyOnWriteArrayList = e;
        copyOnWriteArrayList.add(activity.getClass());
        if (copyOnWriteArrayList.size() == 1) {
            a(ActivityLifecycleManager$onActivityStarted$1.INSTANCE);
        }
        b(new ActivityLifecycleManager$onActivityStarted$2(activity));
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CopyOnWriteArrayList copyOnWriteArrayList = e;
        copyOnWriteArrayList.remove(activity.getClass());
        if (copyOnWriteArrayList.size() == 0) {
            a(ActivityLifecycleManager$onActivityStopped$1.INSTANCE);
        }
        b(new ActivityLifecycleManager$onActivityStopped$2(activity));
    }
}
