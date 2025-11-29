package com.upuphone.starrynet.core.car;

import android.car.Car;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.upuphone.starrynet.common.StLog;

public class CarManager371 extends CarBaseManager {
    private static final String ACTION_POWER_STRMODE = "ecarx.intent.action.power.STRMODE";
    private static final int POWER_STATE_SHUTDOWN_PREPARE = 7;
    private static final int POWER_STATE_SUSPEND_EXIT = 3;
    private static final String PROPERTY_SERVICE_POWER_STR = "service.power.str";
    private static final String SERVICE_POWER_STR_VALUE_ENTRE = "enter";
    private static final String SERVICE_POWER_STR_VALUE_EXIT = "exit";
    private static final String STR_MODE = "strmode";
    private static final String TAG = "CarManager371";

    public class PowerBroadcastReceiver extends BroadcastReceiver {
        private PowerBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            StLog.d(CarManager371.TAG, "onReceive : " + action);
            if (CarManager371.ACTION_POWER_STRMODE.equals(action)) {
                int intExtra = intent.getIntExtra(CarManager371.STR_MODE, 0);
                StLog.d(CarManager371.TAG, "power state = " + intExtra);
                if (intExtra == 7) {
                    CarManager371 carManager371 = CarManager371.this;
                    carManager371.isCarStrMode = true;
                    carManager371.mCallback.onStrModeChanged(true);
                } else if (intExtra == 3) {
                    CarManager371 carManager3712 = CarManager371.this;
                    carManager3712.isCarStrMode = false;
                    carManager3712.mCallback.onStrModeChanged(false);
                }
            }
        }
    }

    public CarManager371(Context context, ICarManagerCallback iCarManagerCallback) {
        super(context, iCarManagerCallback);
        PowerBroadcastReceiver powerBroadcastReceiver = new PowerBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_POWER_STRMODE);
        context.registerReceiver(powerBroadcastReceiver, intentFilter);
    }

    public void connectCarPowerManager(Car car) {
    }

    public void disconnectCarPowerManager() {
    }

    public boolean isStrMode() {
        if (SERVICE_POWER_STR_VALUE_ENTRE.equals(Utils.getProperty(PROPERTY_SERVICE_POWER_STR, SERVICE_POWER_STR_VALUE_EXIT))) {
            this.isCarStrMode = true;
            this.mCallback.onStrModeChanged(true);
        }
        return this.isCarStrMode;
    }
}
