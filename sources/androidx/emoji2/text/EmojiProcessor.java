package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

@RequiresApi
@AnyThread
@RestrictTo
final class EmojiProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final EmojiCompat.SpanFactory f1202a;
    public final MetadataRepo b;
    public EmojiCompat.GlyphChecker c;
    public final boolean d;
    public final int[] e;

    @RequiresApi
    public static final class CodepointIndexFinder {
        public static int a(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z = true;
                    }
                }
                return i;
            }
        }

        public static int b(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i2--;
                            i = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i2--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z = true;
                        }
                    } else if (z) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    public static final class ProcessorSm {

        /* renamed from: a  reason: collision with root package name */
        public int f1203a = 1;
        public final MetadataRepo.Node b;
        public MetadataRepo.Node c;
        public MetadataRepo.Node d;
        public int e;
        public int f;
        public final boolean g;
        public final int[] h;

        public ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
            this.b = node;
            this.c = node;
            this.g = z;
            this.h = iArr;
        }

        public static boolean d(int i) {
            return i == 65039;
        }

        public static boolean f(int i) {
            return i == 65038;
        }

        public int a(int i) {
            MetadataRepo.Node a2 = this.c.a(i);
            int i2 = 2;
            if (this.f1203a != 2) {
                if (a2 == null) {
                    i2 = g();
                } else {
                    this.f1203a = 2;
                    this.c = a2;
                    this.f = 1;
                }
            } else if (a2 != null) {
                this.c = a2;
                this.f++;
            } else if (f(i)) {
                i2 = g();
            } else if (!d(i)) {
                if (this.c.b() != null) {
                    i2 = 3;
                    if (this.f != 1) {
                        this.d = this.c;
                        g();
                    } else if (h()) {
                        this.d = this.c;
                        g();
                    } else {
                        i2 = g();
                    }
                } else {
                    i2 = g();
                }
            }
            this.e = i;
            return i2;
        }

        public EmojiMetadata b() {
            return this.c.b();
        }

        public EmojiMetadata c() {
            return this.d.b();
        }

        public boolean e() {
            return this.f1203a == 2 && this.c.b() != null && (this.f > 1 || h());
        }

        public final int g() {
            this.f1203a = 1;
            this.c = this.b;
            this.f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.c.b().j() || d(this.e)) {
                return true;
            }
            if (this.g) {
                if (this.h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.h, this.c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z, int[] iArr) {
        this.f1202a = spanFactory;
        this.b = metadataRepo;
        this.c = glyphChecker;
        this.d = z;
        this.e = iArr;
    }

    public static boolean b(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            int length = emojiSpanArr.length;
            int i = 0;
            while (i < length) {
                EmojiSpan emojiSpan = emojiSpanArr[i];
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((!z || spanStart != selectionStart) && ((z || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                i4 = CodepointIndexFinder.a(editable, selectionStart, Math.max(i, 0));
                i3 = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i2, 0));
                if (i4 == -1 || i3 == -1) {
                    return false;
                }
            } else {
                i4 = Math.max(selectionStart - i, 0);
                i3 = Math.min(selectionEnd + i2, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(i4, i3, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    i4 = Math.min(spanStart, i4);
                    i3 = Math.max(spanEnd, i3);
                }
                int max = Math.max(i4, 0);
                int min = Math.min(i3, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean d(Editable editable, int i, KeyEvent keyEvent) {
        if (!(i != 67 ? i != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean f(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    public static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final void a(Spannable spannable, EmojiMetadata emojiMetadata, int i, int i2) {
        spannable.setSpan(this.f1202a.a(emojiMetadata), i, i2, 33);
    }

    public final boolean e(CharSequence charSequence, int i, int i2, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.d() == 0) {
            emojiMetadata.k(this.c.a(charSequence, i, i2, emojiMetadata.h()));
        }
        return emojiMetadata.d() == 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r0 == 0) goto L_0x000a
            r1 = r11
            androidx.emoji2.text.SpannableBuilder r1 = (androidx.emoji2.text.SpannableBuilder) r1
            r1.a()
        L_0x000a:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r1 = androidx.emoji2.text.EmojiSpan.class
            if (r0 != 0) goto L_0x002f
            boolean r2 = r11 instanceof android.text.Spannable     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0013
            goto L_0x002f
        L_0x0013:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x002d
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x002a }
            int r3 = r12 + -1
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch:{ all -> 0x002a }
            if (r2 > r13) goto L_0x002d
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            r2.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x002a }
            goto L_0x0037
        L_0x002a:
            r10 = move-exception
            goto L_0x012b
        L_0x002d:
            r2 = 0
            goto L_0x0037
        L_0x002f:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x002a }
            r2.<init>((android.text.Spannable) r3)     // Catch:{ all -> 0x002a }
        L_0x0037:
            r3 = 0
            if (r2 == 0) goto L_0x0063
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x0063
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            if (r5 <= 0) goto L_0x0063
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            r6 = r3
        L_0x0047:
            if (r6 >= r5) goto L_0x0063
            r7 = r4[r6]     // Catch:{ all -> 0x002a }
            int r8 = r2.getSpanStart(r7)     // Catch:{ all -> 0x002a }
            int r9 = r2.getSpanEnd(r7)     // Catch:{ all -> 0x002a }
            if (r8 == r13) goto L_0x0058
            r2.removeSpan(r7)     // Catch:{ all -> 0x002a }
        L_0x0058:
            int r12 = java.lang.Math.min(r8, r12)     // Catch:{ all -> 0x002a }
            int r13 = java.lang.Math.max(r9, r13)     // Catch:{ all -> 0x002a }
            int r6 = r6 + 1
            goto L_0x0047
        L_0x0063:
            if (r12 == r13) goto L_0x0122
            int r4 = r11.length()     // Catch:{ all -> 0x002a }
            if (r12 < r4) goto L_0x006d
            goto L_0x0122
        L_0x006d:
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r4) goto L_0x0080
            if (r2 == 0) goto L_0x0080
            int r4 = r2.length()     // Catch:{ all -> 0x002a }
            java.lang.Object[] r1 = r2.getSpans(r3, r4, r1)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r1 = (androidx.emoji2.text.EmojiSpan[]) r1     // Catch:{ all -> 0x002a }
            int r1 = r1.length     // Catch:{ all -> 0x002a }
            int r14 = r14 - r1
        L_0x0080:
            androidx.emoji2.text.EmojiProcessor$ProcessorSm r1 = new androidx.emoji2.text.EmojiProcessor$ProcessorSm     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.MetadataRepo r4 = r10.b     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.MetadataRepo$Node r4 = r4.f()     // Catch:{ all -> 0x002a }
            boolean r5 = r10.d     // Catch:{ all -> 0x002a }
            int[] r6 = r10.e     // Catch:{ all -> 0x002a }
            r1.<init>(r4, r5, r6)     // Catch:{ all -> 0x002a }
            int r4 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x002a }
            r5 = r4
            r4 = r3
            r3 = r2
        L_0x0096:
            r2 = r12
        L_0x0097:
            if (r12 >= r13) goto L_0x00e9
            if (r4 >= r14) goto L_0x00e9
            int r6 = r1.a(r5)     // Catch:{ all -> 0x002a }
            r7 = 1
            if (r6 == r7) goto L_0x00d7
            r7 = 2
            if (r6 == r7) goto L_0x00cb
            r7 = 3
            if (r6 == r7) goto L_0x00a9
            goto L_0x0097
        L_0x00a9:
            if (r15 != 0) goto L_0x00b5
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x002a }
            boolean r6 = r10.e(r11, r2, r12, r6)     // Catch:{ all -> 0x002a }
            if (r6 != 0) goto L_0x0096
        L_0x00b5:
            if (r3 != 0) goto L_0x00c1
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r3 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ all -> 0x002a }
            r6.<init>(r11)     // Catch:{ all -> 0x002a }
            r3.<init>((android.text.Spannable) r6)     // Catch:{ all -> 0x002a }
        L_0x00c1:
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x002a }
            r10.a(r3, r6, r2, r12)     // Catch:{ all -> 0x002a }
            int r4 = r4 + 1
            goto L_0x0096
        L_0x00cb:
            int r6 = java.lang.Character.charCount(r5)     // Catch:{ all -> 0x002a }
            int r12 = r12 + r6
            if (r12 >= r13) goto L_0x0097
            int r5 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x002a }
            goto L_0x0097
        L_0x00d7:
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x002a }
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x002a }
            int r2 = r2 + r12
            if (r2 >= r13) goto L_0x00e7
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x002a }
            r5 = r12
        L_0x00e7:
            r12 = r2
            goto L_0x0097
        L_0x00e9:
            boolean r13 = r1.e()     // Catch:{ all -> 0x002a }
            if (r13 == 0) goto L_0x010b
            if (r4 >= r14) goto L_0x010b
            if (r15 != 0) goto L_0x00fd
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x002a }
            boolean r13 = r10.e(r11, r2, r12, r13)     // Catch:{ all -> 0x002a }
            if (r13 != 0) goto L_0x010b
        L_0x00fd:
            if (r3 != 0) goto L_0x0104
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r3 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            r3.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x002a }
        L_0x0104:
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x002a }
            r10.a(r3, r13, r2, r12)     // Catch:{ all -> 0x002a }
        L_0x010b:
            if (r3 == 0) goto L_0x0119
            android.text.Spannable r10 = r3.b()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0118
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        L_0x0118:
            return r10
        L_0x0119:
            if (r0 == 0) goto L_0x0121
            r10 = r11
            androidx.emoji2.text.SpannableBuilder r10 = (androidx.emoji2.text.SpannableBuilder) r10
            r10.d()
        L_0x0121:
            return r11
        L_0x0122:
            if (r0 == 0) goto L_0x012a
            r10 = r11
            androidx.emoji2.text.SpannableBuilder r10 = (androidx.emoji2.text.SpannableBuilder) r10
            r10.d()
        L_0x012a:
            return r11
        L_0x012b:
            if (r0 == 0) goto L_0x0132
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        L_0x0132:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
