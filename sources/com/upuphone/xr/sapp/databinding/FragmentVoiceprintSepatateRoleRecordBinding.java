package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.SappTitleBar;

public final class FragmentVoiceprintSepatateRoleRecordBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6827a;
    public final FragmentVoiceprintSrRecordingBinding b;
    public final FragmentVoiceprintSrRecordingCompletedBinding c;
    public final FragmentVoiceprintSrRecordingFailedBinding d;
    public final SappTitleBar e;

    public FragmentVoiceprintSepatateRoleRecordBinding(ConstraintLayout constraintLayout, FragmentVoiceprintSrRecordingBinding fragmentVoiceprintSrRecordingBinding, FragmentVoiceprintSrRecordingCompletedBinding fragmentVoiceprintSrRecordingCompletedBinding, FragmentVoiceprintSrRecordingFailedBinding fragmentVoiceprintSrRecordingFailedBinding, SappTitleBar sappTitleBar) {
        this.f6827a = constraintLayout;
        this.b = fragmentVoiceprintSrRecordingBinding;
        this.c = fragmentVoiceprintSrRecordingCompletedBinding;
        this.d = fragmentVoiceprintSrRecordingFailedBinding;
        this.e = sappTitleBar;
    }

    public static FragmentVoiceprintSepatateRoleRecordBinding a(View view) {
        int i = R.id.layout_recording;
        View a2 = ViewBindings.a(view, i);
        if (a2 != null) {
            FragmentVoiceprintSrRecordingBinding a3 = FragmentVoiceprintSrRecordingBinding.a(a2);
            i = R.id.layout_recording_completed;
            View a4 = ViewBindings.a(view, i);
            if (a4 != null) {
                FragmentVoiceprintSrRecordingCompletedBinding a5 = FragmentVoiceprintSrRecordingCompletedBinding.a(a4);
                i = R.id.layout_recording_failed;
                View a6 = ViewBindings.a(view, i);
                if (a6 != null) {
                    FragmentVoiceprintSrRecordingFailedBinding a7 = FragmentVoiceprintSrRecordingFailedBinding.a(a6);
                    i = R.id.title_bar;
                    SappTitleBar sappTitleBar = (SappTitleBar) ViewBindings.a(view, i);
                    if (sappTitleBar != null) {
                        return new FragmentVoiceprintSepatateRoleRecordBinding((ConstraintLayout) view, a3, a5, a7, sappTitleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentVoiceprintSepatateRoleRecordBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_voiceprint_sepatate_role_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6827a;
    }
}
