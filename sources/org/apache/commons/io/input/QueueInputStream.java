package org.apache.commons.io.input;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.io.output.QueueOutputStream;

public class QueueInputStream extends InputStream {
    private final BlockingQueue<Integer> blockingQueue;

    public QueueInputStream() {
        this(new LinkedBlockingQueue());
    }

    public QueueOutputStream newQueueOutputStream() {
        return new QueueOutputStream(this.blockingQueue);
    }

    public int read() {
        Integer poll = this.blockingQueue.poll();
        if (poll == null) {
            return -1;
        }
        return poll.intValue() & 255;
    }

    public QueueInputStream(BlockingQueue<Integer> blockingQueue2) {
        Objects.requireNonNull(blockingQueue2, "blockingQueue");
        this.blockingQueue = blockingQueue2;
    }
}
