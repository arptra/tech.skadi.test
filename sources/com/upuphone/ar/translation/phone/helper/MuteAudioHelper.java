package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.honey.account.g5.b;
import com.honey.account.g5.c;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.activity.TranslatorBaseActivity;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/MuteAudioHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "transStateEntity", "", "e", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;)V", "", "isSendExitDialog", "c", "(Z)V", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "", "title", "cancel", "confirm", "f", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "i", "(Landroid/content/Context;)V", "Lflyme/support/v7/app/AlertDialog;", "b", "Lflyme/support/v7/app/AlertDialog;", "mNoSoundDialog", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MuteAudioHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final MuteAudioHelper f6299a = new MuteAudioHelper();
    public static AlertDialog b;

    public static final void c(boolean z) {
        if (b != null && z) {
            InterConnectHelper.c.a().v();
        }
        AlertDialog alertDialog = b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        b = null;
    }

    public static /* synthetic */ void d(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c(z);
    }

    public static final void e(TranslationState translationState) {
        Intrinsics.checkNotNullParameter(translationState, "transStateEntity");
        TranslatorBaseActivity peekActivity$ar_translator_intlRelease = TranslationApp.peekActivity$ar_translator_intlRelease();
        if (peekActivity$ar_translator_intlRelease != null) {
            int transState = translationState.getTransState();
            int extCode = translationState.getExtCode();
            String j = InterconnectMsgCodExtKt.j(transState);
            String i = InterconnectMsgCodExtKt.i(extCode);
            LogExt.j("transState=" + j + ", extCode=" + i, "MuteAudioHelper");
            if (transState == 2) {
                if (PreferencesUtils.m() == 1) {
                    MuteAudioHelper muteAudioHelper = f6299a;
                    String string = peekActivity$ar_translator_intlRelease.getString(R.string.tl_transcribe_no_sound_title);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = peekActivity$ar_translator_intlRelease.getString(R.string.tl_dialog_cancel);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = peekActivity$ar_translator_intlRelease.getString(R.string.tl_dialog_continue);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    muteAudioHelper.f(peekActivity$ar_translator_intlRelease, string, string2, string3);
                    return;
                }
                MuteAudioHelper muteAudioHelper2 = f6299a;
                String string4 = peekActivity$ar_translator_intlRelease.getString(R.string.tl_translation_no_sound_title);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String string5 = peekActivity$ar_translator_intlRelease.getString(R.string.tl_dialog_cancel);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                String string6 = peekActivity$ar_translator_intlRelease.getString(R.string.tl_dialog_continue);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                muteAudioHelper2.f(peekActivity$ar_translator_intlRelease, string4, string5, string6);
            }
        }
    }

    public static final void g(AppCompatActivity appCompatActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$activity");
        f6299a.i(appCompatActivity);
        c(true);
    }

    public static final void h(DialogInterface dialogInterface, int i) {
        c(true);
    }

    public final void f(AppCompatActivity appCompatActivity, String str, String str2, String str3) {
        AlertDialog alertDialog = b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        b = null;
        AlertDialog create = new AlertDialog.Builder(appCompatActivity).setTitle((CharSequence) str).setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new b(appCompatActivity)).setNegativeButton((CharSequence) str2, (DialogInterface.OnClickListener) new c()).create();
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        b = create;
        if (create != null) {
            create.show();
        }
    }

    public final void i(Context context) {
        String str;
        String str2;
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        int m = PreferencesUtils.m();
        if (m == 2) {
            str2 = g.d();
            str = g.c();
        } else if (m != 3) {
            str2 = g.e();
            str = g.e();
        } else {
            str2 = g.b();
            str = g.a();
        }
        if (TranslatorConstants.isAirOldLanguage()) {
            str2 = "cn";
            str = "cnen";
        }
        TranslationManager.Companion companion = TranslationManager.q;
        TranslateStateManager p = companion.a().p();
        if (p == null || !p.c()) {
            LogExt.j("startTransForPhone: 翻译未启动=>点击开始翻译", "MuteAudioHelper");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranslationApp.startService(applicationContext);
            return;
        }
        LogExt.j("startTransForPhone: 翻译已启动=>点击开始翻译", "MuteAudioHelper");
        InterConnectHelper.c.a().z(m, str2, str);
        TranslateStateManager p2 = companion.a().p();
        if (p2 != null) {
            p2.y();
        }
    }
}
