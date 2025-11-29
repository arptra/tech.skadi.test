package rxhttp.wrapper.utils;

import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Charsets;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import rxhttp.Platform;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.entity.FileRequestBody;
import rxhttp.wrapper.entity.UriRequestBody;
import rxhttp.wrapper.exception.ProxyException;
import rxhttp.wrapper.progress.ProgressRequestBody;

public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3574a = false;
    public static boolean b = false;
    public static int c = -1;

    public static boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity") && !str.equalsIgnoreCase("gzip");
    }

    public static String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = (Cookie) list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    public static String c(String str, int i) {
        if (i < 0) {
            return str;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(str);
            if (str.startsWith("[")) {
                return jSONTokener.more() ? str : new JSONStringer(i).q(new JSONArray(jSONTokener)).toString();
            } else if (!str.startsWith("{")) {
                return str;
            } else {
                return jSONTokener.more() ? str : new JSONStringer(i).r(new JSONObject(jSONTokener)).toString();
            }
        } catch (Throwable unused) {
            return str;
        }
    }

    public static Charset d(RequestBody requestBody) {
        MediaType contentType = requestBody.contentType();
        return contentType != null ? contentType.charset(Charsets.UTF_8) : Charsets.UTF_8;
    }

    public static Charset e(ResponseBody responseBody) {
        MediaType contentType = responseBody.contentType();
        return contentType != null ? contentType.charset(Charsets.UTF_8) : Charsets.UTF_8;
    }

    public static String f(HttpUrl httpUrl) {
        String str;
        if (httpUrl.host().contains(AccountConstantKt.CODE_SEPARTOR)) {
            str = "[" + httpUrl.host() + "]";
        } else {
            str = httpUrl.host();
        }
        return str + AccountConstantKt.CODE_SEPARTOR + httpUrl.port();
    }

    public static boolean g() {
        return f3574a;
    }

    public static boolean h(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean i() {
        return b;
    }

    public static void j(String str) {
        if (g()) {
            Platform.b().e("RxHttp", str);
        }
    }

    public static void k(Throwable th) {
        if (f3574a) {
            Platform.b().f("RxHttp", th);
        }
    }

    public static void l(Request request, CookieJar cookieJar) {
        if (f3574a) {
            try {
                Request.Builder newBuilder = request.newBuilder();
                StringBuilder sb = new StringBuilder("<------ ");
                sb.append("rxhttp/3.2.7");
                sb.append(" ");
                sb.append(OkHttpCompat.e());
                sb.append(" request start ------>\n");
                sb.append(request.method());
                sb.append(" ");
                sb.append(request.url());
                RequestBody body = request.body();
                if (body != null) {
                    MediaType contentType = body.contentType();
                    if (contentType != null) {
                        newBuilder.header("Content-Type", contentType.toString());
                    }
                    long contentLength = body.contentLength();
                    if (contentLength != -1) {
                        newBuilder.header("Content-Length", String.valueOf(contentLength));
                        newBuilder.removeHeader("Transfer-Encoding");
                    } else {
                        newBuilder.header("Transfer-Encoding", HttpHeaders.Values.CHUNKED);
                        newBuilder.removeHeader("Content-Length");
                    }
                }
                if (request.header("Host") == null) {
                    newBuilder.header("Host", f(request.url()));
                }
                if (request.header("Connection") == null) {
                    newBuilder.header("Connection", "Keep-Alive");
                }
                if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
                    newBuilder.header("Accept-Encoding", "gzip");
                }
                List<Cookie> loadForRequest = cookieJar.loadForRequest(request.url());
                if (!loadForRequest.isEmpty()) {
                    newBuilder.header("Cookie", b(loadForRequest));
                }
                if (request.header("User-Agent") == null) {
                    newBuilder.header("User-Agent", OkHttpCompat.e());
                }
                sb.append(StringUtils.LF);
                sb.append(q(newBuilder.build().headers()));
                if (body != null) {
                    sb.append(StringUtils.LF);
                    if (a(request.headers())) {
                        sb.append("(binary ");
                        sb.append(body.contentLength());
                        sb.append("-byte encoded body omitted)");
                    } else {
                        sb.append(c(r(body), c));
                    }
                }
                Platform.b().d("RxHttp", sb.toString());
            } catch (Throwable th) {
                Platform.b().f("RxHttp", new ProxyException("Request start log printing failed", th));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d9 A[Catch:{ all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ec A[Catch:{ all -> 0x004a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m(okhttp3.Response r13, rxhttp.wrapper.utils.LogTime r14) {
        /*
            java.lang.String r0 = "RxHttp"
            java.lang.String r1 = "\n"
            java.lang.String r2 = "ms"
            java.lang.String r3 = " "
            boolean r4 = f3574a
            if (r4 != 0) goto L_0x000d
            return
        L_0x000d:
            okhttp3.ResponseBody r4 = r13.body()     // Catch:{ all -> 0x004a }
            okhttp3.Request r5 = r13.request()     // Catch:{ all -> 0x004a }
            long r6 = r14.a()     // Catch:{ all -> 0x004a }
            boolean r8 = p(r13)     // Catch:{ all -> 0x004a }
            r9 = 0
            if (r8 == 0) goto L_0x007d
            if (r4 != 0) goto L_0x0024
            goto L_0x007d
        L_0x0024:
            okhttp3.Headers r8 = r13.headers()     // Catch:{ all -> 0x004a }
            boolean r8 = a(r8)     // Catch:{ all -> 0x004a }
            java.lang.String r11 = "(binary "
            if (r8 == 0) goto L_0x004d
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r14.<init>()     // Catch:{ all -> 0x004a }
            r14.append(r11)     // Catch:{ all -> 0x004a }
            long r11 = r4.contentLength()     // Catch:{ all -> 0x004a }
            r14.append(r11)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "-byte encoded body omitted)"
            r14.append(r4)     // Catch:{ all -> 0x004a }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x004a }
        L_0x0048:
            r11 = r9
            goto L_0x0080
        L_0x004a:
            r13 = move-exception
            goto L_0x0111
        L_0x004d:
            boolean r8 = o(r4)     // Catch:{ all -> 0x004a }
            if (r8 != 0) goto L_0x006c
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r14.<init>()     // Catch:{ all -> 0x004a }
            r14.append(r11)     // Catch:{ all -> 0x004a }
            long r11 = r4.contentLength()     // Catch:{ all -> 0x004a }
            r14.append(r11)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "-byte non-text body omitted)"
            r14.append(r4)     // Catch:{ all -> 0x004a }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x004a }
            goto L_0x0048
        L_0x006c:
            java.lang.String r4 = s(r13)     // Catch:{ all -> 0x004a }
            int r8 = c     // Catch:{ all -> 0x004a }
            java.lang.String r4 = c(r4, r8)     // Catch:{ all -> 0x004a }
            long r11 = r14.a()     // Catch:{ all -> 0x004a }
            long r11 = r11 - r6
            r14 = r4
            goto L_0x0080
        L_0x007d:
            java.lang.String r14 = "No Response Body"
            goto L_0x0048
        L_0x0080:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            java.lang.String r8 = "<------ "
            r4.<init>(r8)     // Catch:{ all -> 0x004a }
            java.lang.String r8 = "rxhttp/3.2.7"
            r4.append(r8)     // Catch:{ all -> 0x004a }
            r4.append(r3)     // Catch:{ all -> 0x004a }
            java.lang.String r8 = rxhttp.wrapper.OkHttpCompat.e()     // Catch:{ all -> 0x004a }
            r4.append(r8)     // Catch:{ all -> 0x004a }
            java.lang.String r8 = " request end ------>\n"
            r4.append(r8)     // Catch:{ all -> 0x004a }
            java.lang.String r8 = r5.method()     // Catch:{ all -> 0x004a }
            r4.append(r8)     // Catch:{ all -> 0x004a }
            r4.append(r3)     // Catch:{ all -> 0x004a }
            okhttp3.HttpUrl r5 = r5.url()     // Catch:{ all -> 0x004a }
            r4.append(r5)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = "\n\n"
            r4.append(r5)     // Catch:{ all -> 0x004a }
            okhttp3.Protocol r5 = r13.protocol()     // Catch:{ all -> 0x004a }
            r4.append(r5)     // Catch:{ all -> 0x004a }
            r4.append(r3)     // Catch:{ all -> 0x004a }
            int r5 = r13.code()     // Catch:{ all -> 0x004a }
            r4.append(r5)     // Catch:{ all -> 0x004a }
            r4.append(r3)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = r13.message()     // Catch:{ all -> 0x004a }
            r4.append(r5)     // Catch:{ all -> 0x004a }
            r4.append(r3)     // Catch:{ all -> 0x004a }
            r4.append(r6)     // Catch:{ all -> 0x004a }
            r4.append(r2)     // Catch:{ all -> 0x004a }
            int r5 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ec
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r5.<init>()     // Catch:{ all -> 0x004a }
            r5.append(r3)     // Catch:{ all -> 0x004a }
            r5.append(r11)     // Catch:{ all -> 0x004a }
            r5.append(r2)     // Catch:{ all -> 0x004a }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x004a }
            goto L_0x00ee
        L_0x00ec:
            java.lang.String r2 = ""
        L_0x00ee:
            r4.append(r2)     // Catch:{ all -> 0x004a }
            r4.append(r1)     // Catch:{ all -> 0x004a }
            okhttp3.Headers r13 = r13.headers()     // Catch:{ all -> 0x004a }
            java.lang.String r13 = q(r13)     // Catch:{ all -> 0x004a }
            r4.append(r13)     // Catch:{ all -> 0x004a }
            r4.append(r1)     // Catch:{ all -> 0x004a }
            r4.append(r14)     // Catch:{ all -> 0x004a }
            rxhttp.Platform r13 = rxhttp.Platform.b()     // Catch:{ all -> 0x004a }
            java.lang.String r14 = r4.toString()     // Catch:{ all -> 0x004a }
            r13.g(r0, r14)     // Catch:{ all -> 0x004a }
            goto L_0x011f
        L_0x0111:
            rxhttp.Platform r14 = rxhttp.Platform.b()
            rxhttp.wrapper.exception.ProxyException r1 = new rxhttp.wrapper.exception.ProxyException
            java.lang.String r2 = "Request end log printing failed"
            r1.<init>((java.lang.String) r2, (java.lang.Throwable) r13)
            r14.f(r0, r1)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.utils.LogUtil.m(okhttp3.Response, rxhttp.wrapper.utils.LogTime):void");
    }

    public static String n(MultipartBody multipartBody) {
        long j;
        byte[] bArr = {HttpConstants.COLON, 32};
        byte[] bArr2 = {13, 10};
        byte[] bArr3 = {45, 45};
        Buffer buffer = new Buffer();
        for (MultipartBody.Part next : multipartBody.parts()) {
            Headers headers = next.headers();
            RequestBody body = next.body();
            buffer.write(bArr3).writeUtf8(multipartBody.boundary()).write(bArr2);
            if (headers != null) {
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    buffer.writeUtf8(headers.name(i)).write(bArr).writeUtf8(headers.value(i)).write(bArr2);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                buffer.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(bArr2);
            }
            try {
                j = body.contentLength();
            } catch (IOException e) {
                e.printStackTrace();
                j = -1;
            }
            buffer.writeUtf8("Content-Length: ").writeDecimalLong(j).write(bArr2);
            if (body instanceof MultipartBody) {
                buffer.write(bArr2).writeUtf8(n((MultipartBody) body));
            } else if (body instanceof FileRequestBody) {
                buffer.writeUtf8("(binary " + j + "-byte file body omitted)");
            } else if (body instanceof UriRequestBody) {
                buffer.writeUtf8("(binary " + j + "-byte uri body omitted)");
            } else if (t() && body.isDuplex()) {
                buffer.writeUtf8("(binary " + j + "-byte duplex body omitted)");
            } else if (t() && body.isOneShot()) {
                buffer.writeUtf8("(binary " + j + "-byte one-shot body omitted)");
            } else if (j > 1024) {
                buffer.writeUtf8("(binary " + j + "-byte body omitted)");
            } else {
                try {
                    body.writeTo(buffer);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (j > 0) {
                buffer.write(bArr2);
            }
            buffer.write(bArr2);
        }
        buffer.write(bArr3).writeUtf8(multipartBody.boundary()).write(bArr3);
        return buffer.readString(d(multipartBody));
    }

    public static boolean o(ResponseBody responseBody) {
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            String type = contentType.type();
            String subtype = contentType.subtype();
            if (type.equalsIgnoreCase("text") || subtype.equalsIgnoreCase("json") || subtype.equalsIgnoreCase("xml")) {
                return true;
            }
            if (type.equalsIgnoreCase("image") || type.equalsIgnoreCase("audio") || type.equalsIgnoreCase("video") || subtype.equalsIgnoreCase("zip")) {
                return false;
            }
            if (contentType.charset() != null) {
                return true;
            }
        }
        return responseBody.contentLength() < 1048576;
    }

    public static boolean p(Response response) {
        return u() ? okhttp3.internal.http.HttpHeaders.promisesBody(response) : okhttp3.internal.http.HttpHeaders.hasBody(response);
    }

    public static String q(Headers headers) {
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            sb.append(headers.name(i));
            sb.append(": ");
            sb.append(headers.value(i));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    public static String r(RequestBody requestBody) {
        long j;
        if (requestBody instanceof ProgressRequestBody) {
            requestBody = ((ProgressRequestBody) requestBody).b();
        }
        if (requestBody instanceof MultipartBody) {
            return n((MultipartBody) requestBody);
        }
        try {
            j = requestBody.contentLength();
        } catch (IOException e) {
            e.printStackTrace();
            j = -1;
        }
        if (requestBody instanceof FileRequestBody) {
            return "(binary " + j + "-byte file body omitted)";
        } else if (requestBody instanceof UriRequestBody) {
            return "(binary " + j + "-byte uri body omitted)";
        } else if (t() && requestBody.isDuplex()) {
            return "(binary " + j + "-byte duplex body omitted)";
        } else if (!t() || !requestBody.isOneShot()) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            if (h(buffer)) {
                return buffer.readString(d(requestBody));
            }
            return "(binary " + requestBody.contentLength() + "-byte body omitted)";
        } else {
            return "(binary " + j + "-byte one-shot body omitted)";
        }
    }

    public static String s(Response response) {
        ResponseBody body = response.body();
        boolean h = OkHttpCompat.h(response);
        BufferedSource source = body.source();
        source.request(LongCompanionObject.MAX_VALUE);
        Buffer buffer = source.buffer();
        if (h(buffer)) {
            String readString = buffer.clone().readString(e(body));
            return h ? RxHttpPlugins.i(readString) : readString;
        }
        return "(binary " + buffer.size() + "-byte body omitted)";
    }

    public static boolean t() {
        return OkHttpCompat.j("3.14.0") >= 0;
    }

    public static boolean u() {
        return OkHttpCompat.j("4.0.0") >= 0;
    }
}
