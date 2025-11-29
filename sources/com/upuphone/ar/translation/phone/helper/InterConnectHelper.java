package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.TransInterConnectManager;
import com.upuphone.ar.translation.interconnect.entity.InitPhone2GlassInfo;
import com.upuphone.ar.translation.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.translation.interconnect.entity.InterConnectMessage;
import com.upuphone.ar.translation.interconnect.entity.OpenScene;
import com.upuphone.ar.translation.interconnect.entity.RecordState;
import com.upuphone.ar.translation.interconnect.entity.ScreenState;
import com.upuphone.ar.translation.interconnect.entity.StartTrans;
import com.upuphone.ar.translation.interconnect.entity.SubTitleSetType;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.interconnect.listener.OnInterConnectMsgListener;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006*\u0001W\u0018\u0000 \u00142\u00020\u0001:\u0002Z[B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\u0003J\u0015\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0012¢\u0006\u0004\b*\u0010\u0015J)\u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J!\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b4\u00103J\u0015\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0004¢\u0006\u0004\b6\u0010\bJ\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b7\u0010\u0003J\u0015\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0012¢\u0006\u0004\b9\u0010\u0015J%\u0010=\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0007¢\u0006\u0004\b?\u0010\u0003J\u000f\u0010@\u001a\u00020\u0006H\u0007¢\u0006\u0004\b@\u0010\u0003J%\u0010A\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004¢\u0006\u0004\bA\u0010>J\r\u0010B\u001a\u00020\u0006¢\u0006\u0004\bB\u0010\u0003J\r\u0010C\u001a\u00020\u0006¢\u0006\u0004\bC\u0010\u0003J0\u0010I\u001a\u00020\u00062!\u0010H\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00060D¢\u0006\u0004\bI\u0010JJ2\u0010K\u001a\u00020\u00062#\b\u0002\u0010H\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00060D¢\u0006\u0004\bK\u0010JJ\r\u0010L\u001a\u00020\u000e¢\u0006\u0004\bL\u0010\u001cJ\u000f\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\bN\u0010OJ+\u0010Q\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0006H\u0016¢\u0006\u0004\bS\u0010\u0003R\u0018\u0010V\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010X¨\u0006\\"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper;", "Lcom/upuphone/ar/translation/interconnect/listener/OnInterConnectMsgListener;", "<init>", "()V", "", "data", "", "g", "(Ljava/lang/String;)V", "", "bytes", "d", "([B)V", "e", "", "isWechatReply", "h", "(Z)V", "", "callState", "c", "(I)V", "f", "Lcom/upuphone/ar/translation/interconnect/entity/InitPhone2GlassInfo;", "phone2GlassInfo", "D", "(Lcom/upuphone/ar/translation/interconnect/entity/InitPhone2GlassInfo;)V", "k", "()Z", "E", "Lcom/upuphone/ar/translation/interconnect/entity/InterConnectMessage;", "message", "w", "(Lcom/upuphone/ar/translation/interconnect/entity/InterConnectMessage;)V", "x", "(Lcom/upuphone/ar/translation/interconnect/entity/InterConnectMessage;[B)V", "Landroid/content/Context;", "context", "i", "(Landroid/content/Context;)V", "F", "recordState", "m", "transState", "extCode", "", "extData", "r", "(IILjava/lang/Object;)V", "transResultJson", "n", "(Ljava/lang/String;[B)V", "l", "state", "o", "q", "subtitleSetType", "A", "translationType", "srcLang", "dstLang", "z", "(ILjava/lang/String;Ljava/lang/String;)V", "y", "v", "B", "C", "p", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAgree", "callBack", "t", "(Lkotlin/jvm/functions/Function1;)V", "u", "j", "Lcom/upuphone/ar/translation/interconnect/entity/InterConnectDevice;", "b", "()Lcom/upuphone/ar/translation/interconnect/entity/InterConnectDevice;", "msgCmd", "onInterConnectMessage", "(ILjava/lang/String;[B)V", "onRemoteDie", "a", "Landroid/content/Context;", "mContext", "com/upuphone/ar/translation/phone/helper/InterConnectHelper$mOnDeviceConnectedListener$1", "Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper$mOnDeviceConnectedListener$1;", "mOnDeviceConnectedListener", "Companion", "SingleHolder", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class InterConnectHelper implements OnInterConnectMsgListener {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Context f6296a;
    public final InterConnectHelper$mOnDeviceConnectedListener$1 b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper;", "a", "()Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InterConnectHelper a() {
            return SingleHolder.f6297a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper;", "b", "Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper;", "a", "()Lcom/upuphone/ar/translation/phone/helper/InterConnectHelper;", "instance", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f6297a = new SingleHolder();
        public static final InterConnectHelper b = new InterConnectHelper((DefaultConstructorMarker) null);

        public final InterConnectHelper a() {
            return b;
        }
    }

    public /* synthetic */ InterConnectHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void s(InterConnectHelper interConnectHelper, int i, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            obj = null;
        }
        interConnectHelper.r(i, i2, obj);
    }

    public final void A(int i) {
        String h = InterconnectMsgCodExtKt.h(i);
        LogExt.j("sendSubtitleSetType type" + h, "InterConnectHelper");
        w(new InterConnectMessage(58, JsonUtils.d(new SubTitleSetType(i))));
    }

    public final void B(int i, String str, String str2) {
        String str3;
        String str4;
        int i2 = i;
        String str5 = str;
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str5, "srcLang");
        Intrinsics.checkNotNullParameter(str6, "dstLang");
        if (i2 == 1 || !TranslatorConstants.isMicroSoftAsr()) {
            str4 = str5;
            str3 = str6;
        } else {
            String str7 = "en";
            String str8 = Intrinsics.areEqual((Object) str5, (Object) "cnen") ? str7 : str5;
            if (!Intrinsics.areEqual((Object) str6, (Object) "cnen")) {
                str7 = str6;
            }
            String k = InterconnectMsgCodExtKt.k(i);
            LogExt.j("sendTranslateLanguageSet update type=" + k + ", src=" + str8 + ", dst=" + str7, "InterConnectHelper");
            str4 = str8;
            str3 = str7;
        }
        if (i2 == 3 && k()) {
            i2 = 4;
        }
        int i3 = i2;
        String k2 = InterconnectMsgCodExtKt.k(i3);
        LogExt.j("sendTranslateLanguageSet type" + k2 + ", src=" + str5 + ", dst=" + str6, "InterConnectHelper");
        w(new InterConnectMessage(60, JsonUtils.d(new StartTrans(i3, str4, str3, false, 0, false, 0, 120, (DefaultConstructorMarker) null))));
    }

    public final void C() {
        String str;
        String str2;
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        int m = PreferencesUtils.m();
        if (m == 1) {
            str = g.e();
            str2 = g.e();
        } else if (m == 2) {
            str = g.d();
            str2 = g.c();
        } else if (m != 3) {
            str = g.d();
            str2 = g.c();
        } else {
            str = g.b();
            str2 = g.a();
        }
        if (TranslatorConstants.isAirOldLanguage()) {
            str = "cn";
            str2 = "cnen";
        }
        String str3 = str2;
        String str4 = str;
        if (m == 3 && k()) {
            m = 4;
        }
        D(new InitPhone2GlassInfo(TranslationApp.isStartServiceToPhone$ar_translator_intlRelease() ? Integer.valueOf(m) : null, str4, str3, PreferencesUtils.n(), PreferencesUtils.c() ? 1 : 2, TranslatorConstants.isIntlVersion() ? 2 : 1, 0, 64, (DefaultConstructorMarker) null));
    }

    public final void D(InitPhone2GlassInfo initPhone2GlassInfo) {
        String str;
        Context context = this.f6296a;
        if (context == null || (str = context.getString(R.string.translation_app_name)) == null) {
            str = "";
        }
        OpenScene openScene = new OpenScene(DDAuthConstant.AUTH_LOGIN_TYPE_APP, new OpenScene.Data("open_app", FastRecordMainViewModel.RECORD_TYPE_SCENE, AssistantConstants.PKG_NAME_TRANSLATION, str, JsonUtils.d(initPhone2GlassInfo), (OpenScene.Data.Size) null, 32, (DefaultConstructorMarker) null));
        LogExt.j("startLauncherScene " + initPhone2GlassInfo, "InterConnectHelper");
        TransInterConnectManager.y.a().z(openScene, (byte[]) null);
    }

    public final void E() {
        Context context = this.f6296a;
        if (context != null) {
            TranslationApp.stopService(context);
            TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(7));
        }
    }

    public final void F() {
        LogExt.j("[unInit] 释放互联工具类", "InterConnectHelper");
        this.f6296a = null;
        TransInterConnectManager.Companion companion = TransInterConnectManager.y;
        companion.a().K();
        companion.a().L();
        companion.a().J();
    }

    public final InterConnectDevice b() {
        return TransInterConnectManager.y.a().l();
    }

    public final void c(int i) {
        TranslateStateManager p;
        String a2 = InterconnectMsgCodExtKt.a(i);
        LogExt.j("handlePhoneCallState state" + a2, "InterConnectHelper");
        if (i == 0) {
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 != null) {
                p2.p();
            }
        } else if (i == 1) {
            TranslateStateManager p3 = TranslationManager.q.a().p();
            if (p3 != null) {
                p3.r();
            }
        } else if (i == 2 && (p = TranslationManager.q.a().p()) != null) {
            p.q();
        }
    }

    public final void d(byte[] bArr) {
        LogExt.f("Glass audio[Proximal]", "InterConnectHelper", "handleProximalAudio", 0, 4, (Object) null);
        if (bArr != null) {
            TelephoneTransHelper telephoneTransHelper = TelephoneTransHelper.f6305a;
            if (telephoneTransHelper.A()) {
                telephoneTransHelper.p(bArr);
            }
        }
    }

    public final void e(byte[] bArr) {
        LogExt.f("Glass audio[Remote]", "InterConnectHelper", "handleRemoteAudio", 0, 4, (Object) null);
        if (bArr != null) {
            TelephoneTransHelper telephoneTransHelper = TelephoneTransHelper.f6305a;
            if (telephoneTransHelper.A()) {
                telephoneTransHelper.q(bArr);
            } else {
                BleAudioHelper.f6295a.l(bArr);
            }
        }
    }

    public final void f(String str) {
        Unit unit;
        TranslateStateManager p;
        if (str != null) {
            try {
                LogExt.j("handleScreenState data=" + str, "InterConnectHelper");
                int state = ((ScreenState) GsonUtils.a(str, ScreenState.class)).getState();
                if (state >= 0 && state < 3 && (p = TranslationManager.q.a().p()) != null) {
                    p.o(state);
                }
                unit = Unit.INSTANCE;
            } catch (Exception e) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                LogExt.h("handleScreenState error=" + stackTraceToString, "InterConnectHelper");
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.j("handleScreenState data is null", "InterConnectHelper");
        }
    }

    public final void g(String str) {
        Unit unit;
        XunFeiChannelHandler a2;
        if (str != null) {
            try {
                StartTrans startTrans = (StartTrans) GsonUtils.a(str, StartTrans.class);
                TranslationManager.Companion companion = TranslationManager.q;
                TranslateStateManager p = companion.a().p();
                boolean z = false;
                boolean e = p != null ? p.e() : false;
                TranslateStateManager p2 = companion.a().p();
                if (p2 != null) {
                    z = p2.h();
                }
                LogExt.j("handleStartTrans startTrans=" + startTrans + ", notStartTransState=" + e + ", runningState=" + z, "InterConnectHelper");
                if (!startTrans.getPhoneInitFinish() || e) {
                    if (!z) {
                        int transType = startTrans.getTransType();
                        if (transType == 4) {
                            transType = 3;
                        }
                        int i = transType;
                        PreferencesUtils.A(i);
                        if (startTrans.getCallState() != 0) {
                            c(startTrans.getCallState());
                        }
                        if (startTrans.getWechatReply()) {
                            h(true);
                        }
                        GlassVersionHelper.INSTANCE.setGlassVersionCode(startTrans.getVersionCode());
                        TranslateStateManager p3 = companion.a().p();
                        if (!(p3 == null || (a2 = p3.a()) == null)) {
                            a2.H(new StartTrans(i, startTrans.getSrc(), startTrans.getDst(), false, 0, false, 0, 120, (DefaultConstructorMarker) null));
                        }
                    }
                    TranslateStateManager p4 = companion.a().p();
                    if (p4 != null) {
                        p4.y();
                    }
                }
                unit = Unit.INSTANCE;
            } catch (Exception e2) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
                LogExt.j("handleStartTrans error=" + stackTraceToString, "InterConnectHelper");
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.j("handleStartTrans data is null", "InterConnectHelper");
        }
    }

    public final void h(boolean z) {
        if (z) {
            TranslateStateManager p = TranslationManager.q.a().p();
            if (p != null) {
                p.I();
                return;
            }
            return;
        }
        TranslateStateManager p2 = TranslationManager.q.a().p();
        if (p2 != null) {
            p2.H();
        }
    }

    public final void i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.j("[init] 初始化互联工具类", "InterConnectHelper");
        this.f6296a = context;
        TransInterConnectManager.Companion companion = TransInterConnectManager.y;
        companion.a().r((Context) null, "com.upuphone.ar.translation.phone", AssistantConstants.PKG_NAME_TRANSLATION);
        companion.a().A(this.b);
        companion.a().B(this);
        companion.a().C(this);
    }

    public final boolean j() {
        return TransInterConnectManager.y.a().v();
    }

    public final boolean k() {
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        return value != null && value.getCallStatus() == 2;
    }

    public final void l(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "transResultJson");
        x(new InterConnectMessage(54, str), bArr);
    }

    public final void m(int i) {
        String f = InterconnectMsgCodExtKt.f(i);
        LogExt.j("passRecordState state" + f, "InterConnectHelper");
        w(new InterConnectMessage(51, JsonUtils.d(new RecordState(i))));
    }

    public final void n(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "transResultJson");
        x(new InterConnectMessage(53, str), bArr);
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        LogExt.j("passServerRunningState state=" + str, "InterConnectHelper");
        w(new InterConnectMessage(55, str));
    }

    public void onInterConnectMessage(int i, String str, byte[] bArr) {
        if (!(i == 4 || i == 3)) {
            String e = InterconnectMsgCodExtKt.e(i);
            LogExt.j("onInterConnectMessage msgCmd" + e + ", data=" + str, "InterConnectHelper");
        }
        if (i == 1) {
            g(str);
        } else if (i != 7) {
            byte[] bArr2 = null;
            if (i == 3) {
                if (bArr != null) {
                    bArr2 = Arrays.copyOf(bArr, bArr.length);
                    Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
                }
                d(bArr2);
            } else if (i == 4) {
                if (bArr != null) {
                    bArr2 = Arrays.copyOf(bArr, bArr.length);
                    Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
                }
                e(bArr2);
            } else if (i == 11) {
                TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(11));
            } else if (i != 12) {
                switch (i) {
                    case 14:
                    case 15:
                        return;
                    case 16:
                        h(true);
                        return;
                    case 17:
                        h(false);
                        return;
                    case 18:
                        c(2);
                        return;
                    case 19:
                        c(0);
                        return;
                    case 20:
                        c(1);
                        return;
                    case 21:
                        f(str);
                        return;
                    default:
                        String e2 = InterconnectMsgCodExtKt.e(i);
                        LogExt.j("异常的互联互通消息指令！msgCmd" + e2, "InterConnectHelper");
                        return;
                }
            } else {
                TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(12));
            }
        } else {
            E();
        }
    }

    public void onRemoteDie() {
        LogExt.j("onRemoteDie 眼镜翻译异常退出", "InterConnectHelper");
        E();
    }

    public final void p() {
        LogExt.j("passSettingsToGlass 同步设置项到眼镜", "InterConnectHelper");
        A(PreferencesUtils.n());
    }

    public final void q() {
        w(new InterConnectMessage(68, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void r(int i, int i2, Object obj) {
        Context context;
        String j = InterconnectMsgCodExtKt.j(i);
        String i3 = InterconnectMsgCodExtKt.i(i2);
        LogExt.j("passTranslationState transState" + j + ", extCode" + i3, "InterConnectHelper");
        if (obj == null || !(obj instanceof TtsData)) {
            w(new InterConnectMessage(52, JsonUtils.d(new TranslationState(i, i2, (Long) null, 4, (DefaultConstructorMarker) null))));
        } else {
            TtsData ttsData = (TtsData) obj;
            x(new InterConnectMessage(52, JsonUtils.d(new TranslationState(i, i2, Long.valueOf(ttsData.getTime())))), ttsData.getTts());
        }
        if (i == 3 && i2 == -1 && (context = this.f6296a) != null) {
            LogExt.j("passTranslationState close assistant", "InterConnectHelper");
            TranslationApp.closeAssistant$ar_translator_intlRelease(context);
        }
    }

    public final void t(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        TransInterConnectManager.y.a().D(function1);
    }

    public final void u(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        TransInterConnectManager.y.a().E(function1);
    }

    public final void v() {
        LogExt.j("[sendDialogDismiss]", "InterConnectHelper");
        w(new InterConnectMessage(63, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void w(InterConnectMessage interConnectMessage) {
        if (!(interConnectMessage.getMsgCmd() == 53 || interConnectMessage.getMsgCmd() == 54)) {
            LogExt.j("sendMessage=" + interConnectMessage, "InterConnectHelper");
        }
        TransInterConnectManager.y.a().F(interConnectMessage);
    }

    public final void x(InterConnectMessage interConnectMessage, byte[] bArr) {
        TransInterConnectManager.y.a().G(interConnectMessage, bArr);
    }

    public final void y() {
        LogExt.j("[sendSaveSuccess]", "InterConnectHelper");
        w(new InterConnectMessage(66, (String) null, 2, (DefaultConstructorMarker) null));
        PreferencesUtils preferencesUtils = PreferencesUtils.f6369a;
        if (!preferencesUtils.a()) {
            TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(66));
            preferencesUtils.o(true);
        }
    }

    public final void z(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "srcLang");
        Intrinsics.checkNotNullParameter(str2, "dstLang");
        if (i == 3 && k()) {
            i = 4;
        }
        int i2 = i;
        String k = InterconnectMsgCodExtKt.k(i2);
        LogExt.j("sendStartTranslate transType" + k + ", src=" + str + ", dst=" + str2, "InterConnectHelper");
        w(new InterConnectMessage(61, JsonUtils.d(new StartTrans(i2, str, str2, false, 0, false, 0, 120, (DefaultConstructorMarker) null))));
    }

    public InterConnectHelper() {
        this.b = new InterConnectHelper$mOnDeviceConnectedListener$1(this);
    }
}
