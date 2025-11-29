package io.ktor.util.debug;

import java.lang.management.ManagementFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class IntellijIdeaDebugDetector$isDebuggerConnected$2 extends Lambda implements Function0<Boolean> {
    public static final IntellijIdeaDebugDetector$isDebuggerConnected$2 INSTANCE = new IntellijIdeaDebugDetector$isDebuggerConnected$2();

    public IntellijIdeaDebugDetector$isDebuggerConnected$2() {
        super(0);
    }

    @NotNull
    public final Boolean invoke() {
        boolean z = false;
        try {
            z = StringsKt.contains$default((CharSequence) ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), (CharSequence) "jdwp", false, 2, (Object) null);
        } catch (Throwable unused) {
        }
        return Boolean.valueOf(z);
    }
}
