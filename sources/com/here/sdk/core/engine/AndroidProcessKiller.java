package com.here.sdk.core.engine;

import android.os.Process;

class AndroidProcessKiller implements ProcessKiller {
    public void killProcess(int i) {
        Process.killProcess(i);
    }
}
