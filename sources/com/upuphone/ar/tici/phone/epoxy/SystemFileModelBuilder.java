package com.upuphone.ar.tici.phone.epoxy;

import com.airbnb.epoxy.EpoxyBuildScope;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.listener.SystemFileItemListener;

@EpoxyBuildScope
public interface SystemFileModelBuilder {
    SystemFileModelBuilder a(CharSequence charSequence);

    SystemFileModelBuilder b(int i);

    SystemFileModelBuilder e(SystemFileItemListener systemFileItemListener);

    SystemFileModelBuilder h(boolean z);

    SystemFileModelBuilder o(SystemFileInfo systemFileInfo);
}
