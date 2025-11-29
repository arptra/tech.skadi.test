package com.upuphone.xr.sapp.glass;

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

@SourceDebugExtension({"SMAP\nGlassScreenShotHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassScreenShotHelper.kt\ncom/upuphone/xr/sapp/glass/GlassScreenShotHelper$saveG4ToAlbum$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,587:1\n12285#2,2:588\n12285#2,2:590\n11095#2:592\n11430#2,3:593\n*S KotlinDebug\n*F\n+ 1 GlassScreenShotHelper.kt\ncom/upuphone/xr/sapp/glass/GlassScreenShotHelper$saveG4ToAlbum$2\n*L\n394#1:588,2\n403#1:590,2\n422#1:592\n422#1:593,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$saveG4ToAlbum$2", f = "GlassScreenShotHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassScreenShotHelper$saveG4ToAlbum$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ Uri $srcUri;
    final /* synthetic */ boolean $useEncoding;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassScreenShotHelper$saveG4ToAlbum$2(Uri uri, boolean z, Continuation<? super GlassScreenShotHelper$saveG4ToAlbum$2> continuation) {
        super(2, continuation);
        this.$srcUri = uri;
        this.$useEncoding = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$saveG4ToAlbum$2(this.$srcUri, this.$useEncoding, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r15, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01c4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c7, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01cb, code lost:
        throw r15;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.String r0 = "createBitmap(...)"
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            if (r1 != 0) goto L_0x01e9
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            android.net.Uri r1 = r14.$srcUri
            boolean r2 = r14.$useEncoding
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "saveG4ToAlbum, srcUri: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ", useEncoding: "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "GlassScreenShotHelper"
            r15.a(r2, r1)
            r1 = 0
            android.net.Uri r3 = r14.$srcUri     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x01cc
            int r4 = r3.length()     // Catch:{ Exception -> 0x007c }
            if (r4 != 0) goto L_0x0041
            goto L_0x01cc
        L_0x0041:
            android.content.Context r4 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()     // Catch:{ Exception -> 0x007c }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x007c }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x007c }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x007c }
            r6.<init>(r3)     // Catch:{ Exception -> 0x007c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x007c }
            byte[] r3 = kotlin.io.ByteStreamsKt.readBytes(r5)     // Catch:{ all -> 0x01c5 }
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ Exception -> 0x007c }
            int r5 = r3.length     // Catch:{ Exception -> 0x007c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r6.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r7 = "saveG4ToAlbum, fileBytes.length: "
            r6.append(r7)     // Catch:{ Exception -> 0x007c }
            r6.append(r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x007c }
            r15.a(r2, r5)     // Catch:{ Exception -> 0x007c }
            int r15 = r3.length     // Catch:{ Exception -> 0x007c }
            r5 = 0
            r6 = r5
        L_0x0072:
            if (r6 >= r15) goto L_0x007f
            byte r7 = r3[r6]     // Catch:{ Exception -> 0x007c }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x007c }
            if (r7 != 0) goto L_0x0086
            int r6 = r6 + 1
            goto L_0x0072
        L_0x007c:
            r14 = move-exception
            goto L_0x01d2
        L_0x007f:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = "saveG4ToAlbum, fileBytes are all zero"
            r15.c(r2, r6)     // Catch:{ Exception -> 0x007c }
        L_0x0086:
            boolean r14 = r14.$useEncoding     // Catch:{ Exception -> 0x007c }
            if (r14 == 0) goto L_0x0090
            com.upuphone.xr.sapp.glass.GlassScreenShotHelper r14 = com.upuphone.xr.sapp.glass.GlassScreenShotHelper.b     // Catch:{ Exception -> 0x007c }
            byte[] r3 = r14.I(r3)     // Catch:{ Exception -> 0x007c }
        L_0x0090:
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x007c }
            int r15 = r3.length     // Catch:{ Exception -> 0x007c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r6.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r7 = "saveG4ToAlbum, srcBytes.length = "
            r6.append(r7)     // Catch:{ Exception -> 0x007c }
            r6.append(r15)     // Catch:{ Exception -> 0x007c }
            java.lang.String r15 = r6.toString()     // Catch:{ Exception -> 0x007c }
            r14.a(r2, r15)     // Catch:{ Exception -> 0x007c }
            int r14 = r3.length     // Catch:{ Exception -> 0x007c }
            r15 = r5
        L_0x00a9:
            if (r15 >= r14) goto L_0x00b3
            byte r6 = r3[r15]     // Catch:{ Exception -> 0x007c }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x007c }
            if (r6 != 0) goto L_0x00ba
            int r15 = r15 + 1
            goto L_0x00a9
        L_0x00b3:
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x007c }
            java.lang.String r15 = "saveG4ToAlbum, srcBytes are all zero"
            r14.c(r2, r15)     // Catch:{ Exception -> 0x007c }
        L_0x00ba:
            int r14 = r3.length     // Catch:{ Exception -> 0x007c }
            int r14 = r14 * 2
            int[] r15 = new int[r14]     // Catch:{ Exception -> 0x007c }
            int r6 = r3.length     // Catch:{ Exception -> 0x007c }
            r7 = r5
            r8 = r7
        L_0x00c2:
            if (r7 >= r6) goto L_0x00db
            byte r9 = r3[r7]     // Catch:{ Exception -> 0x007c }
            int r10 = r8 + 1
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x007c }
            int r8 = r8 * 2
            int r11 = r8 + 1
            r12 = r9 & 15
            int r12 = r12 << 4
            r15[r11] = r12     // Catch:{ Exception -> 0x007c }
            r9 = r9 & 240(0xf0, float:3.36E-43)
            r15[r8] = r9     // Catch:{ Exception -> 0x007c }
            int r7 = r7 + 1
            r8 = r10
            goto L_0x00c2
        L_0x00db:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x007c }
            r3.<init>(r14)     // Catch:{ Exception -> 0x007c }
        L_0x00e0:
            if (r5 >= r14) goto L_0x00f3
            r6 = r15[r5]     // Catch:{ Exception -> 0x007c }
            int r6 = r6 << 8
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r6 = r6 | r7
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ Exception -> 0x007c }
            r3.add(r6)     // Catch:{ Exception -> 0x007c }
            int r5 = r5 + 1
            goto L_0x00e0
        L_0x00f3:
            int[] r14 = kotlin.collections.CollectionsKt.toIntArray(r3)     // Catch:{ Exception -> 0x007c }
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x007c }
            int r3 = r14.length     // Catch:{ Exception -> 0x007c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r5.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = "saveG4ToAlbum, rgb data length = "
            r5.append(r6)     // Catch:{ Exception -> 0x007c }
            r5.append(r3)     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x007c }
            r15.a(r2, r3)     // Catch:{ Exception -> 0x007c }
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ Exception -> 0x007c }
            r5 = 640(0x280, float:8.97E-43)
            r6 = 480(0x1e0, float:6.73E-43)
            android.graphics.Bitmap r14 = android.graphics.Bitmap.createBitmap(r14, r5, r6, r3)     // Catch:{ Exception -> 0x007c }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)     // Catch:{ Exception -> 0x007c }
            android.graphics.Matrix r12 = new android.graphics.Matrix     // Catch:{ Exception -> 0x007c }
            r12.<init>()     // Catch:{ Exception -> 0x007c }
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            r12.postScale(r3, r5)     // Catch:{ Exception -> 0x007c }
            int r10 = r14.getWidth()     // Catch:{ Exception -> 0x007c }
            int r11 = r14.getHeight()     // Catch:{ Exception -> 0x007c }
            r13 = 0
            r8 = 0
            r9 = 0
            r7 = r14
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x007c }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ Exception -> 0x007c }
            int r0 = r14.getWidth()     // Catch:{ Exception -> 0x007c }
            float r0 = (float) r0     // Catch:{ Exception -> 0x007c }
            r5 = 1067450368(0x3fa00000, float:1.25)
            float r0 = r0 * r5
            int r0 = (int) r0     // Catch:{ Exception -> 0x007c }
            int r14 = r14.getHeight()     // Catch:{ Exception -> 0x007c }
            float r14 = (float) r14     // Catch:{ Exception -> 0x007c }
            float r14 = r14 * r5
            int r14 = (int) r14     // Catch:{ Exception -> 0x007c }
            r5 = 1
            android.graphics.Bitmap r14 = android.graphics.Bitmap.createScaledBitmap(r3, r0, r14, r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = "createScaledBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)     // Catch:{ Exception -> 0x007c }
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x007c }
            r0.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = "mime_type"
            java.lang.String r5 = "image/*"
            r0.put(r3, r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = "_display_name"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x007c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r7.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r8 = "screenshot_"
            r7.append(r8)     // Catch:{ Exception -> 0x007c }
            r7.append(r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r5 = ".jpg"
            r7.append(r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x007c }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = "relative_path"
            java.lang.String r5 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x007c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r7.<init>()     // Catch:{ Exception -> 0x007c }
            r7.append(r5)     // Catch:{ Exception -> 0x007c }
            r7.append(r6)     // Catch:{ Exception -> 0x007c }
            java.lang.String r5 = "myvu"
            r7.append(r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x007c }
            r0.put(r3, r5)     // Catch:{ Exception -> 0x007c }
            android.net.Uri r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x007c }
            android.net.Uri r0 = r4.insert(r3, r0)     // Catch:{ Exception -> 0x007c }
            if (r0 != 0) goto L_0x01aa
            java.lang.String r14 = "saveG4ToAlbum, contentUri is null"
            r15.c(r2, r14)     // Catch:{ Exception -> 0x007c }
            return r1
        L_0x01aa:
            java.io.OutputStream r15 = r4.openOutputStream(r0)     // Catch:{ Exception -> 0x007c }
            if (r15 == 0) goto L_0x01e8
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x01be }
            r4 = 100
            r14.compress(r3, r4, r15)     // Catch:{ all -> 0x01be }
            r15.flush()     // Catch:{ all -> 0x01be }
            kotlin.io.CloseableKt.closeFinally(r15, r1)     // Catch:{ Exception -> 0x007c }
            return r0
        L_0x01be:
            r14 = move-exception
            throw r14     // Catch:{ all -> 0x01c0 }
        L_0x01c0:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r15, r14)     // Catch:{ Exception -> 0x007c }
            throw r0     // Catch:{ Exception -> 0x007c }
        L_0x01c5:
            r14 = move-exception
            throw r14     // Catch:{ all -> 0x01c7 }
        L_0x01c7:
            r15 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r14)     // Catch:{ Exception -> 0x007c }
            throw r15     // Catch:{ Exception -> 0x007c }
        L_0x01cc:
            java.lang.String r14 = "saveG4ToAlbum, filePath is null"
            r15.a(r2, r14)     // Catch:{ Exception -> 0x007c }
            return r1
        L_0x01d2:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "saveG4ToAlbum, error: "
            r0.append(r3)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.c(r2, r14)
        L_0x01e8:
            return r1
        L_0x01e9:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassScreenShotHelper$saveG4ToAlbum$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Uri> continuation) {
        return ((GlassScreenShotHelper$saveG4ToAlbum$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
