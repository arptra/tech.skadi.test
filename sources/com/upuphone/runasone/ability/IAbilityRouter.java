package com.upuphone.runasone.ability;

import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import java.util.List;
import java.util.Map;

public interface IAbilityRouter {
    void attachAbility(EnumAbility enumAbility, IAbilitySlot iAbilitySlot, EnumLinkStrategy enumLinkStrategy, ComponentProperty componentProperty);

    boolean bindChannel(IChannel iChannel, EnumLinkStrategy enumLinkStrategy);

    void detachAbility(EnumAbility enumAbility);

    Map<String, String> getLocalAbilityAttr();

    List<String> getLocalAbilityList();

    void unbindChannel(IChannel iChannel, EnumLinkStrategy enumLinkStrategy);
}
