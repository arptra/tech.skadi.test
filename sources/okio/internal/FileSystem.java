package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.FileMetadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n52#2,5:156\n52#2,21:161\n60#2,10:182\n57#2,2:192\n71#2,2:194\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,5\n66#1:161,21\n65#1:182,10\n65#1:192,2\n65#1:194,2\n*E\n"})
@JvmName(name = "-FileSystem")
/* renamed from: okio.internal.-FileSystem  reason: invalid class name */
public final class FileSystem {
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00de, code lost:
        if (r0 != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        if (r7 != 0) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        r6.addLast(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e9, code lost:
        r7 = r6;
        r10 = r11;
        r11 = r12;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0127, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0128, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0129, code lost:
        r7.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012c, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f6 A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0120 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super okio.Path> r15, @org.jetbrains.annotations.NotNull okio.FileSystem r16, @org.jetbrains.annotations.NotNull kotlin.collections.ArrayDeque<okio.Path> r17, @org.jetbrains.annotations.NotNull okio.Path r18, boolean r19, boolean r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r0 = r15
            r1 = r18
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof okio.internal.FileSystem$collectRecursively$1
            if (r4 == 0) goto L_0x001a
            r4 = r3
            okio.internal.-FileSystem$collectRecursively$1 r4 = (okio.internal.FileSystem$collectRecursively$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001a
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x001f
        L_0x001a:
            okio.internal.-FileSystem$collectRecursively$1 r4 = new okio.internal.-FileSystem$collectRecursively$1
            r4.<init>(r3)
        L_0x001f:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x007c
            if (r6 == r10) goto L_0x0060
            if (r6 == r9) goto L_0x0040
            if (r6 != r8) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0147
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.L$3
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r7 = r4.L$2
            kotlin.collections.ArrayDeque r7 = (kotlin.collections.ArrayDeque) r7
            java.lang.Object r10 = r4.L$1
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005d }
            goto L_0x00f0
        L_0x005d:
            r0 = move-exception
            goto L_0x0129
        L_0x0060:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$3
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.L$2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r11 = r4.L$1
            okio.FileSystem r11 = (okio.FileSystem) r11
            java.lang.Object r12 = r4.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r2
            r2 = r0
            r0 = r1
            r1 = r14
            goto L_0x00a5
        L_0x007c:
            kotlin.ResultKt.throwOnFailure(r3)
            if (r2 != 0) goto L_0x009c
            r4.L$0 = r0
            r3 = r16
            r4.L$1 = r3
            r6 = r17
            r4.L$2 = r6
            r4.L$3 = r1
            r11 = r19
            r4.Z$0 = r11
            r4.Z$1 = r2
            r4.label = r10
            java.lang.Object r12 = r15.yield(r1, r4)
            if (r12 != r5) goto L_0x00a2
            return r5
        L_0x009c:
            r3 = r16
            r6 = r17
            r11 = r19
        L_0x00a2:
            r12 = r0
            r0 = r11
            r11 = r3
        L_0x00a5:
            java.util.List r3 = r11.listOrNull(r1)
            if (r3 != 0) goto L_0x00af
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00af:
            boolean r13 = r3.isEmpty()
            r10 = r10 ^ r13
            if (r10 == 0) goto L_0x0131
            r10 = r1
        L_0x00b7:
            if (r0 == 0) goto L_0x00d8
            boolean r13 = r6.contains(r10)
            if (r13 != 0) goto L_0x00c0
            goto L_0x00d8
        L_0x00c0:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "symlink cycle at "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00d8:
            okio.Path r13 = symlinkTarget(r11, r10)
            if (r13 != 0) goto L_0x012d
            if (r0 != 0) goto L_0x00e2
            if (r7 != 0) goto L_0x0131
        L_0x00e2:
            r6.addLast(r10)
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0127 }
            r7 = r6
            r10 = r11
            r11 = r12
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r3
        L_0x00f0:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x0120
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005d }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x005d }
            r4.L$0 = r11     // Catch:{ all -> 0x005d }
            r4.L$1 = r10     // Catch:{ all -> 0x005d }
            r4.L$2 = r7     // Catch:{ all -> 0x005d }
            r4.L$3 = r6     // Catch:{ all -> 0x005d }
            r4.L$4 = r2     // Catch:{ all -> 0x005d }
            r4.Z$0 = r1     // Catch:{ all -> 0x005d }
            r4.Z$1 = r0     // Catch:{ all -> 0x005d }
            r4.label = r9     // Catch:{ all -> 0x005d }
            r15 = r11
            r16 = r10
            r17 = r7
            r18 = r3
            r19 = r1
            r20 = r0
            r21 = r4
            java.lang.Object r3 = collectRecursively(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x005d }
            if (r3 != r5) goto L_0x00f0
            return r5
        L_0x0120:
            r7.removeLast()
            r2 = r0
            r1 = r6
            r12 = r11
            goto L_0x0131
        L_0x0127:
            r0 = move-exception
            r7 = r6
        L_0x0129:
            r7.removeLast()
            throw r0
        L_0x012d:
            int r7 = r7 + 1
            r10 = r13
            goto L_0x00b7
        L_0x0131:
            if (r2 == 0) goto L_0x014a
            r0 = 0
            r4.L$0 = r0
            r4.L$1 = r0
            r4.L$2 = r0
            r4.L$3 = r0
            r4.L$4 = r0
            r4.label = r8
            java.lang.Object r0 = r12.yield(r1, r4)
            if (r0 != r5) goto L_0x0147
            return r5
        L_0x0147:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041 A[Catch:{ all -> 0x002f, all -> 0x0036, all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054 A[SYNTHETIC, Splitter:B:26:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void commonCopy(@org.jetbrains.annotations.NotNull okio.FileSystem r4, @org.jetbrains.annotations.NotNull okio.Path r5, @org.jetbrains.annotations.NotNull okio.Path r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            okio.Source r5 = r4.source(r5)
            r0 = 0
            okio.Sink r4 = r4.sink(r6)     // Catch:{ all -> 0x003b }
            okio.BufferedSink r4 = okio.Okio.buffer((okio.Sink) r4)     // Catch:{ all -> 0x003b }
            long r1 = r4.writeAll(r5)     // Catch:{ all -> 0x002f }
            java.lang.Long r6 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002d
            r4.close()     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
            r4 = move-exception
            goto L_0x003f
        L_0x002d:
            r4 = r0
            goto L_0x003f
        L_0x002f:
            r6 = move-exception
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003d
        L_0x0036:
            r4 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r6, r4)     // Catch:{ all -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r4 = move-exception
            goto L_0x0055
        L_0x003d:
            r4 = r6
            r6 = r0
        L_0x003f:
            if (r4 != 0) goto L_0x0054
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x003b }
            long r1 = r6.longValue()     // Catch:{ all -> 0x003b }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x003b }
            if (r5 == 0) goto L_0x0062
            r5.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0062
        L_0x0052:
            r0 = move-exception
            goto L_0x0062
        L_0x0054:
            throw r4     // Catch:{ all -> 0x003b }
        L_0x0055:
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r5)
        L_0x005f:
            r3 = r0
            r0 = r4
            r4 = r3
        L_0x0062:
            if (r0 != 0) goto L_0x0068
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return
        L_0x0068:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }

    public static final void commonCreateDirectories(@NotNull okio.FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.exists(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.parent();
        }
        if (!z || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                fileSystem.createDirectory((Path) it.next());
            }
            return;
        }
        throw new IOException(path + " already exists.");
    }

    public static final void commonDeleteRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation<? super FileSystem$commonDeleteRecursively$sequence$1>) null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final boolean commonExists(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt.sequence(new FileSystem$commonListRecursively$1(path, fileSystem, z, (Continuation<? super FileSystem$commonListRecursively$1>) null));
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }
}
