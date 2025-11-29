package io.netty.util.internal;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StarryNetConstant;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscUnboundedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.SpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PlatformDependent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE = addressSize0();
    private static final String[] ALLOWED_LINUX_OS_CLASSIFIERS;
    public static final boolean BIG_ENDIAN_NATIVE_ORDER = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final int BIT_MODE = bitMode0();
    private static final long BYTE_ARRAY_BASE_OFFSET = byteArrayBaseOffset0();
    private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = (!isAndroid());
    private static final Cleaner CLEANER;
    private static final boolean DIRECT_BUFFER_PREFERRED;
    private static final AtomicLong DIRECT_MEMORY_COUNTER;
    private static final long DIRECT_MEMORY_LIMIT;
    private static final boolean IS_IVKVM_DOT_NET = isIkvmDotNet0();
    private static final boolean IS_J9_JVM = isJ9Jvm0();
    private static final boolean IS_OSX = isOsx0();
    private static final boolean IS_WINDOWS = isWindows0();
    private static final String LINUX_ID_LIKE_PREFIX = "ID_LIKE=";
    private static final String LINUX_ID_PREFIX = "ID=";
    private static final Set<String> LINUX_OS_CLASSIFIERS;
    private static final int MAX_ALLOWED_MPSC_CAPACITY = 1073741824;
    private static final long MAX_DIRECT_MEMORY;
    private static final Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
    private static final boolean MAYBE_SUPER_USER = maybeSuperUser0();
    private static final int MIN_MAX_MPSC_CAPACITY = 2048;
    private static final int MPSC_CHUNK_SIZE = 1024;
    private static final Cleaner NOOP;
    private static final String NORMALIZED_ARCH = normalizeArch(SystemPropertyUtil.get("os.arch", ""));
    private static final String NORMALIZED_OS = normalizeOs(SystemPropertyUtil.get("os.name", ""));
    private static final String[] OS_RELEASE_FILES = {"/etc/os-release", "/usr/lib/os-release"};
    private static final ThreadLocalRandomProvider RANDOM_PROVIDER;
    private static final File TMPDIR = tmpdir0();
    private static final int UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE = unsafeUnavailabilityCause0();
    private static final boolean USE_DIRECT_BUFFER_NO_CLEANER;
    /* access modifiers changed from: private */
    public static final InternalLogger logger;

    public static final class AtomicLongCounter extends AtomicLong implements LongCounter {
        private static final long serialVersionUID = 4074772784610639305L;

        private AtomicLongCounter() {
        }

        public void add(long j) {
            addAndGet(j);
        }

        public void decrement() {
            decrementAndGet();
        }

        public void increment() {
            incrementAndGet();
        }

        public long value() {
            return get();
        }
    }

    public interface ThreadLocalRandomProvider {
        Random current();
    }

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent.class);
        logger = instance;
        long estimateMaxDirectMemory = estimateMaxDirectMemory();
        MAX_DIRECT_MEMORY = estimateMaxDirectMemory;
        String[] strArr = {"fedora", "suse", "arch"};
        ALLOWED_LINUX_OS_CLASSIFIERS = strArr;
        boolean z = false;
        AnonymousClass1 r5 = new Cleaner() {
            public void freeDirectBuffer(ByteBuffer byteBuffer) {
            }
        };
        NOOP = r5;
        if (javaVersion() >= 7) {
            RANDOM_PROVIDER = new ThreadLocalRandomProvider() {
                @SuppressJava6Requirement(reason = "Usage guarded by java version check")
                public Random current() {
                    return ThreadLocalRandom.current();
                }
            };
        } else {
            RANDOM_PROVIDER = new ThreadLocalRandomProvider() {
                public Random current() {
                    return ThreadLocalRandom.current();
                }
            };
        }
        long j = SystemPropertyUtil.getLong("io.netty.maxDirectMemory", -1);
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0 || !hasUnsafe() || !PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            USE_DIRECT_BUFFER_NO_CLEANER = false;
            DIRECT_MEMORY_COUNTER = null;
        } else {
            USE_DIRECT_BUFFER_NO_CLEANER = true;
            if (i < 0) {
                if (estimateMaxDirectMemory <= 0) {
                    DIRECT_MEMORY_COUNTER = null;
                } else {
                    DIRECT_MEMORY_COUNTER = new AtomicLong();
                }
                j = estimateMaxDirectMemory;
            } else {
                DIRECT_MEMORY_COUNTER = new AtomicLong();
            }
        }
        instance.debug("-Dio.netty.maxDirectMemory: {} bytes", (Object) Long.valueOf(j));
        if (j >= 1) {
            estimateMaxDirectMemory = j;
        }
        DIRECT_MEMORY_LIMIT = estimateMaxDirectMemory;
        int i2 = SystemPropertyUtil.getInt("io.netty.uninitializedArrayAllocationThreshold", 1024);
        if (javaVersion() < 9 || !PlatformDependent0.hasAllocateArrayMethod()) {
            i2 = -1;
        }
        UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD = i2;
        instance.debug("-Dio.netty.uninitializedArrayAllocationThreshold: {}", (Object) Integer.valueOf(i2));
        if (isAndroid()) {
            CLEANER = r5;
        } else if (javaVersion() >= 9) {
            CLEANER = CleanerJava9.isSupported() ? new CleanerJava9() : r5;
        } else {
            CLEANER = CleanerJava6.isSupported() ? new CleanerJava6() : r5;
        }
        Cleaner cleaner = CLEANER;
        if (cleaner != r5 && !SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false)) {
            z = true;
        }
        DIRECT_BUFFER_PREFERRED = z;
        if (instance.isDebugEnabled()) {
            instance.debug("-Dio.netty.noPreferDirect: {}", (Object) Boolean.valueOf(true ^ z));
        }
        if (cleaner == r5 && !PlatformDependent0.isExplicitNoUnsafe()) {
            instance.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.");
        }
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!addPropertyOsClassifiers(unmodifiableSet, linkedHashSet)) {
            addFilesystemOsClassifiers(unmodifiableSet, linkedHashSet);
        }
        LINUX_OS_CLASSIFIERS = Collections.unmodifiableSet(linkedHashSet);
    }

    private PlatformDependent() {
    }

    /* access modifiers changed from: private */
    public static void addClassifier(Set<String> set, Set<String> set2, String... strArr) {
        for (String str : strArr) {
            if (set.contains(str)) {
                set2.add(str);
            }
        }
    }

    public static void addFilesystemOsClassifiers(final Set<String> set, final Set<String> set2) {
        String[] strArr = OS_RELEASE_FILES;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            final String str = strArr[i];
            final File file = new File(str);
            if (!((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
                    if (r1 != null) goto L_0x0066;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0097 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x009f */
                /* JADX WARNING: Removed duplicated region for block: B:33:0x0088 A[Catch:{ all -> 0x003f }] */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A[SYNTHETIC, Splitter:B:40:0x009c] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Boolean run() {
                    /*
                        r6 = this;
                        java.io.File r0 = r4     // Catch:{ SecurityException -> 0x006a }
                        boolean r0 = r0.exists()     // Catch:{ SecurityException -> 0x006a }
                        if (r0 == 0) goto L_0x00ab
                        r0 = 0
                        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        java.io.File r4 = r4     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        r3.<init>(r4)     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        java.nio.charset.Charset r4 = io.netty.util.CharsetUtil.UTF_8     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                        r1.<init>(r2)     // Catch:{ SecurityException -> 0x0076, IOException -> 0x0071, all -> 0x006c }
                    L_0x001c:
                        java.lang.String r0 = r1.readLine()     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        if (r0 == 0) goto L_0x0066
                        java.lang.String r2 = "ID="
                        boolean r2 = r0.startsWith(r2)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        if (r2 == 0) goto L_0x0046
                        r2 = 3
                        java.lang.String r0 = r0.substring(r2)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.lang.String r0 = io.netty.util.internal.PlatformDependent.normalizeOsReleaseVariableValue(r0)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.util.Set r2 = r6     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.util.Set r3 = r7     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        io.netty.util.internal.PlatformDependent.addClassifier(r2, r3, r0)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        goto L_0x001c
                    L_0x003f:
                        r0 = move-exception
                        goto L_0x009a
                    L_0x0042:
                        r0 = move-exception
                        goto L_0x007b
                    L_0x0044:
                        r0 = move-exception
                        goto L_0x0089
                    L_0x0046:
                        java.lang.String r2 = "ID_LIKE="
                        boolean r2 = r0.startsWith(r2)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        if (r2 == 0) goto L_0x001c
                        r2 = 8
                        java.lang.String r0 = r0.substring(r2)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.lang.String r0 = io.netty.util.internal.PlatformDependent.normalizeOsReleaseVariableValue(r0)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.util.Set r2 = r6     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.util.Set r3 = r7     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        java.lang.String r4 = "[ ]+"
                        java.lang.String[] r0 = r0.split(r4)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        io.netty.util.internal.PlatformDependent.addClassifier(r2, r3, r0)     // Catch:{ SecurityException -> 0x0044, IOException -> 0x0042 }
                        goto L_0x001c
                    L_0x0066:
                        r1.close()     // Catch:{ IOException -> 0x0097 }
                        goto L_0x0097
                    L_0x006a:
                        r0 = move-exception
                        goto L_0x00a0
                    L_0x006c:
                        r1 = move-exception
                        r5 = r1
                        r1 = r0
                        r0 = r5
                        goto L_0x009a
                    L_0x0071:
                        r1 = move-exception
                        r5 = r1
                        r1 = r0
                        r0 = r5
                        goto L_0x007b
                    L_0x0076:
                        r1 = move-exception
                        r5 = r1
                        r1 = r0
                        r0 = r5
                        goto L_0x0089
                    L_0x007b:
                        io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.internal.PlatformDependent.logger     // Catch:{ all -> 0x003f }
                        java.lang.String r3 = "Error while reading content of {}"
                        java.lang.String r4 = r3     // Catch:{ all -> 0x003f }
                        r2.debug(r3, r4, r0)     // Catch:{ all -> 0x003f }
                        if (r1 == 0) goto L_0x0097
                        goto L_0x0066
                    L_0x0089:
                        io.netty.util.internal.logging.InternalLogger r2 = io.netty.util.internal.PlatformDependent.logger     // Catch:{ all -> 0x003f }
                        java.lang.String r3 = "Unable to read {}"
                        java.lang.String r4 = r3     // Catch:{ all -> 0x003f }
                        r2.debug(r3, r4, r0)     // Catch:{ all -> 0x003f }
                        if (r1 == 0) goto L_0x0097
                        goto L_0x0066
                    L_0x0097:
                        java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ SecurityException -> 0x006a }
                        return r6
                    L_0x009a:
                        if (r1 == 0) goto L_0x009f
                        r1.close()     // Catch:{ IOException -> 0x009f }
                    L_0x009f:
                        throw r0     // Catch:{ SecurityException -> 0x006a }
                    L_0x00a0:
                        io.netty.util.internal.logging.InternalLogger r1 = io.netty.util.internal.PlatformDependent.logger
                        java.lang.String r2 = "Unable to check if {} exists"
                        java.lang.String r6 = r3
                        r1.debug(r2, r6, r0)
                    L_0x00ab:
                        java.lang.Boolean r6 = java.lang.Boolean.FALSE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.AnonymousClass4.run():java.lang.Boolean");
                }
            })).booleanValue()) {
                i++;
            } else {
                return;
            }
        }
    }

    public static boolean addPropertyOsClassifiers(Set<String> set, Set<String> set2) {
        String str = SystemPropertyUtil.get("io.netty.osClassifiers");
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return true;
        }
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        if (split.length == 0) {
            throw new IllegalArgumentException("io.netty.osClassifiers" + " property is not empty, but contains no classifiers: " + str);
        } else if (split.length <= 2) {
            for (String str2 : split) {
                addClassifier(set, set2, str2);
            }
            return true;
        } else {
            throw new IllegalArgumentException("io.netty.osClassifiers" + " property contains more than 2 classifiers: " + str);
        }
    }

    public static int addressSize() {
        return ADDRESS_SIZE;
    }

    private static int addressSize0() {
        if (!hasUnsafe()) {
            return -1;
        }
        return PlatformDependent0.addressSize();
    }

    public static long align(long j, int i) {
        return Pow2.align(j, i);
    }

    public static ByteBuffer alignDirectBuffer(ByteBuffer byteBuffer, int i) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Cannot get aligned slice of non-direct byte buffer.");
        } else if (PlatformDependent0.hasAlignSliceMethod()) {
            return PlatformDependent0.alignSlice(byteBuffer, i);
        } else {
            if (hasUnsafe()) {
                long directBufferAddress = directBufferAddress(byteBuffer);
                byteBuffer.position((int) (align(directBufferAddress, i) - directBufferAddress));
                return byteBuffer.slice();
            }
            throw new UnsupportedOperationException("Cannot align direct buffer. Needs either Unsafe or ByteBuffer.alignSlice method available.");
        }
    }

    public static ByteBuffer allocateDirectNoCleaner(int i) {
        incrementMemoryCounter(i);
        try {
            return PlatformDependent0.allocateDirectNoCleaner(i);
        } catch (Throwable th) {
            decrementMemoryCounter(i);
            throwException(th);
            return null;
        }
    }

    public static long allocateMemory(long j) {
        return PlatformDependent0.allocateMemory(j);
    }

    public static byte[] allocateUninitializedArray(int i) {
        int i2 = UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
        return (i2 < 0 || i2 > i) ? new byte[i] : PlatformDependent0.allocateUninitializedArray(i);
    }

    public static int bitMode() {
        return BIT_MODE;
    }

    private static int bitMode0() {
        int i = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
        if (i > 0) {
            logger.debug("-Dio.netty.bitMode: {}", (Object) Integer.valueOf(i));
            return i;
        }
        int i2 = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
        if (i2 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", (Object) Integer.valueOf(i2));
            return i2;
        }
        int i3 = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
        if (i3 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", (Object) Integer.valueOf(i3));
            return i3;
        }
        String str = SystemPropertyUtil.get("os.arch", "");
        Locale locale = Locale.US;
        String trim = str.toLowerCase(locale).trim();
        if ("amd64".equals(trim) || "x86_64".equals(trim)) {
            i3 = 64;
        } else if ("i386".equals(trim) || "i486".equals(trim) || "i586".equals(trim) || "i686".equals(trim)) {
            i3 = 32;
        }
        if (i3 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(i3), trim);
        }
        Matcher matcher = Pattern.compile("([1-9][0-9]+)-?bit").matcher(SystemPropertyUtil.get("java.vm.name", "").toLowerCase(locale));
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 64;
    }

    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    private static long byteArrayBaseOffset0() {
        if (!hasUnsafe()) {
            return -1;
        }
        return PlatformDependent0.byteArrayBaseOffset();
    }

    public static boolean canEnableTcpNoDelayByDefault() {
        return CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    }

    public static void copyMemory(long j, long j2, long j3) {
        PlatformDependent0.copyMemory(j, j2, j3);
    }

    @SuppressJava6Requirement(reason = "Guarded by version check")
    public static File createTempFile(String str, String str2, File file) throws IOException {
        if (javaVersion() >= 7) {
            return file == null ? Files.createTempFile(str, str2, new FileAttribute[0]).toFile() : Files.createTempFile(file.toPath(), str, str2, new FileAttribute[0]).toFile();
        }
        File createTempFile = file == null ? File.createTempFile(str, str2) : File.createTempFile(str, str2, file);
        if (!createTempFile.setReadable(false, false)) {
            throw new IOException("Failed to set permissions on temporary file " + createTempFile);
        } else if (createTempFile.setReadable(true, true)) {
            return createTempFile;
        } else {
            throw new IOException("Failed to set permissions on temporary file " + createTempFile);
        }
    }

    private static void decrementMemoryCounter(int i) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            atomicLong.addAndGet((long) (-i));
        }
    }

    public static ByteBuffer directBuffer(long j, int i) {
        if (PlatformDependent0.hasDirectBufferNoCleanerConstructor()) {
            return PlatformDependent0.newDirectBuffer(j, i);
        }
        throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent0.directBufferAddress(byteBuffer);
    }

    public static boolean directBufferPreferred() {
        return DIRECT_BUFFER_PREFERRED;
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return (!hasUnsafe() || !PlatformDependent0.unalignedAccess()) ? equalsSafe(bArr, i, bArr2, i2, i3) : PlatformDependent0.equals(bArr, i, bArr2, i2, i3);
    }

    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        return (!hasUnsafe() || !PlatformDependent0.unalignedAccess()) ? ConstantTimeUtils.equalsConstantTime(bArr, i, bArr2, i2, i3) : PlatformDependent0.equalsConstantTime(bArr, i, bArr2, i2, i3);
    }

    private static boolean equalsSafe(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if (r0 != 'm') goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long estimateMaxDirectMemory() {
        /*
            r0 = 1
            r1 = 0
            r3 = 0
            java.lang.ClassLoader r4 = getSystemClassLoader()     // Catch:{ all -> 0x003b }
            java.lang.String r5 = "java.vm.name"
            java.lang.String r6 = ""
            java.lang.String r5 = io.netty.util.internal.SystemPropertyUtil.get(r5, r6)     // Catch:{ all -> 0x003c }
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x003c }
            java.lang.String r6 = "ibm j9"
            boolean r6 = r5.startsWith(r6)     // Catch:{ all -> 0x003c }
            if (r6 != 0) goto L_0x003c
            java.lang.String r6 = "eclipse openj9"
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x003c }
            if (r5 != 0) goto L_0x003c
            java.lang.String r5 = "sun.misc.VM"
            java.lang.Class r5 = java.lang.Class.forName(r5, r0, r4)     // Catch:{ all -> 0x003c }
            java.lang.String r6 = "maxDirectMemory"
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r3)     // Catch:{ all -> 0x003c }
            java.lang.Object r5 = r5.invoke(r3, r3)     // Catch:{ all -> 0x003c }
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ all -> 0x003c }
            long r5 = r5.longValue()     // Catch:{ all -> 0x003c }
            goto L_0x003d
        L_0x003b:
            r4 = r3
        L_0x003c:
            r5 = r1
        L_0x003d:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L_0x0042
            return r5
        L_0x0042:
            java.lang.String r7 = "java.lang.management.ManagementFactory"
            java.lang.Class r7 = java.lang.Class.forName(r7, r0, r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = "java.lang.management.RuntimeMXBean"
            java.lang.Class r4 = java.lang.Class.forName(r8, r0, r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = "getRuntimeMXBean"
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r8, r3)     // Catch:{ all -> 0x00b7 }
            java.lang.Object r7 = r7.invoke(r3, r3)     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = "getInputArguments"
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r8, r3)     // Catch:{ all -> 0x00b7 }
            java.lang.Object r3 = r4.invoke(r7, r3)     // Catch:{ all -> 0x00b7 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x00b7 }
            int r4 = r3.size()     // Catch:{ all -> 0x00b7 }
            int r4 = r4 - r0
        L_0x0069:
            if (r4 < 0) goto L_0x00b7
            java.util.regex.Pattern r7 = MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN     // Catch:{ all -> 0x00b7 }
            java.lang.Object r8 = r3.get(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x00b7 }
            java.util.regex.Matcher r7 = r7.matcher(r8)     // Catch:{ all -> 0x00b7 }
            boolean r8 = r7.matches()     // Catch:{ all -> 0x00b7 }
            if (r8 != 0) goto L_0x0080
            int r4 = r4 + -1
            goto L_0x0069
        L_0x0080:
            java.lang.String r0 = r7.group(r0)     // Catch:{ all -> 0x00b7 }
            long r5 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x00b7 }
            r0 = 2
            java.lang.String r0 = r7.group(r0)     // Catch:{ all -> 0x00b7 }
            r3 = 0
            char r0 = r0.charAt(r3)     // Catch:{ all -> 0x00b7 }
            r3 = 71
            if (r0 == r3) goto L_0x00b3
            r3 = 75
            if (r0 == r3) goto L_0x00b0
            r3 = 77
            if (r0 == r3) goto L_0x00ab
            r3 = 103(0x67, float:1.44E-43)
            if (r0 == r3) goto L_0x00b3
            r3 = 107(0x6b, float:1.5E-43)
            if (r0 == r3) goto L_0x00b0
            r3 = 109(0x6d, float:1.53E-43)
            if (r0 == r3) goto L_0x00ab
            goto L_0x00b7
        L_0x00ab:
            r3 = 1048576(0x100000, double:5.180654E-318)
        L_0x00ae:
            long r5 = r5 * r3
            goto L_0x00b7
        L_0x00b0:
            r3 = 1024(0x400, double:5.06E-321)
            goto L_0x00ae
        L_0x00b3:
            r3 = 1073741824(0x40000000, double:5.304989477E-315)
            goto L_0x00ae
        L_0x00b7:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00cf
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            long r5 = r0.maxMemory()
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "maxDirectMemory: {} bytes (maybe)"
            r0.debug((java.lang.String) r2, (java.lang.Object) r1)
            goto L_0x00da
        L_0x00cf:
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "maxDirectMemory: {} bytes"
            r0.debug((java.lang.String) r2, (java.lang.Object) r1)
        L_0x00da:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.estimateMaxDirectMemory():long");
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        CLEANER.freeDirectBuffer(byteBuffer);
    }

    public static void freeDirectNoCleaner(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        PlatformDependent0.freeMemory(PlatformDependent0.directBufferAddress(byteBuffer));
        decrementMemoryCounter(capacity);
    }

    public static void freeMemory(long j) {
        PlatformDependent0.freeMemory(j);
    }

    public static byte getByte(long j) {
        return PlatformDependent0.getByte(j);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return PlatformDependent0.getClassLoader(cls);
    }

    public static ClassLoader getContextClassLoader() {
        return PlatformDependent0.getContextClassLoader();
    }

    public static int getInt(Object obj, long j) {
        return PlatformDependent0.getInt(obj, j);
    }

    private static int getIntSafe(byte[] bArr, int i) {
        byte b;
        int i2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            b = (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            i2 = bArr[i + 3] & 255;
        } else {
            b = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            i2 = bArr[i + 3] << 24;
        }
        return i2 | b;
    }

    public static int getIntVolatile(long j) {
        return PlatformDependent0.getIntVolatile(j);
    }

    public static long getLong(long j) {
        return PlatformDependent0.getLong(j);
    }

    private static long getLongSafe(byte[] bArr, int i) {
        long j;
        long j2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            long j3 = (((long) bArr[i + 1]) & 255) << 48;
            j = ((((long) bArr[i + 6]) & 255) << 8) | j3 | (((long) bArr[i]) << 56) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16);
            j2 = ((long) bArr[i + 7]) & 255;
        } else {
            j = ((((long) bArr[i + 1]) & 255) << 8) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
            j2 = ((long) bArr[i + 7]) << 56;
        }
        return j2 | j;
    }

    public static Object getObject(Object obj, long j) {
        return PlatformDependent0.getObject(obj, j);
    }

    public static short getShort(long j) {
        return PlatformDependent0.getShort(j);
    }

    private static short getShortSafe(byte[] bArr, int i) {
        int i2;
        int i3;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i2 = bArr[i] << 8;
            i3 = bArr[i + 1] & 255;
        } else {
            i2 = bArr[i] & 255;
            i3 = bArr[i + 1] << 8;
        }
        return (short) (i3 | i2);
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    public static boolean hasAlignDirectByteBuffer() {
        return hasUnsafe() || PlatformDependent0.hasAlignSliceMethod();
    }

    public static boolean hasDirectBufferNoCleanerConstructor() {
        return PlatformDependent0.hasDirectBufferNoCleanerConstructor();
    }

    public static boolean hasUnsafe() {
        return UNSAFE_UNAVAILABILITY_CAUSE == null;
    }

    public static int hashCodeAscii(byte[] bArr, int i, int i2) {
        if (!hasUnsafe() || !PlatformDependent0.unalignedAccess()) {
            return hashCodeAsciiSafe(bArr, i, i2);
        }
        return PlatformDependent0.hashCodeAscii(bArr, i, i2);
    }

    private static int hashCodeAsciiCompute(CharSequence charSequence, int i, int i2) {
        int hashCodeAsciiSanitizeInt;
        int hashCodeAsciiSanitizeInt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            hashCodeAsciiSanitizeInt = (i2 * -862048943) + (hashCodeAsciiSanitizeInt(charSequence, i + 4) * 461845907);
            hashCodeAsciiSanitizeInt2 = hashCodeAsciiSanitizeInt(charSequence, i);
        } else {
            hashCodeAsciiSanitizeInt = (i2 * -862048943) + (hashCodeAsciiSanitizeInt(charSequence, i) * 461845907);
            hashCodeAsciiSanitizeInt2 = hashCodeAsciiSanitizeInt(charSequence, i + 4);
        }
        return hashCodeAsciiSanitizeInt + hashCodeAsciiSanitizeInt2;
    }

    public static int hashCodeAsciiSafe(byte[] bArr, int i, int i2) {
        int i3;
        int hashCodeAsciiSanitize;
        int i4 = i2 & 7;
        int i5 = i + i4;
        int i6 = -1028477387;
        for (int i7 = (i - 8) + i2; i7 >= i5; i7 -= 8) {
            i6 = PlatformDependent0.hashCodeAsciiCompute(getLongSafe(bArr, i7), i6);
        }
        switch (i4) {
            case 1:
                i3 = i6 * -862048943;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(bArr[i]);
                break;
            case 2:
                i3 = i6 * -862048943;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i));
                break;
            case 3:
                i3 = ((i6 * -862048943) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i])) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i + 1));
                break;
            case 4:
                i3 = i6 * -862048943;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i));
                break;
            case 5:
                i3 = ((i6 * -862048943) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i])) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 1));
                break;
            case 6:
                i3 = ((i6 * -862048943) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i))) * 461845907;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 2));
                break;
            case 7:
                i3 = ((((i6 * -862048943) + PlatformDependent0.hashCodeAsciiSanitize(bArr[i])) * 461845907) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i + 1))) * -862048943;
                hashCodeAsciiSanitize = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 3));
                break;
            default:
                return i6;
        }
        return i3 + hashCodeAsciiSanitize;
    }

    private static int hashCodeAsciiSanitizeByte(char c) {
        return c & 31;
    }

    private static int hashCodeAsciiSanitizeInt(CharSequence charSequence, int i) {
        char charAt;
        int charAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            charAt = (charSequence.charAt(i + 3) & 31) | ((charSequence.charAt(i + 2) & 31) << 8) | ((charSequence.charAt(i + 1) & 31) << 16);
            charAt2 = (charSequence.charAt(i) & 31) << 24;
        } else {
            charAt = ((charSequence.charAt(i + 3) & 31) << 24) | ((charSequence.charAt(i + 2) & 31) << 16) | ((charSequence.charAt(i + 1) & 31) << 8);
            charAt2 = charSequence.charAt(i) & 31;
        }
        return charAt2 | charAt;
    }

    private static int hashCodeAsciiSanitizeShort(CharSequence charSequence, int i) {
        int charAt;
        int charAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            charAt = charSequence.charAt(i + 1) & 31;
            charAt2 = (charSequence.charAt(i) & 31) << 8;
        } else {
            charAt = (charSequence.charAt(i + 1) & 31) << 8;
            charAt2 = charSequence.charAt(i) & 31;
        }
        return charAt2 | charAt;
    }

    private static void incrementMemoryCounter(int i) {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            long j = (long) i;
            long addAndGet = atomicLong.addAndGet(j);
            long j2 = DIRECT_MEMORY_LIMIT;
            if (addAndGet > j2) {
                atomicLong.addAndGet((long) (-i));
                throw new OutOfDirectMemoryError("failed to allocate " + i + " byte(s) of direct memory (used: " + (addAndGet - j) + ", max: " + j2 + ')');
            }
        }
    }

    public static boolean isAndroid() {
        return PlatformDependent0.isAndroid();
    }

    public static boolean isIkvmDotNet() {
        return IS_IVKVM_DOT_NET;
    }

    private static boolean isIkvmDotNet0() {
        return SystemPropertyUtil.get("java.vm.name", "").toUpperCase(Locale.US).equals("IKVM.NET");
    }

    public static boolean isJ9Jvm() {
        return IS_J9_JVM;
    }

    private static boolean isJ9Jvm0() {
        String lowerCase = SystemPropertyUtil.get("java.vm.name", "").toLowerCase();
        return lowerCase.startsWith("ibm j9") || lowerCase.startsWith("eclipse openj9");
    }

    public static boolean isOsx() {
        return IS_OSX;
    }

    private static boolean isOsx0() {
        boolean equals = "osx".equals(NORMALIZED_OS);
        if (equals) {
            logger.debug("Platform: MacOS");
        }
        return equals;
    }

    public static boolean isUnaligned() {
        return PlatformDependent0.isUnaligned();
    }

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    private static boolean isWindows0() {
        boolean equals = "windows".equals(NORMALIZED_OS);
        if (equals) {
            logger.debug("Platform: Windows");
        }
        return equals;
    }

    public static boolean isZero(byte[] bArr, int i, int i2) {
        return (!hasUnsafe() || !PlatformDependent0.unalignedAccess()) ? isZeroSafe(bArr, i, i2) : PlatformDependent0.isZero(bArr, i, i2);
    }

    private static boolean isZeroSafe(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            if (bArr[i] != 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int javaVersion() {
        return PlatformDependent0.javaVersion();
    }

    public static long maxDirectMemory() {
        return DIRECT_MEMORY_LIMIT;
    }

    public static boolean maybeSuperUser() {
        return MAYBE_SUPER_USER;
    }

    private static boolean maybeSuperUser0() {
        String str = SystemPropertyUtil.get("user.name");
        return isWindows() ? "Administrator".equals(str) : "root".equals(str) || "toor".equals(str);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <C> Deque<C> newConcurrentDeque() {
        return javaVersion() < 7 ? new LinkedBlockingDeque() : new ConcurrentLinkedDeque();
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap();
    }

    public static <T> Queue<T> newFixedMpscQueue(int i) {
        return hasUnsafe() ? new MpscArrayQueue(i) : new MpscAtomicArrayQueue(i);
    }

    public static LongCounter newLongCounter() {
        return javaVersion() >= 8 ? new LongAdderCounter() : new AtomicLongCounter();
    }

    public static <T> Queue<T> newMpscQueue() {
        return Mpsc.newMpscQueue();
    }

    public static <T> Queue<T> newSpscQueue() {
        return hasUnsafe() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue();
    }

    private static String normalize(String str) {
        return str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private static String normalizeArch(String str) {
        String normalize = normalize(str);
        return normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$") ? "x86_64" : normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$") ? "x86_32" : normalize.matches("^(ia64|itanium64)$") ? "itanium_64" : normalize.matches("^(sparc|sparc32)$") ? "sparc_32" : normalize.matches("^(sparcv9|sparc64)$") ? "sparc_64" : normalize.matches("^(arm|arm32)$") ? "arm_32" : "aarch64".equals(normalize) ? "aarch_64" : normalize.matches("^(ppc|ppc32)$") ? "ppc_32" : "ppc64".equals(normalize) ? "ppc_64" : "ppc64le".equals(normalize) ? "ppcle_64" : "s390".equals(normalize) ? "s390_32" : "s390x".equals(normalize) ? "s390_64" : "loongarch64".equals(normalize) ? "loongarch_64" : StarryNetConstant.DEVICE_NAME_UNKNOWN;
    }

    private static String normalizeOs(String str) {
        String normalize = normalize(str);
        if (normalize.startsWith("aix")) {
            return "aix";
        }
        if (normalize.startsWith("hpux")) {
            return "hpux";
        }
        if (normalize.startsWith("os400") && (normalize.length() <= 5 || !Character.isDigit(normalize.charAt(5)))) {
            return "os400";
        }
        if (normalize.startsWith("linux")) {
            return "linux";
        }
        String str2 = "osx";
        if (!normalize.startsWith("macosx") && !normalize.startsWith(str2) && !normalize.startsWith("darwin")) {
            if (normalize.startsWith("freebsd")) {
                return "freebsd";
            }
            if (normalize.startsWith("openbsd")) {
                return "openbsd";
            }
            if (normalize.startsWith("netbsd")) {
                return "netbsd";
            }
            str2 = "sunos";
            if (!normalize.startsWith("solaris") && !normalize.startsWith(str2)) {
                return normalize.startsWith("windows") ? "windows" : StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
        }
        return str2;
    }

    /* access modifiers changed from: private */
    public static String normalizeOsReleaseVariableValue(String str) {
        return str.trim().replaceAll("[\"']", "");
    }

    public static String normalizedArch() {
        return NORMALIZED_ARCH;
    }

    public static Set<String> normalizedLinuxClassifiers() {
        return LINUX_OS_CLASSIFIERS;
    }

    public static String normalizedOs() {
        return NORMALIZED_OS;
    }

    public static long objectFieldOffset(Field field) {
        return PlatformDependent0.objectFieldOffset(field);
    }

    public static void putByte(long j, byte b) {
        PlatformDependent0.putByte(j, b);
    }

    public static void putInt(long j, int i) {
        PlatformDependent0.putInt(j, i);
    }

    public static void putIntOrdered(long j, int i) {
        PlatformDependent0.putIntOrdered(j, i);
    }

    public static void putLong(long j, long j2) {
        PlatformDependent0.putLong(j, j2);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        PlatformDependent0.putObject(obj, j, obj2);
    }

    public static void putShort(long j, short s) {
        PlatformDependent0.putShort(j, s);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i) {
        int capacity = i - byteBuffer.capacity();
        incrementMemoryCounter(capacity);
        try {
            return PlatformDependent0.reallocateDirectNoCleaner(byteBuffer, i);
        } catch (Throwable th) {
            decrementMemoryCounter(capacity);
            throwException(th);
            return null;
        }
    }

    public static long reallocateMemory(long j, long j2) {
        return PlatformDependent0.reallocateMemory(j, j2);
    }

    public static void safeConstructPutInt(Object obj, long j, int i) {
        PlatformDependent0.safeConstructPutInt(obj, j, i);
    }

    public static void setMemory(byte[] bArr, int i, long j, byte b) {
        PlatformDependent0.setMemory(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), j, b);
    }

    public static Random threadLocalRandom() {
        return RANDOM_PROVIDER.current();
    }

    public static void throwException(Throwable th) {
        if (hasUnsafe()) {
            PlatformDependent0.throwException(th);
        } else {
            throwException0(th);
        }
    }

    private static <E extends Throwable> void throwException0(Throwable th) throws Throwable {
        throw th;
    }

    public static File tmpdir() {
        return TMPDIR;
    }

    private static File tmpdir0() {
        try {
            File directory = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
            if (directory != null) {
                logger.debug("-Dio.netty.tmpdir: {}", (Object) directory);
                return directory;
            }
            File directory2 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
            if (directory2 != null) {
                logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", (Object) directory2);
                return directory2;
            }
            if (isWindows()) {
                File directory3 = toDirectory(System.getenv("TEMP"));
                if (directory3 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%TEMP%)", (Object) directory3);
                    return directory3;
                }
                String str = System.getenv("USERPROFILE");
                if (str != null) {
                    File directory4 = toDirectory(str + "\\AppData\\Local\\Temp");
                    if (directory4 != null) {
                        logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", (Object) directory4);
                        return directory4;
                    }
                    File directory5 = toDirectory(str + "\\Local Settings\\Temp");
                    if (directory5 != null) {
                        logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", (Object) directory5);
                        return directory5;
                    }
                }
            } else {
                File directory6 = toDirectory(System.getenv("TMPDIR"));
                if (directory6 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", (Object) directory6);
                    return directory6;
                }
            }
            File file = isWindows() ? new File("C:\\Windows\\Temp") : new File("/tmp");
            logger.warn("Failed to get the temporary directory; falling back to: {}", (Object) file);
            return file;
        } catch (Throwable unused) {
        }
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            return file.getAbsoluteFile();
        } catch (Exception unused) {
            return file;
        }
    }

    private static Throwable unsafeUnavailabilityCause0() {
        if (isAndroid()) {
            logger.debug("sun.misc.Unsafe: unavailable (Android)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (Android)");
        } else if (isIkvmDotNet()) {
            logger.debug("sun.misc.Unsafe: unavailable (IKVM.NET)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (IKVM.NET)");
        } else {
            Throwable unsafeUnavailabilityCause = PlatformDependent0.getUnsafeUnavailabilityCause();
            if (unsafeUnavailabilityCause != null) {
                return unsafeUnavailabilityCause;
            }
            try {
                boolean hasUnsafe = PlatformDependent0.hasUnsafe();
                logger.debug("sun.misc.Unsafe: {}", (Object) hasUnsafe ? "available" : "unavailable");
                if (hasUnsafe) {
                    return null;
                }
                return PlatformDependent0.getUnsafeUnavailabilityCause();
            } catch (Throwable th) {
                logger.trace("Could not determine if Unsafe is available", th);
                return new UnsupportedOperationException("Could not determine if Unsafe is available", th);
            }
        }
    }

    public static boolean useDirectBufferNoCleaner() {
        return USE_DIRECT_BUFFER_NO_CLEANER;
    }

    public static long usedDirectMemory() {
        AtomicLong atomicLong = DIRECT_MEMORY_COUNTER;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return -1;
    }

    public static final class Mpsc {
        private static final boolean USE_MPSC_CHUNKED_ARRAY_QUEUE;

        static {
            if ((PlatformDependent.hasUnsafe() ? AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    return UnsafeAccess.UNSAFE;
                }
            }) : null) == null) {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                USE_MPSC_CHUNKED_ARRAY_QUEUE = false;
                return;
            }
            PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: available");
            USE_MPSC_CHUNKED_ARRAY_QUEUE = true;
        }

        private Mpsc() {
        }

        public static <T> Queue<T> newChunkedMpscQueue(int i, int i2) {
            return USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscChunkedArrayQueue(i, i2) : new MpscChunkedAtomicArrayQueue(i, i2);
        }

        public static <T> Queue<T> newMpscQueue(int i) {
            return newChunkedMpscQueue(1024, Math.max(Math.min(i, 1073741824), 2048));
        }

        public static <T> Queue<T> newMpscQueue() {
            return USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscUnboundedArrayQueue(1024) : new MpscUnboundedAtomicArrayQueue(1024);
        }
    }

    public static void copyMemory(byte[] bArr, int i, long j, long j2) {
        PlatformDependent0.copyMemory(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), (Object) null, j, j2);
    }

    public static byte getByte(byte[] bArr, int i) {
        return PlatformDependent0.getByte(bArr, i);
    }

    public static int getInt(long j) {
        return PlatformDependent0.getInt(j);
    }

    public static long getLong(byte[] bArr, int i) {
        return PlatformDependent0.getLong(bArr, i);
    }

    public static short getShort(byte[] bArr, int i) {
        return PlatformDependent0.getShort(bArr, i);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i) {
        return new ConcurrentHashMap(i);
    }

    public static <T> Queue<T> newMpscQueue(int i) {
        return Mpsc.newMpscQueue(i);
    }

    public static void putByte(byte[] bArr, int i, byte b) {
        PlatformDependent0.putByte(bArr, i, b);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        PlatformDependent0.putInt(bArr, i, i2);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        PlatformDependent0.putLong(bArr, i, j);
    }

    public static void putShort(byte[] bArr, int i, short s) {
        PlatformDependent0.putShort(bArr, i, s);
    }

    public static void setMemory(long j, long j2, byte b) {
        PlatformDependent0.setMemory(j, j2, b);
    }

    public static void copyMemory(byte[] bArr, int i, byte[] bArr2, int i2, long j) {
        long j2 = BYTE_ARRAY_BASE_OFFSET;
        PlatformDependent0.copyMemory(bArr, j2 + ((long) i), bArr2, j2 + ((long) i2), j);
    }

    public static byte getByte(byte[] bArr, long j) {
        return PlatformDependent0.getByte(bArr, j);
    }

    public static int getInt(byte[] bArr, int i) {
        return PlatformDependent0.getInt(bArr, i);
    }

    public static long getLong(long[] jArr, long j) {
        return PlatformDependent0.getLong(jArr, j);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i, float f) {
        return new ConcurrentHashMap(i, f);
    }

    public static <T> Queue<T> newMpscQueue(int i, int i2) {
        return Mpsc.newChunkedMpscQueue(i, i2);
    }

    public static void putByte(Object obj, long j, byte b) {
        PlatformDependent0.putByte(obj, j, b);
    }

    public static void copyMemory(long j, byte[] bArr, int i, long j2) {
        PlatformDependent0.copyMemory((Object) null, j, bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), j2);
    }

    public static int getInt(int[] iArr, long j) {
        return PlatformDependent0.getInt(iArr, j);
    }

    public static int hashCodeAscii(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = length & 7;
        int i3 = -1028477387;
        if (length >= 32) {
            for (int i4 = length - 8; i4 >= i2; i4 -= 8) {
                i3 = hashCodeAsciiCompute(charSequence, i4, i3);
            }
        } else if (length >= 8) {
            i3 = hashCodeAsciiCompute(charSequence, length - 8, -1028477387);
            if (length >= 16) {
                i3 = hashCodeAsciiCompute(charSequence, length - 16, i3);
                if (length >= 24) {
                    i3 = hashCodeAsciiCompute(charSequence, length - 24, i3);
                }
            }
        }
        if (i2 == 0) {
            return i3;
        }
        boolean z = true;
        int i5 = -862048943;
        if (((i2 != 2) & (i2 != 4)) && (i2 != 6)) {
            i3 = (i3 * -862048943) + hashCodeAsciiSanitizeByte(charSequence.charAt(0));
            i = 1;
        } else {
            i = 0;
        }
        if (((i2 != 1) & (i2 != 4)) && (i2 != 5)) {
            i3 = (i3 * (i == 0 ? -862048943 : 461845907)) + PlatformDependent0.hashCodeAsciiSanitize(hashCodeAsciiSanitizeShort(charSequence, i));
            i += 2;
        }
        if (i2 < 4) {
            return i3;
        }
        boolean z2 = i == 0;
        if (i != 3) {
            z = false;
        }
        if (!z2 && !z) {
            i5 = 461845907;
        }
        return (i3 * i5) + hashCodeAsciiSanitizeInt(charSequence, i);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i, float f, int i2) {
        return new ConcurrentHashMap(i, f, i2);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(Map<? extends K, ? extends V> map) {
        return new ConcurrentHashMap(map);
    }
}
