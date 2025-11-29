package com.xjsd.ai.assistant.adapt;

import android.content.Context;
import androidx.core.util.Consumer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/xjsd/ai/assistant/adapt/OfflineAsrDelegate;", "", "Landroidx/core/util/Consumer;", "Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;", "consumer", "", "a", "(Landroidx/core/util/Consumer;)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "start", "()V", "", "data", "c", "([B)V", "b", "destroy", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface OfflineAsrDelegate {
    void a(Consumer consumer);

    void b();

    void c(byte[] bArr);

    void destroy();

    void init(Context context);

    void start();
}
