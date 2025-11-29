package com.upuphone.xr.sapp.vu.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesLanguageModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "", "d", "()Ljava/lang/String;", "language", "", "e", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "_language", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "c", "()Landroidx/lifecycle/LiveData;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesLanguageModel extends ViewModel {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData f8114a;
    public final LiveData b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesLanguageModel$Companion;", "", "()V", "LAN_CN_ZH", "", "LAN_EN_MS", "LAN_EN_US", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public VuGlassesLanguageModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f8114a = mutableLiveData;
        this.b = mutableLiveData;
        mutableLiveData.setValue(GlassDataStoreHelper.f8091a.b());
    }

    public final LiveData c() {
        return this.b;
    }

    public final String d() {
        Object value = this.b.getValue();
        Intrinsics.checkNotNull(value);
        return (String) value;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "language");
        this.f8114a.setValue(str);
        GlassDataStoreHelper.f8091a.m(str);
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.o(str);
        }
    }
}
