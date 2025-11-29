package com.upuphone.starrycommon.utils;

import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Log2File {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f6496a;
    public final SimpleDateFormat b;
    public final Date c;

    public static class WriteHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final String f6497a;
        public final SimpleDateFormat b;
        public final Date c;
        public final String d;

        public final File b(String str, String str2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.c.setTime(System.currentTimeMillis());
            File file2 = new File(file, String.format("%s_%s_%s.csv", new Object[]{str2, this.d, this.b.format(this.c)}));
            if (!file2.exists()) {
                File[] listFiles = file.listFiles(new a(this, str2));
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    Collections.addAll(arrayList, listFiles);
                }
                Collections.sort(arrayList);
                while (arrayList.size() >= 7) {
                    FileSaveUtil.a(((File) arrayList.remove(0)).getPath());
                }
            }
            return file2;
        }

        public final /* synthetic */ boolean c(String str, File file) {
            return file.isFile() && file.getName().startsWith(str) && file.getName().contains(this.d);
        }

        public final void d(FileWriter fileWriter, String str) {
            fileWriter.append(str).append(10);
        }

        public void handleMessage(Message message) {
            String str = (String) message.obj;
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(b(this.f6497a, "logs"), true);
                try {
                    d(fileWriter2, str);
                    fileWriter2.flush();
                    fileWriter2.close();
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(String str) {
        Handler handler = this.f6496a;
        handler.sendMessage(handler.obtainMessage(0, this.b.format(this.c) + str));
    }
}
