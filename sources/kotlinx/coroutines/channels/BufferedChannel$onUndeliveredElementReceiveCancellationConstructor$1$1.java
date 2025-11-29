package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "", "", "E", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<anonymous parameter 1>", "", "element", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 extends Lambda implements Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>> {
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(BufferedChannel<E> bufferedChannel) {
        super(3);
        this.this$0 = bufferedChannel;
    }

    @NotNull
    public final Function1<Throwable, Unit> invoke(@NotNull final SelectInstance<?> selectInstance, @Nullable Object obj, @Nullable final Object obj2) {
        final BufferedChannel<E> bufferedChannel = this.this$0;
        return new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th) {
                if (obj2 != BufferedChannelKt.z()) {
                    OnUndeliveredElementKt.b(bufferedChannel.b, obj2, selectInstance.getContext());
                }
            }
        };
    }
}
