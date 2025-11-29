package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PublicSuffixDatabase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    @NotNull
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf("*");
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    @NotNull
    private static final byte[] WILDCARD_LABEL = {42};
    /* access modifiers changed from: private */
    @NotNull
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    @NotNull
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    @NotNull
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int i3;
            boolean z;
            int and;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            int length = bArr3.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = (i4 + length) / 2;
                while (i5 > -1 && bArr3[i5] != 10) {
                    i5--;
                }
                int i6 = i5 + 1;
                int i7 = 1;
                while (true) {
                    i2 = i6 + i7;
                    if (bArr3[i2] == 10) {
                        break;
                    }
                    i7++;
                }
                int i8 = i2 - i6;
                int i9 = i;
                boolean z2 = false;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        i3 = Util.and(bArr4[i9][i10], 255);
                        z = z3;
                    }
                    and = i3 - Util.and(bArr3[i6 + i11], 255);
                    if (and != 0) {
                        break;
                    }
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr4[i9].length != i10) {
                        z2 = z;
                    } else if (i9 == bArr4.length - 1) {
                        break;
                    } else {
                        i9++;
                        z2 = true;
                        i10 = -1;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i12 = i8 - i11;
                        int length2 = bArr4[i9].length - i10;
                        int length3 = bArr4.length;
                        for (int i13 = i9 + 1; i13 < length3; i13++) {
                            length2 += bArr4[i13].length;
                        }
                        if (length2 >= i12) {
                            if (length2 <= i12) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                                return new String(bArr3, i6, i8, charset);
                            }
                        }
                    }
                    i4 = i2 + 1;
                }
                length = i5;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r18) {
        /*
            r17 = this;
            r0 = r17
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.listRead
            boolean r1 = r1.get()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0018
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.listRead
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0018
            r17.readTheListUninterruptibly()
            goto L_0x0025
        L_0x0018:
            java.util.concurrent.CountDownLatch r1 = r0.readCompleteLatch     // Catch:{ InterruptedException -> 0x001e }
            r1.await()     // Catch:{ InterruptedException -> 0x001e }
            goto L_0x0025
        L_0x001e:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L_0x0025:
            byte[] r1 = r0.publicSuffixListBytes
            if (r1 == 0) goto L_0x010c
            int r1 = r18.size()
            byte[][] r4 = new byte[r1][]
            r5 = r2
        L_0x0030:
            if (r5 >= r1) goto L_0x004e
            r6 = r18
            java.lang.Object r7 = r6.get(r5)
            java.lang.String r7 = (java.lang.String) r7
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r9 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            byte[] r7 = r7.getBytes(r8)
            java.lang.String r8 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r4[r5] = r7
            int r5 = r5 + r3
            goto L_0x0030
        L_0x004e:
            r5 = r2
        L_0x004f:
            java.lang.String r6 = "publicSuffixListBytes"
            r7 = 0
            if (r5 >= r1) goto L_0x0067
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r8 = Companion
            byte[] r9 = r0.publicSuffixListBytes
            if (r9 != 0) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r9 = r7
        L_0x005e:
            java.lang.String r8 = r8.binarySearch(r9, r4, r5)
            if (r8 == 0) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            int r5 = r5 + r3
            goto L_0x004f
        L_0x0067:
            r8 = r7
        L_0x0068:
            if (r1 <= r3) goto L_0x008d
            java.lang.Object r5 = r4.clone()
            byte[][] r5 = (byte[][]) r5
            int r9 = r5.length
            int r9 = r9 - r3
            r10 = r2
        L_0x0073:
            if (r10 >= r9) goto L_0x008d
            byte[] r11 = WILDCARD_LABEL
            r5[r10] = r11
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r11 = Companion
            byte[] r12 = r0.publicSuffixListBytes
            if (r12 != 0) goto L_0x0083
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r12 = r7
        L_0x0083:
            java.lang.String r11 = r11.binarySearch(r12, r5, r10)
            if (r11 == 0) goto L_0x008b
            r5 = r11
            goto L_0x008e
        L_0x008b:
            int r10 = r10 + r3
            goto L_0x0073
        L_0x008d:
            r5 = r7
        L_0x008e:
            if (r5 == 0) goto L_0x00aa
            int r1 = r1 - r3
            r6 = r2
        L_0x0092:
            if (r6 >= r1) goto L_0x00aa
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r9 = Companion
            byte[] r10 = r0.publicSuffixExceptionListBytes
            if (r10 != 0) goto L_0x00a0
            java.lang.String r10 = "publicSuffixExceptionListBytes"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = r7
        L_0x00a0:
            java.lang.String r9 = r9.binarySearch(r10, r4, r6)
            if (r9 == 0) goto L_0x00a8
            r7 = r9
            goto L_0x00aa
        L_0x00a8:
            int r6 = r6 + r3
            goto L_0x0092
        L_0x00aa:
            r0 = 46
            if (r7 == 0) goto L_0x00cc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r4 = 33
            r1.append(r4)
            r1.append(r7)
            java.lang.String r8 = r1.toString()
            char[] r9 = new char[r3]
            r9[r2] = r0
            r12 = 6
            r13 = 0
            r10 = 0
            r11 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r8, (char[]) r9, (boolean) r10, (int) r11, (int) r12, (java.lang.Object) r13)
            return r0
        L_0x00cc:
            if (r8 != 0) goto L_0x00d3
            if (r5 != 0) goto L_0x00d3
            java.util.List<java.lang.String> r0 = PREVAILING_RULE
            return r0
        L_0x00d3:
            if (r8 == 0) goto L_0x00e5
            char[] r7 = new char[r3]
            r7[r2] = r0
            r10 = 6
            r11 = 0
            r1 = 0
            r9 = 0
            r6 = r8
            r8 = r1
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r6, (char[]) r7, (boolean) r8, (int) r9, (int) r10, (java.lang.Object) r11)
            if (r1 != 0) goto L_0x00e9
        L_0x00e5:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00e9:
            if (r5 == 0) goto L_0x00fb
            char[] r12 = new char[r3]
            r12[r2] = r0
            r15 = 6
            r16 = 0
            r13 = 0
            r14 = 0
            r11 = r5
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (char[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
            if (r0 != 0) goto L_0x00ff
        L_0x00fb:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00ff:
            int r2 = r1.size()
            int r3 = r0.size()
            if (r2 <= r3) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r1 = r0
        L_0x010b:
            return r1
        L_0x010c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unable to load publicsuffixes.gz resource from the classpath."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r5 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x005d }
            r0.<init>()     // Catch:{ all -> 0x005d }
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r2 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r3 = "publicsuffixes.gz"
            java.io.InputStream r2 = r2.getResourceAsStream(r3)     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x001a
            java.util.concurrent.CountDownLatch r5 = r5.readCompleteLatch
            r5.countDown()
            return
        L_0x001a:
            okio.GzipSource r3 = new okio.GzipSource     // Catch:{ all -> 0x005d }
            okio.Source r2 = okio.Okio.source((java.io.InputStream) r2)     // Catch:{ all -> 0x005d }
            r3.<init>(r2)     // Catch:{ all -> 0x005d }
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x005d }
            int r3 = r2.readInt()     // Catch:{ all -> 0x0062 }
            long r3 = (long) r3     // Catch:{ all -> 0x0062 }
            byte[] r3 = r2.readByteArray(r3)     // Catch:{ all -> 0x0062 }
            r0.element = r3     // Catch:{ all -> 0x0062 }
            int r3 = r2.readInt()     // Catch:{ all -> 0x0062 }
            long r3 = (long) r3     // Catch:{ all -> 0x0062 }
            byte[] r3 = r2.readByteArray(r3)     // Catch:{ all -> 0x0062 }
            r1.element = r3     // Catch:{ all -> 0x0062 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0062 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x005d }
            monitor-enter(r5)     // Catch:{ all -> 0x005d }
            T r0 = r0.element     // Catch:{ all -> 0x005f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x005f }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x005f }
            r5.publicSuffixListBytes = r0     // Catch:{ all -> 0x005f }
            T r0 = r1.element     // Catch:{ all -> 0x005f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x005f }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x005f }
            r5.publicSuffixExceptionListBytes = r0     // Catch:{ all -> 0x005f }
            monitor-exit(r5)     // Catch:{ all -> 0x005d }
            java.util.concurrent.CountDownLatch r5 = r5.readCompleteLatch
            r5.countDown()
            return
        L_0x005d:
            r0 = move-exception
            goto L_0x0069
        L_0x005f:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x005d }
            throw r0     // Catch:{ all -> 0x005d }
        L_0x0062:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x005d }
            throw r1     // Catch:{ all -> 0x005d }
        L_0x0069:
            java.util.concurrent.CountDownLatch r5 = r5.readCompleteLatch
            r5.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r4 = this;
            r0 = 0
        L_0x0001:
            r4.readTheList()     // Catch:{ InterruptedIOException -> 0x0027, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r4 = move-exception
            goto L_0x002c
        L_0x0010:
            r4 = move-exception
            okhttp3.internal.platform.Platform$Companion r1 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r1 = r1.get()     // Catch:{ all -> 0x000e }
            java.lang.String r2 = "Failed to read public suffix list"
            r3 = 5
            r1.log(r2, r3, r4)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0026
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x0026:
            return
        L_0x0027:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002c:
            if (r0 == 0) goto L_0x0035
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0035:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    private final List<String> splitDomain(String str) {
        List<String> split$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics.areEqual(CollectionsKt.last(split$default), (Object) "") ? CollectionsKt.dropLast(split$default, 1) : split$default;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String str) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(str, "domain");
        String unicode = IDN.toUnicode(str);
        Intrinsics.checkNotNullExpressionValue(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(str)), size - size2), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final void setListBytes(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
