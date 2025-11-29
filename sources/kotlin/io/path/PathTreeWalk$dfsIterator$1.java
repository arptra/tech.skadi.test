package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n45#2,15:193\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n67#1:178,15\n78#1:193,15\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
public final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.sequences.SequenceScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0207 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x0069
            if (r1 == r6) goto L_0x004c
            if (r1 == r4) goto L_0x003b
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            goto L_0x003b
        L_0x0016:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x001e:
            java.lang.Object r1 = r14.L$5
            java.nio.file.Path r1 = (java.nio.file.Path) r1
            java.lang.Object r4 = r14.L$4
            kotlin.io.path.PathTreeWalk r4 = (kotlin.io.path.PathTreeWalk) r4
            java.lang.Object r7 = r14.L$3
            kotlin.io.path.PathNode r7 = (kotlin.io.path.PathNode) r7
            java.lang.Object r8 = r14.L$2
            kotlin.io.path.DirectoryEntriesReader r8 = (kotlin.io.path.DirectoryEntriesReader) r8
            java.lang.Object r9 = r14.L$1
            kotlin.collections.ArrayDeque r9 = (kotlin.collections.ArrayDeque) r9
            java.lang.Object r10 = r14.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x01a2
        L_0x003b:
            java.lang.Object r1 = r14.L$2
            kotlin.io.path.DirectoryEntriesReader r1 = (kotlin.io.path.DirectoryEntriesReader) r1
            java.lang.Object r4 = r14.L$1
            kotlin.collections.ArrayDeque r4 = (kotlin.collections.ArrayDeque) r4
            java.lang.Object r7 = r14.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x013c
        L_0x004c:
            java.lang.Object r1 = r14.L$5
            java.nio.file.Path r1 = (java.nio.file.Path) r1
            java.lang.Object r4 = r14.L$4
            kotlin.io.path.PathTreeWalk r4 = (kotlin.io.path.PathTreeWalk) r4
            java.lang.Object r7 = r14.L$3
            kotlin.io.path.PathNode r7 = (kotlin.io.path.PathNode) r7
            java.lang.Object r8 = r14.L$2
            kotlin.io.path.DirectoryEntriesReader r8 = (kotlin.io.path.DirectoryEntriesReader) r8
            java.lang.Object r9 = r14.L$1
            kotlin.collections.ArrayDeque r9 = (kotlin.collections.ArrayDeque) r9
            java.lang.Object r10 = r14.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00e2
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r7 = r15
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.collections.ArrayDeque r15 = new kotlin.collections.ArrayDeque
            r15.<init>()
            kotlin.io.path.DirectoryEntriesReader r1 = new kotlin.io.path.DirectoryEntriesReader
            kotlin.io.path.PathTreeWalk r8 = r14.this$0
            boolean r8 = r8.getFollowLinks()
            r1.<init>(r8)
            kotlin.io.path.PathNode r8 = new kotlin.io.path.PathNode
            kotlin.io.path.PathTreeWalk r9 = r14.this$0
            java.nio.file.Path r9 = r9.start
            kotlin.io.path.PathTreeWalk r10 = r14.this$0
            java.nio.file.Path r10 = r10.start
            kotlin.io.path.PathTreeWalk r11 = r14.this$0
            java.nio.file.LinkOption[] r11 = r11.getLinkOptions()
            java.lang.Object r10 = kotlin.io.path.PathTreeWalkKt.keyOf(r10, r11)
            r8.<init>(r9, r10, r5)
            kotlin.io.path.PathTreeWalk r9 = r14.this$0
            java.nio.file.Path r10 = r8.getPath()
            java.nio.file.LinkOption[] r11 = r9.getLinkOptions()
            int r12 = r11.length
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r12)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            int r12 = r11.length
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r12)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.isDirectory(r10, r11)
            if (r11 == 0) goto L_0x011b
            boolean r4 = kotlin.io.path.PathTreeWalkKt.createsCycle(r8)
            if (r4 != 0) goto L_0x0111
            boolean r4 = r9.getIncludeDirectories()
            if (r4 == 0) goto L_0x00e9
            r14.L$0 = r7
            r14.L$1 = r15
            r14.L$2 = r1
            r14.L$3 = r8
            r14.L$4 = r9
            r14.L$5 = r10
            r14.label = r6
            java.lang.Object r4 = r7.yield(r10, r14)
            if (r4 != r0) goto L_0x00db
            return r0
        L_0x00db:
            r4 = r9
            r9 = r15
            r13 = r8
            r8 = r1
            r1 = r10
            r10 = r7
            r7 = r13
        L_0x00e2:
            r15 = r9
            r9 = r4
            r13 = r10
            r10 = r1
            r1 = r8
            r8 = r7
            r7 = r13
        L_0x00e9:
            java.nio.file.LinkOption[] r4 = r9.getLinkOptions()
            int r9 = r4.length
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r9)
            java.nio.file.LinkOption[] r4 = (java.nio.file.LinkOption[]) r4
            int r9 = r4.length
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r9)
            java.nio.file.LinkOption[] r4 = (java.nio.file.LinkOption[]) r4
            boolean r4 = java.nio.file.Files.isDirectory(r10, r4)
            if (r4 == 0) goto L_0x010f
            java.util.List r4 = r1.readEntries(r8)
            java.util.Iterator r4 = r4.iterator()
            r8.setContentIterator(r4)
            r15.addLast(r8)
        L_0x010f:
            r4 = r15
            goto L_0x013c
        L_0x0111:
            java.nio.file.FileSystemLoopException r14 = new java.nio.file.FileSystemLoopException
            java.lang.String r15 = r10.toString()
            r14.<init>(r15)
            throw r14
        L_0x011b:
            java.nio.file.LinkOption r8 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            java.nio.file.LinkOption[] r8 = new java.nio.file.LinkOption[]{r8}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r6)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.exists(r10, r8)
            if (r8 == 0) goto L_0x010f
            r14.L$0 = r7
            r14.L$1 = r15
            r14.L$2 = r1
            r14.label = r4
            java.lang.Object r4 = r7.yield(r10, r14)
            if (r4 != r0) goto L_0x010f
            return r0
        L_0x013c:
            boolean r15 = r4.isEmpty()
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x0207
            java.lang.Object r15 = r4.last()
            kotlin.io.path.PathNode r15 = (kotlin.io.path.PathNode) r15
            java.util.Iterator r15 = r15.getContentIterator()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            boolean r8 = r15.hasNext()
            if (r8 == 0) goto L_0x0202
            java.lang.Object r15 = r15.next()
            kotlin.io.path.PathNode r15 = (kotlin.io.path.PathNode) r15
            kotlin.io.path.PathTreeWalk r8 = r14.this$0
            java.nio.file.Path r9 = r15.getPath()
            java.nio.file.LinkOption[] r10 = r8.getLinkOptions()
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.isDirectory(r9, r10)
            if (r10 == 0) goto L_0x01db
            boolean r10 = kotlin.io.path.PathTreeWalkKt.createsCycle(r15)
            if (r10 != 0) goto L_0x01d1
            boolean r10 = r8.getIncludeDirectories()
            if (r10 == 0) goto L_0x01a9
            r14.L$0 = r7
            r14.L$1 = r4
            r14.L$2 = r1
            r14.L$3 = r15
            r14.L$4 = r8
            r14.L$5 = r9
            r14.label = r3
            java.lang.Object r10 = r7.yield(r9, r14)
            if (r10 != r0) goto L_0x019b
            return r0
        L_0x019b:
            r10 = r7
            r7 = r15
            r13 = r8
            r8 = r1
            r1 = r9
            r9 = r4
            r4 = r13
        L_0x01a2:
            r15 = r7
            r7 = r10
            r13 = r9
            r9 = r1
            r1 = r8
            r8 = r4
            r4 = r13
        L_0x01a9:
            java.nio.file.LinkOption[] r8 = r8.getLinkOptions()
            int r10 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            int r10 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.isDirectory(r9, r8)
            if (r8 == 0) goto L_0x013c
            java.util.List r8 = r1.readEntries(r15)
            java.util.Iterator r8 = r8.iterator()
            r15.setContentIterator(r8)
            r4.addLast(r15)
            goto L_0x013c
        L_0x01d1:
            java.nio.file.FileSystemLoopException r14 = new java.nio.file.FileSystemLoopException
            java.lang.String r15 = r9.toString()
            r14.<init>(r15)
            throw r14
        L_0x01db:
            java.nio.file.LinkOption r15 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            java.nio.file.LinkOption[] r15 = new java.nio.file.LinkOption[]{r15}
            java.lang.Object[] r15 = java.util.Arrays.copyOf(r15, r6)
            java.nio.file.LinkOption[] r15 = (java.nio.file.LinkOption[]) r15
            boolean r15 = java.nio.file.Files.exists(r9, r15)
            if (r15 == 0) goto L_0x013c
            r14.L$0 = r7
            r14.L$1 = r4
            r14.L$2 = r1
            r14.L$3 = r5
            r14.L$4 = r5
            r14.L$5 = r5
            r14.label = r2
            java.lang.Object r15 = r7.yield(r9, r14)
            if (r15 != r0) goto L_0x013c
            return r0
        L_0x0202:
            r4.removeLast()
            goto L_0x013c
        L_0x0207:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
