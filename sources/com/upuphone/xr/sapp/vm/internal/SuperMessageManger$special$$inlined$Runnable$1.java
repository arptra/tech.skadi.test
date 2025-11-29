package com.upuphone.xr.sapp.vm.internal;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.ReportInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 SuperMessageManger.kt\ncom/upuphone/xr/sapp/vm/internal/SuperMessageManger\n*L\n1#1,18:1\n1294#2,9:19\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SuperMessageManger$special$$inlined$Runnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperMessageManger f8016a;

    public SuperMessageManger$special$$inlined$Runnable$1(SuperMessageManger superMessageManger) {
        this.f8016a = superMessageManger;
    }

    public final void run() {
        ReportInfo reportInfo = new ReportInfo();
        ReportInfo.Data data = new ReportInfo.Data();
        data.setAction("req_active_state");
        reportInfo.setAction("system_glass_active");
        reportInfo.setData(data);
        String json = this.f8016a.b.toJson((Object) reportInfo);
        ULog.Delegate delegate = ULog.f6446a;
        String f = SuperMessageManger.n;
        delegate.a(f, "reqGlassActiveState = " + json);
        SuperMessageManger superMessageManger = this.f8016a;
        Intrinsics.checkNotNull(json);
        superMessageManger.j0(json);
    }
}
