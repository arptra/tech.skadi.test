package com.xjsd.ai.assistant.accessibility.utils;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0013R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/xjsd/ai/assistant/accessibility/utils/SearchNodeRule;", "", "", "toString", "()Ljava/lang/String;", "", "a", "Ljava/lang/Boolean;", "isVisibleToUser", "()Ljava/lang/Boolean;", "setVisibleToUser", "(Ljava/lang/Boolean;)V", "b", "isEnabled", "setEnabled", "c", "Ljava/lang/String;", "getResourceId", "setResourceId", "(Ljava/lang/String;)V", "resourceId", "d", "getClassName", "setClassName", "className", "Lkotlin/text/Regex;", "e", "Lkotlin/text/Regex;", "getTextRegex", "()Lkotlin/text/Regex;", "setTextRegex", "(Lkotlin/text/Regex;)V", "textRegex", "f", "Z", "getPinyinMode", "()Z", "setPinyinMode", "(Z)V", "pinyinMode", "accessibility_release"}, k = 1, mv = {1, 8, 0})
public class SearchNodeRule {

    /* renamed from: a  reason: collision with root package name */
    public Boolean f8380a;
    public Boolean b;
    public String c;
    public String d;
    public Regex e;
    public boolean f;

    public String toString() {
        return "SearchNodeRule(isVisibleToUser=" + this.f8380a + ", isEnabled=" + this.b + ", resourceId=" + this.c + ", className=" + this.d + ", textRegex=" + this.e + ", pinyinMode=" + this.f + ')';
    }
}
