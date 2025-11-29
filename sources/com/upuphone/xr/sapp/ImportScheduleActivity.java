package com.upuphone.xr.sapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.honey.account.a8.q;
import com.honey.account.a8.r;
import com.honey.account.a8.s;
import com.honey.account.a8.t;
import com.honey.account.a8.u;
import com.ss.android.larksso.LarkSSO;
import com.upuphone.star.common.phone.UBaseActivity;
import com.upuphone.star.launcher.ddauth.DDAuthActivity;
import com.upuphone.xr.sapp.databinding.ActivityImportScheduleBinding;
import com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper;
import com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0015¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/ImportScheduleActivity;", "Lcom/upuphone/star/common/phone/UBaseActivity;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "finish", "onResume", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;", "type", "B0", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/SubscribeType;)V", "Lcom/upuphone/xr/sapp/databinding/ActivityImportScheduleBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/ActivityImportScheduleBinding;", "bind", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ImportScheduleActivity extends UBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public ActivityImportScheduleBinding f6594a;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscribeType.values().length];
            try {
                iArr[SubscribeType.feishu.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void A0(ImportScheduleActivity importScheduleActivity, View view) {
        Intrinsics.checkNotNullParameter(importScheduleActivity, "this$0");
        importScheduleActivity.B0(SubscribeType.feishu);
    }

    public static final void C0(SubscribeType subscribeType, ImportScheduleActivity importScheduleActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(subscribeType, "$type");
        Intrinsics.checkNotNullParameter(importScheduleActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[subscribeType.ordinal()] == 1) {
            new LarkSsoHelper().f(importScheduleActivity);
        } else {
            DDAuthActivity.f6480a.a(importScheduleActivity);
        }
    }

    public static final void D0(DialogInterface dialogInterface, int i) {
    }

    private final void initView() {
        ActivityImportScheduleBinding activityImportScheduleBinding = this.f6594a;
        ActivityImportScheduleBinding activityImportScheduleBinding2 = null;
        if (activityImportScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            activityImportScheduleBinding = null;
        }
        activityImportScheduleBinding.b.setOnClickListener(new q(this));
        ActivityImportScheduleBinding activityImportScheduleBinding3 = this.f6594a;
        if (activityImportScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            activityImportScheduleBinding3 = null;
        }
        activityImportScheduleBinding3.c.setOnClickListener(new r(this));
        ActivityImportScheduleBinding activityImportScheduleBinding4 = this.f6594a;
        if (activityImportScheduleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
        } else {
            activityImportScheduleBinding2 = activityImportScheduleBinding4;
        }
        activityImportScheduleBinding2.d.setOnClickListener(new s(this));
    }

    public static final void y0(ImportScheduleActivity importScheduleActivity, View view) {
        Intrinsics.checkNotNullParameter(importScheduleActivity, "this$0");
        importScheduleActivity.finish();
    }

    public static final void z0(ImportScheduleActivity importScheduleActivity, View view) {
        Intrinsics.checkNotNullParameter(importScheduleActivity, "this$0");
        importScheduleActivity.B0(SubscribeType.dingding);
    }

    public final void B0(SubscribeType subscribeType) {
        String string = getString(R.string.import_schedule_dialog_title, new Object[]{getString(subscribeType == SubscribeType.dingding ? R.string.import_schedule_rimet_name : R.string.import_schedule_lark_name)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        new AlertDialog.Builder(this).setTitle((CharSequence) string).setPositiveButton((CharSequence) getString(R.string.import_schedule_dialog_allwo), (DialogInterface.OnClickListener) new t(subscribeType, this)).setNegativeButton((CharSequence) getString(R.string.cancel), (DialogInterface.OnClickListener) new u()).show();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.next_close_enter, R.anim.next_close_exit);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LarkSSO.x().z(this, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityImportScheduleBinding c = ActivityImportScheduleBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6594a = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            c = null;
        }
        setContentView((View) c.getRoot());
        initView();
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        LarkSSO.x().z(this, intent);
    }

    public void onResume() {
        super.onResume();
        LarkSSO.x().z(this, getIntent());
    }
}
