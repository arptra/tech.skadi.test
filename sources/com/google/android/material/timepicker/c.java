package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerTextInputPresenter f9698a;

    public /* synthetic */ c(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.f9698a = timePickerTextInputPresenter;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        this.f9698a.lambda$setupPeriodToggle$0(materialButtonToggleGroup, i, z);
    }
}
