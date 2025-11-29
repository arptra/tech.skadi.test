package com.upuphone.xr.sapp.glass;

import com.honey.account.i8.c;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassLogUpdateHelper;", "", "<init>", "()V", "", "taskId", "", "code", "", "h", "(Ljava/lang/String;I)V", "e", "(Ljava/lang/String;)V", "Lcom/upuphone/starrynetsdk/ability/share/ShareListener;", "shareListener", "d", "(Lcom/upuphone/starrynetsdk/ability/share/ShareListener;)V", "i", "a", "Ljava/lang/String;", "glassLogTaskId", "b", "starryNetTaskId", "Lcom/upuphone/xr/sapp/glass/LogShareListener;", "c", "Lkotlin/Lazy;", "f", "()Lcom/upuphone/xr/sapp/glass/LogShareListener;", "filterShareListener", "Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "g", "()Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "shareAbility", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassLogUpdateHelper {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final Lazy f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GlassLogUpdateHelper$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public String f7053a = "";
    public String b = "";
    public final Lazy c = LazyKt.lazy(GlassLogUpdateHelper$filterShareListener$2.INSTANCE);
    public final Lazy d = LazyKt.lazy(GlassLogUpdateHelper$shareAbility$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassLogUpdateHelper$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/glass/GlassLogUpdateHelper;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/glass/GlassLogUpdateHelper;", "instance", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GlassLogUpdateHelper a() {
            return (GlassLogUpdateHelper) GlassLogUpdateHelper.f.getValue();
        }

        public Companion() {
        }
    }

    public GlassLogUpdateHelper() {
        StarryNet.getInstance().registerInstallListener(new c(this));
    }

    public static final void b(GlassLogUpdateHelper glassLogUpdateHelper) {
        Intrinsics.checkNotNullParameter(glassLogUpdateHelper, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassLogUpdateHelper", "StarryNet onInstalled, initShareAbility");
        ShareAbility g = glassLogUpdateHelper.g();
        int unregisterReceiveListener = g.unregisterReceiveListener(glassLogUpdateHelper.f());
        delegate.a("GlassLogUpdateHelper", "unregisterReceiveListener code: " + unregisterReceiveListener);
        int registerReceiveListener = g.registerReceiveListener(glassLogUpdateHelper.f());
        delegate.a("GlassLogUpdateHelper", "registerReceiveListener code: " + registerReceiveListener);
    }

    public final void d(ShareListener shareListener) {
        Intrinsics.checkNotNullParameter(shareListener, "shareListener");
        f().a(shareListener);
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.f7053a;
        delegate.a("GlassLogUpdateHelper", "confirmTask::taskId is: " + str + " glassLogTaskId:" + str2);
        this.b = str;
        if (Intrinsics.areEqual((Object) str, (Object) this.f7053a)) {
            f().c(str);
            g().confirm(str);
        }
    }

    public final LogShareListener f() {
        return (LogShareListener) this.c.getValue();
    }

    public final ShareAbility g() {
        return (ShareAbility) this.d.getValue();
    }

    public final void h(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.f7053a;
        delegate.a("GlassLogUpdateHelper", "receiveGlassTask code:" + i + " taskId: " + str + " +glassLogTaskId:" + str2);
        if (i == 200) {
            this.f7053a = str;
            if (Intrinsics.areEqual((Object) this.b, (Object) str)) {
                f().c(str);
                g().confirm(str);
                return;
            }
            return;
        }
        f().onError(str, i);
    }

    public final void i() {
        f().b();
        this.b = "";
        this.f7053a = "";
    }
}
