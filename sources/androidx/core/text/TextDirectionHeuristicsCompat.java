package androidx.core.text;

import java.util.Locale;

public final class TextDirectionHeuristicsCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f826a = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, false);
    public static final TextDirectionHeuristicCompat b = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, true);
    public static final TextDirectionHeuristicCompat c;
    public static final TextDirectionHeuristicCompat d;
    public static final TextDirectionHeuristicCompat e = new TextDirectionHeuristicInternal(AnyStrong.b, false);
    public static final TextDirectionHeuristicCompat f = TextDirectionHeuristicLocale.b;

    public static class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong b = new AnyStrong(true);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f827a;

        public AnyStrong(boolean z) {
            this.f827a = z;
        }

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f827a) {
                        return 1;
                    }
                } else if (this.f827a) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f827a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class FirstStrong implements TextDirectionAlgorithm {

        /* renamed from: a  reason: collision with root package name */
        public static final FirstStrong f828a = new FirstStrong();

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    public interface TextDirectionAlgorithm {
        int a(CharSequence charSequence, int i, int i2);
    }

    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* renamed from: a  reason: collision with root package name */
        public final TextDirectionAlgorithm f829a;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f829a = textDirectionAlgorithm;
        }

        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                return this.f829a == null ? b() : c(charSequence, i, i2);
            }
            throw new IllegalArgumentException();
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i, int i2) {
            int a2 = this.f829a.a(charSequence, i, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return b();
            }
            return false;
        }
    }

    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        public final boolean b;

        public TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.b = z;
        }

        public boolean b() {
            return this.b;
        }
    }

    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale b = new TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super((TextDirectionAlgorithm) null);
        }

        public boolean b() {
            return TextUtilsCompat.a(Locale.getDefault()) == 1;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f828a;
        c = new TextDirectionHeuristicInternal(firstStrong, false);
        d = new TextDirectionHeuristicInternal(firstStrong, true);
    }

    public static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
