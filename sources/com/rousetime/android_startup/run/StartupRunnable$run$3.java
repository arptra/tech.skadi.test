package com.rousetime.android_startup.run;

import com.rousetime.android_startup.Startup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "Lcom/rousetime/android_startup/Startup;", "invoke"}, k = 3, mv = {1, 1, 16})
public final class StartupRunnable$run$3 extends Lambda implements Function0<Class<? extends Startup<?>>> {
    final /* synthetic */ StartupRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartupRunnable$run$3(StartupRunnable startupRunnable) {
        super(0);
        this.this$0 = startupRunnable;
    }

    @NotNull
    public final Class<? extends Startup<?>> invoke() {
        return this.this$0.b.getClass();
    }
}
