package top.zibin.luban;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import java.util.Locale;

public class LubanUtils {
    public static String a(Context context, Uri uri, String str, String[] strArr) {
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
            Log.i("Luban", String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", new Object[]{e.getMessage()}));
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

    public static String b(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (!DocumentsContract.isDocumentUri(applicationContext, uri)) {
            return "content".equalsIgnoreCase(uri.getScheme()) ? e(uri) ? uri.getLastPathSegment() : a(applicationContext, uri, (String) null, (String[]) null) : "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : "";
        }
        if (d(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(AccountConstantKt.CODE_SEPARTOR);
            if (!"primary".equalsIgnoreCase(split[0])) {
                return "";
            }
            return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + split[1];
        } else if (c(uri)) {
            return a(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), (String) null, (String[]) null);
        } else if (!f(uri)) {
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
            return a(applicationContext, uri2, "_id=?", new String[]{split2[1]});
        }
    }

    public static boolean c(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean d(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean e(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean f(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
