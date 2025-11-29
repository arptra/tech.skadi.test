package com.upuphone.xr.sapp.vu;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.ArSpaceStarterActivity$showScreenCapture$1$bitmap$1", f = "ArSpaceStarterActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ArSpaceStarterActivity$showScreenCapture$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $file;
    int label;
    final /* synthetic */ ArSpaceStarterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceStarterActivity$showScreenCapture$1$bitmap$1(String str, ArSpaceStarterActivity arSpaceStarterActivity, Continuation<? super ArSpaceStarterActivity$showScreenCapture$1$bitmap$1> continuation) {
        super(2, continuation);
        this.$file = str;
        this.this$0 = arSpaceStarterActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ArSpaceStarterActivity$showScreenCapture$1$bitmap$1(this.$file, this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0084, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0085, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            if (r0 != 0) goto L_0x0089
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.$file
            android.net.Uri r7 = android.net.Uri.parse(r7)
            com.upuphone.xr.sapp.vu.ArSpaceStarterActivity r0 = r6.this$0
            android.content.ContentResolver r0 = r0.getContentResolver()
            r4 = 0
            r5 = 0
            r2 = 0
            r3 = 0
            r1 = r7
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            java.lang.String r1 = "showScreenCapture: "
            java.lang.String r2 = "ArSpaceStarterActivity"
            if (r0 == 0) goto L_0x005d
            int r3 = r0.getCount()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.d(r2, r3)
            boolean r3 = r0.moveToFirst()
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = "_display_name"
            int r3 = r0.getColumnIndex(r3)
            java.lang.String r0 = r0.getString(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.d(r2, r0)
        L_0x005d:
            com.upuphone.xr.sapp.vu.ArSpaceStarterActivity r6 = r6.this$0
            android.content.ContentResolver r6 = r6.getContentResolver()
            java.io.InputStream r6 = r6.openInputStream(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r7.<init>()     // Catch:{ all -> 0x0082 }
            r7.append(r1)     // Catch:{ all -> 0x0082 }
            r7.append(r6)     // Catch:{ all -> 0x0082 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0082 }
            android.util.Log.d(r2, r7)     // Catch:{ all -> 0x0082 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ all -> 0x0082 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r0)
            return r7
        L_0x0082:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r7)
            throw r0
        L_0x0089:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.ArSpaceStarterActivity$showScreenCapture$1$bitmap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Bitmap> continuation) {
        return ((ArSpaceStarterActivity$showScreenCapture$1$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
