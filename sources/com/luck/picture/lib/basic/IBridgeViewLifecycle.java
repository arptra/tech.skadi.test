package com.luck.picture.lib.basic;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public interface IBridgeViewLifecycle {
    void a(Fragment fragment, View view, Bundle bundle);

    void b(Fragment fragment);
}
