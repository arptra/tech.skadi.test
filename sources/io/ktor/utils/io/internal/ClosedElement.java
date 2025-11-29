package io.ktor.utils.io.internal;

import io.ktor.utils.io.ClosedWriteChannelException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/internal/ClosedElement;", "", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/Throwable;", "b", "()Ljava/lang/Throwable;", "c", "sendException", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ClosedElement {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final ClosedElement c = new ClosedElement((Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f9100a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/internal/ClosedElement$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/internal/ClosedElement;", "EmptyCause", "Lio/ktor/utils/io/internal/ClosedElement;", "a", "()Lio/ktor/utils/io/internal/ClosedElement;", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClosedElement a() {
            return ClosedElement.c;
        }

        public Companion() {
        }
    }

    public ClosedElement(Throwable th) {
        this.f9100a = th;
    }

    public final Throwable b() {
        return this.f9100a;
    }

    public final Throwable c() {
        Throwable th = this.f9100a;
        return th == null ? new ClosedWriteChannelException("The channel was closed") : th;
    }

    public String toString() {
        return "Closed[" + c() + ']';
    }
}
