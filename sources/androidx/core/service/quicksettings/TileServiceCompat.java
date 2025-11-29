package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public class TileServiceCompat {

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static void a(TileService tileService, Intent intent) {
            tileService.startActivityAndCollapse(intent);
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static void a(TileService tileService, PendingIntent pendingIntent) {
            tileService.startActivityAndCollapse(pendingIntent);
        }
    }

    public interface TileServiceWrapper {
    }
}
