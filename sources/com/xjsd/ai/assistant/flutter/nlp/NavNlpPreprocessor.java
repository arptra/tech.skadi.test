package com.xjsd.ai.assistant.flutter.nlp;

import com.upuphone.xr.interconnect.entity.PoiResult;
import com.xjsd.ai.assistant.flutter.event.FlutterNavigationEvent;
import com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$navigateCallback$2;
import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.skill.navigation.NavHelper;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode;
import com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer;
import com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\b*\u0001;\u0018\u0000 \u00162\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u0019H@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\"2\u0006\u0010!\u001a\u00020\tH@¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\tH@¢\u0006\u0004\b%\u0010&R$\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020'8\u0002@BX\u000e¢\u0006\f\n\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00102\u001a\u00020.2\u0006\u0010(\u001a\u00020.8\u0002@BX\u000e¢\u0006\f\n\u0004\b\n\u0010/\"\u0004\b0\u00101R$\u00107\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00198\u0002@BX\u000e¢\u0006\f\n\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "Lcom/xjsd/ai/assistant/flutter/event/FlutterNavigationEvent;", "event", "", "onReceiveFlutterNavigationEvent", "(Lcom/xjsd/ai/assistant/flutter/event/FlutterNavigationEvent;)V", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "g", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)Z", "clean", "lastDomain", "currentDomain", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "poiName", "", "type", "n", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/interconnect/entity/PoiResult;", "poiResult", "v", "(Lcom/upuphone/xr/interconnect/entity/PoiResult;)V", "poi", "", "m", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode;", "value", "a", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode;", "u", "(Lcom/xjsd/ai/assistant/skill/navigation/enums/NavTravelMode;)V", "travelType", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer;", "Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer;", "t", "(Lcom/xjsd/ai/assistant/skill/navigation/enums/NaviRoutePrefer;)V", "routeType", "c", "I", "q", "(I)V", "navTarget", "d", "Ljava/util/List;", "poiList", "com/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$navigateCallback$2$1", "e", "Lkotlin/Lazy;", "k", "()Lcom/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$navigateCallback$2$1;", "navigateCallback", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNavNlpPreprocessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavNlpPreprocessor.kt\ncom/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,450:1\n314#2,11:451\n314#2,11:462\n*S KotlinDebug\n*F\n+ 1 NavNlpPreprocessor.kt\ncom/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor\n*L\n418#1:451,11\n432#1:462,11\n*E\n"})
public final class NavNlpPreprocessor implements NlpPreprocessor {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public NavTravelMode f8487a = NavTravelMode.DEFAULT;
    public NaviRoutePrefer b = NaviRoutePrefer.DEFAULT;
    public int c;
    public List d;
    public final Lazy e = LazyKt.lazy(NavNlpPreprocessor$navigateCallback$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public NavNlpPreprocessor() {
        EventBus.c().o(this);
    }

    public static /* synthetic */ Object o(NavNlpPreprocessor navNlpPreprocessor, NluResponse nluResponse, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return navNlpPreprocessor.n(nluResponse, str, i, continuation);
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return VuiModelType.NAVIGATION;
    }

    public Object c(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.e(this, nluResponse, continuation);
    }

    public void clean() {
        ILog.a("NavNlpPreprocessor", "clean: 清除导航临时数据");
        t(NaviRoutePrefer.DEFAULT);
        u(NavTravelMode.DEFAULT);
        q(0);
        this.d = null;
        NavHelper.b();
    }

    public void d(NluResponse nluResponse, int i) {
        NlpPreprocessor.DefaultImpls.j(this, nluResponse, i);
    }

    public void e(NluResponse nluResponse, TtsTemplate ttsTemplate) {
        NlpPreprocessor.DefaultImpls.k(this, nluResponse, ttsTemplate);
    }

    public void f(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "lastDomain");
        Intrinsics.checkNotNullParameter(str2, "currentDomain");
        if (Intrinsics.areEqual((Object) str, (Object) b())) {
            clean();
        }
    }

