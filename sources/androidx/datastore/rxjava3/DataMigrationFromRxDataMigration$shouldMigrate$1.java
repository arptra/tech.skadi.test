package androidx.datastore.rxjava3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.rxjava3.DataMigrationFromRxDataMigration", f = "RxDataStoreBuilder.kt", i = {}, l = {172}, m = "shouldMigrate", n = {}, s = {})
public final class DataMigrationFromRxDataMigration$shouldMigrate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataMigrationFromRxDataMigration<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataMigrationFromRxDataMigration$shouldMigrate$1(DataMigrationFromRxDataMigration<T> dataMigrationFromRxDataMigration, Continuation<? super DataMigrationFromRxDataMigration$shouldMigrate$1> continuation) {
        super(continuation);
        this.this$0 = dataMigrationFromRxDataMigration;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((Object) null, this);
    }
}
