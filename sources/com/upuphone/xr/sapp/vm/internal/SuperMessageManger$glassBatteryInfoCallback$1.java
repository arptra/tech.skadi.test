package com.upuphone.xr.sapp.vm.internal;

import androidx.lifecycle.MutableLiveData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.GlassBatteryInfo;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/vm/internal/SuperMessageManger$glassBatteryInfoCallback$1", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/entity/GlassBatteryInfo;", "", "Lcom/upuphone/xr/sapp/glass/GlassBatteryInfoCallback;", "glassBatteryInfo", "a", "(Lcom/upuphone/xr/sapp/entity/GlassBatteryInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SuperMessageManger$glassBatteryInfoCallback$1 implements Function1<GlassBatteryInfo, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperMessageManger f8017a;

    public SuperMessageManger$glassBatteryInfoCallback$1(SuperMessageManger superMessageManger) {
        this.f8017a = superMessageManger;
    }

    public void a(GlassBatteryInfo glassBatteryInfo) {
        Intrinsics.checkNotNullParameter(glassBatteryInfo, "glassBatteryInfo");
        ULog.Delegate delegate = ULog.f6446a;
        String f = SuperMessageManger.n;
        delegate.a(f, "GlassBatteryInfoCallback: " + glassBatteryInfo);
        SuperViewModel e = this.f8017a.d;
        MutableLiveData n0 = e != null ? e.n0() : null;
        if (n0 != null) {
            n0.setValue(glassBatteryInfo);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((GlassBatteryInfo) obj);
        return Unit.INSTANCE;
    }
}
