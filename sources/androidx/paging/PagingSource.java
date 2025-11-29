package androidx.paging;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nPagingSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagingSource.kt\nandroidx/paging/PagingSource\n+ 2 Logger.kt\nandroidx/paging/LoggerKt\n*L\n1#1,437:1\n41#2,10:438\n*S KotlinDebug\n*F\n+ 1 PagingSource.kt\nandroidx/paging/PagingSource\n*L\n371#1:438,10\n*E\n"})
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\f\u0010\u000bJ-\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¦@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010 \u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Landroidx/paging/PagingSource;", "", "Key", "Value", "<init>", "()V", "", "e", "Lkotlin/Function0;", "onInvalidatedCallback", "g", "(Lkotlin/jvm/functions/Function0;)V", "h", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "f", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingState;", "state", "d", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "Landroidx/paging/InvalidateCallbackTracker;", "a", "Landroidx/paging/InvalidateCallbackTracker;", "invalidateCallbackTracker", "", "b", "()Z", "jumpingSupported", "c", "keyReuseSupported", "invalid", "LoadParams", "LoadResult", "paging-common"}, k = 1, mv = {1, 8, 0})
public abstract class PagingSource<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final InvalidateCallbackTracker f1618a = new InvalidateCallbackTracker(PagingSource$invalidateCallbackTracker$1.INSTANCE, (Function0) null, 2, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00018\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0010\u0001\u0003\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Landroidx/paging/PagingSource$LoadParams;", "", "Key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(IZ)V", "a", "I", "b", "()I", "Z", "c", "()Z", "()Ljava/lang/Object;", "key", "Append", "Companion", "Prepend", "Refresh", "Landroidx/paging/PagingSource$LoadParams$Append;", "Landroidx/paging/PagingSource$LoadParams$Prepend;", "Landroidx/paging/PagingSource$LoadParams$Refresh;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class LoadParams<Key> {
        public static final Companion c = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final int f1619a;
        public final boolean b;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00028\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Append;", "", "Key", "Landroidx/paging/PagingSource$LoadParams;", "key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Append<Key> extends LoadParams<Key> {
            public final Object d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Append(Object obj, int i, boolean z) {
                super(i, z, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(obj, IntentKey.ACTIVITY.ACTION_KEY);
                this.d = obj;
            }

            public Object a() {
                return this.d;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\f\"\b\b\u0003\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00018\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Companion;", "", "<init>", "()V", "Key", "Landroidx/paging/LoadType;", "loadType", "key", "", "loadSize", "", "placeholdersEnabled", "Landroidx/paging/PagingSource$LoadParams;", "a", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZ)Landroidx/paging/PagingSource$LoadParams;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                static {
                    /*
                        androidx.paging.LoadType[] r0 = androidx.paging.LoadType.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.paging.LoadType r1 = androidx.paging.LoadType.PREPEND     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingSource.LoadParams.Companion.WhenMappings.<clinit>():void");
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LoadParams a(LoadType loadType, Object obj, int i, boolean z) {
                Intrinsics.checkNotNullParameter(loadType, "loadType");
                int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
                if (i2 == 1) {
                    return new Refresh(obj, i, z);
                }
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else if (obj != null) {
                        return new Append(obj, i, z);
                    } else {
                        throw new IllegalArgumentException("key cannot be null for append".toString());
                    }
                } else if (obj != null) {
                    return new Prepend(obj, i, z);
                } else {
                    throw new IllegalArgumentException("key cannot be null for prepend".toString());
                }
            }

            public Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00028\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Prepend;", "", "Key", "Landroidx/paging/PagingSource$LoadParams;", "key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Prepend<Key> extends LoadParams<Key> {
            public final Object d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Prepend(Object obj, int i, boolean z) {
                super(i, z, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(obj, IntentKey.ACTIVITY.ACTION_KEY);
                this.d = obj;
            }

            public Object a() {
                return this.d;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00018\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Refresh;", "", "Key", "Landroidx/paging/PagingSource$LoadParams;", "key", "", "loadSize", "", "placeholdersEnabled", "<init>", "(Ljava/lang/Object;IZ)V", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Refresh<Key> extends LoadParams<Key> {
            public final Object d;

            public Refresh(Object obj, int i, boolean z) {
                super(i, z, (DefaultConstructorMarker) null);
                this.d = obj;
            }

            public Object a() {
                return this.d;
            }
        }

        public /* synthetic */ LoadParams(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z);
        }

        public abstract Object a();

        public final int b() {
            return this.f1619a;
        }

        public final boolean c() {
            return this.b;
        }

        public LoadParams(int i, boolean z) {
            this.f1619a = i;
            this.b = z;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0004\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/PagingSource$LoadResult;", "Key", "", "Value", "()V", "Error", "Invalid", "Page", "Landroidx/paging/PagingSource$LoadResult$Error;", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "Landroidx/paging/PagingSource$LoadResult$Page;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadResult<Key, Value> {

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Error;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Error<Key, Value> extends LoadResult<Key, Value> {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f1620a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(Throwable th) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th, "throwable");
                this.f1620a = th;
            }

            public final Throwable a() {
                return this.f1620a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual((Object) this.f1620a, (Object) ((Error) obj).f1620a);
            }

            public int hashCode() {
                return this.f1620a.hashCode();
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Error(\n                    |   throwable: " + this.f1620a + "\n                    |) ", (String) null, 1, (Object) null);
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Invalid;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "()V", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Invalid<Key, Value> extends LoadResult<Key, Value> {
            public Invalid() {
                super((DefaultConstructorMarker) null);
            }

            public String toString() {
                return "LoadResult.Invalid";
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000  *\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00042\b\u0012\u0004\u0012\u00028\u00050\u0005:\u0001&B=\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004\u0012\b\b\u0003\u0010\u000b\u001a\u00020\n\u0012\b\b\u0003\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00050\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00050\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00018\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00018\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010\u0016R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b#\u0010%\u001a\u0004\b\"\u0010\u0016¨\u0006'"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "", "", "data", "prevKey", "nextKey", "", "itemsBefore", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "", "iterator", "()Ljava/util/Iterator;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "c", "e", "d", "I", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Page<Key, Value> extends LoadResult<Key, Value> implements Iterable<Value>, KMappedMarker {
            public static final Companion f = new Companion((DefaultConstructorMarker) null);
            public static final Page g = new Page(CollectionsKt.emptyList(), (Object) null, (Object) null, 0, 0);

            /* renamed from: a  reason: collision with root package name */
            public final List f1621a;
            public final Object b;
            public final Object c;
            public final int d;
            public final int e;

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0006\"\b\b\u0006\u0010\u0004*\u00020\u0001\"\b\b\u0007\u0010\u0005*\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\bR,\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00068\u0000X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page$Companion;", "", "<init>", "()V", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult$Page;", "a", "()Landroidx/paging/PagingSource$LoadResult$Page;", "", "EMPTY", "Landroidx/paging/PagingSource$LoadResult$Page;", "b", "getEMPTY$paging_common$annotations", "", "COUNT_UNDEFINED", "I", "paging-common"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final Page a() {
                    Page b = b();
                    Intrinsics.checkNotNull(b, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Page<Key of androidx.paging.PagingSource.LoadResult.Page.Companion.empty, Value of androidx.paging.PagingSource.LoadResult.Page.Companion.empty>");
                    return b;
                }

                public final Page b() {
                    return Page.g;
                }

                public Companion() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Page(List list, Object obj, Object obj2, int i, int i2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "data");
                this.f1621a = list;
                this.b = obj;
                this.c = obj2;
                this.d = i;
                this.e = i2;
                if (i != Integer.MIN_VALUE && i < 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
                } else if (i2 != Integer.MIN_VALUE && i2 < 0) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
                }
            }

            public final List b() {
                return this.f1621a;
            }

            public final int c() {
                return this.e;
            }

            public final int d() {
                return this.d;
            }

            public final Object e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Page)) {
                    return false;
                }
                Page page = (Page) obj;
                return Intrinsics.areEqual((Object) this.f1621a, (Object) page.f1621a) && Intrinsics.areEqual(this.b, page.b) && Intrinsics.areEqual(this.c, page.c) && this.d == page.d && this.e == page.e;
            }

            public final Object f() {
                return this.b;
            }

            public int hashCode() {
                int hashCode = this.f1621a.hashCode() * 31;
                Object obj = this.b;
                int i = 0;
                int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
                Object obj2 = this.c;
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                return ((((hashCode2 + i) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
            }

            public Iterator iterator() {
                return this.f1621a.listIterator();
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Page(\n                    |   data size: " + this.f1621a.size() + "\n                    |   first Item: " + CollectionsKt.firstOrNull(this.f1621a) + "\n                    |   last Item: " + CollectionsKt.lastOrNull(this.f1621a) + "\n                    |   nextKey: " + this.c + "\n                    |   prevKey: " + this.b + "\n                    |   itemsBefore: " + this.d + "\n                    |   itemsAfter: " + this.e + "\n                    |) ", (String) null, 1, (Object) null);
            }
        }

        public /* synthetic */ LoadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public LoadResult() {
        }
    }

    public final boolean a() {
        return this.f1618a.a();
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public abstract Object d(PagingState pagingState);

    public final void e() {
        Logger a2;
        if (this.f1618a.b() && (a2 = LoggerKt.a()) != null && a2.b(3)) {
            a2.a(3, "Invalidated PagingSource " + this, (Throwable) null);
        }
    }

    public abstract Object f(LoadParams loadParams, Continuation continuation);

    public final void g(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onInvalidatedCallback");
        this.f1618a.c(function0);
    }

    public final void h(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onInvalidatedCallback");
        this.f1618a.d(function0);
    }
}
