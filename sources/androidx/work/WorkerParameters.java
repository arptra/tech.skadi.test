package androidx.work;

import android.net.Network;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    public UUID f2075a;
    public Data b;
    public Set c;
    public RuntimeExtras d;
    public int e;
    public Executor f;
    public TaskExecutor g;
    public WorkerFactory h;
    public ProgressUpdater i;
    public ForegroundUpdater j;
    public int k;

    @RestrictTo
    public static class RuntimeExtras {

        /* renamed from: a  reason: collision with root package name */
        public List f2076a = Collections.emptyList();
        public List b = Collections.emptyList();
        public Network c;
    }

    public WorkerParameters(UUID uuid, Data data, Collection collection, RuntimeExtras runtimeExtras, int i2, int i3, Executor executor, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.f2075a = uuid;
        this.b = data;
        this.c = new HashSet(collection);
        this.d = runtimeExtras;
        this.e = i2;
        this.k = i3;
        this.f = executor;
        this.g = taskExecutor;
        this.h = workerFactory;
        this.i = progressUpdater;
        this.j = foregroundUpdater;
    }

    public Executor a() {
        return this.f;
    }

    public ForegroundUpdater b() {
        return this.j;
    }

    public UUID c() {
        return this.f2075a;
    }

    public Data d() {
        return this.b;
    }

    public TaskExecutor e() {
        return this.g;
    }

    public WorkerFactory f() {
        return this.h;
    }
}
