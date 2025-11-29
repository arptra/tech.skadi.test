package io.netty.buffer;

import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;

public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    static final int CALCULATE_THRESHOLD = 4194304;
    static final int DEFAULT_INITIAL_CAPACITY = 256;
    static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    /* renamed from: io.netty.buffer.AbstractByteBufAllocator$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.util.ResourceLeakDetector$Level[] r0 = io.netty.util.ResourceLeakDetector.Level.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$util$ResourceLeakDetector$Level = r0
                io.netty.util.ResourceLeakDetector$Level r1 = io.netty.util.ResourceLeakDetector.Level.SIMPLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$util$ResourceLeakDetector$Level     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.util.ResourceLeakDetector$Level r1 = io.netty.util.ResourceLeakDetector.Level.ADVANCED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$util$ResourceLeakDetector$Level     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.util.ResourceLeakDetector$Level r1 = io.netty.util.ResourceLeakDetector.Level.PARANOID     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.AbstractByteBufAllocator.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, "toLeakAwareBuffer");
    }

    public AbstractByteBufAllocator() {
        this(false);
    }

    public static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf) {
        ByteBuf simpleLeakAwareByteBuf;
        ResourceLeakTracker<ByteBuf> track;
        int i = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i == 1) {
            ResourceLeakTracker<ByteBuf> track2 = AbstractByteBuf.leakDetector.track(byteBuf);
            if (track2 == null) {
                return byteBuf;
            }
            simpleLeakAwareByteBuf = new SimpleLeakAwareByteBuf(byteBuf, track2);
        } else if ((i != 2 && i != 3) || (track = AbstractByteBuf.leakDetector.track(byteBuf)) == null) {
            return byteBuf;
        } else {
            simpleLeakAwareByteBuf = new AdvancedLeakAwareByteBuf(byteBuf, track);
        }
        return simpleLeakAwareByteBuf;
    }

    private static void validate(int i, int i2) {
        ObjectUtil.checkPositiveOrZero(i, "initialCapacity");
        if (i > i2) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        }
    }

    public ByteBuf buffer() {
        if (this.directByDefault) {
            return directBuffer();
        }
        return heapBuffer();
    }

    public int calculateNewCapacity(int i, int i2) {
        ObjectUtil.checkPositiveOrZero(i, "minNewCapacity");
        if (i > i2) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        } else if (i == 4194304) {
            return 4194304;
        } else {
            if (i <= 4194304) {
                return Math.min(MathUtil.findNextPositivePowerOfTwo(Math.max(i, 64)), i2);
            }
            int i3 = (i / 4194304) * 4194304;
            return i3 > i2 - 4194304 ? i2 : i3 + 4194304;
        }
    }

    public CompositeByteBuf compositeBuffer() {
        if (this.directByDefault) {
            return compositeDirectBuffer();
        }
        return compositeHeapBuffer();
    }

    public CompositeByteBuf compositeDirectBuffer() {
        return compositeDirectBuffer(16);
    }

    public CompositeByteBuf compositeHeapBuffer() {
        return compositeHeapBuffer(16);
    }

    public ByteBuf directBuffer() {
        return directBuffer(256, Integer.MAX_VALUE);
    }

    public ByteBuf heapBuffer() {
        return heapBuffer(256, Integer.MAX_VALUE);
    }

    public ByteBuf ioBuffer() {
        if (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) {
            return directBuffer(256);
        }
        return heapBuffer(256);
    }

    public abstract ByteBuf newDirectBuffer(int i, int i2);

    public abstract ByteBuf newHeapBuffer(int i, int i2);

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(directByDefault: " + this.directByDefault + ')';
    }

    public AbstractByteBufAllocator(boolean z) {
        this.directByDefault = z && PlatformDependent.hasUnsafe();
        this.emptyBuf = new EmptyByteBuf(this);
    }

    public CompositeByteBuf compositeDirectBuffer(int i) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, true, i));
    }

    public CompositeByteBuf compositeHeapBuffer(int i) {
        return toLeakAwareBuffer(new CompositeByteBuf(this, false, i));
    }

    public ByteBuf directBuffer(int i) {
        return directBuffer(i, Integer.MAX_VALUE);
    }

    public ByteBuf heapBuffer(int i) {
        return heapBuffer(i, Integer.MAX_VALUE);
    }

    public ByteBuf directBuffer(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.emptyBuf;
        }
        validate(i, i2);
        return newDirectBuffer(i, i2);
    }

    public ByteBuf heapBuffer(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.emptyBuf;
        }
        validate(i, i2);
        return newHeapBuffer(i, i2);
    }

    public ByteBuf buffer(int i) {
        if (this.directByDefault) {
            return directBuffer(i);
        }
        return heapBuffer(i);
    }

    public CompositeByteBuf compositeBuffer(int i) {
        if (this.directByDefault) {
            return compositeDirectBuffer(i);
        }
        return compositeHeapBuffer(i);
    }

    public ByteBuf ioBuffer(int i) {
        if (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) {
            return directBuffer(i);
        }
        return heapBuffer(i);
    }

    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf) {
        CompositeByteBuf simpleLeakAwareCompositeByteBuf;
        ResourceLeakTracker<ByteBuf> track;
        int i = AnonymousClass1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()];
        if (i == 1) {
            ResourceLeakTracker<ByteBuf> track2 = AbstractByteBuf.leakDetector.track(compositeByteBuf);
            if (track2 == null) {
                return compositeByteBuf;
            }
            simpleLeakAwareCompositeByteBuf = new SimpleLeakAwareCompositeByteBuf(compositeByteBuf, track2);
        } else if ((i != 2 && i != 3) || (track = AbstractByteBuf.leakDetector.track(compositeByteBuf)) == null) {
            return compositeByteBuf;
        } else {
            simpleLeakAwareCompositeByteBuf = new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf, track);
        }
        return simpleLeakAwareCompositeByteBuf;
    }

    public ByteBuf buffer(int i, int i2) {
        if (this.directByDefault) {
            return directBuffer(i, i2);
        }
        return heapBuffer(i, i2);
    }

    public ByteBuf ioBuffer(int i, int i2) {
        if (PlatformDependent.hasUnsafe() || isDirectBufferPooled()) {
            return directBuffer(i, i2);
        }
        return heapBuffer(i, i2);
    }
}
