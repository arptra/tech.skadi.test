package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

public enum RedisMessageType {
    INLINE_COMMAND((String) null, true),
    SIMPLE_STRING((byte) 43, true),
    ERROR((byte) 45, true),
    INTEGER(Byte.valueOf(HttpConstants.COLON), true),
    BULK_STRING(Byte.valueOf(BinaryMemcacheOpcodes.GATKQ), false),
    ARRAY_HEADER((byte) 42, false);
    
    private final boolean inline;
    private final Byte value;

    private RedisMessageType(Byte b, boolean z) {
        this.value = b;
        this.inline = z;
    }

    public static RedisMessageType readFrom(ByteBuf byteBuf, boolean z) {
        int readerIndex = byteBuf.readerIndex();
        RedisMessageType valueOf = valueOf(byteBuf.readByte());
        if (valueOf == INLINE_COMMAND) {
            if (z) {
                byteBuf.readerIndex(readerIndex);
            } else {
                throw new RedisCodecException("Decoding of inline commands is disabled");
            }
        }
        return valueOf;
    }

    public boolean isInline() {
        return this.inline;
    }

    public int length() {
        return this.value != null ? 1 : 0;
    }

    public void writeTo(ByteBuf byteBuf) {
        Byte b = this.value;
        if (b != null) {
            byteBuf.writeByte(b.byteValue());
        }
    }

    private static RedisMessageType valueOf(byte b) {
        if (b == 36) {
            return BULK_STRING;
        }
        if (b == 45) {
            return ERROR;
        }
        if (b == 58) {
            return INTEGER;
        }
        if (b == 42) {
            return ARRAY_HEADER;
        }
        if (b != 43) {
            return INLINE_COMMAND;
        }
        return SIMPLE_STRING;
    }
}
