package com.upuphone.xr.sapp.monitor.schedule.rimet;

import com.upuphone.xr.sapp.monitor.schedule.ScheduleProvider;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/rimet/RimetScheduleProvider;", "Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleProvider;", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "account", "<init>", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;)V", "", "c", "()V", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RimetScheduleProvider extends ScheduleProvider {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/rimet/RimetScheduleProvider$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RimetScheduleProvider(LocalScheduleModel localScheduleModel) {
        super(localScheduleModel);
        Intrinsics.checkNotNullParameter(localScheduleModel, "account");
    }

    public void c() {
    }
}
