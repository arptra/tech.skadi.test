package com.upuphone.starrycommon.utils;

import com.upuphone.starrycommon.utils.Log2File;
import java.io.File;
import java.io.FileFilter;

public final /* synthetic */ class a implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Log2File.WriteHandler f6512a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(Log2File.WriteHandler writeHandler, String str) {
        this.f6512a = writeHandler;
        this.b = str;
    }

    public final boolean accept(File file) {
        return this.f6512a.c(this.b, file);
    }
}
