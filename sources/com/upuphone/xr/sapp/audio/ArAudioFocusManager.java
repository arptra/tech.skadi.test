package com.upuphone.xr.sapp.audio;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.honey.account.d8.a;
import com.honey.account.d8.b;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.util.DataBinderValueExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/audio/ArAudioFocusManager;", "", "<init>", "()V", "", "deviceId", "", "f", "(Ljava/lang/String;)V", "i", "h", "c", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "b", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mOnAudioFocusChangeListener", "Landroid/media/AudioFocusRequest;", "Landroid/media/AudioFocusRequest;", "mFocusRequest", "Landroid/media/AudioManager;", "d", "Lkotlin/Lazy;", "()Landroid/media/AudioManager;", "audioManager", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArAudioFocusManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ArAudioFocusManager f6641a = new ArAudioFocusManager();
    public static final AudioManager.OnAudioFocusChangeListener b;
    public static final AudioFocusRequest c;
    public static final Lazy d = LazyKt.lazy(ArAudioFocusManager$audioManager$2.INSTANCE);

    static {
        a aVar = new a();
        b = aVar;
        AudioFocusRequest build = new AudioFocusRequest.Builder(2).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(aVar).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        c = build;
    }

    public static final void e(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ArAudioFocusManager", "OnAudioFocusChanged  " + i);
    }

    public static final void g(DataBinderValue dataBinderValue) {
        if (dataBinderValue == null || DataBinderValueExtKt.asString(dataBinderValue) == null) {
            ULog.f6446a.a("ArAudioFocusManager", "receive AudioFocus id invalid");
            return;
        }
        ULog.Delegate delegate = ULog.f6446a;
        String asString = DataBinderValueExtKt.asString(dataBinderValue);
        delegate.a("ArAudioFocusManager", "receive AudioFocus id " + asString);
        String asString2 = DataBinderValueExtKt.asString(dataBinderValue);
        if (asString2 == null) {
            return;
        }
        if (asString2.length() != 0 && !StringsKt.equals(asString2, "com.android.bluetooth", true)) {
            f6641a.h();
        } else {
            f6641a.c();
        }
    }

    public final void c() {
        ULog.f6446a.g("ArAudioFocusManager", "abandonAudioFocus");
        d().abandonAudioFocusRequest(c);
    }

    public final AudioManager d() {
        return (AudioManager) d.getValue();
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        ULog.f6446a.g("ArAudioFocusManager", "registerDataBinder");
        InterconnectManager.getInstance().getDataBinderManager().subscribe(str, "AudioFocus:focused", (DataBinderItemUpdateListener) new b());
    }

    public final void h() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ArAudioFocusManager", "requestAudioFocus");
        if (d().requestAudioFocus(c) == 1) {
            delegate.g("ArAudioFocusManager", "request audiofocus success");
        } else {
            delegate.g("ArAudioFocusManager", "request audiofocus failed");
        }
    }

    public final void i(String str) {
        ULog.f6446a.g("ArAudioFocusManager", "unregisterDataBinder");
        c();
    }
}
