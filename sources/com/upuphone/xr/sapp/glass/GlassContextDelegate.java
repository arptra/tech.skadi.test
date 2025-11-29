package com.upuphone.xr.sapp.glass;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.audio.GlassVolInfo;
import com.upuphone.xr.sapp.context.GlassContext;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfoKt;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0003R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\"\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0 8VX\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b\u001a\u0010!R\u001a\u0010&\u001a\u00020\u000b8VX\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0003\u001a\u0004\b\u001e\u0010$R\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190 8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010!R\u0016\u0010)\u001a\u0004\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010(¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassContextDelegate;", "Lcom/upuphone/xr/sapp/context/GlassContext;", "<init>", "()V", "", "d", "()Ljava/lang/String;", "", "isAir", "()Z", "isAirPro", "", "value", "", "f", "(I)V", "m", "l", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "_peerVersionData", "b", "I", "peerVersionCache", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "c", "_glassInfoData", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "glassInfoCache", "e", "_glassVolumeData", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "getPeerVersionData$annotations", "peerVersionData", "()I", "getPeerVersionOrCache$annotations", "peerVersionOrCache", "glassInfoData", "()Lcom/upuphone/xr/sapp/context/IGlassInfo;", "glassInfoOrCache", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassContextDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassContextDelegate.kt\ncom/upuphone/xr/sapp/glass/GlassContextDelegate\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,138:1\n29#2,5:139\n29#2,5:144\n*S KotlinDebug\n*F\n+ 1 GlassContextDelegate.kt\ncom/upuphone/xr/sapp/glass/GlassContextDelegate\n*L\n48#1:139,5\n118#1:144,5\n*E\n"})
public final class GlassContextDelegate implements GlassContext {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData f7045a = new MutableLiveData();
    public int b = -1;
    public final MutableLiveData c = new MutableLiveData();
    public IGlassInfo d;
    public final MutableLiveData e = new MutableLiveData();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassContextDelegate$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GlassContextDelegate() {
        l();
        m();
    }

    public IGlassInfo a() {
        SimpleGlassInfo toSimpleGlassInfo;
        IGlassInfo iGlassInfo = (IGlassInfo) this.c.getValue();
        if (iGlassInfo != null) {
            return iGlassInfo;
        }
        IGlassInfo iGlassInfo2 = this.d;
        if (iGlassInfo2 != null) {
            return iGlassInfo2;
        }
        BasicGlassInfo a2 = GlassPreference.f7059a.a();
        if (a2 == null || (toSimpleGlassInfo = BasicGlassInfoKt.getToSimpleGlassInfo(a2)) == null) {
            return null;
        }
        this.d = toSimpleGlassInfo;
        return toSimpleGlassInfo;
    }

    public LiveData b() {
        return this.c;
    }

    public LiveData c() {
        return this.f7045a;
    }

    public String d() {
        return ControlUtils.f7858a.y();
    }

    public int e() {
        Integer num = (Integer) this.f7045a.getValue();
        return num == null ? this.b : num.intValue();
    }

    public void f(int i) {
        this.e.postValue(Integer.valueOf(i));
    }

    public boolean isAir() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAir();
    }

    public boolean isAirPro() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();
    }

    public final void l() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new GlassContextDelegate$initGlassVersion$1(this, (Continuation<? super GlassContextDelegate$initGlassVersion$1>) null), 3, (Object) null);
    }

    public final void m() {
        Object obj;
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "volume_info_store", "", (Context) null, 4, (Object) null);
        Type type = new GlassContextDelegate$initGlassVolume$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(str, type);
        }
        GlassVolInfo glassVolInfo = (GlassVolInfo) obj;
        if (glassVolInfo == null) {
            glassVolInfo = new GlassVolInfo(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
        }
        this.e.postValue(Integer.valueOf(glassVolInfo.getCurrent()));
    }
}
