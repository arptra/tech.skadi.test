package com.xjsd.ai.assistant.common.stks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.ba.a;
import com.honey.account.ba.b;
import com.honey.account.ba.c;
import com.xjsd.ai.assistant.log.ILog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntentFuncManager {
    public static final IntentFuncManager b = new IntentFuncManager();

    /* renamed from: a  reason: collision with root package name */
    public final Map f8434a;

    public IntentFuncManager() {
        BufferedReader bufferedReader;
        HashMap hashMap = new HashMap();
        this.f8434a = hashMap;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/funcIntent.json")));
            bufferedReader.lines().forEach(new a(sb));
            bufferedReader.close();
            f(sb.toString()).forEach(new b(this));
            ILog.a("HotWordManager", "处理funcIntent.json成功->" + hashMap);
            return;
        } catch (IOException e) {
            ILog.h("HotWordManager", "处理funcIntent.json出错", e);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String c(String str) {
        return (String) this.f8434a.get(str);
    }

    public final /* synthetic */ void d(String str, String str2) {
        this.f8434a.put(str2, str);
    }

    public final /* synthetic */ void e(String str, List list) {
        list.forEach(new c(this, str));
    }

    public final Map f(String str) {
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, List<String>>>() {
        }.getType());
    }
}
