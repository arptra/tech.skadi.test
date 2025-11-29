package com.xjsd.ai.assistant.connect;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;

public class InterconnectComponent extends Component {
    public void a(Application application) {
        new InterconnectAbilityImpl().register();
    }

    public String c() {
        return "InterconnectComponent";
    }
}
