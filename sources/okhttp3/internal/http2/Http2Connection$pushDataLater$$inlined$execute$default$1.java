package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.concurrent.Task;
import okio.Buffer;

@SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n939#2:219\n940#2,8:222\n948#2:233\n402#3,2:220\n404#3,3:230\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n939#1:220,2\n939#1:230,3\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Http2Connection$pushDataLater$$inlined$execute$default$1 extends Task {
    final /* synthetic */ Buffer $buffer$inlined;
    final /* synthetic */ int $byteCount$inlined;
    final /* synthetic */ boolean $inFinished$inlined;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushDataLater$$inlined$execute$default$1(String str, boolean z, Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z2) {
        super(str, z);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$buffer$inlined = buffer;
        this.$byteCount$inlined = i2;
        this.$inFinished$inlined = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long runOnce() {
        /*
            r5 = this;
            okhttp3.internal.http2.Http2Connection r0 = r5.this$0     // Catch:{ IOException -> 0x003e }
            okhttp3.internal.http2.PushObserver r0 = r0.pushObserver     // Catch:{ IOException -> 0x003e }
            int r1 = r5.$streamId$inlined     // Catch:{ IOException -> 0x003e }
            okio.Buffer r2 = r5.$buffer$inlined     // Catch:{ IOException -> 0x003e }
            int r3 = r5.$byteCount$inlined     // Catch:{ IOException -> 0x003e }
            boolean r4 = r5.$inFinished$inlined     // Catch:{ IOException -> 0x003e }
            boolean r0 = r0.onData(r1, r2, r3, r4)     // Catch:{ IOException -> 0x003e }
            if (r0 == 0) goto L_0x0021
            okhttp3.internal.http2.Http2Connection r1 = r5.this$0     // Catch:{ IOException -> 0x003e }
            okhttp3.internal.http2.Http2Writer r1 = r1.getWriter()     // Catch:{ IOException -> 0x003e }
            int r2 = r5.$streamId$inlined     // Catch:{ IOException -> 0x003e }
            okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x003e }
            r1.rstStream(r2, r3)     // Catch:{ IOException -> 0x003e }
        L_0x0021:
            if (r0 != 0) goto L_0x0027
            boolean r0 = r5.$inFinished$inlined     // Catch:{ IOException -> 0x003e }
            if (r0 == 0) goto L_0x003e
        L_0x0027:
            okhttp3.internal.http2.Http2Connection r0 = r5.this$0     // Catch:{ IOException -> 0x003e }
            monitor-enter(r0)     // Catch:{ IOException -> 0x003e }
            okhttp3.internal.http2.Http2Connection r1 = r5.this$0     // Catch:{ all -> 0x003b }
            java.util.Set r1 = r1.currentPushRequests     // Catch:{ all -> 0x003b }
            int r5 = r5.$streamId$inlined     // Catch:{ all -> 0x003b }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x003b }
            r1.remove(r5)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ IOException -> 0x003e }
            goto L_0x003e
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ IOException -> 0x003e }
            throw r5     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1.runOnce():long");
    }
}
