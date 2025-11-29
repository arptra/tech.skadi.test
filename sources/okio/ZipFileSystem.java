package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;
import okio.internal.ZipEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", "", "Lokio/internal/ZipEntry;", "comment", "", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "appendingSink", "Lokio/Sink;", "file", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,175:1\n52#2,5:176\n52#2,21:181\n60#2,10:202\n57#2,2:212\n71#2,2:214\n52#2,21:216\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n102#1:176,5\n103#1:181,21\n102#1:202,10\n102#1:212,2\n102#1:214,2\n132#1:216,21\n*E\n"})
public final class ZipFileSystem extends FileSystem {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    @Nullable
    private final String comment;
    @NotNull
    private final Map<Path, ZipEntry> entries;
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final Path zipPath;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }

        private Companion() {
        }
    }

    public ZipFileSystem(@NotNull Path path, @NotNull FileSystem fileSystem2, @NotNull Map<Path, ZipEntry> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(path, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(map, "entries");
        this.zipPath = path;
        this.fileSystem = fileSystem2;
        this.entries = map;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @NotNull
    public Sink appendingSink(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    public void atomicMove(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path canonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(canonicalizeInternal)) {
            return canonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    public void createDirectory(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "dir");
        throw new IOException("zip file systems are read-only");
    }

    public void createSymlink(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        throw new IOException("zip file systems are read-only");
    }

    public void delete(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @NotNull
    public List<Path> list(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        List<Path> list = list(path, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Nullable
    public List<Path> listOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return list(path, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A[Catch:{ all -> 0x006e, all -> 0x0075, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A[SYNTHETIC, Splitter:B:36:0x008b] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.FileMetadata metadataOrNull(@org.jetbrains.annotations.NotNull okio.Path r14) {
        /*
            r13 = this;
            java.lang.String r0 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            okio.Path r14 = r13.canonicalizeInternal(r14)
            java.util.Map<okio.Path, okio.internal.ZipEntry> r0 = r13.entries
            java.lang.Object r14 = r0.get(r14)
            okio.internal.ZipEntry r14 = (okio.internal.ZipEntry) r14
            r0 = 0
            if (r14 != 0) goto L_0x0015
            return r0
        L_0x0015:
            okio.FileMetadata r12 = new okio.FileMetadata
            boolean r1 = r14.isDirectory()
            r2 = r1 ^ 1
            boolean r3 = r14.isDirectory()
            boolean r1 = r14.isDirectory()
            if (r1 == 0) goto L_0x0029
            r5 = r0
            goto L_0x0032
        L_0x0029:
            long r4 = r14.getSize()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r5 = r1
        L_0x0032:
            java.lang.Long r7 = r14.getLastModifiedAtMillis()
            r10 = 128(0x80, float:1.794E-43)
            r11 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            long r1 = r14.getOffset()
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x004c
            return r12
        L_0x004c:
            okio.FileSystem r1 = r13.fileSystem
            okio.Path r13 = r13.zipPath
            okio.FileHandle r13 = r1.openReadOnly(r13)
            long r1 = r14.getOffset()     // Catch:{ all -> 0x007a }
            okio.Source r14 = r13.source(r1)     // Catch:{ all -> 0x007a }
            okio.BufferedSource r14 = okio.Okio.buffer((okio.Source) r14)     // Catch:{ all -> 0x007a }
            okio.FileMetadata r1 = okio.internal.ZipFilesKt.readLocalHeader(r14, r12)     // Catch:{ all -> 0x006e }
            if (r14 == 0) goto L_0x006c
            r14.close()     // Catch:{ all -> 0x006a }
            goto L_0x006c
        L_0x006a:
            r14 = move-exception
            goto L_0x007e
        L_0x006c:
            r14 = r0
            goto L_0x007e
        L_0x006e:
            r1 = move-exception
            if (r14 == 0) goto L_0x007c
            r14.close()     // Catch:{ all -> 0x0075 }
            goto L_0x007c
        L_0x0075:
            r14 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r1, r14)     // Catch:{ all -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r14 = move-exception
            goto L_0x008c
        L_0x007c:
            r14 = r1
            r1 = r0
        L_0x007e:
            if (r14 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x007a }
            if (r13 == 0) goto L_0x0098
            r13.close()     // Catch:{ all -> 0x0089 }
            goto L_0x0098
        L_0x0089:
            r0 = move-exception
            goto L_0x0098
        L_0x008b:
            throw r14     // Catch:{ all -> 0x007a }
        L_0x008c:
            if (r13 == 0) goto L_0x0096
            r13.close()     // Catch:{ all -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r13 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r14, r13)
        L_0x0096:
            r1 = r0
            r0 = r14
        L_0x0098:
            if (r0 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            return r1
        L_0x009e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.metadataOrNull(okio.Path):okio.FileMetadata");
    }

    @NotNull
    public FileHandle openReadOnly(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @NotNull
    public FileHandle openReadWrite(@NotNull Path path, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip entries are not writable");
    }

    @NotNull
    public Sink sink(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.Source source(@org.jetbrains.annotations.NotNull okio.Path r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            okio.Path r0 = r6.canonicalizeInternal(r7)
            java.util.Map<okio.Path, okio.internal.ZipEntry> r1 = r6.entries
            java.lang.Object r0 = r1.get(r0)
            okio.internal.ZipEntry r0 = (okio.internal.ZipEntry) r0
            if (r0 == 0) goto L_0x0077
            okio.FileSystem r7 = r6.fileSystem
            okio.Path r6 = r6.zipPath
            okio.FileHandle r6 = r7.openReadOnly(r6)
            r7 = 0
            long r1 = r0.getOffset()     // Catch:{ all -> 0x0030 }
            okio.Source r1 = r6.source(r1)     // Catch:{ all -> 0x0030 }
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)     // Catch:{ all -> 0x0030 }
            if (r6 == 0) goto L_0x003e
            r6.close()     // Catch:{ all -> 0x002e }
            goto L_0x003e
        L_0x002e:
            r7 = move-exception
            goto L_0x003e
        L_0x0030:
            r1 = move-exception
            if (r6 == 0) goto L_0x003b
            r6.close()     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r6 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r1, r6)
        L_0x003b:
            r5 = r1
            r1 = r7
            r7 = r5
        L_0x003e:
            if (r7 != 0) goto L_0x0076
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            okio.internal.ZipFilesKt.skipLocalHeader(r1)
            int r6 = r0.getCompressionMethod()
            r7 = 1
            if (r6 != 0) goto L_0x0057
            okio.internal.FixedLengthSource r6 = new okio.internal.FixedLengthSource
            long r2 = r0.getSize()
            r6.<init>(r1, r2, r7)
            goto L_0x0075
        L_0x0057:
            okio.InflaterSource r6 = new okio.InflaterSource
            okio.internal.FixedLengthSource r2 = new okio.internal.FixedLengthSource
            long r3 = r0.getCompressedSize()
            r2.<init>(r1, r3, r7)
            java.util.zip.Inflater r1 = new java.util.zip.Inflater
            r1.<init>(r7)
            r6.<init>((okio.Source) r2, (java.util.zip.Inflater) r1)
            okio.internal.FixedLengthSource r7 = new okio.internal.FixedLengthSource
            long r0 = r0.getSize()
            r2 = 0
            r7.<init>(r6, r0, r2)
            r6 = r7
        L_0x0075:
            return r6
        L_0x0076:
            throw r7
        L_0x0077:
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "no such file: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.source(okio.Path):okio.Source");
    }

    private final List<Path> list(Path path, boolean z) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return CollectionsKt.toList(zipEntry.getChildren());
        }
        if (!z) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }
}
