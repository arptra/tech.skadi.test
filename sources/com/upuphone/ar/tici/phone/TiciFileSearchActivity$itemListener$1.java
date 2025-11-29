package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.listener.SystemFileItemListener;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/upuphone/ar/tici/phone/TiciFileSearchActivity$itemListener$1", "Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "fileInfo", "", "a", "(Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;)V", "b", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciFileSearchActivity$itemListener$1 implements SystemFileItemListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciFileSearchActivity f5882a;

    public TiciFileSearchActivity$itemListener$1(TiciFileSearchActivity ticiFileSearchActivity) {
        this.f5882a = ticiFileSearchActivity;
    }

    public void a(SystemFileInfo systemFileInfo) {
        Intrinsics.checkNotNullParameter(systemFileInfo, "fileInfo");
        CommonExtKt.e("onImportClick, " + systemFileInfo, "TiciFileSearchActivity");
        if (!new File(systemFileInfo.getPath()).exists()) {
            CommonExtKt.j(this.f5882a, R.string.tici_file_not_exist, 0, 2, (Object) null);
            return;
        }
        TiciApp.b.c().K0(systemFileInfo);
        this.f5882a.finish();
    }

    public void b(SystemFileInfo systemFileInfo) {
        Intrinsics.checkNotNullParameter(systemFileInfo, "fileInfo");
        CommonExtKt.e("onItemClick, " + systemFileInfo, "TiciFileSearchActivity");
        if (TiciApp.b.l()) {
            if (systemFileInfo.getSize() > 10485760) {
                CommonExtKt.j(this.f5882a, R.string.tici_file_over_size_10m_toast, 0, 2, (Object) null);
            }
        } else if (systemFileInfo.getSize() > 204800) {
            CommonExtKt.j(this.f5882a, R.string.tici_file_over_size_200k_toast, 0, 2, (Object) null);
        }
    }
}
