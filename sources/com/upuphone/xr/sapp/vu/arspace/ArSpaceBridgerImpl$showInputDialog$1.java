package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.VuInputDialog;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$showInputDialog$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n1855#2,2:668\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$showInputDialog$1\n*L\n483#1:666,2\n497#1:668,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$showInputDialog$1", "Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnTextChangeListener;", "", "text", "", "b", "(Ljava/lang/String;)V", "", "start", "end", "a", "(II)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceBridgerImpl$showInputDialog$1 implements VuInputDialog.OnTextChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceBridgerImpl f8048a;

    public ArSpaceBridgerImpl$showInputDialog$1(ArSpaceBridgerImpl arSpaceBridgerImpl) {
        this.f8048a = arSpaceBridgerImpl;
    }

    public void a(int i, int i2) {
        if (this.f8048a.currentEditTextInfo != null) {
            try {
                CopyOnWriteArraySet<IOnInputTextListener> access$getOnInputTextListeners$p = this.f8048a.onInputTextListeners;
                ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8048a;
                for (IOnInputTextListener onSelectionChange : access$getOnInputTextListeners$p) {
                    EditTextInfo access$getCurrentEditTextInfo$p = arSpaceBridgerImpl.currentEditTextInfo;
                    Intrinsics.checkNotNull(access$getCurrentEditTextInfo$p);
                    onSelectionChange.onSelectionChange(access$getCurrentEditTextInfo$p.id, i, i2);
                }
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("ArSpaceBridgerImpl", "onSelectionChanged: " + e);
            }
        }
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (this.f8048a.currentEditTextInfo != null) {
            try {
                CopyOnWriteArraySet<IOnInputTextListener> access$getOnInputTextListeners$p = this.f8048a.onInputTextListeners;
                ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8048a;
                for (IOnInputTextListener onTextChange : access$getOnInputTextListeners$p) {
                    EditTextInfo access$getCurrentEditTextInfo$p = arSpaceBridgerImpl.currentEditTextInfo;
                    Intrinsics.checkNotNull(access$getCurrentEditTextInfo$p);
                    onTextChange.onTextChange(access$getCurrentEditTextInfo$p.id, str);
                }
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("ArSpaceBridgerImpl", "onTextChanged: " + e);
            }
        }
    }
}
