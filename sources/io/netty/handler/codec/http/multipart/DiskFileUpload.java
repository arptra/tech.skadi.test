package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class DiskFileUpload extends AbstractDiskHttpData implements FileUpload {
    public static String baseDirectory = null;
    public static boolean deleteOnExitTemporaryFile = true;
    public static final String postfix = ".tmp";
    public static final String prefix = "FUp_";
    private final String baseDir;
    private String contentTransferEncoding;
    private String contentType;
    private final boolean deleteOnExit;
    private String filename;

    public DiskFileUpload(String str, String str2, String str3, String str4, Charset charset, long j, String str5, boolean z) {
        super(str, charset, j);
        setFilename(str2);
        setContentType(str3);
        setContentTransferEncoding(str4);
        this.baseDir = str5 == null ? baseDirectory : str5;
        this.deleteOnExit = z;
    }

    public boolean deleteOnExit() {
        return this.deleteOnExit;
    }

    public boolean equals(Object obj) {
        return (obj instanceof FileUpload) && FileUploadUtil.equals(this, (FileUpload) obj);
    }

    public String getBaseDirectory() {
        return this.baseDir;
    }

    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getDiskFilename() {
        return "upload";
    }

    public String getFilename() {
        return this.filename;
    }

    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.FileUpload;
    }

    public String getPostfix() {
        return postfix;
    }

    public String getPrefix() {
        return prefix;
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
        File file;
        try {
            file = getFile();
        } catch (IOException unused) {
            file = null;
        }
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
        sb.append("\r\nRealFile: ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" DeleteAfter: ");
        sb.append(this.deleteOnExit);
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
        return replace(content != null ? content.copy() : null);
    }

    public FileUpload duplicate() {
        ByteBuf content = content();
        return replace(content != null ? content.duplicate() : null);
    }

    public FileUpload replace(ByteBuf byteBuf) {
        DiskFileUpload diskFileUpload = new DiskFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size, this.baseDir, this.deleteOnExit);
        if (byteBuf != null) {
            try {
                diskFileUpload.setContent(byteBuf);
            } catch (IOException e) {
                throw new ChannelException((Throwable) e);
            }
        }
        diskFileUpload.setCompleted(isCompleted());
        return diskFileUpload;
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

    public DiskFileUpload(String str, String str2, String str3, String str4, Charset charset, long j) {
        this(str, str2, str3, str4, charset, j, baseDirectory, deleteOnExitTemporaryFile);
    }

    public FileUpload retain(int i) {
        super.retain(i);
        return this;
    }

    public FileUpload touch() {
        super.touch();
        return this;
    }

    public FileUpload retain() {
        super.retain();
        return this;
    }

    public FileUpload touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
