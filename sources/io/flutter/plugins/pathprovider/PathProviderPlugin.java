package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.pathprovider.Messages;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathProviderPlugin implements FlutterPlugin, Messages.PathProviderApi {
    static final String TAG = "PathProviderPlugin";
    private Context context;

    /* renamed from: io.flutter.plugins.pathprovider.PathProviderPlugin$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.flutter.plugins.pathprovider.Messages$StorageDirectory[] r0 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory = r0
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.ROOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.MUSIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.PODCASTS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.RINGTONES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x003e }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.ALARMS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.NOTIFICATIONS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.PICTURES     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.MOVIES     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x006c }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.DOWNLOADS     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.DCIM     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.flutter.plugins.pathprovider.Messages$StorageDirectory r1 = io.flutter.plugins.pathprovider.Messages.StorageDirectory.DOCUMENTS     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.pathprovider.PathProviderPlugin.AnonymousClass1.<clinit>():void");
        }
    }

    private String getApplicationSupportDirectory() {
        return PathUtils.getFilesDir(this.context);
    }

    private String getPathProviderApplicationDocumentsDirectory() {
        return PathUtils.getDataDirectory(this.context);
    }

    private List<String> getPathProviderExternalCacheDirectories() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.context.getExternalCacheDirs()) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private List<String> getPathProviderExternalStorageDirectories(@NonNull Messages.StorageDirectory storageDirectory) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.context.getExternalFilesDirs(getStorageDirectoryString(storageDirectory))) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private String getPathProviderStorageDirectory() {
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    private String getPathProviderTemporaryDirectory() {
        return this.context.getCacheDir().getPath();
    }

    private String getStorageDirectoryString(@NonNull Messages.StorageDirectory storageDirectory) {
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$pathprovider$Messages$StorageDirectory[storageDirectory.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "music";
            case 3:
                return "podcasts";
            case 4:
                return "ringtones";
            case 5:
                return "alarms";
            case 6:
                return "notifications";
            case 7:
                return "pictures";
            case 8:
                return "movies";
            case 9:
                return "downloads";
            case 10:
                return "dcim";
            case 11:
                return "documents";
            default:
                throw new RuntimeException("Unrecognized directory: " + storageDirectory);
        }
    }

    private void setup(BinaryMessenger binaryMessenger, Context context2) {
        try {
            Messages.PathProviderApi.setup(binaryMessenger, this);
        } catch (Exception e) {
            Log.e(TAG, "Received exception while setting up PathProviderPlugin", e);
        }
        this.context = context2;
    }

    @Nullable
    public String getApplicationCachePath() {
        return this.context.getCacheDir().getPath();
    }

    @Nullable
    public String getApplicationDocumentsPath() {
        return getPathProviderApplicationDocumentsDirectory();
    }

    @Nullable
    public String getApplicationSupportPath() {
        return getApplicationSupportDirectory();
    }

    @NonNull
    public List<String> getExternalCachePaths() {
        return getPathProviderExternalCacheDirectories();
    }

    @Nullable
    public String getExternalStoragePath() {
        return getPathProviderStorageDirectory();
    }

    @NonNull
    public List<String> getExternalStoragePaths(@NonNull Messages.StorageDirectory storageDirectory) {
        return getPathProviderExternalStorageDirectories(storageDirectory);
    }

    @Nullable
    public String getTemporaryPath() {
        return getPathProviderTemporaryDirectory();
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setup(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Messages.PathProviderApi.setup(flutterPluginBinding.getBinaryMessenger(), (Messages.PathProviderApi) null);
    }
}
