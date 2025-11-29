package androidx.datastore.rxjava3;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface RxDataMigration<T> {
    Single a(Object obj);

    Single b(Object obj);

    Completable cleanUp();
}
