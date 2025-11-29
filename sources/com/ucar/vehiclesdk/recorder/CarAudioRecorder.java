package com.ucar.vehiclesdk.recorder;

import android.media.AudioFormat;
import android.media.AudioRecord;
import com.easy.logger.EasyLog;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

public class CarAudioRecorder extends Thread {
    public static final AtomicInteger i = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    public final AudioConfig f5479a;
    public final Callback b;
    public AudioRecord c;
    public boolean d = true;
    public final String e = ("CarAudioRecorder-" + i.incrementAndGet());
    public int f = 0;
    public boolean g = false;
    public final int h;

    public interface Callback {
        void a(short[] sArr, int i);
    }

    public CarAudioRecorder(AudioConfig audioConfig, boolean z, Callback callback, int i2) {
        this.b = callback;
        this.f5479a = audioConfig;
        this.d = z;
        this.h = i2;
    }

    public final AudioRecord.Builder a() {
        AudioFormat.Builder builder = new AudioFormat.Builder();
        if (12 == this.f5479a.getChannel()) {
            builder.setSampleRate(this.d ? this.f5479a.getSampleRate() : this.f5479a.getSampleRate() * 2).setChannelMask(this.d ? this.f5479a.getChannel() : 16);
        } else {
            builder.setSampleRate(this.f5479a.getSampleRate()).setChannelMask(this.f5479a.getChannel());
        }
        return new AudioRecord.Builder().setAudioFormat(builder.setEncoding(this.f5479a.getFormat()).build()).setAudioSource(this.f5479a.getSource()).setBufferSizeInBytes(this.f);
    }

    public final boolean b() {
        if (12 == this.f5479a.getChannel()) {
            this.f = AudioRecord.getMinBufferSize(this.d ? this.f5479a.getSampleRate() : this.f5479a.getSampleRate() * 2, this.d ? this.f5479a.getChannel() : 16, this.f5479a.getFormat());
        } else {
            this.f = AudioRecord.getMinBufferSize(this.f5479a.getSampleRate(), this.f5479a.getChannel(), this.f5479a.getFormat());
        }
        boolean z = this.f != -2;
        if (!z) {
            EasyLog.c(this.e, "initBuffer error!");
        }
        return z;
    }

    public final boolean c() {
        if (this.c == null) {
            AudioRecord.Builder a2 = a();
            d(a2, this.h);
            try {
                this.c = a2.build();
                return true;
            } catch (UnsupportedOperationException unused) {
                d(a2, 0);
                try {
                    this.c = a2.build();
                    return true;
                } catch (UnsupportedOperationException e2) {
                    EasyLog.j(this.e, "initRecorder failed.", e2);
                }
            }
        }
        return false;
    }

    public final void d(AudioRecord.Builder builder, int i2) {
        String str = this.e;
        EasyLog.a(str, "setSessionId, id: " + i2);
        try {
            AudioRecord.Builder.class.getDeclaredMethod("setSessionId", new Class[]{Integer.TYPE}).invoke(builder, new Object[]{Integer.valueOf(i2)});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            String str2 = this.e;
            EasyLog.c(str2, "set session id error, error msg = " + e2.getMessage());
        }
    }

    public synchronized void e() {
        String str = this.e;
        EasyLog.e(str, "startRecording, supportStereo: " + this.d);
        if (b() && c()) {
            this.g = true;
            start();
        }
    }

    public synchronized void f() {
        this.g = false;
        interrupt();
    }

    public void run() {
        EasyLog.e(this.e, "audio recorder start");
        if (this.c.getState() != 0) {
            int i2 = 15;
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0 || !this.g) {
                    break;
                }
                this.c.startRecording();
                if (this.c.getRecordingState() == 3) {
                    break;
                }
                try {
                    Thread.sleep(10);
                    i2 = i3;
                } catch (InterruptedException e2) {
                    EasyLog.d(this.e, "sleep duration start recording error.", e2);
                }
            }
            if (this.c.getRecordingState() == 3) {
                int i4 = this.f / 2;
                short[] sArr = new short[i4];
                while (this.g) {
                    int read = this.c.read(sArr, 0, i4);
                    if (read > 0) {
                        this.b.a(sArr, read);
                    }
                }
            }
        }
        this.c.release();
        this.c = null;
        this.g = false;
        EasyLog.a(this.e, "audio record released.");
    }
}
