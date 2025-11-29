package com.upuphone.ar.transcribe.phone.helper;

import android.content.Context;
import android.content.DialogInterface;
import com.honey.account.x4.a;
import com.honey.account.x4.b;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.TranslationStateEntity;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.activity.TranscribeBaseActivity;
import com.upuphone.ar.transcribe.utils.LanguageUtils;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/MuteAudioHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;", "transStateEntity", "", "e", "(Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;)V", "", "isSendExitDialog", "c", "(Z)V", "Landroid/content/Context;", "activity", "", "title", "cancel", "confirm", "f", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "context", "i", "(Landroid/content/Context;)V", "Lflyme/support/v7/app/AlertDialog;", "b", "Lflyme/support/v7/app/AlertDialog;", "mNoSoundDialog", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MuteAudioHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final MuteAudioHelper f6103a = new MuteAudioHelper();
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

    public static final void e(TranslationStateEntity translationStateEntity) {
        Intrinsics.checkNotNullParameter(translationStateEntity, "transStateEntity");
        TranscribeBaseActivity peekActivity = TranscribeApp.peekActivity();
        if (peekActivity != null) {
            int transState = translationStateEntity.getTransState();
            int extCode = translationStateEntity.getExtCode();
            String e = InterconnectMsgCodExtKt.e(transState);
            String d = InterconnectMsgCodExtKt.d(extCode);
            LogExt.g("transState=" + e + ", extCode=" + d, "MuteAudioHelper");
            if (transState == 2) {
                MuteAudioHelper muteAudioHelper = f6103a;
                String string = peekActivity.getString(R.string.trsb_transcribe_no_sound_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = peekActivity.getString(R.string.trsb_dialog_cancel);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = peekActivity.getString(R.string.trsb_dialog_continue);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                muteAudioHelper.f(peekActivity, string, string2, string3);
            }
        }
    }

    public static final void g(Context context, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(context, "$activity");
        f6103a.i(context);
        c(false);
    }

    public static final void h(DialogInterface dialogInterface, int i) {
        c(true);
    }

    public final void f(Context context, String str, String str2, String str3) {
        AlertDialog alertDialog = b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        b = null;
        AlertDialog create = new AlertDialog.Builder(context).setTitle((CharSequence) str).setPositiveButton((CharSequence) str3, (DialogInterface.OnClickListener) new a(context)).setNegativeButton((CharSequence) str2, (DialogInterface.OnClickListener) new b()).create();
        b = create;
        if (create != null) {
            create.show();
        }
    }

    public final void i(Context context) {
        LanguageUtils.StoredLanguage c = LanguageUtils.c(context, false, false, 6, (Object) null);
        String a2 = c.a();
        String a3 = c.a();
        if (TranscribeConstants.f6027a.h()) {
            a2 = "cn";
            a3 = "cnen";
        }
        TranscribeManager.Companion companion = TranscribeManager.j;
        if (!companion.a().h().n() || !companion.a().h().g()) {
            LogExt.g("startTransForPhone: 翻译未启动=>点击开始翻译", "MuteAudioHelper");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranscribeApp.startService(applicationContext);
            return;
        }
        LogExt.g("startTransForPhone: 翻译已启动=>点击开始翻译", "MuteAudioHelper");
        InterConnectHelper.c.a().z(1, a2, a3);
        companion.a().h().E();
    }
}
