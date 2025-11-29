package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.engines.cloud.Status;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/ai/ttsengine/engines/cloud/CloudEngine$audioListener$1", "Lkotlin/Function1;", "Lcom/upuphone/ai/ttsengine/engines/cloud/Status;", "", "it", "a", "(Lcom/upuphone/ai/ttsengine/engines/cloud/Status;)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CloudEngine$audioListener$1 implements Function1<Status, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloudEngine f5550a;

    public CloudEngine$audioListener$1(CloudEngine cloudEngine) {
        this.f5550a = cloudEngine;
    }

    public void a(Status status) {
        Intrinsics.checkNotNullParameter(status, "it");
        if (status instanceof Status.AudioData) {
            this.f5550a.handleAudio((Status.AudioData) status);
        } else if (status instanceof Status.Error) {
            this.f5550a.onPlayError(((Status.Error) status).a());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Status) obj);
        return Unit.INSTANCE;
    }
}
