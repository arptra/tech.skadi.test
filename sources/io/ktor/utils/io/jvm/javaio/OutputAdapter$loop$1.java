package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nBlocking.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1\n+ 2 Blocking.kt\nio/ktor/utils/io/jvm/javaio/BlockingAdapter\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,316:1\n275#2,4:317\n1#3:321\n*S KotlinDebug\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1\n*L\n88#1:317,4\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class OutputAdapter$loop$1 extends BlockingAdapter {
    public final /* synthetic */ OutputAdapter g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutputAdapter$loop$1(Job job, OutputAdapter outputAdapter) {
        super(job);
        this.g = outputAdapter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[Catch:{ all -> 0x0030, all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[Catch:{ all -> 0x0030, all -> 0x00d3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0086 A[SYNTHETIC, Splitter:B:36:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1 r8 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0030 }
            goto L_0x004a
        L_0x0030:
            r9 = move-exception
            goto L_0x00c5
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.L$1
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r8 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1 r8 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0030 }
            goto L_0x0063
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x004a:
            r9 = 0
            r8.result = r9     // Catch:{ all -> 0x0030 }
            r0.L$0 = r8     // Catch:{ all -> 0x0030 }
            r0.L$1 = r8     // Catch:{ all -> 0x0030 }
            r0.label = r4     // Catch:{ all -> 0x0030 }
            java.lang.Object r9 = r8.j(r0)     // Catch:{ all -> 0x0030 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0030 }
            if (r9 != r2) goto L_0x0060
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0030 }
        L_0x0060:
            if (r9 != r1) goto L_0x0063
            return r1
        L_0x0063:
            java.lang.Object r2 = io.ktor.utils.io.jvm.javaio.BlockingKt.b     // Catch:{ all -> 0x0030 }
            if (r9 != r2) goto L_0x0086
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r8.g
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f9112a
            boolean r9 = io.ktor.utils.io.ByteWriteChannelKt.a(r9)
            if (r9 != 0) goto L_0x0083
            io.ktor.utils.io.jvm.javaio.OutputAdapter r8 = r8.g
            io.ktor.utils.io.ByteWriteChannel r8 = r8.f9112a
            java.lang.Throwable r8 = r8.f()
            if (r8 != 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            throw r8
        L_0x0083:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0086:
            java.lang.Object r2 = io.ktor.utils.io.jvm.javaio.BlockingKt.c     // Catch:{ all -> 0x0030 }
            if (r9 != r2) goto L_0x00a3
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r8.g     // Catch:{ all -> 0x0030 }
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f9112a     // Catch:{ all -> 0x0030 }
            r9.flush()     // Catch:{ all -> 0x0030 }
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r8.g     // Catch:{ all -> 0x0030 }
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f9112a     // Catch:{ all -> 0x0030 }
            java.lang.Throwable r9 = r9.f()     // Catch:{ all -> 0x0030 }
            if (r9 != 0) goto L_0x00a2
            goto L_0x004a
        L_0x00a2:
            throw r9     // Catch:{ all -> 0x0030 }
        L_0x00a3:
            boolean r2 = r9 instanceof byte[]     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x004a
            io.ktor.utils.io.jvm.javaio.OutputAdapter r2 = r8.g     // Catch:{ all -> 0x0030 }
            io.ktor.utils.io.ByteWriteChannel r2 = r2.f9112a     // Catch:{ all -> 0x0030 }
            byte[] r9 = (byte[]) r9     // Catch:{ all -> 0x0030 }
            int r5 = r8.f()     // Catch:{ all -> 0x0030 }
            int r6 = r8.e()     // Catch:{ all -> 0x0030 }
            r0.L$0 = r8     // Catch:{ all -> 0x0030 }
            r7 = 0
            r0.L$1 = r7     // Catch:{ all -> 0x0030 }
            r0.label = r3     // Catch:{ all -> 0x0030 }
            java.lang.Object r9 = r2.I(r9, r5, r6, r0)     // Catch:{ all -> 0x0030 }
            if (r9 != r1) goto L_0x004a
            return r1
        L_0x00c5:
            boolean r0 = r9 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00d3 }
            if (r0 != 0) goto L_0x00d5
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r8.g     // Catch:{ all -> 0x00d3 }
            io.ktor.utils.io.ByteWriteChannel r0 = r0.f9112a     // Catch:{ all -> 0x00d3 }
            r0.h(r9)     // Catch:{ all -> 0x00d3 }
            goto L_0x00d5
        L_0x00d3:
            r9 = move-exception
            goto L_0x00d6
        L_0x00d5:
            throw r9     // Catch:{ all -> 0x00d3 }
        L_0x00d6:
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r8.g
            io.ktor.utils.io.ByteWriteChannel r0 = r0.f9112a
            boolean r0 = io.ktor.utils.io.ByteWriteChannelKt.a(r0)
            if (r0 != 0) goto L_0x00ef
            io.ktor.utils.io.jvm.javaio.OutputAdapter r8 = r8.g
            io.ktor.utils.io.ByteWriteChannel r8 = r8.f9112a
            java.lang.Throwable r8 = r8.f()
            if (r8 == 0) goto L_0x00ef
            throw r8
        L_0x00ef:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1.h(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
