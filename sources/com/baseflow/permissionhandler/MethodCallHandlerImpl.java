package com.baseflow.permissionhandler;

import android.content.Context;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Objects;

final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2400a;
    public final AppSettingsManager b;
    public final PermissionManager c;
    public final ServiceManager d;

    public MethodCallHandlerImpl(Context context, AppSettingsManager appSettingsManager, PermissionManager permissionManager, ServiceManager serviceManager) {
        this.f2400a = context;
        this.b = appSettingsManager;
        this.c = permissionManager;
        this.d = serviceManager;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    c2 = 1;
                    break;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    c2 = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                int parseInt = Integer.parseInt(methodCall.arguments.toString());
                ServiceManager serviceManager = this.d;
                Context context = this.f2400a;
                Objects.requireNonNull(result);
                serviceManager.a(parseInt, context, new a(result), new b(result));
                return;
            case 1:
                int parseInt2 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager = this.c;
                Objects.requireNonNull(result);
                permissionManager.i(parseInt2, new f(result), new g(result));
                return;
            case 2:
                int parseInt3 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager2 = this.c;
                Objects.requireNonNull(result);
                permissionManager2.c(parseInt3, new c(result));
                return;
            case 3:
                AppSettingsManager appSettingsManager = this.b;
                Context context2 = this.f2400a;
                Objects.requireNonNull(result);
                appSettingsManager.a(context2, new h(result), new i(result));
                return;
            case 4:
                PermissionManager permissionManager3 = this.c;
                Objects.requireNonNull(result);
                permissionManager3.g((List) methodCall.arguments(), new d(result), new e(result));
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
