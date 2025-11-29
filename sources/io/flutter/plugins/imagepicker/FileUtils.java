package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import io.flutter.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

class FileUtils {
    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private static String getBaseName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(0, lastIndexOf);
    }

    private static String getImageExtension(Context context, Uri uri) {
        try {
            String extensionFromMimeType = uri.getScheme().equals("content") ? MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri)) : MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            if (extensionFromMimeType != null && !extensionFromMimeType.isEmpty()) {
                return "." + extensionFromMimeType;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String getImageName(Context context, Uri uri) {
        Cursor queryImageName = queryImageName(context, uri);
        if (queryImageName != null) {
            try {
                if (queryImageName.moveToFirst()) {
                    if (queryImageName.getColumnCount() >= 1) {
                        String string = queryImageName.getString(0);
                        queryImageName.close();
                        return string;
                    }
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        if (queryImageName == null) {
            return null;
        }
        queryImageName.close();
        return null;
        throw th;
    }

    private static Cursor queryImageName(Context context, Uri uri) {
        return context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
    }

    public String getPathFromUri(Context context, Uri uri) {
        InputStream openInputStream;
        FileOutputStream fileOutputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
            File file = new File(context.getCacheDir(), UUID.randomUUID().toString());
            file.mkdir();
            file.deleteOnExit();
            String imageName = getImageName(context, uri);
            String imageExtension = getImageExtension(context, uri);
            if (imageName == null) {
                Log.w("FileUtils", "Cannot get file name for " + uri);
                if (imageExtension == null) {
                    imageExtension = ".jpg";
                }
                imageName = "image_picker" + imageExtension;
            } else if (imageExtension != null) {
                imageName = getBaseName(imageName) + imageExtension;
            }
            File file2 = new File(file, imageName);
            fileOutputStream = new FileOutputStream(file2);
            copy(openInputStream, fileOutputStream);
            String path = file2.getPath();
            fileOutputStream.close();
            if (openInputStream != null) {
                openInputStream.close();
            }
            return path;
            throw th;
            throw th;
        } catch (IOException | SecurityException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }
}
