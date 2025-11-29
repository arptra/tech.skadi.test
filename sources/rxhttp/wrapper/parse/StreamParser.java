package rxhttp.wrapper.parse;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Response;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.callback.OutputStreamFactory;
import rxhttp.wrapper.callback.ProgressCallback;
import rxhttp.wrapper.callback.ProgressCallbackHelper;
import rxhttp.wrapper.entity.DownloadOffSize;
import rxhttp.wrapper.utils.LogUtil;
import rxhttp.wrapper.utils.Utils;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\u00020\u000b*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001a¨\u0006\u001b"}, d2 = {"Lrxhttp/wrapper/parse/StreamParser;", "T", "Lrxhttp/wrapper/parse/Parser;", "Lrxhttp/wrapper/callback/OutputStreamFactory;", "osFactory", "<init>", "(Lrxhttp/wrapper/callback/OutputStreamFactory;)V", "", "minPeriod", "Lrxhttp/wrapper/callback/ProgressCallback;", "progressCallback", "", "b", "(ILrxhttp/wrapper/callback/ProgressCallback;)V", "Lokhttp3/Response;", "response", "a", "(Lokhttp3/Response;)Ljava/lang/Object;", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "os", "Lrxhttp/wrapper/callback/ProgressCallbackHelper;", "callback", "c", "(Ljava/io/InputStream;Ljava/io/OutputStream;Lokhttp3/Response;Lrxhttp/wrapper/callback/ProgressCallbackHelper;)V", "Lrxhttp/wrapper/callback/OutputStreamFactory;", "Lrxhttp/wrapper/callback/ProgressCallbackHelper;", "rxhttp"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStreamParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamParser.kt\nrxhttp/wrapper/parse/StreamParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public class StreamParser<T> implements Parser<T> {

    /* renamed from: a  reason: collision with root package name */
    public final OutputStreamFactory f3564a;
    public ProgressCallbackHelper b;

    public StreamParser(OutputStreamFactory outputStreamFactory) {
        Intrinsics.checkNotNullParameter(outputStreamFactory, "osFactory");
        this.f3564a = outputStreamFactory;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0068, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(okhttp3.Response r6) {
        /*
            r5 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            okhttp3.ResponseBody r0 = rxhttp.wrapper.OkHttpCompat.o(r6)
            java.lang.String r1 = "throwIfFail(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            rxhttp.wrapper.callback.OutputStreamFactory r1 = r5.f3564a
            rxhttp.wrapper.entity.ExpandOutputStream r1 = r1.b(r6)
            java.lang.Object r2 = r1.a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "Download start: "
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            r3.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0064 }
            rxhttp.wrapper.utils.LogUtil.j(r3)     // Catch:{ all -> 0x0064 }
            rxhttp.wrapper.utils.LogTime r3 = new rxhttp.wrapper.utils.LogTime     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            java.io.InputStream r0 = r0.byteStream()     // Catch:{ all -> 0x0064 }
            rxhttp.wrapper.callback.ProgressCallbackHelper r4 = r5.b     // Catch:{ all -> 0x0066 }
            r5.c(r0, r1, r6, r4)     // Catch:{ all -> 0x0066 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0066 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r5)     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r6.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "Download end, cost "
            r6.append(r0)     // Catch:{ all -> 0x0064 }
            long r3 = r3.a()     // Catch:{ all -> 0x0064 }
            r6.append(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "ms: "
            r6.append(r0)     // Catch:{ all -> 0x0064 }
            r6.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0064 }
            rxhttp.wrapper.utils.LogUtil.j(r6)     // Catch:{ all -> 0x0064 }
            kotlin.io.CloseableKt.closeFinally(r1, r5)
            return r2
        L_0x0064:
            r5 = move-exception
            goto L_0x006d
        L_0x0066:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r5)     // Catch:{ all -> 0x0064 }
            throw r6     // Catch:{ all -> 0x0064 }
        L_0x006d:
            throw r5     // Catch:{ all -> 0x006e }
        L_0x006e:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.parse.StreamParser.a(okhttp3.Response):java.lang.Object");
    }

    public final void b(int i, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        this.b = new ProgressCallbackHelper(i, progressCallback);
    }

    public final void c(InputStream inputStream, OutputStream outputStream, Response response, ProgressCallbackHelper progressCallbackHelper) {
        DownloadOffSize downloadOffSize;
        if (progressCallbackHelper == null) {
            Utils.e(inputStream, outputStream, (Function1) null, 2, (Object) null);
            return;
        }
        long j = 0;
        if (Utils.c(response) && (downloadOffSize = (DownloadOffSize) OkHttpCompat.n(response).tag(DownloadOffSize.class)) != null) {
            j = downloadOffSize.f3550a;
        }
        Ref.LongRef longRef = new Ref.LongRef();
        long d = OkHttpCompat.d(response);
        longRef.element = d;
        if (d != -1) {
            longRef.element = d + j;
        }
        if (longRef.element == -1) {
            LogUtil.j("Unable to calculate callback progress without `Content-Length` response header");
        }
        progressCallbackHelper.b(j);
        Utils.d(inputStream, outputStream, new StreamParser$writeTo$1(progressCallbackHelper, longRef));
        long j2 = longRef.element;
        if (j2 == -1) {
            progressCallbackHelper.a(-1, j2);
        }
    }
}
