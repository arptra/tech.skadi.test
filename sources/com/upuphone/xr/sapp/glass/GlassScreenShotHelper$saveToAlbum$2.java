package com.upuphone.xr.sapp.glass;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$saveToAlbum$2", f = "GlassScreenShotHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassScreenShotHelper$saveToAlbum$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ Uri $srcUri;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassScreenShotHelper$saveToAlbum$2(Uri uri, Continuation<? super GlassScreenShotHelper$saveToAlbum$2> continuation) {
        super(2, continuation);
        this.$srcUri = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$saveToAlbum$2(this.$srcUri, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c9, code lost:
        throw r10;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.label
            if (r0 != 0) goto L_0x00e7
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            android.net.Uri r0 = r9.$srcUri
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveToAlbum, srcUri: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "GlassScreenShotHelper"
            r10.a(r1, r0)
            r0 = 0
            android.content.Context r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()     // Catch:{ Exception -> 0x00a0 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x00a0 }
            android.net.Uri r9 = r9.$srcUri     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r9 = r9.getPath()     // Catch:{ Exception -> 0x00a0 }
            if (r9 == 0) goto L_0x00ca
            int r3 = r9.length()     // Catch:{ Exception -> 0x00a0 }
            if (r3 != 0) goto L_0x003d
            goto L_0x00ca
        L_0x003d:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a0 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00a0 }
            r4.<init>(r9)     // Catch:{ Exception -> 0x00a0 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00a0 }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x00a2 }
            r9.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "mime_type"
            java.lang.String r5 = "image/*"
            r9.put(r4, r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "_display_name"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r7.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r8 = "screenshot_"
            r7.append(r8)     // Catch:{ all -> 0x00a2 }
            r7.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = ".jpg"
            r7.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00a2 }
            r9.put(r4, r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "relative_path"
            java.lang.String r5 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r7.<init>()     // Catch:{ all -> 0x00a2 }
            r7.append(r5)     // Catch:{ all -> 0x00a2 }
            r7.append(r6)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = "myvu"
            r7.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00a2 }
            r9.put(r4, r5)     // Catch:{ all -> 0x00a2 }
            android.net.Uri r4 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ all -> 0x00a2 }
            android.net.Uri r9 = r2.insert(r4, r9)     // Catch:{ all -> 0x00a2 }
            if (r9 != 0) goto L_0x00a4
            java.lang.String r9 = "saveToAlbum, contentUri is null"
            r10.c(r1, r9)     // Catch:{ all -> 0x00a2 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ Exception -> 0x00a0 }
            return r0
        L_0x00a0:
            r9 = move-exception
            goto L_0x00d0
        L_0x00a2:
            r9 = move-exception
            goto L_0x00c4
        L_0x00a4:
            java.io.OutputStream r10 = r2.openOutputStream(r9)     // Catch:{ all -> 0x00a2 }
            if (r10 == 0) goto L_0x00c0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ all -> 0x00b9 }
            r2 = 0
            r4 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r3, r10, r2, r4, r0)     // Catch:{ all -> 0x00b9 }
            kotlin.io.CloseableKt.closeFinally(r10, r0)     // Catch:{ all -> 0x00a2 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ Exception -> 0x00a0 }
            return r9
        L_0x00b9:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r9)     // Catch:{ all -> 0x00a2 }
            throw r2     // Catch:{ all -> 0x00a2 }
        L_0x00c0:
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00e6
        L_0x00c4:
            throw r9     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r9)     // Catch:{ Exception -> 0x00a0 }
            throw r10     // Catch:{ Exception -> 0x00a0 }
        L_0x00ca:
            java.lang.String r9 = "saveToAlbum, filePath is null"
            r10.a(r1, r9)     // Catch:{ Exception -> 0x00a0 }
            return r0
        L_0x00d0:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "saveToAlbum, error: "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r10.c(r1, r9)
        L_0x00e6:
            return r0
        L_0x00e7:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassScreenShotHelper$saveToAlbum$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Uri> continuation) {
        return ((GlassScreenShotHelper$saveToAlbum$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
