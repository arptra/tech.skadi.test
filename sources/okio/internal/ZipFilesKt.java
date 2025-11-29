package okio.internal;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,459:1\n1045#2:460\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n156#1:460\n*E\n"})
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(path, new ZipEntry(path, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null)));
        for (T t : CollectionsKt.sortedWith(list, new ZipFilesKt$buildIndex$$inlined$sortedBy$1())) {
            if (mutableMapOf.put(t.getCanonicalPath(), t) == null) {
                while (true) {
                    Path parent = t.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry = mutableMapOf.get(parent);
                    if (zipEntry != null) {
                        zipEntry.getChildren().add(t.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry2 = r4;
                    ZipEntry zipEntry3 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null);
                    ZipEntry zipEntry4 = zipEntry2;
                    mutableMapOf.put(parent, zipEntry4);
                    zipEntry4.getChildren().add(t.getCanonicalPath());
                    t = zipEntry4;
                }
            }
        }
        return mutableMapOf;
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r10.close();
        r4 = r4 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        if (r4 <= 0) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        r4 = okio.Okio.buffer(r3.source(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
        if (r4.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
        r5 = r4.readIntLe();
        r12 = r4.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if (r4.readIntLe() != 1) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007b, code lost:
        if (r5 != 0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        r5 = okio.Okio.buffer(r3.source(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r10 = r5.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        if (r10 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        r8 = readZip64EocdRecord(r5, r8);
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c4, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d4, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e6, code lost:
        r4 = new java.util.ArrayList();
        r5 = okio.Okio.buffer(r3.source(r8.getCentralDirectoryOffset()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r12 = r8.getEntryCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fd, code lost:
        if (r6 >= r12) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ff, code lost:
        r10 = readEntry(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
        if (r10.getOffset() >= r8.getCentralDirectoryOffset()) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0119, code lost:
        if (r2.invoke(r10).booleanValue() == false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011b, code lost:
        r4.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0120, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0122, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012d, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012e, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, buildIndex(r4), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013c, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013f, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0141, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0142, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0146, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        r8 = readEocdRecord(r10);
        r9 = r10.readUtf8((long) r8.getCommentByteCount());
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(@org.jetbrains.annotations.NotNull okio.Path r18, @org.jetbrains.annotations.NotNull okio.FileSystem r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r20) throws java.io.IOException {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            okio.FileHandle r3 = r1.openReadOnly(r0)
            long r4 = r3.size()     // Catch:{ all -> 0x00db }
            r6 = 22
            long r6 = (long) r6     // Catch:{ all -> 0x00db }
            long r4 = r4 - r6
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0161
            r8 = 65536(0x10000, double:3.2379E-319)
            long r8 = r4 - r8
            long r8 = java.lang.Math.max(r8, r6)     // Catch:{ all -> 0x00db }
        L_0x0031:
            okio.Source r10 = r3.source(r4)     // Catch:{ all -> 0x00db }
            okio.BufferedSource r10 = okio.Okio.buffer((okio.Source) r10)     // Catch:{ all -> 0x00db }
            int r11 = r10.readIntLe()     // Catch:{ all -> 0x0147 }
            r12 = 101010256(0x6054b50, float:2.506985E-35)
            if (r11 != r12) goto L_0x0149
            okio.internal.EocdRecord r8 = readEocdRecord(r10)     // Catch:{ all -> 0x0147 }
            int r9 = r8.getCommentByteCount()     // Catch:{ all -> 0x0147 }
            long r11 = (long) r9     // Catch:{ all -> 0x0147 }
            java.lang.String r9 = r10.readUtf8(r11)     // Catch:{ all -> 0x0147 }
            r10.close()     // Catch:{ all -> 0x00db }
            r10 = 20
            long r10 = (long) r10     // Catch:{ all -> 0x00db }
            long r4 = r4 - r10
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r11 = 0
            if (r10 <= 0) goto L_0x00e6
            okio.Source r4 = r3.source(r4)     // Catch:{ all -> 0x00db }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ all -> 0x00db }
            int r5 = r4.readIntLe()     // Catch:{ all -> 0x0098 }
            r10 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r5 != r10) goto L_0x00d5
            int r5 = r4.readIntLe()     // Catch:{ all -> 0x0098 }
            long r12 = r4.readLongLe()     // Catch:{ all -> 0x0098 }
            int r10 = r4.readIntLe()     // Catch:{ all -> 0x0098 }
            r14 = 1
            if (r10 != r14) goto L_0x00cc
            if (r5 != 0) goto L_0x00cc
            okio.Source r5 = r3.source(r12)     // Catch:{ all -> 0x0098 }
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r5)     // Catch:{ all -> 0x0098 }
            int r10 = r5.readIntLe()     // Catch:{ all -> 0x009b }
            r12 = 101075792(0x6064b50, float:2.525793E-35)
            if (r10 != r12) goto L_0x009e
            okio.internal.EocdRecord r8 = readZip64EocdRecord(r5, r8)     // Catch:{ all -> 0x009b }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009b }
            kotlin.io.CloseableKt.closeFinally(r5, r11)     // Catch:{ all -> 0x0098 }
            goto L_0x00d5
        L_0x0098:
            r0 = move-exception
            r1 = r0
            goto L_0x00df
        L_0x009b:
            r0 = move-exception
            r1 = r0
            goto L_0x00c5
        L_0x009e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r1.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = getHex(r12)     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = " but was "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = getHex(r10)     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009b }
            r0.<init>(r1)     // Catch:{ all -> 0x009b }
            throw r0     // Catch:{ all -> 0x009b }
        L_0x00c5:
            throw r1     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x0098 }
            throw r2     // Catch:{ all -> 0x0098 }
        L_0x00cc:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x0098 }
            throw r0     // Catch:{ all -> 0x0098 }
        L_0x00d5:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0098 }
            kotlin.io.CloseableKt.closeFinally(r4, r11)     // Catch:{ all -> 0x00db }
            goto L_0x00e6
        L_0x00db:
            r0 = move-exception
            r1 = r0
            goto L_0x017c
        L_0x00df:
            throw r1     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x00db }
            throw r2     // Catch:{ all -> 0x00db }
        L_0x00e6:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00db }
            r4.<init>()     // Catch:{ all -> 0x00db }
            long r12 = r8.getCentralDirectoryOffset()     // Catch:{ all -> 0x00db }
            okio.Source r5 = r3.source(r12)     // Catch:{ all -> 0x00db }
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r5)     // Catch:{ all -> 0x00db }
            long r12 = r8.getEntryCount()     // Catch:{ all -> 0x011f }
        L_0x00fb:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x012e
            okio.internal.ZipEntry r10 = readEntry(r5)     // Catch:{ all -> 0x011f }
            long r14 = r10.getOffset()     // Catch:{ all -> 0x011f }
            long r16 = r8.getCentralDirectoryOffset()     // Catch:{ all -> 0x011f }
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x0126
            java.lang.Object r14 = r2.invoke(r10)     // Catch:{ all -> 0x011f }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x011f }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x011f }
            if (r14 == 0) goto L_0x0122
            r4.add(r10)     // Catch:{ all -> 0x011f }
            goto L_0x0122
        L_0x011f:
            r0 = move-exception
            r1 = r0
            goto L_0x0140
        L_0x0122:
            r14 = 1
            long r6 = r6 + r14
            goto L_0x00fb
        L_0x0126:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011f }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x011f }
            throw r0     // Catch:{ all -> 0x011f }
        L_0x012e:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011f }
            kotlin.io.CloseableKt.closeFinally(r5, r11)     // Catch:{ all -> 0x00db }
            java.util.Map r2 = buildIndex(r4)     // Catch:{ all -> 0x00db }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x00db }
            r4.<init>(r0, r1, r2, r9)     // Catch:{ all -> 0x00db }
            kotlin.io.CloseableKt.closeFinally(r3, r11)
            return r4
        L_0x0140:
            throw r1     // Catch:{ all -> 0x0141 }
        L_0x0141:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x00db }
            throw r2     // Catch:{ all -> 0x00db }
        L_0x0147:
            r0 = move-exception
            goto L_0x015d
        L_0x0149:
            r10.close()     // Catch:{ all -> 0x00db }
            r10 = -1
            long r4 = r4 + r10
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0155
            goto L_0x0031
        L_0x0155:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00db }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00db }
        L_0x015d:
            r10.close()     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00db }
        L_0x0161:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r1.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "not a zip: size="
            r1.append(r2)     // Catch:{ all -> 0x00db }
            long r4 = r3.size()     // Catch:{ all -> 0x00db }
            r1.append(r4)     // Catch:{ all -> 0x00db }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00db }
            r0.<init>(r1)     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00db }
        L_0x017c:
            throw r1     // Catch:{ all -> 0x017d }
        L_0x017d:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipFilesKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    @NotNull
    public static final ZipEntry readEntry(@NotNull BufferedSource bufferedSource) throws IOException {
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe();
            short s = readShortLe & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & UShort.MAX_VALUE, bufferedSource.readShortLe() & UShort.MAX_VALUE);
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & 4294967295L;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe3);
                if (!StringsKt.contains$default((CharSequence) readUtf8, 0, false, 2, (Object) null)) {
                    long j = longRef2.element == 4294967295L ? (long) 8 : 0;
                    long j2 = longRef.element == 4294967295L ? j + ((long) 8) : j;
                    String str = readUtf8;
                    if (longRef3.element == 4294967295L) {
                        j2 += (long) 8;
                    }
                    long j3 = j2;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    long j4 = readIntLe2;
                    ZipFilesKt$readEntry$1 zipFilesKt$readEntry$1 = r0;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    String str2 = str;
                    Ref.LongRef longRef4 = longRef3;
                    ZipFilesKt$readEntry$1 zipFilesKt$readEntry$12 = new ZipFilesKt$readEntry$1(booleanRef, j3, longRef2, bufferedSource, longRef, longRef3);
                    readExtra(bufferedSource2, readShortLe4, zipFilesKt$readEntry$1);
                    if (j3 <= 0 || booleanRef2.element) {
                        String str3 = str2;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(str3), StringsKt.endsWith$default(str3, "/", false, 2, (Object) null), bufferedSource2.readUtf8((long) readShortLe5), j4, longRef.element, longRef2.element, readShortLe2, dosDateTimeToEpochMillis, longRef4.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(s));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & UShort.MAX_VALUE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & UShort.MAX_VALUE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, 4294967295L & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = (long) i;
        while (j != 0) {
            if (j >= 4) {
                short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - ((long) 4);
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i2 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    @NotNull
    public static final FileMetadata readLocalHeader(@NotNull BufferedSource bufferedSource, @NotNull FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(fileMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        BufferedSource bufferedSource2 = bufferedSource;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(2);
            short readShortLe = bufferedSource.readShortLe();
            short s = readShortLe & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource2.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) readShortLe3);
                    return null;
                }
                readExtra(bufferedSource2, readShortLe3, new ZipFilesKt$readOrSkipLocalHeader$1(bufferedSource2, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), (Path) null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(s));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (FileMetadata) null);
    }
}
