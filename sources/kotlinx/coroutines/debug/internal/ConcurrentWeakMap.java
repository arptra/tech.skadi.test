package kotlinx.coroutines.debug.internal;

import com.honey.account.constant.AccountConstantKt;
import com.honey.account.u1.c;
import com.upuphone.runasone.core.api.ApiConstant;
import com.upuphone.runasone.relay.api.IntentKey;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003-./B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J#\u0010\u0015\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u00102\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0!8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#R\u000b\u0010)\u001a\u00020(8\u0002X\u0004R!\u0010,\u001a\u0018\u0012\u0014\u0012\u00120+R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000*8\u0002X\u0004¨\u00060"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "", "weakRefQueue", "<init>", "(Z)V", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "clear", "()V", "h", "f", "g", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "e", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "Ljava/lang/ref/ReferenceQueue;", "a", "Ljava/lang/ref/ReferenceQueue;", "", "getSize", "()I", "size", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getEntries", "entries", "Lkotlinx/atomicfu/AtomicInt;", "_size", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "core", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    public static final AtomicIntegerFieldUpdater b;
    public static final AtomicReferenceFieldUpdater c;
    @Volatile
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    public final ReferenceQueue f3764a;
    @Volatile
    @Nullable
    private volatile Object core;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018\"\u0004\b\u0002\u0010\u00152\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\"R\u0019\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0'8\u0002X\u0004R\u000b\u0010*\u001a\u00020)8\u0002X\u0004R\u0013\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'8\u0002X\u0004¨\u0006-"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "key", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakKey0", "h", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "j", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "weakRef", "", "d", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "E", "Lkotlin/Function2;", "factory", "", "g", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "hash", "f", "(I)I", "index", "k", "(I)V", "a", "I", "b", "shift", "c", "threshold", "Lkotlinx/atomicfu/AtomicArray;", "keys", "Lkotlinx/atomicfu/AtomicInt;", "load", "values", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class Core {
        public static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");

        /* renamed from: a  reason: collision with root package name */
        public final int f3765a;
        public final int b;
        public final int c;
        public final AtomicReferenceArray d;
        public final AtomicReferenceArray e;
        @Volatile
        private volatile int load;

        @SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0016\u0010\u0018\u001a\u00028\u00008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00028\u00018\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "b", "()Ljava/lang/Void;", "", "a", "()V", "Lkotlin/jvm/functions/Function2;", "", "I", "index", "c", "Ljava/lang/Object;", "key", "d", "value", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {

            /* renamed from: a  reason: collision with root package name */
            public final Function2 f3766a;
            public int b = -1;
            public Object c;
            public Object d;

            public KeyValueIterator(Function2 function2) {
                this.f3766a = function2;
                a();
            }

            public final void a() {
                Object obj;
                while (true) {
                    int i = this.b + 1;
                    this.b = i;
                    if (i < Core.this.f3765a) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.d.get(this.b);
                        if (!(hashedWeakRef == null || (obj = hashedWeakRef.get()) == null)) {
                            this.c = obj;
                            Object obj2 = Core.this.e.get(this.b);
                            if (obj2 instanceof Marked) {
                                obj2 = ((Marked) obj2).f3777a;
                            }
                            if (obj2 != null) {
                                this.d = obj2;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            /* renamed from: b */
            public Void remove() {
                Void unused = ConcurrentWeakMapKt.e();
                throw new KotlinNothingValueException();
            }

            public boolean hasNext() {
                return this.b < Core.this.f3765a;
            }

            public Object next() {
                if (this.b < Core.this.f3765a) {
                    Function2 function2 = this.f3766a;
                    Object obj = this.c;
                    if (obj == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(IntentKey.ACTIVITY.ACTION_KEY);
                        obj = Unit.INSTANCE;
                    }
                    Object obj2 = this.d;
                    if (obj2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AccountConstantKt.RESPONSE_VALUE);
                        obj2 = Unit.INSTANCE;
                    }
                    Object invoke = function2.invoke(obj, obj2);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public Core(int i) {
            this.f3765a = i;
            this.b = Integer.numberOfLeadingZeros(i) + 1;
            this.c = (i * 2) / 3;
            this.d = new AtomicReferenceArray(i);
            this.e = new AtomicReferenceArray(i);
        }

        public static /* synthetic */ Object i(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i, Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.h(obj, obj2, hashedWeakRef);
        }

        public final void d(HashedWeakRef hashedWeakRef) {
            int f2 = f(hashedWeakRef.f3776a);
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) this.d.get(f2);
                if (hashedWeakRef2 != null) {
                    if (hashedWeakRef2 == hashedWeakRef) {
                        k(f2);
                        return;
                    }
                    if (f2 == 0) {
                        f2 = this.f3765a;
                    }
                    f2--;
                } else {
                    return;
                }
            }
        }

        public final Object e(Object obj) {
            int f2 = f(obj.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.d.get(f2);
                if (hashedWeakRef == null) {
                    return null;
                }
                Object obj2 = hashedWeakRef.get();
                if (Intrinsics.areEqual(obj, obj2)) {
                    Object obj3 = this.e.get(f2);
                    return obj3 instanceof Marked ? ((Marked) obj3).f3777a : obj3;
                }
                if (obj2 == null) {
                    k(f2);
                }
                if (f2 == 0) {
                    f2 = this.f3765a;
                }
                f2--;
            }
        }

        public final int f(int i) {
            return (i * -1640531527) >>> this.b;
        }

        public final Iterator g(Function2 function2) {
            return new KeyValueIterator(function2);
        }

        public final Object h(Object obj, Object obj2, HashedWeakRef hashedWeakRef) {
            Object obj3;
            int i;
            int f2 = f(obj.hashCode());
            boolean z = false;
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) this.d.get(f2);
                if (hashedWeakRef2 == null) {
                    if (obj2 != null) {
                        if (!z) {
                            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
                            do {
                                i = atomicIntegerFieldUpdater.get(this);
                                if (i >= this.c) {
                                    return ConcurrentWeakMapKt.f3769a;
                                }
                            } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1));
                            z = true;
                        }
                        if (hashedWeakRef == null) {
                            hashedWeakRef = new HashedWeakRef(obj, ConcurrentWeakMap.this.f3764a);
                        }
                        if (c.a(this.d, f2, (Object) null, hashedWeakRef)) {
                            break;
                        }
                    } else {
                        return null;
                    }
                } else {
                    Object obj4 = hashedWeakRef2.get();
                    if (!Intrinsics.areEqual(obj, obj4)) {
                        if (obj4 == null) {
                            k(f2);
                        }
                        if (f2 == 0) {
                            f2 = this.f3765a;
                        }
                        f2--;
                    } else if (z) {
                        g.decrementAndGet(this);
                    }
                }
            }
            do {
                obj3 = this.e.get(f2);
                if (obj3 instanceof Marked) {
                    return ConcurrentWeakMapKt.f3769a;
                }
            } while (!c.a(this.e, f2, obj3, obj2));
            return obj3;
        }

        public final Core j() {
            Object obj;
            while (true) {
                Core core = new Core(Integer.highestOneBit(RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = this.f3765a;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        return core;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.d.get(i2);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        k(i2);
                    }
                    while (true) {
                        obj = this.e.get(i2);
                        if (!(obj instanceof Marked)) {
                            if (c.a(this.e, i2, obj, ConcurrentWeakMapKt.d(obj))) {
                                break;
                            }
                        } else {
                            obj = ((Marked) obj).f3777a;
                            break;
                        }
                    }
                    if (obj2 == null || obj == null || core.h(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.f3769a) {
                        i2++;
                    }
                }
            }
        }

        public final void k(int i) {
            Object obj;
            do {
                obj = this.e.get(i);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!c.a(this.e, i, obj, (Object) null));
            ConcurrentWeakMap.this.f();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00028\u00032\u0006\u0010\b\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00028\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "b", "getValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3767a;
        public final Object b;

        public Entry(Object obj, Object obj2) {
            this.f3767a = obj;
            this.b = obj2;
        }

        public Object getKey() {
            return this.f3767a;
        }

        public Object getValue() {
            return this.b;
        }

        public Object setValue(Object obj) {
            Void unused = ConcurrentWeakMapKt.e();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "()Ljava/util/Iterator;", "a", "Lkotlin/jvm/functions/Function2;", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class KeyValueSet<E> extends AbstractMutableSet<E> {

        /* renamed from: a  reason: collision with root package name */
        public final Function2 f3768a;

        public KeyValueSet(Function2 function2) {
            this.f3768a = function2;
        }

        public boolean add(Object obj) {
            Void unused = ConcurrentWeakMapKt.e();
            throw new KotlinNothingValueException();
        }

        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        public Iterator iterator() {
            return ((Core) ConcurrentWeakMap.c.get(ConcurrentWeakMap.this)).g(this.f3768a);
        }
    }

    static {
        Class<ConcurrentWeakMap> cls = ConcurrentWeakMap.class;
        b = AtomicIntegerFieldUpdater.newUpdater(cls, "_size");
        c = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, ApiConstant.COMPONENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public void clear() {
        for (Object remove : keySet()) {
            remove(remove);
        }
    }

    public final void e(HashedWeakRef hashedWeakRef) {
        ((Core) c.get(this)).d(hashedWeakRef);
    }

    public final void f() {
        b.decrementAndGet(this);
    }

    public final synchronized Object g(Object obj, Object obj2) {
        Object i;
        Core core2 = (Core) c.get(this);
        while (true) {
            i = Core.i(core2, obj, obj2, (HashedWeakRef) null, 4, (Object) null);
            if (i == ConcurrentWeakMapKt.f3769a) {
                core2 = core2.j();
                c.set(this, core2);
            }
        }
        return i;
    }

    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Core) c.get(this)).e(obj);
    }

    public Set getEntries() {
        return new KeyValueSet(ConcurrentWeakMap$entries$1.INSTANCE);
    }

    public Set getKeys() {
        return new KeyValueSet(ConcurrentWeakMap$keys$1.INSTANCE);
    }

    public int getSize() {
        return b.get(this);
    }

    public final void h() {
        if (this.f3764a != null) {
            while (true) {
                try {
                    Reference remove = this.f3764a.remove();
                    Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    e((HashedWeakRef) remove);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    public Object put(Object obj, Object obj2) {
        Object i = Core.i((Core) c.get(this), obj, obj2, (HashedWeakRef) null, 4, (Object) null);
        if (i == ConcurrentWeakMapKt.f3769a) {
            i = g(obj, obj2);
        }
        if (i == null) {
            b.incrementAndGet(this);
        }
        return i;
    }

    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        Object i = Core.i((Core) c.get(this), obj, (Object) null, (HashedWeakRef) null, 4, (Object) null);
        if (i == ConcurrentWeakMapKt.f3769a) {
            i = g(obj, (Object) null);
        }
        if (i != null) {
            b.decrementAndGet(this);
        }
        return i;
    }

    public ConcurrentWeakMap(boolean z) {
        this.core = new Core(16);
        this.f3764a = z ? new ReferenceQueue() : null;
    }
}
