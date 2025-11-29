package androidx.datastore.preferences.rxjava3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.rxjava3.RxDataStore;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001eR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "", "Landroid/content/Context;", "context", "", "name", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Scheduler;", "ioScheduler", "d", "(Lio/reactivex/rxjava3/core/Scheduler;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "c", "(Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/core/DataMigration;", "dataMigration", "a", "(Landroidx/datastore/core/DataMigration;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/rxjava3/RxDataStore;", "b", "()Landroidx/datastore/rxjava3/RxDataStore;", "Ljava/util/concurrent/Callable;", "Ljava/io/File;", "Ljava/util/concurrent/Callable;", "produceFile", "Landroid/content/Context;", "Ljava/lang/String;", "Lio/reactivex/rxjava3/core/Scheduler;", "e", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "", "f", "Ljava/util/List;", "dataMigrations", "datastore-preferences-rxjava3_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"TopLevelBuilder"})
public final class RxPreferenceDataStoreBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Callable f1166a;
    public Context b;
    public String c;
    public Scheduler d;
    public ReplaceFileCorruptionHandler e;
    public final List f = new ArrayList();

    public RxPreferenceDataStoreBuilder(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.d = io2;
        this.b = context;
        this.c = str;
    }

    public final RxPreferenceDataStoreBuilder a(DataMigration dataMigration) {
        Intrinsics.checkNotNullParameter(dataMigration, "dataMigration");
        this.f.add(dataMigration);
        return this;
    }

    public final RxDataStore b() {
        DataStore dataStore;
        CoroutineScope a2 = CoroutineScopeKt.a(RxSchedulerKt.d(this.d).plus(JobKt__JobKt.b((Job) null, 1, (Object) null)));
        Callable callable = this.f1166a;
        Context context = this.b;
        String str = this.c;
        if (callable != null) {
            dataStore = PreferenceDataStoreFactory.f1039a.a(this.e, this.f, a2, new RxPreferenceDataStoreBuilder$build$delegate$1(callable));
        } else if (context == null || str == null) {
            throw new IllegalStateException("Either produceFile or context and name must be set. This should never happen.".toString());
        } else {
            dataStore = PreferenceDataStoreFactory.f1039a.a(this.e, this.f, a2, new RxPreferenceDataStoreBuilder$build$delegate$2(context, str));
        }
        return RxDataStore.c.a(dataStore, a2);
    }

    public final RxPreferenceDataStoreBuilder c(ReplaceFileCorruptionHandler replaceFileCorruptionHandler) {
        Intrinsics.checkNotNullParameter(replaceFileCorruptionHandler, "corruptionHandler");
        this.e = replaceFileCorruptionHandler;
        return this;
    }

    public final RxPreferenceDataStoreBuilder d(Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.d = scheduler;
        return this;
    }
}
