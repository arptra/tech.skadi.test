package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.honey.account.db.a;
import com.honey.account.db.b;
import com.honey.account.db.c;
import com.honey.account.db.d;
import com.honey.account.db.e;
import com.honey.account.db.f;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.imagepicker.Messages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    @VisibleForTesting
    static final int REQUEST_CAMERA_IMAGE_PERMISSION = 2345;
    @VisibleForTesting
    static final int REQUEST_CAMERA_VIDEO_PERMISSION = 2355;
    @VisibleForTesting
    static final int REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY = 2342;
    @VisibleForTesting
    static final int REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY = 2347;
    @VisibleForTesting
    static final int REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY = 2346;
    @VisibleForTesting
    static final int REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY = 2352;
    @VisibleForTesting
    static final int REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA = 2343;
    @VisibleForTesting
    static final int REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA = 2353;
    @NonNull
    private final Activity activity;
    @NonNull
    private final ImagePickerCache cache;
    private CameraDevice cameraDevice;
    private final ExecutorService executor;
    @VisibleForTesting
    final String fileProviderName;
    private final FileUriResolver fileUriResolver;
    private final FileUtils fileUtils;
    @NonNull
    private final ImageResizer imageResizer;
    @Nullable
    private PendingCallState pendingCallState;
    private final Object pendingCallStateLock;
    private Uri pendingCameraMediaUri;
    private final PermissionManager permissionManager;

    public enum CameraDevice {
        REAR,
        FRONT
    }

    public interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    public class MediaPath {
        final String mimeType;
        final String path;

        public MediaPath(@NonNull String str, @Nullable String str2) {
            this.path = str;
            this.mimeType = str2;
        }

        @Nullable
        public String getMimeType() {
            return this.mimeType;
        }

        @NonNull
        public String getPath() {
            return this.path;
        }
    }

    public interface OnPathReadyListener {
        void onPathReady(String str);
    }

    public static class PendingCallState {
        @Nullable
        public final Messages.ImageSelectionOptions imageOptions;
        @NonNull
        public final Messages.Result<List<String>> result;
        @Nullable
        public final Messages.VideoSelectionOptions videoOptions;

        public PendingCallState(@Nullable Messages.ImageSelectionOptions imageSelectionOptions, @Nullable Messages.VideoSelectionOptions videoSelectionOptions, @NonNull Messages.Result<List<String>> result2) {
            this.imageOptions = imageSelectionOptions;
            this.videoOptions = videoSelectionOptions;
            this.result = result2;
        }
    }

    public interface PermissionManager {
        void askForPermission(String str, int i);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    public ImagePickerDelegate(@NonNull final Activity activity2, @NonNull ImageResizer imageResizer2, @NonNull ImagePickerCache imagePickerCache) {
        this(activity2, imageResizer2, (Messages.ImageSelectionOptions) null, (Messages.VideoSelectionOptions) null, (Messages.Result<List<String>>) null, imagePickerCache, new PermissionManager() {
            public void askForPermission(String str, int i) {
                ActivityCompat.e(activity2, new String[]{str}, i);
            }

            public boolean isPermissionGranted(String str) {
                return ContextCompat.checkSelfPermission(activity2, str) == 0;
            }

            public boolean needRequestCameraPermission() {
                return ImagePickerUtils.needRequestCameraPermission(activity2);
            }
        }, new FileUriResolver() {
            public void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener) {
                MediaScannerConnection.scanFile(activity2, new String[]{uri != null ? uri.getPath() : ""}, (String[]) null, new c(onPathReadyListener));
            }

            public Uri resolveFileProviderUriForFile(String str, File file) {
                return FileProvider.getUriForFile(activity2, str, file);
            }
        }, new FileUtils(), Executors.newSingleThreadExecutor());
    }

    private File createTemporaryWritableFile(String str) {
        String uuid = UUID.randomUUID().toString();
        File cacheDir = this.activity.getCacheDir();
        try {
            cacheDir.mkdirs();
            return File.createTempFile(uuid, str, cacheDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(".jpg");
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private void finishWithAlreadyActiveError(Messages.Result<List<String>> result) {
        result.error(new Messages.FlutterError("already_active", "Image picker is already active", (Object) null));
    }

    private void finishWithError(String str, String str2) {
        Messages.Result<List<String>> result;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState2 = this.pendingCallState;
                result = pendingCallState2 != null ? pendingCallState2.result : null;
                this.pendingCallState = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (result == null) {
            this.cache.saveResult((ArrayList<String>) null, str, str2);
        } else {
            result.error(new Messages.FlutterError(str, str2, (Object) null));
        }
    }

    private void finishWithListSuccess(ArrayList<String> arrayList) {
        Messages.Result<List<String>> result;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState2 = this.pendingCallState;
                result = pendingCallState2 != null ? pendingCallState2.result : null;
                this.pendingCallState = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (result == null) {
            this.cache.saveResult(arrayList, (String) null, (String) null);
        } else {
            result.success(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void finishWithSuccess(@Nullable String str) {
        Messages.Result<List<String>> result;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState2 = this.pendingCallState;
                result = pendingCallState2 != null ? pendingCallState2.result : null;
                this.pendingCallState = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (result != null) {
            result.success(arrayList);
        } else if (!arrayList.isEmpty()) {
            this.cache.saveResult(arrayList, (String) null, (String) null);
        }
    }

    @Nullable
    private ArrayList<MediaPath> getPathsFromIntent(@NonNull Intent intent, boolean z) {
        String pathFromUri;
        ArrayList<MediaPath> arrayList = new ArrayList<>();
        Uri data = intent.getData();
        if (data != null) {
            String pathFromUri2 = this.fileUtils.getPathFromUri(this.activity, data);
            if (pathFromUri2 == null) {
                return null;
            }
            arrayList.add(new MediaPath(pathFromUri2, (String) null));
        } else if (intent.getClipData() == null) {
            return null;
        } else {
            for (int i = 0; i < intent.getClipData().getItemCount(); i++) {
                Uri uri = intent.getClipData().getItemAt(i).getUri();
                if (uri == null || (pathFromUri = this.fileUtils.getPathFromUri(this.activity, uri)) == null) {
                    return null;
                }
                arrayList.add(new MediaPath(pathFromUri, z ? this.activity.getContentResolver().getType(uri) : null));
            }
        }
        return arrayList;
    }

    private String getResizedImagePath(String str, @NonNull Messages.ImageSelectionOptions imageSelectionOptions) {
        return this.imageResizer.resizeImageIfNeeded(str, imageSelectionOptions.getMaxWidth(), imageSelectionOptions.getMaxHeight(), imageSelectionOptions.getQuality().intValue());
    }

    private void grantUriPermissions(Intent intent, Uri uri) {
        PackageManager packageManager = this.activity.getPackageManager();
        for (ResolveInfo resolveInfo : Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) : queryIntentActivitiesPreApi33(packageManager, intent)) {
            this.activity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCaptureImageResult */
    public void lambda$onActivityResult$2(int i) {
        if (i == -1) {
            Uri uri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver2.getFullImagePath(uri, new a(this));
            return;
        }
        finishWithSuccess((String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCaptureVideoResult */
    public void lambda$onActivityResult$5(int i) {
        if (i == -1) {
            Uri uri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver2 = this.fileUriResolver;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver2.getFullImagePath(uri, new b(this));
            return;
        }
        finishWithSuccess((String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseImageResult */
    public void lambda$onActivityResult$0(int i, Intent intent) {
        if (i != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
        if (pathsFromIntent == null) {
            finishWithError("no_valid_image_uri", "Cannot find the selected image.");
        } else {
            handleMediaResult(pathsFromIntent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseMediaResult */
    public void lambda$onActivityResult$3(int i, Intent intent) {
        if (i != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, true);
        if (pathsFromIntent == null) {
            finishWithError("no_valid_media_uri", "Cannot find the selected media.");
        } else {
            handleMediaResult(pathsFromIntent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseMultiImageResult */
    public void lambda$onActivityResult$1(int i, Intent intent) {
        if (i != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
        if (pathsFromIntent == null) {
            finishWithError("missing_valid_image_uri", "Cannot find at least one of the selected images.");
        } else {
            handleMediaResult(pathsFromIntent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleChooseVideoResult */
    public void lambda$onActivityResult$4(int i, Intent intent) {
        if (i != -1 || intent == null) {
            finishWithSuccess((String) null);
            return;
        }
        ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
        if (pathsFromIntent == null || pathsFromIntent.size() < 1) {
            finishWithError("no_valid_video_uri", "Cannot find the selected video.");
        } else {
            finishWithSuccess(pathsFromIntent.get(0).path);
        }
    }

    private void handleMediaResult(@NonNull ArrayList<MediaPath> arrayList) {
        Messages.ImageSelectionOptions imageSelectionOptions;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState2 = this.pendingCallState;
                imageSelectionOptions = pendingCallState2 != null ? pendingCallState2.imageOptions : null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        if (imageSelectionOptions != null) {
            while (i < arrayList.size()) {
                MediaPath mediaPath = arrayList.get(i);
                String str = mediaPath.path;
                String str2 = mediaPath.mimeType;
                if (str2 == null || !str2.startsWith("video/")) {
                    str = getResizedImagePath(mediaPath.path, imageSelectionOptions);
                }
                arrayList2.add(str);
                i++;
            }
            finishWithListSuccess(arrayList2);
            return;
        }
        while (i < arrayList.size()) {
            arrayList2.add(arrayList.get(i).path);
            i++;
        }
        finishWithListSuccess(arrayList2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleCaptureImageResult$6(String str) {
        handleImageResult(str, true);
    }

    private void launchMultiPickImageFromGalleryIntent(Boolean bool, int i) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new ActivityResultContracts.PickMultipleVisualMedia(i).a(this.activity, new PickVisualMediaRequest.Builder().b(ActivityResultContracts.PickVisualMedia.ImageOnly.f131a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY);
    }

    private void launchPickImageFromGalleryIntent(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new ActivityResultContracts.PickVisualMedia().a(this.activity, new PickVisualMediaRequest.Builder().b(ActivityResultContracts.PickVisualMedia.ImageOnly.f131a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY);
    }

    private void launchPickMediaFromGalleryIntent(Messages.GeneralOptions generalOptions) {
        Intent intent;
        if (generalOptions.getUsePhotoPicker().booleanValue()) {
            intent = generalOptions.getAllowMultiple().booleanValue() ? new ActivityResultContracts.PickMultipleVisualMedia(ImagePickerUtils.getLimitFromOption(generalOptions)).a(this.activity, new PickVisualMediaRequest.Builder().b(ActivityResultContracts.PickVisualMedia.ImageAndVideo.f130a).a()) : new ActivityResultContracts.PickVisualMedia().a(this.activity, new PickVisualMediaRequest.Builder().b(ActivityResultContracts.PickVisualMedia.ImageAndVideo.f130a).a());
        } else {
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.setType("*/*");
            intent2.putExtra("CONTENT_TYPE", new String[]{"video/*", "image/*"});
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", generalOptions.getAllowMultiple());
            intent = intent2;
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY);
    }

    private void launchPickVideoFromGalleryIntent(Boolean bool) {
        Intent intent;
        if (bool.booleanValue()) {
            intent = new ActivityResultContracts.PickVisualMedia().a(this.activity, new PickVisualMediaRequest.Builder().b(ActivityResultContracts.PickVisualMedia.VideoOnly.f133a).a());
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("video/*");
        }
        this.activity.startActivityForResult(intent, REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchTakeImageWithCameraIntent() {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.media.action.IMAGE_CAPTURE"
            r0.<init>(r1)
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r1 = r4.cameraDevice
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r2 = io.flutter.plugins.imagepicker.ImagePickerDelegate.CameraDevice.FRONT
            if (r1 != r2) goto L_0x0010
            r4.useFrontCamera(r0)
        L_0x0010:
            java.io.File r1 = r4.createTemporaryWritableImageFile()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "file:"
            r2.append(r3)
            java.lang.String r3 = r1.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r4.pendingCameraMediaUri = r2
            io.flutter.plugins.imagepicker.ImagePickerDelegate$FileUriResolver r2 = r4.fileUriResolver
            java.lang.String r3 = r4.fileProviderName
            android.net.Uri r2 = r2.resolveFileProviderUriForFile(r3, r1)
            java.lang.String r3 = "output"
            r0.putExtra(r3, r2)
            r4.grantUriPermissions(r0, r2)
            android.app.Activity r2 = r4.activity     // Catch:{ ActivityNotFoundException -> 0x0047 }
            r3 = 2343(0x927, float:3.283E-42)
            r2.startActivityForResult(r0, r3)     // Catch:{ ActivityNotFoundException -> 0x0047 }
            goto L_0x0056
        L_0x0047:
            r1.delete()     // Catch:{ SecurityException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004f:
            java.lang.String r0 = "no_available_camera"
            java.lang.String r1 = "No cameras available for taking pictures."
            r4.finishWithError(r0, r1)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchTakeImageWithCameraIntent():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchTakeVideoWithCameraIntent() {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.media.action.VIDEO_CAPTURE"
            r0.<init>(r1)
            java.lang.Object r1 = r4.pendingCallStateLock
            monitor-enter(r1)
            io.flutter.plugins.imagepicker.ImagePickerDelegate$PendingCallState r2 = r4.pendingCallState     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x0013
            io.flutter.plugins.imagepicker.Messages$VideoSelectionOptions r2 = r2.videoOptions     // Catch:{ all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r4 = move-exception
            goto L_0x007a
        L_0x0013:
            r2 = 0
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x002a
            java.lang.Long r1 = r2.getMaxDurationSeconds()
            if (r1 == 0) goto L_0x002a
            java.lang.Long r1 = r2.getMaxDurationSeconds()
            int r1 = r1.intValue()
            java.lang.String r2 = "android.intent.extra.durationLimit"
            r0.putExtra(r2, r1)
        L_0x002a:
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r1 = r4.cameraDevice
            io.flutter.plugins.imagepicker.ImagePickerDelegate$CameraDevice r2 = io.flutter.plugins.imagepicker.ImagePickerDelegate.CameraDevice.FRONT
            if (r1 != r2) goto L_0x0033
            r4.useFrontCamera(r0)
        L_0x0033:
            java.io.File r1 = r4.createTemporaryWritableVideoFile()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "file:"
            r2.append(r3)
            java.lang.String r3 = r1.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r4.pendingCameraMediaUri = r2
            io.flutter.plugins.imagepicker.ImagePickerDelegate$FileUriResolver r2 = r4.fileUriResolver
            java.lang.String r3 = r4.fileProviderName
            android.net.Uri r2 = r2.resolveFileProviderUriForFile(r3, r1)
            java.lang.String r3 = "output"
            r0.putExtra(r3, r2)
            r4.grantUriPermissions(r0, r2)
            android.app.Activity r2 = r4.activity     // Catch:{ ActivityNotFoundException -> 0x006a }
            r3 = 2353(0x931, float:3.297E-42)
            r2.startActivityForResult(r0, r3)     // Catch:{ ActivityNotFoundException -> 0x006a }
            goto L_0x0079
        L_0x006a:
            r1.delete()     // Catch:{ SecurityException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0072:
            java.lang.String r0 = "no_available_camera"
            java.lang.String r1 = "No cameras available for taking pictures."
            r4.finishWithError(r0, r1)
        L_0x0079:
            return
        L_0x007a:
            monitor-exit(r1)     // Catch:{ all -> 0x0011 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchTakeVideoWithCameraIntent():void");
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager2 = this.permissionManager;
        if (permissionManager2 == null) {
            return false;
        }
        return permissionManager2.needRequestCameraPermission();
    }

    private static List<ResolveInfo> queryIntentActivitiesPreApi33(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentActivities(intent, 65536);
    }

    private boolean setPendingOptionsAndResult(@Nullable Messages.ImageSelectionOptions imageSelectionOptions, @Nullable Messages.VideoSelectionOptions videoSelectionOptions, @NonNull Messages.Result<List<String>> result) {
        synchronized (this.pendingCallStateLock) {
            try {
                if (this.pendingCallState != null) {
                    return false;
                }
                this.pendingCallState = new PendingCallState(imageSelectionOptions, videoSelectionOptions, result);
                this.cache.clear();
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private void useFrontCamera(Intent intent) {
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
    }

    public void chooseImageFromGallery(@NonNull Messages.ImageSelectionOptions imageSelectionOptions, boolean z, @NonNull Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickImageFromGalleryIntent(Boolean.valueOf(z));
        }
    }

    public void chooseMediaFromGallery(@NonNull Messages.MediaSelectionOptions mediaSelectionOptions, @NonNull Messages.GeneralOptions generalOptions, @NonNull Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(mediaSelectionOptions.getImageSelectionOptions(), (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickMediaFromGalleryIntent(generalOptions);
        }
    }

    public void chooseMultiImageFromGallery(@NonNull Messages.ImageSelectionOptions imageSelectionOptions, boolean z, int i, @NonNull Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchMultiPickImageFromGalleryIntent(Boolean.valueOf(z), i);
        }
    }

    public void chooseVideoFromGallery(@NonNull Messages.VideoSelectionOptions videoSelectionOptions, boolean z, @NonNull Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult((Messages.ImageSelectionOptions) null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickVideoFromGalleryIntent(Boolean.valueOf(z));
        }
    }

    public void handleImageResult(String str, boolean z) {
        Messages.ImageSelectionOptions imageSelectionOptions;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState2 = this.pendingCallState;
                imageSelectionOptions = pendingCallState2 != null ? pendingCallState2.imageOptions : null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (imageSelectionOptions != null) {
            String resizedImagePath = getResizedImagePath(str, imageSelectionOptions);
            if (resizedImagePath != null && !resizedImagePath.equals(str) && z) {
                new File(str).delete();
            }
            finishWithSuccess(resizedImagePath);
            return;
        }
        finishWithSuccess(str);
    }

    public boolean onActivityResult(int i, int i2, @Nullable Intent intent) {
        Runnable runnable;
        if (i == REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY) {
            runnable = new a(this, i2, intent);
        } else if (i == REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA) {
            runnable = new c(this, i2);
        } else if (i == REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY) {
            runnable = new b(this, i2, intent);
        } else if (i == REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY) {
            runnable = new d(this, i2, intent);
        } else if (i == REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY) {
            runnable = new e(this, i2, intent);
        } else if (i != REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA) {
            return false;
        } else {
            runnable = new f(this, i2);
        }
        this.executor.execute(runnable);
        return true;
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z = iArr.length > 0 && iArr[0] == 0;
        if (i != REQUEST_CAMERA_IMAGE_PERMISSION) {
            if (i != REQUEST_CAMERA_VIDEO_PERMISSION) {
                return false;
            }
            if (z) {
                launchTakeVideoWithCameraIntent();
            }
        } else if (z) {
            launchTakeImageWithCameraIntent();
        }
        if (!z && (i == REQUEST_CAMERA_IMAGE_PERMISSION || i == REQUEST_CAMERA_VIDEO_PERMISSION)) {
            finishWithError("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }

    @Nullable
    public Messages.CacheRetrievalResult retrieveLostImage() {
        Map<String, Object> cacheMap = this.cache.getCacheMap();
        if (cacheMap.isEmpty()) {
            return null;
        }
        Messages.CacheRetrievalResult.Builder builder = new Messages.CacheRetrievalResult.Builder();
        Messages.CacheRetrievalType cacheRetrievalType = (Messages.CacheRetrievalType) cacheMap.get("type");
        if (cacheRetrievalType != null) {
            builder.setType(cacheRetrievalType);
        }
        builder.setError((Messages.CacheRetrievalError) cacheMap.get("error"));
        ArrayList arrayList = (ArrayList) cacheMap.get("pathList");
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Double d = (Double) cacheMap.get("maxWidth");
                Double d2 = (Double) cacheMap.get("maxHeight");
                Integer num = (Integer) cacheMap.get("imageQuality");
                arrayList2.add(this.imageResizer.resizeImageIfNeeded(str, d, d2, num == null ? 100 : num.intValue()));
            }
            builder.setPaths(arrayList2);
        }
        this.cache.clear();
        return builder.build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x000e, code lost:
        r0 = r3.cache;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0010, code lost:
        if (r1 == null) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0012, code lost:
        r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.IMAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
        r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.VIDEO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        r0.saveType(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        if (r1 == null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001c, code lost:
        r3.cache.saveDimensionWithOutputOptions(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r0 = r3.pendingCameraMediaUri;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0025, code lost:
        r3.cache.savePendingCameraMediaUriPath(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveStateBeforeResult() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.pendingCallStateLock
            monitor-enter(r0)
            io.flutter.plugins.imagepicker.ImagePickerDelegate$PendingCallState r1 = r3.pendingCallState     // Catch:{ all -> 0x0009 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r3 = move-exception
            goto L_0x002b
        L_0x000b:
            io.flutter.plugins.imagepicker.Messages$ImageSelectionOptions r1 = r1.imageOptions     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            io.flutter.plugins.imagepicker.ImagePickerCache r0 = r3.cache
            if (r1 == 0) goto L_0x0015
            io.flutter.plugins.imagepicker.ImagePickerCache$CacheType r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.IMAGE
            goto L_0x0017
        L_0x0015:
            io.flutter.plugins.imagepicker.ImagePickerCache$CacheType r2 = io.flutter.plugins.imagepicker.ImagePickerCache.CacheType.VIDEO
        L_0x0017:
            r0.saveType(r2)
            if (r1 == 0) goto L_0x0021
            io.flutter.plugins.imagepicker.ImagePickerCache r0 = r3.cache
            r0.saveDimensionWithOutputOptions(r1)
        L_0x0021:
            android.net.Uri r0 = r3.pendingCameraMediaUri
            if (r0 == 0) goto L_0x002a
            io.flutter.plugins.imagepicker.ImagePickerCache r3 = r3.cache
            r3.savePendingCameraMediaUriPath(r0)
        L_0x002a:
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.saveStateBeforeResult():void");
    }

    public void setCameraDevice(CameraDevice cameraDevice2) {
        this.cameraDevice = cameraDevice2;
    }

    public void takeImageWithCamera(@NonNull Messages.ImageSelectionOptions imageSelectionOptions, @NonNull Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, (Messages.VideoSelectionOptions) null, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeImageWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_IMAGE_PERMISSION);
        }
    }

    public void takeVideoWithCamera(@NonNull Messages.VideoSelectionOptions videoSelectionOptions, @NonNull Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult((Messages.ImageSelectionOptions) null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else if (!needRequestCameraPermission() || this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            launchTakeVideoWithCameraIntent();
        } else {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_VIDEO_PERMISSION);
        }
    }

    @VisibleForTesting
    public ImagePickerDelegate(@NonNull Activity activity2, @NonNull ImageResizer imageResizer2, @Nullable Messages.ImageSelectionOptions imageSelectionOptions, @Nullable Messages.VideoSelectionOptions videoSelectionOptions, @Nullable Messages.Result<List<String>> result, @NonNull ImagePickerCache imagePickerCache, PermissionManager permissionManager2, FileUriResolver fileUriResolver2, FileUtils fileUtils2, ExecutorService executorService) {
        this.pendingCallStateLock = new Object();
        this.activity = activity2;
        this.imageResizer = imageResizer2;
        this.fileProviderName = activity2.getPackageName() + ".flutter.image_provider";
        if (result != null) {
            this.pendingCallState = new PendingCallState(imageSelectionOptions, videoSelectionOptions, result);
        }
        this.permissionManager = permissionManager2;
        this.fileUriResolver = fileUriResolver2;
        this.fileUtils = fileUtils2;
        this.cache = imagePickerCache;
        this.executor = executorService;
    }
}
