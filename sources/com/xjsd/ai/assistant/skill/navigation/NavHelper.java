package com.xjsd.ai.assistant.skill.navigation;

import android.text.TextUtils;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluContextDataMaintainer;
import com.xjsd.ai.assistant.nlu.bean.ContextData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.nav.NavBusinessData;
import io.flutter.plugin.editing.SpellCheckPlugin;
import java.util.HashMap;
import java.util.List;

public class NavHelper {
    public static void a(List list, int i) {
        if (list == null || list.isEmpty()) {
            b();
            return;
        }
        ContextData contextData = new ContextData(VuiModelType.NAVIGATION, "poiList");
        NluContextDataMaintainer.f8512a.a("navPoiList", contextData.appendPayload("pageId", "pageid00" + i).appendPayload(SpellCheckPlugin.START_INDEX_KEY, 1).appendPayload("type", "default").appendPayload(SpellCheckPlugin.END_INDEX_KEY, Integer.valueOf(list.size())).appendPayload("list", list));
        d(list, (String) ((CacheAbility) AbilityManager.b.b(CacheAbility.class)).getCacheWithDefault("traceId", ""));
    }

    public static void b() {
        NluContextDataMaintainer.f8512a.d("navPoiList");
    }

    public static void c(int i, Object obj) {
        NavBusinessData navBusinessData = new NavBusinessData(i);
        navBusinessData.setPayload(obj);
        Communicator.a(BusinessDataType.NAVIGATE, navBusinessData, new SendMsgCallback() {
            public void onFail(int i, String str) {
                ILog.a("NavHelper", "发送导航业务数据失败->" + str);
            }

            public void onSuccess() {
                ILog.a("NavHelper", "发送导航业务数据成功");
            }
        });
    }

    public static void d(List list, String str) {
        String c = JsonUtil.c(list);
        if (c != null && !TextUtils.isEmpty(c)) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "1");
            hashMap.put("resource_content", c);
            hashMap.put("session_id", str);
            SdkContext.f6675a.d().reportEvent("CP", hashMap);
        }
    }
}
