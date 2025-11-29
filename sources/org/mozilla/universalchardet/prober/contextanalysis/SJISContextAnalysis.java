package org.mozilla.universalchardet.prober.contextanalysis;

import com.alibaba.fastjson.asm.Opcodes;

public class SJISContextAnalysis extends JapaneseContextAnalysis {
    public int b(byte[] bArr, int i) {
        byte b;
        if ((bArr[i] & 255) != 130 || (b = bArr[i + 1] & 255) < 159 || b > 241) {
            return -1;
        }
        return b - Opcodes.IF_ICMPEQ;
    }
}
