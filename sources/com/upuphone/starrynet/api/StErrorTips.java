package com.upuphone.starrynet.api;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StErrorTips {
    private static final String STARRY_NET_SETTING_ERROR_TIPS_PROPERTY = "starry_net_error_tips_prop";
    private static final String TAG = "StErrorTips";
    private static Context appContext;
    private static TipsDialog tipsDialog;
    /* access modifiers changed from: private */
    public static String versionName;

    public enum ErrorTips {
        P2P_ALL_GO("双端p2p连接都是go角色", "无法建立p2p连接", "需要联系StarryNet确认一下车机的model,是否在相关配置项中"),
        P2P_ALL_GC("双端p2p连接都是gc角色", "无法建立p2p连接", "需要联系StarryNet确认一下车机的model,是否在相关配置项中"),
        P2P_GO_NAME_INVALID("P2P GO name无效", "go name不是starrynet定义的格式，不会发起p2p连接", "需要联系StarryNet P2P排查Go Name设置不生效的原因"),
        BLE_GATT_SERVER_NOT_OPEN("Ble Gatt Server启动异常", "1.无法发现设备\n2.无法回连设备\n", "需要车机端蓝牙排查Ble Gatt Server启动异常的原因"),
        P2P_HEARTBEAT_TIMEOUT("P2P连接心跳包超时", "FlymeLink断开", "提供相关的p2p日志给StarryNet P2P的开发同事，做进一步分析"),
        NONE("", "", "");
        
        private String desc;
        private String solution;
        private String title;

        private ErrorTips(String str, String str2, String str3) {
            this.title = str;
            this.desc = str2;
            this.solution = str3;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getSolution() {
            return this.solution;
        }

        public String getTitle() {
            return this.title;
        }
    }

    public static class TipsDialog extends AlertDialog {
        private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS", Locale.getDefault());
        private TextView txtDesc;
        private TextView txtSolution;

        public TipsDialog(Context context) {
            super(context);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundResource(17301654);
            int dp2px = (int) dp2px(15.0f);
            linearLayout.setPadding(dp2px, 0, dp2px, dp2px);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (int) dp2px(10.0f);
            TextView textView = new TextView(context);
            this.txtDesc = textView;
            textView.setLayoutParams(layoutParams);
            this.txtDesc.setTextSize(2, 18.0f);
            linearLayout.addView(this.txtDesc);
            TextView textView2 = new TextView(context);
            this.txtSolution = textView2;
            textView2.setLayoutParams(layoutParams);
            this.txtSolution.setTextSize(2, 18.0f);
            linearLayout.addView(this.txtSolution);
            TextView textView3 = new TextView(context);
            textView3.setLayoutParams(layoutParams);
            textView3.setTextSize(2, 16.0f);
            textView3.setText("StarryNet Version:" + StErrorTips.versionName + ",\n发生时间：" + formatter.format(new Date()));
            linearLayout.addView(textView3);
            setView(linearLayout);
        }

        public float dp2px(float f) {
            return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
        }

        public void setDetail(String str, String str2, String str3) {
            setTitle("警告:" + str);
            TextView textView = this.txtDesc;
            textView.setText("产生的问题：\n\t\t\t" + str2);
            TextView textView2 = this.txtSolution;
            textView2.setText("建议措施：\n\t\t\t" + str3);
        }
    }

    public static void init(Context context) {
        appContext = context;
        try {
            versionName = context.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "package name not found: " + appContext.getPackageName());
            versionName = "none";
        }
        tipsDialog = new TipsDialog(context);
    }

    private static boolean isErrorTipsOpened() {
        Context context = appContext;
        if (context != null) {
            return Settings.Global.getInt(context.getContentResolver(), STARRY_NET_SETTING_ERROR_TIPS_PROPERTY, 0) == 1;
        }
        Log.w(TAG, "app context not init");
        return false;
    }

    public static boolean showErrorTips(ErrorTips errorTips) {
        if (!isErrorTipsOpened()) {
            Log.w(TAG, "error tips not open");
            return false;
        }
        TipsDialog tipsDialog2 = tipsDialog;
        if (tipsDialog2 == null) {
            return false;
        }
        tipsDialog2.setDetail(errorTips.getTitle(), errorTips.getDesc(), errorTips.getSolution());
        tipsDialog.getWindow().setType(2038);
        tipsDialog.show();
        return true;
    }
}
