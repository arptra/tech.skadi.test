package com.upuphone.xr.sapp.monitor.sport.mz;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.meizu.net.pedometerprovider.manager.PedoManager;
import com.meizu.net.pedometerprovider.manager.bean.UInfo;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.sport.SportInfo;
import com.upuphone.xr.sapp.monitor.sport.SportInfoProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/mz/MeiZuSportInfoProvider;", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfoProvider;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "c", "()V", "j", "Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "i", "()Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "b", "Landroid/content/Context;", "", "Z", "isUidChanged", "Landroid/database/ContentObserver;", "d", "Landroid/database/ContentObserver;", "dataObserver", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "f", "Companion", "DataObserver", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MeiZuSportInfoProvider extends SportInfoProvider {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final Uri g;
    public static final Uri h;
    public static final Uri i;
    public static final Uri j;
    public final Context b;
    public boolean c = true;
    public ContentObserver d = new DataObserver(this, new Handler(Looper.getMainLooper()));
    public final CoroutineScope e = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/mz/MeiZuSportInfoProvider$Companion;", "", "()V", "CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "SETTING_TABLE_NAME", "", "SETTING_URI", "STEP_TABLE_NAME", "STEP_URI", "TAG", "URI_AUTHORITY", "USER_TABLE_NAME", "USER_URI", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/mz/MeiZuSportInfoProvider$DataObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "(Lcom/upuphone/xr/sapp/monitor/sport/mz/MeiZuSportInfoProvider;Landroid/os/Handler;)V", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DataObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MeiZuSportInfoProvider f7797a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataObserver(MeiZuSportInfoProvider meiZuSportInfoProvider, Handler handler) {
            super(handler);
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.f7797a = meiZuSportInfoProvider;
        }

        public void onChange(boolean z, Uri uri) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("MeiZuSportInfoProvider", "onChange: " + uri);
            String uri2 = MeiZuSportInfoProvider.h.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            if (!StringsKt.contains$default((CharSequence) uri2, (CharSequence) String.valueOf(uri), false, 2, (Object) null)) {
                this.f7797a.c = true;
            }
            this.f7797a.j();
        }
    }

    static {
        Uri parse = Uri.parse("content://com.meizu.net.pedometer/");
        g = parse;
        String uri = parse.toString();
        h = Uri.parse(uri + "stepcount");
        String uri2 = parse.toString();
        i = Uri.parse(uri2 + "userinfo");
        String uri3 = parse.toString();
        j = Uri.parse(uri3 + "settinginfo");
    }

    public MeiZuSportInfoProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
    }

    public void c() {
        j();
    }

    public final SportInfo i() {
        PedoUtil pedoUtil = PedoUtil.f7798a;
        if (!pedoUtil.d(this.b)) {
            ULog.f6446a.g("MeiZuSportInfoProvider", "pedo not install");
            return new SportInfo(0, 0.0d, 0, 2);
        }
        PedoManager instance = PedoManager.getInstance(this.b);
        UInfo c2 = pedoUtil.c(this.b);
        if (c2 == null) {
            ULog.f6446a.g("MeiZuSportInfoProvider", "userInfo is null");
            return new SportInfo(0, 0.0d, 0, 1);
        }
        if (this.c) {
            Intrinsics.checkNotNull(instance);
            pedoUtil.e(instance, this.b);
            this.c = false;
        }
        int toadayStep = instance.getToadayStep();
        if (toadayStep == 0) {
            Intrinsics.checkNotNull(instance);
            pedoUtil.e(instance, this.b);
        }
        return new SportInfo(toadayStep, ((double) c2.getWeight()) * ((double) (((float) toadayStep) * 0.68f)) * 0.001d, c2.getTarget(), 0, 8, (DefaultConstructorMarker) null);
    }

    public final void j() {
        ULog.f6446a.g("MeiZuSportInfoProvider", "updateStepInfo: ");
        Job unused = BuildersKt__Builders_commonKt.d(this.e, (CoroutineContext) null, (CoroutineStart) null, new MeiZuSportInfoProvider$updateStepInfo$1(this, (Continuation<? super MeiZuSportInfoProvider$updateStepInfo$1>) null), 3, (Object) null);
    }
}
