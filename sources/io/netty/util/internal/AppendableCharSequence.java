package io.netty.util.internal;

import java.util.Arrays;

public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i) {
        this.chars = new char[ObjectUtil.checkPositive(i, "length")];
    }

    private static char[] expand(char[] cArr, int i, int i2) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i2);
        return cArr2;
    }

    public char charAt(int i) {
        if (i <= this.pos) {
            return this.chars[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i) {
        return this.chars[i];
    }

    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public void setLength(int i) {
        if (i < 0 || i > this.pos) {
            throw new IllegalArgumentException("length: " + i + " (length: >= 0, <= " + this.pos + ')');
        }
        this.pos = i;
    }

    public String subStringUnsafe(int i, int i2) {
        return new String(this.chars, i, i2 - i);
    }

    public String substring(int i, int i2) {
        int i3 = i2 - i;
        int i4 = this.pos;
        if (i <= i4 && i3 <= i4) {
            return new String(this.chars, i, i3);
        }
        throw new IndexOutOfBoundsException("expected: start and length <= (" + this.pos + ")");
    }

    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    public AppendableCharSequence subSequence(int i, int i2) {
        if (i == i2) {
            return new AppendableCharSequence(Math.min(16, this.chars.length));
        }
        return new AppendableCharSequence(Arrays.copyOfRange(this.chars, i, i2));
    }

    private AppendableCharSequence(char[] cArr) {
        this.chars = ObjectUtil.checkNonEmpty(cArr, "chars");
        this.pos = cArr.length;
    }

    public AppendableCharSequence append(char c) {
        int i = this.pos;
        char[] cArr = this.chars;
        if (i == cArr.length) {
            char[] cArr2 = new char[(cArr.length << 1)];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i2 = this.pos;
        this.pos = i2 + 1;
        cArr3[i2] = c;
        return this;
    }

    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    public AppendableCharSequence append(CharSequence charSequence, int i, int i2) {
        if (charSequence.length() >= i2) {
            int i3 = i2 - i;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i4 = this.pos;
            if (i3 > length - i4) {
                this.chars = expand(cArr, i4 + i3, i4);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i, this.chars, this.pos, i3);
                this.pos += i3;
                return this;
            }
            while (i < i2) {
                char[] cArr2 = this.chars;
                int i5 = this.pos;
                this.pos = i5 + 1;
                cArr2[i5] = charSequence.charAt(i);
                i++;
            }
            return this;
        }
        throw new IndexOutOfBoundsException("expected: csq.length() >= (" + i2 + "),but actual is (" + charSequence.length() + ")");
    }
}
