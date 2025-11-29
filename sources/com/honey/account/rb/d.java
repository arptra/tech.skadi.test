package com.honey.account.rb;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.output.ThresholdingOutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

public final /* synthetic */ class d implements IOFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnsynchronizedByteArrayOutputStream f7609a;

    public /* synthetic */ d(UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream) {
        this.f7609a = unsynchronizedByteArrayOutputStream;
    }

    public final Object apply(Object obj) {
        return IOUtils.lambda$toByteArray$1(this.f7609a, (ThresholdingOutputStream) obj);
    }
}
