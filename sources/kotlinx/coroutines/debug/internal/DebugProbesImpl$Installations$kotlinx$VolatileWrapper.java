package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class DebugProbesImpl$Installations$kotlinx$VolatileWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f3774a = AtomicIntegerFieldUpdater.newUpdater(DebugProbesImpl$Installations$kotlinx$VolatileWrapper.class, "installations");
    @Volatile
    private volatile int installations;

    public DebugProbesImpl$Installations$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$Installations$kotlinx$VolatileWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
