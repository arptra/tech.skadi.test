package com.xjsd.ai.assistant.skill.navigation;

import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.nav.NavBusinessData;
import com.xjsd.ai.assistant.protocol.nav.NaviListData;
import com.xjsd.ai.assistant.protocol.nav.TypedPoiResult;
import com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/NavigationBusinessHandler;", "Lcom/xjsd/ai/assistant/common/handler/BusinessHandler;", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/nav/NavBusinessData;", "data", "", "onReceiveNavBusinessData", "(Lcom/xjsd/ai/assistant/protocol/nav/NavBusinessData;)V", "Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "getHandleType", "()Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "Lcom/xjsd/ai/assistant/protocol/BusinessData;", "businessData", "a", "(Lcom/xjsd/ai/assistant/protocol/BusinessData;)V", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NavigationBusinessHandler implements BusinessHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8685a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/navigation/NavigationBusinessHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public NavigationBusinessHandler() {
        EventBus.c().o(this);
    }

    public void a(BusinessData businessData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        NavBusinessData navBusinessData = (NavBusinessData) businessData.parseData(NavBusinessData.class);
        String e = GsonUtils.e(navBusinessData);
        ILog.a("NavigationBusinessHandler", "收到navigation业务数据->" + e);
        Intrinsics.checkNotNull(navBusinessData);
        b(navBusinessData);
    }

    public final void b(NavBusinessData navBusinessData) {
        int type = navBusinessData.getType();
        if (type == 0) {
            NavManager.j().p((TypedPoiResult) navBusinessData.parse(TypedPoiResult.class));
        } else if (type == 1) {
            NavManager.j().i();
        } else if (type == 2) {
            CustomizedNavManager.c().a();
            NaviListData naviListData = (NaviListData) navBusinessData.parse(NaviListData.class);
            NavHelper.a(naviListData.getPoiResults(), naviListData.getCurrentPage());
        } else if (type != 3) {
            UnSupportFeatureManager.f8414a.c();
        } else {
            boolean areEqual = Intrinsics.areEqual((Object) (String) navBusinessData.parse(String.class), (Object) "TurnOff");
            NaviAbilityOperator f = SuperAppAbilityManager.e().f();
            if (f.isNaving()) {
                f.setNaviSpeak(areEqual);
                new PhoneTtsPlayBuilder().e(areEqual ? TtsNaviTemplate.NAVI17_P02 : TtsNaviTemplate.NAVI17_P01).a().c();
                return;
            }
            new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI17_P03).a().c();
        }
    }

    public BusinessDataType getHandleType() {
        return BusinessDataType.NAVIGATE;
    }

    @Subscribe
    public final void onReceiveNavBusinessData(@NotNull NavBusinessData navBusinessData) {
        Intrinsics.checkNotNullParameter(navBusinessData, "data");
        b(navBusinessData);
    }
}
