package com.upuphone.xr.sapp.monitor.sport.mz;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.meizu.net.pedometerprovider.manager.PedoManager;
import com.meizu.net.pedometerprovider.manager.UserManager;
import com.meizu.net.pedometerprovider.manager.bean.UInfo;
import com.meizu.net.pedometerprovider.util.PedometerUtil;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/mz/PedoUtil;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "d", "(Landroid/content/Context;)Z", "Lcom/meizu/net/pedometerprovider/manager/bean/UInfo;", "c", "(Landroid/content/Context;)Lcom/meizu/net/pedometerprovider/manager/bean/UInfo;", "Lcom/meizu/net/pedometerprovider/manager/PedoManager;", "pedoManager", "", "e", "(Lcom/meizu/net/pedometerprovider/manager/PedoManager;Landroid/content/Context;)V", "", "a", "(Landroid/content/Context;)I", "", "packageName", "b", "(Landroid/content/Context;Ljava/lang/String;)I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PedoUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final PedoUtil f7798a = new PedoUtil();

    public final int a(Context context) {
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        if (phoneTypeUtils.i()) {
            return b(context, PedometerUtil.PACKAGE_NAME);
        }
        if (phoneTypeUtils.c()) {
            return b(context, "com.huawei.health");
        }
        return 1;
    }

    public final int b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public final UInfo c(Context context) {
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        if (phoneTypeUtils.i()) {
            return UserManager.getInstance(context).getUserInfo();
        }
        if (!phoneTypeUtils.c() || HuaWeiFeatureParser.b().g()) {
            return new UInfo();
        }
        return null;
    }

    public final boolean d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context) >= 0;
    }

    public final void e(PedoManager pedoManager, Context context) {
        Intrinsics.checkNotNullParameter(pedoManager, "pedoManager");
        pedoManager.setUserId(UserManager.getInstance(context).getSetingInfo().getUid());
    }
}
