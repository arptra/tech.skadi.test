package com.upuphone.xr.sapp.contract;

import android.content.DialogInterface;

public final /* synthetic */ class e implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssistantTtsTimbreSelector f6712a;

    public /* synthetic */ e(AssistantTtsTimbreSelector assistantTtsTimbreSelector) {
        this.f6712a = assistantTtsTimbreSelector;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AssistantTtsTimbreSelector$mSelectDialog$2.invoke$lambda$0(this.f6712a, dialogInterface);
    }
}
