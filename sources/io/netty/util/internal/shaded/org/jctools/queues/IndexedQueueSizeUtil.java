package io.netty.util.internal.shaded.org.jctools.queues;

import com.here.posclient.UpdateOptions;

public final class IndexedQueueSizeUtil {

    public interface IndexedQueue {
        int capacity();

        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        return indexedQueue.lvConsumerIndex() >= indexedQueue.lvProducerIndex();
    }

    public static int size(IndexedQueue indexedQueue) {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            lvProducerIndex = indexedQueue.lvProducerIndex();
            lvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j = lvProducerIndex - lvConsumerIndex;
        if (j > UpdateOptions.SOURCE_ANY) {
            return Integer.MAX_VALUE;
        }
        if (j < 0) {
            return 0;
        }
        return (indexedQueue.capacity() == -1 || j <= ((long) indexedQueue.capacity())) ? (int) j : indexedQueue.capacity();
    }
}
