package com.honey.account.e8;

import android.view.View;
import com.upuphone.xr.sapp.contract.AssistantTtsTimbreSelector;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssistantTtsTimbreSelector.TtsTimbreAdapter f4361a;
    public final /* synthetic */ AssistantTtsTimbreSelector.VH b;

    public /* synthetic */ b(AssistantTtsTimbreSelector.TtsTimbreAdapter ttsTimbreAdapter, AssistantTtsTimbreSelector.VH vh) {
        this.f4361a = ttsTimbreAdapter;
        this.b = vh;
    }

    public final void onClick(View view) {
        AssistantTtsTimbreSelector.TtsTimbreAdapter.j(this.f4361a, this.b, view);
    }
}
