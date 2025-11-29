package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0002H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/paging/WrapperDataSource;", "", "Key", "ValueFrom", "ValueTo", "Landroidx/paging/DataSource;", "source", "Landroidx/arch/core/util/Function;", "", "listFunction", "<init>", "(Landroidx/paging/DataSource;Landroidx/arch/core/util/Function;)V", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "", "a", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "h", "d", "()V", "item", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "dest", "j", "(Ljava/util/List;Ljava/util/List;)V", "Landroidx/paging/DataSource$Params;", "params", "Landroidx/paging/DataSource$BaseResult;", "f", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/DataSource;", "g", "Landroidx/arch/core/util/Function;", "Ljava/util/IdentityHashMap;", "Ljava/util/IdentityHashMap;", "keyMap", "", "e", "()Z", "isInvalid", "paging-common"}, k = 1, mv = {1, 8, 0})
public class WrapperDataSource<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {
    public final DataSource f;
    public final Function g;
    public final IdentityHashMap h;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            try {
                iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapperDataSource(DataSource dataSource, Function function) {
        super(dataSource.c());
        Intrinsics.checkNotNullParameter(dataSource, "source");
        Intrinsics.checkNotNullParameter(function, "listFunction");
        this.f = dataSource;
        this.g = function;
        this.h = WhenMappings.$EnumSwitchMapping$0[dataSource.c().ordinal()] == 1 ? new IdentityHashMap() : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object i(androidx.paging.WrapperDataSource r4, androidx.paging.DataSource.Params r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof androidx.paging.WrapperDataSource$load$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.WrapperDataSource$load$1 r0 = (androidx.paging.WrapperDataSource$load$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.WrapperDataSource$load$1 r0 = new androidx.paging.WrapperDataSource$load$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            androidx.paging.WrapperDataSource r4 = (androidx.paging.WrapperDataSource) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.paging.DataSource r6 = r4.f
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.f(r5, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            androidx.paging.DataSource$BaseResult r6 = (androidx.paging.DataSource.BaseResult) r6
            androidx.paging.DataSource$BaseResult$Companion r5 = androidx.paging.DataSource.BaseResult.f
            androidx.arch.core.util.Function r0 = r4.g
            androidx.paging.DataSource$BaseResult r5 = r5.a(r6, r0)
            java.util.List r6 = r6.f1529a
            java.util.List r0 = r5.f1529a
            r4.j(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.WrapperDataSource.i(androidx.paging.WrapperDataSource, androidx.paging.DataSource$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void a(DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.f.a(invalidatedCallback);
    }

    public Object b(Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(obj, "item");
        IdentityHashMap identityHashMap = this.h;
        if (identityHashMap != null) {
            synchronized (identityHashMap) {
                obj2 = this.h.get(obj);
                Intrinsics.checkNotNull(obj2);
            }
            return obj2;
        }
        throw new IllegalStateException("Cannot get key by item in non-item keyed DataSource");
    }

    public void d() {
        this.f.d();
    }

    public boolean e() {
        return this.f.e();
    }

    public Object f(DataSource.Params params, Continuation continuation) {
        return i(this, params, continuation);
    }

    public void h(DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.f.h(invalidatedCallback);
    }

    public final void j(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "source");
        Intrinsics.checkNotNullParameter(list2, "dest");
        IdentityHashMap identityHashMap = this.h;
        if (identityHashMap != null) {
            synchronized (identityHashMap) {
                try {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        IdentityHashMap identityHashMap2 = this.h;
                        Object obj = list2.get(i);
                        DataSource dataSource = this.f;
                        Intrinsics.checkNotNull(dataSource, "null cannot be cast to non-null type androidx.paging.ItemKeyedDataSource<Key of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1, ValueFrom of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1>");
                        identityHashMap2.put(obj, ((ItemKeyedDataSource) dataSource).k(list.get(i)));
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
