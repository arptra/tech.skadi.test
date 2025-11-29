package com.here.odnp.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OdnpAssetManager {
    private static final String TAG = "odnp.util.OdnpAssetManager";

    public static class Asset {
        private final String mName;
        private final boolean mOverwrite;
        private final boolean mRequired;

        public Asset(String str, boolean z, boolean z2) {
            this.mName = str;
            this.mRequired = z;
            this.mOverwrite = z2;
        }

        public String getName() {
            return this.mName;
        }

        public boolean getOverwrite() {
            return this.mOverwrite;
        }

        public boolean getRequired() {
            return this.mRequired;
        }
    }

    public interface AsyncCopyListener {
        void asyncCopyFinished(boolean z);
    }

    public static AssetCopyTask asyncCopyAssets(Context context, Asset[] assetArr, AsyncCopyListener asyncCopyListener) {
        return new AssetCopyTask(context, asyncCopyListener).start(assetArr);
    }

    public static boolean copyAsset(Context context, Asset asset) {
        BufferedOutputStream bufferedOutputStream;
        FileNotFoundException e;
        IOException e2;
        File file = new File(OdnpFileManager.getPrivateDir(context), asset.getName());
        Log.v(TAG, "copyAsset: Copying '%s'' => '%s'", asset.getName(), file.getAbsolutePath());
        boolean z = true;
        if (!file.exists() || asset.getOverwrite()) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open(asset.getName()));
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    Log.e(TAG, "copyAsset: getParentFile is null", new Object[0]);
                    OdnpIOUtils.close((InputStream) bufferedInputStream);
                    return false;
                } else if (parentFile.exists() || parentFile.mkdirs()) {
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            OdnpIOUtils.copy(bufferedInputStream, bufferedOutputStream);
                        } catch (FileNotFoundException e3) {
                            e = e3;
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                Log.w(TAG, "copyAsset: Unable to copy, error: %s", Log.getStackTraceString(e2));
                                z = false;
                                return OdnpIOUtils.close((InputStream) bufferedInputStream) & z & OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                OdnpIOUtils.close((InputStream) bufferedInputStream);
                                OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e5) {
                        FileNotFoundException fileNotFoundException = e5;
                        bufferedOutputStream = null;
                        e = fileNotFoundException;
                        Log.w(TAG, "copyAsset: Unable to create file, error: %s", Log.getStackTraceString(e));
                        z = false;
                        return OdnpIOUtils.close((InputStream) bufferedInputStream) & z & OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                    } catch (IOException e6) {
                        IOException iOException = e6;
                        bufferedOutputStream = null;
                        e2 = iOException;
                        Log.w(TAG, "copyAsset: Unable to copy, error: %s", Log.getStackTraceString(e2));
                        z = false;
                        return OdnpIOUtils.close((InputStream) bufferedInputStream) & z & OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        bufferedOutputStream = null;
                        th = th3;
                        OdnpIOUtils.close((InputStream) bufferedInputStream);
                        OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                        throw th;
                    }
                    return OdnpIOUtils.close((InputStream) bufferedInputStream) & z & OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                } else {
                    Log.e(TAG, "copyAsset: Could not create path '%s'", parentFile.getAbsolutePath());
                    OdnpIOUtils.close((InputStream) bufferedInputStream);
                    return false;
                }
            } catch (IOException e7) {
                if (!asset.getRequired()) {
                    return true;
                }
                Log.e(TAG, "copyAsset: Unable to find mandatory asset: '%s': %s", asset.getName(), Log.getStackTraceString(e7));
                return false;
            }
        } else {
            Log.v(TAG, "copyAsset: The file '%s'' already exists and overwrite disabled -> ignored", file.getAbsolutePath());
            return true;
        }
    }

    public static boolean copyAssets(Context context, Asset[] assetArr) {
        boolean z = true;
        for (Asset copyAsset : assetArr) {
            z &= copyAsset(context, copyAsset);
        }
        return z;
    }
}
