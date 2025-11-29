package com.upuphone.ai.ttsengine.engines.cloud;

import com.google.mlkit.nl.languageid.LanguageIdentifier;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class CloudEngine$selectLanguage$2$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Continuation<String> $continuation;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$selectLanguage$2$1(CloudEngine cloudEngine, Continuation<? super String> continuation) {
        super(1);
        this.this$0 = cloudEngine;
        this.$continuation = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        String access$getLanguage;
        AILOG access$getAiLog = this.this$0.getAiLog();
        String access$getLanguage2 = this.this$0.getLanguage();
        access$getAiLog.c("identify language: " + str + ", param language: " + access$getLanguage2, new Object[0]);
        Continuation<String> continuation = this.$continuation;
        if (Intrinsics.areEqual((Object) str, (Object) LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG) && (access$getLanguage = this.this$0.getLanguage()) != null && access$getLanguage.length() > 0 && (str = this.this$0.getLanguage()) == null) {
            str = LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG;
        }
        continuation.resumeWith(Result.m20constructorimpl(str));
    }
}
