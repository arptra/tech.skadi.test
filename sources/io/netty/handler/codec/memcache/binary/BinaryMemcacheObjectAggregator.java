package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectAggregator;
import io.netty.handler.codec.memcache.FullMemcacheMessage;
import io.netty.handler.codec.memcache.MemcacheObject;

public class BinaryMemcacheObjectAggregator extends AbstractMemcacheObjectAggregator<BinaryMemcacheMessage> {
    public BinaryMemcacheObjectAggregator(int i) {
        super(i);
    }

    private static FullBinaryMemcacheRequest toFullRequest(BinaryMemcacheRequest binaryMemcacheRequest, ByteBuf byteBuf) {
        ByteBuf byteBuf2 = null;
        ByteBuf retain = binaryMemcacheRequest.key() == null ? null : binaryMemcacheRequest.key().retain();
        if (binaryMemcacheRequest.extras() != null) {
            byteBuf2 = binaryMemcacheRequest.extras().retain();
        }
        DefaultFullBinaryMemcacheRequest defaultFullBinaryMemcacheRequest = new DefaultFullBinaryMemcacheRequest(retain, byteBuf2, byteBuf);
        defaultFullBinaryMemcacheRequest.setMagic(binaryMemcacheRequest.magic());
        defaultFullBinaryMemcacheRequest.setOpcode(binaryMemcacheRequest.opcode());
        defaultFullBinaryMemcacheRequest.setKeyLength(binaryMemcacheRequest.keyLength());
        defaultFullBinaryMemcacheRequest.setExtrasLength(binaryMemcacheRequest.extrasLength());
        defaultFullBinaryMemcacheRequest.setDataType(binaryMemcacheRequest.dataType());
        defaultFullBinaryMemcacheRequest.setTotalBodyLength(binaryMemcacheRequest.totalBodyLength());
        defaultFullBinaryMemcacheRequest.setOpaque(binaryMemcacheRequest.opaque());
        defaultFullBinaryMemcacheRequest.setCas(binaryMemcacheRequest.cas());
        defaultFullBinaryMemcacheRequest.setReserved(binaryMemcacheRequest.reserved());
        return defaultFullBinaryMemcacheRequest;
    }

    private static FullBinaryMemcacheResponse toFullResponse(BinaryMemcacheResponse binaryMemcacheResponse, ByteBuf byteBuf) {
        ByteBuf byteBuf2 = null;
        ByteBuf retain = binaryMemcacheResponse.key() == null ? null : binaryMemcacheResponse.key().retain();
        if (binaryMemcacheResponse.extras() != null) {
            byteBuf2 = binaryMemcacheResponse.extras().retain();
        }
        DefaultFullBinaryMemcacheResponse defaultFullBinaryMemcacheResponse = new DefaultFullBinaryMemcacheResponse(retain, byteBuf2, byteBuf);
        defaultFullBinaryMemcacheResponse.setMagic(binaryMemcacheResponse.magic());
        defaultFullBinaryMemcacheResponse.setOpcode(binaryMemcacheResponse.opcode());
        defaultFullBinaryMemcacheResponse.setKeyLength(binaryMemcacheResponse.keyLength());
        defaultFullBinaryMemcacheResponse.setExtrasLength(binaryMemcacheResponse.extrasLength());
        defaultFullBinaryMemcacheResponse.setDataType(binaryMemcacheResponse.dataType());
        defaultFullBinaryMemcacheResponse.setTotalBodyLength(binaryMemcacheResponse.totalBodyLength());
        defaultFullBinaryMemcacheResponse.setOpaque(binaryMemcacheResponse.opaque());
        defaultFullBinaryMemcacheResponse.setCas(binaryMemcacheResponse.cas());
        defaultFullBinaryMemcacheResponse.setStatus(binaryMemcacheResponse.status());
        return defaultFullBinaryMemcacheResponse;
    }

    public FullMemcacheMessage beginAggregation(BinaryMemcacheMessage binaryMemcacheMessage, ByteBuf byteBuf) throws Exception {
        if (binaryMemcacheMessage instanceof BinaryMemcacheRequest) {
            return toFullRequest((BinaryMemcacheRequest) binaryMemcacheMessage, byteBuf);
        }
        if (binaryMemcacheMessage instanceof BinaryMemcacheResponse) {
            return toFullResponse((BinaryMemcacheResponse) binaryMemcacheMessage, byteBuf);
        }
        throw new Error();
    }

    public boolean isStartMessage(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof BinaryMemcacheMessage;
    }
}
