package com.upuphone.xr.sapp.vu.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u0004J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0016\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\b0\b0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010)\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\b0\b0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010 R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0006¢\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010 R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0006¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b/\u0010&¨\u00062"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$OnBrightnessChangeListener;", "<init>", "()V", "", "onCleared", "p", "", "mode", "n", "(I)V", "value", "m", "brightness", "onBrightnessChange", "", "h", "(I)Ljava/lang/String;", "Lkotlin/Function0;", "setBlock", "successBlock", "l", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "T", "getBlock", "Lkotlin/Function1;", "k", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "_displayMode", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "g", "()Landroidx/lifecycle/LiveData;", "displayMode", "c", "_autoSleep", "d", "f", "autoSleep", "e", "_viewGlassBrightness", "j", "viewGlassBrightness", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassesPreferenceModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesPreferenceModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,138:1\n1#2:139\n*E\n"})
public final class VuGlassesPreferenceModel extends ViewModel implements VuGlassesEventDispatcher.OnBrightnessChangeListener {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData f8119a;
    public final LiveData b;
    public final MutableLiveData c;
    public final LiveData d;
    public final MutableLiveData e;
    public final LiveData f;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel$Companion;", "", "()V", "DEFAULT_AUTO_SLEEP_VALUE", "", "DEFAULT_DISPLAY_MODE_VALUE", "DEFAULT_KEEP_VIEW_HORIZONTAL_VALUE", "", "DISPLAY_MODE_EYE_CARE", "DISPLAY_MODE_STANDARD", "DISPLAY_MODE_VIDEO", "REFRESH_RATE_120", "REFRESH_RATE_60", "REFRESH_RATE_75", "REFRESH_RATE_FORCE", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public VuGlassesPreferenceModel() {
        MutableLiveData mutableLiveData = new MutableLiveData(0);
        this.f8119a = mutableLiveData;
        this.b = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(60);
        this.c = mutableLiveData2;
        this.d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.e = mutableLiveData3;
        this.f = mutableLiveData3;
        VuGlassesEventDispatcher.f8098a.d(this);
    }

    public final LiveData f() {
        return this.d;
    }

    public final LiveData g() {
        return this.b;
    }

    public final String h(int i) {
        if (i == 0) {
            String string = MainApplication.k.f().getString(R.string.display_mode_video);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == 1) {
            String string2 = MainApplication.k.f().getString(R.string.display_mode_pro);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (i != 2) {
            String string3 = MainApplication.k.f().getString(R.string.display_mode_video);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else {
            String string4 = MainApplication.k.f().getString(R.string.display_mode_eye_care);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
    }

    public final LiveData j() {
        return this.f;
    }

    public final void k(Function0 function0, Function1 function1) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m20constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r5 = Result.m23exceptionOrNullimpl(obj);
        if (r5 != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = r5.getMessage();
            delegate.a("VuGlassesPreferenceModel", "safeGet error: " + message);
        }
        if (Result.m26isFailureimpl(obj)) {
            obj = null;
        }
        if ((obj instanceof Integer) && ((Number) obj).intValue() >= 0) {
            function1.invoke(obj);
        } else if (obj instanceof Boolean) {
            function1.invoke(obj);
        } else {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("VuGlassesPreferenceModel", "safeGet failed: ret=" + obj);
        }
    }

    public final void l(Function0 function0, Function0 function02) {
        Integer num;
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m20constructorimpl(Integer.valueOf(((Number) function0.invoke()).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r5 = Result.m23exceptionOrNullimpl(num);
        if (r5 != null) {
            ULog.Delegate delegate = ULog.f6446a;
            r5.printStackTrace();
            delegate.a("VuGlassesPreferenceModel", "safeSet error: " + Unit.INSTANCE);
        }
        if (Result.m26isFailureimpl(num)) {
            num = 0;
        }
        int intValue = ((Number) num).intValue();
        if (intValue == 0) {
            function02.invoke();
            return;
        }
        ULog.f6446a.a("VuGlassesPreferenceModel", "safeSet failed: ret=" + intValue);
    }

    public final void m(int i) {
        l(new VuGlassesPreferenceModel$setAutoSleep$1(i), new VuGlassesPreferenceModel$setAutoSleep$2(this, i));
    }

    public final void n(int i) {
        l(new VuGlassesPreferenceModel$setDisplayMode$1(i), new VuGlassesPreferenceModel$setDisplayMode$2(this, i));
    }

    public void onBrightnessChange(int i) {
        this.e.postValue(Integer.valueOf(i));
    }

    public void onCleared() {
        super.onCleared();
        VuGlassesEventDispatcher.f8098a.n(this);
    }

    public final void p() {
        k(VuGlassesPreferenceModel$update$1.INSTANCE, new VuGlassesPreferenceModel$update$2(this));
        k(VuGlassesPreferenceModel$update$3.INSTANCE, new VuGlassesPreferenceModel$update$4(this));
        k(VuGlassesPreferenceModel$update$5.INSTANCE, new VuGlassesPreferenceModel$update$6(this));
    }
}
