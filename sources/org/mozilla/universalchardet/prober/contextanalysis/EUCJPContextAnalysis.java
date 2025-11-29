package org.mozilla.universalchardet.prober.contextanalysis;

import com.alibaba.fastjson.asm.Opcodes;

public class EUCJPContextAnalysis extends JapaneseContextAnalysis {
    public int b(byte[] bArr, int i) {
        byte b;
        if ((bArr[i] & 255) != 164 || (b = bArr[i + 1] & 255) < 161 || b > 243) {
            return -1;
        }
        return b - Opcodes.IF_ICMPLT;
    }
}
