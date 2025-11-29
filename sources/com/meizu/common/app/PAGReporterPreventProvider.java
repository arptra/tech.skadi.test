package com.meizu.common.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.common.util.PAGReporterPrevent;

public class PAGReporterPreventProvider extends ContentProvider {
    private static final String TAG = " [PAGReporterProvider] ";

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean onCreate() {
        try {
            Log.i(TAG, "pag provider onCreate");
            if (getContext() != null) {
                PAGReporterPrevent.init(getContext());
                return true;
            }
            Log.i(TAG, "pag provider get context null");
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
