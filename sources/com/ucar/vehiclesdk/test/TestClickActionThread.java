package com.ucar.vehiclesdk.test;

import com.easy.logger.EasyLog;
import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import java.util.Random;

public class TestClickActionThread extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5480a = false;
    public int b;
    public int c;
    public Random d = new Random();
    public int e = 1;
    public int[] f;
    public int[] g;
    public int[] h;
    public long i;

    public TestClickActionThread(int i2, int i3) {
        this.c = i3;
        this.b = i2;
    }

    public void interrupt() {
        this.f5480a = false;
        try {
            super.interrupt();
        } catch (Exception e2) {
            EasyLog.d("TestCilckActionThread", "interrupt exception", e2);
        }
    }

    public void run() {
        super.run();
        while (this.f5480a && !Thread.interrupted()) {
            int i2 = this.e;
            this.f = new int[i2];
            this.g = new int[i2];
            this.h = new int[i2];
            for (int i3 = 0; i3 < this.e; i3++) {
                this.f[i3] = 0;
                this.g[i3] = this.d.nextInt(this.b);
                this.h[i3] = this.d.nextInt(this.c);
            }
            UCarAdapter.R0().n2(UCarCommon.KeyEventActionType.KEY_EVENT_ACTION_DOWN.getValue(), this.e, this.f, this.g, this.h);
            try {
                Thread.sleep(100);
            } catch (Exception e2) {
                EasyLog.d("TestCilckActionThread", "sleep duration 1 error.", e2);
            }
            UCarAdapter.R0().n2(UCarCommon.KeyEventActionType.KEY_EVENT_ACTION_UP.getValue(), this.e, this.f, this.g, this.h);
            long nextInt = (long) (this.d.nextInt(901) + 100);
            this.i = nextInt;
            try {
                Thread.sleep(nextInt);
            } catch (Exception e3) {
                EasyLog.d("TestCilckActionThread", "sleep duration 2 error.", e3);
            }
        }
    }

    public synchronized void start() {
        this.f5480a = true;
        try {
            super.start();
        } catch (Exception e2) {
            EasyLog.d("TestCilckActionThread", "start exception", e2);
        }
        return;
    }
}
