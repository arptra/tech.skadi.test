package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.entity.StandbyWidgetOrderInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/StandbyPositionFragment$setStandbyWidgetOrder$2", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "p0", "", "p1", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StandbyPositionFragment$setStandbyWidgetOrder$2 extends SendMessageListener {
    final /* synthetic */ ArrayList<String> $currentWidgetList;
    final /* synthetic */ StandbyWidgetOrderInfo $standbyWidgetOrderInfo;
    final /* synthetic */ StandbyPositionFragment this$0;

    public StandbyPositionFragment$setStandbyWidgetOrder$2(StandbyPositionFragment standbyPositionFragment, ArrayList<String> arrayList, StandbyWidgetOrderInfo standbyWidgetOrderInfo) {
        this.this$0 = standbyPositionFragment;
        this.$currentWidgetList = arrayList;
        this.$standbyWidgetOrderInfo = standbyWidgetOrderInfo;
    }

    public void onFail(@Nullable String str, int i) {
        ULog.f6446a.g("StandbyPositionFragment", "sendStandbyWidgetOrder消息发送失败");
    }

    public void onSuccess(@Nullable String str) {
        this.this$0.o = this.$currentWidgetList;
        ULog.Delegate delegate = ULog.f6446a;
        StandbyWidgetOrderInfo standbyWidgetOrderInfo = this.$standbyWidgetOrderInfo;
        delegate.g("StandbyPositionFragment", "sendStandbyWidgetOrder消息发送成功 " + standbyWidgetOrderInfo);
        this.this$0.G1(this.$currentWidgetList);
        DataStoreUtils.e.a().p("standby_widget_order", GsonHelper.toJson(this.$standbyWidgetOrderInfo), true);
    }
}
