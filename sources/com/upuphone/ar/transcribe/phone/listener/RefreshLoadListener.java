package com.upuphone.ar.transcribe.phone.listener;

public interface RefreshLoadListener<T> {
    void noMoreData();

    void onLoadMoreData(Object obj, int i, int i2);
}
