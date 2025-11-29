package com.upuphone.runasone.relay.lib.application;

import android.content.Context;
import android.content.IntentFilter;
import com.google.auto.service.AutoService;
import com.google.gson.Gson;
import com.upuphone.runasone.host.api.InitApplication;
import com.upuphone.runasone.host.api.InitCallback;
import com.upuphone.runasone.host.core.api.Ability;
import com.upuphone.runasone.host.core.api.Component;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.relay.lib.RelayPort;
import com.upuphone.runasone.relay.lib.air.AirBean;
import com.upuphone.runasone.relay.lib.air.AirPort;
import com.upuphone.runasone.relay.lib.air.AirPortMessageManager;
import com.upuphone.runasone.relay.lib.bypass.RelayBypassPort;
import com.upuphone.runasone.relay.lib.device.MessageManager;
import com.upuphone.runasone.relay.lib.manager.AppConfigManager;
import com.upuphone.runasone.relay.lib.manager.PackageReceiver;
import com.upuphone.runasone.relay.lib.manager.RelayBean;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.runasone.relay.util.RelayConst;
import java.util.ArrayList;
import java.util.HashMap;

@AutoService({InitApplication.class})
public class RelayApplication implements InitApplication {
    private static String TAG = "RelayApplication";
    private static Ability airAbility;
    private static Ability relayAbility;

    private ComponentProperty getAirProperty() {
        ComponentProperty componentProperty = new ComponentProperty();
        componentProperty.setSupportTlv(true);
        componentProperty.setAgreementType(0);
        AirBean airBean = new AirBean();
        HashMap hashMap = new HashMap();
        hashMap.put(1, "com.upuphone.star.launcher");
        hashMap.put(2, "com.upuphone.thanos.sdk_test");
        airBean.setAirMapping(hashMap);
        componentProperty.setJson(new Gson().toJson((Object) airBean));
        return componentProperty;
    }

    private static ComponentProperty getProperty() {
        ComponentProperty componentProperty = new ComponentProperty();
        componentProperty.setSupportTlv(true);
        componentProperty.setAgreementType(0);
        RelayBean relayBean = new RelayBean();
        relayBean.setMetaInfo(AppConfigManager.getInstance().getAppUnitCodeList());
        relayBean.setMetaMap(AppConfigManager.getInstance().getMetaMap());
        componentProperty.setJson(new Gson().toJson((Object) relayBean));
        return componentProperty;
    }

    private void initPkgListener(Context context) {
        PackageReceiver packageReceiver = new PackageReceiver();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(packageReceiver, intentFilter);
    }

    public static void updateAirAbility() {
        Ability ability = relayAbility;
        if (ability != null && ability.getComponentCallback() != null) {
            relayAbility.getComponentCallback().onUpdate(getProperty());
        }
    }

    public static void updateRelayAbility() {
        Ability ability = relayAbility;
        if (ability != null && ability.getComponentCallback() != null) {
            relayAbility.getComponentCallback().onUpdate(getProperty());
        }
    }

    public void initHighPriority(Context context, InitCallback initCallback) {
        LogUtil.dPrimary(TAG, "---initHighPriority");
        LogUtil.init(context);
        AirPortMessageManager.Companion.getSIntance().initCtx(context);
        MessageManager.getInstance().install(context);
        AppConfigManager.getInstance().getAllMetaData(context);
        ArrayList arrayList = new ArrayList();
        RelayPort instance = RelayPort.getInstance();
        EnumLinkStrategy enumLinkStrategy = EnumLinkStrategy.STRATEGY_DEFAULT;
        Ability ability = new Ability("abilityRelay", instance, enumLinkStrategy, getProperty());
        relayAbility = ability;
        arrayList.add(ability);
        arrayList.add(new Ability("abilityRelayBypass", RelayBypassPort.Companion.getSIntance(), EnumLinkStrategy.STRATEGY_SIMPLIFIED));
        Ability ability2 = new Ability("abilityAir", AirPort.Companion.getSIntance(), enumLinkStrategy, getAirProperty());
        airAbility = ability2;
        arrayList.add(ability2);
        initCallback.onComplete(new Component(RelayConst.RELAY_COMP, arrayList));
        initPkgListener(context);
    }

    public void initLowPriority(Context context) {
        LogUtil.dPrimary(TAG, "---initLowPriority");
    }
}
