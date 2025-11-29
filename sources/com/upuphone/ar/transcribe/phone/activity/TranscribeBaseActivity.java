package com.upuphone.ar.transcribe.phone.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.MuteAudioHelper;
import com.upuphone.star.common.phone.UBaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "Lcom/upuphone/star/common/phone/UBaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setStatusBar", "isDarkMode", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class TranscribeBaseActivity extends UBaseActivity {
    private final void setStatusBar(boolean z) {
        Unit unit;
        fitStatusBar(true);
        setNavigationBarColor(0);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), viewGroup);
            a2.d(!z);
            a2.c(!z);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.g("contentView is null", "TranslationBaseActivity");
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStatusBar(ContextExtKt.d(this));
        TranscribeApp.pushActivity(this);
    }

    public void onDestroy() {
        super.onDestroy();
        MuteAudioHelper.c(true);
        TranscribeApp.popActivity();
    }
}
