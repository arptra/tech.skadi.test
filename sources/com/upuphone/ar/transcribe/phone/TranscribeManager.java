package com.upuphone.ar.transcribe.phone;

import android.content.Context;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.ar.transcribe.eventtrack.event.FuncEndEvent;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.TranslationStateEntity;
import com.upuphone.ar.transcribe.phone.bean.TempStorageTransResult;
import com.upuphone.ar.transcribe.phone.bean.TransStateEvent;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.BleAudioManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.phone.helper.TitleGenerator;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import com.upuphone.ar.transcribe.phone.network.NetworkConnectManager;
import com.upuphone.ar.transcribe.statemachine.machine.TranscribeStateManager;
import com.upuphone.ar.transcribe.utils.GsonUtils;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import com.xjsd.xr.sapp.asr.dao.TtsData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0003AEH\u0018\u0000 52\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u0018J\u001f\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010I¨\u0006M"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/TranscribeManager;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "h", "()Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "", "n", "()Z", "Landroid/content/Context;", "context", "", "m", "(Landroid/content/Context;)V", "u", "", "resId", "", "i", "(I)Ljava/lang/String;", "state", "expCode", "q", "(II)V", "p", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "k", "(I)Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "o", "result", "ownerType", "t", "(Ljava/lang/String;I)V", "r", "a", "Landroid/content/Context;", "appContext", "", "b", "J", "mTransFuncStartTime", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/upuphone/ar/transcribe/phone/network/NetworkConnectManager;", "d", "Lcom/upuphone/ar/transcribe/phone/network/NetworkConnectManager;", "mNetworkConnectManager", "Lcom/upuphone/ar/transcribe/phone/helper/TitleGenerator;", "e", "Lcom/upuphone/ar/transcribe/phone/helper/TitleGenerator;", "j", "()Lcom/upuphone/ar/transcribe/phone/helper/TitleGenerator;", "setTitleGenerator", "(Lcom/upuphone/ar/transcribe/phone/helper/TitleGenerator;)V", "titleGenerator", "f", "I", "l", "()I", "s", "(I)V", "translationType", "com/upuphone/ar/transcribe/phone/TranscribeManager$uiStateListener$1", "g", "Lcom/upuphone/ar/transcribe/phone/TranscribeManager$uiStateListener$1;", "uiStateListener", "com/upuphone/ar/transcribe/phone/TranscribeManager$transResultListener$1", "Lcom/upuphone/ar/transcribe/phone/TranscribeManager$transResultListener$1;", "transResultListener", "com/upuphone/ar/transcribe/phone/TranscribeManager$mNetworkConnectListener$1", "Lcom/upuphone/ar/transcribe/phone/TranscribeManager$mNetworkConnectListener$1;", "mNetworkConnectListener", "Companion", "SingleHolder", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranscribeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeManager.kt\ncom/upuphone/ar/transcribe/phone/TranscribeManager\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,404:1\n48#2,4:405\n1#3:409\n*S KotlinDebug\n*F\n+ 1 TranscribeManager.kt\ncom/upuphone/ar/transcribe/phone/TranscribeManager\n*L\n70#1:405,4\n*E\n"})
public final class TranscribeManager {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Context f6069a;
    public long b;
    public final CoroutineScope c;
    public NetworkConnectManager d;
    public TitleGenerator e;
    public int f = 1;
    public final TranscribeManager$uiStateListener$1 g = new TranscribeManager$uiStateListener$1(this);
    public final TranscribeManager$transResultListener$1 h = new TranscribeManager$transResultListener$1(this);
    public final TranscribeManager$mNetworkConnectListener$1 i = new TranscribeManager$mNetworkConnectListener$1(this);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/TranscribeManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/TranscribeManager;", "a", "()Lcom/upuphone/ar/transcribe/phone/TranscribeManager;", "", "TAG", "Ljava/lang/String;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TranscribeManager a() {
            return SingleHolder.f6070a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/TranscribeManager$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/TranscribeManager;", "b", "Lcom/upuphone/ar/transcribe/phone/TranscribeManager;", "a", "()Lcom/upuphone/ar/transcribe/phone/TranscribeManager;", "instance", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f6070a = new SingleHolder();
        public static final TranscribeManager b = new TranscribeManager();

        public final TranscribeManager a() {
            return b;
        }
    }

