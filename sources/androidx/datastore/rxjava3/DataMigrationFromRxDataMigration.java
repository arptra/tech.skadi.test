package androidx.datastore.rxjava3;

import androidx.datastore.core.DataMigration;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx3.RxAwaitKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u0013\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/datastore/rxjava3/DataMigrationFromRxDataMigration;", "T", "Landroidx/datastore/core/DataMigration;", "currentData", "", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/rxjava3/RxDataMigration;", "Landroidx/datastore/rxjava3/RxDataMigration;", "migration", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
public final class DataMigrationFromRxDataMigration<T> implements DataMigration<T> {

    /* renamed from: a  reason: collision with root package name */
    public final RxDataMigration f1167a;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.rxjava3.DataMigrationFromRxDataMigration$shouldMigrate$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.rxjava3.DataMigrationFromRxDataMigration$shouldMigrate$1 r0 = (androidx.datastore.rxjava3.DataMigrationFromRxDataMigration$shouldMigrate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.rxjava3.DataMigrationFromRxDataMigration$shouldMigrate$1 r0 = new androidx.datastore.rxjava3.DataMigrationFromRxDataMigration$shouldMigrate$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.datastore.rxjava3.RxDataMigration r4 = r4.f1167a
            io.reactivex.rxjava3.core.Single r4 = r4.a(r5)
            java.lang.String r5 = "migration.shouldMigrate(currentData)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.rx3.RxAwaitKt.b(r4, r0)
            if (r6 != r1) goto L_0x0048
            return r1
        L_0x0048:
            java.lang.String r4 = "migration.shouldMigrate(currentData).await()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.rxjava3.DataMigrationFromRxDataMigration.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object b(Continuation continuation) {
        Completable cleanUp = this.f1167a.cleanUp();
        Intrinsics.checkNotNullExpressionValue(cleanUp, "migration.cleanUp()");
        Object a2 = RxAwaitKt.a(cleanUp, continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public Object c(Object obj, Continuation continuation) {
        Single b = this.f1167a.b(obj);
        Intrinsics.checkNotNullExpressionValue(b, "migration.migrate(currentData)");
        return RxAwaitKt.b(b, continuation);
    }
}
