package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.WindowManager;
import com.ucar.databus.proto.UCarProto;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow((double) point.x, 2.0d) + Math.pow((double) point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int b = EglUtils.b();
        if (b > 0) {
            sqrt = Math.min(sqrt, b);
        }
        Log.d("BitmapLoadUtils", "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static boolean b(Bitmap bitmap, BitmapFactory.Options options) {
        if (((long) (bitmap != null ? bitmap.getByteCount() : 0)) <= j()) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    public static void c(Closeable closeable) {
        if (closeable != null && (closeable instanceof Closeable)) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int d(int i, int i2) {
        if (i % 2 == 1) {
            i++;
        }
        if (i2 % 2 == 1) {
            i2++;
        }
        int max = Math.max(i, i2);
        float min = ((float) Math.min(i, i2)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d = (double) min;
            if (d > 0.5625d || d <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d));
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

    public static void e(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i, i2, bitmapLoadCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int f(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return UCarProto.Orientation.ORIENTATION_270_VALUE;
            default:
                return 0;
        }
    }

    public static int g(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static int h(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            int g = new ImageHeaderParser(openInputStream).g();
            c(openInputStream);
            return g;
        } catch (IOException e) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + uri.toString(), e);
            return 0;
        }
    }

    public static int[] i(Context context, Uri uri) {
        InputStream openInputStream;
        if (FileUtils.p(uri.toString())) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), (Rect) null, options);
            options.inSampleSize = d(options.outWidth, options.outHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        options.inJustDecodeBounds = false;
        boolean z = false;
        Bitmap bitmap = null;
        while (!z) {
            try {
                openInputStream = context.getContentResolver().openInputStream(uri);
                bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                c(openInputStream);
                if (!b(bitmap, options)) {
                    z = true;
                }
            } catch (OutOfMemoryError e2) {
                Log.e("BitmapLoadUtils", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e2);
                options.inSampleSize *= 2;
            } catch (IOException e3) {
                Log.e("BitmapLoadUtils", "doInBackground: ImageDecoder.createSource: ", e3);
            } catch (Throwable th) {
                c(openInputStream);
                throw th;
            }
        }
        return bitmap == null ? new int[]{0, 0} : new int[]{bitmap.getWidth(), bitmap.getHeight()};
    }

    public static long j() {
        long j = Runtime.getRuntime().totalMemory();
        if (j > 104857600) {
            return 104857600;
        }
        return j;
    }

    public static boolean k(Uri uri) {
        return uri != null && "content".equals(uri.getScheme());
    }

    public static Bitmap l(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e) {
            Log.e("BitmapLoadUtils", "transformBitmap: ", e);
            return bitmap;
        }
    }
}
