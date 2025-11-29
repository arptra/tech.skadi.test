package com.upuphone.ar.navi.lite.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;

public class SensorEventHelper implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f5812a;
    public Sensor b;
    public Display c;
    public long d = 0;
    public float e;
    public Context f;
    public RotateChangedListener g;

    public interface RotateChangedListener {
        void a(float f);
    }

    public SensorEventHelper(Context context) {
        this.f = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f5812a = sensorManager;
        this.b = sensorManager.getDefaultSensor(3);
        this.c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public float a() {
        return NaviUtil.s0() ? this.e : 360.0f - this.e;
    }

    public int b() {
        Display display = this.c;
        if (display == null) {
            return 0;
        }
        int rotation = display.getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : -90;
        }
        return 180;
    }

    public void c() {
        this.f5812a.registerListener(this, this.b, 3);
    }

    public void d(RotateChangedListener rotateChangedListener) {
        this.g = rotateChangedListener;
    }

    public void e() {
        this.f5812a.unregisterListener(this, this.b);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.d >= 100 && sensorEvent.sensor.getType() == 3) {
            float b2 = (sensorEvent.values[0] + ((float) b())) % 360.0f;
            if (b2 > 180.0f) {
                b2 -= 360.0f;
            } else if (b2 < -180.0f) {
                b2 += 360.0f;
            }
            if (Math.abs(this.e - b2) >= 3.0f) {
                if (Float.isNaN(b2)) {
                    b2 = 0.0f;
                }
                this.e = b2;
                RotateChangedListener rotateChangedListener = this.g;
                if (rotateChangedListener != null) {
                    rotateChangedListener.a(a());
                }
                this.d = System.currentTimeMillis();
            }
        }
    }
}
