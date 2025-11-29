package com.upuphone.starrynet.core.car;

import android.car.Car;
import android.car.hardware.power.CarPowerManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.upuphone.starrynet.common.StLog;

public abstract class CarBaseManager {
    private static final long CAR_CONNECT_START_TIMEOUT = 5000;
    private static final long CAR_RECONNECT_TIMEOUT = 1000;
    private static final long CAR_TIMEOUT = 200;
    public static final String TAG = "CarBaseManager";
    protected boolean isCarStrMode = false;
    protected final ICarManagerCallback mCallback;
    /* access modifiers changed from: private */
    public Car mCar;
    /* access modifiers changed from: private */
    public final Handler mCarHandler;
    protected CarPowerManager mCarPowerManager;
    /* access modifiers changed from: private */
    public final Context mContext;
    protected final CarPowerManager.CarPowerStateListener mPowerStateListener = new CarPowerManager.CarPowerStateListener() {
        public void onStateChanged(int i) {
            StLog.d(CarBaseManager.TAG, "CarPowerManagerListener state changed: state = " + i);
            if (i == 7) {
                CarBaseManager carBaseManager = CarBaseManager.this;
                carBaseManager.isCarStrMode = true;
                carBaseManager.mCallback.onStrModeChanged(true);
            } else if (i == 3) {
                CarBaseManager carBaseManager2 = CarBaseManager.this;
                carBaseManager2.isCarStrMode = false;
                carBaseManager2.mCallback.onStrModeChanged(false);
            }
        }
    };
    private final Runnable singletonCarConnectionTask = new Runnable() {
        public void run() {
            StLog.d(CarBaseManager.TAG, "Car.connect task start");
            try {
                if (CarBaseManager.this.mCar != null && CarBaseManager.this.mCar.isConnected()) {
                    CarBaseManager.this.mCar.disconnect();
                }
                CarBaseManager carBaseManager = CarBaseManager.this;
                Car unused = carBaseManager.mCar = Car.createCar(carBaseManager.mContext, CarBaseManager.this.mCarHandler, 200, new Car.CarServiceLifecycleListener() {
                    public void onLifecycleChanged(Car car, boolean z) {
                        StLog.d(CarBaseManager.TAG, "onLifecycleChanged ready = " + z);
                        if (z) {
                            CarBaseManager.this.connectCarPowerManager(car);
                            return;
                        }
                        StLog.i(CarBaseManager.TAG, "disconnected from Car Service, reConnecting...");
                        CarBaseManager.this.connectCar(1000);
                    }
                });
                if (CarBaseManager.this.mCar == null) {
                    StLog.e(CarBaseManager.TAG, "Car.create: connect failed, reconnecting ");
                    CarBaseManager.this.connectCar(1000);
                    return;
                }
                StLog.d(CarBaseManager.TAG, "Car.create: successful");
            } catch (Exception unused2) {
                StLog.e(CarBaseManager.TAG, "Car.create: unknown exception, reconnecting if needed");
                if (CarBaseManager.this.mCar == null) {
                    CarBaseManager.this.connectCar(1000);
                }
            }
        }
    };

    public CarBaseManager(Context context, ICarManagerCallback iCarManagerCallback) {
        this.mContext = context;
        this.mCallback = iCarManagerCallback;
        this.mCarHandler = new Handler(Looper.getMainLooper());
        connectCar(5000);
    }

    /* access modifiers changed from: private */
    public void connectCar(long j) {
        StLog.d(TAG, "connectCar delay = " + j);
        this.mCarHandler.postDelayed(this.singletonCarConnectionTask, j);
    }

    private void disconnectCar() {
        Car car = this.mCar;
        if (car != null) {
            car.disconnect();
            this.mCar = null;
        }
    }

    public abstract void connectCarPowerManager(Car car);

    public abstract void disconnectCarPowerManager();

    public abstract boolean isStrMode();
}
