package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000bJB\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2'\u0010\u0015\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010¢\u0006\u0002\b\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ'\u0010 \u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u0019H@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000bJ\u001b\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u000bJ\u0017\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ#\u0010(\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010%R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM;", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lkotlinx/coroutines/Job;", "job", "", "J", "(Lkotlinx/coroutines/Job;)V", "Ljava/nio/ByteBuffer;", "src", "", "Q1", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "dst", "u", "R", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "visitor", "m", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "min", "Lkotlin/Function1;", "consumer", "K", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "x", "", "y", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R1", "S1", "P1", "(Ljava/nio/ByteBuffer;)I", "M1", "rc0", "N1", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O1", "attachedJob", "Lkotlinx/coroutines/Job;", "Session", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nByteChannelSequentialJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannelSequentialJVM.kt\nio/ktor/utils/io/ByteChannelSequentialJVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ByteBuffers.kt\nio/ktor/utils/io/core/ByteBuffersKt\n+ 4 PacketDirect.kt\nio/ktor/utils/io/core/PacketDirectKt\n+ 5 BufferUtilsJvm.kt\nio/ktor/utils/io/core/BufferUtilsJvmKt\n+ 6 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 7 Output.kt\nio/ktor/utils/io/core/Output\n*L\n1#1,256:1\n1#2:257\n1#2:285\n1#2:329\n1#2:373\n1#2:405\n1#2:436\n91#3,5:258\n96#3:271\n97#3:289\n98#3:301\n91#3,5:302\n96#3:315\n97#3:333\n98#3:345\n59#3,5:346\n80#3,5:351\n85#3:359\n64#3:382\n80#3,5:383\n85#3:391\n80#3,5:414\n85#3:422\n9#4,8:263\n18#4,11:290\n9#4,8:307\n18#4,11:334\n95#5,5:272\n100#5,3:282\n104#5:286\n95#5,5:316\n100#5,3:326\n104#5:330\n111#5,5:360\n116#5,3:370\n120#5:374\n111#5,5:392\n116#5,3:402\n120#5:406\n111#5,5:423\n116#5,3:433\n120#5:437\n372#6,5:277\n377#6,2:287\n372#6,5:321\n377#6,2:331\n390#6,5:365\n395#6,2:375\n390#6,5:397\n395#6,2:407\n390#6,5:428\n395#6,2:438\n371#7,3:356\n374#7,5:377\n371#7,3:388\n374#7,5:409\n371#7,3:419\n374#7,5:440\n*S KotlinDebug\n*F\n+ 1 ByteChannelSequentialJVM.kt\nio/ktor/utils/io/ByteChannelSequentialJVM\n*L\n102#1:285\n198#1:329\n220#1:373\n235#1:405\n247#1:436\n102#1:258,5\n102#1:271\n102#1:289\n102#1:301\n198#1:302,5\n198#1:315\n198#1:333\n198#1:345\n220#1:346,5\n220#1:351,5\n220#1:359\n220#1:382\n235#1:383,5\n235#1:391\n247#1:414,5\n247#1:422\n102#1:263,8\n102#1:290,11\n198#1:307,8\n198#1:334,11\n102#1:272,5\n102#1:282,3\n102#1:286\n198#1:316,5\n198#1:326,3\n198#1:330\n220#1:360,5\n220#1:370,3\n220#1:374\n235#1:392,5\n235#1:402,3\n235#1:406\n247#1:423,5\n247#1:433,3\n247#1:437\n102#1:277,5\n102#1:287,2\n198#1:321,5\n198#1:331,2\n220#1:365,5\n220#1:375,2\n235#1:397,5\n235#1:407,2\n247#1:428,5\n247#1:438,2\n220#1:356,3\n220#1:377,5\n235#1:388,3\n235#1:409,5\n247#1:419,3\n247#1:440,5\n*E\n"})
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {
    /* access modifiers changed from: private */
    @Nullable
    public volatile Job attachedJob;

    @SourceDebugExtension({"SMAP\nByteChannelSequentialJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannelSequentialJVM.kt\nio/ktor/utils/io/ByteChannelSequentialJVM$Session\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Packet.kt\nio/ktor/utils/io/core/PacketKt\n+ 4 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,256:1\n1#2:257\n39#3:258\n69#4:259\n*S KotlinDebug\n*F\n+ 1 ByteChannelSequentialJVM.kt\nio/ktor/utils/io/ByteChannelSequentialJVM$Session\n*L\n179#1:258\n184#1:259\n*E\n"})
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM$Session;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lio/ktor/utils/io/ByteChannelSequentialJVM;", "channel", "<init>", "(Lio/ktor/utils/io/ByteChannelSequentialJVM;)V", "", "n", "", "b", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "r", "(I)V", "skip", "atLeast", "Ljava/nio/ByteBuffer;", "a", "(II)Ljava/nio/ByteBuffer;", "Lio/ktor/utils/io/ByteChannelSequentialJVM;", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Session implements LookAheadSuspendSession {
        public final ByteChannelSequentialJVM b;

        public Session(ByteChannelSequentialJVM byteChannelSequentialJVM) {
            Intrinsics.checkNotNullParameter(byteChannelSequentialJVM, "channel");
            this.b = byteChannelSequentialJVM;
        }

        public ByteBuffer a(int i, int i2) {
            Throwable f = this.b.f();
            if (f != null) {
                throw f;
            } else if (this.b.Q()) {
                return null;
            } else {
                if (this.b.D0().c0()) {
                    this.b.G0();
                }
                ChunkBuffer d0 = this.b.D0().d0();
                if (d0.k() - d0.i() < i2 + i) {
                    return null;
                }
                ByteBuffer slice = d0.h().slice();
                slice.position(d0.i() + i);
                slice.limit(d0.k());
                return slice;
            }
        }

        public Object b(int i, Continuation continuation) {
            Throwable f = this.b.f();
            if (f == null) {
                return this.b.b(i, continuation);
            }
            throw f;
        }

        public void r(int i) {
            Throwable f = this.b.f();
            if (f == null) {
                this.b.r(i);
                return;
            }
            throw f;
        }
    }

    public void J(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.d(job, true, false, new ByteChannelSequentialJVM$attachJob$1(this), 2, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object K(int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            java.lang.String r0 = "Buffer's position shouldn't be rewinded"
            boolean r1 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$read$1
            if (r1 == 0) goto L_0x0015
            r1 = r8
            io.ktor.utils.io.ByteChannelSequentialJVM$read$1 r1 = (io.ktor.utils.io.ByteChannelSequentialJVM$read$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.utils.io.ByteChannelSequentialJVM$read$1 r1 = new io.ktor.utils.io.ByteChannelSequentialJVM$read$1
            r1.<init>(r5, r8)
        L_0x001a:
            java.lang.Object r8 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x003e
            if (r3 != r4) goto L_0x0036
            int r6 = r1.I$0
            java.lang.Object r5 = r1.L$1
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r5 = r1.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r5 = (io.ktor.utils.io.ByteChannelSequentialJVM) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0052
        L_0x0036:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 < 0) goto L_0x00f2
            r1.L$0 = r5
            r1.L$1 = r7
            r1.I$0 = r6
            r1.label = r4
            java.lang.Object r8 = r5.b(r6, r1)
            if (r8 != r2) goto L_0x0052
            return r2
        L_0x0052:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00d6
            io.ktor.utils.io.core.ByteReadPacket r5 = r5.D0()
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = r5.D0(r6)
            if (r8 == 0) goto L_0x00cd
            int r6 = r8.i()
            java.nio.ByteBuffer r1 = r8.h()     // Catch:{ all -> 0x00a5 }
            int r2 = r8.i()     // Catch:{ all -> 0x00a5 }
            int r3 = r8.k()     // Catch:{ all -> 0x00a5 }
            int r3 = r3 - r2
            java.nio.ByteBuffer r1 = io.ktor.utils.io.bits.Memory.h(r1, r2, r3)     // Catch:{ all -> 0x00a5 }
            r7.invoke(r1)     // Catch:{ all -> 0x00a5 }
            int r7 = r1.limit()     // Catch:{ all -> 0x00a5 }
            if (r7 != r3) goto L_0x00a7
            int r7 = r1.position()     // Catch:{ all -> 0x00a5 }
            r8.c(r7)     // Catch:{ all -> 0x00a5 }
            int r7 = r8.i()
            if (r7 < r6) goto L_0x009f
            int r6 = r8.k()
            if (r7 != r6) goto L_0x0099
            r5.v(r8)
            goto L_0x009c
        L_0x0099:
            r5.O0(r7)
        L_0x009c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x009f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>(r0)
            throw r5
        L_0x00a5:
            r7 = move-exception
            goto L_0x00b3
        L_0x00a7:
            java.lang.String r7 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a5 }
            r1.<init>(r7)     // Catch:{ all -> 0x00a5 }
            throw r1     // Catch:{ all -> 0x00a5 }
        L_0x00b3:
            int r1 = r8.i()
            if (r1 < r6) goto L_0x00c7
            int r6 = r8.k()
            if (r1 != r6) goto L_0x00c3
            r5.v(r8)
            goto L_0x00c6
        L_0x00c3:
            r5.O0(r1)
        L_0x00c6:
            throw r7
        L_0x00c7:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>(r0)
            throw r5
        L_0x00cd:
            io.ktor.utils.io.core.StringsKt.a(r6)
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L_0x00d6:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Channel closed while "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = " bytes expected"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x00f2:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Failed requirement."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.K(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.nio.ByteBuffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object M1(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006d
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r5 = (io.ktor.utils.io.ByteChannelSequentialJVM) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.b(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x005f
            r5 = -1
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        L_0x005f:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r5.u(r6, r0)
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.M1(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object N1(java.nio.ByteBuffer r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r8 = (io.ktor.utils.io.ByteChannelSequentialJVM) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L_0x0056
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0041:
            boolean r9 = r7.hasRemaining()
            if (r9 == 0) goto L_0x0075
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r6.b(r3, r0)
            if (r9 != r1) goto L_0x0056
            return r1
        L_0x0056:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.String r2 = "Channel closed"
            if (r9 == 0) goto L_0x006f
            int r9 = r6.O1(r7)
            r4 = -1
            if (r9 == r4) goto L_0x0069
            int r8 = r8 + r9
            goto L_0x0041
        L_0x0069:
            java.io.EOFException r6 = new java.io.EOFException
            r6.<init>(r2)
            throw r6
        L_0x006f:
            java.io.EOFException r6 = new java.io.EOFException
            r6.<init>(r2)
            throw r6
        L_0x0075:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.N1(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int O1(ByteBuffer byteBuffer) {
        Throwable f = f();
        if (f != null) {
            throw f;
        } else if (A0() && i() == 0) {
            return -1;
        } else {
            if (!D0().g()) {
                G0();
            }
            int b = ByteBuffersKt.b(D0(), byteBuffer);
            h0(b);
            return b;
        }
    }

    public final int P1(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int z0 = z0();
        if (A0()) {
            Throwable f = f();
            if (f == null) {
                f = new ClosedSendChannelException("Channel closed for write");
            }
            throw f;
        }
        if (remaining != 0) {
            if (remaining <= z0) {
                OutputArraysJVMKt.a(E0(), byteBuffer);
            } else if (z0 != 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + z0);
                OutputArraysJVMKt.a(E0(), byteBuffer);
                byteBuffer.limit(limit);
                remaining = z0;
            }
            i0(remaining);
            return remaining;
        }
        remaining = 0;
        i0(remaining);
        return remaining;
    }

    public Object Q1(ByteBuffer byteBuffer, Continuation continuation) {
        int P1 = P1(byteBuffer);
        if (P1 <= 0) {
            if (byteBuffer.hasRemaining()) {
                return R1(byteBuffer, continuation);
            }
            P1 = 0;
        }
        return Boxing.boxInt(P1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.nio.ByteBuffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v4 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x005c, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object R1(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r5 = (io.ktor.utils.io.ByteChannelSequentialJVM) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.l0(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r5.Q1(r6, r0)
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x005f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.R1(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object S1(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r6 = (io.ktor.utils.io.ByteChannelSequentialJVM) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L_0x0052
        L_0x0034:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x003f:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L_0x005a
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.l0(r3, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            int r7 = r5.P1(r6)
            r5.i0(r7)
            goto L_0x003f
        L_0x005a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.S1(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object l(ByteBuffer byteBuffer, Continuation continuation) {
        P1(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Unit.INSTANCE;
        }
        Object S1 = S1(byteBuffer, continuation);
        return S1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? S1 : Unit.INSTANCE;
    }

    public Object m(Function2 function2, Continuation continuation) {
        return function2.invoke(new Session(this), continuation);
    }

    public Object u(ByteBuffer byteBuffer, Continuation continuation) {
        int O1 = O1(byteBuffer);
        return O1 != 0 ? Boxing.boxInt(O1) : !byteBuffer.hasRemaining() ? Boxing.boxInt(0) : M1(byteBuffer, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084 A[Catch:{ all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A[Catch:{ all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object x(int r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$1
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r4 = (io.ktor.utils.io.ByteChannelSequentialJVM) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0062
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r4.A0()
            if (r7 == 0) goto L_0x0053
            java.lang.Throwable r4 = r4.f()
            if (r4 != 0) goto L_0x0052
            kotlinx.coroutines.channels.ClosedSendChannelException r4 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r5 = "Channel closed for write"
            r4.<init>(r5)
        L_0x0052:
            throw r4
        L_0x0053:
            r0.L$0 = r4
            r0.L$1 = r6
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r7 = r4.l0(r5, r0)
            if (r7 != r1) goto L_0x0062
            return r1
        L_0x0062:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r4.E0()
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r7.c0(r5)
            java.nio.ByteBuffer r0 = r5.h()     // Catch:{ all -> 0x00a2 }
            int r1 = r5.k()     // Catch:{ all -> 0x00a2 }
            int r2 = r5.g()     // Catch:{ all -> 0x00a2 }
            int r2 = r2 - r1
            java.nio.ByteBuffer r0 = io.ktor.utils.io.bits.Memory.h(r0, r1, r2)     // Catch:{ all -> 0x00a2 }
            r6.invoke(r0)     // Catch:{ all -> 0x00a2 }
            int r6 = r0.limit()     // Catch:{ all -> 0x00a2 }
            if (r6 != r2) goto L_0x00a4
            int r6 = r0.position()     // Catch:{ all -> 0x00a2 }
            r5.a(r6)     // Catch:{ all -> 0x00a2 }
            if (r6 < 0) goto L_0x0096
            r7.b()
            r4.i0(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0096:
            java.lang.String r4 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a2 }
            r5.<init>(r4)     // Catch:{ all -> 0x00a2 }
            throw r5     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r4 = move-exception
            goto L_0x00b0
        L_0x00a4:
            java.lang.String r4 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a2 }
            r5.<init>(r4)     // Catch:{ all -> 0x00a2 }
            throw r5     // Catch:{ all -> 0x00a2 }
        L_0x00b0:
            r7.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.x(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095 A[Catch:{ all -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object y(kotlin.jvm.functions.Function1 r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r8
            r8 = r2
            goto L_0x006a
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0042:
            boolean r10 = r8.A0()
            if (r10 == 0) goto L_0x0056
            java.lang.Throwable r8 = r8.f()
            if (r8 != 0) goto L_0x0055
            kotlinx.coroutines.channels.ClosedSendChannelException r8 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r9 = "Channel closed for write"
            r8.<init>(r9)
        L_0x0055:
            throw r8
        L_0x0056:
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef
            r10.<init>()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r2 = r8.l0(r3, r0)
            if (r2 != r1) goto L_0x006a
            return r1
        L_0x006a:
            io.ktor.utils.io.core.BytePacketBuilder r2 = r8.E0()
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r2.c0(r3)
            java.nio.ByteBuffer r5 = r4.h()     // Catch:{ all -> 0x00b7 }
            int r6 = r4.k()     // Catch:{ all -> 0x00b7 }
            int r7 = r4.g()     // Catch:{ all -> 0x00b7 }
            int r7 = r7 - r6
            java.nio.ByteBuffer r5 = io.ktor.utils.io.bits.Memory.h(r5, r6, r7)     // Catch:{ all -> 0x00b7 }
            java.lang.Object r6 = r9.invoke(r5)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00b7 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00b7 }
            r10.element = r6     // Catch:{ all -> 0x00b7 }
            int r6 = r5.limit()     // Catch:{ all -> 0x00b7 }
            if (r6 != r7) goto L_0x00b9
            int r5 = r5.position()     // Catch:{ all -> 0x00b7 }
            r4.a(r5)     // Catch:{ all -> 0x00b7 }
            if (r5 < 0) goto L_0x00ab
            r2.b()
            r8.i0(r5)
            boolean r10 = r10.element
            if (r10 != 0) goto L_0x0042
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00ab:
            java.lang.String r8 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b7 }
            r9.<init>(r8)     // Catch:{ all -> 0x00b7 }
            throw r9     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r8 = move-exception
            goto L_0x00c5
        L_0x00b9:
            java.lang.String r8 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b7 }
            r9.<init>(r8)     // Catch:{ all -> 0x00b7 }
            throw r9     // Catch:{ all -> 0x00b7 }
        L_0x00c5:
            r2.b()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.y(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
