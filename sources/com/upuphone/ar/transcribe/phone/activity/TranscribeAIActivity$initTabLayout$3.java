package com.upuphone.ar.transcribe.phone.activity;

import com.google.android.material.tabs.TabLayout;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeAiBinding;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeAIActivity$initTabLayout$3", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "p0", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAIActivity$initTabLayout$3 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ TranscribeAIActivity this$0;

    public TranscribeAIActivity$initTabLayout$3(TranscribeAIActivity transcribeAIActivity) {
        this.this$0 = transcribeAIActivity;
    }

    public void onTabReselected(@Nullable TabLayout.Tab tab) {
        ULog.f6446a.a("TranscribeAIActivity", "onTabReselected");
        ActivityTranscribeAiBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.b.requestFocus();
    }

    public void onTabSelected(@Nullable TabLayout.Tab tab) {
        ULog.f6446a.a("TranscribeAIActivity", "on tab selected");
        ActivityTranscribeAiBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.b.requestFocus();
    }

    public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        ULog.f6446a.a("TranscribeAIActivity", "onTabUnselected");
    }
}
