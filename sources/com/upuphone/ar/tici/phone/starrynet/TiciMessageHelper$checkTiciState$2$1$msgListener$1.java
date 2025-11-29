package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply;
import com.upuphone.ar.tici.phone.utils.JsonUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;

@SourceDebugExtension({"SMAP\nTiciMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$checkTiciState$2$1$msgListener$1\n+ 2 JsonUtils.kt\ncom/upuphone/ar/tici/phone/utils/JsonUtils\n*L\n1#1,364:1\n29#2,5:365\n*S KotlinDebug\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$checkTiciState$2$1$msgListener$1\n*L\n156#1:365,5\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$checkTiciState$2$1$msgListener$1", "Lkotlin/Function1;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;", "", "Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsgListener;", "p1", "a", "(Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;)V", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciMessageHelper$checkTiciState$2$1$msgListener$1 implements Function1<BaseActionMsg, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5974a;
    public final /* synthetic */ CancellableContinuation b;

    public TiciMessageHelper$checkTiciState$2$1$msgListener$1(String str, CancellableContinuation cancellableContinuation) {
        this.f5974a = str;
        this.b = cancellableContinuation;
    }

    public void a(BaseActionMsg baseActionMsg) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseActionMsg, "p1");
        JsonUtils jsonUtils = JsonUtils.f5992a;
        String value = baseActionMsg.getValue();
        Type type = new TiciMessageHelper$checkTiciState$2$1$msgListener$1$invoke$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(value, type);
        }
        CheckTiciStateReply checkTiciStateReply = (CheckTiciStateReply) obj;
        TiciApp.b.q().getReceiveMsgHandler().s(this.f5974a, this);
        if (this.b.isActive() && checkTiciStateReply != null) {
            this.b.resumeWith(Result.m20constructorimpl(Result.m19boximpl(Result.m20constructorimpl(checkTiciStateReply))));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((BaseActionMsg) obj);
        return Unit.INSTANCE;
    }
}
