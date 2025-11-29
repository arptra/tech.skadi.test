package com.honey.account.m6;

import com.upuphone.runasone.share.lib.UupShare;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4949a;

    public /* synthetic */ d(String str) {
        this.f4949a = str;
    }

    public final void run() {
        UupShare.getInstance().sendMessageOfCancel(this.f4949a, 2);
    }
}
