package io.flutter.plugins.webviewflutter;

import android.webkit.PermissionRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.List;
import java.util.Objects;

@RequiresApi
public class PermissionRequestHostApiImpl implements GeneratedAndroidWebView.PermissionRequestHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public PermissionRequestHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
    }

    private PermissionRequest getPermissionRequestInstance(@NonNull Long l) {
        PermissionRequest permissionRequest = (PermissionRequest) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(permissionRequest);
        return permissionRequest;
    }

    public void deny(@NonNull Long l) {
        getPermissionRequestInstance(l).deny();
    }

    public void grant(@NonNull Long l, @NonNull List<String> list) {
        getPermissionRequestInstance(l).grant((String[]) list.toArray(new String[0]));
    }
}
