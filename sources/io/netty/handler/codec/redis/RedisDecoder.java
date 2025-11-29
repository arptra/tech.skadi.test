package io.netty.handler.codec.redis;

import com.meizu.common.widget.MzContactsContract;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import java.util.List;

public final class RedisDecoder extends ByteToMessageDecoder {
    private final boolean decodeInlineCommands;
    private final int maxInlineMessageLength;
    private final RedisMessagePool messagePool;
    private int remainingBulkLength;
    private State state;
    private final ToPositiveLongProcessor toPositiveLongProcessor;
    private RedisMessageType type;

    /* renamed from: io.netty.handler.codec.redis.RedisDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisMessageType;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                io.netty.handler.codec.redis.RedisMessageType[] r0 = io.netty.handler.codec.redis.RedisMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType = r0
                r1 = 1
                io.netty.handler.codec.redis.RedisMessageType r2 = io.netty.handler.codec.redis.RedisMessageType.ARRAY_HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$redis$RedisMessageType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.redis.RedisMessageType r3 = io.netty.handler.codec.redis.RedisMessageType.BULK_STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$codec$redis$RedisMessageType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.redis.RedisMessageType r4 = io.netty.handler.codec.redis.RedisMessageType.INLINE_COMMAND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$netty$handler$codec$redis$RedisMessageType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.redis.RedisMessageType r5 = io.netty.handler.codec.redis.RedisMessageType.SIMPLE_STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$io$netty$handler$codec$redis$RedisMessageType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.redis.RedisMessageType r6 = io.netty.handler.codec.redis.RedisMessageType.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = $SwitchMap$io$netty$handler$codec$redis$RedisMessageType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.redis.RedisMessageType r6 = io.netty.handler.codec.redis.RedisMessageType.INTEGER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                io.netty.handler.codec.redis.RedisDecoder$State[] r5 = io.netty.handler.codec.redis.RedisDecoder.State.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State = r5
                io.netty.handler.codec.redis.RedisDecoder$State r6 = io.netty.handler.codec.redis.RedisDecoder.State.DECODE_TYPE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State     // Catch:{ NoSuchFieldError -> 0x0064 }
                io.netty.handler.codec.redis.RedisDecoder$State r5 = io.netty.handler.codec.redis.RedisDecoder.State.DECODE_INLINE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State     // Catch:{ NoSuchFieldError -> 0x006e }
                io.netty.handler.codec.redis.RedisDecoder$State r1 = io.netty.handler.codec.redis.RedisDecoder.State.DECODE_LENGTH     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.redis.RedisDecoder$State r1 = io.netty.handler.codec.redis.RedisDecoder.State.DECODE_BULK_STRING_EOL     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State     // Catch:{ NoSuchFieldError -> 0x0082 }
                io.netty.handler.codec.redis.RedisDecoder$State r1 = io.netty.handler.codec.redis.RedisDecoder.State.DECODE_BULK_STRING_CONTENT     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.redis.RedisDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        DECODE_TYPE,
        DECODE_INLINE,
        DECODE_LENGTH,
        DECODE_BULK_STRING_EOL,
        DECODE_BULK_STRING_CONTENT
    }

    public static final class ToPositiveLongProcessor implements ByteProcessor {
        private long result;

        private ToPositiveLongProcessor() {
        }

        public long content() {
            return this.result;
        }

        public boolean process(byte b) throws Exception {
            if (b < 48 || b > 57) {
                throw new RedisCodecException("bad byte in number: " + b);
            }
            this.result = (this.result * 10) + ((long) (b - 48));
            return true;
        }

        public void reset() {
            this.result = 0;
        }

        public /* synthetic */ ToPositiveLongProcessor(AnonymousClass1 r1) {
            this();
        }
    }

    public RedisDecoder() {
        this(false);
    }

    private boolean decodeBulkString(ByteBuf byteBuf, List<Object> list) throws Exception {
        int i = this.remainingBulkLength;
        if (i == -1) {
            list.add(FullBulkStringRedisMessage.NULL_INSTANCE);
            resetDecoder();
            return true;
        } else if (i != 0) {
            list.add(new BulkStringHeaderRedisMessage(i));
            this.state = State.DECODE_BULK_STRING_CONTENT;
            return decodeBulkStringContent(byteBuf, list);
        } else {
            this.state = State.DECODE_BULK_STRING_EOL;
            return decodeBulkStringEndOfLine(byteBuf, list);
        }
    }

    private boolean decodeBulkStringContent(ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return false;
        }
        int i = this.remainingBulkLength;
        if (i == 0 && readableBytes < 2) {
            return false;
        }
        if (readableBytes >= i + 2) {
            ByteBuf readSlice = byteBuf.readSlice(i);
            readEndOfLine(byteBuf);
            list.add(new DefaultLastBulkStringRedisContent(readSlice.retain()));
            resetDecoder();
            return true;
        }
        int min = Math.min(i, readableBytes);
        this.remainingBulkLength -= min;
        list.add(new DefaultBulkStringRedisContent(byteBuf.readSlice(min).retain()));
        return true;
    }

    private boolean decodeBulkStringEndOfLine(ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 2) {
            return false;
        }
        readEndOfLine(byteBuf);
        list.add(FullBulkStringRedisMessage.EMPTY_INSTANCE);
        resetDecoder();
        return true;
    }

    private boolean decodeInline(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine != null) {
            list.add(newInlineRedisMessage(this.type, readLine));
            resetDecoder();
            return true;
        } else if (byteBuf.readableBytes() <= this.maxInlineMessageLength) {
            return false;
        } else {
            throw new RedisCodecException("length: " + byteBuf.readableBytes() + " (expected: <= " + this.maxInlineMessageLength + ")");
        }
    }

    private boolean decodeLength(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            return false;
        }
        long parseRedisNumber = parseRedisNumber(readLine);
        if (parseRedisNumber >= -1) {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[this.type.ordinal()];
            if (i == 1) {
                list.add(new ArrayHeaderRedisMessage(parseRedisNumber));
                resetDecoder();
                return true;
            } else if (i != 2) {
                throw new RedisCodecException("bad type: " + this.type);
            } else if (parseRedisNumber <= 536870912) {
                this.remainingBulkLength = (int) parseRedisNumber;
                return decodeBulkString(byteBuf, list);
            } else {
                throw new RedisCodecException("length: " + parseRedisNumber + " (expected: <= " + 536870912 + ")");
            }
        } else {
            throw new RedisCodecException("length: " + parseRedisNumber + " (expected: >= " + -1 + ")");
        }
    }

    private boolean decodeType(ByteBuf byteBuf) throws Exception {
        if (!byteBuf.isReadable()) {
            return false;
        }
        RedisMessageType readFrom = RedisMessageType.readFrom(byteBuf, this.decodeInlineCommands);
        this.type = readFrom;
        this.state = readFrom.isInline() ? State.DECODE_INLINE : State.DECODE_LENGTH;
        return true;
    }

    private RedisMessage newInlineRedisMessage(RedisMessageType redisMessageType, ByteBuf byteBuf) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[redisMessageType.ordinal()];
        if (i == 3) {
            return new InlineCommandRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        }
        if (i == 4) {
            SimpleStringRedisMessage simpleString = this.messagePool.getSimpleString(byteBuf);
            return simpleString != null ? simpleString : new SimpleStringRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        } else if (i == 5) {
            ErrorRedisMessage error = this.messagePool.getError(byteBuf);
            return error != null ? error : new ErrorRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        } else if (i == 6) {
            IntegerRedisMessage integer = this.messagePool.getInteger(byteBuf);
            return integer != null ? integer : new IntegerRedisMessage(parseRedisNumber(byteBuf));
        } else {
            throw new RedisCodecException("bad type: " + redisMessageType);
        }
    }

    private long parsePositiveNumber(ByteBuf byteBuf) {
        this.toPositiveLongProcessor.reset();
        byteBuf.forEachByte(this.toPositiveLongProcessor);
        return this.toPositiveLongProcessor.content();
    }

    private long parseRedisNumber(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int i = (readableBytes <= 0 || byteBuf.getByte(byteBuf.readerIndex()) != 45) ? 0 : 1;
        if (readableBytes <= i) {
            throw new RedisCodecException("no number to parse: " + byteBuf.toString(CharsetUtil.US_ASCII));
        } else if (readableBytes <= i + 19) {
            return i != 0 ? -parsePositiveNumber(byteBuf.skipBytes(i)) : parsePositiveNumber(byteBuf);
        } else {
            throw new RedisCodecException("too many characters to be a valid RESP Integer: " + byteBuf.toString(CharsetUtil.US_ASCII));
        }
    }

    private static void readEndOfLine(ByteBuf byteBuf) {
        short readShort = byteBuf.readShort();
        if (RedisConstants.EOL_SHORT != readShort) {
            byte[] shortToBytes = RedisCodecUtil.shortToBytes(readShort);
            throw new RedisCodecException("delimiter: [" + shortToBytes[0] + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + shortToBytes[1] + "] (expected: \\r\\n)");
        }
    }

    private static ByteBuf readLine(ByteBuf byteBuf) {
        int forEachByte;
        if (!byteBuf.isReadable(2) || (forEachByte = byteBuf.forEachByte(ByteProcessor.FIND_LF)) < 0) {
            return null;
        }
        ByteBuf readSlice = byteBuf.readSlice((forEachByte - byteBuf.readerIndex()) - 1);
        readEndOfLine(byteBuf);
        return readSlice;
    }

    private void resetDecoder() {
        this.state = State.DECODE_TYPE;
        this.remainingBulkLength = 0;
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (true) {
            try {
                int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[this.state.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    throw new RedisCodecException("Unknown state: " + this.state);
                                } else if (!decodeBulkStringContent(byteBuf, list)) {
                                    return;
                                }
                            } else if (!decodeBulkStringEndOfLine(byteBuf, list)) {
                                return;
                            }
                        } else if (!decodeLength(byteBuf, list)) {
                            return;
                        }
                    } else if (!decodeInline(byteBuf, list)) {
                        return;
                    }
                } else if (!decodeType(byteBuf)) {
                    return;
                }
            } catch (RedisCodecException e) {
                resetDecoder();
                throw e;
            } catch (Exception e2) {
                resetDecoder();
                throw new RedisCodecException((Throwable) e2);
            }
        }
    }

    public RedisDecoder(boolean z) {
        this(65536, FixedRedisMessagePool.INSTANCE, z);
    }

    public RedisDecoder(int i, RedisMessagePool redisMessagePool) {
        this(i, redisMessagePool, false);
    }

    public RedisDecoder(int i, RedisMessagePool redisMessagePool, boolean z) {
        this.toPositiveLongProcessor = new ToPositiveLongProcessor((AnonymousClass1) null);
        this.state = State.DECODE_TYPE;
        if (i <= 0 || i > 536870912) {
            throw new RedisCodecException("maxInlineMessageLength: " + i + " (expected: <= " + 536870912 + ")");
        }
        this.maxInlineMessageLength = i;
        this.messagePool = redisMessagePool;
        this.decodeInlineCommands = z;
    }
}
