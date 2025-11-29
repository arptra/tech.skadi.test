package com.upuphone.xr.sapp;

import android.content.Intent;
import android.os.Bundle;
import com.xjmz.myvu.MYVUActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/MainActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(new Intent(this, MYVUActivity.class));
        finish();
    }
}
