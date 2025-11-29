package com.xjsd.ai.assistant.phone.vui.translate;

import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;

public class TranslateManager {

    /* renamed from: a  reason: collision with root package name */
    public static final TranslateManager f8659a = new TranslateManager();

    public static int a(String str) {
        if ("dt".equalsIgnoreCase(str)) {
            return 2;
        }
        return "pt".equalsIgnoreCase(str) ? 1 : 3;
    }

    public static boolean b() {
        int transCurrentState = SuperAppAbilityManager.e().g().getTransCurrentState();
        ILog.a("TranslateManager", "isInDtState: 是否正在翻译->" + transCurrentState);
        return transCurrentState == 1;
    }

    public static boolean c() {
        int transCurrentState = SuperAppAbilityManager.e().g().getTransCurrentState();
        ILog.a("TranslateManager", "isInPtState: 是否正在转写->" + transCurrentState);
        return transCurrentState == 2;
    }

    public static boolean d(boolean z, String str, String str2, String str3) {
        return SuperAppAbilityManager.e().g().isSupportLanguage(z, a(str), str2, str3);
    }

    public static boolean e(String str) {
        int a2 = a(str);
        if (a2 == 2) {
            return b();
        }
        if (a2 == 1) {
            return c();
        }
        return false;
    }

    public static boolean f(String str) {
        return "dt".equalsIgnoreCase(str);
    }

    public static int g(String str) {
        return SuperAppAbilityManager.e().g().startTranslation(a(str));
    }

    public static void h(String str) {
        SuperAppAbilityManager.e().g().stopTranslation(a(str));
    }

    public static int i(String str, String str2, String str3) {
        return SuperAppAbilityManager.e().g().switchLang(DeviceUtils.d(), a(str), str2, str3);
    }
}
