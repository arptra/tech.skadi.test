package com.luck.picture.lib.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.honey.account.constant.AccountConstantKt;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

public class PictureFileUtils {
    public static void a(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static File b(Context context, int i, String str, String str2, String str3) {
        return c(context, i, str, str2, str3);
    }

    public static File c(Context context, int i, String str, String str2, String str3) {
        return d(context, i, str, str2, str3);
    }

    public static File d(Context context, int i, String str, String str2, String str3) {
        File file;
        File file2;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                StringBuilder sb = new StringBuilder();
                sb.append(file2.getAbsolutePath());
                String str4 = File.separator;
                sb.append(str4);
                sb.append("Camera");
                sb.append(str4);
                file = new File(sb.toString());
            } else {
                file2 = i(applicationContext, i);
                file = new File(file2.getAbsolutePath() + File.separator);
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } else {
            File file3 = new File(str3);
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            if (!parentFile.exists()) {
                file3.getParentFile().mkdirs();
            }
            file = file3;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (i == 2) {
            if (isEmpty) {
                str = DateUtils.c("VID_") + ".mp4";
            }
            return new File(file, str);
        } else if (i != 3) {
            if (TextUtils.isEmpty(str2)) {
                str2 = ".jpg";
            }
            if (isEmpty) {
                str = DateUtils.c("IMG_") + str2;
            }
            return new File(file, str);
        } else {
            if (isEmpty) {
                str = DateUtils.c("AUD_") + ".amr";
            }
            return new File(file, str);
        }
    }

    public static String e(long j) {
        double d;
        String str;
        if (j >= 0) {
            if (j < 1000) {
                d = (double) j;
                str = "";
            } else if (j < 1000000) {
                d = ((double) j) / 1000.0d;
                str = "KB";
            } else if (j < 1000000000) {
                d = ((double) j) / 1000000.0d;
                str = "MB";
            } else {
                d = ((double) j) / 1.0E9d;
                str = "GB";
            }
            Object format = String.format(new Locale("zh"), "%.2f", new Object[]{Double.valueOf(d)});
            StringBuilder sb = new StringBuilder();
            if (((double) Math.round(ValueOf.a(format))) - ValueOf.a(format) == 0.0d) {
                format = Long.valueOf(Math.round(ValueOf.a(format)));
            }
            sb.append(format);
            sb.append(str);
            return sb.toString();
        }
        throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
    }

    public static String f(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        } else if (j < 1024) {
            Object format = String.format("%.2f", new Object[]{Double.valueOf((double) j)});
            double a2 = ValueOf.a(format);
            long round = Math.round(a2);
            StringBuilder sb = new StringBuilder();
            if (((double) round) - a2 == 0.0d) {
                format = Long.valueOf(round);
            }
            sb.append(format);
            sb.append("B");
            return sb.toString();
        } else if (j < 1048576) {
            Object format2 = String.format("%.2f", new Object[]{Double.valueOf(((double) j) / 1024.0d)});
            double a3 = ValueOf.a(format2);
            long round2 = Math.round(a3);
            StringBuilder sb2 = new StringBuilder();
            if (((double) round2) - a3 == 0.0d) {
                format2 = Long.valueOf(round2);
            }
            sb2.append(format2);
            sb2.append("KB");
            return sb2.toString();
        } else if (j < FileUtils.ONE_GB) {
            Object format3 = String.format("%.2f", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
            double a4 = ValueOf.a(format3);
            long round3 = Math.round(a4);
            StringBuilder sb3 = new StringBuilder();
            if (((double) round3) - a4 == 0.0d) {
                format3 = Long.valueOf(round3);
            }
            sb3.append(format3);
            sb3.append("MB");
            return sb3.toString();
        } else {
            Object format4 = String.format("%.2f", new Object[]{Double.valueOf(((double) j) / 1.073741824E9d)});
            double a5 = ValueOf.a(format4);
            long round4 = Math.round(a5);
            StringBuilder sb4 = new StringBuilder();
            if (((double) round4) - a5 == 0.0d) {
                format4 = Long.valueOf(round4);
            }
            sb4.append(format4);
            sb4.append("GB");
            return sb4.toString();
        }
    }

    public static String g(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor == null) {
                    return "";
                }
                cursor.close();
                return "";
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            cursor.close();
            return string;
        } catch (IllegalArgumentException e) {
            Log.i("PictureFileUtils", String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", new Object[]{e.getMessage()}));
            if (cursor == null) {
                return "";
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String h(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (!DocumentsContract.isDocumentUri(applicationContext, uri)) {
            return "content".equalsIgnoreCase(uri.getScheme()) ? n(uri) ? uri.getLastPathSegment() : g(applicationContext, uri, (String) null, (String[]) null) : "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : "";
        }
        if (l(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(AccountConstantKt.CODE_SEPARTOR);
            if (!"primary".equalsIgnoreCase(split[0])) {
                return "";
            }
            if (SdkVersionUtils.f()) {
                return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + split[1];
            }
            return Environment.getExternalStorageDirectory() + "/" + split[1];
        } else if (k(uri)) {
            return g(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ValueOf.e(DocumentsContract.getDocumentId(uri))), (String) null, (String[]) null);
        } else if (!p(uri)) {
            return "";
        } else {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(AccountConstantKt.CODE_SEPARTOR);
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return g(applicationContext, uri2, "_id=?", new String[]{split2[1]});
        }
    }

    public static File i(Context context, int i) {
        return new File(FileDirMap.b(context, i));
    }

    public static String j(Context context) {
        File file = new File(context.getExternalFilesDir("").getAbsolutePath(), "VideoThumbnail");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    public static boolean k(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean l(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean m(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean n(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean o(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 2;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth > 0 && options.outHeight > 0;
    }

    public static boolean p(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri q(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".luckProvider", file);
    }

    public static boolean r(InputStream inputStream, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } catch (Exception e) {
                e = e;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    a(bufferedInputStream);
                    a(bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    a(bufferedInputStream);
                    a(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                a(bufferedInputStream);
                a(bufferedOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        a(bufferedInputStream2);
                        a(bufferedOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = bufferedInputStream2;
                e.printStackTrace();
                a(bufferedInputStream);
                a(bufferedOutputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                a(bufferedInputStream);
                a(bufferedOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream = null;
            e.printStackTrace();
            a(bufferedInputStream);
            a(bufferedOutputStream);
            return false;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            a(bufferedInputStream);
            a(bufferedOutputStream);
            throw th;
        }
    }
}
