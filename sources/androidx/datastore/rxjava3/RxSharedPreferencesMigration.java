package androidx.datastore.rxjava3;

import androidx.datastore.migrations.SharedPreferencesView;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/rxjava3/RxSharedPreferencesMigration;", "T", "", "currentData", "Lio/reactivex/rxjava3/core/Single;", "", "a", "(Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Single;", "Landroidx/datastore/migrations/SharedPreferencesView;", "sharedPreferencesView", "b", "(Landroidx/datastore/migrations/SharedPreferencesView;Ljava/lang/Object;)Lio/reactivex/rxjava3/core/Single;", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
public interface RxSharedPreferencesMigration<T> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
    }

    Single a(Object obj);

    Single b(SharedPreferencesView sharedPreferencesView, Object obj);
}
