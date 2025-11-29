package com.upuphone.xr.sapp.guide.connectui;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.guide.model.ConnectResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/guide/model/ConnectResult;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AddGlassFragment$searchGlass$2 extends Lambda implements Function1<ConnectResult, Unit> {
    final /* synthetic */ AddGlassFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddGlassFragment$searchGlass$2(AddGlassFragment addGlassFragment) {
        super(1);
        this.this$0 = addGlassFragment;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(AddGlassFragment addGlassFragment, ConnectResult connectResult) {
        Intrinsics.checkNotNullParameter(addGlassFragment, "this$0");
        Intrinsics.checkNotNullParameter(connectResult, "$it");
        addGlassFragment.X1(connectResult);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConnectResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ConnectResult connectResult) {
        if (connectResult != null) {
            AddGlassFragment addGlassFragment = this.this$0;
            ULog.Delegate delegate = ULog.f6446a;
            StarryNetDevice N0 = addGlassFragment.m;
            String str = null;
            String deviceId = N0 != null ? N0.getDeviceId() : null;
            delegate.o("AddGlassFragment", "mDeviceConnectFail observe it = " + connectResult + ",mCurStarryNetDevice deviceId = " + deviceId);
            String mDeviceID = connectResult.getMDeviceID();
            StarryNetDevice N02 = addGlassFragment.m;
            if (N02 != null) {
                str = N02.getDeviceId();
            }
            if (Intrinsics.areEqual((Object) mDeviceID, (Object) str) && connectResult.getMErrorCode() != 112000) {
                int mErrorCode = connectResult.getMErrorCode();
                MainApplication.Companion companion = MainApplication.k;
                boolean g = companion.g();
                boolean M0 = addGlassFragment.u;
                delegate.a("AddGlassFragment", "code is: " + mErrorCode + " and mConnectFail is: " + g + " and mConnectOK is: " + M0);
                if (!companion.g() && !addGlassFragment.u && addGlassFragment.r) {
                    companion.o(true);
                    addGlassFragment.l.postDelayed(new a(addGlassFragment, connectResult), 1000);
                }
            }
        }
    }
}
