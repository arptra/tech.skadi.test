package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0004B5\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR/\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/paging/WrapperPositionalDataSource;", "", "A", "B", "Landroidx/paging/PositionalDataSource;", "source", "Landroidx/arch/core/util/Function;", "", "listFunction", "<init>", "(Landroidx/paging/PositionalDataSource;Landroidx/arch/core/util/Function;)V", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "", "a", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "h", "d", "()V", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "params", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "callback", "l", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Landroidx/paging/PositionalDataSource$LoadInitialCallback;)V", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "o", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Landroidx/paging/PositionalDataSource$LoadRangeCallback;)V", "g", "Landroidx/paging/PositionalDataSource;", "Landroidx/arch/core/util/Function;", "q", "()Landroidx/arch/core/util/Function;", "", "e", "()Z", "isInvalid", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    public final PositionalDataSource g;
    public final Function h;

    public WrapperPositionalDataSource(PositionalDataSource positionalDataSource, Function function) {
        Intrinsics.checkNotNullParameter(positionalDataSource, "source");
        Intrinsics.checkNotNullParameter(function, "listFunction");
        this.g = positionalDataSource;
        this.h = function;
    }

    public void a(DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.g.a(invalidatedCallback);
    }

    public void d() {
        this.g.d();
    }

    public boolean e() {
        return this.g.e();
    }

    public void h(DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.g.h(invalidatedCallback);
    }

    public void l(PositionalDataSource.LoadInitialParams loadInitialParams, PositionalDataSource.LoadInitialCallback loadInitialCallback) {
        Intrinsics.checkNotNullParameter(loadInitialParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadInitialCallback, "callback");
        this.g.l(loadInitialParams, new WrapperPositionalDataSource$loadInitial$1(loadInitialCallback, this));
    }

    public void o(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback loadRangeCallback) {
        Intrinsics.checkNotNullParameter(loadRangeParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadRangeCallback, "callback");
        this.g.o(loadRangeParams, new WrapperPositionalDataSource$loadRange$1(loadRangeCallback, this));
    }

    public final Function q() {
        return this.h;
    }
}
