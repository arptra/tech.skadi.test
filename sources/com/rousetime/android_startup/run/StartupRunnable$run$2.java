package com.rousetime.android_startup.run;

import com.rousetime.android_startup.Startup;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a \u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Ljava/lang/Class;", "Lcom/rousetime/android_startup/Startup;", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class StartupRunnable$run$2 extends Lambda implements Function0<Triple<? extends Class<? extends Startup<?>>, ? extends Boolean, ? extends Boolean>> {
    final /* synthetic */ StartupRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartupRunnable$run$2(StartupRunnable startupRunnable) {
        super(0);
        this.this$0 = startupRunnable;
    }

    @NotNull
    public final Triple<Class<? extends Startup<?>>, Boolean, Boolean> invoke() {
        return new Triple<>(this.this$0.b.getClass(), Boolean.valueOf(this.this$0.b.g()), Boolean.valueOf(this.this$0.b.h()));
    }
}
