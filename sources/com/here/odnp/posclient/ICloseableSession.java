package com.here.odnp.posclient;

public interface ICloseableSession {
    void close();

    boolean open();
}
