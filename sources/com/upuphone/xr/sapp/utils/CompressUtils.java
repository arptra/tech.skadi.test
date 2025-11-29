package com.upuphone.xr.sapp.utils;

import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.utils.DateUtils;
import java.io.File;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.OnNewCompressListener;
import top.zibin.luban.OnRenameListener;

public class CompressUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final CompressUtils f7855a = new CompressUtils();

    /* renamed from: com.upuphone.xr.sapp.utils.CompressUtils$1  reason: invalid class name */
    class AnonymousClass1 implements OnNewCompressListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnKeyValueResultCallbackListener f7856a;

        public void a(String str, File file) {
            OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = this.f7856a;
            if (onKeyValueResultCallbackListener != null) {
                onKeyValueResultCallbackListener.a(str, file.getAbsolutePath());
            }
        }

        public void b(String str, Throwable th) {
            OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = this.f7856a;
            if (onKeyValueResultCallbackListener != null) {
                onKeyValueResultCallbackListener.a(str, (String) null);
            }
        }

        public void onStart() {
        }
    }

    /* renamed from: com.upuphone.xr.sapp.utils.CompressUtils$2  reason: invalid class name */
    class AnonymousClass2 implements CompressionPredicate {
        public boolean apply(String str) {
            if (!PictureMimeType.n(str) || PictureMimeType.g(str)) {
                return !PictureMimeType.m(str);
            }
            return true;
        }
    }

    /* renamed from: com.upuphone.xr.sapp.utils.CompressUtils$3  reason: invalid class name */
    class AnonymousClass3 implements OnRenameListener {
        public String a(String str) {
            int lastIndexOf = str.lastIndexOf(".");
            String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : ".jpg";
            return DateUtils.c("CMP_") + substring;
        }
    }
}
