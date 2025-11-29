package kotlinx.coroutines.reactive;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\b¨\u0006\n"}, d2 = {"T", "Lorg/reactivestreams/Publisher;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "a", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;)Lorg/reactivestreams/Publisher;", "", "Lkotlinx/coroutines/reactive/ContextInjector;", "[Lkotlinx/coroutines/reactive/ContextInjector;", "contextInjectors", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReactiveFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/ReactiveFlowKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,273:1\n12990#2,3:274\n37#3,2:277\n*S KotlinDebug\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/ReactiveFlowKt\n*L\n169#1:274,3\n166#1:277,2\n*E\n"})
public final class ReactiveFlowKt {

    /* renamed from: a  reason: collision with root package name */
    public static final ContextInjector[] f3944a;

    static {
        Class<ContextInjector> cls = ContextInjector.class;
        f3944a = (ContextInjector[]) SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(cls, cls.getClassLoader()).iterator())).toArray(new ContextInjector[0]);
    }

    public static final Publisher a(Publisher publisher, CoroutineContext coroutineContext) {
        for (ContextInjector a2 : f3944a) {
            publisher = a2.a(publisher, coroutineContext);
        }
        return publisher;
    }
}
