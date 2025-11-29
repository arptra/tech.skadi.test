package com.honey.account.s0;

import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f3104a;

    public /* synthetic */ q(InputStream inputStream) {
        this.f3104a = inputStream;
    }

    public final void run() {
        Utils.closeQuietly(this.f3104a);
    }
}
