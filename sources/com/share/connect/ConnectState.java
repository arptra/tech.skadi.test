package com.share.connect;

import com.easy.logger.EasyLog;

public class ConnectState {
    public static volatile ConnectState b;

    /* renamed from: a  reason: collision with root package name */
    public volatile String f9871a = "idle";

    public static ConnectState b() {
        if (b == null) {
            synchronized (ConnectState.class) {
                try {
                    if (b == null) {
                        b = new ConnectState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public synchronized String a() {
        return this.f9871a;
    }

    public synchronized boolean c() {
        return this.f9871a.contains("connected");
    }

    public synchronized boolean d() {
        return this.f9871a.contains("disconnect");
    }

    public synchronized boolean e() {
        return this.f9871a.equals("idle") || d();
    }

    public synchronized boolean f() {
        return this.f9871a.equals("usb_connected");
    }

    public synchronized boolean g() {
        return this.f9871a.equals("usb_connecting") || this.f9871a.equals("usb_prepare_connecting");
    }

    public synchronized boolean h() {
        return this.f9871a.equals("wifi_connected");
    }

    public synchronized boolean i() {
        return this.f9871a.equals("wifi_connecting");
    }

    public synchronized void j(String str) {
        EasyLog.a("ConnectState", "setCurrentState: " + str);
        this.f9871a = str;
    }
}
