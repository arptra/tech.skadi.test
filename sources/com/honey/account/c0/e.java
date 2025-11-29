package com.honey.account.c0;

import androidx.room.MultiInstanceInvalidationClient;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f3026a;

    public /* synthetic */ e(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f3026a = multiInstanceInvalidationClient;
    }

    public final void run() {
        MultiInstanceInvalidationClient.k(this.f3026a);
    }
}
