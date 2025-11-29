package com.upuphone.xr.sapp.glass;

import com.honey.account.i8.b;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0004*\u0002\u0015\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassFileTransferHelper;", "", "<init>", "()V", "", "f", "", "taskId", "d", "(Ljava/lang/String;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "taskIds", "Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "c", "Lkotlin/Lazy;", "e", "()Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "shareAbility", "com/upuphone/xr/sapp/glass/GlassFileTransferHelper$messageListener$1", "Lcom/upuphone/xr/sapp/glass/GlassFileTransferHelper$messageListener$1;", "messageListener", "com/upuphone/xr/sapp/glass/GlassFileTransferHelper$filterShareListener$1", "Lcom/upuphone/xr/sapp/glass/GlassFileTransferHelper$filterShareListener$1;", "filterShareListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassFileTransferHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassFileTransferHelper f7048a;
    public static final HashSet b = new HashSet();
    public static final Lazy c = LazyKt.lazy(GlassFileTransferHelper$shareAbility$2.INSTANCE);
    public static final GlassFileTransferHelper$messageListener$1 d;
    public static final GlassFileTransferHelper$filterShareListener$1 e = new GlassFileTransferHelper$filterShareListener$1();

    static {
        GlassFileTransferHelper glassFileTransferHelper = new GlassFileTransferHelper();
        f7048a = glassFileTransferHelper;
        GlassFileTransferHelper$messageListener$1 glassFileTransferHelper$messageListener$1 = new GlassFileTransferHelper$messageListener$1();
        d = glassFileTransferHelper$messageListener$1;
        GlassMessageHelper.f7054a.c("air_transfer_file", "air_transfer_file", glassFileTransferHelper$messageListener$1);
        glassFileTransferHelper.f();
    }

    public static final void g() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassFileTransferHelper", "StarryNet onInstalled, initShareAbility");
        ShareAbility e2 = f7048a.e();
        GlassFileTransferHelper$filterShareListener$1 glassFileTransferHelper$filterShareListener$1 = e;
        int unregisterReceiveListener = e2.unregisterReceiveListener(glassFileTransferHelper$filterShareListener$1);
        delegate.a("GlassFileTransferHelper", "unregisterReceiveListener code: " + unregisterReceiveListener);
        int registerReceiveListener = e2.registerReceiveListener(glassFileTransferHelper$filterShareListener$1);
        delegate.a("GlassFileTransferHelper", "registerReceiveListener code: " + registerReceiveListener);
    }

    public final void d(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassFileTransferHelper", "checkShouldConfirmTask");
        HashSet hashSet = b;
        if (hashSet.contains(str)) {
            int confirm = e().confirm(str);
            delegate.a("GlassFileTransferHelper", "checkShouldConfirmTask, confirm code: " + confirm);
            if (confirm != 0) {
                hashSet.remove(str);
                return;
            }
            return;
        }
        delegate.a("GlassFileTransferHelper", "checkShouldConfirmTask, ignore");
    }

    public final ShareAbility e() {
        return (ShareAbility) c.getValue();
    }

    public final void f() {
        StarryNet.getInstance().registerInstallListener(new b());
    }
}
