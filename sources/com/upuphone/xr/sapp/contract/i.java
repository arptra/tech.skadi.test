package com.upuphone.xr.sapp.contract;

import android.content.DialogInterface;

public final /* synthetic */ class i implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssistantUserGuideDialogController f6716a;

    public /* synthetic */ i(AssistantUserGuideDialogController assistantUserGuideDialogController) {
        this.f6716a = assistantUserGuideDialogController;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AssistantUserGuideDialogController$mErrorDialog$2.invoke$lambda$2(this.f6716a, dialogInterface);
    }
}
