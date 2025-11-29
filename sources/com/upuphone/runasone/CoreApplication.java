package com.upuphone.runasone;

import android.content.Context;
import android.content.IntentFilter;
import com.google.auto.service.AutoService;
import com.honey.account.n5.a;
import com.honey.account.n5.b;
import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.BluetoothUtils;
import com.upuphone.runasone.broadcast.WlanStateReceiver;
import com.upuphone.runasone.channel.proxy.ProxyManager;
import com.upuphone.runasone.core.api.ApiConstant;
import com.upuphone.runasone.host.api.BaseAbility;
import com.upuphone.runasone.host.api.BaseComponent;
import com.upuphone.runasone.host.api.CoreInitApplication;
import com.upuphone.runasone.host.api.IAbility;
import com.upuphone.runasone.host.api.InitApplication;
import com.upuphone.runasone.host.api.InitCallback;
import com.upuphone.runasone.host.core.api.Ability;
import com.upuphone.runasone.host.core.api.Component;
import com.upuphone.runasone.host.core.api.DataManager;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.lifecycle.manager.LifecycleManager;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.runasone.utils.log.LogManager;
import com.upuphone.starrynet.api.StErrorTips;
import java.util.ArrayList;
import java.util.Map;

@AutoService({InitApplication.class})
public class CoreApplication implements CoreInitApplication {
    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$initHighPriority$1(InitCallback initCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Ability(ApiConstant.ABILITY_DEVICES, new CoreAbility(), (EnumLinkStrategy) null));
        if (StarrynetApiImpl.getInstance().getOwnDevice().getTerminalType() == 3) {
            arrayList.add(new Ability(ApiConstant.ABILITY_BLE, new BleAbility(), (EnumLinkStrategy) null));
        }
        arrayList.add(new Ability("systemApi", new SystemApiAbility(), (EnumLinkStrategy) null));
        arrayList.add(new Ability(ApiConstant.ABILITY_LIFECYCLE, new LifecycleAbility(), EnumLinkStrategy.STRATEGY_DEFAULT));
        initCallback.onComplete(new Component(ApiConstant.COMPONENT, arrayList));
    }

    public void initComponents(Map<String, BaseComponent> map) {
        LogUtil.d("components : " + map);
        for (Map.Entry<String, BaseComponent> value : map.entrySet()) {
            for (BaseAbility baseAbility : ((Component) value.getValue()).getAbilities()) {
                IAbility iAbility = baseAbility.getIAbility();
                if (iAbility instanceof IAbilitySlot) {
                    Ability ability = (Ability) baseAbility;
                    ability.setComponentCallback(new b(baseAbility));
                    AbilityRouterImpl.getInstance().attachAbility(EnumAbility.parse(baseAbility.getName()), (IAbilitySlot) iAbility, ability.getLinkStrategy(), ability.getProp());
                }
            }
        }
    }

    public void initHighPriority(Context context, InitCallback initCallback) {
        LogManager.init(context, Integer.MIN_VALUE);
        BluetoothUtils.setContext(context);
        StErrorTips.init(context);
        StarrynetApiImpl.init(context, new a(initCallback));
        LifecycleManager.getInstance().setContext(context);
        Utils.initContext(context);
        DataManager.getInstance().setOwnDevice(Utils.convert(StarrynetApiImpl.getInstance().getOwnDevice()));
        LogManager.setIs3rdDevice(StarrynetApiImpl.getInstance().getOwnDevice().getTerminalType() == 4);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        context.registerReceiver(new WlanStateReceiver(), intentFilter);
        ProxyManager.getInstance().init();
    }

    public void initLowPriority(Context context) {
    }
}
