package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;
    private final Inflater z;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB, 0);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i;
        ByteBuf prepareDecompressBuffer;
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 0) {
            try {
                this.z.avail_in = readableBytes;
                if (byteBuf.hasArray()) {
                    this.z.next_in = byteBuf.array();
                    this.z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
                } else {
                    byte[] bArr = new byte[readableBytes];
                    byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                    this.z.next_in = bArr;
                    this.z.next_in_index = 0;
                }
                i = this.z.next_in_index;
                prepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, (ByteBuf) null, readableBytes << 1);
                while (true) {
                    prepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, prepareDecompressBuffer, this.z.avail_in << 1);
                    this.z.avail_out = prepareDecompressBuffer.writableBytes();
                    this.z.next_out = prepareDecompressBuffer.array();
                    this.z.next_out_index = prepareDecompressBuffer.arrayOffset() + prepareDecompressBuffer.writerIndex();
                    int i2 = this.z.next_out_index;
                    int inflate = this.z.inflate(2);
                    int i3 = this.z.next_out_index - i2;
                    if (i3 > 0) {
                        prepareDecompressBuffer.writerIndex(prepareDecompressBuffer.writerIndex() + i3);
                    }
                    if (inflate != -5) {
                        if (inflate != 0) {
                            if (inflate == 1) {
                                this.finished = true;
                                this.z.inflateEnd();
                                break;
                            } else if (inflate != 2) {
                                ZlibUtil.fail(this.z, "decompression failure", inflate);
                            } else {
                                byte[] bArr2 = this.dictionary;
                                if (bArr2 == null) {
                                    ZlibUtil.fail(this.z, "decompression failure", inflate);
                                } else {
                                    int inflateSetDictionary = this.z.inflateSetDictionary(bArr2, bArr2.length);
                                    if (inflateSetDictionary != 0) {
                                        ZlibUtil.fail(this.z, "failed to set the dictionary", inflateSetDictionary);
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    } else if (this.z.avail_in > 0) {
                    }
                }
                byteBuf.skipBytes(this.z.next_in_index - i);
                if (prepareDecompressBuffer.isReadable()) {
                    list.add(prepareDecompressBuffer);
                } else {
                    prepareDecompressBuffer.release();
                }
                this.z.next_in = null;
                this.z.next_out = null;
            } catch (Throwable th) {
                this.z.next_in = null;
                this.z.next_out = null;
                throw th;
            }
        }
    }

    public void decompressionBufferExhausted(ByteBuf byteBuf) {
        this.finished = true;
    }

    public boolean isClosed() {
        return this.finished;
    }

    public JZlibDecoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 0);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper, int i) {
        super(i);
        Inflater inflater = new Inflater();
        this.z = inflater;
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        int init = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
        if (init != 0) {
            ZlibUtil.fail(inflater, "initialization failure", init);
        }
    }

    public JZlibDecoder(byte[] bArr) {
        this(bArr, 0);
    }

    public JZlibDecoder(byte[] bArr, int i) {
        super(i);
        Inflater inflater = new Inflater();
        this.z = inflater;
        this.dictionary = (byte[]) ObjectUtil.checkNotNull(bArr, "dictionary");
        int inflateInit = inflater.inflateInit(JZlib.W_ZLIB);
        if (inflateInit != 0) {
            ZlibUtil.fail(inflater, "initialization failure", inflateInit);
        }
    }
}
