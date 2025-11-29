package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/upuphone/ar/tici/phone/utils/FileUtils$getFileSize$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileUtils$getFileSize$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileUtils$getFileSize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUtils$getFileSize$2(Uri uri, Context context, Continuation<? super FileUtils$getFileSize$2> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileUtils$getFileSize$2(this.$uri, this.$context, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            if (r0 != 0) goto L_0x006d
            kotlin.ResultKt.throwOnFailure(r5)
            android.net.Uri r5 = r4.$uri
            java.lang.String r5 = r5.getScheme()
            r0 = 0
            if (r5 == 0) goto L_0x0068
            int r2 = r5.hashCode()
            r3 = 3143036(0x2ff57c, float:4.404332E-39)
            if (r2 == r3) goto L_0x004d
            r3 = 951530617(0x38b73479, float:8.735894E-5)
            if (r2 == r3) goto L_0x0023
            goto L_0x0068
        L_0x0023:
            java.lang.String r2 = "content"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            android.content.Context r5 = r4.$context     // Catch:{ Exception -> 0x0068 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x0068 }
            android.net.Uri r4 = r4.$uri     // Catch:{ Exception -> 0x0068 }
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r4 = r5.openFileDescriptor(r4, r2)     // Catch:{ Exception -> 0x0068 }
            if (r4 == 0) goto L_0x0068
            long r2 = r4.getStatSize()     // Catch:{ all -> 0x0046 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x0068 }
            r0 = r2
            goto L_0x0068
        L_0x0046:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x0068 }
            throw r2     // Catch:{ Exception -> 0x0068 }
        L_0x004d:
            java.lang.String r2 = "file"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0056
            goto L_0x0068
        L_0x0056:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0068 }
            android.net.Uri r4 = r4.$uri     // Catch:{ Exception -> 0x0068 }
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x0068 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ Exception -> 0x0068 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0068 }
            long r0 = r5.length()     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r4
        L_0x006d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.FileUtils$getFileSize$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Long> continuation) {
        return ((FileUtils$getFileSize$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
