package com.upuphone.xr.sapp.debug;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.monitor.net.GwTokenResBody;
import com.upuphone.xr.sapp.monitor.net.TokenResBody;
import com.upuphone.xr.sapp.monitor.net.TokenUtil;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\r"}, d2 = {"com/upuphone/xr/sapp/debug/SuperAppDebugActivity$initView$3$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SuperAppDebugActivity$initView$3$1 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f6931a;
    public final /* synthetic */ SuperAppDebugActivity b;

    public SuperAppDebugActivity$initView$3$1(String[] strArr, SuperAppDebugActivity superAppDebugActivity) {
        this.f6931a = strArr;
        this.b = superAppDebugActivity;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(adapterView, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        String str = this.f6931a[i];
        NetConfig.Companion companion = NetConfig.f6666a;
        if (!Intrinsics.areEqual((Object) companion.j(), (Object) str)) {
            companion.A(str);
            Context applicationContext = this.b.getApplicationContext();
            Toast.makeText(applicationContext, "Selected: " + str, 0).show();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("SuperAppDebugActivity", "切换环境-> " + str);
            TokenUtil tokenUtil = TokenUtil.f7744a;
            tokenUtil.n((GwTokenResBody) null);
            tokenUtil.o((TokenResBody) null);
            DataStoreUtils.Companion companion2 = DataStoreUtils.e;
            companion2.a().o("networkConfigVerDetail", Integer.MIN_VALUE);
            companion2.a().o("networkConfigDetail", "");
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.b), Dispatchers.b(), (CoroutineStart) null, new SuperAppDebugActivity$initView$3$1$onItemSelected$1((Continuation<? super SuperAppDebugActivity$initView$3$1$onItemSelected$1>) null), 2, (Object) null);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
        Intrinsics.checkNotNullParameter(adapterView, "parent");
    }
}
