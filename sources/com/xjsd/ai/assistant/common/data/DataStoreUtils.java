package com.xjsd.ai.assistant.common.data;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ \u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH@¢\u0006\u0004\b\u0011\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0012\u0010\u0010J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH@¢\u0006\u0004\b\u0014\u0010\u000eJ\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0015\u0010\u0010J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\nH@¢\u0006\u0004\b\u0017\u0010\u000eJ\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0018\u0010\u0010J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\nH@¢\u0006\u0004\b\u001a\u0010\u000eJ\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u001b\u0010\u0010J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\nH@¢\u0006\u0004\b\u001d\u0010\u000eJ\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u001e\u0010\u0010J \u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH@¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b#\u0010\u0010J%\u0010'\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\n¢\u0006\u0004\b'\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010+R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010+R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010+R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\n0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010+R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010+¨\u00068"}, d2 = {"Lcom/xjsd/ai/assistant/common/data/DataStoreUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "h", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "", "isWakeup", "", "u", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "o", "isContinuous", "t", "m", "isOnScreen", "q", "j", "isChatGptTtsPlay", "s", "l", "isChatGptCardDisplay", "r", "k", "", "value", "p", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "", "type", "switchOn", "w", "(Landroid/content/Context;Ljava/lang/String;Z)V", "Landroidx/datastore/preferences/core/Preferences$Key;", "b", "Landroidx/datastore/preferences/core/Preferences$Key;", "LOW_POWER_WAKEUP", "c", "LOW_POWER_WAKEUP_SCREEN_OFF", "d", "CONTINUOUS_DIALOGUE", "e", "ASR_RESULT_SCREEN", "f", "CHAT_GPT_TTS_PLAY", "g", "CHAT_GPT_CARD_DISPLAY", "TTS_TIMBRE", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDataStoreUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreUtils.kt\ncom/xjsd/ai/assistant/common/data/DataStoreUtils\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,279:1\n53#2:280\n55#2:284\n53#2:285\n55#2:289\n53#2:290\n55#2:294\n53#2:295\n55#2:299\n53#2:300\n55#2:304\n53#2:305\n55#2:309\n53#2:310\n55#2:314\n50#3:281\n55#3:283\n50#3:286\n55#3:288\n50#3:291\n55#3:293\n50#3:296\n55#3:298\n50#3:301\n55#3:303\n50#3:306\n55#3:308\n50#3:311\n55#3:313\n106#4:282\n106#4:287\n106#4:292\n106#4:297\n106#4:302\n106#4:307\n106#4:312\n*S KotlinDebug\n*F\n+ 1 DataStoreUtils.kt\ncom/xjsd/ai/assistant/common/data/DataStoreUtils\n*L\n85#1:280\n85#1:284\n110#1:285\n110#1:289\n135#1:290\n135#1:294\n160#1:295\n160#1:299\n185#1:300\n185#1:304\n210#1:305\n210#1:309\n235#1:310\n235#1:314\n85#1:281\n85#1:283\n110#1:286\n110#1:288\n135#1:291\n135#1:293\n160#1:296\n160#1:298\n185#1:301\n185#1:303\n210#1:306\n210#1:308\n235#1:311\n235#1:313\n85#1:282\n110#1:287\n135#1:292\n160#1:297\n185#1:302\n210#1:307\n235#1:312\n*E\n"})
public final class DataStoreUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final DataStoreUtils f8415a = new DataStoreUtils();
    public static final Preferences.Key b = PreferencesKeys.a("low_power_wakeup");
    public static final Preferences.Key c = PreferencesKeys.a("low_power_wakeup_screen_off");
    public static final Preferences.Key d = PreferencesKeys.a("continuous_dialogue");
    public static final Preferences.Key e = PreferencesKeys.a("asr_result_screen");
    public static final Preferences.Key f = PreferencesKeys.a("chat_gpt_tts_play");
    public static final Preferences.Key g = PreferencesKeys.a("chat_gpt_card_display");
    public static final Preferences.Key h = PreferencesKeys.d("tts_timbre");

    public final DataStore h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DataStoreUtilsKt.a(context);
    }

    public final Object i(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$getTtsTimbre$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object j(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$isAsrResultScreen$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object k(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$isChatGptCardDisplay$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object l(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$isChatGptTTSPlay$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object m(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$isContinuousDialogue$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object n(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$isLowPowerWakeup$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object o(Context context, Continuation continuation) {
        return FlowKt.w(new DataStoreUtils$isLowPowerWakeupScreenOff$$inlined$map$1(DataStoreUtilsKt.a(context).getData()), continuation);
    }

    public final Object p(Context context, int i, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$storeTtsTimbre$2(i, (Continuation<? super DataStoreUtils$storeTtsTimbre$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final Object q(Context context, boolean z, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$switchAsrResultScreen$2(z, (Continuation<? super DataStoreUtils$switchAsrResultScreen$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final Object r(Context context, boolean z, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$switchChatGptCardDisplay$2(z, (Continuation<? super DataStoreUtils$switchChatGptCardDisplay$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final Object s(Context context, boolean z, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$switchChatGptTTSPlay$2(z, (Continuation<? super DataStoreUtils$switchChatGptTTSPlay$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final Object t(Context context, boolean z, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$switchContinuousDialogue$2(z, (Continuation<? super DataStoreUtils$switchContinuousDialogue$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final Object u(Context context, boolean z, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$switchLowPowerWakeup$2(z, (Continuation<? super DataStoreUtils$switchLowPowerWakeup$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final Object v(Context context, boolean z, Continuation continuation) {
        Object a2 = PreferencesKt.a(DataStoreUtilsKt.a(context), new DataStoreUtils$switchLowPowerWakeupScreenOff$2(z, (Continuation<? super DataStoreUtils$switchLowPowerWakeupScreenOff$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    public final void w(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new DataStoreUtils$updateAssistantSettings$1(str, context, z, (Continuation<? super DataStoreUtils$updateAssistantSettings$1>) null), 3, (Object) null);
    }
}
