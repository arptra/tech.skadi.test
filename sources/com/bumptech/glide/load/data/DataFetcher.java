package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void e(Object obj);

        void f(Exception exc);
    }

    Class a();

    void b();

    DataSource c();

    void cancel();

    void d(Priority priority, DataCallback dataCallback);
}
