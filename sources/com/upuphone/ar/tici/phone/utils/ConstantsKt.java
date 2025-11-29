package com.upuphone.ar.tici.phone.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\b\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"\u001a\u0010\u000b\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\"\u001a\u0010\r\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\f\u0010\u0004\"\u001a\u0010\u000f\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\u000e\u0010\u0002\u001a\u0004\b\t\u0010\u0004\"\u001a\u0010\u0010\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\f\u0010\u0002\u001a\u0004\b\u000e\u0010\u0004\"\u001a\u0010\u0011\u001a\u00020\u00008\u0000XD¢\u0006\f\n\u0004\b\u0003\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0001\u0010\u0016\"\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\"\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0011\u0010&\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010%¨\u0006'"}, d2 = {"", "a", "I", "g", "()I", "CODE_SUCC", "b", "d", "CODE_FAILED", "c", "h", "CODE_TIME_OUT", "f", "CODE_OVER_SIZE", "e", "CODE_DISCONNECT", "CODE_MANUALLY_CANCELD", "CODE_CANCELD_BY_GLASS", "", "", "Ljava/util/List;", "j", "()Ljava/util/List;", "TXT_FILE_SUFFIX_LIST", "i", "k", "WORD_FILE_SUFFIX_LIST", "ALL_FILE_SUFFIX_LIST", "getTXT_FILE_MIME_LIST", "TXT_FILE_MIME_LIST", "l", "getWORD_FILE_MIME_LIST", "WORD_FILE_MIME_LIST", "m", "getALL_FILE_MIME_LIST", "ALL_FILE_MIME_LIST", "Lkotlin/ranges/IntRange;", "()Lkotlin/ranges/IntRange;", "defaultTiciTypeRange", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class ConstantsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5980a = 0;
    public static final int b = -1;
    public static final int c = -2;
    public static final int d = -3;
    public static final int e = -4;
    public static final int f = -5;
    public static final int g = -6;
    public static final List h;
    public static final List i;
    public static final List j;
    public static final List k;
    public static final List l;
    public static final List m;

    static {
        List listOf = CollectionsKt.listOf(".txt");
        h = listOf;
        List listOf2 = CollectionsKt.listOf(".doc", ".docx");
        i = listOf2;
        j = CollectionsKt.plus(listOf, listOf2);
        List listOf3 = CollectionsKt.listOf("text/plain");
        k = listOf3;
        List listOf4 = CollectionsKt.listOf("application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        l = listOf4;
        m = CollectionsKt.plus(listOf3, listOf4);
    }

    public static final List a() {
        return j;
    }

    public static final int b() {
        return g;
    }

    public static final int c() {
        return e;
    }

    public static final int d() {
        return b;
    }

    public static final int e() {
        return f;
    }

    public static final int f() {
        return d;
    }

    public static final int g() {
        return f5980a;
    }

    public static final int h() {
        return c;
    }

    public static final IntRange i() {
        return new IntRange(1, 6);
    }

    public static final List j() {
        return h;
    }

    public static final List k() {
        return i;
    }
}
