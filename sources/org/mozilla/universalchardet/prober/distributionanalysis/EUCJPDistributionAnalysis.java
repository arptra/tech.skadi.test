package org.mozilla.universalchardet.prober.distributionanalysis;

import com.alibaba.fastjson.asm.Opcodes;

public class EUCJPDistributionAnalysis extends JISDistributionAnalysis {
    public int b(byte[] bArr, int i) {
        byte b = bArr[i] & 255;
        if (b < 161) {
            return -1;
        }
        return (((b - Opcodes.IF_ICMPLT) * 94) + (bArr[i + 1] & 255)) - Opcodes.IF_ICMPLT;
    }
}
