package com.upuphone.xr.interconnect.pm;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upuphone.xr.interconnect.R;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.entity.StarryNetAppDockMenu;
import com.upuphone.xr.interconnect.util.XrSdkDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;

public final class StarryNetAppUtil {
    private static final String INTENT_ACTION = "custom.intent.action.StarryNetApp";
    private static final String INTENT_CATEGORY = "custom.intent.category.StarryNetApp";
    private static final String STARRY_NET_APP_ID_SEPARATOR = "@";
    private static final String TAG = "StarryNetAppUtil";
    private static final String XML_DOCK_MENU = "DockMenu";
    private static final String XML_STARRY_NET_APP = "StarryNetApp";
    private static final String XML_STARRY_NET_APP_CONFIG = "starry_net_app_config";

    private StarryNetAppUtil() {
    }

    public static String getAppDockMenuIconName(StarryNetAppDockMenu starryNetAppDockMenu) {
        return String.format("%s@%s.png", new Object[]{starryNetAppDockMenu.getAppId(), starryNetAppDockMenu.getId()});
    }

    public static String getAppIconName(StarryNetApp starryNetApp) {
        return String.format("%s@%s.png", new Object[]{starryNetApp.getPackageName(), starryNetApp.getId()});
    }

    public static boolean isStarryNetAppIdValid(String str) {
        return str.split(STARRY_NET_APP_ID_SEPARATOR).length > 1;
    }

    public static String paresStarryNetAppPackage(String str) {
        return str.split(STARRY_NET_APP_ID_SEPARATOR)[0];
    }

    public static String parseStarryNetAppId(String str) {
        String[] split = str.split(STARRY_NET_APP_ID_SEPARATOR);
        return split.length > 1 ? split[1] : split[0];
    }

    public static List<StarryNetApp> queryStarryNetApp(@NonNull Context context) {
        return queryTargetStarryNetApp(context, (String) null);
    }

    public static List<StarryNetApp> queryTargetStarryNetApp(@NonNull Context context, String str) {
        ILog.w(TAG, "queryTargetStarryNetApp targetPkgName = " + str);
        List<StarryNetApp> list = (List) new Gson().fromJson(XrSdkDeviceUtil.isIsIntl() ? context.getString(R.string.app_info_intl) : context.getString(R.string.app_info), new TypeToken<List<StarryNetApp>>() {
        }.getType());
        for (int i = 0; i < list.size(); i++) {
            ILog.w(TAG, "queryTargetStarryNetApp info =" + list.get(i).toString());
        }
        return list;
    }
}
