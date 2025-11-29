package com.honey.account.z;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.navigation.fragment.DialogFragmentNavigator;

public final /* synthetic */ class b implements FragmentOnAttachListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogFragmentNavigator f3144a;

    public /* synthetic */ b(DialogFragmentNavigator dialogFragmentNavigator) {
        this.f3144a = dialogFragmentNavigator;
    }

    public final void a(FragmentManager fragmentManager, Fragment fragment) {
        DialogFragmentNavigator.q(this.f3144a, fragmentManager, fragment);
    }
}
