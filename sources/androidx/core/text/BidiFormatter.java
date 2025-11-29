package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import kotlin.text.Typography;

public final class BidiFormatter {
    public static final TextDirectionHeuristicCompat d;
    public static final String e = Character.toString(8206);
    public static final String f = Character.toString(8207);
    public static final BidiFormatter g;
    public static final BidiFormatter h;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f820a;
    public final int b;
    public final TextDirectionHeuristicCompat c;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f821a;
        public int b;
        public TextDirectionHeuristicCompat c;

        public Builder() {
            c(BidiFormatter.e(Locale.getDefault()));
        }

        public static BidiFormatter b(boolean z) {
            return z ? BidiFormatter.h : BidiFormatter.g;
        }

        public BidiFormatter a() {
            return (this.b == 2 && this.c == BidiFormatter.d) ? b(this.f821a) : new BidiFormatter(this.f821a, this.b, this.c);
        }

        public final void c(boolean z) {
            this.f821a = z;
            this.c = BidiFormatter.d;
            this.b = 2;
        }
    }

    public static class DirectionalityEstimator {
        public static final byte[] f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f822a;
        public final boolean b;
        public final int c;
        public int d;
        public char e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.f822a = charSequence;
            this.b = z;
            this.c = charSequence.length();
        }

        public static byte c(char c2) {
            return c2 < 1792 ? f[c2] : Character.getDirectionality(c2);
        }

        public byte a() {
            char charAt = this.f822a.charAt(this.d - 1);
            this.e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f822a, this.d);
                this.d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.d--;
            byte c2 = c(this.e);
            if (!this.b) {
                return c2;
            }
            char c3 = this.e;
            return c3 == '>' ? h() : c3 == ';' ? f() : c2;
        }

        public byte b() {
            char charAt = this.f822a.charAt(this.d);
            this.e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f822a, this.d);
                this.d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.d++;
            byte c2 = c(this.e);
            if (!this.b) {
                return c2;
            }
            char c3 = this.e;
            return c3 == '<' ? i() : c3 == '&' ? g() : c2;
        }

        public int d() {
            this.d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.d < this.c && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        public int e() {
            this.d = this.c;
            int i = 0;
            while (true) {
                int i2 = i;
                while (this.d > 0) {
                    byte a2 = a();
                    if (a2 != 0) {
                        if (a2 == 1 || a2 == 2) {
                            if (i == 0) {
                                return 1;
                            }
                            if (i2 == 0) {
                            }
                        } else if (a2 != 9) {
                            switch (a2) {
                                case 14:
                                case 15:
                                    if (i2 == i) {
                                        return -1;
                                    }
                                    break;
                                case 16:
                                case 17:
                                    if (i2 == i) {
                                        return 1;
                                    }
                                    break;
                                case 18:
                                    i++;
                                    break;
                                default:
                                    if (i2 != 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            i--;
                        } else {
                            continue;
                        }
                    } else if (i == 0) {
                        return -1;
                    } else {
                        if (i2 == 0) {
                        }
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char charAt;
            int i = this.d;
            do {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f822a;
                int i3 = i2 - 1;
                this.d = i3;
                charAt = charSequence.charAt(i3);
                this.e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.d = i;
            this.e = ';';
            return 13;
        }

        public final byte g() {
            char charAt;
            do {
                int i = this.d;
                if (i >= this.c) {
                    return 12;
                }
                CharSequence charSequence = this.f822a;
                this.d = i + 1;
                charAt = charSequence.charAt(i);
                this.e = charAt;
            } while (charAt != ';');
            return 12;
        }

        public final byte h() {
            char charAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f822a;
                int i3 = i2 - 1;
                this.d = i3;
                char charAt2 = charSequence.charAt(i3);
                this.e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i4 = this.d;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f822a;
                        int i5 = i4 - 1;
                        this.d = i5;
                        charAt = charSequence2.charAt(i5);
                        this.e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.d = i;
            this.e = Typography.greater;
            return 13;
        }

        public final byte i() {
            char charAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 < this.c) {
                    CharSequence charSequence = this.f822a;
                    this.d = i2 + 1;
                    char charAt2 = charSequence.charAt(i2);
                    this.e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i3 = this.d;
                            if (i3 >= this.c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f822a;
                            this.d = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.d = i;
                    this.e = Typography.less;
                    return 13;
                }
            }
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.c;
        d = textDirectionHeuristicCompat;
        g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    public BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f820a = z;
        this.b = i;
        this.c = textDirectionHeuristicCompat;
    }

    public static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).e();
    }

    public static BidiFormatter c() {
        return new Builder().a();
    }

    public static boolean e(Locale locale) {
        return TextUtilsCompat.a(locale) == 1;
    }

    public boolean d() {
        return (this.b & 2) != 0;
    }

    public final String f(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean a2 = textDirectionHeuristicCompat.a(charSequence, 0, charSequence.length());
        return (this.f820a || (!a2 && b(charSequence) != 1)) ? this.f820a ? (!a2 || b(charSequence) == -1) ? f : "" : "" : e;
    }

    public final String g(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean a2 = textDirectionHeuristicCompat.a(charSequence, 0, charSequence.length());
        return (this.f820a || (!a2 && a(charSequence) != 1)) ? this.f820a ? (!a2 || a(charSequence) == -1) ? f : "" : "" : e;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.c, true);
    }

    public CharSequence i(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = textDirectionHeuristicCompat.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append(g(charSequence, a2 ? TextDirectionHeuristicsCompat.b : TextDirectionHeuristicsCompat.f826a));
        }
        if (a2 != this.f820a) {
            spannableStringBuilder.append(a2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(f(charSequence, a2 ? TextDirectionHeuristicsCompat.b : TextDirectionHeuristicsCompat.f826a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.c, true);
    }

    public String k(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, textDirectionHeuristicCompat, z).toString();
    }
}
