package com.xjsd.ai.assistant.phone.tts;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AudioFocusManageDelegate;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0006\u001f !\"#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "template", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TemplateTtsParams;", "f", "(Lcom/xjsd/ai/assistant/template/TtsTemplate;)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TemplateTtsParams;", "", "res", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$StringResTtsParams;", "e", "(I)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$StringResTtsParams;", "", "text", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TextTtsParams;", "g", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TextTtsParams;", "", "d", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "baseTts", "b", "(Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;", "ttsParams", "c", "(Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;)V", "a", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "mTtsParams", "Companion", "StringResTtsParams", "TemplateTtsParams", "TextTtsParams", "TtsParams", "TtsPlayListener", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUniqueTtsPlayBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UniqueTtsPlayBuilder.kt\ncom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,162:1\n37#2,2:163\n*S KotlinDebug\n*F\n+ 1 UniqueTtsPlayBuilder.kt\ncom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder\n*L\n150#1:163,2\n*E\n"})
public final class UniqueTtsPlayBuilder {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TtsParams f8610a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$StringResTtsParams;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "", "resId", "<init>", "(I)V", "f", "I", "j", "()I", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class StringResTtsParams extends TtsParams {
        public final int f;

        public StringResTtsParams(int i) {
            super((DefaultConstructorMarker) null);
            this.f = i;
        }

        public final int j() {
            return this.f;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\t\u001a\u00020\u00002\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R3\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TemplateTtsParams;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "template", "<init>", "(Lcom/xjsd/ai/assistant/template/TtsTemplate;)V", "", "", "formatArgs", "n", "([Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TemplateTtsParams;", "key", "value", "j", "(Ljava/lang/String;Ljava/lang/String;)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TemplateTtsParams;", "f", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "m", "()Lcom/xjsd/ai/assistant/template/TtsTemplate;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "l", "()Ljava/util/HashMap;", "slots", "", "h", "Ljava/util/List;", "k", "()Ljava/util/List;", "setMFormatArgs", "(Ljava/util/List;)V", "mFormatArgs", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TemplateTtsParams extends TtsParams {
        public final TtsTemplate f;
        public final HashMap g = new HashMap();
        public List h = CollectionsKt.emptyList();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TemplateTtsParams(TtsTemplate ttsTemplate) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(ttsTemplate, "template");
            this.f = ttsTemplate;
        }

        public final TemplateTtsParams j(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
            this.g.put(str, str2);
            return this;
        }

        public final List k() {
            return this.h;
        }

        public final HashMap l() {
            return this.g;
        }

        public final TtsTemplate m() {
            return this.f;
        }

