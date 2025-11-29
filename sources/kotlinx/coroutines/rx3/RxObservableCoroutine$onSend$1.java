package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final /* synthetic */ class RxObservableCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<RxObservableCoroutine<?>, SelectInstance<?>, Object, Unit> {
    public static final RxObservableCoroutine$onSend$1 INSTANCE = new RxObservableCoroutine$onSend$1();

    public RxObservableCoroutine$onSend$1() {
        super(3, RxObservableCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RxObservableCoroutine<?>) (RxObservableCoroutine) obj, (SelectInstance<?>) (SelectInstance) obj2, obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RxObservableCoroutine<?> rxObservableCoroutine, @NotNull SelectInstance<?> selectInstance, @Nullable Object obj) {
        rxObservableCoroutine.A1(selectInstance, obj);
    }
}
