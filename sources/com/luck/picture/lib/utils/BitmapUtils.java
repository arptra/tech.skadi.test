package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.ucar.databus.proto.UCarProto;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.InputStream;

public class BitmapUtils {
    public static int a(int i, int i2) {
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

    public static int[] b(int i, int i2) {
        int i3 = -1;
        if (i == 0 && i2 == 0) {
            return new int[]{-1, -1};
        }
        int a2 = a(i, i2);
        long c = c();
        boolean z = false;
        int i4 = a2;
        int i5 = -1;
        while (!z) {
            i3 = i / i4;
            i5 = i2 / i4;
            if (((long) (i3 * i5 * 4)) > c) {
                i4 *= 2;
            } else {
                z = true;
            }
        }
        return new int[]{i3, i5};
    }

    public static long c() {
        long j = Runtime.getRuntime().totalMemory();
        if (j > 104857600) {
            return 104857600;
        }
        return j;
    }

    public static int d(Context context, String str) {
        ExifInterface exifInterface;
        InputStream inputStream = null;
        try {
            if (PictureMimeType.c(str)) {
                inputStream = PictureContentResolver.a(context, Uri.parse(str));
                exifInterface = new ExifInterface(inputStream);
            } else {
                exifInterface = new ExifInterface(str);
            }
            int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                PictureFileUtils.a(inputStream);
                return 180;
            } else if (attributeInt == 6) {
                PictureFileUtils.a(inputStream);
                return 90;
            } else if (attributeInt != 8) {
                PictureFileUtils.a(inputStream);
                return 0;
            } else {
                PictureFileUtils.a(inputStream);
                return UCarProto.Orientation.ORIENTATION_270_VALUE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            PictureFileUtils.a((Closeable) null);
            return 0;
        } catch (Throwable th) {
            PictureFileUtils.a((Closeable) null);
            throw th;
        }
    }

    public static void e(Context context, String str) {
        Closeable closeable;
        Bitmap bitmap;
        Closeable closeable2;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Bitmap bitmap2;
        InputStream inputStream2 = null;
        try {
            int d = d(context, str);
            if (d > 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (PictureMimeType.c(str)) {
                    inputStream = PictureContentResolver.a(context, Uri.parse(str));
                    try {
                        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    } catch (Exception e) {
                        e = e;
                        closeable2 = null;
                        bitmap = null;
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        bitmap = null;
                        inputStream2 = inputStream;
                        PictureFileUtils.a(inputStream2);
                        PictureFileUtils.a(closeable);
                        bitmap.recycle();
                        throw th;
                    }
                } else {
                    BitmapFactory.decodeFile(str, options);
                    inputStream = null;
                }
                options.inSampleSize = a(options.outWidth, options.outHeight);
                options.inJustDecodeBounds = false;
                if (PictureMimeType.c(str)) {
                    inputStream = PictureContentResolver.a(context, Uri.parse(str));
                    bitmap2 = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                } else {
                    bitmap2 = BitmapFactory.decodeFile(str, options);
                }
                if (bitmap2 != null) {
                    try {
                        bitmap = f(bitmap2, d);
                        try {
                            FileOutputStream fileOutputStream2 = PictureMimeType.c(str) ? (FileOutputStream) PictureContentResolver.b(context, Uri.parse(str)) : new FileOutputStream(str);
                            g(bitmap, fileOutputStream2);
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            closeable2 = null;
                            inputStream2 = inputStream;
                            try {
                                e.printStackTrace();
                                PictureFileUtils.a(inputStream2);
                                PictureFileUtils.a(closeable);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                PictureFileUtils.a(inputStream2);
                                PictureFileUtils.a(closeable);
                                bitmap.recycle();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = null;
                            inputStream2 = inputStream;
                            PictureFileUtils.a(inputStream2);
                            PictureFileUtils.a(closeable);
                            bitmap.recycle();
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        closeable2 = null;
                        bitmap = bitmap2;
                        inputStream2 = inputStream;
                        e.printStackTrace();
                        PictureFileUtils.a(inputStream2);
                        PictureFileUtils.a(closeable);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = null;
                        bitmap = bitmap2;
                        inputStream2 = inputStream;
                        PictureFileUtils.a(inputStream2);
                        PictureFileUtils.a(closeable);
                        bitmap.recycle();
                        throw th;
                    }
                } else {
                    fileOutputStream = null;
                    bitmap = bitmap2;
                }
                inputStream2 = inputStream;
            } else {
                fileOutputStream = null;
                bitmap = null;
            }
            PictureFileUtils.a(inputStream2);
            PictureFileUtils.a(fileOutputStream);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
        } catch (Exception e4) {
            e = e4;
            closeable2 = null;
            bitmap = null;
            e.printStackTrace();
            PictureFileUtils.a(inputStream2);
            PictureFileUtils.a(closeable);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            bitmap = null;
            PictureFileUtils.a(inputStream2);
            PictureFileUtils.a(closeable);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            throw th;
        }
        bitmap.recycle();
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void g(Bitmap bitmap, FileOutputStream fileOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                PictureFileUtils.a(fileOutputStream);
                PictureFileUtils.a(byteArrayOutputStream2);
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    e.printStackTrace();
                    PictureFileUtils.a(fileOutputStream);
                    PictureFileUtils.a(byteArrayOutputStream);
                } catch (Throwable th) {
                    th = th;
                    PictureFileUtils.a(fileOutputStream);
                    PictureFileUtils.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                PictureFileUtils.a(fileOutputStream);
                PictureFileUtils.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            PictureFileUtils.a(fileOutputStream);
            PictureFileUtils.a(byteArrayOutputStream);
        }
    }
}
