package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\t\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00010\u00002#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\"c\u0010\u0017\u001aQ\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0002`\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016\"\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a\"\u0014\u0010\u001f\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a\"\u0014\u0010!\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001a\"\u001a\u0010%\u001a\u00020\u00188\u0000X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010$*Â\u0001\b\u0007\u0010*\"[\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030&¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00020\u00102[\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030&¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00020\u0010B\u0002\b)*¦\u0001\b\u0007\u0010+\"M\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102M\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010B\u0002\b)*¦\u0001\b\u0007\u0010,\"M\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030&¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u00102M\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030&¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u0010B\u0002\b)¨\u0006-"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "", "j", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)Z", "", "trySelectInternalResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "a", "(I)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "Lkotlin/Function3;", "", "clauseObject", "param", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "Lkotlin/jvm/functions/Function3;", "DUMMY_PROCESS_RESULT_FUNCTION", "Lkotlinx/coroutines/internal/Symbol;", "b", "Lkotlinx/coroutines/internal/Symbol;", "STATE_REG", "c", "STATE_COMPLETED", "d", "STATE_CANCELLED", "e", "NO_RESULT", "f", "i", "()Lkotlinx/coroutines/internal/Symbol;", "PARAM_CLAUSE_0", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "internalResult", "Lkotlinx/coroutines/InternalCoroutinesApi;", "OnCancellationConstructor", "ProcessResultFunction", "RegistrationFunction", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
public final class SelectKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Function3 f3974a = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.INSTANCE;
    public static final Symbol b = new Symbol("STATE_REG");
    public static final Symbol c = new Symbol("STATE_COMPLETED");
    public static final Symbol d = new Symbol("STATE_CANCELLED");
    public static final Symbol e = new Symbol("NO_RESULT");
    public static final Symbol f = new Symbol("PARAM_CLAUSE_0");

    public static final TrySelectDetailedResult a(int i) {
        if (i == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i).toString());
    }

    public static final Symbol i() {
        return f;
    }

    public static final boolean j(CancellableContinuation cancellableContinuation, Function1 function1) {
        Object H = cancellableContinuation.H(Unit.INSTANCE, (Object) null, function1);
        if (H == null) {
            return false;
        }
        cancellableContinuation.B(H);
        return true;
    }
}
