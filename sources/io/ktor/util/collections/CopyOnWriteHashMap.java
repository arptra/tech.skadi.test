package io.ktor.util.collections;

import com.honey.account.i.a;
import com.upuphone.runasone.relay.api.IntentKey;
import io.ktor.util.InternalAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nCopyOnWriteHashMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CopyOnWriteHashMap.kt\nio/ktor/util/collections/CopyOnWriteHashMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1#2:74\n*E\n"})
@InternalAPI
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001J\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/util/collections/CopyOnWriteHashMap;", "", "K", "V", "key", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "producer", "a", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class CopyOnWriteHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9044a = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    @NotNull
    private volatile /* synthetic */ Object current;

    public final Object a(Object obj, Function1 function1) {
        Map map;
        HashMap hashMap;
        Object invoke;
        Intrinsics.checkNotNullParameter(obj, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(function1, "producer");
        do {
            map = (Map) this.current;
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                return obj2;
            }
            hashMap = new HashMap(map);
            invoke = function1.invoke(obj);
            hashMap.put(obj, invoke);
        } while (!a.a(f9044a, this, map, hashMap));
        return invoke;
    }

    public final Object b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, IntentKey.ACTIVITY.ACTION_KEY);
        return ((Map) this.current).get(obj);
    }
}
