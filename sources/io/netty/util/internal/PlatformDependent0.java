package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

@SuppressJava6Requirement(reason = "Unsafe access is guarded")
final class PlatformDependent0 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALIGN_SLICE;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final Object INTERNAL_UNSAFE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID = isAndroid0();
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = explicitTryReflectionSetAccessible0();
    private static final int JAVA_VERSION = javaVersion0();
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final boolean RUNNING_IN_NATIVE_IMAGE = SystemPropertyUtil.contains("org.graalvm.nativeimage.imagecode");
    private static final boolean STORE_FENCE_AVAILABLE;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f8  */
    static {
        /*
            java.lang.Class<io.netty.util.internal.PlatformDependent0> r0 = io.netty.util.internal.PlatformDependent0.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            logger = r0
            java.lang.Throwable r1 = explicitNoUnsafeCause0()
            EXPLICIT_NO_UNSAFE_CAUSE = r1
            int r2 = javaVersion0()
            JAVA_VERSION = r2
            boolean r2 = isAndroid0()
            IS_ANDROID = r2
            java.lang.String r2 = "org.graalvm.nativeimage.imagecode"
            boolean r2 = io.netty.util.internal.SystemPropertyUtil.contains(r2)
            RUNNING_IN_NATIVE_IMAGE = r2
            boolean r2 = explicitTryReflectionSetAccessible0()
            IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = r2
            r2 = 1
            java.lang.Class<byte[]> r4 = byte[].class
            r5 = 1
            r6 = 0
            r7 = 0
            if (r1 == 0) goto L_0x0037
            r10 = r6
            r8 = r7
            r9 = r8
            r11 = r9
            goto L_0x0112
        L_0x0037:
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocateDirect(r5)
            io.netty.util.internal.PlatformDependent0$1 r9 = new io.netty.util.internal.PlatformDependent0$1
            r9.<init>()
            java.lang.Object r9 = java.security.AccessController.doPrivileged(r9)
            boolean r10 = r9 instanceof java.lang.Throwable
            if (r10 == 0) goto L_0x0062
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            boolean r9 = r0.isTraceEnabled()
            if (r9 == 0) goto L_0x0057
            java.lang.String r9 = "sun.misc.Unsafe.theUnsafe: unavailable"
            r0.debug((java.lang.String) r9, (java.lang.Throwable) r1)
            goto L_0x0060
        L_0x0057:
            java.lang.String r9 = "sun.misc.Unsafe.theUnsafe: unavailable: {}"
            java.lang.String r10 = r1.getMessage()
            r0.debug((java.lang.String) r9, (java.lang.Object) r10)
        L_0x0060:
            r9 = r7
            goto L_0x0069
        L_0x0062:
            sun.misc.Unsafe r9 = (sun.misc.Unsafe) r9
            java.lang.String r10 = "sun.misc.Unsafe.theUnsafe: available"
            r0.debug((java.lang.String) r10)
        L_0x0069:
            if (r9 == 0) goto L_0x0095
            io.netty.util.internal.PlatformDependent0$2 r10 = new io.netty.util.internal.PlatformDependent0$2
            r10.<init>(r9)
            java.lang.Object r10 = java.security.AccessController.doPrivileged(r10)
            if (r10 != 0) goto L_0x007c
            java.lang.String r10 = "sun.misc.Unsafe.copyMemory: available"
            r0.debug((java.lang.String) r10)
            goto L_0x0095
        L_0x007c:
            r1 = r10
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            boolean r9 = r0.isTraceEnabled()
            if (r9 == 0) goto L_0x008b
            java.lang.String r9 = "sun.misc.Unsafe.copyMemory: unavailable"
            r0.debug((java.lang.String) r9, (java.lang.Throwable) r1)
            goto L_0x0094
        L_0x008b:
            java.lang.String r9 = "sun.misc.Unsafe.copyMemory: unavailable: {}"
            java.lang.String r10 = r1.getMessage()
            r0.debug((java.lang.String) r9, (java.lang.Object) r10)
        L_0x0094:
            r9 = r7
        L_0x0095:
            if (r9 == 0) goto L_0x00c2
            io.netty.util.internal.PlatformDependent0$3 r10 = new io.netty.util.internal.PlatformDependent0$3
            r10.<init>(r9)
            java.lang.Object r10 = java.security.AccessController.doPrivileged(r10)
            if (r10 != 0) goto L_0x00a9
            java.lang.String r10 = "sun.misc.Unsafe.storeFence: available"
            r0.debug((java.lang.String) r10)
            r10 = r5
            goto L_0x00c3
        L_0x00a9:
            boolean r11 = r0.isTraceEnabled()
            if (r11 == 0) goto L_0x00b7
            java.lang.String r11 = "sun.misc.Unsafe.storeFence: unavailable"
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            r0.debug((java.lang.String) r11, (java.lang.Throwable) r10)
            goto L_0x00c2
        L_0x00b7:
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.String r10 = r10.getMessage()
            java.lang.String r11 = "sun.misc.Unsafe.storeFence: unavailable: {}"
            r0.debug((java.lang.String) r11, (java.lang.Object) r10)
        L_0x00c2:
            r10 = r6
        L_0x00c3:
            if (r9 == 0) goto L_0x00f5
            io.netty.util.internal.PlatformDependent0$4 r11 = new io.netty.util.internal.PlatformDependent0$4
            r11.<init>(r9, r8)
            java.lang.Object r11 = java.security.AccessController.doPrivileged(r11)
            boolean r12 = r11 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x00da
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            java.lang.String r12 = "java.nio.Buffer.address: available"
            r0.debug((java.lang.String) r12)
            goto L_0x00f6
        L_0x00da:
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            boolean r1 = r0.isTraceEnabled()
            if (r1 == 0) goto L_0x00e8
            java.lang.String r1 = "java.nio.Buffer.address: unavailable"
            r0.debug((java.lang.String) r1, (java.lang.Throwable) r11)
            goto L_0x00f1
        L_0x00e8:
            java.lang.String r1 = "java.nio.Buffer.address: unavailable: {}"
            java.lang.String r9 = r11.getMessage()
            r0.debug((java.lang.String) r1, (java.lang.Object) r9)
        L_0x00f1:
            r9 = r7
            r1 = r11
            r11 = r9
            goto L_0x00f6
        L_0x00f5:
            r11 = r7
        L_0x00f6:
            if (r9 == 0) goto L_0x0112
            int r12 = r9.arrayIndexScale(r4)
            long r12 = (long) r12
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x0112
            java.lang.Long r1 = java.lang.Long.valueOf(r12)
            java.lang.String r9 = "unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe."
            r0.debug((java.lang.String) r9, (java.lang.Object) r1)
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r9 = "Unexpected unsafe.arrayIndexScale"
            r1.<init>(r9)
            r9 = r7
        L_0x0112:
            UNSAFE_UNAVAILABILITY_CAUSE = r1
            UNSAFE = r9
            r1 = 9
            r12 = -1
            if (r9 != 0) goto L_0x0133
            ADDRESS_FIELD_OFFSET = r12
            BYTE_ARRAY_BASE_OFFSET = r12
            LONG_ARRAY_BASE_OFFSET = r12
            LONG_ARRAY_INDEX_SCALE = r12
            INT_ARRAY_BASE_OFFSET = r12
            INT_ARRAY_INDEX_SCALE = r12
            UNALIGNED = r6
            DIRECT_BUFFER_CONSTRUCTOR = r7
            ALLOCATE_ARRAY_METHOD = r7
            STORE_FENCE_AVAILABLE = r6
            r2 = r7
            goto L_0x027b
        L_0x0133:
            io.netty.util.internal.PlatformDependent0$5 r6 = new io.netty.util.internal.PlatformDependent0$5     // Catch:{ all -> 0x0163 }
            r6.<init>(r8)     // Catch:{ all -> 0x0163 }
            java.lang.Object r6 = java.security.AccessController.doPrivileged(r6)     // Catch:{ all -> 0x0163 }
            boolean r8 = r6 instanceof java.lang.reflect.Constructor     // Catch:{ all -> 0x0163 }
            if (r8 == 0) goto L_0x0167
            long r2 = r9.allocateMemory(r2)     // Catch:{ all -> 0x0163 }
            r8 = r6
            java.lang.reflect.Constructor r8 = (java.lang.reflect.Constructor) r8     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            java.lang.Long r9 = java.lang.Long.valueOf(r2)     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            java.lang.Object[] r5 = new java.lang.Object[]{r9, r5}     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            r8.newInstance(r5)     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            java.lang.reflect.Constructor r6 = (java.lang.reflect.Constructor) r6     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            java.lang.String r5 = "direct buffer constructor: available"
            r0.debug((java.lang.String) r5)     // Catch:{ IllegalAccessException | InstantiationException | InvocationTargetException -> 0x0161, all -> 0x015e }
            goto L_0x0182
        L_0x015e:
            r0 = move-exception
            goto L_0x02a4
        L_0x0161:
            r6 = r7
            goto L_0x0182
        L_0x0163:
            r0 = move-exception
            r2 = r12
            goto L_0x02a4
        L_0x0167:
            boolean r2 = r0.isTraceEnabled()     // Catch:{ all -> 0x0163 }
            if (r2 == 0) goto L_0x0175
            java.lang.String r2 = "direct buffer constructor: unavailable"
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0163 }
            r0.debug((java.lang.String) r2, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0163 }
            goto L_0x0180
        L_0x0175:
            java.lang.String r2 = "direct buffer constructor: unavailable: {}"
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0163 }
            r0.debug((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x0163 }
        L_0x0180:
            r6 = r7
            r2 = r12
        L_0x0182:
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x018b
            sun.misc.Unsafe r0 = UNSAFE
            r0.freeMemory(r2)
        L_0x018b:
            DIRECT_BUFFER_CONSTRUCTOR = r6
            long r2 = objectFieldOffset(r11)
            ADDRESS_FIELD_OFFSET = r2
            sun.misc.Unsafe r0 = UNSAFE
            int r2 = r0.arrayBaseOffset(r4)
            long r2 = (long) r2
            BYTE_ARRAY_BASE_OFFSET = r2
            java.lang.Class<int[]> r2 = int[].class
            int r3 = r0.arrayBaseOffset(r2)
            long r3 = (long) r3
            INT_ARRAY_BASE_OFFSET = r3
            int r2 = r0.arrayIndexScale(r2)
            long r2 = (long) r2
            INT_ARRAY_INDEX_SCALE = r2
            java.lang.Class<long[]> r2 = long[].class
            int r3 = r0.arrayBaseOffset(r2)
            long r3 = (long) r3
            LONG_ARRAY_BASE_OFFSET = r3
            int r0 = r0.arrayIndexScale(r2)
            long r2 = (long) r0
            LONG_ARRAY_INDEX_SCALE = r2
            io.netty.util.internal.PlatformDependent0$6 r0 = new io.netty.util.internal.PlatformDependent0$6
            r0.<init>()
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            boolean r2 = r0 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x01d7
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r2 = r0.booleanValue()
            io.netty.util.internal.logging.InternalLogger r3 = logger
            java.lang.String r4 = "java.nio.Bits.unaligned: available, {}"
            r3.debug((java.lang.String) r4, (java.lang.Object) r0)
            goto L_0x0206
        L_0x01d7:
            java.lang.String r2 = "os.arch"
            java.lang.String r3 = ""
            java.lang.String r2 = io.netty.util.internal.SystemPropertyUtil.get(r2, r3)
            java.lang.String r3 = "^(i[3-6]86|x86(_64)?|x64|amd64)$"
            boolean r2 = r2.matches(r3)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            io.netty.util.internal.logging.InternalLogger r3 = logger
            boolean r4 = r3.isTraceEnabled()
            if (r4 == 0) goto L_0x01f9
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            java.lang.String r5 = "java.nio.Bits.unaligned: unavailable, {}"
            r3.debug(r5, r4, r0)
            goto L_0x0206
        L_0x01f9:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = "java.nio.Bits.unaligned: unavailable, {}, {}"
            r3.debug(r5, r4, r0)
        L_0x0206:
            UNALIGNED = r2
            int r0 = javaVersion()
            if (r0 < r1) goto L_0x026e
            io.netty.util.internal.PlatformDependent0$7 r0 = new io.netty.util.internal.PlatformDependent0$7
            r0.<init>()
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            boolean r2 = r0 instanceof java.lang.Throwable
            if (r2 != 0) goto L_0x0244
            io.netty.util.internal.PlatformDependent0$8 r2 = new io.netty.util.internal.PlatformDependent0$8
            r2.<init>(r0)
            java.lang.Object r2 = java.security.AccessController.doPrivileged(r2)
            boolean r3 = r2 instanceof java.lang.reflect.Method
            if (r3 == 0) goto L_0x0242
            r3 = r2
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0241 }
            java.lang.Class r4 = java.lang.Byte.TYPE     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0241 }
            r5 = 8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0241 }
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5}     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0241 }
            java.lang.Object r4 = r3.invoke(r0, r4)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0241 }
            byte[] r4 = (byte[]) r4     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0241 }
        L_0x023d:
            r15 = r2
            r2 = r0
            r0 = r15
            goto L_0x0246
        L_0x0241:
            r2 = move-exception
        L_0x0242:
            r3 = r7
            goto L_0x023d
        L_0x0244:
            r2 = r7
            r3 = r2
        L_0x0246:
            boolean r4 = r0 instanceof java.lang.Throwable
            if (r4 == 0) goto L_0x0266
            io.netty.util.internal.logging.InternalLogger r4 = logger
            boolean r5 = r4.isTraceEnabled()
            if (r5 == 0) goto L_0x025a
            java.lang.String r5 = "jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable"
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4.debug((java.lang.String) r5, (java.lang.Throwable) r0)
            goto L_0x0277
        L_0x025a:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = "jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable: {}"
            r4.debug((java.lang.String) r5, (java.lang.Object) r0)
            goto L_0x0277
        L_0x0266:
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.String r4 = "jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available"
            r0.debug((java.lang.String) r4)
            goto L_0x0277
        L_0x026e:
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.String r2 = "jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9"
            r0.debug((java.lang.String) r2)
            r2 = r7
            r3 = r2
        L_0x0277:
            ALLOCATE_ARRAY_METHOD = r3
            STORE_FENCE_AVAILABLE = r10
        L_0x027b:
            int r0 = javaVersion()
            if (r0 <= r1) goto L_0x028f
            io.netty.util.internal.PlatformDependent0$9 r0 = new io.netty.util.internal.PlatformDependent0$9
            r0.<init>()
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            ALIGN_SLICE = r0
            goto L_0x0291
        L_0x028f:
            ALIGN_SLICE = r7
        L_0x0291:
            INTERNAL_UNSAFE = r2
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.reflect.Constructor<?> r1 = DIRECT_BUFFER_CONSTRUCTOR
            if (r1 == 0) goto L_0x029c
            java.lang.String r1 = "available"
            goto L_0x029e
        L_0x029c:
            java.lang.String r1 = "unavailable"
        L_0x029e:
            java.lang.String r2 = "java.nio.DirectByteBuffer.<init>(long, int): {}"
            r0.debug((java.lang.String) r2, (java.lang.Object) r1)
            return
        L_0x02a4:
            int r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x02ad
            sun.misc.Unsafe r1 = UNSAFE
            r1.freeMemory(r2)
        L_0x02ad:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent0.<clinit>():void");
    }

    private PlatformDependent0() {
    }

    public static int addressSize() {
        return UNSAFE.addressSize();
    }

    public static ByteBuffer alignSlice(ByteBuffer byteBuffer, int i) {
        try {
            return (ByteBuffer) ALIGN_SLICE.invoke(byteBuffer, new Object[]{Integer.valueOf(i)});
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    public static ByteBuffer allocateDirectNoCleaner(int i) {
        return newDirectBuffer(UNSAFE.allocateMemory((long) Math.max(1, i)), i);
    }

    public static long allocateMemory(long j) {
        return UNSAFE.allocateMemory(j);
    }

    public static byte[] allocateUninitializedArray(int i) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, new Object[]{Byte.TYPE, Integer.valueOf(i)});
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    public static void copyMemory(long j, long j2, long j3) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(j, j2, j3);
        } else {
            UNSAFE.copyMemory(j, j2, j3);
        }
    }

    private static void copyMemoryWithSafePointPolling(long j, long j2, long j3) {
        while (j3 > 0) {
            long min = Math.min(j3, 1048576);
            UNSAFE.copyMemory(j, j2, min);
            j3 -= min;
            j += min;
            j2 += min;
        }
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong((Object) byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArr3 = bArr;
        int i4 = i;
        byte[] bArr4 = bArr2;
        int i5 = i3;
        int i6 = i5 & 7;
        long j = BYTE_ARRAY_BASE_OFFSET + ((long) i4);
        long j2 = (long) (i2 - i4);
        if (i5 >= 8) {
            long j3 = ((long) i6) + j;
            long j4 = (j - 8) + ((long) i5);
            while (j4 >= j3) {
                Unsafe unsafe = UNSAFE;
                long j5 = j3;
                if (unsafe.getLong(bArr3, j4) != unsafe.getLong(bArr4, j4 + j2)) {
                    return false;
                }
                j4 -= 8;
                j3 = j5;
            }
        }
        if (i6 >= 4) {
            i6 -= 4;
            long j6 = ((long) i6) + j;
            Unsafe unsafe2 = UNSAFE;
            if (unsafe2.getInt(bArr3, j6) != unsafe2.getInt(bArr4, j6 + j2)) {
                return false;
            }
        }
        long j7 = j2 + j;
        if (i6 >= 2) {
            Unsafe unsafe3 = UNSAFE;
            return unsafe3.getChar(bArr3, j) == unsafe3.getChar(bArr4, j7) && (i6 == 2 || unsafe3.getByte(bArr3, j + 2) == unsafe3.getByte(bArr4, j7 + 2));
        }
        if (i6 != 0) {
            Unsafe unsafe4 = UNSAFE;
            if (unsafe4.getByte(bArr3, j) != unsafe4.getByte(bArr4, j7)) {
                return false;
            }
        }
        return true;
    }

    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArr3 = bArr;
        int i4 = i;
        byte[] bArr4 = bArr2;
        int i5 = i3;
        long j = (long) (i5 & 7);
        long j2 = BYTE_ARRAY_BASE_OFFSET + ((long) i4);
        long j3 = j2 + j;
        long j4 = (long) (i2 - i4);
        long j5 = 0;
        for (long j6 = (j2 - 8) + ((long) i5); j6 >= j3; j6 -= 8) {
            Unsafe unsafe = UNSAFE;
            j5 |= unsafe.getLong(bArr3, j6) ^ unsafe.getLong(bArr4, j6 + j4);
        }
        if (j >= 4) {
            Unsafe unsafe2 = UNSAFE;
            j5 |= (long) (unsafe2.getInt(bArr4, j2 + j4) ^ unsafe2.getInt(bArr3, j2));
            j -= 4;
        }
        if (j >= 2) {
            long j7 = j3 - j;
            Unsafe unsafe3 = UNSAFE;
            j5 |= (long) (unsafe3.getChar(bArr4, j7 + j4) ^ unsafe3.getChar(bArr3, j7));
            j -= 2;
        }
        if (j == 1) {
            long j8 = j3 - 1;
            Unsafe unsafe4 = UNSAFE;
            j5 |= (long) (unsafe4.getByte(bArr3, j8) ^ unsafe4.getByte(bArr4, j8 + j4));
        }
        return ConstantTimeUtils.equalsConstantTime(j5, 0);
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean z = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", (Object) Boolean.valueOf(z));
        if (z) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        String str = "io.netty.tryUnsafe";
        if (!SystemPropertyUtil.contains(str)) {
            str = "org.jboss.netty.tryUnsafe";
        }
        if (SystemPropertyUtil.getBoolean(str, true)) {
            return null;
        }
        String str2 = "sun.misc.Unsafe: unavailable (" + str + ")";
        internalLogger.debug(str2);
        return new UnsupportedOperationException(str2);
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", javaVersion() < 9 || RUNNING_IN_NATIVE_IMAGE);
    }

    public static void freeMemory(long j) {
        UNSAFE.freeMemory(j);
    }

    public static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    public static ClassLoader getClassLoader(final Class<?> cls) {
        return System.getSecurityManager() == null ? cls.getClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    public static ClassLoader getContextClassLoader() {
        return System.getSecurityManager() == null ? Thread.currentThread().getContextClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    public static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    public static int getIntVolatile(long j) {
        return UNSAFE.getIntVolatile((Object) null, j);
    }

    private static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    public static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    public static short getShort(long j) {
        return UNSAFE.getShort(j);
    }

    public static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    public static boolean hasAlignSliceMethod() {
        return ALIGN_SLICE != null;
    }

    public static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    public static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    public static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    public static int hashCodeAscii(byte[] bArr, int i, int i2) {
        int i3;
        long j = BYTE_ARRAY_BASE_OFFSET + ((long) i);
        int i4 = i2 & 7;
        long j2 = ((long) i4) + j;
        int i5 = HASH_CODE_ASCII_SEED;
        for (long j3 = (j - 8) + ((long) i2); j3 >= j2; j3 -= 8) {
            i5 = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j3), i5);
        }
        if (i4 == 0) {
            return i5;
        }
        boolean z = false;
        boolean z2 = (i4 != 2) & (i4 != 4) & (i4 != 6);
        int i6 = HASH_CODE_C2;
        if (z2) {
            i5 = (i5 * HASH_CODE_C1) + hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
            j++;
            i3 = HASH_CODE_C2;
        } else {
            i3 = HASH_CODE_C1;
        }
        boolean z3 = (i4 != 1) & (i4 != 4);
        if (i4 != 5) {
            z = true;
        }
        if (z && z3) {
            i5 = (i5 * i3) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j));
            if (i3 != HASH_CODE_C1) {
                i6 = HASH_CODE_C1;
            }
            j += 2;
            i3 = i6;
        }
        return i4 >= 4 ? (i5 * i3) + hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j)) : i5;
    }

    public static int hashCodeAsciiCompute(long j, int i) {
        return (i * HASH_CODE_C1) + (hashCodeAsciiSanitize((int) j) * HASH_CODE_C2) + ((int) ((j & 2242545357458243584L) >>> 32));
    }

    public static int hashCodeAsciiSanitize(byte b) {
        return b & 31;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean equals = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (equals) {
            logger.debug("Platform: Android");
        }
        return equals;
    }

    public static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    public static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    public static boolean isUnaligned() {
        return UNALIGNED;
    }

    public static boolean isZero(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (i4 <= 0) {
            return true;
        }
        long j = BYTE_ARRAY_BASE_OFFSET + ((long) i3);
        int i5 = i4 & 7;
        long j2 = ((long) i5) + j;
        for (long j3 = (j - 8) + ((long) i4); j3 >= j2; j3 -= 8) {
            if (UNSAFE.getLong(bArr2, j3) != 0) {
                return false;
            }
        }
        if (i5 >= 4) {
            i5 -= 4;
            if (UNSAFE.getInt(bArr2, ((long) i5) + j) != 0) {
                return false;
            }
        }
        return i5 >= 2 ? UNSAFE.getChar(bArr2, j) == 0 && (i5 == 2 || bArr2[i3 + 2] == 0) : bArr2[i3] == 0;
    }

    public static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int majorVersionFromJavaSpecificationVersion = isAndroid0() ? 6 : majorVersionFromJavaSpecificationVersion();
        logger.debug("Java version: {}", (Object) Integer.valueOf(majorVersionFromJavaSpecificationVersion));
        return majorVersionFromJavaSpecificationVersion;
    }

    public static int majorVersion(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        int i2 = iArr[0];
        return i2 == 1 ? iArr[1] : i2;
    }

    public static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    public static ByteBuffer newDirectBuffer(long j, int i) {
        ObjectUtil.checkPositiveOrZero(i, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    public static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    public static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    public static void putInt(long j, int i) {
        UNSAFE.putInt(j, i);
    }

    public static void putIntOrdered(long j, int i) {
        UNSAFE.putOrderedInt((Object) null, j, i);
    }

    public static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        UNSAFE.putObject(obj, j, obj2);
    }

    public static void putShort(long j, short s) {
        UNSAFE.putShort(j, s);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), (long) i), i);
    }

    public static long reallocateMemory(long j, long j2) {
        return UNSAFE.reallocateMemory(j, j2);
    }

    public static void safeConstructPutInt(Object obj, long j, int i) {
        if (STORE_FENCE_AVAILABLE) {
            Unsafe unsafe = UNSAFE;
            unsafe.putInt(obj, j, i);
            unsafe.storeFence();
            return;
        }
        UNSAFE.putIntVolatile(obj, j, i);
    }

    public static void setMemory(long j, long j2, byte b) {
        UNSAFE.setMemory(j, j2, b);
    }

    public static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    public static boolean unalignedAccess() {
        return UNALIGNED;
    }

    /* access modifiers changed from: private */
    public static boolean unsafeStaticFieldOffsetSupported() {
        return !RUNNING_IN_NATIVE_IMAGE;
    }

    public static byte getByte(byte[] bArr, int i) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    public static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    public static short getShort(byte[] bArr, int i) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static int hashCodeAsciiSanitize(int i) {
        return i & 522133279;
    }

    public static void putByte(byte[] bArr, int i, byte b) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), b);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), i2);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        UNSAFE.putLong(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), j);
    }

    public static void putShort(byte[] bArr, int i, short s) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), s);
    }

    public static void setMemory(Object obj, long j, long j2, byte b) {
        UNSAFE.setMemory(obj, j, j2, b);
    }

    private static void copyMemoryWithSafePointPolling(Object obj, long j, Object obj2, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        while (j6 > 0) {
            long min = Math.min(j6, 1048576);
            UNSAFE.copyMemory(obj, j4, obj2, j5, min);
            j6 -= min;
            j4 += min;
            j5 += min;
        }
    }

    public static byte getByte(byte[] bArr, long j) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j);
    }

    public static int getInt(byte[] bArr, int i) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static long getLong(byte[] bArr, int i) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static int hashCodeAsciiSanitize(short s) {
        return s & 7967;
    }

    public static void putByte(Object obj, long j, byte b) {
        UNSAFE.putByte(obj, j, b);
    }

    public static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(obj, j, obj2, j2, j3);
        } else {
            UNSAFE.copyMemory(obj, j, obj2, j2, j3);
        }
    }

    public static int getInt(int[] iArr, long j) {
        return UNSAFE.getInt(iArr, INT_ARRAY_BASE_OFFSET + (INT_ARRAY_INDEX_SCALE * j));
    }

    public static long getLong(long[] jArr, long j) {
        return UNSAFE.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (LONG_ARRAY_INDEX_SCALE * j));
    }
}
