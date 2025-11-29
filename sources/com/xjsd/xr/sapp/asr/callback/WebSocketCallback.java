package com.xjsd.xr.sapp.asr.callback;

import kotlin.Metadata;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000f"}, d2 = {"Lcom/xjsd/xr/sapp/asr/callback/WebSocketCallback;", "", "onClosed", "", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "response", "Lokhttp3/Response;", "onOpen", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface WebSocketCallback {
    void onClosed(int i, @NotNull String str);

    void onClosing(int i, @NotNull String str);

    void onFailure(@NotNull Throwable th, @Nullable Response response);

    void onOpen(@Nullable Response response);
}
