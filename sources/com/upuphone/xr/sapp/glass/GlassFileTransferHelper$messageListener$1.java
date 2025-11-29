package com.upuphone.xr.sapp.glass;

import com.honey.account.view.web.WebJs;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/glass/GlassFileTransferHelper$messageListener$1", "Lcom/upuphone/xr/sapp/glass/TwinActionMessageListener;", "", "action", "subAction", "data", "", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassFileTransferHelper$messageListener$1 implements TwinActionMessageListener {
    public void a(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassFileTransferHelper", "onMessageReceive: action: " + str + ", subAction: " + str2 + ", data: " + str3);
        if (str3 != null) {
            try {
                String string = new JSONObject(str3).getString("taskId");
                Intrinsics.checkNotNull(string);
                if (string.length() > 0) {
                    GlassFileTransferHelper.b.add(string);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
