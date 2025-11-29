package com.upuphone.xr.sapp.monitor.schedule.lark;

import android.app.Activity;
import android.content.DialogInterface;
import com.honey.account.o8.a;
import com.honey.account.o8.b;
import com.meizu.common.app.LoadingDialog;
import com.ss.android.larksso.LarkSSO;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\bR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper;", "", "<init>", "()V", "Landroid/app/Activity;", "context", "", "f", "(Landroid/app/Activity;)V", "", "code", "e", "(Ljava/lang/String;Landroid/app/Activity;)V", "h", "a", "Ljava/lang/String;", "getCacheCode", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "cacheCode", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLarkSsoHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LarkSsoHelper.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,163:1\n48#2,4:164\n*S KotlinDebug\n*F\n+ 1 LarkSsoHelper.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper\n*L\n81#1:164,4\n*E\n"})
public final class LarkSsoHelper {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public String f7787a = "";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void i(LarkSsoHelper larkSsoHelper, Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(larkSsoHelper, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$context");
        larkSsoHelper.e(larkSsoHelper.f7787a, activity);
    }

    public static final void j(DialogInterface dialogInterface, int i) {
    }

    public final void e(String str, Activity activity) {
        LoadingDialog show = LoadingDialog.show(activity, (CharSequence) null, "绑定中");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), new LarkSsoHelper$getCalDavInfo$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this, activity), (CoroutineStart) null, new LarkSsoHelper$getCalDavInfo$2(str, show, activity, this, (Continuation<? super LarkSsoHelper$getCalDavInfo$2>) null), 2, (Object) null);
    }

    public final void f(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add("calendar:setting:generate_caldav_conf");
        LarkSSO.Builder m = new LarkSSO.Builder().k("cli_a6a4a2ca173a900c").q("Feishu").o("zh").l(true).n("test-hhl").p(arrayList).m(activity);
        Intrinsics.checkNotNullExpressionValue(m, "setContext(...)");
        String j = m.j();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("Schedule-LarkSsoHelper", "getLarkAuth deviceId:" + j);
        LarkSSO.x().C(m, new LarkSsoHelper$getLarkAuth$1(this, activity));
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f7787a = str;
    }

    public final void h(Activity activity) {
        new AlertDialog.Builder(activity).setTitle((CharSequence) activity.getString(R.string.import_schedule_dialog_fail_title)).setPositiveButton((CharSequence) activity.getString(R.string.import_schedule_dialog_fail_retry), (DialogInterface.OnClickListener) new a(this, activity)).setNegativeButton((CharSequence) activity.getString(R.string.cancel), (DialogInterface.OnClickListener) new b()).show();
    }
}
