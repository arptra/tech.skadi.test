package com.upuphone.starrynet.core.car;

import android.car.Car;
import android.car.hardware.power.CarPowerManager;
import android.content.Context;
import com.upuphone.starrynet.common.StLog;

public class CarManager extends CarBaseManager {
    public CarManager(Context context, ICarManagerCallback iCarManagerCallback) {
        super(context, iCarManagerCallback);
    }

    public void connectCarPowerManager(Car car) {
        if (car != null) {
            if (this.mCarPowerManager != null) {
                StLog.d(CarBaseManager.TAG, "CarPowerManager not disconnected before creating, disconnect now...");
                disconnectCarPowerManager();
            }
            StLog.d(CarBaseManager.TAG, " connect CarPowerManager");
            CarPowerManager carPowerManager = (CarPowerManager) car.getCarManager("power");
            this.mCarPowerManager = carPowerManager;
            carPowerManager.setListener(this.mPowerStateListener);
        }
    }

    public void disconnectCarPowerManager() {
        CarPowerManager carPowerManager = this.mCarPowerManager;
        if (carPowerManager != null) {
            carPowerManager.clearListener();
            this.mCarPowerManager = null;
        }
    }

    public boolean isStrMode() {
        return this.isCarStrMode;
    }
}
