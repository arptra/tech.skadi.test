package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import androidx.lifecycle.AndroidViewModel;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.i5.n;
import com.honey.account.i5.o;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u00013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0010J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0010J\u0015\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u0015J%\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\r2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\tJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorSettingsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "onCleared", "()V", "", "m", "()Z", "", "callAudio", "j", "(I)I", "index", "l", "", "k", "(I)Ljava/lang/String;", "type", "f", "h", "g", "audioType", "Lkotlin/Function0;", "onComplete", "n", "(ILkotlin/jvm/functions/Function0;)V", "r", "focusChange", "onAudioFocusChange", "(I)V", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroid/media/AudioManager;", "c", "Landroid/media/AudioManager;", "mAudioManager", "Landroid/media/AudioFocusRequest;", "d", "Landroid/media/AudioFocusRequest;", "mAudioFocusRequest", "Landroid/media/MediaPlayer;", "e", "Landroid/media/MediaPlayer;", "mMediaPlayer", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorSettingsViewModel extends AndroidViewModel implements AudioManager.OnAudioFocusChangeListener {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public AudioManager c;
    public AudioFocusRequest d;
    public MediaPlayer e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorSettingsViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSettingsViewModel(@NotNull Application application) {
        super(application);
        AudioManager audioManager;
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        Object systemService = application.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.c = (AudioManager) systemService;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
        this.e = mediaPlayer;
        AudioFocusRequest build = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(this).build();
        this.d = build;
        if (build != null && (audioManager = this.c) != null) {
            audioManager.requestAudioFocus(build);
        }
    }

    public static final void p(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "$mediaPlayer");
        mediaPlayer.start();
    }

    public static final void q(Function0 function0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(function0, "$onComplete");
        LogExt.j("playAudioTypeTts onComplete", "TranslatorSettingsViewModel");
        function0.invoke();
    }

    public final int f(int i) {
        return (i == 1 || i != 2) ? 0 : 1;
    }

    public final String g(int i) {
        String[] stringArray = this.b.getResources().getStringArray(R.array.call_broadcast_audio_type);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        if (stringArray.length < 2) {
            return "";
        }
        if (i == 1) {
            String str = stringArray[0];
            Intrinsics.checkNotNull(str);
            return str;
        } else if (i != 2) {
            String str2 = stringArray[0];
            Intrinsics.checkNotNull(str2);
            return str2;
        } else {
            String str3 = stringArray[1];
            Intrinsics.checkNotNull(str3);
            return str3;
        }
    }

    public final int h(int i) {
        return (i == 0 || i != 1) ? 1 : 2;
    }

    public final int j(int i) {
        return (i == 1 || i != 2) ? 0 : 1;
    }

    public final String k(int i) {
        String[] stringArray = this.b.getResources().getStringArray(R.array.call_audio_content);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        if (stringArray.length < 2) {
            return "";
        }
        if (i == 1) {
            String str = stringArray[0];
            Intrinsics.checkNotNull(str);
            return str;
        } else if (i != 2) {
            String str2 = stringArray[0];
            Intrinsics.checkNotNull(str2);
            return str2;
        } else {
            String str3 = stringArray[1];
            Intrinsics.checkNotNull(str3);
            return str3;
        }
    }

    public final int l(int i) {
        return (i == 0 || i != 1) ? 1 : 2;
    }

    public final boolean m() {
        if (!TranslatorConstants.isAirPro()) {
            return false;
        }
        float[] roleVprint = TranslatorConstants.getRoleVprint();
        boolean f2 = PreferencesUtils.f();
        if (!(roleVprint.length == 0)) {
            PreferencesUtils.r(false);
        }
        return f2 && roleVprint.length == 0;
    }

    public final void n(int i, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.reset();
                String str = i != 1 ? "translator_standard_female.mp3" : "translator_standard_male.mp3";
                LogExt.j("playAudioTypeTts audioFileName=" + str, "TranslatorSettingsViewModel");
                AssetFileDescriptor openFd = this.b.getAssets().openFd(str);
                Intrinsics.checkNotNullExpressionValue(openFd, "openFd(...)");
                mediaPlayer.setDataSource(openFd);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new n(mediaPlayer));
                mediaPlayer.setOnCompletionListener(new o(function0));
            } catch (Exception e2) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
                LogExt.j("playAudioTypeTts error=" + stackTraceToString, "TranslatorSettingsViewModel");
            }
        }
    }

    public void onAudioFocusChange(int i) {
        if (i == -2) {
            MediaPlayer mediaPlayer = this.e;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        } else if (i == -1) {
            try {
                MediaPlayer mediaPlayer2 = this.e;
                if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                    mediaPlayer2.stop();
                }
            } catch (Exception e2) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
                LogExt.j("onAudioFocusChange error=" + stackTraceToString, "TranslatorSettingsViewModel");
            }
        }
    }

    public void onCleared() {
        AudioManager audioManager;
        super.onCleared();
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.e;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        this.e = null;
        AudioFocusRequest audioFocusRequest = this.d;
        if (!(audioFocusRequest == null || (audioManager = this.c) == null)) {
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
        this.d = null;
        this.c = null;
    }

    public final void r() {
        LogExt.j("stopAudioTypeTts", "TranslatorSettingsViewModel");
        try {
            MediaPlayer mediaPlayer = this.e;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("stopAudioTypeTts error=" + stackTraceToString, "TranslatorSettingsViewModel");
        }
    }
}
