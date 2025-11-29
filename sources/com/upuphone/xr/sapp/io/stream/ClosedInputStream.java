package com.upuphone.xr.sapp.io.stream;

import java.io.InputStream;

public class ClosedInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final ClosedInputStream f7103a = new ClosedInputStream();

    public int read() {
        return -1;
    }
}
