package com.upuphone.ar.tici.phone.starrynet;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "", "()V", "toJsonString", "", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public class BaseJsonMsg {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Gson gson = new Gson();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg$Companion;", "", "<init>", "()V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "a", "()Lcom/google/gson/Gson;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Gson a() {
            return BaseJsonMsg.gson;
        }

        public Companion() {
        }
    }

    @NotNull
    public final String toJsonString() {
        String json = gson.toJson((Object) this);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
