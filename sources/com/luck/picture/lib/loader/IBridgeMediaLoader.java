package com.luck.picture.lib.loader;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.meizu.common.datetimepicker.date.MonthView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.LongCompanionObject;

public abstract class IBridgeMediaLoader {
    public static final String c = "IBridgeMediaLoader";
    public static final Uri d = MediaStore.Files.getContentUri("external");
    public static final String[] e = {"_id", "_data", "mime_type", MonthView.VIEW_PARAMS_WIDTH, MonthView.VIEW_PARAMS_HEIGHT, "duration", "_size", "bucket_display_name", "_display_name", "bucket_id", "date_added", "orientation"};
    public static final String[] f = {"_id", "_data", "mime_type", MonthView.VIEW_PARAMS_WIDTH, MonthView.VIEW_PARAMS_HEIGHT, "duration", "_size", "bucket_display_name", "_display_name", "bucket_id", "date_added", "orientation", "COUNT(*) AS count"};

    /* renamed from: a  reason: collision with root package name */
    public final Context f9423a;
    public final SelectorConfig b;

    public IBridgeMediaLoader(Context context, SelectorConfig selectorConfig) {
        this.f9423a = context;
        this.b = selectorConfig;
    }

    public SelectorConfig a() {
        return this.b;
    }

    public Context b() {
        return this.f9423a;
    }

    public String c() {
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", new Object[]{Long.valueOf(Math.max(0, (long) a().r)), "=", Long.valueOf(a().q == 0 ? LongCompanionObject.MAX_VALUE : (long) a().q)});
    }

    public String d() {
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", new Object[]{Long.valueOf(Math.max(0, a().y)), "=", Long.valueOf(a().x == 0 ? LongCompanionObject.MAX_VALUE : a().x)});
    }

    public String e() {
        HashSet hashSet = new HashSet(a().Q);
        Iterator it = hashSet.iterator();
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str) && (a().f9404a != SelectMimeType.d() ? a().f9404a != SelectMimeType.c() ? a().f9404a != SelectMimeType.b() || (!str.startsWith("video") && !str.startsWith("image")) : !str.startsWith("audio") && !str.startsWith("video") : !str.startsWith("image") && !str.startsWith("audio"))) {
                i++;
                sb.append(i == 0 ? " AND " : " OR ");
                sb.append("mime_type");
                sb.append("='");
                sb.append(str);
                sb.append("'");
            }
        }
        if (a().f9404a != SelectMimeType.d() && !a().E && !hashSet.contains(PictureMimeType.q())) {
            sb.append(" AND (mime_type!='image/gif')");
        }
        return sb.toString();
    }

    public abstract void f(OnQueryAllAlbumListener onQueryAllAlbumListener);

    public abstract void g(OnQueryAlbumListener onQueryAlbumListener);

    public abstract void h(long j, int i, int i2, OnQueryDataResultListener onQueryDataResultListener);
}
