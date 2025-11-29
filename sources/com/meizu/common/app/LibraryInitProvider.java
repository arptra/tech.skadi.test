package com.meizu.common.app;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

public class LibraryInitProvider extends ContentProvider {
    private static final int INIT_DELAY = 3000;
    private static final String TAG = "[LibraryInitProvider]";
    private Handler mHandler;
    private boolean mHasInit = false;

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean onCreate() {
        if (getContext() == null) {
            Log.i(TAG, "init fail context is null");
            return true;
        } else if (this.mHasInit) {
            Log.i(TAG, "has init already.");
            return true;
        } else {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHasInit = true;
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    try {
                        Class.forName("com.meizu.nightmode.MzHighContrastManager");
                        Log.i(LibraryInitProvider.TAG, "start init");
                        HighContrastRegisterManager.init((Application) LibraryInitProvider.this.getContext().getApplicationContext());
                    } catch (Exception unused) {
                        Log.i(LibraryInitProvider.TAG, "not Support high contrast");
                    }
                }
            }, 3000);
            return true;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
