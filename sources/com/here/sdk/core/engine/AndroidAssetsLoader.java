package com.here.sdk.core.engine;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

class AndroidAssetsLoader implements AssetsLoader {
    private static final String LOG_TAG = "AndroidAssetsLoader";
    private final Context m_context;

    public AndroidAssetsLoader(Context context) {
        this.m_context = context;
    }

    private ByteArrayOutputStream loadAssetStream(@NonNull String str) {
        InputStream open;
        try {
            open = this.m_context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    return byteArrayOutputStream;
                }
            }
        } catch (Exception e) {
            String str2 = LOG_TAG;
            Log.e(str2, "Failed to load asset stream " + str, e);
            return new ByteArrayOutputStream();
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public boolean checkAssetAvailability(@NonNull String str) {
        try {
            this.m_context.getAssets().open(str).close();
            return true;
        } catch (Exception e) {
            String str2 = LOG_TAG;
            Log.i(str2, "Asset with path - " + str + " could not been found", e);
            return false;
        }
    }

    @NonNull
    public String getAssetsPath() {
        return this.m_context.getFilesDir().getAbsolutePath();
    }

    @NonNull
    public List<String> getSubfolderNames(@NonNull String str) {
        String[] strArr = new String[0];
        try {
            strArr = this.m_context.getAssets().list(str);
        } catch (IOException e) {
            String str2 = LOG_TAG;
            Log.e(str2, "Failed to list assets at " + str, e);
        }
        return Arrays.asList(strArr);
    }

    @NonNull
    public String loadAsset(@NonNull String str) {
        try {
            return loadAssetStream(str).toString("UTF-8");
        } catch (Exception e) {
            String str2 = LOG_TAG;
            Log.e(str2, "Failed to load " + str, e);
            return "";
        }
    }

    @NonNull
    public byte[] loadAssetBlob(@NonNull String str) {
        return loadAssetStream(str).toByteArray();
    }
}
