package com.xjsd.ai.assistant.stks;

import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/stks/ContextHelper;", "", "<init>", "()V", "", "resId", "", "a", "(I)Ljava/lang/String;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "mContext", "stks_base_release"}, k = 1, mv = {1, 6, 0})
@SuppressLint({"StaticFieldLeak"})
public final class ContextHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ContextHelper f8704a = new ContextHelper();
    public static Context b;

    public final String a(int i) {
        Context context = b;
        if (context != null) {
            return context.getString(i);
        }
        return null;
    }
}
