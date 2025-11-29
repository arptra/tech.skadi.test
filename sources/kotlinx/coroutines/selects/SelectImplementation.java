package kotlinx.coroutines.selects;

import com.honey.account.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001SB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\nJ/\u0010\u001b\u001a\u00028\u00002\u0010\u0010\u001a\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\r2\u0010\u0010\u001d\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b \u0010\nJ5\u0010%\u001a\u00020\r*\u00020!2\u001c\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\"H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&JG\u0010*\u001a\u00020\r\"\u0004\b\u0001\u0010'*\b\u0012\u0004\u0012\u00028\u00010(2\"\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\u000b0)H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\r*\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\r2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J#\u00107\u001a\u00020\r2\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u00106\u001a\u00020\u0013H\u0016¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b9\u0010\u000fJ!\u0010;\u001a\u00020,2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020=2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b>\u0010?J\u001a\u0010B\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0004\bB\u0010CR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010D\u001a\u0004\bE\u0010FR(\u0010I\u001a\u0014\u0012\u000e\u0012\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010JR\u0016\u0010M\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010LR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010JR\u0014\u0010P\u001a\u00020,8BX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0011\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000b0Q8\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "clauseObject", "", "m", "(Ljava/lang/Object;)V", "A", "x", "internalResult", "", "z", "(Ljava/lang/Object;Ljava/lang/Object;)I", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "s", "(Ljava/lang/Object;)Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "o", "clause", "u", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectedClause", "n", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;)V", "p", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "a", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "f", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "", "reregister", "v", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Z)V", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "d", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "index", "b", "(Lkotlinx/coroutines/internal/Segment;I)V", "c", "result", "e", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "y", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "cause", "g", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "", "Ljava/util/List;", "clauses", "Ljava/lang/Object;", "disposableHandleOrSegment", "I", "indexInSegment", "t", "()Z", "isSelected", "Lkotlinx/atomicfu/AtomicRef;", "state", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public class SelectImplementation<R> extends CancelHandler implements SelectBuilder<R>, SelectInstanceInternal<R> {
    public static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f3972a;
    public List b = new ArrayList(2);
    public Object c;
    public int d = -1;
    public Object e = SelectKt.e;
    @Volatile
    @Nullable
    private volatile Object state = SelectKt.b;

    @SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B¸\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u000b\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003j\u0002`\n\u0012U\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\r\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0014\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011\u0018\u00010\u0003j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00182\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00028\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J1\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b#\u0010%Rc\u0010\u000b\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003j\u0002`\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010&Rc\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010%R\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010%Ru\u0010\u0014\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011\u0018\u00010\u0003j\u0004\u0018\u0001`\u00138\u0006X\u0004¢\u0006\u0006\n\u0004\b'\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b(\u0010%R\u0016\u0010-\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b+\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "block", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "", "e", "(Lkotlinx/coroutines/selects/SelectImplementation;)Z", "result", "d", "(Ljava/lang/Object;)Ljava/lang/Object;", "argument", "c", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "()V", "a", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "f", "g", "disposableHandleOrSegment", "", "h", "I", "indexInSegment", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class ClauseData {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3973a;
        public final Function3 b;
        public final Function3 c;
        public final Object d;
        public final Object e;
        public final Function3 f;
        public Object g;
        public int h = -1;

        public ClauseData(Object obj, Function3 function3, Function3 function32, Object obj2, Object obj3, Function3 function33) {
            this.f3973a = obj;
            this.b = function3;
            this.c = function32;
            this.d = obj2;
            this.e = obj3;
            this.f = function33;
        }

        public final Function1 a(SelectInstance selectInstance, Object obj) {
            Function3 function3 = this.f;
            if (function3 != null) {
                return (Function1) function3.invoke(selectInstance, this.d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.g;
            SelectImplementation selectImplementation = SelectImplementation.this;
            DisposableHandle disposableHandle = null;
            if (obj instanceof Segment) {
                ((Segment) obj).o(this.h, (Throwable) null, selectImplementation.getContext());
                return;
            }
            if (obj instanceof DisposableHandle) {
                disposableHandle = (DisposableHandle) obj;
            }
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Object c(Object obj, Continuation continuation) {
            Object obj2 = this.e;
            if (this.d == SelectKt.i()) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(continuation);
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, continuation);
        }

        public final Object d(Object obj) {
            return this.c.invoke(this.f3973a, this.d, obj);
        }

        public final boolean e(SelectImplementation selectImplementation) {
            this.b.invoke(this.f3973a, selectImplementation, this.d);
            return selectImplementation.e == SelectKt.e;
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.f3972a = coroutineContext;
    }

    public static /* synthetic */ Object q(SelectImplementation selectImplementation, Continuation continuation) {
        return selectImplementation.t() ? selectImplementation.o(continuation) : selectImplementation.r(continuation);
    }

    private final boolean t() {
        return f.get(this) instanceof ClauseData;
    }

    public static /* synthetic */ void w(SelectImplementation selectImplementation, ClauseData clauseData, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            selectImplementation.v(clauseData, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    public final Object A(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        AtomicReferenceFieldUpdater j = f;
        while (true) {
            Object obj = j.get(this);
            if (obj == SelectKt.b) {
                if (a.a(f, this, obj, cancellableContinuationImpl)) {
                    cancellableContinuationImpl.E(this);
                    break;
                }
            } else if (obj instanceof List) {
                if (a.a(f, this, obj, SelectKt.b)) {
                    for (Object l : (Iterable) obj) {
                        x(l);
                    }
                }
            } else if (obj instanceof ClauseData) {
                cancellableContinuationImpl.m(Unit.INSTANCE, ((ClauseData) obj).a(this, this.e));
            } else {
                throw new IllegalStateException(("unexpected state: " + obj).toString());
            }
        }
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    public void a(SelectClause0 selectClause0, Function1 function1) {
        w(this, new ClauseData(selectClause0.d(), selectClause0.c(), selectClause0.b(), SelectKt.i(), function1, selectClause0.a()), false, 1, (Object) null);
    }

    public void b(Segment segment, int i) {
        this.c = segment;
        this.d = i;
    }

    public void c(Object obj) {
        this.e = obj;
    }

    public void d(DisposableHandle disposableHandle) {
        this.c = disposableHandle;
    }

    public boolean e(Object obj, Object obj2) {
        return z(obj, obj2) == 0;
    }

    public void f(SelectClause1 selectClause1, Function2 function2) {
        w(this, new ClauseData(selectClause1.d(), selectClause1.c(), selectClause1.b(), (Object) null, function2, selectClause1.a()), false, 1, (Object) null);
    }

    public void g(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.c) {
                return;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, SelectKt.d));
        List<ClauseData> list = this.b;
        if (list != null) {
            for (ClauseData b2 : list) {
                b2.b();
            }
            this.e = SelectKt.e;
            this.b = null;
        }
    }

    public CoroutineContext getContext() {
        return this.f3972a;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void m(Object obj) {
        List<ClauseData> list = this.b;
        Intrinsics.checkNotNull(list);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (ClauseData clauseData : list) {
                if (clauseData.f3973a == obj) {
                    throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                }
            }
        }
    }

    public final void n(ClauseData clauseData) {
        List<ClauseData> list = this.b;
        if (list != null) {
            for (ClauseData clauseData2 : list) {
                if (clauseData2 != clauseData) {
                    clauseData2.b();
                }
            }
            f.set(this, SelectKt.c);
            this.e = SelectKt.e;
            this.b = null;
        }
    }

    public final Object o(Continuation continuation) {
        Object obj = f.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.e;
        n(clauseData);
        return clauseData.c(clauseData.d(obj2), continuation);
    }

    public Object p(Continuation continuation) {
        return q(this, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:18:0x0053, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0056
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.selects.SelectImplementation r5 = (kotlinx.coroutines.selects.SelectImplementation) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.A(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r5.o(r0)
            if (r6 != r1) goto L_0x0056
            return r1
        L_0x0056:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.selects.SelectImplementation.ClauseData s(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.List r3 = r3.b
            r0 = 0
            if (r3 != 0) goto L_0x0006
            return r0
        L_0x0006:
            java.util.Iterator r3 = r3.iterator()
        L_0x000a:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = r3.next()
            r2 = r1
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r2 = (kotlinx.coroutines.selects.SelectImplementation.ClauseData) r2
            java.lang.Object r2 = r2.f3973a
            if (r2 != r4) goto L_0x000a
            r0 = r1
        L_0x001c:
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r0 = (kotlinx.coroutines.selects.SelectImplementation.ClauseData) r0
            if (r0 == 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Clause with object "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = " is not found"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.s(java.lang.Object):kotlinx.coroutines.selects.SelectImplementation$ClauseData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlinx.coroutines.selects.SelectImplementation.ClauseData r5, java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.Object r4 = r5.d(r6)
            r0.label = r2
            java.lang.Object r4 = r5.c(r4, r0)
            if (r4 != r7) goto L_0x0041
            return r7
        L_0x0041:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.u(kotlinx.coroutines.selects.SelectImplementation$ClauseData, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void v(ClauseData clauseData, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        if (!(atomicReferenceFieldUpdater.get(this) instanceof ClauseData)) {
            if (!z) {
                m(clauseData.f3973a);
            }
            if (clauseData.e(this)) {
                if (!z) {
                    List list = this.b;
                    Intrinsics.checkNotNull(list);
                    list.add(clauseData);
                }
                clauseData.g = this.c;
                clauseData.h = this.d;
                this.c = null;
                this.d = -1;
                return;
            }
            atomicReferenceFieldUpdater.set(this, clauseData);
        }
    }

    public final void x(Object obj) {
        ClauseData s = s(obj);
        Intrinsics.checkNotNull(s);
        s.g = null;
        s.h = -1;
        v(s, true);
    }

    public final TrySelectDetailedResult y(Object obj, Object obj2) {
        return SelectKt.a(z(obj, obj2));
    }

    public final int z(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof CancellableContinuation) {
                ClauseData s = s(obj);
                if (s == null) {
                    continue;
                } else {
                    Function1 a2 = s.a(this, obj2);
                    if (a.a(atomicReferenceFieldUpdater, this, obj3, s)) {
                        this.e = obj2;
                        if (SelectKt.j((CancellableContinuation) obj3, a2)) {
                            return 0;
                        }
                        this.e = null;
                        return 2;
                    }
                }
            } else {
                if (Intrinsics.areEqual(obj3, (Object) SelectKt.c) ? true : obj3 instanceof ClauseData) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj3, (Object) SelectKt.d)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj3, (Object) SelectKt.b)) {
                    if (a.a(atomicReferenceFieldUpdater, this, obj3, CollectionsKt.listOf(obj))) {
                        return 1;
                    }
                } else if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                } else if (a.a(atomicReferenceFieldUpdater, this, obj3, CollectionsKt.plus((Collection) obj3, obj))) {
                    return 1;
                }
            }
        }
    }
}
