package io.ktor.utils.io;

import com.honey.account.i.a;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.AwaitingSlot;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0019J\u0013\u0010\u001e\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0019J\u0013\u0010 \u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\b \u0010\u0019J\u0013\u0010\"\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0019J#\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J#\u0010)\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J#\u0010.\u001a\u00020\n2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b0\u0010/J+\u00104\u001a\u00020\n2\u0006\u0010,\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0019J\u000f\u00107\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u0010\fJ\u0019\u0010:\u001a\u0004\u0018\u0001092\u0006\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0004\b:\u0010;J#\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010A\u001a\u00020\u00132\u0006\u0010@\u001a\u000209H@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ+\u0010C\u001a\u00020\u00132\u0006\u0010@\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bC\u00105J\u0017\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0013H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0013H\u0002¢\u0006\u0004\bG\u0010FJ\u001b\u0010H\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u001b\u0010J\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bJ\u0010IJ\u000f\u0010K\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010\fJ\u000f\u0010L\u001a\u00020\nH\u0004¢\u0006\u0004\bL\u0010\fJ\u001b\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u001b\u0010Q\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\u001b\u0010T\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bT\u0010IJ\u001b\u0010V\u001a\u00020\n2\u0006\u0010U\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001b\u0010Y\u001a\u00020\n2\u0006\u0010X\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001b\u0010[\u001a\u00020\n2\u0006\u0010@\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J+\u0010]\u001a\u00020\n2\u0006\u0010@\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b]\u00105J\u001b\u0010^\u001a\u00020\u00132\u0006\u0010@\u001a\u000209H@ø\u0001\u0000¢\u0006\u0004\b^\u0010BJ+\u0010_\u001a\u00020\u00132\u0006\u0010@\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b_\u00105J<\u0010f\u001a\u00020\n2'\u0010e\u001a#\b\u0001\u0012\u0004\u0012\u00020a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0b\u0012\u0006\u0012\u0004\u0018\u00010c0`¢\u0006\u0002\bdH@ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020aH\u0016¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\n2\u0006\u0010j\u001a\u00020\u0013H\u0016¢\u0006\u0004\bk\u0010FJ\u0013\u0010l\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\bl\u0010\u0019J\u0013\u0010m\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0019J\u0017\u0010n\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0013H\u0004¢\u0006\u0004\bn\u0010FJ\u0013\u0010-\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019J\u0013\u0010o\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\bo\u0010\u0019J\u0013\u0010p\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\bp\u0010\u0019J\u0013\u0010q\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0004\bq\u0010\u0019J\u001b\u0010r\u001a\u00020%2\u0006\u0010$\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\br\u0010WJ\u001b\u0010s\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bs\u0010IJ\u001b\u0010t\u001a\u00020\u00132\u0006\u0010,\u001a\u000209H@ø\u0001\u0000¢\u0006\u0004\bt\u0010BJ\u001b\u0010u\u001a\u00020\u00132\u0006\u0010,\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0004\bu\u0010\\J+\u0010v\u001a\u00020\u00132\u0006\u0010,\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bv\u00105J+\u0010w\u001a\u00020\n2\u0006\u0010,\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bw\u00105J\u0013\u0010x\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0019J\u001b\u0010M\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bM\u0010IJ\u0013\u0010y\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0019J\u001b\u0010z\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\bz\u0010IJ\u0017\u0010{\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0013H\u0016¢\u0006\u0004\b{\u0010|J\u0019\u0010}\u001a\u0004\u0018\u0001092\u0006\u00108\u001a\u00020\u0013H\u0016¢\u0006\u0004\b}\u0010;J\u001b\u0010~\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0004\b~\u0010WJ\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\b\u0001\u0010\fJ?\u0010\u0001\u001a\u00020\n2(\u0010\u0001\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0b\u0012\u0006\u0012\u0004\u0018\u00010c0`¢\u0006\u0002\bdH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010gJ7\u0010\u0001\u001a\u00020\u0007\"\u000e\b\u0000\u0010r*\b0\u0001j\u0003`\u00012\u0007\u0010\u0001\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010$\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010IJ\u001e\u0010\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001dH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0013H\u0004¢\u0006\u0005\b\u0001\u0010FJF\u0010P\u001a\u00020\u001d2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0005\bP\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u00078\u0016X\u0004¢\u0006\u000e\n\u0005\bM\u0010\u0001\u001a\u0005\b\u0001\u0010\tR\u001e\u0010\u0001\u001a\u00020\u000f8\u0004X\u0004¢\u0006\u000f\n\u0005\bk\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010¢\u0001\u001a\u00020%8\u0004X\u0004¢\u0006\u000f\n\u0005\b\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001R\u0018\u0010¥\u0001\u001a\u00030£\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010¤\u0001R\u001c\u0010©\u0001\u001a\u00070cj\u0003`¦\u00018\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0017\u0010«\u0001\u001a\u00020\u000f8\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010\u0001R\u0016\u0010­\u0001\u001a\u00020\u00078BX\u0004¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010\tR)\u0010²\u0001\u001a\u00020\u00072\u0007\u0010®\u0001\u001a\u00020\u00078D@DX\u000e¢\u0006\u000f\u001a\u0005\b¯\u0001\u0010\t\"\u0006\b°\u0001\u0010±\u0001R\u0016\u0010´\u0001\u001a\u00020\u00138VX\u0004¢\u0006\u0007\u001a\u0005\bS\u0010³\u0001R\u0017\u0010¶\u0001\u001a\u00020\u00138VX\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010³\u0001R\u0016\u0010¸\u0001\u001a\u00020\u00078VX\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010\tR\u0016\u0010¹\u0001\u001a\u00020\u00078VX\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\tR0\u0010½\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b§\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006¾\u0001"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;", "", "x0", "()Z", "", "y0", "()V", "u0", "v0", "Lio/ktor/utils/io/core/BytePacketBuilder;", "closeable", "w0", "(Lio/ktor/utils/io/core/BytePacketBuilder;)V", "", "remaining", "p0", "(ILio/ktor/utils/io/core/BytePacketBuilder;)V", "", "O0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "g1", "Y0", "", "a1", "", "S0", "", "Q0", "builder", "limit", "Lio/ktor/utils/io/core/ByteReadPacket;", "e1", "(Lio/ktor/utils/io/core/BytePacketBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "c1", "(Lio/ktor/utils/io/core/BytePacketBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/Buffer;", "dst", "n", "T0", "(Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "V0", "", "offset", "length", "W0", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "M0", "r0", "atLeast", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "m1", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "max", "discarded0", "t0", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "src", "u1", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v1", "count", "f0", "(I)V", "g0", "l0", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k0", "flush", "G0", "b", "C", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "t", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "O", "l", "H", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "packet", "w", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "M", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "q1", "r1", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "visitor", "F", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "L", "()Lio/ktor/utils/io/WriterSuspendSession;", "written", "c", "q", "G", "h0", "E", "o", "B", "A", "j", "v", "H0", "D", "p", "K0", "n0", "o0", "r", "(I)I", "a", "k", "d", "()Lio/ktor/utils/io/SuspendableReadSession;", "P", "consumer", "h1", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "k1", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "N", "", "cause", "e", "(Ljava/lang/Throwable;)Z", "h", "p1", "(Lio/ktor/utils/io/ByteChannelSequentialBase;J)J", "i0", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "min", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Z", "z", "autoFlush", "Lio/ktor/utils/io/core/BytePacketBuilder;", "E0", "()Lio/ktor/utils/io/core/BytePacketBuilder;", "writable", "Lio/ktor/utils/io/core/ByteReadPacket;", "D0", "()Lio/ktor/utils/io/core/ByteReadPacket;", "readable", "Lio/ktor/utils/io/internal/AwaitingSlot;", "Lio/ktor/utils/io/internal/AwaitingSlot;", "slot", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "f", "Ljava/lang/Object;", "flushMutex", "g", "flushBuffer", "F0", "isCancelled", "<anonymous parameter 0>", "A0", "setClosed", "(Z)V", "closed", "()I", "availableForRead", "z0", "availableForWrite", "Q", "isClosedForRead", "isClosedForWrite", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "closedCause", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nByteChannelSequential.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannelSequential.kt\nio/ktor/utils/io/ByteChannelSequentialBase\n+ 2 AtomicFU.kt\nkotlinx/atomicfu/AtomicInt\n+ 3 AtomicFU.kt\nkotlinx/atomicfu/AtomicRef\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 6 Packet.kt\nio/ktor/utils/io/core/PacketKt\n*L\n1#1,855:1\n207#2,3:856\n302#2,2:874\n302#2,2:876\n295#2,2:878\n87#3,3:859\n1#4:862\n69#5:863\n69#5:864\n74#5:867\n74#5:868\n74#5:869\n69#5:870\n69#5:873\n43#6:865\n43#6:866\n43#6:871\n39#6:872\n*S KotlinDebug\n*F\n+ 1 ByteChannelSequential.kt\nio/ktor/utils/io/ByteChannelSequentialBase\n*L\n42#1:856,3\n838#1:874,2\n840#1:876,2\n849#1:878,2\n43#1:859,3\n194#1:863\n229#1:864\n483#1:867\n493#1:868\n504#1:869\n576#1:870\n651#1:873\n293#1:865\n315#1:866\n602#1:871\n640#1:872\n*E\n"})
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {
    public static final /* synthetic */ AtomicLongFieldUpdater h;
    public static final /* synthetic */ AtomicLongFieldUpdater i;
    public static final /* synthetic */ AtomicIntegerFieldUpdater j;
    public static final /* synthetic */ AtomicIntegerFieldUpdater k;
    public static final /* synthetic */ AtomicReferenceFieldUpdater l;
    @NotNull
    private volatile /* synthetic */ int _availableForRead;
    @NotNull
    private volatile /* synthetic */ Object _closed;
    @NotNull
    private volatile /* synthetic */ Object _lastReadView;
    @NotNull
    private volatile /* synthetic */ long _totalBytesRead;
    @NotNull
    private volatile /* synthetic */ long _totalBytesWritten;
    public final boolean b;
    public final BytePacketBuilder c;
    @NotNull
    private volatile /* synthetic */ int channelSize;
    public final ByteReadPacket d;
    public final AwaitingSlot e;
    public final Object f;
    public final BytePacketBuilder g;
    @NotNull
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    @NotNull
    private volatile /* synthetic */ Object lastReadView$delegate;

    static {
        Class<ByteChannelSequentialBase> cls = ByteChannelSequentialBase.class;
        h = AtomicLongFieldUpdater.newUpdater(cls, "_totalBytesRead");
        i = AtomicLongFieldUpdater.newUpdater(cls, "_totalBytesWritten");
        j = AtomicIntegerFieldUpdater.newUpdater(cls, "_availableForRead");
        k = AtomicIntegerFieldUpdater.newUpdater(cls, "channelSize");
        l = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_closed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object A1(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L_0x005c
        L_0x0038:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L_0x0049:
            if (r8 >= r5) goto L_0x0070
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r9 = r6.l0(r3, r0)
            if (r9 != r1) goto L_0x005c
            return r1
        L_0x005c:
            int r9 = r6.z0()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r6.c
            io.ktor.utils.io.core.OutputKt.b(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.i0(r9)
            goto L_0x0049
        L_0x0070:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.A1(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object B1(io.ktor.utils.io.ByteChannelSequentialBase r5, java.nio.ByteBuffer r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r4
            goto L_0x0058
        L_0x003a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0045:
            if (r7 >= r8) goto L_0x006c
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r5.l0(r3, r0)
            if (r9 != r1) goto L_0x0058
            return r1
        L_0x0058:
            int r9 = r5.z0()
            int r2 = r8 - r7
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r5.c
            io.ktor.utils.io.core.OutputKt.e(r2, r6, r7, r9)
            int r7 = r7 + r9
            r5.i0(r9)
            goto L_0x0045
        L_0x006c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.B1(io.ktor.utils.io.ByteChannelSequentialBase, java.nio.ByteBuffer, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object C1(io.ktor.utils.io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.l0(r3, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.c
            io.ktor.utils.io.core.OutputPrimitivesKt.c(r7, r6)
            r5.i0(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.C1(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object D1(io.ktor.utils.io.ByteChannelSequentialBase r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            long r6 = r0.J$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0049
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.l0(r3, r0)
            if (r8 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.c
            io.ktor.utils.io.core.OutputPrimitivesKt.e(r8, r6)
            r5.i0(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.D1(io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.core.ByteReadPacket} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object E1(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.l0(r3, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            long r0 = r5.r0()
            int r6 = (int) r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.c
            r0.r0(r5)
            r4.i0(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.E1(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object F1(io.ktor.utils.io.ByteChannelSequentialBase r5, short r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            short r6 = r0.S$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.S$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.l0(r3, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.c
            short r6 = (short) r6
            io.ktor.utils.io.core.OutputPrimitivesKt.g(r7, r6)
            r5.i0(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.F1(io.ktor.utils.io.ByteChannelSequentialBase, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object G1(ByteChannelSequentialBase byteChannelSequentialBase, Function2 function2, Continuation continuation) {
        Object invoke = function2.invoke(byteChannelSequentialBase.L(), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object J0(io.ktor.utils.io.ByteChannelSequentialBase r4, byte[] r5, int r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            int r7 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r4 = r0.L$1
            r5 = r4
            byte[] r5 = (byte[]) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0078
        L_0x0036:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Throwable r8 = r4.f()
            if (r8 != 0) goto L_0x009c
            boolean r8 = r4.A0()
            if (r8 == 0) goto L_0x0059
            int r8 = r4.i()
            if (r8 != 0) goto L_0x0059
            r4 = -1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        L_0x0059:
            if (r7 != 0) goto L_0x0061
            r4 = 0
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        L_0x0061:
            int r8 = r4.i()
            if (r8 != 0) goto L_0x0078
            r0.L$0 = r4
            r0.L$1 = r5
            r0.I$0 = r6
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r8 = r4.o0(r3, r0)
            if (r8 != r1) goto L_0x0078
            return r1
        L_0x0078:
            io.ktor.utils.io.core.ByteReadPacket r8 = r4.d
            boolean r8 = r8.g()
            if (r8 != 0) goto L_0x0083
            r4.G0()
        L_0x0083:
            long r7 = (long) r7
            io.ktor.utils.io.core.ByteReadPacket r0 = r4.d
            long r0 = r0.r0()
            long r7 = java.lang.Math.min(r7, r0)
            int r7 = (int) r7
            io.ktor.utils.io.core.ByteReadPacket r8 = r4.d
            io.ktor.utils.io.core.InputArraysKt.e(r8, r5, r6, r7)
            r4.h0(r7)
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r4
        L_0x009c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.J0(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object L0(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.d.g()) {
            return byteChannelSequentialBase.M0(continuation);
        }
        boolean z = byteChannelSequentialBase.d.readByte() == 1;
        byteChannelSequentialBase.h0(1);
        return Boxing.boxBoolean(z);
    }

    public static /* synthetic */ Object N0(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!(!byteChannelSequentialBase.d.c0())) {
            return byteChannelSequentialBase.O0(continuation);
        }
        byte readByte = byteChannelSequentialBase.d.readByte();
        byteChannelSequentialBase.h0(1);
        return Boxing.boxByte(readByte);
    }

    public static /* synthetic */ Object P0(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.d.y0(8)) {
            return byteChannelSequentialBase.Q0(continuation);
        }
        double a2 = InputPrimitivesKt.a(byteChannelSequentialBase.d);
        byteChannelSequentialBase.h0(8);
        return Boxing.boxDouble(a2);
    }

    public static /* synthetic */ Object R0(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.d.y0(4)) {
            return byteChannelSequentialBase.S0(continuation);
        }
        float c2 = InputPrimitivesKt.c(byteChannelSequentialBase.d);
        byteChannelSequentialBase.h0(4);
        return Boxing.boxFloat(c2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object U0(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFully$6) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0077
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.D(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != r8) goto L_0x0064
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0064:
            r2 = -1
            if (r9 == r2) goto L_0x007a
            int r7 = r7 + r9
            int r8 = r8 - r9
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r5 = r5.W0(r6, r7, r8, r0)
            if (r5 != r1) goto L_0x0077
            return r1
        L_0x0077:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x007a:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.String r6 = "Unexpected end of stream"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.U0(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object X0(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.d.y0(4)) {
            return byteChannelSequentialBase.Y0(continuation);
        }
        int e2 = InputPrimitivesKt.e(byteChannelSequentialBase.d);
        byteChannelSequentialBase.h0(4);
        return Boxing.boxInt(e2);
    }

    public static /* synthetic */ Object Z0(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.d.y0(8)) {
            return byteChannelSequentialBase.a1(continuation);
        }
        long g2 = InputPrimitivesKt.g(byteChannelSequentialBase.d);
        byteChannelSequentialBase.h0(8);
        return Boxing.boxLong(g2);
    }

    public static /* synthetic */ Object b1(ByteChannelSequentialBase byteChannelSequentialBase, int i2, Continuation continuation) {
        q0(byteChannelSequentialBase, i2, (BytePacketBuilder) null, 2, (Object) null);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        int min = (int) Math.min((long) i2, byteChannelSequentialBase.d.r0());
        int i3 = i2 - min;
        bytePacketBuilder.y0(byteChannelSequentialBase.d, min);
        byteChannelSequentialBase.h0(min);
        byteChannelSequentialBase.p0(i3, bytePacketBuilder);
        return i3 > 0 ? byteChannelSequentialBase.c1(bytePacketBuilder, i3, continuation) : bytePacketBuilder.F0();
    }

    public static /* synthetic */ Object d1(ByteChannelSequentialBase byteChannelSequentialBase, long j2, Continuation continuation) {
        byteChannelSequentialBase.v0();
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        long min = Math.min(j2, byteChannelSequentialBase.d.r0());
        bytePacketBuilder.z0(byteChannelSequentialBase.d, min);
        byteChannelSequentialBase.h0((int) min);
        if (j2 - ((long) bytePacketBuilder.G0()) != 0 && !byteChannelSequentialBase.Q()) {
            return byteChannelSequentialBase.e1(bytePacketBuilder, j2, continuation);
        }
        byteChannelSequentialBase.w0(bytePacketBuilder);
        return bytePacketBuilder.F0();
    }

    public static /* synthetic */ Object f1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.d.y0(2)) {
            return byteChannelSequentialBase.g1(continuation);
        }
        short i2 = InputPrimitivesKt.i(byteChannelSequentialBase.d);
        byteChannelSequentialBase.h0(2);
        return Boxing.boxShort(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object i1(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0045
        L_0x002d:
            r5 = move-exception
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r4.r0()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x004b:
            r4.r0()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.i1(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object j0(ByteChannelSequentialBase byteChannelSequentialBase, int i2, Continuation continuation) {
        if (i2 >= 0) {
            long j2 = (long) i2;
            if (j2 <= 4088) {
                byteChannelSequentialBase.r0();
                return i2 == 0 ? Boxing.boxBoolean(!byteChannelSequentialBase.Q()) : byteChannelSequentialBase.d.r0() >= j2 ? Boxing.boxBoolean(true) : byteChannelSequentialBase.o0(i2, continuation);
            }
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i2).toString());
        }
        throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i2).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object j1(io.ktor.utils.io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004b
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.k1(r7, r6, r0)
            if (r5 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x004b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L_0x0055
            r5 = 0
            return r5
        L_0x0055:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.j1(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object l1(ByteChannelSequentialBase byteChannelSequentialBase, Appendable appendable, int i2, Continuation continuation) {
        if (!byteChannelSequentialBase.Q()) {
            return UTF8Kt.b(appendable, i2, new ByteChannelSequentialBase$readUTF8LineTo$2(byteChannelSequentialBase, (Continuation<? super ByteChannelSequentialBase$readUTF8LineTo$2>) null), new ByteChannelSequentialBase$readUTF8LineTo$3(byteChannelSequentialBase), continuation);
        }
        Throwable f2 = byteChannelSequentialBase.f();
        if (f2 == null) {
            return Boxing.boxBoolean(false);
        }
        throw f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object m0(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.flush()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.l0(r3, r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r4.u0()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.m0(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void q0(ByteChannelSequentialBase byteChannelSequentialBase, int i2, BytePacketBuilder bytePacketBuilder, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bytePacketBuilder = null;
            }
            byteChannelSequentialBase.p0(i2, bytePacketBuilder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
    }

    public static /* synthetic */ Object s0(ByteChannelSequentialBase byteChannelSequentialBase, long j2, Continuation continuation) {
        long n = byteChannelSequentialBase.d.n(j2);
        byteChannelSequentialBase.h0((int) n);
        if (n != j2 && !byteChannelSequentialBase.Q()) {
            return byteChannelSequentialBase.t0(j2, n, continuation);
        }
        byteChannelSequentialBase.v0();
        return Boxing.boxLong(n);
    }

    public static /* synthetic */ Object s1(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation continuation) {
        int k2 = chunkBuffer.k() - chunkBuffer.i();
        if (k2 == 0) {
            return Boxing.boxInt(0);
        }
        int min = Math.min(k2, byteChannelSequentialBase.z0());
        if (min == 0) {
            return byteChannelSequentialBase.u1(chunkBuffer, continuation);
        }
        OutputKt.a(byteChannelSequentialBase.c, chunkBuffer, min);
        byteChannelSequentialBase.i0(min);
        return Boxing.boxInt(min);
    }

    public static /* synthetic */ Object t1(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i2, int i3, Continuation continuation) {
        if (i3 == 0) {
            return Boxing.boxInt(0);
        }
        int min = Math.min(i3, byteChannelSequentialBase.z0());
        if (min == 0) {
            return byteChannelSequentialBase.v1(bArr, i2, i3, continuation);
        }
        OutputKt.b(byteChannelSequentialBase.c, bArr, i2, min);
        byteChannelSequentialBase.i0(min);
        return Boxing.boxInt(min);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object w1(io.ktor.utils.io.ByteChannelSequentialBase r4, byte r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            byte r5 = r0.B$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.B$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.l0(r3, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            io.ktor.utils.io.core.BytePacketBuilder r6 = r4.c
            byte r5 = (byte) r5
            r6.i0(r5)
            r4.i0(r3)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.w1(io.ktor.utils.io.ByteChannelSequentialBase, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object x1(io.ktor.utils.io.ByteChannelSequentialBase r5, double r6, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            double r6 = r0.D$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0049
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.D$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.l0(r3, r0)
            if (r8 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.c
            io.ktor.utils.io.core.OutputPrimitivesKt.a(r8, r6)
            r5.i0(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.x1(io.ktor.utils.io.ByteChannelSequentialBase, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object y1(io.ktor.utils.io.ByteChannelSequentialBase r5, float r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            float r6 = r0.F$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.F$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.l0(r3, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.c
            io.ktor.utils.io.core.OutputPrimitivesKt.b(r7, r6)
            r5.i0(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.y1(io.ktor.utils.io.ByteChannelSequentialBase, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.core.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object z1(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.l0(r3, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            int r6 = r5.k()
            int r0 = r5.i()
            int r6 = r6 - r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.c
            r1 = 2
            r2 = 0
            r3 = 0
            io.ktor.utils.io.core.OutputKt.c(r0, r5, r3, r1, r2)
            r4.i0(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.z1(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object A(long j2, Continuation continuation) {
        return d1(this, j2, continuation);
    }

    public final boolean A0() {
        return this._closed != null;
    }

    public Object B(Continuation continuation) {
        return P0(this, continuation);
    }

    public final int B0() {
        return this.lastReadAvailable$delegate;
    }

    public Object C(byte b2, Continuation continuation) {
        return w1(this, b2, continuation);
    }

    public final ChunkBuffer C0() {
        return (ChunkBuffer) this.lastReadView$delegate;
    }

    public Object D(byte[] bArr, int i2, int i3, Continuation continuation) {
        return J0(this, bArr, i2, i3, continuation);
    }

    public final ByteReadPacket D0() {
        return this.d;
    }

    public Object E(Continuation continuation) {
        return Z0(this, continuation);
    }

    public final BytePacketBuilder E0() {
        return this.c;
    }

    public Object F(Function2 function2, Continuation continuation) {
        return G1(this, function2, continuation);
    }

    public final boolean F0() {
        CloseElement closeElement = (CloseElement) this._closed;
        return (closeElement != null ? closeElement.a() : null) != null;
    }

    public Object G(Continuation continuation) {
        return f1(this, continuation);
    }

    public final void G0() {
        synchronized (this.f) {
            UnsafeKt.e(this.d, this.g);
        }
    }

    public Object H(long j2, Continuation continuation) {
        return D1(this, j2, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.core.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H0(io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0079
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Throwable r6 = r4.f()
            if (r6 != 0) goto L_0x00a6
            boolean r6 = r4.A0()
            if (r6 == 0) goto L_0x0055
            int r6 = r4.i()
            if (r6 != 0) goto L_0x0055
            r4 = -1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        L_0x0055:
            int r6 = r5.g()
            int r2 = r5.k()
            int r6 = r6 - r2
            if (r6 != 0) goto L_0x0066
            r4 = 0
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        L_0x0066:
            int r6 = r4.i()
            if (r6 != 0) goto L_0x0079
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.o0(r3, r0)
            if (r6 != r1) goto L_0x0079
            return r1
        L_0x0079:
            io.ktor.utils.io.core.ByteReadPacket r6 = r4.d
            boolean r6 = r6.g()
            if (r6 != 0) goto L_0x0084
            r4.G0()
        L_0x0084:
            int r6 = r5.g()
            int r0 = r5.k()
            int r6 = r6 - r0
            long r0 = (long) r6
            io.ktor.utils.io.core.ByteReadPacket r6 = r4.d
            long r2 = r6.r0()
            long r0 = java.lang.Math.min(r0, r2)
            int r6 = (int) r0
            io.ktor.utils.io.core.ByteReadPacket r0 = r4.d
            io.ktor.utils.io.core.InputArraysKt.d(r0, r5, r6)
            r4.h0(r6)
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r4
        L_0x00a6:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.H0(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object I(byte[] bArr, int i2, int i3, Continuation continuation) {
        return A1(this, bArr, i2, i3, continuation);
    }

    public Object K0(Continuation continuation) {
        return L0(this, continuation);
    }

    public WriterSuspendSession L() {
        return new ByteChannelSequentialBase$beginWriteSession$1(this);
    }

    public Object M(Buffer buffer, Continuation continuation) {
        return z1(this, buffer, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:18:0x0056, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object M0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0059
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.o0(r4, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = 0
            q0(r5, r4, r6, r3, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r5.K0(r0)
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.M0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object N(int i2, Continuation continuation) {
        return j1(this, i2, continuation);
    }

    public Object O(int i2, Continuation continuation) {
        return C1(this, i2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object O0(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
        L_0x0038:
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.o0(r3, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            io.ktor.utils.io.core.ByteReadPacket r5 = r4.d
            boolean r5 = r5.c0()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x005d
            io.ktor.utils.io.core.ByteReadPacket r5 = r4.d
            byte r5 = r5.readByte()
            java.lang.Byte r5 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r5)
            r5.byteValue()
            r4.h0(r3)
            return r5
        L_0x005d:
            r5 = 2
            r2 = 0
            q0(r4, r3, r2, r5, r2)
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.O0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void P() {
        r0();
    }

    public boolean Q() {
        return F0() || (A0() && this.channelSize == 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Q0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.o0(r3, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            io.ktor.utils.io.core.ByteReadPacket r6 = r5.d
            double r0 = io.ktor.utils.io.core.InputPrimitivesKt.a(r6)
            r5.h0(r3)
            java.lang.Double r5 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Q0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object S0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.o0(r3, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            io.ktor.utils.io.core.ByteReadPacket r6 = r5.d
            float r6 = io.ktor.utils.io.core.InputPrimitivesKt.c(r6)
            r5.h0(r3)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.S0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object T0(Buffer buffer, int i2, Continuation continuation) {
        if (i2 > buffer.g() - buffer.k()) {
            throw new IllegalArgumentException(("Not enough space in the destination buffer to write " + i2 + " bytes").toString());
        } else if (i2 < 0) {
            throw new IllegalArgumentException("n shouldn't be negative".toString());
        } else if (f() != null) {
            Throwable f2 = f();
            Intrinsics.checkNotNull(f2);
            throw f2;
        } else if (this.d.r0() >= ((long) i2)) {
            InputArraysKt.d(this.d, buffer, i2);
            Unit unit = Unit.INSTANCE;
            h0(i2);
            return Unit.INSTANCE;
        } else if (!A0()) {
            Object V0 = V0(buffer, i2, continuation);
            return V0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? V0 : Unit.INSTANCE;
        } else {
            throw new EOFException("Channel is closed and not enough bytes available: required " + i2 + " but " + i() + " available");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: io.ktor.utils.io.core.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object V0(io.ktor.utils.io.core.Buffer r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0055
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.o0(r7, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r5 = r5.T0(r6, r7, r0)
            if (r5 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.V0(io.ktor.utils.io.core.Buffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object W0(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            int r7 = r0.I$2
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r5 = r0
            r0 = r8
            r8 = r2
            r2 = r5
            r6 = r10
            r10 = r9
            r9 = r6
            goto L_0x006d
        L_0x003e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r5 = r8
            r8 = r7
            r7 = r11
            r11 = r10
            r10 = r9
            r9 = r5
        L_0x0050:
            if (r7 >= r11) goto L_0x0082
            int r2 = r10 + r7
            int r4 = r11 - r7
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r7
            r0.label = r3
            java.lang.Object r2 = r8.D(r9, r2, r4, r0)
            if (r2 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r5 = r0
            r0 = r11
            r11 = r2
            r2 = r5
        L_0x006d:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r4 = -1
            if (r11 == r4) goto L_0x007a
            int r7 = r7 + r11
            r11 = r0
            r0 = r2
            goto L_0x0050
        L_0x007a:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r8 = "Unexpected end of stream"
            r7.<init>(r8)
            throw r7
        L_0x0082:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.W0(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Y0(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.o0(r3, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            io.ktor.utils.io.core.ByteReadPacket r6 = r5.d
            int r6 = io.ktor.utils.io.core.InputPrimitivesKt.e(r6)
            r5.h0(r3)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Y0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public ChunkBuffer a(int i2) {
        Throwable f2 = f();
        if (f2 == null) {
            r0();
            return m1(i2);
        }
        throw f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a1(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.o0(r3, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            io.ktor.utils.io.core.ByteReadPacket r6 = r5.d
            long r0 = io.ktor.utils.io.core.InputPrimitivesKt.g(r6)
            r5.h0(r3)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.a1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object b(int i2, Continuation continuation) {
        return j0(this, i2, continuation);
    }

    public void c(int i2) {
        this.c.b();
        i0(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c1(io.ktor.utils.io.core.BytePacketBuilder r10, int r11, kotlin.coroutines.Continuation r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r10 = (io.ktor.utils.io.core.BytePacketBuilder) r10
            java.lang.Object r11 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r11 = (io.ktor.utils.io.ByteChannelSequentialBase) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r9
            r9 = r8
            goto L_0x0041
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x0041:
            if (r11 <= 0) goto L_0x006c
            long r4 = (long) r11
            io.ktor.utils.io.core.ByteReadPacket r12 = r9.d
            long r6 = r12.r0()
            long r4 = java.lang.Math.min(r4, r6)
            int r12 = (int) r4
            int r11 = r11 - r12
            io.ktor.utils.io.core.ByteReadPacket r2 = r9.d
            r10.y0(r2, r12)
            r9.h0(r12)
            r9.p0(r11, r10)
            if (r11 <= 0) goto L_0x0041
            r0.L$0 = r9
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r12 = r9.o0(r3, r0)
            if (r12 != r1) goto L_0x0041
            return r1
        L_0x006c:
            r9.p0(r11, r10)
            io.ktor.utils.io.core.ByteReadPacket r9 = r10.F0()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.c1(io.ktor.utils.io.core.BytePacketBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public SuspendableReadSession d() {
        return this;
    }

    public boolean e(Throwable th) {
        if (f() != null || A0()) {
            return false;
        }
        if (th == null) {
            th = new CancellationException("Channel cancelled");
        }
        return h(th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e1(io.ktor.utils.io.core.BytePacketBuilder r11, long r12, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r12 = (io.ktor.utils.io.core.BytePacketBuilder) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r13 = (io.ktor.utils.io.ByteChannelSequentialBase) r13
            kotlin.ResultKt.throwOnFailure(r14)
            r8 = r10
            r11 = r12
            r10 = r13
            r12 = r8
            goto L_0x0042
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x0042:
            int r14 = r11.G0()
            long r4 = (long) r14
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0085
            int r14 = r11.G0()
            long r4 = (long) r14
            long r4 = r12 - r4
            io.ktor.utils.io.core.ByteReadPacket r14 = r10.d
            long r6 = r14.r0()
            long r4 = java.lang.Math.min(r4, r6)
            io.ktor.utils.io.core.ByteReadPacket r14 = r10.d
            r11.z0(r14, r4)
            int r14 = (int) r4
            r10.h0(r14)
            r10.w0(r11)
            boolean r14 = r10.Q()
            if (r14 != 0) goto L_0x0085
            int r14 = r11.G0()
            int r2 = (int) r12
            if (r14 != r2) goto L_0x0076
            goto L_0x0085
        L_0x0076:
            r0.L$0 = r10
            r0.L$1 = r11
            r0.J$0 = r12
            r0.label = r3
            java.lang.Object r14 = r10.o0(r3, r0)
            if (r14 != r1) goto L_0x0042
            return r1
        L_0x0085:
            r10.w0(r11)
            io.ktor.utils.io.core.ByteReadPacket r10 = r11.F0()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.e1(io.ktor.utils.io.core.BytePacketBuilder, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Throwable f() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.a();
        }
        return null;
    }

    public final void f0(int i2) {
        if (i2 >= 0) {
            int i3 = -i2;
            k.getAndAdd(this, i3);
            h.addAndGet(this, (long) i2);
            j.getAndAdd(this, i3);
            if (this.channelSize < 0) {
                throw new IllegalStateException(("Readable bytes count is negative: " + i() + ", " + i2 + " in " + this).toString());
            } else if (i() < 0) {
                throw new IllegalStateException(("Readable bytes count is negative: " + i() + ", " + i2 + " in " + this).toString());
            }
        } else {
            throw new IllegalArgumentException(("Can't read negative amount of bytes: " + i2).toString());
        }
    }

    public void flush() {
        x0();
    }

    public boolean g() {
        return A0();
    }

    public final void g0(int i2) {
        if (i2 >= 0) {
            k.getAndAdd(this, i2);
            i.addAndGet(this, (long) i2);
            if (this.channelSize < 0) {
                throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + i2 + " in " + this).toString());
            }
            return;
        }
        throw new IllegalArgumentException(("Can't write negative amount of bytes: " + i2).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g1(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.o0(r3, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            io.ktor.utils.io.core.ByteReadPacket r6 = r5.d
            short r6 = io.ktor.utils.io.core.InputPrimitivesKt.i(r6)
            r5.h0(r3)
            short r5 = (short) r6
            java.lang.Short r5 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.g1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean h(Throwable th) {
        if (!a.a(l, this, (Object) null, th == null ? CloseElementKt.a() : new CloseElement(th))) {
            return false;
        }
        if (th != null) {
            this.d.release();
            this.c.release();
            this.g.release();
        } else {
            flush();
            this.c.release();
        }
        this.e.b(th);
        return true;
    }

    public final void h0(int i2) {
        f0(i2);
        this.e.c();
    }

    public Object h1(Function2 function2, Continuation continuation) {
        return i1(this, function2, continuation);
    }

    public int i() {
        return this._availableForRead;
    }

    public final void i0(int i2) {
        g0(i2);
        if (A0()) {
            this.c.release();
            u0();
        }
        if (z() || z0() == 0) {
            flush();
        }
    }

    public Object j(int i2, Continuation continuation) {
        return b1(this, i2, continuation);
    }

    public Object k(long j2, Continuation continuation) {
        return s0(this, j2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k0(int r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L_0x003d
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x003d:
            int r7 = r5.i()
            if (r7 >= r6) goto L_0x005d
            boolean r7 = r5.Q()
            if (r7 != 0) goto L_0x005d
            io.ktor.utils.io.internal.AwaitingSlot r7 = r5.e
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
            r2.<init>(r5, r6)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.d(r2, r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x005d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.k0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object k1(Appendable appendable, int i2, Continuation continuation) {
        return l1(this, appendable, i2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l0(int r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r6 = (io.ktor.utils.io.ByteChannelSequentialBase) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L_0x003d
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x003d:
            int r7 = r5.z0()
            if (r7 >= r6) goto L_0x0063
            boolean r7 = r5.A0()
            if (r7 != 0) goto L_0x0063
            boolean r7 = r5.x0()
            if (r7 != 0) goto L_0x003d
            io.ktor.utils.io.internal.AwaitingSlot r7 = r5.e
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2
            r2.<init>(r5, r6)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.d(r2, r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x0063:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.l0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ChunkBuffer m1(int i2) {
        if (this.d.c0()) {
            G0();
        }
        ChunkBuffer E0 = this.d.E0(i2);
        if (E0 == null) {
            o1(ChunkBuffer.j.a());
            n1(0);
        } else {
            o1(E0);
            n1(E0.k() - E0.i());
        }
        return E0;
    }

    public Object n(Continuation continuation) {
        return X0(this, continuation);
    }

    public final Object n0(Continuation continuation) {
        return this.d.c0() ^ true ? Boxing.boxBoolean(true) : o0(1, continuation);
    }

    public final void n1(int i2) {
        this.lastReadAvailable$delegate = i2;
    }

    public Object o(Continuation continuation) {
        return R0(this, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o0(int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 < 0) goto L_0x0066
            r0.L$0 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.k0(r5, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r4.G0()
            java.lang.Throwable r6 = r4.f()
            if (r6 != 0) goto L_0x0065
            boolean r6 = r4.Q()
            if (r6 != 0) goto L_0x005f
            int r4 = r4.i()
            if (r4 < r5) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r3 = 0
        L_0x0060:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L_0x0065:
            throw r6
        L_0x0066:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Failed requirement."
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.o0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void o1(ChunkBuffer chunkBuffer) {
        this.lastReadView$delegate = chunkBuffer;
    }

    public Object p(byte[] bArr, int i2, int i3, Continuation continuation) {
        return U0(this, bArr, i2, i3, continuation);
    }

    public final void p0(int i2, BytePacketBuilder bytePacketBuilder) {
        Throwable f2 = f();
        if (f2 != null) {
            if (bytePacketBuilder != null) {
                bytePacketBuilder.close();
            }
            throw f2;
        } else if (A0() && i() < i2) {
            if (bytePacketBuilder != null) {
                bytePacketBuilder.close();
            }
            throw new EOFException(i2 + " bytes required but EOF reached");
        }
    }

    public final long p1(ByteChannelSequentialBase byteChannelSequentialBase, long j2) {
        Intrinsics.checkNotNullParameter(byteChannelSequentialBase, "dst");
        long r0 = this.d.r0();
        if (r0 > j2) {
            return 0;
        }
        byteChannelSequentialBase.c.r0(this.d);
        int i2 = (int) r0;
        byteChannelSequentialBase.i0(i2);
        h0(i2);
        return r0;
    }

    public Object q(Continuation continuation) {
        return N0(this, continuation);
    }

    public Object q1(ChunkBuffer chunkBuffer, Continuation continuation) {
        return s1(this, chunkBuffer, continuation);
    }

    public int r(int i2) {
        Throwable f2 = f();
        if (f2 != null) {
            throw f2;
        } else if (i2 == 0) {
            return 0;
        } else {
            int j2 = this.d.j(i2);
            h0(i2);
            m1(1);
            return j2;
        }
    }

    public final void r0() {
        ChunkBuffer C0 = C0();
        int B0 = B0() - (C0.k() - C0.i());
        if (C0() != Buffer.g.a()) {
            UnsafeKt.a(this.d, C0());
        }
        if (B0 > 0) {
            h0(B0);
        }
        n1(0);
        o1(ChunkBuffer.j.a());
    }

    public Object r1(byte[] bArr, int i2, int i3, Continuation continuation) {
        return t1(this, bArr, i2, i3, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(java.nio.ByteBuffer r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation r28) {
        /*
            r18 = this;
            r0 = r18
            r1 = r28
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = (io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0060
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
            r1.<init>()
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2
            r17 = 0
            r6 = r4
            r7 = r24
            r9 = r22
            r11 = r1
            r12 = r26
            r14 = r19
            r15 = r20
            r6.<init>(r7, r9, r11, r12, r14, r15, r17)
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r0 = r0.h1(r4, r2)
            if (r0 != r3) goto L_0x005f
            return r3
        L_0x005f:
            r0 = r1
        L_0x0060:
            long r0 = r0.element
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.s(java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object t(short s, Continuation continuation) {
        return F1(this, s, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (r8.Q() == false) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t0(long r9, long r11, kotlin.coroutines.Continuation r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            r0.<init>(r8, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            long r8 = r0.J$1
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r12 = (io.ktor.utils.io.ByteChannelSequentialBase) r12
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
            goto L_0x004f
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r13)
        L_0x0040:
            r0.L$0 = r8
            r0.J$0 = r9
            r0.J$1 = r11
            r0.label = r3
            java.lang.Object r13 = r8.b(r3, r0)
            if (r13 != r1) goto L_0x004f
            return r1
        L_0x004f:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x006e
            io.ktor.utils.io.core.ByteReadPacket r13 = r8.d
            long r4 = r9 - r11
            long r4 = r13.n(r4)
            int r13 = (int) r4
            r8.h0(r13)
            long r11 = r11 + r4
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x006e
            boolean r13 = r8.Q()
            if (r13 == 0) goto L_0x0040
        L_0x006e:
            r8.v0()
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.t0(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void u0() {
        if (A0()) {
            Throwable f2 = f();
            if (f2 == null) {
                f2 = new ClosedWriteChannelException("Channel " + this + " is already closed");
            }
            throw f2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v4 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x005c, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u1(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1
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
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
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
            java.lang.Object r7 = r5.q1(r6, r0)
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x005f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.u1(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object v(ChunkBuffer chunkBuffer, Continuation continuation) {
        return Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
    }

    public final void v0() {
        Throwable f2 = f();
        if (f2 != null) {
            throw f2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v4 java.lang.Object), (r9v1 java.lang.Object) binds: [B:18:0x0064, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v1(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.l0(r4, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r5.r1(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0067:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.v1(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object w(ByteReadPacket byteReadPacket, Continuation continuation) {
        return E1(this, byteReadPacket, continuation);
    }

    public final void w0(BytePacketBuilder bytePacketBuilder) {
        Throwable f2 = f();
        if (f2 != null) {
            bytePacketBuilder.release();
            throw f2;
        }
    }

    public final boolean x0() {
        if (this.c.H0()) {
            this.e.c();
            return false;
        }
        y0();
        this.e.c();
        return true;
    }

    public final void y0() {
        synchronized (this.f) {
            int G0 = this.c.G0();
            ChunkBuffer f0 = this.c.f0();
            Intrinsics.checkNotNull(f0);
            this.g.q0(f0);
            j.addAndGet(this, G0);
        }
    }

    public boolean z() {
        return this.b;
    }

    public int z0() {
        return Math.max(0, 4088 - this.channelSize);
    }
}
