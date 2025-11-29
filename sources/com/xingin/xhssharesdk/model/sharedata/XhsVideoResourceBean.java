package com.xingin.xhssharesdk.model.sharedata;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;
import org.json.JSONObject;

@Keep
public class XhsVideoResourceBean implements Parcelable {
    public static final Parcelable.Creator<XhsVideoResourceBean> CREATOR = new a();
    private static final String TAG = "XhsShare_XhsVideoResourceBean";
    @Nullable
    private String networkUrl;
    private Uri uri;

    public class a implements Parcelable.Creator<XhsVideoResourceBean> {
        public final Object createFromParcel(Parcel parcel) {
            return new XhsVideoResourceBean(parcel);
        }

        public final Object[] newArray(int i) {
            return new XhsVideoResourceBean[0];
        }
    }

    public XhsVideoResourceBean(Uri uri2) {
        this.uri = uri2;
    }

    public static XhsVideoResourceBean fromUrl(String str) {
        return XhsShareSdkTools.isNetworkUrl(str) ? new XhsVideoResourceBean(str) : new XhsVideoResourceBean(new File(str));
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getNetworkUrl() {
        return this.networkUrl;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean isValid() {
        return this.uri != null || !TextUtils.isEmpty(this.networkUrl);
    }

    public JSONObject toJsonForDeeplink() {
        JSONObject jSONObject = new JSONObject();
        Uri uri2 = this.uri;
        if (uri2 != null) {
            jSONObject.putOpt("uri", uri2.toString());
        }
        if (!TextUtils.isEmpty(this.networkUrl)) {
            jSONObject.putOpt("url", this.networkUrl);
        }
        return jSONObject;
    }

    public String toString() {
        return "XhsVideoResourceBean{uri=" + this.uri + ", networkUrl='" + this.networkUrl + "'}";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.networkUrl);
    }

    public XhsVideoResourceBean(Parcel parcel) {
        try {
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.networkUrl = parcel.readString();
        } catch (Throwable th) {
            XhsShareSdk.c(TAG, "XhsVideoResourceBean from Parcel error!", th);
        }
    }

    public XhsVideoResourceBean(File file) {
        this.uri = Uri.fromFile(file);
    }

    private XhsVideoResourceBean(String str) {
        this.networkUrl = str;
    }
}
