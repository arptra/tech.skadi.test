package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Deque;

public final class UniformStreamByteDistributor implements StreamByteDistributor {
    private int minAllocationChunk = 1024;
    /* access modifiers changed from: private */
    public final Deque<State> queue = new ArrayDeque(4);
    /* access modifiers changed from: private */
    public final Http2Connection.PropertyKey stateKey;
    /* access modifiers changed from: private */
    public long totalStreamableBytes;

    public final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean enqueued;
        final Http2Stream stream;
        int streamableBytes;
        boolean windowNegative;
        boolean writing;

        public State(Http2Stream http2Stream) {
            this.stream = http2Stream;
        }

        public void addToQueue() {
            if (!this.enqueued) {
                this.enqueued = true;
                UniformStreamByteDistributor.this.queue.addLast(this);
            }
        }

        public void close() {
            removeFromQueue();
            updateStreamableBytes(0, false, 0);
        }

        public void removeFromQueue() {
            if (this.enqueued) {
                this.enqueued = false;
                UniformStreamByteDistributor.this.queue.remove(this);
            }
        }

        public void updateStreamableBytes(int i, boolean z, int i2) {
            int i3 = i - this.streamableBytes;
            if (i3 != 0) {
                this.streamableBytes = i;
                UniformStreamByteDistributor uniformStreamByteDistributor = UniformStreamByteDistributor.this;
                long unused = uniformStreamByteDistributor.totalStreamableBytes = uniformStreamByteDistributor.totalStreamableBytes + ((long) i3);
            }
            this.windowNegative = i2 < 0;
            if (!z) {
                return;
            }
            if (i2 > 0 || (i2 == 0 && !this.writing)) {
                addToQueue();
            }
        }

        public void write(int i, StreamByteDistributor.Writer writer) throws Http2Exception {
            this.writing = true;
            try {
                writer.write(this.stream, i);
                this.writing = false;
            } catch (Throwable th) {
                this.writing = false;
                throw th;
            }
        }
    }

    public UniformStreamByteDistributor(Http2Connection http2Connection) {
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        Http2Stream connectionStream = http2Connection.connectionStream();
        connectionStream.setProperty(newKey, new State(connectionStream));
        http2Connection.addListener(new Http2ConnectionAdapter() {
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(UniformStreamByteDistributor.this.stateKey, new State(http2Stream));
            }

            public void onStreamClosed(Http2Stream http2Stream) {
                UniformStreamByteDistributor.this.state(http2Stream).close();
            }
        });
    }

    /* access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) ((Http2Stream) ObjectUtil.checkNotNull(http2Stream, "stream")).getProperty(this.stateKey);
    }

    public boolean distribute(int i, StreamByteDistributor.Writer writer) throws Http2Exception {
        int size = this.queue.size();
        if (size == 0) {
            return this.totalStreamableBytes > 0;
        }
        int max = Math.max(this.minAllocationChunk, i / size);
        State pollFirst = this.queue.pollFirst();
        while (true) {
            pollFirst.enqueued = false;
            if (!pollFirst.windowNegative) {
                if (i == 0 && pollFirst.streamableBytes > 0) {
                    this.queue.addFirst(pollFirst);
                    pollFirst.enqueued = true;
                    break;
                }
                int min = Math.min(max, Math.min(i, pollFirst.streamableBytes));
                i -= min;
                pollFirst.write(min, writer);
            }
            pollFirst = this.queue.pollFirst();
            if (pollFirst == null) {
                break;
            }
        }
        return this.totalStreamableBytes > 0;
    }

    public void minAllocationChunk(int i) {
        ObjectUtil.checkPositive(i, "minAllocationChunk");
        this.minAllocationChunk = i;
    }

    public void updateDependencyTree(int i, int i2, short s, boolean z) {
    }

    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame(), streamState.windowSize());
    }
}
