package com.xjsd.ai.assistant.flutter.util;

import androidx.core.util.Consumer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/PcmEncoder;", "", "Landroidx/core/util/Consumer;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData;", "consumer", "", "a", "(Landroidx/core/util/Consumer;)V", "", "b", "()Ljava/lang/String;", "start", "()V", "", "data", "encode", "([B)V", "flush", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface PcmEncoder {
    void a(Consumer consumer);

    String b();

    void encode(byte[] bArr);

    void flush();

    void start();
}
