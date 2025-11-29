package com.honey.account.utils.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/honey/account/utils/thread/MainExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mHandler", "Landroid/os/Handler;", "execute", "", "command", "Ljava/lang/Runnable;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainExecutor implements Executor {
    @NotNull
    public static final MainExecutor INSTANCE = new MainExecutor();
    @NotNull
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    private MainExecutor() {
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        mHandler.post(runnable);
    }
}
