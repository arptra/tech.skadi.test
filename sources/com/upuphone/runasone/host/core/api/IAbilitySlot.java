package com.upuphone.runasone.host.core.api;

import android.os.Bundle;
import androidx.core.util.Consumer;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.api.IAbility;

public interface IAbilitySlot extends IAbility {

    public interface SlotObserver {
        int commonFun(int i, Bundle bundle, Consumer<Object> consumer);

        void onError(StarryDevice starryDevice, int i);

        int output(StarryDevice starryDevice, AbilityMessage abilityMessage);
    }

    void attach(StarryDevice starryDevice, SlotObserver slotObserver, ComponentProperty componentProperty);

    void attach(StarryDevice starryDevice, SlotObserver slotObserver, ComponentProperty componentProperty, IStarryNetStackCallback iStarryNetStackCallback) {
    }

    void detach(StarryDevice starryDevice);

    void input(StarryDevice starryDevice, AbilityMessage abilityMessage);
}
