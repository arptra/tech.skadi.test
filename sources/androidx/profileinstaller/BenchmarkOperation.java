package androidx.profileinstaller;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class BenchmarkOperation {

    @RequiresApi
    public static class Api21ContextHelper {
    }

    @RequiresApi
    public static class Api24ContextHelper {
        public static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z = true;
            for (int i = 0; i < length; i++) {
                z = a(listFiles[i]) && z;
            }
            return z;
        }
        file.delete();
        return true;
    }

    public static void b(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        if (a(Api24ContextHelper.a(context))) {
            resultDiagnostics.a(14, (Object) null);
        } else {
            resultDiagnostics.a(15, (Object) null);
        }
    }
}
