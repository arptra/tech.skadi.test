package androidx.paging;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0003\u0012\u0013\u0014B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/paging/SingleRunner;", "", "", "cancelPreviousInEqualPriority", "<init>", "(Z)V", "", "priority", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "b", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/SingleRunner$Holder;", "a", "Landroidx/paging/SingleRunner$Holder;", "holder", "CancelIsolatedRunnerException", "Companion", "Holder", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class SingleRunner {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Holder f1635a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Landroidx/paging/SingleRunner;", "(Landroidx/paging/SingleRunner;)V", "getRunner", "()Landroidx/paging/SingleRunner;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CancelIsolatedRunnerException extends CancellationException {
        @NotNull
        private final SingleRunner runner;

        public CancelIsolatedRunnerException(@NotNull SingleRunner singleRunner) {
            Intrinsics.checkNotNullParameter(singleRunner, "runner");
            this.runner = singleRunner;
        }

        @NotNull
        public final SingleRunner getRunner() {
            return this.runner;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/SingleRunner$Companion;", "", "()V", "DEFAULT_PRIORITY", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nSingleRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleRunner.kt\nandroidx/paging/SingleRunner$Holder\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,123:1\n107#2,10:124\n107#2,10:134\n*S KotlinDebug\n*F\n+ 1 SingleRunner.kt\nandroidx/paging/SingleRunner$Holder\n*L\n92#1:124,10\n111#1:134,10\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/paging/SingleRunner$Holder;", "", "Landroidx/paging/SingleRunner;", "singleRunner", "", "cancelPreviousInEqualPriority", "<init>", "(Landroidx/paging/SingleRunner;Z)V", "", "priority", "Lkotlinx/coroutines/Job;", "job", "b", "(ILkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/SingleRunner;", "Z", "Lkotlinx/coroutines/sync/Mutex;", "c", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "d", "Lkotlinx/coroutines/Job;", "previous", "e", "I", "previousPriority", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Holder {

        /* renamed from: a  reason: collision with root package name */
        public final SingleRunner f1636a;
        public final boolean b;
        public final Mutex c = MutexKt.b(false, 1, (Object) null);
        public Job d;
        public int e;

        public Holder(SingleRunner singleRunner, boolean z) {
            Intrinsics.checkNotNullParameter(singleRunner, "singleRunner");
            this.f1636a = singleRunner;
            this.b = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[Catch:{ all -> 0x005b }] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(kotlinx.coroutines.Job r6, kotlin.coroutines.Continuation r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.SingleRunner$Holder$onFinish$1
                if (r0 == 0) goto L_0x0013
                r0 = r7
                androidx.paging.SingleRunner$Holder$onFinish$1 r0 = (androidx.paging.SingleRunner$Holder$onFinish$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.SingleRunner$Holder$onFinish$1 r0 = new androidx.paging.SingleRunner$Holder$onFinish$1
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0040
                if (r2 != r3) goto L_0x0038
                java.lang.Object r5 = r0.L$2
                kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
                java.lang.Object r6 = r0.L$1
                kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
                java.lang.Object r0 = r0.L$0
                androidx.paging.SingleRunner$Holder r0 = (androidx.paging.SingleRunner.Holder) r0
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r5
                r5 = r0
                goto L_0x0054
            L_0x0038:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0040:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.sync.Mutex r7 = r5.c
                r0.L$0 = r5
                r0.L$1 = r6
                r0.L$2 = r7
                r0.label = r3
                java.lang.Object r0 = r7.c(r4, r0)
                if (r0 != r1) goto L_0x0054
                return r1
            L_0x0054:
                kotlinx.coroutines.Job r0 = r5.d     // Catch:{ all -> 0x005b }
                if (r6 != r0) goto L_0x005d
                r5.d = r4     // Catch:{ all -> 0x005b }
                goto L_0x005d
            L_0x005b:
                r5 = move-exception
                goto L_0x0065
            L_0x005d:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
                r7.d(r4)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L_0x0065:
                r7.d(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.Holder.a(kotlinx.coroutines.Job, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[Catch:{ all -> 0x0086 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0089 A[Catch:{ all -> 0x0086 }] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object b(int r9, kotlinx.coroutines.Job r10, kotlin.coroutines.Continuation r11) {
            /*
                r8 = this;
                boolean r0 = r11 instanceof androidx.paging.SingleRunner$Holder$tryEnqueue$1
                if (r0 == 0) goto L_0x0013
                r0 = r11
                androidx.paging.SingleRunner$Holder$tryEnqueue$1 r0 = (androidx.paging.SingleRunner$Holder$tryEnqueue$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.SingleRunner$Holder$tryEnqueue$1 r0 = new androidx.paging.SingleRunner$Holder$tryEnqueue$1
                r0.<init>(r8, r11)
            L_0x0018:
                java.lang.Object r11 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x005b
                if (r2 == r4) goto L_0x0047
                if (r2 != r3) goto L_0x003f
                int r8 = r0.I$0
                java.lang.Object r9 = r0.L$2
                kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
                java.lang.Object r10 = r0.L$1
                kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
                java.lang.Object r0 = r0.L$0
                androidx.paging.SingleRunner$Holder r0 = (androidx.paging.SingleRunner.Holder) r0
                kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x003c }
                goto L_0x00ae
            L_0x003c:
                r8 = move-exception
                goto L_0x00be
            L_0x003f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x0047:
                int r9 = r0.I$0
                java.lang.Object r8 = r0.L$2
                kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
                java.lang.Object r10 = r0.L$1
                kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
                java.lang.Object r2 = r0.L$0
                androidx.paging.SingleRunner$Holder r2 = (androidx.paging.SingleRunner.Holder) r2
                kotlin.ResultKt.throwOnFailure(r11)
                r11 = r8
                r8 = r2
                goto L_0x0071
            L_0x005b:
                kotlin.ResultKt.throwOnFailure(r11)
                kotlinx.coroutines.sync.Mutex r11 = r8.c
                r0.L$0 = r8
                r0.L$1 = r10
                r0.L$2 = r11
                r0.I$0 = r9
                r0.label = r4
                java.lang.Object r2 = r11.c(r5, r0)
                if (r2 != r1) goto L_0x0071
                return r1
            L_0x0071:
                kotlinx.coroutines.Job r2 = r8.d     // Catch:{ all -> 0x0086 }
                if (r2 == 0) goto L_0x008c
                boolean r6 = r2.isActive()     // Catch:{ all -> 0x0086 }
                if (r6 == 0) goto L_0x008c
                int r6 = r8.e     // Catch:{ all -> 0x0086 }
                if (r6 < r9) goto L_0x008c
                if (r6 != r9) goto L_0x0089
                boolean r6 = r8.b     // Catch:{ all -> 0x0086 }
                if (r6 == 0) goto L_0x0089
                goto L_0x008c
            L_0x0086:
                r8 = move-exception
                r9 = r11
                goto L_0x00be
            L_0x0089:
                r4 = 0
            L_0x008a:
                r9 = r11
                goto L_0x00b6
            L_0x008c:
                if (r2 == 0) goto L_0x0098
                androidx.paging.SingleRunner$CancelIsolatedRunnerException r6 = new androidx.paging.SingleRunner$CancelIsolatedRunnerException     // Catch:{ all -> 0x0086 }
                androidx.paging.SingleRunner r7 = r8.f1636a     // Catch:{ all -> 0x0086 }
                r6.<init>(r7)     // Catch:{ all -> 0x0086 }
                r2.a(r6)     // Catch:{ all -> 0x0086 }
            L_0x0098:
                if (r2 == 0) goto L_0x00b1
                r0.L$0 = r8     // Catch:{ all -> 0x0086 }
                r0.L$1 = r10     // Catch:{ all -> 0x0086 }
                r0.L$2 = r11     // Catch:{ all -> 0x0086 }
                r0.I$0 = r9     // Catch:{ all -> 0x0086 }
                r0.label = r3     // Catch:{ all -> 0x0086 }
                java.lang.Object r0 = r2.i0(r0)     // Catch:{ all -> 0x0086 }
                if (r0 != r1) goto L_0x00ab
                return r1
            L_0x00ab:
                r0 = r8
                r8 = r9
                r9 = r11
            L_0x00ae:
                r11 = r9
                r9 = r8
                r8 = r0
            L_0x00b1:
                r8.d = r10     // Catch:{ all -> 0x0086 }
                r8.e = r9     // Catch:{ all -> 0x0086 }
                goto L_0x008a
            L_0x00b6:
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch:{ all -> 0x003c }
                r9.d(r5)
                return r8
            L_0x00be:
                r9.d(r5)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.Holder.b(int, kotlinx.coroutines.Job, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public SingleRunner(boolean z) {
        this.f1635a = new Holder(this, z);
    }

    public static /* synthetic */ Object c(SingleRunner singleRunner, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return singleRunner.b(i, function1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(int r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.paging.SingleRunner$runInIsolation$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.paging.SingleRunner$runInIsolation$1 r0 = (androidx.paging.SingleRunner$runInIsolation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.SingleRunner$runInIsolation$1 r0 = new androidx.paging.SingleRunner$runInIsolation$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            androidx.paging.SingleRunner r4 = (androidx.paging.SingleRunner) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ CancelIsolatedRunnerException -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.paging.SingleRunner$runInIsolation$2 r7 = new androidx.paging.SingleRunner$runInIsolation$2     // Catch:{ CancelIsolatedRunnerException -> 0x002d }
            r2 = 0
            r7.<init>(r4, r5, r6, r2)     // Catch:{ CancelIsolatedRunnerException -> 0x002d }
            r0.L$0 = r4     // Catch:{ CancelIsolatedRunnerException -> 0x002d }
            r0.label = r3     // Catch:{ CancelIsolatedRunnerException -> 0x002d }
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.f(r7, r0)     // Catch:{ CancelIsolatedRunnerException -> 0x002d }
            if (r4 != r1) goto L_0x0051
            return r1
        L_0x004b:
            androidx.paging.SingleRunner r6 = r5.getRunner()
            if (r6 != r4) goto L_0x0054
        L_0x0051:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0054:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.b(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
