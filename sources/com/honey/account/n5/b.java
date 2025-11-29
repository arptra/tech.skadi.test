package com.honey.account.n5;

import com.upuphone.runasone.ability.AbilityRouterImpl;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.host.api.BaseAbility;
import com.upuphone.runasone.host.core.api.Ability;
import com.upuphone.runasone.host.core.api.ComponentProperty;

public final /* synthetic */ class b implements Ability.ComponentCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseAbility f4964a;

    public /* synthetic */ b(BaseAbility baseAbility) {
        this.f4964a = baseAbility;
    }

    public final void onUpdate(ComponentProperty componentProperty) {
        AbilityRouterImpl.getInstance().updateAbility(EnumAbility.parse(this.f4964a.getName()), componentProperty);
    }
}
