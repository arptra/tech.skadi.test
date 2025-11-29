package com.xjmz.myvu.modules.home;

import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$checkHuaWeiSport$2 extends Lambda implements Function0<Unit> {
    public static final HomeFragment$checkHuaWeiSport$2 INSTANCE = new HomeFragment$checkHuaWeiSport$2();

    public HomeFragment$checkHuaWeiSport$2() {
        super(0);
    }

    public final void invoke() {
        DataStoreUtils.e.a().o("huawei_auth_open", Boolean.FALSE);
    }
}
