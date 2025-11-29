package com.upuphone.ai.ttsengine.base.helper;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/helper/TextFilter;", "", "<init>", "()V", "", "origin", "", "a", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "source", "", "b", "(Ljava/lang/CharSequence;)Z", "c", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "phoneNumPattern", "whiteCharPattern", "d", "symbolPattern", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TextFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final TextFilter f5505a = new TextFilter();
    public static final Regex b = new Regex("(?:电话|号码|拨打)[^,.;，。?？!！\\n]*(1\\s*[3-9](?:\\s*\\d){9})|(1\\s*[3-9](?:\\s*\\d){9})[^.;。?？!！\\n]*(?:电话|来电)");
    public static final Regex c = new Regex("\\s");
    public static final Regex d = new Regex("^[,.;，。?？!！:：@#+\\-=|{}\\[\\]【】《》<>\n]+$");

    public final String a(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        try {
            Result.Companion companion = Result.Companion;
            Unit unit = null;
            MatchResult find$default = Regex.find$default(b, charSequence, 0, 2, (Object) null);
            if (find$default != null) {
                charSequence = StringsKt.replaceRange(charSequence, find$default.getRange(), (CharSequence) c.replace((CharSequence) find$default.getValue(), ""));
                unit = Unit.INSTANCE;
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        return charSequence.toString();
    }

    public final boolean b(CharSequence charSequence) {
        String replace = charSequence != null ? c.replace(charSequence, "") : null;
        return replace == null || replace.length() == 0;
    }

    public final boolean c(CharSequence charSequence) {
        if (charSequence != null) {
            return d.matches(charSequence);
        }
        return false;
    }
}
