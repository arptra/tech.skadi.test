package com.xjsd.ai.assistant.skill.call;

import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashSet;
import java.util.Set;

public class PhoneCallVuiHandler implements VuiHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Set f8672a;
    public final Set b;
    public final PhoneCallDelegate c = new PhoneCallDelegate();

    public PhoneCallVuiHandler() {
        HashSet hashSet = new HashSet();
        this.f8672a = hashSet;
        HashSet hashSet2 = new HashSet();
        this.b = hashSet2;
        hashSet.add("SwitchPage");
        hashSet.add("Select");
        hashSet.add("PhoneDirective");
        hashSet.add("Cancel");
        hashSet2.add("Dial");
        hashSet2.add("DialNumber");
        hashSet2.add("DialYellowPage");
        hashSet2.add("DialContact");
        hashSet2.add("DialRelative");
    }

    public boolean a(VuiModel vuiModel) {
        String name = vuiModel.getHeader().getName();
        if (this.f8672a.contains(name)) {
            return false;
        }
        if (this.b.contains(name)) {
            return this.c.h(vuiModel);
        }
        UnSupportFeatureManager.f8414a.c();
        return true;
    }

    public String getHandleType() {
        return VuiModelType.PHONE;
    }
}
