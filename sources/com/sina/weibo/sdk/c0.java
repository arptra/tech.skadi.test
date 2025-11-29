package com.sina.weibo.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class c0 extends AsyncTask<WeiboMultiMessage, Void, b0> {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f9971a;
    public a0 b;

    public c0(Context context, v vVar) {
        this.f9971a = new WeakReference<>(context);
        this.b = vVar;
    }

    public final Object doInBackground(Object[] objArr) {
        WeiboMultiMessage weiboMultiMessage;
        Uri uri;
        WeiboMultiMessage[] weiboMultiMessageArr = (WeiboMultiMessage[]) objArr;
        Context context = this.f9971a.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        a.C0037a a2 = a.a(context);
        String str = a2 != null ? a2.f9968a : "";
        if (TextUtils.isEmpty(str)) {
            str = "com.sina.weibo";
        }
        b0 b0Var = new b0();
        try {
            if (!(weiboMultiMessage.imageObject == null || weiboMultiMessage.multiImageObject == null)) {
                weiboMultiMessage.imageObject = null;
            }
            if (!(weiboMultiMessage.videoSourceObject == null || (weiboMultiMessage.imageObject == null && weiboMultiMessage.multiImageObject == null))) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    Uri next = it.next();
                    if (next != null && l.b(context, next)) {
                        arrayList.add(next);
                        context.grantUriPermission(str, next, 1);
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            ImageObject imageObject = weiboMultiMessage.imageObject;
            if (imageObject != null) {
                if (!imageObject.checkArgs()) {
                    throw new IllegalArgumentException("imageObject is too large(more than 200k), please invoke imageObject.checkArgs before share");
                }
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (!(videoSourceObject == null || (uri = videoSourceObject.videoPath) == null || !l.c(context, uri))) {
                VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                videoSourceObject2.videoPath = uri;
                videoSourceObject2.during = l.a(l.a(context, uri));
                context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
            }
            b0Var.b = weiboMultiMessage;
            b0Var.f9970a = true;
        } catch (Throwable th) {
            b0Var.f9970a = false;
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            b0Var.c = message;
            String str2 = n.b;
            n.a(str2, "prepare resource error is :" + message, th);
        }
        return b0Var;
    }

    public final void onPostExecute(Object obj) {
        b0 b0Var = (b0) obj;
        super.onPostExecute(b0Var);
        a0 a0Var = this.b;
        if (a0Var != null) {
            v vVar = (v) a0Var;
            vVar.f9997a.b.setVisibility(4);
            if (b0Var == null) {
                vVar.f9997a.a("Trans result is null.");
                return;
            }
            if (n.d) {
                String str = n.b;
                n.b(str, "share_msg_transfer: " + b0Var.b);
            }
            if (b0Var.f9970a) {
                vVar.f9997a.a(b0Var.b);
            } else if (TextUtils.isEmpty(b0Var.c)) {
                vVar.f9997a.a("Trans resource fail.");
            } else {
                vVar.f9997a.a(b0Var.c);
            }
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
