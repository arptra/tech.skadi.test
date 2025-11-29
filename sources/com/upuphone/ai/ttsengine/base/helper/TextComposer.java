package com.upuphone.ai.ttsengine.base.helper;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/helper/TextComposer;", "", "<init>", "()V", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Lkotlin/text/Regex;", "c", "Lkotlin/text/Regex;", "symbolRegex", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TextComposer {

    /* renamed from: a  reason: collision with root package name */
    public static final TextComposer f5504a = new TextComposer();
    public static final AILOG b = AILOG.a("TextComposer");
    public static final Regex c = new Regex("[,，.。!！?？;；]");
}
