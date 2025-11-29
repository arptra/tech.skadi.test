package com.rousetime.android_startup.dispatcher;

import com.rousetime.android_startup.Startup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class StartupManagerDispatcher$dispatch$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Startup $startup;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartupManagerDispatcher$dispatch$1(Startup startup) {
        super(0);
        this.$startup = startup;
    }

    @NotNull
    public final String invoke() {
        return this.$startup.getClass().getSimpleName() + " being dispatching, onMainThread " + this.$startup.g() + '.';
    }
}
