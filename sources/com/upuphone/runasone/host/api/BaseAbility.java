package com.upuphone.runasone.host.api;

public class BaseAbility {
    private final IAbility iAbility;
    private final String name;

    public BaseAbility(String str, IAbility iAbility2) {
        this.name = str;
        this.iAbility = iAbility2;
    }

    public IAbility getIAbility() {
        return this.iAbility;
    }

    public String getName() {
        return this.name;
    }
}
