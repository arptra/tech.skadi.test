package androidx.datastore;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002J*\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R,\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00160\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/datastore/DataStoreSingletonDelegate;", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "b", "(Landroid/content/Context;Lkotlin/reflect/KProperty;)Landroidx/datastore/core/DataStore;", "", "a", "Ljava/lang/String;", "fileName", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "c", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "d", "Lkotlin/jvm/functions/Function1;", "produceMigrations", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "f", "Ljava/lang/Object;", "lock", "g", "Landroidx/datastore/core/DataStore;", "INSTANCE", "datastore_release"}, k = 1, mv = {1, 5, 1})
public final class DataStoreSingletonDelegate<T> implements ReadOnlyProperty<Context, DataStore<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f1012a;
    public final Serializer b;
    public final ReplaceFileCorruptionHandler c;
    public final Function1 d;
    public final CoroutineScope e;
    public final Object f;
    public volatile DataStore g;

    /* renamed from: b */
    public DataStore getValue(Context context, KProperty kProperty) {
        DataStore dataStore;
        Intrinsics.checkNotNullParameter(context, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        DataStore dataStore2 = this.g;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.f) {
            try {
                if (this.g == null) {
                    Context applicationContext = context.getApplicationContext();
                    Serializer serializer = this.b;
                    ReplaceFileCorruptionHandler replaceFileCorruptionHandler = this.c;
                    Function1 function1 = this.d;
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    CoroutineScope coroutineScope = this.e;
                    this.g = DataStoreFactory.f1015a.a(serializer, replaceFileCorruptionHandler, (List) function1.invoke(applicationContext), coroutineScope, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
                }
                dataStore = this.g;
                Intrinsics.checkNotNull(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
