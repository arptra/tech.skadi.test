package com.airbnb.epoxy;

class MainThreadExecutor extends HandlerExecutor {
    public static final MainThreadExecutor b = new MainThreadExecutor(false);
    public static final MainThreadExecutor c = new MainThreadExecutor(true);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainThreadExecutor(boolean z) {
        super(z ? EpoxyAsyncUtil.b : EpoxyAsyncUtil.f2282a);
    }
}
