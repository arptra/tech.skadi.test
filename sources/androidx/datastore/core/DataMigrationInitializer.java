package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", "T", "", "a", "Companion", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class DataMigrationInitializer<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f1014a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u000f\u001a3\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0011\u001a\u00020\u000e\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\tH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", "", "<init>", "()V", "T", "", "Landroidx/datastore/core/DataMigration;", "migrations", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "b", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "c", "(Ljava/util/List;Landroidx/datastore/core/InitializerApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function2 b(List list) {
            Intrinsics.checkNotNullParameter(list, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(list, (Continuation<? super DataMigrationInitializer$Companion$getInitializer$1>) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object c(java.util.List r6, androidx.datastore.core.InitializerApi r7, kotlin.coroutines.Continuation r8) {
            /*
                r5 = this;
                boolean r0 = r8 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L_0x0013
                r0 = r8
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r5, r8)
            L_0x0018:
                java.lang.Object r5 = r0.result
                java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r0.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0046
                if (r1 == r3) goto L_0x003e
                if (r1 != r2) goto L_0x0036
                java.lang.Object r6 = r0.L$1
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r0.L$0
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0034 }
                goto L_0x006a
            L_0x0034:
                r5 = move-exception
                goto L_0x0083
            L_0x0036:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x003e:
                java.lang.Object r6 = r0.L$0
                java.util.List r6 = (java.util.List) r6
                kotlin.ResultKt.throwOnFailure(r5)
                goto L_0x0060
            L_0x0046:
                kotlin.ResultKt.throwOnFailure(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r1 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r4 = 0
                r1.<init>(r6, r5, r4)
                r0.L$0 = r5
                r0.label = r3
                java.lang.Object r6 = r7.a(r1, r0)
                if (r6 != r8) goto L_0x005f
                return r8
            L_0x005f:
                r6 = r5
            L_0x0060:
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L_0x006a:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L_0x0095
                java.lang.Object r5 = r6.next()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r0.L$0 = r7     // Catch:{ all -> 0x0034 }
                r0.L$1 = r6     // Catch:{ all -> 0x0034 }
                r0.label = r2     // Catch:{ all -> 0x0034 }
                java.lang.Object r5 = r5.invoke(r0)     // Catch:{ all -> 0x0034 }
                if (r5 != r8) goto L_0x006a
                return r8
            L_0x0083:
                T r1 = r7.element
                if (r1 != 0) goto L_0x008a
                r7.element = r5
                goto L_0x006a
            L_0x008a:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                T r1 = r7.element
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                kotlin.ExceptionsKt.addSuppressed(r1, r5)
                goto L_0x006a
            L_0x0095:
                T r5 = r7.element
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto L_0x009e
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L_0x009e:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.c(java.util.List, androidx.datastore.core.InitializerApi, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public Companion() {
        }
    }
}
