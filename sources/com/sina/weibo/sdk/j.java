package com.sina.weibo.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.honey.account.constant.AccountConstantKt;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public abstract class j<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f9984a = 1;
    public final b b;
    public final c c;
    public a d = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            s<String> sVar;
            d dVar = (d) message.obj;
            int i = message.what;
            if (i == 1) {
                j jVar = dVar.f9987a;
                Data data = dVar.b[0];
                jVar.getClass();
                q qVar = (q) jVar;
                String str = (String) data;
                if (qVar.f == null && (sVar = qVar.e) != null) {
                    AccessTokenHelper.writeAccessToken(((AccessTokenHelper.a) sVar).f9969a, Oauth2AccessToken.parseAccessToken(str));
                }
                jVar.f9984a = 3;
                message.obj = null;
            } else if (i == 2) {
                dVar.f9987a.getClass();
            } else if (i == 3) {
                dVar.f9987a.getClass();
            }
        }
    }

    public class b extends f<Params, Result> {
        public b() {
            super(0);
        }

        public final Result call() {
            j.this.getClass();
            Process.setThreadPriority(5);
            j jVar = j.this;
            jVar.getClass();
            q qVar = (q) jVar;
            try {
                t.a aVar = new t.a();
                aVar.f9995a = "https://api.weibo.com/oauth2/access_token";
                u a2 = p.a(new t(aVar.a("client_id", qVar.g).a("appKey", qVar.g).a(AccountConstantKt.REQUEST_PARAM_GRANT_TYPE, Oauth2AccessToken.KEY_REFRESH_TOKEN).a(Oauth2AccessToken.KEY_REFRESH_TOKEN, qVar.h.getRefreshToken())));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = a2.f9996a.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        Result byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    }
                }
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                th.printStackTrace();
                qVar.f = th;
                return null;
            }
        }
    }

    public class c extends j<Params, Progress, Result>.e {
        public c(b bVar) {
            super(bVar);
        }

        public final int compareTo(Object obj) {
            return 0;
        }

        public final void done() {
            try {
                Object obj = get();
                j jVar = j.this;
                jVar.d.obtainMessage(1, new d(jVar, obj)).sendToTarget();
            } catch (InterruptedException unused) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            } catch (ExecutionException unused2) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            } catch (CancellationException unused3) {
                j.this.d.obtainMessage(3, new d(j.this, (Data[]) null)).sendToTarget();
            } catch (Throwable unused4) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            }
        }
    }

    public static class d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final j f9987a;
        public final Data[] b;

        public d(j jVar, Data... dataArr) {
            this.f9987a = jVar;
            this.b = dataArr;
        }
    }

    public abstract class e extends FutureTask<Result> implements Comparable<Object> {
        public e(b bVar) {
            super(bVar);
        }
    }

    public static abstract class f<Params, Result> implements Callable<Result> {
        public f() {
        }

        public /* synthetic */ f(int i) {
            this();
        }
    }

    public j() {
        b bVar = new b();
        this.b = bVar;
        this.c = new c(bVar);
    }
}
