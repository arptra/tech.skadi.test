package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class AhoCorasicSearchProcessorFactory extends AbstractMultiSearchProcessorFactory {
    static final int ALPHABET_SIZE = 256;
    static final int BITS_PER_SYMBOL = 8;
    private final int[] jumpTable;
    private final int[] matchForNeedleId;

    public static class Context {
        int[] jumpTable;
        int[] matchForNeedleId;

        private Context() {
        }
    }

    public static class Processor implements MultiSearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final int[] matchForNeedleId;

        public Processor(int[] iArr, int[] iArr2) {
            this.jumpTable = iArr;
            this.matchForNeedleId = iArr2;
        }

        public int getFoundNeedleId() {
            return this.matchForNeedleId[((int) this.currentPosition) >> 8];
        }

        public boolean process(byte b) {
            long j = (long) PlatformDependent.getInt(this.jumpTable, this.currentPosition | (((long) b) & 255));
            this.currentPosition = j;
            if (j >= 0) {
                return true;
            }
            this.currentPosition = -j;
            return false;
        }

        public void reset() {
            this.currentPosition = 0;
        }
    }

    public AhoCorasicSearchProcessorFactory(byte[]... bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            if (bArr[i2].length != 0) {
                i2++;
            } else {
                throw new IllegalArgumentException("Needle must be non empty");
            }
        }
        Context buildTrie = buildTrie(bArr);
        this.jumpTable = buildTrie.jumpTable;
        this.matchForNeedleId = buildTrie.matchForNeedleId;
        linkSuffixes();
        while (true) {
            int[] iArr = this.jumpTable;
            if (i < iArr.length) {
                int[] iArr2 = this.matchForNeedleId;
                int i3 = iArr[i];
                if (iArr2[i3 >> 8] >= 0) {
                    iArr[i] = -i3;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private static Context buildTrie(byte[][] bArr) {
        ArrayList arrayList = new ArrayList(256);
        for (int i = 0; i < 256; i++) {
            arrayList.add(-1);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(-1);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = 0;
            for (byte b : bArr[i2]) {
                int i4 = i3 + (b & 255);
                if (((Integer) arrayList.get(i4)).intValue() == -1) {
                    arrayList.set(i4, Integer.valueOf(arrayList.size()));
                    for (int i5 = 0; i5 < 256; i5++) {
                        arrayList.add(-1);
                    }
                    arrayList2.add(-1);
                }
                i3 = ((Integer) arrayList.get(i4)).intValue();
            }
            arrayList2.set(i3 >> 8, Integer.valueOf(i2));
        }
        Context context = new Context();
        context.jumpTable = new int[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            context.jumpTable[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        context.matchForNeedleId = new int[arrayList2.size()];
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            context.matchForNeedleId[i7] = ((Integer) arrayList2.get(i7)).intValue();
        }
        return context;
    }

    private void linkSuffixes() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(0);
        int[] iArr = new int[this.matchForNeedleId.length];
        Arrays.fill(iArr, -1);
        while (!arrayDeque.isEmpty()) {
            int intValue = ((Integer) arrayDeque.remove()).intValue();
            int i = intValue >> 8;
            int i2 = iArr[i];
            if (i2 == -1) {
                i2 = 0;
            }
            int[] iArr2 = this.matchForNeedleId;
            if (iArr2[i] == -1) {
                iArr2[i] = iArr2[i2 >> 8];
            }
            for (int i3 = 0; i3 < 256; i3++) {
                int i4 = intValue | i3;
                int[] iArr3 = this.jumpTable;
                int i5 = iArr3[i4];
                int i6 = iArr3[i2 | i3];
                if (i5 != -1) {
                    int i7 = i5 >> 8;
                    if (intValue <= 0 || i6 == -1) {
                        i6 = 0;
                    }
                    iArr[i7] = i6;
                    arrayDeque.add(Integer.valueOf(i5));
                } else {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    iArr3[i4] = i6;
                }
            }
        }
    }

    public Processor newSearchProcessor() {
        return new Processor(this.jumpTable, this.matchForNeedleId);
    }
}
