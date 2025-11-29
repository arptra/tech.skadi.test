package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.codec.language.Soundex;

public class UUIDSerializer extends StdScalarSerializer<UUID> {
    static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public UUIDSerializer() {
        super(UUID.class);
    }

    private static void _appendInt(int i, char[] cArr, int i2) {
        _appendShort(i >> 16, cArr, i2);
        _appendShort(i, cArr, i2 + 4);
    }

    private static void _appendShort(int i, char[] cArr, int i2) {
        char[] cArr2 = HEX_CHARS;
        cArr[i2] = cArr2[(i >> 12) & 15];
        cArr[i2 + 1] = cArr2[(i >> 8) & 15];
        cArr[i2 + 2] = cArr2[(i >> 4) & 15];
        cArr[i2 + 3] = cArr2[i & 15];
    }

    private static final byte[] _asBytes(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        _appendInt((int) (mostSignificantBits >> 32), bArr, 0);
        _appendInt((int) mostSignificantBits, bArr, 4);
        _appendInt((int) (leastSignificantBits >> 32), bArr, 8);
        _appendInt((int) leastSignificantBits, bArr, 12);
        return bArr;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, UUID uuid) {
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    public void serialize(UUID uuid, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (!jsonGenerator.canWriteBinaryNatively() || (jsonGenerator instanceof TokenBuffer)) {
            char[] cArr = new char[36];
            long mostSignificantBits = uuid.getMostSignificantBits();
            _appendInt((int) (mostSignificantBits >> 32), cArr, 0);
            cArr[8] = Soundex.SILENT_MARKER;
            int i = (int) mostSignificantBits;
            _appendShort(i >>> 16, cArr, 9);
            cArr[13] = Soundex.SILENT_MARKER;
            _appendShort(i, cArr, 14);
            cArr[18] = Soundex.SILENT_MARKER;
            long leastSignificantBits = uuid.getLeastSignificantBits();
            _appendShort((int) (leastSignificantBits >>> 48), cArr, 19);
            cArr[23] = Soundex.SILENT_MARKER;
            _appendShort((int) (leastSignificantBits >>> 32), cArr, 24);
            _appendInt((int) leastSignificantBits, cArr, 28);
            jsonGenerator.writeString(cArr, 0, 36);
            return;
        }
        jsonGenerator.writeBinary(_asBytes(uuid));
    }

    private static final void _appendInt(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }
}
