package com.ucar.vehiclesdk.cast;

import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.ucar.vehiclesdk.MDevice;
import com.ucar.vehiclesdk.player.VideoPlayerV2;
import com.ucar.vehiclesdk.player.VideoQueueManager;
import com.ucarsink.sink.natives.SinkNative;
import java.util.HashMap;

public class CastManager {

    /* renamed from: a  reason: collision with root package name */
    public MDevice f5417a;
    public int b;
    public CastListener c;
    public String d;
    public VideoPlayerV2 e;
    public final VideoQueueManager f;
    public long g;
    public boolean h;
    public SinkNative.WfdListener i;

    /* renamed from: com.ucar.vehiclesdk.cast.CastManager$1  reason: invalid class name */
    public class AnonymousClass1 implements SinkNative.WfdListener {
    }

    /* renamed from: com.ucar.vehiclesdk.cast.CastManager$2  reason: invalid class name */
    public class AnonymousClass2 implements VideoPlayerV2.DecodeVideoSizeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CastManager f5418a;

        public void a(int i, int i2) {
            CastListener castListener = this.f5418a.c;
            if (castListener != null) {
                castListener.a(i, i2);
            }
        }
    }

    public void a() {
        this.f.a();
    }

    public void b(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("kWhatAudioLatency", String.valueOf(i2));
        SinkNative.setParameter(this.d, hashMap);
    }

    public synchronized void c() {
        VideoPlayerV2 videoPlayerV2 = this.e;
        if (videoPlayerV2 != null && videoPlayerV2.L()) {
            this.e.J(false);
            this.e.M();
        }
    }

    public void d(MDevice mDevice) {
        this.f5417a = mDevice;
    }

    public void e(boolean z) {
        EasyLog.a("CastManager", "bNeedDump:" + z);
        this.h = z;
    }

    public void f(int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3) {
        MDevice mDevice = this.f5417a;
        if (mDevice == null || TextUtils.isEmpty(mDevice.getAddress())) {
            EasyLog.c("CastManager", "MDevice is null, can not cast");
            return;
        }
        this.b = i5;
        SinkNative.a(this.i);
        SinkNative.start(this.f5417a.getAddress(), this.f5417a.getPort(), i2, i3, i4, i5, z, z2, z3);
    }

    public final synchronized void g() {
        try {
            VideoPlayerV2 videoPlayerV2 = this.e;
            if (videoPlayerV2 != null) {
                videoPlayerV2.N();
                this.e = null;
            }
            this.f.a();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void h() {
        EasyLog.e("CastManager", "stop Cast");
        c();
        g();
        SinkNative.stop(this.d);
        SinkNative.b();
        this.d = null;
    }

    public synchronized void i(long j) {
        try {
            VideoPlayerV2 videoPlayerV2 = this.e;
            if (videoPlayerV2 != null) {
                videoPlayerV2.O(j);
            }
            this.g = j;
        } catch (Throwable th) {
            throw th;
        }
    }
}
