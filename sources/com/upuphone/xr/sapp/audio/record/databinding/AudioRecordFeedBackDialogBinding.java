package com.upuphone.xr.sapp.audio.record.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.audio.record.R;

public final class AudioRecordFeedBackDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6648a;
    public final RecyclerView b;
    public final TextView c;
    public final TextView d;

    public AudioRecordFeedBackDialogBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f6648a = constraintLayout;
        this.b = recyclerView;
        this.c = textView;
        this.d = textView2;
    }

    public static AudioRecordFeedBackDialogBinding a(View view) {
        int i = R.id.rec_record;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
        if (recyclerView != null) {
            i = R.id.tv_ok;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_tag;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new AudioRecordFeedBackDialogBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AudioRecordFeedBackDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static AudioRecordFeedBackDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.audio_record_feed_back_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6648a;
    }
}
