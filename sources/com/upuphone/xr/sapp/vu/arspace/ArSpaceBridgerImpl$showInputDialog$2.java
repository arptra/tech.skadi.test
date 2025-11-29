package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.VuInputDialog;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$showInputDialog$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$showInputDialog$2\n*L\n511#1:666,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$showInputDialog$2", "Lcom/upuphone/xr/sapp/vu/VuInputDialog$OnEditorActionListener;", "", "action", "", "a", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceBridgerImpl$showInputDialog$2 implements VuInputDialog.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceBridgerImpl f8049a;

    public ArSpaceBridgerImpl$showInputDialog$2(ArSpaceBridgerImpl arSpaceBridgerImpl) {
        this.f8049a = arSpaceBridgerImpl;
    }

    public void a(int i) {
        if (this.f8049a.currentEditTextInfo != null) {
            try {
                CopyOnWriteArraySet<IOnInputTextListener> access$getOnInputTextListeners$p = this.f8049a.onInputTextListeners;
                ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8049a;
                for (IOnInputTextListener onAction : access$getOnInputTextListeners$p) {
                    EditTextInfo access$getCurrentEditTextInfo$p = arSpaceBridgerImpl.currentEditTextInfo;
                    Intrinsics.checkNotNull(access$getCurrentEditTextInfo$p);
                    onAction.onAction(access$getCurrentEditTextInfo$p.id, i);
                }
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("ArSpaceBridgerImpl", "onEditorAction: " + e);
            }
        }
    }
}
