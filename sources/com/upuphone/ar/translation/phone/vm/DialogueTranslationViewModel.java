package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.i5.b;
import com.honey.account.i5.c;
import com.honey.account.i5.d;
import com.honey.account.i5.e;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.bean.DialogueUserTips;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.bean.TranslationLanguage;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.SwitchLangHelper;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.NetworkUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.ar.translation.utils.RomUtils;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0001`B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u0016J\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u0016J\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u0016J\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\u0016J\u001d\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0016J\u0017\u0010(\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\f¢\u0006\u0004\b*\u0010\u001cJ\r\u0010,\u001a\u00020+¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\b2\b\b\u0001\u0010.\u001a\u00020&¢\u0006\u0004\b/\u0010)J\u0015\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020&¢\u0006\u0004\b1\u0010)J\r\u00102\u001a\u00020+¢\u0006\u0004\b2\u0010-J\u0015\u00105\u001a\u00020&2\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\r\u00108\u001a\u000207¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\b¢\u0006\u0004\b:\u0010\u0016J\r\u0010;\u001a\u00020\b¢\u0006\u0004\b;\u0010\u0016J\u0015\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u00020\f¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\b¢\u0006\u0004\b?\u0010\u0016J\r\u0010@\u001a\u00020+¢\u0006\u0004\b@\u0010-J\r\u0010A\u001a\u00020+¢\u0006\u0004\bA\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060F8\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020&0F8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010HR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020&0L8\u0006¢\u0006\f\n\u0004\bR\u0010N\u001a\u0004\bS\u0010PR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u00101R\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006a"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/DialogueTranslationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;", "language", "", "O", "(Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;)V", "a0", "", "langType", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "w", "(Ljava/lang/String;)Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "", "E", "()Ljava/util/Map;", "G", "i0", "()V", "h0", "P", "c0", "t", "B", "()Ljava/lang/String;", "H", "k0", "b0", "v", "src", "dst", "l0", "(Lcom/upuphone/ar/translation/phone/bean/LanguageBean;Lcom/upuphone/ar/translation/phone/bean/LanguageBean;)V", "V", "", "transType", "W", "(I)V", "D", "", "L", "()Z", "strId", "j0", "callState", "Z", "M", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "x", "(Landroidx/recyclerview/widget/RecyclerView;)I", "Lcom/upuphone/ar/translation/phone/bean/DialogueUserTips;", "F", "()Lcom/upuphone/ar/translation/phone/bean/DialogueUserTips;", "g0", "Y", "text", "S", "(Ljava/lang/String;)V", "e0", "N", "K", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mTransLanguage", "d", "_mTtsStatus", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "y", "()Landroidx/lifecycle/LiveData;", "mTransLanguage", "f", "A", "mTtsStatus", "Landroid/media/AudioManager;", "g", "Landroid/media/AudioManager;", "mAudioManager", "h", "mIsSwitchToSpeaker", "Landroid/media/MediaPlayer;", "i", "Landroid/media/MediaPlayer;", "mMediaPlayer", "j", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DialogueTranslationViewModel extends AndroidViewModel {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final LiveData e;
    public final LiveData f;
    public AudioManager g;
    public boolean h;
    public MediaPlayer i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/DialogueTranslationViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogueTranslationViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.d = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.translation.phone.bean.TranslationLanguage>");
        this.e = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.f = mutableLiveData2;
    }

    public static final void I(DialogueTranslationViewModel dialogueTranslationViewModel, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(dialogueTranslationViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        String k = InterconnectMsgCodExtKt.k(i2);
        LogExt.j("SwitchLangHelper transType=" + k + ", src=" + str + ", dst=" + str2, "DialogueTranslationViewModel");
        if (i2 == 3) {
            dialogueTranslationViewModel.O(new TranslationLanguage(dialogueTranslationViewModel.w(str), dialogueTranslationViewModel.w(str2)));
        }
    }

    public static final void Q(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "$mediaPlayer");
        mediaPlayer.start();
    }

    public static final boolean R(MediaPlayer mediaPlayer, int i2, int i3) {
        LogExt.j("playMuteAudio error[mp=" + mediaPlayer + ", what=" + i2 + ", extra=" + i3 + "]", "DialogueTranslationViewModel");
        return true;
    }

    public static final void U(DialogueTranslationViewModel dialogueTranslationViewModel, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dialogueTranslationViewModel, "this$0");
        LogExt.j("playTts status=" + i2 + ", errorCode=" + i3, "DialogueTranslationViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(dialogueTranslationViewModel), Dispatchers.c(), (CoroutineStart) null, new DialogueTranslationViewModel$playTts$3$1(dialogueTranslationViewModel, i2, (Continuation<? super DialogueTranslationViewModel$playTts$3$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ void X(DialogueTranslationViewModel dialogueTranslationViewModel, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 3;
        }
        dialogueTranslationViewModel.W(i2);
    }

    public final LiveData A() {
        return this.f;
    }

    public final String B() {
        String str;
        TranslationLanguage translationLanguage = (TranslationLanguage) this.e.getValue();
        if (translationLanguage == null) {
            return "en";
        }
        String langType = translationLanguage.getSrc().getLangType();
        switch (langType.hashCode()) {
            case 3179:
                str = "cn";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3201:
                str = "de";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3241:
                langType.equals("en");
                return "en";
            case 3246:
                return !langType.equals("es") ? "en" : "esmx";
            case 3276:
                str = "fr";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3355:
                str = "id";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3371:
                str = "it";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3383:
                str = "ja";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3428:
                str = "ko";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3494:
                str = "ms";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3651:
                str = "ru";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3700:
                str = "th";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3763:
                str = "vi";
                if (!langType.equals(str)) {
                    return "en";
                }
                break;
            case 3058260:
                langType.equals("cnen");
                return "en";
            default:
                return "en";
        }
        return str;
    }

    public final String D() {
        LanguageBean src;
        String string = this.b.getString(R.string.tl_dialog_trans_use_inst_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TranslationLanguage translationLanguage = (TranslationLanguage) this.c.getValue();
        if (translationLanguage == null || (src = translationLanguage.getSrc()) == null) {
            return string;
        }
        String str = (String) E().get(src.getLangType());
        if (str == null) {
            str = string;
        }
        return str == null ? string : str;
    }

    public final Map E() {
        return MapsKt.mutableMapOf(TuplesKt.to("cn", this.b.getString(R.string.tl_dialog_trans_use_inst_cn)), TuplesKt.to("cnen", this.b.getString(R.string.tl_dialog_trans_use_inst_en)), TuplesKt.to("ja", this.b.getString(R.string.tl_dialog_trans_use_inst_ja)), TuplesKt.to("ko", this.b.getString(R.string.tl_dialog_trans_use_inst_ko)), TuplesKt.to("ru", this.b.getString(R.string.tl_dialog_trans_use_inst_ru)), TuplesKt.to("fr", this.b.getString(R.string.tl_dialog_trans_use_inst_fr)), TuplesKt.to("es", this.b.getString(R.string.tl_dialog_trans_use_inst_es)), TuplesKt.to("vi", this.b.getString(R.string.tl_dialog_trans_use_inst_vi)), TuplesKt.to("ms", this.b.getString(R.string.tl_dialog_trans_use_inst_ms)), TuplesKt.to("th", this.b.getString(R.string.tl_dialog_trans_use_inst_th)), TuplesKt.to("id", this.b.getString(R.string.tl_dialog_trans_use_inst_id)), TuplesKt.to("it", this.b.getString(R.string.tl_dialog_trans_use_inst_it)), TuplesKt.to("de", this.b.getString(R.string.tl_dialog_trans_use_inst_de)), TuplesKt.to("ar", this.b.getString(R.string.tl_dialog_trans_use_inst_ar)));
    }

    public final DialogueUserTips F() {
        Map G = G();
        DialogueUserTips dialogueUserTips = new DialogueUserTips(String.valueOf(G.get("cn")), String.valueOf(G.get("cnen")));
        TranslationLanguage translationLanguage = (TranslationLanguage) this.c.getValue();
        if (translationLanguage == null) {
            return dialogueUserTips;
        }
        String langType = translationLanguage.getSrc().getLangType();
        String langType2 = translationLanguage.getDst().getLangType();
        return (!G.containsKey(langType) || !G.containsKey(langType2)) ? dialogueUserTips : new DialogueUserTips(String.valueOf(G.get(langType)), String.valueOf(G.get(langType2)));
    }

    public final Map G() {
        return MapsKt.mutableMapOf(TuplesKt.to("cn", this.b.getString(R.string.tl_dialog_trans_user_tip_cn)), TuplesKt.to("cnen", this.b.getString(R.string.tl_dialog_trans_user_tip_en)), TuplesKt.to("ja", this.b.getString(R.string.tl_dialog_trans_user_tip_ja)), TuplesKt.to("ko", this.b.getString(R.string.tl_dialog_trans_user_tip_ko)), TuplesKt.to("ru", this.b.getString(R.string.tl_dialog_trans_user_tip_ru)), TuplesKt.to("fr", this.b.getString(R.string.tl_dialog_trans_user_tip_fr)), TuplesKt.to("es", this.b.getString(R.string.tl_dialog_trans_user_tip_es)), TuplesKt.to("vi", this.b.getString(R.string.tl_dialog_trans_user_tip_vi)), TuplesKt.to("ms", this.b.getString(R.string.tl_dialog_trans_user_tip_ms)), TuplesKt.to("th", this.b.getString(R.string.tl_dialog_trans_user_tip_th)), TuplesKt.to("id", this.b.getString(R.string.tl_dialog_trans_user_tip_id)), TuplesKt.to("it", this.b.getString(R.string.tl_dialog_trans_user_tip_it)), TuplesKt.to("ar", this.b.getString(R.string.tl_dialog_trans_user_tip_ar)));
    }

    public final void H() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new DialogueTranslationViewModel$init$1(this, (Continuation<? super DialogueTranslationViewModel$init$1>) null), 2, (Object) null);
        SwitchLangHelper.j("DialogueTranslationViewModel", new b(this));
        Object systemService = this.b.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.g = (AudioManager) systemService;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(1).build());
        this.i = mediaPlayer;
    }

    public final boolean K() {
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        return value != null && value.getCallStatus() == 2;
    }

    public final boolean L() {
        return InterConnectHelper.c.a().j();
    }

    public final boolean M() {
        TranslationLanguage translationLanguage;
        if (TranslatorConstants.isIntlVersion() || (translationLanguage = (TranslationLanguage) this.e.getValue()) == null) {
            return true;
        }
        ArrayList arrayListOf = CollectionsKt.arrayListOf("cn", "cnen", "en", "ja");
        return arrayListOf.contains(translationLanguage.getSrc().getLangType()) && arrayListOf.contains(translationLanguage.getDst().getLangType());
    }

    public final boolean N() {
        TranslationLanguage translationLanguage;
        if (!TranslatorConstants.isIntlVersion() && (translationLanguage = (TranslationLanguage) this.e.getValue()) != null) {
            return CollectionsKt.arrayListOf("cn", "cnen", "en", "ja", "es", "id", "ko").contains(translationLanguage.getSrc().getLangType());
        }
        return true;
    }

    public final void O(TranslationLanguage translationLanguage) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new DialogueTranslationViewModel$notifyLanguage$1(translationLanguage, this, (Continuation<? super DialogueTranslationViewModel$notifyLanguage$1>) null), 2, (Object) null);
    }

    public final void P() {
        LogExt.j("playMuteAudio", "DialogueTranslationViewModel");
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.reset();
                AssetFileDescriptor openFd = this.b.getAssets().openFd("translator_mute_audio.mp3");
                Intrinsics.checkNotNullExpressionValue(openFd, "openFd(...)");
                mediaPlayer.setDataSource(openFd);
                mediaPlayer.setLooping(true);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new c(mediaPlayer));
                mediaPlayer.setOnErrorListener(new d());
            } catch (Exception e2) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
                LogExt.j("playMuteAudio error=" + stackTraceToString, "DialogueTranslationViewModel");
            }
        }
    }

    public final void S(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        LogExt.j("playTts tts=" + str, "DialogueTranslationViewModel");
        AudioManager audioManager = this.g;
        if (!(audioManager == null || RomUtils.f6371a.f() || audioManager.getMode() == 3)) {
            int mode = audioManager.getMode();
            LogExt.j("playTts audio mode error[" + mode + "]", "DialogueTranslationViewModel");
            audioManager.setMode(3);
        }
        TtsSdk ttsSdk = TtsSdk.f5490a;
        Bundle bundle = new Bundle();
        bundle.putInt("caller_priority", 0);
        bundle.putInt("disable_bt", 1);
        bundle.putInt("voice_gender", 1);
        bundle.putInt("voice_id_by_language", 1);
        bundle.putString("language", B());
        Unit unit = Unit.INSTANCE;
        ttsSdk.p("DialogueTranslationViewModel", str, 0, bundle, String.valueOf(System.currentTimeMillis()), new e(this));
    }

    public final void V() {
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        boolean z = false;
        if (value != null && value.getCallStatus() == 2) {
            z = true;
        }
        EventTrackingHelper eventTrackingHelper = EventTrackingHelper.f6200a;
        eventTrackingHelper.b(new ClickEvent(z ? 12 : 10, 0, 2, (DefaultConstructorMarker) null));
        if (z) {
            eventTrackingHelper.e(new ClickEvent(12, 0, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void W(int i2) {
        int i3;
        int i4 = i2;
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        boolean z = false;
        if (value != null && value.getCallStatus() == 2) {
            z = true;
        }
        EventTrackingHelper eventTrackingHelper = EventTrackingHelper.f6200a;
        if (i4 != 1) {
            i3 = 4;
            if (i4 != 2 && i4 == 3) {
                i3 = z ? 13 : 11;
            }
        } else {
            i3 = 7;
        }
        eventTrackingHelper.b(new ClickEvent(i3, 0, 2, (DefaultConstructorMarker) null));
        if (z && i4 == 3) {
            eventTrackingHelper.e(new ClickEvent(13, 0, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void Y() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new DialogueTranslationViewModel$resetAudioDevice$1(this, (Continuation<? super DialogueTranslationViewModel$resetAudioDevice$1>) null), 2, (Object) null);
    }

    public final void Z(int i2) {
        TranslateStateManager p;
        if (i2 == 0) {
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 != null) {
                p2.p();
            }
        } else if (i2 == 1) {
            TranslateStateManager p3 = TranslationManager.q.a().p();
            if (p3 != null) {
                p3.r();
            }
        } else if (i2 == 2 && (p = TranslationManager.q.a().p()) != null) {
            p.q();
        }
    }

    public final void a0(TranslationLanguage translationLanguage) {
        LogExt.j("setLanguage transLanguage=" + translationLanguage, "DialogueTranslationViewModel");
        PreferencesUtils.p(3, translationLanguage.getSrc().getLangType(), translationLanguage.getDst().getLangType());
        InterConnectHelper.c.a().B(3, translationLanguage.getSrc().getLangType(), translationLanguage.getDst().getLangType());
    }

    public final void b0() {
        String str;
        String str2;
        LanguageBean dst;
        LanguageBean src;
        PreferencesUtils.A(3);
        LanguageUtils.StoredLanguage g2 = LanguageUtils.g();
        TranslationLanguage translationLanguage = (TranslationLanguage) this.c.getValue();
        if (translationLanguage == null || (src = translationLanguage.getSrc()) == null || (str = src.getLangType()) == null) {
            str = g2.d();
        }
        if (translationLanguage == null || (dst = translationLanguage.getDst()) == null || (str2 = dst.getLangType()) == null) {
            str2 = g2.c();
        }
        TranslationManager.Companion companion = TranslationManager.q;
        TranslateStateManager p = companion.a().p();
        boolean z = false;
        boolean c2 = p != null ? p.c() : false;
        TranslateStateManager p2 = companion.a().p();
        if (p2 != null) {
            z = p2.e();
        }
        if (c2 || z) {
            LogExt.j("startTranslation 翻译服务已启动，开始对话翻译", "DialogueTranslationViewModel");
            NetworkUtils.f6368a.e(this.b, new DialogueTranslationViewModel$startTranslation$1(str, str2));
            return;
        }
        LogExt.j("startTranslation 翻译服务未启动，开始对话翻译", "DialogueTranslationViewModel");
        TranslationApp.startService(this.b);
    }

    public final void c0() {
        LogExt.j("stopMuteAudio", "DialogueTranslationViewModel");
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            } catch (Exception e2) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
                LogExt.j("stopMuteAudio error=" + stackTraceToString, "DialogueTranslationViewModel");
            }
        }
    }

    public final void e0() {
        TtsSdk.u(TtsSdk.f5490a, "DialogueTranslationViewModel", (String) null, 2, (Object) null);
    }

    public final void g0() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new DialogueTranslationViewModel$switchToSpeaker$1(this, (Continuation<? super DialogueTranslationViewModel$switchToSpeaker$1>) null), 2, (Object) null);
    }

    public final void h0() {
        AudioManager audioManager = this.g;
        if (audioManager != null) {
            if (!RomUtils.f6371a.f()) {
                audioManager.setMode(3);
                P();
            } else {
                audioManager.setMode(1);
            }
            audioManager.setSpeakerphoneOn(true);
            t();
        }
    }

    public final void i0() {
        Unit unit;
        Object obj;
        AudioManager audioManager = this.g;
        if (audioManager != null) {
            List a2 = audioManager.getAvailableCommunicationDevices();
            Intrinsics.checkNotNullExpressionValue(a2, "getAvailableCommunicationDevices(...)");
            Iterator it = a2.iterator();
            while (true) {
                unit = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((AudioDeviceInfo) obj).getType() == 2) {
                    break;
                }
            }
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo != null) {
                if (!RomUtils.f6371a.f()) {
                    audioManager.setMode(3);
                    P();
                } else {
                    audioManager.setMode(1);
                }
                boolean a3 = audioManager.setCommunicationDevice(audioDeviceInfo);
                t();
                LogExt.j("switchToSpeaker31 is result=" + a3, "DialogueTranslationViewModel");
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                LogExt.j("switchToSpeaker31 speaker device is null", "DialogueTranslationViewModel");
            }
        }
    }

    public final void j0(int i2) {
        UToast.f6444a.c(this.b, i2, 0);
    }

    public final void k0() {
        SwitchLangHelper.A("DialogueTranslationViewModel");
        Y();
        e0();
        this.g = null;
        MediaPlayer mediaPlayer = this.i;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.i;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        this.i = null;
    }

    public final void l0(LanguageBean languageBean, LanguageBean languageBean2) {
        Intrinsics.checkNotNullParameter(languageBean, "src");
        Intrinsics.checkNotNullParameter(languageBean2, "dst");
        LogExt.g("updateLanguage src=" + languageBean + ", dst=" + languageBean2, "DialogueTranslationViewModel");
        TranslationLanguage translationLanguage = new TranslationLanguage(languageBean, languageBean2);
        O(translationLanguage);
        a0(translationLanguage);
    }

    public final void t() {
        AudioManager audioManager = this.g;
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int i2 = (int) (((double) streamMaxVolume) * 0.6d);
            LogExt.j("adjustVolume current=" + streamVolume + ", max=" + streamMaxVolume + ", new=" + i2, "DialogueTranslationViewModel");
            if (streamVolume < i2) {
                audioManager.setStreamVolume(3, i2, 1);
            }
        }
    }

    public final void v() {
        TranslationLanguage translationLanguage = (TranslationLanguage) this.c.getValue();
        if (translationLanguage != null) {
            LanguageBean languageBean = new LanguageBean(translationLanguage.getSrc().getLangName(), translationLanguage.getSrc().getLangType());
            LanguageBean languageBean2 = new LanguageBean(translationLanguage.getDst().getLangName(), translationLanguage.getDst().getLangType());
            LogExt.g("exchangeLanguage tempSrc=" + languageBean + ", tempDst=" + languageBean2, "DialogueTranslationViewModel");
            TranslationLanguage translationLanguage2 = new TranslationLanguage(languageBean2, languageBean);
            O(translationLanguage2);
            a0(translationLanguage2);
        }
    }

    public final LanguageBean w(String str) {
        return new LanguageBean(LanguageUtils.e(this.b, str), str);
    }

    public final int x(RecyclerView recyclerView) {
        int childAdapterPosition;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int childCount = recyclerView.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt.getVisibility() != 8 && (childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) >= i2) {
                i2 = childAdapterPosition;
            }
        }
        return i2;
    }

    public final LiveData y() {
        return this.e;
    }
}
