package com.honey.account.e8;

import com.upuphone.xr.sapp.contract.AssistantTtsTimbreSelector;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssistantTtsTimbreSelector f4360a;

    public /* synthetic */ a(AssistantTtsTimbreSelector assistantTtsTimbreSelector) {
        this.f4360a = assistantTtsTimbreSelector;
    }

    public final void run() {
        AssistantTtsTimbreSelector.PlayTask.b(this.f4360a);
    }
}
