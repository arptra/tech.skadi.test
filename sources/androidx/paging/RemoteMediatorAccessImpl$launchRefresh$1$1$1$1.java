package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import androidx.paging.RemoteMediator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/AccessorState;", "invoke", "(Landroidx/paging/AccessorState;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RemoteMediatorAccessImpl$launchRefresh$1$1$1$1 extends Lambda implements Function1<AccessorState<Key, Value>, Boolean> {
    final /* synthetic */ RemoteMediator.MediatorResult $loadResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(RemoteMediator.MediatorResult mediatorResult) {
        super(1);
        this.$loadResult = mediatorResult;
    }

    @NotNull
    public final Boolean invoke(@NotNull AccessorState<Key, Value> accessorState) {
        Intrinsics.checkNotNullParameter(accessorState, "it");
        LoadType loadType = LoadType.REFRESH;
        accessorState.c(loadType);
        if (((RemoteMediator.MediatorResult.Success) this.$loadResult).a()) {
            AccessorState.BlockState blockState = AccessorState.BlockState.COMPLETED;
            accessorState.j(loadType, blockState);
            accessorState.j(LoadType.PREPEND, blockState);
            accessorState.j(LoadType.APPEND, blockState);
            accessorState.d();
        } else {
            LoadType loadType2 = LoadType.PREPEND;
            AccessorState.BlockState blockState2 = AccessorState.BlockState.UNBLOCKED;
            accessorState.j(loadType2, blockState2);
            accessorState.j(LoadType.APPEND, blockState2);
        }
        accessorState.k(LoadType.PREPEND, (LoadState.Error) null);
        accessorState.k(LoadType.APPEND, (LoadState.Error) null);
        return Boolean.valueOf(accessorState.g() != null);
    }
}
