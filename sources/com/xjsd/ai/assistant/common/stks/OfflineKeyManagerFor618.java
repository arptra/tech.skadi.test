package com.xjsd.ai.assistant.common.stks;

import com.honey.account.ba.a;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OfflineKeyManagerFor618 {

    /* renamed from: a  reason: collision with root package name */
    public Map f8438a;

    public static final class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final OfflineKeyManagerFor618 f8439a = new OfflineKeyManagerFor618();
    }

    public static OfflineKeyManagerFor618 a() {
        return Holder.f8439a;
    }

    public OfflineKey b(String str) {
        OfflineKey offlineKey = (OfflineKey) this.f8438a.get(str);
        ILog.a("OfflineKeyManagerFor618", "searchOfflineKey: 离线指令词->" + str + "，匹配结果->" + GsonUtils.e(offlineKey));
        return offlineKey;
    }

    public OfflineKeyManagerFor618() {
        BufferedReader bufferedReader;
        this.f8438a = new HashMap();
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(OfflineKeyManagerFor618.class.getResourceAsStream("/offlineCmdPlus.json")));
            bufferedReader.lines().forEach(new a(sb));
            bufferedReader.close();
        } catch (IOException e) {
            ILog.h("OfflineKeyManagerFor618", "捕获异常", e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        for (OfflineKey offlineKey : GsonUtils.b(sb.toString(), OfflineKey.class)) {
            offlineKey.getData().setFunc(IntentFuncManager.b.c(offlineKey.getData().getIntent()));
            this.f8438a.put(offlineKey.getText(), offlineKey);
        }
        return;
        throw th;
    }
}
