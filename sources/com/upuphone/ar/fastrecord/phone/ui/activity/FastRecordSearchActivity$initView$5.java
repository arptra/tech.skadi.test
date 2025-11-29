package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.text.TextWatcher;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSearchActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$initView$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,207:1\n262#2,2:208\n*S KotlinDebug\n*F\n+ 1 FastRecordSearchActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$initView$5\n*L\n153#1:208,2\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$initView$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "content", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSearchActivity$initView$5 implements TextWatcher {
    final /* synthetic */ FastRecordSearchActivity this$0;

    public FastRecordSearchActivity$initView$5(FastRecordSearchActivity fastRecordSearchActivity) {
        this.this$0 = fastRecordSearchActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.upuphone.ar.fastrecord.phone.ui.viewmodel.search.FastRecordSearchViewModel} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "s.toString() is: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FastRecordSearchActivity"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logD(r0, r1)
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r0 = r2.this$0
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r3)
            java.lang.String r3 = r3.toString()
            r0.keyWordValue = r3
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r3 = r2.this$0
            java.lang.String r3 = r3.keyWordValue
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r0 = 0
            if (r3 != 0) goto L_0x0051
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r3 = r2.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.search.FastRecordSearchViewModel r3 = r3.viewModel
            if (r3 != 0) goto L_0x0046
            java.lang.String r3 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0047
        L_0x0046:
            r0 = r3
        L_0x0047:
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r3 = r2.this$0
            java.lang.String r3 = r3.keyWordValue
            r0.queryRecordInfoNoNeedCheckShowContent(r3)
            goto L_0x007b
        L_0x0051:
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r3 = r2.this$0
            com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter r3 = r3.viewAdapter
            if (r3 != 0) goto L_0x0060
            java.lang.String r3 = "viewAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0061
        L_0x0060:
            r0 = r3
        L_0x0061:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0.notifyRecordData(r3)
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r3 = r2.this$0
            com.upuphone.ar.fastrecord.databinding.FastRecordSearchActivityBinding r3 = r3.getLayout()
            android.widget.LinearLayout r3 = r3.d
            java.lang.String r0 = "llEmpty"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r0 = 8
            r3.setVisibility(r0)
        L_0x007b:
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r3 = r2.this$0
            com.upuphone.ar.fastrecord.databinding.FastRecordSearchActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText r0 = r0.c
            java.lang.String r1 = "edtSearch"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity r2 = r2.this$0
            com.upuphone.ar.fastrecord.databinding.FastRecordSearchActivityBinding r2 = r2.getLayout()
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText r2 = r2.c
            android.text.Editable r2 = r2.getText()
            r1 = 1
            if (r2 == 0) goto L_0x00a0
            int r2 = r2.length()
            if (r2 != 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r2 = 0
            goto L_0x00a1
        L_0x00a0:
            r2 = r1
        L_0x00a1:
            r2 = r2 ^ r1
            r3.setDrawable(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSearchActivity$initView$5.afterTextChanged(android.text.Editable):void");
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        LogExt.logE("beforeTextChanged p0 = " + charSequence, "FastRecordSearchActivity");
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        LogExt.logE("onTextChanged content = " + charSequence, "FastRecordSearchActivity");
    }
}
