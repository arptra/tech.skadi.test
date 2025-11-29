package org.mozilla.universalchardet.prober.distributionanalysis;

import com.alibaba.fastjson.asm.Opcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import okio.Utf8;

public class SJISDistributionAnalysis extends JISDistributionAnalysis {
    public int b(byte[] bArr, int i) {
        int i2;
        byte b = bArr[i] & 255;
        if (b >= 129 && b <= 159) {
            i2 = b - DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE;
        } else if (b < 224 || b > 239) {
            return -1;
        } else {
            i2 = b + Utf8.REPLACEMENT_BYTE;
        }
        int i3 = i2 * Opcodes.NEWARRAY;
        byte b2 = bArr[i + 1] & 255;
        int i4 = i3 + (b2 - 64);
        return b2 >= 128 ? i4 - 1 : i4;
    }
}
