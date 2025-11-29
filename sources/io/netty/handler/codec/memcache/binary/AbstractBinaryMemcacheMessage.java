package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObject;

public abstract class AbstractBinaryMemcacheMessage extends AbstractMemcacheObject implements BinaryMemcacheMessage {
    private long cas;
    private byte dataType;
    private ByteBuf extras;
    private byte extrasLength;
    private ByteBuf key;
    private short keyLength;
    private byte magic;
    private int opaque;
    private byte opcode;
    private int totalBodyLength;

    public AbstractBinaryMemcacheMessage(ByteBuf byteBuf, ByteBuf byteBuf2) {
        this.key = byteBuf;
        byte b = 0;
        this.keyLength = byteBuf == null ? 0 : (short) byteBuf.readableBytes();
        this.extras = byteBuf2;
        b = byteBuf2 != null ? (byte) byteBuf2.readableBytes() : b;
        this.extrasLength = b;
        this.totalBodyLength = this.keyLength + b;
    }

    public long cas() {
        return this.cas;
    }

    public void copyMeta(AbstractBinaryMemcacheMessage abstractBinaryMemcacheMessage) {
        abstractBinaryMemcacheMessage.magic = this.magic;
        abstractBinaryMemcacheMessage.opcode = this.opcode;
        abstractBinaryMemcacheMessage.keyLength = this.keyLength;
        abstractBinaryMemcacheMessage.extrasLength = this.extrasLength;
        abstractBinaryMemcacheMessage.dataType = this.dataType;
        abstractBinaryMemcacheMessage.totalBodyLength = this.totalBodyLength;
        abstractBinaryMemcacheMessage.opaque = this.opaque;
        abstractBinaryMemcacheMessage.cas = this.cas;
    }

    public byte dataType() {
        return this.dataType;
    }

    public void deallocate() {
        ByteBuf byteBuf = this.key;
        if (byteBuf != null) {
            byteBuf.release();
        }
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
    }

    public ByteBuf extras() {
        return this.extras;
    }

    public byte extrasLength() {
        return this.extrasLength;
    }

    public ByteBuf key() {
        return this.key;
    }

    public short keyLength() {
        return this.keyLength;
    }

    public byte magic() {
        return this.magic;
    }

    public int opaque() {
        return this.opaque;
    }

    public byte opcode() {
        return this.opcode;
    }

    public BinaryMemcacheMessage setCas(long j) {
        this.cas = j;
        return this;
    }

    public BinaryMemcacheMessage setDataType(byte b) {
        this.dataType = b;
        return this;
    }

    public BinaryMemcacheMessage setExtras(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.extras = byteBuf;
        short s = (short) this.extrasLength;
        byte readableBytes = byteBuf == null ? 0 : (byte) byteBuf.readableBytes();
        this.extrasLength = readableBytes;
        this.totalBodyLength = (this.totalBodyLength + readableBytes) - s;
        return this;
    }

    public BinaryMemcacheMessage setExtrasLength(byte b) {
        this.extrasLength = b;
        return this;
    }

    public BinaryMemcacheMessage setKey(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = this.key;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.key = byteBuf;
        short s = this.keyLength;
        short readableBytes = byteBuf == null ? 0 : (short) byteBuf.readableBytes();
        this.keyLength = readableBytes;
        this.totalBodyLength = (this.totalBodyLength + readableBytes) - s;
        return this;
    }

    public BinaryMemcacheMessage setKeyLength(short s) {
        this.keyLength = s;
        return this;
    }

    public BinaryMemcacheMessage setMagic(byte b) {
        this.magic = b;
        return this;
    }

    public BinaryMemcacheMessage setOpaque(int i) {
        this.opaque = i;
        return this;
    }

    public BinaryMemcacheMessage setOpcode(byte b) {
        this.opcode = b;
        return this;
    }

    public BinaryMemcacheMessage setTotalBodyLength(int i) {
        this.totalBodyLength = i;
        return this;
    }

    public int totalBodyLength() {
        return this.totalBodyLength;
    }

    public BinaryMemcacheMessage retain() {
        super.retain();
        return this;
    }

    public BinaryMemcacheMessage touch() {
        super.touch();
        return this;
    }

    public BinaryMemcacheMessage retain(int i) {
        super.retain(i);
        return this;
    }

    public BinaryMemcacheMessage touch(Object obj) {
        ByteBuf byteBuf = this.key;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.touch(obj);
        }
        return this;
    }
}
