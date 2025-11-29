package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "okio/Okio")
final /* synthetic */ class Okio__OkioKt {
    @NotNull
    @JvmName(name = "blackhole")
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RealBufferedSource(source);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.io.Closeable, R> R use(T r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends R> r4) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1
            r1 = 0
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0019 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r3 == 0) goto L_0x0015
            r3.close()     // Catch:{ all -> 0x0014 }
            goto L_0x0015
        L_0x0014:
            r1 = move-exception
        L_0x0015:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            goto L_0x002d
        L_0x0019:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r3 == 0) goto L_0x0027
            r3.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r3)
        L_0x0027:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            r2 = r1
            r1 = r4
            r4 = r2
        L_0x002d:
            if (r1 != 0) goto L_0x0033
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        L_0x0033:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Okio__OkioKt.use(java.io.Closeable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new RealBufferedSink(sink);
    }
}
