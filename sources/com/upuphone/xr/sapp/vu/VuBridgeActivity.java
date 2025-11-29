package com.upuphone.xr.sapp.vu;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import androidx.appcompat.app.AppCompatActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHelper;
import com.upuphone.xr.sapp.vu.vm.VuGlassesModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuBridgeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "n0", "()Ljava/lang/Boolean;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuBridgeActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8023a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuBridgeActivity$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final Boolean n0() {
        Display c = VuGlassesHelper.f8099a.c();
        if (c == null) {
            ULog.f6446a.g("VuBridgeActivity", "display: " + c);
            return null;
        }
        ULog.f6446a.g("VuBridgeActivity", "display: " + c);
        Display.Mode[] supportedModes = c.getSupportedModes();
        Intrinsics.checkNotNull(supportedModes);
        int length = supportedModes.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            Display.Mode mode = supportedModes[i];
            ULog.f6446a.g("VuBridgeActivity", "support modes: " + mode);
            if (mode.getRefreshRate() > 100.0f) {
                break;
            }
            i++;
        }
        ULog.f6446a.g("VuBridgeActivity", "is3DMode: " + z);
        return Boolean.valueOf(z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!MainApplication.k.f().v() && Intrinsics.areEqual((Object) n0(), (Object) Boolean.FALSE)) {
            startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
        }
        if (SystemClock.elapsedRealtime() - VuTouchpadActivity.w.c() > 6000) {
            VuGlassesModel.n.c(true);
        }
        finish();
    }
}
