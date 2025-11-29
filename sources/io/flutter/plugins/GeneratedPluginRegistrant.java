package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import br.com.yanncabral.open_settings_plus.OpenSettingsPlusPlugin;
import com.baseflow.permissionhandler.PermissionHandlerPlugin;
import com.benjaminabel.vibration.VibrationPlugin;
import com.crazecoder.flutterbugly.FlutterBuglyPlugin;
import com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin;
import com.example.flutter_pag_plugin.FlutterPagPlugin;
import com.example.imagegallerysaver.ImageGallerySaverPlugin;
import com.foo.statusbarcontrol.StatusBarControlPlugin;
import com.jrai.flutter_keyboard_visibility.FlutterKeyboardVisibilityPlugin;
import com.jstyle.blesdk2301.ble2301.Ble2301Plugin;
import com.jstyle.nordic_otas.nordic_otas_plugin.NordicOtasPlugin;
import com.kurenai7968.volume_controller.VolumeControllerPlugin;
import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import com.mr.flutter.plugin.filepicker.FilePickerPlugin;
import com.tekartik.sqflite.SqflitePlugin;
import com.upuphone.myvu.myvu_config_plugin.MyvuConfigPlugin;
import com.upuphone.myvu.myvu_share_plugin.MyvuSharePlugin;
import dev.fluttercommunity.plus.connectivity.ConnectivityPlugin;
import dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin;
import dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
import net.wolverinebeach.flutter_timezone.FlutterTimezonePlugin;

@Keep
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new Ble2301Plugin());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin ble2301, com.jstyle.blesdk2301.ble2301.Ble2301Plugin", e);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ConnectivityPlugin());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin connectivity_plus, dev.fluttercommunity.plus.connectivity.ConnectivityPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DeviceInfoPlusPlugin());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin device_info_plus, dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FilePickerPlugin());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin file_picker, com.mr.flutter.plugin.filepicker.FilePickerPlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterBluePlusPlugin());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin flutter_blue_plus, com.lib.flutter_blue_plus.FlutterBluePlusPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterBuglyPlugin());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin flutter_bugly, com.crazecoder.flutterbugly.FlutterBuglyPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterKeyboardVisibilityPlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin flutter_keyboard_visibility, com.jrai.flutter_keyboard_visibility.FlutterKeyboardVisibilityPlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterLocalNotificationsPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin flutter_local_notifications, com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterTimezonePlugin());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin flutter_timezone, net.wolverinebeach.flutter_timezone.FlutterTimezonePlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ImageGallerySaverPlugin());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin image_gallery_saver, com.example.imagegallerysaver.ImageGallerySaverPlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ImagePickerPlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin image_picker_android, io.flutter.plugins.imagepicker.ImagePickerPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new MyvuConfigPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin myvu_config_plugin, com.upuphone.myvu.myvu_config_plugin.MyvuConfigPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new MyvuSharePlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin myvu_share_plugin, com.upuphone.myvu.myvu_share_plugin.MyvuSharePlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NordicOtasPlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin nordic_otas_plugin, com.jstyle.nordic_otas.nordic_otas_plugin.NordicOtasPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new OpenSettingsPlusPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin open_settings_plus, br.com.yanncabral.open_settings_plus.OpenSettingsPlusPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PackageInfoPlugin());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterPagPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin pag, com.example.flutter_pag_plugin.FlutterPagPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PermissionHandlerPlugin());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharedPreferencesPlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SqflitePlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new StatusBarControlPlugin());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin status_bar_control, com.foo.statusbarcontrol.StatusBarControlPlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UrlLauncherPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new VibrationPlugin());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin vibration, com.benjaminabel.vibration.VibrationPlugin", e25);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new VolumeControllerPlugin());
        } catch (Exception e26) {
            Log.e(TAG, "Error registering plugin volume_controller, com.kurenai7968.volume_controller.VolumeControllerPlugin", e26);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new WebViewFlutterPlugin());
        } catch (Exception e27) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e27);
        }
    }
}