        public final TemplateTtsParams n(String... strArr) {
            Intrinsics.checkNotNullParameter(strArr, "formatArgs");
            this.h = ArraysKt.toList((T[]) strArr);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TextTtsParams;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "", "text", "<init>", "(Ljava/lang/String;)V", "f", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TextTtsParams extends TtsParams {
        public final String f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextTtsParams(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.f = str;
        }

        public final String j() {
            return this.f;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000e\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001e\u0010\u0017R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b \u0010\u0017\u0001\u0003\"#$¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;", "builder", "", "i", "(Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;)V", "Lkotlin/Function0;", "callback", "h", "(Lkotlin/jvm/functions/Function0;)Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "f", "g", "a", "()Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;", "mBuilder", "b", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setMPlayDiscardCallback", "(Lkotlin/jvm/functions/Function0;)V", "mPlayDiscardCallback", "c", "e", "setMPlayStartCallback", "mPlayStartCallback", "d", "setMPlayErrorCallback", "mPlayErrorCallback", "setMPlayOverCallback", "mPlayOverCallback", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$StringResTtsParams;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TemplateTtsParams;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TextTtsParams;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static abstract class TtsParams {

        /* renamed from: a  reason: collision with root package name */
        public UniqueTtsPlayBuilder f8611a;
        public Function0 b;
        public Function0 c;
        public Function0 d;
        public Function0 e;

        public /* synthetic */ TtsParams(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UniqueTtsPlayBuilder a() {
            UniqueTtsPlayBuilder uniqueTtsPlayBuilder = this.f8611a;
            if (uniqueTtsPlayBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
                uniqueTtsPlayBuilder = null;
            }
            return uniqueTtsPlayBuilder.b(this);
        }

        public final Function0 b() {
            return this.b;
        }

        public final Function0 c() {
            return this.d;
        }

        public final Function0 d() {
            return this.e;
        }

        public final Function0 e() {
            return this.c;
        }

        public final TtsParams f(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "callback");
            this.d = function0;
            return this;
        }

        public final TtsParams g(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "callback");
            this.e = function0;
            return this;
        }

        public final TtsParams h(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "callback");
            this.c = function0;
            return this;
        }

        public final void i(UniqueTtsPlayBuilder uniqueTtsPlayBuilder) {
            Intrinsics.checkNotNullParameter(uniqueTtsPlayBuilder, "builder");
            this.f8611a = uniqueTtsPlayBuilder;
        }

        public TtsParams() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsPlayListener;", "Lcom/xjsd/ai/assistant/core/api/tts/TtsListener;", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "ttsParams", "<init>", "(Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder;Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;)V", "", "onDiscard", "()V", "onSpeakStart", "onSpeakEnd", "", "error", "onSpeakError", "(Ljava/lang/String;)V", "a", "Lcom/xjsd/ai/assistant/phone/tts/UniqueTtsPlayBuilder$TtsParams;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TtsPlayListener implements TtsListener {

        /* renamed from: a  reason: collision with root package name */
        public final TtsParams f8612a;
        public final /* synthetic */ UniqueTtsPlayBuilder b;

        public TtsPlayListener(UniqueTtsPlayBuilder uniqueTtsPlayBuilder, TtsParams ttsParams) {
            Intrinsics.checkNotNullParameter(ttsParams, "ttsParams");
            this.b = uniqueTtsPlayBuilder;
            this.f8612a = ttsParams;
        }

        public void onDiscard() {
            Function0 b2 = this.f8612a.b();
            if (b2 != null) {
                b2.invoke();
            }
        }

        public void onSpeakEnd() {
            AudioFocusManageDelegate.a(2);
            Function0 d = this.f8612a.d();
            if (d != null) {
                d.invoke();
            }
        }

        public void onSpeakError(String str) {
            AudioFocusManageDelegate.a(2);
            Function0 c = this.f8612a.c();
            if (c != null) {
                c.invoke();
            }
        }

        public void onSpeakStart() {
            Function0 e = this.f8612a.e();
            if (e != null) {
                e.invoke();
            }
        }
    }

    public final UniqueTtsPlayBuilder b(TtsParams ttsParams) {
        this.f8610a = ttsParams;
        return this;
    }

    public final void c(TtsParams ttsParams) {
        TtsData ttsData = new TtsData();
        ttsData.setEmotionType("");
        TtsParams ttsParams2 = this.f8610a;
        Intrinsics.checkNotNull(ttsParams2);
        if (ttsParams2 instanceof StringResTtsParams) {
            Intrinsics.checkNotNull(ttsParams, "null cannot be cast to non-null type com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder.StringResTtsParams");
            ttsData.setText(ContextHelper.b(((StringResTtsParams) ttsParams).j(), new Object[0]));
        } else if (ttsParams2 instanceof TextTtsParams) {
            TtsParams ttsParams3 = this.f8610a;
            Intrinsics.checkNotNull(ttsParams3, "null cannot be cast to non-null type com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder.TextTtsParams");
            ttsData.setText(((TextTtsParams) ttsParams3).j());
        } else if (ttsParams2 instanceof TemplateTtsParams) {
            TtsParams ttsParams4 = this.f8610a;
            Intrinsics.checkNotNull(ttsParams4, "null cannot be cast to non-null type com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder.TemplateTtsParams");
            TemplateTtsParams templateTtsParams = (TemplateTtsParams) ttsParams4;
            TtsTemplate m = templateTtsParams.m();
            String[] strArr = (String[]) templateTtsParams.k().toArray(new String[0]);
            ttsData.setText(m.getTts(Arrays.copyOf(strArr, strArr.length)));
            ttsData.setFunctionId(templateTtsParams.m().getFunctionId());
            ttsData.setSlots(templateTtsParams.l());
        }
        ILog.j("UniqueTtsPlayBuilder", "播报非语音助理业务TTS，内容->" + ttsData);
        TtsDataTransform.f8607a.a(ttsData, false);
        AudioFocusManageDelegate.a(1);
        TtsAbility ttsAbility = (TtsAbility) AbilityManager.b.b(TtsAbility.class);
        if (ttsAbility != null) {
            ttsAbility.startSpeak(ttsData, new TtsPlayListener(this, ttsParams));
        }
    }

    public final void d() {
        TtsParams ttsParams = this.f8610a;
        if (ttsParams != null) {
            Intrinsics.checkNotNull(ttsParams);
            c(ttsParams);
            return;
        }
        throw new RuntimeException("请先设置相关播报参数");
    }

    public final StringResTtsParams e(int i) {
        StringResTtsParams stringResTtsParams = new StringResTtsParams(i);
        stringResTtsParams.i(this);
        return stringResTtsParams;
    }

    public final TemplateTtsParams f(TtsTemplate ttsTemplate) {
        Intrinsics.checkNotNullParameter(ttsTemplate, "template");
        TemplateTtsParams templateTtsParams = new TemplateTtsParams(ttsTemplate);
        templateTtsParams.i(this);
        return templateTtsParams;
    }

    public final TextTtsParams g(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextTtsParams textTtsParams = new TextTtsParams(str);
        textTtsParams.i(this);
        return textTtsParams;
    }
}
