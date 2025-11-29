package com.upuphone.ar.tici.phone.starrynet;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.db.entity.TiciEntityKt;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.AutoTiciRunningMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply;
import com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReply;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3;
import com.upuphone.ar.tici.phone.starrynet.msg.SendContentPageRequest;
import com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\rj\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\rj\u0002`\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0018J@\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2'\u0010\u000f\u001a#\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\rj\u0002`\u000e\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0002\b\u001fH\u0002¢\u0006\u0004\b \u0010\u0011J\u0017\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0018J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0018R6\u0010'\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\rj\u0002`\u000e0$0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010)R\u0014\u0010.\u001a\u00020+8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;", "msgManager", "Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;", "baseActionMsg", "", "k", "(Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;)V", "", "action", "Lkotlin/Function1;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsgListener;", "listener", "c", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "s", "m", "(Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;)V", "n", "p", "h", "(Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;)V", "j", "f", "g", "(Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;)V", "l", "e", "Lkotlin/ExtensionFunctionType;", "d", "r", "q", "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "actionMsgListeners", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "openTiciResultLock", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReceiveMsgHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler\n+ 2 BaseJsonMsg.kt\ncom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg$Companion\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,365:1\n15#2:366\n15#2:367\n15#2:368\n15#2:369\n15#2:370\n15#2:371\n15#2:372\n15#2:378\n15#2:379\n72#3,2:373\n1#4:375\n1855#5,2:376\n*S KotlinDebug\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler\n*L\n99#1:366\n145#1:367\n192#1:368\n228#1:369\n252#1:370\n275#1:371\n297#1:372\n319#1:378\n347#1:379\n302#1:373,2\n302#1:375\n313#1:376,2\n*E\n"})
public final class ReceiveMsgHandler implements CoroutineScope {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f5972a = CoroutineScopeKt.b();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final Mutex c = MutexKt.b(false, 1, (Object) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = new java.util.concurrent.CopyOnWriteArraySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r2, kotlin.jvm.functions.Function1 r3) {
        /*
            r1 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.concurrent.ConcurrentHashMap r1 = r1.b
            java.lang.Object r0 = r1.get(r2)
            if (r0 != 0) goto L_0x001f
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet
            r0.<init>()
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            java.util.Set r0 = (java.util.Set) r0
            r0.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler.c(java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    public final void d(String str, Function1 function1) {
        Set<Function1> set = (Set) this.b.get(str);
        if (set != null) {
            for (Function1 invoke : set) {
                function1.invoke(invoke);
            }
        }
    }

    public final void e(BaseActionMsg baseActionMsg) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        String value = baseActionMsg.getValue();
        TiciApp.b.c().h0((AutoTiciRunningMsg) companion.a().fromJson(value, AutoTiciRunningMsg.class));
    }

    public final void f(BaseActionMsg baseActionMsg) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        CheckTiciStateReply checkTiciStateReply = (CheckTiciStateReply) companion.a().fromJson(baseActionMsg.getValue(), CheckTiciStateReply.class);
        CommonExtKt.e("handleCheckTiciStateReply-> " + checkTiciStateReply, "ReceiveMsgHandler");
        TiciApp.b.c().Q0(checkTiciStateReply);
    }

    public final void g(TiciStarryMsgManager ticiStarryMsgManager) {
        ticiStarryMsgManager.handleGlassesTiciQuit$ar_tici_release();
        TiciApp.b.c().i0();
    }

    public CoroutineContext getCoroutineContext() {
        return this.f5972a.getCoroutineContext();
    }

    public final void h(BaseActionMsg baseActionMsg) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        HighlightMsg highlightMsg = (HighlightMsg) companion.a().fromJson(baseActionMsg.getValue(), HighlightMsg.class);
        CommonExtKt.e("handleHighlight, highlightMsg: " + highlightMsg, "ReceiveMsgHandler");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$handleHighlight$1(this, highlightMsg, (Continuation<? super ReceiveMsgHandler$handleHighlight$1>) null), 3, (Object) null);
    }

    public final void j(BaseActionMsg baseActionMsg) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        HighlightMsgV3 highlightMsgV3 = (HighlightMsgV3) companion.a().fromJson(baseActionMsg.getValue(), HighlightMsgV3.class);
        CommonExtKt.e("handleHighlightV3, highlightMsg: " + highlightMsgV3, "ReceiveMsgHandler");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$handleHighlightV3$1(this, highlightMsgV3, (Continuation<? super ReceiveMsgHandler$handleHighlightV3$1>) null), 3, (Object) null);
    }

    public final void k(TiciStarryMsgManager ticiStarryMsgManager, BaseActionMsg baseActionMsg) {
        Intrinsics.checkNotNullParameter(ticiStarryMsgManager, "msgManager");
        Intrinsics.checkNotNullParameter(baseActionMsg, "baseActionMsg");
        CommonExtKt.e("handleMsg-> " + baseActionMsg, "ReceiveMsgHandler");
        String action = baseActionMsg.getAction();
        switch (action.hashCode()) {
            case -2035997143:
                if (action.equals(BaseActionMsg.MSG_OPEN_RESULT_V2)) {
                    n(baseActionMsg, ticiStarryMsgManager);
                    break;
                }
                break;
            case -2035997142:
                if (action.equals(BaseActionMsg.MSG_OPEN_RESULT_V3)) {
                    p(baseActionMsg, ticiStarryMsgManager);
                    break;
                }
                break;
            case -1862220885:
                if (action.equals(BaseActionMsg.MSG_AUTO_TICI_RUNNING)) {
                    e(baseActionMsg);
                    break;
                }
                break;
            case -1685907601:
                if (action.equals(BaseActionMsg.MSG_CHECK_TICI_STATE_REPLY)) {
                    f(baseActionMsg);
                    break;
                }
                break;
            case -1546293195:
                if (action.equals(BaseActionMsg.MSG_HIGHLIGHT_INDEX_V3)) {
                    j(baseActionMsg);
                    break;
                }
                break;
            case -1415977622:
                if (action.equals(BaseActionMsg.MSG_OPEN_FROM_GLASSES)) {
                    l();
                    break;
                }
                break;
            case -1174027897:
                if (action.equals(BaseActionMsg.MSG_HIGHLIGHT_INDEX)) {
                    h(baseActionMsg);
                    break;
                }
                break;
            case -87435342:
                if (action.equals(BaseActionMsg.MSG_OPEN_RESULT)) {
                    m(baseActionMsg, ticiStarryMsgManager);
                    break;
                }
                break;
            case 431452931:
                if (action.equals(BaseActionMsg.MSG_SYNC_PARAGRAPH_INFO)) {
                    r(baseActionMsg);
                    break;
                }
                break;
            case 451638534:
                if (action.equals(BaseActionMsg.MSG_GLASSES_QUIT)) {
                    g(ticiStarryMsgManager);
                    break;
                }
                break;
            case 1954404412:
                if (action.equals(BaseActionMsg.MSG_REQUEST_SEND_CONTENT_PAGE)) {
                    q(baseActionMsg);
                    break;
                }
                break;
        }
        d(baseActionMsg.getAction(), new ReceiveMsgHandler$handleMsg$1(baseActionMsg));
    }

    public final void l() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$handleOpenFromGlasses$1((Continuation<? super ReceiveMsgHandler$handleOpenFromGlasses$1>) null), 3, (Object) null);
    }

    public final void m(BaseActionMsg baseActionMsg, TiciStarryMsgManager ticiStarryMsgManager) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        OpenTiciMsgReply openTiciMsgReply = (OpenTiciMsgReply) companion.a().fromJson(baseActionMsg.getValue(), OpenTiciMsgReply.class);
        CommonExtKt.e("handleOpenResult, reply: " + openTiciMsgReply, "ReceiveMsgHandler");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$handleOpenResult$1(this, ticiStarryMsgManager, openTiciMsgReply, (Continuation<? super ReceiveMsgHandler$handleOpenResult$1>) null), 3, (Object) null);
    }

    public final void n(BaseActionMsg baseActionMsg, TiciStarryMsgManager ticiStarryMsgManager) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        OpenTiciMsgReplyV2 openTiciMsgReplyV2 = (OpenTiciMsgReplyV2) companion.a().fromJson(baseActionMsg.getValue(), OpenTiciMsgReplyV2.class);
        CommonExtKt.e("handleOpenResultV2, reply: " + openTiciMsgReplyV2, "ReceiveMsgHandler");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$handleOpenResultV2$1(this, ticiStarryMsgManager, openTiciMsgReplyV2, (Continuation<? super ReceiveMsgHandler$handleOpenResultV2$1>) null), 3, (Object) null);
    }

    public final void p(BaseActionMsg baseActionMsg, TiciStarryMsgManager ticiStarryMsgManager) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        OpenTiciMsgReplyV3 openTiciMsgReplyV3 = (OpenTiciMsgReplyV3) companion.a().fromJson(baseActionMsg.getValue(), OpenTiciMsgReplyV3.class);
        CommonExtKt.e("handleOpenResultV3, reply: " + openTiciMsgReplyV3, "ReceiveMsgHandler");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$handleOpenResultV3$1(this, openTiciMsgReplyV3, ticiStarryMsgManager, (Continuation<? super ReceiveMsgHandler$handleOpenResultV3$1>) null), 3, (Object) null);
    }

    public final void q(BaseActionMsg baseActionMsg) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        SendContentPageRequest sendContentPageRequest = (SendContentPageRequest) companion.a().fromJson(baseActionMsg.getValue(), SendContentPageRequest.class);
        CommonExtKt.e("onRequestSendContentPage, request: " + sendContentPageRequest, "ReceiveMsgHandler");
        Long b2 = TiciEntityKt.b(sendContentPageRequest.getFileKey());
        if (b2 != null) {
            Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$onRequestSendContentPage$1(sendContentPageRequest, b2.longValue(), (Continuation<? super ReceiveMsgHandler$onRequestSendContentPage$1>) null), 3, (Object) null);
        }
    }

    public final void r(BaseActionMsg baseActionMsg) {
        BaseJsonMsg.Companion companion = BaseJsonMsg.Companion;
        SyncParagraphInfo syncParagraphInfo = (SyncParagraphInfo) companion.a().fromJson(baseActionMsg.getValue(), SyncParagraphInfo.class);
        CommonExtKt.e("onSyncParagraphInfo, paragraphInfo: " + syncParagraphInfo, "ReceiveMsgHandler");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ReceiveMsgHandler$onSyncParagraphInfo$1(syncParagraphInfo, (Continuation<? super ReceiveMsgHandler$onSyncParagraphInfo$1>) null), 3, (Object) null);
    }

    public final void s(String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Set set = (Set) this.b.get(str);
        if (set != null) {
            set.remove(function1);
        }
    }
}
