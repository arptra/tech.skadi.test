package com.xjsd.ai.assistant.common;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.xjsd.ai.assistant.log.ILog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AudioFocusManager implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final AudioFocusRequest f8410a;
    public final AudioFocusRequest b;
    public AtomicInteger c;
    public Set d;
    public Set e;

    public static final class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final AudioFocusManager f8411a = new AudioFocusManager();
    }

    public interface RequestAudioFocusCallback {
        void a();

        void onSuccess();
    }

    public static AudioFocusManager a() {
        return Holder.f8411a;
    }

    public final boolean b(Context context, AudioFocusRequest audioFocusRequest) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (audioManager != null ? audioManager.abandonAudioFocusRequest(audioFocusRequest) : -1) == 1;
    }

    public synchronized void c(Context context, int i) {
        this.e.remove(Integer.valueOf(i));
        if (this.e.isEmpty()) {
            boolean b2 = b(context, this.b);
            ILog.a("AudioFocusManager", "释放混音音频焦点返回->" + b2);
        }
    }

    public synchronized void d(Context context, int i) {
        this.d.remove(Integer.valueOf(i));
        if (this.d.isEmpty()) {
            boolean b2 = b(context, this.b);
            ILog.a("AudioFocusManager", "释放短音频焦点返回->" + b2);
        }
    }

    public final int e(Context context, AudioFocusRequest audioFocusRequest, RequestAudioFocusCallback requestAudioFocusCallback) {
        int incrementAndGet = this.c.incrementAndGet();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int requestAudioFocus = audioManager.requestAudioFocus(audioFocusRequest);
        int mode = audioManager.getMode();
        ILog.a("AudioFocusManager", "申请音频焦点返回结果->" + requestAudioFocus);
        boolean z = true;
        if (requestAudioFocus != 1 || mode == 2 || mode == 3) {
            ILog.a("AudioFocusManager", "申请音频焦点失败，申请id->" + incrementAndGet);
            z = false;
        } else {
            ILog.a("AudioFocusManager", "申请音频焦点成功，申请id->" + incrementAndGet);
        }
        if (requestAudioFocusCallback != null) {
            if (z) {
                requestAudioFocusCallback.onSuccess();
            } else {
                requestAudioFocusCallback.a();
            }
        }
        return incrementAndGet;
    }

    public synchronized int f(Context context, RequestAudioFocusCallback requestAudioFocusCallback) {
        int e2;
        e2 = e(context, this.b, requestAudioFocusCallback);
        this.e.add(Integer.valueOf(e2));
        return e2;
    }

    public synchronized int g(Context context, RequestAudioFocusCallback requestAudioFocusCallback) {
        int e2;
        e2 = e(context, this.f8410a, requestAudioFocusCallback);
        this.d.add(Integer.valueOf(e2));
        return e2;
    }

    public void onAudioFocusChange(int i) {
        ILog.j("AudioFocusManager", "onAudioFocusChange->" + i);
        if (i == -3) {
            ILog.a("AudioFocusManager", "暂时性失去焦点，但可以降低音量播放，不清除请求id列表");
        } else if (i == -2) {
            ILog.a("AudioFocusManager", "暂时性失去焦点，不清除请求id列表");
        } else if (i == -1) {
            ILog.a("AudioFocusManager", "永久失去焦点，清除请求id列表");
            this.d.clear();
            this.e.clear();
        } else if (i == 1) {
            ILog.a("AudioFocusManager", "获取音频长焦点");
        } else if (i == 2) {
            ILog.a("AudioFocusManager", "获取音频短焦点");
        }
    }

    public AudioFocusManager() {
        this.f8410a = new AudioFocusRequest.Builder(2).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
        this.b = new AudioFocusRequest.Builder(3).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
        this.c = new AtomicInteger(0);
        this.d = new HashSet();
        this.e = new HashSet();
    }
}
