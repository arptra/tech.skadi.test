package com.upuphone.datatrack.base.db;

import android.content.Context;
import android.text.TextUtils;
import com.upuphone.datatrack.base.utils.DataTrackHelper;
import com.upuphone.datatrack.base.utils.LogUtil;
import java.util.List;

public final class XJDataBaseManager {
    public static volatile XJDataBaseManager c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f6396a;
    public final DataTrackDbHelper b;

    public XJDataBaseManager(Context context) {
        this.f6396a = context;
        this.b = new DataTrackDbHelper(context);
    }

    public static XJDataBaseManager d(Context context) {
        if (c == null) {
            synchronized (XJDataBaseManager.class) {
                try {
                    if (c == null) {
                        c = new XJDataBaseManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public void a(List list) {
        this.b.d(list);
    }

    public void b(String str, int i) {
        this.b.e(str, i);
    }

    public int c(String str) {
        return this.b.g(str);
    }

    public void e(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            LogUtil.c("XJDataBaseManager", "insert, msg is null");
        } else if (TextUtils.isEmpty(str3)) {
            LogUtil.c("XJDataBaseManager", "insert, eventName is null");
        } else {
            this.b.m(DataTrackHelper.d(str, str3, str2));
        }
    }

    public List f(int i) {
        return this.b.j(i);
    }

    public int g(String str) {
        return this.b.k(str);
    }

    public List h(int i) {
        return this.b.l(i);
    }

    public void i(List list) {
        this.b.n(list);
    }
}
