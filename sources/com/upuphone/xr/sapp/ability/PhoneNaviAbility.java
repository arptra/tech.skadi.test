package com.upuphone.xr.sapp.ability;

import android.content.Context;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneNaviAbilityImpl;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001d\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\u0019\u0010!\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b#\u0010\"J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b(\u0010\u0019J!\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b)\u0010\u0019J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010,J!\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\tH\u0016¢\u0006\u0004\b2\u0010\u000bJ\u000f\u00103\u001a\u00020\tH\u0016¢\u0006\u0004\b3\u0010\u000bJ\u0015\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e04H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\fH\u0016¢\u0006\u0004\b8\u0010\u0016J\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b04H\u0016¢\u0006\u0004\b9\u00106R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010:\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneNaviAbility;", "Lcom/upuphone/xr/interconnect/api/PhoneNaviAbilityImpl$INaviAbilityResponse;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "a", "()V", "", "isNaving", "()Z", "", "naviMode", "", "keyword", "Lcom/upuphone/xr/interconnect/common/INaviPoiCallback;", "callback", "poiSearch", "(ILjava/lang/String;Lcom/upuphone/xr/interconnect/common/INaviPoiCallback;)V", "type", "hasAddress", "(I)Z", "Lcom/upuphone/xr/interconnect/common/INaviActionResult;", "startNaviToAddress", "(ILcom/upuphone/xr/interconnect/common/INaviActionResult;)V", "strategy", "Lcom/upuphone/xr/interconnect/entity/PoiResult;", "destPoi", "startNavi", "(IILcom/upuphone/xr/interconnect/entity/PoiResult;Lcom/upuphone/xr/interconnect/common/INaviActionResult;)V", "isNaviOpened", "Lcom/upuphone/xr/interconnect/common/INaviLocationCallback;", "startLocation", "(Lcom/upuphone/xr/interconnect/common/INaviLocationCallback;)V", "stopLocation", "", "getLocation", "()[D", "callBack", "changeNavi", "changeRoute", "isOn", "setTrafficEnabled", "(Z)V", "refreshNavi", "setNaviSpeak", "poi", "saveNaviAddress", "(Lcom/upuphone/xr/interconnect/entity/PoiResult;I)Z", "isTrafficEnabled", "isNaviSpeakOn", "", "findDeniedPermissions", "()Ljava/util/List;", "frontDistance", "readTrafficInfo", "getFreqVisitedAddress", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneNaviAbility implements PhoneNaviAbilityImpl.INaviAbilityResponse {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6599a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/ability/PhoneNaviAbility$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PhoneNaviAbility(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6599a = context;
    }

    public final void a() {
        InterconnectManager.getInstance().getPhoneNaviAbility().registerNaviResponse(this);
    }

    public void changeNavi(int i, INaviActionResult iNaviActionResult) {
        ULog.f6446a.a("PhoneNaviAbility", "do changeNavi==");
        try {
            NaviManager.getInstance(this.f6599a).changeNavi(i, iNaviActionResult);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "changeNavi::e is: " + message);
        }
    }

    public void changeRoute(int i, INaviActionResult iNaviActionResult) {
        ULog.f6446a.a("PhoneNaviAbility", "do changeRoute==");
        try {
            NaviManager.getInstance(this.f6599a).changeRoute(i, iNaviActionResult);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "changeRoute::e is: " + message);
        }
    }

    public List findDeniedPermissions() {
        ULog.f6446a.a("PhoneNaviAbility", "do findDeniedPermissions==");
        try {
            List<String> findDeniedPermissions = NaviManager.getInstance(this.f6599a).findDeniedPermissions();
            Intrinsics.checkNotNullExpressionValue(findDeniedPermissions, "findDeniedPermissions(...)");
            return findDeniedPermissions;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "findDeniedPermissions::e is: " + message);
            return new ArrayList();
        }
    }

    public List getFreqVisitedAddress() {
        ULog.f6446a.a("PhoneNaviAbility", "do getFreqVisitedAddress==");
        try {
            List<PoiResult> freqVisitedAddress = NaviManager.getInstance(this.f6599a).getFreqVisitedAddress(this.f6599a);
            Intrinsics.checkNotNullExpressionValue(freqVisitedAddress, "getFreqVisitedAddress(...)");
            return freqVisitedAddress;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "readTrafficInfo::e is: " + message);
            return new ArrayList();
        }
    }

    public double[] getLocation() {
        ULog.f6446a.a("PhoneNaviAbility", "do getLocation==");
        try {
            double[] location = NaviManager.getInstance(this.f6599a).getLocation();
            Intrinsics.checkNotNullExpressionValue(location, "getLocation(...)");
            return location;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "getLocation::e is: " + message);
            return new double[0];
        }
    }

    public boolean hasAddress(int i) {
        ULog.f6446a.a("PhoneNaviAbility", "do hasAddress==");
        try {
            return NaviManager.getInstance(this.f6599a).hasAddress(i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "hasAddress::e is: " + message);
            return false;
        }
    }

    public boolean isNaviOpened() {
        ULog.f6446a.a("PhoneNaviAbility", "do isNaviOpened==");
        try {
            return NaviManager.getInstance(this.f6599a).isNaviOpened();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "isNaviOpened::e is: " + message);
            return false;
        }
    }

    public boolean isNaviSpeakOn() {
        ULog.f6446a.a("PhoneNaviAbility", "do isNaviSpeakOn==");
        try {
            return NaviManager.getInstance(this.f6599a).isNaviSpeakOn();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "isNaviSpeakOn::e is: " + message);
            return false;
        }
    }

    public boolean isNaving() {
        ULog.f6446a.a("PhoneNaviAbility", "do isNaving==");
        try {
            return NaviManager.getInstance(this.f6599a).isNaving();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "isNaving::e is: " + message);
            return false;
        }
    }

    public boolean isTrafficEnabled() {
        ULog.f6446a.a("PhoneNaviAbility", "do isTrafficEnabled==");
        try {
            return NaviManager.getInstance(this.f6599a).isTrafficEnabled();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "isTrafficEnabled::e is: " + message);
            return false;
        }
    }

    public void poiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback) {
        ULog.f6446a.a("PhoneNaviAbility", "do poiSearch==");
        try {
            NaviManager.getInstance(this.f6599a).poiSearch(this.f6599a, str, iNaviPoiCallback);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "poiSearch::e is: " + message);
        }
    }

    public boolean readTrafficInfo(int i) {
        ULog.f6446a.a("PhoneNaviAbility", "do readTrafficInfo==");
        try {
            return NaviManager.getInstance(this.f6599a).readTrafficInfo(i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "readTrafficInfo::e is: " + message);
            return false;
        }
    }

    public boolean refreshNavi() {
        ULog.f6446a.a("PhoneNaviAbility", "do refreshNavi==");
        try {
            return NaviManager.getInstance(this.f6599a).refreshNavi();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "refreshNavi::e is: " + message);
            return false;
        }
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        ULog.f6446a.a("PhoneNaviAbility", "do saveNaviAddress==");
        try {
            return NaviManager.getInstance(this.f6599a).saveNaviAddress(poiResult, i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "saveNaviAddress::e is: " + message);
            return false;
        }
    }

    public void setNaviSpeak(boolean z) {
        ULog.f6446a.a("PhoneNaviAbility", "do setNaviSpeak==");
        try {
            NaviManager.getInstance(this.f6599a).setNaviSpeak(z);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "setNaviSpeak::e is: " + message);
        }
    }

    public void setTrafficEnabled(boolean z) {
        ULog.f6446a.a("PhoneNaviAbility", "do setTrafficEnabled==");
        try {
            NaviManager.getInstance(this.f6599a).setTrafficEnabled(z);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "setTrafficEnabled::e is: " + message);
        }
    }

    public void startLocation(INaviLocationCallback iNaviLocationCallback) {
        ULog.f6446a.a("PhoneNaviAbility", "do startLocation==");
        try {
            NaviManager.getInstance(this.f6599a).startLocation(this.f6599a, iNaviLocationCallback);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "startLocation::e is: " + message);
        }
    }

    public void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) {
        Intrinsics.checkNotNullParameter(poiResult, "destPoi");
        Intrinsics.checkNotNullParameter(iNaviActionResult, "callback");
        ULog.f6446a.a("PhoneNaviAbility", "do startNavi==");
        try {
            NaviManager.getInstance(this.f6599a).startNavi(this.f6599a, i, i2, poiResult, iNaviActionResult);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "startNavi::e is: " + message);
        }
    }

    public void startNaviToAddress(int i, INaviActionResult iNaviActionResult) {
        Intrinsics.checkNotNullParameter(iNaviActionResult, "callback");
        ULog.f6446a.a("PhoneNaviAbility", "do startNaviToAddress==");
        try {
            NaviManager.getInstance(this.f6599a).startNaviToAddress(this.f6599a, i, iNaviActionResult);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "startNaviToAddress::e is: " + message);
        }
    }

    public void stopLocation(INaviLocationCallback iNaviLocationCallback) {
        ULog.f6446a.a("PhoneNaviAbility", "do stopLocation==");
        try {
            NaviManager.getInstance(this.f6599a).stopLocation(iNaviLocationCallback);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("PhoneNaviAbility", "stopLocation::e is: " + message);
        }
    }
}
