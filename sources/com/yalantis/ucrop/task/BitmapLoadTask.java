package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.eclipse.jetty.util.URIUtil;

public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f8749a;
    public Uri b;
    public Uri c;
    public final int d;
    public final int e;
    public final BitmapLoadCallback f;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.f8749a = new WeakReference(context);
        this.b = uri;
        this.c = uri2;
        this.d = i;
        this.e = i2;
        this.f = bitmapLoadCallback;
    }

    /* renamed from: a */
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream openInputStream;
        Context context = (Context) this.f8749a.get();
        if (context == null) {
            return new BitmapWorkerResult(new NullPointerException("context is null"));
        }
        if (this.b == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            d();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeStream(context.getContentResolver().openInputStream(this.b), (Rect) null, options);
                options.inSampleSize = BitmapLoadUtils.d(options.outWidth, options.outHeight);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            boolean z = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z) {
                try {
                    openInputStream = context.getContentResolver().openInputStream(this.b);
                    bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        BitmapWorkerResult bitmapWorkerResult = new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.b + "]"));
                        BitmapLoadUtils.c(openInputStream);
                        return bitmapWorkerResult;
                    }
                    BitmapLoadUtils.c(openInputStream);
                    if (!BitmapLoadUtils.b(bitmap, options)) {
                        z = true;
                    }
                } catch (OutOfMemoryError e3) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e3);
                    options.inSampleSize *= 2;
                } catch (IOException e4) {
                    Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e4);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.b + "]", e4));
                } catch (Throwable th) {
                    BitmapLoadUtils.c(openInputStream);
                    throw th;
                }
            }
            if (bitmap == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.b + "]"));
            }
            int h = BitmapLoadUtils.h(context, this.b);
            int f2 = BitmapLoadUtils.f(h);
            int g = BitmapLoadUtils.g(h);
            ExifInfo exifInfo = new ExifInfo(h, f2, g);
            Matrix matrix = new Matrix();
            if (f2 != 0) {
                matrix.preRotate((float) f2);
            }
            if (g != 1) {
                matrix.postScale((float) g, 1.0f);
            }
            return !matrix.isIdentity() ? new BitmapWorkerResult(BitmapLoadUtils.l(bitmap, matrix), exifInfo) : new BitmapWorkerResult(bitmap, exifInfo);
        } catch (IOException | NullPointerException e5) {
            return new BitmapWorkerResult(e5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.net.Uri r5, android.net.Uri r6) {
        /*
            r4 = this;
            java.lang.String r0 = "BitmapWorkerTask"
            java.lang.String r1 = "downloadFile"
            android.util.Log.d(r0, r1)
            if (r6 == 0) goto L_0x009c
            java.lang.ref.WeakReference r0 = r4.f8749a
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 == 0) goto L_0x0094
            com.yalantis.ucrop.OkHttpClientStore r1 = com.yalantis.ucrop.OkHttpClientStore.b
            okhttp3.OkHttpClient r1 = r1.a()
            r2 = 0
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch:{ all -> 0x0076 }
            r3.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0076 }
            okhttp3.Request$Builder r5 = r3.url((java.lang.String) r5)     // Catch:{ all -> 0x0076 }
            okhttp3.Request r5 = r5.build()     // Catch:{ all -> 0x0076 }
            okhttp3.Call r5 = r1.newCall(r5)     // Catch:{ all -> 0x0076 }
            okhttp3.Response r5 = r5.execute()     // Catch:{ all -> 0x0076 }
            okhttp3.ResponseBody r3 = r5.body()     // Catch:{ all -> 0x0072 }
            okio.BufferedSource r3 = r3.source()     // Catch:{ all -> 0x0072 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x0065 }
            java.io.OutputStream r6 = r0.openOutputStream(r6)     // Catch:{ all -> 0x0065 }
            if (r6 == 0) goto L_0x006a
            okio.Sink r2 = okio.Okio.sink((java.io.OutputStream) r6)     // Catch:{ all -> 0x0065 }
            r3.readAll(r2)     // Catch:{ all -> 0x0065 }
            com.yalantis.ucrop.util.BitmapLoadUtils.c(r3)
            com.yalantis.ucrop.util.BitmapLoadUtils.c(r2)
            okhttp3.ResponseBody r5 = r5.body()
            com.yalantis.ucrop.util.BitmapLoadUtils.c(r5)
            okhttp3.Dispatcher r5 = r1.dispatcher()
            r5.cancelAll()
            android.net.Uri r5 = r4.c
            r4.b = r5
            return
        L_0x0065:
            r6 = move-exception
            r0 = r5
            r5 = r2
            r2 = r3
            goto L_0x0079
        L_0x006a:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = "OutputStream for given output Uri is null"
            r6.<init>(r0)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x0072:
            r6 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x0079
        L_0x0076:
            r6 = move-exception
            r5 = r2
            r0 = r5
        L_0x0079:
            com.yalantis.ucrop.util.BitmapLoadUtils.c(r2)
            com.yalantis.ucrop.util.BitmapLoadUtils.c(r5)
            if (r0 == 0) goto L_0x0088
            okhttp3.ResponseBody r5 = r0.body()
            com.yalantis.ucrop.util.BitmapLoadUtils.c(r5)
        L_0x0088:
            okhttp3.Dispatcher r5 = r1.dispatcher()
            r5.cancelAll()
            android.net.Uri r5 = r4.c
            r4.b = r5
            throw r6
        L_0x0094:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "Context is null"
            r4.<init>(r5)
            throw r4
        L_0x009c:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "Output Uri is null - cannot download image"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.task.BitmapLoadTask.b(android.net.Uri, android.net.Uri):void");
    }

    /* renamed from: c */
    public void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.c;
        if (exc == null) {
            this.f.a(bitmapWorkerResult.f8750a, bitmapWorkerResult.b, this.b, this.c);
        } else {
            this.f.onFailure(exc);
        }
    }

    public final void d() {
        String scheme = this.b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if (URIUtil.HTTP.equals(scheme) || URIUtil.HTTPS.equals(scheme)) {
            try {
                b(this.b, this.c);
            } catch (IOException | NullPointerException e2) {
                Log.e("BitmapWorkerTask", "Downloading failed", e2);
                throw e2;
            }
        } else if (!"file".equals(scheme) && !"content".equals(scheme)) {
            Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
    }

    public static class BitmapWorkerResult {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f8750a;
        public ExifInfo b;
        public Exception c;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.f8750a = bitmap;
            this.b = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.c = exc;
        }
    }
}
