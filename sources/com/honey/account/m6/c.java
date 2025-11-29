package com.honey.account.m6;

import com.upuphone.runasone.share.lib.UupShare;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4948a;

    public /* synthetic */ c(String str) {
        this.f4948a = str;
    }

    public final void run() {
        UupShare.getInstance().sendMessageOfCancel(this.f4948a, 3);
    }
}
