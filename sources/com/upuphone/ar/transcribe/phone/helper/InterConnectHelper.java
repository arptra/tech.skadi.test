package com.upuphone.ar.transcribe.phone.helper;

import android.content.Context;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.TransInterConnectManager;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectMessage;
import com.upuphone.ar.transcribe.interconnect.entity.OpenScene;
import com.upuphone.ar.transcribe.interconnect.entity.PreTranslationEntity;
import com.upuphone.ar.transcribe.interconnect.entity.RecordStateEntity;
import com.upuphone.ar.transcribe.interconnect.entity.ScreenState;
import com.upuphone.ar.transcribe.interconnect.entity.StartTrans;
import com.upuphone.ar.transcribe.interconnect.entity.TranslationStateEntity;
import com.upuphone.ar.transcribe.interconnect.listener.OnInterConnectMsgListener;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.bean.OperateMessage;
import com.upuphone.ar.transcribe.utils.GsonUtils;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import com.upuphone.ar.transcribe.utils.LanguageUtils;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006*\u0001S\u0018\u0000 42\u00020\u0001:\u0002VWB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u0003J+\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0003J\u0015\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010\u0018J)\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010\u000bJ\u0015\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b-\u0010\u000bJ\u0015\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\b¢\u0006\u0004\b/\u0010\u000bJ\r\u00100\u001a\u00020\u0004¢\u0006\u0004\b0\u0010\u0003J\r\u00101\u001a\u00020\u0012¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b6\u0010\u001dJ\u0015\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J!\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b=\u0010>J%\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0004H\u0007¢\u0006\u0004\bD\u0010\u0003J\u000f\u0010E\u001a\u00020\u0004H\u0007¢\u0006\u0004\bE\u0010\u0003J%\u0010F\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b¢\u0006\u0004\bF\u0010CJ\r\u0010G\u001a\u00020\u0004¢\u0006\u0004\bG\u0010\u0003J0\u0010M\u001a\u00020\u00042!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u00040H¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u0004¢\u0006\u0004\bO\u0010\u0003R\u0018\u0010R\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010T¨\u0006X"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper;", "Lcom/upuphone/ar/transcribe/interconnect/listener/OnInterConnectMsgListener;", "<init>", "()V", "", "j", "E", "b", "", "data", "g", "(Ljava/lang/String;)V", "", "bytes", "", "channel", "d", "([BI)V", "", "isWechatReply", "h", "(Z)V", "callState", "e", "(I)V", "f", "Landroid/content/Context;", "context", "i", "(Landroid/content/Context;)V", "D", "msgCmd", "onInterConnectMessage", "(ILjava/lang/String;[B)V", "onRemoteDie", "recordState", "m", "transState", "extCode", "Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "extData", "r", "(IILcom/xjsd/xr/sapp/asr/dao/TtsData;)V", "transResultJson", "n", "l", "state", "o", "q", "k", "()Z", "Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectDevice;", "c", "()Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectDevice;", "B", "Lcom/upuphone/ar/transcribe/interconnect/entity/PreTranslationEntity;", "preTranslationEntity", "C", "(Lcom/upuphone/ar/transcribe/interconnect/entity/PreTranslationEntity;)V", "Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectMessage;", "message", "w", "(Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectMessage;[B)V", "translationType", "srcLang", "dstLang", "z", "(ILjava/lang/String;Ljava/lang/String;)V", "y", "v", "A", "p", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAgree", "callBack", "t", "(Lkotlin/jvm/functions/Function1;)V", "u", "a", "Landroid/content/Context;", "mContext", "com/upuphone/ar/transcribe/phone/helper/InterConnectHelper$mOnDeviceConnectedListener$1", "Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper$mOnDeviceConnectedListener$1;", "mOnDeviceConnectedListener", "Companion", "SingleHolder", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class InterConnectHelper implements OnInterConnectMsgListener {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Context f6099a;
    public final InterConnectHelper$mOnDeviceConnectedListener$1 b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper;", "a", "()Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper;", "", "TAG", "Ljava/lang/String;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InterConnectHelper a() {
            return SingleHolder.f6100a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper;", "b", "Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper;", "a", "()Lcom/upuphone/ar/transcribe/phone/helper/InterConnectHelper;", "instance", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f6100a = new SingleHolder();
        public static final InterConnectHelper b = new InterConnectHelper((DefaultConstructorMarker) null);

        public final InterConnectHelper a() {
            return b;
        }
    }

    public /* synthetic */ InterConnectHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void s(InterConnectHelper interConnectHelper, int i, int i2, TtsData ttsData, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            ttsData = null;
        }
        interConnectHelper.r(i, i2, ttsData);
    }

    public static /* synthetic */ void x(InterConnectHelper interConnectHelper, InterConnectMessage interConnectMessage, byte[] bArr, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        interConnectHelper.w(interConnectMessage, bArr);
    }

    public final void A(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "srcLang");
        Intrinsics.checkNotNullParameter(str2, "dstLang");
        LogExt.g("[passTranslateLanguageSet type: " + i + ", src: " + str + ", dst: " + str2 + "]", "InterConnectHelper");
        x(this, new InterConnectMessage(60, JsonUtils.b(new StartTrans(i, str, str2, false, 0, false, false, 120, (DefaultConstructorMarker) null))), (byte[]) null, 2, (Object) null);
    }

    public final void B(Context context) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        LanguageUtils.StoredLanguage c2 = LanguageUtils.c(context2, false, false, 6, (Object) null);
        String a2 = c2.a();
        String a3 = c2.a();
        TranscribeConstants transcribeConstants = TranscribeConstants.f6027a;
        if (transcribeConstants.h()) {
            a2 = "cn";
            a3 = "cnen";
        }
        C(new PreTranslationEntity(1, a2, a3, PreferencesUtils.g(context), PreferencesUtils.f(context), PreferencesUtils.b(context) ? 1 : 2, transcribeConstants.m() ? 2 : 1, PreferencesUtils.f6190a.e(context2), 0, 256, (DefaultConstructorMarker) null));
    }

    public final void C(PreTranslationEntity preTranslationEntity) {
        String str;
        Intrinsics.checkNotNullParameter(preTranslationEntity, "preTranslationEntity");
        Context context = this.f6099a;
        if (context == null || (str = context.getString(R.string.transcribe_app_name)) == null) {
            str = "";
        }
        OpenScene openScene = new OpenScene(DDAuthConstant.AUTH_LOGIN_TYPE_APP, new OpenScene.Data("open_app", FastRecordMainViewModel.RECORD_TYPE_SCENE, "com.upuphone.ar.transcribe.glasses", str, JsonUtils.b(preTranslationEntity), (OpenScene.Data.Size) null, 32, (DefaultConstructorMarker) null));
        LogExt.g("转写启动： 手机发送打开眼镜端转写消息 startLauncherScene", "InterConnectHelper");
        TransInterConnectManager.y.a().x(openScene, (byte[]) null);
    }

    public final void D() {
        LogExt.g("转写退出: 互联消息 注销", "InterConnectHelper");
        this.f6099a = null;
        E();
    }

    public final void E() {
        LogExt.g("unInitInterConnect: 互联解除注册", "InterConnectHelper");
        TransInterConnectManager.Companion companion = TransInterConnectManager.y;
        companion.a().H();
        companion.a().I();
        companion.a().G();
    }

    public final void b() {
        Context context = this.f6099a;
        if (context != null) {
            TranscribeApp.stopService(context);
            TranscribeApp.notifyVariousMsg(new OperateMessage(7));
        }
    }

    public final InterConnectDevice c() {
        return TransInterConnectManager.y.a().k();
    }

    public final void d(byte[] bArr, int i) {
        LogExt.b("接收到眼镜发过来的原始数据: " + i, "InterConnectHelper", "handleRemoteAudio", 20, true);
        if (bArr != null) {
            BleAudioManager.g.a().f(bArr, i);
        }
    }

    public final void e(int i) {
        String a2 = InterconnectMsgCodExtKt.a(i);
        LogExt.g("handlePhoneInCall callState=" + a2, "InterConnectHelper");
        if (i == 0) {
            TranscribeManager.j.a().h().v();
        } else if (i == 1) {
            TranscribeManager.j.a().h().x();
        } else if (i == 2) {
            TranscribeManager.j.a().h().w();
        }
    }

    public final void f(String str) {
        Unit unit;
        if (str != null) {
            try {
                LogExt.g("handleScreenState data=" + str, "InterConnectHelper");
                int state = ((ScreenState) GsonUtils.a(str, ScreenState.class)).getState();
                if (state >= 0 && state < 3) {
                    TranscribeManager.j.a().h().t(state);
                }
                unit = Unit.INSTANCE;
            } catch (Exception e) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                LogExt.e("handleScreenState parse data error=" + stackTraceToString, "InterConnectHelper");
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.d("handleScreenState data is null", "InterConnectHelper");
        }
    }

    public final void g(String str) {
        LogExt.g("handleStartTrans data:: " + str, "InterConnectHelper");
        if (str != null) {
            try {
                if (!StringsKt.isBlank(str)) {
                    StartTrans startTrans = (StartTrans) GsonUtils.a(str, StartTrans.class);
                    TranscribeManager.Companion companion = TranscribeManager.j;
                    boolean i = companion.a().h().i();
                    boolean l = companion.a().h().l();
                    LogExt.g("handleStartTrans startTrans:: " + startTrans + ", notStartTransState:: " + i + ", runningState:: " + l, "InterConnectHelper");
                    if (!startTrans.getPhoneInitFinish() || i) {
                        if (!l) {
                            companion.a().s(startTrans.getTransType());
                            e(startTrans.getCallState());
                            h(startTrans.getWechatReply());
                            companion.a().h().d().t(startTrans);
                        }
                        companion.a().h().E();
                    }
                }
            } catch (Exception e) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                LogExt.g("handleStartTrans error:: " + stackTraceToString, "InterConnectHelper");
            }
        }
    }

    public final void h(boolean z) {
        if (z) {
            TranscribeManager.j.a().h().O();
        } else {
            TranscribeManager.j.a().h().N();
        }
    }

    public final void i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.g("转写启动: 互联消息 初始化", "InterConnectHelper");
        this.f6099a = context;
        j();
    }

    public final void j() {
        TransInterConnectManager.Companion companion = TransInterConnectManager.y;
        if (companion.a().u()) {
            LogExt.g("转写启动: 互联互通异常注册", "InterConnectHelper");
            return;
        }
        LogExt.g("转写启动: 互联注册消息回调", "InterConnectHelper");
        companion.a().p((Context) null, "com.upuphone.ar.transcribe.phone", "com.upuphone.ar.transcribe.glasses");
        companion.a().y(this.b);
        companion.a().z(this);
        companion.a().A(this);
    }

    public final boolean k() {
        return TransInterConnectManager.y.a().t();
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "transResultJson");
        x(this, new InterConnectMessage(54, str), (byte[]) null, 2, (Object) null);
    }

    public final void m(int i) {
        String c2 = InterconnectMsgCodExtKt.c(i);
        LogExt.g("passRecordState recordState[" + i + ", " + c2 + "]", "InterConnectHelper");
        x(this, new InterConnectMessage(51, JsonUtils.b(new RecordStateEntity(i))), (byte[]) null, 2, (Object) null);
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "transResultJson");
        x(this, new InterConnectMessage(53, str), (byte[]) null, 2, (Object) null);
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        LogExt.g("passServerRunningState state=" + str, "InterConnectHelper");
        x(this, new InterConnectMessage(55, str), (byte[]) null, 2, (Object) null);
    }

    public void onInterConnectMessage(int i, String str, byte[] bArr) {
        if (!(i == 4 || i == 3)) {
            String b2 = InterconnectMsgCodExtKt.b(i);
            LogExt.g("onInterConnectMessage: msgCmd[" + i + ", " + b2 + "], data=" + str, "InterConnectHelper");
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
                d(bArr2, 1);
            } else if (i == 4) {
                if (bArr != null) {
                    bArr2 = Arrays.copyOf(bArr, bArr.length);
                    Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
                }
                d(bArr2, 0);
            } else if (i == 11) {
                TranscribeApp.notifyVariousMsg(new OperateMessage(11));
            } else if (i != 12) {
                switch (i) {
                    case 14:
                        TranscribeManager.j.a().h().M();
                        return;
                    case 15:
                        TranscribeManager.j.a().h().I();
                        return;
                    case 16:
                        h(true);
                        return;
                    case 17:
                        h(false);
                        return;
                    case 18:
                        e(2);
                        return;
                    case 19:
                        e(0);
                        return;
                    case 20:
                        e(1);
                        return;
                    case 21:
                        f(str);
                        return;
                    default:
                        String b3 = InterconnectMsgCodExtKt.b(i);
                        LogExt.g("异常的互联互通消息指令！msgCmd[" + i + ", " + b3 + "]", "InterConnectHelper");
                        return;
                }
            } else {
                TranscribeApp.notifyVariousMsg(new OperateMessage(12));
            }
        } else {
            Context context = this.f6099a;
            if (context != null) {
                TranscribeApp.stopService(context);
                TranscribeApp.notifyVariousMsg(new OperateMessage(7));
            }
        }
    }

    public void onRemoteDie() {
        LogExt.d("对端转写已经退出(非正常退出)", "InterConnectHelper");
        b();
    }

    public final void p() {
        Context context = this.f6099a;
        if (context != null) {
            LogExt.g("transSettingsToGlass 同步设置项到眼镜", "InterConnectHelper");
            LanguageUtils.StoredLanguage c2 = LanguageUtils.c(context, false, false, 6, (Object) null);
            A(1, c2.a(), c2.a());
            Unit unit = Unit.INSTANCE;
        }
        LogExt.d("transSettingsToGlass context is null", "InterConnectHelper");
    }

    public final void q() {
        x(this, new InterConnectMessage(68, (String) null, 2, (DefaultConstructorMarker) null), (byte[]) null, 2, (Object) null);
    }

    public final void r(int i, int i2, TtsData ttsData) {
        Context context;
        String e = InterconnectMsgCodExtKt.e(i);
        String d = InterconnectMsgCodExtKt.d(i2);
        LogExt.g("passTranslationState transState[" + i + ", " + e + "], extCode[" + i2 + ", " + d + "]", "InterConnectHelper");
        if (ttsData != null) {
            w(new InterConnectMessage(52, JsonUtils.b(new TranslationStateEntity(i, i2, Long.valueOf(ttsData.getTime())))), ttsData.getTts());
        } else {
            x(this, new InterConnectMessage(52, JsonUtils.b(new TranslationStateEntity(i, i2, (Long) null, 4, (DefaultConstructorMarker) null))), (byte[]) null, 2, (Object) null);
        }
        if (i == 3 && i2 == -1 && (context = this.f6099a) != null) {
            LogExt.g("passTranslationState close assistant", "InterConnectHelper");
            TranscribeApp.closeAssistant(context);
        }
    }

    public final void t(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        TransInterConnectManager.y.a().B(function1);
    }

    public final void u() {
        TransInterConnectManager.y.a().C();
    }

    public final void v() {
        LogExt.g("[sendDialogDismiss]", "InterConnectHelper");
        x(this, new InterConnectMessage(63, (String) null, 2, (DefaultConstructorMarker) null), (byte[]) null, 2, (Object) null);
    }

    public final void w(InterConnectMessage interConnectMessage, byte[] bArr) {
        Intrinsics.checkNotNullParameter(interConnectMessage, "message");
        if (!(interConnectMessage.getMsgCmd() == 53 || interConnectMessage.getMsgCmd() == 54)) {
            LogExt.g("sendMessage: " + interConnectMessage, "InterConnectHelper");
        }
        TransInterConnectManager.y.a().D(interConnectMessage, bArr);
    }

    public final void y() {
        LogExt.g("[sendSaveSuccess]", "InterConnectHelper");
        x(this, new InterConnectMessage(66, (String) null, 2, (DefaultConstructorMarker) null), (byte[]) null, 2, (Object) null);
    }

    public final void z(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "srcLang");
        Intrinsics.checkNotNullParameter(str2, "dstLang");
        LogExt.g("[sendStartTranslate transType=" + i + ", src=" + str + ", dst=" + str2 + "]", "InterConnectHelper");
        x(this, new InterConnectMessage(61, JsonUtils.b(new StartTrans(i, str, str2, false, 0, false, false, 120, (DefaultConstructorMarker) null))), (byte[]) null, 2, (Object) null);
    }

    public InterConnectHelper() {
        this.b = new InterConnectHelper$mOnDeviceConnectedListener$1(this);
    }
}
