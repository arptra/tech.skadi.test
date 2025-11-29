package com.upuphone.ai.ttsengine.engines.cloud;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "onFailure"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class CloudEngine$selectLanguage$2$2 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloudEngine f5552a;
    public final /* synthetic */ Continuation b;

    public CloudEngine$selectLanguage$2$2(CloudEngine cloudEngine, Continuation continuation) {
        this.f5552a = cloudEngine;
        this.b = continuation;
    }

    public final void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        this.f5552a.getAiLog().c("language identify error", new Object[0]);
        this.b.resumeWith(Result.m20constructorimpl("en"));
    }
}
