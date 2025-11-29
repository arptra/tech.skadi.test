package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f3775a = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.class, "sequenceNumber");
    @Volatile
    private volatile long sequenceNumber;

    public DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
