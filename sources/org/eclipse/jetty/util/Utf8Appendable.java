package org.eclipse.jetty.util;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import okio.Utf8;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public abstract class Utf8Appendable {
    private static final byte[] BYTE_TABLE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    protected static final Logger LOG = Log.getLogger((Class<?>) Utf8Appendable.class);
    public static final char REPLACEMENT = '�';
    private static final byte[] TRANS_TABLE = {0, 12, 24, BinaryMemcacheOpcodes.GATKQ, 60, 96, 84, 12, 12, 12, 48, 72, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 0, 12, 0, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, BinaryMemcacheOpcodes.GATKQ, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    private static final int UTF8_ACCEPT = 0;
    private static final int UTF8_REJECT = 12;
    protected final Appendable _appendable;
    private int _codep;
    protected int _state = 0;

    public static class NotUtf8Exception extends IllegalArgumentException {
        public NotUtf8Exception(String str) {
            super("Not valid UTF8! " + str);
        }
    }

    public Utf8Appendable(Appendable appendable) {
        this._appendable = appendable;
    }

    public void append(byte b) {
        try {
            appendByte(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendByte(byte b) throws IOException {
        if (b <= 0 || this._state != 0) {
            byte b2 = b & 255;
            byte b3 = BYTE_TABLE[b2];
            int i = this._state;
            byte b4 = i == 0 ? (255 >> b3) & b2 : (b & Utf8.REPLACEMENT_BYTE) | (this._codep << 6);
            this._codep = b4;
            byte b5 = TRANS_TABLE[i + b3];
            if (b5 == 0) {
                this._state = b5;
                if (b4 < 55296) {
                    this._appendable.append((char) b4);
                    return;
                }
                for (char append : Character.toChars(b4)) {
                    this._appendable.append(append);
                }
            } else if (b5 != 12) {
                this._state = b5;
            } else {
                String str = "byte " + TypeUtil.toHexString(b) + " in state " + (this._state / 12);
                this._codep = 0;
                this._state = 0;
                this._appendable.append(65533);
                throw new NotUtf8Exception(str);
            }
        } else {
            this._appendable.append((char) (b & 255));
        }
    }

    public void checkState() {
        if (!isUtf8SequenceComplete()) {
            this._codep = 0;
            this._state = 0;
            try {
                this._appendable.append(65533);
                throw new NotUtf8Exception("incomplete UTF8 sequence");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isUtf8SequenceComplete() {
        return this._state == 0;
    }

    public abstract int length();

    public void reset() {
        this._state = 0;
    }

    public String toReplacedString() {
        if (!isUtf8SequenceComplete()) {
            this._codep = 0;
            this._state = 0;
            try {
                this._appendable.append(65533);
                NotUtf8Exception notUtf8Exception = new NotUtf8Exception("incomplete UTF8 sequence");
                Logger logger = LOG;
                logger.warn(notUtf8Exception.toString(), new Object[0]);
                logger.debug(notUtf8Exception);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this._appendable.toString();
    }

    public void append(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            try {
                appendByte(bArr[i]);
                i++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean append(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            try {
                if (length() > i3) {
                    return false;
                }
                appendByte(bArr[i]);
                i++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
