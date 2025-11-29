package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class ColognePhonetic implements StringEncoder {
    private static final char[] AEIJOUY = {'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] AHKLOQRUX = {'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] AHKOQUX = {'A', 'H', 'K', 'O', 'Q', 'U', 'X'};
    private static final char CHAR_IGNORE = '-';
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] CSZ = {'C', 'S', 'Z'};
    private static final char[] DTX = {'D', 'T', 'X'};
    private static final char[] FPVW = {'F', 'P', 'V', 'W'};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[] SZ = {'S', 'Z'};

    public class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            char[] cArr2 = this.data;
            System.arraycopy(cArr2, (cArr2.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        public int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    public class CologneOutputBuffer extends CologneBuffer {
        private char lastCode = '/';

        public CologneOutputBuffer(int i) {
            super(i);
        }

        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, i, cArr, 0, i2);
            return cArr;
        }

        public void put(char c) {
            if (!(c == '-' || this.lastCode == c || (c == '0' && this.length != 0))) {
                char[] cArr = this.data;
                int i = this.length;
                cArr[i] = c;
                this.length = i + 1;
            }
            this.lastCode = c;
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private char[] preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 196) {
                charArray[i] = 'A';
            } else if (c == 214) {
                charArray[i] = 'O';
            } else if (c == 220) {
                charArray[i] = 'U';
            }
        }
        return charArray;
    }

    public String colognePhonetic(String str) {
        if (str == null) {
            return null;
        }
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess(str));
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(cologneInputBuffer.length() * 2);
        char c = '-';
        while (cologneInputBuffer.length() > 0) {
            char removeNext = cologneInputBuffer.removeNext();
            char nextChar = cologneInputBuffer.length() > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (removeNext >= 'A' && removeNext <= 'Z') {
                if (arrayContains(AEIJOUY, removeNext)) {
                    cologneOutputBuffer.put('0');
                } else if (removeNext == 'B' || (removeNext == 'P' && nextChar != 'H')) {
                    cologneOutputBuffer.put('1');
                } else if ((removeNext == 'D' || removeNext == 'T') && !arrayContains(CSZ, nextChar)) {
                    cologneOutputBuffer.put('2');
                } else if (arrayContains(FPVW, removeNext)) {
                    cologneOutputBuffer.put('3');
                } else if (arrayContains(GKQ, removeNext)) {
                    cologneOutputBuffer.put('4');
                } else if (removeNext == 'X' && !arrayContains(CKQ, c)) {
                    cologneOutputBuffer.put('4');
                    cologneOutputBuffer.put('8');
                } else if (removeNext == 'S' || removeNext == 'Z') {
                    cologneOutputBuffer.put('8');
                } else if (removeNext == 'C') {
                    if (cologneOutputBuffer.length() == 0) {
                        if (arrayContains(AHKLOQRUX, nextChar)) {
                            cologneOutputBuffer.put('4');
                        } else {
                            cologneOutputBuffer.put('8');
                        }
                    } else if (arrayContains(SZ, c) || !arrayContains(AHKOQUX, nextChar)) {
                        cologneOutputBuffer.put('8');
                    } else {
                        cologneOutputBuffer.put('4');
                    }
                } else if (arrayContains(DTX, removeNext)) {
                    cologneOutputBuffer.put('8');
                } else if (removeNext == 'R') {
                    cologneOutputBuffer.put('7');
                } else if (removeNext == 'L') {
                    cologneOutputBuffer.put('5');
                } else if (removeNext == 'M' || removeNext == 'N') {
                    cologneOutputBuffer.put('6');
                } else if (removeNext == 'H') {
                    cologneOutputBuffer.put('-');
                }
                c = removeNext;
            }
        }
        return cologneOutputBuffer.toString();
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    public abstract class CologneBuffer {
        protected final char[] data;
        protected int length = 0;

        public CologneBuffer(char[] cArr) {
            this.data = cArr;
            this.length = cArr.length;
        }

        public abstract char[] copyData(int i, int i2);

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }

        public CologneBuffer(int i) {
            this.data = new char[i];
            this.length = 0;
        }
    }

    public String encode(String str) {
        return colognePhonetic(str);
    }
}
