package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JF\u0010\t\u001a\u00028\u000021\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "transform", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore$readAndInit$api$1 implements InitializerApi<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Mutex f1025a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ SingleProcessDataStore d;

    public SingleProcessDataStore$readAndInit$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, SingleProcessDataStore singleProcessDataStore) {
        this.f1025a = mutex;
        this.b = booleanRef;
        this.c = objectRef;
        this.d = singleProcessDataStore;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098 A[Catch:{ all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d6 A[SYNTHETIC, Splitter:B:48:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.jvm.functions.Function2 r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1$updateData$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x005a
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r9 = r0.L$2
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x003b }
            goto L_0x00c9
        L_0x003b:
            r9 = move-exception
            goto L_0x00de
        L_0x003e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0046:
            java.lang.Object r9 = r0.L$2
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0056 }
            goto L_0x00b0
        L_0x0056:
            r9 = move-exception
            r0 = r2
            goto L_0x00de
        L_0x005a:
            java.lang.Object r9 = r0.L$4
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r5
            r8 = r7
            r7 = r10
            r10 = r8
            goto L_0x0094
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r11 = r9.f1025a
            kotlin.jvm.internal.Ref$BooleanRef r2 = r9.b
            kotlin.jvm.internal.Ref$ObjectRef r7 = r9.c
            androidx.datastore.core.SingleProcessDataStore r9 = r9.d
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r7
            r0.L$4 = r9
            r0.label = r5
            java.lang.Object r5 = r11.c(r6, r0)
            if (r5 != r1) goto L_0x0094
            return r1
        L_0x0094:
            boolean r2 = r2.element     // Catch:{ all -> 0x00d3 }
            if (r2 != 0) goto L_0x00d6
            T r2 = r7.element     // Catch:{ all -> 0x00d3 }
            r0.L$0 = r11     // Catch:{ all -> 0x00d3 }
            r0.L$1 = r7     // Catch:{ all -> 0x00d3 }
            r0.L$2 = r9     // Catch:{ all -> 0x00d3 }
            r0.L$3 = r6     // Catch:{ all -> 0x00d3 }
            r0.L$4 = r6     // Catch:{ all -> 0x00d3 }
            r0.label = r4     // Catch:{ all -> 0x00d3 }
            java.lang.Object r10 = r10.invoke(r2, r0)     // Catch:{ all -> 0x00d3 }
            if (r10 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            r2 = r11
            r11 = r10
            r10 = r7
        L_0x00b0:
            T r4 = r10.element     // Catch:{ all -> 0x0056 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r4)     // Catch:{ all -> 0x0056 }
            if (r4 != 0) goto L_0x00cc
            r0.L$0 = r2     // Catch:{ all -> 0x0056 }
            r0.L$1 = r10     // Catch:{ all -> 0x0056 }
            r0.L$2 = r11     // Catch:{ all -> 0x0056 }
            r0.label = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r9 = r9.z(r11, r0)     // Catch:{ all -> 0x0056 }
            if (r9 != r1) goto L_0x00c7
            return r1
        L_0x00c7:
            r9 = r11
            r0 = r2
        L_0x00c9:
            r10.element = r9     // Catch:{ all -> 0x003b }
            goto L_0x00cd
        L_0x00cc:
            r0 = r2
        L_0x00cd:
            T r9 = r10.element     // Catch:{ all -> 0x003b }
            r0.d(r6)
            return r9
        L_0x00d3:
            r9 = move-exception
            r0 = r11
            goto L_0x00de
        L_0x00d6:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d3 }
            java.lang.String r10 = "InitializerApi.updateData should not be called after initialization is complete."
            r9.<init>(r10)     // Catch:{ all -> 0x00d3 }
            throw r9     // Catch:{ all -> 0x00d3 }
        L_0x00de:
            r0.d(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
