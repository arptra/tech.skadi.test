package com.upuphone.xr.sapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatDelegate;
import com.upuphone.star.common.phone.UBaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/BaseActivity;", "Lcom/upuphone/star/common/phone/UBaseActivity;", "<init>", "()V", "Landroid/content/Context;", "base", "", "o0", "(Landroid/content/Context;)V", "newBase", "attachBaseContext", "Landroid/app/ActivityManager$TaskDescription;", "taskDescription", "setTaskDescription", "(Landroid/app/ActivityManager$TaskDescription;)V", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public class BaseActivity extends UBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6573a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/BaseActivity$Companion;", "", "()V", "APP_DEFAULT_FONT_SCALE", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void o0(Context context) {
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.fontScale = 1.0f;
            context.createConfigurationContext(configuration);
        }
    }

    public void attachBaseContext(Context context) {
        o0(context);
        AppCompatDelegate delegate = getDelegate();
        Intrinsics.checkNotNull(context);
        super.attachBaseContext(delegate.e(context));
    }

    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(new ActivityManager.TaskDescription(getString(R.string.app_name), R.mipmap.ic_sapp_launcher));
    }
}
