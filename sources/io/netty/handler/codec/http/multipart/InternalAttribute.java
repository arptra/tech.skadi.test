package io.netty.handler.codec.http.multipart;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

final class InternalAttribute extends AbstractReferenceCounted implements InterfaceHttpData {
    private final Charset charset;
    private int size;
    private final List<ByteBuf> value = new ArrayList();

    public InternalAttribute(Charset charset2) {
        this.charset = charset2;
    }

    public void addValue(String str) {
        ObjectUtil.checkNotNull(str, AccountConstantKt.RESPONSE_VALUE);
        ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) str, this.charset);
        this.value.add(copiedBuffer);
        this.size += copiedBuffer.readableBytes();
    }

    public void deallocate() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternalAttribute)) {
            return false;
        }
        return getName().equalsIgnoreCase(((InternalAttribute) obj).getName());
    }

    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.InternalAttribute;
    }

    public String getName() {
        return "InternalAttribute";
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public void setValue(String str, int i) {
        ObjectUtil.checkNotNull(str, AccountConstantKt.RESPONSE_VALUE);
        ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) str, this.charset);
        ByteBuf byteBuf = this.value.set(i, copiedBuffer);
        if (byteBuf != null) {
            this.size -= byteBuf.readableBytes();
            byteBuf.release();
        }
        this.size += copiedBuffer.readableBytes();
    }

    public int size() {
        return this.size;
    }

    public ByteBuf toByteBuf() {
        return Unpooled.compositeBuffer().addComponents((Iterable<ByteBuf>) this.value).writerIndex(size()).readerIndex(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ByteBuf byteBuf : this.value) {
            sb.append(byteBuf.toString(this.charset));
        }
        return sb.toString();
    }

    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof InternalAttribute) {
            return compareTo((InternalAttribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    public InterfaceHttpData retain() {
        for (ByteBuf retain : this.value) {
            retain.retain();
        }
        return this;
    }

    public InterfaceHttpData touch() {
        for (ByteBuf byteBuf : this.value) {
            byteBuf.touch();
        }
        return this;
    }

    public void addValue(String str, int i) {
        ObjectUtil.checkNotNull(str, AccountConstantKt.RESPONSE_VALUE);
        ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) str, this.charset);
        this.value.add(i, copiedBuffer);
        this.size += copiedBuffer.readableBytes();
    }

    public InterfaceHttpData retain(int i) {
        for (ByteBuf retain : this.value) {
            retain.retain(i);
        }
        return this;
    }

    public InterfaceHttpData touch(Object obj) {
        for (ByteBuf byteBuf : this.value) {
            byteBuf.touch(obj);
        }
        return this;
    }

    public int compareTo(InternalAttribute internalAttribute) {
        return getName().compareToIgnoreCase(internalAttribute.getName());
    }
}
