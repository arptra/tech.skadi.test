package org.apache.tika.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StreamGobbler implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f3345a;
    public final int b;
    public List c = new ArrayList();
    public long d = 0;
    public boolean e = false;

    public StreamGobbler(InputStream inputStream, int i) {
        this.f3345a = inputStream;
        this.b = i;
    }

    public boolean a() {
        return this.e;
    }

    public List b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public void run() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.f3345a, StandardCharsets.UTF_8));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (this.b >= 0) {
                    long length = this.d + ((long) readLine.length());
                    int i = this.b;
                    if (length > ((long) i)) {
                        int i2 = i - ((int) this.d);
                        if (i2 > 0) {
                            this.e = true;
                            this.c.add(readLine.substring(0, Math.min(readLine.length(), i2)));
                        }
                    } else {
                        this.c.add(readLine);
                    }
                }
                this.d += (long) readLine.length();
            }
            bufferedReader.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
