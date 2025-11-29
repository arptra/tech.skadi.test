package org.litepal.crud.async;

import org.litepal.crud.callback.SaveCallback;

public class SaveExecutor extends AsyncExecutor {
    private SaveCallback cb;

    public SaveCallback getListener() {
        return this.cb;
    }

    public void listen(SaveCallback saveCallback) {
        this.cb = saveCallback;
        execute();
    }
}
