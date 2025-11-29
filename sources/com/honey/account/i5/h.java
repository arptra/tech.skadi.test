package com.honey.account.i5;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel;
import java.util.List;

public final /* synthetic */ class h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorRecordViewModel f4847a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ NoteBean c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ View e;
    public final /* synthetic */ List f;
    public final /* synthetic */ String g;

    public /* synthetic */ h(TranslatorRecordViewModel translatorRecordViewModel, Activity activity, NoteBean noteBean, RecyclerView recyclerView, View view, List list, String str) {
        this.f4847a = translatorRecordViewModel;
        this.b = activity;
        this.c = noteBean;
        this.d = recyclerView;
        this.e = view;
        this.f = list;
        this.g = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TranslatorRecordViewModel.Q(this.f4847a, this.b, this.c, this.d, this.e, this.f, this.g, dialogInterface, i);
    }
}
