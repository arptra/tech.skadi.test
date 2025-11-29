package com.jstyle.nordic_otas.nordic_otas_plugin;

import android.app.Activity;
import android.os.Bundle;

public class NotificationActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        isTaskRoot();
        finish();
    }
}
