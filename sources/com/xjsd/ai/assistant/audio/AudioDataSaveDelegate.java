package com.xjsd.ai.assistant.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xjsd.ai.assistant.log.ILog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;

class AudioDataSaveDelegate {

    /* renamed from: a  reason: collision with root package name */
    public Context f8388a;
    public volatile boolean b;
    public FileOutputStream c;
    public FileOutputStream d;
    public FileOutputStream e;
    public FileOutputStream f;
    public FileOutputStream g;
    public final ExecutorService h;
    public boolean i;

    /* renamed from: com.xjsd.ai.assistant.audio.AudioDataSaveDelegate$1  reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AudioDataSaveDelegate f8389a;

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("open", 0);
            ILog.j("AudioDataUtil", "收到开关音频记录广播->" + intExtra);
            if (intExtra == 1) {
                this.f8389a.d(true);
            } else {
                this.f8389a.d(false);
            }
        }
    }

    public final void b() {
        File file = new File(c());
        ILog.a("AudioDataUtil", "音频保存路径->" + file.getAbsolutePath());
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            ILog.a("AudioDataUtil", "创建文件夹->" + mkdirs);
        }
    }

    public final String c() {
        return this.f8388a.getFilesDir().getAbsolutePath() + File.separator + "ulog/asrAudio/";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.b     // Catch:{ all -> 0x0014 }
            if (r0 != r4) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            android.content.Context r0 = r3.f8388a     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0016
            java.lang.String r4 = "AudioDataUtil"
            java.lang.String r0 = "mContext is null, do nothing"
            com.xjsd.ai.assistant.log.ILog.a(r4, r0)     // Catch:{ all -> 0x0014 }
            monitor-exit(r3)
            return
        L_0x0014:
            r4 = move-exception
            goto L_0x003d
        L_0x0016:
            if (r4 == 0) goto L_0x0035
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0014 }
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0014 }
            java.util.concurrent.ExecutorService r1 = r3.h     // Catch:{ all -> 0x0014 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ all -> 0x0014 }
            com.honey.account.y9.a r2 = new com.honey.account.y9.a     // Catch:{ all -> 0x0014 }
            r2.<init>(r1)     // Catch:{ all -> 0x0014 }
            r0.<init>(r2)     // Catch:{ all -> 0x0014 }
            r4.addShutdownHook(r0)     // Catch:{ all -> 0x0014 }
            r3.b()     // Catch:{ all -> 0x0014 }
            r4 = 1
            r3.b = r4     // Catch:{ all -> 0x0014 }
            goto L_0x003b
        L_0x0035:
            r4 = 0
            r3.b = r4     // Catch:{ all -> 0x0014 }
            r3.e()     // Catch:{ all -> 0x0014 }
        L_0x003b:
            monitor-exit(r3)
            return
        L_0x003d:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.audio.AudioDataSaveDelegate.d(boolean):void");
    }

    public void e() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = false;
    }
}
