package com.xjsd.ai.assistant.skill.navigation;

import android.os.RemoteException;
import com.alibaba.fastjson.JSON;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.NaviActionResult;
import com.upuphone.xr.interconnect.listener.NaviPoiCallback;
import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.phone.helper.VrStateHelper;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.nav.TypedPoiResult;
import com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager;
import com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode;
import com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer;
import com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer;
import com.xjsd.ai.assistant.template.TtsAppTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.List;

public class NavManager {
    public static final NavManager h = new NavManager();

    /* renamed from: a  reason: collision with root package name */
    public final NavConfig f8682a = new NavConfig(NavTravelMode.DEFAULT, NaviRoutePrefer.DEFAULT);
    public int b = 0;
    public final NaviActionResult c = new NaviActionResult() {
        public void actionFailure(String str, int i) {
            ILog.j("NavManager", "change navi mode failed, dest->" + str + ", code->" + i);
            if (!NavManager.this.s(i)) {
                if (i == 20) {
                    String modeName = NavManager.this.f8682a.d().getModeName();
                    if (modeName == null) {
                        modeName = "";
                    }
                    new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI08_P02).o(modeName).k("vehcileType", modeName).a().c();
                    return;
                }
                NavManager.this.x();
            }
        }

        public void actionSuceess(String str, int i) {
            ILog.j("NavManager", "change navi mode cuccess, dest->" + str + ", code->" + i);
            if (!NavManager.this.t(i)) {
                String modeName = NavManager.this.f8682a.d().getModeName();
                if (modeName == null) {
                    modeName = "";
                }
                new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI08_P01).o(modeName).k("vehcileType", modeName).a().c();
            }
        }
    };
    public final NaviActionResult d = new NaviActionResult() {
        public void actionFailure(String str, int i) {
            ILog.j("NavManager", "change route failed, dest->" + str + ", code->" + i);
            if (!NavManager.this.s(i)) {
                NavManager.this.x();
            }
        }

        public void actionSuceess(String str, int i) {
            ILog.j("NavManager", "change route success, dest->" + str + ", code->" + i);
            if (!NavManager.this.t(i)) {
                String b = ContextHelper.b(NavManager.this.f8682a.c().getNameRes(), new Object[0]);
                new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI09_P01).o(b).k("naviStrtegy", b).a().c();
            }
        }
    };
    public final NaviActionResult e = new NaviActionResult() {
        public void actionFailure(String str, int i) {
            ILog.j("NavManager", "navi to address failed, dest->" + str + ", code->" + i);
            if (!NavManager.this.s(i)) {
                NavManager.this.w(0, i);
            }
        }

        public void actionSuceess(String str, int i) {
            ILog.j("NavManager", "navi to address success, dest->" + str + ", code->" + i);
            DotUtil.b("vad_end", "发起导航成功耗时");
            if (!NavManager.this.t(i)) {
                ContinuousDialogDispatcher.c(true);
            }
        }
    };
    public final NaviActionResult f = new NaviActionResult() {
        public void actionFailure(String str, int i) {
            ILog.j("NavManager", "navi to home failed, dest->" + str + ", code->" + i);
            if (!NavManager.this.s(i)) {
                NavManager.this.w(1, i);
            }
        }

        public void actionSuceess(String str, int i) {
            ILog.j("NavManager", "navi to home success, dest->" + str + ", code->" + i);
            DotUtil.b("vad_end", "发起导航回家成功耗时");
            CustomizedNavManager.c().e();
            if (!NavManager.this.t(i)) {
                ContinuousDialogDispatcher.c(true);
            }
        }
    };
    public final NaviActionResult g = new NaviActionResult() {
        public void actionFailure(String str, int i) {
            ILog.j("NavManager", "navi to office failed, dest->" + str + ", code->" + i);
            if (!NavManager.this.s(i)) {
                NavManager.this.w(2, i);
            }
        }

        public void actionSuceess(String str, int i) {
            ILog.j("NavManager", "navi to home success, dest->" + str + ", code->" + i);
            DotUtil.b("vad_end", "发起导航去公司成功耗时");
            CustomizedNavManager.c().e();
            if (!NavManager.this.t(i)) {
                ContinuousDialogDispatcher.c(true);
            }
        }
    };

    public static class NavConfig {

        /* renamed from: a  reason: collision with root package name */
        public NavTravelMode f8683a;
        public NaviRoutePrefer b;

        public NavConfig(NavTravelMode navTravelMode, NaviRoutePrefer naviRoutePrefer) {
            this.f8683a = navTravelMode;
            this.b = naviRoutePrefer;
        }

        public NaviRoutePrefer c() {
            return this.b;
        }

        public NavTravelMode d() {
            return this.f8683a;
        }

        public final void e(NaviRoutePrefer naviRoutePrefer) {
            this.b = naviRoutePrefer;
        }

        public final void f(NavTravelMode navTravelMode) {
            this.f8683a = navTravelMode;
        }
    }

    public static NavManager j() {
        return h;
    }

    public void A(String str) {
        ILog.j("NavManager", "setRouteType: target type->" + str);
        this.f8682a.e(NaviRoutePrefer.matchMode(str));
        NavTravelMode matchMode = NavTravelMode.matchMode(str);
        if (matchMode != NavTravelMode.DEFAULT) {
            this.f8682a.f(matchMode);
        }
    }

    public void g() {
        if (r()) {
            SuperAppAbilityManager.e().f().changeNavi(this.f8682a.d().getCode(), this.c);
        }
    }

    public void h() {
        if (r()) {
            NaviAbilityOperator f2 = SuperAppAbilityManager.e().f();
            NavConfig navConfig = this.f8682a;
            ILog.a("NavManager", "switch route->" + navConfig.c());
            f2.changeRoute(navConfig.c().getCode(), this.d);
        }
    }

    public void i() {
        SuperAppAbilityManager.SAppAbilityEnum sAppAbilityEnum = SuperAppAbilityManager.SAppAbilityEnum.NAVI;
        boolean h2 = SuperAppAbilityManager.e().h(sAppAbilityEnum);
        NaviAbilityOperator f2 = SuperAppAbilityManager.e().f();
        if (h2 || (f2 != null && f2.isNaving())) {
            SuperAppAbilityManager.e().d(sAppAbilityEnum);
            new PhoneTtsPlayBuilder().e(TtsAppTemplate.APP02_R01).a().c();
            return;
        }
        new PhoneTtsPlayBuilder().e(TtsAppTemplate.APP02_R02).a().c();
    }

    public String k(String str) {
        return "NAVI_HOME".equalsIgnoreCase(str) ? VoiceAssistantApi.isOversea ? "go home" : "回家" : "NAVI_OFFICE".equalsIgnoreCase(str) ? VoiceAssistantApi.isOversea ? "go to office" : "去公司" : "NAVI_OPEN".equalsIgnoreCase(str) ? VoiceAssistantApi.isOversea ? "start navigation" : "打开导航" : str;
    }

    public final NaviActionResult l(int i) {
        return i != 1 ? i != 2 ? this.e : this.g : this.f;
    }

    public void m() {
        NaviAbilityOperator f2 = SuperAppAbilityManager.e().f();
        if (f2.hasAddress(1)) {
            f2.startNaviToAddress(1, this.f);
            return;
        }
        this.b = 1;
        new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI04_P02).g(2).a().c();
    }

    public void n(boolean z) {
        new PhoneTtsPlayBuilder().e(q(z)).a().c();
    }

    public void o() {
        NaviAbilityOperator f2 = SuperAppAbilityManager.e().f();
        if (f2.hasAddress(2)) {
            f2.startNaviToAddress(2, this.g);
            return;
        }
        this.b = 2;
        new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI05_P02).g(2).a().c();
    }

    public void p(TypedPoiResult typedPoiResult) {
        ExitTimer.f8563a.d();
        int type = typedPoiResult.getType();
        ILog.a("NavManager", "save to address type->" + type + ", destSaveType->" + this.b);
        NaviAbilityOperator f2 = SuperAppAbilityManager.e().f();
        if (type != 0) {
            ILog.a("NavManager", "save to address status->" + f2.saveNaviAddress(typedPoiResult, type));
        } else {
            type = this.b;
            if (type != 0) {
                ILog.a("NavManager", "save to address status->" + f2.saveNaviAddress(typedPoiResult, type));
            } else {
                type = 0;
            }
        }
        this.b = 0;
        PoiResult poiResult = new PoiResult();
        poiResult.setName(typedPoiResult.getName());
        poiResult.setDistance(typedPoiResult.getDistance());
        poiResult.setAddress(typedPoiResult.getAddress());
        poiResult.setLatitude(typedPoiResult.getLatitude());
        poiResult.setLongitude(typedPoiResult.getLongitude());
        poiResult.setPoiId(typedPoiResult.getPoiId());
        ILog.j("NavManager", "开始导航, NaviMode->" + this.f8682a.d() + ", LineMode->" + this.f8682a.c() + ", PoiResult->" + GsonUtils.e(poiResult));
        DotUtil.b("vad_end", "发起导航耗时");
        NavOptimizer.f8690a.j(poiResult, this.f8682a);
        f2.startNavi(this.f8682a.d().getCode(), this.f8682a.c().getCode(), poiResult, l(type));
    }

    public TtsTemplate q(boolean z) {
        NaviAbilityOperator f2 = SuperAppAbilityManager.e().f();
        if (!f2.isNaving()) {
            return z ? TtsNaviTemplate.NAVI10_P04 : TtsNaviTemplate.NAVI10_P03;
        }
        boolean isTrafficEnabled = f2.isTrafficEnabled();
        ILog.a("NavManager", "navi real-time traffic is open->" + isTrafficEnabled);
        if (isTrafficEnabled != z) {
            f2.setTrafficEnabled(z);
        }
        return z ? TtsNaviTemplate.NAVI10_P01 : TtsNaviTemplate.NAVI10_P02;
    }

    public final boolean r() {
        if (this.f8682a.c() != NaviRoutePrefer.UN_SUPPORT) {
            return true;
        }
        new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI01_P09).a().c();
        return false;
    }

    public final boolean s(int i) {
        if (u()) {
            return true;
        }
        if (i != 100001) {
            return false;
        }
        ILog.a("NavManager", "isNavCallbackFailHandled: 特殊国家，不支持驾驶导航");
        UnSupportFeatureManager.f8414a.c();
        return true;
    }

    public final boolean t(int i) {
        if (u()) {
            return true;
        }
        if (i != 10001 && i != 10002 && i != 10003) {
            return false;
        }
        new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL02_R03).a().c();
        return true;
    }

    public final boolean u() {
        boolean a2 = VrStateHelper.f8567a.a();
        if (!a2) {
            ILog.a("NavManager", "语音助理已经退出");
        }
        return !a2;
    }

    public void v(final int i, String str) {
        SuperAppAbilityManager.e().f().poiSearch(0, str, new NaviPoiCallback() {
            public void poiCallback(List<PoiResult> list) throws RemoteException {
                if (!NavManager.this.u()) {
                    ILog.j("NavManager", "search poi return->" + JSON.toJSONString(list));
                    if (list.size() == 1) {
                        NavManager.this.p(new TypedPoiResult(list.get(0), i));
                    } else {
                        NavHelper.c(0, list);
                    }
                }
            }
        });
    }

    public final void w(int i, int i2) {
        if (i2 == 20) {
            new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI02_P06).a().c();
        } else if (i2 != 10004) {
            x();
        } else {
            new PhoneTtsPlayBuilder().e(i == 1 ? TtsNaviTemplate.NAVI21_P01 : i == 2 ? TtsNaviTemplate.NAVI21_P02 : TtsNaviTemplate.NAVI21_P03).a().c();
        }
    }

    public final void x() {
        new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI21_P05).a().c();
    }

    public void y(String str) {
        ILog.a("NavManager", "reset destSaveType " + this.b);
        if ("回家".equalsIgnoreCase(str) || "NAVI_HOME".equalsIgnoreCase(str)) {
            this.b = 1;
        } else if ("去公司".equalsIgnoreCase(str) || "NAVI_OFFICE".equalsIgnoreCase(str)) {
            this.b = 2;
        } else {
            this.b = 0;
        }
        this.f8682a.f(NavTravelMode.DEFAULT);
        this.f8682a.e(NaviRoutePrefer.DEFAULT);
    }

    public void z(String str) {
        ILog.j("NavManager", "setDriverType: target type->" + str);
        this.f8682a.f(NavTravelMode.matchMode(str));
    }
}
