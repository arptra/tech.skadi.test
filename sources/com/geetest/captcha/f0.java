package com.geetest.captcha;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR$\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/geetest/captcha/utils/HttpUrl;", "", "", "baseUrl", "", "params", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "Lcom/geetest/captcha/utils/HttpUrl$Builder;", "newBuilder", "()Lcom/geetest/captcha/utils/HttpUrl$Builder;", "Ljava/lang/String;", "Ljava/util/Map;", "Builder", "Companion", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class f0 {
    public static final a c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f2854a;
    public final Map b;

    public static final class a {
        public final f0 a(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            try {
                if (StringsKt.isBlank(str)) {
                    return null;
                }
                Object[] array = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) str).toString(), new String[]{"?"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    HashMap hashMap = new HashMap();
                    if (strArr.length == 1) {
                        return new f0(strArr[0], hashMap);
                    }
                    if (strArr.length == 2) {
                        Object[] array2 = StringsKt.split$default((CharSequence) strArr[1], new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            int length = strArr2.length;
                            int i = 0;
                            while (i < length) {
                                Object[] array3 = StringsKt.split$default((CharSequence) strArr2[i], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                                if (array3 != null) {
                                    String[] strArr3 = (String[]) array3;
                                    if (strArr3.length == 2) {
                                        hashMap.put(strArr3[0], strArr3[1]);
                                    }
                                    i++;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            return new f0(strArr[0], hashMap);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public f0(String str, Map map) {
        this.f2854a = str;
        this.b = map;
    }

    public String toString() {
        Map map = this.b;
        if (map == null || map.isEmpty()) {
            return this.f2854a;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f2854a);
        stringBuffer.append('?');
        for (Map.Entry entry : this.b.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append('=');
            stringBuffer.append((String) entry.getValue());
            stringBuffer.append(Typography.amp);
        }
        String stringBuffer2 = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.deleteCharAt(sb.length - 1).toString()");
        return stringBuffer2;
    }
}
