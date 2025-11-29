package com.honey.account.s0;

import com.airbnb.lottie.utils.Utils;
import java.util.zip.ZipInputStream;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZipInputStream f3096a;

    public /* synthetic */ i(ZipInputStream zipInputStream) {
        this.f3096a = zipInputStream;
    }

    public final void run() {
        Utils.closeQuietly(this.f3096a);
    }
}
