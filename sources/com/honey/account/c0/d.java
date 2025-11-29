package com.honey.account.c0;

import androidx.room.MultiInstanceInvalidationClient;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f3025a;

    public /* synthetic */ d(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f3025a = multiInstanceInvalidationClient;
    }

    public final void run() {
        MultiInstanceInvalidationClient.n(this.f3025a);
    }
}
