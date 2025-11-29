package com.mr.flutter.plugin.filepicker;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.honey.account.constant.AccountConstantKt;
import com.mr.flutter.plugin.filepicker.FileInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileUtils {
    public static boolean a(Context context) {
        try {
            n(new File(context.getCacheDir() + "/file_picker/"));
            return true;
        } catch (Exception e) {
            Log.e("FilePickerUtils", "There was an error while clearing cached files: " + e.toString());
            return false;
        }
    }

    public static Uri b(Uri uri, int i, Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
            File c = c();
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(c);
            decodeStream.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Uri fromFile = Uri.fromFile(c);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return fromFile;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static File c() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return File.createTempFile("JPEG_" + format + AccountConstantKt.DEFAULT_SEGMENT, ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String d(Class cls, Object obj) {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return (String) cls.getMethod("getPath", (Class[]) null).invoke(obj, (Object[]) null);
            }
            File file = (File) cls.getMethod("getDirectory", (Class[]) null).invoke(obj, (Object[]) null);
            if (file != null) {
                return file.getPath();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r2 = r2[1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(android.net.Uri r2) {
        /*
            java.lang.String r2 = android.provider.DocumentsContract.getTreeDocumentId(r2)
            java.lang.String r0 = ":"
            java.lang.String[] r2 = r2.split(r0)
            int r0 = r2.length
            r1 = 2
            if (r0 < r1) goto L_0x0014
            r0 = 1
            r2 = r2[r0]
            if (r2 == 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r2 = java.io.File.separator
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.FileUtils.e(android.net.Uri):java.lang.String");
    }

    public static String f(Uri uri, Context context) {
        Cursor query;
        String str = null;
        try {
            if (uri.getScheme().equals("content")) {
                query = context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_display_name"));
                    }
                }
                query.close();
            }
            if (str != null) {
                return str;
            }
            String path = uri.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
        } catch (Exception e) {
            Log.e("FilePickerUtils", "Failed to handle file name: " + e.toString());
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public static String g(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30 || !k(uri)) {
            String j = j(i(uri), context);
            new FileInfo.Builder();
            if (j == null) {
                return File.separator;
            }
            String str = File.separator;
            if (j.endsWith(str)) {
                j = j.substring(0, j.length() - 1);
            }
            String e = e(uri);
            if (e.endsWith(str)) {
                e = e.substring(0, e.length() - 1);
            }
            if (e.length() <= 0) {
                return j;
            }
            if (e.startsWith(str)) {
                return j + e;
            }
            return j + str + e;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        if (documentId.equals("downloads")) {
            return path;
        }
        if (documentId.matches("^ms[df]\\:.*")) {
            String f = f(uri, context);
            return path + "/" + f;
        } else if (documentId.startsWith("raw:")) {
            return documentId.split(AccountConstantKt.CODE_SEPARTOR)[1];
        } else {
            return null;
        }
    }

    public static String[] h(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String) arrayList.get(i));
            if (mimeTypeFromExtension == null) {
                Log.w("FilePickerUtils", "Custom file type " + ((String) arrayList.get(i)) + " is unsupported and will be ignored.");
            } else {
                arrayList2.add(mimeTypeFromExtension);
            }
        }
        Log.d("FilePickerUtils", "Allowed file extensions mimes: " + arrayList2);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static String i(Uri uri) {
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(AccountConstantKt.CODE_SEPARTOR);
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    public static String j(String str, Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", (Class[]) null);
            Method method2 = cls.getMethod("getUuid", (Class[]) null);
            Method method3 = cls.getMethod("isPrimary", (Class[]) null);
            Object invoke = method.invoke(storageManager, (Object[]) null);
            if (invoke == null) {
                return null;
            }
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str2 = (String) method2.invoke(obj, (Object[]) null);
                if (((Boolean) method3.invoke(obj, (Object[]) null)) != null && "primary".equals(str)) {
                    return d(cls, obj);
                }
                if (str2 != null && str2.equals(str)) {
                    return d(cls, obj);
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static boolean k(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void l(File file, FileInfo.Builder builder) {
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
            } catch (FileNotFoundException e) {
                Log.e("FilePickerUtils", "File not found: " + e.getMessage(), (Throwable) null);
            } catch (IOException e2) {
                Log.e("FilePickerUtils", "Failed to close file streams: " + e2.getMessage(), (Throwable) null);
            }
            builder.b(bArr);
        } catch (Exception e3) {
            Log.e("FilePickerUtils", "Failed to load bytes into memory with error " + e3.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
        }
    }

    public static FileInfo m(Context context, Uri uri, boolean z) {
        FileOutputStream fileOutputStream;
        Log.i("FilePickerUtils", "Caching from URI: " + uri.toString());
        FileInfo.Builder builder = new FileInfo.Builder();
        String f = f(uri, context);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getAbsolutePath());
        sb.append("/file_picker/");
        sb.append(System.currentTimeMillis());
        sb.append("/");
        sb.append(f != null ? f : "unamed");
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(sb2);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    fileOutputStream.getFD().sync();
                } catch (Exception e) {
                    e = e;
                    try {
                        fileOutputStream.close();
                        Log.e("FilePickerUtils", "Failed to retrieve path: " + e.getMessage(), (Throwable) null);
                        return null;
                    } catch (IOException | NullPointerException unused) {
                        Log.e("FilePickerUtils", "Failed to close file streams: " + e.getMessage(), (Throwable) null);
                        return null;
                    }
                } catch (Throwable th) {
                    fileOutputStream.getFD().sync();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                fileOutputStream.close();
                Log.e("FilePickerUtils", "Failed to retrieve path: " + e.getMessage(), (Throwable) null);
                return null;
            }
        }
        Log.d("FilePickerUtils", "File loaded and cached at:" + sb2);
        if (z) {
            l(file, builder);
        }
        builder.d(sb2).c(f).f(uri).e(Long.parseLong(String.valueOf(file.length())));
        return builder.a();
    }

    public static void n(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                for (File n : file.listFiles()) {
                    n(n);
                }
            }
            file.delete();
        }
    }
}
