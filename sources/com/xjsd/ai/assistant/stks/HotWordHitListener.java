package com.xjsd.ai.assistant.stks;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.stks.dto.STKSResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/stks/HotWordHitListener;", "", "moduleName", "", "(Ljava/lang/String;)V", "getModuleName", "()Ljava/lang/String;", "onHit", "", "responseList", "", "Lcom/xjsd/ai/assistant/stks/dto/STKSResponse;", "toString", "stks_base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Keep
public abstract class HotWordHitListener {
    @NotNull
    private final String moduleName;

    public HotWordHitListener(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "moduleName");
        this.moduleName = str;
    }

    @NotNull
    public final String getModuleName() {
        return this.moduleName;
    }

    public abstract void onHit(@NotNull List<? extends STKSResponse> list);

    @NotNull
    public String toString() {
        String str = this.moduleName;
        int hashCode = hashCode();
        return str + "@" + hashCode;
    }
}
