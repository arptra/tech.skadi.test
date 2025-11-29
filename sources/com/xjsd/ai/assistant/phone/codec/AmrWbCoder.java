package com.xjsd.ai.assistant.phone.codec;

import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/codec/AmrWbCoder;", "", "<init>", "()V", "", "b", "Z", "isRunning", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "c", "Ljava/util/concurrent/ExecutorService;", "encodePool", "d", "readPool", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AmrWbCoder {

    /* renamed from: a  reason: collision with root package name */
    public static final AmrWbCoder f8552a = new AmrWbCoder();
    public static boolean b = true;
    public static final ExecutorService c = ThreadPoolFactory.b("AmrEncode");
    public static final ExecutorService d = ThreadPoolFactory.b("AmrRead");
}
