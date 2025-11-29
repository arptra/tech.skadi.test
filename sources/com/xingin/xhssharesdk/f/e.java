package com.xingin.xhssharesdk.f;

import com.xingin.xhssharesdk.e.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

public final class e<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final a f8178a;
    public final boolean b = true;

    public e(a aVar) {
        this.f8178a = aVar;
    }

    public final f a(ArrayList arrayList) {
        int i;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://spider-tracker.xiaohongshu.com/api/spider").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream; charset=utf-8");
            if (this.b) {
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
            httpURLConnection.connect();
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                if (this.b) {
                    outputStream = new GZIPOutputStream(outputStream);
                }
                this.f8178a.getClass();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    byteArrayOutputStream.write((byte[]) it.next());
                }
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th = th;
                i = -2;
                return f.a(i, th);
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                httpURLConnection.disconnect();
                f fVar = new f();
                if (responseCode < 200 || responseCode >= 300) {
                    fVar.f8179a = false;
                } else {
                    fVar.f8179a = true;
                }
                fVar.b = responseCode;
                fVar.c = responseMessage;
                return fVar;
            } catch (Throwable th2) {
                th = th2;
                i = -1;
                return f.a(i, th);
            }
        } catch (Throwable th3) {
            th = th3;
            i = -4;
            return f.a(i, th);
        }
    }
}
