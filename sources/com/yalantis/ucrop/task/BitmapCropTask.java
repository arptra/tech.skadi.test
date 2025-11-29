package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f8748a;
    public Bitmap b;
    public final RectF c;
    public final RectF d;
    public float e;
    public float f;
    public final int g;
    public final int h;
    public final Bitmap.CompressFormat i;
    public final int j;
    public final String k;
    public final String l;
    public final Uri m;
    public final Uri n;
    public final ExifInfo o;
    public final BitmapCropCallback p;
    public int q;
    public int r;
    public int s;
    public int t;

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.f8748a = new WeakReference(context);
        this.b = bitmap;
        this.c = imageState.a();
        this.d = imageState.c();
        this.e = imageState.d();
        this.f = imageState.b();
        this.g = cropParameters.h();
        this.h = cropParameters.i();
        this.i = cropParameters.a();
        this.j = cropParameters.b();
        this.k = cropParameters.f();
        this.l = cropParameters.g();
        this.m = cropParameters.c();
        this.n = cropParameters.d();
        this.o = cropParameters.e();
        this.p = bitmapCropCallback;
    }

    public final void a() {
        if (this.s < 0) {
            this.s = 0;
            this.q = this.b.getWidth();
        }
        if (this.t < 0) {
            this.t = 0;
            this.r = this.b.getHeight();
        }
    }

    public final void b(Context context) {
        boolean k2 = BitmapLoadUtils.k(this.m);
        boolean k3 = BitmapLoadUtils.k(this.n);
        if (k2 && k3) {
            ImageHeaderParser.b(context, this.q, this.r, this.m, this.n);
        } else if (k2) {
            ImageHeaderParser.c(context, this.q, this.r, this.m, this.l);
        } else if (k3) {
            ImageHeaderParser.d(context, new ExifInterface(this.k), this.q, this.r, this.n);
        } else {
            ImageHeaderParser.e(new ExifInterface(this.k), this.q, this.r, this.l);
        }
    }

    public final boolean c() {
        Context context = (Context) this.f8748a.get();
        if (context == null) {
            return false;
        }
        if (this.g > 0 && this.h > 0) {
            float width = this.c.width() / this.e;
            float height = this.c.height() / this.e;
            int i2 = this.g;
            if (width > ((float) i2) || height > ((float) this.h)) {
                float min = Math.min(((float) i2) / width, ((float) this.h) / height);
                Bitmap bitmap = this.b;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * min), Math.round(((float) this.b.getHeight()) * min), false);
                Bitmap bitmap2 = this.b;
                if (bitmap2 != createScaledBitmap) {
                    bitmap2.recycle();
                }
                this.b = createScaledBitmap;
                this.e /= min;
            }
        }
        if (this.f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f, (float) (this.b.getWidth() / 2), (float) (this.b.getHeight() / 2));
            Bitmap bitmap3 = this.b;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.b;
            if (bitmap4 != createBitmap) {
                bitmap4.recycle();
            }
            this.b = createBitmap;
        }
        this.s = Math.round((this.c.left - this.d.left) / this.e);
        this.t = Math.round((this.c.top - this.d.top) / this.e);
        this.q = Math.round(this.c.width() / this.e);
        int round = Math.round(this.c.height() / this.e);
        this.r = round;
        boolean g2 = g(this.q, round);
        Log.i("BitmapCropTask", "Should crop: " + g2);
        if (g2) {
            a();
            f(Bitmap.createBitmap(this.b, this.s, this.t, this.q, this.r));
            if (!this.i.equals(Bitmap.CompressFormat.JPEG)) {
                return true;
            }
            b(context);
            return true;
        }
        if (FileUtils.j(this.k)) {
            FileUtils.v(context.getContentResolver().openInputStream(Uri.parse(this.k)), new FileOutputStream(this.l));
        } else {
            FileUtils.a(this.k, this.l);
        }
        return false;
    }

    /* renamed from: d */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        if (this.n == null) {
            return new NullPointerException("ImageOutputUri is null");
        }
        try {
            c();
            this.b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* renamed from: e */
    public void onPostExecute(Throwable th) {
        BitmapCropCallback bitmapCropCallback = this.p;
        if (bitmapCropCallback == null) {
            return;
        }
        if (th == null) {
            this.p.a(BitmapLoadUtils.k(this.n) ? this.n : Uri.fromFile(new File(this.l)), this.s, this.t, this.q, this.r);
        } else {
            bitmapCropCallback.b(th);
        }
    }

    public final void f(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        Context context = (Context) this.f8748a.get();
        if (context != null) {
            OutputStream outputStream = null;
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(this.n);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    outputStream = openOutputStream;
                    try {
                        Log.e("BitmapCropTask", e.getLocalizedMessage());
                        BitmapLoadUtils.c(outputStream);
                        BitmapLoadUtils.c(byteArrayOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        BitmapLoadUtils.c(outputStream);
                        BitmapLoadUtils.c(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    outputStream = openOutputStream;
                    BitmapLoadUtils.c(outputStream);
                    BitmapLoadUtils.c(byteArrayOutputStream);
                    throw th;
                }
                try {
                    bitmap.compress(this.i, this.j, byteArrayOutputStream);
                    openOutputStream.write(byteArrayOutputStream.toByteArray());
                    bitmap.recycle();
                    BitmapLoadUtils.c(openOutputStream);
                } catch (IOException e3) {
                    e = e3;
                    outputStream = openOutputStream;
                    Log.e("BitmapCropTask", e.getLocalizedMessage());
                    BitmapLoadUtils.c(outputStream);
                    BitmapLoadUtils.c(byteArrayOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = openOutputStream;
                    BitmapLoadUtils.c(outputStream);
                    BitmapLoadUtils.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                byteArrayOutputStream = null;
                Log.e("BitmapCropTask", e.getLocalizedMessage());
                BitmapLoadUtils.c(outputStream);
                BitmapLoadUtils.c(byteArrayOutputStream);
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                BitmapLoadUtils.c(outputStream);
                BitmapLoadUtils.c(byteArrayOutputStream);
                throw th;
            }
            BitmapLoadUtils.c(byteArrayOutputStream);
        }
    }

    public final boolean g(int i2, int i3) {
        int round = Math.round(((float) Math.max(i2, i3)) / 1000.0f) + 1;
        if (this.g > 0 && this.h > 0) {
            return true;
        }
        float f2 = (float) round;
        return Math.abs(this.c.left - this.d.left) > f2 || Math.abs(this.c.top - this.d.top) > f2 || Math.abs(this.c.bottom - this.d.bottom) > f2 || Math.abs(this.c.right - this.d.right) > f2 || this.f != 0.0f;
    }
}
