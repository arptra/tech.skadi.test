package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$shareByType$1 extends Lambda implements Function1<ArrayList<Uri>, Unit> {
    final /* synthetic */ String $type;
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$shareByType$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, String str) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
        this.$type = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<Uri>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ArrayList<Uri> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "it");
        this.this$0.shareFilePath(arrayList, this.$type);
    }
}
