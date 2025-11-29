package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "<init>", "()V", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "a", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "b", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
public final class MainDispatcherLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final MainDispatcherLoader f3924a;
    public static final MainCoroutineDispatcher b;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        f3924a = mainDispatcherLoader;
        SystemPropsKt.f("kotlinx.coroutines.fast.service.loader", true);
        b = mainDispatcherLoader.a();
    }

    public final MainCoroutineDispatcher a() {
        T t;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        try {
            List<T> list = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                t = null;
            } else {
                t = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) t).getLoadPriority();
                    do {
                        T next = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            t = next;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) t;
            if (mainDispatcherFactory != null) {
                MainCoroutineDispatcher e = MainDispatchersKt.e(mainDispatcherFactory, list);
                if (e != null) {
                    return e;
                }
            }
            return MainDispatchersKt.b((Throwable) null, (String) null, 3, (Object) null);
        } catch (Throwable th) {
            return MainDispatchersKt.b(th, (String) null, 2, (Object) null);
        }
    }
}
