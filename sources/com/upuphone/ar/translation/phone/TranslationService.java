package com.upuphone.ar.translation.phone;

import android.app.Notification;
import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.utils.RomUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J)\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0003¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/phone/TranslationService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "", "g", "()Z", "", "onCreate", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "f", "b", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslationService extends LifecycleService {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static boolean c = true;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/translation/phone/TranslationService$Companion;", "", "()V", "TAG", "", "needSendInitFinishMsg", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final boolean g() {
        return InterConnectHelper.c.a().j();
    }

    public final void f() {
        boolean isTransExited$ar_translator_intlRelease = TranslationApp.isTransExited$ar_translator_intlRelease();
        boolean isServiceOn = TranslationApp.isServiceOn();
        LogExt.j("[ON_START_COMMAND]isTransExited=" + isTransExited$ar_translator_intlRelease + ", isServiceOn=" + isServiceOn, "TranslationService");
        if (!isTransExited$ar_translator_intlRelease || !isServiceOn) {
            TranslationApp.setServiceOn$ar_translator_intlRelease(true);
            TranslationApp.setTransExited$ar_translator_intlRelease(false);
            TranslationApp.initService$ar_translator_intlRelease(this, new TranslationService$handleOnStartCommand$1(this));
            boolean isSelfPhoneThird = TranslatorConstants.isSelfPhoneThird();
            Notification keepLiveNotification$ar_translator_intlRelease = TranslationApp.getKeepLiveNotification$ar_translator_intlRelease();
            if (isSelfPhoneThird && keepLiveNotification$ar_translator_intlRelease != null) {
                startForeground(TranslationApp.getKeepLiveNotifyId$ar_translator_intlRelease(), keepLiveNotification$ar_translator_intlRelease);
            }
            LogExt.j("[ON_START_COMMAND]服务启动selfPhoneThird=" + isSelfPhoneThird + ", notification=" + keepLiveNotification$ar_translator_intlRelease, "TranslationService");
            return;
        }
        InterConnectHelper.c.a().q();
    }

    public void onCreate() {
        super.onCreate();
        RomUtils.RomInfo c2 = RomUtils.f6371a.c();
        LogExt.j("[ON_CREATE]手机Rom信息=" + c2, "TranslationService");
        LogExt.j("[ON_CREATE]翻译服务分支=dev-SNAPSHOT", "TranslationService");
    }

    public void onDestroy() {
        super.onDestroy();
        LogExt.j("[ON_DESTROY]翻译服务翻译", "TranslationService");
        TranslationApp.setTransExited$ar_translator_intlRelease(false);
        TranslationApp.setServiceOn$ar_translator_intlRelease(false);
        TranslationApp.unInitService$ar_translator_intlRelease();
        c = true;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        f();
        return super.onStartCommand(intent, i, i2);
    }
}
