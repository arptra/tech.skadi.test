package com.here.services.internal;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpIOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UserConsent {
    private static final String CONSENT_SETTING_NAME = "here_positioning_consent";
    private static final int SETTING_FALSE = 0;
    private static final int SETTING_TRUE = 1;
    private static final String TAG = "services.internal.UserConsent";
    private static final String USER_OK_FILE = "userok";

    private static boolean checkUserConsentFile(Context context) {
        File fileStreamPath = context.getFileStreamPath(USER_OK_FILE);
        return fileStreamPath != null && fileStreamPath.exists();
    }

    public static boolean isGranted(Context context) {
        Log.v(TAG, "isGranted: consent is not required", new Object[0]);
        return true;
    }

    public static boolean update(Context context, boolean z) {
        Log.v(TAG, "update: consent is not required", new Object[0]);
        return true;
    }

    private static boolean updateUserConsentFile(Context context, boolean z) {
        if (!z) {
            return context.deleteFile(USER_OK_FILE);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(USER_OK_FILE, 0);
            fileOutputStream.write((int) (System.currentTimeMillis() / 1000));
            return OdnpIOUtils.close((OutputStream) fileOutputStream);
        } catch (IOException unused) {
            return false;
        } finally {
            OdnpIOUtils.close((OutputStream) fileOutputStream);
        }
    }
}
