package com.xjsd.ai.assistant.asr;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;

public class AsrComponent extends Component {
    public void a(Application application) {
        AsrAbilityImpl asrAbilityImpl = new AsrAbilityImpl();
        asrAbilityImpl.init(application);
        asrAbilityImpl.register();
    }

    public String c() {
        return "AsrComponent";
    }
}
