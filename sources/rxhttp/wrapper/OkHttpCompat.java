package rxhttp.wrapper;

import com.meizu.common.util.LunarCalendar;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.commons.lang3.BooleanUtils;
import rxhttp.wrapper.exception.HttpStatusCodeException;
import rxhttp.wrapper.param.Param;

public class OkHttpCompat {

    /* renamed from: a  reason: collision with root package name */
    public static String f3528a;

    public static ResponseBody a(ResponseBody responseBody) {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), (BufferedSource) buffer);
    }

    public static void b(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    Util.closeQuietly(closeable);
                }
            }
        }
    }

    public static CookieJar c(OkHttpClient okHttpClient) {
        return okHttpClient.cookieJar();
    }

    public static long d(Response response) {
        ResponseBody body = response.body();
        long j = -1;
        if (body != null) {
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                return contentLength;
            }
            j = contentLength;
        }
        String header = response.header("Content-Range");
        if (header == null) {
            return j;
        }
        try {
            String[] split = header.substring(header.indexOf(" ") + 1, header.indexOf("/")).split(LunarCalendar.DATE_SEPARATOR);
            return (Long.parseLong(split[1]) - Long.parseLong(split[0])) + 1;
        } catch (Exception unused) {
            return j;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = (java.lang.String) r2.getDeclaredMethod("userAgent", (java.lang.Class[]) null).invoke((java.lang.Object) null, (java.lang.Object[]) null);
        f3528a = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e() {
        /*
            java.lang.String r0 = "userAgent"
            java.lang.String r1 = f3528a
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            r1 = 0
            java.lang.Class<okhttp3.internal.Util> r2 = okhttp3.internal.Util.class
            byte[] r3 = okhttp3.internal.Util.EMPTY_BYTE_ARRAY     // Catch:{ all -> 0x0019 }
            java.lang.reflect.Field r2 = r2.getDeclaredField(r0)     // Catch:{ all -> 0x0019 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0019 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0019 }
            f3528a = r2     // Catch:{ all -> 0x0019 }
            return r2
        L_0x0019:
            java.lang.String r2 = "okhttp3.internal.Version"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x002c }
            java.lang.reflect.Field r3 = r2.getDeclaredField(r0)     // Catch:{ Exception -> 0x002e }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x002e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x002e }
            f3528a = r3     // Catch:{ Exception -> 0x002e }
            return r3
        L_0x002c:
            r0 = move-exception
            goto L_0x003b
        L_0x002e:
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r0, r1)     // Catch:{ all -> 0x002c }
            java.lang.Object r0 = r0.invoke(r1, r1)     // Catch:{ all -> 0x002c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x002c }
            f3528a = r0     // Catch:{ all -> 0x002c }
            return r0
        L_0x003b:
            r0.printStackTrace()
            java.lang.String r0 = "okhttp/x.x.x"
            f3528a = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.OkHttpCompat.e():java.lang.String");
    }

    public static String f(Response response, String str) {
        return response.header(str);
    }

    public static boolean g(Response response) {
        return response.code() == 206;
    }

    public static boolean h(Response response) {
        return !BooleanUtils.FALSE.equals(response.request().header(Param.f3561a));
    }

    public static DiskLruCache i(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j("4.3.0") >= 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, TaskRunner.INSTANCE);
        }
        Class<File> cls = File.class;
        Class<FileSystem> cls2 = FileSystem.class;
        if (j("4.0.0") >= 0) {
            DiskLruCache.Companion companion = DiskLruCache.Companion;
            Class<?> cls3 = companion.getClass();
            try {
                Class cls4 = Integer.TYPE;
                return (DiskLruCache) cls3.getDeclaredMethod("create", new Class[]{cls2, cls, cls4, cls4, Long.TYPE}).invoke(companion, new Object[]{fileSystem, file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            } catch (Throwable th) {
                th.printStackTrace();
                throw new RuntimeException("Please upgrade OkHttp to V3.12.0 or higher");
            }
        } else {
            Class<DiskLruCache> cls5 = DiskLruCache.class;
            try {
                Class cls6 = Integer.TYPE;
                return (DiskLruCache) cls5.getDeclaredMethod("create", new Class[]{cls2, cls, cls6, cls6, Long.TYPE}).invoke((Object) null, new Object[]{fileSystem, file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            } catch (Throwable th2) {
                th2.printStackTrace();
                throw new RuntimeException("Please upgrade OkHttp to V3.12.0 or higher");
            }
        }
    }

    public static int j(String str) {
        String[] split = e().split("/");
        return p(split[split.length - 1], str);
    }

    public static StatusLine k(String str) {
        if (j("4.0.0") >= 0) {
            return StatusLine.Companion.parse(str);
        }
        Class<StatusLine> cls = StatusLine.class;
        try {
            return (StatusLine) cls.getDeclaredMethod("parse", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static List l(Response response) {
        return response.request().url().pathSegments();
    }

    public static long m(Response response) {
        return response.receivedResponseAtMillis();
    }

    public static Request n(Response response) {
        return response.request();
    }

    public static ResponseBody o(Response response) {
        ResponseBody body = response.body();
        if (response.isSuccessful()) {
            return body;
        }
        try {
            throw new HttpStatusCodeException(response.newBuilder().body(a(body)).build());
        } catch (Throwable th) {
            body.close();
            throw th;
        }
    }

    public static int p(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            String str3 = split[i2];
            String str4 = split2[i2];
            int length = str3.length() - str4.length();
            i = length == 0 ? str3.compareTo(str4) : length;
            if (i != 0) {
                break;
            }
        }
        return i != 0 ? i : split.length - split2.length;
    }
}
