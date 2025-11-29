package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator f786a = new a();

    public interface ContentQueryWrapper {
        static ContentQueryWrapper a(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }

        Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    public static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final ContentProviderClient f787a;

        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f787a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.f787a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    @RequiresApi
    public static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final ContentProviderClient f788a;

        public ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.f788a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f788a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.f788a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    public static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List d(FontRequest fontRequest, Resources resources) {
        return fontRequest.b() != null ? fontRequest.b() : FontResourcesParserCompat.c(resources, fontRequest.c());
    }

    public static FontsContractCompat.FontFamilyResult e(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) {
        ProviderInfo f = f(context.getPackageManager(), fontRequest, context.getResources());
        return f == null ? FontsContractCompat.FontFamilyResult.a(1, (FontsContractCompat.FontInfo[]) null) : FontsContractCompat.FontFamilyResult.a(0, h(context, fontRequest, f.authority, cancellationSignal));
    }

    public static ProviderInfo f(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        String e = fontRequest.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e);
        } else if (resolveContentProvider.packageName.equals(fontRequest.f())) {
            List b = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b, f786a);
            List d = d(fontRequest, resources);
            for (int i = 0; i < d.size(); i++) {
                ArrayList arrayList = new ArrayList((Collection) d.get(i));
                Collections.sort(arrayList, f786a);
                if (c(b, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + e + ", but package was not " + fontRequest.f());
        }
    }

    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    public static FontsContractCompat.FontInfo[] h(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        Uri uri;
        boolean z;
        String str2 = str;
        ArrayList arrayList2 = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        ContentQueryWrapper a2 = ContentQueryWrapper.a(context, build);
        Cursor cursor = null;
        try {
            Cursor b = a2.b(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.g()}, (String) null, cancellationSignal);
            if (b != null && b.getCount() > 0) {
                int columnIndex = b.getColumnIndex("result_code");
                ArrayList arrayList3 = new ArrayList();
                int columnIndex2 = b.getColumnIndex("_id");
                int columnIndex3 = b.getColumnIndex("file_id");
                int columnIndex4 = b.getColumnIndex("font_ttc_index");
                int columnIndex5 = b.getColumnIndex("font_weight");
                int columnIndex6 = b.getColumnIndex("font_italic");
                while (b.moveToNext()) {
                    int i = columnIndex != -1 ? b.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? b.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        arrayList = arrayList3;
                        uri = ContentUris.withAppendedId(build, b.getLong(columnIndex2));
                    } else {
                        arrayList = arrayList3;
                        uri = ContentUris.withAppendedId(build2, b.getLong(columnIndex3));
                    }
                    int i3 = columnIndex5 != -1 ? b.getInt(columnIndex5) : CmdCode.CODE_WAKEUP_RECORDING;
                    if (columnIndex6 != -1) {
                        z = true;
                        if (b.getInt(columnIndex6) == 1) {
                            FontsContractCompat.FontInfo a3 = FontsContractCompat.FontInfo.a(uri, i2, i3, z, i);
                            arrayList3 = arrayList;
                            arrayList3.add(a3);
                        }
                    }
                    z = false;
                    FontsContractCompat.FontInfo a32 = FontsContractCompat.FontInfo.a(uri, i2, i3, z, i);
                    arrayList3 = arrayList;
                    arrayList3.add(a32);
                }
                arrayList2 = arrayList3;
            }
            if (b != null) {
                b.close();
            }
            a2.close();
            return (FontsContractCompat.FontInfo[]) arrayList2.toArray(new FontsContractCompat.FontInfo[0]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            a2.close();
            throw th;
        }
    }
}
