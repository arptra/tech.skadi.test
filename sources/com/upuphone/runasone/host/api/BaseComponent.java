package com.upuphone.runasone.host.api;

import java.util.ArrayList;
import java.util.List;

public class BaseComponent {
    private final List<? extends BaseAbility> abilities;
    private final String name;

    public BaseComponent(String str, List<? extends BaseAbility> list) {
        this.name = str;
        this.abilities = list;
    }

    public List<? extends BaseAbility> getAbilities() {
        return this.abilities;
    }

    public List<String> getAbilityNames() {
        ArrayList arrayList = new ArrayList();
        for (BaseAbility name2 : this.abilities) {
            arrayList.add(name2.getName());
        }
        return arrayList;
    }

    public String getName() {
        return this.name;
    }
}
