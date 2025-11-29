package org.apache.tika.parser.strings;

public enum StringsEncoding {
    SINGLE_7_BIT('s', "single-7-bit-byte"),
    SINGLE_8_BIT('S', "single-8-bit-byte"),
    BIGENDIAN_16_BIT('b', "16-bit bigendian"),
    LITTLEENDIAN_16_BIT('l', "16-bit littleendian"),
    BIGENDIAN_32_BIT('B', "32-bit bigendian"),
    LITTLEENDIAN_32_BIT('L', "32-bit littleendian");
    
    private String encoding;
    private char value;

    private StringsEncoding(char c, String str) {
        this.value = c;
        this.encoding = str;
    }

    public char get() {
        return this.value;
    }

    public String toString() {
        return this.encoding;
    }
}
