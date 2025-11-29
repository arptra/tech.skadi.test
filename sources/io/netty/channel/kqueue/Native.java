package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Unix;
import io.netty.util.internal.ClassInitializerUtil;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class Native {
    private static final int CONNECT_DATA_IDEMPOTENT;
    private static final int CONNECT_RESUME_ON_READ_WRITE;
    static final int CONNECT_TCP_FASTOPEN;
    static final short EVFILT_READ = KQueueStaticallyReferencedJniMethods.evfiltRead();
    static final short EVFILT_SOCK = KQueueStaticallyReferencedJniMethods.evfiltSock();
    static final short EVFILT_USER = KQueueStaticallyReferencedJniMethods.evfiltUser();
    static final short EVFILT_WRITE = KQueueStaticallyReferencedJniMethods.evfiltWrite();
    static final short EV_ADD;
    static final short EV_ADD_CLEAR_ENABLE;
    static final short EV_CLEAR;
    static final short EV_DELETE;
    static final short EV_DELETE_DISABLE;
    static final short EV_DISABLE;
    static final short EV_ENABLE;
    static final short EV_EOF = KQueueStaticallyReferencedJniMethods.evEOF();
    static final short EV_ERROR = KQueueStaticallyReferencedJniMethods.evError();
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_CLIENT = isSupportingFastOpenClient();
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_SERVER = isSupportingFastOpenServer();
    static final int NOTE_CONNRESET;
    static final int NOTE_DISCONNECTED;
    static final int NOTE_RDHUP;
    static final int NOTE_READCLOSED;
    private static final InternalLogger logger;

    static {
        Class<Native> cls = Native.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        ClassInitializerUtil.tryLoadClasses(cls, PeerCredentials.class, DefaultFileRegion.class, FileChannel.class, FileDescriptor.class);
        try {
            sizeofKEvent();
        } catch (UnsatisfiedLinkError unused) {
            loadNativeLibrary();
        }
        Unix.registerInternal(new Runnable() {
            public void run() {
                int unused = Native.registerUnix();
            }
        });
        short evAdd = KQueueStaticallyReferencedJniMethods.evAdd();
        EV_ADD = evAdd;
        short evEnable = KQueueStaticallyReferencedJniMethods.evEnable();
        EV_ENABLE = evEnable;
        short evDisable = KQueueStaticallyReferencedJniMethods.evDisable();
        EV_DISABLE = evDisable;
        short evDelete = KQueueStaticallyReferencedJniMethods.evDelete();
        EV_DELETE = evDelete;
        short evClear = KQueueStaticallyReferencedJniMethods.evClear();
        EV_CLEAR = evClear;
        short noteReadClosed = KQueueStaticallyReferencedJniMethods.noteReadClosed();
        NOTE_READCLOSED = noteReadClosed;
        short noteConnReset = KQueueStaticallyReferencedJniMethods.noteConnReset();
        NOTE_CONNRESET = noteConnReset;
        short noteDisconnected = KQueueStaticallyReferencedJniMethods.noteDisconnected();
        NOTE_DISCONNECTED = noteDisconnected;
        NOTE_RDHUP = noteReadClosed | noteConnReset | noteDisconnected;
        EV_ADD_CLEAR_ENABLE = (short) (evAdd | evClear | evEnable);
        EV_DELETE_DISABLE = (short) (evDelete | evDisable);
        int connectResumeOnReadWrite = KQueueStaticallyReferencedJniMethods.connectResumeOnReadWrite();
        CONNECT_RESUME_ON_READ_WRITE = connectResumeOnReadWrite;
        int connectDataIdempotent = KQueueStaticallyReferencedJniMethods.connectDataIdempotent();
        CONNECT_DATA_IDEMPOTENT = connectDataIdempotent;
        CONNECT_TCP_FASTOPEN = connectResumeOnReadWrite | connectDataIdempotent;
    }

    private Native() {
    }

    private static boolean isSupportingFastOpenClient() {
        try {
            return KQueueStaticallyReferencedJniMethods.fastOpenClient() == 1;
        } catch (Exception e) {
            logger.debug("Failed to probe fastOpenClient sysctl, assuming client-side TCP FastOpen cannot be used.", (Throwable) e);
            return false;
        }
    }

    private static boolean isSupportingFastOpenServer() {
        try {
            return KQueueStaticallyReferencedJniMethods.fastOpenServer() == 1;
        } catch (Exception e) {
            logger.debug("Failed to probe fastOpenServer sysctl, assuming server-side TCP FastOpen cannot be used.", (Throwable) e);
            return false;
        }
    }

    public static native int keventAddUserEvent(int i, int i2);

    public static native int keventTriggerUserEvent(int i, int i2);

    private static native int keventWait(int i, long j, int i2, long j2, int i3, int i4, int i5);

    public static int keventWait(int i, KQueueEventArray kQueueEventArray, KQueueEventArray kQueueEventArray2, int i2, int i3) throws IOException {
        int keventWait = keventWait(i, kQueueEventArray.memoryAddress(), kQueueEventArray.size(), kQueueEventArray2.memoryAddress(), kQueueEventArray2.capacity(), i2, i3);
        if (keventWait >= 0) {
            return keventWait;
        }
        throw Errors.newIOException("kevent", keventWait);
    }

    private static native int kqueueCreate();

    private static void loadNativeLibrary() {
        String normalizedOs = PlatformDependent.normalizedOs();
        if ("osx".equals(normalizedOs) || normalizedOs.contains("bsd")) {
            String str = "netty_transport_native_kqueue" + '_' + PlatformDependent.normalizedArch();
            ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
            try {
                NativeLibraryLoader.load(str, classLoader);
            } catch (UnsatisfiedLinkError e) {
                try {
                    NativeLibraryLoader.load("netty_transport_native_kqueue", classLoader);
                    logger.debug("Failed to load {}", str, e);
                } catch (UnsatisfiedLinkError e2) {
                    ThrowableUtil.addSuppressed((Throwable) e, (Throwable) e2);
                    throw e;
                }
            }
        } else {
            throw new IllegalStateException("Only supported on OSX/BSD");
        }
    }

    public static io.netty.channel.unix.FileDescriptor newKQueue() {
        return new io.netty.channel.unix.FileDescriptor(kqueueCreate());
    }

    public static native int offsetofKEventFFlags();

    public static native int offsetofKEventFilter();

    public static native int offsetofKEventFlags();

    public static native int offsetofKEventIdent();

    public static native int offsetofKeventData();

    /* access modifiers changed from: private */
    public static native int registerUnix();

    public static native int sizeofKEvent();
}
