package com.upuphone.ar.transcribe.statemachine.core;

import android.os.Message;

public class State implements IState {
    public void a() {
    }

    public void b() {
    }

    public boolean c(Message message) {
        return false;
    }

    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }
}
