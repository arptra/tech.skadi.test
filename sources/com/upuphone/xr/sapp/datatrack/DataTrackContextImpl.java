package com.upuphone.xr.sapp.datatrack;

import com.upuphone.xr.sapp.context.DataTrackContext;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016¢\u0006\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackContextImpl;", "Lcom/upuphone/xr/sapp/context/DataTrackContext;", "<init>", "()V", "", "eventName", "", "attributes", "", "reportEvent", "(Ljava/lang/String;Ljava/util/Map;)V", "", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DataTrackContextImpl implements DataTrackContext {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6914a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackContextImpl$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        DataTrackUtil.n(DataTrackUtil.f7875a, str, map, false, 4, (Object) null);
    }

    public void reportEvent(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        DataTrackUtil.n(DataTrackUtil.f7875a, str, map, false, 4, (Object) null);
    }
}
