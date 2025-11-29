package org.apache.commons.codec.language;

import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.runasone.uupcast.CastEventCode;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    private boolean isNextChar(StringBuilder sb, int i, char c) {
        return i >= 0 && i < sb.length() - 1 && sb.charAt(i + 1) == c;
    }

    private boolean isPreviousChar(StringBuilder sb, int i, char c) {
        return i > 0 && i < sb.length() && sb.charAt(i - 1) == c;
    }

    private boolean isVowel(StringBuilder sb, int i) {
        return VOWELS.indexOf(sb.charAt(i)) >= 0;
    }

    private boolean regionMatch(StringBuilder sb, int i, String str) {
        if (i < 0 || (str.length() + i) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i, str.length() + i).equals(str);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public String metaphone(String str) {
        int length;
        String str2 = str;
        if (str2 == null || (length = str.length()) == 0) {
            return "";
        }
        if (length == 1) {
            return str2.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str2.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuilder sb = new StringBuilder(40);
        StringBuilder sb2 = new StringBuilder(10);
        int i = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else {
                    sb.append(charArray);
                }
            } else if (c == 'W') {
                char c2 = charArray[1];
                if (c2 == 'R') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else if (c2 == 'H') {
                    sb.append(charArray, 1, charArray.length - 1);
                    sb.setCharAt(0, 'W');
                } else {
                    sb.append(charArray);
                }
            } else if (c != 'X') {
                sb.append(charArray);
            } else {
                charArray[0] = 'S';
                sb.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            sb.append(charArray, 1, charArray.length - 1);
        } else {
            sb.append(charArray);
        }
        int length2 = sb.length();
        while (sb2.length() < getMaxCodeLen() && i < length2) {
            char charAt = sb.charAt(i);
            if (charAt == 'C' || !isPreviousChar(sb, i, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case CastEventCode.SINK_VIDEO_SURFACE_CONFIGURABLE:
                        if (i == 0) {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'B':
                        if (!isPreviousChar(sb, i, 'M') || !isLastChar(length2, i)) {
                            sb2.append(charAt);
                            break;
                        }
                    case 'C':
                        if (!isPreviousChar(sb, i, 'S') || isLastChar(length2, i) || FRONTV.indexOf(sb.charAt(i + 1)) < 0) {
                            if (!regionMatch(sb, i, "CIA")) {
                                if (isLastChar(length2, i) || FRONTV.indexOf(sb.charAt(i + 1)) < 0) {
                                    if (!isPreviousChar(sb, i, 'S') || !isNextChar(sb, i, 'H')) {
                                        if (isNextChar(sb, i, 'H')) {
                                            if (i == 0 && length2 >= 3 && isVowel(sb, 2)) {
                                                sb2.append('K');
                                                break;
                                            } else {
                                                sb2.append('X');
                                                break;
                                            }
                                        } else {
                                            sb2.append('K');
                                            break;
                                        }
                                    } else {
                                        sb2.append('K');
                                        break;
                                    }
                                } else {
                                    sb2.append('S');
                                    break;
                                }
                            } else {
                                sb2.append('X');
                                break;
                            }
                        }
                        break;
                    case 'D':
                        if (!isLastChar(length2, i + 1) && isNextChar(sb, i, 'G')) {
                            int i2 = i + 2;
                            if (FRONTV.indexOf(sb.charAt(i2)) >= 0) {
                                sb2.append('J');
                                i = i2;
                                break;
                            }
                        }
                        sb2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case CastEventCode.SINK_VIDEO_SIZE_DETERMINED:
                    case CastEventCode.SINK_AUDIO_FOCUS_REQUEST_FAILED:
                    case 'R':
                        sb2.append(charAt);
                        break;
                    case 'G':
                        int i3 = i + 1;
                        if ((!isLastChar(length2, i3) || !isNextChar(sb, i, 'H')) && ((isLastChar(length2, i3) || !isNextChar(sb, i, 'H') || isVowel(sb, i + 2)) && (i <= 0 || (!regionMatch(sb, i, "GN") && !regionMatch(sb, i, "GNED"))))) {
                            boolean isPreviousChar = isPreviousChar(sb, i, 'G');
                            if (!isLastChar(length2, i) && FRONTV.indexOf(sb.charAt(i3)) >= 0 && !isPreviousChar) {
                                sb2.append('J');
                                break;
                            } else {
                                sb2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!isLastChar(length2, i) && ((i <= 0 || VARSON.indexOf(sb.charAt(i - 1)) < 0) && isVowel(sb, i + 1))) {
                            sb2.append('H');
                            break;
                        }
                    case 'K':
                        if (i > 0) {
                            if (!isPreviousChar(sb, i, 'C')) {
                                sb2.append(charAt);
                                break;
                            }
                        } else {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (!isNextChar(sb, i, 'H')) {
                            sb2.append(charAt);
                            break;
                        } else {
                            sb2.append('F');
                            break;
                        }
                    case CastEventCode.SINK_AUDIO_FOCUS_LOST:
                        sb2.append('K');
                        break;
                    case CastEventCode.SOURCE_PAUSE_VIRTUAL_DISPLAY_SUCCESS:
                        if (!regionMatch(sb, i, "SH") && !regionMatch(sb, i, "SIO") && !regionMatch(sb, i, "SIA")) {
                            sb2.append('S');
                            break;
                        } else {
                            sb2.append('X');
                            break;
                        }
                        break;
                    case CastEventCode.SOURCE_RESUME_VIRTUAL_DISPLAY_SUCCESS:
                        if (!regionMatch(sb, i, "TIA") && !regionMatch(sb, i, "TIO")) {
                            if (!regionMatch(sb, i, "TCH")) {
                                if (!regionMatch(sb, i, "TH")) {
                                    sb2.append('T');
                                    break;
                                } else {
                                    sb2.append('0');
                                    break;
                                }
                            }
                        } else {
                            sb2.append('X');
                            break;
                        }
                        break;
                    case 'V':
                        sb2.append('F');
                        break;
                    case Opcodes.POP:
                    case Opcodes.DUP:
                        if (!isLastChar(length2, i) && isVowel(sb, i + 1)) {
                            sb2.append(charAt);
                            break;
                        }
                    case 'X':
                        sb2.append('K');
                        sb2.append('S');
                        break;
                    case ORIENTATION_90_VALUE:
                        sb2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (sb2.length() > getMaxCodeLen()) {
                sb2.setLength(getMaxCodeLen());
            }
        }
        return sb2.toString();
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    public String encode(String str) {
        return metaphone(str);
    }
}
