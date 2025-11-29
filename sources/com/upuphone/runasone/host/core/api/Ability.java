package com.upuphone.runasone.host.core.api;

import com.upuphone.runasone.host.api.BaseAbility;
import com.upuphone.runasone.host.api.IAbility;

public class Ability extends BaseAbility {
    private ComponentCallback componentCallback;
    private EnumLinkStrategy linkStrategy;
    private ComponentProperty prop;

    public interface ComponentCallback {
        void onUpdate(ComponentProperty componentProperty);
    }

    public Ability(String str, IAbility iAbility, EnumLinkStrategy enumLinkStrategy) {
        super(str, iAbility);
        this.linkStrategy = enumLinkStrategy;
    }

    public ComponentCallback getComponentCallback() {
        return this.componentCallback;
    }

    public EnumLinkStrategy getLinkStrategy() {
        return this.linkStrategy;
    }

    public ComponentProperty getProp() {
        return this.prop;
    }

    public void setComponentCallback(ComponentCallback componentCallback2) {
        this.componentCallback = componentCallback2;
    }

    public Ability(String str, IAbility iAbility, EnumLinkStrategy enumLinkStrategy, ComponentProperty componentProperty) {
        super(str, iAbility);
        this.linkStrategy = enumLinkStrategy;
        this.prop = componentProperty;
    }
}
