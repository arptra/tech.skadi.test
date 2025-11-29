package com.xjsd.ai.assistant.cache;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;

public class CacheComponent extends Component {
    public void a(Application application) {
        new CacheAbilityImpl(application).register();
    }

    public String c() {
        return "CacheComponent";
    }
}
