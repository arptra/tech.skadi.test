package com.honey.account.ua;

import flyme.support.v7.app.palette.ColorPickerView;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ColorPickerView f7626a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(ColorPickerView colorPickerView, int i) {
        this.f7626a = colorPickerView;
        this.b = i;
    }

    public final void run() {
        this.f7626a.lambda$updatePointByColor$2(this.b);
    }
}
