package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

public class MemoryFileUpload extends AbstractMemoryHttpData implements FileUpload {
    private String contentTransferEncoding;
    private String contentType;
    private String filename;

    public MemoryFileUpload(String str, String str2, String str3, String str4, Charset charset, long j) {
        super(str, charset, j);
        setFilename(str2);
        setContentType(str3);
        setContentTransferEncoding(str4);
    }

    public boolean equals(Object obj) {
        return (obj instanceof FileUpload) && FileUploadUtil.equals(this, (FileUpload) obj);
    }

    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFilename() {
        return this.filename;
    }

    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.FileUpload;
    }

    public int hashCode() {
        return FileUploadUtil.hashCode(this);
    }

    public void setContentTransferEncoding(String str) {
        this.contentTransferEncoding = str;
    }

    public void setContentType(String str) {
        this.contentType = (String) ObjectUtil.checkNotNull(str, "contentType");
    }

    public void setFilename(String str) {
        this.filename = (String) ObjectUtil.checkNotNull(str, "filename");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HttpHeaderNames.CONTENT_DISPOSITION);
        sb.append(": ");
        sb.append(HttpHeaderValues.FORM_DATA);
        sb.append("; ");
        sb.append(HttpHeaderValues.NAME);
        sb.append("=\"");
        sb.append(getName());
        sb.append("\"; ");
        sb.append(HttpHeaderValues.FILENAME);
        sb.append("=\"");
        sb.append(this.filename);
        sb.append("\"\r\n");
        sb.append(HttpHeaderNames.CONTENT_TYPE);
        sb.append(": ");
        sb.append(this.contentType);
        String str = "\r\n";
        if (getCharset() != null) {
            str = "; " + HttpHeaderValues.CHARSET + '=' + getCharset().name() + str;
        }
        sb.append(str);
        sb.append(HttpHeaderNames.CONTENT_LENGTH);
        sb.append(": ");
        sb.append(length());
        sb.append("\r\nCompleted: ");
        sb.append(isCompleted());
        sb.append("\r\nIsInMemory: ");
        sb.append(isInMemory());
        return sb.toString();
    }

    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof FileUpload) {
            return compareTo((FileUpload) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    public FileUpload copy() {
        ByteBuf content = content();
        if (content != null) {
            content = content.copy();
        }
        return replace(content);
    }

    public FileUpload duplicate() {
        ByteBuf content = content();
        if (content != null) {
            content = content.duplicate();
        }
        return replace(content);
    }

    public FileUpload replace(ByteBuf byteBuf) {
        MemoryFileUpload memoryFileUpload = new MemoryFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size);
        if (byteBuf != null) {
            try {
                memoryFileUpload.setContent(byteBuf);
            } catch (IOException e) {
                throw new ChannelException((Throwable) e);
            }
        }
        memoryFileUpload.setCompleted(isCompleted());
        return memoryFileUpload;
    }

    public FileUpload retainedDuplicate() {
        ByteBuf content = content();
        if (content == null) {
            return replace((ByteBuf) null);
        }
        ByteBuf retainedDuplicate = content.retainedDuplicate();
        try {
            return replace(retainedDuplicate);
        } catch (Throwable th) {
            retainedDuplicate.release();
            throw th;
        }
    }

    public int compareTo(FileUpload fileUpload) {
        return FileUploadUtil.compareTo(this, fileUpload);
    }

    public FileUpload retain() {
        super.retain();
        return this;
    }

    public FileUpload touch() {
        super.touch();
        return this;
    }

    public FileUpload retain(int i) {
        super.retain(i);
        return this;
    }

    public FileUpload touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
