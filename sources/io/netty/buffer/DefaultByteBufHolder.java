package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultByteBufHolder implements ByteBufHolder {
    private final ByteBuf data;

    public DefaultByteBufHolder(ByteBuf byteBuf) {
        this.data = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "data");
    }

    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.data);
    }

    public final String contentToString() {
        return this.data.toString();
    }

    public ByteBufHolder copy() {
        return replace(this.data.copy());
    }

    public ByteBufHolder duplicate() {
        return replace(this.data.duplicate());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.data.equals(((DefaultByteBufHolder) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public int refCnt() {
        return this.data.refCnt();
    }

    public boolean release() {
        return this.data.release();
    }

    public ByteBufHolder replace(ByteBuf byteBuf) {
        return new DefaultByteBufHolder(byteBuf);
    }

    public ByteBufHolder retainedDuplicate() {
        return replace(this.data.retainedDuplicate());
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '(' + contentToString() + ')';
    }

    public boolean release(int i) {
        return this.data.release(i);
    }

    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    public ByteBufHolder touch() {
        this.data.touch();
        return this;
    }

    public ByteBufHolder retain(int i) {
        this.data.retain(i);
        return this;
    }

    public ByteBufHolder touch(Object obj) {
        this.data.touch(obj);
        return this;
    }
}
