package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class FixedRedisMessagePool implements RedisMessagePool {
    public static final FixedRedisMessagePool INSTANCE = new FixedRedisMessagePool();
    private static final long MAX_CACHED_INTEGER_NUMBER = 128;
    private static final long MIN_CACHED_INTEGER_NUMBER = -1;
    private static final int SIZE_CACHED_INTEGER_NUMBER = 129;
    private final Map<ByteBuf, ErrorRedisMessage> byteBufToErrors;
    private final Map<ByteBuf, IntegerRedisMessage> byteBufToIntegers;
    private final Map<ByteBuf, SimpleStringRedisMessage> byteBufToSimpleStrings = new HashMap(RedisReplyKey.values().length, 1.0f);
    private final Map<RedisErrorKey, ErrorRedisMessage> keyToErrors;
    private final Map<RedisReplyKey, SimpleStringRedisMessage> keyToSimpleStrings = new HashMap(RedisReplyKey.values().length, 1.0f);
    private final LongObjectMap<byte[]> longToByteBufs;
    private final LongObjectMap<IntegerRedisMessage> longToIntegers;
    private final Map<String, ErrorRedisMessage> stringToErrors;
    private final Map<String, SimpleStringRedisMessage> stringToSimpleStrings = new HashMap(RedisReplyKey.values().length, 1.0f);

    public enum RedisErrorKey {
        ERR("ERR"),
        ERR_IDX("ERR index out of range"),
        ERR_NOKEY("ERR no such key"),
        ERR_SAMEOBJ("ERR source and destination objects are the same"),
        ERR_SYNTAX("ERR syntax error"),
        BUSY("BUSY Redis is busy running a script. You can only call SCRIPT KILL or SHUTDOWN NOSAVE."),
        BUSYKEY("BUSYKEY Target key name already exists."),
        EXECABORT("EXECABORT Transaction discarded because of previous errors."),
        LOADING("LOADING Redis is loading the dataset in memory"),
        MASTERDOWN("MASTERDOWN Link with MASTER is down and slave-serve-stale-data is set to 'no'."),
        MISCONF("MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk. Commands that may modify the data set are disabled. Please check Redis logs for details about the error."),
        NOREPLICAS("NOREPLICAS Not enough good slaves to write."),
        NOSCRIPT("NOSCRIPT No matching script. Please use EVAL."),
        OOM("OOM command not allowed when used memory > 'maxmemory'."),
        READONLY("READONLY You can't write against a read only slave."),
        WRONGTYPE("WRONGTYPE Operation against a key holding the wrong kind of value"),
        NOT_AUTH("NOAUTH Authentication required.");
        
        private final String msg;

        private RedisErrorKey(String str) {
            this.msg = str;
        }

        public String toString() {
            return this.msg;
        }
    }

    public enum RedisReplyKey {
        OK,
        PONG,
        QUEUED
    }

    private FixedRedisMessagePool() {
        for (RedisReplyKey redisReplyKey : RedisReplyKey.values()) {
            String name = redisReplyKey.name();
            Charset charset = CharsetUtil.UTF_8;
            ByteBuf asReadOnly = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(name.getBytes(charset))).asReadOnly();
            SimpleStringRedisMessage simpleStringRedisMessage = new SimpleStringRedisMessage(new String(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(redisReplyKey.name().getBytes(charset))).array()));
            this.stringToSimpleStrings.put(redisReplyKey.name(), simpleStringRedisMessage);
            this.keyToSimpleStrings.put(redisReplyKey, simpleStringRedisMessage);
            this.byteBufToSimpleStrings.put(asReadOnly, simpleStringRedisMessage);
        }
        this.keyToErrors = new HashMap(RedisErrorKey.values().length, 1.0f);
        this.stringToErrors = new HashMap(RedisErrorKey.values().length, 1.0f);
        this.byteBufToErrors = new HashMap(RedisErrorKey.values().length, 1.0f);
        for (RedisErrorKey redisErrorKey : RedisErrorKey.values()) {
            String redisErrorKey2 = redisErrorKey.toString();
            Charset charset2 = CharsetUtil.UTF_8;
            ByteBuf asReadOnly2 = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(redisErrorKey2.getBytes(charset2))).asReadOnly();
            ErrorRedisMessage errorRedisMessage = new ErrorRedisMessage(new String(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(redisErrorKey.toString().getBytes(charset2))).array()));
            this.stringToErrors.put(redisErrorKey.toString(), errorRedisMessage);
            this.keyToErrors.put(redisErrorKey, errorRedisMessage);
            this.byteBufToErrors.put(asReadOnly2, errorRedisMessage);
        }
        this.byteBufToIntegers = new HashMap(SIZE_CACHED_INTEGER_NUMBER, 1.0f);
        this.longToIntegers = new LongObjectHashMap(SIZE_CACHED_INTEGER_NUMBER, 1.0f);
        this.longToByteBufs = new LongObjectHashMap(SIZE_CACHED_INTEGER_NUMBER, 1.0f);
        for (long j = -1; j < 128; j++) {
            byte[] longToAsciiBytes = RedisCodecUtil.longToAsciiBytes(j);
            ByteBuf asReadOnly3 = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(longToAsciiBytes)).asReadOnly();
            IntegerRedisMessage integerRedisMessage = new IntegerRedisMessage(j);
            this.byteBufToIntegers.put(asReadOnly3, integerRedisMessage);
            this.longToIntegers.put(j, integerRedisMessage);
            this.longToByteBufs.put(j, longToAsciiBytes);
        }
    }

    public byte[] getByteBufOfInteger(long j) {
        return this.longToByteBufs.get(j);
    }

    public ErrorRedisMessage getError(String str) {
        return this.stringToErrors.get(str);
    }

    public IntegerRedisMessage getInteger(long j) {
        return this.longToIntegers.get(j);
    }

    public SimpleStringRedisMessage getSimpleString(String str) {
        return this.stringToSimpleStrings.get(str);
    }

    public ErrorRedisMessage getError(RedisErrorKey redisErrorKey) {
        return this.keyToErrors.get(redisErrorKey);
    }

    public IntegerRedisMessage getInteger(ByteBuf byteBuf) {
        return this.byteBufToIntegers.get(byteBuf);
    }

    public SimpleStringRedisMessage getSimpleString(RedisReplyKey redisReplyKey) {
        return this.keyToSimpleStrings.get(redisReplyKey);
    }

    public ErrorRedisMessage getError(ByteBuf byteBuf) {
        return this.byteBufToErrors.get(byteBuf);
    }

    public SimpleStringRedisMessage getSimpleString(ByteBuf byteBuf) {
        return this.byteBufToSimpleStrings.get(byteBuf);
    }
}
