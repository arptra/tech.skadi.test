package com.xjsd.ai.assistant.phone.tts;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "template", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TemplateTts;", "e", "(Lcom/xjsd/ai/assistant/template/TtsTemplate;)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TemplateTts;", "", "res", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$StringResTts;", "d", "(I)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$StringResTts;", "", "text", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TextTts;", "f", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TextTts;", "", "c", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "baseTts", "b", "(Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder;", "a", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "mTts", "PhoneTts", "StringResTts", "TemplateTts", "TextTts", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPhoneTtsPlayBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhoneTtsPlayBuilder.kt\ncom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 PhoneTtsPlayBuilder.kt\ncom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder\n*L\n128#1:135,2\n*E\n"})
public final class PhoneTtsPlayBuilder {

    /* renamed from: a  reason: collision with root package name */
    public PhoneTts f8605a;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001d\u001a\u0004\b\"\u0010\u001e\"\u0004\b'\u0010 R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b&\u0010\u001e\"\u0004\b)\u0010 \u0001\u0003+,-¨\u0006."}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder;", "builder", "", "j", "(Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder;)V", "", "action", "g", "(I)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "Lkotlin/Function0;", "callback", "h", "(Lkotlin/jvm/functions/Function0;)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "i", "a", "()Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder;", "mBuilder", "b", "I", "()I", "setMNextAction", "(I)V", "mNextAction", "c", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setMPlayDiscardCallback", "(Lkotlin/jvm/functions/Function0;)V", "mPlayDiscardCallback", "d", "f", "setMPlayStartCallback", "mPlayStartCallback", "e", "setMPlayErrorCallback", "mPlayErrorCallback", "setMPlayOverCallback", "mPlayOverCallback", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$StringResTts;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TemplateTts;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TextTts;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static abstract class PhoneTts {

        /* renamed from: a  reason: collision with root package name */
        public PhoneTtsPlayBuilder f8606a;
        public int b;
        public Function0 c;
        public Function0 d;
        public Function0 e;
        public Function0 f;

        public /* synthetic */ PhoneTts(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PhoneTtsPlayBuilder a() {
            PhoneTtsPlayBuilder phoneTtsPlayBuilder = this.f8606a;
            if (phoneTtsPlayBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
                phoneTtsPlayBuilder = null;
            }
            return phoneTtsPlayBuilder.b(this);
        }

        public final int b() {
            return this.b;
        }

        public final Function0 c() {
            return this.c;
        }

        public final Function0 d() {
            return this.e;
        }

        public final Function0 e() {
            return this.f;
        }

        public final Function0 f() {
            return this.d;
        }

        public final PhoneTts g(int i) {
            this.b = i;
            return this;
        }

        public final PhoneTts h(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "callback");
            this.e = function0;
            return this;
        }

        public final PhoneTts i(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "callback");
            this.f = function0;
            return this;
        }

        public final void j(PhoneTtsPlayBuilder phoneTtsPlayBuilder) {
            Intrinsics.checkNotNullParameter(phoneTtsPlayBuilder, "builder");
            this.f8606a = phoneTtsPlayBuilder;
        }

        public PhoneTts() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$StringResTts;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "", "resId", "<init>", "(I)V", "g", "I", "k", "()I", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class StringResTts extends PhoneTts {
        public final int g;

        public StringResTts(int i) {
            super((DefaultConstructorMarker) null);
            this.g = i;
        }

        public final int k() {
            return this.g;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\t\u001a\u00020\u00002\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R3\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TemplateTts;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "template", "<init>", "(Lcom/xjsd/ai/assistant/template/TtsTemplate;)V", "", "", "formatArgs", "o", "([Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TemplateTts;", "key", "value", "k", "(Ljava/lang/String;Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TemplateTts;", "g", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "n", "()Lcom/xjsd/ai/assistant/template/TtsTemplate;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "h", "Ljava/util/HashMap;", "m", "()Ljava/util/HashMap;", "slots", "", "i", "Ljava/util/List;", "l", "()Ljava/util/List;", "setMFormatArgs", "(Ljava/util/List;)V", "mFormatArgs", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TemplateTts extends PhoneTts {
        public final TtsTemplate g;
        public final HashMap h = new HashMap();
        public List i = CollectionsKt.emptyList();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TemplateTts(TtsTemplate ttsTemplate) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(ttsTemplate, "template");
            this.g = ttsTemplate;
        }

        public final TemplateTts k(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
            this.h.put(str, str2);
            return this;
        }

        public final List l() {
            return this.i;
        }

        public final HashMap m() {
            return this.h;
        }

        public final TtsTemplate n() {
            return this.g;
        }

        public final TemplateTts o(String... strArr) {
            Intrinsics.checkNotNullParameter(strArr, "formatArgs");
            this.i = ArraysKt.toList((T[]) strArr);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$TextTts;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "", "text", "<init>", "(Ljava/lang/String;)V", "g", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TextTts extends PhoneTts {
        public final String g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextTts(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.g = str;
        }

        public final String k() {
            return this.g;
        }
    }

    public final PhoneTtsPlayBuilder b(PhoneTts phoneTts) {
        this.f8605a = phoneTts;
        return this;
    }

    public final void c() {
        PhoneTts phoneTts = this.f8605a;
        if (phoneTts != null) {
            TemplateTts templateTts = phoneTts instanceof TemplateTts ? (TemplateTts) phoneTts : null;
            if (templateTts != null) {
                CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
                Boolean bool = cacheAbility != null ? (Boolean) cacheAbility.getCacheWithDefault("isNetworkAvailable", Boolean.TRUE) : null;
                boolean booleanValue = bool == null ? false : bool.booleanValue();
                String obj = templateTts.n().toString();
                if (booleanValue || (!StringsKt.startsWith$default(obj, "SET", false, 2, (Object) null) && !StringsKt.startsWith$default(obj, "APP", false, 2, (Object) null) && !StringsKt.startsWith$default(obj, "NAV", false, 2, (Object) null))) {
                    TtsTemplate n = templateTts.n();
                    String[] strArr = (String[]) templateTts.l().toArray(new String[0]);
                    n.getTts(Arrays.copyOf(strArr, strArr.length));
                } else {
                    ILog.a("PhoneTtsPlayBuilder", "play: 离线状态下，统一播报好的");
                    TtsManager.g.c(new StringResTts(TtsGlobalTemplate.GLOBAL05_P01.getResId()));
                    return;
                }
            }
            TtsManager ttsManager = TtsManager.g;
            PhoneTts phoneTts2 = this.f8605a;
            Intrinsics.checkNotNull(phoneTts2);
            ttsManager.c(phoneTts2);
            return;
        }
        throw new RuntimeException("请先设置相关播报参数");
    }

    public final StringResTts d(int i) {
        StringResTts stringResTts = new StringResTts(i);
        stringResTts.j(this);
        return stringResTts;
    }

    public final TemplateTts e(TtsTemplate ttsTemplate) {
        Intrinsics.checkNotNullParameter(ttsTemplate, "template");
        TemplateTts templateTts = new TemplateTts(ttsTemplate);
        templateTts.j(this);
        return templateTts;
    }

    public final TextTts f(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextTts textTts = new TextTts(str);
        textTts.j(this);
        return textTts;
    }
}
