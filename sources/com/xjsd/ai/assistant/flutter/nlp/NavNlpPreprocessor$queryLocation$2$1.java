package com.xjsd.ai.assistant.flutter.nlp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.stks.ContextHelper;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$queryLocation$2$1", "Lcom/upuphone/xr/interconnect/listener/NaviLocationCallback;", "onLocationChanged", "", "locationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavNlpPreprocessor$queryLocation$2$1 extends NaviLocationCallback {
    final /* synthetic */ CancellableContinuation<String> $it;

    public NavNlpPreprocessor$queryLocation$2$1(CancellableContinuation<? super String> cancellableContinuation) {
        this.$it = cancellableContinuation;
    }

    public void onLocationChanged(@Nullable NaviLocationInfo naviLocationInfo) {
        String str;
        String jSONString = JSON.toJSONString(naviLocationInfo);
        ILog.j("NavNlpPreprocessor", "LocationInfo->" + jSONString);
        if (naviLocationInfo == null || TextUtils.isEmpty(naviLocationInfo.getAddress())) {
            str = ContextHelper.f8704a.a(R.string.tts_query_location_failed);
            Intrinsics.checkNotNull(str);
        } else {
            str = TtsNaviTemplate.NAVI06_P01.getTts(naviLocationInfo.getAddress());
        }
        SuperAppAbilityManager.e().f().stopLocation(this);
        this.$it.resumeWith(Result.m20constructorimpl(str));
    }
}