    public TranscribeManager() {
        CompletableJob b2 = SupervisorKt.b((Job) null, 1, (Object) null);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.c = CoroutineScopeKt.a(b2.plus(ExecutorsKt.b(newSingleThreadExecutor)).plus(new TranscribeManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0)));
    }

    public static final TranscribeManager g() {
        return j.a();
    }

    public final TranscribeStateManager h() {
        return TranscribeStateManager.h.a();
    }

    public final String i(int i2) {
        Context context = this.f6069a;
        if (context != null) {
            return context.getString(i2);
        }
        return null;
    }

    public final TitleGenerator j() {
        return this.e;
    }

    public final TranscribeBean k(int i2) {
        if (h().j(i2)) {
            TranscribeDBHelper transcribeDBHelper = TranscribeDBHelper.f6108a;
            TranscribeBean D = transcribeDBHelper.D(transcribeDBHelper.k());
            if (D != null) {
                return D;
            }
            TempStorageTransResult j2 = transcribeDBHelper.j();
            if (j2 == null) {
                return null;
            }
            LogExt.g("getTransStateNoteBean first transResult=" + j2, "TranscribeManager");
            Context context = this.f6069a;
            if (context != null) {
                j2.setFirstTemp(true);
                Unit unit = Unit.INSTANCE;
                transcribeDBHelper.x(context, j2);
                return transcribeDBHelper.k();
            }
        }
        return null;
    }

    public final int l() {
        return this.f;
    }

    public final void m(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String d2 = TranscribeConstants.f6027a.d();
        LogExt.g("Init:: 翻译管理类 " + d2, "TranscribeManager");
        this.f6069a = context;
        h().f(context, this.h, this.g);
        h().P();
        NetworkConnectManager networkConnectManager = new NetworkConnectManager(context, this.i);
        this.d = networkConnectManager;
        networkConnectManager.w();
        TitleGenerator titleGenerator = new TitleGenerator(context, this.c);
        this.e = titleGenerator;
        titleGenerator.i();
        this.b = 0;
    }

    public final boolean n() {
        return TranscribeStateManager.h.b();
    }

    public final void o(int i2, int i3) {
        switch (i3) {
            case 21:
            case 22:
                BleAudioManager.g.a().c(i3);
                break;
            case 25:
            case 26:
                BleAudioManager.g.a().e(i3);
                break;
            case 27:
            case 28:
            case 29:
                BleAudioManager.g.a().d(i3);
                break;
            default:
                if (this.f == 1 || i3 != 23) {
                    InterConnectHelper.s(InterConnectHelper.c.a(), i2, i3, (TtsData) null, 4, (Object) null);
                    break;
                }
        }
        if (i2 == 2) {
            LogExt.g("notifyTransState reset keepLive state", "TranscribeManager");
            BleAudioManager.Companion companion = BleAudioManager.g;
            companion.a().c(22);
            companion.a().e(26);
            companion.a().d(27);
        }
    }

    public final void p(int i2, int i3) {
        TranscribeApp.notifyTranslateState(new TransStateEvent(new TranslationStateEntity(i2, i3, (Long) null, 4, (DefaultConstructorMarker) null), k(i2)));
        if (i3 == 14 || i3 == 19) {
            TranscribeDBHelper.f6108a.l();
        }
        BleAudioManager.g.a().l(i2);
    }

    public final void q(int i2, int i3) {
        if (i3 == -1) {
            boolean m = h().m(i2);
            boolean h2 = h().h(i2);
            if (m) {
                this.b = System.currentTimeMillis();
            }
            if (h2) {
                long j2 = this.b;
                if (j2 > 0) {
                    EventTrackingHelper.f6058a.e(new FuncEndEvent(2, j2, 0, this.f, 4, (DefaultConstructorMarker) null));
                    this.b = 0;
                }
            }
        }
    }

    public final void r(String str, int i2) {
        String str2;
        if (!new JSONObject(str).has("src")) {
            LogExt.e("saveTranscribeRecord has no src", "TranscribeManager");
            return;
        }
        AsrResult asrResult = (AsrResult) GsonUtils.a(str, AsrResult.class);
        Src src = asrResult.getSrc();
        if (src != null) {
            int type = src.getType();
            String content = src.getContent();
            ResultExt ext = asrResult.getExt();
            if (ext == null || (str2 = ext.getRecognizeId()) == null) {
                str2 = "";
            }
            Context context = this.f6069a;
            if (context == null) {
                return;
            }
            if (content == null || content.length() == 0) {
                LogExt.e("saveTranscribeRecord content is null", "TranscribeManager");
                return;
            }
            TempStorageTransResult tempStorageTransResult = new TempStorageTransResult(i2, content, false, str2);
            TranscribeDBHelper transcribeDBHelper = TranscribeDBHelper.f6108a;
            transcribeDBHelper.C(type, tempStorageTransResult);
            if (type != 0) {
                LogExt.e("saveTranscribeRecord content is not final result", "TranscribeManager");
            } else {
                transcribeDBHelper.x(context, tempStorageTransResult);
            }
        }
    }

    public final void s(int i2) {
        this.f = i2;
    }

    public final void t(String str, int i2) {
        Context context = this.f6069a;
        if (Intrinsics.areEqual((Object) context != null ? Boolean.valueOf(PreferencesUtils.b(context)) : null, (Object) Boolean.FALSE)) {
            LogExt.e("storeTranslateResult not sync", "TranscribeManager");
            return;
        }
        LogExt.g("storeTranslateResult", "TranscribeManager");
        Job unused = BuildersKt__Builders_commonKt.d(this.c, (CoroutineContext) null, (CoroutineStart) null, new TranscribeManager$storeTranslateResult$1(this, str, i2, (Continuation<? super TranscribeManager$storeTranslateResult$1>) null), 3, (Object) null);
    }

    public final void u() {
        String d2 = TranscribeConstants.f6027a.d();
        LogExt.g("unInit:: 翻译管理类 " + d2, "TranscribeManager");
        this.f6069a = null;
        h().s();
        NetworkConnectManager networkConnectManager = this.d;
        if (networkConnectManager != null) {
            networkConnectManager.x();
        }
        TranscribeStateManager.h.c();
        TitleGenerator titleGenerator = this.e;
        if (titleGenerator != null) {
            titleGenerator.k();
        }
        this.e = null;
        this.b = 0;
    }
}
