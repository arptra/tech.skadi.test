package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;

public final class PreferredDirectByteBufAllocator implements ByteBufAllocator {
    private ByteBufAllocator allocator;

    public ByteBuf buffer() {
        return this.allocator.directBuffer();
    }

    public int calculateNewCapacity(int i, int i2) {
        return this.allocator.calculateNewCapacity(i, i2);
    }

    public CompositeByteBuf compositeBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    public CompositeByteBuf compositeDirectBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    public CompositeByteBuf compositeHeapBuffer() {
        return this.allocator.compositeHeapBuffer();
    }

    public ByteBuf directBuffer() {
        return this.allocator.directBuffer();
    }

    public ByteBuf heapBuffer() {
        return this.allocator.heapBuffer();
    }

    public ByteBuf ioBuffer() {
        return this.allocator.directBuffer();
    }

    public boolean isDirectBufferPooled() {
        return this.allocator.isDirectBufferPooled();
    }

    public void updateAllocator(ByteBufAllocator byteBufAllocator) {
        this.allocator = byteBufAllocator;
    }

    public ByteBuf buffer(int i) {
        return this.allocator.directBuffer(i);
    }

    public CompositeByteBuf compositeBuffer(int i) {
        return this.allocator.compositeDirectBuffer(i);
    }

    public CompositeByteBuf compositeDirectBuffer(int i) {
        return this.allocator.compositeDirectBuffer(i);
    }

    public CompositeByteBuf compositeHeapBuffer(int i) {
        return this.allocator.compositeHeapBuffer(i);
    }

    public ByteBuf directBuffer(int i) {
        return this.allocator.directBuffer(i);
    }

    public ByteBuf heapBuffer(int i) {
        return this.allocator.heapBuffer(i);
    }

    public ByteBuf ioBuffer(int i) {
        return this.allocator.directBuffer(i);
    }

    public ByteBuf buffer(int i, int i2) {
        return this.allocator.directBuffer(i, i2);
    }

    public ByteBuf directBuffer(int i, int i2) {
        return this.allocator.directBuffer(i, i2);
    }

    public ByteBuf heapBuffer(int i, int i2) {
        return this.allocator.heapBuffer(i, i2);
    }

    public ByteBuf ioBuffer(int i, int i2) {
        return this.allocator.directBuffer(i, i2);
    }
}
