package com.xingin.xhssharesdk.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.l.a;
import com.xingin.xhssharesdk.model.sharedata.XhsImageInfo;
import com.xingin.xhssharesdk.model.sharedata.XhsImageResourceBean;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import com.xingin.xhssharesdk.model.sharedata.XhsShareDeeplinkData;
import com.xingin.xhssharesdk.model.sharedata.XhsVideoInfo;
import com.xingin.xhssharesdk.model.sharedata.XhsVideoResourceBean;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public static Uri a(Context context, XhsNote xhsNote, String str, long j) {
        XhsShareDeeplinkData xhsShareDeeplinkData = new XhsShareDeeplinkData();
        xhsShareDeeplinkData.noteInfo = xhsNote;
        xhsShareDeeplinkData.shareType = "note";
        xhsShareDeeplinkData.sdkVersion = XhsShareSdkTools.getSdkVersion();
        xhsShareDeeplinkData.thirdAppPackage = XhsShareSdkTools.getCurrentAppPackageName(context);
        try {
            xhsShareDeeplinkData.thirdAppVersion = XhsShareSdkTools.getCurrentAppVersionName(context);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        xhsShareDeeplinkData.shareSessionId = str;
        xhsShareDeeplinkData.startShareTimestamp = j;
        xhsShareDeeplinkData.did = XhsShareSdkTools.getDid(context);
        return Uri.parse("xhsdiscover://share_sdk").buildUpon().appendQueryParameter("data", Base64.encodeToString(xhsShareDeeplinkData.toJson().toString().getBytes(StandardCharsets.UTF_8), 2)).build();
    }

    public static XhsImageResourceBean b(Context context, String str, XhsImageResourceBean xhsImageResourceBean, String str2) {
        File createTempFile = XhsShareSdkTools.createTempFile(str2);
        if (!TextUtils.isEmpty(xhsImageResourceBean.getNetworkUrl())) {
            return xhsImageResourceBean;
        }
        if (xhsImageResourceBean.getUri() != null) {
            XhsShareSdkTools.copyFile(context, xhsImageResourceBean.getUri(), createTempFile);
            Uri convertAvailableUri = XhsShareSdkTools.convertAvailableUri(context, str, createTempFile);
            if (convertAvailableUri != null) {
                return new XhsImageResourceBean(convertAvailableUri);
            }
            throw new a(5, "[processImageResource] ConvertAvailableUri error. Path is " + createTempFile.getPath());
        }
        throw new a(4, "[processImageResource] The imageResource is invalid!");
    }

    public static XhsNote c(Context context, String str, XhsNote xhsNote, String str2) {
        Uri uri;
        if (xhsNote.getImageInfo() != null && xhsNote.getImageInfo().isValid()) {
            ArrayList arrayList = new ArrayList();
            for (XhsImageResourceBean next : xhsNote.getImageInfo().getImageResourceList()) {
                if (next.isValid()) {
                    arrayList.add(b(context, str, next, str2));
                }
            }
            return new XhsNote().setTitle(xhsNote.getTitle()).setContent(xhsNote.getContent()).setImageInfo(new XhsImageInfo((List<XhsImageResourceBean>) arrayList));
        } else if (xhsNote.getVideoInfo() != null) {
            XhsImageResourceBean cover = xhsNote.getVideoInfo().getCover();
            XhsImageResourceBean b = (cover == null || !cover.isValid()) ? null : b(context, str, cover, str2);
            XhsVideoResourceBean video = xhsNote.getVideoInfo().getVideo();
            if (TextUtils.isEmpty(video.getNetworkUrl())) {
                if (video.getUri() != null) {
                    long fileLength = XhsShareSdkTools.getFileLength(context, video.getUri());
                    XhsShareSdk.b("XhsShare_XhsShareDataProcessor", "The video file length is " + fileLength);
                    if (fileLength < 0 || fileLength >= 5242880) {
                        Uri uri2 = video.getUri();
                        if (TextUtils.equals(uri2.getScheme(), "content")) {
                            XhsShareSdkTools.grantUriPermission(context, uri2);
                            XhsShareSdk.b("XhsShare_XhsShareDataProcessor", "Real uri, it is " + uri2);
                            uri = uri2;
                        } else {
                            uri = XhsShareSdkTools.convertAvailableUri(context, str, new File(uri2.getPath()));
                            XhsShareSdk.b("XhsShare_XhsShareDataProcessor", "Fake uri, it is " + uri2);
                        }
                        if (uri == null) {
                            throw new a(5, "[processVideoResource] ConvertAvailableUri error. (without copy)");
                        }
                    } else {
                        File createTempFile = XhsShareSdkTools.createTempFile(str2);
                        XhsShareSdkTools.copyFile(context, video.getUri(), createTempFile);
                        uri = XhsShareSdkTools.convertAvailableUri(context, str, createTempFile);
                        if (uri == null) {
                            throw new a(5, "[processVideoResource] ConvertAvailableUri error. (with copy)");
                        }
                    }
                    video = new XhsVideoResourceBean(uri);
                } else {
                    throw new a(6, "[processVideoResource] The videoResource is invalid!");
                }
            }
            return new XhsNote().setTitle(xhsNote.getTitle()).setContent(xhsNote.getContent()).setVideoInfo(new XhsVideoInfo(video, b));
        } else {
            throw new a(7, "[process] The note is invalid!");
        }
    }

    public static boolean d(XhsNote xhsNote) {
        boolean z = false;
        if (xhsNote.getImageInfo() != null && xhsNote.getImageInfo().isValid()) {
            for (XhsImageResourceBean isValid : xhsNote.getImageInfo().getImageResourceList()) {
                if (isValid.isValid()) {
                    z = true;
                }
            }
            return z;
        } else if (xhsNote.getVideoInfo() != null) {
            return xhsNote.getVideoInfo().getVideo().isValid();
        } else {
            return false;
        }
    }
}
