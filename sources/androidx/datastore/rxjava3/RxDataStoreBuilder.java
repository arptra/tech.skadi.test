package androidx.datastore.rxjava3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.rx3.RxSchedulerKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010$R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010&R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130'8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010(¨\u0006*"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "", "T", "Landroid/content/Context;", "context", "", "fileName", "Landroidx/datastore/core/Serializer;", "serializer", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroidx/datastore/core/Serializer;)V", "Lio/reactivex/rxjava3/core/Scheduler;", "ioScheduler", "g", "(Lio/reactivex/rxjava3/core/Scheduler;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "f", "(Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/core/DataMigration;", "dataMigration", "d", "(Landroidx/datastore/core/DataMigration;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/rxjava3/RxDataStore;", "e", "()Landroidx/datastore/rxjava3/RxDataStore;", "Ljava/util/concurrent/Callable;", "Ljava/io/File;", "a", "Ljava/util/concurrent/Callable;", "produceFile", "b", "Landroid/content/Context;", "c", "Ljava/lang/String;", "name", "Landroidx/datastore/core/Serializer;", "Lio/reactivex/rxjava3/core/Scheduler;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "", "Ljava/util/List;", "dataMigrations", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"TopLevelBuilder"})
public final class RxDataStoreBuilder<T> {

    /* renamed from: a  reason: collision with root package name */
    public Callable f1169a;
    public Context b;
    public String c;
    public Serializer d;
    public Scheduler e;
    public ReplaceFileCorruptionHandler f;
    public final List g = new ArrayList();

    public RxDataStoreBuilder(Context context, String str, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.e = io2;
        this.b = context;
        this.c = str;
        this.d = serializer;
    }

    public final RxDataStoreBuilder d(DataMigration dataMigration) {
        Intrinsics.checkNotNullParameter(dataMigration, "dataMigration");
        this.g.add(dataMigration);
        return this;
    }

    public final RxDataStore e() {
        DataStore dataStore;
        CoroutineScope a2 = CoroutineScopeKt.a(RxSchedulerKt.d(this.e).plus(JobKt__JobKt.b((Job) null, 1, (Object) null)));
        if (this.f1169a != null) {
            Serializer serializer = this.d;
            Intrinsics.checkNotNull(serializer);
            dataStore = DataStoreFactory.f1015a.a(serializer, this.f, this.g, a2, new RxDataStoreBuilder$build$delegateDs$1(this));
        } else if (this.b == null || this.c == null) {
            throw new IllegalStateException("Either produceFile or context and name must be set. This should never happen.".toString());
        } else {
            Serializer serializer2 = this.d;
            Intrinsics.checkNotNull(serializer2);
            dataStore = DataStoreFactory.f1015a.a(serializer2, this.f, this.g, a2, new RxDataStoreBuilder$build$delegateDs$2(this));
        }
        return RxDataStore.c.a(dataStore, a2);
    }

    public final RxDataStoreBuilder f(ReplaceFileCorruptionHandler replaceFileCorruptionHandler) {
        Intrinsics.checkNotNullParameter(replaceFileCorruptionHandler, "corruptionHandler");
        this.f = replaceFileCorruptionHandler;
        return this;
    }

    public final RxDataStoreBuilder g(Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.e = scheduler;
        return this;
    }
}
