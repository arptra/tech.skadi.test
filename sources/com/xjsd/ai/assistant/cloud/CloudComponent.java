package com.xjsd.ai.assistant.cloud;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;

public class CloudComponent extends Component {
    public void a(Application application) {
        CloudAbilityImpl cloudAbilityImpl = new CloudAbilityImpl();
        cloudAbilityImpl.init(application);
        cloudAbilityImpl.register();
    }

    public String c() {
        return "CloudComponent";
    }
}
