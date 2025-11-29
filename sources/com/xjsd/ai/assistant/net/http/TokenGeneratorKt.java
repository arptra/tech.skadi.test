package com.xjsd.ai.assistant.net.http;

import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "tag", "", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "lib_assistant_release"}, k = 2, mv = {1, 9, 0})
public final class TokenGeneratorKt {
    public static final void a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ILog.j(str2, str);
    }
}
