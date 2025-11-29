package com.rousetime.android_startup;

import android.content.Context;
import com.rousetime.android_startup.dispatcher.Dispatcher;
import com.rousetime.android_startup.executor.StartupExecutor;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00000\t\u0018\u00010\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bH&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u00020\u00142\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/rousetime/android_startup/Startup;", "T", "Lcom/rousetime/android_startup/dispatcher/Dispatcher;", "Lcom/rousetime/android_startup/executor/StartupExecutor;", "Landroid/content/Context;", "context", "a", "(Landroid/content/Context;)Ljava/lang/Object;", "", "Ljava/lang/Class;", "dependencies", "()Ljava/util/List;", "", "f", "", "k", "()I", "startup", "", "result", "", "b", "(Lcom/rousetime/android_startup/Startup;Ljava/lang/Object;)V", "", "i", "()Z", "dispatcher", "c", "(Lcom/rousetime/android_startup/dispatcher/Dispatcher;)V", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public interface Startup<T> extends Dispatcher, StartupExecutor {
    Object a(Context context);

    void b(Startup startup, Object obj);

    void c(Dispatcher dispatcher);

    List dependencies();

    List f();

    boolean i();

    int k();
}
