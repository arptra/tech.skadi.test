package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.IAudioMulti;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0006*\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0010R,\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b0\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AudioMultiHelper;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/context/IAudioMulti;", "audioMulti", "", "c", "(Lcom/upuphone/xr/sapp/context/IAudioMulti;)V", "", "callbackKey", "Lkotlin/Function1;", "callback", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "d", "(Ljava/lang/String;)V", "b", "", "Ljava/util/Map;", "mCallbackMap", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAudioMultiHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioMultiHelper.kt\ncom/upuphone/xr/sapp/utils/AudioMultiHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,56:1\n215#2,2:57\n*S KotlinDebug\n*F\n+ 1 AudioMultiHelper.kt\ncom/upuphone/xr/sapp/utils/AudioMultiHelper\n*L\n21#1:57,2\n*E\n"})
public final class AudioMultiHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AudioMultiHelper f7846a = new AudioMultiHelper();
    public static final Map b = new LinkedHashMap();

    public final void a(String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Map map = b;
        if (map.containsKey(str)) {
            b("addAudioMultiCallback \"" + str + "\" 被重复注册");
            return;
        }
        map.put(str, function1);
    }

    public final void b(String str) {
        ULog.f6446a.g("AudioMultiHelper", str);
    }

    public final void c(IAudioMulti iAudioMulti) {
        Intrinsics.checkNotNullParameter(iAudioMulti, "audioMulti");
        for (Map.Entry value : b.entrySet()) {
            ((Function1) value.getValue()).invoke(iAudioMulti);
        }
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "callbackKey");
        Map map = b;
        if (map.containsKey(str)) {
            map.remove(str);
            return;
        }
        b("removeAudioMultiCallback \"" + str + "\" 从未被注册");
    }
}
