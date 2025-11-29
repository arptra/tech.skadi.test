package com.xjsd.ai.assistant.common.manager;

import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.common.handler.VuiInterceptor;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VuiHandlerManager {
    public static final VuiHandlerManager d = new VuiHandlerManager();
    public static final ThreadLocal e = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final Map f8433a = new HashMap();
    public final List b = new ArrayList();
    public String c;

    public VuiHandlerManager a(VuiHandler vuiHandler) {
        ILog.a("VuiHandlerManager", "注册领域处理器，对应类型->" + vuiHandler.getHandleType());
        this.f8433a.put(vuiHandler.getHandleType(), vuiHandler);
        return this;
    }

    public VuiHandlerManager b(VuiInterceptor vuiInterceptor) {
        ILog.a("VuiHandlerManager", "注册拦截器，标识符->" + vuiInterceptor.getIdentifier());
        this.b.add(vuiInterceptor);
        return this;
    }

    public boolean c(VuiModel vuiModel) {
        if (this.c == null) {
            return false;
        }
        ILog.a("VuiHandlerManager", "checkIsDomainCross: last domain->" + this.c);
        return !this.c.equals(vuiModel.getHeader().getNamespace());
    }

    public String d() {
        return this.c;
    }

    public boolean e(VuiModel vuiModel) {
        String namespace = vuiModel.getHeader().getNamespace();
        if ((!VuiModelType.VSP_ERROR.equals(namespace) || !"ASR_RESULT_IS_EMPTY".equals(vuiModel.getPayload().getString("type"))) && !vuiModel.getHeader().isSpecialCmdInChatGptScene()) {
            this.c = namespace;
        }
        VuiHandler vuiHandler = (VuiHandler) this.f8433a.get(namespace);
        boolean z = false;
        if (vuiHandler != null) {
            ThreadLocal threadLocal = e;
            threadLocal.set(vuiModel.getSessionId());
            try {
                z = vuiHandler.a(vuiModel);
                threadLocal.remove();
            } catch (Exception e2) {
                ILog.h("VuiHandlerManager", "垂域处理异常", e2);
                e.remove();
            } catch (Throwable th) {
                e.remove();
                throw th;
            }
            return z;
        }
        ILog.a("VuiHandlerManager", namespace + "对应垂域Handler不存在");
        return false;
    }

    public boolean f(VuiModel vuiModel) {
        for (VuiInterceptor vuiInterceptor : this.b) {
            if (vuiInterceptor.a(vuiModel)) {
                ILog.a("VuiHandlerManager", "垂域数据被拦截处理，拦截器->" + vuiInterceptor.getIdentifier());
                return true;
            }
        }
        return false;
    }

    public void g(String str) {
        this.c = str;
    }
}
