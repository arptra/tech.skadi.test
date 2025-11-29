package com.xjsd.ai.assistant.nlg;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;
import com.xjsd.ai.assistant.log.ILog;
import java.io.IOException;

public class NlgComponent extends Component {
    public void a(Application application) {
        try {
            NlgTemplateFileUtil.a(application);
        } catch (IOException e) {
            ILog.h("NlgComponent", "拷贝模版文件出错", e);
        }
        new NlgAbilityImpl().register();
    }

    public String c() {
        return "NlgComponent";
    }
}
