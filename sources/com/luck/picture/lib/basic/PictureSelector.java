package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public final class PictureSelector {

    /* renamed from: a  reason: collision with root package name */
    public final SoftReference f9400a;
    public final SoftReference b;

    public PictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public static PictureSelector a(Fragment fragment) {
        return new PictureSelector(fragment);
    }

    public static Intent d(ArrayList arrayList) {
        return new Intent().putParcelableArrayListExtra("extra_result_media", arrayList);
    }

    public PictureSelectionQueryModel b(int i) {
        return new PictureSelectionQueryModel(this, i);
    }

    public Activity c() {
        return (Activity) this.f9400a.get();
    }

    public PictureSelector(Activity activity, Fragment fragment) {
        this.f9400a = new SoftReference(activity);
        this.b = new SoftReference(fragment);
    }
}
