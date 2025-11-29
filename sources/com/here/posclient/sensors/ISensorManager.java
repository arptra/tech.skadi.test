package com.here.posclient.sensors;

public interface ISensorManager {
    public static final long SENSOR_ACCELEROMETER = 2;
    public static final long SENSOR_ACTIVITY = 1;
    public static final long SENSOR_BAROMETER = 16;
    public static final long SENSOR_GRAVITY = 8;
    public static final long SENSOR_PURE_ACCELERATION = 4;
    public static final long SENSOR_UNKNOWN = 0;

    public interface Listener {
        void onHandleActivityResult(ActivityResult activityResult);
    }

    void close();

    void open();

    int requestSensorStatus(long j);

    int subscribe(long j);

    long supportedSensorTypes();

    void unsubscribe(long j);
}
