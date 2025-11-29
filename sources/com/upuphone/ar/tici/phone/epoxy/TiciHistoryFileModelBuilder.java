package com.upuphone.ar.tici.phone.epoxy;

import com.airbnb.epoxy.EpoxyBuildScope;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.listener.TiciHistoryItemListener;

@EpoxyBuildScope
public interface TiciHistoryFileModelBuilder {
    TiciHistoryFileModelBuilder a(CharSequence charSequence);

    TiciHistoryFileModelBuilder b(int i);

    TiciHistoryFileModelBuilder c(boolean z);

    TiciHistoryFileModelBuilder g(TiciHistory ticiHistory);

    TiciHistoryFileModelBuilder i(TiciHistoryItemListener ticiHistoryItemListener);

    TiciHistoryFileModelBuilder j(boolean z);

    TiciHistoryFileModelBuilder m(boolean z);

    TiciHistoryFileModelBuilder n(boolean z);
}
