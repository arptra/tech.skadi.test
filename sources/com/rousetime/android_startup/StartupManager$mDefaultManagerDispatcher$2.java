package com.rousetime.android_startup;

import com.rousetime.android_startup.dispatcher.StartupManagerDispatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/rousetime/android_startup/dispatcher/StartupManagerDispatcher;", "invoke"}, k = 3, mv = {1, 1, 16})
public final class StartupManager$mDefaultManagerDispatcher$2 extends Lambda implements Function0<StartupManagerDispatcher> {
    final /* synthetic */ StartupManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartupManager$mDefaultManagerDispatcher$2(StartupManager startupManager) {
        super(0);
        this.this$0 = startupManager;
    }

    @NotNull
    public final StartupManagerDispatcher invoke() {
        return new StartupManagerDispatcher(this.this$0.c, this.this$0.e, this.this$0.f9819a, this.this$0.d.size(), this.this$0.f.b());
    }
}
