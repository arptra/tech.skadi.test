package com.upuphone.ai.ttsengine;

import com.upuphone.ai.ttsengine.base.TtsManager;
import com.upuphone.ai.ttsengine.base.service.SpeakCallback;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.AudioFocusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

@SourceDebugExtension({"SMAP\nTtsSdk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsSdk.kt\ncom/upuphone/ai/ttsengine/TtsSdk$statusCallBack$1\n+ 2 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,416:1\n32#2,2:417\n32#2,2:419\n32#2,2:421\n*S KotlinDebug\n*F\n+ 1 TtsSdk.kt\ncom/upuphone/ai/ttsengine/TtsSdk$statusCallBack$1\n*L\n85#1:417,2\n99#1:419,2\n120#1:421,2\n*E\n"})
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/ai/ttsengine/TtsSdk$statusCallBack$1", "Lcom/upuphone/ai/ttsengine/base/service/SpeakCallback;", "onDone", "", "caller", "", "id", "onError", "errorCode", "", "onStart", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TtsSdk$statusCallBack$1 implements SpeakCallback {
    public void onDone(String str, String str2) {
        Unit unit;
        AILOG b = TtsSdk.b;
        b.c("onDone caller: " + str + ", id: " + str2, new Object[0]);
        if (str != null) {
            AudioFocusManager.f5525a.o(str, false);
        }
        OnStatusChange onStatusChange = (OnStatusChange) TypeIntrinsics.asMutableMap(TtsSdk.d).remove(str2);
        if (onStatusChange != null) {
            onStatusChange.a(1, 0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            synchronized (TtsSdk.c) {
                try {
                    for (TtsCallback onDone : TtsSdk.c) {
                        onDone.onDone(str, str2);
                    }
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onError(String str, String str2, int i) {
        AILOG b = TtsSdk.b;
        b.c("onError caller: " + str + ", id: " + str2 + ", errorCode: " + i, new Object[0]);
        Unit unit = null;
        if (Intrinsics.areEqual((Object) str2, (Object) TtsSdk.j)) {
            TtsSdk.j = null;
            TtsSdk.b.c("return for timeout stop", new Object[0]);
            return;
        }
        if (i == 8) {
            TtsSdk.j = str2;
            TtsManager.c().f();
        }
        if (str != null) {
            AudioFocusManager.f5525a.o(str, false);
        }
        OnStatusChange onStatusChange = (OnStatusChange) TypeIntrinsics.asMutableMap(TtsSdk.d).remove(str2);
        if (onStatusChange != null) {
            onStatusChange.a(2, i);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            synchronized (TtsSdk.c) {
                try {
                    for (TtsCallback onError : TtsSdk.c) {
                        onError.onError(str, str2, i);
                    }
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onStart(String str, String str2) {
        Unit unit;
        AILOG b = TtsSdk.b;
        b.c("onStart caller: " + str + ", id: " + str2, new Object[0]);
        OnStatusChange onStatusChange = (OnStatusChange) TtsSdk.d.get(str2);
        if (onStatusChange != null) {
            onStatusChange.a(0, 0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            synchronized (TtsSdk.c) {
                try {
                    for (TtsCallback onStart : TtsSdk.c) {
                        onStart.onStart(str, str2);
                    }
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Object unused = TtsSdk.f5490a.i();
    }
}
