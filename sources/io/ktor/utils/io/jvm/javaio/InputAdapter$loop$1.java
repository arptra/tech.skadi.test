package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nBlocking.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/InputAdapter$loop$1\n+ 2 Blocking.kt\nio/ktor/utils/io/jvm/javaio/BlockingAdapter\n*L\n1#1,316:1\n275#2,4:317\n*S KotlinDebug\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/InputAdapter$loop$1\n*L\n37#1:317,4\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/InputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class InputAdapter$loop$1 extends BlockingAdapter {
    public final /* synthetic */ InputAdapter g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1(Job job, InputAdapter inputAdapter) {
        super(job);
        this.g = inputAdapter;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    public java.lang.Object h(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r8 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0083
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.Object r8 = r0.L$1
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r8 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r8 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0060
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 0
        L_0x0048:
            r8.result = r9
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r8.j(r0)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r2) goto L_0x005d
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x005d:
            if (r9 != r1) goto L_0x0060
            return r1
        L_0x0060:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.ByteArray"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r2)
            byte[] r9 = (byte[]) r9
            io.ktor.utils.io.jvm.javaio.InputAdapter r2 = r8.g
            io.ktor.utils.io.ByteReadChannel r2 = r2.f9111a
            int r5 = r8.f()
            int r6 = r8.e()
            r0.L$0 = r8
            r7 = 0
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r9 = r2.D(r9, r5, r6, r0)
            if (r9 != r1) goto L_0x0083
            return r1
        L_0x0083:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r2 = -1
            if (r9 != r2) goto L_0x0048
            io.ktor.utils.io.jvm.javaio.InputAdapter r0 = r8.g
            kotlinx.coroutines.CompletableJob r0 = r0.b
            r0.complete()
            r8.d(r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1.h(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
