package com.upuphone.starryshare.server;

import android.os.Environment;
import android.text.TextUtils;
import com.upuphone.starrycommon.utils.FileUtils;
import com.upuphone.starrycommon.utils.StarryCastLog;
import com.upuphone.starryshare.FileTransferDelegate;
import com.upuphone.starryshare.bean.FileInfo;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

public class FileReceiver extends BaseTransfer implements Runnable {
    public static final String k = "FileReceiver";

    /* renamed from: a  reason: collision with root package name */
    public Socket f6555a;
    public DataInputStream b;
    public List c;
    public final Object d = new Object();
    public boolean e = false;
    public OnReceiveListener f;
    public String g;
    public String h;
    public long i = 0;
    public int j = 1;

    public interface OnReceiveListener {
        void a(String str, int i, String str2);

        void b(String str, Throwable th, int i);

        void c(String str);

        void onFinish(String str, String str2);

        void onStart();

        void onSuccess(String str);
    }

    public FileReceiver(Socket socket) {
        this.f6555a = socket;
    }

    public void a() {
        Socket socket = this.f6555a;
        if (socket != null && socket.isConnected()) {
            try {
                this.f6555a.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        d();
    }

    public final boolean b(String str, File file) {
        String a2 = FileUtils.a(file);
        String str2 = k;
        StarryCastLog.d(str2, "newMd5:" + a2 + "oldMd5:" + str);
        return str.equals(a2);
    }

    public void c(String str) {
        String[] split = str.split("\\/");
        String str2 = "";
        for (int i2 = 0; i2 < split.length; i2++) {
            str2 = str2 + "/" + split[i2];
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public void d() {
        List<FileInfo> list = this.c;
        if (list != null) {
            for (FileInfo fileInfo : list) {
                String str = TextUtils.isEmpty(this.g) ? FileTransferDelegate.f6549a : this.g;
                File file = new File(str + File.separator + fileInfo.getMd5());
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public void e() {
        DataInputStream dataInputStream = this.b;
        if (dataInputStream != null) {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
        Socket socket = this.f6555a;
        if (socket != null && socket.isConnected()) {
            try {
                this.f6555a.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        StarryCastLog.d(k, "FileReceiver close socket######>>>");
    }

    public int f() {
        return this.j;
    }

    public void g() {
        if (this.f6555a != null) {
            this.b = new DataInputStream(this.f6555a.getInputStream());
        }
    }

    public void h() {
        long j2;
        int i2;
        int read;
        Iterator it;
        FileReceiver fileReceiver;
        long j3;
        long j4;
        FileReceiver fileReceiver2 = this;
        StarryCastLog.d(k, "parseBody######>>>start");
        Iterator it2 = fileReceiver2.c.iterator();
        long j5 = 0;
        while (it2.hasNext()) {
            FileInfo fileInfo = (FileInfo) it2.next();
            long size = fileInfo.getSize();
            String str = TextUtils.isEmpty(fileReceiver2.g) ? FileTransferDelegate.f6549a : fileReceiver2.g;
            fileReceiver2.c(str);
            if (!new File(str).exists()) {
                StarryCastLog.c(k, "Can't create upp share directory ");
                str = Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_DOWNLOADS;
            }
            String str2 = str;
            String str3 = str2 + File.separator + fileInfo.getMd5();
            fileInfo.setFilePath(str3);
            FileOutputStream fileOutputStream = new FileOutputStream(str3, true);
            long beginOfFile = fileInfo.getBeginOfFile();
            if (beginOfFile >= size) {
                beginOfFile = 0;
            }
            byte[] bArr = new byte[1024];
            j5 += j2;
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                i2 = (j2 > size ? 1 : (j2 == size ? 0 : -1));
                if (i2 >= 0 || (read = fileReceiver2.b.read(bArr)) == -1) {
                    FileReceiver fileReceiver3 = fileReceiver2;
                    Iterator it3 = it2;
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                } else {
                    synchronized (fileReceiver2.d) {
                        if (fileReceiver2.e) {
                            try {
                                fileReceiver2.d.wait();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                        long j6 = (long) read;
                        long j7 = j5 + j6;
                        j2 += j6;
                        int i3 = (int) (size - j2);
                        if (i3 >= 1024 || i3 <= 0) {
                            fileReceiver = this;
                            it = it2;
                        } else {
                            byte[] bArr2 = new byte[i3];
                            fileReceiver = this;
                            int read2 = fileReceiver.b.read(bArr2);
                            it = it2;
                            fileOutputStream.write(bArr2, 0, read2);
                            fileOutputStream.flush();
                            long j8 = (long) read2;
                            j2 += j8;
                            j7 += j8;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (currentTimeMillis2 - currentTimeMillis > 200) {
                            OnReceiveListener onReceiveListener = fileReceiver.f;
                            if (onReceiveListener != null) {
                                j4 = currentTimeMillis2;
                                j3 = j7;
                                onReceiveListener.a(fileReceiver.h, (int) ((100 * j7) / fileReceiver.i), fileInfo.getFilePath());
                            } else {
                                j4 = currentTimeMillis2;
                                j3 = j7;
                            }
                            currentTimeMillis = j4;
                        } else {
                            j3 = j7;
                        }
                    }
                    fileReceiver2 = fileReceiver;
                    it2 = it;
                    j5 = j3;
                }
            }
            FileReceiver fileReceiver32 = fileReceiver2;
            Iterator it32 = it2;
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            if (i2 == 0) {
                if (fileReceiver32.f != null) {
                    String str4 = str2 + File.separator + fileInfo.getName();
                    File file = new File(str3);
                    if (fileReceiver32.b(fileInfo.getMd5(), file)) {
                        File file2 = new File(str4);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file.renameTo(file2);
                        fileInfo.setFilePath(str4);
                        fileReceiver32.f.onFinish(fileReceiver32.h, fileInfo.getFilePath());
                    } else {
                        d();
                        StarryCastLog.d(k, " 校验文件失败 taskId:" + fileReceiver32.h + " try new send");
                        throw new IllegalStateException("校验文件失败");
                    }
                }
                fileReceiver2 = fileReceiver32;
                it2 = it32;
            } else {
                d();
                StarryCastLog.d(k, " 文件缺失:" + fileReceiver32.h);
                throw new IllegalStateException("校验文件失败");
            }
        }
        FileReceiver fileReceiver4 = fileReceiver2;
        if (j5 >= fileReceiver4.i) {
            StarryCastLog.d(k, "parseBody######>>>end");
            OnReceiveListener onReceiveListener2 = fileReceiver4.f;
            if (onReceiveListener2 != null) {
                fileReceiver4.j = 4;
                onReceiveListener2.onSuccess(fileReceiver4.h);
                fileReceiver4.b.close();
                return;
            }
            return;
        }
        d();
        throw new Exception("接收失败");
    }

    public void i() {
        StarryCastLog.d(k, "parseHeader######>>>start");
        int readInt = this.b.readInt();
        byte[] bArr = new byte[readInt];
        int i2 = 0;
        do {
            int read = this.b.read();
            if (read == -1) {
                break;
            }
            bArr[i2] = (byte) read;
            i2++;
        } while (i2 != readInt);
        String str = k;
        StringBuilder sb = new StringBuilder();
        sb.append("FileReceiver receive header------>>>");
        Charset charset = StandardCharsets.UTF_8;
        sb.append(new String(bArr, charset));
        StarryCastLog.d(str, sb.toString());
        List<FileInfo> lists = FileInfo.toLists(new String(bArr, charset).split("::")[1].trim());
        this.c = lists;
        for (FileInfo next : lists) {
            this.h = next.getTaskId();
            this.i += next.getSize();
        }
        StarryCastLog.d(k, "parseHeader######>>>end");
    }

    public void j(OnReceiveListener onReceiveListener) {
        this.f = onReceiveListener;
    }

    public void k(String str) {
        this.g = str;
    }

    public void run() {
        try {
            OnReceiveListener onReceiveListener = this.f;
            if (onReceiveListener != null) {
                this.j = 3;
                onReceiveListener.onStart();
            }
            g();
            try {
                i();
                OnReceiveListener onReceiveListener2 = this.f;
                if (onReceiveListener2 != null) {
                    onReceiveListener2.c(this.h);
                }
                try {
                    h();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    StarryCastLog.d(k, "FileReceiver parseBody() --->>> occur expection");
                    if (this.f != null) {
                        this.j = 4;
                        this.f.b(this.h, e2, -1);
                    }
                    e();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                StarryCastLog.d(k, "FileReceiver parseHeader() --->>> occur expection");
                OnReceiveListener onReceiveListener3 = this.f;
                if (onReceiveListener3 != null) {
                    this.j = 4;
                    onReceiveListener3.b(this.h, e3, -1);
                }
                e();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            StarryCastLog.d(k, "FileReceiver init() --->>> occur expection");
            OnReceiveListener onReceiveListener4 = this.f;
            if (onReceiveListener4 != null) {
                this.j = 4;
                onReceiveListener4.b(this.h, e4, -1);
            }
            e();
        }
    }
}
