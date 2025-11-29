package com.upuphone.runasone.share.lib.application;

import android.content.Context;
import com.google.auto.service.AutoService;
import com.upuphone.runasone.host.api.InitApplication;
import com.upuphone.runasone.host.api.InitCallback;
import com.upuphone.runasone.host.core.api.Ability;
import com.upuphone.runasone.host.core.api.Component;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.share.api.ApiConstant;
import com.upuphone.runasone.share.lib.UupShare;
import java.util.ArrayList;

@AutoService({InitApplication.class})
public class ShareApplication implements InitApplication {
    public void initHighPriority(Context context, InitCallback initCallback) {
        UupShare.getInstance().install(context);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Ability("abilityShare", UupShare.getInstance(), EnumLinkStrategy.STRATEGY_DEFAULT, (ComponentProperty) null));
        initCallback.onComplete(new Component(ApiConstant.COMPONENT, arrayList));
    }

    public void initLowPriority(Context context) {
    }
}
