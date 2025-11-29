package org.litepal.crud.async;

import org.litepal.crud.callback.FindCallback;

public class FindExecutor<T> extends AsyncExecutor {
    private FindCallback<T> cb;

    public FindCallback<T> getListener() {
        return this.cb;
    }

    public void listen(FindCallback<T> findCallback) {
        this.cb = findCallback;
        execute();
    }
}
