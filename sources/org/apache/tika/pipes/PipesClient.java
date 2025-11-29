package org.apache.tika.pipes;

import com.honey.account.mc.b;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ProcessBuilder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.tika.pipes.PipesResult;
import org.apache.tika.pipes.PipesServer;
import org.apache.tika.pipes.emitter.EmitData;
import org.apache.tika.utils.ProcessUtils;
import org.apache.tika.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipesClient implements Closeable {
    public static final Logger j = LoggerFactory.k(PipesClient.class);
    public static AtomicInteger k = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f3289a = new Object[0];
    public final PipesConfigBase b;
    public final int c;
    public volatile boolean d = false;
    public ExecutorService e = Executors.newFixedThreadPool(1);
    public Process f;
    public DataOutputStream g;
    public DataInputStream h;
    public int i = 0;

    /* renamed from: org.apache.tika.pipes.PipesClient$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3290a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.apache.tika.pipes.PipesServer$STATUS[] r0 = org.apache.tika.pipes.PipesServer.STATUS.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3290a = r0
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.OOM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.EMIT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.EMITTER_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.FETCHER_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.FETCHER_INITIALIZATION_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.FETCH_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.PARSE_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.PARSE_EXCEPTION_NO_EMIT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.EMIT_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.EMIT_SUCCESS_PARSE_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.EMPTY_OUTPUT     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x009c }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.READY     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.CALL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.PING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f3290a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.apache.tika.pipes.PipesServer$STATUS r1 = org.apache.tika.pipes.PipesServer.STATUS.FAILED_TO_START     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.pipes.PipesClient.AnonymousClass1.<clinit>():void");
        }
    }

    public PipesClient(PipesConfigBase pipesConfigBase) {
        this.b = pipesConfigBase;
        this.c = k.getAndIncrement();
    }

    public static String j(String str, UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream) {
        String abstractByteArrayOutputStream = unsynchronizedByteArrayOutputStream.toString(StandardCharsets.UTF_8);
        if (StringUtils.a(abstractByteArrayOutputStream)) {
            return str;
        }
        return str + "So far, I've read: >" + abstractByteArrayOutputStream + "<";
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0050 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0050=Splitter:B:13:0x0050, B:25:0x00c9=Splitter:B:25:0x00c9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.apache.tika.pipes.PipesResult c(org.apache.tika.pipes.FetchEmitTuple r12) {
        /*
            r11 = this;
            java.lang.String r0 = "pipesClientId="
            long r1 = java.lang.System.currentTimeMillis()
            java.util.concurrent.FutureTask r3 = new java.util.concurrent.FutureTask
            com.honey.account.mc.a r4 = new com.honey.account.mc.a
            r4.<init>(r11, r12, r1)
            r3.<init>(r4)
            r4 = 1
            boolean r5 = r11.d     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            if (r5 != 0) goto L_0x0034
            java.util.concurrent.ExecutorService r5 = r11.e     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            r5.execute(r3)     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            org.apache.tika.pipes.PipesConfigBase r5 = r11.b     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            long r5 = r5.i0()     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            java.lang.Object r5 = r3.get(r5, r7)     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            org.apache.tika.pipes.PipesResult r5 = (org.apache.tika.pipes.PipesResult) r5     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            r3.cancel(r4)
            return r5
        L_0x002c:
            r11 = move-exception
            goto L_0x011d
        L_0x002f:
            r5 = move-exception
            goto L_0x0077
        L_0x0031:
            r12 = move-exception
            goto L_0x0119
        L_0x0034:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            r6.<init>()     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            r6.append(r0)     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            int r7 = r11.c     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            java.lang.String r7 = ": PipesClient closed"
            r6.append(r7)     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            java.lang.String r6 = r6.toString()     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            r5.<init>(r6)     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
            throw r5     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x002f, TimeoutException -> 0x0050 }
        L_0x0050:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002c }
            long r5 = r5 - r1
            r11.g()     // Catch:{ all -> 0x002c }
            org.slf4j.Logger r0 = j     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "pipesClientId={} client timeout: {} in {} ms"
            int r11 = r11.c     // Catch:{ all -> 0x002c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x002c }
            java.lang.String r12 = r12.getId()     // Catch:{ all -> 0x002c }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x002c }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r12, r2}     // Catch:{ all -> 0x002c }
            r0.warn((java.lang.String) r1, (java.lang.Object[]) r11)     // Catch:{ all -> 0x002c }
            org.apache.tika.pipes.PipesResult r11 = org.apache.tika.pipes.PipesResult.e     // Catch:{ all -> 0x002c }
            r3.cancel(r4)
            return r11
        L_0x0077:
            org.slf4j.Logger r6 = j     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r7.<init>()     // Catch:{ all -> 0x002c }
            r7.append(r0)     // Catch:{ all -> 0x002c }
            int r0 = r11.c     // Catch:{ all -> 0x002c }
            r7.append(r0)     // Catch:{ all -> 0x002c }
            java.lang.String r0 = ": execution exception"
            r7.append(r0)     // Catch:{ all -> 0x002c }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x002c }
            r6.error((java.lang.String) r0, (java.lang.Throwable) r5)     // Catch:{ all -> 0x002c }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002c }
            long r7 = r7 - r1
            r11.r()     // Catch:{ all -> 0x002c }
            java.lang.Process r0 = r11.f     // Catch:{ all -> 0x002c }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x00c9
            java.lang.Process r0 = r11.f     // Catch:{ all -> 0x002c }
            int r0 = r0.exitValue()     // Catch:{ all -> 0x002c }
            r1 = 17
            if (r1 != r0) goto L_0x00c9
            java.lang.String r0 = "pipesClientId={} server timeout: {} in {} ms"
            int r11 = r11.c     // Catch:{ all -> 0x002c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x002c }
            java.lang.String r12 = r12.getId()     // Catch:{ all -> 0x002c }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x002c }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r12, r1}     // Catch:{ all -> 0x002c }
            r6.warn((java.lang.String) r0, (java.lang.Object[]) r11)     // Catch:{ all -> 0x002c }
            org.apache.tika.pipes.PipesResult r11 = org.apache.tika.pipes.PipesResult.e     // Catch:{ all -> 0x002c }
            r3.cancel(r4)
            return r11
        L_0x00c9:
            java.lang.Process r0 = r11.f     // Catch:{ all -> 0x002c }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x002c }
            r9 = 500(0x1f4, double:2.47E-321)
            r0.waitFor(r9, r1)     // Catch:{ all -> 0x002c }
            java.lang.Process r0 = r11.f     // Catch:{ all -> 0x002c }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x00f2
            java.lang.String r0 = "pipesClientId={} crash: {} in {} ms with no exit code available"
            int r11 = r11.c     // Catch:{ all -> 0x002c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x002c }
            java.lang.String r12 = r12.getId()     // Catch:{ all -> 0x002c }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x002c }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r12, r1}     // Catch:{ all -> 0x002c }
            r6.warn((java.lang.String) r0, (java.lang.Object[]) r11)     // Catch:{ all -> 0x002c }
            goto L_0x0113
        L_0x00f2:
            java.lang.String r0 = "pipesClientId={} crash: {} in {} ms with exit code {}"
            int r1 = r11.c     // Catch:{ all -> 0x002c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x002c }
            java.lang.String r12 = r12.getId()     // Catch:{ all -> 0x002c }
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x002c }
            java.lang.Process r11 = r11.f     // Catch:{ all -> 0x002c }
            int r11 = r11.exitValue()     // Catch:{ all -> 0x002c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x002c }
            java.lang.Object[] r11 = new java.lang.Object[]{r1, r12, r2, r11}     // Catch:{ all -> 0x002c }
            r6.warn((java.lang.String) r0, (java.lang.Object[]) r11)     // Catch:{ all -> 0x002c }
        L_0x0113:
            org.apache.tika.pipes.PipesResult r11 = org.apache.tika.pipes.PipesResult.g     // Catch:{ all -> 0x002c }
            r3.cancel(r4)
            return r11
        L_0x0119:
            r11.g()     // Catch:{ all -> 0x002c }
            throw r12     // Catch:{ all -> 0x002c }
        L_0x011d:
            r3.cancel(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.pipes.PipesClient.c(org.apache.tika.pipes.FetchEmitTuple):org.apache.tika.pipes.PipesResult");
    }

    public void close() {
        if (this.f != null) {
            try {
                g();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this.f3289a) {
            try {
                ExecutorService executorService = this.e;
                if (executorService != null) {
                    executorService.shutdownNow();
                }
                this.d = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final PipesResult d() {
        ObjectInputStream objectInputStream;
        byte[] bArr = new byte[this.h.readInt()];
        this.h.readFully(bArr);
        try {
            objectInputStream = new ObjectInputStream(new UnsynchronizedByteArrayInputStream(bArr));
            EmitData emitData = (EmitData) objectInputStream.readObject();
            String containerStackTrace = emitData.getContainerStackTrace();
            if (StringUtils.a(containerStackTrace)) {
                PipesResult pipesResult = new PipesResult(emitData);
                objectInputStream.close();
                return pipesResult;
            }
            PipesResult pipesResult2 = new PipesResult(emitData, containerStackTrace);
            objectInputStream.close();
            return pipesResult2;
        } catch (ClassNotFoundException e2) {
            j.error("class not found exception deserializing data", (Throwable) e2);
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|(2:8|9)(1:10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r4 = this;
            java.lang.Process r0 = r4.f
            r0.destroyForcibly()
            java.lang.Process r0 = r4.f
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r2 = 10000(0x2710, double:4.9407E-320)
            r0.waitFor(r2, r1)
            java.io.DataInputStream r0 = r4.h     // Catch:{ IOException -> 0x0013 }
            r0.close()     // Catch:{ IOException -> 0x0013 }
        L_0x0013:
            java.io.DataOutputStream r0 = r4.g     // Catch:{ IOException -> 0x0018 }
            r0.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            java.lang.Process r4 = r4.f
            boolean r4 = r4.isAlive()
            if (r4 == 0) goto L_0x002b
            org.slf4j.Logger r4 = j
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.String r1 = "Process still alive after {}ms"
            r4.error((java.lang.String) r1, (java.lang.Object) r0)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.pipes.PipesClient.g():void");
    }

    public final String[] i() {
        List<String> J = this.b.J();
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str2 = null;
        for (String str3 : J) {
            if (str3.startsWith("-Djava.awt.headless")) {
                z2 = true;
            }
            if (str3.equals("-cp") || str3.equals("--classpath")) {
                z = true;
            }
            if (str3.equals("-XX:+ExitOnOutOfMemoryError") || str3.equals("-XX:+CrashOnOutOfMemoryError")) {
                z3 = true;
            }
            if (str3.startsWith("-Dlog4j.configuration")) {
                z4 = true;
            }
            if (str3.startsWith("-Xloggc:")) {
                str2 = str3.replace("${pipesClientId}", "id-" + this.c);
                str = str3;
            }
        }
        if (!(str == null || str2 == null)) {
            J.remove(str);
            J.add(str2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ProcessUtils.b(this.b.N()));
        if (!z) {
            arrayList.add("-cp");
            arrayList.add(System.getProperty("java.class.path"));
        }
        if (!z2) {
            arrayList.add("-Djava.awt.headless=true");
        }
        if (z3) {
            j.warn("I notice that you have an exit/crash on OOM. If you run heavy external processes like tesseract, this setting may result in orphaned processes which could be disastrous for performance.");
        }
        if (!z4) {
            arrayList.add("-Dlog4j.configurationFile=classpath:pipes-fork-server-default-log4j2.xml");
        }
        arrayList.add("-DpipesClientId=" + this.c);
        arrayList.addAll(J);
        arrayList.add("org.apache.tika.pipes.PipesServer");
        arrayList.add(ProcessUtils.b(this.b.f0().toAbsolutePath().toString()));
        arrayList.add(Long.toString(this.b.T()));
        arrayList.add(Long.toString(this.b.i0()));
        arrayList.add(Long.toString(this.b.U()));
        j.debug("pipesClientId={}: commandline: {}", Integer.valueOf(this.c), arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final /* synthetic */ PipesResult n(FetchEmitTuple fetchEmitTuple, long j2) {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsynchronizedByteArrayOutputStream);
        try {
            objectOutputStream.writeObject(fetchEmitTuple);
            objectOutputStream.close();
            byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
            this.g.write(PipesServer.STATUS.CALL.getByte());
            this.g.writeInt(byteArray.length);
            this.g.write(byteArray);
            this.g.flush();
            Logger logger = j;
            if (logger.isTraceEnabled()) {
                logger.trace("pipesClientId={}: timer -- write tuple: {} ms", Integer.valueOf(this.c), Long.valueOf(System.currentTimeMillis() - j2));
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!Thread.currentThread().isInterrupted()) {
                PipesResult w = w(fetchEmitTuple, j2);
                if (logger.isDebugEnabled()) {
                    logger.debug("finished reading result in {} ms", (Object) Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                if (logger.isTraceEnabled()) {
                    logger.trace("pipesClientId={}: timer -- read result: {} ms", Integer.valueOf(this.c), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                return w;
            }
            throw new InterruptedException("thread interrupt");
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final /* synthetic */ Integer o(UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream) {
        int read = this.h.read();
        int i2 = 1;
        while (i2 < 20000 && read != PipesServer.STATUS.READY.getByte()) {
            if (read != -1) {
                unsynchronizedByteArrayOutputStream.write(read);
                read = this.h.read();
                i2++;
            } else {
                throw new RuntimeException(j("pipesClientId=" + this.c + ": Couldn't start server -- read EOF before 'ready' byte.\n process isAlive=" + this.f.isAlive(), unsynchronizedByteArrayOutputStream));
            }
        }
        if (i2 < 20000) {
            if (unsynchronizedByteArrayOutputStream.size() > 0) {
                j.warn("pipesClientId={}: From forked process before start byte: {}", Integer.valueOf(this.c), unsynchronizedByteArrayOutputStream.toString(StandardCharsets.UTF_8));
            }
            return 1;
        }
        throw new RuntimeException(j("pipesClientId=" + this.c + ": Couldn't start server: read too many bytes before 'ready' byte.\n Make absolutely certain that your logger is not writing to stdout.\n", unsynchronizedByteArrayOutputStream));
    }

    public final void r() {
        try {
            this.f.waitFor(200, TimeUnit.MILLISECONDS);
        } finally {
            g();
        }
    }

    public final boolean s() {
        Process process = this.f;
        if (process != null && process.isAlive()) {
            try {
                DataOutputStream dataOutputStream = this.g;
                PipesServer.STATUS status = PipesServer.STATUS.PING;
                dataOutputStream.write(status.getByte());
                this.g.flush();
                if (this.h.read() == status.getByte()) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public PipesResult u(FetchEmitTuple fetchEmitTuple) {
        if (s()) {
            if (this.b.S() > 0 && this.i >= this.b.S()) {
                j.info("pipesClientId={}: restarting server after hitting max files: {}", Integer.valueOf(this.c), Integer.valueOf(this.i));
            }
            return c(fetchEmitTuple);
        }
        boolean z = false;
        while (!z) {
            try {
                z();
                z = true;
            } catch (TimeoutException unused) {
                j.warn("pipesClientId={}: couldn't restart within {} ms (startupTimeoutMillis)", Integer.valueOf(this.c), Long.valueOf(this.b.d0()));
                Thread.sleep(this.b.c0());
            }
        }
        return c(fetchEmitTuple);
    }

    public final PipesResult v(PipesResult.STATUS status) {
        byte[] bArr = new byte[this.h.readInt()];
        this.h.readFully(bArr);
        return new PipesResult(status, new String(bArr, StandardCharsets.UTF_8));
    }

    public final PipesResult w(FetchEmitTuple fetchEmitTuple, long j2) {
        int read = this.h.read();
        long currentTimeMillis = System.currentTimeMillis() - j2;
        try {
            PipesServer.STATUS lookup = PipesServer.STATUS.lookup(read);
            switch (AnonymousClass1.f3290a[lookup.ordinal()]) {
                case 1:
                    j.warn("pipesClientId={} oom: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return PipesResult.f;
                case 2:
                    j.warn("pipesClientId={} server response timeout: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return PipesResult.e;
                case 3:
                    j.warn("pipesClientId={} emit exception: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return v(PipesResult.STATUS.EMIT_EXCEPTION);
                case 4:
                    j.warn("pipesClientId={} emitter not found: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return v(PipesResult.STATUS.NO_EMITTER_FOUND);
                case 5:
                    j.warn("pipesClientId={} fetcher not found: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return v(PipesResult.STATUS.NO_FETCHER_FOUND);
                case 6:
                    j.warn("pipesClientId={} fetcher initialization exception: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return v(PipesResult.STATUS.FETCHER_INITIALIZATION_EXCEPTION);
                case 7:
                    j.warn("pipesClientId={} fetch exception: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return v(PipesResult.STATUS.FETCH_EXCEPTION);
                case 8:
                    j.debug("pipesClientId={} parse success: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return d();
                case 9:
                    return v(PipesResult.STATUS.PARSE_EXCEPTION_NO_EMIT);
                case 10:
                    j.debug("pipesClientId={} emit success: {} in {} ms", Integer.valueOf(this.c), fetchEmitTuple.getId(), Long.valueOf(currentTimeMillis));
                    return PipesResult.h;
                case 11:
                    return v(PipesResult.STATUS.EMIT_SUCCESS_PARSE_EXCEPTION);
                case 12:
                    return PipesResult.j;
                case 13:
                case 14:
                case 15:
                case 16:
                    throw new IOException("Not expecting this status: " + lookup);
                default:
                    throw new IOException("Need to handle procesing for: " + lookup);
            }
        } catch (IllegalArgumentException unused) {
            throw new IOException("problem reading response from server " + null);
        }
    }

    public final void z() {
        if (this.f != null) {
            Logger logger = j;
            logger.debug("process still alive; trying to destroy it");
            g();
            Process process = this.f;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!process.waitFor(30, timeUnit)) {
                logger.warn("pipesClientId={}: process has not yet ended", (Object) Integer.valueOf(this.c));
            }
            this.e.shutdownNow();
            if (!this.e.awaitTermination(30, timeUnit)) {
                logger.warn("pipesClientId={}: executorService has not yet shutdown", (Object) Integer.valueOf(this.c));
            }
            synchronized (this.f3289a) {
                if (!this.d) {
                    this.e = Executors.newFixedThreadPool(1);
                } else {
                    throw new IllegalArgumentException("pipesClientId=" + this.c + ": PipesClient closed");
                }
            }
            logger.info("pipesClientId={}: restarting process", (Object) Integer.valueOf(this.c));
        } else {
            j.info("pipesClientId={}: starting process", (Object) Integer.valueOf(this.c));
        }
        ProcessBuilder processBuilder = new ProcessBuilder(i());
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            this.f = processBuilder.start();
            this.h = new DataInputStream(this.f.getInputStream());
            this.g = new DataOutputStream(this.f.getOutputStream());
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            FutureTask futureTask = new FutureTask(new b(this, unsynchronizedByteArrayOutputStream));
            long currentTimeMillis = System.currentTimeMillis();
            this.e.submit(futureTask);
            try {
                futureTask.get(this.b.d0(), TimeUnit.MILLISECONDS);
                futureTask.cancel(true);
            } catch (InterruptedException e2) {
                g();
                throw e2;
            } catch (ExecutionException e3) {
                Logger logger2 = j;
                logger2.error("pipesClientId=" + this.c + ": couldn't start server", (Throwable) e3);
                g();
                throw new RuntimeException(e3);
            } catch (TimeoutException e4) {
                j.error("pipesClientId={} didn't receive ready byte from server within StartupTimeoutMillis {}; ms elapsed {}; did read >{}<", Integer.valueOf(this.c), Long.valueOf(this.b.d0()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), unsynchronizedByteArrayOutputStream.toString(StandardCharsets.UTF_8));
                g();
                throw e4;
            } catch (Throwable th) {
                futureTask.cancel(true);
                throw th;
            }
        } catch (Exception e5) {
            j.error("failed to start client", (Throwable) e5);
            throw new FailedToStartClientException(e5);
        }
    }
}
