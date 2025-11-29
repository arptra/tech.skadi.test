package com.xjsd.ai.assistant.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.log.ILog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

class AudioDataSaveDelegate2 {

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f8390a;
    public final Handler b;
    public String c;
    public volatile boolean d;
    public String e;
    public FileOutputStream f;
    public FileOutputStream g;
    public FileOutputStream h;
    public FileOutputStream i;
    public FileOutputStream j;
    public final ExecutorService k = ThreadPoolFactory.b("AudioFileSizeProcess");
    public final Runnable l = new a(this);

    public AudioDataSaveDelegate2() {
        HandlerThread handlerThread = new HandlerThread("audio-save-worker");
        this.f8390a = handlerThread;
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper()) {
            public final void a(FileOutputStream fileOutputStream) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                        ILog.h("AudioDataSaveDelegate2", "closeFileOutputStream: 关闭流异常", e);
                    }
                }
            }

            public final void b(FileOutputStream fileOutputStream, byte[] bArr) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                    } catch (IOException unused) {
                    }
                }
            }

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    String format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(Long.valueOf(System.currentTimeMillis()));
                    AudioDataSaveDelegate2 audioDataSaveDelegate2 = AudioDataSaveDelegate2.this;
                    audioDataSaveDelegate2.e = "task#" + format;
                    ILog.a("AudioDataSaveDelegate2", "handleMessage: task->" + AudioDataSaveDelegate2.this.e);
                    String f = AudioDataSaveDelegate2.this.c;
                    if (((Boolean) message.obj).booleanValue()) {
                        AudioDataSaveDelegate2 audioDataSaveDelegate22 = AudioDataSaveDelegate2.this;
                        audioDataSaveDelegate22.f = audioDataSaveDelegate22.u(f, format + "_0-low-power.pcm");
                        return;
                    }
                    AudioDataSaveDelegate2 audioDataSaveDelegate23 = AudioDataSaveDelegate2.this;
                    audioDataSaveDelegate23.g = audioDataSaveDelegate23.u(f, format + "_1-origin.pcm");
                    AudioDataSaveDelegate2 audioDataSaveDelegate24 = AudioDataSaveDelegate2.this;
                    audioDataSaveDelegate24.h = audioDataSaveDelegate24.u(f, format + "_2-reduce.pcm");
                    AudioDataSaveDelegate2 audioDataSaveDelegate25 = AudioDataSaveDelegate2.this;
                    audioDataSaveDelegate25.i = audioDataSaveDelegate25.u(f, format + "_3-encode.pcm");
                    AudioDataSaveDelegate2 audioDataSaveDelegate26 = AudioDataSaveDelegate2.this;
                    audioDataSaveDelegate26.j = audioDataSaveDelegate26.u(f, format + "_4-trans.pcm");
                } else if (i != 1001) {
                    switch (i) {
                        case 1011:
                            b(AudioDataSaveDelegate2.this.f, (byte[]) message.obj);
                            return;
                        case MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT:
                            b(AudioDataSaveDelegate2.this.g, (byte[]) message.obj);
                            return;
                        case MSG.MSG_GLASS_SCREEN_STATE:
                            b(AudioDataSaveDelegate2.this.h, (byte[]) message.obj);
                            return;
                        case 1014:
                            b(AudioDataSaveDelegate2.this.i, (byte[]) message.obj);
                            return;
                        case 1015:
                            b(AudioDataSaveDelegate2.this.j, (byte[]) message.obj);
                            return;
                        default:
                            return;
                    }
                } else {
                    a(AudioDataSaveDelegate2.this.f);
                    a(AudioDataSaveDelegate2.this.g);
                    a(AudioDataSaveDelegate2.this.h);
                    a(AudioDataSaveDelegate2.this.i);
                    a(AudioDataSaveDelegate2.this.j);
                    AudioDataSaveDelegate2.this.f = null;
                    AudioDataSaveDelegate2.this.g = null;
                    AudioDataSaveDelegate2.this.h = null;
                    AudioDataSaveDelegate2.this.i = null;
                    AudioDataSaveDelegate2.this.j = null;
                    ILog.a("AudioDataSaveDelegate2", "handleMessage: 保存文件结束，task->" + AudioDataSaveDelegate2.this.e);
                }
            }
        };
    }

    public static /* synthetic */ int w(File file, File file2) {
        int i2 = (file.lastModified() > file2.lastModified() ? 1 : (file.lastModified() == file2.lastModified() ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }

    public static /* synthetic */ void x(File file) {
        boolean delete = file.delete();
        ILog.a("AudioDataSaveDelegate2", "remove file->" + file.getName() + ", result->" + delete);
    }

    public void A(byte[] bArr) {
        z(1014, bArr);
    }

    public void B(byte[] bArr) {
        z(1011, bArr);
    }

    public void C(byte[] bArr) {
        z(MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT, bArr);
    }

    public void D(byte[] bArr) {
        z(MSG.MSG_GLASS_SCREEN_STATE, bArr);
    }

    public void E(byte[] bArr) {
        z(1015, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void F(boolean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.d     // Catch:{ all -> 0x0010 }
            if (r0 != r2) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r2 == 0) goto L_0x0012
            r1.t()     // Catch:{ all -> 0x0010 }
            r2 = 1
            r1.d = r2     // Catch:{ all -> 0x0010 }
            goto L_0x0018
        L_0x0010:
            r2 = move-exception
            goto L_0x001a
        L_0x0012:
            r2 = 0
            r1.d = r2     // Catch:{ all -> 0x0010 }
            r1.H()     // Catch:{ all -> 0x0010 }
        L_0x0018:
            monitor-exit(r1)
            return
        L_0x001a:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.audio.AudioDataSaveDelegate2.F(boolean):void");
    }

    public synchronized void G(boolean z) {
        if (this.d) {
            H();
            this.k.execute(this.l);
            this.b.sendMessage(this.b.obtainMessage(1000, Boolean.valueOf(z)));
        }
    }

    public void H() {
        this.b.sendMessage(this.b.obtainMessage(1001));
    }

    public final void s() {
        File[] listFiles;
        File file = new File(this.c);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 200) {
            Arrays.stream(listFiles).sorted(new b()).limit((long) (listFiles.length - 200)).forEach(new c());
        }
    }

    public final void t() {
        File file = new File(this.c);
        ILog.a("AudioDataSaveDelegate2", "音频保存路径->" + file.getAbsolutePath());
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            ILog.a("AudioDataSaveDelegate2", "创建文件夹->" + mkdirs);
        }
    }

    public final FileOutputStream u(String str, String str2) {
        File file = new File(str, str2);
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            ILog.a("AudioDataSaveDelegate2", "创建文件夹->" + str + "，创建结果->" + mkdirs);
        }
        if (file.exists()) {
            ILog.a("AudioDataSaveDelegate2", "文件->" + file.getAbsolutePath() + "已存在");
            return null;
        }
        try {
            boolean createNewFile = file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ILog.j("AudioDataSaveDelegate2", "create file->" + str2 + "，创建结果->" + createNewFile);
            return fileOutputStream;
        } catch (IOException e2) {
            ILog.h("AudioDataSaveDelegate2", "create file->" + str2 + ", failed", e2);
            return null;
        }
    }

    public void v(Context context, boolean z) {
        ILog.a("AudioDataSaveDelegate2", "是否保存音频数据->" + z);
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext.getFilesDir().getAbsolutePath() + File.separator + "ulog/asrAudio/";
        applicationContext.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("open", 0);
                ILog.j("AudioDataSaveDelegate2", "收到开关音频记录广播->" + intExtra);
                if (intExtra == 1) {
                    AudioDataSaveDelegate2.this.F(true);
                } else {
                    AudioDataSaveDelegate2.this.F(false);
                }
            }
        }, new IntentFilter("assistant.intent.action.SAVE_AUDIO_PCM"), 2);
        F(z);
    }

    public final /* synthetic */ void y() {
        ILog.a("AudioDataSaveDelegate2", "音频文件数目维护->start");
        s();
        ILog.a("AudioDataSaveDelegate2", "音频文件数目维护->end");
    }

    public final void z(int i2, byte[] bArr) {
        this.b.sendMessage(this.b.obtainMessage(i2, Arrays.copyOf(bArr, bArr.length)));
    }
}
