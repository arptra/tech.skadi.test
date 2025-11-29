package com.jstyle.nordic_otas.nordic_otas_plugin;

import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

public class DfuService extends DfuBaseService {
    public Class<? extends Activity> getNotificationTarget() {
        return NotificationActivity.class;
    }

    public boolean isDebug() {
        return true;
    }
}
