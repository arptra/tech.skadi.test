package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public final class AppLocalesMetadataHolderService extends Service {

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static int a() {
            return 512;
        }
    }

    public static ServiceInfo a(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), Api24Impl.a() | 128);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
