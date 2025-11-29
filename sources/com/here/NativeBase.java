package com.here;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class NativeBase {
    private static final Logger LOGGER = Logger.getLogger(NativeBase.class.getName());
    /* access modifiers changed from: private */
    public static final Set<Reference<?>> REFERENCES = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final ReferenceQueue<NativeBase> REFERENCE_QUEUE = new ReferenceQueue<>();
    private final long nativeHandle;

    public static class DisposableReference extends PhantomReference<NativeBase> {
        private final Disposer disposer;
        private final long nativePointer;

        public void dispose() {
            NativeBase.REFERENCES.remove(this);
            this.disposer.disposeNative(this.nativePointer);
        }

        private DisposableReference(NativeBase nativeBase, long j, Disposer disposer2) {
            super(nativeBase, NativeBase.REFERENCE_QUEUE);
            this.nativePointer = j;
            this.disposer = disposer2;
            NativeBase.cleanUpQueue();
        }
    }

    public interface Disposer {
        void disposeNative(long j);
    }

    public NativeBase(long j, Disposer disposer) {
        this.nativeHandle = j;
        REFERENCES.add(new DisposableReference(j, disposer));
    }

    /* access modifiers changed from: private */
    public static void cleanUpQueue() {
        while (true) {
            Reference<? extends NativeBase> poll = REFERENCE_QUEUE.poll();
            if (poll != null) {
                poll.clear();
                try {
                    ((DisposableReference) poll).dispose();
                } catch (Throwable th) {
                    LOGGER.log(Level.SEVERE, "Error cleaning up after reference.", th);
                }
            } else {
                return;
            }
        }
    }
}
