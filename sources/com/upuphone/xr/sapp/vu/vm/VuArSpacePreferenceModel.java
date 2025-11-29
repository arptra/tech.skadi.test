package com.upuphone.xr.sapp.vu.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuArSpacePreferenceModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "", "autoOpen", "", "f", "(Z)V", "enable", "e", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "_autoOpenArSpace", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "d", "()Landroidx/lifecycle/LiveData;", "autoOpenArSpace", "c", "_antiShake", "antiShake", "_keepViewHorizontal", "getKeepViewHorizontal", "keepViewHorizontal", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuArSpacePreferenceModel extends ViewModel {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData f8108a;
    public final LiveData b;
    public final MutableLiveData c;
    public final LiveData d;
    public final MutableLiveData e;
    public final LiveData f;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuArSpacePreferenceModel$Companion;", "", "()V", "DEFAULT_ANTI_SHAKE_VALUE", "", "DEFAULT_KEEP_VIEW_HORIZONTAL_VALUE", "DEFAULT_OPEN_AR_SPACE_VALUE", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public VuArSpacePreferenceModel() {
        Boolean bool = Boolean.FALSE;
        MutableLiveData mutableLiveData = new MutableLiveData(bool);
        this.f8108a = mutableLiveData;
        this.b = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(bool);
        this.c = mutableLiveData2;
        this.d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData(Boolean.TRUE);
        this.e = mutableLiveData3;
        this.f = mutableLiveData3;
        GlassDataStoreHelper glassDataStoreHelper = GlassDataStoreHelper.f8091a;
        mutableLiveData.setValue(Boolean.valueOf(glassDataStoreHelper.d()));
        mutableLiveData2.setValue(Boolean.valueOf(glassDataStoreHelper.c(false)));
        mutableLiveData3.setValue(Boolean.valueOf(glassDataStoreHelper.f(true)));
    }

    public final LiveData c() {
        return this.d;
    }

    public final LiveData d() {
        return this.b;
    }

    public final void e(boolean z) {
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.x(z);
        }
        this.c.setValue(Boolean.valueOf(z));
        GlassDataStoreHelper.f8091a.i(z);
    }

    public final void f(boolean z) {
        this.f8108a.setValue(Boolean.valueOf(z));
        GlassDataStoreHelper.f8091a.j(z);
    }
}
