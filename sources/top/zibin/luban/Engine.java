package top.zibin.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

class Engine {

    /* renamed from: a  reason: collision with root package name */
    public InputStreamProvider f3578a;
    public File b;
    public int c;
    public int d;
    public boolean e;

    public Engine(InputStreamProvider inputStreamProvider, File file, boolean z) {
        this.b = file;
        this.f3578a = inputStreamProvider;
        this.e = z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(inputStreamProvider.open(), (Rect) null, options);
        this.c = options.outWidth;
        this.d = options.outHeight;
    }

    public File a() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeStream = BitmapFactory.decodeStream(this.f3578a.open(), (Rect) null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Checker checker = Checker.SINGLE;
        if (checker.isJPG(this.f3578a.open())) {
            decodeStream = c(decodeStream, checker.getOrientation(this.f3578a.open()));
        }
        decodeStream.compress((this.e || decodeStream.hasAlpha()) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        decodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.b);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.b;
    }

    public final int b() {
        int i = this.c;
        if (i % 2 == 1) {
            i++;
        }
        this.c = i;
        int i2 = this.d;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.d = i2;
        int max = Math.max(i, i2);
        float min = ((float) Math.min(this.c, this.d)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d2 = (double) min;
            if (d2 > 0.5625d || d2 <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d2));
            }
            int i3 = max / PlatformPlugin.DEFAULT_SYSTEM_UI;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max <= 4990 || max >= 10240) {
                return max / PlatformPlugin.DEFAULT_SYSTEM_UI;
            }
            return 4;
        }
    }

    public final Bitmap c(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
