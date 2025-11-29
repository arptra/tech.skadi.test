package com.xingin.xhssharesdk.p;

import com.xingin.xhssharesdk.XhsShareSdkTools;
import java.io.File;

public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final File f8198a;

    public a(File file) {
        this.f8198a = file;
    }

    public final void run() {
        super.run();
        XhsShareSdkTools.deleteFile(this.f8198a, false);
    }
}
