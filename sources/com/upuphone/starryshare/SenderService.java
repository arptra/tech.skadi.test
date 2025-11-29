package com.upuphone.starryshare;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.upuphone.starrycommon.threads.ThreadExecutorKit;
import com.upuphone.starrycommon.utils.StarryCastLog;
import com.upuphone.starryshare.bean.FileInfo;
import com.upuphone.starryshare.listener.IOtaShareListener;
import com.upuphone.starryshare.server.FileSender;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.concurrent.Executor;

public class SenderService {

    /* renamed from: a  reason: collision with root package name */
    public String f6553a;
    public int b;
    public Executor c;
    public final Object d = new Object();
    public IOtaShareListener e;
    public String f;
    public Context g;
    public Runnable h;
    public FileSender i;
    public int j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferStatus {
    }

    public SenderService(Context context) {
        this.g = context.getApplicationContext();
    }

    public void e(String str) {
        StarryCastLog.c("SenderService", "cancel");
        if (this.j < 3) {
            IOtaShareListener iOtaShareListener = this.e;
            if (iOtaShareListener != null) {
                iOtaShareListener.onFailure(str, false, 2);
            }
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        FileSender fileSender = this.i;
        if (fileSender != null) {
            fileSender.b();
        }
    }

    public final Executor f() {
        if (this.c == null) {
            synchronized (this.d) {
                try {
                    if (this.c == null) {
                        this.c = ThreadExecutorKit.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }

    public void g(Runnable runnable) {
        this.h = runnable;
    }

    public void h(String str) {
        this.f6553a = str;
    }

    public void i(int i2) {
        this.b = i2;
    }

    public void j(String str) {
        this.f = str;
        this.j = 1;
    }

    public void k(IOtaShareListener iOtaShareListener) {
        this.e = iOtaShareListener;
    }

    public void l(List list) {
        FileSender fileSender = new FileSender(this.g, list, this.f6553a, this.b);
        this.i = fileSender;
        fileSender.g(new FileSender.OnSendListener() {
            public void a(Throwable th, int i) {
                StarryCastLog.d("SenderService", "send failure");
                if (i == -1 && SenderService.this.h != null) {
                    SenderService.this.h.run();
                }
                if (SenderService.this.e != null) {
                    SenderService.this.e.onFailure(SenderService.this.f, false, 1);
                }
            }

            public void b(FileInfo fileInfo) {
                int unused = SenderService.this.j = 4;
                String desStorage = fileInfo.getDesStorage();
                if (TextUtils.isEmpty(desStorage)) {
                    desStorage = FileTransferDelegate.f6549a;
                }
                File file = new File(desStorage);
                if (!file.isDirectory() && !file.mkdir()) {
                    desStorage = FileTransferDelegate.f6549a;
                    StarryCastLog.c("SenderService", "Can't create base directory " + file.getPath());
                    File file2 = new File(desStorage);
                    if (!file2.exists() && !file2.mkdir()) {
                        StarryCastLog.c("SenderService", "Can't create upp share directory ");
                        desStorage = Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_DOWNLOADS;
                    }
                }
                String str = desStorage + File.separator + fileInfo.getName();
                StarryCastLog.d("SenderService", "onFinish" + str);
                if (SenderService.this.e != null) {
                    SenderService.this.e.onFinish(SenderService.this.f, fileInfo.getUri(), Uri.parse(str));
                }
            }

            public void c(int i, FileInfo fileInfo) {
                StarryCastLog.d("SenderService", "send onProgress" + i);
                if (SenderService.this.e != null) {
                    SenderService.this.e.onProgressChanged(SenderService.this.f, i, Uri.parse(fileInfo.getFilePath()));
                }
            }

            public void onStart() {
                StarryCastLog.d("SenderService", "send onStart");
                int unused = SenderService.this.j = 3;
            }

            public void onSuccess() {
                StarryCastLog.d("SenderService", "send success");
                if (SenderService.this.e != null) {
                    SenderService.this.e.onSuccess(SenderService.this.f);
                }
            }
        });
        f().execute(this.i);
    }
}
