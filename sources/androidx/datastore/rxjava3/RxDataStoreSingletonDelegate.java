package androidx.datastore.rxjava3;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import io.reactivex.rxjava3.core.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003J*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R,\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00170\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStoreSingletonDelegate;", "", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/rxjava3/RxDataStore;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Landroid/content/Context;Lkotlin/reflect/KProperty;)Landroidx/datastore/rxjava3/RxDataStore;", "", "Ljava/lang/String;", "fileName", "Landroidx/datastore/core/Serializer;", "b", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "c", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "d", "Lkotlin/jvm/functions/Function1;", "produceMigrations", "Lio/reactivex/rxjava3/core/Scheduler;", "e", "Lio/reactivex/rxjava3/core/Scheduler;", "scheduler", "f", "Ljava/lang/Object;", "lock", "g", "Landroidx/datastore/rxjava3/RxDataStore;", "INSTANCE", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
public final class RxDataStoreSingletonDelegate<T> implements ReadOnlyProperty<Context, RxDataStore<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f1170a;
    public final Serializer b;
    public final ReplaceFileCorruptionHandler c;
    public final Function1 d;
    public final Scheduler e;
    public final Object f;
    public volatile RxDataStore g;

    /* renamed from: a */
    public RxDataStore getValue(Context context, KProperty kProperty) {
        RxDataStore rxDataStore;
        Intrinsics.checkNotNullParameter(context, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        RxDataStore rxDataStore2 = this.g;
        if (rxDataStore2 != null) {
            return rxDataStore2;
        }
        synchronized (this.f) {
            try {
                if (this.g == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    RxDataStoreBuilder rxDataStoreBuilder = new RxDataStoreBuilder(applicationContext, this.f1170a, this.b);
                    rxDataStoreBuilder.g(this.e);
                    for (DataMigration d2 : (Iterable) this.d.invoke(applicationContext)) {
                        rxDataStoreBuilder.d(d2);
                    }
                    ReplaceFileCorruptionHandler replaceFileCorruptionHandler = this.c;
                    if (replaceFileCorruptionHandler != null) {
                        rxDataStoreBuilder.f(replaceFileCorruptionHandler);
                    }
                    this.g = rxDataStoreBuilder.e();
                }
                rxDataStore = this.g;
                Intrinsics.checkNotNull(rxDataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return rxDataStore;
    }
}
