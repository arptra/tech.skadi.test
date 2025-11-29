package io.netty.util.concurrent;

import java.util.Arrays;

final class DefaultFutureListeners {
    private GenericFutureListener<? extends Future<?>>[] listeners;
    private int progressiveSize;
    private int size = 2;

    public DefaultFutureListeners(GenericFutureListener<? extends Future<?>> genericFutureListener, GenericFutureListener<? extends Future<?>> genericFutureListener2) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = new GenericFutureListener[2];
        this.listeners = genericFutureListenerArr;
        genericFutureListenerArr[0] = genericFutureListener;
        genericFutureListenerArr[1] = genericFutureListener2;
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
        if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public void add(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i = this.size;
        if (i == genericFutureListenerArr.length) {
            genericFutureListenerArr = (GenericFutureListener[]) Arrays.copyOf(genericFutureListenerArr, i << 1);
            this.listeners = genericFutureListenerArr;
        }
        genericFutureListenerArr[i] = genericFutureListener;
        this.size = i + 1;
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public GenericFutureListener<? extends Future<?>>[] listeners() {
        return this.listeners;
    }

    public int progressiveSize() {
        return this.progressiveSize;
    }

    public void remove(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (genericFutureListenerArr[i2] == genericFutureListener) {
                int i3 = (i - i2) - 1;
                if (i3 > 0) {
                    System.arraycopy(genericFutureListenerArr, i2 + 1, genericFutureListenerArr, i2, i3);
                }
                int i4 = i - 1;
                genericFutureListenerArr[i4] = null;
                this.size = i4;
                if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                    this.progressiveSize--;
                    return;
                }
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }
}
