package com.luck.picture.lib;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import java.util.ArrayList;
import java.util.List;

public class PictureSelectorSystemFragment extends PictureCommonFragment {
    public static final String p = "PictureSelectorSystemFragment";
    public ActivityResultLauncher l;
    public ActivityResultLauncher m;
    public ActivityResultLauncher n;
    public ActivityResultLauncher o;

    public static PictureSelectorSystemFragment n2() {
        return new PictureSelectorSystemFragment();
    }

    public int W0() {
        return R.layout.ps_empty;
    }

    public void a1(String[] strArr) {
        v1(false, (String[]) null);
        SelectorConfig selectorConfig = this.e;
        OnPermissionsInterceptListener onPermissionsInterceptListener = selectorConfig.d1;
        if (onPermissionsInterceptListener != null ? onPermissionsInterceptListener.a(this, strArr) : PermissionChecker.g(selectorConfig.f9404a, getContext())) {
            o2();
        } else {
            ToastUtils.c(getContext(), getString(R.string.ps_jurisdiction));
            s1();
        }
        PermissionConfig.f9440a = new String[0];
    }

    public void f1(int i, String[] strArr) {
        if (i == -2) {
            this.e.d1.b(this, PermissionConfig.a(T0(), this.e.f9404a), new OnRequestPermissionListener() {
            });
        }
    }

    public final void h2() {
        this.o = registerForActivityResult(new ActivityResultContract<String, Uri>() {
            /* renamed from: d */
            public Intent a(Context context, String str) {
                return TextUtils.equals("video/*", str) ? new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI) : TextUtils.equals(RecordConstants.SHARE_TYPE_AUDIO, str) ? new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI) : new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }

            /* renamed from: e */
            public Uri c(int i, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }
        }, new ActivityResultCallback<Uri>() {
            /* renamed from: b */
            public void a(Uri uri) {
                if (uri == null) {
                    PictureSelectorSystemFragment.this.s1();
                    return;
                }
                LocalMedia g2 = PictureSelectorSystemFragment.this.m0(uri.toString());
                g2.setPath(SdkVersionUtils.f() ? g2.getPath() : g2.getRealPath());
                if (PictureSelectorSystemFragment.this.D0(g2, false) == 0) {
                    PictureSelectorSystemFragment.this.Q0();
                } else {
                    PictureSelectorSystemFragment.this.s1();
                }
            }
        });
    }

    public final void i2() {
        this.n = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() {
            /* renamed from: d */
            public Intent a(Context context, String str) {
                Intent intent = TextUtils.equals("video/*", str) ? new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI) : TextUtils.equals(RecordConstants.SHARE_TYPE_AUDIO, str) ? new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI) : new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                return intent;
            }

            /* renamed from: e */
            public List c(int i, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }
        }, new ActivityResultCallback<List<Uri>>() {
            /* renamed from: b */
            public void a(List list) {
                if (list == null || list.size() == 0) {
                    PictureSelectorSystemFragment.this.s1();
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    LocalMedia d2 = PictureSelectorSystemFragment.this.m0(((Uri) list.get(i)).toString());
                    d2.setPath(SdkVersionUtils.f() ? d2.getPath() : d2.getRealPath());
                    PictureSelectorSystemFragment.this.e.c(d2);
                }
                PictureSelectorSystemFragment.this.Q0();
            }
        });
    }

    public final void j2() {
        this.l = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() {
            /* renamed from: d */
            public Intent a(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType(str);
                return intent;
            }

            /* renamed from: e */
            public List c(int i, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }
        }, new ActivityResultCallback<List<Uri>>() {
            /* renamed from: b */
            public void a(List list) {
                if (list == null || list.size() == 0) {
                    PictureSelectorSystemFragment.this.s1();
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    LocalMedia X1 = PictureSelectorSystemFragment.this.m0(((Uri) list.get(i)).toString());
                    X1.setPath(SdkVersionUtils.f() ? X1.getPath() : X1.getRealPath());
                    PictureSelectorSystemFragment.this.e.c(X1);
                }
                PictureSelectorSystemFragment.this.Q0();
            }
        });
    }

    public final void k2() {
        this.m = registerForActivityResult(new ActivityResultContract<String, Uri>() {
            /* renamed from: d */
            public Intent a(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(str);
                return intent;
            }

            /* renamed from: e */
            public Uri c(int i, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }
        }, new ActivityResultCallback<Uri>() {
            /* renamed from: b */
            public void a(Uri uri) {
                if (uri == null) {
                    PictureSelectorSystemFragment.this.s1();
                    return;
                }
                LocalMedia b2 = PictureSelectorSystemFragment.this.m0(uri.toString());
                b2.setPath(SdkVersionUtils.f() ? b2.getPath() : b2.getRealPath());
                if (PictureSelectorSystemFragment.this.D0(b2, false) == 0) {
                    PictureSelectorSystemFragment.this.Q0();
                } else {
                    PictureSelectorSystemFragment.this.s1();
                }
            }
        });
    }

    public final void l2() {
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.j == 1) {
            if (selectorConfig.f9404a == SelectMimeType.a()) {
                k2();
            } else {
                h2();
            }
        } else if (selectorConfig.f9404a == SelectMimeType.a()) {
            j2();
        } else {
            i2();
        }
    }

    public final String m2() {
        return this.e.f9404a == SelectMimeType.d() ? "video/*" : this.e.f9404a == SelectMimeType.b() ? RecordConstants.SHARE_TYPE_AUDIO : "image/*";
    }

    public final void o2() {
        v1(false, (String[]) null);
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.j == 1) {
            if (selectorConfig.f9404a == SelectMimeType.a()) {
                this.m.a("image/*,video/*");
            } else {
                this.o.a(m2());
            }
        } else if (selectorConfig.f9404a == SelectMimeType.a()) {
            this.l.a("image/*,video/*");
        } else {
            this.n.a(m2());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            s1();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ActivityResultLauncher activityResultLauncher = this.l;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
        }
        ActivityResultLauncher activityResultLauncher2 = this.m;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.c();
        }
        ActivityResultLauncher activityResultLauncher3 = this.n;
        if (activityResultLauncher3 != null) {
            activityResultLauncher3.c();
        }
        ActivityResultLauncher activityResultLauncher4 = this.o;
        if (activityResultLauncher4 != null) {
            activityResultLauncher4.c();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        l2();
        if (PermissionChecker.g(this.e.f9404a, getContext())) {
            o2();
            return;
        }
        final String[] a2 = PermissionConfig.a(T0(), this.e.f9404a);
        v1(true, a2);
        if (this.e.d1 != null) {
            f1(-2, a2);
        } else {
            PermissionChecker.b().m(this, a2, new PermissionResultCallback() {
                public void a() {
                    PictureSelectorSystemFragment.this.o2();
                }

                public void b() {
                    PictureSelectorSystemFragment.this.Z0(a2);
                }
            });
        }
    }
}
