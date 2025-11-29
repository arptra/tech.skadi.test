package com.xjsd.ai.assistant.common.stks;

import android.text.TextUtils;
import com.honey.account.ba.a;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfflineKeyManagerForSpring {

    /* renamed from: a  reason: collision with root package name */
    public List f8440a;
    public final Map b;
    public final List c;

    public static final class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final OfflineKeyManagerForSpring f8441a = new OfflineKeyManagerForSpring();
    }

    public static OfflineKeyManagerForSpring a() {
        return Holder.f8441a;
    }

    public OfflineKey b(String str) {
        Class<OfflineKey> cls;
        Map.Entry entry;
        Matcher matcher;
        Iterator it = this.b.entrySet().iterator();
        do {
            cls = OfflineKey.class;
            if (it.hasNext()) {
                entry = (Map.Entry) it.next();
                matcher = ((Pattern) entry.getKey()).matcher(str);
            } else {
                for (OfflineKey offlineKey : this.f8440a) {
                    if (offlineKey.getText().equals(str)) {
                        OfflineKey offlineKey2 = (OfflineKey) JsonUtil.a(JsonUtil.c(offlineKey), cls);
                        ILog.a("OfflineKeyManagerForSpring", "离线指令词匹配2->" + GsonUtils.e(offlineKey2));
                        return offlineKey2;
                    }
                }
                return null;
            }
        } while (!matcher.find());
        String group = matcher.group(1);
        int indexOf = this.c.indexOf(group);
        if (indexOf >= 0) {
            group = String.valueOf(indexOf + 1);
        }
        OfflineKey offlineKey3 = (OfflineKey) JsonUtil.a(JsonUtil.c((OfflineKey) this.f8440a.get(((Integer) entry.getValue()).intValue())), cls);
        offlineKey3.setText(str);
        offlineKey3.getData().setNumber(group);
        ILog.a("OfflineKeyManagerForSpring", "离线指令词匹配1->" + GsonUtils.e(offlineKey3));
        return offlineKey3;
    }

    public OfflineKeyManagerForSpring() {
        BufferedReader bufferedReader;
        this.b = new HashMap();
        this.c = Arrays.asList(new String[]{"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"});
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(OfflineKeyManagerForSpring.class.getResourceAsStream("/offlineCmd.json")));
            bufferedReader.lines().forEach(new a(sb));
            bufferedReader.close();
        } catch (IOException e) {
            ILog.h("OfflineKeyManagerForSpring", "捕获异常", e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        this.f8440a = GsonUtils.b(sb.toString(), OfflineKey.class);
        for (int i = 0; i < this.f8440a.size(); i++) {
            OfflineKey offlineKey = (OfflineKey) this.f8440a.get(i);
            if (offlineKey.getText().startsWith("^")) {
                this.b.put(Pattern.compile(offlineKey.getText()), Integer.valueOf(i));
            }
            String c2 = IntentFuncManager.b.c(offlineKey.getData().getIntent());
            if (!TextUtils.isEmpty(c2)) {
                offlineKey.getData().setFunc(c2);
            }
        }
        return;
        throw th;
    }
}
