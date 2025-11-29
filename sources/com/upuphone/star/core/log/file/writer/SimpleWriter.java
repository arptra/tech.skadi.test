package com.upuphone.star.core.log.file.writer;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SimpleWriter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public String f6458a;
    public File b;
    public BufferedWriter c;

    public void a(String str) {
        try {
            this.c.write(str);
            this.c.newLine();
            this.c.flush();
        } catch (Exception e) {
            Log.w("ulog", "append log failed: " + e.getMessage());
        }
    }

    public boolean b() {
        BufferedWriter bufferedWriter = this.c;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.c = null;
        this.f6458a = null;
        this.b = null;
        return true;
    }

    public File c() {
        return this.b;
    }

    public String d() {
        return this.f6458a;
    }

    public boolean e() {
        return this.c != null && this.b.exists();
    }

    public boolean f(File file) {
        boolean z;
        this.f6458a = file.getName();
        this.b = file;
        if (!file.exists()) {
            try {
                File parentFile = this.b.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.b.createNewFile();
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                b();
                return false;
            }
        } else {
            z = false;
        }
        try {
            this.c = new BufferedWriter(new FileWriter(this.b, true));
            if (z) {
                g(this.b);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            b();
            return false;
        }
    }

    public void g(File file) {
    }
}
