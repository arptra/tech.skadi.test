package com.upuphone.ai;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class NlgService$nlg_path$2 extends Lambda implements Function0<String> {
    final /* synthetic */ NlgService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NlgService$nlg_path$2(NlgService nlgService) {
        super(0);
        this.this$0 = nlgService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r2 = (r2 = r2.getApplicationContext()).getFilesDir();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke() {
        /*
            r2 = this;
            java.lang.String r0 = "nlg_path = "
            java.io.PrintStream r1 = java.lang.System.out
            r1.println(r0)
            com.upuphone.ai.NlgService r2 = r2.this$0
            android.app.Application r2 = r2.c()
            if (r2 == 0) goto L_0x0020
            android.content.Context r2 = r2.getApplicationContext()
            if (r2 == 0) goto L_0x0020
            java.io.File r2 = r2.getFilesDir()
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.getAbsolutePath()
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.NlgService$nlg_path$2.invoke():java.lang.String");
    }
}
