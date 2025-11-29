package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\u0001\u0007\u001f !\"#$%¨\u0006&"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState;", "", "Ljava/nio/ByteBuffer;", "backingBuffer", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "capacity", "<init>", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;)V", "d", "()Lio/ktor/utils/io/internal/ReadWriteBufferState;", "e", "f", "g", "a", "Ljava/nio/ByteBuffer;", "b", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "", "()Z", "idle", "()Ljava/nio/ByteBuffer;", "readBuffer", "c", "writeBuffer", "IdleEmpty", "IdleNonEmpty", "Initial", "Reading", "ReadingWriting", "Terminated", "Writing", "Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleEmpty;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Terminated;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "ktor-io"}, k = 1, mv = {1, 8, 0})
public abstract class ReadWriteBufferState {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f9103a;
    public final RingBufferCapacity b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleEmpty;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "a", "()Z", "idle", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class IdleEmpty extends ReadWriteBufferState {
        public static final IdleEmpty c = new IdleEmpty();

        public IdleEmpty() {
            super(ReadWriteBufferStateKt.a(), ReadWriteBufferStateKt.b(), (DefaultConstructorMarker) null);
        }

        public boolean a() {
            return true;
        }

        public String toString() {
            return "IDLE(empty)";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "initial", "<init>", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "i", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "j", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "", "toString", "()Ljava/lang/String;", "c", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "h", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "", "a", "()Z", "idle", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class IdleNonEmpty extends ReadWriteBufferState {
        public final Initial c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IdleNonEmpty(Initial initial) {
            super(initial.f9103a, initial.b, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.c = initial;
        }

        public boolean a() {
            return true;
        }

        public final Initial h() {
            return this.c;
        }

        /* renamed from: i */
        public Reading d() {
            return this.c.i();
        }

        /* renamed from: j */
        public Writing e() {
            return this.c.k();
        }

        public String toString() {
            return "IDLE(with buffer)";
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u00188\u0000X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u001a\u0010%\u001a\u00020\u000b8\u0000X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\rR\u001a\u0010*\u001a\u00020&8\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "Ljava/nio/ByteBuffer;", "backingBuffer", "", "reservedSize", "<init>", "(Ljava/nio/ByteBuffer;I)V", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "l", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "m", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "", "toString", "()Ljava/lang/String;", "c", "Ljava/nio/ByteBuffer;", "()Ljava/nio/ByteBuffer;", "writeBuffer", "d", "b", "readBuffer", "Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "e", "Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "h", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "idleState", "f", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "i", "readingState", "g", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "k", "writingState", "Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "j", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "readingWritingState", "", "a", "()Z", "idle", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Initial extends ReadWriteBufferState {
        public final ByteBuffer c;
        public final ByteBuffer d;
        public final IdleNonEmpty e;
        public final Reading f;
        public final Writing g;
        public final ReadingWriting h;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Initial(ByteBuffer byteBuffer, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(byteBuffer, (i2 & 2) != 0 ? 8 : i);
        }

        public boolean a() {
            throw new IllegalStateException("Not available for initial state".toString());
        }

        public ByteBuffer b() {
            return this.d;
        }

        public ByteBuffer c() {
            return this.c;
        }

        public final IdleNonEmpty h() {
            return this.e;
        }

        public final Reading i() {
            return this.f;
        }

        public final ReadingWriting j() {
            return this.h;
        }

        public final Writing k() {
            return this.g;
        }

        /* renamed from: l */
        public Reading d() {
            return this.f;
        }

        /* renamed from: m */
        public Writing e() {
            return this.g;
        }

        public String toString() {
            return "Initial";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Initial(ByteBuffer byteBuffer, int i) {
            super(byteBuffer, new RingBufferCapacity(byteBuffer.capacity() - i), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(byteBuffer, "backingBuffer");
            if (byteBuffer.position() != 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (byteBuffer.limit() == byteBuffer.capacity()) {
                ByteBuffer duplicate = byteBuffer.duplicate();
                Intrinsics.checkNotNullExpressionValue(duplicate, "backingBuffer.duplicate()");
                this.c = duplicate;
                ByteBuffer duplicate2 = byteBuffer.duplicate();
                Intrinsics.checkNotNullExpressionValue(duplicate2, "backingBuffer.duplicate()");
                this.d = duplicate2;
                this.e = new IdleNonEmpty(this);
                this.f = new Reading(this);
                this.g = new Writing(this);
                this.h = new ReadingWriting(this);
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "initial", "<init>", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "h", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "i", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "", "toString", "()Ljava/lang/String;", "c", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Ljava/nio/ByteBuffer;", "b", "()Ljava/nio/ByteBuffer;", "readBuffer", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Reading extends ReadWriteBufferState {
        public final Initial c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Reading(Initial initial) {
            super(initial.f9103a, initial.b, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.c = initial;
        }

        public ByteBuffer b() {
            return this.c.b();
        }

        /* renamed from: h */
        public ReadingWriting e() {
            return this.c.j();
        }

        /* renamed from: i */
        public IdleNonEmpty f() {
            return this.c.h();
        }

        public String toString() {
            return "Reading";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0013¨\u0006\u0016"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "initial", "<init>", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "h", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "i", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Reading;", "", "toString", "()Ljava/lang/String;", "c", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Ljava/nio/ByteBuffer;", "b", "()Ljava/nio/ByteBuffer;", "readBuffer", "writeBuffer", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class ReadingWriting extends ReadWriteBufferState {
        public final Initial c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReadingWriting(Initial initial) {
            super(initial.f9103a, initial.b, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.c = initial;
        }

        public ByteBuffer b() {
            return this.c.b();
        }

        public ByteBuffer c() {
            return this.c.c();
        }

        /* renamed from: h */
        public Writing f() {
            return this.c.k();
        }

        /* renamed from: i */
        public Reading g() {
            return this.c.i();
        }

        public String toString() {
            return "Reading+Writing";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$Terminated;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "()V", "toString", "", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Terminated extends ReadWriteBufferState {
        public static final Terminated c = new Terminated();

        public Terminated() {
            super(ReadWriteBufferStateKt.a(), ReadWriteBufferStateKt.b(), (DefaultConstructorMarker) null);
        }

        public String toString() {
            return "Terminated";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/internal/ReadWriteBufferState$Writing;", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "initial", "<init>", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "h", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$ReadingWriting;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "i", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$IdleNonEmpty;", "", "toString", "()Ljava/lang/String;", "c", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Ljava/nio/ByteBuffer;", "()Ljava/nio/ByteBuffer;", "writeBuffer", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Writing extends ReadWriteBufferState {
        public final Initial c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Writing(Initial initial) {
            super(initial.f9103a, initial.b, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.c = initial;
        }

        public ByteBuffer c() {
            return this.c.c();
        }

        /* renamed from: h */
        public ReadingWriting d() {
            return this.c.j();
        }

        /* renamed from: i */
        public IdleNonEmpty g() {
            return this.c.h();
        }

        public String toString() {
            return "Writing";
        }
    }

    public /* synthetic */ ReadWriteBufferState(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, ringBufferCapacity);
    }

    public boolean a() {
        return false;
    }

    public ByteBuffer b() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    public ByteBuffer c() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    public ReadWriteBufferState d() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    public ReadWriteBufferState e() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    public ReadWriteBufferState f() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    public ReadWriteBufferState g() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }

    public ReadWriteBufferState(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity) {
        this.f9103a = byteBuffer;
        this.b = ringBufferCapacity;
    }
}
