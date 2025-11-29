package com.upuphone.runasone.host.core.api.util;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TlvBox {
    protected static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;
    protected final Map<Byte, byte[]> valueMap;

    public TlvBox() {
        this.valueMap = new HashMap();
    }

    public static TlvBox clone(TlvBox tlvBox) {
        if (tlvBox == null) {
            return null;
        }
        return new TlvBox(tlvBox.serialize());
    }

    public static TlvBox create() {
        return new TlvBox();
    }

    public static TlvBox parse(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        return new TlvBox(bArr, i, i2);
    }

    public static byte[] serialize(TlvBox tlvBox) {
        if (tlvBox == null) {
            return null;
        }
        return tlvBox.serialize();
    }

    public boolean contains(Byte b) {
        return this.valueMap.containsKey(b);
    }

    public Boolean getBoolean(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        boolean z = false;
        if (bytes[0] == 1) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public Byte getByte(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Byte.valueOf(bytes[0]);
    }

    public byte[] getBytes(Byte b) {
        return this.valueMap.get(b);
    }

    public Character getCharacter(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Character.valueOf(ByteBuffer.wrap(bytes).order(DEFAULT_BYTE_ORDER).getChar());
    }

    public Double getDouble(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Double.valueOf(ByteBuffer.wrap(bytes).order(DEFAULT_BYTE_ORDER).getDouble());
    }

    public Float getFloat(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Float.valueOf(ByteBuffer.wrap(bytes).order(DEFAULT_BYTE_ORDER).getFloat());
    }

    public Integer getInteger(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Integer.valueOf(ByteBuffer.wrap(bytes).order(DEFAULT_BYTE_ORDER).getInt());
    }

    public Long getLong(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Long.valueOf(ByteBuffer.wrap(bytes).order(DEFAULT_BYTE_ORDER).getLong());
    }

    public TlvBox getObject(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return new TlvBox(bytes, 0, bytes.length);
    }

    public Short getShort(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return Short.valueOf(ByteBuffer.wrap(bytes).order(DEFAULT_BYTE_ORDER).getShort());
    }

    public String getString(Byte b) {
        byte[] bytes = getBytes(b);
        if (bytes == null) {
            return null;
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public Map<Byte, byte[]> getValueMap() {
        return this.valueMap;
    }

    public int length() {
        int i = 0;
        for (Map.Entry<Byte, byte[]> value : this.valueMap.entrySet()) {
            i += ((byte[]) value.getValue()).length + 3;
        }
        return i;
    }

    public TlvBox put(Byte b, byte[] bArr) {
        if (bArr == null) {
            return this;
        }
        this.valueMap.put(b, bArr);
        return this;
    }

    public byte[] remove(Byte b) {
        return this.valueMap.remove(b);
    }

    public static TlvBox parse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new TlvBox(bArr);
    }

    public TlvBox put(Byte b, byte b2) {
        return put(b, new byte[]{b2});
    }

    public byte[] serialize() {
        int length = length();
        if (length == 0) {
            return new byte[0];
        }
        Log.e("----序列化tlvbox", length + "");
        byte[] bArr = new byte[length];
        int i = 0;
        for (Map.Entry next : this.valueMap.entrySet()) {
            byte[] bArr2 = (byte[]) next.getValue();
            ByteBuffer allocate = ByteBuffer.allocate(1);
            ByteOrder byteOrder = DEFAULT_BYTE_ORDER;
            byte[] array = allocate.order(byteOrder).put(((Byte) next.getKey()).byteValue()).array();
            byte[] array2 = ByteBuffer.allocate(2).order(byteOrder).putShort((short) bArr2.length).array();
            System.arraycopy(array, 0, bArr, i, array.length);
            System.arraycopy(array2, 0, bArr, i + 1, array2.length);
            int i2 = i + 3;
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i = i2 + bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TlvBox(TlvBox tlvBox) {
        this(tlvBox != null ? tlvBox.serialize() : null);
    }

    public TlvBox put(Byte b, boolean z) {
        return put(b, new byte[]{z ? (byte) 1 : 0});
    }

    public TlvBox(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public TlvBox put(Byte b, char c) {
        return put(b, ByteBuffer.allocate(2).order(DEFAULT_BYTE_ORDER).putChar(c).array());
    }

    public TlvBox(Map<Byte, byte[]> map) {
        this.valueMap = map;
    }

    public TlvBox put(Byte b, short s) {
        return put(b, ByteBuffer.allocate(2).order(DEFAULT_BYTE_ORDER).putShort(s).array());
    }

    public TlvBox put(Byte b, int i) {
        return put(b, ByteBuffer.allocate(4).order(DEFAULT_BYTE_ORDER).putInt(i).array());
    }

    public TlvBox(byte[] bArr, int i, int i2) {
        this.valueMap = new HashMap();
        if (bArr != null) {
            Log.e("----解析tlvbox", i2 + "");
            int i3 = 0;
            while (i3 < i2) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr, i + i3, 1);
                ByteOrder byteOrder = DEFAULT_BYTE_ORDER;
                Byte valueOf = Byte.valueOf(wrap.order(byteOrder).get());
                int unsignedInt = Short.toUnsignedInt(ByteBuffer.wrap(bArr, i3 + 1 + i, 2).order(byteOrder).getShort());
                int i4 = i3 + 3;
                byte[] bArr2 = new byte[unsignedInt];
                System.arraycopy(bArr, i + i4, bArr2, 0, unsignedInt);
                put(valueOf, bArr2);
                i3 = i4 + unsignedInt;
            }
        }
    }

    public TlvBox put(Byte b, long j) {
        return put(b, ByteBuffer.allocate(8).order(DEFAULT_BYTE_ORDER).putLong(j).array());
    }

    public TlvBox put(Byte b, float f) {
        return put(b, ByteBuffer.allocate(4).order(DEFAULT_BYTE_ORDER).putFloat(f).array());
    }

    public TlvBox put(Byte b, double d) {
        return put(b, ByteBuffer.allocate(8).order(DEFAULT_BYTE_ORDER).putDouble(d).array());
    }

    public TlvBox put(Byte b, String str) {
        return str == null ? this : put(b, str.getBytes(StandardCharsets.UTF_8));
    }

    public TlvBox put(Byte b, TlvBox tlvBox) {
        return tlvBox == null ? this : put(b, tlvBox.serialize());
    }
}
