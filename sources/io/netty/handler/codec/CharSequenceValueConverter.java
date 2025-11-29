package io.netty.handler.codec;

import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.BooleanUtils;

public class CharSequenceValueConverter implements ValueConverter<CharSequence> {
    public static final CharSequenceValueConverter INSTANCE = new CharSequenceValueConverter();
    private static final AsciiString TRUE_ASCII = new AsciiString((CharSequence) BooleanUtils.TRUE);

    public CharSequence convertBoolean(boolean z) {
        return String.valueOf(z);
    }

    public CharSequence convertByte(byte b) {
        return String.valueOf(b);
    }

    public CharSequence convertChar(char c) {
        return String.valueOf(c);
    }

    public CharSequence convertDouble(double d) {
        return String.valueOf(d);
    }

    public CharSequence convertFloat(float f) {
        return String.valueOf(f);
    }

    public CharSequence convertInt(int i) {
        return String.valueOf(i);
    }

    public CharSequence convertLong(long j) {
        return String.valueOf(j);
    }

    public CharSequence convertObject(Object obj) {
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public CharSequence convertShort(short s) {
        return String.valueOf(s);
    }

    public CharSequence convertTimeMillis(long j) {
        return DateFormatter.format(new Date(j));
    }

    public boolean convertToBoolean(CharSequence charSequence) {
        return AsciiString.contentEqualsIgnoreCase(charSequence, TRUE_ASCII);
    }

    public byte convertToByte(CharSequence charSequence) {
        if (!(charSequence instanceof AsciiString) || charSequence.length() != 1) {
            return Byte.parseByte(charSequence.toString());
        }
        return ((AsciiString) charSequence).byteAt(0);
    }

    public char convertToChar(CharSequence charSequence) {
        return charSequence.charAt(0);
    }

    public double convertToDouble(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).parseDouble();
        }
        return Double.parseDouble(charSequence.toString());
    }

    public float convertToFloat(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).parseFloat();
        }
        return Float.parseFloat(charSequence.toString());
    }

    public int convertToInt(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).parseInt();
        }
        return Integer.parseInt(charSequence.toString());
    }

    public long convertToLong(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).parseLong();
        }
        return Long.parseLong(charSequence.toString());
    }

    public short convertToShort(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).parseShort();
        }
        return Short.parseShort(charSequence.toString());
    }

    public long convertToTimeMillis(CharSequence charSequence) {
        Date parseHttpDate = DateFormatter.parseHttpDate(charSequence);
        if (parseHttpDate != null) {
            return parseHttpDate.getTime();
        }
        PlatformDependent.throwException(new ParseException("header can't be parsed into a Date: " + charSequence, 0));
        return 0;
    }
}
