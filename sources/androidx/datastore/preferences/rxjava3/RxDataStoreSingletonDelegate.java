package androidx.datastore.preferences.rxjava3;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.rxjava3.RxDataStore;
import io.reactivex.rxjava3.core.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR,\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00130\u00120\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/datastore/preferences/rxjava3/RxDataStoreSingletonDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/rxjava3/RxDataStore;", "Landroidx/datastore/preferences/core/Preferences;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Landroid/content/Context;Lkotlin/reflect/KProperty;)Landroidx/datastore/rxjava3/RxDataStore;", "", "Ljava/lang/String;", "fileName", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "b", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "c", "Lkotlin/jvm/functions/Function1;", "produceMigrations", "Lio/reactivex/rxjava3/core/Scheduler;", "d", "Lio/reactivex/rxjava3/core/Scheduler;", "scheduler", "", "e", "Ljava/lang/Object;", "lock", "f", "Landroidx/datastore/rxjava3/RxDataStore;", "INSTANCE", "datastore-preferences-rxjava3_release"}, k = 1, mv = {1, 5, 1})
public final class RxDataStoreSingletonDelegate implements ReadOnlyProperty<Context, RxDataStore<Preferences>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f1165a;
    public final ReplaceFileCorruptionHandler b;
    public final Function1 c;
    public final Scheduler d;
    public final Object e;
    public volatile RxDataStore f;

    /* renamed from: a */
    public RxDataStore getValue(Context context, KProperty kProperty) {
        RxDataStore rxDataStore;
        Intrinsics.checkNotNullParameter(context, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        RxDataStore rxDataStore2 = this.f;
        if (rxDataStore2 != null) {
            return rxDataStore2;
        }
        synchronized (this.e) {
            try {
                if (this.f == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    RxPreferenceDataStoreBuilder rxPreferenceDataStoreBuilder = new RxPreferenceDataStoreBuilder(applicationContext, this.f1165a);
                    rxPreferenceDataStoreBuilder.d(this.d);
                    for (DataMigration a2 : (Iterable) this.c.invoke(applicationContext)) {
                        rxPreferenceDataStoreBuilder.a(a2);
                    }
                    ReplaceFileCorruptionHandler replaceFileCorruptionHandler = this.b;
                    if (replaceFileCorruptionHandler != null) {
                        rxPreferenceDataStoreBuilder.c(replaceFileCorruptionHandler);
                    }
                    this.f = rxPreferenceDataStoreBuilder.b();
                }
                rxDataStore = this.f;
                Intrinsics.checkNotNull(rxDataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return rxDataStore;
    }
}
