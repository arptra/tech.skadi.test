package androidx.webkit;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.webkit.internal.WebViewGlueCommunicator;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;

public final class DropDataContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public DropDataContentProviderBoundaryInterface f1950a;

    public final DropDataContentProviderBoundaryInterface a() {
        if (this.f1950a == null) {
            DropDataContentProviderBoundaryInterface dropDataProvider = WebViewGlueCommunicator.d().getDropDataProvider();
            this.f1950a = dropDataProvider;
            dropDataProvider.onCreate();
        }
        return this.f1950a;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        return a().call(str, str2, bundle);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("delete method is not supported.");
    }

    public String getType(Uri uri) {
        return a().getType(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert method is not supported.");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return a().openFile(this, uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return a().query(uri, strArr, str, strArr2, str2);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("update method is not supported.");
    }
}
