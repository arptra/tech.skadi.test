package io.ktor.utils.io;

import com.here.posclient.UpdateOptions;
import com.honey.account.i.a;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import io.ktor.utils.io.internal.ClosedElement;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ReadSessionImpl;
import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.internal.RingBufferCapacity;
import io.ktor.utils.io.internal.WriteSessionImpl;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0010\u0018\u0000 Ô\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002¾\u0002B)\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\u0014*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\u00020\f*\u00020\u00102\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0010H\u0002¢\u0006\u0004\b*\u0010+J+\u0010/\u001a\u00020\f2\u0006\u0010)\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u00100J'\u00104\u001a\u00020\f2\u0006\u0010)\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u00105J#\u00107\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00102\u0006\u00106\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b7\u00108J#\u0010;\u001a\u00020\u00142\u0006\u0010)\u001a\u0002092\u0006\u0010:\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b;\u0010<J+\u0010=\u001a\u00020\u00142\u0006\u0010)\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J+\u0010?\u001a\u00020\f2\u0006\u0010)\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b?\u0010>J\u001b\u0010@\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010B\u001a\u00020\f2\u0006\u0010)\u001a\u000209H@ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ+\u0010I\u001a\u00020H2\u0006\u0010D\u001a\u00020\f2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u0014*\u00020\u00102\u0006\u0010:\u001a\u00020\fH\u0002¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u0014*\u00020\u0010H\u0002¢\u0006\u0004\bM\u0010\u0012J#\u0010Q\u001a\u00020\u0014*\u00020\u00102\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\fH\u0002¢\u0006\u0004\bQ\u0010RJ#\u0010S\u001a\u00020\u0014*\u00020\u00102\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\fH\u0002¢\u0006\u0004\bS\u0010RJ!\u0010V\u001a\u0004\u0018\u00010\u00002\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u001fH\u0002¢\u0006\u0004\bV\u0010WJ\u001b\u0010Y\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\bY\u0010AJ\u001b\u0010Z\u001a\u00020\f2\u0006\u0010X\u001a\u000209H@ø\u0001\u0000¢\u0006\u0004\bZ\u0010CJ\u001b\u0010[\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\b[\u0010AJ\u001b\u0010\\\u001a\u00020\u00142\u0006\u0010X\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0004\b\\\u0010]J\u0013\u0010^\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b^\u0010_J+\u0010a\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u00002\u0006\u0010`\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0010H\u0002¢\u0006\u0004\be\u0010+J\u0017\u0010f\u001a\u00020\f2\u0006\u0010X\u001a\u00020,H\u0002¢\u0006\u0004\bf\u0010gJ'\u0010h\u001a\u00020\f2\u0006\u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\bh\u00105J+\u0010i\u001a\u00020\u00142\u0006\u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\bi\u0010>J+\u0010j\u001a\u00020\f2\u0006\u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\bj\u0010>J/\u0010n\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\f2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140lH@ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ#\u0010p\u001a\u00020\u00072\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070lH\u0002¢\u0006\u0004\bp\u0010qJ'\u0010r\u001a\u00020\u00142\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070lH@ø\u0001\u0000¢\u0006\u0004\br\u0010sJ3\u0010t\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00102\u0006\u0010O\u001a\u00020N2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070lH\u0002¢\u0006\u0004\bt\u0010uJ#\u0010x\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010.\u001a\u00020vH@ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ/\u0010z\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\f2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140lH@ø\u0001\u0000¢\u0006\u0004\bz\u0010oJ\u001b\u0010|\u001a\u00020\u00142\u0006\u0010{\u001a\u00020HH@ø\u0001\u0000¢\u0006\u0004\b|\u0010}J\u0017\u0010~\u001a\u00020\f2\u0006\u0010{\u001a\u00020HH\u0002¢\u0006\u0004\b~\u0010J\u001e\u0010\u0001\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J.\u0010\u0001\u001a\u00020\u00072\r\u0010\u0001\u001a\b0\u0001j\u0003`\u00012\u0007\u0010\u0001\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J.\u0010\u0001\u001a\u00020\u00072\r\u0010\u0001\u001a\b0\u0001j\u0003`\u00012\u0007\u0010\u0001\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020vH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020vH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\b\u0001\u0010\u001eJ\u0011\u0010\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\b\u0001\u0010\u001eJ\u001e\u0010\u0001\u001a\u00020\u00142\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J+\u0010\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020\f2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\fH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J*\u0010¡\u0001\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\f2\u000e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u0001H\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0012\u0010£\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u001a\u0010¥\u0001\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\nH\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0013\u0010¨\u0001\u001a\u00030§\u0001H\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0014\u0010ª\u0001\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J\u001c\u0010®\u0001\u001a\u00020\u00142\b\u0010­\u0001\u001a\u00030¬\u0001H\u0017¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001e\u0010°\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001e\u0010²\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0006\b²\u0001\u0010±\u0001J\u0011\u0010³\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\b³\u0001\u0010\u001eJ\"\u0010µ\u0001\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u00102\u0007\u0010´\u0001\u001a\u00020\fH\u0000¢\u0006\u0005\bµ\u0001\u0010LJ\u0013\u0010¶\u0001\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0005\b¶\u0001\u0010\u001cJ\u0011\u0010·\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0005\b·\u0001\u0010\u001eJ\u0012\u0010¸\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0006\b¸\u0001\u0010\u0001J-\u0010¹\u0001\u001a\u00020\u00142\u0006\u0010)\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0005\b¹\u0001\u0010>J\u001d\u0010º\u0001\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0005\bº\u0001\u0010AJ-\u0010»\u0001\u001a\u00020\f2\u0006\u0010)\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0005\b»\u0001\u0010>J\u001d\u0010¼\u0001\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0005\b¼\u0001\u0010AJ\u001d\u0010½\u0001\u001a\u00020\f2\u0006\u0010)\u001a\u000209H@ø\u0001\u0000¢\u0006\u0005\b½\u0001\u0010CJ\u001e\u0010¾\u0001\u001a\u00020H2\u0006\u0010D\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\b¾\u0001\u0010\u0001J\u0015\u0010¿\u0001\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0005\b¿\u0001\u0010_J\u0016\u0010Á\u0001\u001a\u00030À\u0001H@ø\u0001\u0000¢\u0006\u0005\bÁ\u0001\u0010_J\u0016\u0010Ã\u0001\u001a\u00030Â\u0001H@ø\u0001\u0000¢\u0006\u0005\bÃ\u0001\u0010_J\u0013\u0010:\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b:\u0010_J\u0015\u0010Ä\u0001\u001a\u00020vH@ø\u0001\u0000¢\u0006\u0005\bÄ\u0001\u0010_J\u0016\u0010Æ\u0001\u001a\u00030Å\u0001H@ø\u0001\u0000¢\u0006\u0005\bÆ\u0001\u0010_J\u0016\u0010È\u0001\u001a\u00030Ç\u0001H@ø\u0001\u0000¢\u0006\u0005\bÈ\u0001\u0010_J)\u0010É\u0001\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u00102\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\fH\u0000¢\u0006\u0005\bÉ\u0001\u0010RJ\u0012\u0010Ê\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J \u0010Í\u0001\u001a\u00020\u00142\b\u0010Ì\u0001\u001a\u00030À\u0001H@ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J \u0010Ð\u0001\u001a\u00020\u00142\b\u0010Ï\u0001\u001a\u00030Â\u0001H@ø\u0001\u0000¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001f\u0010Ó\u0001\u001a\u00020\u00142\u0007\u0010Ò\u0001\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\bÓ\u0001\u0010\u0001J\u001f\u0010Õ\u0001\u001a\u00020\u00142\u0007\u0010Ô\u0001\u001a\u00020vH@ø\u0001\u0000¢\u0006\u0006\bÕ\u0001\u0010\u0001J\u001d\u0010Ö\u0001\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0005\bÖ\u0001\u0010AJ\u001d\u0010×\u0001\u001a\u00020\f2\u0006\u0010X\u001a\u000209H@ø\u0001\u0000¢\u0006\u0005\b×\u0001\u0010CJ\u001d\u0010Ô\u0001\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0005\bÔ\u0001\u0010AJ\u001d\u0010Ø\u0001\u001a\u00020\u00142\u0006\u0010X\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0005\bØ\u0001\u0010]J1\u0010Ù\u0001\u001a\u00020v2\u0006\u0010X\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020v2\b\u0010 \u001a\u0004\u0018\u00010\u001fH@ø\u0001\u0000¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J-\u0010Û\u0001\u001a\u00020\u00142\u0006\u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0005\bÛ\u0001\u0010>J-\u0010Ü\u0001\u001a\u00020\f2\u0006\u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0005\bÜ\u0001\u0010>J.\u0010Ý\u0001\u001a\u00020\f2\u0006\u0010k\u001a\u00020\f2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140lH\u0016¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J1\u0010ß\u0001\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\f2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140lH@ø\u0001\u0000¢\u0006\u0005\bß\u0001\u0010oJ)\u0010à\u0001\u001a\u00020\u00142\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070lH@ø\u0001\u0000¢\u0006\u0005\bà\u0001\u0010sJ\u0013\u0010â\u0001\u001a\u00030á\u0001H\u0016¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u0011\u0010ä\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\bä\u0001\u0010\u001eJ\u0015\u0010æ\u0001\u001a\u0005\u0018\u00010å\u0001H\u0016¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u001a\u0010 \u0001\u001a\u00020\u00142\u0007\u0010è\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b \u0001\u0010\u0016J2\u0010ê\u0001\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\f2\u0013\u0010é\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140lH@ø\u0001\u0000¢\u0006\u0005\bê\u0001\u0010oJ\u001e\u0010ë\u0001\u001a\u00020v2\u0006\u0010.\u001a\u00020vH@ø\u0001\u0000¢\u0006\u0006\bë\u0001\u0010\u0001J\u001d\u0010ì\u0001\u001a\u00020\u00142\u0006\u0010{\u001a\u00020HH@ø\u0001\u0000¢\u0006\u0005\bì\u0001\u0010}JK\u0010ñ\u0001\u001a\u00028\u0000\"\u0005\b\u0000\u0010í\u00012,\u0010ð\u0001\u001a'\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010î\u0001¢\u0006\u0003\bï\u0001H@ø\u0001\u0000¢\u0006\u0006\bñ\u0001\u0010ò\u0001JE\u0010ó\u0001\u001a\u00020\u00142-\u0010ð\u0001\u001a(\b\u0001\u0012\u0005\u0012\u00030å\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00140\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010î\u0001¢\u0006\u0003\bï\u0001H@ø\u0001\u0000¢\u0006\u0006\bó\u0001\u0010ò\u0001J\u0019\u0010ô\u0001\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\fH\u0016¢\u0006\u0005\bô\u0001\u0010\u0016J\u001e\u0010Ì\u0001\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\bÌ\u0001\u0010\u0001J&\u0010÷\u0001\u001a\u0004\u0018\u00010\u00102\u0007\u0010õ\u0001\u001a\u00020\f2\u0007\u0010ö\u0001\u001a\u00020\fH\u0016¢\u0006\u0006\b÷\u0001\u0010ø\u0001J9\u0010ú\u0001\u001a\u00020\u0007\"\u000f\b\u0000\u0010ù\u0001*\b0\u0001j\u0003`\u00012\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010\u0001J\"\u0010ü\u0001\u001a\u0005\u0018\u00010û\u00012\u0007\u0010\u0001\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\bü\u0001\u0010\u0001J\u001f\u0010ù\u0001\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020vH@ø\u0001\u0000¢\u0006\u0006\bù\u0001\u0010\u0001J\u001e\u0010ý\u0001\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0006\bý\u0001\u0010\u0001JG\u0010Ï\u0001\u001a\u00020v2\b\u0010ÿ\u0001\u001a\u00030þ\u00012\u0007\u0010\u0002\u001a\u00020v2\u0006\u00102\u001a\u00020v2\u0006\u0010k\u001a\u00020v2\u0006\u0010.\u001a\u00020vH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\bÏ\u0001\u0010\u0002J\u0013\u0010\u0002\u001a\u00030û\u0001H\u0016¢\u0006\u0006\b\u0002\u0010\u0002R\u001e\u0010\b\u001a\u00020\u00078\u0016X\u0004¢\u0006\u0010\n\u0006\bÌ\u0001\u0010\u0002\u001a\u0006\b\u0002\u0010\u0001R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u0002R\u001e\u0010\r\u001a\u00020\f8\u0000X\u0004¢\u0006\u0010\n\u0006\bâ\u0001\u0010Û\u0001\u001a\u0006\b\u0002\u0010\u0002R\u0019\u0010U\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bU\u0010\u0002R\u0019\u0010\u0002\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010Û\u0001R\u0019\u0010\u0002\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010Û\u0001R\u001c\u0010\u0002\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R2\u0010\u0002\u001a\u00020v2\u0007\u0010\u0002\u001a\u00020v8\u0016@PX\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010®\u0001\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R2\u0010\u0002\u001a\u00020v2\u0007\u0010\u0002\u001a\u00020v8\u0016@PX\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010®\u0001\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001f\u0010\u0002\u001a\u00030\u00028\u0002X\u0004¢\u0006\u000f\n\u0006\b\u0002\u0010\u0002\u0012\u0005\b\u0002\u0010\u001eR\u0018\u0010\u0002\u001a\u00030\u00028\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010\u0002R\u001e\u0010¢\u0002\u001a\t\u0012\u0004\u0012\u00020\u00070 \u00028\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010¡\u0002R\u001e\u0010£\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140 \u00028\u0002X\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¡\u0002R\u0019\u0010¤\u0002\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010Û\u0001R+\u0010¦\u0002\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00140\u0001\u0012\u0005\u0012\u00030\u00010l8\u0002X\u0004¢\u0006\b\n\u0006\bë\u0001\u0010¥\u0002R\u0018\u0010¨\u0002\u001a\u00030§\u00018BX\u0004¢\u0006\b\u001a\u0006\b§\u0002\u0010©\u0001R0\u0010¯\u0002\u001a\u0005\u0018\u00010©\u00022\n\u0010ª\u0002\u001a\u0005\u0018\u00010©\u00028B@BX\u000e¢\u0006\u0010\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b­\u0002\u0010®\u0002R<\u0010´\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00012\u0010\u0010ª\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00018B@BX\u000e¢\u0006\u0010\u001a\u0006\b°\u0002\u0010±\u0002\"\u0006\b²\u0002\u0010³\u0002R<\u0010·\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00012\u0010\u0010ª\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00018B@BX\u000e¢\u0006\u0010\u001a\u0006\bµ\u0002\u0010±\u0002\"\u0006\b¶\u0002\u0010³\u0002R\u0017\u0010¸\u0002\u001a\u00020\f8VX\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010\u0002R\u0017\u0010º\u0002\u001a\u00020\u00078VX\u0004¢\u0006\b\u001a\u0006\b¹\u0002\u0010\u0001R\u0017\u0010»\u0002\u001a\u00020\u00078VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0001R\u001a\u0010½\u0002\u001a\u0005\u0018\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010¼\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006¿\u0002"}, d2 = {"Lio/ktor/utils/io/ByteBufferChannel;", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "pool", "", "reservedSize", "<init>", "(ZLio/ktor/utils/io/pool/ObjectPool;I)V", "Ljava/nio/ByteBuffer;", "content", "(Ljava/nio/ByteBuffer;)V", "minWriteSize", "", "N0", "(I)V", "position", "available", "Z0", "(Ljava/nio/ByteBuffer;II)V", "R1", "()Ljava/nio/ByteBuffer;", "I1", "()V", "Lio/ktor/utils/io/internal/JoiningState;", "joined", "V1", "(Lio/ktor/utils/io/internal/JoiningState;)Z", "forceTermination", "W1", "(Z)Z", "idx", "H0", "(Ljava/nio/ByteBuffer;I)I", "dst", "d1", "(Ljava/nio/ByteBuffer;)I", "Lio/ktor/utils/io/core/Buffer;", "consumed", "max", "c1", "(Lio/ktor/utils/io/core/Buffer;II)I", "", "offset", "length", "e1", "([BII)I", "rc0", "q1", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "n", "p1", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r1", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l1", "k1", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j1", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "Lio/ktor/utils/io/core/BytePacketBuilder;", "builder", "buffer", "Lio/ktor/utils/io/core/ByteReadPacket;", "t1", "(ILio/ktor/utils/io/core/BytePacketBuilder;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "N1", "(Ljava/nio/ByteBuffer;I)V", "G0", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "capacity", "count", "E0", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;I)V", "D0", "current", "joining", "H1", "(Lio/ktor/utils/io/ByteBufferChannel;Lio/ktor/utils/io/internal/JoiningState;)Lio/ktor/utils/io/ByteBufferChannel;", "src", "m2", "l2", "s2", "r2", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delegateClose", "V0", "(Lio/ktor/utils/io/ByteBufferChannel;ZLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "M0", "(Lio/ktor/utils/io/internal/JoiningState;)V", "c2", "b2", "(Lio/ktor/utils/io/core/Buffer;)I", "d2", "t2", "A2", "min", "Lkotlin/Function1;", "block", "C0", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "G2", "(Lkotlin/jvm/functions/Function1;)Z", "H2", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "F2", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "", "discarded0", "L0", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m1", "packet", "x2", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Y1", "(Lio/ktor/utils/io/core/ByteReadPacket;)I", "A0", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "limit", "C1", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "D1", "F1", "(J)Lio/ktor/utils/io/core/ByteReadPacket;", "v1", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "L1", "M1", "", "cause", "K1", "(Ljava/lang/Throwable;)V", "w1", "y1", "Lkotlin/coroutines/Continuation;", "continuation", "", "U1", "x1", "T1", "()Z", "C2", "(I)Z", "z2", "Lkotlinx/coroutines/CancellableContinuation;", "c", "B2", "(ILkotlinx/coroutines/CancellableContinuation;)V", "X0", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "E1", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "J0", "()Lio/ktor/utils/io/internal/ReadWriteBufferState;", "P0", "()Lio/ktor/utils/io/internal/JoiningState;", "Lkotlinx/coroutines/Job;", "job", "J", "(Lkotlinx/coroutines/Job;)V", "h", "(Ljava/lang/Throwable;)Z", "e", "flush", "lockedSpace", "a1", "S1", "J1", "X1", "p", "o1", "D", "u", "v", "j", "n1", "", "q", "", "G", "E", "", "o", "", "B", "F0", "G1", "()Lio/ktor/utils/io/ByteBufferChannel;", "b", "C", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "t", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "O", "l", "H", "g2", "f2", "M", "I0", "(Lio/ktor/utils/io/ByteBufferChannel;JLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "h2", "e2", "(ILkotlin/jvm/functions/Function1;)I", "x", "y", "Lio/ktor/utils/io/SuspendableReadSession;", "d", "()Lio/ktor/utils/io/SuspendableReadSession;", "P", "Lio/ktor/utils/io/WriterSuspendSession;", "L", "()Lio/ktor/utils/io/WriterSuspendSession;", "written", "consumer", "K", "k", "w", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "visitor", "m", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "F", "r", "skip", "atLeast", "a", "(II)Ljava/nio/ByteBuffer;", "A", "A1", "", "N", "Z1", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "Z", "z", "Lio/ktor/utils/io/pool/ObjectPool;", "getReservedSize$ktor_io", "()I", "Lio/ktor/utils/io/internal/JoiningState;", "readPosition", "f", "writePosition", "attachedJob", "Lkotlinx/coroutines/Job;", "<set-?>", "totalBytesRead", "S0", "()J", "P1", "(J)V", "totalBytesWritten", "T0", "Q1", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "g", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "getReadSession$annotations", "readSession", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSession", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "readSuspendContinuationCache", "writeSuspendContinuationCache", "writeSuspensionSize", "Lkotlin/jvm/functions/Function1;", "writeSuspension", "R0", "state", "Lio/ktor/utils/io/internal/ClosedElement;", "value", "O0", "()Lio/ktor/utils/io/internal/ClosedElement;", "setClosed", "(Lio/ktor/utils/io/internal/ClosedElement;)V", "closed", "Q0", "()Lkotlin/coroutines/Continuation;", "O1", "(Lkotlin/coroutines/Continuation;)V", "readOp", "U0", "setWriteOp", "writeOp", "availableForRead", "Q", "isClosedForRead", "isClosedForWrite", "()Ljava/lang/Throwable;", "closedCause", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nByteBufferChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteBufferChannel.kt\nio/ktor/utils/io/ByteBufferChannel\n+ 2 RingBufferCapacity.kt\nio/ktor/utils/io/internal/RingBufferCapacity\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n+ 5 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 6 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 7 Packet.kt\nio/ktor/utils/io/core/PacketKt\n+ 8 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 9 Output.kt\nio/ktor/utils/io/core/OutputKt\n+ 10 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,2411:1\n2110#1,2:2436\n459#1,4:2443\n466#1,2:2448\n464#1:2450\n459#1,4:2451\n466#1,2:2456\n464#1:2458\n459#1,4:2463\n466#1,2:2468\n464#1:2470\n459#1,4:2472\n466#1,2:2477\n464#1:2479\n849#1,4:2481\n459#1,4:2485\n466#1,2:2490\n464#1:2492\n853#1,15:2493\n849#1,4:2508\n459#1,4:2512\n466#1,2:2517\n464#1:2519\n853#1,15:2520\n849#1,4:2535\n459#1,4:2539\n466#1,2:2544\n464#1:2546\n853#1,15:2547\n849#1,4:2562\n459#1,4:2566\n466#1,2:2571\n464#1:2573\n853#1,15:2574\n849#1,4:2589\n459#1,4:2593\n466#1,2:2598\n464#1:2600\n853#1,15:2601\n849#1,4:2616\n459#1,4:2620\n466#1,2:2625\n464#1:2627\n853#1,15:2628\n459#1,4:2643\n466#1,2:2648\n464#1:2650\n964#1:2651\n966#1:2653\n1036#1,7:2654\n929#1,2:2661\n1043#1,2:2663\n931#1:2665\n1045#1:2666\n967#1,76:2667\n929#1,2:2743\n1043#1,2:2745\n931#1:2747\n1045#1:2748\n1030#1,3:2749\n979#1,32:2752\n1033#1:2784\n972#1:2785\n964#1:2786\n966#1:2788\n1036#1,7:2789\n929#1,2:2796\n1043#1,2:2798\n931#1:2800\n1045#1:2801\n967#1,76:2802\n929#1,2:2878\n1043#1,2:2880\n931#1:2882\n1045#1:2883\n1030#1,3:2884\n979#1,32:2887\n1033#1:2919\n972#1:2920\n964#1:2921\n966#1:2923\n1036#1,7:2924\n929#1,2:2931\n1043#1,2:2933\n931#1:2935\n1045#1:2936\n967#1,76:2937\n929#1,2:3013\n1043#1,2:3015\n931#1:3017\n1045#1:3018\n1030#1,3:3019\n979#1,32:3022\n1033#1:3054\n972#1:3055\n964#1:3056\n966#1:3058\n1036#1,7:3059\n929#1,2:3066\n1043#1,2:3068\n931#1:3070\n1045#1:3071\n967#1,76:3072\n929#1,2:3148\n1043#1,2:3150\n931#1:3152\n1045#1:3153\n1030#1,3:3154\n979#1,32:3157\n1033#1:3189\n972#1:3190\n1036#1,7:3191\n929#1,2:3198\n1043#1,2:3200\n931#1:3202\n1045#1:3203\n979#1,32:3204\n1019#1,24:3236\n929#1,2:3260\n1043#1,2:3262\n931#1:3264\n1045#1:3265\n1030#1,3:3266\n979#1,32:3269\n1033#1:3301\n993#1,18:3302\n1036#1,7:3320\n929#1,2:3327\n1043#1,2:3329\n931#1:3331\n1045#1:3332\n979#1,32:3333\n929#1,3:3365\n440#1:3370\n441#1,7:3372\n459#1,4:3381\n466#1,2:3386\n464#1:3388\n449#1,8:3389\n440#1:3397\n441#1,7:3399\n449#1,8:3407\n440#1:3415\n441#1,7:3417\n449#1,8:3426\n440#1:3434\n441#1,7:3436\n449#1,8:3444\n440#1:3452\n441#1,16:3454\n440#1:3470\n441#1,16:3472\n440#1:3488\n441#1,16:3490\n459#1,4:3506\n466#1,2:3511\n464#1:3513\n459#1,4:3515\n466#1,2:3520\n464#1:3522\n459#1,4:3523\n466#1,2:3528\n464#1:3530\n440#1:3533\n441#1,16:3535\n459#1,4:3551\n466#1,2:3556\n464#1:3558\n459#1,4:3559\n466#1,2:3564\n464#1:3566\n459#1,4:3569\n466#1,2:3574\n464#1:3576\n2197#1,3:3628\n2201#1,3:3632\n2341#1,3:3636\n2345#1:3640\n2197#1,3:3641\n2201#1,3:3645\n2346#1,5:3648\n2197#1,7:3653\n2197#1,3:3660\n2201#1,3:3664\n2341#1,3:3679\n2345#1,6:3683\n12#2:2412\n18#2:2413\n18#2:2415\n12#2:2416\n18#2:2421\n12#2:2429\n12#2:2431\n12#2:2442\n12#2:2447\n12#2:2455\n12#2:2461\n12#2:2467\n12#2:2476\n12#2:2489\n12#2:2516\n12#2:2543\n12#2:2570\n12#2:2597\n12#2:2624\n12#2:2647\n18#2:3379\n18#2:3380\n12#2:3385\n18#2:3406\n18#2:3425\n18#2:3443\n12#2:3510\n12#2:3514\n12#2:3519\n12#2:3527\n12#2:3555\n12#2:3563\n12#2:3567\n12#2:3568\n12#2:3573\n12#2:3577\n12#2:3622\n12#2:3623\n12#2:3624\n12#2:3625\n12#2:3626\n12#2:3627\n12#2:3631\n12#2:3635\n12#2:3644\n12#2:3663\n18#2:3667\n1#3:2414\n1#3:2652\n1#3:2787\n1#3:2922\n1#3:3057\n1#3:3371\n1#3:3398\n1#3:3416\n1#3:3435\n1#3:3453\n1#3:3471\n1#3:3489\n1#3:3534\n1#3:3639\n1#3:3682\n186#4,4:2417\n186#4,4:2422\n186#4,3:2426\n189#4:2430\n186#4,4:2432\n164#4,4:2438\n74#5:2459\n74#5:2462\n69#5:3424\n74#5:3589\n74#5:3611\n361#6:2460\n361#6:2471\n361#6:2480\n355#6:3368\n355#6:3369\n43#7:3531\n43#7:3532\n12#8,7:3578\n19#8,4:3596\n12#8,7:3600\n19#8,4:3618\n488#9,4:3585\n492#9,6:3590\n488#9,4:3607\n492#9,6:3612\n314#10,11:3668\n*S KotlinDebug\n*F\n+ 1 ByteBufferChannel.kt\nio/ktor/utils/io/ByteBufferChannel\n*L\n377#1:2436,2\n474#1:2443,4\n474#1:2448,2\n474#1:2450\n512#1:2451,4\n512#1:2456,2\n512#1:2458\n539#1:2463,4\n539#1:2468,2\n539#1:2470\n637#1:2472,4\n637#1:2477,2\n637#1:2479\n822#1:2481,4\n822#1:2485,4\n822#1:2490,2\n822#1:2492\n822#1:2493,15\n826#1:2508,4\n826#1:2512,4\n826#1:2517,2\n826#1:2519\n826#1:2520,15\n830#1:2535,4\n830#1:2539,4\n830#1:2544,2\n830#1:2546\n830#1:2547,15\n834#1:2562,4\n834#1:2566,4\n834#1:2571,2\n834#1:2573\n834#1:2574,15\n838#1:2589,4\n838#1:2593,4\n838#1:2598,2\n838#1:2600\n838#1:2601,15\n842#1:2616,4\n842#1:2620,4\n842#1:2625,2\n842#1:2627\n842#1:2628,15\n852#1:2643,4\n852#1:2648,2\n852#1:2650\n936#1:2651\n936#1:2653\n936#1:2654,7\n936#1:2661,2\n936#1:2663,2\n936#1:2665\n936#1:2666\n936#1:2667,76\n936#1:2743,2\n936#1:2745,2\n936#1:2747\n936#1:2748\n936#1:2749,3\n936#1:2752,32\n936#1:2784\n936#1:2785\n940#1:2786\n940#1:2788\n940#1:2789,7\n940#1:2796,2\n940#1:2798,2\n940#1:2800\n940#1:2801\n940#1:2802,76\n940#1:2878,2\n940#1:2880,2\n940#1:2882\n940#1:2883\n940#1:2884,3\n940#1:2887,32\n940#1:2919\n940#1:2920\n944#1:2921\n944#1:2923\n944#1:2924,7\n944#1:2931,2\n944#1:2933,2\n944#1:2935\n944#1:2936\n944#1:2937,76\n944#1:3013,2\n944#1:3015,2\n944#1:3017\n944#1:3018\n944#1:3019,3\n944#1:3022,32\n944#1:3054\n944#1:3055\n948#1:3056\n948#1:3058\n948#1:3059,7\n948#1:3066,2\n948#1:3068,2\n948#1:3070\n948#1:3071\n948#1:3072,76\n948#1:3148,2\n948#1:3150,2\n948#1:3152\n948#1:3153\n948#1:3154,3\n948#1:3157,32\n948#1:3189\n948#1:3190\n966#1:3191,7\n966#1:3198,2\n966#1:3200,2\n966#1:3202\n966#1:3203\n969#1:3204,32\n970#1:3236,24\n970#1:3260,2\n970#1:3262,2\n970#1:3264\n970#1:3265\n970#1:3266,3\n970#1:3269,32\n970#1:3301\n983#1:3302,18\n1029#1:3320,7\n1029#1:3327,2\n1029#1:3329,2\n1029#1:3331\n1029#1:3332\n1032#1:3333,32\n1042#1:3365,3\n1196#1:3370\n1196#1:3372,7\n1209#1:3381,4\n1209#1:3386,2\n1209#1:3388\n1196#1:3389,8\n1322#1:3397\n1322#1:3399,7\n1322#1:3407,8\n1352#1:3415\n1352#1:3417,7\n1352#1:3426,8\n1376#1:3434\n1376#1:3436,7\n1376#1:3444,8\n1455#1:3452\n1455#1:3454,16\n1525#1:3470\n1525#1:3472,16\n1535#1:3488\n1535#1:3490,16\n1640#1:3506,4\n1640#1:3511,2\n1640#1:3513\n1675#1:3515,4\n1675#1:3520,2\n1675#1:3522\n1693#1:3523,4\n1693#1:3528,2\n1693#1:3530\n1754#1:3533\n1754#1:3535,16\n1775#1:3551,4\n1775#1:3556,2\n1775#1:3558\n1796#1:3559,4\n1796#1:3564,2\n1796#1:3566\n1902#1:3569,4\n1902#1:3574,2\n1902#1:3576\n2209#1:3628,3\n2209#1:3632,3\n2225#1:3636,3\n2225#1:3640\n2225#1:3641,3\n2225#1:3645,3\n2225#1:3648,5\n2225#1:3653,7\n2231#1:3660,3\n2231#1:3664,3\n2326#1:3679,3\n2326#1:3683,6\n95#1:2412\n98#1:2413\n181#1:2415\n182#1:2416\n269#1:2421\n302#1:2429\n309#1:2431\n462#1:2442\n474#1:2447\n512#1:2455\n531#1:2461\n539#1:2467\n637#1:2476\n822#1:2489\n826#1:2516\n830#1:2543\n834#1:2570\n838#1:2597\n842#1:2624\n852#1:2647\n1198#1:3379\n1202#1:3380\n1209#1:3385\n1338#1:3406\n1364#1:3425\n1387#1:3443\n1640#1:3510\n1641#1:3514\n1675#1:3519\n1693#1:3527\n1775#1:3555\n1796#1:3563\n1858#1:3567\n1880#1:3568\n1902#1:3573\n1930#1:3577\n2139#1:3622\n2158#1:3623\n2164#1:3624\n2179#1:3625\n2184#1:3626\n2199#1:3627\n2209#1:3631\n2221#1:3635\n2225#1:3644\n2231#1:3663\n2258#1:3667\n936#1:2652\n940#1:2787\n944#1:2922\n948#1:3057\n1196#1:3371\n1322#1:3398\n1352#1:3416\n1376#1:3435\n1455#1:3453\n1525#1:3471\n1535#1:3489\n1754#1:3534\n2225#1:3639\n2326#1:3682\n224#1:2417,4\n276#1:2422,4\n292#1:2426,3\n292#1:2430\n316#1:2432,4\n398#1:2438,4\n513#1:2459\n505#1:2462\n1356#1:3424\n2072#1:3589\n2087#1:3611\n531#1:2460\n607#1:2471\n723#1:2480\n1099#1:3368\n1122#1:3369\n1725#1:3531\n1741#1:3532\n2069#1:3578,7\n2069#1:3596,4\n2084#1:3600,7\n2084#1:3618,4\n2071#1:3585,4\n2071#1:3590,6\n2086#1:3607,4\n2086#1:3612,6\n2311#1:3668,11\n*E\n"})
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel, LookAheadSuspendSession, HasReadSession, HasWriteSession {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public static final /* synthetic */ AtomicReferenceFieldUpdater m;
    public static final /* synthetic */ AtomicReferenceFieldUpdater n;
    public static final /* synthetic */ AtomicReferenceFieldUpdater o;
    public static final /* synthetic */ AtomicReferenceFieldUpdater p;
    @NotNull
    private volatile /* synthetic */ Object _closed;
    @NotNull
    private volatile /* synthetic */ Object _readOp;
    @NotNull
    private volatile /* synthetic */ Object _state;
    @NotNull
    volatile /* synthetic */ Object _writeOp;
    /* access modifiers changed from: private */
    @Nullable
    public volatile Job attachedJob;
    public final boolean b;
    public final ObjectPool c;
    public final int d;
    public int e;
    public int f;
    public final ReadSessionImpl g;
    public final WriteSessionImpl h;
    public final CancellableReusableContinuation i;
    public final CancellableReusableContinuation j;
    @Nullable
    private volatile JoiningState joining;
    public final Function1 k;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    /* access modifiers changed from: private */
    public volatile int writeSuspensionSize;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/ktor/utils/io/ByteBufferChannel$Companion;", "", "()V", "ReservedLongIndex", "", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        Class<ByteBufferChannel> cls = ByteBufferChannel.class;
        Class<Object> cls2 = Object.class;
        m = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        n = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closed");
        o = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_readOp");
        p = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_writeOp");
    }

    public ByteBufferChannel(boolean z, ObjectPool objectPool, int i2) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.b = z;
        this.c = objectPool;
        this.d = i2;
        this._state = ReadWriteBufferState.IdleEmpty.c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.g = new ReadSessionImpl(this);
        this.h = new WriteSessionImpl(this);
        this.i = new CancellableReusableContinuation();
        this.j = new CancellableReusableContinuation();
        this.k = new ByteBufferChannel$writeSuspension$1(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object D2(io.ktor.utils.io.ByteBufferChannel r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r4 = (io.ktor.utils.io.internal.WriteSessionImpl) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r5 = move-exception
            goto L_0x0050
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.utils.io.internal.WriteSessionImpl r4 = r4.h
            r4.e()
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r4.f()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0050:
            r4.f()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.D2(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object E2(ByteBufferChannel byteBufferChannel, Function1 function1, Continuation continuation) {
        if (!byteBufferChannel.G2(function1)) {
            return Unit.INSTANCE;
        }
        ClosedElement O0 = byteBufferChannel.O0();
        if (O0 == null) {
            Object H2 = byteBufferChannel.H2(function1, continuation);
            return H2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? H2 : Unit.INSTANCE;
        }
        Void unused = ByteBufferChannelKt.b(O0.c());
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Object K0(ByteBufferChannel byteBufferChannel, long j2, Continuation continuation) {
        long j3 = 0;
        if (j2 >= 0) {
            ByteBuffer R1 = byteBufferChannel.R1();
            if (R1 != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int l2 = ringBufferCapacity.l((int) Math.min(UpdateOptions.SOURCE_ANY, j2));
                        byteBufferChannel.D0(R1, ringBufferCapacity, l2);
                        j3 = (long) l2;
                    }
                } finally {
                    byteBufferChannel.I1();
                    byteBufferChannel.X1();
                }
            }
            long j4 = j3;
            return (j4 == j2 || byteBufferChannel.Q()) ? Boxing.boxLong(j4) : byteBufferChannel.L0(j4, j2, continuation);
        }
        throw new IllegalArgumentException(("max shouldn't be negative: " + j2).toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (((java.lang.Boolean) r15).booleanValue() != false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object L0(long r11, long r13, kotlin.coroutines.Continuation r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$discardSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            kotlin.ResultKt.throwOnFailure(r15)
            r8 = r10
            r10 = r13
            r13 = r8
            goto L_0x007b
        L_0x0036:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r11
            r12 = r15
        L_0x0049:
            long r4 = r12.element
            int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x00ac
            java.nio.ByteBuffer r11 = r10.R1()
            if (r11 != 0) goto L_0x0056
            goto L_0x0066
        L_0x0056:
            io.ktor.utils.io.internal.ReadWriteBufferState r15 = r10.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r15 = r15.b
            int r2 = r15._availableForRead$internal     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x0084
            r10.I1()
            r10.X1()
        L_0x0066:
            boolean r11 = r10.Q()
            if (r11 != 0) goto L_0x00ac
            r0.L$0 = r10
            r0.L$1 = r12
            r0.J$0 = r13
            r0.label = r3
            java.lang.Object r15 = r10.w1(r3, r0)
            if (r15 != r1) goto L_0x007b
            return r1
        L_0x007b:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r11 = r15.booleanValue()
            if (r11 != 0) goto L_0x0049
            goto L_0x00ac
        L_0x0084:
            long r4 = r12.element     // Catch:{ all -> 0x00a4 }
            long r4 = r13 - r4
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = java.lang.Math.min(r6, r4)     // Catch:{ all -> 0x00a4 }
            int r2 = (int) r4     // Catch:{ all -> 0x00a4 }
            int r2 = r15.l(r2)     // Catch:{ all -> 0x00a4 }
            r10.D0(r11, r15, r2)     // Catch:{ all -> 0x00a4 }
            long r4 = r12.element     // Catch:{ all -> 0x00a4 }
            long r6 = (long) r2     // Catch:{ all -> 0x00a4 }
            long r4 = r4 + r6
            r12.element = r4     // Catch:{ all -> 0x00a4 }
            r10.I1()
            r10.X1()
            goto L_0x0049
        L_0x00a4:
            r11 = move-exception
            r10.I1()
            r10.X1()
            throw r11
        L_0x00ac:
            long r10 = r12.element
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.L0(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r7.element = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r8.I1();
        r8.X1();
        r9 = r2;
        r8 = r4;
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00df, code lost:
        if (r3 != false) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e1, code lost:
        r2 = r7.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e6, code lost:
        if (r2 == null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e8, code lost:
        r7 = new io.ktor.utils.io.internal.FailedLookAhead(r2);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 4;
        r9 = r8.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fe, code lost:
        if (r9 != r1) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0100, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0101, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0108, code lost:
        if (r7.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010a, code lost:
        r7 = io.ktor.utils.io.internal.TerminatedLookAhead.b;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 5;
        r9 = r8.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011d, code lost:
        if (r9 != r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0120, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.L$2 = r9;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 6;
        r8 = r8.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0132, code lost:
        if (r8 != r1) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0134, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0135, code lost:
        r0 = r7;
        r7 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r7.element = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013b, code lost:
        r7 = r0.R0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0143, code lost:
        if (r7.a() != false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0147, code lost:
        if (r7 == io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014b, code lost:
        if ((r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.Reading) != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014f, code lost:
        if ((r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.ReadingWriting) == false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0151, code lost:
        r0.I1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0154, code lost:
        r0.X1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0157, code lost:
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0159, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015a, code lost:
        r0 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015c, code lost:
        r8 = r0.R0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0172, code lost:
        r0.I1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0175, code lost:
        r0.X1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0178, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x017b, code lost:
        return r9.element;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object W0(io.ktor.utils.io.ByteBufferChannel r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x006e;
                case 1: goto L_0x006a;
                case 2: goto L_0x0066;
                case 3: goto L_0x004a;
                case 4: goto L_0x0045;
                case 5: goto L_0x0040;
                case 6: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002c:
            java.lang.Object r7 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r0 = (io.ktor.utils.io.ByteBufferChannel) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003d }
            goto L_0x0139
        L_0x003d:
            r7 = move-exception
            goto L_0x015c
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0120
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0101
        L_0x004a:
            java.lang.Object r7 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$3
            io.ktor.utils.io.ByteBufferChannel r8 = (io.ktor.utils.io.ByteBufferChannel) r8
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0063 }
            goto L_0x00d4
        L_0x0063:
            r7 = move-exception
            goto L_0x0180
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009a
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0085
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Throwable r9 = r7.f()
            if (r9 == 0) goto L_0x0086
            io.ktor.utils.io.internal.FailedLookAhead r7 = new io.ktor.utils.io.internal.FailedLookAhead
            r7.<init>(r9)
            r0.label = r3
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x0085
            return r1
        L_0x0085:
            return r9
        L_0x0086:
            io.ktor.utils.io.internal.ReadWriteBufferState r9 = r7.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r2 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r9 != r2) goto L_0x009b
            io.ktor.utils.io.internal.TerminatedLookAhead r7 = io.ktor.utils.io.internal.TerminatedLookAhead.b
            r9 = 2
            r0.label = r9
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x009a
            return r1
        L_0x009a:
            return r9
        L_0x009b:
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            java.nio.ByteBuffer r2 = r7.R1()
            r4 = 0
            if (r2 != 0) goto L_0x00a9
        L_0x00a7:
            r3 = r4
            goto L_0x00df
        L_0x00a9:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r7.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.b
            int r2 = r2._availableForRead$internal     // Catch:{ all -> 0x017c }
            if (r2 != 0) goto L_0x00ba
            r7.I1()
            r7.X1()
            goto L_0x00a7
        L_0x00ba:
            r0.L$0 = r7     // Catch:{ all -> 0x017c }
            r0.L$1 = r8     // Catch:{ all -> 0x017c }
            r0.L$2 = r9     // Catch:{ all -> 0x017c }
            r0.L$3 = r7     // Catch:{ all -> 0x017c }
            r0.L$4 = r9     // Catch:{ all -> 0x017c }
            r2 = 3
            r0.label = r2     // Catch:{ all -> 0x017c }
            java.lang.Object r2 = r8.invoke(r7, r0)     // Catch:{ all -> 0x017c }
            if (r2 != r1) goto L_0x00ce
            return r1
        L_0x00ce:
            r5 = r7
            r4 = r8
            r8 = r5
            r7 = r9
            r9 = r2
            r2 = r7
        L_0x00d4:
            r7.element = r9     // Catch:{ all -> 0x0063 }
            r8.I1()
            r8.X1()
            r9 = r2
            r8 = r4
            r7 = r5
        L_0x00df:
            if (r3 != 0) goto L_0x0179
            java.lang.Throwable r2 = r7.f()
            r3 = 0
            if (r2 == 0) goto L_0x0102
            io.ktor.utils.io.internal.FailedLookAhead r7 = new io.ktor.utils.io.internal.FailedLookAhead
            r7.<init>(r2)
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r0.L$4 = r3
            r9 = 4
            r0.label = r9
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x0101
            return r1
        L_0x0101:
            return r9
        L_0x0102:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r7.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r4 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r4) goto L_0x0121
            io.ktor.utils.io.internal.TerminatedLookAhead r7 = io.ktor.utils.io.internal.TerminatedLookAhead.b
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r0.L$4 = r3
            r9 = 5
            r0.label = r9
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x0120
            return r1
        L_0x0120:
            return r9
        L_0x0121:
            r0.L$0 = r7     // Catch:{ all -> 0x0159 }
            r0.L$1 = r9     // Catch:{ all -> 0x0159 }
            r0.L$2 = r9     // Catch:{ all -> 0x0159 }
            r0.L$3 = r3     // Catch:{ all -> 0x0159 }
            r0.L$4 = r3     // Catch:{ all -> 0x0159 }
            r2 = 6
            r0.label = r2     // Catch:{ all -> 0x0159 }
            java.lang.Object r8 = r8.invoke(r7, r0)     // Catch:{ all -> 0x0159 }
            if (r8 != r1) goto L_0x0135
            return r1
        L_0x0135:
            r0 = r7
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0139:
            r7.element = r9     // Catch:{ all -> 0x003d }
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r0.R0()
            boolean r9 = r7.a()
            if (r9 != 0) goto L_0x0157
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r9 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r7 == r9) goto L_0x0157
            boolean r9 = r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.Reading
            if (r9 != 0) goto L_0x0151
            boolean r7 = r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.ReadingWriting
            if (r7 == 0) goto L_0x0154
        L_0x0151:
            r0.I1()
        L_0x0154:
            r0.X1()
        L_0x0157:
            r9 = r8
            goto L_0x0179
        L_0x0159:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L_0x015c:
            io.ktor.utils.io.internal.ReadWriteBufferState r8 = r0.R0()
            boolean r9 = r8.a()
            if (r9 != 0) goto L_0x0178
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r9 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r8 == r9) goto L_0x0178
            boolean r9 = r8 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.Reading
            if (r9 != 0) goto L_0x0172
            boolean r8 = r8 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.ReadingWriting
            if (r8 == 0) goto L_0x0175
        L_0x0172:
            r0.I1()
        L_0x0175:
            r0.X1()
        L_0x0178:
            throw r7
        L_0x0179:
            T r7 = r9.element
            return r7
        L_0x017c:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0180:
            r8.I1()
            r8.X1()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.W0(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object Y0(io.ktor.utils.io.ByteBufferChannel r16, java.nio.ByteBuffer r17, long r18, long r20, long r22, long r24, kotlin.coroutines.Continuation r26) {
        /*
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteBufferChannel$peekTo$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r2 = (io.ktor.utils.io.ByteBufferChannel$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r2 = new io.ktor.utils.io.ByteBufferChannel$peekTo$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ EOFException -> 0x0065 }
            goto L_0x0065
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            long r6 = r22 + r20
            r8 = 4088(0xff8, double:2.0197E-320)
            long r6 = kotlin.ranges.RangesKt.coerceAtMost((long) r6, (long) r8)
            int r4 = (int) r6
            io.ktor.utils.io.ByteBufferChannel$peekTo$2 r15 = new io.ktor.utils.io.ByteBufferChannel$peekTo$2     // Catch:{ EOFException -> 0x0064 }
            r6 = r15
            r7 = r20
            r9 = r24
            r11 = r17
            r12 = r18
            r14 = r1
            r6.<init>(r7, r9, r11, r12, r14)     // Catch:{ EOFException -> 0x0064 }
            r2.L$0 = r1     // Catch:{ EOFException -> 0x0064 }
            r2.label = r5     // Catch:{ EOFException -> 0x0064 }
            java.lang.Object r0 = r0.K(r4, r15, r2)     // Catch:{ EOFException -> 0x0064 }
            if (r0 != r3) goto L_0x0064
            return r3
        L_0x0064:
            r0 = r1
        L_0x0065:
            int r0 = r0.element
            long r0 = (long) r0
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.Y0(io.ktor.utils.io.ByteBufferChannel, java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a2(io.ktor.utils.io.ByteBufferChannel r5, int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$write$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = (io.ktor.utils.io.ByteBufferChannel$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = new io.ktor.utils.io.ByteBufferChannel$write$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L_0x0048
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 <= 0) goto L_0x0080
            r8 = 4088(0xff8, float:5.729E-42)
            if (r6 > r8) goto L_0x0060
        L_0x0048:
            int r8 = r5.e2(r6, r7)
            if (r8 < 0) goto L_0x0051
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0051:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.C0(r6, r7, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0060:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Min("
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = ") should'nt be greater than (4088)"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L_0x0080:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.a2(io.ktor.utils.io.ByteBufferChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object b1(ByteBufferChannel byteBufferChannel, int i2, Function1 function1, Continuation continuation) {
        if (i2 >= 0) {
            ByteBuffer R1 = byteBufferChannel.R1();
            boolean z = false;
            if (R1 != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int i3 = ringBufferCapacity._availableForRead$internal;
                        if (i3 > 0) {
                            if (i3 >= i2) {
                                int position = R1.position();
                                int limit = R1.limit();
                                function1.invoke(R1);
                                if (limit == R1.limit()) {
                                    int position2 = R1.position() - position;
                                    if (position2 < 0) {
                                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                                    } else if (ringBufferCapacity.m(position2)) {
                                        byteBufferChannel.D0(R1, ringBufferCapacity, position2);
                                        z = true;
                                    } else {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                } else {
                                    throw new IllegalStateException("Buffer limit modified.".toString());
                                }
                            }
                        }
                    }
                } finally {
                    byteBufferChannel.I1();
                    byteBufferChannel.X1();
                }
            }
            if (z) {
                return Unit.INSTANCE;
            }
            if (!byteBufferChannel.Q() || i2 <= 0) {
                Object m1 = byteBufferChannel.m1(i2, function1, continuation);
                return m1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1 : Unit.INSTANCE;
            }
            throw new EOFException("Got EOF but at least " + i2 + " bytes were expected");
        }
        throw new IllegalArgumentException("min should be positive or zero".toString());
    }

    public static /* synthetic */ int f1(ByteBufferChannel byteBufferChannel, Buffer buffer, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = buffer.g() - buffer.k();
            }
            return byteBufferChannel.c1(buffer, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
    }

    public static /* synthetic */ Object g1(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, Continuation continuation) {
        int f1 = f1(byteBufferChannel, chunkBuffer, 0, 0, 6, (Object) null);
        if (f1 == 0 && byteBufferChannel.O0() != null) {
            f1 = byteBufferChannel.R0().b.e() ? f1(byteBufferChannel, chunkBuffer, 0, 0, 6, (Object) null) : -1;
        } else if (f1 <= 0 && chunkBuffer.g() > chunkBuffer.k()) {
            return byteBufferChannel.j1(chunkBuffer, continuation);
        }
        return Boxing.boxInt(f1);
    }

    public static /* synthetic */ Object h1(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) {
        int d1 = byteBufferChannel.d1(byteBuffer);
        if (d1 == 0 && byteBufferChannel.O0() != null) {
            d1 = byteBufferChannel.R0().b.e() ? byteBufferChannel.d1(byteBuffer) : -1;
        } else if (d1 <= 0 && byteBuffer.hasRemaining()) {
            return byteBufferChannel.k1(byteBuffer, continuation);
        }
        return Boxing.boxInt(d1);
    }

    public static /* synthetic */ Object i1(ByteBufferChannel byteBufferChannel, byte[] bArr, int i2, int i3, Continuation continuation) {
        int e1 = byteBufferChannel.e1(bArr, i2, i3);
        if (e1 == 0 && byteBufferChannel.O0() != null) {
            e1 = byteBufferChannel.R0().b.e() ? byteBufferChannel.e1(bArr, i2, i3) : -1;
        } else if (e1 <= 0 && i3 != 0) {
            return byteBufferChannel.l1(bArr, i2, i3, continuation);
        }
        return Boxing.boxInt(e1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = r1.H1(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object i2(io.ktor.utils.io.ByteBufferChannel r1, io.ktor.utils.io.core.internal.ChunkBuffer r2, kotlin.coroutines.Continuation r3) {
        /*
            io.ktor.utils.io.internal.JoiningState r0 = r1.joining
            if (r0 == 0) goto L_0x000f
            io.ktor.utils.io.ByteBufferChannel r0 = r1.H1(r1, r0)
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r0.f2(r2, r3)
            return r1
        L_0x000f:
            int r0 = r1.b2(r2)
            if (r0 <= 0) goto L_0x001a
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            return r1
        L_0x001a:
            io.ktor.utils.io.internal.JoiningState r0 = r1.joining
            if (r0 == 0) goto L_0x0029
            io.ktor.utils.io.ByteBufferChannel r0 = r1.H1(r1, r0)
            if (r0 == 0) goto L_0x0029
            java.lang.Object r1 = r0.l2(r2, r3)
            return r1
        L_0x0029:
            java.lang.Object r1 = r1.l2(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.i2(io.ktor.utils.io.ByteBufferChannel, io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = r1.H1(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object j2(io.ktor.utils.io.ByteBufferChannel r1, java.nio.ByteBuffer r2, kotlin.coroutines.Continuation r3) {
        /*
            io.ktor.utils.io.internal.JoiningState r0 = r1.joining
            if (r0 == 0) goto L_0x000f
            io.ktor.utils.io.ByteBufferChannel r0 = r1.H1(r1, r0)
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r0.g2(r2, r3)
            return r1
        L_0x000f:
            int r0 = r1.c2(r2)
            if (r0 <= 0) goto L_0x001a
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            return r1
        L_0x001a:
            io.ktor.utils.io.internal.JoiningState r0 = r1.joining
            if (r0 == 0) goto L_0x0029
            io.ktor.utils.io.ByteBufferChannel r0 = r1.H1(r1, r0)
            if (r0 == 0) goto L_0x0029
            java.lang.Object r1 = r0.m2(r2, r3)
            return r1
        L_0x0029:
            java.lang.Object r1 = r1.m2(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.j2(io.ktor.utils.io.ByteBufferChannel, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.nio.ByteBuffer} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k1(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
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
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.w1(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.k1(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object k2(ByteBufferChannel byteBufferChannel, byte[] bArr, int i2, int i3, Continuation continuation) {
        ByteBufferChannel H1;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (H1 = byteBufferChannel.H1(byteBufferChannel, joiningState)) != null) {
            return H1.h2(bArr, i2, i3, continuation);
        }
        int d2 = byteBufferChannel.d2(bArr, i2, i3);
        return d2 > 0 ? Boxing.boxInt(d2) : byteBufferChannel.A2(bArr, i2, i3, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l2(io.ktor.utils.io.core.internal.ChunkBuffer r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007e
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0070
        L_0x003b:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = (io.ktor.utils.io.core.internal.ChunkBuffer) r7
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.io.ByteBufferChannel) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.z2(r5, r0)
            if (r8 != r1) goto L_0x0058
            return r1
        L_0x0058:
            io.ktor.utils.io.internal.JoiningState r8 = r6.joining
            r2 = 0
            if (r8 == 0) goto L_0x0071
            io.ktor.utils.io.ByteBufferChannel r8 = r6.H1(r6, r8)
            if (r8 == 0) goto L_0x0071
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r8 = r8.l2(r7, r0)
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x0070:
            return r8
        L_0x0071:
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r6.f2(r7, r0)
            if (r8 != r1) goto L_0x007e
            return r1
        L_0x007e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.l2(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.nio.ByteBuffer} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m2(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007e
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0070
        L_0x003b:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.io.ByteBufferChannel) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.z2(r5, r0)
            if (r8 != r1) goto L_0x0058
            return r1
        L_0x0058:
            io.ktor.utils.io.internal.JoiningState r8 = r6.joining
            r2 = 0
            if (r8 == 0) goto L_0x0071
            io.ktor.utils.io.ByteBufferChannel r8 = r6.H1(r6, r8)
            if (r8 == 0) goto L_0x0071
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r8 = r8.m2(r7, r0)
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x0070:
            return r8
        L_0x0071:
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r6.g2(r7, r0)
            if (r8 != r1) goto L_0x007e
            return r1
        L_0x007e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.m2(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        if (r8.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bf, code lost:
        if (r2.e().C((byte) r9, r0) != r1) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c2, code lost:
        r0.L$0 = r2;
        r0.L$1 = r8;
        r0.B$0 = r9;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cf, code lost:
        if (r8.z2(1, r0) != r1) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.L$2 = r2;
        r0.B$0 = r10;
        r0.I$0 = r9;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r8.z2(r9, r0) != r1) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f8, code lost:
        if (r8.joining == null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fa, code lost:
        r8.J1();
        r9 = r8.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0108, code lost:
        if (r8.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010a, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011c, code lost:
        if (r9.e().C((byte) r10, r0) != r1) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011f, code lost:
        r2 = r9;
        r9 = r8;
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0128, code lost:
        if (r9.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012a, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013c, code lost:
        if (r2.e().C((byte) r8, r0) != r1) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013f, code lost:
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.L$2 = null;
        r0.B$0 = r8;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014f, code lost:
        if (r9.z2(1, r0) != r1) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0151, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (r6.p(r9) != false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0159, code lost:
        r8.a1(r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0160, code lost:
        if (r2.remaining() >= r9) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0162, code lost:
        r2.limit(r2.capacity());
        r2.put((byte) r10);
        r8.G0(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0171, code lost:
        r2.put((byte) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0175, code lost:
        r8.E0(r2, r6, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x017c, code lost:
        if (r6.h() != false) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0182, code lost:
        if (r8.z() == false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0184, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0187, code lost:
        r8.J1();
        r8.X1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018f, code lost:
        r5 = r8;
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ce, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object n2(io.ktor.utils.io.ByteBufferChannel r8, byte r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeByte$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeByte$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeByte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeByte$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeByte$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x006d;
                case 1: goto L_0x0068;
                case 2: goto L_0x0068;
                case 3: goto L_0x0068;
                case 4: goto L_0x0057;
                case 5: goto L_0x003c;
                case 6: goto L_0x0068;
                case 7: goto L_0x0068;
                case 8: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            byte r8 = r0.B$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0122
        L_0x003c:
            int r8 = r0.I$0
            byte r9 = r0.B$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r6 = (io.ktor.utils.io.internal.RingBufferCapacity) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0054 }
            r10 = r9
            r9 = r8
            r8 = r5
            goto L_0x00f6
        L_0x0054:
            r8 = move-exception
            goto L_0x0191
        L_0x0057:
            byte r8 = r0.B$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00a7
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x01cc
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            if (r10 == 0) goto L_0x0084
            io.ktor.utils.io.ByteBufferChannel r10 = r8.H1(r8, r10)
            if (r10 == 0) goto L_0x0084
            byte r8 = (byte) r9
            r0.label = r3
            java.lang.Object r8 = r10.C(r8, r0)
            if (r8 != r1) goto L_0x01cc
            return r1
        L_0x0084:
            java.nio.ByteBuffer r10 = r8.S1()
            if (r10 != 0) goto L_0x00d2
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r5) goto L_0x00a6
            io.ktor.utils.io.ByteBufferChannel r8 = r10.e()
            byte r9 = (byte) r9
            r10 = 2
            r0.label = r10
            java.lang.Object r8 = r8.C(r9, r0)
            if (r8 != r1) goto L_0x01cc
            return r1
        L_0x00a6:
            r2 = r10
        L_0x00a7:
            io.ktor.utils.io.internal.ReadWriteBufferState r10 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r10 != r5) goto L_0x00c2
            io.ktor.utils.io.ByteBufferChannel r8 = r2.e()
            byte r9 = (byte) r9
            r0.L$0 = r4
            r0.L$1 = r4
            r10 = 3
            r0.label = r10
            java.lang.Object r8 = r8.C(r9, r0)
            if (r8 != r1) goto L_0x01cc
            return r1
        L_0x00c2:
            r0.L$0 = r2
            r0.L$1 = r8
            r0.B$0 = r9
            r10 = 4
            r0.label = r10
            java.lang.Object r10 = r8.z2(r3, r0)
            if (r10 != r1) goto L_0x00a7
            return r1
        L_0x00d2:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.b
            boolean r5 = r2.p(r3)
            if (r5 != 0) goto L_0x0198
            r6 = r2
            r2 = r10
            r10 = r9
            r9 = r3
        L_0x00e2:
            r0.L$0 = r6     // Catch:{ all -> 0x018e }
            r0.L$1 = r8     // Catch:{ all -> 0x018e }
            r0.L$2 = r2     // Catch:{ all -> 0x018e }
            r0.B$0 = r10     // Catch:{ all -> 0x018e }
            r0.I$0 = r9     // Catch:{ all -> 0x018e }
            r5 = 5
            r0.label = r5     // Catch:{ all -> 0x018e }
            java.lang.Object r5 = r8.z2(r9, r0)     // Catch:{ all -> 0x018e }
            if (r5 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            io.ktor.utils.io.internal.JoiningState r5 = r8.joining
            if (r5 == 0) goto L_0x0152
            r8.J1()
            io.ktor.utils.io.internal.JoiningState r9 = r8.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r5) goto L_0x011f
            io.ktor.utils.io.ByteBufferChannel r8 = r9.e()
            byte r9 = (byte) r10
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r10 = 6
            r0.label = r10
            java.lang.Object r8 = r8.C(r9, r0)
            if (r8 != r1) goto L_0x01cc
            return r1
        L_0x011f:
            r2 = r9
            r9 = r8
            r8 = r10
        L_0x0122:
            io.ktor.utils.io.internal.ReadWriteBufferState r10 = r9.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r10 != r5) goto L_0x013f
            io.ktor.utils.io.ByteBufferChannel r9 = r2.e()
            byte r8 = (byte) r8
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r10 = 7
            r0.label = r10
            java.lang.Object r8 = r9.C(r8, r0)
            if (r8 != r1) goto L_0x01cc
            return r1
        L_0x013f:
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r4
            r0.B$0 = r8
            r10 = 8
            r0.label = r10
            java.lang.Object r10 = r9.z2(r3, r0)
            if (r10 != r1) goto L_0x0122
            return r1
        L_0x0152:
            boolean r5 = r6.p(r9)
            if (r5 != 0) goto L_0x0159
            goto L_0x00e2
        L_0x0159:
            r8.a1(r2, r9)
            int r0 = r2.remaining()
            if (r0 >= r9) goto L_0x0171
            int r0 = r2.capacity()
            r2.limit(r0)
            byte r10 = (byte) r10
            r2.put(r10)
            r8.G0(r2)
            goto L_0x0175
        L_0x0171:
            byte r10 = (byte) r10
            r2.put(r10)
        L_0x0175:
            r8.E0(r2, r6, r9)
            boolean r9 = r6.h()
            if (r9 != 0) goto L_0x0184
            boolean r9 = r8.z()
            if (r9 == 0) goto L_0x0187
        L_0x0184:
            r8.flush()
        L_0x0187:
            r8.J1()
            r8.X1()
            goto L_0x01cc
        L_0x018e:
            r9 = move-exception
            r5 = r8
            r8 = r9
        L_0x0191:
            r5.J1()
            r5.X1()
            throw r8
        L_0x0198:
            r8.a1(r10, r3)
            int r0 = r10.remaining()
            if (r0 >= r3) goto L_0x01b0
            int r0 = r10.capacity()
            r10.limit(r0)
            byte r9 = (byte) r9
            r10.put(r9)
            r8.G0(r10)
            goto L_0x01b4
        L_0x01b0:
            byte r9 = (byte) r9
            r10.put(r9)
        L_0x01b4:
            r8.E0(r10, r2, r3)
            boolean r9 = r2.h()
            if (r9 != 0) goto L_0x01c3
            boolean r9 = r8.z()
            if (r9 == 0) goto L_0x01c6
        L_0x01c3:
            r8.flush()
        L_0x01c6:
            r8.J1()
            r8.X1()
        L_0x01cc:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.n2(io.ktor.utils.io.ByteBufferChannel, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object o2(ByteBufferChannel byteBufferChannel, Buffer buffer, Continuation continuation) {
        byteBufferChannel.b2(buffer);
        if (buffer.k() <= buffer.i()) {
            return Unit.INSTANCE;
        }
        Object r2 = byteBufferChannel.r2(buffer, continuation);
        return r2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r2 : Unit.INSTANCE;
    }

    public static /* synthetic */ Object p2(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) {
        ByteBufferChannel H1;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState == null || (H1 = byteBufferChannel.H1(byteBufferChannel, joiningState)) == null) {
            byteBufferChannel.c2(byteBuffer);
            if (!byteBuffer.hasRemaining()) {
                return Unit.INSTANCE;
            }
            Object s2 = byteBufferChannel.s2(byteBuffer, continuation);
            return s2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? s2 : Unit.INSTANCE;
        }
        Object l2 = H1.l(byteBuffer, continuation);
        return l2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? l2 : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q1(java.nio.ByteBuffer r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x003e:
            boolean r8 = r6.hasRemaining()
            if (r8 == 0) goto L_0x0087
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r8 = r5.w1(r3, r0)
            if (r8 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x0056:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0067
            int r8 = r7.d1(r6)
            int r5 = r5 + r8
            r4 = r7
            r7 = r5
            r5 = r4
            goto L_0x003e
        L_0x0067:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r5 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unexpected EOF: expected "
            r7.append(r8)
            int r6 = r6.remaining()
            r7.append(r6)
            java.lang.String r6 = " more bytes"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x0087:
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.q1(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object q2(ByteBufferChannel byteBufferChannel, byte[] bArr, int i2, int i3, Continuation continuation) {
        ByteBufferChannel H1;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState == null || (H1 = byteBufferChannel.H1(byteBufferChannel, joiningState)) == null) {
            while (i3 > 0) {
                int d2 = byteBufferChannel.d2(bArr, i2, i3);
                if (d2 == 0) {
                    break;
                }
                i2 += d2;
                i3 -= d2;
            }
            if (i3 == 0) {
                return Unit.INSTANCE;
            }
            Object t2 = byteBufferChannel.t2(bArr, i2, i3, continuation);
            return t2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? t2 : Unit.INSTANCE;
        }
        Object I = H1.I(bArr, i2, i3, continuation);
        return I == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? I : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r1(byte[] r7, int r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r6 = r0.I$2
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            byte[] r9 = (byte[]) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005d
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 0
        L_0x0043:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.I$2 = r10
            r0.label = r3
            java.lang.Object r2 = r6.w1(r3, r0)
            if (r2 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r4 = r2
            r2 = r6
            r6 = r10
            r10 = r4
            r5 = r9
            r9 = r7
            r7 = r5
        L_0x005d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0075
            int r8 = r8 + r6
            int r6 = r7 - r6
            int r10 = r2.e1(r9, r8, r6)
            if (r10 < r6) goto L_0x0071
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0071:
            r7 = r9
            r9 = r6
            r6 = r2
            goto L_0x0043
        L_0x0075:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r6 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unexpected EOF: expected "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = " more bytes"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.r1(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object s1(ByteBufferChannel byteBufferChannel, int i2, Continuation continuation) {
        Throwable b2;
        ClosedElement O0 = byteBufferChannel.O0();
        if (O0 != null && (b2 = O0.b()) != null) {
            Void unused = ByteBufferChannelKt.b(b2);
            throw new KotlinNothingValueException();
        } else if (i2 == 0) {
            return ByteReadPacket.i.a();
        } else {
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            ByteBuffer byteBuffer = (ByteBuffer) ObjectPoolKt.d().h0();
            while (i2 > 0) {
                try {
                    byteBuffer.clear();
                    if (byteBuffer.remaining() > i2) {
                        byteBuffer.limit(i2);
                    }
                    int d1 = byteBufferChannel.d1(byteBuffer);
                    if (d1 == 0) {
                        break;
                    }
                    byteBuffer.flip();
                    OutputArraysJVMKt.a(bytePacketBuilder, byteBuffer);
                    i2 -= d1;
                } catch (Throwable th) {
                    ObjectPoolKt.d().recycle(byteBuffer);
                    bytePacketBuilder.release();
                    throw th;
                }
            }
            if (i2 != 0) {
                return byteBufferChannel.t1(i2, bytePacketBuilder, byteBuffer, continuation);
            }
            ObjectPoolKt.d().recycle(byteBuffer);
            return bytePacketBuilder.F0();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s2(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            r0.<init>(r6, r8)
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
            goto L_0x0071
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x0059
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x0046:
            boolean r8 = r7.hasRemaining()
            if (r8 == 0) goto L_0x0078
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.Z1(r4, r0)
            if (r8 != r1) goto L_0x0059
            return r1
        L_0x0059:
            io.ktor.utils.io.internal.JoiningState r8 = r6.joining
            if (r8 == 0) goto L_0x0074
            io.ktor.utils.io.ByteBufferChannel r8 = r6.H1(r6, r8)
            if (r8 == 0) goto L_0x0074
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r8.l(r7, r0)
            if (r6 != r1) goto L_0x0071
            return r1
        L_0x0071:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0074:
            r6.c2(r7)
            goto L_0x0046
        L_0x0078:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.s2(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object u1(ByteBufferChannel byteBufferChannel, long j2, Continuation continuation) {
        if (!byteBufferChannel.g()) {
            return byteBufferChannel.v1(j2, continuation);
        }
        Throwable f2 = byteBufferChannel.f();
        if (f2 == null) {
            return byteBufferChannel.F1(j2);
        }
        Void unused = ByteBufferChannelKt.b(f2);
        throw new KotlinNothingValueException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r8.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r8 = r2.e();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r8.O(r9, r0) != r1) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        r0.L$0 = r2;
        r0.L$1 = r8;
        r0.I$0 = r9;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        if (r8.z2(1, r0) != r1) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ce, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.L$2 = r2;
        r0.I$0 = r9;
        r0.I$1 = r3;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ee, code lost:
        if (r8.z2(r3, r0) != r1) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f3, code lost:
        if (r8.joining == null) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f5, code lost:
        r8.J1();
        r10 = r8.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0103, code lost:
        if (r8.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0105, code lost:
        r8 = r10.e();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0116, code lost:
        if (r8.O(r9, r0) != r1) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0118, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0119, code lost:
        r2 = r10;
        r7 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0123, code lost:
        if (r9.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0125, code lost:
        r9 = r2.e();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0136, code lost:
        if (r9.O(r8, r0) != r1) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0138, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.L$2 = null;
        r0.I$0 = r8;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0149, code lost:
        if (r9.z2(1, r0) != r1) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0150, code lost:
        if (r6.p(r3) != false) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0153, code lost:
        r8.a1(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015a, code lost:
        if (r2.remaining() >= r3) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015c, code lost:
        r2.limit(r2.capacity());
        r2.putInt(r9);
        r8.G0(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016a, code lost:
        r2.putInt(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016d, code lost:
        r8.E0(r2, r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0174, code lost:
        if (r6.h() != false) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017a, code lost:
        if (r8.z() == false) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017c, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017f, code lost:
        r8.J1();
        r8.X1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0186, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0187, code lost:
        r3 = r8;
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c4, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object u2(io.ktor.utils.io.ByteBufferChannel r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeInt$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeInt$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeInt$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeInt$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            r5 = 0
            switch(r2) {
                case 0: goto L_0x006e;
                case 1: goto L_0x0069;
                case 2: goto L_0x0069;
                case 3: goto L_0x0069;
                case 4: goto L_0x0058;
                case 5: goto L_0x003d;
                case 6: goto L_0x0069;
                case 7: goto L_0x0069;
                case 8: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002e:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x011d
        L_0x003d:
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r3 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r3 = (io.ktor.utils.io.ByteBufferChannel) r3
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r6 = (io.ktor.utils.io.internal.RingBufferCapacity) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0055 }
            r7 = r3
            r3 = r8
            r8 = r7
            goto L_0x00f1
        L_0x0055:
            r8 = move-exception
            goto L_0x0189
        L_0x0058:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00a6
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x01c2
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            if (r10 == 0) goto L_0x0084
            io.ktor.utils.io.ByteBufferChannel r10 = r8.H1(r8, r10)
            if (r10 == 0) goto L_0x0084
            r0.label = r4
            java.lang.Object r8 = r10.O(r9, r0)
            if (r8 != r1) goto L_0x01c2
            return r1
        L_0x0084:
            java.nio.ByteBuffer r10 = r8.S1()
            if (r10 != 0) goto L_0x00cf
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r6 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r6) goto L_0x00a5
            io.ktor.utils.io.ByteBufferChannel r8 = r10.e()
            r10 = 2
            r0.label = r10
            java.lang.Object r8 = r8.O(r9, r0)
            if (r8 != r1) goto L_0x01c2
            return r1
        L_0x00a5:
            r2 = r10
        L_0x00a6:
            io.ktor.utils.io.internal.ReadWriteBufferState r10 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r6 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r10 != r6) goto L_0x00c0
            io.ktor.utils.io.ByteBufferChannel r8 = r2.e()
            r0.L$0 = r5
            r0.L$1 = r5
            r10 = 3
            r0.label = r10
            java.lang.Object r8 = r8.O(r9, r0)
            if (r8 != r1) goto L_0x01c2
            return r1
        L_0x00c0:
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.z2(r4, r0)
            if (r10 != r1) goto L_0x00a6
            return r1
        L_0x00cf:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.b
            boolean r6 = r2.p(r3)
            if (r6 != 0) goto L_0x0190
            r6 = r2
            r2 = r10
        L_0x00dd:
            r0.L$0 = r6     // Catch:{ all -> 0x0186 }
            r0.L$1 = r8     // Catch:{ all -> 0x0186 }
            r0.L$2 = r2     // Catch:{ all -> 0x0186 }
            r0.I$0 = r9     // Catch:{ all -> 0x0186 }
            r0.I$1 = r3     // Catch:{ all -> 0x0186 }
            r10 = 5
            r0.label = r10     // Catch:{ all -> 0x0186 }
            java.lang.Object r10 = r8.z2(r3, r0)     // Catch:{ all -> 0x0186 }
            if (r10 != r1) goto L_0x00f1
            return r1
        L_0x00f1:
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            if (r10 == 0) goto L_0x014c
            r8.J1()
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r3) goto L_0x0119
            io.ktor.utils.io.ByteBufferChannel r8 = r10.e()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r10 = 6
            r0.label = r10
            java.lang.Object r8 = r8.O(r9, r0)
            if (r8 != r1) goto L_0x01c2
            return r1
        L_0x0119:
            r2 = r10
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x011d:
            io.ktor.utils.io.internal.ReadWriteBufferState r10 = r9.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r10 != r3) goto L_0x0139
            io.ktor.utils.io.ByteBufferChannel r9 = r2.e()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r10 = 7
            r0.label = r10
            java.lang.Object r8 = r9.O(r8, r0)
            if (r8 != r1) goto L_0x01c2
            return r1
        L_0x0139:
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r5
            r0.I$0 = r8
            r10 = 8
            r0.label = r10
            java.lang.Object r10 = r9.z2(r4, r0)
            if (r10 != r1) goto L_0x011d
            return r1
        L_0x014c:
            boolean r10 = r6.p(r3)
            if (r10 != 0) goto L_0x0153
            goto L_0x00dd
        L_0x0153:
            r8.a1(r2, r3)
            int r10 = r2.remaining()
            if (r10 >= r3) goto L_0x016a
            int r10 = r2.capacity()
            r2.limit(r10)
            r2.putInt(r9)
            r8.G0(r2)
            goto L_0x016d
        L_0x016a:
            r2.putInt(r9)
        L_0x016d:
            r8.E0(r2, r6, r3)
            boolean r9 = r6.h()
            if (r9 != 0) goto L_0x017c
            boolean r9 = r8.z()
            if (r9 == 0) goto L_0x017f
        L_0x017c:
            r8.flush()
        L_0x017f:
            r8.J1()
            r8.X1()
            goto L_0x01c2
        L_0x0186:
            r9 = move-exception
            r3 = r8
            r8 = r9
        L_0x0189:
            r3.J1()
            r3.X1()
            throw r8
        L_0x0190:
            r8.a1(r10, r3)
            int r0 = r10.remaining()
            if (r0 >= r3) goto L_0x01a7
            int r0 = r10.capacity()
            r10.limit(r0)
            r10.putInt(r9)
            r8.G0(r10)
            goto L_0x01aa
        L_0x01a7:
            r10.putInt(r9)
        L_0x01aa:
            r8.E0(r10, r2, r3)
            boolean r9 = r2.h()
            if (r9 != 0) goto L_0x01b9
            boolean r9 = r8.z()
            if (r9 == 0) goto L_0x01bc
        L_0x01b9:
            r8.flush()
        L_0x01bc:
            r8.J1()
            r8.X1()
        L_0x01c2:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.u2(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        if (r10.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        r10 = r2.e();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (r10.H(r11, r0) != r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.J$0 = r11;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ce, code lost:
        if (r10.z2(1, r0) != r1) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r0.L$0 = r7;
        r0.L$1 = r10;
        r0.L$2 = r2;
        r0.J$0 = r12;
        r0.I$0 = r11;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f2, code lost:
        if (r10.z2(r11, r0) != r1) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f7, code lost:
        if (r10.joining == null) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f9, code lost:
        r10.J1();
        r11 = r10.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0107, code lost:
        if (r10.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0109, code lost:
        r10 = r11.e();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011a, code lost:
        if (r10.H(r12, r0) != r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011d, code lost:
        r2 = r11;
        r8 = r12;
        r12 = r10;
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0127, code lost:
        if (r12.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0129, code lost:
        r12 = r2.e();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
        if (r12.H(r10, r0) != r1) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013d, code lost:
        r0.L$0 = r2;
        r0.L$1 = r12;
        r0.L$2 = null;
        r0.J$0 = r10;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014b, code lost:
        if (r12.z2(1, r0) != r1) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0152, code lost:
        if (r7.p(r11) != false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0155, code lost:
        r10.a1(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015c, code lost:
        if (r2.remaining() >= r11) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015e, code lost:
        r2.limit(r2.capacity());
        r2.putLong(r12);
        r10.G0(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016c, code lost:
        r2.putLong(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016f, code lost:
        r10.E0(r2, r7, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0176, code lost:
        if (r7.h() != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (r10.z() == false) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017e, code lost:
        r10.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0181, code lost:
        r10.J1();
        r10.X1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0188, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0189, code lost:
        r6 = r10;
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c6, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object v2(io.ktor.utils.io.ByteBufferChannel r10, long r11, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteBufferChannel$writeLong$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.ktor.utils.io.ByteBufferChannel$writeLong$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeLong$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeLong$1
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            r5 = 0
            switch(r2) {
                case 0: goto L_0x006f;
                case 1: goto L_0x006a;
                case 2: goto L_0x006a;
                case 3: goto L_0x006a;
                case 4: goto L_0x0059;
                case 5: goto L_0x003e;
                case 6: goto L_0x006a;
                case 7: goto L_0x006a;
                case 8: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002f:
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0121
        L_0x003e:
            int r10 = r0.I$0
            long r11 = r0.J$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.io.ByteBufferChannel) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r7 = (io.ktor.utils.io.internal.RingBufferCapacity) r7
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0056 }
            r12 = r11
            r11 = r10
            r10 = r6
            goto L_0x00f5
        L_0x0056:
            r10 = move-exception
            goto L_0x018b
        L_0x0059:
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r8 = r10
            r10 = r12
            r11 = r8
            goto L_0x00a7
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x01c4
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r13)
            io.ktor.utils.io.internal.JoiningState r13 = r10.joining
            if (r13 == 0) goto L_0x0085
            io.ktor.utils.io.ByteBufferChannel r13 = r10.H1(r10, r13)
            if (r13 == 0) goto L_0x0085
            r0.label = r4
            java.lang.Object r10 = r13.H(r11, r0)
            if (r10 != r1) goto L_0x01c4
            return r1
        L_0x0085:
            java.nio.ByteBuffer r13 = r10.S1()
            if (r13 != 0) goto L_0x00d1
            io.ktor.utils.io.internal.JoiningState r13 = r10.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r10.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r3) goto L_0x00a6
            io.ktor.utils.io.ByteBufferChannel r10 = r13.e()
            r13 = 2
            r0.label = r13
            java.lang.Object r10 = r10.H(r11, r0)
            if (r10 != r1) goto L_0x01c4
            return r1
        L_0x00a6:
            r2 = r13
        L_0x00a7:
            io.ktor.utils.io.internal.ReadWriteBufferState r13 = r10.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r13 != r3) goto L_0x00c1
            io.ktor.utils.io.ByteBufferChannel r10 = r2.e()
            r0.L$0 = r5
            r0.L$1 = r5
            r13 = 3
            r0.label = r13
            java.lang.Object r10 = r10.H(r11, r0)
            if (r10 != r1) goto L_0x01c4
            return r1
        L_0x00c1:
            r0.L$0 = r2
            r0.L$1 = r10
            r0.J$0 = r11
            r13 = 4
            r0.label = r13
            java.lang.Object r13 = r10.z2(r4, r0)
            if (r13 != r1) goto L_0x00a7
            return r1
        L_0x00d1:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r10.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.b
            boolean r6 = r2.p(r3)
            if (r6 != 0) goto L_0x0192
            r7 = r2
            r2 = r13
            r12 = r11
            r11 = r3
        L_0x00e1:
            r0.L$0 = r7     // Catch:{ all -> 0x0188 }
            r0.L$1 = r10     // Catch:{ all -> 0x0188 }
            r0.L$2 = r2     // Catch:{ all -> 0x0188 }
            r0.J$0 = r12     // Catch:{ all -> 0x0188 }
            r0.I$0 = r11     // Catch:{ all -> 0x0188 }
            r6 = 5
            r0.label = r6     // Catch:{ all -> 0x0188 }
            java.lang.Object r6 = r10.z2(r11, r0)     // Catch:{ all -> 0x0188 }
            if (r6 != r1) goto L_0x00f5
            return r1
        L_0x00f5:
            io.ktor.utils.io.internal.JoiningState r6 = r10.joining
            if (r6 == 0) goto L_0x014e
            r10.J1()
            io.ktor.utils.io.internal.JoiningState r11 = r10.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r10.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r6 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r6) goto L_0x011d
            io.ktor.utils.io.ByteBufferChannel r10 = r11.e()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r11 = 6
            r0.label = r11
            java.lang.Object r10 = r10.H(r12, r0)
            if (r10 != r1) goto L_0x01c4
            return r1
        L_0x011d:
            r2 = r11
            r8 = r12
            r12 = r10
            r10 = r8
        L_0x0121:
            io.ktor.utils.io.internal.ReadWriteBufferState r13 = r12.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r6 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r13 != r6) goto L_0x013d
            io.ktor.utils.io.ByteBufferChannel r12 = r2.e()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r13 = 7
            r0.label = r13
            java.lang.Object r10 = r12.H(r10, r0)
            if (r10 != r1) goto L_0x01c4
            return r1
        L_0x013d:
            r0.L$0 = r2
            r0.L$1 = r12
            r0.L$2 = r5
            r0.J$0 = r10
            r0.label = r3
            java.lang.Object r13 = r12.z2(r4, r0)
            if (r13 != r1) goto L_0x0121
            return r1
        L_0x014e:
            boolean r6 = r7.p(r11)
            if (r6 != 0) goto L_0x0155
            goto L_0x00e1
        L_0x0155:
            r10.a1(r2, r11)
            int r0 = r2.remaining()
            if (r0 >= r11) goto L_0x016c
            int r0 = r2.capacity()
            r2.limit(r0)
            r2.putLong(r12)
            r10.G0(r2)
            goto L_0x016f
        L_0x016c:
            r2.putLong(r12)
        L_0x016f:
            r10.E0(r2, r7, r11)
            boolean r11 = r7.h()
            if (r11 != 0) goto L_0x017e
            boolean r11 = r10.z()
            if (r11 == 0) goto L_0x0181
        L_0x017e:
            r10.flush()
        L_0x0181:
            r10.J1()
            r10.X1()
            goto L_0x01c4
        L_0x0188:
            r11 = move-exception
            r6 = r10
            r10 = r11
        L_0x018b:
            r6.J1()
            r6.X1()
            throw r10
        L_0x0192:
            r10.a1(r13, r3)
            int r0 = r13.remaining()
            if (r0 >= r3) goto L_0x01a9
            int r0 = r13.capacity()
            r13.limit(r0)
            r13.putLong(r11)
            r10.G0(r13)
            goto L_0x01ac
        L_0x01a9:
            r13.putLong(r11)
        L_0x01ac:
            r10.E0(r13, r2, r3)
            boolean r11 = r2.h()
            if (r11 != 0) goto L_0x01bb
            boolean r11 = r10.z()
            if (r11 == 0) goto L_0x01be
        L_0x01bb:
            r10.flush()
        L_0x01be:
            r10.J1()
            r10.X1()
        L_0x01c4:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.v2(io.ktor.utils.io.ByteBufferChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object w2(ByteBufferChannel byteBufferChannel, ByteReadPacket byteReadPacket, Continuation continuation) {
        ByteBufferChannel H1;
        ByteBufferChannel H12;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState == null || (H12 = byteBufferChannel.H1(byteBufferChannel, joiningState)) == null) {
            do {
                try {
                    if (!(!byteReadPacket.c0()) || byteBufferChannel.Y1(byteReadPacket) == 0) {
                    }
                    break;
                } catch (Throwable th) {
                    byteReadPacket.release();
                    throw th;
                }
            } while (byteBufferChannel.Y1(byteReadPacket) == 0);
            if (byteReadPacket.r0() <= 0) {
                return Unit.INSTANCE;
            }
            JoiningState joiningState2 = byteBufferChannel.joining;
            if (joiningState2 == null || (H1 = byteBufferChannel.H1(byteBufferChannel, joiningState2)) == null) {
                Object x2 = byteBufferChannel.x2(byteReadPacket, continuation);
                return x2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? x2 : Unit.INSTANCE;
            }
            Object w = H1.w(byteReadPacket, continuation);
            return w == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? w : Unit.INSTANCE;
        }
        Object w2 = H12.w(byteReadPacket, continuation);
        return w2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? w2 : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        if (r8.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bf, code lost:
        if (r2.e().t((short) r9, r0) != r1) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c2, code lost:
        r0.L$0 = r2;
        r0.L$1 = r8;
        r0.S$0 = r9;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cf, code lost:
        if (r8.z2(1, r0) != r1) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.L$2 = r10;
        r0.S$0 = r9;
        r0.I$0 = r2;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f0, code lost:
        if (r8.z2(r2, r0) != r1) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f2, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f5, code lost:
        if (r8.joining == null) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f7, code lost:
        r8.J1();
        r10 = r8.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        if (r8.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0107, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0119, code lost:
        if (r10.e().t((short) r9, r0) != r1) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011c, code lost:
        r2 = r10;
        r7 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        if (r9.R0() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0128, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
        if (r2.e().t((short) r8, r0) != r1) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013d, code lost:
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.L$2 = null;
        r0.S$0 = r8;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014d, code lost:
        if (r9.z2(1, r0) != r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0154, code lost:
        if (r6.p(r2) != false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0157, code lost:
        r8.a1(r10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015e, code lost:
        if (r10.remaining() >= r2) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0160, code lost:
        r10.limit(r10.capacity());
        r10.putShort((short) r9);
        r8.G0(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        r10.putShort((short) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0173, code lost:
        r8.E0(r10, r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x017a, code lost:
        if (r6.h() != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0180, code lost:
        if (r8.z() == false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0182, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0185, code lost:
        r8.J1();
        r8.X1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        r5 = r8;
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cc, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object y2(io.ktor.utils.io.ByteBufferChannel r8, short r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeShort$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeShort$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeShort$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeShort$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x006d;
                case 1: goto L_0x0068;
                case 2: goto L_0x0068;
                case 3: goto L_0x0068;
                case 4: goto L_0x0057;
                case 5: goto L_0x003c;
                case 6: goto L_0x0068;
                case 7: goto L_0x0068;
                case 8: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            short r8 = r0.S$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0120
        L_0x003c:
            int r8 = r0.I$0
            short r9 = r0.S$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r6 = (io.ktor.utils.io.internal.RingBufferCapacity) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0054 }
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x00f3
        L_0x0054:
            r8 = move-exception
            goto L_0x018f
        L_0x0057:
            short r8 = r0.S$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00a7
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x01ca
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            if (r10 == 0) goto L_0x0084
            io.ktor.utils.io.ByteBufferChannel r10 = r8.H1(r8, r10)
            if (r10 == 0) goto L_0x0084
            short r8 = (short) r9
            r0.label = r3
            java.lang.Object r8 = r10.t(r8, r0)
            if (r8 != r1) goto L_0x01ca
            return r1
        L_0x0084:
            java.nio.ByteBuffer r10 = r8.S1()
            r2 = 2
            if (r10 != 0) goto L_0x00d2
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r6 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r5 != r6) goto L_0x00a6
            io.ktor.utils.io.ByteBufferChannel r8 = r10.e()
            short r9 = (short) r9
            r0.label = r2
            java.lang.Object r8 = r8.t(r9, r0)
            if (r8 != r1) goto L_0x01ca
            return r1
        L_0x00a6:
            r2 = r10
        L_0x00a7:
            io.ktor.utils.io.internal.ReadWriteBufferState r10 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r10 != r5) goto L_0x00c2
            io.ktor.utils.io.ByteBufferChannel r8 = r2.e()
            short r9 = (short) r9
            r0.L$0 = r4
            r0.L$1 = r4
            r10 = 3
            r0.label = r10
            java.lang.Object r8 = r8.t(r9, r0)
            if (r8 != r1) goto L_0x01ca
            return r1
        L_0x00c2:
            r0.L$0 = r2
            r0.L$1 = r8
            r0.S$0 = r9
            r10 = 4
            r0.label = r10
            java.lang.Object r10 = r8.z2(r3, r0)
            if (r10 != r1) goto L_0x00a7
            return r1
        L_0x00d2:
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r8.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r5 = r5.b
            boolean r6 = r5.p(r2)
            if (r6 != 0) goto L_0x0196
            r6 = r5
        L_0x00df:
            r0.L$0 = r6     // Catch:{ all -> 0x018c }
            r0.L$1 = r8     // Catch:{ all -> 0x018c }
            r0.L$2 = r10     // Catch:{ all -> 0x018c }
            r0.S$0 = r9     // Catch:{ all -> 0x018c }
            r0.I$0 = r2     // Catch:{ all -> 0x018c }
            r5 = 5
            r0.label = r5     // Catch:{ all -> 0x018c }
            java.lang.Object r5 = r8.z2(r2, r0)     // Catch:{ all -> 0x018c }
            if (r5 != r1) goto L_0x00f3
            return r1
        L_0x00f3:
            io.ktor.utils.io.internal.JoiningState r5 = r8.joining
            if (r5 == 0) goto L_0x0150
            r8.J1()
            io.ktor.utils.io.internal.JoiningState r10 = r8.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r8.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r2 != r5) goto L_0x011c
            io.ktor.utils.io.ByteBufferChannel r8 = r10.e()
            short r9 = (short) r9
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r10 = 6
            r0.label = r10
            java.lang.Object r8 = r8.t(r9, r0)
            if (r8 != r1) goto L_0x01ca
            return r1
        L_0x011c:
            r2 = r10
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x0120:
            io.ktor.utils.io.internal.ReadWriteBufferState r10 = r9.R0()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.c
            if (r10 != r5) goto L_0x013d
            io.ktor.utils.io.ByteBufferChannel r9 = r2.e()
            short r8 = (short) r8
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r10 = 7
            r0.label = r10
            java.lang.Object r8 = r9.t(r8, r0)
            if (r8 != r1) goto L_0x01ca
            return r1
        L_0x013d:
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r4
            r0.S$0 = r8
            r10 = 8
            r0.label = r10
            java.lang.Object r10 = r9.z2(r3, r0)
            if (r10 != r1) goto L_0x0120
            return r1
        L_0x0150:
            boolean r5 = r6.p(r2)
            if (r5 != 0) goto L_0x0157
            goto L_0x00df
        L_0x0157:
            r8.a1(r10, r2)
            int r0 = r10.remaining()
            if (r0 >= r2) goto L_0x016f
            int r0 = r10.capacity()
            r10.limit(r0)
            short r9 = (short) r9
            r10.putShort(r9)
            r8.G0(r10)
            goto L_0x0173
        L_0x016f:
            short r9 = (short) r9
            r10.putShort(r9)
        L_0x0173:
            r8.E0(r10, r6, r2)
            boolean r9 = r6.h()
            if (r9 != 0) goto L_0x0182
            boolean r9 = r8.z()
            if (r9 == 0) goto L_0x0185
        L_0x0182:
            r8.flush()
        L_0x0185:
            r8.J1()
            r8.X1()
            goto L_0x01ca
        L_0x018c:
            r9 = move-exception
            r5 = r8
            r8 = r9
        L_0x018f:
            r5.J1()
            r5.X1()
            throw r8
        L_0x0196:
            r8.a1(r10, r2)
            int r0 = r10.remaining()
            if (r0 >= r2) goto L_0x01ae
            int r0 = r10.capacity()
            r10.limit(r0)
            short r9 = (short) r9
            r10.putShort(r9)
            r8.G0(r10)
            goto L_0x01b2
        L_0x01ae:
            short r9 = (short) r9
            r10.putShort(r9)
        L_0x01b2:
            r8.E0(r10, r5, r2)
            boolean r9 = r5.h()
            if (r9 != 0) goto L_0x01c1
            boolean r9 = r8.z()
            if (r9 == 0) goto L_0x01c4
        L_0x01c1:
            r8.flush()
        L_0x01c4:
            r8.J1()
            r8.X1()
        L_0x01ca:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.y2(io.ktor.utils.io.ByteBufferChannel, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object z1(io.ktor.utils.io.ByteBufferChannel r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
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
            java.lang.Object r5 = r5.A1(r7, r6, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.z1(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object A(long j2, Continuation continuation) {
        return u1(this, j2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object A0(int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.w1(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L_0x0058
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r4.R0()
            boolean r6 = r6.a()
            if (r6 == 0) goto L_0x0058
            r4.R1()
        L_0x0058:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.A0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object A1(Appendable appendable, int i2, Continuation continuation) {
        return C1(appendable, i2, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    public final java.lang.Object A2(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0076
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r5 = r10
            r10 = r7
            r7 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x005e
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r11)
        L_0x004d:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.label = r4
            java.lang.Object r11 = r7.Z1(r4, r0)
            if (r11 != r1) goto L_0x005e
            return r1
        L_0x005e:
            io.ktor.utils.io.internal.JoiningState r11 = r7.joining
            if (r11 == 0) goto L_0x0077
            io.ktor.utils.io.ByteBufferChannel r11 = r7.H1(r7, r11)
            if (r11 == 0) goto L_0x0077
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r11 = r11.A2(r8, r9, r10, r0)
            if (r11 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r11
        L_0x0077:
            int r11 = r7.d2(r8, r9, r10)
            if (r11 <= 0) goto L_0x004d
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.A2(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object B(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readDouble$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readDouble$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readDouble$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readDouble$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readDouble$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r9 = r0
            r0 = r10
            r10 = r2
        L_0x0031:
            r2 = r9
            goto L_0x00ae
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 8
        L_0x0041:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.nio.ByteBuffer r4 = r10.R1()
            r5 = 0
            if (r4 != 0) goto L_0x004e
            goto L_0x0081
        L_0x004e:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r10.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.b
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x0070 }
            if (r7 != 0) goto L_0x005f
        L_0x0058:
            r10.I1()
            r10.X1()
            goto L_0x0081
        L_0x005f:
            boolean r7 = r6.m(r11)     // Catch:{ all -> 0x0070 }
            if (r7 != 0) goto L_0x0066
            goto L_0x0058
        L_0x0066:
            int r5 = r4.remaining()     // Catch:{ all -> 0x0070 }
            if (r5 >= r11) goto L_0x0072
            r10.N1(r4, r11)     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r11 = move-exception
            goto L_0x00d5
        L_0x0072:
            long r7 = r4.getLong()     // Catch:{ all -> 0x0070 }
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)     // Catch:{ all -> 0x0070 }
            r2.element = r5     // Catch:{ all -> 0x0070 }
            r10.D0(r4, r6, r11)     // Catch:{ all -> 0x0070 }
            r5 = r3
            goto L_0x0058
        L_0x0081:
            if (r5 == 0) goto L_0x009d
            T r10 = r2.element
            if (r10 != 0) goto L_0x008e
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            goto L_0x0090
        L_0x008e:
            java.lang.Number r10 = (java.lang.Number) r10
        L_0x0090:
            long r10 = r10.longValue()
            double r10 = java.lang.Double.longBitsToDouble(r10)
            java.lang.Double r10 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r10)
            return r10
        L_0x009d:
            r0.L$0 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r2 = r10.w1(r11, r0)
            if (r2 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            r9 = r0
            r0 = r11
            r11 = r2
            goto L_0x0031
        L_0x00ae:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00b9
            r11 = r0
            r0 = r2
            goto L_0x0041
        L_0x00b9:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "EOF while "
            r11.append(r1)
            r11.append(r0)
            java.lang.String r0 = " bytes expected"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x00d5:
            r10.I1()
            r10.X1()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object B0(Continuation continuation) {
        if (O0() != null) {
            return Unit.INSTANCE;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            Object a2 = joiningState.a(continuation);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
        } else if (O0() != null) {
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("Only works for joined.".toString());
        }
    }

    public final void B2(int i2, CancellableContinuation cancellableContinuation) {
        Throwable c2;
        while (true) {
            ClosedElement O0 = O0();
            if (O0 != null && (c2 = O0.c()) != null) {
                Void unused = ByteBufferChannelKt.b(c2);
                throw new KotlinNothingValueException();
            } else if (!C2(i2)) {
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
                break;
            } else {
                while (U0() == null) {
                    if (C2(i2)) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p;
                        if (a.a(atomicReferenceFieldUpdater, this, (Object) null, cancellableContinuation)) {
                            if (C2(i2) || !a.a(atomicReferenceFieldUpdater, this, cancellableContinuation, (Object) null)) {
                                break;
                            }
                        }
                    }
                }
                throw new IllegalStateException("Operation is already in progress".toString());
            }
        }
        N0(i2);
        if (T1()) {
            L1();
        }
    }

    public Object C(byte b2, Continuation continuation) {
        return n2(this, b2, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object C0(int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
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
            goto L_0x006d
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0055
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.z2(r6, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            io.ktor.utils.io.internal.JoiningState r8 = r5.joining
            if (r8 == 0) goto L_0x0070
            io.ktor.utils.io.ByteBufferChannel r5 = r5.H1(r5, r8)
            if (r5 == 0) goto L_0x0070
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r5 = r5.x(r6, r7, r0)
            if (r5 != r1) goto L_0x006d
            return r1
        L_0x006d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0070:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.C0(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object C1(Appendable appendable, int i2, Continuation continuation) {
        if (R0() != ReadWriteBufferState.Terminated.c) {
            return D1(appendable, i2, continuation);
        }
        Throwable f2 = f();
        if (f2 == null) {
            return Boxing.boxBoolean(false);
        }
        throw f2;
    }

    public final boolean C2(int i2) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState R0 = R0();
        if (O0() != null) {
            return false;
        }
        if (joiningState == null) {
            if (R0.b._availableForWrite$internal >= i2 || R0 == ReadWriteBufferState.IdleEmpty.c) {
                return false;
            }
        } else if (R0 == ReadWriteBufferState.Terminated.c || (R0 instanceof ReadWriteBufferState.Writing) || (R0 instanceof ReadWriteBufferState.ReadingWriting)) {
            return false;
        }
        return true;
    }

    public Object D(byte[] bArr, int i2, int i3, Continuation continuation) {
        return i1(this, bArr, i2, i3, continuation);
    }

    public final void D0(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i2) {
        if (i2 >= 0) {
            this.e = H0(byteBuffer, this.e + i2);
            ringBufferCapacity.a(i2);
            P1(S0() + ((long) i2));
            M1();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:(2:34|35)|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|(1:53)(5:54|55|56|23|(0)(0))|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(20:34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|(1:53)(5:54|55|56|23|(0)(0))|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0136, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0138, code lost:
        r13 = r3;
        r15 = r5;
        r10 = r7;
        r14 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013d, code lost:
        r11 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0140, code lost:
        r9 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
        r9 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0145, code lost:
        r11 = r17;
        r12 = r18;
        r8 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014c, code lost:
        r9 = r23;
        r7 = r24;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6 A[SYNTHETIC, Splitter:B:34:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D1(java.lang.Appendable r23, int r24, kotlin.coroutines.Continuation r25) {
        /*
            r22 = this;
            r0 = r25
            boolean r1 = r0 instanceof io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r1 = (io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r22
            goto L_0x001e
        L_0x0017:
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r1 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1
            r2 = r22
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0085
            if (r4 == r6) goto L_0x004e
            if (r4 != r5) goto L_0x0046
            java.lang.Object r2 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r3 = r1.L$2
            kotlin.jvm.internal.Ref$BooleanRef r3 = (kotlin.jvm.internal.Ref.BooleanRef) r3
            java.lang.Object r4 = r1.L$1
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r1 = r1.L$0
            io.ktor.utils.io.ByteBufferChannel r1 = (io.ktor.utils.io.ByteBufferChannel) r1
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ EOFException -> 0x0041 }
        L_0x0041:
            r5 = r2
            r2 = r1
            r1 = r6
            goto L_0x019c
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            int r2 = r1.I$0
            java.lang.Object r4 = r1.L$8
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r7 = r1.L$7
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r1.L$6
            char[] r8 = (char[]) r8
            java.lang.Object r9 = r1.L$5
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$4
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r1.L$2
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            java.lang.Object r13 = r1.L$1
            java.lang.Appendable r13 = (java.lang.Appendable) r13
            java.lang.Object r14 = r1.L$0
            io.ktor.utils.io.ByteBufferChannel r14 = (io.ktor.utils.io.ByteBufferChannel) r14
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ EOFException -> 0x0077 }
        L_0x0077:
            r15 = r9
            r0 = r13
            r9 = r8
            r13 = r12
            r12 = r3
            r3 = r4
            r4 = r1
            r1 = r2
            r2 = r14
            r14 = r10
            r10 = r11
            r11 = r7
            goto L_0x012e
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            kotlin.jvm.internal.Ref$IntRef r4 = new kotlin.jvm.internal.Ref$IntRef
            r4.<init>()
            r4.element = r6
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r9 = 8192(0x2000, float:1.14794E-41)
            char[] r9 = new char[r9]
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef
            r11.<init>()
            r13 = r0
            r14 = r7
            r15 = r8
            r12 = r11
            r0 = r23
            r11 = r10
            r10 = r4
            r4 = r1
            r1 = r24
        L_0x00b7:
            boolean r7 = r2.Q()
            if (r7 != 0) goto L_0x00cf
            boolean r7 = r15.element
            if (r7 != 0) goto L_0x00cf
            boolean r7 = r14.element
            if (r7 != 0) goto L_0x00cf
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r7) goto L_0x00d6
            int r7 = r13.element
            if (r7 > r1) goto L_0x00cf
            goto L_0x00d6
        L_0x00cf:
            r12 = r3
            r6 = r11
            r3 = r13
            r8 = r14
            r5 = r15
            goto L_0x0159
        L_0x00d6:
            int r8 = r10.element     // Catch:{ EOFException -> 0x0151 }
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2 r7 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2     // Catch:{ EOFException -> 0x0151 }
            r22 = r7
            r7 = r22
            r5 = r8
            r8 = r11
            r23 = r9
            r9 = r1
            r24 = r10
            r10 = r23
            r6 = r11
            r11 = r13
            r17 = r12
            r12 = r24
            r18 = r3
            r3 = r13
            r13 = r15
            r19 = r14
            r20 = r5
            r5 = r15
            r15 = r0
            r16 = r17
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ EOFException -> 0x014c }
            r4.L$0 = r2     // Catch:{ EOFException -> 0x014c }
            r4.L$1 = r0     // Catch:{ EOFException -> 0x014c }
            r4.L$2 = r3     // Catch:{ EOFException -> 0x014c }
            r7 = r24
            r4.L$3 = r7     // Catch:{ EOFException -> 0x0143 }
            r8 = r19
            r4.L$4 = r8     // Catch:{ EOFException -> 0x0140 }
            r4.L$5 = r5     // Catch:{ EOFException -> 0x0140 }
            r9 = r23
            r4.L$6 = r9     // Catch:{ EOFException -> 0x013d }
            r4.L$7 = r6     // Catch:{ EOFException -> 0x013d }
            r11 = r17
            r4.L$8 = r11     // Catch:{ EOFException -> 0x0136 }
            r4.I$0 = r1     // Catch:{ EOFException -> 0x0136 }
            r10 = 1
            r4.label = r10     // Catch:{ EOFException -> 0x0136 }
            r12 = r22
            r10 = r20
            java.lang.Object r10 = r2.K(r10, r12, r4)     // Catch:{ EOFException -> 0x0136 }
            r12 = r18
            if (r10 != r12) goto L_0x0128
            return r12
        L_0x0128:
            r13 = r3
            r15 = r5
            r10 = r7
            r14 = r8
        L_0x012c:
            r3 = r11
            r11 = r6
        L_0x012e:
            r5 = 2
            r6 = 1
            r21 = r12
            r12 = r3
            r3 = r21
            goto L_0x00b7
        L_0x0136:
            r12 = r18
        L_0x0138:
            r13 = r3
            r15 = r5
            r10 = r7
            r14 = r8
            goto L_0x012c
        L_0x013d:
            r11 = r17
            goto L_0x0136
        L_0x0140:
            r9 = r23
            goto L_0x013d
        L_0x0143:
            r9 = r23
        L_0x0145:
            r11 = r17
            r12 = r18
            r8 = r19
            goto L_0x0138
        L_0x014c:
            r9 = r23
            r7 = r24
            goto L_0x0145
        L_0x0151:
            r7 = r10
            r6 = r11
            r11 = r12
            r8 = r14
            r5 = r15
            r12 = r3
            r3 = r13
            goto L_0x012c
        L_0x0159:
            T r0 = r6.element
            if (r0 == 0) goto L_0x0169
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.utils.io.internal.ObjectPoolKt.d()
            T r1 = r6.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r0.recycle(r1)
        L_0x0169:
            boolean r0 = r2.Q()
            if (r0 != 0) goto L_0x01a2
            boolean r0 = r8.element
            if (r0 == 0) goto L_0x01a2
            boolean r0 = r5.element
            if (r0 != 0) goto L_0x01a2
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$3     // Catch:{ EOFException -> 0x01a0 }
            r0.<init>(r5)     // Catch:{ EOFException -> 0x01a0 }
            r4.L$0 = r2     // Catch:{ EOFException -> 0x01a0 }
            r4.L$1 = r3     // Catch:{ EOFException -> 0x01a0 }
            r4.L$2 = r8     // Catch:{ EOFException -> 0x01a0 }
            r4.L$3 = r5     // Catch:{ EOFException -> 0x01a0 }
            r1 = 0
            r4.L$4 = r1     // Catch:{ EOFException -> 0x01a0 }
            r4.L$5 = r1     // Catch:{ EOFException -> 0x01a0 }
            r4.L$6 = r1     // Catch:{ EOFException -> 0x01a0 }
            r4.L$7 = r1     // Catch:{ EOFException -> 0x01a0 }
            r4.L$8 = r1     // Catch:{ EOFException -> 0x01a0 }
            r1 = 2
            r4.label = r1     // Catch:{ EOFException -> 0x01a0 }
            r1 = 1
            java.lang.Object r0 = r2.K(r1, r0, r4)     // Catch:{ EOFException -> 0x019a }
            if (r0 != r12) goto L_0x019a
            return r12
        L_0x019a:
            r4 = r3
            r3 = r8
        L_0x019c:
            r14 = r3
            r13 = r4
            r15 = r5
            goto L_0x01a6
        L_0x01a0:
            r1 = 1
            goto L_0x019a
        L_0x01a2:
            r1 = 1
            r13 = r3
            r15 = r5
            r14 = r8
        L_0x01a6:
            boolean r0 = r2.Q()
            if (r0 == 0) goto L_0x01b0
            int r0 = r13.element
            if (r0 > 0) goto L_0x01bb
        L_0x01b0:
            boolean r0 = r15.element
            if (r0 != 0) goto L_0x01bb
            boolean r0 = r14.element
            if (r0 == 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            r6 = 0
            goto L_0x01bc
        L_0x01bb:
            r6 = r1
        L_0x01bc:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.D1(java.lang.Appendable, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object E(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readLong$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readLong$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r9 = r0
            r0 = r10
            r10 = r2
        L_0x0031:
            r2 = r9
            goto L_0x00a2
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 8
        L_0x0041:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.nio.ByteBuffer r4 = r10.R1()
            r5 = 0
            if (r4 != 0) goto L_0x004e
            goto L_0x0081
        L_0x004e:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r10.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.b
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x0070 }
            if (r7 != 0) goto L_0x005f
        L_0x0058:
            r10.I1()
            r10.X1()
            goto L_0x0081
        L_0x005f:
            boolean r7 = r6.m(r11)     // Catch:{ all -> 0x0070 }
            if (r7 != 0) goto L_0x0066
            goto L_0x0058
        L_0x0066:
            int r5 = r4.remaining()     // Catch:{ all -> 0x0070 }
            if (r5 >= r11) goto L_0x0072
            r10.N1(r4, r11)     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r11 = move-exception
            goto L_0x00c9
        L_0x0072:
            long r7 = r4.getLong()     // Catch:{ all -> 0x0070 }
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)     // Catch:{ all -> 0x0070 }
            r2.element = r5     // Catch:{ all -> 0x0070 }
            r10.D0(r4, r6, r11)     // Catch:{ all -> 0x0070 }
            r5 = r3
            goto L_0x0058
        L_0x0081:
            if (r5 == 0) goto L_0x0091
            T r10 = r2.element
            if (r10 != 0) goto L_0x008e
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            goto L_0x0090
        L_0x008e:
            java.lang.Number r10 = (java.lang.Number) r10
        L_0x0090:
            return r10
        L_0x0091:
            r0.L$0 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r2 = r10.w1(r11, r0)
            if (r2 != r1) goto L_0x009e
            return r1
        L_0x009e:
            r9 = r0
            r0 = r11
            r11 = r2
            goto L_0x0031
        L_0x00a2:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00ad
            r11 = r0
            r0 = r2
            goto L_0x0041
        L_0x00ad:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "EOF while "
            r11.append(r1)
            r11.append(r0)
            java.lang.String r0 = " bytes expected"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x00c9:
            r10.I1()
            r10.X1()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.E(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void E0(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i2) {
        if (i2 >= 0) {
            this.f = H0(byteBuffer, this.f + i2);
            ringBufferCapacity.c(i2);
            Q1(T0() + ((long) i2));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void E1(ReadWriteBufferState.Initial initial) {
        this.c.recycle(initial);
    }

    public Object F(Function2 function2, Continuation continuation) {
        return D2(this, function2, continuation);
    }

    public final void F0(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        Intrinsics.checkNotNullParameter(ringBufferCapacity, "capacity");
        E0(byteBuffer, ringBufferCapacity, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        return r0.F0();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.ktor.utils.io.core.ByteReadPacket F1(long r10) {
        /*
            r9 = this;
            io.ktor.utils.io.core.BytePacketBuilder r0 = new io.ktor.utils.io.core.BytePacketBuilder
            r1 = 0
            r2 = 1
            r0.<init>(r1, r2, r1)
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.d(r0, r2, r1)     // Catch:{ all -> 0x0045 }
        L_0x000b:
            int r3 = r1.g()     // Catch:{ all -> 0x001e }
            int r4 = r1.k()     // Catch:{ all -> 0x001e }
            int r3 = r3 - r4
            long r3 = (long) r3     // Catch:{ all -> 0x001e }
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0020
            int r3 = (int) r10     // Catch:{ all -> 0x001e }
            r1.u(r3)     // Catch:{ all -> 0x001e }
            goto L_0x0020
        L_0x001e:
            r9 = move-exception
            goto L_0x0047
        L_0x0020:
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            r3 = r9
            r4 = r1
            int r3 = f1(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x001e }
            long r3 = (long) r3     // Catch:{ all -> 0x001e }
            long r10 = r10 - r3
            r3 = 0
            int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x003d
            boolean r3 = r9.Q()     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x003d
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.d(r0, r2, r1)     // Catch:{ all -> 0x001e }
            goto L_0x000b
        L_0x003d:
            r0.b()     // Catch:{ all -> 0x0045 }
            io.ktor.utils.io.core.ByteReadPacket r9 = r0.F0()     // Catch:{ all -> 0x0045 }
            return r9
        L_0x0045:
            r9 = move-exception
            goto L_0x004b
        L_0x0047:
            r0.b()     // Catch:{ all -> 0x0045 }
            throw r9     // Catch:{ all -> 0x0045 }
        L_0x004b:
            r0.release()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.F1(long):io.ktor.utils.io.core.ByteReadPacket");
    }

    public final boolean F2(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, Function1 function1) {
        int capacity = byteBuffer.capacity() - this.d;
        boolean z = true;
        while (z) {
            int n2 = ringBufferCapacity.n(1);
            if (n2 == 0) {
                break;
            }
            int i2 = this.f;
            int coerceAtMost = RangesKt.coerceAtMost(i2 + n2, capacity);
            byteBuffer.limit(coerceAtMost);
            byteBuffer.position(i2);
            try {
                boolean booleanValue = ((Boolean) function1.invoke(byteBuffer)).booleanValue();
                if (byteBuffer.limit() == coerceAtMost) {
                    int position = byteBuffer.position() - i2;
                    if (position >= 0) {
                        E0(byteBuffer, ringBufferCapacity, position);
                        if (position < n2) {
                            n2 -= position;
                        }
                        z = booleanValue;
                    } else {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                    }
                } else {
                    throw new IllegalStateException("Buffer limit modified.".toString());
                }
            } finally {
                ringBufferCapacity.a(n2);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object G(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readShort$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readShort$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L_0x0031:
            r2 = r8
            goto L_0x00a1
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 2
        L_0x0040:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.R1()
            r5 = 0
            if (r4 != 0) goto L_0x004d
            goto L_0x0080
        L_0x004d:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r9.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.b
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x005e
        L_0x0057:
            r9.I1()
            r9.X1()
            goto L_0x0080
        L_0x005e:
            boolean r7 = r6.m(r10)     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            int r5 = r4.remaining()     // Catch:{ all -> 0x006f }
            if (r5 >= r10) goto L_0x0071
            r9.N1(r4, r10)     // Catch:{ all -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r10 = move-exception
            goto L_0x00c8
        L_0x0071:
            short r5 = r4.getShort()     // Catch:{ all -> 0x006f }
            java.lang.Short r5 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r5)     // Catch:{ all -> 0x006f }
            r2.element = r5     // Catch:{ all -> 0x006f }
            r9.D0(r4, r6, r10)     // Catch:{ all -> 0x006f }
            r5 = r3
            goto L_0x0057
        L_0x0080:
            if (r5 == 0) goto L_0x0090
            T r9 = r2.element
            if (r9 != 0) goto L_0x008d
            java.lang.String r9 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = 0
            goto L_0x008f
        L_0x008d:
            java.lang.Number r9 = (java.lang.Number) r9
        L_0x008f:
            return r9
        L_0x0090:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.w1(r10, r0)
            if (r2 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L_0x0031
        L_0x00a1:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00ac
            r10 = r0
            r0 = r2
            goto L_0x0040
        L_0x00ac:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r9 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "EOF while "
            r10.append(r1)
            r10.append(r0)
            java.lang.String r0 = " bytes expected"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c8:
            r9.I1()
            r9.X1()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.G(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void G0(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - this.d;
        int position = byteBuffer.position();
        for (int i2 = capacity; i2 < position; i2++) {
            byteBuffer.put(i2 - capacity, byteBuffer.get(i2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = H1(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.ktor.utils.io.ByteBufferChannel G1() {
        /*
            r1 = this;
            io.ktor.utils.io.internal.JoiningState r0 = r1.joining
            if (r0 == 0) goto L_0x000c
            io.ktor.utils.io.ByteBufferChannel r0 = r1.H1(r1, r0)
            if (r0 != 0) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            r1 = r0
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.G1():io.ktor.utils.io.ByteBufferChannel");
    }

    /* JADX INFO: finally extract failed */
    public final boolean G2(Function1 function1) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = H1(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer S1 = byteBufferChannel.S1();
        if (S1 == null) {
            return true;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
        long T0 = byteBufferChannel.T0();
        try {
            ClosedElement O0 = byteBufferChannel.O0();
            if (O0 == null) {
                boolean F2 = byteBufferChannel.F2(S1, ringBufferCapacity, function1);
                if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    Q1(T0() + (byteBufferChannel.T0() - T0));
                }
                byteBufferChannel.J1();
                byteBufferChannel.X1();
                return F2;
            }
            Void unused = ByteBufferChannelKt.b(O0.c());
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                Q1(T0() + (byteBufferChannel.T0() - T0));
            }
            byteBufferChannel.J1();
            byteBufferChannel.X1();
            throw th;
        }
    }

    public Object H(long j2, Continuation continuation) {
        return v2(this, j2, continuation);
    }

    public final int H0(ByteBuffer byteBuffer, int i2) {
        return i2 >= byteBuffer.capacity() - this.d ? i2 - (byteBuffer.capacity() - this.d) : i2;
    }

    public final ByteBufferChannel H1(ByteBufferChannel byteBufferChannel, JoiningState joiningState) {
        while (byteBufferChannel.R0() == ReadWriteBufferState.Terminated.c) {
            byteBufferChannel = joiningState.e();
            joiningState = byteBufferChannel.joining;
            if (joiningState == null) {
                return byteBufferChannel;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        r4 = r1.H1(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e7, code lost:
        if (r11.O0() != null) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce A[Catch:{ all -> 0x00dd }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3 A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H2(kotlin.jvm.functions.Function1 r18, kotlin.coroutines.Continuation r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            boolean r2 = r0 instanceof io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1 r2 = (io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1 r2 = new io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0076
            if (r4 == r6) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x013b
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            long r7 = r2.J$0
            java.lang.Object r1 = r2.L$8
            io.ktor.utils.io.ByteBufferChannel r1 = (io.ktor.utils.io.ByteBufferChannel) r1
            java.lang.Object r4 = r2.L$7
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4
            java.lang.Object r9 = r2.L$6
            io.ktor.utils.io.internal.RingBufferCapacity r9 = (io.ktor.utils.io.internal.RingBufferCapacity) r9
            java.lang.Object r10 = r2.L$5
            io.ktor.utils.io.internal.RingBufferCapacity r10 = (io.ktor.utils.io.internal.RingBufferCapacity) r10
            java.lang.Object r11 = r2.L$4
            io.ktor.utils.io.ByteBufferChannel r11 = (io.ktor.utils.io.ByteBufferChannel) r11
            java.lang.Object r12 = r2.L$3
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r13 = r2.L$2
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r14 = r2.L$1
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            java.lang.Object r15 = r2.L$0
            io.ktor.utils.io.ByteBufferChannel r15 = (io.ktor.utils.io.ByteBufferChannel) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0072 }
            r0 = r14
            r14 = r13
            r13 = r11
            r11 = r1
            r1 = r15
            r16 = r4
            r4 = r2
            r2 = r12
            r12 = r10
            r10 = r9
            r8 = r7
            r7 = r16
            goto L_0x00cf
        L_0x0072:
            r0 = move-exception
            r2 = r12
            goto L_0x015d
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            r0.element = r6
            io.ktor.utils.io.internal.JoiningState r4 = r1.joining
            if (r4 == 0) goto L_0x008d
            io.ktor.utils.io.ByteBufferChannel r4 = r1.H1(r1, r4)
            if (r4 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r11 = r4
            goto L_0x008e
        L_0x008d:
            r11 = r1
        L_0x008e:
            java.nio.ByteBuffer r4 = r11.S1()
            if (r4 != 0) goto L_0x0099
            r14 = r0
            r0 = r18
            goto L_0x010e
        L_0x0099:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r11.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r10 = r7.b
            long r7 = r11.T0()
            io.ktor.utils.io.internal.ClosedElement r9 = r11.O0()     // Catch:{ all -> 0x015b }
            if (r9 != 0) goto L_0x014e
            r14 = r0
            r8 = r7
            r12 = r10
            r13 = r11
            r0 = r18
            r7 = r4
            r4 = r2
            r2 = r1
        L_0x00b2:
            r4.L$0 = r1     // Catch:{ all -> 0x00dd }
            r4.L$1 = r0     // Catch:{ all -> 0x00dd }
            r4.L$2 = r14     // Catch:{ all -> 0x00dd }
            r4.L$3 = r2     // Catch:{ all -> 0x00dd }
            r4.L$4 = r13     // Catch:{ all -> 0x00dd }
            r4.L$5 = r12     // Catch:{ all -> 0x00dd }
            r4.L$6 = r10     // Catch:{ all -> 0x00dd }
            r4.L$7 = r7     // Catch:{ all -> 0x00dd }
            r4.L$8 = r11     // Catch:{ all -> 0x00dd }
            r4.J$0 = r8     // Catch:{ all -> 0x00dd }
            r4.label = r6     // Catch:{ all -> 0x00dd }
            java.lang.Object r15 = r11.z2(r6, r4)     // Catch:{ all -> 0x00dd }
            if (r15 != r3) goto L_0x00cf
            return r3
        L_0x00cf:
            io.ktor.utils.io.internal.JoiningState r15 = r11.joining     // Catch:{ all -> 0x00dd }
            if (r15 != 0) goto L_0x00e9
            boolean r15 = r11.F2(r7, r10, r0)     // Catch:{ all -> 0x00dd }
            if (r15 != 0) goto L_0x00e3
            r6 = 0
            r14.element = r6     // Catch:{ all -> 0x00dd }
            goto L_0x00e9
        L_0x00dd:
            r0 = move-exception
            r7 = r8
            r10 = r12
            r11 = r13
            goto L_0x015d
        L_0x00e3:
            io.ktor.utils.io.internal.ClosedElement r15 = r11.O0()     // Catch:{ all -> 0x00dd }
            if (r15 == 0) goto L_0x00b2
        L_0x00e9:
            boolean r6 = r12.h()
            if (r6 != 0) goto L_0x00f5
            boolean r6 = r13.z()
            if (r6 == 0) goto L_0x00f8
        L_0x00f5:
            r13.flush()
        L_0x00f8:
            if (r13 == r2) goto L_0x0107
            long r6 = r2.T0()
            long r10 = r13.T0()
            long r10 = r10 - r8
            long r6 = r6 + r10
            r2.Q1(r6)
        L_0x0107:
            r13.J1()
            r13.X1()
            r2 = r4
        L_0x010e:
            boolean r4 = r14.element
            if (r4 != 0) goto L_0x0115
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0115:
            io.ktor.utils.io.internal.ClosedElement r4 = r1.O0()
            if (r4 != 0) goto L_0x0141
            io.ktor.utils.io.internal.JoiningState r4 = r1.joining
            if (r4 == 0) goto L_0x013e
            r4 = 0
            r2.L$0 = r4
            r2.L$1 = r4
            r2.L$2 = r4
            r2.L$3 = r4
            r2.L$4 = r4
            r2.L$5 = r4
            r2.L$6 = r4
            r2.L$7 = r4
            r2.L$8 = r4
            r2.label = r5
            java.lang.Object r0 = r1.y(r0, r2)
            if (r0 != r3) goto L_0x013b
            return r3
        L_0x013b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x013e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0141:
            java.lang.Throwable r0 = r4.c()
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.b(r0)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x014e:
            java.lang.Throwable r0 = r9.c()     // Catch:{ all -> 0x015b }
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.b(r0)     // Catch:{ all -> 0x015b }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x015b }
            r0.<init>()     // Catch:{ all -> 0x015b }
            throw r0     // Catch:{ all -> 0x015b }
        L_0x015b:
            r0 = move-exception
            r2 = r1
        L_0x015d:
            boolean r1 = r10.h()
            if (r1 != 0) goto L_0x0169
            boolean r1 = r11.z()
            if (r1 == 0) goto L_0x016c
        L_0x0169:
            r11.flush()
        L_0x016c:
            if (r11 == r2) goto L_0x017b
            long r3 = r2.T0()
            long r5 = r11.T0()
            long r5 = r5 - r7
            long r3 = r3 + r5
            r2.Q1(r3)
        L_0x017b:
            r11.J1()
            r11.X1()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.H2(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object I(byte[] bArr, int i2, int i3, Continuation continuation) {
        return q2(this, bArr, i2, i3, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v16, resolved type: io.ktor.utils.io.ByteBufferChannel} */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0385, code lost:
        if (r12.V1(r11) == false) goto L_0x0388;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01ee A[Catch:{ all -> 0x02cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01fc A[Catch:{ all -> 0x02cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0268 A[Catch:{ all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x027b A[Catch:{ all -> 0x02a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02e8 A[Catch:{ all -> 0x02ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02f9 A[Catch:{ all -> 0x02ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0316 A[SYNTHETIC, Splitter:B:173:0x0316] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0337 A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0376 A[ADDED_TO_REGION, Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x037f A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x039b A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03e6 A[Catch:{ all -> 0x02ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03fc A[SYNTHETIC, Splitter:B:225:0x03fc] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011d A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015d A[SYNTHETIC, Splitter:B:71:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0188 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object I0(io.ktor.utils.io.ByteBufferChannel r25, long r26, io.ktor.utils.io.internal.JoiningState r28, kotlin.coroutines.Continuation r29) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r28
            r3 = r29
            boolean r4 = r3 instanceof io.ktor.utils.io.ByteBufferChannel$copyDirect$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            io.ktor.utils.io.ByteBufferChannel$copyDirect$1 r4 = (io.ktor.utils.io.ByteBufferChannel$copyDirect$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            io.ktor.utils.io.ByteBufferChannel$copyDirect$1 r4 = new io.ktor.utils.io.ByteBufferChannel$copyDirect$1
            r4.<init>(r1, r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 3
            r8 = 2
            r9 = 1
            if (r6 == 0) goto L_0x00c9
            if (r6 == r9) goto L_0x0085
            if (r6 == r8) goto L_0x006a
            if (r6 != r7) goto L_0x0062
            boolean r0 = r4.Z$0
            long r1 = r4.J$0
            java.lang.Object r6 = r4.L$3
            kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
            java.lang.Object r11 = r4.L$2
            io.ktor.utils.io.internal.JoiningState r11 = (io.ktor.utils.io.internal.JoiningState) r11
            java.lang.Object r12 = r4.L$1
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r13 = r4.L$0
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005e }
            r2 = r1
            r1 = r13
            r10 = 0
            r22 = r6
            r6 = r0
            r0 = r12
            r12 = r9
            r9 = r5
            r5 = r8
            r8 = r22
            r23 = r7
            r7 = r4
            r4 = r11
            r11 = r23
            goto L_0x03bf
        L_0x005e:
            r0 = move-exception
            r1 = r13
            goto L_0x0406
        L_0x0062:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x006a:
            boolean r0 = r4.Z$0
            long r1 = r4.J$0
            java.lang.Object r6 = r4.L$3
            kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
            java.lang.Object r11 = r4.L$2
            io.ktor.utils.io.internal.JoiningState r11 = (io.ktor.utils.io.internal.JoiningState) r11
            java.lang.Object r12 = r4.L$1
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r13 = r4.L$0
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005e }
            r9 = r5
            r5 = r8
            goto L_0x036e
        L_0x0085:
            long r1 = r4.J$1
            boolean r0 = r4.Z$0
            long r11 = r4.J$0
            java.lang.Object r6 = r4.L$9
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.io.ByteBufferChannel) r6
            java.lang.Object r13 = r4.L$8
            java.nio.ByteBuffer r13 = (java.nio.ByteBuffer) r13
            java.lang.Object r14 = r4.L$7
            io.ktor.utils.io.internal.RingBufferCapacity r14 = (io.ktor.utils.io.internal.RingBufferCapacity) r14
            java.lang.Object r15 = r4.L$6
            io.ktor.utils.io.internal.RingBufferCapacity r15 = (io.ktor.utils.io.internal.RingBufferCapacity) r15
            java.lang.Object r7 = r4.L$5
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            java.lang.Object r8 = r4.L$4
            io.ktor.utils.io.ByteBufferChannel r8 = (io.ktor.utils.io.ByteBufferChannel) r8
            java.lang.Object r10 = r4.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r9 = r4.L$2
            io.ktor.utils.io.internal.JoiningState r9 = (io.ktor.utils.io.internal.JoiningState) r9
            r24 = r0
            java.lang.Object r0 = r4.L$1
            io.ktor.utils.io.ByteBufferChannel r0 = (io.ktor.utils.io.ByteBufferChannel) r0
            r25 = r0
            java.lang.Object r0 = r4.L$0
            r16 = r0
            io.ktor.utils.io.ByteBufferChannel r16 = (io.ktor.utils.io.ByteBufferChannel) r16
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x00c6 }
            r2 = r1
            r0 = r5
            r5 = r9
            r9 = r6
            r6 = r24
            r24 = r25
            goto L_0x018e
        L_0x00c6:
            r0 = move-exception
            goto L_0x03d5
        L_0x00c9:
            kotlin.ResultKt.throwOnFailure(r3)
            boolean r3 = r25.Q()
            r6 = 0
            if (r3 == 0) goto L_0x00fb
            if (r2 == 0) goto L_0x00e9
            boolean r2 = r0.V1(r2)
            if (r2 == 0) goto L_0x00dd
            goto L_0x00e9
        L_0x00dd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00e9:
            java.lang.Throwable r2 = r25.f()
            if (r2 == 0) goto L_0x00f6
            java.lang.Throwable r0 = r25.f()
            r1.h(r0)
        L_0x00f6:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r0
        L_0x00fb:
            if (r2 == 0) goto L_0x0108
            boolean r3 = r0.V1(r2)
            if (r3 == 0) goto L_0x0108
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r0
        L_0x0108:
            boolean r3 = r24.z()
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x0128 }
            r6.<init>()     // Catch:{ all -> 0x0128 }
            r7 = r4
            r8 = r6
            r4 = r2
            r6 = r3
            r2 = r26
        L_0x0117:
            long r9 = r8.element     // Catch:{ all -> 0x0128 }
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x03fa
            io.ktor.utils.io.internal.JoiningState r9 = r1.joining     // Catch:{ all -> 0x0128 }
            if (r9 == 0) goto L_0x012b
            io.ktor.utils.io.ByteBufferChannel r9 = r1.H1(r1, r9)     // Catch:{ all -> 0x0128 }
            if (r9 != 0) goto L_0x012c
            goto L_0x012b
        L_0x0128:
            r0 = move-exception
            goto L_0x0406
        L_0x012b:
            r9 = r1
        L_0x012c:
            java.nio.ByteBuffer r10 = r9.S1()     // Catch:{ all -> 0x0128 }
            if (r10 != 0) goto L_0x0136
            r20 = r5
            goto L_0x0314
        L_0x0136:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r9.R0()     // Catch:{ all -> 0x0128 }
            io.ktor.utils.io.internal.RingBufferCapacity r15 = r11.b     // Catch:{ all -> 0x0128 }
            long r11 = r9.T0()     // Catch:{ all -> 0x0128 }
            io.ktor.utils.io.internal.ClosedElement r13 = r9.O0()     // Catch:{ all -> 0x03cf }
            if (r13 != 0) goto L_0x03c2
            r16 = r5
            r13 = r10
            r24 = r11
            r14 = r15
            r5 = r1
            r11 = r2
            r3 = r4
            r4 = r7
            r10 = r8
            r7 = r9
            r8 = r5
        L_0x0153:
            long r1 = r10.element     // Catch:{ all -> 0x02d1 }
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x02d8
            int r1 = r14._availableForWrite$internal     // Catch:{ all -> 0x02d1 }
            if (r1 != 0) goto L_0x01c0
            r4.L$0 = r5     // Catch:{ all -> 0x01bc }
            r4.L$1 = r0     // Catch:{ all -> 0x01bc }
            r4.L$2 = r3     // Catch:{ all -> 0x01bc }
            r4.L$3 = r10     // Catch:{ all -> 0x01bc }
            r4.L$4 = r8     // Catch:{ all -> 0x01bc }
            r4.L$5 = r7     // Catch:{ all -> 0x01bc }
            r4.L$6 = r15     // Catch:{ all -> 0x01bc }
            r4.L$7 = r14     // Catch:{ all -> 0x01bc }
            r4.L$8 = r13     // Catch:{ all -> 0x01bc }
            r4.L$9 = r9     // Catch:{ all -> 0x01bc }
            r4.J$0 = r11     // Catch:{ all -> 0x01bc }
            r4.Z$0 = r6     // Catch:{ all -> 0x01bc }
            r1 = r24
            r4.J$1 = r1     // Catch:{ all -> 0x01b8 }
            r24 = r0
            r0 = 1
            r4.label = r0     // Catch:{ all -> 0x01b8 }
            r25 = r1
            java.lang.Object r1 = r9.Z1(r0, r4)     // Catch:{ all -> 0x01b1 }
            r0 = r16
            if (r1 != r0) goto L_0x0189
            return r0
        L_0x0189:
            r16 = r5
            r5 = r3
            r2 = r25
        L_0x018e:
            io.ktor.utils.io.internal.JoiningState r1 = r9.joining     // Catch:{ all -> 0x01a5 }
            if (r1 != 0) goto L_0x01a9
            int r1 = r14._availableForWrite$internal     // Catch:{ all -> 0x01a5 }
            r17 = r15
            r15 = r14
            r14 = r13
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r1
            r1 = r24
            r24 = r2
            goto L_0x01de
        L_0x01a5:
            r0 = move-exception
            r1 = r2
            goto L_0x03d5
        L_0x01a9:
            r20 = r0
            r1 = r2
            r3 = r5
            r0 = r24
            goto L_0x02e2
        L_0x01b1:
            r0 = move-exception
        L_0x01b2:
            r1 = r25
        L_0x01b4:
            r16 = r5
            goto L_0x03d5
        L_0x01b8:
            r0 = move-exception
            r25 = r1
            goto L_0x01b4
        L_0x01bc:
            r0 = move-exception
            r25 = r24
            goto L_0x01b2
        L_0x01c0:
            r22 = r24
            r24 = r0
            r0 = r16
            r16 = r22
            r22 = r1
            r1 = r24
            r24 = r16
            r16 = r5
            r17 = r15
            r5 = r3
            r15 = r14
            r14 = r13
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r22
        L_0x01de:
            int r2 = r10.f     // Catch:{ all -> 0x02cb }
            r10.Z0(r14, r2, r4)     // Catch:{ all -> 0x02cb }
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x02cb }
            r2.<init>()     // Catch:{ all -> 0x02cb }
            java.nio.ByteBuffer r3 = r1.R1()     // Catch:{ all -> 0x02cb }
            if (r3 != 0) goto L_0x01fc
            r20 = r0
            r26 = r5
            r27 = r6
        L_0x01f4:
            r19 = r7
            r28 = r8
            r18 = r9
            goto L_0x0264
        L_0x01fc:
            r26 = r5
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r1.R0()     // Catch:{ all -> 0x02cb }
            io.ktor.utils.io.internal.RingBufferCapacity r5 = r5.b     // Catch:{ all -> 0x02cb }
            r27 = r6
            int r6 = r5._availableForRead$internal     // Catch:{ all -> 0x02bf }
            if (r6 != 0) goto L_0x021c
            r1.I1()     // Catch:{ all -> 0x0213 }
            r1.X1()     // Catch:{ all -> 0x0213 }
            r20 = r0
            goto L_0x01f4
        L_0x0213:
            r0 = move-exception
            r1 = r24
            r7 = r8
            r8 = r9
            r15 = r17
            goto L_0x03d5
        L_0x021c:
            int r6 = r3.remaining()     // Catch:{ all -> 0x02bf }
            r28 = r8
            r18 = r9
            long r8 = (long) r6
            int r6 = r14.remaining()     // Catch:{ all -> 0x02b1 }
            r19 = r7
            long r6 = (long) r6
            r20 = r0
            r21 = r1
            long r0 = r11.element     // Catch:{ all -> 0x02b3 }
            long r0 = r12 - r0
            long r0 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x02b3 }
            long r0 = java.lang.Math.min(r8, r0)     // Catch:{ all -> 0x02b3 }
            int r0 = (int) r0     // Catch:{ all -> 0x02b3 }
            int r0 = r15.o(r0)     // Catch:{ all -> 0x02b3 }
            if (r0 > 0) goto L_0x0246
            r1 = r21
            goto L_0x025e
        L_0x0246:
            boolean r1 = r5.m(r0)     // Catch:{ all -> 0x02b3 }
            if (r1 == 0) goto L_0x02b7
            int r1 = r3.position()     // Catch:{ all -> 0x02b3 }
            int r1 = r1 + r0
            r3.limit(r1)     // Catch:{ all -> 0x02b3 }
            r14.put(r3)     // Catch:{ all -> 0x02b3 }
            r2.element = r0     // Catch:{ all -> 0x02b3 }
            r1 = r21
            r1.D0(r3, r5, r0)     // Catch:{ all -> 0x02b1 }
        L_0x025e:
            r1.I1()     // Catch:{ all -> 0x02a6 }
            r1.X1()     // Catch:{ all -> 0x02a6 }
        L_0x0264:
            int r0 = r2.element     // Catch:{ all -> 0x02a6 }
            if (r0 > 0) goto L_0x027b
            r3 = r26
            r4 = r27
            r7 = r28
            r0 = r1
            r10 = r11
            r11 = r12
            r15 = r17
            r8 = r18
            r6 = r19
            r1 = r24
            goto L_0x02e2
        L_0x027b:
            r10.E0(r14, r15, r0)     // Catch:{ all -> 0x02a6 }
            long r5 = r11.element     // Catch:{ all -> 0x02a6 }
            int r0 = r2.element     // Catch:{ all -> 0x02a6 }
            long r2 = (long) r0     // Catch:{ all -> 0x02a6 }
            long r5 = r5 + r2
            r11.element = r5     // Catch:{ all -> 0x02a6 }
            int r4 = r4 - r0
            if (r4 == 0) goto L_0x028b
            if (r19 == 0) goto L_0x028e
        L_0x028b:
            r10.flush()     // Catch:{ all -> 0x02a6 }
        L_0x028e:
            r3 = r26
            r4 = r27
            r7 = r28
            r0 = r1
            r9 = r10
            r10 = r11
            r11 = r12
            r13 = r14
            r14 = r15
            r5 = r16
            r15 = r17
            r8 = r18
            r6 = r19
            r16 = r20
            goto L_0x0153
        L_0x02a6:
            r0 = move-exception
        L_0x02a7:
            r1 = r24
            r7 = r28
            r15 = r17
            r8 = r18
            goto L_0x03d5
        L_0x02b1:
            r0 = move-exception
            goto L_0x02c4
        L_0x02b3:
            r0 = move-exception
            r1 = r21
            goto L_0x02c4
        L_0x02b7:
            r1 = r21
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x02b1 }
            r0.<init>()     // Catch:{ all -> 0x02b1 }
            throw r0     // Catch:{ all -> 0x02b1 }
        L_0x02bf:
            r0 = move-exception
            r28 = r8
            r18 = r9
        L_0x02c4:
            r1.I1()     // Catch:{ all -> 0x02a6 }
            r1.X1()     // Catch:{ all -> 0x02a6 }
            throw r0     // Catch:{ all -> 0x02a6 }
        L_0x02cb:
            r0 = move-exception
            r28 = r8
            r18 = r9
            goto L_0x02a7
        L_0x02d1:
            r0 = move-exception
            r16 = r24
            r1 = r16
            goto L_0x01b4
        L_0x02d8:
            r20 = r16
            r16 = r24
            r24 = r0
            r1 = r16
            r16 = r5
        L_0x02e2:
            boolean r5 = r15.h()     // Catch:{ all -> 0x02ef }
            if (r5 != 0) goto L_0x02f4
            boolean r5 = r7.z()     // Catch:{ all -> 0x02ef }
            if (r5 == 0) goto L_0x02f7
            goto L_0x02f4
        L_0x02ef:
            r0 = move-exception
            r1 = r16
            goto L_0x0406
        L_0x02f4:
            r7.flush()     // Catch:{ all -> 0x02ef }
        L_0x02f7:
            if (r7 == r8) goto L_0x0308
            long r13 = r8.T0()     // Catch:{ all -> 0x02ef }
            long r17 = r7.T0()     // Catch:{ all -> 0x02ef }
            long r17 = r17 - r1
            long r13 = r13 + r17
            r8.Q1(r13)     // Catch:{ all -> 0x02ef }
        L_0x0308:
            r7.J1()     // Catch:{ all -> 0x02ef }
            r7.X1()     // Catch:{ all -> 0x02ef }
            r7 = r4
            r8 = r10
            r1 = r16
            r4 = r3
            r2 = r11
        L_0x0314:
            if (r4 == 0) goto L_0x0331
            boolean r5 = r0.V1(r4)     // Catch:{ all -> 0x0128 }
            if (r5 == 0) goto L_0x031e
            goto L_0x03fa
        L_0x031e:
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r0.R0()     // Catch:{ all -> 0x0128 }
            io.ktor.utils.io.internal.RingBufferCapacity r5 = r5.b     // Catch:{ all -> 0x0128 }
            boolean r5 = r5.e()     // Catch:{ all -> 0x0128 }
            if (r5 == 0) goto L_0x0331
            r0.M1()     // Catch:{ all -> 0x0128 }
            r5 = r20
            goto L_0x0117
        L_0x0331:
            long r9 = r8.element     // Catch:{ all -> 0x0128 }
            int r5 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x03fa
            r1.flush()     // Catch:{ all -> 0x0128 }
            int r5 = r0.i()     // Catch:{ all -> 0x0128 }
            if (r5 != 0) goto L_0x0394
            r7.L$0 = r1     // Catch:{ all -> 0x0128 }
            r7.L$1 = r0     // Catch:{ all -> 0x0128 }
            r7.L$2 = r4     // Catch:{ all -> 0x0128 }
            r7.L$3 = r8     // Catch:{ all -> 0x0128 }
            r5 = 0
            r7.L$4 = r5     // Catch:{ all -> 0x0128 }
            r7.L$5 = r5     // Catch:{ all -> 0x0128 }
            r7.L$6 = r5     // Catch:{ all -> 0x0128 }
            r7.L$7 = r5     // Catch:{ all -> 0x0128 }
            r7.L$8 = r5     // Catch:{ all -> 0x0128 }
            r7.L$9 = r5     // Catch:{ all -> 0x0128 }
            r7.J$0 = r2     // Catch:{ all -> 0x0128 }
            r7.Z$0 = r6     // Catch:{ all -> 0x0128 }
            r5 = 2
            r7.label = r5     // Catch:{ all -> 0x0128 }
            r9 = 1
            java.lang.Object r10 = r0.x1(r9, r7)     // Catch:{ all -> 0x0128 }
            r9 = r20
            if (r10 != r9) goto L_0x0366
            return r9
        L_0x0366:
            r12 = r0
            r13 = r1
            r1 = r2
            r11 = r4
            r0 = r6
            r4 = r7
            r6 = r8
            r3 = r10
        L_0x036e:
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x005e }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x037f
            if (r11 == 0) goto L_0x0388
            boolean r3 = r12.V1(r11)     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0388
            goto L_0x0390
        L_0x037f:
            if (r11 == 0) goto L_0x0390
            boolean r3 = r12.V1(r11)     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0388
            goto L_0x0390
        L_0x0388:
            r2 = r1
            r7 = r4
            r8 = r6
            r4 = r11
            r1 = r13
            r6 = r0
            r0 = r12
            goto L_0x0397
        L_0x0390:
            r8 = r6
            r1 = r13
            r6 = r0
            goto L_0x03fa
        L_0x0394:
            r9 = r20
            r5 = 2
        L_0x0397:
            io.ktor.utils.io.internal.JoiningState r10 = r1.joining     // Catch:{ all -> 0x0128 }
            if (r10 == 0) goto L_0x03bf
            r7.L$0 = r1     // Catch:{ all -> 0x0128 }
            r7.L$1 = r0     // Catch:{ all -> 0x0128 }
            r7.L$2 = r4     // Catch:{ all -> 0x0128 }
            r7.L$3 = r8     // Catch:{ all -> 0x0128 }
            r10 = 0
            r7.L$4 = r10     // Catch:{ all -> 0x0128 }
            r7.L$5 = r10     // Catch:{ all -> 0x0128 }
            r7.L$6 = r10     // Catch:{ all -> 0x0128 }
            r7.L$7 = r10     // Catch:{ all -> 0x0128 }
            r7.L$8 = r10     // Catch:{ all -> 0x0128 }
            r7.L$9 = r10     // Catch:{ all -> 0x0128 }
            r7.J$0 = r2     // Catch:{ all -> 0x0128 }
            r7.Z$0 = r6     // Catch:{ all -> 0x0128 }
            r11 = 3
            r7.label = r11     // Catch:{ all -> 0x0128 }
            r12 = 1
            java.lang.Object r13 = r1.Z1(r12, r7)     // Catch:{ all -> 0x0128 }
            if (r13 != r9) goto L_0x03bf
            return r9
        L_0x03bf:
            r5 = r9
            goto L_0x0117
        L_0x03c2:
            java.lang.Throwable r0 = r13.c()     // Catch:{ all -> 0x03cf }
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.b(r0)     // Catch:{ all -> 0x03cf }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x03cf }
            r0.<init>()     // Catch:{ all -> 0x03cf }
            throw r0     // Catch:{ all -> 0x03cf }
        L_0x03cf:
            r0 = move-exception
            r8 = r1
            r16 = r8
            r7 = r9
            r1 = r11
        L_0x03d5:
            boolean r3 = r15.h()     // Catch:{ all -> 0x02ef }
            if (r3 != 0) goto L_0x03e1
            boolean r3 = r7.z()     // Catch:{ all -> 0x02ef }
            if (r3 == 0) goto L_0x03e4
        L_0x03e1:
            r7.flush()     // Catch:{ all -> 0x02ef }
        L_0x03e4:
            if (r7 == r8) goto L_0x03f3
            long r3 = r8.T0()     // Catch:{ all -> 0x02ef }
            long r5 = r7.T0()     // Catch:{ all -> 0x02ef }
            long r5 = r5 - r1
            long r3 = r3 + r5
            r8.Q1(r3)     // Catch:{ all -> 0x02ef }
        L_0x03f3:
            r7.J1()     // Catch:{ all -> 0x02ef }
            r7.X1()     // Catch:{ all -> 0x02ef }
            throw r0     // Catch:{ all -> 0x02ef }
        L_0x03fa:
            if (r6 == 0) goto L_0x03ff
            r1.flush()     // Catch:{ all -> 0x0128 }
        L_0x03ff:
            long r2 = r8.element     // Catch:{ all -> 0x0128 }
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2)     // Catch:{ all -> 0x0128 }
            return r0
        L_0x0406:
            r1.h(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.I0(io.ktor.utils.io.ByteBufferChannel, long, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void I1() {
        Object obj;
        ReadWriteBufferState f2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ReadWriteBufferState readWriteBufferState = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState2 = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty != null) {
                idleNonEmpty.b.j();
                M1();
                readWriteBufferState = null;
            }
            f2 = readWriteBufferState2.f();
            if ((f2 instanceof ReadWriteBufferState.IdleNonEmpty) && R0() == readWriteBufferState2 && f2.b.k()) {
                ReadWriteBufferState readWriteBufferState3 = f2;
                f2 = ReadWriteBufferState.IdleEmpty.c;
                readWriteBufferState = readWriteBufferState3;
            }
            atomicReferenceFieldUpdater = m;
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, f2));
        ReadWriteBufferState readWriteBufferState4 = ReadWriteBufferState.IdleEmpty.c;
        if (f2 == readWriteBufferState4) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty2 != null) {
                E1(idleNonEmpty2.h());
            }
            M1();
        } else if ((f2 instanceof ReadWriteBufferState.IdleNonEmpty) && f2.b.g() && f2.b.k() && a.a(atomicReferenceFieldUpdater, this, f2, readWriteBufferState4)) {
            f2.b.j();
            E1(((ReadWriteBufferState.IdleNonEmpty) f2).h());
            M1();
        }
    }

    public void J(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.d(job, true, false, new ByteBufferChannel$attachJob$1(this), 2, (Object) null);
    }

    public final ReadWriteBufferState J0() {
        return R0();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0027: MOVE  (r0v3 io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty) = 
          (r0v2 io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void J1() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            java.lang.Object r1 = r5._state
            r2 = r1
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = (io.ktor.utils.io.internal.ReadWriteBufferState) r2
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r2.g()
            boolean r3 = r2 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r3 == 0) goto L_0x001b
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r2.b
            boolean r3 = r3.g()
            if (r3 == 0) goto L_0x001b
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r0 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.c
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x001b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = m
            boolean r1 = com.honey.account.i.a.a(r3, r5, r1, r2)
            if (r1 == 0) goto L_0x0001
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r1 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.c
            if (r2 != r1) goto L_0x0032
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty r0 = (io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty) r0
            if (r0 == 0) goto L_0x0032
            io.ktor.utils.io.internal.ReadWriteBufferState$Initial r0 = r0.h()
            r5.E1(r0)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.J1():void");
    }

    public Object K(int i2, Function1 function1, Continuation continuation) {
        return b1(this, i2, function1, continuation);
    }

    public final void K1(Throwable th) {
        Continuation continuation = (Continuation) o.getAndSet(this, (Object) null);
        if (continuation != null) {
            if (th != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
            } else {
                continuation.resumeWith(Result.m20constructorimpl(Boolean.valueOf(R0().b._availableForRead$internal > 0)));
            }
        }
        Continuation continuation2 = (Continuation) p.getAndSet(this, (Object) null);
        if (continuation2 != null) {
            Result.Companion companion2 = Result.Companion;
            if (th == null) {
                th = new ClosedWriteChannelException("Byte channel was closed");
            }
            continuation2.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public WriterSuspendSession L() {
        WriteSessionImpl writeSessionImpl = this.h;
        writeSessionImpl.e();
        return writeSessionImpl;
    }

    public final void L1() {
        Throwable th = null;
        Continuation continuation = (Continuation) o.getAndSet(this, (Object) null);
        if (continuation != null) {
            ClosedElement O0 = O0();
            if (O0 != null) {
                th = O0.b();
            }
            if (th != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
                return;
            }
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
        }
    }

    public Object M(Buffer buffer, Continuation continuation) {
        return o2(this, buffer, continuation);
    }

    public final void M0(JoiningState joiningState) {
        ClosedElement O0 = O0();
        if (O0 != null) {
            this.joining = null;
            if (!joiningState.d()) {
                joiningState.e().flush();
                joiningState.b();
                return;
            }
            ReadWriteBufferState R0 = joiningState.e().R0();
            boolean z = (R0 instanceof ReadWriteBufferState.Writing) || (R0 instanceof ReadWriteBufferState.ReadingWriting);
            if (O0.b() != null || !z) {
                joiningState.e().h(O0.b());
            } else {
                joiningState.e().flush();
            }
            joiningState.b();
        }
    }

    public final void M1() {
        Continuation U0;
        ClosedElement O0;
        do {
            U0 = U0();
            if (U0 != null) {
                O0 = O0();
                if (O0 == null && this.joining != null) {
                    ReadWriteBufferState R0 = R0();
                    if (!(R0 instanceof ReadWriteBufferState.Writing) && !(R0 instanceof ReadWriteBufferState.ReadingWriting) && R0 != ReadWriteBufferState.Terminated.c) {
                        return;
                    }
                }
            } else {
                return;
            }
        } while (!a.a(p, this, U0, (Object) null));
        Result.Companion companion = Result.Companion;
        U0.resumeWith(Result.m20constructorimpl(O0 == null ? Unit.INSTANCE : ResultKt.createFailure(O0.c())));
    }

    public Object N(int i2, Continuation continuation) {
        return z1(this, i2, continuation);
    }

    public final void N0(int i2) {
        ReadWriteBufferState R0;
        ReadWriteBufferState.Terminated terminated;
        ByteBufferChannel e2;
        JoiningState joiningState = this.joining;
        if (!(joiningState == null || (e2 = joiningState.e()) == null)) {
            e2.flush();
        }
        do {
            R0 = R0();
            terminated = ReadWriteBufferState.Terminated.c;
            if (R0 != terminated) {
                R0.b.e();
            } else {
                return;
            }
        } while (R0 != R0());
        int i3 = R0.b._availableForWrite$internal;
        if (R0.b._availableForRead$internal >= 1) {
            L1();
        }
        JoiningState joiningState2 = this.joining;
        if (i3 < i2) {
            return;
        }
        if (joiningState2 == null || R0() == terminated) {
            M1();
        }
    }

    public final void N1(ByteBuffer byteBuffer, int i2) {
        int remaining = byteBuffer.remaining();
        byteBuffer.limit(byteBuffer.position() + i2);
        int i3 = i2 - remaining;
        for (int i4 = 0; i4 < i3; i4++) {
            byteBuffer.put((byteBuffer.capacity() - 8) + i4, byteBuffer.get(i4));
        }
    }

    public Object O(int i2, Continuation continuation) {
        return u2(this, i2, continuation);
    }

    public final ClosedElement O0() {
        return (ClosedElement) this._closed;
    }

    public final void O1(Continuation continuation) {
        this._readOp = continuation;
    }

    public void P() {
        this.g.c();
        ReadWriteBufferState R0 = R0();
        if ((R0 instanceof ReadWriteBufferState.Reading) || (R0 instanceof ReadWriteBufferState.ReadingWriting)) {
            I1();
            X1();
        }
    }

    public final JoiningState P0() {
        return this.joining;
    }

    public void P1(long j2) {
        this.totalBytesRead = j2;
    }

    public boolean Q() {
        return R0() == ReadWriteBufferState.Terminated.c && O0() != null;
    }

    public final Continuation Q0() {
        return (Continuation) this._readOp;
    }

    public void Q1(long j2) {
        this.totalBytesWritten = j2;
    }

    public final ReadWriteBufferState R0() {
        return (ReadWriteBufferState) this._state;
    }

    public final ByteBuffer R1() {
        Object obj;
        Throwable b2;
        ReadWriteBufferState d2;
        Throwable b3;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (Intrinsics.areEqual((Object) readWriteBufferState, (Object) ReadWriteBufferState.Terminated.c) ? true : Intrinsics.areEqual((Object) readWriteBufferState, (Object) ReadWriteBufferState.IdleEmpty.c)) {
                ClosedElement O0 = O0();
                if (O0 == null || (b2 = O0.b()) == null) {
                    return null;
                }
                Void unused = ByteBufferChannelKt.b(b2);
                throw new KotlinNothingValueException();
            }
            ClosedElement O02 = O0();
            if (O02 != null && (b3 = O02.b()) != null) {
                Void unused2 = ByteBufferChannelKt.b(b3);
                throw new KotlinNothingValueException();
            } else if (readWriteBufferState.b._availableForRead$internal == 0) {
                return null;
            } else {
                d2 = readWriteBufferState.d();
            }
        } while (!a.a(m, this, obj, d2));
        ByteBuffer b4 = d2.b();
        Z0(b4, this.e, d2.b._availableForRead$internal);
        return b4;
    }

    public long S0() {
        return this.totalBytesRead;
    }

    public final ByteBuffer S1() {
        Object obj;
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.IdleEmpty idleEmpty;
        ReadWriteBufferState readWriteBufferState2;
        Continuation U0 = U0();
        if (U0 == null) {
            ReadWriteBufferState readWriteBufferState3 = null;
            ReadWriteBufferState.Initial initial = null;
            do {
                obj = this._state;
                readWriteBufferState = (ReadWriteBufferState) obj;
                if (this.joining != null) {
                    if (initial != null) {
                        E1(initial);
                    }
                    return null;
                } else if (O0() != null) {
                    if (initial != null) {
                        E1(initial);
                    }
                    ClosedElement O0 = O0();
                    Intrinsics.checkNotNull(O0);
                    Void unused = ByteBufferChannelKt.b(O0.c());
                    throw new KotlinNothingValueException();
                } else {
                    idleEmpty = ReadWriteBufferState.IdleEmpty.c;
                    if (readWriteBufferState == idleEmpty) {
                        if (initial == null) {
                            initial = X0();
                        }
                        readWriteBufferState2 = initial.e();
                    } else if (readWriteBufferState == ReadWriteBufferState.Terminated.c) {
                        if (initial != null) {
                            E1(initial);
                        }
                        if (this.joining != null) {
                            return null;
                        }
                        ClosedElement O02 = O0();
                        Intrinsics.checkNotNull(O02);
                        Void unused2 = ByteBufferChannelKt.b(O02.c());
                        throw new KotlinNothingValueException();
                    } else {
                        readWriteBufferState2 = readWriteBufferState.e();
                    }
                }
            } while (!a.a(m, this, obj, readWriteBufferState2));
            if (O0() == null) {
                ByteBuffer c2 = readWriteBufferState2.c();
                if (initial != null) {
                    if (readWriteBufferState == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("old");
                    } else {
                        readWriteBufferState3 = readWriteBufferState;
                    }
                    if (readWriteBufferState3 != idleEmpty) {
                        E1(initial);
                    }
                }
                Z0(c2, this.f, readWriteBufferState2.b._availableForWrite$internal);
                return c2;
            }
            J1();
            X1();
            ClosedElement O03 = O0();
            Intrinsics.checkNotNull(O03);
            Void unused3 = ByteBufferChannelKt.b(O03.c());
            throw new KotlinNothingValueException();
        }
        throw new IllegalStateException("Write operation is already in progress: " + U0);
    }

    public long T0() {
        return this.totalBytesWritten;
    }

    public final boolean T1() {
        return this.joining != null && (R0() == ReadWriteBufferState.IdleEmpty.c || (R0() instanceof ReadWriteBufferState.IdleNonEmpty));
    }

    public final Continuation U0() {
        return (Continuation) this._writeOp;
    }

    public final Object U1(int i2, Continuation continuation) {
        while (true) {
            ReadWriteBufferState R0 = R0();
            if (R0.b._availableForRead$internal >= i2 || !(this.joining == null || U0() == null || (R0 != ReadWriteBufferState.IdleEmpty.c && !(R0 instanceof ReadWriteBufferState.IdleNonEmpty)))) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
            } else {
                ClosedElement O0 = O0();
                if (O0 == null) {
                    while (Q0() == null) {
                        if (O0() == null) {
                            ReadWriteBufferState R02 = R0();
                            if (R02.b._availableForRead$internal < i2 && (this.joining == null || U0() == null || (R02 != ReadWriteBufferState.IdleEmpty.c && !(R02 instanceof ReadWriteBufferState.IdleNonEmpty)))) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
                                if (a.a(atomicReferenceFieldUpdater, this, (Object) null, continuation)) {
                                    if (O0() == null) {
                                        ReadWriteBufferState R03 = R0();
                                        if (R03.b._availableForRead$internal < i2) {
                                            if (this.joining != null) {
                                                if (U0() != null) {
                                                    if (R03 != ReadWriteBufferState.IdleEmpty.c && !(R03 instanceof ReadWriteBufferState.IdleNonEmpty)) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!a.a(atomicReferenceFieldUpdater, this, continuation, (Object) null)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    throw new IllegalStateException("Operation is already in progress".toString());
                } else if (O0.b() != null) {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(O0.b())));
                    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
                } else {
                    boolean e2 = R0().b.e();
                    boolean z = false;
                    boolean z2 = R0().b._availableForRead$internal >= i2;
                    Result.Companion companion3 = Result.Companion;
                    if (e2 && z2) {
                        z = true;
                    }
                    continuation.resumeWith(Result.m20constructorimpl(Boolean.valueOf(z)));
                    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
                }
            }
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: io.ktor.utils.io.ByteBufferChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object V0(io.ktor.utils.io.ByteBufferChannel r10, boolean r11, io.ktor.utils.io.internal.JoiningState r12, kotlin.coroutines.Continuation r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1
            r0.<init>(r9, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r2) goto L_0x0034
            if (r1 != r8) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x007d
        L_0x002c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0034:
            boolean r11 = r0.Z$0
            java.lang.Object r9 = r0.L$1
            r10 = r9
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005e
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.Z$0 = r11
            r0.label = r2
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1 = r9
            r2 = r10
            r5 = r12
            r6 = r0
            java.lang.Object r12 = r1.I0(r2, r3, r5, r6)
            if (r12 != r7) goto L_0x005e
            return r7
        L_0x005e:
            if (r11 == 0) goto L_0x006c
            boolean r11 = r10.Q()
            if (r11 == 0) goto L_0x006c
            io.ktor.utils.io.ByteWriteChannelKt.a(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x006c:
            r9.flush()
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r8
            java.lang.Object r9 = r10.B0(r0)
            if (r9 != r7) goto L_0x007d
            return r7
        L_0x007d:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.V0(io.ktor.utils.io.ByteBufferChannel, boolean, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean V1(JoiningState joiningState) {
        if (!W1(true)) {
            return false;
        }
        M0(joiningState);
        Continuation continuation = (Continuation) o.getAndSet(this, (Object) null);
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(new IllegalStateException("Joining is in progress"))));
        }
        M1();
        return true;
    }

    public final boolean W1(boolean z) {
        Object obj;
        ReadWriteBufferState.Terminated terminated;
        ReadWriteBufferState.Initial initial = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            ClosedElement O0 = O0();
            if (initial != null) {
                if ((O0 != null ? O0.b() : null) == null) {
                    initial.b.j();
                }
                M1();
                initial = null;
            }
            terminated = ReadWriteBufferState.Terminated.c;
            if (readWriteBufferState == terminated) {
                return true;
            }
            if (readWriteBufferState != ReadWriteBufferState.IdleEmpty.c) {
                if (O0 != null && (readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) && (readWriteBufferState.b.k() || O0.b() != null)) {
                    if (O0.b() != null) {
                        readWriteBufferState.b.f();
                    }
                    initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).h();
                } else if (!z || !(readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) || !readWriteBufferState.b.k()) {
                    return false;
                } else {
                    initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).h();
                }
            }
        } while (!a.a(m, this, obj, terminated));
        if (initial != null && R0() == terminated) {
            E1(initial);
        }
        return true;
    }

    public final ReadWriteBufferState.Initial X0() {
        ReadWriteBufferState.Initial initial = (ReadWriteBufferState.Initial) this.c.h0();
        initial.b.j();
        return initial;
    }

    public final boolean X1() {
        if (O0() == null || !W1(false)) {
            return false;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            M0(joiningState);
        }
        L1();
        M1();
        return true;
    }

    /* JADX INFO: finally extract failed */
    public final int Y1(ByteReadPacket byteReadPacket) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = H1(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer S1 = byteBufferChannel.S1();
        if (S1 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
        long T0 = byteBufferChannel.T0();
        try {
            ClosedElement O0 = byteBufferChannel.O0();
            if (O0 == null) {
                int o2 = ringBufferCapacity.o((int) Math.min(byteReadPacket.r0(), (long) S1.remaining()));
                if (o2 > 0) {
                    S1.limit(S1.position() + o2);
                    ByteBuffersKt.c(byteReadPacket, S1);
                    byteBufferChannel.E0(S1, ringBufferCapacity, o2);
                }
                if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    Q1(T0() + (byteBufferChannel.T0() - T0));
                }
                byteBufferChannel.J1();
                byteBufferChannel.X1();
                return o2;
            }
            Void unused = ByteBufferChannelKt.b(O0.c());
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                Q1(T0() + (byteBufferChannel.T0() - T0));
            }
            byteBufferChannel.J1();
            byteBufferChannel.X1();
            throw th;
        }
    }

    public final void Z0(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (i3 >= 0) {
            byteBuffer.limit(RangesKt.coerceAtMost(i3 + i2, byteBuffer.capacity() - this.d));
            byteBuffer.position(i2);
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Object Z1(int i2, Continuation continuation) {
        Throwable c2;
        if (!C2(i2)) {
            ClosedElement O0 = O0();
            if (O0 == null || (c2 = O0.c()) == null) {
                return Unit.INSTANCE;
            }
            Void unused = ByteBufferChannelKt.b(c2);
            throw new KotlinNothingValueException();
        }
        this.writeSuspensionSize = i2;
        if (this.attachedJob != null) {
            Object invoke = this.k.invoke(continuation);
            if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        CancellableReusableContinuation cancellableReusableContinuation = this.j;
        this.k.invoke(cancellableReusableContinuation);
        Object g2 = cancellableReusableContinuation.g(IntrinsicsKt.intercepted(continuation));
        if (g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public ByteBuffer a(int i2, int i3) {
        ReadWriteBufferState R0 = R0();
        int i4 = R0.b._availableForRead$internal;
        int i5 = this.e;
        if (i4 < i3 + i2) {
            return null;
        }
        if (!R0.a() && ((R0 instanceof ReadWriteBufferState.Reading) || (R0 instanceof ReadWriteBufferState.ReadingWriting))) {
            ByteBuffer b2 = R0.b();
            Z0(b2, H0(b2, i5 + i2), i4 - i2);
            if (b2.remaining() >= i3) {
                return b2;
            }
            return null;
        } else if (R1() == null) {
            return null;
        } else {
            return a(i2, i3);
        }
    }

    public final void a1(ByteBuffer byteBuffer, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        Z0(byteBuffer, this.f, i2);
    }

    public final Object b(int i2, Continuation continuation) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i2).toString());
        } else if (i2 > 4088) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i2).toString());
        } else if (R0().b._availableForRead$internal < i2) {
            return (R0().a() || (R0() instanceof ReadWriteBufferState.Writing)) ? A0(i2, continuation) : i2 == 1 ? x1(1, continuation) : w1(i2, continuation);
        } else {
            if (R0().a() || (R0() instanceof ReadWriteBufferState.Writing)) {
                R1();
            }
            return Boxing.boxBoolean(true);
        }
    }

    public final int b2(Buffer buffer) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = H1(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer S1 = byteBufferChannel.S1();
        int i2 = 0;
        if (S1 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
        long T0 = byteBufferChannel.T0();
        try {
            ClosedElement O0 = byteBufferChannel.O0();
            if (O0 == null) {
                while (true) {
                    int o2 = ringBufferCapacity.o(Math.min(buffer.k() - buffer.i(), S1.remaining()));
                    if (o2 == 0) {
                        break;
                    }
                    BufferUtilsJvmKt.c(buffer, S1, o2);
                    i2 += o2;
                    byteBufferChannel.Z0(S1, byteBufferChannel.H0(S1, byteBufferChannel.f + i2), ringBufferCapacity._availableForWrite$internal);
                }
                byteBufferChannel.E0(S1, ringBufferCapacity, i2);
                if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    Q1(T0() + (byteBufferChannel.T0() - T0));
                }
                byteBufferChannel.J1();
                byteBufferChannel.X1();
                return i2;
            }
            Void unused = ByteBufferChannelKt.b(O0.c());
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                Q1(T0() + (byteBufferChannel.T0() - T0));
            }
            byteBufferChannel.J1();
            byteBufferChannel.X1();
            throw th;
        }
    }

    public void c(int i2) {
        this.h.b(i2);
        this.h.f();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r8 r9 
      PHI: (r8v1 int) = (r8v0 int), (r8v2 int) binds: [B:0:0x0000, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v1 int) = (r9v0 int), (r9v2 int) binds: [B:0:0x0000, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[EDGE_INSN: B:29:0x006c->B:26:0x006c ?: BREAK  
    EDGE_INSN: B:31:0x006c->B:26:0x006c ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c1(io.ktor.utils.io.core.Buffer r7, int r8, int r9) {
        /*
            r6 = this;
        L_0x0000:
            java.nio.ByteBuffer r0 = r6.R1()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r4 = r1
            goto L_0x0054
        L_0x0009:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r6.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.b
            int r3 = r2._availableForRead$internal     // Catch:{ all -> 0x0045 }
            if (r3 != 0) goto L_0x001a
            r6.I1()
            r6.X1()
            goto L_0x0007
        L_0x001a:
            int r3 = r7.g()     // Catch:{ all -> 0x0045 }
            int r4 = r7.k()     // Catch:{ all -> 0x0045 }
            int r3 = r3 - r4
            int r4 = r0.remaining()     // Catch:{ all -> 0x0045 }
            int r5 = java.lang.Math.min(r3, r9)     // Catch:{ all -> 0x0045 }
            int r4 = java.lang.Math.min(r4, r5)     // Catch:{ all -> 0x0045 }
            int r4 = r2.l(r4)     // Catch:{ all -> 0x0045 }
            if (r4 > 0) goto L_0x0036
            goto L_0x004e
        L_0x0036:
            int r1 = r0.remaining()     // Catch:{ all -> 0x0045 }
            if (r3 >= r1) goto L_0x0047
            int r1 = r0.position()     // Catch:{ all -> 0x0045 }
            int r1 = r1 + r3
            r0.limit(r1)     // Catch:{ all -> 0x0045 }
            goto L_0x0047
        L_0x0045:
            r7 = move-exception
            goto L_0x006d
        L_0x0047:
            io.ktor.utils.io.core.BufferPrimitivesJvmKt.a(r7, r0)     // Catch:{ all -> 0x0045 }
            r6.D0(r0, r2, r4)     // Catch:{ all -> 0x0045 }
            r1 = 1
        L_0x004e:
            r6.I1()
            r6.X1()
        L_0x0054:
            int r8 = r8 + r4
            int r9 = r9 - r4
            if (r1 == 0) goto L_0x006c
            int r0 = r7.g()
            int r1 = r7.k()
            if (r0 <= r1) goto L_0x006c
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r6.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r0 = r0.b
            int r0 = r0._availableForRead$internal
            if (r0 > 0) goto L_0x0000
        L_0x006c:
            return r8
        L_0x006d:
            r6.I1()
            r6.X1()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.c1(io.ktor.utils.io.core.Buffer, int, int):int");
    }

    public final int c2(ByteBuffer byteBuffer) {
        ByteBufferChannel byteBufferChannel;
        int o2;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = H1(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer S1 = byteBufferChannel.S1();
        int i2 = 0;
        if (S1 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
        long T0 = byteBufferChannel.T0();
        try {
            ClosedElement O0 = byteBufferChannel.O0();
            if (O0 == null) {
                int limit = byteBuffer.limit();
                while (true) {
                    int position = limit - byteBuffer.position();
                    if (position == 0 || (o2 = ringBufferCapacity.o(Math.min(position, S1.remaining()))) == 0) {
                        byteBuffer.limit(limit);
                        byteBufferChannel.E0(S1, ringBufferCapacity, i2);
                    } else if (o2 > 0) {
                        byteBuffer.limit(byteBuffer.position() + o2);
                        S1.put(byteBuffer);
                        i2 += o2;
                        byteBufferChannel.Z0(S1, byteBufferChannel.H0(S1, byteBufferChannel.f + i2), ringBufferCapacity._availableForWrite$internal);
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                byteBuffer.limit(limit);
                byteBufferChannel.E0(S1, ringBufferCapacity, i2);
                if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    Q1(T0() + (byteBufferChannel.T0() - T0));
                }
                byteBufferChannel.J1();
                byteBufferChannel.X1();
                return i2;
            }
            Void unused = ByteBufferChannelKt.b(O0.c());
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                Q1(T0() + (byteBufferChannel.T0() - T0));
            }
            byteBufferChannel.J1();
            byteBufferChannel.X1();
            throw th;
        }
    }

    public SuspendableReadSession d() {
        return this.g;
    }

    public final int d1(ByteBuffer byteBuffer) {
        ByteBuffer R1 = R1();
        int i2 = 0;
        if (R1 != null) {
            RingBufferCapacity ringBufferCapacity = R0().b;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int capacity = R1.capacity() - this.d;
                    while (true) {
                        int remaining = byteBuffer.remaining();
                        if (remaining == 0) {
                            break;
                        }
                        int i3 = this.e;
                        int l2 = ringBufferCapacity.l(Math.min(capacity - i3, remaining));
                        if (l2 == 0) {
                            break;
                        }
                        R1.limit(i3 + l2);
                        R1.position(i3);
                        byteBuffer.put(R1);
                        D0(R1, ringBufferCapacity, l2);
                        i2 += l2;
                    }
                }
            } finally {
                I1();
                X1();
            }
        }
        return i2;
    }

    public final int d2(byte[] bArr, int i2, int i3) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = H1(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer S1 = byteBufferChannel.S1();
        int i4 = 0;
        if (S1 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
        long T0 = byteBufferChannel.T0();
        try {
            ClosedElement O0 = byteBufferChannel.O0();
            if (O0 == null) {
                while (true) {
                    int o2 = ringBufferCapacity.o(Math.min(i3 - i4, S1.remaining()));
                    if (o2 == 0) {
                        byteBufferChannel.E0(S1, ringBufferCapacity, i4);
                        if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != this) {
                            Q1(T0() + (byteBufferChannel.T0() - T0));
                        }
                        byteBufferChannel.J1();
                        byteBufferChannel.X1();
                        return i4;
                    } else if (o2 > 0) {
                        S1.put(bArr, i2 + i4, o2);
                        i4 += o2;
                        byteBufferChannel.Z0(S1, byteBufferChannel.H0(S1, byteBufferChannel.f + i4), ringBufferCapacity._availableForWrite$internal);
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
            } else {
                Void unused = ByteBufferChannelKt.b(O0.c());
                throw new KotlinNothingValueException();
            }
        } catch (Throwable th) {
            if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                Q1(T0() + (byteBufferChannel.T0() - T0));
            }
            byteBufferChannel.J1();
            byteBufferChannel.X1();
            throw th;
        }
    }

    public boolean e(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return h(th);
    }

    public final int e1(byte[] bArr, int i2, int i3) {
        ByteBuffer R1 = R1();
        int i4 = 0;
        if (R1 != null) {
            RingBufferCapacity ringBufferCapacity = R0().b;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int capacity = R1.capacity() - this.d;
                    while (true) {
                        int i5 = i3 - i4;
                        if (i5 == 0) {
                            break;
                        }
                        int i6 = this.e;
                        int l2 = ringBufferCapacity.l(Math.min(capacity - i6, i5));
                        if (l2 == 0) {
                            break;
                        }
                        R1.limit(i6 + l2);
                        R1.position(i6);
                        R1.get(bArr, i2 + i4, l2);
                        D0(R1, ringBufferCapacity, l2);
                        i4 += l2;
                    }
                }
            } finally {
                I1();
                X1();
            }
        }
        return i4;
    }

    /* JADX INFO: finally extract failed */
    public int e2(int i2, Function1 function1) {
        ByteBufferChannel byteBufferChannel;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(function1, "block");
        if (i2 <= 0) {
            throw new IllegalArgumentException("min should be positive".toString());
        } else if (i2 <= 4088) {
            JoiningState joiningState = this.joining;
            if (joiningState == null || (byteBufferChannel = H1(this, joiningState)) == null) {
                byteBufferChannel = this;
            }
            ByteBuffer S1 = byteBufferChannel.S1();
            int i5 = 0;
            if (S1 == null) {
                i3 = 0;
            } else {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.R0().b;
                long T0 = byteBufferChannel.T0();
                try {
                    ClosedElement O0 = byteBufferChannel.O0();
                    if (O0 == null) {
                        int n2 = ringBufferCapacity.n(i2);
                        if (n2 <= 0) {
                            i4 = 0;
                        } else {
                            byteBufferChannel.Z0(S1, byteBufferChannel.f, n2);
                            int position = S1.position();
                            int limit = S1.limit();
                            function1.invoke(S1);
                            if (limit == S1.limit()) {
                                i5 = S1.position() - position;
                                if (i5 < 0) {
                                    throw new IllegalStateException("Position has been moved backward: pushback is not supported".toString());
                                } else if (i5 >= 0) {
                                    byteBufferChannel.E0(S1, ringBufferCapacity, i5);
                                    if (i5 < n2) {
                                        ringBufferCapacity.a(n2 - i5);
                                    }
                                    i4 = 1;
                                } else {
                                    throw new IllegalStateException();
                                }
                            } else {
                                throw new IllegalStateException("Buffer limit modified".toString());
                            }
                        }
                        if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != this) {
                            Q1(T0() + (byteBufferChannel.T0() - T0));
                        }
                        byteBufferChannel.J1();
                        byteBufferChannel.X1();
                        i3 = i5;
                        i5 = i4;
                    } else {
                        Void unused = ByteBufferChannelKt.b(O0.c());
                        throw new KotlinNothingValueException();
                    }
                } catch (Throwable th) {
                    if (ringBufferCapacity.h() || byteBufferChannel.z()) {
                        byteBufferChannel.flush();
                    }
                    if (byteBufferChannel != this) {
                        Q1(T0() + (byteBufferChannel.T0() - T0));
                    }
                    byteBufferChannel.J1();
                    byteBufferChannel.X1();
                    throw th;
                }
            }
            if (i5 == 0) {
                return -1;
            }
            return i3;
        } else {
            throw new IllegalArgumentException(("Min(" + i2 + ") shouldn't be greater than 4088").toString());
        }
    }

    public Throwable f() {
        ClosedElement O0 = O0();
        if (O0 != null) {
            return O0.b();
        }
        return null;
    }

    public Object f2(ChunkBuffer chunkBuffer, Continuation continuation) {
        return i2(this, chunkBuffer, continuation);
    }

    public void flush() {
        N0(1);
    }

    public boolean g() {
        return O0() != null;
    }

    public Object g2(ByteBuffer byteBuffer, Continuation continuation) {
        return j2(this, byteBuffer, continuation);
    }

    public boolean h(Throwable th) {
        JoiningState joiningState;
        if (O0() != null) {
            return false;
        }
        ClosedElement a2 = th == null ? ClosedElement.b.a() : new ClosedElement(th);
        R0().b.e();
        if (!a.a(n, this, (Object) null, a2)) {
            return false;
        }
        R0().b.e();
        if (R0().b.g() || th != null) {
            X1();
        }
        K1(th);
        if (R0() == ReadWriteBufferState.Terminated.c && (joiningState = this.joining) != null) {
            M0(joiningState);
        }
        if (th != null) {
            Job job = this.attachedJob;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            this.i.d(th);
            this.j.d(th);
            return true;
        }
        this.j.d(new ClosedWriteChannelException("Byte channel was closed"));
        this.i.c(Boolean.valueOf(R0().b.e()));
        return true;
    }

    public Object h2(byte[] bArr, int i2, int i3, Continuation continuation) {
        return k2(this, bArr, i2, i3, continuation);
    }

    public int i() {
        return R0().b._availableForRead$internal;
    }

    public Object j(int i2, Continuation continuation) {
        return s1(this, i2, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j1(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
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
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.w1(r4, r0)
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
            java.lang.Object r7 = r5.v(r6, r0)
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.j1(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object k(long j2, Continuation continuation) {
        return K0(this, j2, continuation);
    }

    public Object l(ByteBuffer byteBuffer, Continuation continuation) {
        return p2(this, byteBuffer, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l1(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
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
            goto L_0x0075
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
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.w1(r4, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0067
            r5 = -1
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        L_0x0067:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r5.D(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.l1(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object m(Function2 function2, Continuation continuation) {
        return W0(this, function2, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1(int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
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
            goto L_0x0090
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0059
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r4)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.w1(r8, r0)
            if (r8 != r1) goto L_0x0059
            return r1
        L_0x0059:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0082
            if (r6 > 0) goto L_0x0066
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0066:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Got EOF but at least "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = " bytes were expected"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x0082:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r5 = r5.K(r6, r7, r0)
            if (r5 != r1) goto L_0x0090
            return r1
        L_0x0090:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.m1(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readInt$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readInt$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L_0x0031:
            r2 = r8
            goto L_0x00a1
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 4
        L_0x0040:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.R1()
            r5 = 0
            if (r4 != 0) goto L_0x004d
            goto L_0x0080
        L_0x004d:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r9.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.b
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x005e
        L_0x0057:
            r9.I1()
            r9.X1()
            goto L_0x0080
        L_0x005e:
            boolean r7 = r6.m(r10)     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            int r5 = r4.remaining()     // Catch:{ all -> 0x006f }
            if (r5 >= r10) goto L_0x0071
            r9.N1(r4, r10)     // Catch:{ all -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r10 = move-exception
            goto L_0x00c8
        L_0x0071:
            int r5 = r4.getInt()     // Catch:{ all -> 0x006f }
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch:{ all -> 0x006f }
            r2.element = r5     // Catch:{ all -> 0x006f }
            r9.D0(r4, r6, r10)     // Catch:{ all -> 0x006f }
            r5 = r3
            goto L_0x0057
        L_0x0080:
            if (r5 == 0) goto L_0x0090
            T r9 = r2.element
            if (r9 != 0) goto L_0x008d
            java.lang.String r9 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = 0
            goto L_0x008f
        L_0x008d:
            java.lang.Number r9 = (java.lang.Number) r9
        L_0x008f:
            return r9
        L_0x0090:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.w1(r10, r0)
            if (r2 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L_0x0031
        L_0x00a1:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00ac
            r10 = r0
            r0 = r2
            goto L_0x0040
        L_0x00ac:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r9 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "EOF while "
            r10.append(r1)
            r10.append(r0)
            java.lang.String r0 = " bytes expected"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c8:
            r9.I1()
            r9.X1()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n1(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteBufferChannel$readBoolean$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            io.ktor.utils.io.ByteBufferChannel$readBoolean$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readBoolean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readBoolean$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBoolean$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.q(r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.Number r5 = (java.lang.Number) r5
            byte r4 = r5.byteValue()
            if (r4 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r3 = 0
        L_0x0047:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.n1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readFloat$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readFloat$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readFloat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readFloat$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFloat$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L_0x0031:
            r2 = r8
            goto L_0x00ad
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 4
        L_0x0040:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.R1()
            r5 = 0
            if (r4 != 0) goto L_0x004d
            goto L_0x0080
        L_0x004d:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r9.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.b
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x005e
        L_0x0057:
            r9.I1()
            r9.X1()
            goto L_0x0080
        L_0x005e:
            boolean r7 = r6.m(r10)     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            int r5 = r4.remaining()     // Catch:{ all -> 0x006f }
            if (r5 >= r10) goto L_0x0071
            r9.N1(r4, r10)     // Catch:{ all -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r10 = move-exception
            goto L_0x00d4
        L_0x0071:
            int r5 = r4.getInt()     // Catch:{ all -> 0x006f }
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch:{ all -> 0x006f }
            r2.element = r5     // Catch:{ all -> 0x006f }
            r9.D0(r4, r6, r10)     // Catch:{ all -> 0x006f }
            r5 = r3
            goto L_0x0057
        L_0x0080:
            if (r5 == 0) goto L_0x009c
            T r9 = r2.element
            if (r9 != 0) goto L_0x008d
            java.lang.String r9 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = 0
            goto L_0x008f
        L_0x008d:
            java.lang.Number r9 = (java.lang.Number) r9
        L_0x008f:
            int r9 = r9.intValue()
            float r9 = java.lang.Float.intBitsToFloat(r9)
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            return r9
        L_0x009c:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.w1(r10, r0)
            if (r2 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L_0x0031
        L_0x00ad:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00b8
            r10 = r0
            r0 = r2
            goto L_0x0040
        L_0x00b8:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r9 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "EOF while "
            r10.append(r1)
            r10.append(r0)
            java.lang.String r0 = " bytes expected"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00d4:
            r9.I1()
            r9.X1()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object o1(ByteBuffer byteBuffer, Continuation continuation) {
        int d1 = d1(byteBuffer);
        return !byteBuffer.hasRemaining() ? Boxing.boxInt(d1) : q1(byteBuffer, d1, continuation);
    }

    public final Object p(byte[] bArr, int i2, int i3, Continuation continuation) {
        int e1 = e1(bArr, i2, i3);
        if (e1 >= i3) {
            return Unit.INSTANCE;
        }
        Object r1 = r1(bArr, i2 + e1, i3 - e1, continuation);
        return r1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r1 : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p1(io.ktor.utils.io.core.internal.ChunkBuffer r12, int r13, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2
            if (r0 == 0) goto L_0x0013
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            int r11 = r0.I$1
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r10 = r0
            r0 = r12
            r12 = r2
        L_0x0037:
            r2 = r10
            goto L_0x006b
        L_0x0039:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = 0
            r10 = r12
            r12 = r11
            r11 = r14
            r14 = r13
            r13 = r10
        L_0x004a:
            int r2 = r13.g()
            int r4 = r13.k()
            if (r2 <= r4) goto L_0x009f
            if (r11 >= r14) goto L_0x009f
            r0.L$0 = r12
            r0.L$1 = r13
            r0.I$0 = r14
            r0.I$1 = r11
            r0.label = r3
            java.lang.Object r2 = r12.w1(r3, r0)
            if (r2 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r10 = r0
            r0 = r14
            r14 = r2
            goto L_0x0037
        L_0x006b:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0082
            int r7 = r0 - r11
            r8 = 2
            r9 = 0
            r6 = 0
            r4 = r12
            r5 = r13
            int r14 = f1(r4, r5, r6, r7, r8, r9)
            int r11 = r11 + r14
            r14 = r0
            r0 = r2
            goto L_0x004a
        L_0x0082:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r12 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Unexpected EOF: expected "
            r13.append(r14)
            int r0 = r0 - r11
            r13.append(r0)
            java.lang.String r11 = " more bytes"
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        L_0x009f:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.p1(io.ktor.utils.io.core.internal.ChunkBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readByte$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readByte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readByte$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L_0x0031:
            r2 = r8
            goto L_0x00a1
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r3
        L_0x0040:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.R1()
            r5 = 0
            if (r4 != 0) goto L_0x004d
            goto L_0x0080
        L_0x004d:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r9.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.b
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x005e
        L_0x0057:
            r9.I1()
            r9.X1()
            goto L_0x0080
        L_0x005e:
            boolean r7 = r6.m(r10)     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            int r5 = r4.remaining()     // Catch:{ all -> 0x006f }
            if (r5 >= r10) goto L_0x0071
            r9.N1(r4, r10)     // Catch:{ all -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r10 = move-exception
            goto L_0x00c8
        L_0x0071:
            byte r5 = r4.get()     // Catch:{ all -> 0x006f }
            java.lang.Byte r5 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r5)     // Catch:{ all -> 0x006f }
            r2.element = r5     // Catch:{ all -> 0x006f }
            r9.D0(r4, r6, r10)     // Catch:{ all -> 0x006f }
            r5 = r3
            goto L_0x0057
        L_0x0080:
            if (r5 == 0) goto L_0x0090
            T r9 = r2.element
            if (r9 != 0) goto L_0x008d
            java.lang.String r9 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = 0
            goto L_0x008f
        L_0x008d:
            java.lang.Number r9 = (java.lang.Number) r9
        L_0x008f:
            return r9
        L_0x0090:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.w1(r10, r0)
            if (r2 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L_0x0031
        L_0x00a1:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00ac
            r10 = r0
            r0 = r2
            goto L_0x0040
        L_0x00ac:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r9 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "EOF while "
            r10.append(r1)
            r10.append(r0)
            java.lang.String r0 = " bytes expected"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c8:
            r9.I1()
            r9.X1()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void r(int i2) {
        if (i2 >= 0) {
            ReadWriteBufferState R0 = R0();
            if (!R0.b.m(i2)) {
                throw new IllegalStateException("Unable to consume " + i2 + " bytes: not enough available bytes");
            } else if (i2 > 0) {
                D0(R0.b(), R0.b, i2);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r2(io.ktor.utils.io.core.Buffer r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            r0.<init>(r6, r8)
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
            goto L_0x0075
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x005d
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x0046:
            int r8 = r7.k()
            int r2 = r7.i()
            if (r8 <= r2) goto L_0x007c
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.Z1(r4, r0)
            if (r8 != r1) goto L_0x005d
            return r1
        L_0x005d:
            io.ktor.utils.io.internal.JoiningState r8 = r6.joining
            if (r8 == 0) goto L_0x0078
            io.ktor.utils.io.ByteBufferChannel r8 = r6.H1(r6, r8)
            if (r8 == 0) goto L_0x0078
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r8.M(r7, r0)
            if (r6 != r1) goto L_0x0075
            return r1
        L_0x0075:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0078:
            r6.b2(r7)
            goto L_0x0046
        L_0x007c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.r2(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object s(ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, Continuation continuation) {
        return Y0(this, byteBuffer, j2, j3, j4, j5, continuation);
    }

    public Object t(short s, Continuation continuation) {
        return y2(this, s, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046 A[SYNTHETIC, Splitter:B:17:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d A[SYNTHETIC, Splitter:B:30:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t1(int r6, io.ktor.utils.io.core.BytePacketBuilder r7, java.nio.ByteBuffer r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$2
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r7 = (io.ktor.utils.io.core.BytePacketBuilder) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r8 = (io.ktor.utils.io.ByteBufferChannel) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0037 }
            goto L_0x006b
        L_0x0037:
            r5 = move-exception
            goto L_0x0089
        L_0x0039:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0044:
            if (r6 <= 0) goto L_0x007d
            r8.clear()     // Catch:{ all -> 0x0053 }
            int r9 = r8.remaining()     // Catch:{ all -> 0x0053 }
            if (r9 <= r6) goto L_0x0056
            r8.limit(r6)     // Catch:{ all -> 0x0053 }
            goto L_0x0056
        L_0x0053:
            r5 = move-exception
            r6 = r8
            goto L_0x0089
        L_0x0056:
            r0.L$0 = r5     // Catch:{ all -> 0x0053 }
            r0.L$1 = r7     // Catch:{ all -> 0x0053 }
            r0.L$2 = r8     // Catch:{ all -> 0x0053 }
            r0.I$0 = r6     // Catch:{ all -> 0x0053 }
            r0.label = r3     // Catch:{ all -> 0x0053 }
            java.lang.Object r9 = r5.o1(r8, r0)     // Catch:{ all -> 0x0053 }
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r4 = r8
            r8 = r5
            r5 = r6
            r6 = r4
        L_0x006b:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ all -> 0x0037 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0037 }
            r6.flip()     // Catch:{ all -> 0x0037 }
            io.ktor.utils.io.core.OutputArraysJVMKt.a(r7, r6)     // Catch:{ all -> 0x0037 }
            int r5 = r5 - r9
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r4
            goto L_0x0044
        L_0x007d:
            io.ktor.utils.io.core.ByteReadPacket r5 = r7.F0()     // Catch:{ all -> 0x0053 }
            io.ktor.utils.io.pool.ObjectPool r6 = io.ktor.utils.io.internal.ObjectPoolKt.d()
            r6.recycle(r8)
            return r5
        L_0x0089:
            r7.release()     // Catch:{ all -> 0x008d }
            throw r5     // Catch:{ all -> 0x008d }
        L_0x008d:
            r5 = move-exception
            io.ktor.utils.io.pool.ObjectPool r7 = io.ktor.utils.io.internal.ObjectPoolKt.d()
            r7.recycle(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.t1(int, io.ktor.utils.io.core.BytePacketBuilder, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t2(byte[] r7, int r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0059
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0040:
            if (r9 <= 0) goto L_0x0068
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r10 = r6.h2(r7, r8, r9, r0)
            if (r10 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x0059:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            int r7 = r7 + r10
            int r6 = r6 - r10
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0040
        L_0x0068:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.t2(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + R0() + ')';
    }

    public Object u(ByteBuffer byteBuffer, Continuation continuation) {
        return h1(this, byteBuffer, continuation);
    }

    public Object v(ChunkBuffer chunkBuffer, Continuation continuation) {
        return g1(this, chunkBuffer, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072 A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091 A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf A[SYNTHETIC, Splitter:B:40:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4 A[SYNTHETIC, Splitter:B:42:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cd A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v1(long r13, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r12 = r0.L$4
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = (io.ktor.utils.io.core.internal.ChunkBuffer) r12
            java.lang.Object r13 = r0.L$3
            io.ktor.utils.io.core.Output r13 = (io.ktor.utils.io.core.Output) r13
            java.lang.Object r14 = r0.L$2
            kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r2 = (io.ktor.utils.io.core.BytePacketBuilder) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003e }
            goto L_0x00ae
        L_0x003e:
            r12 = move-exception
            goto L_0x00d6
        L_0x0041:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.utils.io.core.BytePacketBuilder r15 = new io.ktor.utils.io.core.BytePacketBuilder
            r2 = 0
            r15.<init>(r2, r3, r2)
            kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x00da }
            r4.<init>()     // Catch:{ all -> 0x00da }
            r4.element = r13     // Catch:{ all -> 0x00da }
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = io.ktor.utils.io.core.internal.UnsafeKt.d(r15, r3, r2)     // Catch:{ all -> 0x00da }
            r2 = r15
            r14 = r4
            r11 = r13
            r13 = r12
            r12 = r11
        L_0x0062:
            int r4 = r12.g()     // Catch:{ all -> 0x0077 }
            int r5 = r12.k()     // Catch:{ all -> 0x0077 }
            int r4 = r4 - r5
            long r4 = (long) r4     // Catch:{ all -> 0x0077 }
            long r6 = r14.element     // Catch:{ all -> 0x0077 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x007b
            int r4 = (int) r6     // Catch:{ all -> 0x0077 }
            r12.u(r4)     // Catch:{ all -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r12 = move-exception
            r13 = r15
            goto L_0x00d6
        L_0x007b:
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            r5 = r13
            r6 = r12
            int r4 = f1(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0077 }
            long r5 = r14.element     // Catch:{ all -> 0x0077 }
            long r7 = (long) r4     // Catch:{ all -> 0x0077 }
            long r5 = r5 - r7
            r14.element = r5     // Catch:{ all -> 0x0077 }
            r7 = 0
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x00bc
            boolean r4 = r13.Q()     // Catch:{ all -> 0x0077 }
            if (r4 != 0) goto L_0x00bc
            r0.L$0 = r13     // Catch:{ all -> 0x0077 }
            r0.L$1 = r2     // Catch:{ all -> 0x0077 }
            r0.L$2 = r14     // Catch:{ all -> 0x0077 }
            r0.L$3 = r15     // Catch:{ all -> 0x0077 }
            r0.L$4 = r12     // Catch:{ all -> 0x0077 }
            r0.label = r3     // Catch:{ all -> 0x0077 }
            java.lang.Object r4 = r13.w1(r3, r0)     // Catch:{ all -> 0x0077 }
            if (r4 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            r11 = r4
            r4 = r13
            r13 = r15
            r15 = r11
        L_0x00ae:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x003e }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x003e }
            if (r15 == 0) goto L_0x00ba
            r15 = r13
            r13 = r4
            r4 = r3
            goto L_0x00bd
        L_0x00ba:
            r15 = r13
            r13 = r4
        L_0x00bc:
            r4 = 0
        L_0x00bd:
            if (r4 == 0) goto L_0x00c4
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = io.ktor.utils.io.core.internal.UnsafeKt.d(r15, r3, r12)     // Catch:{ all -> 0x0077 }
            goto L_0x0062
        L_0x00c4:
            r15.b()     // Catch:{ all -> 0x00d2 }
            java.lang.Throwable r12 = r13.f()     // Catch:{ all -> 0x00d2 }
            if (r12 != 0) goto L_0x00d5
            io.ktor.utils.io.core.ByteReadPacket r12 = r2.F0()     // Catch:{ all -> 0x00d2 }
            return r12
        L_0x00d2:
            r12 = move-exception
            r15 = r2
            goto L_0x00db
        L_0x00d5:
            throw r12     // Catch:{ all -> 0x00d2 }
        L_0x00d6:
            r13.b()     // Catch:{ all -> 0x00d2 }
            throw r12     // Catch:{ all -> 0x00d2 }
        L_0x00da:
            r12 = move-exception
        L_0x00db:
            r15.release()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.v1(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object w(ByteReadPacket byteReadPacket, Continuation continuation) {
        return w2(this, byteReadPacket, continuation);
    }

    public final Object w1(int i2, Continuation continuation) {
        boolean z = true;
        if (R0().b._availableForRead$internal >= i2) {
            return Boxing.boxBoolean(true);
        }
        ClosedElement O0 = O0();
        if (O0 == null) {
            return i2 == 1 ? x1(1, continuation) : y1(i2, continuation);
        }
        Throwable b2 = O0.b();
        if (b2 == null) {
            RingBufferCapacity ringBufferCapacity = R0().b;
            if (!ringBufferCapacity.e() || ringBufferCapacity._availableForRead$internal < i2) {
                z = false;
            }
            if (Q0() == null) {
                return Boxing.boxBoolean(z);
            }
            throw new IllegalStateException("Read operation is already in progress");
        }
        Void unused = ByteBufferChannelKt.b(b2);
        throw new KotlinNothingValueException();
    }

    public Object x(int i2, Function1 function1, Continuation continuation) {
        return a2(this, i2, function1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x1(int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0075
        L_0x002d:
            r5 = move-exception
            goto L_0x0076
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r4.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r6.b
            int r2 = r2._availableForRead$internal
            if (r2 >= r5) goto L_0x007b
            io.ktor.utils.io.internal.JoiningState r2 = r4.joining
            if (r2 == 0) goto L_0x0056
            kotlin.coroutines.Continuation r2 = r4.U0()
            if (r2 == 0) goto L_0x0056
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r2 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.c
            if (r6 == r2) goto L_0x007b
            boolean r6 = r6 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r6 != 0) goto L_0x007b
        L_0x0056:
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.I$0 = r5     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            io.ktor.utils.io.internal.CancellableReusableContinuation r6 = r4.i     // Catch:{ all -> 0x002d }
            r4.U1(r5, r6)     // Catch:{ all -> 0x002d }
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = r6.g(r5)     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x002d }
            if (r6 != r5) goto L_0x0072
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x002d }
        L_0x0072:
            if (r6 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r6
        L_0x0076:
            r6 = 0
            r4.O1(r6)
            throw r5
        L_0x007b:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.x1(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ all -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A[Catch:{ all -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0084 A[SYNTHETIC, Splitter:B:41:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x2(io.ktor.utils.io.core.ByteReadPacket r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0030 }
            goto L_0x0079
        L_0x0030:
            r7 = move-exception
            goto L_0x008e
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0030 }
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x0060
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x004c:
            boolean r8 = r7.c0()     // Catch:{ all -> 0x007f }
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0088
            r0.L$0 = r6     // Catch:{ all -> 0x007f }
            r0.L$1 = r7     // Catch:{ all -> 0x007f }
            r0.label = r4     // Catch:{ all -> 0x007f }
            java.lang.Object r8 = r6.z2(r4, r0)     // Catch:{ all -> 0x007f }
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            io.ktor.utils.io.internal.JoiningState r8 = r6.joining     // Catch:{ all -> 0x007f }
            if (r8 == 0) goto L_0x0084
            io.ktor.utils.io.ByteBufferChannel r8 = r6.H1(r6, r8)     // Catch:{ all -> 0x007f }
            if (r8 == 0) goto L_0x0084
            r0.L$0 = r7     // Catch:{ all -> 0x007f }
            r6 = 0
            r0.L$1 = r6     // Catch:{ all -> 0x007f }
            r0.label = r3     // Catch:{ all -> 0x007f }
            java.lang.Object r6 = r8.w(r7, r0)     // Catch:{ all -> 0x007f }
            if (r6 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r6 = r7
        L_0x0079:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0030 }
            r6.release()
            return r7
        L_0x007f:
            r6 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x008e
        L_0x0084:
            r6.Y1(r7)     // Catch:{ all -> 0x007f }
            goto L_0x004c
        L_0x0088:
            r7.release()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x008e:
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.x2(io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object y(Function1 function1, Continuation continuation) {
        return E2(this, function1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y1(int r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x0097
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x003e:
            io.ktor.utils.io.internal.ReadWriteBufferState r8 = r6.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r8 = r8.b
            int r8 = r8._availableForRead$internal
            if (r8 < r7) goto L_0x004d
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L_0x004d:
            io.ktor.utils.io.internal.ClosedElement r8 = r6.O0()
            if (r8 == 0) goto L_0x008a
            java.lang.Throwable r0 = r8.b()
            if (r0 != 0) goto L_0x007d
            io.ktor.utils.io.internal.ReadWriteBufferState r8 = r6.R0()
            io.ktor.utils.io.internal.RingBufferCapacity r8 = r8.b
            boolean r0 = r8.e()
            if (r0 == 0) goto L_0x006a
            int r8 = r8._availableForRead$internal
            if (r8 < r7) goto L_0x006a
            r3 = r4
        L_0x006a:
            kotlin.coroutines.Continuation r6 = r6.Q0()
            if (r6 != 0) goto L_0x0075
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L_0x0075:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Read operation is already in progress"
            r6.<init>(r7)
            throw r6
        L_0x007d:
            java.lang.Throwable r6 = r8.b()
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.b(r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x008a:
            r0.L$0 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r6.x1(r7, r0)
            if (r8 != r1) goto L_0x0097
            return r1
        L_0x0097:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x003e
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.y1(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean z() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z2(int r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
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
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.io.ByteBufferChannel) r6
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
            boolean r7 = r5.C2(r6)
            if (r7 == 0) goto L_0x0068
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r7.<init>(r2, r3)
            r7.x()
            r5.B2(r6, r7)
            java.lang.Object r7 = r7.u()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r2) goto L_0x0065
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0065:
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x0068:
            io.ktor.utils.io.internal.ClosedElement r5 = r5.O0()
            if (r5 == 0) goto L_0x007e
            java.lang.Throwable r5 = r5.c()
            if (r5 != 0) goto L_0x0075
            goto L_0x007e
        L_0x0075:
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.b(r5)
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L_0x007e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.z2(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ByteBufferChannel(boolean z, ObjectPool objectPool, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i3 & 2) != 0 ? ObjectPoolKt.c() : objectPool, (i3 & 4) != 0 ? 8 : i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel(ByteBuffer byteBuffer) {
        this(false, ObjectPoolKt.b(), 0);
        Intrinsics.checkNotNullParameter(byteBuffer, "content");
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(slice, 0);
        initial.b.i();
        this._state = initial.e();
        J1();
        ByteWriteChannelKt.a(this);
        X1();
    }
}
