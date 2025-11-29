package com.xjsd.ai.assistant.phone.vad;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;

public class VadComponent extends Component {
    public void a(Application application) {
        VadDetector vadDetector = new VadDetector();
        vadDetector.init(application);
        vadDetector.register();
    }

    public String c() {
        return "VadComponent";
    }
}
