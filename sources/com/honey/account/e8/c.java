package com.honey.account.e8;

import android.view.View;
import com.upuphone.xr.sapp.contract.AssistantTtsTimbreSelector;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssistantTtsTimbreSelector f4362a;
    public final /* synthetic */ AssistantTtsTimbreSelector.TtsTimbreItem b;

    public /* synthetic */ c(AssistantTtsTimbreSelector assistantTtsTimbreSelector, AssistantTtsTimbreSelector.TtsTimbreItem ttsTimbreItem) {
        this.f4362a = assistantTtsTimbreSelector;
        this.b = ttsTimbreItem;
    }

    public final void onClick(View view) {
        AssistantTtsTimbreSelector.TtsTimbreAdapter.k(this.f4362a, this.b, view);
    }
}
