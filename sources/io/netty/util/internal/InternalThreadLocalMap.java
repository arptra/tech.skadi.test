package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int ARRAY_LIST_CAPACITY_EXPAND_THRESHOLD = 1073741824;
    private static final int ARRAY_LIST_CAPACITY_MAX_SIZE = 2147483639;
    private static final int DEFAULT_ARRAY_LIST_INITIAL_CAPACITY = 8;
    private static final int HANDLER_SHARABLE_CACHE_INITIAL_CAPACITY = 4;
    private static final int INDEXED_VARIABLE_TABLE_INITIAL_SIZE = 32;
    private static final int STRING_BUILDER_INITIAL_SIZE;
    private static final int STRING_BUILDER_MAX_SIZE;
    public static final Object UNSET = new Object();
    private static final InternalLogger logger;
    private static final AtomicInteger nextIndex = new AtomicInteger();
    private static final ThreadLocal<InternalThreadLocalMap> slowThreadLocalMap = new ThreadLocal<>();
    private ArrayList<Object> arrayList;
    private Map<Charset, CharsetDecoder> charsetDecoderCache;
    private Map<Charset, CharsetEncoder> charsetEncoderCache;
    private BitSet cleanerFlags;
    private IntegerHolder counterHashCode;
    private int futureListenerStackDepth;
    private Map<Class<?>, Boolean> handlerSharableCache;
    private Object[] indexedVariables = newIndexedVariableTable();
    private int localChannelReaderStackDepth;
    private ThreadLocalRandom random;
    public long rp1;
    public long rp2;
    public long rp3;
    public long rp4;
    public long rp5;
    public long rp6;
    public long rp7;
    public long rp8;
    private StringBuilder stringBuilder;
    private Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache;
    private Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache;

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) InternalThreadLocalMap.class);
        logger = instance;
        int i = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 1024);
        STRING_BUILDER_INITIAL_SIZE = i;
        instance.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", (Object) Integer.valueOf(i));
        int i2 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);
        STRING_BUILDER_MAX_SIZE = i2;
        instance.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", (Object) Integer.valueOf(i2));
    }

    private InternalThreadLocalMap() {
    }

    public static void destroy() {
        slowThreadLocalMap.remove();
    }

    private void expandIndexedVariableTableAndSet(int i, Object obj) {
        int i2;
        Object[] objArr = this.indexedVariables;
        int length = objArr.length;
        if (i < 1073741824) {
            int i3 = (i >>> 1) | i;
            int i4 = i3 | (i3 >>> 2);
            int i5 = i4 | (i4 >>> 4);
            int i6 = i5 | (i5 >>> 8);
            i2 = (i6 | (i6 >>> 16)) + 1;
        } else {
            i2 = ARRAY_LIST_CAPACITY_MAX_SIZE;
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Arrays.fill(copyOf, length, copyOf.length, UNSET);
        copyOf[i] = obj;
        this.indexedVariables = copyOf;
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread fastThreadLocalThread) {
        InternalThreadLocalMap threadLocalMap = fastThreadLocalThread.threadLocalMap();
        if (threadLocalMap != null) {
            return threadLocalMap;
        }
        InternalThreadLocalMap internalThreadLocalMap = new InternalThreadLocalMap();
        fastThreadLocalThread.setThreadLocalMap(internalThreadLocalMap);
        return internalThreadLocalMap;
    }

    public static InternalThreadLocalMap get() {
        Thread currentThread = Thread.currentThread();
        return currentThread instanceof FastThreadLocalThread ? fastGet((FastThreadLocalThread) currentThread) : slowGet();
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread currentThread = Thread.currentThread();
        return currentThread instanceof FastThreadLocalThread ? ((FastThreadLocalThread) currentThread).threadLocalMap() : slowThreadLocalMap.get();
    }

    public static int lastVariableIndex() {
        return nextIndex.get() - 1;
    }

    private static Object[] newIndexedVariableTable() {
        Object[] objArr = new Object[32];
        Arrays.fill(objArr, UNSET);
        return objArr;
    }

    public static int nextVariableIndex() {
        AtomicInteger atomicInteger = nextIndex;
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement < ARRAY_LIST_CAPACITY_MAX_SIZE && andIncrement >= 0) {
            return andIncrement;
        }
        atomicInteger.set(ARRAY_LIST_CAPACITY_MAX_SIZE);
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    public static void remove() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread) currentThread).setThreadLocalMap((InternalThreadLocalMap) null);
        } else {
            slowThreadLocalMap.remove();
        }
    }

    private static InternalThreadLocalMap slowGet() {
        ThreadLocal<InternalThreadLocalMap> threadLocal = slowThreadLocalMap;
        InternalThreadLocalMap internalThreadLocalMap = threadLocal.get();
        if (internalThreadLocalMap != null) {
            return internalThreadLocalMap;
        }
        InternalThreadLocalMap internalThreadLocalMap2 = new InternalThreadLocalMap();
        threadLocal.set(internalThreadLocalMap2);
        return internalThreadLocalMap2;
    }

    public <E> ArrayList<E> arrayList() {
        return arrayList(8);
    }

    public Map<Charset, CharsetDecoder> charsetDecoderCache() {
        Map<Charset, CharsetDecoder> map = this.charsetDecoderCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.charsetDecoderCache = identityHashMap;
        return identityHashMap;
    }

    public Map<Charset, CharsetEncoder> charsetEncoderCache() {
        Map<Charset, CharsetEncoder> map = this.charsetEncoderCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.charsetEncoderCache = identityHashMap;
        return identityHashMap;
    }

    @Deprecated
    public IntegerHolder counterHashCode() {
        return this.counterHashCode;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public Map<Class<?>, Boolean> handlerSharableCache() {
        Map<Class<?>, Boolean> map = this.handlerSharableCache;
        if (map != null) {
            return map;
        }
        WeakHashMap weakHashMap = new WeakHashMap(4);
        this.handlerSharableCache = weakHashMap;
        return weakHashMap;
    }

    public Object indexedVariable(int i) {
        Object[] objArr = this.indexedVariables;
        return i < objArr.length ? objArr[i] : UNSET;
    }

    public boolean isCleanerFlagSet(int i) {
        BitSet bitSet = this.cleanerFlags;
        return bitSet != null && bitSet.get(i);
    }

    public boolean isIndexedVariableSet(int i) {
        Object[] objArr = this.indexedVariables;
        return i < objArr.length && objArr[i] != UNSET;
    }

    public int localChannelReaderStackDepth() {
        return this.localChannelReaderStackDepth;
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom threadLocalRandom = this.random;
        if (threadLocalRandom != null) {
            return threadLocalRandom;
        }
        ThreadLocalRandom threadLocalRandom2 = new ThreadLocalRandom();
        this.random = threadLocalRandom2;
        return threadLocalRandom2;
    }

    public Object removeIndexedVariable(int i) {
        Object[] objArr = this.indexedVariables;
        if (i >= objArr.length) {
            return UNSET;
        }
        Object obj = objArr[i];
        objArr[i] = UNSET;
        return obj;
    }

    public void setCleanerFlag(int i) {
        if (this.cleanerFlags == null) {
            this.cleanerFlags = new BitSet();
        }
        this.cleanerFlags.set(i);
    }

    @Deprecated
    public void setCounterHashCode(IntegerHolder integerHolder) {
        this.counterHashCode = integerHolder;
    }

    public void setFutureListenerStackDepth(int i) {
        this.futureListenerStackDepth = i;
    }

    public boolean setIndexedVariable(int i, Object obj) {
        Object[] objArr = this.indexedVariables;
        if (i < objArr.length) {
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2 == UNSET;
        }
        expandIndexedVariableTableAndSet(i, obj);
        return true;
    }

    public void setLocalChannelReaderStackDepth(int i) {
        this.localChannelReaderStackDepth = i;
    }

    public int size() {
        int i = this.futureListenerStackDepth != 0 ? 1 : 0;
        if (this.localChannelReaderStackDepth != 0) {
            i++;
        }
        if (this.handlerSharableCache != null) {
            i++;
        }
        if (this.counterHashCode != null) {
            i++;
        }
        if (this.random != null) {
            i++;
        }
        if (this.typeParameterMatcherGetCache != null) {
            i++;
        }
        if (this.typeParameterMatcherFindCache != null) {
            i++;
        }
        if (this.stringBuilder != null) {
            i++;
        }
        if (this.charsetEncoderCache != null) {
            i++;
        }
        if (this.charsetDecoderCache != null) {
            i++;
        }
        if (this.arrayList != null) {
            i++;
        }
        for (Object obj : this.indexedVariables) {
            if (obj != UNSET) {
                i++;
            }
        }
        return i - 1;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb = this.stringBuilder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = sb2;
            return sb2;
        }
        if (sb.capacity() > STRING_BUILDER_MAX_SIZE) {
            sb.setLength(STRING_BUILDER_INITIAL_SIZE);
            sb.trimToSize();
        }
        sb.setLength(0);
        return sb;
    }

    public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache() {
        Map<Class<?>, Map<String, TypeParameterMatcher>> map = this.typeParameterMatcherFindCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.typeParameterMatcherFindCache = identityHashMap;
        return identityHashMap;
    }

    public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache() {
        Map<Class<?>, TypeParameterMatcher> map = this.typeParameterMatcherGetCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.typeParameterMatcherGetCache = identityHashMap;
        return identityHashMap;
    }

    public <E> ArrayList<E> arrayList(int i) {
        ArrayList<Object> arrayList2 = this.arrayList;
        if (arrayList2 == null) {
            ArrayList<Object> arrayList3 = new ArrayList<>(i);
            this.arrayList = arrayList3;
            return arrayList3;
        }
        arrayList2.clear();
        arrayList2.ensureCapacity(i);
        return arrayList2;
    }
}
