package kotlin.reflect.jvm.internal.impl.util;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;
        @NotNull
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(@NotNull KClass<? extends K> kClass, int i) {
            Intrinsics.checkNotNullParameter(kClass, IntentKey.ACTIVITY.ACTION_KEY);
            this.key = kClass;
            this.id = i;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner, kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final T extractValue(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V> r2) {
            /*
                r1 = this;
                java.lang.String r0 = "thisRef"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                kotlin.reflect.jvm.internal.impl.util.ArrayMap r2 = r2.getArrayMap()
                int r1 = r1.id
                java.lang.Object r1 = r2.get(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner.AbstractArrayMapAccessor.extractValue(kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner):java.lang.Object");
        }
    }

    @NotNull
    public abstract ArrayMap<V> getArrayMap();

    @NotNull
    public abstract TypeRegistry<K, V> getTypeRegistry();

    public final boolean isEmpty() {
        return getArrayMap().getSize() == 0;
    }

    @NotNull
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public abstract void registerComponent(@NotNull KClass<? extends K> kClass, @NotNull V v);
}
