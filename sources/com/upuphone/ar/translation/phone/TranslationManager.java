package com.upuphone.ar.translation.phone;

import android.content.Context;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.audio.thread.ThreadPollHelper;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.FuncEndEvent;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.TempStorageTransResult;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.helper.BleAudioHelper;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.NoteSyncHelper;
import com.upuphone.ar.translation.phone.helper.RecordTitleHelper;
import com.upuphone.ar.translation.phone.helper.RunningRecordHelper;
import com.upuphone.ar.translation.phone.helper.TelephoneTransHelper;
import com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec;
import com.upuphone.ar.translation.phone.network.NetworkConnectManager;
import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0003\n\u0002\b\u0006*\u0002lo\u0018\u0000 @2\u00020\u0001:\u0002rsB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u000fJ\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b$\u0010#J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b(\u0010#J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b)\u0010#J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0001H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0001H\u0002¢\u0006\u0004\b0\u0010/J\u001f\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0002¢\u0006\u0004\b4\u00105J'\u00107\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00106\u001a\u00020\u001fH\u0002¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0002¢\u0006\u0004\b9\u00105J7\u0010>\u001a\u00020=2\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00106\u001a\u00020\u001f2\u0006\u0010<\u001a\u000201H\u0002¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020=2\u0006\u0010;\u001a\u0002012\u0006\u00103\u001a\u000201H\u0002¢\u0006\u0004\b@\u0010AJ'\u0010E\u001a\u00020\u00062\b\b\u0002\u0010B\u001a\u0002012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060CH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010\tR\u0016\u0010R\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010[R\u0018\u0010a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u00104R\u0016\u0010g\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010QR\u0016\u0010h\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010QR\u0016\u0010i\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010QR\u0018\u0010k\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010jR\u0014\u0010n\u001a\u00020l8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010mR\u0014\u0010q\u001a\u00020o8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010p¨\u0006t"}, d2 = {"Lcom/upuphone/ar/translation/phone/TranslationManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "w", "(Landroid/content/Context;)V", "J", "Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;", "p", "()Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;", "", "z", "()Z", "Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec;", "n", "()Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec;", "l", "y", "Lcom/upuphone/ar/translation/phone/helper/RunningRecordHelper;", "o", "()Lcom/upuphone/ar/translation/phone/helper/RunningRecordHelper;", "Lcom/upuphone/ar/translation/phone/helper/RecordTitleHelper;", "m", "()Lcom/upuphone/ar/translation/phone/helper/RecordTitleHelper;", "isBroadcastTts", "H", "(Z)V", "x", "", "state", "expCode", "v", "(II)V", "C", "", "B", "()Ljava/util/List;", "E", "D", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "s", "(I)Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "obj", "u", "(Ljava/lang/Object;)V", "t", "", "result", "resultMark", "I", "(Ljava/lang/String;Ljava/lang/String;)V", "transType", "F", "(Ljava/lang/String;Ljava/lang/String;I)V", "G", "finalSrc", "content", "recognizeId", "Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "r", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "q", "(Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "name", "Lkotlin/Function0;", "callback", "A", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lkotlinx/coroutines/CoroutineScope;", "k", "()Lkotlinx/coroutines/CoroutineScope;", "a", "Landroid/content/Context;", "appContext", "", "b", "mTransFuncStartTime", "c", "Z", "mIsTelephoneTrans", "d", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager;", "e", "Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager;", "mNetworkConnectManager", "f", "Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec;", "mRemoteOpusCodec", "g", "mProximalOpusCodec", "h", "Lcom/upuphone/ar/translation/phone/helper/RunningRecordHelper;", "mRunningRecordHelper", "i", "Lcom/upuphone/ar/translation/phone/helper/RecordTitleHelper;", "mRecordTitleHelper", "j", "mCurrentTransType", "mIsSyncCurrentRecord", "mIsShowOnlyOther", "mIsDialogueBroadcastTts", "Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;", "mTranslateStateManager", "com/upuphone/ar/translation/phone/TranslationManager$mTranslatorUiListener$1", "Lcom/upuphone/ar/translation/phone/TranslationManager$mTranslatorUiListener$1;", "mTranslatorUiListener", "com/upuphone/ar/translation/phone/TranslationManager$mNetworkConnectListener$1", "Lcom/upuphone/ar/translation/phone/TranslationManager$mNetworkConnectListener$1;", "mNetworkConnectListener", "Companion", "SingleHolder", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslationManager {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Context f6215a;
    public long b;
    public boolean c;
    public CoroutineScope d = k();
    public NetworkConnectManager e;
    public TranslatorOpusCodec f;
    public TranslatorOpusCodec g;
    public RunningRecordHelper h;
    public RecordTitleHelper i;
    public int j = 2;
    public boolean k;
    public boolean l;
    public boolean m;
    public TranslateStateManager n;
    public final TranslationManager$mTranslatorUiListener$1 o = new TranslationManager$mTranslatorUiListener$1(this);
    public final TranslationManager$mNetworkConnectListener$1 p = new TranslationManager$mNetworkConnectListener$1(this);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/TranslationManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/TranslationManager;", "a", "()Lcom/upuphone/ar/translation/phone/TranslationManager;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TranslationManager a() {
            return SingleHolder.f6216a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/TranslationManager$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/TranslationManager;", "b", "Lcom/upuphone/ar/translation/phone/TranslationManager;", "a", "()Lcom/upuphone/ar/translation/phone/TranslationManager;", "instance", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f6216a = new SingleHolder();
        public static final TranslationManager b = new TranslationManager();

        public final TranslationManager a() {
            return b;
        }
    }

    public final void A(String str, Function0 function0) {
        if (CoroutineScopeKt.h(this.d)) {
            Job unused = BuildersKt__Builders_commonKt.d(this.d, (CoroutineContext) null, (CoroutineStart) null, new TranslationManager$launchIoScope$1(function0, str, (Continuation<? super TranslationManager$launchIoScope$1>) null), 3, (Object) null);
            return;
        }
        LogExt.k("launchIoScope[" + str + "] ioScope not active", "TranslationManager");
    }

    public final List B() {
        return CollectionsKt.mutableListOf(21, 22, 25, 26, 27, 28, 29, 34, 35);
    }

    public final void C(int i2, int i3) {
        if (!B().contains(Integer.valueOf(i3))) {
            InterConnectHelper.s(InterConnectHelper.c.a(), i2, i3, (Object) null, 4, (Object) null);
        }
    }

    public final void D(int i2, int i3) {
        TranslateStateManager p2;
        XunFeiChannelHandler a2;
        TranslationState translationState = new TranslationState(i2, i3, (Long) null, 4, (DefaultConstructorMarker) null);
        TranslationApp.notifyTranslateState$ar_translator_intlRelease(new TransStateEvent(translationState, s(i2)));
        RunningRecordHelper runningRecordHelper = this.h;
        if (runningRecordHelper != null) {
            runningRecordHelper.p(translationState);
        }
        BleAudioHelper.f6295a.w(i2, i3);
        if (i2 == 4 && i3 == -1) {
            this.j = PreferencesUtils.m();
            this.k = PreferencesUtils.c();
            this.l = PreferencesUtils.b();
            String k2 = InterconnectMsgCodExtKt.k(this.j);
            boolean z = this.k;
            boolean z2 = this.l;
            LogExt.j("notifyTransStateToPhone transType" + k2 + ", syncRecord=" + z + ", onlyOther=" + z2, "TranslationManager");
        }
        if (i3 == 14 || i3 == 19) {
            NoteSyncHelper.m();
        }
        if (TranslatorConstants.isMicroSoftAsr() && i2 == 2 && i3 == -1 && !z() && (p2 = p()) != null && (a2 = p2.a()) != null) {
            a2.w();
        }
        if (i2 == 2 && InterconnectMsgCodExtKt.d(i3)) {
            H(false);
        }
    }

    public final void E(int i2, int i3) {
        if (i3 == -1 || InterconnectMsgCodExtKt.d(i3)) {
            TranslateStateManager p2 = p();
            boolean i4 = p2 != null ? p2.i(i2) : false;
            TranslateStateManager p3 = p();
            boolean d2 = p3 != null ? p3.d(i2) : false;
            if (i4) {
                this.b = System.currentTimeMillis();
                this.c = TelephoneTransHelper.f6305a.A();
            }
            if (d2 && this.b > 0) {
                int m2 = PreferencesUtils.m();
                EventTrackingHelper eventTrackingHelper = EventTrackingHelper.f6200a;
                int i5 = 2;
                int i6 = 1;
                if (m2 != 1) {
                    if (m2 != 2 && m2 == 3) {
                        if (this.c) {
                            i5 = 4;
                        } else {
                            i6 = 3;
                        }
                    }
                    eventTrackingHelper.d(new FuncEndEvent(i6, this.b, 0, 4, (DefaultConstructorMarker) null));
                    if (this.c && m2 == 3) {
                        eventTrackingHelper.f(new FuncEndEvent(4, this.b, 0, 4, (DefaultConstructorMarker) null));
                    }
                    this.b = 0;
                    this.c = false;
                }
                i6 = i5;
                eventTrackingHelper.d(new FuncEndEvent(i6, this.b, 0, 4, (DefaultConstructorMarker) null));
                eventTrackingHelper.f(new FuncEndEvent(4, this.b, 0, 4, (DefaultConstructorMarker) null));
                this.b = 0;
                this.c = false;
            }
        }
    }

    public final void F(String str, String str2, int i2) {
        String str3;
        AsrResult asrResult = (AsrResult) GsonUtils.a(str, AsrResult.class);
        Dst dst = asrResult.getDst();
        if (dst != null) {
            int type = dst.getType();
            String finalSrc = dst.getFinalSrc();
            String content = dst.getContent();
            ResultExt ext = asrResult.getExt();
            if (ext == null || (str3 = ext.getRecognizeId()) == null) {
                str3 = "";
            }
            String str4 = str3;
            Context context = this.f6215a;
            if (context != null) {
                TempStorageTransResult r = r(finalSrc, content, str2, i2, str4);
                NoteSyncHelper.f6301a.y(type, r);
                if (type == 0) {
                    NoteSyncHelper.v(context, r);
                }
            }
        }
    }

    public final void G(String str, String str2) {
        Context context;
        Src src = ((AsrResult) GsonUtils.a(str, AsrResult.class)).getSrc();
        if (src != null && (context = this.f6215a) != null) {
            int type = src.getType();
            TempStorageTransResult q2 = q(src.getContent(), str2);
            NoteSyncHelper.f6301a.y(type, q2);
            if (type == 0) {
                NoteSyncHelper.v(context, q2);
            }
        }
    }

    public final void H(boolean z) {
        this.m = z;
    }

    public final void I(String str, String str2) {
        String str3;
        if (this.j != 1) {
            String str4 = null;
            if (Intrinsics.areEqual((Object) str2, (Object) "proximal_trans")) {
                str3 = null;
                str4 = str;
            } else {
                str3 = str;
            }
            RunningRecordHelper runningRecordHelper = this.h;
            if (runningRecordHelper != null) {
                runningRecordHelper.q(this.j, str4, str3);
            }
        }
        if (!this.k) {
            LogExt.f("未开启记录存储开关，不存储翻译记录", "TranslationManager", "storeTranslateResult", 0, 4, (Object) null);
            return;
        }
        int i2 = this.j;
        if (i2 == 1) {
            G(str, str2);
        } else {
            F(str, str2, i2);
        }
    }

    public final void J() {
        LogExt.j("[unInit] 释放翻译官管理类", "TranslationManager");
        TranslateStateManager p2 = p();
        if (p2 != null) {
            p2.n();
        }
        TranslatorOpusCodec translatorOpusCodec = this.f;
        if (translatorOpusCodec != null) {
            translatorOpusCodec.e();
        }
        this.f = null;
        TranslatorOpusCodec translatorOpusCodec2 = this.g;
        if (translatorOpusCodec2 != null) {
            translatorOpusCodec2.e();
        }
        this.g = null;
        TelephoneTransHelper.f6305a.E();
        NetworkConnectManager networkConnectManager = this.e;
        if (networkConnectManager != null) {
            networkConnectManager.z();
        }
        this.e = null;
        this.h = null;
        RecordTitleHelper recordTitleHelper = this.i;
        if (recordTitleHelper != null) {
            recordTitleHelper.k();
        }
        this.i = null;
        this.j = 0;
        this.k = false;
        this.l = false;
        this.b = 0;
        this.c = false;
        this.m = false;
        GlassVersionHelper.INSTANCE.setGlassVersionCode(0);
        CoroutineScopeKt.e(this.d, (CancellationException) null, 1, (Object) null);
        this.f6215a = null;
        this.n = null;
    }

    public final CoroutineScope k() {
        return CoroutineScopeKt.a(ExecutorsKt.b(ThreadPollHelper.f6199a.a()).plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    }

    public final TranslatorOpusCodec l() {
        return this.g;
    }

    public final RecordTitleHelper m() {
        return this.i;
    }

    public final TranslatorOpusCodec n() {
        return this.f;
    }

    public final RunningRecordHelper o() {
        return this.h;
    }

    public final TranslateStateManager p() {
        return this.n;
    }

    public final TempStorageTransResult q(String str, String str2) {
        String str3 = Intrinsics.areEqual((Object) str2, (Object) "remote_trans") ? str : "";
        String str4 = Intrinsics.areEqual((Object) str2, (Object) "proximal_trans") ? str : "";
        return new TempStorageTransResult(1, str3, str3, str4, str4, false, (String) null, 64, (DefaultConstructorMarker) null);
    }

    public final TempStorageTransResult r(String str, String str2, String str3, int i2, String str4) {
        String str5 = Intrinsics.areEqual((Object) str3, (Object) "remote_trans") ? str : "";
        String str6 = Intrinsics.areEqual((Object) str3, (Object) "remote_trans") ? str2 : "";
        String str7 = Intrinsics.areEqual((Object) str3, (Object) "proximal_trans") ? str : "";
        String str8 = Intrinsics.areEqual((Object) str3, (Object) "proximal_trans") ? str2 : "";
        int i3 = 2;
        if (i2 != 2) {
            i3 = 3;
        }
        return new TempStorageTransResult(i3, str5, str6, str7, str8, false, str4);
    }

    public final NoteBean s(int i2) {
        TranslateStateManager p2 = p();
        if (p2 != null && p2.f(i2)) {
            NoteBean A = NoteSyncHelper.A(NoteSyncHelper.j());
            if (A != null) {
                return A;
            }
            TempStorageTransResult f2 = NoteSyncHelper.f6301a.f();
            if (f2 == null) {
                return null;
            }
            LogExt.j("getTransStateNoteBean first transResult=" + f2, "TranslationManager");
            Context context = this.f6215a;
            if (context != null) {
                f2.setFirstTemp(true);
                NoteSyncHelper.v(context, f2);
                return NoteSyncHelper.j();
            }
        }
        return null;
    }

    public final void t(Object obj) {
        A("ProximalTransResult", new TranslationManager$handleProximalTranslateResult$1(obj, this));
    }

    public final void u(Object obj) {
        A("RemoteTransResult", new TranslationManager$handleRemoteTranslateResult$1(obj, this));
    }

    public final void v(int i2, int i3) {
        A("handleUiStateChanged", new TranslationManager$handleUiStateChanged$1(i2, i3, this));
    }

    public final void w(Context context) {
        XunFeiChannelHandler a2;
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.j("[init] 初始化翻译官管理类", "TranslationManager");
        this.f6215a = context;
        this.n = new TranslateStateManager(context, this.o);
        TranslatorOpusCodec translatorOpusCodec = new TranslatorOpusCodec();
        translatorOpusCodec.c(TranslatorConstants.isMono());
        this.f = translatorOpusCodec;
        TranslatorOpusCodec translatorOpusCodec2 = new TranslatorOpusCodec();
        translatorOpusCodec2.c(TranslatorConstants.isMono());
        this.g = translatorOpusCodec2;
        TelephoneTransHelper.f6305a.y(context);
        NetworkConnectManager networkConnectManager = new NetworkConnectManager(context, this.p);
        networkConnectManager.y();
        TranslateStateManager p2 = p();
        if (!(p2 == null || (a2 = p2.a()) == null)) {
            a2.I(networkConnectManager);
        }
        this.e = networkConnectManager;
        this.h = new RunningRecordHelper(context);
        RecordTitleHelper recordTitleHelper = new RecordTitleHelper(context);
        recordTitleHelper.i();
        this.i = recordTitleHelper;
        this.b = 0;
        this.c = false;
        if (!CoroutineScopeKt.h(this.d)) {
            this.d = k();
        }
    }

    public final boolean x() {
        return this.m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean y() {
        /*
            r1 = this;
            com.upuphone.ar.translation.statemachine.machine.TranslateStateManager r1 = r1.p()
            if (r1 == 0) goto L_0x0015
            com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler r1 = r1.a()
            if (r1 == 0) goto L_0x0015
            int r1 = r1.v()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            if (r1 != 0) goto L_0x0019
            goto L_0x0022
        L_0x0019:
            int r1 = r1.intValue()
            r0 = 3
            if (r1 != r0) goto L_0x0022
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.TranslationManager.y():boolean");
    }

    public final boolean z() {
        return p() == null;
    }
}
