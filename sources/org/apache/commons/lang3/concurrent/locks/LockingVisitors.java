package org.apache.commons.lang3.concurrent.locks;

import com.honey.account.bc.a;
import com.honey.account.bc.b;
import com.honey.account.bc.c;
import com.honey.account.bc.d;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.aspectj.lang.JoinPoint;

public class LockingVisitors {

    public static class LockVisitor<O, L> {
        private final L lock;
        private final O object;
        private final Supplier<Lock> readLockSupplier;
        private final Supplier<Lock> writeLockSupplier;

        public LockVisitor(O o, L l, Supplier<Lock> supplier, Supplier<Lock> supplier2) {
            Objects.requireNonNull(o, "object");
            this.object = o;
            Objects.requireNonNull(l, JoinPoint.SYNCHRONIZATION_LOCK);
            this.lock = l;
            Objects.requireNonNull(supplier, "readLockSupplier");
            this.readLockSupplier = supplier;
            Objects.requireNonNull(supplier2, "writeLockSupplier");
            this.writeLockSupplier = supplier2;
        }

        public void acceptReadLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.readLockSupplier, failableConsumer);
        }

        public void acceptWriteLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.writeLockSupplier, failableConsumer);
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [org.apache.commons.lang3.function.FailableFunction, org.apache.commons.lang3.function.FailableFunction<O, T, ?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> T applyReadLocked(org.apache.commons.lang3.function.FailableFunction<O, T, ?> r2) {
            /*
                r1 = this;
                java.util.function.Supplier<java.util.concurrent.locks.Lock> r0 = r1.readLockSupplier
                java.lang.Object r1 = r1.lockApplyUnlock(r0, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.applyReadLocked(org.apache.commons.lang3.function.FailableFunction):java.lang.Object");
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [org.apache.commons.lang3.function.FailableFunction, org.apache.commons.lang3.function.FailableFunction<O, T, ?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> T applyWriteLocked(org.apache.commons.lang3.function.FailableFunction<O, T, ?> r2) {
            /*
                r1 = this;
                java.util.function.Supplier<java.util.concurrent.locks.Lock> r0 = r1.writeLockSupplier
                java.lang.Object r1 = r1.lockApplyUnlock(r0, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.applyWriteLocked(org.apache.commons.lang3.function.FailableFunction):java.lang.Object");
        }

        public L getLock() {
            return this.lock;
        }

        public O getObject() {
            return this.object;
        }

        public void lockAcceptUnlock(Supplier<Lock> supplier, FailableConsumer<O, ?> failableConsumer) {
            Lock lock2 = supplier.get();
            lock2.lock();
            try {
                failableConsumer.accept(this.object);
                lock2.unlock();
            } catch (Throwable th) {
                lock2.unlock();
                throw th;
            }
        }

        public <T> T lockApplyUnlock(Supplier<Lock> supplier, FailableFunction<O, T, ?> failableFunction) {
            Lock lock2 = supplier.get();
            lock2.lock();
            try {
                T apply = failableFunction.apply(this.object);
                lock2.unlock();
                return apply;
            } catch (Throwable th) {
                lock2.unlock();
                throw th;
            }
        }
    }

    public static class ReadWriteLockVisitor<O> extends LockVisitor<O, ReadWriteLock> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReadWriteLockVisitor(O o, ReadWriteLock readWriteLock) {
            super(o, readWriteLock, new a(readWriteLock), new b(readWriteLock));
            readWriteLock.getClass();
        }
    }

    public static class StampedLockVisitor<O> extends LockVisitor<O, StampedLock> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StampedLockVisitor(O o, StampedLock stampedLock) {
            super(o, stampedLock, new c(stampedLock), new d(stampedLock));
            stampedLock.getClass();
        }
    }

    public static <O> ReadWriteLockVisitor<O> reentrantReadWriteLockVisitor(O o) {
        return new ReadWriteLockVisitor<>(o, new ReentrantReadWriteLock());
    }

    public static <O> StampedLockVisitor<O> stampedLockVisitor(O o) {
        return new StampedLockVisitor<>(o, new StampedLock());
    }
}
