package okio;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import okio.Path;
import okio.internal.ResourceFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J:\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u0006H&JD\u0010/\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u0002\u0007\n\u0005\b20\u0001¨\u00065"}, d2 = {"Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "copy", "createDirectories", "dir", "mustCreate", "createDirectory", "createSymlink", "delete", "deleteRecursively", "fileOrDirectory", "exists", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "read", "T", "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,165:1\n52#2,21:166\n52#2,21:187\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/FileSystem\n*L\n67#1:166,21\n81#1:187,21\n*E\n"})
public abstract class FileSystem {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FileSystem RESOURCES;
    @NotNull
    @JvmField
    public static final FileSystem SYSTEM;
    @NotNull
    @JvmField
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "asOkioFileSystem", "Ljava/nio/file/FileSystem;", "get", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "get")
        public final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem) {
            Intrinsics.checkNotNullParameter(fileSystem, "<this>");
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* renamed from: -write$default  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object m1690write$default(okio.FileSystem r1, okio.Path r2, boolean r3, kotlin.jvm.functions.Function1 r4, int r5, java.lang.Object r6) throws java.io.IOException {
        /*
            if (r6 != 0) goto L_0x0049
            r5 = r5 & 2
            if (r5 == 0) goto L_0x0007
            r3 = 0
        L_0x0007:
            java.lang.String r5 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "writerAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            okio.Sink r1 = r1.sink(r2, r3)
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r1)
            r2 = 0
            r3 = 1
            java.lang.Object r4 = r4.invoke(r1)     // Catch:{ all -> 0x002e }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ all -> 0x0029 }
            goto L_0x002a
        L_0x0029:
            r2 = move-exception
        L_0x002a:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            goto L_0x0042
        L_0x002e:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ all -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r1)
        L_0x003c:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            r0 = r4
            r4 = r2
            r2 = r0
        L_0x0042:
            if (r2 != 0) goto L_0x0048
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        L_0x0048:
            throw r2
        L_0x0049:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Super calls with default arguments not supported in this target, function: write"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileSystem.m1690write$default(okio.FileSystem, okio.Path, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    static {
        FileSystem fileSystem;
        try {
            Class.forName("java.nio.file.Files");
            fileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            fileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = fileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, (FileSystem) null, 4, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.appendingSink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.createDirectories(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.createDirectory(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.delete(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            fileSystem.deleteRecursively(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "get")
    public static final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem) {
        return Companion.get(fileSystem);
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.listRecursively(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return fileSystem.openReadWrite(path, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.sink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    @kotlin.jvm.JvmName(name = "-read")
    /* renamed from: -read  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T m1691read(@org.jetbrains.annotations.NotNull okio.Path r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.BufferedSource, ? extends T> r4) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "readerAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            okio.Source r2 = r2.source(r3)
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r2)
            r3 = 1
            r0 = 0
            java.lang.Object r4 = r4.invoke(r2)     // Catch:{ all -> 0x0026 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            if (r2 == 0) goto L_0x0022
            r2.close()     // Catch:{ all -> 0x0021 }
            goto L_0x0022
        L_0x0021:
            r0 = move-exception
        L_0x0022:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            goto L_0x003a
        L_0x0026:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            if (r2 == 0) goto L_0x0034
            r2.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r2 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r2)
        L_0x0034:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            r1 = r0
            r0 = r4
            r4 = r1
        L_0x003a:
            if (r0 != 0) goto L_0x0040
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        L_0x0040:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileSystem.m1691read(okio.Path, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    @kotlin.jvm.JvmName(name = "-write")
    /* renamed from: -write  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T m1692write(@org.jetbrains.annotations.NotNull okio.Path r3, boolean r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.BufferedSink, ? extends T> r5) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "writerAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            okio.Sink r2 = r2.sink(r3, r4)
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)
            r3 = 1
            r4 = 0
            java.lang.Object r5 = r5.invoke(r2)     // Catch:{ all -> 0x0027 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            if (r2 == 0) goto L_0x0023
            r2.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            goto L_0x003b
        L_0x0027:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            if (r2 == 0) goto L_0x0035
            r2.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r2 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r5, r2)
        L_0x0035:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            r1 = r5
            r5 = r4
            r4 = r1
        L_0x003b:
            if (r4 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            return r5
        L_0x0041:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileSystem.m1692write(okio.Path, boolean, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public final Sink appendingSink(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return appendingSink(path, false);
    }

    @NotNull
    public abstract Sink appendingSink(@NotNull Path path, boolean z) throws IOException;

    public abstract void atomicMove(@NotNull Path path, @NotNull Path path2) throws IOException;

    @NotNull
    public abstract Path canonicalize(@NotNull Path path) throws IOException;

    public void copy(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        okio.internal.FileSystem.commonCopy(this, path, path2);
    }

    public final void createDirectories(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        okio.internal.FileSystem.commonCreateDirectories(this, path, z);
    }

    public final void createDirectory(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        createDirectory(path, false);
    }

    public abstract void createDirectory(@NotNull Path path, boolean z) throws IOException;

    public abstract void createSymlink(@NotNull Path path, @NotNull Path path2) throws IOException;

    public final void delete(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public abstract void delete(@NotNull Path path, boolean z) throws IOException;

    public void deleteRecursively(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        okio.internal.FileSystem.commonDeleteRecursively(this, path, z);
    }

    public final boolean exists(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.commonExists(this, path);
    }

    @NotNull
    public abstract List<Path> list(@NotNull Path path) throws IOException;

    @Nullable
    public abstract List<Path> listOrNull(@NotNull Path path);

    @NotNull
    public Sequence<Path> listRecursively(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return okio.internal.FileSystem.commonListRecursively(this, path, z);
    }

    @NotNull
    public final FileMetadata metadata(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    @Nullable
    public abstract FileMetadata metadataOrNull(@NotNull Path path) throws IOException;

    @NotNull
    public abstract FileHandle openReadOnly(@NotNull Path path) throws IOException;

    @NotNull
    public final FileHandle openReadWrite(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return openReadWrite(path, false, false);
    }

    @NotNull
    public abstract FileHandle openReadWrite(@NotNull Path path, boolean z, boolean z2) throws IOException;

    @NotNull
    public final Sink sink(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return sink(path, false);
    }

    @NotNull
    public abstract Sink sink(@NotNull Path path, boolean z) throws IOException;

    @NotNull
    public abstract Source source(@NotNull Path path) throws IOException;

    public final void createDirectories(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        createDirectories(path, false);
    }

    public final void deleteRecursively(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        deleteRecursively(path, false);
    }

    @NotNull
    public final Sequence<Path> listRecursively(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return listRecursively(path, false);
    }
}
