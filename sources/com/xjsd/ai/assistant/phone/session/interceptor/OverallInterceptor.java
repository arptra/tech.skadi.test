package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.asr.bean.AsrResult;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrAudioInfo;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.chatgpt.model.minimax.LlmRecommend;
import com.xjsd.ai.assistant.chatgpt.model.minimax.LlmRecommendCopy;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.cloud.CloudEventListener;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluAbility;
import com.xjsd.ai.assistant.nlu.NluDataCreator;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.bean.OfflineAsrBean;
import com.xjsd.ai.assistant.phone.event.AccessibilityShotEvent;
import com.xjsd.ai.assistant.phone.event.NetworkEvent;
import com.xjsd.ai.assistant.phone.event.TimerTimeoutEvent;
import com.xjsd.ai.assistant.phone.export.FeedAudioDataToCloudStrategy;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.phone.helper.VrStateHelper;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.asr.AsrTransData;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupRes;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010\u001fJC\u0010(\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020#2*\u0010'\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020&0%0$\"\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0004\b(\u0010)JK\u0010+\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020#2\u0006\u0010*\u001a\u00020#2*\u0010'\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020&0%0$\"\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0015H\u0002¢\u0006\u0004\b-\u0010\u001fJ\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020#H\u0002¢\u0006\u0004\b0\u00101J\u001f\u00105\u001a\u00020\u00152\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020#H\u0002¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\u00152\u0006\u00107\u001a\u00020\tH@¢\u0006\u0004\b8\u00109J\u0018\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020:H@¢\u0006\u0004\b<\u0010=J\u0018\u0010?\u001a\u00020\u00152\u0006\u0010;\u001a\u00020>H@¢\u0006\u0004\b?\u0010@J\u0018\u0010B\u001a\u00020\u00152\u0006\u0010A\u001a\u00020>H@¢\u0006\u0004\bB\u0010@J\u0018\u0010C\u001a\u00020\u00152\u0006\u0010A\u001a\u00020>H@¢\u0006\u0004\bC\u0010@J\u0018\u0010F\u001a\u00020\u00152\u0006\u0010E\u001a\u00020DH@¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020\u00152\u0006\u0010E\u001a\u00020DH@¢\u0006\u0004\bH\u0010GJ@\u0010O\u001a\u00020\u00152\u0006\u0010I\u001a\u0002022'\u0010N\u001a#\b\u0001\u0012\u0004\u0012\u00020K\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150L\u0012\u0006\u0012\u0004\u0018\u00010&0J¢\u0006\u0002\bMH\u0002¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u00152\u0006\u0010Q\u001a\u000202H\u0002¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\u0015H@¢\u0006\u0004\bT\u0010UJ\u0018\u0010X\u001a\u00020\u00152\u0006\u0010W\u001a\u00020VH@¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u00152\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b\\\u0010]J \u0010`\u001a\u00020\u00152\u0006\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020#H@¢\u0006\u0004\b`\u0010aR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010cR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010cR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010eR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010gR\u0014\u0010k\u001a\u00020h8\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001b\u0010q\u001a\u00020l8BX\u0002¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u0016\u0010s\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u00105R\u0014\u0010w\u001a\u00020t8\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020x8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u00100R\u0018\u0010}\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001c\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002020~8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020t8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020t8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020t8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020t8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020V0\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00020\u00078BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/AbsInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "session", "Lkotlinx/coroutines/flow/Flow;", "", "audioSource", "", "vadSource", "Lcom/xjsd/ai/assistant/phone/bean/OfflineAsrBean;", "offlineAsrSource", "Lcom/xjsd/ai/assistant/cloud/CloudAbility;", "cloudAbility", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "Lcom/xjsd/ai/assistant/nlu/NluAbility;", "nluAbility", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lcom/xjsd/ai/assistant/cloud/CloudAbility;Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;Lcom/xjsd/ai/assistant/nlu/NluAbility;)V", "Lcom/xjsd/ai/assistant/phone/event/NetworkEvent;", "event", "", "onReceiveNetworkEvent", "(Lcom/xjsd/ai/assistant/phone/event/NetworkEvent;)V", "Lcom/xjsd/ai/assistant/phone/event/AccessibilityShotEvent;", "onReceiveAccessibilityShotEvent", "(Lcom/xjsd/ai/assistant/phone/event/AccessibilityShotEvent;)V", "Lcom/xjsd/ai/assistant/phone/event/TimerTimeoutEvent;", "onReceiveTimerTimeoutEvent", "(Lcom/xjsd/ai/assistant/phone/event/TimerTimeoutEvent;)V", "f", "()V", "h", "i", "g", "", "", "Lkotlin/Pair;", "", "data", "L", "(Ljava/lang/String;[Lkotlin/Pair;)V", "log", "K", "(Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", "Y", "traceId", "Lcom/xjsd/ai/assistant/cloud/InitCloudParams;", "J", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/cloud/InitCloudParams;", "", "isSuccess", "message", "Z", "(ZLjava/lang/String;)V", "offlineAsrBean", "T", "(Lcom/xjsd/ai/assistant/phone/bean/OfflineAsrBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjsd/ai/assistant/asr/bean/AsrResult;", "asrResult", "V", "(Lcom/xjsd/ai/assistant/asr/bean/AsrResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjsd/ai/assistant/protocol/asr/AsrTransData;", "O", "(Lcom/xjsd/ai/assistant/protocol/asr/AsrTransData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asrTransData", "X", "U", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "S", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "W", "isOfflineJob", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "block", "I", "(ZLkotlin/jvm/functions/Function2;)V", "interruptLlm", "a0", "(Z)V", "b0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "llmResponse", "R", "(Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "llmRecommend", "Q", "(Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;)V", "sessionId", "code", "P", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Lcom/xjsd/ai/assistant/cloud/CloudAbility;", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "Lcom/xjsd/ai/assistant/nlu/NluAbility;", "Ljava/util/concurrent/atomic/AtomicInteger;", "j", "Ljava/util/concurrent/atomic/AtomicInteger;", "produceCount", "Lcom/xjsd/ai/assistant/phone/export/FeedAudioDataToCloudStrategy;", "k", "Lkotlin/Lazy;", "N", "()Lcom/xjsd/ai/assistant/phone/export/FeedAudioDataToCloudStrategy;", "feedAudioDataToCloudStrategy", "l", "isNetworkAvailable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "m", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cloudConnectRef", "", "n", "asrFinalTimestamp", "o", "Ljava/lang/Boolean;", "glassAccessibilityHit", "Lkotlinx/coroutines/channels/Channel;", "p", "Lkotlinx/coroutines/channels/Channel;", "glassAccessibilityHitChannel", "Lkotlinx/coroutines/sync/Mutex;", "q", "Lkotlinx/coroutines/sync/Mutex;", "mNluHandleLock", "r", "onlineNluHandleRef", "s", "offlineNlpHandleRef", "t", "asrFirstFrameDotRef", "u", "llmFirstFrameDotRef", "Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudOptions;", "v", "Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudOptions;", "mAsrCloudOptions", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "w", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "llmResponseFlow", "M", "()I", "controlType", "x", "CloudResult", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOverallInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OverallInterceptor.kt\ncom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,1003:1\n120#2,10:1004\n120#2,10:1014\n*S KotlinDebug\n*F\n+ 1 OverallInterceptor.kt\ncom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor\n*L\n691#1:1004,10\n794#1:1014,10\n*E\n"})
public final class OverallInterceptor extends AbsInterceptor {
    public static final Companion x = new Companion((DefaultConstructorMarker) null);
    public final Flow d;
    public final Flow e;
    public final Flow f;
    public final CloudAbility g;
    public final CacheAbility h;
    public final NluAbility i;
    public final AtomicInteger j = new AtomicInteger(0);
    public final Lazy k = LazyKt.lazy(new OverallInterceptor$feedAudioDataToCloudStrategy$2(this));
    public boolean l;
    public final AtomicBoolean m = new AtomicBoolean(false);
    public long n;
    public Boolean o;
    public final Channel p = ChannelKt.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
    public final Mutex q = MutexKt.b(false, 1, (Object) null);
    public final AtomicBoolean r = new AtomicBoolean(false);
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final AtomicBoolean t = new AtomicBoolean(false);
    public final AtomicBoolean u = new AtomicBoolean(false);
    public final AsrCloudOptions v;
    public final MutableSharedFlow w;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;", "", "()V", "CloudAsrResult", "CloudError", "CloudLlmRecommendResult", "CloudLlmResult", "CloudNluResult", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudAsrResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudError;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudLlmRecommendResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudLlmResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudNluResult;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class CloudResult {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudAsrResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;", "Lcom/xjsd/ai/assistant/asr/bean/AsrResult;", "asr", "<init>", "(Lcom/xjsd/ai/assistant/asr/bean/AsrResult;)V", "a", "Lcom/xjsd/ai/assistant/asr/bean/AsrResult;", "()Lcom/xjsd/ai/assistant/asr/bean/AsrResult;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class CloudAsrResult extends CloudResult {

            /* renamed from: a  reason: collision with root package name */
            public final AsrResult f8580a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CloudAsrResult(AsrResult asrResult) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(asrResult, "asr");
                this.f8580a = asrResult;
            }

            public final AsrResult a() {
                return this.f8580a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudError;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;", "", "sessionId", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class CloudError extends CloudResult {

            /* renamed from: a  reason: collision with root package name */
            public final String f8581a;
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CloudError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
                Intrinsics.checkNotNullParameter(str2, "code");
                this.f8581a = str;
                this.b = str2;
            }

            public final String a() {
                return this.b;
            }

            public final String b() {
                return this.f8581a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudLlmRecommendResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "llmRecommend", "<init>", "(Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;)V", "a", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "()Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class CloudLlmRecommendResult extends CloudResult {

            /* renamed from: a  reason: collision with root package name */
            public final LlmRecommend f8582a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CloudLlmRecommendResult(LlmRecommend llmRecommend) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(llmRecommend, "llmRecommend");
                this.f8582a = llmRecommend;
            }

            public final LlmRecommend a() {
                return this.f8582a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudLlmResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "llm", "<init>", "(Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;)V", "a", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "()Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class CloudLlmResult extends CloudResult {

            /* renamed from: a  reason: collision with root package name */
            public final LlmResponse f8583a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CloudLlmResult(LlmResponse llmResponse) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(llmResponse, "llm");
                this.f8583a = llmResponse;
            }

            public final LlmResponse a() {
                return this.f8583a;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult$CloudNluResult;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nlu", "<init>", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)V", "a", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "()Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class CloudNluResult extends CloudResult {

            /* renamed from: a  reason: collision with root package name */
            public final NluResponse f8584a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CloudNluResult(NluResponse nluResponse) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(nluResponse, "nlu");
                this.f8584a = nluResponse;
            }

            public final NluResponse a() {
                return this.f8584a;
            }
        }

        public /* synthetic */ CloudResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public CloudResult() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$Companion;", "", "()V", "HANDLED_TIMEOUT", "", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor(Session session, Flow flow, Flow flow2, Flow flow3, CloudAbility cloudAbility, CacheAbility cacheAbility, NluAbility nluAbility) {
        super(session);
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(flow, "audioSource");
        Intrinsics.checkNotNullParameter(flow2, "vadSource");
        Intrinsics.checkNotNullParameter(flow3, "offlineAsrSource");
        Intrinsics.checkNotNullParameter(cloudAbility, "cloudAbility");
        Intrinsics.checkNotNullParameter(cacheAbility, "cacheAbility");
        Intrinsics.checkNotNullParameter(nluAbility, "nluAbility");
        this.d = flow;
        this.e = flow2;
        this.f = flow3;
        this.g = cloudAbility;
        this.h = cacheAbility;
        this.i = nluAbility;
        AsrCloudOptions asrCloudOptions = new AsrCloudOptions();
        AsrAudioInfo asrAudioInfo = new AsrAudioInfo();
        asrAudioInfo.setAudioType(AsrConstants.AUDIO_OPUS);
        asrAudioInfo.setChannel(1);
        asrAudioInfo.setSampleBytes(2);
        asrAudioInfo.setSampleRate(16000);
        asrCloudOptions.setData(asrAudioInfo);
        asrCloudOptions.setEvent(AsrConstants.SYNC_AUDIO_INFO);
        this.v = asrCloudOptions;
        this.w = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    public final void I(boolean z, Function2 function2) {
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new OverallInterceptor$awaitAccessibilityResult$1(this, function2, z, (Continuation<? super OverallInterceptor$awaitAccessibilityResult$1>) null), 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.xjsd.ai.assistant.cloud.InitCloudParams J(java.lang.String r12) {
        /*
            r11 = this;
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r0 = r11.h
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r2 = "isAsrOnlyWakeup"
            java.lang.Object r0 = r0.getCacheWithDefault(r2, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r2 = r11.h
            java.lang.String r3 = "wechat_transfer"
            java.lang.Object r1 = r2.getCacheWithDefault(r3, r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r2 = r11.h
            java.lang.String r3 = "feedAudioDataType"
            java.lang.String r4 = "opus"
            java.lang.Object r2 = r2.getCacheWithDefault(r3, r4)
            java.lang.String r2 = (java.lang.String) r2
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r3 = r11.h
            java.lang.String r4 = "sceneId"
            java.lang.String r5 = "NORMAL"
            java.lang.Object r3 = r3.getCacheWithDefault(r4, r5)
            java.lang.String r3 = (java.lang.String) r3
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r4 = r11.h
            java.lang.String r5 = "IotDeviceId"
            java.lang.String r6 = ""
            java.lang.Object r4 = r4.getCacheWithDefault(r5, r6)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = com.xjsd.ai.assistant.core.util.DeviceUtils.a()
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r7 = r11.h
            java.lang.String r8 = "mzUid"
            java.lang.Object r7 = r7.getCacheWithDefault(r8, r6)
            java.lang.String r7 = (java.lang.String) r7
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r8 = r11.v
            com.xjsd.ai.assistant.asr.engine.protocol.AsrAudioInfo r8 = r8.getData()
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r9 = r11.h
            java.lang.String r10 = "hotWords"
            java.lang.Object r9 = r9.getCache(r10)
            if (r9 == 0) goto L_0x0061
            java.util.List r9 = (java.util.List) r9
            r8.setHotWords(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0062
        L_0x0061:
            r9 = 0
        L_0x0062:
            if (r9 != 0) goto L_0x006b
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            r8.setHotWords(r9)
        L_0x006b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.booleanValue()
            r9 = 1
            r10 = 0
            if (r0 == 0) goto L_0x007e
            java.lang.String r0 = "WECHAT_TRANSFER"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0087
        L_0x007e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r0 = r1.booleanValue()
            if (r0 == 0) goto L_0x0089
        L_0x0087:
            r0 = r9
            goto L_0x008a
        L_0x0089:
            r0 = r10
        L_0x008a:
            r8.setEnablePunctuation(r0)
            r8.setAudioType(r2)
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            r0.setData(r8)
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            r0.setDeviceId(r5)
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            com.xjsd.ai.assistant.phone.session.Session r1 = r11.d()
            java.lang.String r1 = r1.b()
            r0.setRequestId(r1)
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            r0.setIotDeviceId(r4)
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            r0.setAccountId(r7)
            boolean r0 = com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea
            if (r0 == 0) goto L_0x00bd
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            java.lang.String r1 = "en-US"
            r0.setInputLanguageCode(r1)
            goto L_0x00c4
        L_0x00bd:
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r0 = r11.v
            java.lang.String r1 = "en-GB"
            r0.setInputLanguageCode(r1)
        L_0x00c4:
            com.xjsd.ai.assistant.cloud.InitCloudParams r0 = new com.xjsd.ai.assistant.cloud.InitCloudParams
            r0.<init>()
            r0.setTraceId(r12)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData r2 = new com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData
            r2.<init>()
            java.lang.String r3 = "asr"
            r2.setType(r3)
            com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions r3 = r11.v
            r2.setPayload(r3)
            r1.add(r2)
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData r2 = new com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData
            r2.<init>()
            java.lang.String r3 = "nlp"
            r2.setType(r3)
            com.xjsd.ai.assistant.nlu.NluAbility r11 = r11.i
            com.xjsd.ai.assistant.nlu.bean.TalkInfo r3 = new com.xjsd.ai.assistant.nlu.bean.TalkInfo
            r3.<init>(r12, r6, r9)
            com.xjsd.ai.assistant.nlu.bean.NluRequest r11 = r11.getTalkReq(r3)
            com.xjsd.ai.assistant.nlu.bean.MetaData r12 = r11.getMetadata()
            r12.setOriginType(r10)
            com.xjsd.ai.assistant.nlu.bean.MetaData r12 = r11.getMetadata()
            java.lang.String r3 = com.xjsd.ai.assistant.core.util.DeviceUtils.a()
            r12.setDeviceId(r3)
            com.xjsd.ai.assistant.nlu.bean.MetaData r12 = r11.getMetadata()
            r12.setSessionFirstFlag(r10)
            r2.setPayload(r11)
            r1.add(r2)
            r0.setInitData(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor.J(java.lang.String):com.xjsd.ai.assistant.cloud.InitCloudParams");
    }

    public final void K(String str, String str2, Pair... pairArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to("traceId", d().b()));
        spreadBuilder.addSpread(pairArr);
        DotUtil.a(str, str2, (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    public final void L(String str, Pair... pairArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to("traceId", d().b()));
        spreadBuilder.addSpread(pairArr);
        DotUtil.d(str, (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    public final int M() {
        Object cacheWithDefault = this.h.getCacheWithDefault("lastWakeupType", 1);
        Intrinsics.checkNotNullExpressionValue(cacheWithDefault, "getCacheWithDefault(...)");
        return ((Number) cacheWithDefault).intValue();
    }

    public final FeedAudioDataToCloudStrategy N() {
        return (FeedAudioDataToCloudStrategy) this.k.getValue();
    }

    public final Object O(AsrTransData asrTransData, Continuation continuation) {
        boolean isOfflineResult = asrTransData.isOfflineResult();
        if (!isOfflineResult || !this.l || !this.m.get()) {
            Communicator.b(M() == 3 ? 105 : 101, asrTransData, new OverallInterceptor$handleAsrTransData$2());
        }
        if (asrTransData.getType() == 0) {
            return Unit.INSTANCE;
        }
        if (M() == 3) {
            ILog.a("OverallInterceptor", "微信和GPT转写不进行NLU");
            return Unit.INSTANCE;
        }
        if (isOfflineResult) {
            K("vad_end", "offline asr耗时", TuplesKt.to("asr", asrTransData.getText()));
        } else {
            K("vad_end", "online asr耗时", TuplesKt.to("asr", asrTransData.getText()));
        }
        this.n = System.currentTimeMillis();
        if (isOfflineResult) {
            Object X = X(asrTransData, continuation);
            return X == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? X : Unit.INSTANCE;
        }
        ExitTimer.f8563a.d();
        return Unit.INSTANCE;
    }

    public final Object P(String str, String str2, Continuation continuation) {
        ILog.a("OverallInterceptor", "收到cloud error, sessionId->" + str + ", code->" + str2);
        if (!VrStateHelper.f8567a.a()) {
            ILog.m("OverallInterceptor", "语音助理已退出流程，不处理");
            return Unit.INSTANCE;
        }
        switch (str2.hashCode()) {
            case 1507424:
                if (str2.equals("1001")) {
                    ILog.m("OverallInterceptor", "参数错误");
                    break;
                }
                break;
            case 1507425:
                if (str2.equals("1002")) {
                    ILog.m("OverallInterceptor", "音频解码错误");
                    break;
                }
                break;
            case 1507426:
                if (str2.equals("1003")) {
                    ILog.m("OverallInterceptor", "server主动关闭连接");
                    break;
                }
                break;
            case 1507427:
                if (str2.equals("1004")) {
                    ILog.m("OverallInterceptor", "业务错误(超过次数或流量限制)");
                    break;
                }
                break;
            case 1507428:
                if (str2.equals("1005")) {
                    ILog.m("OverallInterceptor", "识别结果为空");
                    break;
                }
                break;
        }
        if (DeviceUtils.d() && M() == 3) {
            AsrTransData asrTransData = new AsrTransData();
            asrTransData.setErrorCode(str2);
            Communicator.b(105, asrTransData, (SendMsgCallback) null);
            WakeupControlDelegate.g.i(new WakeupControl(0));
        }
        if (!Intrinsics.areEqual((Object) (Boolean) this.h.getCacheWithDefault("isNetworkAvailable", Boxing.boxBoolean(false)), (Object) Boxing.boxBoolean(true))) {
            ILog.a("OverallInterceptor", "收到cloud error，此时网络不可用，等待兜底或离线指令结果");
        } else if (M() != 3) {
            NluResponse a2 = Intrinsics.areEqual((Object) str2, (Object) "1005") ? NluDataCreator.a("ASR_RESULT_IS_EMPTY") : NluDataCreator.a("ASR_ERROR");
            Intrinsics.checkNotNull(a2);
            Object S = S(a2, continuation);
            return S == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? S : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void Q(LlmRecommend llmRecommend) {
        String[] recommend_queries;
        if (!this.s.get() && (recommend_queries = llmRecommend.getRecommend_queries()) != null && recommend_queries.length != 0) {
            Communicator.b(123, new LlmRecommendCopy(llmRecommend.getRecommend_queries()[0], llmRecommend.getVersion_code()), new OverallInterceptor$handleLlmRecommendResult$1());
        }
    }

    public final Object R(LlmResponse llmResponse, Continuation continuation) {
        if (this.s.get()) {
            return Unit.INSTANCE;
        }
        ExitTimer.f8563a.c();
        if (this.u.get()) {
            this.u.set(false);
            L("receive_llm_first_frame", new Pair[0]);
            K("vad_end", "vad_end->llm首帧 耗时", new Pair[0]);
            K("receive_online_nlu", "nlu->llm首帧 耗时", new Pair[0]);
        }
        if (llmResponse.getBase_status() == 2) {
            L("receive_llm_last_frame", new Pair[0]);
        }
        Object emit = this.w.emit(llmResponse, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Object S(NluResponse nluResponse, Continuation continuation) {
        ILog.a("OverallInterceptor", "handleNluResult: nlu response->" + nluResponse);
        ILog.e("online_nlu_result", nluResponse);
        ILog.f("online_nlu_result_pre_time");
        I(false, new OverallInterceptor$handleNluResult$2(this, nluResponse, (Continuation<? super OverallInterceptor$handleNluResult$2>) null));
        return Unit.INSTANCE;
    }

    public final Object T(OfflineAsrBean offlineAsrBean, Continuation continuation) {
        boolean z = offlineAsrBean.getType() == 1;
        if (this.l && this.m.get() && !z) {
            return Unit.INSTANCE;
        }
        AsrTransData asrTransData = new AsrTransData();
        asrTransData.setId(d().b());
        asrTransData.setText(offlineAsrBean.getText());
        asrTransData.setType(offlineAsrBean.getType());
        asrTransData.setOfflineResult(true);
        asrTransData.setOfflineCmd(offlineAsrBean.getCmd());
        if (z) {
            ILog.e("ts_phone_asr_offline", asrTransData.getText());
            ILog.e("ts_phone_asr_arbitration", asrTransData.getText());
            int i2 = this.j.get();
            ILog.j("OverallInterceptor", "算法透出数据->" + i2);
        } else {
            ILog.e("ts_phone_asr_offline_partial", asrTransData.getText());
        }
        Object O = O(asrTransData, continuation);
        return O == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? O : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c A[SYNTHETIC, Splitter:B:22:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object U(com.xjsd.ai.assistant.protocol.asr.AsrTransData r14, kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOfflineResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOfflineResult$1 r0 = (com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOfflineResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOfflineResult$1 r0 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOfflineResult$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "OverallInterceptor"
            r5 = 0
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r13 = r0.L$2
            kotlinx.coroutines.sync.Mutex r13 = (kotlinx.coroutines.sync.Mutex) r13
            java.lang.Object r14 = r0.L$1
            com.xjsd.ai.assistant.protocol.asr.AsrTransData r14 = (com.xjsd.ai.assistant.protocol.asr.AsrTransData) r14
            java.lang.Object r0 = r0.L$0
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r0 = (com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor) r0
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r13
            r13 = r0
            goto L_0x006a
        L_0x003a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "handleOfflineResult: offline asr->"
            r15.append(r2)
            r15.append(r14)
            java.lang.String r15 = r15.toString()
            com.xjsd.ai.assistant.log.ILog.a(r4, r15)
            kotlinx.coroutines.sync.Mutex r15 = r13.q
            r0.L$0 = r13
            r0.L$1 = r14
            r0.L$2 = r15
            r0.label = r3
            java.lang.Object r0 = r15.c(r5, r0)
            if (r0 != r1) goto L_0x006a
            return r1
        L_0x006a:
            boolean r0 = com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x007c
            java.lang.String r13 = "handleOfflineResult: oversea not support offline word"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x0079:
            r13 = move-exception
            goto L_0x01e7
        L_0x007c:
            java.util.concurrent.atomic.AtomicBoolean r0 = r13.r     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x008f
            java.lang.String r13 = "handleOfflineResult: 已收到在线NLU结果并处理，拦截离线结果"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x008f:
            java.lang.String r14 = r14.getOfflineCmd()     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r0 = r13.h     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "sceneId"
            java.lang.String r2 = "NORMAL"
            java.lang.Object r0 = r0.getCacheWithDefault(r1, r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "CALL"
            boolean r1 = kotlin.text.StringsKt.equals(r0, r1, r3)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "online_nlu_result"
            r6 = 0
            if (r1 == 0) goto L_0x00fb
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x00b2
            r8 = r5
            goto L_0x00ba
        L_0x00b2:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.common.stks.OfflineKey r14 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.d(r14)     // Catch:{ all -> 0x0079 }
            r8 = r14
        L_0x00ba:
            if (r8 == 0) goto L_0x00ef
            java.lang.String r14 = "接听电话"
            java.lang.String r1 = r8.getText()     // Catch:{ all -> 0x0079 }
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r1)     // Catch:{ all -> 0x0079 }
            if (r14 != 0) goto L_0x00d7
            java.lang.String r14 = "挂断电话"
            java.lang.String r1 = r8.getText()     // Catch:{ all -> 0x0079 }
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r1)     // Catch:{ all -> 0x0079 }
            if (r14 != 0) goto L_0x00d7
            goto L_0x00ef
        L_0x00d7:
            com.xjsd.ai.assistant.log.ILog.e(r2, r8)     // Catch:{ all -> 0x0079 }
            java.lang.String r14 = "vad_end"
            java.lang.String r0 = "电话指令匹配耗时"
            kotlin.Pair[] r1 = new kotlin.Pair[r6]     // Catch:{ all -> 0x0079 }
            r13.K(r14, r0, r1)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.common.stks.OfflineKeyManager r7 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f8436a     // Catch:{ all -> 0x0079 }
            r11 = 4
            r12 = 0
            r9 = 1
            r10 = 0
            com.xjsd.ai.assistant.common.stks.OfflineKeyManager.b(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0079 }
            goto L_0x00f2
        L_0x00ef:
            com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer.a(r0)     // Catch:{ all -> 0x0079 }
        L_0x00f2:
            r13.a0(r3)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x00fb:
            boolean r0 = com.xjsd.ai.assistant.core.util.DeviceUtils.b()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0116
            boolean r0 = com.xjsd.ai.assistant.phone.NewFunctionCompact.b()     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0116
            boolean r0 = r13.l     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0116
            java.lang.String r13 = "handleOfflineResult: Air眼镜且不支持增强离线指令词且有网，不走离线匹配"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x0116:
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r0 = r13.h     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "isInChatGptScene"
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ all -> 0x0079 }
            java.lang.Object r0 = r0.getCacheWithDefault(r1, r7)     // Catch:{ all -> 0x0079 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0127
            goto L_0x012e
        L_0x0127:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0079 }
            boolean r6 = r0.booleanValue()     // Catch:{ all -> 0x0079 }
        L_0x012e:
            if (r6 == 0) goto L_0x013b
            java.lang.String r13 = "handleOfflineResult: 角色扮演场景，离线指令不处理，走在线NLU"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x013b:
            com.xjsd.ai.assistant.common.manager.VuiHandlerManager r0 = com.xjsd.ai.assistant.common.manager.VuiHandlerManager.d     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.d()     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "systemsetting"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x016d
            java.lang.String r0 = "SwitchSound"
            java.lang.String r1 = com.xjsd.ai.assistant.common.util.CacheUtil.b()     // Catch:{ all -> 0x0079 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0162
            java.lang.String r0 = "Switch"
            java.lang.String r1 = com.xjsd.ai.assistant.common.util.CacheUtil.b()     // Catch:{ all -> 0x0079 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x016d
        L_0x0162:
            java.lang.String r13 = "handleOfflineResult: 音色切换场景，离线指令不处理，走在线NLU"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x016d:
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x019d
            boolean r14 = r13.l     // Catch:{ all -> 0x0079 }
            if (r14 != 0) goto L_0x0192
            java.lang.String r14 = "handleOfflineResult: offline cmd is null, play network error"
            com.xjsd.ai.assistant.log.ILog.a(r4, r14)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r14 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder     // Catch:{ all -> 0x0079 }
            r14.<init>()     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r0 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P01     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r14 = r14.e(r0)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r14 = r14.a()     // Catch:{ all -> 0x0079 }
            r14.c()     // Catch:{ all -> 0x0079 }
            r13.a0(r3)     // Catch:{ all -> 0x0079 }
            goto L_0x0197
        L_0x0192:
            java.lang.String r13 = "handleOfflineResult: offline cmd is null, await online nlu"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
        L_0x0197:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x019d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.common.stks.OfflineKey r7 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.d(r14)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.log.ILog.e(r2, r7)     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x01bb
            com.xjsd.ai.assistant.common.stks.OfflineKeyManager r6 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager.f8436a     // Catch:{ all -> 0x0079 }
            r10 = 4
            r11 = 0
            r8 = 1
            r9 = 0
            com.xjsd.ai.assistant.common.stks.OfflineKeyManager.b(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0079 }
            r13.a0(r3)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            return r13
        L_0x01bb:
            boolean r14 = r13.l     // Catch:{ all -> 0x0079 }
            if (r14 == 0) goto L_0x01c5
            java.lang.String r13 = "handleOfflineResult: 未匹配到离线指令词，等在线NLU结果"
            com.xjsd.ai.assistant.log.ILog.a(r4, r13)     // Catch:{ all -> 0x0079 }
            goto L_0x01df
        L_0x01c5:
            java.lang.String r14 = "handleOfflineResult: 未匹配到离线指令词，播报网络问题"
            com.xjsd.ai.assistant.log.ILog.a(r4, r14)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r14 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder     // Catch:{ all -> 0x0079 }
            r14.<init>()     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r0 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P01     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r14 = r14.e(r0)     // Catch:{ all -> 0x0079 }
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r14 = r14.a()     // Catch:{ all -> 0x0079 }
            r14.c()     // Catch:{ all -> 0x0079 }
            r13.a0(r3)     // Catch:{ all -> 0x0079 }
        L_0x01df:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r15.d(r5)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x01e7:
            r15.d(r5)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor.U(com.xjsd.ai.assistant.protocol.asr.AsrTransData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object V(AsrResult asrResult, Continuation continuation) {
        boolean d2 = asrResult.d();
        AsrTransData asrTransData = new AsrTransData();
        asrTransData.setId(asrResult.a());
        asrTransData.setText(asrResult.b());
        asrTransData.setType(asrResult.c());
        asrTransData.setOfflineResult(false);
        if (d2) {
            ILog.e("ts_phone_asr_online", asrResult.b());
            ILog.e("ts_phone_asr_arbitration", asrResult.b());
            int i2 = this.j.get();
            ILog.j("OverallInterceptor", "算法透出数据->" + i2);
        } else {
            ILog.e("ts_phone_asr_online_partial", asrResult.b());
        }
        Object O = O(asrTransData, continuation);
        return O == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? O : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090 A[SYNTHETIC, Splitter:B:28:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object W(com.xjsd.ai.assistant.nlu.bean.NluResponse r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOnlineResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOnlineResult$1 r0 = (com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOnlineResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOnlineResult$1 r0 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$handleOnlineResult$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "OverallInterceptor"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x003f
            if (r2 != r4) goto L_0x0037
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0034 }
            goto L_0x00dd
        L_0x0034:
            r8 = move-exception
            goto L_0x00ec
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.L$1
            com.xjsd.ai.assistant.nlu.bean.NluResponse r8 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r8
            java.lang.Object r2 = r0.L$0
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r2 = (com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r7
            r7 = r2
            goto L_0x0079
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "handleOnlineResult: nlu response->"
            r9.append(r2)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.xjsd.ai.assistant.log.ILog.a(r3, r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.q
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.label = r5
            java.lang.Object r2 = r9.c(r6, r0)
            if (r2 != r1) goto L_0x0079
            return r1
        L_0x0079:
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.s     // Catch:{ all -> 0x008d }
            boolean r2 = r2.get()     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0090
            java.lang.String r7 = "已收到离线检测结果并处理，拦截在线NLU"
            com.xjsd.ai.assistant.log.ILog.a(r3, r7)     // Catch:{ all -> 0x008d }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008d }
            r9.d(r6)
            return r7
        L_0x008d:
            r8 = move-exception
            r7 = r9
            goto L_0x00ec
        L_0x0090:
            com.xjsd.ai.assistant.phone.helper.ExitTimer r2 = com.xjsd.ai.assistant.phone.helper.ExitTimer.f8563a     // Catch:{ all -> 0x008d }
            r2.d()     // Catch:{ all -> 0x008d }
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r2 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()     // Catch:{ all -> 0x008d }
            r2.l()     // Catch:{ all -> 0x008d }
            com.xjsd.ai.assistant.protocol.VuiModel r8 = com.xjsd.ai.assistant.phone.helper.NluDataParser.a(r8)     // Catch:{ all -> 0x008d }
            com.xjsd.ai.assistant.common.SessionHelper r2 = com.xjsd.ai.assistant.common.SessionHelper.f8413a     // Catch:{ all -> 0x008d }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x008d }
            r8.setSessionId(r2)     // Catch:{ all -> 0x008d }
            com.xjsd.ai.assistant.common.manager.VuiHandlerManager r2 = com.xjsd.ai.assistant.common.manager.VuiHandlerManager.d     // Catch:{ all -> 0x008d }
            boolean r2 = r2.f(r8)     // Catch:{ all -> 0x008d }
            if (r2 != 0) goto L_0x00b9
            com.xjsd.ai.assistant.phone.VuiHandleDelegate r2 = com.xjsd.ai.assistant.phone.VuiHandleDelegate.f8537a     // Catch:{ all -> 0x008d }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x008d }
            r2.c(r8)     // Catch:{ all -> 0x008d }
        L_0x00b9:
            r2 = 0
            r7.a0(r2)     // Catch:{ all -> 0x008d }
            com.xjsd.ai.assistant.protocol.vui.Header r8 = r8.getHeader()     // Catch:{ all -> 0x008d }
            java.lang.String r8 = r8.getNamespace()     // Catch:{ all -> 0x008d }
            java.lang.String r2 = "llm"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r2)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x00e3
            r0.L$0 = r9     // Catch:{ all -> 0x008d }
            r0.L$1 = r6     // Catch:{ all -> 0x008d }
            r0.L$2 = r6     // Catch:{ all -> 0x008d }
            r0.label = r4     // Catch:{ all -> 0x008d }
            java.lang.Object r7 = r7.b0(r0)     // Catch:{ all -> 0x008d }
            if (r7 != r1) goto L_0x00dc
            return r1
        L_0x00dc:
            r7 = r9
        L_0x00dd:
            com.xjsd.ai.assistant.phone.helper.ExitTimer r8 = com.xjsd.ai.assistant.phone.helper.ExitTimer.f8563a     // Catch:{ all -> 0x0034 }
            r8.f()     // Catch:{ all -> 0x0034 }
            goto L_0x00e4
        L_0x00e3:
            r7 = r9
        L_0x00e4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0034 }
            r7.d(r6)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00ec:
            r7.d(r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor.W(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object X(AsrTransData asrTransData, Continuation continuation) {
        ILog.a("OverallInterceptor", "onOfflineResult: collect asrSource->" + asrTransData);
        I(true, new OverallInterceptor$onOfflineResult$2(this, asrTransData, (Continuation<? super OverallInterceptor$onOfflineResult$2>) null));
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y() {
        /*
            r9 = this;
            java.lang.String r0 = "启动websocket异常"
            java.lang.String r1 = "connect_ws"
            int r2 = r9.M()
            r3 = 4
            r4 = 1
            java.lang.String r5 = "OverallInterceptor"
            if (r2 != r3) goto L_0x0036
            java.lang.String r0 = "onStart: 定制唤醒，等待NLU返回结果即可"
            com.xjsd.ai.assistant.log.ILog.a(r5, r0)
            java.lang.String r0 = "定制唤醒，等待NLU返回结果即可"
            r9.Z(r4, r0)
            com.xjsd.ai.assistant.protocol.notify.VadEventData r0 = new com.xjsd.ai.assistant.protocol.notify.VadEventData
            r1 = 2
            r0.<init>(r1)
            com.xjsd.ai.assistant.phone.session.Session r9 = r9.d()
            java.lang.String r9 = r9.b()
            r0.setSessionId(r9)
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$prepareEnvironment$1 r9 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$prepareEnvironment$1
            r9.<init>()
            r1 = 104(0x68, float:1.46E-43)
            com.xjsd.ai.assistant.common.Communicator.b(r1, r0, r9)
            return
        L_0x0036:
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.m
            r3 = 0
            r2.set(r3)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r2 = r9.h
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            java.lang.String r7 = "isNetworkAvailable"
            java.lang.Object r2 = r2.getCacheWithDefault(r7, r6)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 == 0) goto L_0x0055
            java.lang.String r0 = "手机网络不可用，走离线识别"
            r9.Z(r4, r0)
            return
        L_0x0055:
            com.xjsd.ai.assistant.phone.session.Session r2 = r9.d()     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            java.lang.String r2 = r2.b()     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            com.xjsd.ai.assistant.cloud.InitCloudParams r2 = r9.J(r2)     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            kotlin.Pair[] r6 = new kotlin.Pair[r3]     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            r9.L(r1, r6)     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            com.xjsd.ai.assistant.cloud.CloudAbility r6 = r9.g     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            boolean r2 = r6.launch(r2)     // Catch:{ ExecutionException -> 0x0093, InterruptedException -> 0x0090 }
            java.lang.String r6 = "建立ws连接耗时"
            java.lang.String r7 = "connectCode"
            com.xjsd.ai.assistant.cloud.CloudAbility r8 = r9.g     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            int r8 = r8.getErrorCode()     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            kotlin.Pair[] r7 = new kotlin.Pair[]{r7}     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            r9.K(r1, r6, r7)     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            java.util.concurrent.atomic.AtomicBoolean r1 = r9.m     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            r1.set(r2)     // Catch:{ ExecutionException -> 0x008e, InterruptedException -> 0x008c }
            goto L_0x00a4
        L_0x008c:
            r1 = move-exception
            goto L_0x0096
        L_0x008e:
            r1 = move-exception
            goto L_0x00a1
        L_0x0090:
            r1 = move-exception
            r2 = r3
            goto L_0x0096
        L_0x0093:
            r1 = move-exception
            r2 = r3
            goto L_0x00a1
        L_0x0096:
            com.xjsd.ai.assistant.log.ILog.b(r5, r0, r1)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x00a4
        L_0x00a1:
            com.xjsd.ai.assistant.log.ILog.b(r5, r0, r1)
        L_0x00a4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "启动websocket结果->"
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xjsd.ai.assistant.log.ILog.a(r5, r0)
            if (r2 == 0) goto L_0x00ce
            com.xjsd.ai.assistant.phone.WakeupControlDelegate r0 = com.xjsd.ai.assistant.phone.WakeupControlDelegate.g
            r0.p(r3)
            java.lang.String r0 = "唤醒成功"
            r9.Z(r4, r0)
            com.xjsd.ai.assistant.phone.export.FeedAudioDataToCloudStrategy r9 = r9.N()
            r9.g()
            return
        L_0x00ce:
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$prepareEnvironment$failFlow$1 r0 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$prepareEnvironment$failFlow$1
            r0.<init>(r9)
            boolean r1 = com.xjsd.ai.assistant.core.util.DeviceUtils.d()
            if (r1 == 0) goto L_0x0104
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$prepareEnvironment$endFlow$1 r1 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$prepareEnvironment$endFlow$1
            r1.<init>(r9)
            boolean r2 = com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea
            if (r2 == 0) goto L_0x00e9
            r0.invoke()
            r1.invoke()
            return
        L_0x00e9:
            int r2 = r9.M()
            r3 = 11
            if (r2 != r3) goto L_0x00fd
            java.lang.String r0 = "onStart: 特定场景唤醒，走离线识别"
            com.xjsd.ai.assistant.log.ILog.a(r5, r0)
            java.lang.String r0 = "唤醒失败，走离线识别"
            r9.Z(r4, r0)
            goto L_0x0107
        L_0x00fd:
            r0.invoke()
            r1.invoke()
            goto L_0x0107
        L_0x0104:
            r0.invoke()
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor.Y():void");
    }

    public final void Z(boolean z, String str) {
        L("response_wakeup", new Pair[0]);
        K("receive_wakeup", "唤醒响应", new Pair[0]);
        ExitTimer.f8563a.d();
        WakeupRes wakeupRes = new WakeupRes();
        wakeupRes.setSuccess(z);
        wakeupRes.setMessage(str);
        wakeupRes.setHasNetwork(Intrinsics.areEqual((Object) (Boolean) this.h.getCacheWithDefault("isNetworkAvailable", Boolean.FALSE), (Object) Boolean.TRUE));
        wakeupRes.setSessionId(d().b());
        Communicator.b(4, wakeupRes, new OverallInterceptor$reply$1());
    }

    public final void a0(boolean z) {
        ExitTimer.f8563a.c();
        this.r.set(true);
        if (z) {
            this.s.set(true);
        }
    }

    public final Object b0(Continuation continuation) {
        this.u.set(true);
        j(c(), new OverallInterceptor$startLlmResponseProcess$2(this, (Continuation<? super OverallInterceptor$startLlmResponseProcess$2>) null));
        return Unit.INSTANCE;
    }

    public void f() {
        Object cacheWithDefault = this.h.getCacheWithDefault("isNetworkAvailable", Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(cacheWithDefault, "getCacheWithDefault(...)");
        this.l = ((Boolean) cacheWithDefault).booleanValue();
        EventBus.c().o(this);
        j(c(), new OverallInterceptor$onCreate$1(this, FlowKt.f(new OverallInterceptor$onCreate$flow$1(this, (Continuation<? super OverallInterceptor$onCreate$flow$1>) null)), (Continuation<? super OverallInterceptor$onCreate$1>) null));
    }

    public void g() {
        EventBus.c().q(this);
        SendChannel.DefaultImpls.a(this.p, (Throwable) null, 1, (Object) null);
        this.g.stop();
    }

    public void h() {
        ILog.a("OverallInterceptor", "重置handleRef");
        this.r.set(false);
        this.s.set(false);
        this.t.set(false);
        this.u.set(false);
        this.j.set(0);
        this.o = null;
        Y();
    }

    public void i() {
        this.g.setCloudEventListener((CloudEventListener) null);
        N().d();
    }

    @Subscribe
    public final void onReceiveAccessibilityShotEvent(@NotNull AccessibilityShotEvent accessibilityShotEvent) {
        Intrinsics.checkNotNullParameter(accessibilityShotEvent, "event");
        boolean a2 = accessibilityShotEvent.a();
        ILog.a("OverallInterceptor", "onReceiveGlassAccessibilityShotEvent: result->" + a2);
        this.o = Boolean.valueOf(a2);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new OverallInterceptor$onReceiveAccessibilityShotEvent$1(a2, this, (Continuation<? super OverallInterceptor$onReceiveAccessibilityShotEvent$1>) null), 3, (Object) null);
    }

    @Subscribe
    public final void onReceiveNetworkEvent(@NotNull NetworkEvent networkEvent) {
        Intrinsics.checkNotNullParameter(networkEvent, "event");
        this.l = networkEvent.a();
    }

    @Subscribe
    public final void onReceiveTimerTimeoutEvent(@NotNull TimerTimeoutEvent timerTimeoutEvent) {
        Intrinsics.checkNotNullParameter(timerTimeoutEvent, "event");
        a0(true);
        OverallInterceptor$onReceiveTimerTimeoutEvent$func$1 overallInterceptor$onReceiveTimerTimeoutEvent$func$1 = OverallInterceptor$onReceiveTimerTimeoutEvent$func$1.INSTANCE;
        CacheAbility cacheAbility = this.h;
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = (Boolean) cacheAbility.getCacheWithDefault("isVadStart", bool);
        Intrinsics.checkNotNull(bool2);
        if (bool2.booleanValue()) {
            Boolean bool3 = (Boolean) this.h.getCacheWithDefault("isNetworkAvailable", bool);
            Intrinsics.checkNotNull(bool3);
            new PhoneTtsPlayBuilder().e(bool3.booleanValue() ? TtsGlobalTemplate.GLOBAL01_P06 : TtsGlobalTemplate.GLOBAL01_P01).g(3).i(overallInterceptor$onReceiveTimerTimeoutEvent$func$1).h(overallInterceptor$onReceiveTimerTimeoutEvent$func$1).a().c();
            return;
        }
        Communicator.b(106, 8, new OverallInterceptor$onReceiveTimerTimeoutEvent$1());
        overallInterceptor$onReceiveTimerTimeoutEvent$func$1.invoke();
    }
}
