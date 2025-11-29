package com.upuphone.xr.sapp.fragment;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatGptHistoryH5Fragment f7025a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment, String str) {
        this.f7025a = chatGptHistoryH5Fragment;
        this.b = str;
    }

    public final void run() {
        ChatGptHistoryH5Fragment$loadUrl$1.invokeSuspend$lambda$1$lambda$0(this.f7025a, this.b);
    }
}
