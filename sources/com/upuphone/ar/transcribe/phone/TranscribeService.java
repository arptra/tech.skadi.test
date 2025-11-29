package com.upuphone.ar.transcribe.phone;

import android.app.Notification;
import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.audio.debug.AudioDebugHelper;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.utils.RomUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J)\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0003¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/TranscribeService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "", "f", "()Z", "", "onCreate", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "b", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeService extends LifecycleService {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static boolean c = true;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/TranscribeService$Companion;", "", "()V", "TAG", "", "needSendInitFinishMsg", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final boolean f() {
        return InterConnectHelper.c.a().k();
    }

    public void onCreate() {
        super.onCreate();
        RomUtils.RomInfo c2 = RomUtils.f6192a.c();
        LogExt.g("onCreate 手机Rom信息::" + c2, "TranscribeService");
        LogExt.g("转写启动: 转写手机版本: 2.0.53-dev-SNAPSHOT", "TranscribeService");
        LogExt.g("转写启动: 手机侧服务TranslationService->onCreate", "TranscribeService");
        AudioDebugHelper.b(this);
    }

    public void onDestroy() {
        super.onDestroy();
        LogExt.g("onDestroy ble通道转写", "TranscribeService");
        TranscribeApp.setTransExited(false);
        TranscribeApp.setServiceOn(false);
        TranscribeApp.release();
        c = true;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        boolean isTransExited = TranscribeApp.isTransExited();
        boolean isServiceOn = TranscribeApp.isServiceOn();
        LogExt.g("转写启动：TranslationService->onStartCommand: isTransExited=" + isTransExited + ", isServiceOn=" + isServiceOn, "TranscribeService");
        if (!isTransExited || !isServiceOn) {
            TranscribeApp.setServiceOn(true);
            TranscribeApp.setTransExited(false);
            TranscribeApp.init(this, new TranscribeService$onStartCommand$1(this));
        } else {
            InterConnectHelper.c.a().q();
        }
        boolean n = TranscribeConstants.n();
        Notification keepLiveNotification = TranscribeApp.getKeepLiveNotification();
        if (n && keepLiveNotification != null) {
            startForeground(TranscribeApp.getKeepLiveNotifyId(), keepLiveNotification);
        }
        LogExt.g("转写启动: 服务启动selfPhoneThird=" + n + ", notification=" + keepLiveNotification, "TranscribeService");
        return super.onStartCommand(intent, i, i2);
    }
}
