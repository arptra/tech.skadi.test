package com.xjmz.myvu.modules.home;

import android.os.Bundle;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.UserGuideHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$checkUserGuide$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceType;
    final /* synthetic */ String $localKey;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$checkUserGuide$1(String str, HomeFragment homeFragment, String str2) {
        super(0);
        this.$localKey = str;
        this.this$0 = homeFragment;
        this.$deviceType = str2;
    }

    public final void invoke() {
        Bundle bundle = new Bundle();
        bundle.putString("URL_KEY", UserGuideHelper.f7928a.e(this.$deviceType));
        bundle.putBoolean("FULL_SCREEN", true);
        DataStoreUtils.e.a().o(this.$localKey, Boolean.TRUE);
        TipsManager.f7827a.d(TipsKey.TIPS_USER_GUIDE);
        StaticMethodUtilsKt.v(this.this$0, R.id.userGuideFragment, bundle);
    }
}
