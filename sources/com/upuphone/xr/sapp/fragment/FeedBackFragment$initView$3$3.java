package com.upuphone.xr.sapp.fragment;

import android.net.Uri;
import android.os.Bundle;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.FeedBackFile;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFeedBackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$initView$3$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,815:1\n1549#2:816\n1620#2,3:817\n*S KotlinDebug\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$initView$3$3\n*L\n314#1:816\n314#1:817,3\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FeedBackFragment$initView$3$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FeedBackFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFragment$initView$3$3(FeedBackFragment feedBackFragment) {
        super(1);
        this.this$0 = feedBackFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        Bundle bundle = new Bundle();
        FeedBackFragment feedBackFragment = this.this$0;
        bundle.putInt("MEDIA_INDEX", feedBackFragment.l.size());
        ArrayList<FeedBackFile> S0 = feedBackFragment.l;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(S0, 10));
        for (FeedBackFile a2 : S0) {
            Uri a3 = a2.a();
            Intrinsics.checkNotNull(a3);
            arrayList.add(a3);
        }
        bundle.putParcelableArrayList("MEDIA_ARRAY", arrayList);
        StaticMethodUtilsKt.v(this.this$0, R.id.mediaPreviewFragment, bundle);
        this.this$0.o1();
    }
}
