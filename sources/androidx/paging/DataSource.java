package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b&\u0018\u0000 +*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0006-./012B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JE\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\b*\u00020\u00012\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H @ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H ¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\"R\u001a\u0010(\u001a\u00020$8\u0010XD¢\u0006\f\n\u0004\b\u001f\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010*\u001a\u00020$8\u0010XD¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b)\u0010'R\u0014\u0010,\u001a\u00020$8WX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Landroidx/paging/DataSource;", "", "Key", "Value", "Landroidx/paging/DataSource$KeyType;", "type", "<init>", "(Landroidx/paging/DataSource$KeyType;)V", "ToValue", "Landroidx/arch/core/util/Function;", "", "function", "g", "(Landroidx/arch/core/util/Function;)Landroidx/paging/DataSource;", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "", "a", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "h", "d", "()V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "f", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "item", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroidx/paging/DataSource$KeyType;", "c", "()Landroidx/paging/DataSource$KeyType;", "Landroidx/paging/InvalidateCallbackTracker;", "Landroidx/paging/InvalidateCallbackTracker;", "invalidateCallbackTracker", "", "Z", "isContiguous$paging_common", "()Z", "isContiguous", "getSupportsPageDropping$paging_common", "supportsPageDropping", "e", "isInvalid", "BaseResult", "Companion", "Factory", "InvalidatedCallback", "KeyType", "Params", "paging-common"}, k = 1, mv = {1, 8, 0})
public abstract class DataSource<Key, Value> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final KeyType f1528a;
    public final InvalidateCallbackTracker b = new InvalidateCallbackTracker(DataSource$invalidateCallbackTracker$1.INSTANCE, new DataSource$invalidateCallbackTracker$2(this));
    public final boolean c = true;
    public final boolean d = true;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00030\u0007\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/DataSource$Companion;", "", "<init>", "()V", "A", "B", "Landroidx/arch/core/util/Function;", "", "function", "source", "a", "(Landroidx/arch/core/util/Function;Ljava/util/List;)Ljava/util/List;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(Function function, List list) {
            Intrinsics.checkNotNullParameter(function, "function");
            Intrinsics.checkNotNullParameter(list, "source");
            List list2 = (List) function.apply(list);
            if (list2.size() == list.size()) {
                Intrinsics.checkNotNullExpressionValue(list2, "dest");
                return list2;
            }
            throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataSource.kt\nandroidx/paging/DataSource$Factory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,525:1\n1549#2:526\n1620#2,3:527\n1549#2:530\n1620#2,3:531\n*S KotlinDebug\n*F\n+ 1 DataSource.kt\nandroidx/paging/DataSource$Factory\n*L\n173#1:526\n173#1:527,3\n194#1:530\n194#1:531,3\n*E\n"})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/DataSource$Factory;", "", "Key", "Value", "Landroidx/paging/DataSource;", "a", "()Landroidx/paging/DataSource;", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static abstract class Factory<Key, Value> {
        public abstract DataSource a();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/paging/DataSource$InvalidatedCallback;", "", "", "a", "()V", "paging-common"}, k = 1, mv = {1, 8, 0})
    public interface InvalidatedCallback {
        void a();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/DataSource$KeyType;", "", "(Ljava/lang/String;I)V", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum KeyType {
        POSITIONAL,
        PAGE_KEYED,
        ITEM_KEYED
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\r\u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u001a"}, d2 = {"Landroidx/paging/DataSource$Params;", "", "K", "Landroidx/paging/LoadType;", "type", "key", "", "initialLoadSize", "", "placeholdersEnabled", "pageSize", "<init>", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V", "a", "Landroidx/paging/LoadType;", "e", "()Landroidx/paging/LoadType;", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "c", "I", "()I", "d", "Z", "()Z", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class Params<K> {

        /* renamed from: a  reason: collision with root package name */
        public final LoadType f1531a;
        public final Object b;
        public final int c;
        public final boolean d;
        public final int e;

        public Params(LoadType loadType, Object obj, int i, boolean z, int i2) {
            Intrinsics.checkNotNullParameter(loadType, "type");
            this.f1531a = loadType;
            this.b = obj;
            this.c = i;
            this.d = z;
            this.e = i2;
            if (loadType != LoadType.REFRESH && obj == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }

        public final int a() {
            return this.c;
        }

        public final Object b() {
            return this.b;
        }

        public final int c() {
            return this.e;
        }

        public final boolean d() {
            return this.d;
        }

        public final LoadType e() {
            return this.f1531a;
        }
    }

    public DataSource(KeyType keyType) {
        Intrinsics.checkNotNullParameter(keyType, "type");
        this.f1528a = keyType;
    }

    public void a(InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.b.c(invalidatedCallback);
    }

    public abstract Object b(Object obj);

    public final KeyType c() {
        return this.f1528a;
    }

    public void d() {
        this.b.b();
    }

    public boolean e() {
        return this.b.a();
    }

    public abstract Object f(Params params, Continuation continuation);

    public DataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperDataSource(this, function);
    }

    public void h(InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.b.d(invalidatedCallback);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001d*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u001eB?\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0016\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c¨\u0006\u001f"}, d2 = {"Landroidx/paging/DataSource$BaseResult;", "", "Value", "", "data", "prevKey", "nextKey", "", "itemsBefore", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "pageSize", "", "e", "(I)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "b", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "c", "I", "()I", "f", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0})
    public static final class BaseResult<Value> {
        public static final Companion f = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final List f1529a;
        public final Object b;
        public final Object c;
        public final int d;
        public final int e;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\"\b\b\u0003\u0010\u0004*\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007JW\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005\"\b\b\u0003\u0010\b*\u00020\u0001\"\b\b\u0004\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\u001e\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\f0\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/DataSource$BaseResult$Companion;", "", "<init>", "()V", "T", "Landroidx/paging/DataSource$BaseResult;", "b", "()Landroidx/paging/DataSource$BaseResult;", "ToValue", "Value", "result", "Landroidx/arch/core/util/Function;", "", "function", "a", "(Landroidx/paging/DataSource$BaseResult;Landroidx/arch/core/util/Function;)Landroidx/paging/DataSource$BaseResult;", "paging-common"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BaseResult a(BaseResult baseResult, Function function) {
                Intrinsics.checkNotNullParameter(baseResult, "result");
                Intrinsics.checkNotNullParameter(function, "function");
                return new BaseResult(DataSource.e.a(function, baseResult.f1529a), baseResult.d(), baseResult.c(), baseResult.b(), baseResult.a());
            }

            public final BaseResult b() {
                return new BaseResult(CollectionsKt.emptyList(), (Object) null, (Object) null, 0, 0);
            }

            public Companion() {
            }
        }

        public BaseResult(List list, Object obj, Object obj2, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "data");
            this.f1529a = list;
            this.b = obj;
            this.c = obj2;
            this.d = i;
            this.e = i2;
            if (i < 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Position must be non-negative");
            } else if (list.isEmpty() && (i > 0 || i2 > 0)) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            } else if (i2 < 0 && i2 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
        }

        public final int a() {
            return this.e;
        }

        public final int b() {
            return this.d;
        }

        public final Object c() {
            return this.c;
        }

        public final Object d() {
            return this.b;
        }

        public final void e(int i) {
            int i2;
            if (this.d == Integer.MIN_VALUE || (i2 = this.e) == Integer.MIN_VALUE) {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            } else if (i2 > 0 && this.f1529a.size() % i != 0) {
                throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + this.f1529a.size() + ", position " + this.d + ", totalCount " + (this.d + this.f1529a.size() + this.e) + ", pageSize " + i);
            } else if (this.d % i != 0) {
                throw new IllegalArgumentException("Initial load must be pageSize aligned.Position = " + this.d + ", pageSize = " + i);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BaseResult)) {
                return false;
            }
            BaseResult baseResult = (BaseResult) obj;
            return Intrinsics.areEqual((Object) this.f1529a, (Object) baseResult.f1529a) && Intrinsics.areEqual(this.b, baseResult.b) && Intrinsics.areEqual(this.c, baseResult.c) && this.d == baseResult.d && this.e == baseResult.e;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BaseResult(List list, Object obj, Object obj2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, obj, obj2, (i3 & 8) != 0 ? Integer.MIN_VALUE : i, (i3 & 16) != 0 ? Integer.MIN_VALUE : i2);
        }
    }
}
