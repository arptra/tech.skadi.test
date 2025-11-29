package com.xjsd.ai.assistant.chatgpt.util;

import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002/0B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0001\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062<\b\u0002\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0017\u001a\u00020\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162<\b\u0002\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010!\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00130\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u000b\u0010 \u001a\u00070\u001e¢\u0006\u0002\b\u001fH@¢\u0006\u0004\b!\u0010\"R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u001b\u0010,\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u001b\u0010.\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b-\u0010+¨\u00061"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil;", "", "<init>", "()V", "T", "Lkotlinx/coroutines/flow/Flow;", "Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$SplitConfig;", "splitConfig", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "role", "content", "", "onSuccessFinish", "Lkotlin/Function1;", "Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$MessageStreamData;", "handleResponse", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "f", "(Lkotlinx/coroutines/flow/Flow;Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$SplitConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "", "finishWithCompleteContent", "e", "(Lkotlinx/coroutines/flow/Flow;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "h", "(Lkotlinx/coroutines/flow/Flow;Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$SplitConfig;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/SendChannel;", "str", "", "Lcom/xjsd/ai/assistant/chatgpt/bean/GptStatus;", "status", "i", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "Ljava/util/List;", "endMarkEng", "c", "endMarkChn", "d", "Lkotlin/Lazy;", "()Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$SplitConfig;", "chnSplitConfig", "getEngSplitConfig", "engSplitConfig", "MessageStreamData", "SplitConfig", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GptUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final GptUtil f8402a = new GptUtil();
    public static final List b = CollectionsKt.listOf(", ", ". ", "? ", "! ");
    public static final List c = CollectionsKt.listOf("，", "。", "？", "！");
    public static final Lazy d = LazyKt.lazy(GptUtil$chnSplitConfig$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(GptUtil$engSplitConfig$2.INSTANCE);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B&\u0012\u000b\u0010\u0004\u001a\u00070\u0002¢\u0006\u0002\b\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00070\u0002¢\u0006\u0002\b\u00038\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$MessageStreamData;", "", "", "Lcom/xjsd/ai/assistant/chatgpt/bean/GptStatus;", "status", "", "role", "content", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "c", "b", "Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class MessageStreamData {

        /* renamed from: a  reason: collision with root package name */
        public final int f8407a;
        public final String b;
        public final String c;

        public MessageStreamData(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "content");
            this.f8407a = i;
            this.b = str;
            this.c = str2;
        }

        public final String a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.f8407a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageStreamData)) {
                return false;
            }
            MessageStreamData messageStreamData = (MessageStreamData) obj;
            return this.f8407a == messageStreamData.f8407a && Intrinsics.areEqual((Object) this.b, (Object) messageStreamData.b) && Intrinsics.areEqual((Object) this.c, (Object) messageStreamData.c);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.f8407a) * 31;
            String str = this.b;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode();
        }

        public String toString() {
            int i = this.f8407a;
            String str = this.b;
            String str2 = this.c;
            return "MessageStreamData(status=" + i + ", role=" + str + ", content=" + str2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u001f\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010!\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\u0019\u0010\u000b¨\u0006\""}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/util/GptUtil$SplitConfig;", "", "", "", "markList", "", "minLength", "maxLength", "<init>", "(Ljava/util/List;II)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "getMarkList", "()Ljava/util/List;", "b", "I", "d", "c", "endMark", "e", "Ljava/lang/String;", "splitRegex", "f", "endRegex", "g", "middleRegex", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SplitConfig {

        /* renamed from: a  reason: collision with root package name */
        public final List f8408a;
        public final int b;
        public final int c;
        public final List d;
        public final String e;
        public final String f;
        public final String g;

        public SplitConfig(List list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "markList");
            this.f8408a = list;
            this.b = i;
            this.c = i2;
            List plus = CollectionsKt.plus(list, StringUtils.LF);
            this.d = plus;
            List list2 = plus;
            this.e = CollectionsKt.joinToString$default(list2, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, GptUtil$SplitConfig$splitRegex$1.INSTANCE, 30, (Object) null);
            this.f = CollectionsKt.joinToString$default(list2, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML, "[\\s\\S]*(", ")$", 0, (CharSequence) null, GptUtil$SplitConfig$endRegex$1.INSTANCE, 24, (Object) null);
            this.g = "^([\\s\\S]{" + i2 + ",}?\\s)(.*)$";
        }

        public final String a() {
            return this.f;
        }

        public final int b() {
            return this.c;
        }

        public final String c() {
            return this.g;
        }

        public final int d() {
            return this.b;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SplitConfig)) {
                return false;
            }
            SplitConfig splitConfig = (SplitConfig) obj;
            return Intrinsics.areEqual((Object) this.f8408a, (Object) splitConfig.f8408a) && this.b == splitConfig.b && this.c == splitConfig.c;
        }

        public int hashCode() {
            return (((this.f8408a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            List list = this.f8408a;
            int i = this.b;
            int i2 = this.c;
            return "SplitConfig(markList=" + list + ", minLength=" + i + ", maxLength=" + i2 + ")";
        }
    }

    public static /* synthetic */ Flow g(GptUtil gptUtil, Flow flow, SplitConfig splitConfig, Function2 function2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            splitConfig = gptUtil.d();
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return gptUtil.f(flow, splitConfig, function2, function1);
    }

    public final SplitConfig d() {
        return (SplitConfig) d.getValue();
    }

    public final Flow e(Flow flow, boolean z, Function2 function2, Function1 function1) {
        return FlowKt.i(new GptUtil$handleMessageStream$1(flow, z, function2, function1, (Continuation<? super GptUtil$handleMessageStream$1>) null));
    }

    public final Flow f(Flow flow, SplitConfig splitConfig, Function2 function2, Function1 function1) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(function1, "handleResponse");
        return splitConfig == null ? e(flow, true, function2, function1) : h(flow, splitConfig, true, function2, function1);
    }

    public final Flow h(Flow flow, SplitConfig splitConfig, boolean z, Function2 function2, Function1 function1) {
        return FlowKt.i(new GptUtil$handleMessageStreamSentence$1(flow, z, function2, function1, splitConfig, (Continuation<? super GptUtil$handleMessageStreamSentence$1>) null));
    }

    public final Object i(SendChannel sendChannel, String str, int i, Continuation continuation) {
        Object L = sendChannel.L(new LlmResponse(i, new Regex("\\[(.*?)\\]\\(.*?\\)").replace((CharSequence) new Regex("\n{2,}").replace((CharSequence) str, StringUtils.LF), "[$1]()"), (String) null, false, (String) null, 28, (DefaultConstructorMarker) null), continuation);
        return L == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? L : Unit.INSTANCE;
    }
}