    public boolean g(NluResponse nluResponse) {
        Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
        if (Intrinsics.areEqual((Object) nluResponse.getHeader().getName(), (Object) "TrafficRestrictionSearch")) {
            return false;
        }
        return NlpPreprocessor.DefaultImpls.c(this, nluResponse);
    }

    public void h(NluResponse nluResponse, String str) {
        NlpPreprocessor.DefaultImpls.l(this, nluResponse, str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0286, code lost:
        if (r3.equals("TurnOn") == false) goto L_0x045c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x028a, code lost:
        r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) "TurnOn");
        r4 = r5.getString("target");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0295, code lost:
        if (r4 != null) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0297, code lost:
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x029e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) "map") == false) goto L_0x02fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02a0, code lost:
        r4 = r1.isNaving();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02a4, code lost:
        if (r3 == false) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02a6, code lost:
        r2 = r5.getString("transportation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02aa, code lost:
        if (r2 != null) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02ad, code lost:
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ae, code lost:
        r2 = com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode.Companion.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02b8, code lost:
        if (r12.length() <= 0) goto L_0x02d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02be, code lost:
        if (r1.isNaving() == false) goto L_0x02d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c0, code lost:
        r1.changeNavi(r2.getCode(), k());
        a(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d0, code lost:
        r0.e(r7, com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI02_P01);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02df, code lost:
        if (com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e().h(r2) != false) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02e1, code lost:
        if (r4 == false) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02e4, code lost:
        r0.e(r7, com.xjsd.ai.assistant.template.TtsAppTemplate.APP02_R02);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02ea, code lost:
        com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e().d(r2);
        r0.e(r7, com.xjsd.ai.assistant.template.TtsAppTemplate.APP02_R01);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02f6, code lost:
        clean();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0301, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) "realtime_traffic") == false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0303, code lost:
        r1 = com.xjsd.ai.assistant.skill.navigation.NavManager.j().q(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r0.e(r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0313, code lost:
        s(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0130, code lost:
        if (r3.equals("TurnOff") == false) goto L_0x045c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r17, kotlin.coroutines.Continuation r18) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r1 = r18
            boolean r2 = r1 instanceof com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$process$1
            if (r2 == 0) goto L_0x001a
            r2 = r1
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$process$1 r2 = (com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$process$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001a
            int r3 = r3 - r4
            r2.label = r3
        L_0x0018:
            r4 = r2
            goto L_0x0020
        L_0x001a:
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$process$1 r2 = new com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$process$1
            r2.<init>(r0, r1)
            goto L_0x0018
        L_0x0020:
            java.lang.Object r1 = r4.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r4.label
            switch(r2) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0046;
                case 2: goto L_0x0046;
                case 3: goto L_0x0046;
                case 4: goto L_0x0046;
                case 5: goto L_0x0046;
                case 6: goto L_0x0046;
                case 7: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0033:
            java.lang.Object r0 = r4.L$2
            com.xjsd.ai.assistant.nlu.bean.NluResponse r0 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r0
            java.lang.Object r2 = r4.L$1
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor r2 = (com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor) r2
            java.lang.Object r3 = r4.L$0
            com.xjsd.ai.assistant.nlu.bean.NluResponse r3 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r7 = r0
            r0 = r2
            goto L_0x0161
        L_0x0046:
            java.lang.Object r0 = r4.L$0
            com.xjsd.ai.assistant.nlu.bean.NluResponse r0 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0460
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r1)
            com.xjsd.ai.assistant.nlu.bean.HeaderData r1 = r17.getHeader()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "TrafficRestrictionSearch"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0063
            return r7
        L_0x0063:
            com.xjsd.ai.assistant.skill.navigation.enums.NavUnusableReason r1 = com.xjsd.ai.assistant.skill.navigation.NavUtil.a()
            if (r1 == 0) goto L_0x0071
            com.xjsd.ai.assistant.template.TtsTemplate r1 = r1.getTemplate()
            r0.e(r7, r1)
            return r7
        L_0x0071:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            com.upuphone.xr.interconnect.api.NaviAbilityOperator r1 = r1.f()
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r2 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.NAVI
            com.xjsd.ai.assistant.nlu.bean.HeaderData r3 = r17.getHeader()
            java.lang.String r3 = r3.getName()
            com.alibaba.fastjson.JSONObject r5 = r17.getPayload()
            if (r3 == 0) goto L_0x045c
            int r6 = r3.hashCode()
            java.lang.String r9 = "transportation"
            java.lang.String r10 = "TurnOn"
            java.lang.String r11 = "route_mode"
            java.lang.String r12 = ""
            java.lang.String r13 = "type"
            java.lang.String r15 = "poi"
            r14 = 1
            switch(r6) {
                case -2127828591: goto L_0x0389;
                case -1822154468: goto L_0x032d;
                case -1793734234: goto L_0x0318;
                case -1778562212: goto L_0x0282;
                case -1479043287: goto L_0x0175;
                case 78391464: goto L_0x0134;
                case 699146130: goto L_0x012a;
                case 985339573: goto L_0x00b0;
                case 1646047235: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x045c
        L_0x00a1:
            java.lang.String r1 = "SwitchPage"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00ab
            goto L_0x045c
        L_0x00ab:
            r16.s(r17)
            goto L_0x045f
        L_0x00b0:
            java.lang.String r2 = "MapRouteSet"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x00ba
            goto L_0x045c
        L_0x00ba:
            java.lang.String r2 = "walk"
            java.lang.String r3 = "ride"
            java.lang.String r4 = "car"
            java.lang.String[] r2 = new java.lang.String[]{r4, r2, r3}
            java.util.HashSet r2 = kotlin.collections.SetsKt.hashSetOf(r2)
            java.lang.String r3 = r5.getString(r11)
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x00f9
            boolean r2 = r1.isNaving()
            if (r2 != 0) goto L_0x00e0
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI08_P04
            r0.e(r7, r1)
            goto L_0x045f
        L_0x00e0:
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode$Companion r2 = com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode r2 = r2.a(r3)
            int r2 = r2.getCode()
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$navigateCallback$2$1 r3 = r16.k()
            r1.changeNavi(r2, r3)
            r16.a(r17)
            goto L_0x045f
        L_0x00f9:
            boolean r2 = r1.isNaving()
            if (r2 != 0) goto L_0x0106
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI09_P02
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0106:
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer$Companion r2 = com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer r2 = r2.a(r3)
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer r3 = com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer.UN_SUPPORT
            if (r2 != r3) goto L_0x011a
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI01_P09
            r0.e(r7, r1)
            goto L_0x045f
        L_0x011a:
            int r2 = r2.getCode()
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$navigateCallback$2$1 r3 = r16.k()
            r1.changeRoute(r2, r3)
            r16.a(r17)
            goto L_0x045f
        L_0x012a:
            java.lang.String r4 = "TurnOff"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x028a
            goto L_0x045c
        L_0x0134:
            java.lang.String r1 = "Query"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x013e
            goto L_0x045c
        L_0x013e:
            boolean r1 = r5.containsKey(r13)
            if (r1 == 0) goto L_0x0170
            java.lang.String r1 = r5.getString(r13)
            java.lang.String r2 = "current"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0169
            r4.L$0 = r7
            r4.L$1 = r0
            r4.L$2 = r7
            r1 = 7
            r4.label = r1
            java.lang.Object r1 = r0.l(r4)
            if (r1 != r8) goto L_0x0160
            return r8
        L_0x0160:
            r3 = r7
        L_0x0161:
            java.lang.String r1 = (java.lang.String) r1
            r0.h(r7, r1)
            r0 = r3
            goto L_0x0460
        L_0x0169:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r1 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P05
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0170:
            r16.s(r17)
            goto L_0x045f
        L_0x0175:
            java.lang.String r2 = "NaviDirective"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x017f
            goto L_0x045c
        L_0x017f:
            java.lang.String r2 = "directive"
            java.lang.String r2 = r5.getString(r2)
            if (r2 == 0) goto L_0x027d
            int r3 = r2.hashCode()
            switch(r3) {
                case -1433872411: goto L_0x0253;
                case -864998525: goto L_0x01fc;
                case -401021203: goto L_0x01c7;
                case 1357571402: goto L_0x0190;
                default: goto L_0x018e;
            }
        L_0x018e:
            goto L_0x027d
        L_0x0190:
            java.lang.String r3 = "navigate_office"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x019a
            goto L_0x027d
        L_0x019a:
            java.lang.String r2 = r5.getString(r15)
            if (r2 == 0) goto L_0x01ad
            r4.L$0 = r7
            r1 = 5
            r4.label = r1
            r3 = 2
            java.lang.Object r0 = r0.n(r7, r2, r3, r4)
            if (r0 != r8) goto L_0x045f
            return r8
        L_0x01ad:
            r3 = 2
            boolean r2 = r1.hasAddress(r3)
            if (r2 == 0) goto L_0x01c0
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$navigateCallback$2$1 r2 = r16.k()
            r1.startNaviToAddress(r3, r2)
            r16.a(r17)
            goto L_0x045f
        L_0x01c0:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI05_P02
            r0.e(r7, r1)
            goto L_0x045f
        L_0x01c7:
            java.lang.String r3 = "navigate_home"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x01d1
            goto L_0x027d
        L_0x01d1:
            java.lang.String r2 = r5.getString(r15)
            if (r2 == 0) goto L_0x01e3
            r4.L$0 = r7
            r1 = 4
            r4.label = r1
            java.lang.Object r0 = r0.n(r7, r2, r14, r4)
            if (r0 != r8) goto L_0x045f
            return r8
        L_0x01e3:
            boolean r2 = r1.hasAddress(r14)
            if (r2 == 0) goto L_0x01f5
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$navigateCallback$2$1 r2 = r16.k()
            r1.startNaviToAddress(r14, r2)
            r16.a(r17)
            goto L_0x045f
        L_0x01f5:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI04_P02
            r0.e(r7, r1)
            goto L_0x045f
        L_0x01fc:
            java.lang.String r3 = "switch_destination"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0207
            goto L_0x027d
        L_0x0207:
            boolean r1 = r1.isNaving()
            if (r1 == 0) goto L_0x024c
            java.lang.String r1 = r5.getString(r15)
            if (r1 != 0) goto L_0x0215
            r2 = r12
            goto L_0x0216
        L_0x0215:
            r2 = r1
        L_0x0216:
            int r1 = r2.length()
            if (r1 != 0) goto L_0x0223
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI02_P01
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0223:
            java.lang.String r1 = "poi_category"
            boolean r1 = r5.containsKey(r1)
            if (r1 != 0) goto L_0x0239
            com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer r1 = com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer.f8690a
            r3 = 0
            boolean r1 = r1.i(r2, r3, r3)
            if (r1 == 0) goto L_0x0239
            r16.a(r17)
            goto L_0x045f
        L_0x0239:
            r4.L$0 = r7
            r1 = 6
            r4.label = r1
            r3 = 0
            r5 = 4
            r6 = 0
            r0 = r16
            r1 = r17
            java.lang.Object r0 = o(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x045f
            return r8
        L_0x024c:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI14_P01
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0253:
            java.lang.String r3 = "refresh_route"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x025c
            goto L_0x027d
        L_0x025c:
            boolean r2 = r1.isNaving()
            if (r2 == 0) goto L_0x0276
            boolean r1 = r1.refreshNavi()
            if (r1 == 0) goto L_0x026f
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI07_P01
            r0.e(r7, r1)
            goto L_0x045f
        L_0x026f:
            int r1 = com.xjsd.ai.assistant.phone.R.string.tts_navi_rf_route_fail
            r0.d(r7, r1)
            goto L_0x045f
        L_0x0276:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI01_P08
            r0.e(r7, r1)
            goto L_0x045f
        L_0x027d:
            r16.s(r17)
            goto L_0x045f
        L_0x0282:
            boolean r4 = r3.equals(r10)
            if (r4 != 0) goto L_0x028a
            goto L_0x045c
        L_0x028a:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r10)
            java.lang.String r4 = "target"
            java.lang.String r4 = r5.getString(r4)
            if (r4 != 0) goto L_0x0298
            r4 = r12
        L_0x0298:
            java.lang.String r6 = "map"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x02fb
            boolean r4 = r1.isNaving()
            if (r3 == 0) goto L_0x02d7
            java.lang.String r2 = r5.getString(r9)
            if (r2 != 0) goto L_0x02ad
            goto L_0x02ae
        L_0x02ad:
            r12 = r2
        L_0x02ae:
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode$Companion r2 = com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode.Companion
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode r2 = r2.a(r12)
            int r3 = r12.length()
            if (r3 <= 0) goto L_0x02d0
            boolean r3 = r1.isNaving()
            if (r3 == 0) goto L_0x02d0
            int r2 = r2.getCode()
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$navigateCallback$2$1 r3 = r16.k()
            r1.changeNavi(r2, r3)
            r16.a(r17)
            goto L_0x045f
        L_0x02d0:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI02_P01
            r0.e(r7, r1)
            goto L_0x045f
        L_0x02d7:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            boolean r1 = r1.h(r2)
            if (r1 != 0) goto L_0x02ea
            if (r4 == 0) goto L_0x02e4
            goto L_0x02ea
        L_0x02e4:
            com.xjsd.ai.assistant.template.TtsAppTemplate r1 = com.xjsd.ai.assistant.template.TtsAppTemplate.APP02_R02
            r0.e(r7, r1)
            goto L_0x02f6
        L_0x02ea:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            r1.d(r2)
            com.xjsd.ai.assistant.template.TtsAppTemplate r1 = com.xjsd.ai.assistant.template.TtsAppTemplate.APP02_R01
            r0.e(r7, r1)
        L_0x02f6:
            r16.clean()
            goto L_0x045f
        L_0x02fb:
            java.lang.String r1 = "realtime_traffic"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0313
            com.xjsd.ai.assistant.skill.navigation.NavManager r1 = com.xjsd.ai.assistant.skill.navigation.NavManager.j()
            com.xjsd.ai.assistant.template.TtsTemplate r1 = r1.q(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0313:
            r16.s(r17)
            goto L_0x045f
        L_0x0318:
            java.lang.String r1 = "MapOpen"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0322
            goto L_0x045c
        L_0x0322:
            r4.L$0 = r7
            r4.label = r14
            java.lang.Object r0 = r0.p(r7, r4)
            if (r0 != r8) goto L_0x045f
            return r8
        L_0x032d:
            java.lang.String r1 = "Select"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0337
            goto L_0x045c
        L_0x0337:
            java.lang.String r1 = "index"
            java.lang.String r1 = r5.getString(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0384
            java.util.List r2 = r0.d
            if (r2 == 0) goto L_0x0384
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0351
            goto L_0x0384
        L_0x0351:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 < r14) goto L_0x037d
            java.util.List r2 = r0.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.size()
            if (r1 <= r2) goto L_0x0366
            goto L_0x037d
        L_0x0366:
            java.util.List r2 = r0.d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r1 = r1 - r14
            java.lang.Object r1 = r2.get(r1)
            com.upuphone.xr.interconnect.entity.PoiResult r1 = (com.upuphone.xr.interconnect.entity.PoiResult) r1
            r0.v(r1)
            r16.r(r17)
            r16.clean()
            goto L_0x045f
        L_0x037d:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r1 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL03_P01
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0384:
            r16.s(r17)
            goto L_0x045f
        L_0x0389:
            java.lang.String r1 = "Navigate"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0393
            goto L_0x045c
        L_0x0393:
            com.alibaba.fastjson.JSONObject r1 = r5.getJSONObject(r15)
            if (r1 == 0) goto L_0x0456
            java.lang.String r2 = "name"
            java.lang.String r3 = r1.getString(r2)
            if (r3 == 0) goto L_0x0456
            int r3 = r3.length()
            if (r3 != 0) goto L_0x03a9
            goto L_0x0456
        L_0x03a9:
            java.lang.String r2 = r1.getString(r2)
            java.lang.String r3 = r5.getString(r9)
            java.lang.String r5 = r5.getString(r11)
            java.lang.String r1 = r1.getString(r13)
            java.lang.String r6 = "category"
            boolean r1 = kotlin.text.StringsKt.equals(r6, r1, r14)
            java.lang.String r6 = "unsupport"
            boolean r9 = kotlin.text.StringsKt.equals(r6, r3, r14)
            if (r9 != 0) goto L_0x0450
            boolean r6 = kotlin.text.StringsKt.equals(r6, r5, r14)
            if (r6 == 0) goto L_0x03d0
            goto L_0x0450
        L_0x03d0:
            r6 = 0
            if (r3 == 0) goto L_0x03de
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode$Companion r9 = com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode.Companion
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode r3 = r9.a(r3)
            r0.u(r3)
            r3 = r14
            goto L_0x03df
        L_0x03de:
            r3 = r6
        L_0x03df:
            if (r5 == 0) goto L_0x03eb
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer$Companion r6 = com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer.Companion
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer r5 = r6.a(r5)
            r0.t(r5)
            goto L_0x03ec
        L_0x03eb:
            r14 = r6
        L_0x03ec:
            if (r1 == 0) goto L_0x0404
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r4.L$0 = r7
            r1 = 2
            r4.label = r1
            r3 = 0
            r5 = 4
            r6 = 0
            r0 = r16
            r1 = r17
            java.lang.Object r0 = o(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x045f
            return r8
        L_0x0404:
            com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer r1 = com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer.f8690a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.xjsd.ai.assistant.skill.navigation.optimize.NavPoiHistory r1 = r1.e(r2)
            if (r1 == 0) goto L_0x043d
            java.lang.String r2 = "default"
            if (r3 != 0) goto L_0x0423
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode$Companion r3 = com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode.Companion
            java.lang.String r4 = r1.getNavMode()
            if (r4 != 0) goto L_0x041c
            r4 = r2
        L_0x041c:
            com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode r3 = r3.a(r4)
            r0.u(r3)
        L_0x0423:
            if (r14 != 0) goto L_0x0436
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer$Companion r3 = com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer.Companion
            java.lang.String r4 = r1.getRouteMode()
            if (r4 != 0) goto L_0x042e
            goto L_0x042f
        L_0x042e:
            r2 = r4
        L_0x042f:
            com.xjsd.ai.assistant.skill.navigation.enums.NaviRoutePrefer r2 = r3.a(r2)
            r0.t(r2)
        L_0x0436:
            r0.v(r1)
            r16.a(r17)
            goto L_0x045f
        L_0x043d:
            r4.L$0 = r7
            r1 = 3
            r4.label = r1
            r3 = 0
            r5 = 4
            r6 = 0
            r0 = r16
            r1 = r17
            java.lang.Object r0 = o(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x045f
            return r8
        L_0x0450:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI01_P09
            r0.e(r7, r1)
            goto L_0x045f
        L_0x0456:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r1 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI15_P02
            r0.e(r7, r1)
            goto L_0x045f
        L_0x045c:
            r16.s(r17)
        L_0x045f:
            r0 = r7
        L_0x0460:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final NavNlpPreprocessor$navigateCallback$2.AnonymousClass1 k() {
        return (NavNlpPreprocessor$navigateCallback$2.AnonymousClass1) this.e.getValue();
    }

    public final Object l(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        SuperAppAbilityManager.e().f().startLocation(new NavNlpPreprocessor$queryLocation$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final Object m(String str, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        SuperAppAbilityManager.e().f().poiSearch(0, str, new NavNlpPreprocessor$searchPoi$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.xjsd.ai.assistant.nlu.bean.NluResponse} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(com.xjsd.ai.assistant.nlu.bean.NluResponse r5, java.lang.String r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$searchPoiToNavigate$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$searchPoiToNavigate$1 r0 = (com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$searchPoiToNavigate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$searchPoiToNavigate$1 r0 = new com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor$searchPoiToNavigate$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.xjsd.ai.assistant.nlu.bean.NluResponse r5 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r5
            java.lang.Object r4 = r0.L$0
            com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor r4 = (com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005f
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x0049
            com.xjsd.ai.assistant.template.TtsNaviTemplate r6 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI02_P01
            r4.e(r5, r6)
            goto L_0x009d
        L_0x0049:
            r4.q(r7)
            r7 = 0
            r4.d = r7
            com.xjsd.ai.assistant.skill.navigation.NavHelper.b()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r4.m(r6, r0)
            if (r8 != r1) goto L_0x005f
            return r1
        L_0x005f:
            java.util.List r8 = (java.util.List) r8
            boolean r6 = r8.isEmpty()
            if (r6 == 0) goto L_0x006d
            com.xjsd.ai.assistant.template.TtsNaviTemplate r6 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI15_P02
            r4.e(r5, r6)
            goto L_0x009d
        L_0x006d:
            int r6 = r8.size()
            if (r6 != r3) goto L_0x0081
            r6 = 0
            java.lang.Object r6 = r8.get(r6)
            com.upuphone.xr.interconnect.entity.PoiResult r6 = (com.upuphone.xr.interconnect.entity.PoiResult) r6
            r4.v(r6)
            r4.a(r5)
            goto L_0x009d
        L_0x0081:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r6 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI15_P01
            r4.e(r5, r6)
            com.alibaba.fastjson.JSONObject r5 = r5.getPayload()
            java.lang.String r6 = "getPayload(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = "result"
            java.lang.String r7 = com.xjsd.ai.assistant.json.GsonUtils.e(r8)
            r5.put(r6, r7)
            r4.d = r8
            com.xjsd.ai.assistant.skill.navigation.NavHelper.a(r8, r3)
        L_0x009d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor.n(com.xjsd.ai.assistant.nlu.bean.NluResponse, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Subscribe
    public final void onReceiveFlutterNavigationEvent(@NotNull FlutterNavigationEvent flutterNavigationEvent) {
        Intrinsics.checkNotNullParameter(flutterNavigationEvent, "event");
        v((PoiResult) GsonUtils.a(flutterNavigationEvent.a(), PoiResult.class));
    }

    public Object p(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.f(this, nluResponse, continuation);
    }

    public final void q(int i) {
        this.c = i;
        ILog.a("NavNlpPreprocessor", "导航目的地类型->" + i);
    }

    public void r(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.g(this, nluResponse);
    }

    public void s(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.h(this, nluResponse);
    }

    public final void t(NaviRoutePrefer naviRoutePrefer) {
        this.b = naviRoutePrefer;
        String mode = naviRoutePrefer.getMode();
        ILog.a("NavNlpPreprocessor", "路线偏好->" + mode);
    }

    public final void u(NavTravelMode navTravelMode) {
        this.f8487a = navTravelMode;
        String mode = navTravelMode.getMode();
        ILog.a("NavNlpPreprocessor", "导航方式->" + mode);
    }

    public final void v(PoiResult poiResult) {
        if (this.c != 0) {
            SuperAppAbilityManager.e().f().saveNaviAddress(poiResult, this.c);
        }
        NavOptimizer.f8690a.j(poiResult, new NavManager.NavConfig(this.f8487a, this.b));
        String mode = this.f8487a.getMode();
        ILog.a("NavNlpPreprocessor", "startNav: 导航方式->" + mode);
        String mode2 = this.b.getMode();
        ILog.a("NavNlpPreprocessor", "startNav: 路线偏好->" + mode2);
        SuperAppAbilityManager.e().f().startNavi(this.f8487a.getCode(), this.b.getCode(), poiResult, new NavNlpPreprocessor$startNav$1());
        clean();
    }
}
