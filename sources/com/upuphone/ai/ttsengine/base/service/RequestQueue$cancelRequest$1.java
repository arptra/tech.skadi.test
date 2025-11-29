package com.upuphone.ai.ttsengine.base.service;

import com.upuphone.ai.ttsengine.base.service.RequestQueue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/upuphone/ai/ttsengine/base/service/RequestQueue$RequestItem;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RequestQueue$cancelRequest$1 extends Lambda implements Function1<RequestQueue.RequestItem, Boolean> {
    final /* synthetic */ String $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestQueue$cancelRequest$1(String str) {
        super(1);
        this.$id = str;
    }

    @NotNull
    public final Boolean invoke(RequestQueue.RequestItem requestItem) {
        return Boolean.valueOf(Intrinsics.areEqual((Object) requestItem.e(), (Object) this.$id));
    }
}
