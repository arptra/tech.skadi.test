package com.upuphone.ar.navi.lite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.model.ICheckPermission;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.view.PrivacyView;
import java.util.List;

public class PermissionsActivity extends Activity implements PrivacyView.OnPrivacySelectedListener {
    public static final String b = ("NAVI-" + PermissionsActivity.class.getSimpleName());

    /* renamed from: a  reason: collision with root package name */
    public PrivacyView f5645a;

    public void a() {
        String str = b;
        CLog.b(str, " ######## agree ############");
        this.f5645a.setVisibility(8);
        List p = NaviUtil.p(this);
        if (p == null || p.size() <= 0) {
            CLog.b(str, " ######## agree ########### isStarted=" + LocationManager.f().m());
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
            finish();
            return;
        }
        CLog.b(str, " ######## agree ######%%%%%%%%%%####");
        NaviUtil.g0(this, true, (ICheckPermission) null);
    }

    public void b() {
        finish();
    }

    public final void c() {
        PrivacyView privacyView = (PrivacyView) findViewById(R.id.privacyView);
        this.f5645a = privacyView;
        privacyView.setOnClickListener((View.OnClickListener) null);
        this.f5645a.setOnPrivacySelectedListener(this);
    }

    public final void d() {
        if (this.f5645a.b()) {
            this.f5645a.c();
            this.f5645a.e();
            return;
        }
        super.onBackPressed();
    }

    public void onBackPressed() {
        if (this.f5645a.isShown()) {
            d();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CLog.b(b, " ######## onCreate ############");
        setContentView(R.layout.activity_permissions);
        c();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        String str = b;
        CLog.b(str, "onRequestPermissionsResult &&&&&&&& requestCode=" + i + " needSetPermission=" + NaviUtil.S0(this));
        if (!NaviUtil.S0(this) && !LocationManager.f().m()) {
            NaviOperatorManager.getInstance(getApplicationContext()).startLocation(getApplicationContext());
        }
        finish();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
