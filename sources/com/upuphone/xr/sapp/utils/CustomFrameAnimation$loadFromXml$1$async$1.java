package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.io.IOUtils;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$MyFrame;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.CustomFrameAnimation$loadFromXml$1$async$1", f = "CustomFrameAnimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CustomFrameAnimation$loadFromXml$1$async$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<CustomFrameAnimation.MyFrame>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $defaultDuration;
    final /* synthetic */ int $resourceId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomFrameAnimation$loadFromXml$1$async$1(Context context, int i, int i2, Continuation<? super CustomFrameAnimation$loadFromXml$1$async$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$resourceId = i;
        this.$defaultDuration = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomFrameAnimation$loadFromXml$1$async$1(this.$context, this.$resourceId, this.$defaultDuration, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            XmlResourceParser xml = this.$context.getResources().getXml(this.$resourceId);
            Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        if (Intrinsics.areEqual((Object) xml.getName(), (Object) "item")) {
                            int i = this.$defaultDuration;
                            int attributeCount = xml.getAttributeCount();
                            byte[] bArr = null;
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                if (Intrinsics.areEqual((Object) xml.getAttributeName(i2), (Object) "drawable")) {
                                    String attributeValue = xml.getAttributeValue(i2);
                                    Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                                    String substring = attributeValue.substring(1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                    bArr = IOUtils.d(this.$context.getResources().openRawResource(Integer.parseInt(substring)));
                                } else if (Intrinsics.areEqual((Object) xml.getAttributeName(i2), (Object) "duration")) {
                                    i = xml.getAttributeIntValue(i2, this.$defaultDuration);
                                }
                            }
                            CustomFrameAnimation.MyFrame myFrame = new CustomFrameAnimation.MyFrame();
                            myFrame.e(bArr);
                            myFrame.g(i);
                            arrayList.add(myFrame);
                        }
                    }
                }
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e.getMessage();
                delegate.c("CustomFrameAnimation", "loadFromXml error: " + message);
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ArrayList<CustomFrameAnimation.MyFrame>> continuation) {
        return ((CustomFrameAnimation$loadFromXml$1$async$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
