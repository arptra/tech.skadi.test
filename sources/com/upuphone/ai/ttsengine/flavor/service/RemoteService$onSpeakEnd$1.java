package com.upuphone.ai.ttsengine.flavor.service;

import com.upuphone.ai.ttsengine.protocol.bean.StatusBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RemoteService$onSpeakEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $caller;
    final /* synthetic */ String $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteService$onSpeakEnd$1(String str, String str2) {
        super(0);
        this.$caller = str;
        this.$id = str2;
    }

    public final void invoke() {
        StatusBean statusBean = new StatusBean();
        String str = this.$caller;
        String str2 = this.$id;
        statusBean.setCaller(str);
        statusBean.setId(str2);
        statusBean.setStatus(1);
        RemoteService.f5563a.q(statusBean);
    }
}
