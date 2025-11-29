package com.xingin.xhssharesdk.f;

import com.xingin.xhssharesdk.e.a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class d<T> implements c<T> {
    public static final MediaType d = MediaType.get("application/octet-stream; charset=utf-8");

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f8177a;
    public final String b = "https://spider-tracker.xiaohongshu.com/";
    public final a c;

    public d(a aVar) {
        this.c = aVar;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(5000, timeUnit).callTimeout(10000, timeUnit).writeTimeout(5000, timeUnit);
        writeTimeout.addInterceptor(new b());
        this.f8177a = writeTimeout.build();
    }

    public final f a(ArrayList arrayList) {
        int i;
        try {
            this.c.getClass();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write((byte[]) it.next());
            }
            try {
                RequestBody create = RequestBody.create(d, byteArrayOutputStream.toByteArray());
                try {
                    Request.Builder builder = new Request.Builder();
                    Response response = null;
                    try {
                        Response execute = this.f8177a.newCall(builder.url(this.b + "api/spider").post(create).build()).execute();
                        execute.close();
                        int code = execute.code();
                        String message = execute.message();
                        f fVar = new f();
                        if (code < 200 || code >= 300) {
                            fVar.f8179a = false;
                        } else {
                            fVar.f8179a = true;
                        }
                        fVar.b = code;
                        fVar.c = message;
                        try {
                            execute.close();
                        } catch (Exception unused) {
                        }
                        return fVar;
                    } catch (Throwable th) {
                        if (response != null) {
                            try {
                                response.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    i = -4;
                    return f.a(i, th);
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                i = -3;
                return f.a(i, th);
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            i = -2;
            return f.a(i, th);
        }
    }
}
