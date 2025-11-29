package com.luck.picture.lib.basic;

import android.app.Activity;
import android.text.TextUtils;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryDataSourceListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import java.util.ArrayList;
import java.util.List;

public class PictureSelectionQueryModel {

    /* renamed from: a  reason: collision with root package name */
    public final SelectorConfig f9396a;
    public final PictureSelector b;

    /* renamed from: com.luck.picture.lib.basic.PictureSelectionQueryModel$1  reason: invalid class name */
    class AnonymousClass1 implements OnQueryAllAlbumListener<LocalMediaFolder> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnQueryDataSourceListener f9397a;

        public void a(List list) {
            this.f9397a.a(list);
        }
    }

    public PictureSelectionQueryModel(PictureSelector pictureSelector, int i) {
        this.b = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.f9396a = selectorConfig;
        SelectorProviders.c().a(selectorConfig);
        selectorConfig.f9404a = i;
    }

    public void b(final OnQueryDataSourceListener onQueryDataSourceListener) {
        Activity c = this.b.c();
        if (c == null) {
            throw new NullPointerException("Activity cannot be null");
        } else if (onQueryDataSourceListener != null) {
            final IBridgeMediaLoader localMediaPageLoader = this.f9396a.e0 ? new LocalMediaPageLoader(c, this.f9396a) : new LocalMediaLoader(c, this.f9396a);
            localMediaPageLoader.f(new OnQueryAllAlbumListener<LocalMediaFolder>() {
                public void a(List list) {
                    if (list != null && list.size() > 0) {
                        LocalMediaFolder localMediaFolder = (LocalMediaFolder) list.get(0);
                        if (PictureSelectionQueryModel.this.f9396a.e0) {
                            localMediaPageLoader.h(localMediaFolder.getBucketId(), 1, PictureSelectionQueryModel.this.f9396a.d0, new OnQueryDataResultListener<LocalMedia>() {
                                public void a(ArrayList arrayList, boolean z) {
                                    onQueryDataSourceListener.a(arrayList);
                                }
                            });
                            return;
                        }
                        onQueryDataSourceListener.a(localMediaFolder.getData());
                    }
                }
            });
        } else {
            throw new NullPointerException("OnQueryDataSourceListener cannot be null");
        }
    }

    public PictureSelectionQueryModel c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f9396a.b0 = str;
        }
        return this;
    }
}
