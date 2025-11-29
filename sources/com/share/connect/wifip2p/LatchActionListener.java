package com.share.connect.wifip2p;

import java.util.concurrent.CountDownLatch;

class LatchActionListener extends LogActionListener {
    public CountDownLatch c;

    public LatchActionListener(String str, String str2, CountDownLatch countDownLatch) {
        super(str, str2);
        if (countDownLatch != null) {
            this.c = countDownLatch;
            return;
        }
        throw new NullPointerException("Parameter latch should not be null.");
    }

    public void onFailure(int i) {
        super.onFailure(i);
        this.c.countDown();
    }

    public void onSuccess() {
        super.onSuccess();
        this.c.countDown();
    }
}
