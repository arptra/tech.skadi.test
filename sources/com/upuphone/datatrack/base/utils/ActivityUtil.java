package com.upuphone.datatrack.base.utils;

import android.app.Activity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002XD¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/upuphone/datatrack/base/utils/ActivityUtil;", "", "<init>", "()V", "", "c", "()Ljava/lang/String;", "e", "Landroid/app/Activity;", "b", "()Landroid/app/Activity;", "d", "activity", "", "g", "(Landroid/app/Activity;)V", "f", "", "a", "()I", "Ljava/lang/String;", "TAG", "", "Ljava/util/List;", "ACTIVITY_LIST", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
public final class ActivityUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ActivityUtil f6397a = new ActivityUtil();
    public static final String b = "ActivityUtil";
    public static final List c = new CopyOnWriteArrayList();

    public static final int a() {
        return c.size();
    }

    public static final Activity b() {
        List list = c;
        if (list.isEmpty()) {
            return null;
        }
        try {
            return (Activity) CollectionsKt.getOrNull(list, CollectionsKt.getLastIndex(list));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String c() {
        Activity b2 = b();
        String name = b2 != null ? b2.getClass().getName() : null;
        return name == null ? "" : name;
    }

    public static final Activity d() {
        List list = c;
        if (list.size() < 2) {
            return null;
        }
        try {
            return (Activity) CollectionsKt.getOrNull(list, CollectionsKt.getLastIndex(list) - 1);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String e() {
        Activity d = d();
        String name = d != null ? d.getClass().getName() : null;
        return name == null ? "" : name;
    }

    public static final void f(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        List list = c;
        list.remove(activity);
        String str = b;
        LogUtil.a(str, "popActivity, activityList-size:" + list.size());
    }

    public static final void g(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        List list = c;
        list.add(activity);
        String str = b;
        LogUtil.a(str, "pushActivity, activityList-size: " + list.size());
    }
}
