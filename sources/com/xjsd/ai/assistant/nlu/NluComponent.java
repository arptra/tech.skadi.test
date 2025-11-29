package com.xjsd.ai.assistant.nlu;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;

public class NluComponent extends Component {
    public void a(Application application) {
        new NluAbilityImpl().register();
    }

    public String c() {
        return "NluComponent";
    }
}
